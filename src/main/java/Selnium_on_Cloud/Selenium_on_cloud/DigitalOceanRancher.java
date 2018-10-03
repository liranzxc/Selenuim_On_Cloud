package Selnium_on_Cloud.Selenium_on_cloud;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DigitalOceanRancher {

	private static ChromeOptions options ;
	private static WebDriver driver;

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		init();
		GoTo(driver, "https://www.google.com/");
		
		System.out.println(driver.getCurrentUrl());
		
		driver.quit();

	}
	private static void GoTo(WebDriver driver, String url) {
		// TODO Auto-generated method stub
		driver.get(url);

	/*	WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.urlToBe(url));
*/
	}
	
	private static void init() throws MalformedURLException {
		// TODO Auto-generated method stub

		options = new ChromeOptions();

		options.addArguments("test-type");
		options.addArguments("disable-popup-blocking");
		options.addArguments("--disable-notifications");
		// options.addArguments("--headless");
//http://165.227.102.118:4444/grid/console
		// System.setProperty("webdriver.chrome.driver", "C:\\sel\\chromedriver.exe");
		driver = new RemoteWebDriver(new URL("http://165.227.102.118:4444/wd/hub"), options);
		((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
		// driver = new ChromeDriver(options);
		
		System.out.println("done");
	}
}
