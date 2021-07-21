package PracticeDemo;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjectRepository.DashboardPage;
import pageObjectRepository.LoginPage;
import resources.Driver;

public class validateTest extends Driver {

	public static Logger log = LogManager.getLogger(Driver.class.getName());

	@BeforeTest
	public void initalize() throws IOException {
		driver = browserInvoke();
		log.info("Driver is invoked");
		driver.get(prop.getProperty("url"));
		log.info("Hitting required url as mentioned in Requirement");
		

		driver.manage().window().maximize();
		log.info("Maximizing the window for better understanding");
		 log.trace("TRACE");
	        log.debug("DEBUG");
	        log.info("INFO");
	        log.warn("WARN");
	        log.error("ERROR");
	        log.fatal("FATAL");


	}

	@Test()
	public void calling() throws IOException {
		
		DashboardPage dp = new DashboardPage(driver);
		//dp.LoginButton().click();
		System.out.println(driver.getTitle());
		Assert.assertEquals(dp.getCourses().getText(), "Featured Courses12");
		log.info("Matched Featued Courses");

		//LoginPage lp = new LoginPage(driver);
		//lp.email_ID().sendKeys(username);
		//lp.passworD().sendKeys(password);
		//System.out.println(details);
		//lp.submitButton().click();


	}

	@AfterTest
	public void close() {
		driver.close();
	}

}
