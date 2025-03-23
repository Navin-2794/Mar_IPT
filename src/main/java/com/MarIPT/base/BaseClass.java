package com.MarIPT.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class BaseClass {
	
	public static WebDriver driver;
	public static File file;
	
	public static void browserLaunch(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions opt = new ChromeOptions();
//			opt.addArguments("incognito");
//			opt.addArguments("headless");
			opt.addArguments("start-maximized");
			driver = new ChromeDriver(opt);
		}else if(browserName.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
		} else if(browserName.equalsIgnoreCase("edge")){
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	public static void launchUrl(String Url) {
		try {
			driver.get(Url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected static void inputValues(WebDriver driver,WebElement Element, String Value ) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(10)) 
			.until(ExpectedConditions.visibilityOf(Element))
			.sendKeys(Value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}




	
	public static void clickElement(WebDriver driver, WebElement element) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(15)) 
			.until(ExpectedConditions.visibilityOf(element))
			.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void screenShot(String ImageName) {
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		File Source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination  = new File(".\\Screenshots\\" + ImageName + "_ "+ timestamp+ ".png");
		try {
			FileHandler.copy(Source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void scrollBy(WebDriver driver, int xaxis, int yaxis) {
		((JavascriptExecutor)driver).executeScript("window.scrollBy("+ xaxis+", "+ yaxis+")");		
	}
	
	public void scrollIntoView(WebDriver driver, WebElement element) {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element);
	}
	
	public static void clickjs(WebDriver driver,WebElement Elements ) {
		try {
			((JavascriptExecutor)driver).executeScript("arguments[0].click();",Elements);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	public static void dropDown(WebElement Elements, String ref, String value) {
		try {
			Select s = new Select(Elements);
			if(ref.equals("text")) {
				s.selectByVisibleText("text");
			}else if(ref.equals("value")) {
				s.selectByValue(value);
			} else if(ref.equals("index")) {
				s.selectByIndex(Integer.parseInt(value));	
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	

	public void takeScreenshot() throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		File scrfile = screenshot.getScreenshotAs(OutputType.FILE);
		File destfile = new File("Screenshort\\.png" + "_" + timeStamp + ".png");
		FileHandler.copy(scrfile, destfile);
	}

	public static void staticWait(int sec) {
		try {
			Thread.sleep(sec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void exitBrowser(WebDriver driver) {
		driver.quit();

	}


}
