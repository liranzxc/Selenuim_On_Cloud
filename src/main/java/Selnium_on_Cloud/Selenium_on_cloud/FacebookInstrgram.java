package Selnium_on_Cloud.Selenium_on_cloud;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.stream.IntStream;
import org.apache.http.annotation.Experimental;
import org.apache.tools.ant.types.Path;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookInstrgram implements Finals {

	private static ChromeOptions options;
	private static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		// TODO Auto-generated method stub

		init();
		System.out.println(Paths.get("/data").toAbsolutePath());

		System.out.println("finish init");
		Actions action = new Actions(driver);
		GoTo(driver, url);
		System.out.println("On facebook site");

		Login(driver, email, password, action);
		System.out.println("On after login facebook");

		OpenGroupPage(driver, GroupName);

		System.out.println("in group page");
		UploadToGroup(driver, action, imagepath, message);

		Thread.sleep(2000);
		driver.quit();

		System.out.println("done");

	}

	private static void UploadToGroup(WebDriver driver, Actions action, String path, String message)
			throws InterruptedException {
		// TODO Auto-generated method stub
		
        JavascriptExecutor js = (JavascriptExecutor)driver;		

		try {

			//js.executeAsyncScript("$x(\"//a[@label='Write Post']\")[0].click();");
			
			driver.findElement(By.xpath("//a[@label='Write Post']")).click();;
			Thread.sleep(1000);
			
			WebElement uploadPhoto = driver.findElement(By.name("composer_photo[]"));

			System.out.println("Found UploadPhoto element");
			File f = new File(path);
			uploadPhoto.sendKeys(f.getAbsolutePath());
			Thread.sleep(15000); // wait for upload

			WebElement span = driver.findElement(By.cssSelector("[data-testid='status-attachment-mentions-input']"));
			span.click();
			span.sendKeys(message);

			ClickTabTime(action, 17); // move to post button

			action.sendKeys(Keys.RETURN).build().perform(); // post

		} catch (Exception ex) {

			// UploadToGroup(driver, action, path, message);
			System.out.println("try again");

			ex.printStackTrace();

			driver.navigate().refresh();
			
			driver.quit();
		}

	}

	private static void OpenGroupPage(final WebDriver driver, String groupname) throws InterruptedException {
		// TODO Auto-generated method stub

		try {
			WebElement Searchtext = driver.findElement(By.name("q"));
			Searchtext.sendKeys(groupname);

		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			WebElement Searchtext = driver.findElement(By.name("q"));
			Searchtext.sendKeys(groupname);

		}

		Thread.sleep(2000);
		WebElement searchbutton = driver.findElement(By.xpath("//button[contains(@aria-label,'Search')]"));
		searchbutton.submit();

		Thread.sleep(2000);

		WebElement grouplink = driver.findElement(By.partialLinkText(groupname));
		grouplink.click();

		Thread.sleep(10000);

	}

	private static void Login(WebDriver driver, String email_text, String password_text, Actions action) {
		// TODO Auto-generated method stub
		WebElement email = driver.findElement(By.id("email"));

		email.sendKeys(email_text);

		action.sendKeys(Keys.TAB).build().perform();

		driver.switchTo().activeElement().sendKeys(password_text);

		action.sendKeys(Keys.TAB).build().perform();

		action.sendKeys(Keys.RETURN).build().perform();

		action.sendKeys(Keys.RETURN).build().perform();
	}

	private static void GoTo(WebDriver driver, String url) {
		// TODO Auto-generated method stub
		driver.get(url);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.urlToBe(url));

	}

	private static void init() throws MalformedURLException {
		// TODO Auto-generated method stub

		options = new ChromeOptions();

		options.addArguments("test-type");
		options.addArguments("disable-popup-blocking");
		options.addArguments("--disable-notifications");
	  //  options.addArguments("--headless");
//http://165.227.102.118:4444/grid/console
	//	 System.setProperty("webdriver.chrome.driver", "C:\\sel\\chromedriver.exe");
	driver = new RemoteWebDriver(new URL("http://165.227.102.118:4444/wd/hub"), options);
		((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
		//driver = new ChromeDriver(options);
		
		System.out.println("done");

	}

	private static void ClickTabTime(Actions action, int i) {
		// TODO Auto-generated method stub

		for (int j = 0; j < i; j++) {
			action.sendKeys(Keys.TAB).build().perform();
		}

	}

}
