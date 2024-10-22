package TestRunner;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Magento_API.Locator;
import com.Magento_Base.MagentoBase;

public class TC011 extends MagentoBase {
	
	/**
	 * Steps:-
	 *  1) Click on Delete Account
		2) Enter required fields
		3) Submit 
	 * 
	 * Expected Output:-
	 * 
	 *  A pop - up "Do you really want to delete this account?" 
	 * 
	 * 
	 * @return
	 */
	@Test
	void deleteAccount() {
		//Login As manager
		loginAsManager();
		
		element(Locator.xpath, "//a[normalize-space(text())='Delete Account']").click();
		element(Locator.name, "accountno").sendKeys("139017");
		element(Locator.name, "AccSubmit").click();
		//Trigger Alert
		String alertMsg = handeAlert();
		
		//compare Expected and actual Msg
		try {
			Assert.assertEquals(alertMsg,"Do you really want to delete this account?");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
