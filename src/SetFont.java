import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


public class SetFont {

	
	public static void main(String[] args) {
		
		
		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet();
		Row row= sheet.createRow(1);
		
		Font font = wb.createFont();
		font.setFontHeightInPoints((short)24);
		font.setFontName("Courier New");
		font.setItalic(true);
		font.setStrikeout(true);
		
		//字体在样式中载入才能使用，创建一个style来载入
		CellStyle style = wb.createCellStyle();
		style.setFont(font);
		
		Cell cell = row.createCell(1);
		cell.setCellValue("this is a test of fonts");
		cell.setCellStyle(style);
		
		try {
			FileOutputStream fileout = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\123\\setFont.xls");
			wb.write(fileout);
			fileout.close();
			} catch (Exception e) {
		
			e.printStackTrace();
		}
	}

}
