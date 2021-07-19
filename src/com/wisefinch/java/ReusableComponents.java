package com.wisefinch.java;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;








public class ReusableComponents extends DriverScript {

	public static void searchByVisibleText(WebElement webby,String identifier,String searchValue) {
		WebElement dropdown_lst = webby.findElement(By.cssSelector(identifier));
		Select objSel =new Select(dropdown_lst);
		objSel.selectByVisibleText(searchValue);			
	}
	
	public static void searchByVisibleText(WebElement webby,By by,String searchValue) {
		WebElement dropdown_lst = webby.findElement(by);
		Select objSel =new Select(dropdown_lst);
		objSel.selectByVisibleText(searchValue);			
	}
	
	public static void searchByVisibleText(WebElement webby,String searchValue) {
		Select objSel =new Select(webby);
		objSel.selectByVisibleText(searchValue);			
	}
	
	public static void searchByValue(WebElement webby,By by,String searchValue) {
		WebElement dropdown_lst = webby.findElement(by);
		Select objSel =new Select(dropdown_lst);
		objSel.selectByValue(searchValue);			
	}
	
	public static void searchByValue(WebElement webby,String searchValue) {
		
		Select objSel =new Select(webby);
		objSel.selectByValue(searchValue);			
	}
	
	public static void searchByIndex(WebElement webby,By by,int searchIndex) {
		WebElement dropdown_lst = webby.findElement(by);
		Select objSel =new Select(dropdown_lst);
		objSel.selectByIndex(searchIndex);			
	}
	
	public static void searchByIndex(WebElement webby,int searchIndex) {
		Select objSel =new Select(webby);
		objSel.selectByIndex(searchIndex);			
	}
	
	public static boolean isElementPresent(WebElement webby) {
		try {	 
			webby.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	public static boolean isElementPresent(List<WebElement> webby) {
		try {	 
			((WebElement) webby).isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	
	public static boolean isElementNotPresent(WebElement webby) {
		try {	 
			webby.isDisplayed();
			return false;
		} catch (NoSuchElementException e) {			
			return true;
		}
	}
	
	public static boolean isElementTextNotPresent(String strwebby) {
		try {	 
			strwebby.isEmpty();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public static boolean isElementTextresent(String strwebby) {
		try {	 
			strwebby.isEmpty();
			return false;
		} catch (NoSuchElementException e) {
			return true;
		}
	}
	
	public static void wait(int waittime) {
		try {	 
			Thread.sleep(waittime);
		} catch (InterruptedException e) {
			System.out.println("wait : Interruption Exception ");
		}
	}
	
	public String getPropValues(String field, String fileName) throws IOException {
		 
	Properties prop = new Properties();
	/*String propFileName = "config.properties";*/
	String propFileName = fileName+".properties";
	 
	InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
	 
	if (inputStream != null) {
	prop.load(inputStream);
	} else {
	throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
	}
	 
	
	String expectedfield = prop.getProperty(field);
	 
	System.out.println("Expected field :" + expectedfield);
	return expectedfield;
	}
	
	public String getPropValues(String field) throws IOException {
		 
		Properties prop = new Properties();
		String propFileName = "config.properties";
		 
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		 
		if (inputStream != null) {
		prop.load(inputStream);
		} else {
		throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
		}
		 		
		String expectedfield = prop.getProperty(field);
		 
		System.out.println("Expected field :" + expectedfield);
		return expectedfield;
		}
	
	
	public void syncWait(int time) {
			 
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			System.out.println("Exception Handling" + e.getStackTrace());
			
		} 
			
		
	}
	
	public Object getObjectPropValues(String field) throws IOException {
		 
		Properties prop = new Properties();
		String propFileName = "config.properties";
		 
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		 
		if (inputStream != null) {
		prop.load(inputStream);
		} else {
		throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
		}
		 		
		Object expectedfield = prop.get(field);
		 
		System.out.println("Expected field :" + expectedfield);
		return expectedfield;
	}
	
		
	
	public static void takeScreenShot(WebDriver browser,String resultPath) {
		 
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        	Date date = new Date();
        	System.out.println(dateFormat.format(date));
        	
			File scrFile = ((TakesScreenshot)browser).getScreenshotAs(OutputType.FILE);
			// Now you can do whatever you need to do with it, for example copy somewhere
			FileUtils.copyFile(scrFile, new File(resultPath+dateFormat.format(date)+".png"));
		} catch (IOException e) {
			System.out.println("Exception Handling" + e.getStackTrace());
			
		} 
			
		
	}
	
	public static String takeScreenShotReturnFilePath(WebDriver browser,String resultPath) {
		
		String filePath = null;
		
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        	Date date = new Date();
        	System.out.println(dateFormat.format(date));
        	
			File scrFile = ((TakesScreenshot)browser).getScreenshotAs(OutputType.FILE);
			// Now you can do whatever you need to do with it, for example copy somewhere
			filePath = resultPath+dateFormat.format(date)+".png";
			FileUtils.copyFile(scrFile, new File(filePath));
					
		} catch (IOException e) {
			System.out.println("Exception Handling" + e.getStackTrace());
			
		} 
		
		return filePath;
		
	}
	
	public String pathBuilder(String path) {
		 
		String scrFolder = path
	            + new SimpleDateFormat("yyyy_MM_dd_HHmmss").format(
	                    Calendar.getInstance().getTime()).toString();
	    new File(scrFolder).mkdir();
		return 	scrFolder;
		
	}
	
	public static boolean actionMouserHover(WebDriver browser,WebElement webby) {
		try {	 
			Actions houseHoverAction = new Actions(browser);
			houseHoverAction.moveToElement(webby).perform();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public static boolean scrollDown(WebDriver browser, int steps) {
		try {	 
			JavascriptExecutor js=(JavascriptExecutor)browser;
			  String strExecution = "window.scrollBy(0,"+steps+")";	
			  /*js.executeScript("window.scrollBy(0,500)","");*/
			  js.executeScript(strExecution,"");
			  ReusableComponents.wait(2000);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public static boolean scrollUp(WebDriver browser, int steps) {
		try {	 
			JavascriptExecutor js=(JavascriptExecutor)browser;
			  String strExecution = "window.scrollBy(0,-"+steps+")";	
			  /*js.executeScript("window.scrollBy(0,500)","");*/
			  js.executeScript(strExecution,"");
			  ReusableComponents.wait(2000);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public static boolean scrollOffsetDown(WebDriver browser,WebElement parentElement, int pixels) {
		try {	 
			  Actions dragger = new Actions(browser);					     
			     
			  dragger.moveToElement(parentElement).clickAndHold().moveByOffset(0,pixels).release().perform();
			     
			  ReusableComponents.wait(2000);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public static boolean scrollRobotPageDown() throws AWTException {
		try {	 
			 Robot robot = new Robot();
			  
			 robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			 robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
			     
			  ReusableComponents.wait(2000);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public static boolean scrollJavaScriptDown(WebDriver browser,WebElement mouseElement) {
		try {	 
			String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
	        ((JavascriptExecutor) browser).executeScript(mouseOverScript,mouseElement);
			     
			  ReusableComponents.wait(2000);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public static boolean actionMouseClick(WebDriver browser,WebElement webby) {
		try {	 
			 Actions builder = new Actions(browser);
		     builder.moveToElement(webby).click(webby);
		     builder.perform();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public static boolean javaScriptClickByID(WebDriver browser,String webby) {
		try {	 
			 JavascriptExecutor js = (JavascriptExecutor) browser;
		     js.executeScript("window.document.getElementById('"+webby+"').click()");
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public static void implicitWait(WebDriver browser, int waittime) {
		browser.manage().timeouts().implicitlyWait(waittime, TimeUnit.SECONDS);
	}
	
	public String folderBuilder(String path) {
		 
		String scrFolder = path;
	           
	    new File(scrFolder).mkdir();
		return 	scrFolder;
		
	}
	
	public static WebElement explicitWait( WebDriver browser, By webby, int waittime) {
		WebDriverWait wait = new WebDriverWait(browser, waittime);
		 
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webby));
		wait(2000);
		return element;
	}
	
	public static WebElement explicitWait( WebDriver browser, WebElement webby, int waittime) {
		WebDriverWait wait = new WebDriverWait(browser, waittime);
		 
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webby));
		wait(2000);
		return element;
	}
	
	public static WebElement fluentExplicitWait( WebDriver browser, WebElement webby, int waittime) {
		WebDriverWait wait = new WebDriverWait(browser, waittime);
		 
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webby));
		wait(2000);
		
		explicitWait(browser, webby, waittime);
		
		return element;
	}
	
	/*** Test case Method Name : reportPass
	 * 	 Functionality         : Reporting Pass using all types 
	 * 	 Created By			   : Subramanya MS
	 *   Parameters            :  
	 * 	 testMethod    - Test case Method
	 *   description   - Description of Step  	
	 *   browser       - Webdriver object
	 *   screenShotPath- Screen Shot Path 
	 *   flag          - true for Screen shot Addition
	 *                 - false for Not adding Screen shot
	***/
	
	public static void reportPass(int threadID , List<String> tempList,String testMethod, String description , WebDriver browser , String screenShotPath , boolean flag) {
		System.out.println(testMethod+" : "+description+" PASS");
		resultList.add(testMethod+" : "+description+" -- PASS");
				
		if(flag == true){
			
			String filePath = ReusableComponents.takeScreenShotReturnFilePath(browser, screenShotPath);
		
			tempList.add(LogStatus.FAIL+"&"+testMethod+"&"+description +"&"+filePath);
		}else{
			
			tempList.add(LogStatus.PASS+"&"+testMethod+"&"+description);
		}
		
		hmap.put(threadID, tempList);
		
		
		
		
	}
	
	/*** Test case Method Name : reportSpecific
	 * 	 Functionality         : Reporting selected information custom 
	 * 	 Created By			   : Subramanya MS
	 *   Parameters            :  
	 * 	 testMethod    - Test case Method
	 *   description   - Description of Step  	
	 *   browser       - Webdriver object
	 *   screenShotPath- Screen Shot Path 
	 *   flag          - true for Screen shot Addition
	 *                 - false for Not adding Screen shot
	***/
	
	public static void reportSpecific(int threadID , List<String> tempList,String testMethod, String description , WebDriver browser , String screenShotPath , boolean flag) {
		System.out.println(testMethod+" : "+description+" check it");
		resultList.add(testMethod+" : "+description+" -- check it");
				
		if(flag == true){
			
			String filePath = ReusableComponents.takeScreenShotReturnFilePath(browser, screenShotPath);
			
			tempList.add(LogStatus.UNKNOWN+"&"+testMethod+"&"+description +"&"+filePath);
		}else{
			
			tempList.add(LogStatus.UNKNOWN+"&"+testMethod+"&"+description);
		}
		
		hmap.put(threadID, tempList);
		
		
		
		
	}


	/*** Test case Method Name : reportFail
	 * 	 Functionality         : Reporting Fail using all types 
	 * 	 Created By			   : Subramanya MS
	 *   Parameters            :  
	 * 	 testMethod    - Test case Method
	 *   description   - Description of Step  	
	 *   browser       - Webdriver object
	 *   screenShotPath- Screen Shot Path 
	 *   flag          - true for Screen shot Addition
	 *                 - false for Not adding Screen shot
	***/
	
	public static void reportFail(int threadID , List<String> tempList,String testMethod, String description , WebDriver browser , String screenShotPath , boolean flag) {
		System.out.println(testMethod+" : "+description+" FAIL");
		resultList.add(testMethod+" : "+description+" -- FAIL");
				
		if(flag == true){
			
			String filePath = ReusableComponents.takeScreenShotReturnFilePath(browser, screenShotPath);	
			tempList.add(LogStatus.FAIL+"&"+testMethod+"&"+description +"&"+filePath);			
			
		}else{
			
			tempList.add(LogStatus.FAIL+"&"+testMethod+"&"+description);
		}
		
		hmap.put(threadID, tempList);
		
		
	}
	
	/*** Test case Method Name : reportInfo
	 * 	 Functionality         : Reporting Done/Info using all types 
	 * 	 Created By			   : Subramanya MS
	 *   Parameters            :  
	 * 	 testMethod    - Test case Method
	 *   description   - Description of Step  	
	 *   browser       - Webdriver object
	 *   screenShotPath- Screen Shot Path 
	 *   flag          - true for Screen shot Addition
	 *                 - false for Not adding Screen shot
	***/
	public static void reportInfo(int threadID , List<String> tempList, String testMethod, String description , WebDriver browser , String screenShotPath , boolean flag) {
		System.out.println(testMethod+" : "+description+" DONE");
		resultList.add(testMethod+" : "+description+" -- DONE");
				
		if(flag == true){
			
			String filePath = ReusableComponents.takeScreenShotReturnFilePath(browser, screenShotPath);
			tempList.add(LogStatus.FAIL+"&"+testMethod+"&"+description +"&"+filePath);
		}else{
			
			tempList.add(LogStatus.INFO+"&"+testMethod+"&"+description);
		}
		
		hmap.put(threadID, tempList);
		
		
	}
	
	
	
 }
