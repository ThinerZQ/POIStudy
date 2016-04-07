import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


public class TestCreateRowCell {

	public static void main(String[] args) {
	
		Workbook wb = new HSSFWorkbook();
		
		CreationHelper createHelper = wb.getCreationHelper();
		Sheet sheet1 = wb.createSheet("new sheet");
		//创建一行，在其中加入多个单元格索引号从 0开始
		Row row = sheet1.createRow((short)0);
		//创建一个单元格
		Cell cell = row.createCell(0);
		cell.setCellValue(1);
		
		
		row.createCell(1).setCellValue(1.2);
		row.createCell(2).setCellValue(createHelper.createRichTextString("this is a test"));
		row.createCell(3).setCellValue(true);
		
		row.createCell(4).setCellValue(new Date());
		
		//将之后的单元格设置成日期格式（时间和日期）
		CellStyle cellStyle = wb.createCellStyle();
		cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("m/d/yy H:mm"));
		cell= row.createCell(5);
		cell.setCellValue(new Date());
		cell.setCellStyle(cellStyle);
		
		
		cell = row.createCell(6);
		cell.setCellValue(Calendar.getInstance());
		cell.setCellStyle(cellStyle);
		
		
		
		row = sheet1.createRow((short)2);
		row.createCell(0).setCellValue(1.1);
		row.createCell(1).setCellValue(new Date());
		row.createCell(2).setCellValue(Calendar.getInstance());
		row.createCell(3).setCellValue("a string");
		row.createCell(4).setCellValue(true);
		row.createCell(5).setCellType(HSSFCell.CELL_TYPE_ERROR);
		
		
		
		
		
		
		
		
		
		
		
		try {
			FileOutputStream fileout =
	new FileOutputStream("C:\\Users\\Administrator\\Desktop\\123\\workbook1.xls");
			wb.write(fileout);
			fileout.close();
			} catch (Exception e) {
		
			e.printStackTrace();
		}

	}

}
