package org.seleniumAdvanced;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest1 {
  @Test
  public void test2() 
  {
	  try {
		  int a,b=10; 
		  int c=0;
		  a=b/c;
	  }catch(Exception e) {
		  throw e;
	  }
  }
  @BeforeTest
  public void beforeTest() 
  {
	  System.out.println("Before the Test");
  }

  @AfterTest
  public void afterTest() 
  {
	  System.out.println("After the Test");
  }

}
