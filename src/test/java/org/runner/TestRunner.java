package org.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.userlab.JvmReport;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\CucumberTask\\src\\test\\resources\\Features", glue = "org.stepdefinition", 
			dryRun = false, monochrome = false, strict = false, tags = { "@smoke" }, plugin = {
					"html:src\\test\\resources\\Report",
					"json:src\\test\\resources\\Report\\adactin.json",
				"junit:src\\test\\resources\\Report\\adactin.xml", 
				"rerun:src\\test\\resources\\Rerun\\failed.txt" })

public class TestRunner {

	@AfterClass
	public static void jvmReport() {
		JvmReport.generateJvmReport(System.getProperty("user.dir") + "\\src\\test\\resources\\Report\\adactin.json");
	}
}
