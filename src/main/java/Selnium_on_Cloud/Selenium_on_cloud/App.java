package Selnium_on_Cloud.Selenium_on_cloud;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.DrbgParameters.Capability;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		System.out.println("Hello World!");

		ChromeOptions options = new ChromeOptions();

		// WebDriver driver = new RemoteWebDriver(new URL("http://172.17.0.3:8888"),
		// options);

		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
		driver.get("https://www.google.com");

	    WebElement element = driver.findElement(By.name("q"));
	    element.sendKeys("Cheese!\n");
	    element.submit();

	   // myDynamicElement = (new WebDriverWait(driver, 10))
	      //        .until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats")));

	    List<WebElement> findElements = driver.findElements(By.xpath("//*[@id='rso']//h3/a"));

	    // this are all the links you like to visit
	    for (WebElement webElement : findElements)
	    {
	        System.out.println(webElement.getAttribute("href"));
	    }
	 
		driver.close();
		driver.quit();

// RemoteWebDriver does not implement the TakesScreenshot class
// if the driver does have the Capabilities to take a screenshot
// then Augmenter will add the TakesScreenshot methods to the instance

		// Query the driver to find out more information
		// And now use it
		// Version 69.0.3497.92 (Official Build) (64-bit)

		// driver.get("https://www.ynet.co.il");

		// .out.println(driver.getTitle());

	}
}
