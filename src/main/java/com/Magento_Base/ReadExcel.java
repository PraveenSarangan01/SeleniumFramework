package com.Magento_Base;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcel {
	@Test
	public static String[][] readLoginData() throws IOException {
		String filePath="src\\main\\resources\\testData\\TC008data.xlsx";
		XSSFWorkbook book=new XSSFWorkbook(filePath);
		XSSFSheet sheetAt = book.getSheetAt(0);
		int lastRowNum = sheetAt.getLastRowNum();
		short lastCellNum = sheetAt.getRow(0).getLastCellNum();
		String[][]data= new String [lastRowNum][lastCellNum];		
		for(int i=1;i<=lastRowNum;i++) {
			XSSFRow row = sheetAt.getRow(i);
			
			for(int j=0;j<lastCellNum;j++) {
				XSSFCell cell = row.getCell(j);
				
				DataFormatter df =new DataFormatter();
				
				String formatCellValue = df.formatCellValue(cell);
				data[i-1][j]=formatCellValue;
			}
		}
		book.close();
		return data;
		
	}

}
