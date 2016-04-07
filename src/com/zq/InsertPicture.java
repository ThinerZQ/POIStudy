package com.zq;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class InsertPicture {

	
	public static void main(String[] args) {
		
		Workbook wb = new XSSFWorkbook() ;
		int pictureIdx=0;
		
		try {
			InputStream is = new FileInputStream("C:\\Users\\Administrator\\Desktop\\123\\image.jpg");
			byte[] bytes = IOUtils.toByteArray(is);
			pictureIdx = wb.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		CreationHelper helper = wb.getCreationHelper();
		
		Sheet sheet = wb.createSheet();
		
		//创建顶层的draw对象，他是图像和图像的载体
		
		Drawing drawing = sheet.createDrawingPatriarch();
		//添加一个图片图形
		ClientAnchor anchor = helper.createClientAnchor();
		//设置图像左上角的位置
		//然后调用picture的resize方法，自动关联到uzobiao
		anchor.setCol1(0);
		anchor.setRow1(0);
		
		Picture pict = drawing.createPicture(anchor, pictureIdx);
		
		//自动关联到新坐标
		pict.resize();
		
		//保存到工作薄
		String file = "C:\\Users\\Administrator\\Desktop\\123\\picture.xls";
		if(wb instanceof XSSFWorkbook) file+="x";
		try {
			FileOutputStream fileout = new FileOutputStream(file);
			wb.write(fileout);
			fileout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
