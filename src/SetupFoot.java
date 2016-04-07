import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFFooter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


public class SetupFoot {

	
	public static void main(String[] args) {
		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet();
		HSSFFooter footer = (HSSFFooter) sheet.getFooter();
		
		footer.setRight("page "   +HSSFFooter.page()+" of "+HSSFFooter.numPages());
		
		sheet.createFreezePane(0, 1,0,1);
		sheet.createFreezePane(1, 0,1,0);
		sheet.createFreezePane(2,2);
		sheet.createSplitPane(2000, 2000, 0, 0, Sheet.PANE_LOWER_LEFT);
		
		
		//ппап
		
		
		try {
			FileOutputStream fileout = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\123\\setupFoot.xls");
			wb.write(fileout);
			fileout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
