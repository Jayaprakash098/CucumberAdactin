package org.userlab;

import org.userlab.UtilityBaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPojo extends UtilityBaseClass {
	public LoginPojo() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	private WebElement userid;

	public WebElement getUserid() {
		return userid;
	}

	@FindBy(name = "password")
	private WebElement pass;

	public WebElement getPass() {
		return pass;
	}

	@FindBy(id = "login")
	private WebElement login;

	public WebElement getLogin() {
		return login;
	}

	@CacheLookup
	@FindAll({ @FindBy(id = "first_name"), @FindBy(name = "first_name") })
	private WebElement name;

	public WebElement getName() {
		return name;
	}

	@CacheLookup
	@FindAll({ @FindBy(id = "last_name"), @FindBy(name = "last_name") })
	private WebElement lastname;

	public WebElement getLastname() {
		return lastname;
	}

	@CacheLookup
	@FindAll({ @FindBy(id = "cc_num"), @FindBy(name = "cc_num") })
	private WebElement ccnum;

	public WebElement getCcnum() {
		return ccnum;
	}

	@CacheLookup
	@FindAll({ @FindBy(id = "address"), @FindBy(name = "address") })
	private WebElement address;

	public WebElement getAddress() {
		return address;
	}

	@CacheLookup
	@FindAll({ @FindBy(id = "cc_type"), @FindBy(name = "cc_type") })
	private WebElement cctype;

	public WebElement getCctype() {
		return cctype;
	}

	@CacheLookup
	@FindAll({ @FindBy(id = "cc_exp_month"), @FindBy(name = "cc_exp_month") })
	private WebElement ccmonth;

	public WebElement getCcmonth() {
		return ccmonth;
	}

	@CacheLookup
	@FindAll({ @FindBy(id = "cc_exp_year"), @FindBy(name = "cc_exp_year") })
	private WebElement ccyear;

	public WebElement getCcyear() {
		return ccyear;
	}
	
	@CacheLookup
	@FindAll({ @FindBy(id = "cc_cvv"), @FindBy(name = "cc_cvv") })
	private WebElement cccvv;

	public WebElement getCccvv() {
		return cccvv;
	}
	@CacheLookup
	@FindAll({ 
		@FindBy(name="username"),
		@FindBy(xpath="//input[@class='_2hvTZ pexuQ zyHYP']"),
		@FindBy(xpath="//input[@aria-label='Phone number, username or email address']"),
		@FindBy(xpath="//input[@aria-label='Phone number, username, or email']")
		})private WebElement instaUser;

	public WebElement getInstaUser() {
		return instaUser;
	}

	@CacheLookup
	@FindAll({
		@FindBy(xpath="//input[@aria-label='Password']"),
		@FindBy(name="password")
		})private WebElement instapassword;

	public WebElement getInstapassword() {
		return instapassword;
	}
	@CacheLookup
	@FindAll({
		@FindBy(xpath="//button=[text()='Show']"),
		@FindBy(xpath="//button=[@class='sqdOP yWX7d     _8A5w5    ']")
	})private WebElement show;

	public WebElement getShow() {
		return show;
	}
	@FindBy(xpath="(//input[@type='text'])[2]")
	private WebElement flipkartEmail;

	public WebElement getFlipkartEmail() {
		return flipkartEmail;
	}
	@FindBy(xpath="//input[@type='password']")
	private WebElement flipkartPassword;

	public WebElement getFlipkartPassword() {
		return flipkartPassword;
	}
	

}
