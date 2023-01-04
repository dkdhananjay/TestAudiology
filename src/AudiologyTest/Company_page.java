package AudiologyTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Company_page 
{
@FindBy(xpath="//h4[text()='Company']") private WebElement company;
	
	public Company_page(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickcompany() 
	{
		company.click();
	}

}
