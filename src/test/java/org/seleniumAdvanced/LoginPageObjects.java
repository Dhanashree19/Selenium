package org.seleniumAdvanced;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPageObjects 
{
@FindBy(how=How.NAME, using="userName")
public static WebElement uname;

@FindBy(how=How.NAME, using="password")
public static WebElement pswrd;

@FindBy(how=How.CSS, using="input[name='login'][value='Login']")
public static WebElement SignIn;


}
