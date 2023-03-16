package com.POMWithPageFactory.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;
@FindBy(xpath="//input[@name='userName']")
		WebElement user;
@FindBy(xpath="//input[@name='password']")
WebElement pass;
@FindBy(xpath="//input[@name='submit']")
WebElement submit;
public LoginPage(WebDriver driver) {         //constructor created passing parameter driver,calling from LoginTest
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void logindetails() throws Exception {
	user.sendKeys("tutorial");
	Thread.sleep(3000);
	pass.sendKeys("tutorial");
	Thread.sleep(3000);
	submit.click();
}
}
