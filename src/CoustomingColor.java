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
			//替换保存为默认调色板
			FileOutputStream out = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\123\\default_palette.xls");
			wb.write(out);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		cell.setCellValue("Modified Paletted");
		//为该工作薄创建一个调色板
		HSSFPalette palette = wb.getCustomPalette();

		//替换标准红色freebsd。org上的红色
		palette.setColorAtIndex(HSSFColor.RED.index, (byte)153, (byte)0, (byte)0);
		//替换是灰色为freebsd上的金色
		palette.setColorAtIndex(HSSFColor.LIME.index,(byte)255, (byte)204, (byte)102);
		
		//将其保存为修改过的调色板
		//无论之前在哪里用到过红色，都会奇迹般的出现现在的颜色
		try {
			//替换保存为默认调色板
			FileOutputStream out = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\123\\modified_palette.xls");
			wb.write(out);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
