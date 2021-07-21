package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;

public class Driver {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver browserInvoke() throws IOException
	{
		 prop= new Properties();
		FileInputStream fis = new FileInputStream("D:\\Selenium\\RealTimeProjects\\E2EProject_Demo\\src\\main\\java\\resources\\browser.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chrome\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("Firefox"))
		{
			//System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chrome\\chromedriver.exe");
			//driver = new GeckoDriver();
		}
		else if(browserName.equals("IE"))
		{
			
		}
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
		
	}
	

	
	

}
