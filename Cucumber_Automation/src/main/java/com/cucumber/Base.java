package com.cucumber;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {


	public static WebDriver driver;
	static Properties prop;
	static String path=System.getProperty("user.dir");
	/**
	 * this method is used to get the properties from config prop file
	 * 
	 * 
	 */
	public Base() {

		prop = new Properties();
		try {

			FileInputStream ip = new FileInputStream(path+"\\src\\main\\java\\com\\config\\Config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	//Initialize Browser

	public static void initializeBrowser() {

		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");

		if (browser.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver",path+"\\driver\\chromedriver.exe");

			// create chrome instance
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.firefox.marionette", path+"\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			System.out.println("please define the proper browser value....");
		}
		// driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.get(url);

	}

	public String getReportConfigPath() {
		String reportConfigPath = prop.getProperty("reportConfigPath");
		if (reportConfigPath != null)
			return reportConfigPath;
		else
			throw new RuntimeException(
					"Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
	}

}