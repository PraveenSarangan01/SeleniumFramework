package com.Magento_API;

import org.openqa.selenium.WebElement;

public interface MagentoAPI {
	/**
	 * This method will lauch the Browser with the giver Url
	 * @author Praveen
	 * @param url
	 */
	
	void setUp(String url);
	/**
	 * This method will launch given Browser with given url
	 * @author Praveen
	 * @param browserName
	 * @param url
	 */
	
	void SetUp(Browser browserName, String url);
	/**
	 * This method is used to close the active Browser
	 * @author Praveen
	 */
	
	void close();
	/**
	 * This method is used to close the browser
	 * @author Praveen
	 */
	void quit();
	/**
	 * This method is used to find the webElement within the pages
	 * @param type Example id,name,xpath
	 * @param value
	 * @return
	 */
	
	WebElement  element(Locator type, String value);
	/**
	 * This method is used to switch to specif tab
	 * @author Praveen
	 * @param i
	 */
	void switchToWindow(int i);
	
	/**
	 * this method is used to select the dropDown with given value
	 * @param ele
	 * @param value
	 */
	void selectValue(WebElement ele, String value);
	/**
	 * This method is used to select the dropDown with given Text
	 * @param ele
	 * @param text
	 */
	void selectText(WebElement ele, String text);
	/**
	 * This method is used to select the dropDown with given Index
	 * @param ele
	 * @param position
	 */
	void selectIndex(WebElement ele,int position);
	
	/**
	 * This method will wait until the element is click able and then click
	 * @param ele
	 */
	void click(WebElement ele);
	/**
	 * This method will wait until the element is ready and clear the existing Value and type
	 * @param ele
	 * @param testData
	 */
	void type(WebElement ele, String testData);
	/**
	 * This method will wait until the element is ready and gets the input
	 * @param ele
	 * @param testData
	 */
	void appendTest(WebElement ele,String testData);
	/**
	 * this method will return the active page Title
	 * @return
	 */
	String getTitle();
	/**
	 * This method will return the active page URL
	 * @return
	 */
	String getUrl();
	/**
	 * This method will return the is displayed or not
	 * @return
	 */
	Boolean isDisplayed(WebElement ele);

}
