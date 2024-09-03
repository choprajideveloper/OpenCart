package pageObjects;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	// BasePage is parent of every object class

	public HomePage(WebDriver driver) {
		super(driver); // we are invoking parent class constructor.
	}

	@FindBy(xpath ="//span[normalize-space()='My Account']")
	WebElement lnkMyaccount;

	@FindBy(xpath ="//a[normalize-space()='Register']")
	WebElement lnkRegister;
	
	
	@FindBy(linkText ="Login")
	WebElement lnkLogin;

	public void clickMyAccount() {
		lnkMyaccount.click();
	}
	
	public void clickRegister()
	{
		lnkRegister.click();
	}
	
	
	public void clickLogin()
	{
		lnkLogin.click();
	}
}
