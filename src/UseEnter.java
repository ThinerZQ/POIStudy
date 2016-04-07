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
		
		//Ϊ���ܹ�ʹ�û��У���Ҫ���õ�Ԫ�����ʽ wrap=true
		CellStyle cellstyle = wb.createCellStyle();
		cellstyle.setWrapText(true);
		cell.setCellStyle(cellstyle);
		
		//���ӵ�Ԫ��ĸ߶��ܹ�������������
		row.setHeightInPoints((3*sheet.getDefaultRowHeightInPoints()));
		
		//�����п���ʹ�����ݳ���
		sheet.autoSizeColumn(2);
		
		try {
			//�滻����ΪĬ�ϵ�ɫ��
			FileOutputStream fileout = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\123\\ooxml-newlines.xlsx");
			wb.write(fileout);
			fileout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
