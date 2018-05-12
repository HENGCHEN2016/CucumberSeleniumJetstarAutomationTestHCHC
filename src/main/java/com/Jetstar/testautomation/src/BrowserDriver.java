package com.Jetstar.testautomation.src;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *@author Hengchen Qiu
 *@since Mar 8,2018
*/

public class BrowserDriver{
	/**
	 *  Static object of Selenium web driver class
	 */
	private static WebDriver mDriver = getCurrentDriver();
	/**
	 * Wait period for Web driver on event
	 * 
	 */
    static WebDriverWait wait;
    
	private synchronized static WebDriver getCurrentDriver() {
		if(mDriver==null) {
			try {
				System.setProperty("webdriver.gecko.driver", "d://selenium//geckodriver.exe");
				mDriver=new FirefoxDriver();
				mDriver.manage().window().maximize();
				wait = new WebDriverWait(mDriver,30);
				FileReaderUtil.readFile();
			}catch(Exception e) {
				System.out.println("Exception in WebDriver::getCurrentDriver:" +e.getStackTrace());
				Assert.fail(e.getMessage());
			}
		}
		
		
		return mDriver;
	}
	/**
	 * Method to close the web driver
	 */
	public static void close() {
		try {
			getCurrentDriver().quit();
			mDriver = null;
		}catch(UnreachableBrowserException e) {
		 System.out.println("cannot close browser:unreachable browser");	
		}
	}
	
	/**
	 *Method to load the given URL in the browser
	 *@param url: url to the page to load 
	 */
	public static void loadPage(String url) {
		System.out.println("Directing brower to:" + url);
		try {
			mDriver.get(url);
			mDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}catch(Exception e) {
			System.out.println("Exception in WebDriver::loadPage:" + e.getMessage());
		}
	}
	
	/**
	 * Method to navigate to 'Login' page/ Link
	 * @param 
	 */
	public static void navigateLoginLink(String section) {
	 System.out.println("Dirceting brower to Login:" + section);
	 try {
		 WebElement inputElement = mDriver.findElement(By.xpath("//div//a[text()='Login']"));
		 ((JavascriptExecutor) mDriver).executeScript("arguments[0].click();",inputElement);
		 Thread.sleep(1000);
	 }catch(Exception e) {
		 System.out.println("Exception in WebDriver::navigateLoginLink: "+ e.getMessage());
	 }
	}
	
	/**
	 * Method to click "to where" button and search the destination "Christchurch"
	 */
	public static void destinationdecision(String location) {
		System.out.println("choose destination:" + location);
		try {
			Thread.sleep(20000);
			WebElement towhere = mDriver.findElement(By.xpath("//button[@data-panel-id='destination-panel01']"));
			towhere.click();
			Thread.sleep(2000);
			WebElement search = mDriver.findElement(By.xpath("//button[contains(.,'Christchurch')]"));
			search.click(); 
//			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println("Exception in  WebDriver::navigateLoginLink: " + e.getMessage());
		}
	}
	/**
	 * This method will choose the one way ticket and choose the date and continue
	 */
public static void datedecision( ) {
		
		System.out.println("choose date:" );
		try {
			Thread.sleep(2000);
			Select selectoneway = new Select(mDriver.findElement(By.xpath("//select[@id='calendar-select-departure']")));
			selectoneway.selectByValue("1");
			Thread.sleep(2000);
			WebElement departuredate = mDriver.findElement(By.xpath("//button[@data-date='20180601']"));
			departuredate.click();
		} catch (Exception e) {
			System.out.println("Exception in  WebDriver::navigateLoginLink: " + e.getMessage());
		}
	}
/**
 * This method will choose the flight time and continue
 */
public static void choosetime(String time) {
	System.out.println("choose time:" + time);
	try {
		Thread.sleep(5000);
		mDriver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();

		Thread.sleep(2000);
		WebElement timedetail = mDriver.findElement(By.xpath("//span[@aria-label='Select 12£º40pm departing flight link']"));
		timedetail.click();
		
		Thread.sleep(2000);
		WebElement confirmtime = mDriver.findElement(By.xpath("//button[@id='price-select__button']"));
		confirmtime.click();
		
	} catch (Exception e) {
		System.out.println("Exception in  WebDriver::navigateLoginLink: " + e.getMessage());
	}
}
/**
 * This method will continue without bundle and baggage
 */
public static void bundlebaggage() {
	System.out.println("choose no bundle and baggage");
	try {
		Thread.sleep(2000);
		mDriver.findElement(By.xpath("//button[contains(@id,'submit_button')]")).click();
		
		Thread.sleep(2000);
		mDriver.findElement(By.xpath("//label[@for='all-pax-baggage__radio--AKL-CHC0']")).click();
		
		Thread.sleep(2000);
		mDriver.findElement(By.xpath("//span[@class='js-continue-btn-edit-text']")).click();
		
		Thread.sleep(2000);
		mDriver.findElement(By.xpath("//a[@class='button-rect-ghost']")).click();
		
	} catch (Exception e) {
		System.out.println("Exception in  WebDriver::navigateLoginLink: " + e.getMessage());
	}
}
/**
 * This method will continue without choosing seat and hotel
 */
public static void continuenoseat() {
	System.out.println("dont mind where i sit");
	try {
//		mDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Thread.sleep(2000);
		mDriver.findElement(By.xpath("//button[@class='seating-option-card__btn seating-option-card__btn--select button-outline']")).click();
		
		Thread.sleep(2000);
		mDriver.findElement(By.xpath("//button[@id='submit_button']")).click();
		
		Thread.sleep(2000);
		mDriver.findElement(By.xpath("//button[@class='button small-expand footer-summary__button  ']")).click();
		
	} catch (Exception e) {
		System.out.println("Exception in  WebDriver::navigateLoginLink: " + e.getMessage());
	}
}
/**
 * This method will click the login button with userid and password
 * The userid and password will be read from the properties file available in "src/main/resources/datafile.properties" file
 */

public static void login() {
	System.out.println("Trying to login");

	try {
		Thread.sleep(2000);
		//click the loging in button
		mDriver.findElement(By.xpath("//button[@class='secondary-button-rect js-login-button expand js-login-button']")).click();
		
		Thread.sleep(2000);
		// Enter the  user name
		getCurrentDriver().findElement(By.xpath("//input[@id='gigya-loginID-67160058132024936']")).sendKeys(FileReaderUtil.getProperty("username"));

		// Enter Password
		getCurrentDriver().findElement(By.xpath("//input[@id='gigya-password-27271530588055816']")).sendKeys(FileReaderUtil.getProperty("password"));

		mDriver.findElement(By.className("gigya-input-submit")).click();
		Thread.sleep(1000);

	} catch (Exception e) {
		System.out.println("Exception in  WebDriver::login: " + e.getMessage());
	}
}
/**
 * This method will get the response after clicking the login button
 * @return
 */
public static String getResponse() {
	System.out.println("Getting Response");
//	String text = selenium.getText("id=xxx"); 
	String expMsg = getCurrentDriver().findElement(By.cssSelector("div.submitError")).getText();
	return expMsg;
}

}
