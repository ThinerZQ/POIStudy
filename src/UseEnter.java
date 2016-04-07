import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class UseEnter {

	
	public static void main(String[] args) {
		
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet();
		Row row = sheet.createRow(2);
		Cell cell = row.createCell(2);
		cell.setCellValue("Use \n with word wrap on to create a new file");
		
		//为了能够使用换行，需要设置单元格的样式 wrap=true
		CellStyle cellstyle = wb.createCellStyle();
		cellstyle.setWrapText(true);
		cell.setCellStyle(cellstyle);
		
		//增加单元格的高度能够容纳两行文字
		row.setHeightInPoints((3*sheet.getDefaultRowHeightInPoints()));
		
		//调整列宽以使用内容长度
		sheet.autoSizeColumn(2);
		
		try {
			//替换保存为默认调色板
			FileOutputStream fileout = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\123\\ooxml-newlines.xlsx");
			wb.write(fileout);
			fileout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
