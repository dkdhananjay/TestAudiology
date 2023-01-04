package AudiologyTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BillingCompanyPage 
{
	@FindBy(xpath="//h4[text()='Billing Company']") private WebElement billing;
	
	public BillingCompanyPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	public void clickbranch() 
	{
		billing.click();
	}

}
