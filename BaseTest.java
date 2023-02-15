package com.salesTool.common;

import java.awt.AWTException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.TestResults;
import com.applitools.eyes.selenium.Eyes;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.salesTool.applitools.ApplitoolsTestResultsHandler;
import com.salesTool.applitools.ResultStatus;
import com.salesTool.common.BaseTest;
import com.salesTool.pages.AdvertisedPromotionsPage;
import com.salesTool.pages.CustomersPage;
import com.salesTool.pages.LoginPage;
import com.salesTool.pages.Menu;
import com.salesTool.pages.OrdersPage;
import com.salesTool.pages.ProductDetailPage;
import com.salesTool.pages.ReviewOrderPage;
import com.salesTool.pages.DYFPage;
import com.salesTool.pages.FavoritesPage;
import com.salesTool.pages.RecommendationsPage;

import com.salesTool.pages.DeliveriesPage;

import com.salesTool.pages.SearchPage;
import com.salesTool.pages.SpanishPage;
import com.salesTool.pages.SuggestedProductPage;
import com.salesTool.pages.InventoryPage;
import com.salesTool.util.Awake;
import com.salesTool.util.CommandPrompt;
import com.salesTool.util.Constants;
import com.salesTool.util.PDFReport;
import com.salesTool.util.ExcelReader;
import com.salesTool.util.HtmlReport;

//import com.sfdc.pages.AddEvent;
//import com.sfdc.pages.LoginPage;
//import com.sfdc.util.Awake;
//import com.sfdc.util.CommandPrompt;
//import com.sfdc.util.Constants;
//import com.salesTool.util.ExcelReader;
//import com.sfdc.util.PDFReport;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseTest
{

	protected BatchInfo batch;
	protected String port;
	protected ThreadLocal<String> deviceName = new ThreadLocal<>();
	protected ThreadLocal<String> osVersion = new ThreadLocal<>();
	protected ThreadLocal<String> deviceId = new ThreadLocal<>();
	protected int numOfDevices;
	protected int deviceCount;
	protected ThreadLocal<IOSDriver<MobileElement>> driver = new ThreadLocal<>();
	protected ThreadLocal<IOSDriver<MobileElement>> driver1 = new ThreadLocal<>();
	protected ThreadLocal<Integer> deviceIndex = new ThreadLocal<>();
	protected Map<String, String> devices = new HashMap<String, String>();

	CommandPrompt commandPrompt = new CommandPrompt();
	public static ExtentReports report;
	public static ExtentTest logger;
	// Eyes eyes;
	// String viewKey = "uPQgRtldCPvkqwC9sfYzsYotHGeXyVL1x7EdQdhrg1c110";

	// The below variables are added by Sarav
	// ***********************************************************************
	public static int reportStepCount = 0;
	public static String reportFileName;
	public static String reportTextFileName;
	public static File reportTextFile;
	public static String reportHtmlFileName;
	public static File reportHtmlFile;
	public static String reportPdfFileName;
	public static File reportPdfFile;
	public static File reportExtentFile;
	public static String reportExtentFileName;
	public static boolean testStepStatus;
	public static String completedEventName;
	public String deviceDetails = "";
	public String screenshotName = "";
	public String image;
	private static String OS=null;
	public static CustomersPage customers;
	public static OrdersPage Orders;
	public static LoginPage login;
	public static SearchPage search;
	public static ReviewOrderPage reviewOrder;
	public static ProductDetailPage ProductOverview;
	public static Menu FlyinMenu;
	public static SuggestedProductPage suggestedPg;
	public static SearchPage Search;
	public static DYFPage DidYouForget;
	public static FavoritesPage Favorites;
	public static RecommendationsPage Recommendations;
	public static ReviewOrderPage ReviewOrderPg;
	public static AdvertisedPromotionsPage AdvertisedPromotionsPg;
	public static SpanishPage SpanishPg;
	public static InventoryPage Inventory;    
	public static DeliveriesPage  Deliveries;	
	public static String selectedDate;
	public static String selectedMonth;
	public static int FailStepCount=0;
	public static String base64String;
	public static int screenHeight = 0;
	public static int noOfTimesSwiped = 0;
	// ***********************************************************************
	protected Properties config;

	public static void main(String args[]) {
		BaseTest baseTest = new BaseTest();
		baseTest.getDeviceInfo();
	}

	@BeforeSuite
	public void getDeviceInfo() {
		try {
			if(Constants.ReportFormat.equalsIgnoreCase("combined"))
			{
			createReportFile("SalesToolMobile _IOS", "txt");
			createReportFile("SalesToolMobile_IOS", "extent");
			System.out.println("Extent Report : " + reportExtentFileName);
			report = new ExtentReports(reportExtentFileName);

			if (report != null) {
				System.out.println("Extent Report Object Is Created");
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterSuite
	public void createReports() {
		try {

			try {
				if(Constants.ReportFormat.equalsIgnoreCase("combined")) {
					System.out.println("Inside After Suite");
					report.flush();
					report.close();
				}
			} catch (Exception e) {
				
			}

			String pdfReportFileName = Constants.PdfReportPath + reportFileName + ".pdf";
			PDFReport pdf = new PDFReport();
			pdf.generatePDFReport(pdfReportFileName, reportTextFileName);

			String htmlReportFileName = Constants.HtmlReportPath + reportFileName + ".html";
			HtmlReport html = new HtmlReport();
			html.createHtmlFile(htmlReportFileName, reportTextFileName);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void abortTest(IOSDriver<MobileElement> driver) {
		try {

//			report.endTest(logger);
//			report.flush();
//			report.close();

			String pdfReportFileName = Constants.PdfReportPath + reportFileName + ".pdf";
			PDFReport pdf = new PDFReport();
			pdf.generatePDFReport(pdfReportFileName, reportTextFileName);

//			String htmlReportFileName = Constants.HtmlReportPath + reportFileName + ".html";
//			HtmlReport html = new HtmlReport();
//			html.createHtmlFile(htmlReportFileName, reportTextFileName);
			
			driver.quit();
			testStepStatus = false;
			FailStepCount++;

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public synchronized void createMobileDriver(String deviceName, String platformVersion, String platformName, String bundleId, String udid) throws Exception {
		System.out.println("INSIDE CREATE MOBILE DRIVER METHOD");
		String filePath = System.getProperty("user.dir") + "/src/test/resources/deviceinfo/deviceInfo.properties";
		
		try {
			FileInputStream fileInputStream = new FileInputStream(filePath);
			Properties prop = new Properties();
			prop.load(fileInputStream);
			
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			System.out.println("deviceName :" + deviceName);
			System.out.println("platformVersion:"+platformVersion);
			System.out.println("platformName:"+platformName);
			System.out.println("bundleId:"+bundleId);
			System.out.println("udid:"+udid);
		
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
			capabilities.setCapability("maxTypingFrequency",30);
			
//			capabilities.setCapability("deviceName",prop.getProperty("deviceName"));
//			capabilities.setCapability("platformVersion",prop.getProperty("platformVersion"));
//			capabilities.setCapability("platformName",prop.getProperty("platformName"));
//			capabilities.setCapability("bundleId",prop.getProperty("bundleId"));
//			capabilities.setCapability("udid",prop.getProperty("udid"));
			
			capabilities.setCapability("deviceName",deviceName);
			capabilities.setCapability("platformVersion",platformVersion);
			capabilities.setCapability("platformName",platformName);
			capabilities.setCapability("bundleId",bundleId);
			capabilities.setCapability("udid",udid);	
			capabilities.setCapability("simpleIsVisibleCheck",false);
			capabilities.setCapability("fullReset",false);
			capabilities.setCapability("noReset",true);
			capabilities.setCapability("newCommandTimeout", 180);
			capabilities.setCapability("xcodeOrgId", "8AP2Z6KB72");
			capabilities.setCapability("xcodeSigningId", "iPhone Developer");
			
//			capabilities.setCapability("app",System.getProperty("user.dir")+"/app/iOS.ipa");
			
				driver.set(new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities));
							
				System.out.println("DRIVER HAS BEEN CREATED");
				// Initialize the page objects once the driver object has been created
				login = new LoginPage(getWebDriver());
				customers = new CustomersPage(getWebDriver());				
				Orders = new OrdersPage(getWebDriver());			
				reviewOrder = new ReviewOrderPage(getWebDriver());
				search = new SearchPage(getWebDriver());
				ProductOverview = new ProductDetailPage(getWebDriver());
				FlyinMenu = new Menu(getWebDriver());
				Inventory = new InventoryPage(getWebDriver());
				Search = new SearchPage(getWebDriver());
				DidYouForget = new DYFPage(getWebDriver());
				Favorites = new FavoritesPage(getWebDriver());
				Recommendations = new RecommendationsPage(getWebDriver());	
				ReviewOrderPg = new ReviewOrderPage(getWebDriver());	
				SpanishPg = new SpanishPage(getWebDriver());	
				Deliveries=new DeliveriesPage(getWebDriver());
				AdvertisedPromotionsPg = new AdvertisedPromotionsPage(getWebDriver());
				suggestedPg=new SuggestedProductPage(getWebDriver());

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("DRIVER HAS NOT BEEN CREATED");
			}
	}
	
	public synchronized void createMobileDriver1(String deviceName, String platformVersion, String platformName, String bundleId, String udid) throws Exception {
		System.out.println("INSIDE CREATE MOBILE DRIVER METHOD");
		String filePath = System.getProperty("user.dir") + "/src/test/resources/deviceinfo/deviceInfo.properties";
		
		try {
			FileInputStream fileInputStream = new FileInputStream(filePath);
			Properties prop = new Properties();
			prop.load(fileInputStream);
			
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			System.out.println("deviceName :" + deviceName);
			System.out.println("platformVersion:"+platformVersion);
			System.out.println("platformName:"+platformName);
			System.out.println("bundleId:"+bundleId);
			System.out.println("udid:"+udid);
		
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
			capabilities.setCapability("maxTypingFrequency",30);
			
//			capabilities.setCapability("deviceName",prop.getProperty("deviceName"));
//			capabilities.setCapability("platformVersion",prop.getProperty("platformVersion"));
//			capabilities.setCapability("platformName",prop.getProperty("platformName"));
//			capabilities.setCapability("bundleId",prop.getProperty("bundleId"));
//			capabilities.setCapability("udid",prop.getProperty("udid"));
			
			capabilities.setCapability("deviceName",deviceName);
			capabilities.setCapability("platformVersion",platformVersion);
			capabilities.setCapability("platformName",platformName);
			capabilities.setCapability("bundleId","com.kony.mobilebillpay");
			capabilities.setCapability("udid",udid);	
			capabilities.setCapability("simpleIsVisibleCheck",false);
			capabilities.setCapability("fullReset",false);
			capabilities.setCapability("noReset",true);
			capabilities.setCapability("newCommandTimeout", 180);
			
//			capabilities.setCapability("app",System.getProperty("user.dir")+"/app/iOS.ipa");
			
				driver1.set(new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4724/wd/hub"), capabilities));
							
				System.out.println("DRIVER HAS BEEN CREATED");
				// Initialize the page objects once the driver object has been created
				login = new LoginPage(getWebDriver());
				customers = new CustomersPage(getWebDriver());				
				Orders = new OrdersPage(getWebDriver());			
				reviewOrder = new ReviewOrderPage(getWebDriver());
				search = new SearchPage(getWebDriver());
				ProductOverview = new ProductDetailPage(getWebDriver());
				FlyinMenu = new Menu(getWebDriver());
				Inventory = new InventoryPage(getWebDriver());
				Search = new SearchPage(getWebDriver());
				DidYouForget = new DYFPage(getWebDriver());
				Favorites = new FavoritesPage(getWebDriver());
				Recommendations = new RecommendationsPage(getWebDriver());	
				ReviewOrderPg = new ReviewOrderPage(getWebDriver());	
				SpanishPg = new SpanishPage(getWebDriver());	
				Deliveries=new DeliveriesPage(getWebDriver());
				AdvertisedPromotionsPg = new AdvertisedPromotionsPage(getWebDriver());

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("DRIVER HAS NOT BEEN CREATED");
			}
	}


	protected int countDevices() {
		int countDevices = 0;
		try {
			String filePath = System.getProperty("user.dir")
					+ "/src/test/resources/deviceinfo/deviceInfo.properties";
			FileInputStream fileInputStream = new FileInputStream(filePath);
			Properties properties = new Properties();
			properties.load(fileInputStream);
			fileInputStream.close();

			Enumeration enuKeys = properties.keys();
			while (enuKeys.hasMoreElements()) {
				String key = (String) enuKeys.nextElement();
				String value = properties.getProperty(key);
				if (!value.contains("used")) {
					countDevices++;
				}
				System.out.println(key + ": " + value);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return countDevices;
	}
	
	
	
	
	protected void removeDevices() {
		try {
			String filePath = System.getProperty("user.dir")
					+ "/src/test/resources/deviceinfo/deviceInfo.properties";
			FileInputStream fileInputStream = new FileInputStream(filePath);
			Properties properties = new Properties();
			properties.load(fileInputStream);
			fileInputStream.close();

			Enumeration enuKeys = properties.keys();
			while (enuKeys.hasMoreElements()) {
				String key = (String) enuKeys.nextElement();
				properties.remove(key);
			}
			FileOutputStream out = new FileOutputStream(filePath);
			properties.store(out, null);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void startTest(IOSDriver<MobileElement> driver, String strTestCaseName, String strDevice)
			throws IOException {
		testStepStatus = true;
		String logReport = strTestCaseName + Constants.DELIMITER + strDevice + Constants.DELIMITER
				+ getCurrentDateAndTime() + Constants.DELIMITER + "APP IS LAUNCHED" + Constants.DELIMITER + "NO DATA"
				+ Constants.DELIMITER + Constants.stepPass;
		appendReportFile(driver, logReport);
		extentReport(driver, logReport);
	}

	

	public void endTest(IOSDriver<MobileElement> driver, String strTestCaseName, String strDevice)
			throws IOException {
		testStepStatus = true;
		String logReport = strTestCaseName + Constants.DELIMITER + strDevice + Constants.DELIMITER
				+ getCurrentDateAndTime() + Constants.DELIMITER + "TEST IS COMPLETED" + Constants.DELIMITER + "NO DATA"
				+ Constants.DELIMITER + Constants.stepPass;
		appendReportFile(driver, logReport);
		extentReport(driver, logReport);
	}

	public synchronized void destroyDriver() {
		try {
			driver.get().quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// The below methods are add by Sarav
	public String getCurrentDateAndTime() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
		return sdf.format(cal.getTime());
	}
	public void waitfor_xpath(String text) {

		WebDriverWait wait = new WebDriverWait((WebDriver) driver, 150);
		By ordersPage = By.xpath("//XCUIElementTypeStaticText[@value='"+text+"']");
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(ordersPage));

	}

	/**
	 * This method will check if the specific element is displayed/exist in the app
	 * 
	 * @throws InterruptedException
	 */
	public boolean isElementPresent(IOSDriver<MobileElement> driver, By by, String objDescription) throws InterruptedException {
		
		if (!testStepStatus) {
			return false;
		}

		boolean elementFound = false;
		int findLoop = 0;

		while (!elementFound) {
			//Thread.sleep(200);
			if (findLoop > Constants.MaxWaitTimeInSec) {
				break;
			}
			System.out.println("***********************************************************************************************************");
			System.out.println("Trying to find the element : " + objDescription + "----> " + findLoop + " ("  + by.toString() +  ")");
			System.out.println("***********************************************************************************************************");
			try {
				if (driver.findElement(by).isDisplayed()) {
					System.out.println("***********************************************************************************************************");
					System.out.println("Found the element : " + objDescription + "----> " + findLoop + " ("  + by.toString() +  ")");
					System.out.println("***********************************************************************************************************");
					return true;
				} else {
					findLoop++;
				}
			} catch (Exception e) {
				findLoop++;
			}
		}
		return false;
	}

	public boolean isElementPresent(IOSDriver<MobileElement> driver, By by, String objDescription, int waitTime) throws InterruptedException {
		
		System.out.println(new Object(){}.getClass().getEnclosingMethod().getName()+ "------->" + testStepStatus);

		if (!testStepStatus) {
			return null != null;
		}

		boolean elementFound = false;
		int findLoop = 0;

		while (!elementFound) {
			//Thread.sleep(200);
			
			if (findLoop > waitTime) {
				break;
			}
			
			System.out.println("*************************************************************************");
			System.out.println("Trying to find the element : " + objDescription + "----> " + findLoop + " ("  + by.toString() +  ")");
			System.out.println("*************************************************************************");
			
			try {
				if (driver.findElement(by).isDisplayed()) {
					return true;
				} else {
					findLoop++;
				}
			} catch (Exception e) {
				findLoop++;
			}
		}
		return false;
	}

//	public MobileElement findElement(IOSDriver<MobileElement> driver, By objIdentifier)
//			throws InterruptedException {
//
//		if (!testStepStatus) {
//			return null;
//		}
//		
//		boolean findEle = isElementPresent(driver, objIdentifier);
//		MobileElement element;
//		
//		if (findEle) {
//			element = driver.findElement(objIdentifier);
//			if (element.isDisplayed() && element.isEnabled()) {
//				return element;
//			}
//		}
//		return null;
//	}
	
	public MobileElement findElement(IOSDriver<MobileElement> driver, By objIdentifier, String objDescription)
			throws InterruptedException {

		if (!testStepStatus) {
			return null;
		}
		
		boolean findEle = isElementPresent(driver, objIdentifier,objDescription);
		MobileElement element;
		
		if (findEle) {
			element = driver.findElement(objIdentifier);
			if (element.isDisplayed() && element.isEnabled()) {
				return element;
			}
		}
		return null;
	}

	public String getObjectText(IOSDriver<MobileElement> driver, String strTestCaseName, String strDevice, String objDescription, By objIdentifier) throws InterruptedException, IOException {

		if (!testStepStatus) {
			return null;
		}

		MobileElement element = findElement(driver, objIdentifier,objDescription);
		String returnText = null;
		
		if (element != null) {
			if(element.isDisplayed() && element.isEnabled()) {
				return element.getText();
			}
		}

		String logReport = strTestCaseName + Constants.DELIMITER + strDevice + Constants.DELIMITER
				+ getCurrentDateAndTime() + Constants.DELIMITER + "getObjectText : Element/Object NOT Displayed--->" + objDescription
				+ Constants.DELIMITER + "NO DATA" + Constants.DELIMITER + Constants.stepFail;
		appendReportFile(driver, logReport);
		extentReport(driver, logReport);
		return returnText;
	}
//	public void verifyPageWithApplitools(IOSDriver<MobileElement> driver, String strTestCaseName,
//			String deviceDetails, String checkWindowTag, String matchLevel) throws InterruptedException, IOException {
//
//		Eyes eyes = new Eyes();
//		String screenshotName = null;
//
//		try {
//			String viewKey = "uPQgRtldCPvkqwC9sfYzsYotHGeXyVL1x7EdQdhrg1c110";
//			eyes.setApiKey("cV6gzWmFHcgrPPV0yynHlXhLWRpURIAhdIS0QrZKimE110");
//			
//			
//			// eyes.setProxy(new ProxySettings("http://..."));
//			// final int URL_BAR_SIZE = 100; // This is the size of the top bar, you may need to adjust it.
//			// eyes.setImageCut(new FixedCutProvider(URL_BAR_SIZE, 0, 0, 0));
//
//			if (matchLevel.equalsIgnoreCase("layout")) {
//				eyes.setMatchLevel(MatchLevel.LAYOUT2);
//			} else {
//				eyes.setMatchLevel(MatchLevel.STRICT);
//			}
//
//			eyes.open(driver, "UPC Application", checkWindowTag + "-" + deviceDetails);
//			eyes.checkWindow(strTestCaseName);
//			TestResults testResults = eyes.close(false);
//			// int mismatches = testResults.getMismatches();
//			String testStatus = null;
//
//			ApplitoolsTestResultsHandler testResultHandler = new ApplitoolsTestResultsHandler(testResults, viewKey);
//
//			String[] names = testResultHandler.getStepsNames();
//			ResultStatus[] results = testResultHandler.calculateStepResults();
//
//			for (int j = 0; j < names.length; j++) {
//				testStatus = results[j].toString();
//				System.out.println("Step Result : " + results[j]);
//			}
//
//			// if (mismatches == 0) {
//			if (testStatus.equalsIgnoreCase("PASSED")) {
//				try {
//					testResultHandler.downloadCurrentImages(Constants.ApplitoolsScreenshotsPath);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				// testResultHandler.downloadBaselineImages(Constants.ApplitoolsScreenshotsPath);
//				String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
//						+ getCurrentDateAndTime() + Constants.DELIMITER
//						+ (" APPLITOOLS VISUAL INSPECTION ---> " + checkWindowTag) + Constants.DELIMITER + "NO DATA"
//						+ Constants.DELIMITER + Constants.stepPass;
//				screenshotName = copyScreenshot(strTestCaseName, deviceDetails, checkWindowTag);
//				appendReportFileApplitools(driver, logReport, screenshotName);
//				extentReportApplitools(driver, logReport, screenshotName);
//			} else if (testStatus.equalsIgnoreCase("FAILED")){
//				testResultHandler.downloadDiffs(Constants.ApplitoolsScreenshotsPath);
//				String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
//						+ getCurrentDateAndTime() + Constants.DELIMITER
//						+ (" APPLITOOLS VISUAL INSPECTION---> " + checkWindowTag) + Constants.DELIMITER + "NO DATA"
//						+ Constants.DELIMITER + Constants.stepFail;
//				screenshotName = copyScreenshot(strTestCaseName, deviceDetails, checkWindowTag);
//				appendReportFileApplitools(driver, logReport, screenshotName);
//				extentReportApplitools(driver, logReport, screenshotName);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			eyes.abortIfNotClosed();
//		}
//		deleteFolder(new File(Constants.ApplitoolsScreenshotsPath));
//	}
//	
//	public String copyScreenshot(String strTestCaseName, String deviceDetails, String checkWindowTag)
//			throws InterruptedException, IOException {
//		String directoryName = Constants.ApplitoolsScreenshotsPath;
//		File directory = new File(directoryName);
//		File directory1 = null;
//		String subDirectory = null;
//		String sourceFileName = null;
//		String destinationFileName = null;
//
//		// get all the files from a directory
//		File[] filesList = directory.listFiles();
//		for (File file : filesList) {
//			if (file.isDirectory()) {
//				directory1 = new File(file.getAbsolutePath());
//				File[] subList = directory1.listFiles();
//				for (File subFile : subList) {
//					subDirectory = subFile.getAbsolutePath();
//				}
//			}
//		}
//		File finalDirectory = new File(subDirectory);
//		File[] fileName = finalDirectory.listFiles();
//
//		sourceFileName = fileName[0].getAbsolutePath();
//		destinationFileName = Constants.ApplitoolsScreenshotsPath + strTestCaseName + "-" + deviceDetails + "-"
//				+ checkWindowTag + ".png";
//
//		System.out.println("sourceFileName : " + sourceFileName);
//		System.out.println("destinationFileName : " + destinationFileName);
//
//		// If the destination file already exist, delete the file and copy the current
//		// file
//		if (new File(destinationFileName).exists()) {
//			if (new File(destinationFileName).isFile()) {
//				System.out.println("Destination File Exist");
//				new File(destinationFileName).delete();
//				Thread.sleep(1000);
//			}
//		}
//		File source = new File(sourceFileName);
//		File target = new File(destinationFileName);
//
//		// Files.copy(source.toPath(), target.toPath(),
//		// StandardCopyOption.REPLACE_EXISTING);
//		copyWithChannels(source, target, true);
//		return destinationFileName;
//	}
//	public void copyWithChannels(File aSourceFile, File aTargetFile, boolean aAppend) throws IOException {
//		FileChannel inChannel = null;
//		FileChannel outChannel = null;
//		FileInputStream inStream = null;
//		FileOutputStream outStream = null;
//		try {
//			try {
//				inStream = new FileInputStream(aSourceFile);
//				inChannel = inStream.getChannel();
//				outStream = new FileOutputStream(aTargetFile, aAppend);
//				outChannel = outStream.getChannel();
//				long bytesTransferred = 0; // defensive loop - there's usually only a single
//				iteration: while (bytesTransferred < inChannel.size()) {
//					bytesTransferred += inChannel.transferTo(0, inChannel.size(), outChannel);
//				}
//			} finally { // being
//				// defensive about closing all channels and streams
//				if (inChannel != null)
//					inChannel.close();
//				if (outChannel != null)
//					outChannel.close();
//				if (inStream != null)
//					inStream.close();
//				if (outStream != null)
//					outStream.close();
//			}
//		} catch (FileNotFoundException ex) {
//		} catch (IOException ex) {
//		}
//	}
//	public void deleteFolder(File folder) throws IOException {
//		// System.out.println("Folder Name: "+folder.toString() );
//
//		File[] files = folder.listFiles();
//		if (files != null) { // some JVMs return null for empty dirs
//			for (File f : files) {
//				if (f.isDirectory()) {
//					// deleteFolder(f);
//					FileUtils.deleteDirectory(f);
//				} else {
//					// f.delete();
//				}
//			}
//		}
//		// folder.delete();
//	}
//	
	public void appendReportFileApplitools(WebDriver driver, String logInfo, String screenName)
			throws IOException {
		// Write Content
		logInfo = logInfo + Constants.DELIMITER + screenName;
		FileWriter writer = new FileWriter(reportTextFile, true);
		BufferedWriter bw = new BufferedWriter(writer);
		PrintWriter pw = new PrintWriter(bw);
		pw.println(logInfo);
		pw.close();
	}
	
	public void extentReportApplitools(WebDriver driver, String logInfo, String screenName) {
		try {
			String[] getValue = logInfo.split("@@@@@");
			String stepDescription = getValue[3];
			String stepValue = getValue[4];
			String stepStatus = getValue[5];

			if (stepValue.equals("NO DATA"))
				stepValue = "";

			if (stepStatus.equalsIgnoreCase("PASS")) {
				if (Constants.ScreenshotsToAllApplitoolsReport) {
					System.out.println("INSIDE SCREENSHOT");
					logger.log(LogStatus.PASS, stepDescription, logger.addScreenCapture(screenName));
				} else {
					System.out.println("INSIDE NO SCREENSHOT");
					logger.log(LogStatus.PASS, stepDescription, stepValue);
				}
			} else {
				logger.log(LogStatus.FAIL, stepDescription, logger.addScreenCapture(screenName));
			}
		} catch (Exception e) {
		}
	}
	public void clickLink(IOSDriver<MobileElement> driver, String strTestCaseName, String deviceDetails,
			String objDescription, By objIdentifier) throws IOException {

		if (!testStepStatus) {
			return;
		}

		try {
			MobileElement findEle = findElement(driver, objIdentifier,objDescription);
			if (findEle != null) {
				findEle.click();
				String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
						+ getCurrentDateAndTime() + Constants.DELIMITER + "Click Link--->" + objDescription
						+ Constants.DELIMITER + "NO DATA" + Constants.DELIMITER + Constants.stepPass;
				appendReportFile(driver, logReport);
				extentReport(driver, logReport);
			} else {
				String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
						+ getCurrentDateAndTime() + Constants.DELIMITER + "Did Not Click Link--->" + objDescription
						+ Constants.DELIMITER + "NO DATA" + Constants.DELIMITER + Constants.stepFail;
				appendReportFile(driver, logReport);
				extentReport(driver, logReport);
			}
		} catch (Exception e) {
			e.printStackTrace();
			String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER + "Did Not Click Link--->" + objDescription
					+ Constants.DELIMITER + "NO DATA" + Constants.DELIMITER + Constants.stepFail;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);
			abortTest(driver);
		}
	}

	
	public void setValue_donothidekeyboard(IOSDriver<MobileElement> driver, String strTestCaseName, String deviceDetails,
			String objDescription, By objIdentifier, String value) throws IOException {
		
		
		// System.out.println("Inisde the Method - setValue");
		
		if (!testStepStatus) {
			return;
		}

		try {
			MobileElement findEle = findElement(driver, objIdentifier, value);
			if (findEle != null) {
				findEle.clear();
				findEle.sendKeys(value);
				findEle.click();
//				try {
//					driver.hideKeyboard();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
				String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
						+ getCurrentDateAndTime() + Constants.DELIMITER + "Set Value--->" + objDescription
						+ Constants.DELIMITER + value + Constants.DELIMITER + Constants.stepPass;
				appendReportFile(driver, logReport);
				extentReport(driver, logReport);
				

				
			} else {
				String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
						+ getCurrentDateAndTime() + Constants.DELIMITER + "Did Not  Set Value--->" + objDescription
						+ Constants.DELIMITER + value + Constants.DELIMITER + Constants.stepFail;
				appendReportFile(driver, logReport);
				extentReport(driver, logReport);
			}
		} catch (Exception e) {
			e.printStackTrace();
			String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER + "Did Not  Set Value--->" + objDescription
					+ Constants.DELIMITER + value + Constants.DELIMITER + Constants.stepFail;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);
			abortTest(driver);
		}
	}
	
	public boolean swipeAndVerifyElementIsNotDisplayedForPaginationWithType(IOSDriver<MobileElement> driver,
			String strTestCaseName, String deviceDetails, String objDescription, String objIdentifier, String type,
			String swipeDirection) throws IOException, InterruptedException {

		if (!testStepStatus) {
			return false;
		}

		int swipeCount = 0;
		int initialX = 0;
		int initialY = 0;
		int finalX = 0;
		int finalY = 0;
		boolean endOfScroll = false;
		boolean returnValue = false;
		boolean elementFound = false;
		MobileElement element;
		List<MobileElement> objElement = null;
		int objCount = 0;
		int startX, endX, startY, endY;

		while (!endOfScroll) {
			try {
				swipeCount++;
				if (type == "id") {
					objElement = driver.findElementsById(objIdentifier);
				} else if (type == "xpath") {
					objElement = driver.findElementsByXPath(objIdentifier);
				}

				objCount = objElement.size();

				if (swipeCount > Constants.MaxSwipeForAPageWithoutElement) {
					endOfScroll = true;
					if (objCount < 0) {
						elementFound = false;
						break;
					}
				}
				else {
					// Verify that if the end of scroll of the page
					List<MobileElement> elements = driver.findElements(By.xpath("XCUIElementTypeStaticText"));
					System.out.println("Total Elements : " + elements.size());
					java.util.Iterator<MobileElement> i = elements.iterator();
					while (i.hasNext()) {
						element = i.next();
						initialX = element.getLocation().getX();
						initialY = element.getLocation().getY();
					}
					if (initialX == finalX && initialY == finalY) {
						endOfScroll = true;
						break;
					} else {
						finalX = initialX;
						finalY = initialY;
					}
				}
				if (swipeDirection.equalsIgnoreCase("up")) {
					Dimension size = driver.manage().window().getSize();
					startX = endX = size.width / 2;
					startY = (int) (size.height * 0.80);
					endY = (int) (size.height * 0.30);
					driver.swipe(startX, startY, endX, endY, 1000);
				} else if (swipeDirection.equalsIgnoreCase("down")) {
					Dimension size = driver.manage().window().getSize();
					startX = endX = size.width / 2;
					startY = (int) (size.height * 0.50);
					endY = (int) (size.height * 0.60);
					driver.swipe(startX, startY, endX, endY, 1000);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (elementFound) {
			String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER + "Verification: Element/Object Displayed--->"
					+ objDescription + Constants.DELIMITER + "NO DATA" + Constants.DELIMITER + Constants.stepFail;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);
			returnValue = false;
		} else {
			String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER + "Verification: Element/Object NOT Displayed--->"
					+ objDescription + Constants.DELIMITER + "NO DATA" + Constants.DELIMITER + Constants.stepPass;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);
			returnValue = true;
		}

		return returnValue;
	}
	
	//This method is used to swipe and verify the presence of element for the pages with pagination
	public boolean swipeAndVerifyElementIsDisplayedForPaginationWithType(IOSDriver<MobileElement> driver,
			String strTestCaseName, String deviceDetails, String objDescription, String objIdentifier, String type,
			String swipeDirection) throws IOException, InterruptedException {

		if (!testStepStatus) {
			return false;
		}

		int swipeCount = 0;
		int initialX = 0;
		int initialY = 0;
		int finalX = 0;
		int finalY = 0;
		boolean endOfScroll = false;
		boolean returnValue = false;
		boolean elementFound = false;
		MobileElement element;
		List<MobileElement> objElement = null;
		int objCount = 0;
		int startX, endX, startY, endY;

		while (!endOfScroll) {
			try {
				swipeCount++;
				if (type == "id") {
					objElement = driver.findElementsById(objIdentifier);
				} else if (type == "xpath") {
					objElement = driver.findElementsByXPath(objIdentifier);
				}

				objCount = objElement.size();

				if (swipeCount > Constants.MaxSwipeForAPage) {
					endOfScroll = true;
				}
				if (objCount > 0) {
					elementFound = true;
					break;
				} else {
					// Verify that if the end of scroll of the page
//					List<MobileElement> elements = driver.findElements(By.className("android.widget.TextView"));
					List<MobileElement> elements = driver.findElements(By.xpath("XCUIElementTypeStaticText"));
					
					System.out.println("Total Elements : " + elements.size());
					java.util.Iterator<MobileElement> i = elements.iterator();
					while (i.hasNext()) {
						element = i.next();
						initialX = element.getLocation().getX();
						System.out.println("initialX "+ initialX);
						initialY = element.getLocation().getY();
						System.out.println("initialY "+ initialY);
					}
					if (initialX == finalX && initialY == finalY) {
						endOfScroll = true;
						break;
					} else {
						finalX = initialX;
						finalY = initialY;
					}
				}
				if (swipeDirection.equalsIgnoreCase("up")) {
					Dimension size = driver.manage().window().getSize();
					startX = endX = size.width / 2;
					startY = (int) (size.height * 0.80);
					endY = (int) (size.height * 0.30);
					driver.swipe(startX, startY, endX, endY, 1000);
				} else if (swipeDirection.equalsIgnoreCase("down")) {
					Dimension size = driver.manage().window().getSize();
					startX = endX = size.width / 2;
					startY = (int) (size.height * 0.50);
					endY = (int) (size.height * 0.60);
					driver.swipe(startX, startY, endX, endY, 1000);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (elementFound) {
			String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER + "Verification: Element/Object Displayed--->"
					+ objDescription + Constants.DELIMITER + "NO DATA" + Constants.DELIMITER + Constants.stepPass;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);
			returnValue = true;
		} else {
			String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER + "Verification: Element/Object NOT Displayed--->"
					+ objDescription + Constants.DELIMITER + "NO DATA" + Constants.DELIMITER + Constants.stepFail;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);
			returnValue = false;
		}

		return returnValue;
	}
	
	public void clickButton(IOSDriver<MobileElement> driver, String strTestCaseName, String deviceDetails,
			String objDescription, By objIdentifier) throws IOException {

		if (!testStepStatus) {
			return;
		}

		try {
			
			MobileElement findEle = findElement(driver, objIdentifier,objDescription);
			if (findEle != null) {
				findEle.click();
				String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
						+ getCurrentDateAndTime() + Constants.DELIMITER + "Click Button--->" + objDescription
						+ Constants.DELIMITER + "NO DATA" + Constants.DELIMITER + Constants.stepPass;
				appendReportFile(driver, logReport);
				extentReport(driver, logReport);
			} else {
				String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
						+ getCurrentDateAndTime() + Constants.DELIMITER + "Did Not Click Button--->" + objDescription
						+ Constants.DELIMITER + "NO DATA" + Constants.DELIMITER + Constants.stepFail;
				appendReportFile(driver, logReport);
				extentReport(driver, logReport);
			}
		} catch (Exception e) {
			e.printStackTrace();
			String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER + "Did Not Click Button--->" + objDescription
					+ Constants.DELIMITER + "NO DATA" + Constants.DELIMITER + Constants.stepFail;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);
			abortTest(driver);
		}
	}

	public void clickImage(IOSDriver<MobileElement> driver, String strTestCaseName, String deviceDetails,
			String objDescription, By objIdentifier) throws IOException {

		if (!testStepStatus) {
			return;
		}

		try {
			MobileElement findEle = findElement(driver, objIdentifier,objDescription);
			if (findEle != null) {
				findEle.click();
				String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
						+ getCurrentDateAndTime() + Constants.DELIMITER + "Click Image--->" + objDescription
						+ Constants.DELIMITER + "NO DATA" + Constants.DELIMITER + Constants.stepPass;
				appendReportFile(driver, logReport);
				extentReport(driver, logReport);
			} else {
				String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
						+ getCurrentDateAndTime() + Constants.DELIMITER + "Did Not  Click Image--->" + objDescription
						+ Constants.DELIMITER + "NO DATA" + Constants.DELIMITER + Constants.stepFail;
				appendReportFile(driver, logReport);
				extentReport(driver, logReport);
			}
		} catch (Exception e) {
			e.printStackTrace();
			String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER + "Did Not  Click Image--->" + objDescription
					+ Constants.DELIMITER + "NO DATA" + Constants.DELIMITER + Constants.stepFail;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);
			abortTest(driver);
		}
	}

	public void selectValue(IOSDriver<MobileElement> driver, String strTestCaseName, String deviceDetails,
			String objDescription, By objIdentifier, String value) throws IOException {

		if (!testStepStatus) {
			return;
		}

		try {
			MobileElement findEle = findElement(driver, objIdentifier,objDescription);
			if (findEle != null) {
				Select oSelection = new Select(findEle);
				List<WebElement> allValues = oSelection.getOptions();

				for (int i = 0; i < allValues.size(); i++) {
					String listValue = allValues.get(i).getText();
					if (listValue.equalsIgnoreCase(value))
						findEle.sendKeys(listValue);
					String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
							+ getCurrentDateAndTime() + Constants.DELIMITER + "Select Value--->" + objDescription
							+ Constants.DELIMITER + value + Constants.DELIMITER + Constants.stepPass;
					appendReportFile(driver, logReport);
					extentReport(driver, logReport);
					break;
				}
			} else {
				String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
						+ getCurrentDateAndTime() + Constants.DELIMITER + "Did Not Select Value--->" + objDescription
						+ Constants.DELIMITER + value + Constants.DELIMITER + Constants.stepFail;
				appendReportFile(driver, logReport);
				extentReport(driver, logReport);
			}
		} catch (Exception e) {
			e.printStackTrace();
			String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER + "Did Not Select Value--->" + objDescription
					+ Constants.DELIMITER + value + Constants.DELIMITER + Constants.stepFail;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);
			abortTest(driver);
		}
	}

	public void selectCheckbox(IOSDriver<MobileElement> driver, String strTestCaseName, String deviceDetails,
			String objDescription, By objIdentifier, String value) throws IOException {

		if (!testStepStatus) {
			return;
		}

		try {
			MobileElement findEle = findElement(driver, objIdentifier,objDescription);
			if (findEle != null) {
				if (value.equalsIgnoreCase("off")) {
					if (findEle.isSelected())
						findEle.click();
					String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
							+ getCurrentDateAndTime() + Constants.DELIMITER + "Select Checkbox--->" + objDescription
							+ Constants.DELIMITER + value + Constants.DELIMITER + Constants.stepPass;
					appendReportFile(driver, logReport);
					extentReport(driver, logReport);
				} else if (value.equalsIgnoreCase("on")) {
					if (!findEle.isSelected())
						findEle.click();
					String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
							+ getCurrentDateAndTime() + Constants.DELIMITER + "Select Checkbox--->" + objDescription
							+ Constants.DELIMITER + value + Constants.DELIMITER + Constants.stepPass;
					appendReportFile(driver, logReport);
					extentReport(driver, logReport);
				}
			} else {
				String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
						+ getCurrentDateAndTime() + Constants.DELIMITER + "Did Not Select Checkbox--->" + objDescription
						+ Constants.DELIMITER + value + Constants.DELIMITER + Constants.stepFail;
				appendReportFile(driver, logReport);
				extentReport(driver, logReport);
			}
		} catch (Exception e) {
			e.printStackTrace();
			String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER + "Did Not Select Checkbox--->" + objDescription
					+ Constants.DELIMITER + value + Constants.DELIMITER + Constants.stepFail;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);
			abortTest(driver);
		}
	}

	public void selectRadioButton(IOSDriver<MobileElement> driver, String strTestCaseName, String deviceDetails,
			String objDescription, By objIdentifier, String value) throws IOException {

		if (!testStepStatus) {
			return;
		}

		try {
			MobileElement findEle = findElement(driver, objIdentifier,objDescription);
			if (findEle != null) {
				findEle.click();
				String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
						+ getCurrentDateAndTime() + Constants.DELIMITER + "Select RadioButton--->" + objDescription
						+ Constants.DELIMITER + value + Constants.DELIMITER + Constants.stepPass;
				appendReportFile(driver, logReport);
				extentReport(driver, logReport);
			} else {
				String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
						+ getCurrentDateAndTime() + Constants.DELIMITER + "Did Not  Select RadioButton--->"
						+ objDescription + Constants.DELIMITER + value + Constants.DELIMITER + Constants.stepFail;
				appendReportFile(driver, logReport);
				extentReport(driver, logReport);
			}
		} catch (Exception e) {
			e.printStackTrace();
			String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER + "Did Not  Select RadioButton--->"
					+ objDescription + Constants.DELIMITER + value + Constants.DELIMITER + Constants.stepFail;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);
			abortTest(driver);
		}
	}

	public void setValue(IOSDriver<MobileElement> driver, String strTestCaseName, String deviceDetails,
			String objDescription, By objIdentifier, String value) throws IOException {
		// System.out.println("Inisde the Method - setValue");
		
		if (!testStepStatus) {
			return;
		}

		try {
			MobileElement findEle = findElement(driver, objIdentifier,objDescription);
			if (findEle != null) {
				value = value.replace("\n", " ").replace("\r", " ").trim();
//				ClearText(findEle,driver);
				findEle.clear();
				findEle.sendKeys(value);
				
				String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
						+ getCurrentDateAndTime() + Constants.DELIMITER + "Set Value--->" + objDescription
						+ Constants.DELIMITER + value + Constants.DELIMITER + Constants.stepPass;
				appendReportFile(driver, logReport);
				extentReport(driver, logReport);
			} else {
				String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
						+ getCurrentDateAndTime() + Constants.DELIMITER + "Did Not  Set Value--->" + objDescription
						+ Constants.DELIMITER + value + Constants.DELIMITER + Constants.stepFail;
				appendReportFile(driver, logReport);
				extentReport(driver, logReport);
			}
		} catch (Exception e) {
			e.printStackTrace();
			String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER + "Did Not  Set Value--->" + objDescription
					+ Constants.DELIMITER + value + Constants.DELIMITER + Constants.stepFail;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);
			abortTest(driver);
		}
	}
	
	
	
	
//	private void CleatText(MobileElement ele) {
//				
//		int stringLength = ele.getText().length();
//		
//		for (int i=0; i<stringLength;i++) {
//			driver.sendKeyEvent(22);//MOVE THE CURSOR TO RIGHT
//		}
//		
//		for (int i=0; i<stringLength;i++) {
//			driver.sendKeyEvent(67);//MOVE THE CURSOR TO RIGHT
//		}
//	}
	
	@SuppressWarnings("deprecation")
	public void clearValue(IOSDriver<MobileElement> driver, By objIdentifier, String objDescription) {
		try {
			MobileElement ele = findElement(driver, objIdentifier,objDescription);
			int count = 0;
			while(!ele.getText().isEmpty()) {
				try {
				count++;
	//			TouchAction touch = new TouchAction(driver);
	//			touch.longPress(ele);
	//			ele.click();
	//			ele.sendKeys("");
	//			ele.setValue("");
				if(count==1) {
					driver.tap(1, ele.getLocation().x+ele.getSize().width-10, ele.getLocation().y + ele.getSize().height-10, 100);
				}
				driver.getKeyboard().sendKeys(Keys.DELETE);		
				if(count > 100) {
					break;
				}
			
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clearValue(IOSDriver<MobileElement> driver, String strTestCaseName, String deviceDetails,
			String objDescription, By objIdentifier) throws IOException {
		
		if (!testStepStatus) {
			return;
		}

		try {
			MobileElement findEle = findElement(driver, objIdentifier,objDescription);
			if (findEle != null) {
				findEle.sendKeys("");
				try {
					driver.hideKeyboard();
				} catch (Exception e) {
					e.printStackTrace();
				}
				String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
						+ getCurrentDateAndTime() + Constants.DELIMITER + "Clear Value--->" + objDescription
						+ Constants.DELIMITER + "" + Constants.DELIMITER + Constants.stepPass;
				appendReportFile(driver, logReport);
				extentReport(driver, logReport);
			} else {
				String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
						+ getCurrentDateAndTime() + Constants.DELIMITER + "Did Not  Set Value--->" + objDescription
						+ Constants.DELIMITER + "" + Constants.DELIMITER + Constants.stepFail;
				appendReportFile(driver, logReport);
				extentReport(driver, logReport);
			}
		} catch (Exception e) {
			e.printStackTrace();
			String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER + "Did Not  Set Value--->" + objDescription
					+ Constants.DELIMITER + "" + Constants.DELIMITER + Constants.stepFail;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);
			abortTest(driver);
		}
	}
	
	public void reportLogin(IOSDriver<MobileElement> driver, String strTestCaseName, String deviceDetails, String username, String password) throws IOException {
		String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
				+ getCurrentDateAndTime() + Constants.DELIMITER + "Set Value--->" + "User Name"
				+ Constants.DELIMITER + username + Constants.DELIMITER + Constants.stepPass;
		appendReportFile(driver, logReport);
		extentReport(driver, logReport);
		
		String logReport1 = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
				+ getCurrentDateAndTime() + Constants.DELIMITER + "Set Value--->" + "Password"
				+ Constants.DELIMITER + password + Constants.DELIMITER + Constants.stepPass;
		appendReportFile(driver, logReport1);
		extentReport(driver, logReport1);
		
		String logReport2 = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
				+ getCurrentDateAndTime() + Constants.DELIMITER + "Click Button--->" + "Login"
				+ Constants.DELIMITER + "NO DATA" + Constants.DELIMITER + Constants.stepPass;
		appendReportFile(driver, logReport2);
		extentReport(driver, logReport2);
		
		String logReport3 = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
				+ getCurrentDateAndTime() + Constants.DELIMITER + "LOGIN SUCCESS" + Constants.DELIMITER + "NO DATA"
				+ Constants.DELIMITER + Constants.stepPass;
		appendReportFile(driver, logReport3);
		extentReport(driver, logReport3);
	}
	
	public boolean verifyPageHeader(IOSDriver<MobileElement> driver, String strTestCaseName,
			String strDevice, String objDescription, By objIdentifier) throws IOException {

		if (!testStepStatus) {
			return null != null;
		}
		
		boolean returnValue = false;
		
		try {
			MobileElement findEle = findElement(driver, objIdentifier,objDescription);

			List<MobileElement> objElement = driver.findElements(objIdentifier);
			int objCount = objElement.size();

			if (objCount > 0) {
				String logReport = strTestCaseName + Constants.DELIMITER + strDevice + Constants.DELIMITER
						+ getCurrentDateAndTime() + Constants.DELIMITER + "Verification: Page Is Displayed--->"
						+ objDescription + Constants.DELIMITER + "NO DATA" + Constants.DELIMITER + Constants.stepPass;
				appendReportFile(driver, logReport);
				extentReport(driver, logReport);
				returnValue = true;
			} else {
				String logReport = strTestCaseName + Constants.DELIMITER + strDevice + Constants.DELIMITER
						+ getCurrentDateAndTime() + Constants.DELIMITER
						+ "Verification: Page Is NOT Displayed--->" + objDescription + Constants.DELIMITER
						+ "NO DATA" + Constants.DELIMITER + Constants.stepFail;
				appendReportFile(driver, logReport);
				extentReport(driver, logReport);
				returnValue = false;
				driver.quit();
			}
		} catch (Exception e) {
			String logReport = strTestCaseName + Constants.DELIMITER + strDevice + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER + "Verification: Page Is NOT Displayed--->"
					+ objDescription + Constants.DELIMITER + "NO DATA" + Constants.DELIMITER + Constants.stepFail;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);
			e.printStackTrace();
			returnValue = false;
			driver.quit();
		}
		return returnValue;
	}

	public boolean verifyElementIsDisplayed(IOSDriver<MobileElement> driver, String strTestCaseName,
			String deviceDetails, String objDescription, By objIdentifier) throws IOException {

		if (!testStepStatus) {
			return null != null;
		}
		
		boolean returnValue = false;

		try {
			MobileElement findEle = findElement(driver, objIdentifier,objDescription);

			List<MobileElement> objElement = driver.findElements(objIdentifier);
			int objCount = objElement.size();

			if (objCount > 0) {
				String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
						+ getCurrentDateAndTime() + Constants.DELIMITER + "Verification: Element/Object Displayed--->"
						+ objDescription + Constants.DELIMITER + "NO DATA" + Constants.DELIMITER + Constants.stepPass;
				appendReportFile(driver, logReport);
				extentReport(driver, logReport);
				returnValue = true;
			} else {
				String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
						+ getCurrentDateAndTime() + Constants.DELIMITER
						+ "Verification: Element/Object NOT Displayed--->" + objDescription + Constants.DELIMITER
						+ "NO DATA" + Constants.DELIMITER + Constants.stepFail;
				appendReportFile(driver, logReport);
				extentReport(driver, logReport);
				returnValue = false;
			}
		} catch (Exception e) {
			String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER + "Verification: Element/Object NOT Displayed--->"
					+ objDescription + Constants.DELIMITER + "NO DATA" + Constants.DELIMITER + Constants.stepFail;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);
			e.printStackTrace();
			returnValue = false;
		}
		return returnValue;
	}
	
	public boolean swipeAndVerifyElementIsDisplayed(IOSDriver<MobileElement> driver, String strTestCaseName,
			String deviceDetails, String objDescription, By objIdentifier, String swipeDirection) throws IOException, InterruptedException {

		if (!testStepStatus) {
			return false;
		}
		
		int swipeCount=0;
		int initialX = 0;
		int initialY = 0;
		int finalX = 0;
		int finalY = 0;
		boolean endOfScroll = false;
		boolean returnValue = false;
		boolean elementFound=false;
		MobileElement element;
		List<MobileElement> objElement;
		int objCount=0;
		int startX, endX, startY, endY;
		
		while (!endOfScroll) {
			try {
				swipeCount++;
				objElement = driver.findElements(objIdentifier);
				objCount = objElement.size();
				if(swipeCount>Constants.MaxSwipeForAPage) {
					endOfScroll=true;
					break;
				}
				if (objCount > 0) {
					System.out.println(driver.findElement(objIdentifier).getLocation().getX());
					System.out.println(driver.findElement(objIdentifier).getLocation().getY());
					if(driver.findElement(objIdentifier).getLocation().getX()>0) {
						if(driver.findElement(objIdentifier).getLocation().getY()>0) {
							elementFound=true;
							endOfScroll=true;
							break;
						}
					}
					
				} else {
					List<MobileElement> elements = driver.findElements(By.className("XCUIElementTypeStaticText"));
					System.out.println("Total Elements : " + elements.size());
					java.util.Iterator<MobileElement> i = elements.iterator();
					while (i.hasNext()) {
						element = i.next();
						initialX = element.getLocation().getX();
						initialY = element.getLocation().getY();
					}
					if (initialX == finalX && initialY == finalY) {
						endOfScroll = true;
						break;
					} else {
						finalX = initialX;
						finalY = initialY;
					}
				}
				
				if (swipeDirection.equalsIgnoreCase("up")) {
					Dimension size = driver.manage().window().getSize();
					startX = endX = size.width / 2;
					startY = (int) (size.height * 0.50);
					endY = (int) (size.height * 0.40);
					driver.swipe(startX, startY, endX, endY, 1000);
				}else if (swipeDirection.equalsIgnoreCase("down")) {
					Dimension size = driver.manage().window().getSize();
					startX = endX = size.width / 2;
					startY = (int) (size.height * 0.50);
					endY = (int) (size.height * 0.60);
					driver.swipe(startX, startY, endX, endY, 1000);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (elementFound) {
			if (swipeDirection.equalsIgnoreCase("up")) {
				Dimension size = driver.manage().window().getSize();
				startX = endX = size.width / 2;
				startY = (int) (size.height * 0.50);
				endY = (int) (size.height * 0.40);
				driver.swipe(startX, startY, endX, endY, 1000);
			}else if (swipeDirection.equalsIgnoreCase("down")) {
				Dimension size = driver.manage().window().getSize();
				startX = endX = size.width / 2;
				startY = (int) (size.height * 0.50);
				endY = (int) (size.height * 0.60);
				driver.swipe(startX, startY, endX, endY, 1000);
			}
		}
		if (elementFound) {
			String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER + "Verification: Element/Object Displayed--->"
					+ objDescription + Constants.DELIMITER + "NO DATA" + Constants.DELIMITER + Constants.stepPass;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);
			returnValue = true;
		} else {
			String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER
					+ "Verification: Element/Object NOT Displayed--->" + objDescription + Constants.DELIMITER
					+ "NO DATA" + Constants.DELIMITER + Constants.stepFail;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);
			returnValue = false;
		}
	
		return returnValue;
	}

	public boolean verifyElementIsNotDisplayed(IOSDriver<MobileElement> driver, String strTestCaseName,
			String deviceDetails, String objDescription, By objIdentifier) throws IOException {

		if (!testStepStatus) {
			return null != null;
		}

		boolean returnValue = false;
		try {
			// MobileElement findEle = findElement(driver, objIdentifier);
			//Thread.sleep(10000);
			List<MobileElement> objElement = driver.findElements(objIdentifier);
			int objCount = objElement.size();

			if (objCount == 0) {
				String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
						+ getCurrentDateAndTime() + Constants.DELIMITER
						+ "Verification: Element/Object Not Displayed--->" + objDescription + Constants.DELIMITER
						+ "NO DATA" + Constants.DELIMITER + Constants.stepPass;
				appendReportFile(driver, logReport);
				extentReport(driver, logReport);
				returnValue = true;
			} else {
				String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
						+ getCurrentDateAndTime() + Constants.DELIMITER
						+ "Verification: Element/Object Is Displayed--->" + objDescription + Constants.DELIMITER
						+ "NO DATA" + Constants.DELIMITER + Constants.stepFail;
				appendReportFile(driver, logReport);
				extentReport(driver, logReport);
				returnValue = false;
			}
		} catch (Exception e) {
			String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER + "Verification: Element/Object  Not Displayed--->"
					+ objDescription + Constants.DELIMITER + "NO DATA" + Constants.DELIMITER + Constants.stepPass;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);
			e.printStackTrace();
			returnValue = false;
		}
		return returnValue;
	}

	public boolean verifyElementIsNotDisplayedforNextButton(IOSDriver<MobileElement> driver, String strTestCaseName,
			String deviceDetails, String objDescription, By objIdentifier) throws IOException {

		if (!testStepStatus) {
			return null != null;
		}

		boolean returnValue = false;
		try {
			// MobileElement findEle = findElement(driver, objIdentifier);
			//Thread.sleep(10000);
			List<MobileElement> objElement = driver.findElements(objIdentifier);
			int objCount = objElement.size();

			if (objCount == 1) {
				String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
						+ getCurrentDateAndTime() + Constants.DELIMITER
						+ "Verification: Element/Object Not Displayed--->" + objDescription + Constants.DELIMITER
						+ "NO DATA" + Constants.DELIMITER + Constants.stepPass;
				appendReportFile(driver, logReport);
				extentReport(driver, logReport);
				returnValue = true;
			} else {
				String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
						+ getCurrentDateAndTime() + Constants.DELIMITER
						+ "Verification: Element/Object Is Displayed--->" + objDescription + Constants.DELIMITER
						+ "NO DATA" + Constants.DELIMITER + Constants.stepFail;
				appendReportFile(driver, logReport);
				extentReport(driver, logReport);
				returnValue = false;
			}
		} catch (Exception e) {
			String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER + "Verification: Element/Object  Not Displayed--->"
					+ objDescription + Constants.DELIMITER + "NO DATA" + Constants.DELIMITER + Constants.stepPass;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);
			e.printStackTrace();
			returnValue = false;
		}
		return returnValue;
	}

	
	
	public void quitDriver() {
		if (getWebDriver() != null) {
			((WebDriver) driver).quit();
			driver = null;
		}
	}

	/**
	 * @return the {@link WebDriver} for the current thread
	 */
	public IOSDriver<MobileElement> getWebDriver() {
		return driver.get();
	}

	@SuppressWarnings("unchecked")
	static void setWebDriver(WebDriver driver) {
		((ThreadLocal<WebDriver>) driver).set(driver);
	}

	public String getScreenshotName() {
		return Constants.ScreenshotsPath + getCurrentDateAndTime() + ".jpg";
	}

	public void appendReportFile(IOSDriver<MobileElement> driver2, String logInfo) throws IOException {
		// Write Content
		
		try {
			new Awake().avoidScreenLock();
		} catch (AWTException e) {
			e.printStackTrace();
		}

		if(logInfo.contains("Click Button") ||logInfo.contains("Click Link")  ||logInfo.contains("Set Value") ||logInfo.contains("Click Image")) {
			if (logInfo.contains("FAIL")) {
				testStepStatus = false;
			}
		}
	
		if (logInfo.contains("FAIL")) {
			FailStepCount++;
		}
		
		System.out.println("testStepStatus : " + testStepStatus);
		System.out.println(logInfo);
		
		screenshotName = getScreenshotName();
		
		if(Constants.TakeScreenShotsForAllSteps) {
		  captureScreenShot(driver2, screenshotName);
			logInfo = logInfo + Constants.DELIMITER + screenshotName;

		}else if (logInfo.contains("FAIL"))  {
			captureScreenShot(driver2, screenshotName);
			logInfo = logInfo + Constants.DELIMITER + screenshotName;

		}else {
			logInfo = logInfo + Constants.DELIMITER + screenshotName;

		}
		FileWriter writer = new FileWriter(reportTextFile, true);
		BufferedWriter bw = new BufferedWriter(writer);
		PrintWriter pw = new PrintWriter(bw);
		pw.println(logInfo);
		pw.close();
	}
	
//	public void extentReport(IOSDriver<MobileElement> driver, String logInfo) {
//		try {
//
//			if(logInfo.contains("Click Button") ||logInfo.contains("Click Link")  ||logInfo.contains("Set Value")) {
//				if (logInfo.contains("FAIL")) {
//					testStepStatus = false;
//				}
//			}
//
//			// image = logger.addScreenCapture(screenshotName);
//			String[] getValue = logInfo.split("@@@@@");
//			// String testCaseName = getValue[0];
//			// String deviceName = getValue[1];
//			// String DateTime = getValue[2];
//			String stepDescription = getValue[3];
//			String stepValue = getValue[4];
//			String stepStatus = getValue[5];
//			// String screenshot = getValue[6];
//
//			if (stepValue.equals("NO DATA"))
//				stepValue = "";
//
//			if (stepStatus.equalsIgnoreCase("PASS")) {
//				if (Constants.ScreenshotsToAllStepsInExtentReport) {
//					if (stepValue !="") {
//					logger.log(LogStatus.PASS,  stepDescription + "-----> " + stepValue, logger.addScreenCapture(screenshotName));
//					}else {
//						logger.log(LogStatus.PASS,  stepDescription, logger.addScreenCapture(screenshotName));
//					}
//				} else {
//						logger.log(LogStatus.PASS, stepDescription, stepValue);
//				}
//			} else if (stepStatus.equalsIgnoreCase("FAIL")) {
//				if (stepValue !="") {
//					logger.log(LogStatus.FAIL,  stepDescription + "-----> " + stepValue, logger.addScreenCapture(screenshotName));
//				}else {
//					logger.log(LogStatus.FAIL,  stepDescription, logger.addScreenCapture(screenshotName));
//				}
//			} else {
//					logger.log(LogStatus.INFO, stepDescription, stepValue);
//			}
//		} catch (Exception e) {
//		}
//	}

	public void extentReport(IOSDriver<MobileElement> driver, String logInfo) {
		try {

			if(logInfo.contains("Click Button") ||logInfo.contains("Click Link")  ||logInfo.contains("Set Value") ||logInfo.contains("Click Image")) {
				if (logInfo.contains("FAIL")) {
					testStepStatus = false;
				}
			}

			// image = logger.addScreenCapture(screenshotName);
			String[] getValue = logInfo.split("@@@@@");
			// String testCaseName = getValue[0];
			// String deviceName = getValue[1];
			// String DateTime = getValue[2];
			String stepDescription = getValue[3];
			String stepValue = getValue[4];
			String stepStatus = getValue[5];
			// String screenshot = getValue[6];

			if (stepValue.equals("NO DATA"))
				stepValue = "";

			if (stepStatus.equalsIgnoreCase("PASS")) {
				if (Constants.SCREENSHOTS_TO_ALL_STEPS_IN_EXTENT_REPORT) {
					if (stepValue !="") {
					logger.log(LogStatus.PASS,  stepDescription + "-----> " + stepValue, logger.addBase64ScreenShot("data:image/png;base64," + base64String));
					}else {
						logger.log(LogStatus.PASS,  stepDescription, logger.addBase64ScreenShot("data:image/png;base64," + base64String));
					}
				} else {
						logger.log(LogStatus.PASS, stepDescription, stepValue);
				}
			} else if (stepStatus.equalsIgnoreCase("FAIL")) {
				if (stepValue !="") {
					logger.log(LogStatus.FAIL, stepDescription + "-----> " + stepValue, logger.addBase64ScreenShot("data:image/png;base64," + base64String));
				} else {
					logger.log(LogStatus.FAIL, stepDescription, logger.addBase64ScreenShot("data:image/png;base64," + base64String));
				}
			} else {
					logger.log(LogStatus.INFO, stepDescription,stepValue);
			}
		} catch (Exception e) {
		}
	}

	public void captureScreenShot(IOSDriver<MobileElement> driver, String fileName) {
		try {
			// Take screenshot and store as a file format
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			// now copy the screenshot to desired location using copyFile method //
			FileUtils.copyFile(src, new File(fileName));
			//Capture the image as base64 image
			base64String = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
//			System.out.println("base64String : " + base64String);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}


//	public void captureScreenShot(IOSDriver<MobileElement> driver, String fileName) {
//		try {
//			// Take screenshot and store as a file format
//			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//			// now copy the screenshot to desired location using copyFile method //
//			FileUtils.copyFile(src, new File(fileName));
//		} catch (IOException e) {
//			System.out.println(e.getMessage());
//		}
//	}

	
	public void closeReportFile(String logInfo) throws IOException {
		// Write Content
		FileWriter writer = new FileWriter(reportTextFile);
		writer.close();
	}

	public String createReportFile(String strTestCaseName, String fileType) {

		String returnFileName = null;

		reportFileName = strTestCaseName + "_" + getCurrentDateAndTime();

		if (fileType.equalsIgnoreCase("txt")) {
			try {
				reportTextFileName = Constants.TextReportPath + reportFileName + ".txt";
				returnFileName = reportTextFileName;
				reportTextFile = new File(reportTextFileName);

				if (reportTextFile.createNewFile()) {
					System.out.println("File is created!");
				} else {
					System.out.println("File already exists.");
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if (fileType.equalsIgnoreCase("html")) {
			try {
				reportHtmlFileName = Constants.HtmlReportPath + reportFileName + ".html";
				returnFileName = reportHtmlFileName;
				reportHtmlFile = new File(reportTextFileName);

				if (reportHtmlFile.createNewFile()) {
					System.out.println("File is created!");
				} else {
					System.out.println("File already exists.");
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if (fileType.equalsIgnoreCase("pdf")) {
			try {
				reportPdfFileName = Constants.PdfReportPath + reportFileName + ".pdf";
				returnFileName = reportPdfFileName;
				reportPdfFile = new File(reportTextFileName);

				if (reportPdfFile.createNewFile()) {
					System.out.println("File is created!");
				} else {
					System.out.println("File already exists.");
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if (fileType.equalsIgnoreCase("extent")) {
			reportExtentFileName = Constants.ExtentReportPath + reportFileName + ".html";
			// returnFileName = reportExtentFileName;
			// reportExtentFile = new File(reportTextFileName);
			//
			// if (reportExtentFile.createNewFile()) {
			// System.out.println("File is created!");
			// } else {
			// System.out.println("File already exists.");
			// }
		}
		return returnFileName;
	}

	// Method returns today's date ( Ex: 2)
//	public String getTodaysDate() {
//		Calendar cal = Calendar.getInstance();
//		return String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
//	}

	// Method returns the day of the week ( Ex: Wednesday)
//	public String getTodaysDay() {
//		DayOfWeek dayOfWeek = DayOfWeek.from(LocalDate.now());
//		return dayOfWeek.toString();
//
//		// String daysArray[] = {"Sunday","Monday","Tuesday",
//		// "Wednesday","Thursday","Friday", "Saturday"};
//		// Calendar calendar = Calendar.getInstance();
//		// return daysArray[calendar.get(Calendar.DAY_OF_WEEK)];
//	}
	
	// Method returns the day of the week ( Ex: Wednesday)
		public String getCurrentDay() {
//			DayOfWeek dayOfWeek = DayOfWeek.from(LocalDate.now());
//			return dayOfWeek.toString();

			 String daysArray[] = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday", "Saturday"};
			 Calendar calendar = Calendar.getInstance();
			 return daysArray[calendar.get(Calendar.DAY_OF_WEEK)-1];
		}
		
	//Method returns the current date Ex: 25
	public String getPastDateMonth(int noOfDays) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 0 - noOfDays);
		String date1 = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
		String month1 = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
		return date1 +"<--->"+month1;
		
	}
	
	//Method returns the current date Ex: 25
	public String getFutureDateMonth(int noOfDays) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, noOfDays);
		String date1 = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
		String month1 = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
		return date1 +"<--->"+month1;			
	}

	// Method returns the current month ( Ex: August)
	public String getCurrentMonth() {
		Calendar cal = Calendar.getInstance();
		return cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());

		// Calendar cal = Calendar.getInstance();
		// String[] monthNames = {"January", "February", "March", "April", "May",
		// "June", "July", "August", "September", "October", "November", "December"};
		// return monthNames[cal.get(Calendar.MONTH)];
	}

	// Method returns the current year ( Ex: 2017)
	public String getCurrentYear() {
		Calendar cal = Calendar.getInstance();
		return String.valueOf(cal.get(Calendar.YEAR));
	}

	// Method returns the current month and year ( Ex: August 2017)
	public String getCurrentMonthYear() {
		Calendar cal = Calendar.getInstance();
		String month = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
		String year = String.valueOf(cal.get(Calendar.YEAR));
		return month + " " + year;
	}

	// Method returns the current month and date ( Ex: August 2)
	public String getCurrentMonthDate() {
		Calendar cal = Calendar.getInstance();
		String month = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());

		String date1 = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
		return month + " " + date1;
	}
	
	// Method returns the current month and date ( Ex: Aug)
	public String getShortMonth(String month) {
//		if(month==null) {
//			reportFail(driver, strTestCaseName, month, actionName, objDescription);
//		}
		return month.substring(0, 3);
	}
	
	// Method returns the date in 2 digits (Ex: 02)
		public String getFullDate(String date1) {
			if(date1.length()==1) {
				date1 = "0"+date1;
			}
			return date1;
		}
	
	// Method returns the current month and date ( Ex: Aug02)
		public String getCurrentShortMonthDate() {
			Calendar cal = Calendar.getInstance();
			String month = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
			month = month.substring(0, 2);

			String date1 = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
			if(date1.length()==1) {
				date1 = "0"+date1;
			}
			return month + date1;
		}
		
	//Method returns the current date Ex: 25
	public String getCurrentDate() {
		Calendar cal = Calendar.getInstance();
		String date1 = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
		return date1;
		
	}
	public void compareValues(IOSDriver<MobileElement> driver, String strTestCaseName, String deviceDetails,
			String objDescription, String expectedValue, String actualValue) {
		
		if (!testStepStatus) {
			return;
		}
		try {
			
			expectedValue = expectedValue.replace("\n", " ").replace("\r", " ").trim();
			actualValue = actualValue.replace("\n", " ").replace("\r", " ").trim();
			
			if (expectedValue.equalsIgnoreCase(actualValue)) {
				String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
						+ getCurrentDateAndTime() + Constants.DELIMITER + "Compare Values Of The Object--->"
						+ objDescription + Constants.DELIMITER + ("Exp: " + expectedValue + "-->Act: " + actualValue)
						+ Constants.DELIMITER + Constants.stepPass;
				appendReportFile(driver, logReport);
				extentReport(driver, logReport);
			} else {
				String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
						+ getCurrentDateAndTime() + Constants.DELIMITER + "Compare Values  Of The Object--->"
						+ objDescription + Constants.DELIMITER + ("Exp: " + expectedValue + "-->Act: " + actualValue)
						+ Constants.DELIMITER + Constants.stepFail;
				appendReportFile(driver, logReport);
				extentReport(driver, logReport);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void compareValuesContains(IOSDriver<MobileElement> driver, String strTestCaseName, String deviceDetails,
			String objDescription, String expectedValue, String actualValue) {
		
		if (!testStepStatus) {
			return;
		}
		
		try {
			
			expectedValue = expectedValue.replace("\n", " ").replace("\r", " ").trim();
			actualValue = actualValue.replace("\n", " ").replace("\r", " ").trim();
			
			expectedValue = expectedValue.toLowerCase();
			actualValue = actualValue.toLowerCase();
			Thread.sleep(10000);
			if (actualValue.contains(expectedValue)) {
				String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
						+ getCurrentDateAndTime() + Constants.DELIMITER + "Compare Values Of The Object--->"
						+ objDescription + Constants.DELIMITER + ("Exp: " + expectedValue + "-->Act: " + actualValue)
						+ Constants.DELIMITER + Constants.stepPass;
				appendReportFile(driver, logReport);
				extentReport(driver, logReport);
			} else {
				String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
						+ getCurrentDateAndTime() + Constants.DELIMITER + "Compare Values  Of The Object--->"
						+ objDescription + Constants.DELIMITER + ("Exp: " + expectedValue + "-->Act: " + actualValue)
						+ Constants.DELIMITER + Constants.stepFail;
				appendReportFile(driver, logReport);
				extentReport(driver, logReport);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
		// ********************************************************************* Excel Related Methods **********************************************************************************
	public String getExecutionRows(String strTestCaseName) {
		String getTestCaseName = "";
		String executionRows = "";
		String getRunMode = "N";
		int totalRows = 0;
		int totalExecutionCount = 0;

		String ExecutionFileName = Constants.ExecuteFileLocation;
		ExcelReader xlsReadExecutionFile = new ExcelReader(ExecutionFileName);
		totalRows = xlsReadExecutionFile.getRowCount(Constants.ExecuteFileSheet);

		for (int rowLoop = 1; rowLoop <= totalRows; rowLoop++) {
			getTestCaseName = xlsReadExecutionFile.getCellData(Constants.ExecuteFileSheet, "TestCaseName", rowLoop);
			if (getTestCaseName.equalsIgnoreCase(strTestCaseName)) {
				getRunMode = xlsReadExecutionFile.getCellData(Constants.ExecuteFileSheet, "RunFlag", rowLoop);
				if (getRunMode.equalsIgnoreCase("Y") || getRunMode.equalsIgnoreCase("Yes")) {
					totalExecutionCount++;
					executionRows = executionRows + "," + rowLoop;
				}
			}
		}
		executionRows.trim();
		return executionRows.substring(1);
	}

	public String getDataFromExecutionExcel(int row, String colName) {
		String getValue = "";
		ExcelReader excel = new ExcelReader(Constants.ExecuteFileLocation);
		getValue = excel.getCellData(Constants.ExecuteFileSheet, colName, row);
		return getValue;
	}

	/*
	 * The method will return the total number of rows from the execution file. This
	 * count will be used to iterate through the test script
	 */
	public int getRowsFromExecutionFile() {
		int totalRows = 0;

		String ExecutionFileName = Constants.ExecuteFileLocation;
		ExcelReader xlsReadExecutionFile = new ExcelReader(ExecutionFileName);
		totalRows = xlsReadExecutionFile.getRowCount(Constants.ExecuteFileSheet);
		return totalRows;
	}

	/*
	 * The method is used to verify the run flag of a particular test script from
	 * the execution file If the run flag is "Y" or "Yes", it'll return true value
	 * to the called method Otherwise, false value will be returned to the called
	 * method
	 */
	public boolean verifyExecutionRunMode(String strTestCaseName) {
		boolean testCaseFound = false;
		String getTestCaseName = "";
		String getRunMode = "N";
		int totalRows = 0;

		String ExecutionFileName = Constants.ExecuteFileLocation;
		ExcelReader xlsReadExecutionFile = new ExcelReader(ExecutionFileName);
		totalRows = xlsReadExecutionFile.getRowCount(Constants.ExecuteFileSheet);

		for (int rowLoop = 1; rowLoop <= totalRows; rowLoop++) {
			getTestCaseName = xlsReadExecutionFile.getCellData(Constants.ExecuteFileSheet, "TestCaseName", rowLoop);
			if (getTestCaseName.equalsIgnoreCase(strTestCaseName)) {
				testCaseFound = true;
				getRunMode = xlsReadExecutionFile.getCellData(Constants.ExecuteFileSheet, "RunFlag", rowLoop);
				if (getRunMode.equals("Y")) {
					getRunMode = "YES";
				}
				break;
			}
		}
		if (testCaseFound && getRunMode.equalsIgnoreCase("YES")) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * The method is used to get the values from the execution file based on the
	 * column, these values will be used to create the iOS driver
	 */
	public String getExecutionData(String strTestCaseName, String colName) {

		String getTestCaseName = "";
		int totalRows = 0;
		String returnData = "";

		String ExecutionFileName = Constants.ExecuteFileLocation;
		ExcelReader xlsReadExecutionFile = new ExcelReader(ExecutionFileName);
		totalRows = xlsReadExecutionFile.getRowCount(Constants.ExecuteFileSheet);

		for (int rowLoop = 1; rowLoop <= totalRows; rowLoop++) {
			getTestCaseName = xlsReadExecutionFile.getCellData(Constants.ExecuteFileSheet, "TestCaseName", rowLoop);
			if (getTestCaseName.equalsIgnoreCase(strTestCaseName)) {
				returnData = xlsReadExecutionFile.getCellData(Constants.ExecuteFileSheet, colName, rowLoop);
				break;
			}
		}
		return returnData;
	}

	public int getRowsFromInputFile(String inputFileName, String sheetName) {
		int totalRows = 0;
		ExcelReader xlsReadExecutionFile = new ExcelReader(inputFileName);
		totalRows = xlsReadExecutionFile.getRowCount(sheetName);
		return totalRows;
	}

	public String getDataFromInputFile(String fileName, String sheetName, String colName, int rowNo) throws IOException {
		String getValue = "";
		ExcelReader excel = new ExcelReader(fileName);
		if(!excel.isSheetExist(sheetName)) {
			reportFail(getWebDriver(), fileName, sheetName, "Check Data Sheet Exist", "Data Sheet Does Not Exist ---> " +sheetName );
			abortTest(getWebDriver());
		}
		int totalRows = excel.getRowCount(sheetName);
		getValue = excel.getCellData(sheetName, colName, rowNo);
		return getValue;
	}
	
	public String getDataFromInputFileLoginSheet(String fileName, String sheetName, String roleColName, int rowNo, String returnColName) throws IOException {
		String getValue = null;
		String getLoginRole;
		String getDataRole;
		
		ExcelReader excel = new ExcelReader(fileName);
		
		if(!excel.isSheetExist(sheetName)) {
			reportFail(getWebDriver(), fileName, sheetName, "Check Data Sheet Exist", "Data Sheet Does Not Exist ---> " +sheetName );
			abortTest(getWebDriver());
		}
		getDataRole = excel.getCellData(sheetName, roleColName, rowNo);
		
//		int totalRows = excel.getRowCount(sheetName);
		int totalRows = excel.getRowCount("Login");
		
		for (int row=2;row<=totalRows;row++) {
			getLoginRole = excel.getCellData("Login", Constants.RoleColumn, row);
			if (getLoginRole.equalsIgnoreCase(getDataRole)) {
				getValue = excel.getCellData("Login", returnColName, row);
				break;
			}
		}
		return getValue;
	}

	@DataProvider(name = "GetRecords", parallel = true)
	public static Object[][] sauceBrowserDataProvider(Method testMethod) {
		String ExecutionFileName = Constants.ExecuteFileLocation;
		ExcelReader xls = new ExcelReader(ExecutionFileName);
		int totalRows = xls.getRowCount(Constants.ExecuteFileSheet);
		String sheet = Constants.ExecuteFileSheet;

		Object[][] records = new Object[totalRows][8];
		int counter = 0;
		for (int i = 0; i < totalRows; i++) {
			records[counter++] = new Object[] { xls.getCellData(sheet, "TestCaseName", i + 1),
					xls.getCellData(sheet, "DeviceModel", i + 1), xls.getCellData(sheet, "DeviceName", i + 1),
					xls.getCellData(sheet, "PlatformName", i + 1), xls.getCellData(sheet, "PlatformVersion", i + 1),
					xls.getCellData(sheet, "AppPackage", i + 1), xls.getCellData(sheet, "AppActivity", i + 1),
					xls.getCellData(sheet, "RunFlag", i + 1) };
		}
		return records;
	}

	@DataProvider(name = "getExecutionData")
	public Object[][] executionData() {
		Object[][] arrayObject = getExecutionExcelData();
		return arrayObject;
	}

	public String[][] getExecutionExcelData() {
		String[][] arrayExcelData = null;
		try {
			String ExecutionFileName = Constants.ExecuteFileLocation;
			ExcelReader xls = new ExcelReader(ExecutionFileName);
			int totalRows = xls.getRowCount(Constants.ExecuteFileSheet);
			int totalCols = xls.getColumnCount(Constants.ExecuteFileSheet);

			arrayExcelData = new String[totalRows - 1][totalCols];

			for (int row = 1; row < totalRows; row++) {
				for (int col = 0; col < totalCols; col++) {
					arrayExcelData[row - 1][col] = xls.getCellData(Constants.ExecuteFileSheet, col, row);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrayExcelData;
	}

	public void reportRow(IOSDriver<MobileElement> driver, String strTestCaseName, String deviceDetails,
			int rowNumber) throws IOException {
		String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
				+ getCurrentDateAndTime() + Constants.DELIMITER + "Row Number------------------------------------------------------->"
				+ rowNumber + Constants.DELIMITER + "NO DATA" + Constants.DELIMITER + Constants.stepPass;
		appendReportFile(driver, logReport);
		extentReport(driver, logReport);
	}
	
	public void reportTestCase(IOSDriver<MobileElement> driver, String strTestScriptName, String deviceDetails,
			String zephyrTestCaseName, String testCaseDetails) throws IOException {
		FailStepCount=0;
		String logReport = strTestScriptName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
				+ getCurrentDateAndTime() + Constants.DELIMITER + "Test Case --->"
				+ zephyrTestCaseName + Constants.DELIMITER + testCaseDetails + Constants.DELIMITER + Constants.stepPass;
		appendReportFile(driver, logReport);
		extentReport(driver, logReport);
	}
	
	public void reportInfo(IOSDriver<MobileElement> driver, String strTestCaseName, String strDevice, String actionName,
			String objDescription) throws IOException {
//		if (!testStepStatus) {
//			return;
//		}
//		
//		String logReport = strTestCaseName + Constants.DELIMITER + strDevice + Constants.DELIMITER
//				+ getCurrentDateAndTime() + Constants.DELIMITER + actionName + "--->"
//				+ objDescription + Constants.DELIMITER + "NO DATA" + Constants.DELIMITER + Constants.stepInfo;
//		appendReportFile(driver, logReport);
//		extentReport(driver, logReport);
	}
	
	public void reportPass(IOSDriver<MobileElement> driver, String strTestCaseName, String deviceDetails, String actionName,
			String objDescription) throws IOException {
		String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
				+ getCurrentDateAndTime() + Constants.DELIMITER + actionName + "--->"
				+ objDescription + Constants.DELIMITER + "NO DATA" + Constants.DELIMITER + Constants.stepPass;
		appendReportFile(driver, logReport);
		extentReport(driver, logReport);
	}

	public void reportFail(IOSDriver<MobileElement> iosDriver, String strTestCaseName, String deviceDetails, String actionName,
			String objDescription) throws IOException {

		actionName = actionName.toLowerCase();
		
		if(!actionName.contains("Verification")) {
			testStepStatus = false;
		}
		
		FailStepCount++;

		String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
				+ getCurrentDateAndTime() + Constants.DELIMITER + actionName + "--->"
				+ objDescription + Constants.DELIMITER + "NO DATA" + Constants.DELIMITER + Constants.stepFail;
		appendReportFile(iosDriver, logReport);
		extentReport(iosDriver, logReport);
	}
	
	public String[] returnExecutionRows(String executionRows) {

		String[] arrRowExecute = null;
		String getRow = null;
		String exeRow = "";
		String returnRows[] = null;

		if (executionRows.contains(",")) {
			arrRowExecute = executionRows.split(",");

			for (int rowLoop = 0; rowLoop < arrRowExecute.length; rowLoop++) {
				getRow = arrRowExecute[rowLoop];
				if (getRow.contains("-")) {
					String[] splitRow = getRow.split("-");
					int startRow = Integer.parseInt(splitRow[0]);
					int endRow = Integer.parseInt(splitRow[1]);

					for (int addRow = startRow; addRow <= endRow; addRow++) {
						exeRow = exeRow + addRow + ",";
					}
				} else {
					exeRow = exeRow + getRow + ",";
				}
				returnRows = exeRow.split(",");
			}
		} else if (executionRows.contains("-")) {
			String[] splitRow = executionRows.split("-");
			int startRow = Integer.parseInt(splitRow[0]);
			int endRow = Integer.parseInt(splitRow[1]);

			for (int addRow = startRow; addRow <= endRow; addRow++) {
				exeRow = exeRow + addRow + ",";
			}
			exeRow = exeRow.substring(0, exeRow.length() - 1);
			exeRow.trim();
			returnRows = exeRow.split(",");
		} else {
			exeRow = executionRows;
			returnRows = exeRow.split(" ");
		}
		System.out.println(exeRow);
		
		for (int execLoop = 0; execLoop < returnRows.length; execLoop++) {
			System.out.println(returnRows[execLoop]);
		}
		return returnRows;
	}
	
	
	public void swipeUp(IOSDriver<MobileElement> driver, int startYPos, int endYPos) throws InterruptedException {
		try {
			// Point point = element.getLocation();
			// Point p = element.getCenter();
//			Dimension size = driver.manage().window().getSize();
//			System.out.println("Print window size "+size);
//			System.out.println("Print window width "+size.width);
//			System.out.println("Print window height "+size.height);
//			int startX = (int) (size.width * 0.50);
//			int endX = startX;
//
//			// int startY = element.getCenter().getY();
//			//int startY = (int) (size.height * startYPos / 100);
//			//int endY = (int) (size.height * endYPos / 100);
//			
//			int startY = 0;
//			int endY = (int) (size.height * 0.50);
//			//driver.swipe(startX, startY, endX, endY, 1000);
//			driver.swipe(startX, startY, endX, endY, 1000);
//			Thread.sleep(2000);
			 Dimension size = driver.manage().window().getSize();

           int  startX= size.width / 2;
           int endX = size.width / 2;
            int startY = (int) (size.height * 0.50);

           int  endY = (int) (size.height * 0.40);

             driver.swipe(startX, startY, endX, endY, 1000);
			
			
			
			

			/*
			 * String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails +
			 * Constants.DELIMITER + getCurrentDateAndTime() + Constants.DELIMITER +
			 * "Swipe Left" + Constants.DELIMITER + "NO DATA" + Constants.DELIMITER +
			 * Constants.stepPass; appendReportFile(driver, logReport); extentReport(driver,
			 * logReport);
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void swipeDown(IOSDriver<MobileElement> driver, int startYPos, int endYPos) throws InterruptedException {
		try {
			// Point point = element.getLocation();
			// Point p = element.getCenter();
			Dimension size = driver.manage().window().getSize();
			System.out.println("Print window size "+size);
			System.out.println("Print window width "+size.width);
			System.out.println("Print window height "+size.height);
			int startX = (int) (size.width * 0.50);
			int endX = startX;

			// int startY = element.getCenter().getY();
			int startY = (int) (size.height * 0.80);
			int endY = (int) (size.height * 0.70);
			;

			driver.swipe(startX, startY, endX, endY, 2000);
			//Thread.sleep(2000);

			/*
			 * String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails +
			 * Constants.DELIMITER + getCurrentDateAndTime() + Constants.DELIMITER +
			 * "Swipe Left" + Constants.DELIMITER + "NO DATA" + Constants.DELIMITER +
			 * Constants.stepPass; appendReportFile(driver, logReport); extentReport(driver,
			 * logReport);
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	//*************************************************************** Swipe Elements By Element *****************************************************************************************
//	public void swipeUpByElement(IOSDriver<MobileElement> driver, String strTestCaseName, String deviceDetails,By elementString)
//			throws InterruptedException {
//		try {
//
//			MobileElement element = findElement(driver,elementString);
//			Thread.sleep(2000);
//			
//			Point point = element.getLocation();
//			Dimension size = driver.manage().window().getSize();
//
//			// Point p = element.getCenter();
//
//			int screenHeight = (int) (size.height * 0.10);
//			int elementY = point.getY();
//
//			int endX = 0;
//			int endY = ((int) screenHeight - (elementY + element.getSize().height));
//
//			TouchAction action = new TouchAction((MobileDriver) driver);
//			action.press(element.getCenter().getX(), element.getCenter().getY())
//					.moveTo(endX, screenHeight - element.getCenter().getY()).release().perform();
//
//		Thread.sleep(1000);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

//	public void swipeDownByElement(IOSDriver<MobileElement> driver, String strTestCaseName, String deviceDetails,By elementString)
//			throws InterruptedException {
//
//		MobileElement element = findElement(driver,elementString);
//
//		Point point = element.getLocation();
//		Dimension size = driver.manage().window().getSize();
//
//		int screenHeight = (int) (size.height * 0.90);
//		int elementY = point.getY();
//
//		int endX = 0;
//		int endY = ((int) screenHeight - elementY);
//
//		TouchAction action = new TouchAction((MobileDriver) driver);
//		action.press(element.getCenter().getX(), element.getCenter().getY())
//				.moveTo(endX, screenHeight - element.getCenter().getY()).release().perform();
//		
//		Thread.sleep(1000);
//	}

//	public void swipeLeftByElement(IOSDriver<MobileElement> driver, String strTestCaseName, String deviceDetails,By elementString)
//			throws InterruptedException {
//
//		MobileElement element = findElement(driver,elementString);
//
//		Point point = element.getLocation();
//		Point p = element.getCenter();
//		Dimension size = driver.manage().window().getSize();
//
//		int screenWidth = (int) (size.width * 0.10);
//		int elementX = p.getX();
//
//		int endY = 0;
//		int endX = 0 - (element.getSize().getWidth());
//
//		TouchAction action = new TouchAction((MobileDriver) driver);
//		action.press((int) (point.getX() + (element.getSize().getWidth() * 0.90)), element.getCenter().getY())
//				.moveTo((int) (screenWidth - (point.getX() + (element.getSize().getWidth() * 0.90))), endY).release()
//				.perform();
//		
//		Thread.sleep(1000);
//	}

//	public void swipeRightByElement(IOSDriver<MobileElement> driver, String strTestCaseName, String deviceDetails,By elementString)
//			throws InterruptedException {
//
//		MobileElement element = findElement(driver,elementString);
//
//		Point point = element.getLocation();
//		Point p = element.getCenter();
//
//		Dimension size = driver.manage().window().getSize();
//
//		int screenWidth = (int) (size.width * 0.90);
//		int elementX = p.getX();
//
//		int endY = 0;
//		int endX = element.getSize().getWidth();
//
//		TouchAction action = new TouchAction((MobileDriver) driver);
//
//		action.press((int) (point.getX() + (element.getSize().getWidth() * 0.10)), element.getCenter().getY())
//				.moveTo((int) (screenWidth - (point.getX() + (element.getSize().getWidth() * 0.10))), endY).release()
//				.perform();
//		
//		Thread.sleep(1000);
//
//	}
	//swipeleft
	public void swipeLeft(IOSDriver<MobileElement> driver) throws InterruptedException {
		try {
			// Point point = element.getLocation();
			// Point p = element.getCenter();
			Dimension size = driver.manage().window().getSize();
			System.out.println("size "+size);
			System.out.println("size "+size.width);
			System.out.println("size "+size.width * 0.80);
			System.out.println("size "+size.width * 0.20);
			System.out.println("size "+size.height);
			System.out.println("size "+size.height * 0.30);

			int startX = (int) (size.width);
			int endX = (int) (size.width * 0.90);

			// int startY = element.getCenter().getY();
			int startY = (int) (size.height);
			int endY = startY;

			driver.swipe(startX, startY, endX, endY, 2000);
			//Thread.sleep(1000);

			/*
			 * String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails +
			 * Constants.DELIMITER + getCurrentDateAndTime() + Constants.DELIMITER +
			 * "Swipe Left" + Constants.DELIMITER + "NO DATA" + Constants.DELIMITER +
			 * Constants.stepPass; appendReportFile(driver, logReport); extentReport(driver,
			 * logReport);
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void swipeRight(IOSDriver<MobileElement> driver) throws InterruptedException {
		try {
			// Point point = element.getLocation();
			// Point p = element.getCenter();
			Dimension size = driver.manage().window().getSize();

			int startX = (int) (size.width * 0.20);
			int endX = (int) (size.width * 0.80);

			// int startY = element.getCenter().getY();
			int startY = (int) (size.height * 0.50);
			int endY = startY;

			driver.swipe(startX, startY, endX, endY, 2000);
			//Thread.sleep(1000);

			/*
			 * String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails +
			 * Constants.DELIMITER + getCurrentDateAndTime() + Constants.DELIMITER +
			 * "Swipe Right" + Constants.DELIMITER + "NO DATA" + Constants.DELIMITER +
			 * Constants.stepPass; appendReportFile(driver, logReport); extentReport(driver,
			 * logReport);
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean swipeAndVerifyElementIsDisplayedForEditEventPage(IOSDriver<MobileElement> driver, String strTestCaseName,
			String deviceDetails, String objDescription, By objIdentifier, String swipeDirection) throws IOException, InterruptedException {

		if (!testStepStatus) {
			return false;
		}
		
		int swipeCount=0;
		int initialX = 0;
		int initialY = 0;
		int finalX = 0;
		int finalY = 0;
		boolean endOfScroll = false;
		boolean returnValue = false;
		boolean elementFound=false;
		MobileElement element;
		List<MobileElement> objElement;
		int objCount=0;
		int startX, endX, startY, endY;
		
		while (!endOfScroll) {
			try {
				swipeCount++;
				objElement = driver.findElements(objIdentifier);
				objCount = objElement.size();
				if(swipeCount>Constants.MaxSwipeForAPage) {
					endOfScroll=true;
				}
				if (objCount > 0) {
					if(driver.findElement(objIdentifier).getLocation().getX()>0) {
						if(driver.findElement(objIdentifier).getLocation().getY()>0) {
							elementFound=true;
							endOfScroll=true;
							break;
						}
					}
//					boolean foundAccount = driver.findElement(objIdentifier).isDisplayed();
//					if(foundAccount) {
//						MobileElement elementAccount = driver.findElement(objIdentifier);
//						Dimension size = driver.manage().window().getSize();
//						int getX = elementAccount.getLocation().getX();
//						int getY = elementAccount.getLocation().getY();
//						if (getX >0 && getY >0) {
//							double getPercentage= Math.round(getY/size.height) ;
//							startX = endX = size.width / 2;
//							startY = (int) (size.height * getPercentage/100);
//							endY = (int) (size.height * ((getPercentage/100)-(0.50)));
//							System.out.println("Start Y : " + startY);
//							System.out.println("End Y : " + endY);
//							driver.swipe(startX, startY, endX, endY, 1000);
//							endOfScroll = true;
//						}
//					}
				} else {
						//Verify that if the end of scroll of the page
						List<MobileElement> elements = driver.findElements(By.className("android.widget.TextView"));
						System.out.println("Total Elements : " + elements.size());
						java.util.Iterator<MobileElement> i = elements.iterator();
						while (i.hasNext()) {
							element = i.next();
							initialX = element.getLocation().getX();
							initialY = element.getLocation().getY();
						}
						if (initialX == finalX && initialY == finalY) {
							endOfScroll = true;
							break;
						} else {
							finalX = initialX;
							finalY = initialY;
						}
				}
				if (swipeDirection.equalsIgnoreCase("up")) {
					Dimension size = driver.manage().window().getSize();
					startX = endX = size.width / 2;
					startY = (int) (size.height * 0.90);
					endY = (int) (size.height * 0.80);
					driver.swipe(startX, startY, endX, endY, 1000);
					try {
					
						MobileElement elementAccount = driver.findElement(By.xpath("//android.widget.TextView[(@text='Account') and (@index='1')]"));
						boolean foundAccount = elementAccount.isDisplayed();
						if(foundAccount) {
							int getX = elementAccount.getLocation().getX();
							int getY = elementAccount.getLocation().getY();
							if (getX >0 && getY >0) {
								double getPercentage= Math.round(getY/size.height) ;
								startX = endX = size.width / 2;
								startY = (int) (size.height * getPercentage/100);
								endY = (int) (size.height * ((getPercentage/100)-(0.50)));
								System.out.println("Start Y : " + startY);
								System.out.println("End Y : " + endY);
								driver.swipe(startX, startY, endX, endY, 1000);
								endOfScroll = true;
							}
						}
					} catch (Exception e) {
						
					}
				}else if (swipeDirection.equalsIgnoreCase("down")) {
					Dimension size = driver.manage().window().getSize();
					startX = endX = size.width / 2;
					startY = (int) (size.height * 0.50);
					endY = (int) (size.height * 0.60);
					driver.swipe(startX, startY, endX, endY, 1000);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (elementFound) {
			if (swipeDirection.equalsIgnoreCase("up")) {
				Dimension size = driver.manage().window().getSize();
				startX = endX = size.width / 2;
				startY = (int) (size.height * 0.90);
				endY = (int) (size.height * 0.80);
				driver.swipe(startX, startY, endX, endY, 1000);
			}else if (swipeDirection.equalsIgnoreCase("down")) {
				Dimension size = driver.manage().window().getSize();
				startX = endX = size.width / 2;
				startY = (int) (size.height * 0.50);
				endY = (int) (size.height * 0.60);
				driver.swipe(startX, startY, endX, endY, 1000);
			}
		}
		if (elementFound) {
			String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER + "Verification: Element/Object Displayed--->"
					+ objDescription + Constants.DELIMITER + "NO DATA" + Constants.DELIMITER + Constants.stepPass;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);
			returnValue = true;
		} else {
			String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER
					+ "Verification: Element/Object NOT Displayed--->" + objDescription + Constants.DELIMITER
					+ "NO DATA" + Constants.DELIMITER + Constants.stepFail;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);
			returnValue = false;
		}
	
		return returnValue;
	}
	
	public void clickcoordinatesdone(IOSDriver<MobileElement> driver, String strTestCaseName, String deviceDetails) throws IOException {
		// System.out.println("Inisde the Method - setValue");
		
		int xcord = 0;
		int ycord = 0;
		
		TouchAction touchAction=new TouchAction(driver); 
		
		if(Constants.DeviceModel.equalsIgnoreCase("IPhone7Plus")){		
		 xcord = 364;
		 ycord = 705;
		}else if(Constants.DeviceModel.equalsIgnoreCase("IPhone6")){
			xcord = 190;
			ycord = 190;
		}else if(Constants.DeviceModel.equalsIgnoreCase("IPhone 8 Plus")){
			xcord = 190;
			ycord = 190;
		}
		touchAction.tap(xcord, ycord).perform(); 
		String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
				+ getCurrentDateAndTime() + Constants.DELIMITER + "Done Button is Tapped on Keyboard--->"
				+ Constants.DELIMITER + Constants.DELIMITER + Constants.stepPass;
		appendReportFile(driver, logReport);
		extentReport(driver, logReport);
	}
	
	public void clickcoordinatesDownloadIcon(IOSDriver<MobileElement> driver, String strTestCaseName, String deviceDetails) throws IOException {
		// System.out.println("Inisde the Method - setValue");
		
		 int xcord = 1026;
		int  ycord = 429;
		
		TouchAction touchAction=new TouchAction(driver); 
	
		}
		
	
//	
//	public void clickTop(AndroidDriver<MobileElement> driver, String strTestCaseName, String deviceDetails) throws IOException {
//		// System.out.println("Inisde the Method - setValue");
//		
//		int xcord = 0;
//		int ycord = 0;
//		
//		TouchAction touchAction=new TouchAction(driver); 
//		
//		if(Constants.DeviceModel.equalsIgnoreCase("Samsung S8")){		
//		 xcord = 551;
//		 ycord = 221;
//		}else if(Constants.DeviceModel.equalsIgnoreCase("LG")){
//			xcord = 650;
//			ycord = 190;
//		}
//		touchAction.tap(xcord, ycord).perform(); 
//		String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
//				+ getCurrentDateAndTime() + Constants.DELIMITER + "Done Button is Tapped on Keyboard--->"
//				+ Constants.DELIMITER + Constants.DELIMITER + Constants.stepPass;
//		appendReportFile(driver, logReport);
//		extentReport(driver, logReport);
//	}

	//*********************************************************************************************************************************************************************************

	public void startReportingFiles(String TestCaseName) throws IOException {

		if(!Constants.ReportFormat.equalsIgnoreCase("combined")) {
		
			try {
				reportTextFileName = Constants.TextReportPath + TestCaseName + ".txt";
				reportTextFile = new File(reportTextFileName);
				
				if (reportTextFile.exists()) {
					reportTextFile.delete();
				}

				if (reportTextFile.createNewFile()) {
					System.out.println("File is created!");
				} else {
					System.out.println("File already exists.");
				}
				
				reportExtentFileName = Constants.ExtentReportPath + TestCaseName + ".html";
				report = new ExtentReports(reportExtentFileName);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void endReportingFiles(String TestCaseName) {
		
		if(!Constants.ReportFormat.equalsIgnoreCase("combined")) {
			try {
				report.flush();
				report.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void endTestScript(IOSDriver<MobileElement> driver, String TestCaseName, String strDevice) throws IOException
	{
		try {
			report.endTest(logger);
			endTest(driver, TestCaseName, strDevice);
			endReportingFiles(TestCaseName + "-" + strDevice);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void startTestScript(String TestCaseName, String strDevice) throws IOException
	{
		try {
			startReportingFiles(TestCaseName + "-" + strDevice);
			System.out.println("Printing "+ TestCaseName + "-" + strDevice);
			logger = report.startTest(TestCaseName + "-" + strDevice);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public boolean swipeAndVerifyElementIsDisplayed(IOSDriver<MobileElement> driver, String strTestCaseName,
			String deviceDetails, String objDescription, By objIdentifier, String swipeDirection, int startXPercentage,
			int endXPercentage, int startYPercentage, int endYPercentage) throws IOException, InterruptedException {

		if (!testStepStatus) {
			return false;
		}

		MobileElement getElement = null;
		int swipeCount = 0;
		boolean endOfScroll = false;
		boolean returnValue = false;
		boolean elementFound = false;
		List<MobileElement> objElement;
		int objCount = 0;
		int startX = 0;
		int endX = 0;
		int startY = 0;
		int endY = 0;

		noOfTimesSwiped = 0;

		while (!endOfScroll) {
			try {
				System.out
						.println("Trying to find the element : " + objDescription + "--->" + objIdentifier.toString());
				swipeCount++;

				if (swipeCount >= Constants.MaxSwipeForAPage) {
					endOfScroll = true;
					break;
				}

				try {
					objElement = driver.findElements(objIdentifier);
					objCount = objElement.size();
				} catch (Exception e) {

				}

				// If element is found, verify if the element is displayed and break the loop
				if (objCount > 0) {
					getElement = driver.findElement(objIdentifier);
					System.out.println("getElement.getLocation().getX() " + getElement.getLocation().getX());
					System.out.println("getElement.getLocation().getY() " + getElement.getLocation().getY());
					System.out.println("Screen Height : " + screenHeight);
					try {

						if (getElement.isEnabled() && getElement.isDisplayed() && getElement.getLocation().getX() >= 0
								&& getElement.getLocation().getY() >= 0) {
							System.out.println("Y Location : " + getElement.getLocation().getY());
							getDeviceScreenHeight(driver);
							// System.out.println("Screen Height : " + screenHeight);
							if ((getElement.getLocation().getY()) <= (screenHeight)) {
							elementFound = true;
							endOfScroll = true;
							break;
							}
						}
					} catch (Exception e) {

					}
				}

					if(swipeCount>1) {
				if (swipeDirection.equalsIgnoreCase("up")) {
					Dimension size = driver.manage().window().getSize();

					if (startXPercentage == 0 || endXPercentage == 0) {
						startX = endX = (int) (size.width * 50 / 100);
					} else {
						startX = endX = (int) (size.width * startXPercentage / 100);
					}

					if (startYPercentage == 0) {
						startY = (int) (size.height * 0.40); // 0.60
					} else {
						startY = (int) (size.height * startYPercentage / 100);
					}

					if (endYPercentage == 0) {
						endY = (int) (size.height * 0.30); // 0.40
					} else {
						endY = (int) (size.height * endYPercentage / 100);
					}

					driver.swipe(startX, startY, endX, endY, 1000);
					noOfTimesSwiped++;
				} else if (swipeDirection.equalsIgnoreCase("down")) {
					Dimension size = driver.manage().window().getSize();
					if (startXPercentage == 0 || endXPercentage == 0) {
						startX = endX = (int) (size.width * 50 / 100);
					} else {
						startX = endX = (int) (size.width * startXPercentage / 100);
					}

					if (startYPercentage == 0) {
						startY = (int) (size.height * 0.40);
					} else {
						startY = (int) (size.height * startYPercentage / 100);
					}

					if (endYPercentage == 0) {
						endY = (int) (size.height * 0.60);
					} else {
						endY = (int) (size.height * endYPercentage / 100);
					}
					driver.swipe(startX, startY, endX, endY, 1000);
					noOfTimesSwiped++;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		/*************************/

//			if (elementFound) {
//				if(swipeCount!=1) {
//					if (swipeDirection.equalsIgnoreCase("up")) {
//						Dimension size = driver.manage().window().getSize();
//						startX = endX = size.width / 2;
//						startY = (int) (size.height * 0.60);
//						endY = (int) (size.height * 0.50);
//						driver.swipe(startX, startY, endX, endY, 1000);
//					}else if (swipeDirection.equalsIgnoreCase("down")) {
//						Dimension size = driver.manage().window().getSize();
//						startX = endX = size.width / 2;
//						startY = (int) (size.height * 0.50);
//						endY = (int) (size.height * 0.60);
//						driver.swipe(startX, startY, endX, endY, 1000);
//					}
//				}
//			}
		/***************************/
		if (elementFound) {
			
			String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER + "Verification: Element/Object Displayed--->"
					+ objDescription + Constants.DELIMITER + "NO DATA" + Constants.DELIMITER + Constants.stepPass;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);
			/***********************/
			elementFound = true;
			endOfScroll = true;
			/**********************/
			returnValue = true;
		} else {
			String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER + "Verification: Element/Object Displayed--->"
					+ objDescription + Constants.DELIMITER + "NO DATA" + Constants.DELIMITER + Constants.stepFail;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);
			testStepStatus = false;
			returnValue = false;
		}
		Thread.sleep(2000);
		return returnValue;
	}

	public void getDeviceScreenHeight(IOSDriver<MobileElement> driver) {
		try {

			Dimension size = driver.manage().window().getSize();
			screenHeight = size.height;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean swipeAndVerifyElementIsDisplayed1(IOSDriver<MobileElement> driver, String strTestCaseName,
			String deviceDetails, String objDescription, By objIdentifier, String swipeDirection, int startYPercentage,
			int endYPercentage) throws IOException, InterruptedException {

		if (!testStepStatus) {
			return false;
		}
		boolean returnValue = false;
		returnValue = swipeAndVerifyElementIsDisplayed(driver, strTestCaseName, deviceDetails, objDescription,
				objIdentifier, swipeDirection, 0, 0, startYPercentage, endYPercentage);
		return returnValue;
	}
}
