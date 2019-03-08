package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

	private static volatile WebDriver driver;
	
	private Driver() {
	}

	public static WebDriver getInstance() {

		if (driver == null) {
			synchronized (Driver.class) {
				switch (ConfigurationReader.getProperty("browser")) {
					if (driver == null) {
						case "firefox":
							WebDriverManager.firefoxdriver().setup();
							driver = new FirefoxDriver();
							break;
						case "chrome":
							WebDriverManager.chromedriver().setup();
							driver = new ChromeDriver();
							break;
						case "headless_chrome":
							ChromeOptions options = new ChromeOptions();

							options.addArguments("headless");
							options.addArguments("window-size=1200x600");
							options.addArguments("--disable-infobars");

							WebDriverManager.chromedriver().setup();
							driver = new ChromeDriver(options);
							break;
						case "ie":
							WebDriverManager.iedriver().setup();
							driver = new InternetExplorerDriver();
							break;
						default:
							WebDriverManager.chromedriver().setup();
							driver = new ChromeDriver();
					}
				}
			}
		}
		return driver;
	}

	public static void closeDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}

	}

}
