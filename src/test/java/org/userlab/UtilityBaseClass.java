package org.userlab;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UtilityBaseClass {
	
	public static WebDriver driver;
	static Actions a;

	public static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public static void launchUrl(String url) {
		driver.get(url);
	}

	public static void browserMaximize() {
		driver.manage().window().maximize();
	}

	public static void fillValues(WebElement e, String value) {
		e.sendKeys(value);
	}

	public static void clickBtn(WebElement e) {
		e.click();
	}

	public static void closeBrowser() {
		driver.close();
	}

	public static void select(WebElement e, int index) {
		Select s = new Select(e);
		s.selectByIndex(index);
	}

	public static void robot(int keycode1, int keycode2) throws AWTException {
		Robot r = new Robot();
		r.keyPress(keycode1);
		r.keyRelease(keycode2);
	}

	public static void mouseover(WebElement e) {
		a.moveToElement(e).perform();

	}

	public static void dateAndTime() {
		Date d = new Date();
		System.out.println(d);
	}

	public static void implicitlyWait() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	public static void takeSnap(String path) throws Exception {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(path);
		FileUtils.copyFile(source, dest);
	}

	public static String excelReadBase(String path, String Sheet, int rowNo, int cellNo) throws IOException {

		File f = new File(path);
		FileInputStream fi = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fi);
		Sheet sh = w.getSheet(Sheet);
		Row r = sh.getRow(rowNo);
		Cell c = r.getCell(cellNo);
		int cellType = c.getCellType();

		String value;
		if (cellType == 1) {
			value = c.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(c)) {
			Date dateCellValue = c.getDateCellValue();
			SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
			value = s.format(dateCellValue);

		} else {
			double d = c.getNumericCellValue();
			long l = (long) d;
			value = String.valueOf(l);
		}
		return value;
	}

	public static String excelWrite(String path, String sheet, int rowNum, int cellNum, String cellValue)
			throws IOException {
		File f = new File(path);
		Workbook w = new XSSFWorkbook();
		Sheet sh = w.createSheet(sheet);
		Row r = sh.createRow(rowNum);
		Cell c = r.createCell(cellNum);
		c.setCellValue(cellValue);

		FileOutputStream fo = new FileOutputStream(f);
		w.write(fo);
		return cellValue;

	}

	public static void parallelBrowser(String browser) {

		if (browser.equals("ChromeBrowser")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("IEBrowser")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else if (browser.equals("EdgeBrowser")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

	}
}
