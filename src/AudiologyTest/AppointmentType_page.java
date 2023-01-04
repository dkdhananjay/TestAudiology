package AudiologyTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppointmentType_page 
{
@FindBy(xpath="(//div[@class='col-sm-12'])[15]") private WebElement appointment;
	 
	
	public AppointmentType_page(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickAppointments() 
	{
		appointment.click();
	}

}