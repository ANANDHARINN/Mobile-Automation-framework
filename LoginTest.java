package com.salesTool.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import com.salesTool.util.Constants;
import com.salesTool.common.BaseTest;
import com.salesTool.pages.*;

import io.appium.java_client.MobileElement;

import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.ios.IOSDriver;

public class LoginTest extends BaseTest {
	String TestCaseName = this.getClass().getSimpleName();
	String dataSheetName = "SalesTool_Login";

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
	String bundleId = null;
	String udid = null;
	int totalInputDataRows = 0;
	String username = null;
	String password = null;
	boolean referInputData = false;
	String TCName = "";
	String TCDescription = "";
	boolean newUser = false;
	String userRole = "";
	String tempRole = "";
	int testStartCount = 0;
	boolean launchAndLogin = false;

	@Test
	public void LoginTest() throws Exception {
		getExecutionRows = getExecutionRows(TestCaseName);
		System.out.println("Total Execution Rows : " + getExecutionRows);
		String dataSheetName = "SalesTool_Login";
		totalExecutionRows = getExecutionRows.split(",");

		for (int iteration = 0; iteration < totalExecutionRows.length; iteration++) {
			try {
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
					TCDescription = getDataFromInputFile(Constants.InputFileLocation, dataSheetName,"TestCaseDescription", dataRow);

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
						testStartCount++;
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
					case "TC004":
						TestCaseName = this.getClass().getSimpleName() + "_" + TCName + "_" + TCDescription + "_" + userRole;
						TC004();
						break;
					}
					tempRole = userRole;
					testStartCount = 0;
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
		if (driver != null) {
			driver.quit();
		}
		createMobileDriver(deviceName, platformVersion, platformName, bundleId, udid);
		this.driver = getWebDriver();
	}

	public void TC001() throws IOException, InterruptedException {
		startReportingFiles(TestCaseName + "_" + deviceDetails);
		logger = report.startTest(TestCaseName + "_" + deviceDetails);
		reportTestCase(driver, TestCaseName, deviceDetails, TCName + "_" + TCDescription, TCName + "_" + TCDescription + "_" + userRole);
		try {
			login.emptySignInClick(TestCaseName, deviceDetails);
			login.verifyBecomeACustomerLink(TestCaseName, deviceDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}
		report.endTest(logger);
		endTest(driver, TestCaseName, deviceDetails);
		endReportingFiles(TestCaseName + "_" + deviceDetails);
	}

	public void TC002() throws IOException, InterruptedException {
		startReportingFiles(TestCaseName + "_" + deviceDetails);
		logger = report.startTest(TestCaseName + "_" + deviceDetails);
		reportTestCase(driver, TestCaseName, deviceDetails, TCName + "_" + TCDescription, TCName + "_" + TCDescription + "_" + userRole);
		try {
			login.invalidLoginInvalidUserIdInvalidPassword(TestCaseName, deviceDetails, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		report.endTest(logger);
		endTest(driver, TestCaseName, deviceDetails);
		endReportingFiles(TestCaseName + "_" + deviceDetails);
	}

	public void TC003() throws IOException, InterruptedException {
		startReportingFiles(TestCaseName + "_" + deviceDetails);
		logger = report.startTest(TestCaseName + "_" + deviceDetails);
		reportTestCase(driver, TestCaseName, deviceDetails, TCName + "_" + TCDescription, TCName + "_" + TCDescription + "_" + userRole);
		try {
			login.invalidLoginValidUserIdInvalidPassword(TestCaseName, deviceDetails, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		report.endTest(logger);
		endTest(driver, TestCaseName, deviceDetails);
		endReportingFiles(TestCaseName + "_" + deviceDetails);
	}

	public void TC004() throws IOException, InterruptedException {
		startReportingFiles(TestCaseName + "_" + deviceDetails);
		logger = report.startTest(TestCaseName + "_" + deviceDetails);
		reportTestCase(driver, TestCaseName, deviceDetails, TCName + "_" + TCDescription, TCName + "_" + TCDescription + "_" + userRole);
		try {
			login.validLogin(TestCaseName, deviceDetails, username, password, userRole);
			if (userRole.equalsIgnoreCase("TMUser")) {
				customers.verifyCustomerPageIsDisplayed(TestCaseName, deviceDetails);
				login.signOut(TestCaseName, deviceDetails);
			} else if (userRole.equalsIgnoreCase("CMUser")) {
				Orders.verifyOrdersPageIsDisplayed(TestCaseName, deviceDetails);
				login.secureSignOut(TestCaseName, deviceDetails);
			} else if (userRole.equalsIgnoreCase("NonSalesUser")) {
				FlyinMenu.verifyDivisionsPageIsDisplayed(TestCaseName, deviceDetails);
				FlyinMenu.nonSalesUserDivision(TestCaseName, deviceDetails);
				login.secureSignOut(TestCaseName, deviceDetails);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		report.endTest(logger);
		endTest(driver, TestCaseName, deviceDetails);
		endReportingFiles(TestCaseName + "_" + deviceDetails);
	}
}
