package AudiologyTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import graphql.Assert;

public class Control_PanelMasterCalender extends Base_class
{
	Login_Page login;
	Settings_page set;
	controlPanel_page control;

	@BeforeClass
	public void OpenApp() throws InterruptedException 
	{
		OpenBrowser();
		login = new Login_Page(driver);
		login.EnterUN();                
		login.EnterPWD(); 
		login.clickLogin();
		set = new Settings_page(driver);
		set.clickSettings();
		control= new controlPanel_page(driver);
		control.clickPanel();
	    ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-1000)");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//h3[text()='Calender']")).click();
	}
	
	@Test
	public void tc() 
	{
		driver.findElement(By.id("mat-select-value-45")).click();
		driver.findElement(By.xpath("//span[text()=' Month']")).click();
		driver.findElement(By.xpath("//button[text()='Update ']")).click();
		driver.findElement(By.xpath("(//div[@class=\"p-2 padding\"])[3]")).click();
		boolean	condition=driver.findElement(By.xpath("//button[text()='month']")).isDisplayed();
	    Assert.assertTrue(condition);
	    
	
	}
	
	 
}
