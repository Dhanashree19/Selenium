package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewTest 
{
private WebDriver driver;
private static int rownum=1;
private static int colnum=2;
  
@Test(dataProvider="logindata",priority=1)
  public void test_me_login(String uname,String pass) throws Exception
  {
	//try {
	//excelUtility.setExcelPath("Sheet1","C:\\Users\\A06438_P5.Training\\Desktop\\Dhanashree\\TestData.xlsx\\");
	
	driver.findElement(By.id("userName")).clear();
	driver.findElement(By.id("userName")).sendKeys("Lalitha");
	
	driver.findElement(By.cssSelector("#password")).clear();
	driver.findElement(By.cssSelector("#password")).sendKeys("Password123");
	driver.findElement(By.cssSelector("input.btn:nth-child(1)")).click();   
	//driver.navigate().back();
	String title=driver.getTitle();
	
	Assert.assertEquals(title,"Home");
	excelUtility.setExcelCell(rownum,colnum,"Pass");	
	
	Thread.sleep(5000);
   }
//	catch(AssertionError e)
//	{
//	excelUtility.setExcelCell(rownum,colnum,"Fail");
//	}
//	finally {
//		rownum++;
//		driver.navigate().to("http://localhost:8083/TestMeApp/login.htm");
//	}
	  
  //}

@Test(priority=2)
public void select_category() throws Exception
{
	WebElement category=driver.findElement(By.xpath("/html/body/header/div[2]/div/div/ul/li[2]/a/span"));
 
	 Actions act = new Actions(driver);
	 act.moveToElement(category).click().build().perform();
	 
	 WebElement headfons = driver.findElement(By.xpath("/html/body/header/div[2]/div/div/ul/li[2]/ul/li[1]/ul/li[1]/a"));
	 
	 act.moveToElement(headfons).click().build().perform();
	 Assert.assertEquals(driver.getTitle(), "Search");
}

@Test(priority=3)
public void select_product()
{
	driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/h4/span")).isDisplayed();
	driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/center/a")).click();
	String CartValue=driver.findElement(By.cssSelector(".shop-menu > a:nth-child(2)")).getText();
	Assert.assertEquals(CartValue,"Cart 1");
}

@DataProvider(name="logindata")
public String[][] login_data() throws Exception
{
	excelUtility.setExcelPath("Sheet1","C:\\Users\\A06438_P5.Training\\Desktop\\Dhanashree\\TestData.xlsx\\");
	String[][] tabledata= excelUtility.getExcelTable();
	return tabledata;
}

@BeforeTest
public void beforeTest() 
{
	  System.setProperty("webdriver.gecko.driver","C:\\Users\\A06438_P5.Training\\Desktop\\Dhanashree\\Drivers\\geckodriver-v0.19.1-win64(1)\\geckodriver.exe");
	  driver=new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("http://localhost:8083/TestMeApp/login.htm");    
}
}
