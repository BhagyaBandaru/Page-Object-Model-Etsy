package com.etsy.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.etsy.utils.TestUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	

		public static WebDriver driver;
		public static Properties prop;
		
		
		
	public TestBase(){ 
		
			
			try {
				prop = new Properties();			 
				FileInputStream file = new FileInputStream((System.getProperty("user.dir") + "\\src\\main\\java\\com\\etsy\\config\\config.properties"));					
				prop.load(file);
							
			} catch (FileNotFoundException e) {		
				e.printStackTrace();
			} catch (IOException e) {			
				e.printStackTrace();
			}	
		
		}

	public static void initialization() 
	{
	// READ THE PROPERTIES FROM CONFIG.PROPERTIES FILE AND INITIALIZE THE BROWSERS, OPEN THE URL, MAXIMIZE THE BROWSER WINDOW AND DELETE COOKIES. 

	String BrowserName = prop.getProperty("browser");

		if(BrowserName.equals("chrome")){
				WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Owner\\java\\PageObjectModel\\Drivers\\chromedriver.exe");			
		//System.setProperty("webdriver.chrome.silentOutput", "true"); // Stops showing starting chrome browser...... in the console
		driver = new ChromeDriver();  																		
		}
		else if(BrowserName.equals("firefox")){
			
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Owner\\java\\PageObjectModel\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(BrowserName.equals("firefox")){
			
			System.setProperty("webdriver.ie.driver", "C:\\\\Users\\\\Owner\\\\java\\\\PageObjectModel\\\\Drivers\\\\geckodriver.exe");
			driver = new InternetExplorerDriver();
		}
													
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtils.page_load_timeout, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtils.implicit_wait, TimeUnit.SECONDS);
			
							
			driver.get(prop.getProperty("url"));			
		}

}
