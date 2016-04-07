import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class M {

	
	
	public static void main(String[] args) {
		//创建一个excel文件
		Workbook wb = new XSSFWorkbook();
		
		
		Cell cell ;
		Sheet sheet = wb.createSheet();
		//
		Row row = sheet.createRow(4);
		cell = row.createCell(5);
		cell.setCellValue("你是我的情人，像玫瑰花一样的女人");
	
		//sheet.autoSizeColumn(5);
		sheet.setDefaultColumnWidth(2*sheet.getDefaultColumnWidth());
		try {
			FileOutputStream fileout = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\123\\test.xlsx");
			wb.write(fileout);
			fileout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
