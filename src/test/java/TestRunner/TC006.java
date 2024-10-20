package TestRunner;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Magento_API.Browser;
import com.Magento_API.Locator;
import com.Magento_Base.MagentoBase;
import com.Magento_Base.MagentoListeners;
import com.TestNg.Transformer;

@Listeners({ Transformer.class,MagentoListeners.class})

public class TC006 extends MagentoBase {
	/**
	 * Test Steps
	 * 
	 * 	1) Click on Change Password
		2) Enter required fields
		3) Submit

		Expected Result

		1) A pop-up "Old password is incorrect" is shown
		2) User redirected to Change Password
	 * @throws InterruptedException 

	 */
@Test
	void changePasswordAndLogin() throws InterruptedException {
		SetUp(Browser.chrome, readProperty("url"));
		//login steps
		
		element(Locator.xpath, "//input[@name='uid']").sendKeys(readProperty("user"));
		
		element(Locator.xpath, "//input[@name='password']").sendKeys(readProperty("password"));
	
		element(Locator.xpath, "//input[@name='btnLogin']").click();
		
		
		//navigate to manager page
		//element(Locator.xpath, "//a[text()='Manager']").click();
	
		
		//click the change password link
		element(Locator.xpath, "//a[normalize-space(text())='Change Password']").click();
		
		
		//Enter required Fields to change password
		element(Locator.name, "oldpassword").sendKeys(MagentoBase.oldpssword);
		element(Locator.name,"newpassword").sendKeys(MagentoBase.newpassword);
		element(Locator.name, "confirmpassword").sendKeys(MagentoBase.newpassword);
		Thread.sleep(3000);
		element(Locator.name, "sub").click();
		Thread.sleep(3000);
		//after submitting trigger Alert
		
		Alert a = driver.switchTo().alert();
		String alertMsg = a.getText();
		System.out.println(alertMsg);
		a.accept();
		
		//assert Actual and Expected alert
		try {
			Assert.assertEquals(expectedAlert,alertMsg);
		} catch (Exception e) {
			System.out.println("Assertion Failed");
		}
		//located Change password page Heading
		WebElement changepasspage = element(Locator.xpath, "//p[normalize-space(text())='Change Password']");
		
		String actualHeading = changepasspage.getText();
		System.out.println("actualPageHeading  "+actualHeading);
		
		//assert Actual and Expected Change password pageHeading
		try {
			Assert.assertEquals(MagentoBase.pageHeading, actualHeading);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		

	}

}
