import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


public class SetupPrintArea {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet();
		//Ϊ��һ��sheetҲ�趨��ӡ����
		wb.setPrintArea(0, "$A$1:$C$2");
		//����
		//wb.setPrintArea(0, 0, 1, 0, 0);
		
		try {
			FileOutputStream fileout = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\123\\setupPrintArea.xls");
			wb.write(fileout);
			fileout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
