import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


public class FillColor {

	
	public static void main(String[] args) {
		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet();
		Row row= sheet.createRow(1);
		//浅绿色背景色
		CellStyle style= wb.createCellStyle();
		style.setFillBackgroundColor(IndexedColors.AQUA.getIndex());
		style.setFillPattern(CellStyle.BIG_SPOTS);
		Cell cell = row.createCell(1);
		cell.setCellValue("X");
		cell.setCellStyle(style);
		
		//橙色前景色，指的是正在使用的填充颜色，而不是字体颜色
		style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		cell = row.createCell(2);
		cell.setCellValue("X");
		cell.setCellStyle(style);
		
		try {
			FileOutputStream fileout = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\123\\fillColor.xls");
			wb.write(fileout);
			fileout.close();
			} catch (Exception e) {
		
			e.printStackTrace();
		}
		

	}

}
