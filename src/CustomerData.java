import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


public class CustomerData {

	
	public static void main(String[] args) {
		
		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet();
		CellStyle style ;
		DataFormat format = wb.createDataFormat();
		Row row;
		Cell cell;
		short rowNum=0;
		short colNum=0;
		
		row = sheet.createRow(rowNum++);
		cell=row.createCell(colNum);
		style=wb.createCellStyle();
		style.setDataFormat(format.getFormat("0.0"));
		cell.setCellStyle(style);
		
		row = sheet.createRow(rowNum++);
		cell = row.createCell(colNum);
		cell.setCellValue(1111.25);
		
		style = wb.createCellStyle();
		style.setDataFormat(format.getFormat("#,###0.0000"));
		cell.setCellStyle(style);
		
		try {
			FileOutputStream fileout = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\123\\customData.xls");
			wb.write(fileout);
			fileout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
