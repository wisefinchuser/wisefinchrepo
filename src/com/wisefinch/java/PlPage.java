package com.wisefinch.java;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.time.format.*;
import java.time.LocalDateTime;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.*;





/**
 * Base class for all the pages.
 *
 */
public class PlPage extends DriverScript{
	protected WebDriver browser;
		
	ReusableComponents reusableComponents = new  ReusableComponents();
	/**
	 * Constructor for Page class 
	 * @param browser
	 * @param report
	 */
	protected PlPage(WebDriver browser) {
		this.browser=browser;		
		PageFactory.initElements(browser, this);
	
	}


public PlPage() {
		// TODO Auto-generated constructor stub
	}


@FindBy(css = "#btn-explore79[href*='weather_portfolio']")
WebElement weather_strategy;

@FindBy(css = "a[class*='customize-portfolio']")
WebElement customizeportfolio;

@FindBy(xpath = "//a[contains(.,'Customise')]")
WebElement customizebutton;

@FindBy(xpath = "//a[contains(.,'Reset')]")
WebElement reset_btn_check;

@FindBy(xpath = "//div[@id='customise-portfolio']/div/div[@class='panel panel-default row portfolio-constituents']/div[@class='col-md-12']/div[3]/div[1]/div[1]/div[4]/div[1]/a[1]")
WebElement addstock_Btn;

@FindBy(xpath = "//div[@id='modal-1']//button[@type='button'][contains(text(),'Done')]")
WebElement done_btn;

@FindBy(xpath = "//div[@class='row constituent-row vertical-align']//div[@class='col-md-4']//a[@href='#'][contains(text(),'BT Group plc')]")
WebElement stockreverifypart;

@FindBy(xpath = "//input[contains(@data-isin,'SPY')]")
WebElement slider;

@FindBy(xpath = "//a[contains(.,'Rebalance')]")
WebElement rebalancebutton;

@FindBy(xpath = "//a[contains(.,'Invest Now')]")
WebElement investbutton;

@FindBy(xpath = "//span[contains(.,'SPDR S&P500 ETF Trust')]")
WebElement spdrvaluecheck;

@FindBy(xpath = "//div[1]/div[1]/ul[1]/li[1]/div[1]/div[1]/div[3]/span[1]")
WebElement updatedpercentagevalue;

@FindBy(xpath = "//div[@class='col-xs-8 no-padding'][contains(.,'International Equity')]")
WebElement scrollto_value;

@FindBy(xpath = "//div[@class='row constituent-row vertical-align']//div[@class='col-md-4']//a[@href='#'][contains(text(),'HEALTH CARE SELECT SECTOR')]")
WebElement scrollto_value_another;

// for accounting seed test cases

@FindBy(xpath = "//input[@id='username']")
WebElement login_user_field;

@FindBy(xpath = "//input[@id='password']")
WebElement login_pass_field;

@FindBy(xpath = "//input[@id='Login']")
WebElement login_btn;

//span[normalize-space()='Opportunities']
@FindBy(xpath = "//a[@title='Opportunities']")
WebElement opportunities_click;

@FindBy(xpath = "//div[contains(text(),'New')]")
WebElement New_opp_btn;

//div[@class='uiInput uiInputDate uiInput--default uiInput--input uiInput--datetime']//div[@class='form-element']/input[@data-proxy-id='aura-pos-lib-4']
@FindBy(xpath = "//div[@class='form-element']/input[@type='text']")
WebElement date_field;

@FindBy(xpath = "//div[@class='slds-form-element__control']/div[1]/input[@class=' input'][@aria-required='true']")
WebElement opportunity_enter;

@FindBy(xpath = "//a[contains(@aria-required,'true')]")
WebElement stage_enter;

//@FindBy(xpath = "//a[normalize-space()='Qualification']")
@FindBy(xpath = "//a[@title='Qualification']")
WebElement select_stage;

@FindBy(xpath = "//button[contains(@title,'Save')]//span[contains(@class,'label bBody')][normalize-space()='Save']")
WebElement save_btn;
	
@FindBy(xpath = "//table[@class='detailList']//div[@class='requiredInput']//span[@class='lookupInput']/a/img")
WebElement btn_img;

@FindBy(xpath = "//table[@class='detailList']//div[@class='requiredInput']//span[@class='lookupInput']/input")//input[@maxlength='255']
//@FindBy(xpath = "//table[@class='detailList']//td[@class='dataCol first']/div/span")//input[@maxlength='255']
WebElement first_input;

//@FindBy(xpath = "//table[@class='detailList']//td[@class='dataCol']/div/span/input")
@FindBy(xpath = "//table[@class='detailList']//td[@class='dataCol ']//div[@class='requiredInput']//span[@class='lookupInput']/input")
WebElement second_input;

//@FindBy(xpath = "//div[@class='pbBottomButtons']//table//td//span/input")
//@FindBy(xpath = "//div[@class='pbBottomButtons']//span/input[@class='btn']")
@FindBy(xpath = "//form[@id='thePage:theForm1']//div//div//div//div[@class='pbHeader']//table//tbody//tr//td[2]/input")
WebElement btn_run_click;

@FindBy(xpath = "//c-lookup[@data-jest='startingAccountingPeriod']//div[@class='slds-form-element']//div[@class='slds-form-element__control']//button") 
WebElement new_start_time_btn;

@FindBy(xpath = "//c-lookup[@data-jest='startingAccountingPeriod']//div[@class='slds-form-element']//div[@class='slds-form-element__control']//input")
WebElement new_start_time_input;

@FindBy(xpath = "//c-lookup[@data-jest='endingAccountingPeriod']//div[@class='slds-form-element']//div[@class='slds-form-element__control']//button") 
WebElement new_end_time_btn;

@FindBy(xpath = "//c-lookup[@data-jest='endingAccountingPeriod']//div[@class='slds-form-element']//div[@class='slds-form-element__control']//input")
WebElement new_end_time_input;

@FindBy(xpath = "//button[contains(text(),'Run')]")
WebElement new_click_btn_run;

@FindBy(xpath = "//div[@role='listbox']//ul[@role='presentation']//li[@role='presentation']//span[@data-recordname='2020-07']/span[2]/span")
WebElement dropdown;

@FindBy(xpath = "//div[@role='listbox']//ul[@role='presentation']//li[@role='presentation']//span[@data-recordname='2021-06']/span[2]/span")
WebElement dropdown1;

@FindBy(xpath = "//table//tbody//tr[1]//th//div[1]//a")
WebElement reportname;

@FindBy(xpath = "//button[contains(text(),'Delete Reports')]")
WebElement nav_clicker;

@FindBy(xpath = "//input[@id='lksrch']")
WebElement frame_search;

@FindBy(xpath = "//body/form[@id='theForm']/div[1]/div[2]/input[2]")
WebElement frame_go;

@FindBy(xpath = "//a[contains(text(),'2020-06')]")
//@FindBy(xpath = "//a[contains(text(),'2020-06')]")
WebElement frame_select;

ArrayList<String> startdate_arr= new ArrayList<String>();
ArrayList<String> enddate_arr= new ArrayList<String>();




	/*** Test case Method Name : validateTestA
	 * 	 Functionality         : validate login to Accounting seed salesforce
	 * 	 Created By			   : Subramanya MS
	 * @throws IOException 
	 * @throws AWTException 
	 * 
	***/
	public synchronized  PlPage validateTestA(int threadID , List<String> tempList , String pathLoc ) throws IOException, AWTException {
		String testcasemethod = new Object(){}.getClass().getEnclosingMethod().getName();
	try{
		String username = null, pass_login = null;
		
		//browser.switchTo().defaultContent();
		
		username = reusableComponents.getPropValues("username");
		pass_login = reusableComponents.getPropValues("password");
		
		ReusableComponents.wait(2300);
		
		if(ReusableComponents.isElementPresent(login_user_field)){
			
			ReusableComponents.wait(1200);
		//	ReusableComponents.reportPass( threadID , tempList , testcasemethod , "login_user_field is present", browser ,pathLoc+"\\"+testcasemethod , false );
			
			login_user_field.sendKeys(username);
			
			if(ReusableComponents.isElementPresent(login_pass_field)){
				
				login_pass_field.sendKeys(pass_login);				
				ReusableComponents.wait(1200);
				
				if(ReusableComponents.isElementPresent(login_btn)){
					
					ReusableComponents.wait(1200);
					login_btn.click();
					ReusableComponents.wait(15500);
					
				}else{
					ReusableComponents.reportFail( threadID , tempList , testcasemethod , "login button is NOT present successfully", browser ,pathLoc+"\\"+testcasemethod , true );
				}
				
			}else{
				ReusableComponents.reportFail( threadID , tempList , testcasemethod , "password field is NOT present successfully", browser ,pathLoc+"\\"+testcasemethod , true );
			}
						
		}else{
			ReusableComponents.reportFail( threadID , tempList , testcasemethod , "login_user_field is NOT present successfully", browser ,pathLoc+"\\"+testcasemethod , true );
		}
		
		
	}catch(NoSuchElementException e){
		ReusableComponents.reportFail( threadID , tempList , testcasemethod , " Object is not present"+e.getStackTrace() , browser ,pathLoc+"\\"+testcasemethod , false );
	}
		
		return new PlPage(browser);
	}

	
	
	/*** Test case Method Name : validateTestOpp
	 * 	 Functionality         : validate opportunity creation
	 * 	 Created By			   : Subramanya MS
	 * @throws IOException 
	 * @throws AWTException 
	 * 
	***/
	public synchronized  PlPage validateTestOpp(int threadID , List<String> tempList , String pathLoc ) throws IOException, AWTException {
		String testcasemethod = new Object(){}.getClass().getEnclosingMethod().getName();
	try{
		String opportunity_name = null;
		int counter=0, i=0;
		
		counter = Integer.parseInt(reusableComponents.getPropValues("opportunity_counter")) ;
		
		for(i=0;i<counter;i++) {
		
		browser.switchTo().defaultContent();
		
		//ReusableComponents.wait(2300);
		
		opportunity_name = reusableComponents.getPropValues("opp_name");
		
		
		  WebElement ele =browser.findElement(By.xpath("//a[@title='Opportunities']"));
		  
		  JavascriptExecutor executor = (JavascriptExecutor)browser;
		  executor.executeScript("arguments[0].click();", ele);
		  
		  ReusableComponents.wait(1200);
		 
		  browser.switchTo().defaultContent();
		  
		  ReusableComponents.wait(1200);
		
		if(ReusableComponents.isElementPresent(New_opp_btn)){
			ReusableComponents.wait(1200);
			
			New_opp_btn.click();
			
			ReusableComponents.wait(1200);
			
			browser.switchTo().defaultContent();
			
			
			
		}else{
			ReusableComponents.reportFail( threadID , tempList , testcasemethod , "New_opp_btn is NOT present successfully", browser ,pathLoc+"\\"+testcasemethod , true );
		}
		
		try {
			ReusableComponents.wait(1200);
			
			  WebElement ele1 =browser.findElement(By.xpath("//a[contains(@class,'datePicker-openIcon display')]"));
			  
			  JavascriptExecutor executor1 = (JavascriptExecutor)browser;
			  executor1.executeScript("arguments[0].click();", ele1);
			  
			  ReusableComponents.wait(1200);
			  
			  WebElement ele2 =browser.findElement(By.xpath("//button[normalize-space()='Today']"));
			  
			  JavascriptExecutor executor2 = (JavascriptExecutor)browser;
			  executor2.executeScript("arguments[0].click();", ele2);
			 
			  ReusableComponents.wait(1200);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("exception in date field");
		}
			
		
		if(ReusableComponents.isElementPresent(opportunity_enter)){
			ReusableComponents.wait(1200);
			
			String dt_pattern = "yymmddhhmmss";
			DateTimeFormatter cdt = DateTimeFormatter.ofPattern(dt_pattern);
			LocalDateTime now = LocalDateTime.now();
			
			
			
			opportunity_enter.sendKeys(opportunity_name+"_"+cdt.format(now));
			ReusableComponents.wait(1200);
			
			if(ReusableComponents.isElementPresent(stage_enter)){
				ReusableComponents.wait(1200);
				
				stage_enter.click();
				ReusableComponents.wait(1200);
				
				if(ReusableComponents.isElementPresent(select_stage)){
					ReusableComponents.wait(2200);
					
					new WebDriverWait(browser, 20).until(ExpectedConditions.elementToBeClickable(select_stage)).click();
					//select_stage.click();
					ReusableComponents.wait(1200);
					
					if(ReusableComponents.isElementPresent(save_btn)){
						ReusableComponents.wait(1200);
						
						save_btn.click();
						ReusableComponents.wait(1200);
						
					}else{
						ReusableComponents.reportFail( threadID , tempList , testcasemethod , "save btn is NOT present successfully", browser ,pathLoc+"\\"+testcasemethod , true );
					}
					
				}else{
					ReusableComponents.reportFail( threadID , tempList , testcasemethod , "select stage is NOT present successfully", browser ,pathLoc+"\\"+testcasemethod , true );
				}
				
			}else{
				ReusableComponents.reportFail( threadID , tempList , testcasemethod , "stage enter is NOT present successfully", browser ,pathLoc+"\\"+testcasemethod , true );
			}
			
		}else{
			ReusableComponents.reportFail( threadID , tempList , testcasemethod , "opportunity enter is NOT present successfully", browser ,pathLoc+"\\"+testcasemethod , true );
		}
		
		//return back to opportunity page
		ReusableComponents.wait(2200);
		 
		}//for loop end
		
		
	}catch(NoSuchElementException e){
		ReusableComponents.reportFail( threadID , tempList , testcasemethod , " Object is not present"+e.getStackTrace() , browser ,pathLoc+"\\"+testcasemethod , false );
	}
		
		return new PlPage(browser);
	}

	
	/*** Test case Method Name : validateTestb
	 * 	 Functionality         : validate login to Accounting seed salesforce financial reports page old
	 * 	 Created By			   : Subramanya MS
	 * @throws IOException 
	 * @throws AWTException 
	 * 
	***/
	public synchronized  PlPage validateTestB(int threadID , List<String> tempList , String pathLoc ) throws IOException, AWTException {
		String testcasemethod = new Object(){}.getClass().getEnclosingMethod().getName();
	try{
		/*
		 * boolean test=false;
		 * 
		 * 
		 * try { test = browser.getPageSource().contains("iframe");
		 * 
		 * if(test == true) {
		 * 
		 * browser.switchTo().frame(0); System.out.println("inside an iframe");
		 * 
		 * if(ReusableComponents.isElementPresent(btn_img)){
		 * ReusableComponents.wait(1200);
		 * 
		 * btn_img.click(); ReusableComponents.wait(1200);
		 * 
		 * }else{ ReusableComponents.reportFail( threadID , tempList , testcasemethod ,
		 * "btn is NOT present successfully", browser ,pathLoc+"\\"+testcasemethod ,
		 * true ); }
		 * 
		 * } } catch (Exception e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); System.out.println("my bad"); }
		 */
		/*
		 * 
		 * try { System.out.println("no validation");
		 * 
		 * browser.switchTo().frame(0);
		 * 
		 * if(ReusableComponents.isElementPresent(btn_img)){
		 * ReusableComponents.wait(1200);
		 * 
		 * btn_img.click(); ReusableComponents.wait(1200);
		 * 
		 * }else{ ReusableComponents.reportFail( threadID , tempList , testcasemethod ,
		 * "btn is NOT present successfully", browser ,pathLoc+"\\"+testcasemethod ,
		 * true ); } } catch (Exception e) { // TODO Auto-generated catch block
		 * System.out.println("not sure"); }
		 * 
		 * 
		 */
		
		
		
		
		  boolean test=false;
		  
		  
		  try { 
			  
			  test = browser.getPageSource().contains("iframe");
		  
		  if(test == true) {
		  
		  browser.switchTo().frame(0); 
		  System.out.println("inside an iframe");
		  ReusableComponents.wait(3200);
//		  
//		  try {
//			if(ReusableComponents.isElementPresent(btn_img)){
//				  ReusableComponents.wait(1200);
//				  
//				  btn_img.click();
//				  ReusableComponents.wait(1200);
//				  
//				  //new window
//				  String main_win = browser.getWindowHandle();
//				  Set<String> s1 = browser.getWindowHandles();
//				  
//				  Iterator<String> i1 = s1.iterator();
//			        
//			        while (i1.hasNext()) {
//			            String ChildWindow = i1.next();
//			                if (!main_win.equalsIgnoreCase(ChildWindow)) {
//			                browser.switchTo().window(ChildWindow);
//			                
//			                ReusableComponents.wait(1200);
//			                
//			                browser.switchTo().frame(0);
//			                
//			                frame_search.clear();
//			                frame_search.sendKeys("2020-06");
//			                
//			                ReusableComponents.wait(1200);
//			                
//			                frame_go.click();
//			                
//			                ReusableComponents.wait(4200);
//			                
//			               try {
//							// frame_select.click();
//							    WebElement frame = browser.findElement(By.linkText("2020-06"));
//							    
//							    
//							    frame.click();
//							    
//							    ReusableComponents.wait(2200);
//						} catch (Exception e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//			               
//			               try {
//								// frame_select.click();
//								    WebElement frame = browser.findElement(By.xpath("//a[@href='#']"));
//								    
//								    frame.click();
//								    
//								    ReusableComponents.wait(2200);
//							} catch (Exception e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//			               
//			                browser.close();
//			                System.out.println("Child window closed");
//			            }
//			        }    
//			  
//			        //  Switch back to the main window which is the parent window.
//			        browser.switchTo().window(main_win);
//			        ReusableComponents.wait(12200);
//				  
//				  
//				  }
//				  else
//				  { 
//					  ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"first is NOT present successfully", browser ,pathLoc+"\\"+testcasemethod , true ); 
//				  }
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			System.out.println("frame checker");
//		}
//		  
//		  
//		  browser.switchTo().defaultContent();
//		  browser.switchTo().frame(0);
//		  
//		  
		  try {
			if(ReusableComponents.isElementPresent(first_input)){
			  ReusableComponents.wait(1200);
			  
			  
			  System.out.println("in first");
			  first_input.clear();
			  first_input.sendKeys("2020-06");
			  ReusableComponents.wait(1200);
			  
			  }
			  else
			  { 
				  ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"first is NOT present successfully", browser ,pathLoc+"\\"+testcasemethod , true ); 
			  }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("first btn");
		}
		  
		  try {
			if(ReusableComponents.isElementPresent(second_input)){
				  ReusableComponents.wait(1200);
				  
				  System.out.println("in second");
				  second_input.clear();
				  second_input.sendKeys("2021-05");
				  ReusableComponents.wait(1200);
				  
				  }
				  else
				  { 
					  ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"second is NOT present successfully", browser ,pathLoc+"\\"+testcasemethod , true ); 
				  }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("second btn");
		}
		  
		  try {
			if(ReusableComponents.isElementPresent(btn_run_click)){
				  ReusableComponents.wait(1200);
				  
				  System.out.println("run button");
				  
				  btn_run_click.click();
				  
				  System.out.println("btn clicker");
				  ReusableComponents.wait(3200);
				  
				  //ReusableComponents.reportPass(threadID, tempList, testcasemethod, "test", browser, pathLoc+"\\"+testcasemethod, false);
				  ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "before report generation", browser, pathLoc+"\\"+testcasemethod, true);
				  }
				  else
				  { 
					  ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"btn is NOT present successfully", browser ,pathLoc+"\\"+testcasemethod , true ); 
				  }
			
			ReusableComponents.wait(15200);
			((JavascriptExecutor) browser)
			.executeScript("window.scrollTo(0,document.body.scrollHeight)");
			
			//ReusableComponents.reportPass(threadID, tempList, testcasemethod, "test", browser, pathLoc+"\\"+testcasemethod, false);
			 ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "processing", browser, pathLoc+"\\"+testcasemethod, true);
			
			 ReusableComponents.wait(13200);
			  
			 
			  ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "report generated", browser, pathLoc+"\\"+testcasemethod, true); 
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("run btn");
		}
		  
		  
		  browser.switchTo().defaultContent();
		  
		  } 
		  } catch (Exception e) { // TODO Auto-generated catch block
		  e.printStackTrace(); 
		  System.out.println("my bad"); 
		  }
		 
		
		
		
		
	}catch(NoSuchElementException e){
		ReusableComponents.reportFail( threadID , tempList , testcasemethod , " Object is not present"+e.getStackTrace() , browser ,pathLoc+"\\"+testcasemethod , false );
	}
		
		return new PlPage(browser);
	}


	/*** Test case Method Name : validateTestC
	 * 	 Functionality         : validate login to Accounting seed salesforce financial reports page Lightning
	 * 	 Created By			   : Subramanya MS
	 * @throws IOException 
	 * @throws AWTException 
	 * 
	***/
	public synchronized  PlPage validateTestC(int threadID , List<String> tempList , String pathLoc ) throws IOException, AWTException {
		String testcasemethod = new Object(){}.getClass().getEnclosingMethod().getName();
	try{
		
		String startdate = null, enddate = null;
		
		//the excel input value should be supplied to start date and end date
		
		try {

			String filename = reusableComponents.getPropValues("inputfilename");
			String sheetname = reusableComponents.getPropValues("sheetname");
			
			//String outfilename = reusableComponents.getPropValues("outputfilename");
			//String outsheetname = reusableComponents.getPropValues("outputsheetname");

			File file = new File(workingDir + "\\input\\" + filename);
			FileInputStream istream = new FileInputStream(file);

			Workbook myworkbook = null;

			String fileExtensionName = filename.substring(filename.indexOf("."));

			if (fileExtensionName.equals(".xlsx")) {
				// If it is xlsx file then create object of XSSFWorkbook class
				myworkbook = new XSSFWorkbook(istream);
			}
			// Check condition if the file is xls file
			else if (fileExtensionName.equals(".xls")) {
				// If it is xls file then create object of HSSFWorkbook class
				myworkbook = new HSSFWorkbook(istream);
			}

			Sheet workbooksheet = myworkbook.getSheet(sheetname);
			int rowCount = workbooksheet.getLastRowNum() - workbooksheet.getFirstRowNum();

			// read rows and columns
			
			Iterator<Row> itr = workbooksheet.iterator();
			
			while(itr.hasNext()) {
				Row row = itr.next();
				
				Iterator<Cell> celliterator = row.cellIterator();
				
				while(celliterator.hasNext()) {
					
					Cell cell = celliterator.next();
					 final DataFormatter formatter = new DataFormatter();
					switch (cell.getCellType()) {
			        case Cell.CELL_TYPE_STRING:
			         //   startdate_arr.add(cell.getStringCellValue());
			        case Cell.CELL_TYPE_BLANK:
			        //	startdate_arr.add(cell.getStringCellValue());
			        case Cell.CELL_TYPE_BOOLEAN:
			        //	startdate_arr.add(cell.getStringCellValue());
			        case Cell.CELL_TYPE_NUMERIC:
			           
			         //   startdate_arr.add(formatter.formatCellValue(cell));
			        default:
			        	startdate_arr.add(formatter.formatCellValue(cell));
			            //throw new RuntimeException("unknown cell type " + cell.getCellType());
			    }
					
				}
			}
		

			

		

		} catch (NoSuchElementException e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					" Object is not present" + e.getStackTrace(), browser, pathLoc + "\\" + testcasemethod, false);
		}
		
		
		
		for(int i =0; i<startdate_arr.size();i++) {
			
			System.out.println(startdate_arr.get(i));
		}
		
		
		startdate = startdate_arr.get(2);
		enddate = startdate_arr.get(3);
		
		System.out.println("start date "+startdate+" and end date "+enddate);
		
		
		
		
		//till here
		
//		startdate = reusableComponents.getPropValues("startvalue","plconfig");
//		enddate = reusableComponents.getPropValues("endvalue", "plconfig");
		
		ReusableComponents.wait(5200);
	
		if(ReusableComponents.isElementPresent(new_start_time_btn)){
			  ReusableComponents.wait(1200);
			  
			  System.out.println(" clear selection");
			  
			  new_start_time_btn.click();
			  
			  System.out.println("btn clear");
			  ReusableComponents.wait(3200);
			  
			  if(ReusableComponents.isElementPresent(new_start_time_input)){
				  ReusableComponents.wait(1200);
				  
				  System.out.println(" input selection");
				  
				  new_start_time_input.click();
				  
				  System.out.println("btn clear");
				  ReusableComponents.wait(3200);
				  
				  new_start_time_input.sendKeys(startdate);

				  System.out.println("aft date");
				  
				  ReusableComponents.wait(3200);
				  
				  WebElement dyn_dropdown = browser.findElement(By.xpath("//div[@role='listbox']//ul[@role='presentation']//li[@role='presentation']//span[@data-recordname='"+startdate+"']/span[2]/span"));
				  
if(ReusableComponents.isElementPresent(dyn_dropdown)) { //dropdown
					  
					  ReusableComponents.wait(1200);
					  dyn_dropdown.click();
					  
					  
				  }else {
					  
					  System.out.println("dropdown not present");
				  }
				 		  
				  System.out.println("aft drop click");
				  
			
				  
				  //ReusableComponents.reportPass(threadID, tempList, testcasemethod, "test", browser, pathLoc+"\\"+testcasemethod, false);
				 // ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "before report generation", browser, pathLoc+"\\"+testcasemethod, true);
				  }
				  else
				  { 
					  ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"btn is NOT present successfully", browser ,pathLoc+"\\"+testcasemethod , true ); 
				  }
			  
			  //ReusableComponents.reportPass(threadID, tempList, testcasemethod, "test", browser, pathLoc+"\\"+testcasemethod, false);
			 // ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "before report generation", browser, pathLoc+"\\"+testcasemethod, true);
			  }
			  else
			  { 
				  ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"btn is NOT present successfully", browser ,pathLoc+"\\"+testcasemethod , true ); 
			  }
		
		
		if(ReusableComponents.isElementPresent(new_end_time_btn)){
			  ReusableComponents.wait(1200);
			  
			  System.out.println(" clear selection end");
			  
			  new_end_time_btn.click();
			  
			  System.out.println("btn clear end");
			  ReusableComponents.wait(3200);
			  
			  if(ReusableComponents.isElementPresent(new_end_time_input)){
				  ReusableComponents.wait(1200);
				  
				  System.out.println(" input selection end");
				  
				  new_end_time_input.click();
				  
				  System.out.println("btn clear end");
				  ReusableComponents.wait(3200);
				  
				  new_end_time_input.sendKeys(enddate);

				  System.out.println("aft date");
				  
				  ReusableComponents.wait(3200);
				  
				  WebElement dyn_dropdown1 = browser.findElement(By.xpath("//div[@role='listbox']//ul[@role='presentation']//li[@role='presentation']//span[@data-recordname='"+enddate+"']/span[2]/span"));
				  
if(ReusableComponents.isElementPresent(dyn_dropdown1)) { //dropdown1
					  
					  ReusableComponents.wait(1200);
					  dyn_dropdown1.click();
					  
					  
				  }else {
					  
					  System.out.println("dropdown not present");
				  }
				 
//				  
				 
				  
				  System.out.println("aft drop click");
				  
			//	  Select dropdown1 = new Select(dropdown);
//				  
//				  dropdown1.selectByVisibleText("2020-06");
				  
				  ReusableComponents.wait(3200);
				  
				  if(ReusableComponents.isElementPresent(new_click_btn_run)) {
					  
					  ReusableComponents.wait(1200);
					  new_click_btn_run.click();
					  ReusableComponents.wait(2200);
					  ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "report generation", browser, pathLoc+"\\"+testcasemethod, true);
					  
					  
				  }else {
					  
					  System.out.println("run btn not present");
				  }
				  
				//  ReusableComponents.wait(5200);
				  
				  ReusableComponents.wait(4200);
				  ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "report generation", browser, pathLoc+"\\"+testcasemethod, true);
				  
				  
				  ReusableComponents.wait(15200);
//					((JavascriptExecutor) browser)
//					.executeScript("window.scrollTo(0,document.body.scrollHeight)");
//					
//					 ReusableComponents.wait(5200);
//					
//					JavascriptExecutor js = (JavascriptExecutor) browser;
//					   js.executeScript("window.scrollBy(document.body.scrollHeight,0)");
					
					
					if(ReusableComponents.isElementPresent(reportname)) {
						  
						  ReusableComponents.wait(1200);
						  
						  ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "report name is "+reportname.getText().toUpperCase()+" is generated in this iteration", browser, pathLoc+"\\"+testcasemethod, true);
						  
						  validateTestD(threadID, tempList, pathLoc);
						  
						  
						  
					  }else {
						  
						  System.out.println("report not present");
					  }
					
					
					
				  //ReusableComponents.reportPass(threadID, tempList, testcasemethod, "test", browser, pathLoc+"\\"+testcasemethod, false);
				 // ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "before report generation", browser, pathLoc+"\\"+testcasemethod, true);
				  }
				  else
				  { 
					  ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"btn is NOT present successfully", browser ,pathLoc+"\\"+testcasemethod , true ); 
				  }
			  
			  //ReusableComponents.reportPass(threadID, tempList, testcasemethod, "test", browser, pathLoc+"\\"+testcasemethod, false);
			 // ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "before report generation", browser, pathLoc+"\\"+testcasemethod, true);
			  }
			  else
			  { 
				  ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"btn is NOT present successfully", browser ,pathLoc+"\\"+testcasemethod , true ); 
			  }
		 
		
		
		
		
	}catch(NoSuchElementException e){
		ReusableComponents.reportFail( threadID , tempList , testcasemethod , " Object is not present"+e.getStackTrace() , browser ,pathLoc+"\\"+testcasemethod , false );
	}
		
		return new PlPage(browser);
	}

	
	/*** Test case Method Name : validateTestD
	 * 	 Functionality         : validate navigation to Accounting seed salesforce financial reports page Lightning
	 * 	 Created By			   : Subramanya MS
	 * @throws IOException 
	 * @throws AWTException 
	 * 
	***/
	public synchronized  PlPage validateTestD(int threadID , List<String> tempList , String pathLoc ) throws IOException, AWTException {
		String testcasemethod = new Object(){}.getClass().getEnclosingMethod().getName();
	try{
		
		ReusableComponents.wait(4200);

		if(ReusableComponents.isElementPresent(new_click_btn_run)) {
			  
			  ReusableComponents.wait(1200);

		        JavascriptExecutor js1 = (JavascriptExecutor) browser;
		       
		        try {
					
					//This will scroll the page Horizontally till the element is found		
					js1.executeScript("arguments[0].scrollIntoView();", new_click_btn_run);
					
					ReusableComponents.wait(1200);
					ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "report name is "+reportname.getText().toUpperCase()+" is generated in this iteration", browser, pathLoc+"\\"+testcasemethod, true);
					
					String hrefvalue = reportname.getAttribute("href");
					

					try {
						
							ReusableComponents.wait(1200);
							
							((JavascriptExecutor) browser).executeScript("window.open()");
							
							ArrayList<String> tabs2 = new ArrayList<String> (browser.getWindowHandles());
							  browser.switchTo().window(tabs2.get(1));
							  
							  browser.get(hrefvalue);
							  
							  ReusableComponents.wait(5200);
							  
							  ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "report page", browser, pathLoc+"\\"+testcasemethod, true);
							    
							  ReusableComponents.wait(1200);
							  
							  browser.close();
							  browser.switchTo().window(tabs2.get(0));

						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println("unable to click");
					}
					
														
					ReusableComponents.wait(4200);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
		  
			  
		  }else {
			  
			  System.out.println("report not present");
		  }
		
		
		
	}catch(NoSuchElementException e){
		ReusableComponents.reportFail( threadID , tempList , testcasemethod , " Object is not present"+e.getStackTrace() , browser ,pathLoc+"\\"+testcasemethod , false );
	}
		
		return new PlPage(browser);
	}

	
	

}


