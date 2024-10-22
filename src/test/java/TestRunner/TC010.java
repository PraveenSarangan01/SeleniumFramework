package TestRunner;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Magento_API.Locator;
import com.Magento_Base.MagentoBase;
import com.Magento_Base.MagentoDataprovider;
import com.Magento_Base.MagentoListeners;


/**
 * Steps:-
 * 1) Click on Add New Account
2) Enter all required fields
3) Submit
 * Expected Result:-
 * Details of account generated must be shown
 * @author user
 *
 */


public class TC010 extends MagentoBase{
	@Test
 void	verifyNewAccountToNewCustomer(){
		loginAsManager();
		element(Locator.xpath, "//a[normalize-space(text())='New Account']").click();
		element(Locator.name, "cusid").sendKeys("80428");
		WebElement select = element(Locator.name, "selaccount");
		
		Select s=new Select(select);
		
		String type="Savings";
		if(type.equalsIgnoreCase("Savings")) {
		s.selectByVisibleText("Savings");
		}
		else if(type.equalsIgnoreCase("Current")){
			s.selectByVisibleText("Current");
			}
		else {
			System.out.println("Account type not Matched");
		}
		
		element(Locator.xpath, "//input[@name='inideposit']").sendKeys("1000");
		element(Locator.xpath, "//input[@type='submit']").click();
		// problem in Application cannot be proceed further
		
		//Get the details of added account details
		WebElement table = element(Locator.id, "account");
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		
		for(WebElement row:rows) {
			System.out.println((row.getText()));
		}
		
	}

}
