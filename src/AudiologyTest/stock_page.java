package AudiologyTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class stock_page 
{
@FindBy(xpath="//h4[text()='Stock']") private WebElement stock;
@FindBy(xpath="//h4[text()='Purchase Invoice']") private WebElement invoice;
@FindBy(xpath="(//div[@class='col p-2 text-center'])[2]") private WebElement transfer;
	
	public stock_page(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickstock() 
	{
		stock.click();
	}
	public void clickinvoice() 
	{
		invoice.click();
	}
	public void clicktranfer() 
	{
		transfer.click();
	}
	
	

}
