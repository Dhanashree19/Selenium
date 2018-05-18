package org.seleniumAdvanced;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class dataProviderDemo 
{
  @Test(dataProvider = "logindata")
   public void login(String uname, String pass) 
  {
	 System.out.println(uname+" "+pass); 
  }
  
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.out.println("BeforeMethod");
  }

  @AfterMethod
  public void afterMethod() 
  {
	  System.out.println("AfterMethod");
  }
  
  @DataProvider(name="logindata")
  public String[][] dp() {
    return new String[][] 
    {
      new String[] { "user1", "pass1" },
      new String[] { "user2", "pass2" },
      new String[] { "user3", "pass3" }
    };
  }
  @BeforeTest
  public void beforeTest() 
  {
	  System.out.println("BeforeTest");
  }

  @AfterTest
  public void afterTest() 
  {
	  System.out.println("AfterTest");
  }

}
