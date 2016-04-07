import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;


public class CoustomingColor {

	
	public static void main(String[] args) {
		
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet();
		HSSFRow row =sheet.createRow((short)0);
		HSSFCell cell = row.createCell((short)0);
		cell.setCellValue("Default pelette");
		
		
		HSSFCellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(HSSFColor.LIME.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		
		
		HSSFFont font = wb.createFont();
		font.setColor(HSSFColor.RED.index);
		style.setFont(font);
		
		cell.setCellStyle(style);
		try {
			//�滻����ΪĬ�ϵ�ɫ��
			FileOutputStream out = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\123\\default_palette.xls");
			wb.write(out);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		cell.setCellValue("Modified Paletted");
		//Ϊ�ù���������һ����ɫ��
		HSSFPalette palette = wb.getCustomPalette();

		//�滻��׼��ɫfreebsd��org�ϵĺ�ɫ
		palette.setColorAtIndex(HSSFColor.RED.index, (byte)153, (byte)0, (byte)0);
		//�滻�ǻ�ɫΪfreebsd�ϵĽ�ɫ
		palette.setColorAtIndex(HSSFColor.LIME.index,(byte)255, (byte)204, (byte)102);
		
		//���䱣��Ϊ�޸Ĺ��ĵ�ɫ��
		//����֮ǰ�������õ�����ɫ�������漣��ĳ������ڵ���ɫ
		try {
			//�滻����ΪĬ�ϵ�ɫ��
			FileOutputStream out = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\123\\modified_palette.xls");
			wb.write(out);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
