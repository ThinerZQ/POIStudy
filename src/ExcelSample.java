import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class ExcelSample {

	
	public static void main(String[] args) {
				//创建一个excel文件
				HSSFWorkbook wb= new HSSFWorkbook();
				try{
						FileOutputStream fileOut= new FileOutputStream("c:\\workbook.xls");
						// FileOutputStream fileOut= new FileOutputStream("c:/workbook.xls");
						wb.write(fileOut);
						fileOut.close();
				}catch(Exception e){
					e.printStackTrace();
				}


	}

}
