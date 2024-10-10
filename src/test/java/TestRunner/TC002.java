package TestRunner;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebElement;

import com.Magento_API.Browser;
import com.Magento_Base.MagentoBase;
import com.aventstack.extentreports.ExtentTest;

public class TC002 extends MagentoBase {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		MagentoBase base = new MagentoBase();
		base.extentReport();
		ExtentTest test = extent.createTest("VerifyLoginTC002");
		String url = base.readProperty("url");
		base.SetUp(Browser.firefox, url);
		String username = base.readProperty("user");
		String password = base.readProperty("password");

		WebElement userid = driver.findElementByXPath("//input[@name='uid']");
		
		userid.sendKeys(username);
		
		WebElement pass= driver.findElementByXPath("//input[@name='password']");
		
		pass.sendKeys(password);
		
		driver.findElementByXPath("//input[@name='btnLogin']").click();
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
