package AudiologyTest;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import net.bytebuddy.utility.RandomString;

public class clinic_Master extends Base_class
{
	Login_Page login;
	Settings_page set;                                        
	clinic_page clinic;
	
	@BeforeTest
	public void OpenApp() 
	{
		OpenBrowser();
		login = new Login_Page(driver);
		login.EnterUN();                
		login.EnterPWD();
		login.clickLogin();
		set = new Settings_page(driver);
		set.clickSettings();
		clinic=new clinic_page(driver);
		clinic.clickclinic();
	}
	
	@Test (priority=0)
	public void InvalidTaluka_passingNumbers() throws InterruptedException
	{
		Thread.sleep(1000); 
		driver.findElement(By.xpath("//input[@formcontrolname='taluka']")).clear();
		driver.findElement(By.xpath("//input[@formcontrolname='taluka']")).sendKeys("1234");
		driver.findElement(By.xpath("//input[@formcontrolname='clinicPinCode']")).click();
		String text=driver.findElement(By.xpath("//mat-error[text()=' Please enter valid taluka. ']")).getText();
		String Etext="Please Enter Valid Taluka.";
		Assert.assertEquals(text, Etext);
		driver.navigate().refresh();
    }
	@Test (priority=1)
	public void InvalidTaluka_passingAlphanumericData () throws InterruptedException
	{
		Thread.sleep(1000);  
		driver.findElement(By.xpath("//input[@formcontrolname='taluka']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@formcontrolname='clinicPinCode']")).click();
		driver.findElement(By.xpath("//input[@formcontrolname='taluka']")).sendKeys("Abde1234");
		driver.findElement(By.xpath("//input[@formcontrolname='clinicPinCode']")).click();
		String text=driver.findElement(By.xpath("//mat-error[text()=' Please enter valid taluka. ']")).getText();
		String Etext="Please Enter Valid Taluka.";
		Assert.assertEquals(text, Etext);
		driver.navigate().refresh();
    }
	@Test    (priority=2)
	public void InvalidTaluka_passingSymbols() throws InterruptedException
	{
		Thread.sleep(3000);  
		driver.findElement(By.xpath("//input[@formcontrolname='taluka']")).clear();
		driver.findElement(By.xpath("//input[@formcontrolname='taluka']")).sendKeys("~!@#");
		driver.findElement(By.xpath("//input[@formcontrolname='clinicPinCode']")).click();
		String text=driver.findElement(By.xpath("//mat-error[text()=' Please enter valid taluka. ']")).getText();
		String Etext="Please Enter Valid Taluka.";
		Assert.assertEquals(text, Etext);
		driver.navigate().refresh();
    }
	
    @Test  (priority=6)
	public void InvalidPIN_passingSymbols() throws InterruptedException
	{
		Thread.sleep(2000);  
		WebElement elementPIN = driver.findElement(By.xpath("//input[@formcontrolname='clinicPinCode']"));Thread.sleep(1000);
		elementPIN.clear();
		elementPIN.sendKeys("~!@#");  driver.findElement(By.xpath("//input[@formcontrolname='clinicPhoneNumber']")).click();
		String text=driver.findElement(By.xpath("//mat-error[text()=' Please enter valid PinCode']")).getText();
		String Etext="Please Enter Valid PinCode";
		Assert.assertEquals(text, Etext);
		driver.navigate().refresh();
    }
	@Test  (priority=7)
	public void InvalidPIN_passingAlphabates() throws InterruptedException
	{
		Thread.sleep(2000);  
		WebElement elementPIN = driver.findElement(By.xpath("//input[@formcontrolname='clinicPinCode']")); Thread.sleep(1000);
		elementPIN.clear();
		driver.findElement(By.xpath("//input[@formcontrolname='clinicPinCode']")).sendKeys("abde");
		elementPIN.sendKeys("pin"); driver.findElement(By.xpath("//input[@formcontrolname='clinicPhoneNumber']")).click();
		String text=driver.findElement(By.xpath("//mat-error[text()=' Please enter valid PinCode']")).getText();
		String Etext="Please Enter Valid PinCode";
		Assert.assertEquals(text, Etext);
		driver.navigate().refresh();
		
    }
	@Test  (priority=8)
	public void InvalidPIN_passingAlphanumericData() throws InterruptedException      
	{
		Thread.sleep(2000);  
		driver.findElement(By.xpath("//input[@formcontrolname='clinicPinCode']")).clear();
		driver.findElement(By.xpath("//input[@formcontrolname='clinicPinCode']")).sendKeys("abde1234");
		driver.findElement(By.xpath("//input[@formcontrolname='clinicPhoneNumber']")).click();
		String text=driver.findElement(By.xpath("//mat-error[text()=' Please enter valid PinCode']")).getText();
		String Etext="Please Enter Valid PinCode";
		Assert.assertEquals(text, Etext);
		driver.navigate().refresh();
    }
	@Test  (priority=9)
	public void InvalidMobileNo_passingAlphabates() throws InterruptedException
	{
		Thread.sleep(2000);  
		driver.findElement(By.xpath("//input[@formcontrolname='clinicPhoneNumber']")).clear();
		driver.findElement(By.xpath("//input[@formcontrolname='clinicPhoneNumber']")).sendKeys("abde");
		driver.findElement(By.xpath("//input[@formcontrolname='clinicPinCode']")).click();
		String text=driver.findElement(By.xpath("//mat-error[text()=' Please enter valid Clinic Phone Number']")).getText();
		String Etext="Please Enter Valid Clinic Phone Number";
		Assert.assertEquals(text, Etext);
		driver.navigate().refresh();
    }
	@Test  (priority=10)
	public void InvalidMobileNo_passingAlphanumeric() throws InterruptedException
	{
		Thread.sleep(2000);  
		driver.findElement(By.xpath("//input[@formcontrolname='clinicPhoneNumber']")).clear();
		driver.findElement(By.xpath("//input[@formcontrolname='clinicPhoneNumber']")).sendKeys("abde1234");
		driver.findElement(By.xpath("//input[@formcontrolname='clinicPinCode']")).click();
		String text=driver.findElement(By.xpath("//mat-error[text()=' Please enter valid Clinic Phone Number']")).getText();
		String Etext="Please Enter Valid Clinic Phone Number";
		Assert.assertEquals(text, Etext);
		driver.navigate().refresh();
    }
	@Test  (priority=11)
	public void InvalidMobile_passingSymbols() throws InterruptedException
	{
		Thread.sleep(2000);  
		driver.findElement(By.xpath("//input[@formcontrolname='clinicPhoneNumber']")).clear();
		driver.findElement(By.xpath("//input[@formcontrolname='clinicPhoneNumber']")).sendKeys("~!@#");
		driver.findElement(By.xpath("//input[@formcontrolname='clinicPinCode']")).click();
		String text=driver.findElement(By.xpath("//mat-error[text()=' Please enter valid Clinic Phone Number']")).getText();
		String Etext="Please Enter Valid Clinic Phone Number";
		Assert.assertEquals(text, Etext);
		driver.navigate().refresh();
    }
	@Test (priority=15) //change address and pincode
	public void update() throws InterruptedException 
	{
		 driver.navigate().refresh(); Thread.sleep(3000);
		 WebElement element = driver.findElement(By.xpath("//input[@formcontrolname=\"clinicAddress\"]")); Thread.sleep(3000);
		 element.clear(); 
		 Thread.sleep(3000);  element.sendKeys("hinjawadi phase1 and phase1"); Thread.sleep(1000);
		 String a=RandomStringUtils.randomNumeric(5);
		 WebElement elementPIN = driver.findElement(By.xpath("//input[@formcontrolname='clinicPinCode']"));
		 elementPIN.clear(); elementPIN.sendKeys("4"+a);
		 driver.findElement(By.xpath("//button[text()='Update']")).click();
//		 driver.findElement(By.xpath("(//button[@type=\"button\"])[2]")).click(); Thread.sleep(1000);
//		 driver.findElement(By.xpath("//span[text()=' 9 ']")).click(); Thread.sleep(3000);
//		 driver.findElement(By.xpath("//button[text()='AM']")).click();Thread.sleep(1000);
//		 driver.findElement(By.xpath("//span[text()='Ok']")).click(); 
//		 driver.findElement(By.xpath("(//button[@type='button'])[3]")).click(); Thread.sleep(3000);
//		 driver.findElement(By.xpath("//span[text()=' 6 ']")).click(); Thread.sleep(1000);
//		 driver.findElement(By.xpath("//button[text()='PM']")).click(); Thread.sleep(1000);
//		 driver.findElement(By.xpath("//span[text()='Ok']")).click(); 
		 
	}
	
	@Test(priority=16)
	public void ByDefaultStateMH() 
	{
	String text=driver.findElement(By.xpath("//span[text()='Maharashtra']")).getText();
	String Etext="Maharashtra";
	Assert.assertEquals(text, Etext);
	}
	
	 @Test(priority=18)
	 public void closeApp() 
	 {
		 driver.close();
	 }
	
	


}
