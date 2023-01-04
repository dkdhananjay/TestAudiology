package AudiologyTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Role_page 
{
	@FindBy(xpath="(//div[@class='col-sm-12'])[16]") private WebElement role;
	
	public Role_page(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickrole() 
	{
		role.click();
	}

}
