import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Work {
	
	
	public Work(){
		
	}
	public static void main(String[] args) throws IOException {
		XSSFWorkbook wb =null;
		wb = new XSSFWorkbook();
		
		XSSFSheet sheet = wb.createSheet("人事信息");
		
		wb.setSheetName(0, "人事信息");
		Row  row = sheet.createRow((short)0);
		sheet.createFreezePane(0, 2);
		
		sheet.addMergedRegion(new CellRangeAddress(
				0,0,3,17
				));
		createCellHeader(wb,row,(short)3,"10软件工程1班人事信息");
		
		row  = sheet.createRow((short)1);
		createCell(wb, row, (short)3, "员工号");
		createCell(wb, row, (short)4, "别名");
		createCell(wb, row, (short)5, "员工姓名");
		createCell(wb, row, (short)6, "密码");
		createCell(wb, row, (short)7, "邮件");
		createCell(wb, row, (short)8, "年龄");
		createCell(wb, row, (short)9, "性别");
		createCell(wb, row, (short)10, "注册时间");
		createCell(wb, row, (short)11, "部门名称");
		
		String fileString = "E:\\Jackie\\Documents\\WorkSpace\\Eclipse-jee\\POI\\WebContent\\me.jpg";
		createPicture(wb, sheet,fileString,0,15,0,3);
		
		String file = "C:\\Users\\Administrator\\Desktop\\123\\work.xlsx";
		saveWorkbook(wb, file);
		
		
	}
	public void createFixationSheet()throws IOException{
		
	}
	//创建普通cell
	private static void createCell(XSSFWorkbook wb ,Row row,short col,String val){
		Cell cell = row.createCell(col);
		cell.setCellValue(val);
		CellStyle cellstyle = wb.createCellStyle();
		cellstyle.setAlignment(CellStyle.ALIGN_CENTER_SELECTION);
		cell.setCellStyle(cellstyle);
	}
	//创建头部cell
	private static void createCellHeader(XSSFWorkbook wb,Row row,short col,String val){
		Cell cell = row.createCell(col);
		cell.setCellValue(val);
		CellStyle cellstyle = wb.createCellStyle();
		Font font = wb.createFont();
		font.setFontHeightInPoints((short)24);
		font.setFontName("Courier New");
		font.setItalic(true);
		//font.setStrikeout(true);
		cellstyle.setFont(font);
		cellstyle.setAlignment(CellStyle.ALIGN_CENTER_SELECTION);
		cell.setCellStyle(cellstyle);
		
	}
	//创建图片
	private static void createPicture(XSSFWorkbook wb, XSSFSheet sheet,String fileString,int row1,int row2,int col1,int col2){
		int pictureIdx=0;
		
		try {
			InputStream is = new FileInputStream(fileString);
			byte[] bytes = IOUtils.toByteArray(is);
			pictureIdx = wb.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		CreationHelper helper = wb.getCreationHelper();
		
		Drawing drawing = sheet.createDrawingPatriarch();
		//添加一个图片图形
		ClientAnchor anchor = helper.createClientAnchor();
		//设置图像左上角的位置
		//然后调用picture的resize方法，自动关联到uzobiao
		anchor.setCol1(col1);
		anchor.setRow1(row1);
		anchor.setCol2(col2);
		anchor.setRow2(row2);
		Picture pict = drawing.createPicture(anchor, pictureIdx);
		
		//自动关联到新坐标
		//pict.resize();
	}
	//保存到工作薄
	private static void saveWorkbook(XSSFWorkbook wb,String fileString){
		
			try {
				FileOutputStream fileout = new FileOutputStream(fileString);
				wb.write(fileout);
				fileout.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

}
