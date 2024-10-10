package TestRunner;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebElement;

import com.Magento_API.Browser;
import com.Magento_Base.MagentoBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

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

	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
		
		MagentoBase base = new MagentoBase();
		 base.extentReport();
		 ExtentTest test=extent.createTest("TC001Login");
		 
		String url =base.readProperty("url");
		base.SetUp(Browser.chrome, url);
		String userName = base.readProperty("user");
		
		
		WebElement userid = driver.findElementByXPath("//input[@name='uid']");
		
		userid.sendKeys(userName);
		String password = base.readProperty("password");
		WebElement pass= driver.findElementByXPath("//input[@name='password']");
	
		pass.sendKeys(password);
		driver.findElementByXPath("//input[@name='btnLogin']").click();
		base.takescreenShot("LoginTest");
		test.log(Status.PASS, "Login Sucesful");
		extent.flush();
		Thread.sleep(3000);
		driver.close();
		
		
		
		

	}

}
