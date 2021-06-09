package swaglabs.elementspage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import swaglabs.basepage.BasePage;

public class ElementPage extends BasePage {

	public ElementPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "user-name")
	@CacheLookup
	private WebElement userName;

	public WebElement getUserName() {
		return userName;
	}

	@FindBy(id = "password")
	@CacheLookup
	private WebElement pwd;

	public WebElement getPwd(){
		return pwd;
	}

	@FindBy(xpath = "//*[@class='app_logo']")
	@CacheLookup
	private WebElement appLogo;

	public WebElement getAppLogo(){
		return appLogo;
	}
		
	@FindBy(xpath = "//*[contains(text(),'Sorry, this user has been locked out.')]")
	@CacheLookup
	private WebElement errorMessage;

	public WebElement getErrorMessage(){
		return errorMessage;
	}
	
	public String getTitles() {
		  String title = driver.getTitle();
		  return title;
		
	}
	
	
	}

