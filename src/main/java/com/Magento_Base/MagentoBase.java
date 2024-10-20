package com.Magento_Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Magento_API.Browser;
import com.Magento_API.Locator;
import com.Magento_API.MagentoAPI;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class MagentoBase implements MagentoAPI {
	
	public static RemoteWebDriver driver=null;
	long timeOut=10;
	long maxTimeOut=10;
	protected static WebDriverWait wait=null;
	protected static ExtentReports extent;
	
	protected static ExtentTest exten;
	
	public static final String expectedTitle = "Guru99 Bank Manager HomePage";
    public static final String expectedPop = "User or Password is not valid";
    public static final String pattern = ":";
    public static final String firstPattern= "mngr";
    public static final String secondPattern = "[0-9]+";
    public static final String oldpssword="Mngr@0012";
    public static final String newpassword="Mng@r0002";
    public static final String expectedAlert="Old Password is incorrect";//Old Password is incorrect
    public static final String pageHeading="Change Password";


	public void setUp(String url) {
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		wait = new WebDriverWait(driver, maxTimeOut);
		
		
	}

	public void SetUp(Browser browserName, String url) {
		switch(browserName) {
		case edge:
			driver =new EdgeDriver();
			break;
			
		case chrome:
			driver=new ChromeDriver();
			break;
			
		case firefox:
			driver =new FirefoxDriver();
			break;
			
			default:
				System.err.println("Browser is not defined");
				
			
		}
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		wait = new WebDriverWait(driver, maxTimeOut);
		
		
	}

	public void close() {
		driver.close();
		
	}

	public void quit() {
		driver.quit();
	}

	public WebElement element(Locator type, String value) {
		switch(type) {
		case id:
		return driver.findElement(By.id(value));
		case name:
			return driver.findElement(By.name(value));
		case xpath:
			return driver.findElement(By.xpath(value));
		case linktext:
			return driver.findElement(By.xpath(value));
	
		default:
		break;
			
		}
		return null;
	}

	public void switchToWindow(int i) {
		Set<String> windowHandels=driver.getWindowHandles();
		ArrayList<String> list =new ArrayList<String>(windowHandels);
		driver.switchTo().window(list.get(i));
	}

	public void selectValue(WebElement ele, String value) {
		
		WebElement element = 
		wait.withMessage("Element is not visible").until(ExpectedConditions.visibilityOf(ele));
		new Select(element).selectByValue(value);
		
	}

	public void selectText(WebElement ele, String text) {
		WebElement element = wait.withMessage("element is not Visible").until(ExpectedConditions.visibilityOf(ele));
		new Select(element).selectByVisibleText(text);
		
	}

	public void selectIndex(WebElement ele, int position) {
		WebElement element = wait.withMessage("Element is not Visible").until(ExpectedConditions.visibilityOf(ele));
		new Select(element).selectByIndex(position);
	}

	public void click(WebElement ele) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(ele));
		element.click();
		
	}

	public void type(WebElement ele, String testData) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(ele));
		element.clear();
		element.sendKeys(testData);
		
	}

	public void appendTest(WebElement ele, String testData) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(ele));

		element.sendKeys(testData);
		
	}

	public String getTitle() {
		
		return driver.getTitle();
	}

	public String getUrl() {
		// TODO Auto-generated method stub
		return driver.getCurrentUrl();
	}

	public Boolean isDisplayed(WebElement ele) {
		// TODO Auto-generated method stub
		return ele.isDisplayed();
	}
	
	
	
	public String readProperty( String value)  {
		Properties read = new Properties();
		try {
			read.load(new FileInputStream("./config.property"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String property = read.getProperty(value);
		
		return property;
		
		
	}
	
	public void takescreenShot(RemoteWebDriver driver,String path) throws IOException {
		//Date d= new Date();
		//SimpleDateFormat df= new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
		//String timeStamp = df.format(d);
		//String timeStamp = d.toString().replace(':','_').replace(" ", "");
		TakesScreenshot ts = (TakesScreenshot)driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs, new File(path));
	
	}
	
	public ExtentReports extentReport() {
		ExtentSparkReporter report =new ExtentSparkReporter("Report.html");
		
		extent = new ExtentReports() ;
		extent.attachReporter(report);
		
		report.config().setDocumentTitle("Automation Test suite Report");
		report.config().setReportName("Automation Test Report");
		report.config().setTheme(Theme.STANDARD);
		report.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		
		return extent;
		
	}
	public void flushReport() {
		extent.flush();

	}
	
	public void SetBrowserAndUrl() {
		String url;
		url = readProperty("url");
		SetUp(Browser.firefox, url);
		
	}

	
/**
 * To do:-
 * report
 * property
 * screenshot
 * 
 */
	

}
