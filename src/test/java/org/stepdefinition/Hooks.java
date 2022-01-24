package org.stepdefinition;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.userlab.UtilityBaseClass;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends UtilityBaseClass {
	@Before(order = 1)
	public void initiateBrowser() {
		launchBrowser();
	}
	@Before(order = 2)
	public void maximize() {
		browserMaximize();
	}
	@Before(order = 4)
	public void waittime() {   implicitlyWait();  }
	@Before(order = 3)
	public void stTime() {
		System.out.println("start time--");
		dateAndTime();  }
	@After(order=6)
	public void taskEndSnap() throws Exception {
		takeSnap("C:\\CucumberTask\\src\\test\\resources\\Screenshot\\taskend.png");
	}
	@After(order = 4)
	public void screenshot(Scenario s) throws Exception {
		if (s.isFailed()) {
			String name = s.getName();
			String filename = name.replace(' ', '_');
			takeSnap("C:\\CucumberTask\\src\\test\\resources\\Screenshot\\" + filename + ".png");	}
	}
	@After(order = 5)
	public void embedScreenshot(Scenario s) throws Exception {
		if (s.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] screenshotAs = ts.getScreenshotAs(OutputType.BYTES);
			s.embed(screenshotAs, "image/png"); 	}
	}
	@After(order = 1)
	public void endMessage() {
		System.out.println("....Scenario Completed....");
	}
	@After(order = 3)
	public void endTime() {
		System.out.println("End Time--");
		dateAndTime();
	}
	@After(order = 2)
	public void quit() {
		closeBrowser(); }
}
