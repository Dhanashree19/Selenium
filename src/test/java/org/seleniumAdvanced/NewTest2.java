package org.seleniumAdvanced;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class NewTest2 
{
	private WebDriver driver;
	
//	@Test
//	public void register() 
//	{
//		driver.findElement(By.linkText("REGISTER")).click();
//		driver.findElement(By.name("firstName")).sendKeys("Dhanashree");
//		driver.findElement(By.name("lastName")).sendKeys("Puranik");
//		driver.findElement(By.id("userName")).sendKeys("kotwal.neha64@gmail.com");
//		driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[7]/td[2]/input"));
//		driver.findElement(By.name("city")).sendKeys("Pune");
//		
//		Select country = new Select(driver.findElement(By.name("country")));
//		country.selectByVisibleText("INDIA");
//		
//		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("neha64");
//		
//	}
	@Test
	public void login()
	{
		LoginPageObjects.uname.sendKeys("selenium");
		LoginPageObjects.pswrd.sendKeys("selenium");
		LoginPageObjects.SignIn.click();
		
	}
  @BeforeTest
  public void beforeTest() 
  {
	  System.setProperty("webdriver.gecko.driver","C:\\Users\\A06438_P5.Training\\Desktop\\Dhanashree\\Drivers\\geckodriver-v0.19.1-win64(1)\\geckodriver.exe");
	  driver=new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("http://newtours.demoaut.com/");
	  
	  PageFactory.initElements(driver,LoginPageObjects.class);
	  
  }
  

}
