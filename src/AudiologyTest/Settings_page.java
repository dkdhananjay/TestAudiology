package AudiologyTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Settings_page 
{
	@FindBy(xpath="//h4[text()='Settings']") private WebElement settings;
	 
	
	public Settings_page(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickSettings() 
	{
		settings.click();
	}

}
