package AudiologyTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page 
{
	@FindBy(xpath="//input[@formcontrolname='emailId']") private WebElement un;
	@FindBy(xpath="//input[@formcontrolname='password']") private WebElement pwd;
	@FindBy(xpath="//button[text()='Login']") private WebElement login;
	
	
	 public Login_Page(WebDriver driver) 
	 {
		 PageFactory.initElements(driver, this);
	 }
	
	public void EnterUN() 
	{
		un.sendKeys("superadminQA@audiology.com");
	}
	public void EnterPWD() 
	{
		pwd.sendKeys("oljjze4i");
	}
	public void clickLogin() 
	{
		login.click();
	}
	
	
	
	
}
