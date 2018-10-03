package Selnium_on_Cloud.Selenium_on_cloud;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.Image;
import java.io.File;
import java.net.*;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

public class InstragramBroswerStack {

	// TODO Auto-generated method stub

	public static final String USERNAME = "liran9";
	public static final String AUTOMATE_KEY = "5xPb6EstKsyzvzd4vfFp";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	public static void main(String[] args) throws Exception {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browserName", "android");
		caps.setCapability("device", "Samsung Galaxy S8");
		caps.setCapability("realMobile", "true");
		caps.setCapability("os_version", "7.0");
		caps.setCapability("browserstack.debug", "true");
		WebDriver driver = new RemoteWebDriver(new URL(URL), caps);

		driver.get("https://www.instagram.com/accounts/login/");

		try {

			Thread.sleep((int) (1000 * Math.random() * 2));

			driver.findElement(By.name("username")).sendKeys("lirannh");

			// driver.switchTo().activeElement().sendKeys("vivi_an563");
			// driver.switchTo().activeElement().sendKeys("Aakansha_Agarwal7");

			Actions action = new Actions(driver);
			action.sendKeys(Keys.TAB).build().perform();

			Thread.sleep((int) (1000 * Math.random() * 2));

			driver.switchTo().activeElement().sendKeys("liranzxc1234");

			// driver.switchTo().activeElement().sendKeys("ohmygod");

			Thread.sleep((int) (1000 * Math.random() * 2));

			action.sendKeys(Keys.RETURN).build().perform();

			Thread.sleep((int) (1000 * Math.random() * 8));

			action.sendKeys(Keys.TAB).build().perform();
			Thread.sleep((int) (1000 * Math.random() * 2));

			action.sendKeys(Keys.TAB).build().perform();
			Thread.sleep((int) (1000 * Math.random() * 2));

			action.sendKeys(Keys.RETURN).build().perform();
			Thread.sleep((int) (1000 * Math.random() * 2));

			action.sendKeys(Keys.TAB).build().perform();
			Thread.sleep((int) (1000 * Math.random() * 2));

			action.sendKeys(Keys.TAB).build().perform();
			Thread.sleep((int) (1000 * Math.random() * 2));

			action.sendKeys(Keys.RETURN).build().perform();
			Thread.sleep((int) (1000 * Math.random() * 2));

			// driver.navigate().refresh();
			Thread.sleep((int) (1000 * Math.random() * 5));

			URL url = new URL("http://i.imgur.com/yK076N7.jpg");
            File destination = new File("google.jpg");

			FileUtils.copyURLToFile(url, destination);

			driver.findElement(By.xpath("//input[@type='file']")).sendKeys(destination.getAbsolutePath());
			driver.findElement(By.className("mTGkH")).click();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			driver.quit();

		}
	}
	// <button class="oF4XW sqdOP L3NKy " disabled="">Log in</button>

}
