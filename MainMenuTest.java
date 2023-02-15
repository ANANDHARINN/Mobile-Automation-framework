package com.salesTool.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.salesTool.common.BaseTest;
import com.salesTool.util.Constants;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class MainMenuTest extends BaseTest {

	String TestCaseName = this.getClass().getSimpleName();
	String dataSheetName = "MainMenu";

	IOSDriver<MobileElement> driver;

	boolean TestCaseFound = false;
	String getExecutionRows = null;
	String[] totalExecutionRows = null;
	int currentRow = 0;
	int dataRow = 0;
	String deviceName = "";
	String deviceModel = "";
	String platformName = "";
	String platformVersion = "";
	String appPackage = "";
	String appActivity = "";
	String deviceDetails = "";
	String executionRows = "";
	int totalInputDataRows = 0;
	String username = null;
	String password = null;
	boolean referInputData = false;
	String TCName = "";
	boolean newUser = false;
	String userRole = "";
	String TCDescription = "";
	String tempRole = "";
	int testStartCount = 0;
	String udid = null;
	String bundleId = null;
	boolean launchAndLogin = false;
	String AccountNumber = "";
	String EventType = "";
	String AccountName = "";
	String Address1 = "";
	String StartEndTime = "";
	String EventDescription = "";
	String RelatedObject = "";
	String CustomerNumber = "";
	String CustomerName = "";
	String ProductNumber = "";
	String ProductNumber1 = "";
	String Quantity = "";
	String PONumber = "";
	String PickingUp = "";
	String recommendationsFlag = "";
	String promoSummaryFlag = "";
	String withDepartmentFlag= "";

	@Test
	public void FlyingMenu() throws Exception {

		getExecutionRows = getExecutionRows(TestCaseName);
		String dataSheetName = "MainMenu";
		System.out.println("Total Execution Rows : " + getExecutionRows);
	
		// Split the rows and put it in an array
		totalExecutionRows = getExecutionRows.split(",");

		// Loop through the number of times the script has to be executed in different devices
		for (int iteration = 0; iteration < totalExecutionRows.length; iteration++) {
			try {
				// Get the device details from the execution file
				currentRow = Integer.parseInt(totalExecutionRows[iteration]);
				deviceName = getDataFromExecutionExcel(currentRow, "DeviceName");
				deviceModel = getDataFromExecutionExcel(currentRow, "DeviceModel");
				platformName = getDataFromExecutionExcel(currentRow, "PlatformName");
				platformVersion = getDataFromExecutionExcel(currentRow, "PlatformVersion");
				executionRows = getDataFromExecutionExcel(currentRow, "ExecutionRows");
				username = getDataFromExecutionExcel(currentRow, "Username");
				password = getDataFromExecutionExcel(currentRow, "Password");
				
				
				udid = getDataFromExecutionExcel(currentRow, "Udid");
				bundleId = getDataFromExecutionExcel(currentRow, "Bundleid");
				// Get the details of the device, this is to be used to reporting purpose
				deviceDetails = deviceModel + "-" + platformName + "-" + platformVersion;

				if (username.contains("Data") || password.equals("Data")) {
					referInputData = true;
				}

				String[] returnRows = returnExecutionRows(executionRows);

				for (int execLoop = 0; execLoop < returnRows.length; execLoop++) {
					testStepStatus = true;

					dataRow = Integer.parseInt(returnRows[execLoop]) + 1;
					TCName = getDataFromInputFile(Constants.InputFileLocation, dataSheetName, "TCName", dataRow);
					userRole = getDataFromInputFile(Constants.InputFileLocation, dataSheetName, "userRole", dataRow);
					TCDescription = getDataFromInputFile(Constants.InputFileLocation, dataSheetName, "TestCaseDescription", dataRow);
					CustomerNumber = getDataFromInputFile(Constants.InputFileLocation, dataSheetName, "CustomerNumber", dataRow);
					CustomerName = getDataFromInputFile(Constants.InputFileLocation, dataSheetName, "CustomerName", dataRow);
					ProductNumber = getDataFromInputFile(Constants.InputFileLocation, dataSheetName, "ProductNumber", dataRow);
					ProductNumber1 = getDataFromInputFile(Constants.InputFileLocation, dataSheetName, "ProductNumber1", dataRow);
					PONumber = getDataFromInputFile(Constants.InputFileLocation, dataSheetName, "PONumber", dataRow);
					Quantity = getDataFromInputFile(Constants.InputFileLocation, dataSheetName, "Quantity", dataRow);
					recommendationsFlag =getDataFromInputFile(Constants.InputFileLocation, dataSheetName, "recommendationsFlag", dataRow);
					promoSummaryFlag =getDataFromInputFile(Constants.InputFileLocation, dataSheetName, "promoSummaryFlag", dataRow);
					withDepartmentFlag =getDataFromInputFile(Constants.InputFileLocation, dataSheetName, "withDepartment", dataRow);
					PickingUp = getDataFromInputFile(Constants.InputFileLocation, dataSheetName, "PickingUp", dataRow);
					// Get the data(s) from input data files
					if (referInputData) {
						username = getDataFromInputFileLoginSheet(Constants.InputFileLocation, dataSheetName,Constants.RoleColumn, dataRow, "Username");
						password = getDataFromInputFileLoginSheet(Constants.InputFileLocation, dataSheetName,Constants.RoleColumn, dataRow, "Password");

						if (username == null || password == null) {
							username = getDataFromInputFile(Constants.InputFileLocation, dataSheetName, "Username",dataRow);
							password = getDataFromInputFile(Constants.InputFileLocation, dataSheetName, "Password",dataRow);
						}
					}

					if (!tempRole.equalsIgnoreCase(userRole) || FailStepCount > 0) {
						launchApp();
						launchAndLogin = true;
					}

					switch (TCName.toUpperCase()) {
					case "TC001":
						TestCaseName = this.getClass().getSimpleName() + "_" + TCName + "_" + TCDescription + "_" + userRole;
						TC001();
						break;
					case "TC002":
						TestCaseName = this.getClass().getSimpleName() + "_" + TCName + "_" + TCDescription + "_" + userRole;
						TC002();
						break;
					
				case "TC003":
					TestCaseName = this.getClass().getSimpleName() + "_" + TCName + "_" + TCDescription + "_" + userRole;
					TC003();
					break;
				}
					tempRole = userRole;
					launchAndLogin = false;
				}
				System.out.println(
						"*************************************************************************************************");
				System.out.println(
						"*************************************************************************************************");
			} finally {
				report.endTest(logger);
				destroyDriver();
			}
		}
	}

	public void launchApp() throws Exception {
		// Create and assign the mobile driver
		if (driver != null) {
			driver.quit();
		}
		createMobileDriver(deviceName, platformVersion, platformName, bundleId, udid);
		this.driver = getWebDriver();
	}

	public void TC001() throws Exception {
		startTestScript(TestCaseName, deviceDetails);
		reportTestCase(driver, TestCaseName, deviceDetails, "TC001_Verify Main Menu and Settings_TM or CM",
				"Verfiy Settings and Main Menu_TM or CM");
		try {
			login.login(TestCaseName, deviceDetails, launchAndLogin, username, password, userRole);
			if (userRole.equalsIgnoreCase("CMUser")) {
				Orders.verifyOrdersPageIsDisplayed(TestCaseName, deviceDetails);
				customers.customerChange(TestCaseName, deviceDetails);
				customers.verifyLocationPageIsDisplayed(TestCaseName, deviceDetails);
				customers.selectCustomer(TestCaseName, deviceDetails, CustomerNumber);
			} else if (userRole.equalsIgnoreCase("TMUser")){
				customers.verifyCustomerPageIsDisplayed(TestCaseName, deviceDetails);
				customers.selectCustomer(TestCaseName, deviceDetails, CustomerNumber);
			} else if (userRole.equalsIgnoreCase("NonSalesUser")){
				FlyinMenu.verifyDivisionsPageIsDisplayed(TestCaseName, deviceDetails);
				FlyinMenu.nonSalesUserDivision(TestCaseName, deviceDetails);
			}
			FlyinMenu.clickFlyinMenuOrBackButton(TestCaseName, deviceDetails);
			if(userRole.equalsIgnoreCase("CMUser")||userRole.equalsIgnoreCase("TMUser"))
			{
			FlyinMenu.verifyMainMenu(TestCaseName, deviceDetails);
			FlyinMenu.verifyPersonalNotesInMenu(TestCaseName, deviceDetails);
			FlyinMenu.verifyOurExclusivesInMenu(TestCaseName, deviceDetails);
			}
			else if(userRole.equalsIgnoreCase("NonSalesUser")) {
				FlyinMenu.verifyNonSalesUserMainMenu(TestCaseName, deviceDetails);
			}
			FlyinMenu.verifySettings(TestCaseName, deviceDetails, userRole);
			FlyinMenu.verifySecurity(TestCaseName, deviceDetails);
			FlyinMenu.verifyPreferences(TestCaseName, deviceDetails,userRole);
			FlyinMenu.verifyAboutScreen(TestCaseName, deviceDetails);
			FlyinMenu.verifyReleaseNotes(TestCaseName, deviceDetails);
			FlyinMenu.verifyProvideFeedback(TestCaseName, deviceDetails);
			login.secureSignOut(TestCaseName, deviceDetails);
			endTestScript(driver, TestCaseName, deviceDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void TC002() throws Exception {
		startTestScript(TestCaseName, deviceDetails);
		reportTestCase(driver, TestCaseName, deviceDetails, "TC001_Verify Main Menu and Help_TM or CM",
				"Verfiy Help and Main Menu_TM or CM");
		try {
			login.login(TestCaseName, deviceDetails, launchAndLogin, username, password, userRole);
			if (userRole.equalsIgnoreCase("CMUser")) {
				Orders.verifyOrdersPageIsDisplayed(TestCaseName, deviceDetails);
				customers.customerChange(TestCaseName, deviceDetails);
				customers.verifyLocationPageIsDisplayed(TestCaseName, deviceDetails);
				customers.selectCustomer(TestCaseName, deviceDetails, CustomerNumber);
			} else if (userRole.equalsIgnoreCase("TMUser")){
				customers.verifyCustomerPageIsDisplayed(TestCaseName, deviceDetails);
				customers.selectCustomer(TestCaseName, deviceDetails, CustomerNumber);
			}
			FlyinMenu.clickFlyinMenuOrBackButton(TestCaseName, deviceDetails);
			FlyinMenu.verifySettings(TestCaseName, deviceDetails, userRole);
			FlyinMenu.verifyHelp(TestCaseName, deviceDetails, userRole);
			FlyinMenu.clickFlyinMenuOrBackButton(TestCaseName, deviceDetails);
			FlyinMenu.clickFlyinMenuOrBackButton(TestCaseName, deviceDetails);
			login.secureSignOut(TestCaseName, deviceDetails);
			endTestScript(driver, TestCaseName, deviceDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
			
	public void TC003() throws IOException, InterruptedException {
		startTestScript(TestCaseName, deviceDetails);
		reportTestCase(driver, TestCaseName, deviceDetails, "TC001_Verify Our Exclusives", "Verify Our Exclusives");
		try {
			login.validLogin(TestCaseName, deviceDetails, username, password, userRole);
			FlyinMenu.userLevelHomeScreen(TestCaseName, deviceDetails, userRole, CustomerNumber, withDepartmentFlag);
			
			customers.clickFlyinMenu(TestCaseName, deviceDetails);
			if (recommendationsFlag.equalsIgnoreCase("NO") && promoSummaryFlag.equalsIgnoreCase("NO")) {
				FlyinMenu.verifyOurExclusivesIsNotDisplayed(TestCaseName, deviceDetails);
			}
			if (recommendationsFlag.equalsIgnoreCase("YES") || promoSummaryFlag.equalsIgnoreCase("YES")) {
				FlyinMenu.verifyOurExclusives(TestCaseName, deviceDetails);
				if (recommendationsFlag.equalsIgnoreCase("YES") && promoSummaryFlag.equalsIgnoreCase("NO")) {
					FlyinMenu.verifyRecommendationsInFlyInMenu(TestCaseName, deviceDetails);
				} else if (promoSummaryFlag.equalsIgnoreCase("YES") && recommendationsFlag.equalsIgnoreCase("NO")) {
					FlyinMenu.verifyPromotionSummaryInFlyInMenu(TestCaseName, deviceDetails);
				} else if (recommendationsFlag.equalsIgnoreCase("YES") && promoSummaryFlag.equalsIgnoreCase("YES")) {
					FlyinMenu.verifyRecommendationsInFlyInMenu(TestCaseName, deviceDetails);
					FlyinMenu.verifyPromotionSummaryInFlyInMenu(TestCaseName, deviceDetails);
				}
			}
			login.SignOut(TestCaseName, deviceDetails);
			endTestScript(driver, TestCaseName, deviceDetails);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	





}

