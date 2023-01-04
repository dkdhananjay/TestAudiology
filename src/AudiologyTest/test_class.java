package AudiologyTest;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class test_class 
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		//WebDriver driver;
	System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("http://194.5.152.32:2225/login");
	driver.manage().window().maximize();
	WebElement html = driver.findElement(By.tagName("html"));
	html.sendKeys(Keys.chord(Keys.CONTROL, Keys.ADD));
	//((JavascriptExecutor)driver).executeScript("chrome.settingsPrivate.setDefaultZoom(2.5);");
	//driver.manage().window().maximize();
//	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
	
	
//	driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("oljjze4i");
//	driver.findElement(By.xpath("//button[text()='Login']")).click();
//	FileInputStream file = new FileInputStream("C:\\Users\\hp\\Documents\\selenium excel.xlsx");
//	String data = WorkbookFactory.create(file).getSheet("Selenium").getRow(0).getCell(0).getStringCellValue();
//	driver.findElement(By.xpath("//input[@formcontrolname='emailId']")).sendKeys(data);
	
	
//	WebElement element = driver.findElement(By.xpath("(//div[@class='col-sm-6 pb-2 icon-box'])[11]"));
//	
//	
//	Actions a= new Actions(driver);
//	a.moveToElement(element).doubleClick().perform();
//	WebElement el1 = driver.findElement(By.xpath("//h4[text()='Purchase Invoice']"));
//	a.moveToElement(el1).doubleClick().perform();
//	
	 
 //   driver.findElement(By.xpath("(//div[@class='col-sm-6 pb-2 icon-box'])[11]")).click();
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	driver.findElement(By.xpath("//h4[text()='Settings']")).click();
//	driver.findElement(By.xpath("(//div[@class='col-sm-12'])[15]")).click();
//	((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-1000)");
//	
//	WebElement element = driver.findElement(By.xpath("//input[@formcontrolname=\"color\"]"));
//	String s=element.getCssValue("color");
//	Color.fromString(s).asHex();
//	System.out.println(s);
//	Color s1 = Color.fromString("rgba(40,49,50,5)");	
//	element.click();
//	
	}

	 

}
