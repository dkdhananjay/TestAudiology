package AudiologyTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

 
public class ControlPanel_MasterPatient extends Base_class
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
	}
	
	@Test 
	public void AlternateNameOfPatientIsDisplayed_onSelectingYes() throws InterruptedException 
	{
		 String text = driver.findElement(By.id("mat-select-value-5")).getText();
		
		 String actText="No";
		 
		 if(text.equals(actText)) 
		 {
			 driver.findElement(By.id("mat-select-value-5")).click();
		     driver.findElement(By.xpath("//span[text()=' Yes']")).click();
		 }
		 ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,3000)");
		 driver.findElement(By.xpath("//button[text()='Update ']")).click();
		 
		 Thread.sleep(1000);
		 
		 driver.findElement(By.xpath("//i[@mattooltip=\"Home Page\"]")).click();
		 
		 driver.findElement(By.xpath("(//div[@class='col-sm-6 pb-2 icon-box'])[12]")).click();
		 ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-1000)");
		 boolean condition = driver.findElement(By.xpath("//input[@formcontrolname=\"alternateName\"]")).isDisplayed();
		 Assert.assertTrue(condition);
		 Thread.sleep(2000);
		 driver.navigate().refresh();
	}
	
	@Test(enabled=false)
	public void Mobile5IsDisplayed_onSelectingYes() throws InterruptedException 
	{
		driver.findElement(By.xpath("(//div[@class=\"p-2 padding\"])[1]")).click();
		set.clickSettings();
		control.clickPanel();
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,500)");
//		 String text = driver.findElement(By.id("mat-select-value-21")).getText();
//		 System.out.println();
		 driver.findElement(By.id("mat-select-value-21")).click();
//		 String actText="No";
//		 
//		 if(text.equals(actText)) 
//		 {
//			 driver.findElement(By.id("mat-select-value-21")).click();
//			 Actions a = new Actions(driver);
//		     driver.findElement(By.id("//span[text()=' Yes']")).click();
//		 }
//		 ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,3000)");
//		 driver.findElement(By.xpath("//button[text()='Update ']")).click();
//		 
//		 Thread.sleep(1000);
//		 
//		 driver.findElement(By.xpath("//i[@mattooltip=\"Home Page\"]")).click();
//		 
//		 driver.findElement(By.xpath("(//div[@class='col-sm-6 pb-2 icon-box'])[12]")).click();
//		 ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-1000)");
//		 boolean condition = driver.findElement(By.xpath("//input[@formcontrolname=\"mobile5\"]")).isDisplayed();
//		 Assert.assertTrue(condition);
	}


	@AfterClass
	public void closeApp()
	{
	//driver.close();
	}
	
	

}
