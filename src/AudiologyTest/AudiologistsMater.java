package AudiologyTest;

import static org.testng.Assert.assertEquals;

import org.apache.commons.lang3.RandomStringUtils;
import org.asynchttpclient.netty.request.NettyRequestSender;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AudiologistsMater extends Base_class
{
	Login_Page login;
	Settings_page set;                                        
	Branch_page Audio;
	
	@BeforeTest
	public void OpenApp() throws InterruptedException 
	{
		OpenBrowser();
		login = new Login_Page(driver);
		login.EnterUN();                
		login.EnterPWD();
		login.clickLogin();
		set = new Settings_page(driver);
		set.clickSettings();
		Audio =new Branch_page(driver);
		Audio.clickAudiologist();
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-5000)");

	}
	
	@Test(enabled=false)
	public void AddAudiologist_Andsearch() throws InterruptedException
	{	String a=RandomStringUtils.randomNumeric(5);String b =RandomStringUtils.randomAlphabetic(5); String no =RandomStringUtils.randomNumeric(9);
		driver.findElement(By.xpath("//mat-select[@formcontrolname=\"prefix\"]")).click();
		driver.findElement(By.xpath("//span[text()=' Dr ']")).click();
		driver.findElement(By.xpath("//input[@formcontrolname=\"firstName\"]")).sendKeys("rahul");
		driver.findElement(By.xpath("//input[@formcontrolname=\"lastName\"]")).sendKeys("patil");
		driver.findElement(By.xpath("//input[@formcontrolname=\"dob\"]")).sendKeys("11/01/1982");
		driver.findElement(By.xpath("//input[@formcontrolname=\"mobile1\"]")).sendKeys("9"+no);
		driver.findElement(By.xpath("//mat-select[@formcontrolname=\"sex\"]")).click();
		driver.findElement(By.xpath("//span[text()='Male']")).click();
		driver.findElement(By.xpath("//input[@formcontrolname=\"streetAddress\"]")).sendKeys(a+b);
		driver.findElement(By.xpath("//input[@formcontrolname=\"pincode\"]")).sendKeys("4"+a);
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,300)");
		
		driver.findElement(By.xpath("//button[text()='Save ']")).click(); driver.navigate().refresh(); Thread.sleep(1000);
		
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,5000)"); Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@formcontrolname=\"searchDoctor\"]")).sendKeys("patil");
		String text=driver.findElement(By.xpath("(//td[@mattooltip=\"click to view\"])[3]")).getText();
		System.out.println(text);
		String eText="majnoo"; boolean condn =text.equalsIgnoreCase(eText);
		Assert.assertTrue(condn);
		
	}
	
	@Test(priority=1)
	public void Update() throws InterruptedException 		
	{    String a=RandomStringUtils.randomNumeric(5); String b=RandomStringUtils.randomNumeric(9);
		Thread.sleep(1000); ((JavascriptExecutor)driver).executeScript("window.scrollBy(0, 2000)");
		driver.findElement(By.xpath("(//td[@mattooltip=\"click to view\"])[2]")).click();  Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@formcontrolname=\"pincode\"]")).clear();
		driver.findElement(By.xpath("//input[@formcontrolname=\"pincode\"]")).sendKeys("4"+a);
		driver.findElement(By.xpath("//input[@formcontrolname=\"mobile1\"]")).clear();
		driver.findElement(By.xpath("//input[@formcontrolname=\"mobile1\"]")).sendKeys("9"+b);
		driver.findElement(By.xpath("//button[text()='Update ']")).click(); Thread.sleep(5000);
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0, 500)");
		String mob=driver.findElement(By.xpath("(//td[@mattooltip='click to view'])[5]")).getText();
		String eText="9"+b; Assert.assertEquals(mob, eText);
	}
	
	@Test (priority=2)
	public void InvalidFirstName_NumericData() throws InterruptedException
	{	String a=RandomStringUtils.randomNumeric(5);
		driver.findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(a);
		driver.findElement(By.xpath("//input[@formcontrolname='alternateName']")).click();
		String text=driver.findElement(By.xpath("//mat-error[text()=' Please enter valid first name. ']")).getText();
		String Etext="Please Enter Valid First Name.";
		Assert.assertEquals(text, Etext);
		driver.navigate().refresh();
    }
	
	@Test(priority=3)
	public void InvalidFirstName_AlphanumericData() 
	{
		String a=RandomStringUtils.randomAlphanumeric(5); String b=RandomStringUtils.randomNumeric(1);
		driver.findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(a+b);
		driver.findElement(By.xpath("//input[@formcontrolname='alternateName']")).click();
		String text=driver.findElement(By.xpath("//mat-error[text()=' Please enter valid first name. ']")).getText();
		String Etext="Please Enter Valid First Name.";
		Assert.assertEquals(text, Etext);
		driver.navigate().refresh();
	}
	
	@Test (priority=4)
	public void InvalidFirstName_symbols() throws InterruptedException
	{	String a=RandomStringUtils.randomNumeric(5);
		driver.findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys("~!@#");
		driver.findElement(By.xpath("//input[@formcontrolname='alternateName']")).click();
		String text=driver.findElement(By.xpath("//mat-error[text()=' Please enter valid first name. ']")).getText();
		String Etext="Please Enter Valid First Name.";
		Assert.assertEquals(text, Etext);
		driver.navigate().refresh();
    }
	
	
	
	
	@Test (priority=5)
	public void InvalidLastName_Numeric() throws InterruptedException
	{	String a=RandomStringUtils.randomNumeric(5);
		driver.findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys(a);
		driver.findElement(By.xpath("//input[@formcontrolname='alternateName']")).click();
		String text=driver.findElement(By.xpath("//mat-error[text()=' Please enter valid last name. ']")).getText();
		String Etext="Please Enter Valid Last Name.";
		Assert.assertEquals(text, Etext);
		driver.navigate().refresh();
    }
	
	

	@Test (priority=6)
	public void InvalidLastName_AlphanemericData() throws InterruptedException
	{	Thread.sleep(1000); String a=RandomStringUtils.randomAlphanumeric(5); String b=RandomStringUtils.randomNumeric(1);
		driver.findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys(a+b);
		driver.findElement(By.xpath("//input[@formcontrolname='alternateName']")).click();
		String text=driver.findElement(By.xpath("//mat-error[text()=' Please enter valid last name. ']")).getText();
		String Etext="Please Enter Valid Last Name.";
		Assert.assertEquals(text, Etext);
		driver.navigate().refresh();
    }
	
	@Test(priority=7)
	public void InvalidMobile_Alphanumeric() throws InterruptedException
	{	String a=RandomStringUtils.randomAlphabetic(5);
		driver.findElement(By.xpath("//input[@formcontrolname='mobile1']")).sendKeys(a);
		driver.findElement(By.xpath("//input[@formcontrolname='alternateName']")).click();
		String text=driver.findElement(By.xpath("//mat-error[text()=' Enter valid Mobile1 Number. ']")).getText();
		String Etext="Enter Valid Mobile1 Number.";
		Assert.assertEquals(text, Etext);
		driver.navigate().refresh();
    }
	
	
	
}
