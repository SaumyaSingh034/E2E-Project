package pageObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage {
	
	public WebDriver driver;
	
	By login = By.xpath("//a[@class='theme-btn register-btn']");
	By course = By.xpath("//section[@class='courses-section']/div/div/div/h2");
	
	public DashboardPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement LoginButton()
	{
		return driver.findElement(login);
	}
	public WebElement getCourses()
	{
		return driver.findElement(course);
	}
	

}
