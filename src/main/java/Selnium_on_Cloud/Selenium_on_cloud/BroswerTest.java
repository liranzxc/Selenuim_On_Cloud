package Selnium_on_Cloud.Selenium_on_cloud;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.*;

public class BroswerTest {

	public static final String USERNAME = "liran9";
	public static final String AUTOMATE_KEY = "5xPb6EstKsyzvzd4vfFp";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	public static void main(String[] args) throws Exception {

		ChromeOptions options = new ChromeOptions();

		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("browser", "Chrome");
		caps.setCapability("browser_version", "69.0");
		caps.setCapability("os", "Windows");
		caps.setCapability("os_version", "10");
		caps.setCapability("resolution", "1024x768");
		caps.setCapability("browserstack.debug", "true");
		caps.setCapability(ChromeOptions.CAPABILITY, options);

		options.merge(caps);

		WebDriver driver = new RemoteWebDriver(
				new URL("https://liran9:5xPb6EstKsyzvzd4vfFp@hub-cloud.browserstack.com/wd/hub"), options);

		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));

		element.sendKeys("fxp");
		element.submit();

		System.out.println(driver.getTitle());
		driver.quit();

	}

}
