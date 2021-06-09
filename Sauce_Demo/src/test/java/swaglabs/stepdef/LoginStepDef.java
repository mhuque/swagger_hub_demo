package swaglabs.stepdef;


import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import Utilities.CommonUtility;
import cucumber.api.java.en.*;
import swaglabs.basepage.BasePage;
import swaglabs.elementspage.ElementPage;

public class LoginStepDef extends BasePage {
	ElementPage pf;

	@Given("^I am on the Sauce Demo Login Page$")
	public void i_am_on_the_Sauce_Demo_Login_Page() {
		pf = PageFactory.initElements(driver, ElementPage.class);
		driver.get("https://www.saucedemo.com/");
	}

	@When("^I fill the account information for account Standard User \"([^\"]*)\" into the Username field$")
	public void i_fill_the_account_information_for_account_Standard_User_into_the_Username_field(String userName) {
		logger.info("********** > User able to enter Username  < ***********");
		pf.getUserName().sendKeys(userName);

	}

	@When("^I fill the password \"([^\"]*)\" into the Password field$")
	public void i_fill_the_password_into_the_Password_field(String pwd) {
		logger.info("********** > User able to enter password  < ***********");
		pf.getPwd().sendKeys(pwd);

	}

	@When("^I click the Login Button$")
	public void i_click_the_Login_Button() {
		logger.info("********** > User able to click login  < ***********");
		pf.getPwd().submit();

	}

	@Then("^I am redirected to the Sauce Demo Main Page$")
	public void i_am_redirected_to_the_Sauce_Demo_Main_Page() throws Exception {
		logger.info("********** > User able to take screenshot and verify the home page  < ***********");
		String expected = "Swag Labs";
		Assert.assertEquals(pf.getTitles(), expected);
		System.out.println(expected);
		CommonUtility.takeScreenShot();

	}

	@Then("^I verify the App Logo exists$")
	public void i_verify_the_App_Logo_exists() {
		logger.info("********** > User can verify logo  < ***********");
		boolean logoPresent = pf.getAppLogo().isDisplayed();
		Assert.assertTrue(logoPresent);
	}

	@When("^I fill the account information for account LockedOutUser \"([^\"]*)\" into the Username field$")
	public void i_fill_the_account_information_for_account_LockedOutUser_into_the_Username_field(String userName) {
		logger.info("********** > User can send Locked out username  < ***********");
		pf.getUserName().sendKeys(userName);

	}

	@When("^I fill the password \"([^\"]*)\" the Password field$")
	public void i_fill_the_password_the_Password_field(String pwd) {
		logger.info("********** > User can send Locked out password  < ***********");
		pf.getPwd().sendKeys(pwd);

	}

	@Then("^I verify the Error Message contains the text \"([^\"]*)\"$")
	public void i_verify_the_Error_Message_contains_the_text(String error) throws Exception {
		logger.info("********** > User gets error message and takes screenshot  < ***********");
		Assert.assertEquals(pf.getErrorMessage().getText(), error);
		CommonUtility.takeScreenShot();
	}

}