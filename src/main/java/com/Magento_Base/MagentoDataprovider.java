package com.Magento_Base;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class MagentoDataprovider {
	@DataProvider(name="login",indices = {0})
	public  String[][] readData() throws IOException
	{
		String[][] data= ReadExcel.readLoginData();
		
	
		//data[0][0]="mngr596160";
		//data[0][1]="syzenUq";
		//data[1][0]="Praveen";
		//data[1][1]="syzenUq";
		
		return data;
	}
}
