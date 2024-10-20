package TestRunner;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Magento_API.Locator;
import com.Magento_Base.MagentoBase;
import com.Magento_Base.MagentoListeners;
import com.TestNg.Transformer;

/**
 * Test Steps:-
1) Click on Change Password
2) Enter required fields
3) Submit
TestData:-
Old Password - correct Old
Password
New password - 123456
Confirm Password - 123

Expected Result:-
1) A pop-up "Password is changed" is
shown
2) User logged out and redirected to
login page
 * 
 * 
 * 
 * @author user
 *
 */
@Listeners({ Transformer.class,MagentoListeners.class})
public class TC007 extends MagentoBase{
	
	@Test
	void verifyAfterPasswordChange() throws InterruptedException {
		//Login as Manager
		loginAsManager();

		//click On change password
		element(Locator.xpath, "//a[normalize-space(text())='Change Password']").click();

		//Enter required Fields to change password
		element(Locator.name, "oldpassword").sendKeys(MagentoBase.oldpssword);
		element(Locator.name,"newpassword").sendKeys(MagentoBase.newpassword);
		element(Locator.name, "confirmpassword").sendKeys(MagentoBase.newpassword);
		
		System.out.println("Old password:"+oldpssword);
		System.out.println("New Password:"+newpassword);
		//trigger Alert
		element(Locator.name, "sub").click();
		
		
		
		String actualPop = handeAlert();
		//Assert Actual and expected popup
		
		try {
			Assert.assertEquals(actualPop, MagentoBase.tc7expectedPop);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String title = driver.getTitle();
		System.out.println(title);
		
		
	}

}
