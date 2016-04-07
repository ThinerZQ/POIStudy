import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class CellTextAlign {

	
	public static void main(String[] args) {
		
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet();
		Row row =sheet.createRow(2);
		row.setHeightInPoints(30);
		
		
		createCell(wb,row,(short)0,XSSFCellStyle.ALIGN_CENTER,XSSFCellStyle.VERTICAL_BOTTOM);
		createCell(wb,row,(short)1,XSSFCellStyle.ALIGN_FILL,XSSFCellStyle.VERTICAL_CENTER);
		createCell(wb,row,(short)2,XSSFCellStyle.ALIGN_GENERAL,XSSFCellStyle.VERTICAL_CENTER);
		createCell(wb,row,(short)3,XSSFCellStyle.ALIGN_JUSTIFY,XSSFCellStyle.VERTICAL_JUSTIFY);
		createCell(wb,row,(short)4,XSSFCellStyle.ALIGN_LEFT,XSSFCellStyle.VERTICAL_TOP);
		createCell(wb,row,(short)5,XSSFCellStyle.ALIGN_CENTER,XSSFCellStyle.VERTICAL_BOTTOM);
		createCell(wb,row,(short)6,XSSFCellStyle.ALIGN_RIGHT,XSSFCellStyle.VERTICAL_TOP);
	
		try{
			FileOutputStream fileOut= new FileOutputStream("C:\\Users\\Administrator\\Desktop\\123\\workbook2.xlsx");
			// FileOutputStream fileOut= new FileOutputStream("c:/workbook.xls");
			wb.write(fileOut);
			fileOut.close();
			}catch(Exception e){
					e.printStackTrace();
				}
	}
	
	private static void createCell(Workbook wb ,Row row,short colum ,
			short halign,short valign){
		Cell cell = row.createCell(colum);
		cell.setCellValue(new XSSFRichTextString("Align It"));
		CellStyle cellstyle= wb.createCellStyle();
		cellstyle.setAlignment(halign);
		cellstyle.setVerticalAlignment(valign);
		cell.setCellStyle(cellstyle);
	}

}
