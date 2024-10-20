package TestRunner;

import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Magento_API.Browser;
import com.Magento_Base.MagentoBase;
import com.Magento_Base.MagentoDataprovider;

public class TC004 extends MagentoBase {
	@Test(dataProvider = "login",dataProviderClass = MagentoDataprovider.class)
	public void verifyManagerId(String data[]) throws FileNotFoundException, IOException {
		
		
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
			// Get text displayes on login page
			String managerId = driver.findElementByXPath("//tr[@class='heading3']").getText();
			
			//Extract dynamic text on page
			String[] parts = managerId.split(MagentoBase.pattern);
			String dynamicText=parts[1];
			
			// Check that the dynamic text is of pattern mngrXXXX
			// First 4 characters must be "mngr"
			assertTrue(dynamicText.subSequence(1, 5).equals(firstPattern));
			
			// remain stores the "XXXX" in pattern mngrXXXX
			String remain = dynamicText.substring(dynamicText.length()-4);
			assertTrue(remain.matches(secondPattern));
			
			
		}
	
	}
	}


