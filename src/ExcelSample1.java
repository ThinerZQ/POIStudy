import java.io.FileOutputStream;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class ExcelSample1 {

	public static void main(String[] args) {
		HSSFWorkbook wb = new HSSFWorkbook();    //������HSSFWorkbook����
		HSSFSheet sheet = wb.createSheet("new sheet");  //�����µ�sheet����
		HSSFRow row = sheet.createRow((short)0);
		//��sheet�ﴴ��һ�У�����Ϊ�кţ���һ�У��˴�����������飩
		HSSFCell cell = row.createCell((short)0);      
		//��row�ｨ����cell����Ԫ�񣩣�����Ϊ�кţ���һ�У�
		cell.setCellValue(1);                       //����cell���������͵�ֵ
		row.createCell((short)1).setCellValue(1.2);     //����cell�������͵�ֵ
		row.createCell((short)2).setCellValue("test");   //����cell�ַ����͵�ֵ
		row.createCell((short)3).setCellValue(true);    //����cell�������͵�ֵ 
		HSSFCellStyle cellStyle = wb.createCellStyle(); //�����µ�cell��ʽ
		cellStyle.setDataFormat(HSSFDataFormat. getBuiltinFormat("m/d/yy h:mm"));
		//����cell��ʽΪ���Ƶ����ڸ�ʽ
		HSSFCell dCell =row.createCell((short)4);
		dCell.setCellValue(new Date());            //����cellΪ�������͵�ֵ
		dCell.setCellStyle(cellStyle);              //���ø�cell���ڵ���ʾ��ʽ
		HSSFCell csCell =row.createCell((short)5);
		//csCell.setEncoding(HSSFCell.ENCODING_UTF_16);
		//����cell���������ĸ�λ�ֽڽض�
		csCell.setCellValue("���Ĳ���_Chinese Words Test");  //���������Ľ���ַ���
		row.createCell((short)6).setCellType(HSSFCell.CELL_TYPE_ERROR);
		//��������cell
		try{
			FileOutputStream fileOut = new FileOutputStream("c:\\workbook2.xls");
			wb.write(fileOut);
			fileOut.close();
		}catch(Exception e ){
			e.printStackTrace();
		}


	}

}
