package AudiologyTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AudiologistAvialability_page 
{
@FindBy(xpath="(//div[@class='col-sm-12'])[18]") private WebElement avialability;
	
	public AudiologistAvialability_page(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickAvialability() 
	{
		avialability.click();
	}

}
