package AudiologyTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ServiceRate_Master extends Base_class
{
	Login_Page login;
	Settings_page set;                                        
	Branch_page servicerate;
	
	@BeforeTest
	public void OpenApp() 
	{
		OpenBrowser();
		login = new Login_Page(driver);
		login.EnterUN();                
		login.EnterPWD();
		login.clickLogin();
		set = new Settings_page(driver);
		set.clickSettings();
	    servicerate= new Branch_page(driver);
	    servicerate.clickservicerate();
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-500)");
	}
	
	

}
