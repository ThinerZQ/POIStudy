import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


public class TestCreateSheet {

	
	public static void main(String[] args) {
		Workbook wb = new HSSFWorkbook();
		Sheet sheet1 = wb.createSheet("new sheet");
		Sheet sheet2 = wb.createSheet("second sheet");
		
		try {
			FileOutputStream fileout = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\123\\workbook.xls");
			wb.write(fileout);
			fileout.close();
			} catch (Exception e) {
		
			e.printStackTrace();
		}
		
	}

}
