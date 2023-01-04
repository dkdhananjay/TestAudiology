package AudiologyTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AppointmentType_Master extends Base_class
{
	Login_Page login;
	Settings_page set;
	AppointmentType_page appoint;
	@BeforeClass
	public void OpenApp() 
	{
		OpenBrowser();
		login = new Login_Page(driver);
		login.EnterUN();                
		login.EnterPWD();
		login.clickLogin();
		set = new Settings_page(driver);
		set.clickSettings();
		appoint= new AppointmentType_page(driver);
		appoint.clickAppointments();
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-1000)");
		
	}
	
	@Test
	public void Appointment() 
	{
		//driver.findElement(By.xpath("//input[@formcontrolname='appointmentType']")).sendKeys("  ");
	}
	

}
