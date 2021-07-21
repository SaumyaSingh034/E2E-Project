package PracticeDemo;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjectRepository.DashboardPage;
import pageObjectRepository.LoginPage;
import resources.Driver;

public class BasicPageDemo extends Driver  {
	public static Logger log = LogManager.getLogger(Driver.class.getName());
	
	@BeforeTest
	public void initalize() throws IOException
	{
		driver = browserInvoke();
	
	}
	
	@Test(dataProvider = "getData")
	public void calling(String username, String password, String details) throws IOException
	{
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();
		
		DashboardPage dp = new DashboardPage(driver);
		dp.LoginButton().click();
		System.out.println(driver.getTitle());
		//Assert.assertEquals(dp.getCourses().getText(), "Featured Courses123");
		
		LoginPage lp = new LoginPage(driver);
		lp.email_ID().sendKeys(username);
		lp.passworD().sendKeys(password);
		System.out.println(details);
		lp.submitButton().click();
		
		
		//driver.close();
		
	}
	
	@AfterTest
	public void close()
	{
		driver.close();
	}
	
	 @DataProvider
	
	public Object[][] getData()
	{
		Object[][] data = new Object[2][3];
		data[0][0] = "singhsaumyait034@gmail.com";
		data[0][1] = "Saumya299";
		data[0][2] = "Saumya Singh - Programmer Analyst";
		
		data[1][0] = "snehalParkhe@gmail.com";
		data[1][1] = "SnehalParkhe";
		data[1][2] = "Snehal parkhe - Senior Associate";
		
		return data;
}
	 
	 public void getScreenshot(String testcaseName, WebDriver driver) 
	 {
		 TakesScreenshot ss = (TakesScreenshot) driver;
		 File source = ss.getScreenshotAs(OutputType.FILE);
		 String destination = System.getProperty("user.dir")+"\\reports\\"+testcaseName+",png";
		 try {
			FileUtils.copyFile(source, new File(destination));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }

	

}
