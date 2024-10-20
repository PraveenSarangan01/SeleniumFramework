package com.Magento_Base;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readDatafromExcel {
	
	public static String[][] readData() throws IOException {
	String filepath="./logindata.xlsx";
	XSSFWorkbook book = new XSSFWorkbook(filepath);
	XSSFSheet sheet = book.getSheetAt(0);
	 int lastRowNum = sheet.getLastRowNum();
	 short lastCellNum = sheet.getRow(0).getLastCellNum();
	 
	 String data[][]= new String[lastRowNum][lastCellNum];
	 
	 for(int i=1;i<=lastRowNum;i++) {
		XSSFRow row = sheet.getRow(i);
		 
	 
	 for (int j=0;j<=lastCellNum;j++) {
		 XSSFCell cell = row.getCell(j);
		 
		 DataFormatter df= new DataFormatter();
		 String formatCellValue = df.formatCellValue(cell);
		 System.out.println(formatCellValue);
		 data[i-1][j]=formatCellValue;
	 }
	 }
	 book.close();
	 return data;

}}
