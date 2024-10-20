package TestRunner;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Magento_API.Browser;
import com.Magento_Base.MagentoBase;
import com.Magento_Base.MagentoListeners;


@Listeners(MagentoListeners.class)
public class TC001 extends MagentoBase{
	/**
	 * Steps
	 * 1.Goto https://www.demo.guru99.com/V4/
	 * 2.Enter valid User ID
	 * 3.Enter Valid password
	 * 4.click login
	 * Test data : user id,password
	 * Result : Login SucessFull
	 * @param args
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	
	@Test
	public  void login() throws FileNotFoundException, IOException, InterruptedException {
		
		
		
		 
		 
		String url =readProperty("url");
		SetUp(Browser.chrome, url);
		String userName = readProperty("user");
		
		
		WebElement userid = driver.findElementByXPath("//input[@name='uid']");
		
		userid.sendKeys(userName);
		String password = readProperty("password");
		
		WebElement pass= driver.findElementByXPath("//input[@name='password']");
	
		pass.sendKeys(password);
		driver.findElementByXPath("//input[@name='btnLogin']").click();
		
		
		
		Thread.sleep(3000);
	
	}
	
	

}
