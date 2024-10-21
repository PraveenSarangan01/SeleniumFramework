package TestRunner;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Magento_API.Locator;
import com.Magento_Base.MagentoBase;
import com.Magento_Base.MagentoDataprovider;
import com.Magento_Base.MagentoListeners;
@Listeners(MagentoListeners.class)

public class TC009 extends MagentoBase {
	/**
	 * 1)Click on Add NewCustomer
	 * 2) Enter Required fields
       3) Submit
	 * 
	 * Expected Result
	 * 
	 * Details of added Customer must be shown
	 * 
	 * 
	 * 
	 * 
	 */
	@Test(dataProvider = "login",dataProviderClass = MagentoDataprovider.class)
	void verifyAfterAadingNewCustomer(String data[]) {
		loginAsManager();
		
		//Enter Required Fields
		
		element(Locator.xpath, "(//ul[@class='menusubnav']//a)[2]").click();
		element(Locator.xpath, "(//table[@align='center']//input)[1]").sendKeys(data[0]);
		
		//compare gender and select 
		String gender =data[1];
		if(gender.equalsIgnoreCase("male")) {
			element(Locator.xpath, "(//input[@name='rad1'])[1]").click();
		}
		else {
		element(Locator.xpath, "(//input[@name='rad1'])[2]").click();
		}
		
		element(Locator.id, "dob").sendKeys(data[2]);
		element(Locator.name, "addr").sendKeys(data[3]);
		element(Locator.name, "city").sendKeys(data[4]);
		element(Locator.name, "state").sendKeys(data[5]);
		element(Locator.name, "pinno").sendKeys(data[6]);
		element(Locator.name, "telephoneno").sendKeys(data[7]);
		
		WebElement email = element(Locator.name, "emailid");
		email.clear();
		email.sendKeys(data[8]);
		
		WebElement pass = element(Locator.name, "password");
		pass.click();
		pass.sendKeys(data[9]);
		
		//submit
		
		element(Locator.xpath, "//input[@type='submit']").click();
		
		//Assert Expected Condition
		WebElement sucessMsg = element(Locator.xpath, "//p[@class='heading3']");
		String actualMsg = sucessMsg.getText();
		String expectedMsg="Customer Registered Successfully!!!";
		
		try {
			Assert.assertEquals(expectedMsg,actualMsg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
