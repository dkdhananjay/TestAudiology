package AudiologyTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class user_loginPage 
{
	@FindBy(xpath="//input[@formcontrolname='emailId']") private WebElement un;
	@FindBy(xpath="//input[@formcontrolname='password']") private WebElement pwd;
	@FindBy(xpath="//button[text()='Login']") private WebElement login;
	
	
	 public user_loginPage(WebDriver driver) 
	 {
		 PageFactory.initElements(driver, this);
	 }
	
	public void EnterUN() 
	{
		un.sendKeys("dkalase@rediffmail.com");
	}
	public void EnterPWD() 
	{
		pwd.sendKeys("zuqqfyur");
	}
	public void clickLogin() 
	{
		login.click();
	}
}
