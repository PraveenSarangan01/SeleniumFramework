package TestRunner;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebElement;

import com.Magento_API.Browser;
import com.Magento_Base.MagentoBase;

public class TC002 extends MagentoBase {

	public  void loginVerify() throws FileNotFoundException, IOException {
		
		String url = readProperty("url");
		SetUp(Browser.firefox, url);
		String username =readProperty("user");
		String password =readProperty("password");

		WebElement userid = driver.findElementByXPath("//input[@name='uid']");
		type(userid, username);
		
		
		WebElement pass= driver.findElementByXPath("//input[@name='password']");
		
		type(pass, password);
		
		WebElement login = driver.findElementByXPath("//input[@name='btnLogin']");
		click(login);
		
		WebElement title = driver.findElementByXPath("//h2[@class='barone']");
		String text = title.getText();
		String expectedText="Guru99 Bank";
		if(text.equals(expectedText)) {
			System.out.println("Expected and actual title are same");
		}
		else
		{
			System.out.println("Expected and actual title are not same");
		}
		

	}

}
