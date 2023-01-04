package AudiologyTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class controlPanel_page 
{
@FindBy(xpath="(//div[@class='col-sm-12'])[17]") private WebElement panel;
	
	public controlPanel_page(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickPanel() 
	{
		panel.click();
	}
	

}
