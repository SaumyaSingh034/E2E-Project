package pageObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	By email = By.cssSelector("#user_email");
	By password = By.cssSelector("#user_password");
	By submit = By.xpath("//input[@type='submit']");
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	public WebElement email_ID()
	{
		return driver.findElement(email);
	}
	public WebElement passworD()
	{
		return driver.findElement(password);
		}
	public WebElement submitButton()
	{
		return driver.findElement(submit);
	}
	

}
