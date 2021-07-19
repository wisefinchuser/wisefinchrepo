package com.wisefinch.java;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class DriverScript {
	public static String TESTCASENAME;
	public static List<String> resultList = new ArrayList<String>();
	
	public static String pathLoc;
	
	
	static DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-HH-mm");
	static Calendar c = Calendar.getInstance();
	
	 static String workingDir = System.getProperty("user.dir");
     static String resultpath = workingDir+"\\Reports\\";
	public static ExtentReports report = new ExtentReports(resultpath+dateFormat.format(c.getTime())+"webdriverunresult1.html" );
	
	
	public static ExtentTest logger ;	
	public static String videoFilePath;
	
	
	public static HashMap<Integer, List<String>> hmap = new HashMap<Integer, List<String>>();
	
}
