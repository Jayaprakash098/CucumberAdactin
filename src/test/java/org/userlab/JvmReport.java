package org.userlab;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class JvmReport {
public static void generateJvmReport(String jsonPath) {

	File f=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Report\\JvmReport");
	
	Configuration conf=new Configuration(f, "Adactin Hotel App");
	
	conf.addClassifications("OS", "Windows");
	conf.addClassifications("Version", "Windows 10");
	conf.addClassifications("Browser", "Google Chrome");
	conf.addClassifications("Browser version", "97.0");
	conf.addClassifications("Sprint Level", "2");
	conf.addClassifications("User Story No", "4");
	
	List<String> jsonFile=new ArrayList<String>();
	jsonFile.add(jsonPath);
	
	ReportBuilder r = new ReportBuilder(jsonFile, conf);
	r.generateReports();

}
}
