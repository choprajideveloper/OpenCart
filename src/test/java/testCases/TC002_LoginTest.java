package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;


@Test(groups={"Sanity","Master"})
public class TC002_LoginTest extends BaseClass {
	
	public void verify_login()
	{
		logger.info("************starting TC002 LoginTest ");
	
	try {
	HomePage hp = new HomePage(driver);
	hp.clickMyAccount();
	hp.clickLogin();
	
	LoginPage lp = new LoginPage(driver);
	lp.setEmailId(p.getProperty("email"));
	
	logger.info("email entered");
	lp.setPassword(p.getProperty("password"));
	
	logger.info("password entered");
	lp.clickLoginButton();
	
	logger.info("login button clicked");
	
	MyAccountPage macc = new MyAccountPage(driver);
	boolean targetPage = macc.isMyAccountExist();
	Assert.assertEquals(targetPage, true);
	}
	
	catch(Exception e) {
	logger.info("****** Finished TC_002*** LoginTest********");
	Assert.fail();
	}
	}
}
