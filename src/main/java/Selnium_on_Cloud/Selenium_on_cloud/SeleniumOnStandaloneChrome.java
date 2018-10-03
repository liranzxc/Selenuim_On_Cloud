package Selnium_on_Cloud.Selenium_on_cloud;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumOnStandaloneChrome {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub

		// WebDriver driver = new RemoteWebDriver(new URL("http://172.17.0.3:8888"),
		// options);

		try
		{
		FirefoxOptions options = new FirefoxOptions();

		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
		driver.get("https://www.google.com");

		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!\n");
		element.submit();

		Thread.sleep(4000);

		WebElement linksList = driver.findElement(By.xpath(".//a[contains(@href,'wikipedia')]"));

		linksList.click();

		Thread.sleep(2000);

		driver.quit();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

}
