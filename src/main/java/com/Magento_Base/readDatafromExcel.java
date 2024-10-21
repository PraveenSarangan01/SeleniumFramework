package com.Magento_Base;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class readDatafromExcel {
	@Test
	public static void readData() throws IOException {
		
	String filepath="src\\main\\resources\\testData\\TC008data.xlsx";
	XSSFWorkbook book = new XSSFWorkbook(filepath);
	XSSFSheet sheet = book.getSheetAt(0);
	 int lastRowNum = sheet.getLastRowNum();
	 short lastCellNum = sheet.getRow(0).getLastCellNum();
	 
	 
	 for(int i=1;i<=lastRowNum;i++) {
		XSSFRow row = sheet.getRow(i);
		 
	 
	 for (int j=0;j<=lastCellNum;j++) {
		 XSSFCell cell = row.getCell(j);
		 
		 DataFormatter df= new DataFormatter();
		 String formatCellValue = df.formatCellValue(cell);
		 System.out.println(formatCellValue);
		 
	 }
	 }

	

}}
