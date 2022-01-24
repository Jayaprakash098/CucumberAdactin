package org.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.userlab.JvmReport;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "@src\\test\\resources\\Rerun\\failed.txt", glue = "org.stepdefinition", 
		dryRun = false, monochrome = false, 
		plugin = { "html:src\\test\\resources\\Report", 
				"json:src\\test\\resources\\Report\\adactin.json",
				"junit:src\\test\\resources\\Report\\adactin.xml", 
				"rerun:src\\test\\resources\\Rerun\\failed.txt" })


public class TestRerunner {
	
	@AfterClass
	public static void jvmReport() {
		JvmReport.generateJvmReport(System.getProperty("user.dir") + "\\src\\test\\resources\\Report\\adactin.json");
	}

}
