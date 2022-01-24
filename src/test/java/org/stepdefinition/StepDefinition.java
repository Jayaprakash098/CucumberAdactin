package org.stepdefinition;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.userlab.LoginPojo;
import org.userlab.UtilityBaseClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends UtilityBaseClass {

	LoginPojo l;

	@Given("User must be in adactin hotel booking page")
	public void user_must_be_in_adactin_hotel_booking_page() {
		launchUrl("http://www.adactin.com/HotelApp/");
	}

	@Given("User Login using valid username and password")
	public void user_Login_using_valid_username_and_password() throws IOException {
		l = new LoginPojo();
		String un = excelReadBase("C:\\CucumberTask\\Excel\\Details3.xlsx", "book1", 4, 0);
		String pw = excelReadBase("C:\\CucumberTask\\Excel\\Details3.xlsx", "book1", 4, 1);
		WebElement userid = l.getUserid();
		fillValues(userid, un);
		WebElement password = l.getPass();
		fillValues(password, pw);
		WebElement login = l.getLogin();
		clickBtn(login);
	}

	@When("User enter booking details")
	public void user_enter_booking_details() {
		l = new LoginPojo();
		WebElement location = driver.findElement(By.id("location"));
		select(location, 6);
		WebElement hotels = driver.findElement(By.id("hotels"));
		select(hotels, 1);
		WebElement roomType = driver.findElement(By.id("room_type"));
		select(roomType, 3);
		WebElement roomNos = driver.findElement(By.id("room_nos"));
		select(roomNos, 4);
		WebElement checkIn = driver.findElement(By.id("datepick_in"));
		fillValues(checkIn, "01/01/2022");
		WebElement checkOut = driver.findElement(By.name("datepick_out"));
		fillValues(checkOut, "05/01/2022");
		WebElement adultNos = driver.findElement(By.id("adult_room"));
		select(adultNos, 1);
		WebElement search = driver.findElement(By.id("Submit"));
		clickBtn(search);
	}

	@When("User must click selected hotel")
	public void user_must_click_selected_hotel() {
		l = new LoginPojo();
		WebElement radiobtn = driver.findElement(By.id("radiobutton_0"));
		clickBtn(radiobtn);
		WebElement submit = driver.findElement(By.id("continue"));
		clickBtn(submit);
	}

	@When("User must enter card details for payment")
	public void user_must_enter_card_details_for_payment(io.cucumber.datatable.DataTable d) {
		
		List<Map<String,String>> maps = d.asMaps();
		Map<String, String> v1 = maps.get(0);
		String firstnameValue = v1.get("value");
		Map<String, String> v2 = maps.get(1);
		String lastnameValue = v2.get("value");
		Map<String, String> v3 = maps.get(2);
		String addressValue = v3.get("value");
		Map<String, String> v4 = maps.get(3);
		String cardNo = v4.get("value");
		Map<String, String> v5 = maps.get(4);
		String cvvNo = v5.get("value");
		
		l = new LoginPojo();
		WebElement fn = l.getName();
		fillValues(fn, firstnameValue);
		WebElement ln = l.getLastname();
		fillValues(ln, lastnameValue);
		WebElement address = l.getAddress();
		fillValues(address, addressValue);
		WebElement ccnum = l.getCcnum();
		fillValues(ccnum, cardNo);
		WebElement cctype = l.getCctype();
		select(cctype, 1);
		WebElement ccmonth = l.getCcmonth();
		select(ccmonth, 9);
		WebElement ccyear = l.getCcyear();
		select(ccyear, 11);
		WebElement cccvv = l.getCccvv();
		fillValues(cccvv, cvvNo);
		WebElement booknow = driver.findElement(By.id("book_now"));
		clickBtn(booknow);
	}

	@Then("Check whether the order No is generated")
	public void check_whether_the_order_No_is_generated() {
		implicitlyWait();
		WebElement orderno = driver.findElement(By.id("order_no"));
		String order = orderno.getAttribute("value");
		System.out.println("\nOrder No = " + order + "\n");
	}
	
	@Then("To high light the order No")
	public void to_high_light_the_order_No() {
		WebElement orderno = driver.findElement(By.id("order_no"));
	    JavascriptExecutor js=(JavascriptExecutor) driver;
	    js.executeScript("arguments[0].setAttribute('style','background-color:green')", orderno);
	}
}
