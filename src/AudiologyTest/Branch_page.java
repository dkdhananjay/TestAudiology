package AudiologyTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Branch_page 
{
@FindBy(xpath="//h4[text()='Branch']") private WebElement branch;
@FindBy(xpath="//h4[text()='Expense Vendor']") private WebElement expense;
@FindBy(xpath="//h4[text()='Devices']") private WebElement device;
@FindBy(xpath="//h4[text()='Audiologist']") private WebElement Audio;
@FindBy(xpath="//h4[text()='Clinical Staff']") private WebElement Staff;
@FindBy(xpath="//h4[text()='User']") private WebElement User;
@FindBy(xpath="//h4[text()='Services']") private WebElement Services; 
@FindBy(xpath="//h4[text()='Service Rate']") private WebElement Servicerate; 
@FindBy(xpath="//h4[text()='Billing']") private WebElement billing;
	public Branch_page(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickbranch() 
	{
		branch.click();
	}
	
	public void clickExpenseVendor() 
	{
		expense.click();
	}
	
	public void clickDevice() 
	{
		device.click();
	}
	
	public void clickAudiologist() 
	{
		Audio.click();
	}
	public void clickClinicalStaff() 
	{
		Staff.click();
	}
	
	public void clickUser( ) 
	{
		User.click();
	}
	public void clickservices() 
	{
		Services.click();
	}
	public void clickservicerate() 
	{
		Servicerate.click();
	}
	public void clickbilling() 
	{
		billing.click();
	}
}
