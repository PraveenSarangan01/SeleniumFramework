package TestRunner;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Magento_API.Browser;
import com.Magento_API.Locator;
import com.Magento_Base.MagentoBase;
import com.Magento_Base.MagentoListeners;

@Listeners(MagentoListeners.class)
public class TC008 extends MagentoBase {
	/**
	 * Steps:-
	 * 1) Enter User Id and "new"Password
 		2) Submit
 		
 		Result: User redirected to Manager HomePage
	 */

	@Test
	void loginWithNewPassword(){
		SetUp(Browser.chrome, readProperty("url"));
		//login steps
		
		element(Locator.xpath, "//input[@name='uid']").sendKeys(readProperty("user"));
		//using new password 
		
		element(Locator.xpath, "//input[@name='password']").sendKeys(MagentoBase.newpassword);
	
		element(Locator.xpath, "//input[@name='btnLogin']").click();
		
		WebElement welcomMsg = element(Locator.xpath, "//marquee[@class='heading3']");
		String actualWelcomeMsg = welcomMsg.getText();
		
		try {
			Assert.assertEquals(actualWelcomeMsg,MagentoBase.expectedWelcomeMsg);
			System.out.println("welcome Message"+welcomMsg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
