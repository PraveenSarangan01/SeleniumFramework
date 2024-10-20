package TestRunner;

import java.io.FileNotFoundException;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Magento_API.Browser;
import com.Magento_Base.MagentoBase;
import com.Magento_Base.MagentoDataprovider;


/**
 * SS1: Enter valid userid & password 
 *      Expected: Login successful home page shown 
 * SS2: Enter invalid userid & valid password 
 * SS3: Enter valid userid & invalid password 
 * SS4: Enter invalid userid & invalid password 
 *      Expected: A pop-up “User or Password is not valid” is shown
 * 
 * @throws Exception
 */



public class TC003 extends MagentoBase {
	@Test(dataProvider = "login",dataProviderClass = MagentoDataprovider.class)
	void verifyMultipleLoginScenari(String data[]) throws FileNotFoundException, IOException {
	String url = readProperty("url");
	SetUp(Browser.firefox, url);
	//String username =readProperty("user");
	//String password =readProperty("password");

	WebElement userid = driver.findElementByXPath("//input[@name='uid']");
	type(userid, data[0]);
	
	
	WebElement pass= driver.findElementByXPath("//input[@name='password']");
	
	type(pass, data[1]);
	
	WebElement login = driver.findElementByXPath("//input[@name='btnLogin']");
	click(login);
	
	try {
		Alert a= driver.switchTo().alert();
		String actualPop = a.getText();
		//compare error text with expected text
		if(actualPop.contains(MagentoBase.expectedPop)) {
			System.out.println("Passed:"+actualPop);
		}
		else {
			System.out.println("Failed"+actualPop);
		}
		
	} catch (NoAlertPresentException e) {
		String actualTitle = driver.getTitle();
		
		if(actualTitle.contains(MagentoBase.expectedTitle)) {
			System.out.println("passed: Title Verified"+actualTitle);
		}
		else {
			System.out.println("failed : Title Not Verified"+actualTitle);
		}
	}
	driver.quit();
}
	
}
