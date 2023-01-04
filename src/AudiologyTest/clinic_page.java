package AudiologyTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class clinic_page 
{
@FindBy(xpath="//h4[text()='Clinic']") private WebElement clinic;
	 
	
	public clinic_page(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickclinic() 
	{
		clinic.click();
	}

}
