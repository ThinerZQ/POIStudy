import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


public class AutoSheet {

	
	public static void main(String[] args) {
	
		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet();
		PrintSetup ps = sheet.getPrintSetup();
		sheet.setAutobreaks(true);
		
		ps.setFitHeight((short) 1);
		ps.setFitWidth((short) 1);
		
		//为表格奖励多行多列
		
		try {
			FileOutputStream fileout = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\123\\auoSheet.xls");
			wb.write(fileout);
			fileout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
