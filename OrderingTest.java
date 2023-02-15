package com.salesTool.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;
import com.salesTool.common.BaseTest;
import com.salesTool.util.Constants;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class OrderingTest extends BaseTest {

	String TestCaseName = this.getClass().getSimpleName();
	String dataSheetName = "OrdersTest";
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
	String userName = "";
	String deviceDetails = "";
	String executionRows = "";
	int totalInputDataRows = 0;
	String username = null;
	String password = null;
	boolean referInputData = false;
	String TCName = "";
	String TCDescription = "";
	boolean newUser = false;
	String userRole = "";
	String tempRole = "";
	String Description = "";
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
	String PONumber1 = "";
	String ShoppingList = "";
	String replaceProductNumber= "";
	String withDepartmentFlag= "";
	String screen = "";

	@Test
	public void ST_001_Order_Orders() throws Exception {

		// Get the total number of rows from the execution file
		// for the specified test script name. The sting will be returned with the rows
		// Ex: 2,4
		getExecutionRows = getExecutionRows(TestCaseName);
		String dataSheetName = "OrderingTest";
		System.out.println("Total Execution Rows : " + getExecutionRows);

		// Split the rows and put it in an array
		totalExecutionRows = getExecutionRows.split(",");

		// Loop through the number of times the script has to be executed
		// in different devices
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

				// Get the execution rows from the execution file. The scripts will be executed
				// for the row numbers specified in the file.
				// totalInputDataRows = getRowsFromInputFile(Constants.InputFileLocation,
				// dataSheetName);
				String[] returnRows = returnExecutionRows(executionRows);
				// Loop through the number of times the script has to be executed with different
				// data
				for (int execLoop = 0; execLoop < returnRows.length; execLoop++) {
					testStepStatus = true;

					dataRow = Integer.parseInt(returnRows[execLoop]) + 1;
					TCName = getDataFromInputFile(Constants.InputFileLocation, dataSheetName, "TCName", dataRow);
					userRole = getDataFromInputFile(Constants.InputFileLocation, dataSheetName, "userRole", dataRow);
					Description = getDataFromInputFile(Constants.InputFileLocation, dataSheetName, "Description",
							dataRow);

					TCDescription = getDataFromInputFile(Constants.InputFileLocation, dataSheetName,
							"TestCaseDescription", dataRow);
					CustomerNumber = getDataFromInputFile(Constants.InputFileLocation, dataSheetName, "CustomerNumber",
							dataRow);
					CustomerName = getDataFromInputFile(Constants.InputFileLocation, dataSheetName, "CustomerName",
							dataRow);
					ProductNumber = getDataFromInputFile(Constants.InputFileLocation, dataSheetName, "ProductNumber",
							dataRow);
					ProductNumber1 = getDataFromInputFile(Constants.InputFileLocation, dataSheetName, "ProductNumber1",
							dataRow);
					PONumber = getDataFromInputFile(Constants.InputFileLocation, dataSheetName, "PONumber", dataRow);
					replaceProductNumber=getDataFromInputFile(Constants.InputFileLocation, dataSheetName, "ReplaceProductNumber", dataRow);
					PONumber1 = getDataFromInputFile(Constants.InputFileLocation, dataSheetName, "PONumber1", dataRow);
					ShoppingList = getDataFromInputFile(Constants.InputFileLocation, dataSheetName, "ShoppingList",
							dataRow);
					Quantity = getDataFromInputFile(Constants.InputFileLocation, dataSheetName, "Quantity", dataRow);
					withDepartmentFlag = getDataFromInputFile(Constants.InputFileLocation, dataSheetName, "WithDepartmentFlag", dataRow);
					screen = getDataFromInputFile(Constants.InputFileLocation, dataSheetName, "Screen", dataRow);
					
					// Get the data(s) from input data files
					if (referInputData) {
						username = getDataFromInputFileLoginSheet(Constants.InputFileLocation, dataSheetName,
								Constants.RoleColumn, dataRow, "Username");
						password = getDataFromInputFileLoginSheet(Constants.InputFileLocation, dataSheetName,
								Constants.RoleColumn, dataRow, "Password");

						if (username == null || password == null) {
							username = getDataFromInputFile(Constants.InputFileLocation, dataSheetName, "Username",
									dataRow);
							password = getDataFromInputFile(Constants.InputFileLocation, dataSheetName, "Password",
									dataRow);
						}
					}

					if (!tempRole.equalsIgnoreCase(userRole) || FailStepCount > 0) {
						launchApp();
						launchAndLogin = true;
					}

					switch (TCName.toUpperCase()) {
					case "TC001":
						TestCaseName = this.getClass().getSimpleName() + "_" + TCName + "_" + TCDescription + "_"
								+ userRole;
						TC001();
						break;
					case "TC002":
						TestCaseName = this.getClass().getSimpleName() + "_" + TCName + "_" + TCDescription + "_"
								+ userRole;
						TC002();
						break;
					case "TC003":
						TestCaseName = this.getClass().getSimpleName() + "_" + TCName + "_" + TCDescription + "_"
								+ userRole;
						TC003();
						break;
					case "TC004":
						TestCaseName = this.getClass().getSimpleName() + "_" + TCName + "_" + TCDescription + "_"
								+ userRole;
						TC004();
						break;
					case "TC005":
						TestCaseName = this.getClass().getSimpleName() + "_" + TCName + "_" + TCDescription + "_"
								+ userRole;
						TC005();
						break;
						
					case "TC006":
						TestCaseName = this.getClass().getSimpleName() + "_" + TCName + "_" + TCDescription + "_"
								+ userRole;
						TC006();
						break;	
					
					case "TC007":
						TestCaseName = this.getClass().getSimpleName() + "_" + TCName + "_" + TCDescription + "_"
								+ userRole;
						TC007();
						break;
					case "TC008":
						TestCaseName = this.getClass().getSimpleName() + "_" + TCName + "_" + TCDescription + "_"
								+ userRole;
						TC008();
						break;
					case "TC009":
						TestCaseName = this.getClass().getSimpleName() + "_" + TCName + "_" + TCDescription + "_"
								+ userRole;
						TC009();
						break;
					case "TC010":
						TestCaseName = this.getClass().getSimpleName() + "_" + TCName + "_" + TCDescription + "_"
								+ userRole;
						TC010();
						break;
					case "TC011":
						TestCaseName = this.getClass().getSimpleName() + "_" + TCName + "_" + TCDescription + "_"
								+ userRole;
						TC011();
						break;	
					case "TC012":
						TestCaseName = this.getClass().getSimpleName() + "_" + TCName + "_" + TCDescription + "_"
								+ userRole;
						TC012();
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

	// TC001_US Foods Mobile -Order through Search
	public void TC001() throws Exception {
		startTestScript(TestCaseName, deviceDetails);
		reportTestCase(driver, TestCaseName, deviceDetails, "TC001_OrdersTest",
				"Order through Search Page");
		try {
			login.validLogin(TestCaseName, deviceDetails, username, password, userRole);
			FlyinMenu.userLevelHomeScreen(TestCaseName, deviceDetails, userRole, CustomerNumber, withDepartmentFlag);
			Orders.selectNewOrder(TestCaseName, deviceDetails);
			Search.verifySearchPageIsDisplayed(TestCaseName, deviceDetails);
			Search.searchProduct(TestCaseName, deviceDetails, ProductNumber);
			Search.verifySearchPageIsDisplayed(TestCaseName, deviceDetails);
			Search.enterQuantity(TestCaseName, deviceDetails);
			Orders.clickReviewOrderButton(TestCaseName, deviceDetails);
			reviewOrder.verifyReviewOrderPageIsDisplayed(TestCaseName, deviceDetails);
			Orders.setPONumber(TestCaseName, deviceDetails, PONumber);
			Orders.submitOrder(TestCaseName, deviceDetails);
			Orders.orderConfirmationWithOrWithoutException(TestCaseName, deviceDetails);
			login.secureSignOut(TestCaseName, deviceDetails);
			endTestScript(driver, TestCaseName, deviceDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// TC001-US Foods Mobile -Order through NewlyPurchased/Order through
	// Contracted/Order through Scoop/Equipment & Supplies/ Locally Sourced
	public void TC002() throws Exception {
		startTestScript(TestCaseName, deviceDetails);
		reportTestCase(driver, TestCaseName, deviceDetails, "TC001_OrdersTest", "Order through List Screen");
		try {
			login.validLogin(TestCaseName, deviceDetails, username, password, userRole);
			FlyinMenu.userLevelHomeScreen(TestCaseName, deviceDetails, userRole, CustomerNumber, withDepartmentFlag);
			Orders.selectNewOrder(TestCaseName, deviceDetails);
			Search.verifySearchPageIsDisplayed(TestCaseName, deviceDetails);
			
			if (screen.equalsIgnoreCase("Newly Purchased")) {
				Search.clickNewlyPurchased(TestCaseName, deviceDetails);
			}
			if (screen.equalsIgnoreCase("Contracted")) {
				Search.clickContracted(TestCaseName, deviceDetails);
			}
			if (screen.equalsIgnoreCase("Scoop")) {
				Search.clickScoop(TestCaseName, deviceDetails);
			}
			if (screen.equalsIgnoreCase("Equipment & Supplies")) {
				Search.clickEquipmentAndSupplies(TestCaseName, deviceDetails);
			}
			if (screen.equalsIgnoreCase("Locally Sourced")) {
				Search.clickLocallySourced(TestCaseName, deviceDetails);
			}
			Search.searchProductInListScreens(TestCaseName, deviceDetails, ProductNumber);
			ProductOverview.enterProductDetail(TestCaseName, deviceDetails);
			ProductOverview.verifyProductDetailScreen(TestCaseName, deviceDetails,userRole);
			FlyinMenu.clickFlyinMenuOrBackButton(TestCaseName, deviceDetails);
			Search.enterQuantity(TestCaseName, deviceDetails);
			Orders.clickReviewOrderButton(TestCaseName, deviceDetails);
			reviewOrder.verifyReviewOrderPageIsDisplayed(TestCaseName, deviceDetails);
			reviewOrder.enterOrderDetailScreen(TestCaseName, deviceDetails);
			Orders.verifyOrderDetailsPageIsDisplayed(TestCaseName, deviceDetails);
			Search.searchProductInListScreens(TestCaseName, deviceDetails, ProductNumber);
			ProductOverview.enterProductDetail(TestCaseName, deviceDetails);
			FlyinMenu.clickFlyinMenuOrBackButton(TestCaseName, deviceDetails);
			FlyinMenu.clickFlyinMenuOrBackButton(TestCaseName, deviceDetails);
			Orders.setPONumber(TestCaseName, deviceDetails, PONumber);
			Orders.submitOrder(TestCaseName, deviceDetails);
			Orders.orderConfirmationWithOrWithoutException(TestCaseName, deviceDetails);			
			Thread.sleep(10000);
			login.secureSignOut(TestCaseName, deviceDetails);
			endTestScript(driver, TestCaseName, deviceDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// TC003_SalesTool_Validate Customer has submit the Order thru -->search -->
	// Shopping List
	public void TC003() throws Exception {
		startTestScript(TestCaseName, deviceDetails);
		reportTestCase(driver, TestCaseName, deviceDetails, "TC003_Shopping List OG Order",
				"Order thru search-->Shopping List");
		try {
			login.validLogin(TestCaseName, deviceDetails, username, password, userRole);
			FlyinMenu.userLevelHomeScreen(TestCaseName, deviceDetails, userRole, CustomerNumber, withDepartmentFlag);
			Orders.selectNewOrder(TestCaseName, deviceDetails);
			Search.verifySearchPageIsDisplayed(TestCaseName, deviceDetails);
			Search.viewAllShoppingList(TestCaseName, deviceDetails);
			Orders.selectShoppingListWithSwipe(TestCaseName, deviceDetails, ShoppingList);
			Search.verifyListDetailsPageIsDisplayed(TestCaseName, deviceDetails);
			Search.searchProductInListScreens(TestCaseName, deviceDetails, ProductNumber);
			Search.enterQuantity(TestCaseName, deviceDetails);
			Orders.clickReviewOrderButton(TestCaseName, deviceDetails);
			reviewOrder.verifyReviewOrderPageIsDisplayed(TestCaseName, deviceDetails);
			reviewOrder.enterOrderDetailScreen(TestCaseName, deviceDetails);
			Orders.verifyOrderDetailsPageIsDisplayed(TestCaseName, deviceDetails);
			Search.searchProductInListScreens(TestCaseName, deviceDetails, ProductNumber);
			ProductOverview.enterProductDetail(TestCaseName, deviceDetails);
			FlyinMenu.clickFlyinMenuOrBackButton(TestCaseName, deviceDetails);
			FlyinMenu.clickFlyinMenuOrBackButton(TestCaseName, deviceDetails);
			Orders.setPONumber(TestCaseName, deviceDetails, PONumber);
			Orders.submitOrder(TestCaseName, deviceDetails);
			Orders.orderConfirmationWithOrWithoutException(TestCaseName, deviceDetails);
			login.secureSignOut(TestCaseName, deviceDetails);
			endTestScript(driver, TestCaseName, deviceDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// TC004_SalesTool_Validate Customer has submit the Order thru -->search -->
	// Exception Order
	public void TC004() throws Exception {
		startTestScript(TestCaseName, deviceDetails);
		reportTestCase(driver, TestCaseName, deviceDetails, "TC004_Exceptions Order",
				"Orders Search--> Exception Order Submitted");
		try {
			login.login(TestCaseName, deviceDetails, launchAndLogin, username, password, userRole);
			FlyinMenu.userLevelHomeScreen(TestCaseName, deviceDetails, userRole, CustomerNumber, withDepartmentFlag);
			// Orders.SelectNewOrder(TestCaseName, deviceDetails);
			FlyinMenu.clickFlyinMenuOrBackButton(TestCaseName, deviceDetails);
			FlyinMenu.selectSearch(TestCaseName, deviceDetails);
			Search.verifySearchPageIsDisplayed(TestCaseName, deviceDetails);
			Search.searchProduct(TestCaseName, deviceDetails, ProductNumber);
			Search.verifySearchPageIsDisplayed(TestCaseName, deviceDetails);
			Search.enterQuantity(TestCaseName, deviceDetails);
			Orders.addToOrderOrAddProducts(TestCaseName, deviceDetails);
			Orders.verifyOrdersPageIsDisplayed(TestCaseName, deviceDetails);
			Orders.selectNewOrder(TestCaseName, deviceDetails);
			reviewOrder.verifyReviewOrderPageIsDisplayed(TestCaseName, deviceDetails);
			Orders.setPONumber(TestCaseName, deviceDetails, PONumber);
			FlyinMenu.clickFlyinMenuOrBackButton(TestCaseName, deviceDetails);
			Orders.verifyOrdersPageIsDisplayed(TestCaseName, deviceDetails);
			Orders.selectFirstOrder(TestCaseName, deviceDetails);
			reviewOrder.verifyReviewOrderPageIsDisplayed(TestCaseName, deviceDetails);
			Orders.submitOrder(TestCaseName, deviceDetails);
			Orders.ExceptionOrder(TestCaseName, deviceDetails);
			Orders.verifyOrderExceptionsPageIsDisplayed(TestCaseName, deviceDetails);
			Orders.clickFinished(TestCaseName, deviceDetails);
			Orders.orderConfirmationWithOrWithoutException(TestCaseName, deviceDetails);
			login.secureSignOut(TestCaseName, deviceDetails);
			endTestScript(driver, TestCaseName, deviceDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// TC005_SalesTool_Validate Customer has submit the Order -->NonCES and CES or Direct Product
	// Split Order
	public void TC005() throws Exception {
		startTestScript(TestCaseName, deviceDetails);
		reportTestCase(driver, TestCaseName, deviceDetails, "TC005_Split Order", "Split Order Validation");
		try {
			login.validLogin(TestCaseName, deviceDetails, username, password, userRole);
			FlyinMenu.userLevelHomeScreen(TestCaseName, deviceDetails, userRole, CustomerNumber, withDepartmentFlag);
			FlyinMenu.clickFlyinMenuOrBackButton(TestCaseName, deviceDetails);
			FlyinMenu.selectSearch(TestCaseName, deviceDetails);
			Search.verifySearchPageIsDisplayed(TestCaseName, deviceDetails);
			Search.searchProduct(TestCaseName, deviceDetails, ProductNumber);
			Search.enterQuantity(TestCaseName, deviceDetails);
			Orders.addToOrderOrAddProducts(TestCaseName, deviceDetails);
			Orders.verifyOrdersPageIsDisplayed(TestCaseName, deviceDetails);
			Orders.selectNewOrder(TestCaseName, deviceDetails);
			reviewOrder.verifyReviewOrderPageIsDisplayed(TestCaseName, deviceDetails);
			Orders.setPONumber(TestCaseName, deviceDetails, PONumber);
			Orders.addToOrderOrAddProducts(TestCaseName, deviceDetails);
			Search.verifySearchPageIsDisplayed(TestCaseName, deviceDetails);
			Search.searchProduct(TestCaseName, deviceDetails, ProductNumber1);
			Search.verifySearchPageIsDisplayed(TestCaseName, deviceDetails);
			Search.enterQuantity(TestCaseName, deviceDetails);
			Orders.clickReviewOrderButton(TestCaseName, deviceDetails);
			reviewOrder.verifyReviewOrderPageIsDisplayed(TestCaseName, deviceDetails);
			reviewOrder.vendorShipBannerValidation(TestCaseName, deviceDetails);
			Orders.submitOrder(TestCaseName, deviceDetails);
			Orders.splitOrderPopUpMsg(TestCaseName, deviceDetails);
			Orders.orderConfirmationWithOrWithoutException(TestCaseName, deviceDetails);
			login.secureSignOut(TestCaseName, deviceDetails);
			endTestScript(driver, TestCaseName, deviceDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// TC006_SalesTool_Validate Customer has submit the Order through You May Also Need
	public void TC006() throws Exception {
		startTestScript(TestCaseName, deviceDetails);
		reportTestCase(driver, TestCaseName, deviceDetails, "TC005_Split Order", "Split Order Validation");
		try {
			login.validLogin(TestCaseName, deviceDetails, username, password, userRole);
			FlyinMenu.userLevelHomeScreen(TestCaseName, deviceDetails, userRole, CustomerNumber, withDepartmentFlag);
			FlyinMenu.clickFlyinMenuOrBackButton(TestCaseName, deviceDetails);
			FlyinMenu.selectSearch(TestCaseName, deviceDetails);
			Search.verifySearchPageIsDisplayed(TestCaseName, deviceDetails);
			Search.searchProduct(TestCaseName, deviceDetails, ProductNumber);
			ProductOverview.enterProductDetail(TestCaseName, deviceDetails);
			ProductOverview.youMayAlsoNeedScreenValidation(TestCaseName, deviceDetails);
			Search.enterQuantity(TestCaseName, deviceDetails);
			Orders.addToOrderOrAddProducts(TestCaseName, deviceDetails);
			Orders.verifyOrdersPageIsDisplayed(TestCaseName, deviceDetails);
			Orders.selectNewOrder(TestCaseName, deviceDetails);
			reviewOrder.verifyReviewOrderPageIsDisplayed(TestCaseName, deviceDetails);
			Orders.setPONumber(TestCaseName, deviceDetails, PONumber);
			Orders.submitOrder(TestCaseName, deviceDetails);
			Orders.orderConfirmationWithOrWithoutException(TestCaseName, deviceDetails);
			login.secureSignOut(TestCaseName, deviceDetails);
			endTestScript(driver, TestCaseName, deviceDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Order through Personal Notes
	public void TC007() throws Exception {
		startTestScript(TestCaseName, deviceDetails);
		reportTestCase(driver, TestCaseName, deviceDetails, TCName + "_" + TCDescription,
				TCName + "_" + TCDescription + "_" + userRole);
		try {
			login.validLogin(TestCaseName, deviceDetails, username, password, userRole);
			FlyinMenu.userLevelHomeScreen(TestCaseName, deviceDetails, userRole, CustomerNumber, withDepartmentFlag);
			FlyinMenu.clickFlyinMenuOrBackButton(TestCaseName, deviceDetails);
			FlyinMenu.clickNotificationPersonalNotes(TestCaseName, deviceDetails);
			Search.enterQuantity(TestCaseName, deviceDetails);
			Orders.addToOrderOrAddProducts(TestCaseName, deviceDetails);
			Orders.selectNewOrder(TestCaseName, deviceDetails);
			reviewOrder.verifyReviewOrderPageIsDisplayed(TestCaseName, deviceDetails);
			Orders.setPONumber(TestCaseName, deviceDetails, PONumber);
			Orders.submitOrder(TestCaseName, deviceDetails);
			Orders.orderConfirmationWithOrWithoutException(TestCaseName, deviceDetails);
			login.secureSignOut(TestCaseName, deviceDetails);
			endTestScript(driver, TestCaseName, deviceDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// --> MLM Shopping List adding primary and secondary product and submit order
			public void TC008() throws InterruptedException, IOException {

				startTestScript(TestCaseName, deviceDetails);
				reportTestCase(driver, TestCaseName, deviceDetails,"TC016_Orders usinng MLM Shopping list","Orders usinng MLM Shopping list primary and secondary products");
				try {
					login.validLogin(TestCaseName, deviceDetails, username, password, userRole);
					FlyinMenu.userLevelHomeScreen(TestCaseName, deviceDetails, userRole, CustomerNumber, withDepartmentFlag);
					//Orders.selectNewOrder(TestCaseName, deviceDetails);
					//Orders.backButton(TestCaseName, deviceDetails);
					FlyinMenu.clickFlyinMenuOrBackButton(TestCaseName, deviceDetails);
					FlyinMenu.selectSearch(TestCaseName, deviceDetails);
					Search.verifySearchPageIsDisplayed(TestCaseName, deviceDetails);
					Search.viewAllShoppingList(TestCaseName, deviceDetails);
					Orders.selectShoppingList(TestCaseName, deviceDetails, ShoppingList);
					Orders.verifyListDetailsPageIsDisplayed(TestCaseName, deviceDetails);
					Search.searchProductInListScreens(TestCaseName, deviceDetails, ProductNumber);
					//Orders.searchProduct(TestCaseName, deviceDetails, ProductNumber);
					Search.enterQuantity(TestCaseName, deviceDetails);
					Orders.alternateProductTextdisplayed(TestCaseName, deviceDetails);
					Orders.clickAlternateProductsAvailabletext(TestCaseName, deviceDetails);
					Orders.alternateProductsPagevalidation(TestCaseName, deviceDetails);
					//Orders.alternateProductNumbervalidation(TestCaseName, deviceDetails,ProductNumber1);
					Search.enterQuantity(TestCaseName, deviceDetails);
					FlyinMenu.clickFlyinMenuOrBackButton(TestCaseName, deviceDetails);			
					//Orders.orderGuideSearchProduct(TestCaseName, deviceDetails, ProductNumber);
					//Orders.orderGuideQuantityEnter(TestCaseName, deviceDetails, Quantity);
					Orders.addToOrder(TestCaseName, deviceDetails);
					Orders.selectNewOrder(TestCaseName, deviceDetails);
					Orders.setPONumber(TestCaseName, deviceDetails, PONumber);
					Orders.submitOrder(TestCaseName, deviceDetails);
					Orders. verifyOrderExceptionsPageIsDisplayed(TestCaseName, deviceDetails);
					Orders.finishedException(TestCaseName, deviceDetails);
					Orders.orderConfirmationWithOrWithoutException(TestCaseName, deviceDetails);
					login.secureSignOut(TestCaseName, deviceDetails);
					endTestScript(driver, TestCaseName, deviceDetails);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			// TC0017_SalesTool_Verify Alternate products available text on order exception screen
			public void TC009() throws InterruptedException, IOException {
				startTestScript(TestCaseName, deviceDetails);
				reportTestCase(driver, TestCaseName, deviceDetails, "TC017_Exception screen_Alternate Products available text validation",
						"Exception screen_Alternate Products available text validation");
				try {
					login.validLogin(TestCaseName, deviceDetails, username, password, userRole);
					FlyinMenu.userLevelHomeScreen(TestCaseName, deviceDetails, userRole, CustomerNumber, withDepartmentFlag);
					//Orders.selectNewOrder(TestCaseName, deviceDetails);
					//Orders.backButton(TestCaseName, deviceDetails);
					FlyinMenu.clickFlyinMenuOrBackButton(TestCaseName, deviceDetails);
					FlyinMenu.selectSearch(TestCaseName, deviceDetails);
					Search.verifySearchPageIsDisplayed(TestCaseName, deviceDetails);
					Search.viewAllShoppingList(TestCaseName, deviceDetails);
					Orders.selectShoppingList(TestCaseName, deviceDetails, ShoppingList);
					Orders.verifyListDetailsPageIsDisplayed(TestCaseName, deviceDetails);
					Search.searchProductInListScreens(TestCaseName, deviceDetails, ProductNumber);
					
					//Orders.searchProduct(TestCaseName, deviceDetails, ProductNumber);
					Search.enterQuantity(TestCaseName, deviceDetails);
					Orders.alternateProductTextdisplayed(TestCaseName, deviceDetails);
					Orders.clickAlternateProductsAvailabletext(TestCaseName, deviceDetails);
					Orders.alternateProductsPagevalidation(TestCaseName, deviceDetails);
					Orders.alternateProductNumbervalidation(TestCaseName, deviceDetails,ProductNumber1);
					FlyinMenu.clickFlyinMenuOrBackButton(TestCaseName, deviceDetails);			
					Orders.addToOrder(TestCaseName, deviceDetails);
					Orders.selectNewOrder(TestCaseName, deviceDetails);
					Orders.setPONumber(TestCaseName, deviceDetails, PONumber);
					Orders.submitOrder(TestCaseName, deviceDetails);
					Orders.verifyOrderExceptionsPageIsDisplayed(TestCaseName, deviceDetails);
					Orders.alternateProductTextnotdisplayed(TestCaseName, deviceDetails);
					Orders.finishedException(TestCaseName, deviceDetails);
					Orders.expOrderConfirmation(TestCaseName, deviceDetails);
					Orders.verifyOrdersPageIsDisplayed(TestCaseName, deviceDetails);
					Orders.verifyOrderPlacedWithPONumber(TestCaseName, deviceDetails, PONumber);
					login.secureSignOut(TestCaseName, deviceDetails);
					endTestScript(driver, TestCaseName, deviceDetails);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		//Market Place Direct Order
			public void TC010() throws Exception {
				startTestScript(TestCaseName, deviceDetails);
				reportTestCase(driver, TestCaseName, deviceDetails, "TC001_OrdersTest",
						"Order through Search Page");
				try {
					login.validLogin(TestCaseName, deviceDetails, username, password, userRole);
					FlyinMenu.userLevelHomeScreen(TestCaseName, deviceDetails, userRole, CustomerNumber, withDepartmentFlag);
					Orders.selectNewOrder(TestCaseName, deviceDetails);
					Thread.sleep(5000);
					Search.verifySearchPageIsDisplayed(TestCaseName, deviceDetails);
					Search.searchProduct(TestCaseName, deviceDetails, ProductNumber);
					Search.verifySearchPageIsDisplayed(TestCaseName, deviceDetails);					
					Search.enterQuantity(TestCaseName, deviceDetails);
					Orders.clickReviewOrderButton(TestCaseName, deviceDetails);
					reviewOrder.verifyReviewOrderPageIsDisplayed(TestCaseName, deviceDetails);
					reviewOrder.enterOrderDetailScreen(TestCaseName, deviceDetails);
					Orders.verifyOrderDetailsPageIsDisplayed(TestCaseName, deviceDetails);
					Search.searchProductInListScreens(TestCaseName, deviceDetails, ProductNumber);
					ProductOverview.enterProductDetail(TestCaseName, deviceDetails);					
					FlyinMenu.clickFlyinMenuOrBackButton(TestCaseName, deviceDetails);
					FlyinMenu.clickFlyinMenuOrBackButton(TestCaseName, deviceDetails);
					Orders.setPONumber(TestCaseName, deviceDetails, PONumber);
					Orders.submitOrder(TestCaseName, deviceDetails);
					Orders.orderConfirmationWithOrWithoutException(TestCaseName, deviceDetails);
					Thread.sleep(8000);
					login.secureSignOut(TestCaseName, deviceDetails);
					endTestScript(driver, TestCaseName, deviceDetails);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			// TC008_SalesTool_Validate submitted order recovery pop-up- discard changes
			public void TC011() throws InterruptedException, IOException {
				startTestScript(TestCaseName, deviceDetails);
				reportTestCase(driver, TestCaseName, deviceDetails, "submitted order recovery pop-up discard changes",
						"submitted order recovery pop-up discard changes");
				try {
					login.validLogin(TestCaseName, deviceDetails, username, password, userRole);
					FlyinMenu.userLevelHomeScreen(TestCaseName, deviceDetails, userRole, CustomerNumber, withDepartmentFlag);
					Orders.selectNewOrder(TestCaseName, deviceDetails);					
					Search.verifySearchPageIsDisplayed(TestCaseName, deviceDetails);
					Search.searchProduct(TestCaseName, deviceDetails, ProductNumber);
					Search.verifySearchPageIsDisplayed(TestCaseName, deviceDetails);
					Search.enterQuantity(TestCaseName, deviceDetails);
					Orders.clickReviewOrderButton(TestCaseName, deviceDetails);
					reviewOrder.verifyReviewOrderPageIsDisplayed(TestCaseName, deviceDetails);
					Orders.setPONumber(TestCaseName, deviceDetails, PONumber);
					Orders.submitOrder(TestCaseName, deviceDetails);
					Orders.orderConfirmationWithOrWithoutException(TestCaseName, deviceDetails);
					reviewOrder.enterOrderDetailScreen(TestCaseName, deviceDetails);					
					Orders.orderRecoveryPopUpDiscard(TestCaseName, deviceDetails, PONumber, PONumber1);
					login.secureSignOut(TestCaseName, deviceDetails);
					endTestScript(driver, TestCaseName, deviceDetails);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}	
			// TC009_SalesTool_Validate submitted order recovery pop-up Save changes
			public void TC012() throws InterruptedException, IOException {
				startTestScript(TestCaseName, deviceDetails);
				reportTestCase(driver, TestCaseName, deviceDetails, "submitted order recovery pop-up save changes",
						"submitted order recovery pop-up save changes");
				try {
					login.validLogin(TestCaseName, deviceDetails, username, password, userRole);
					FlyinMenu.userLevelHomeScreen(TestCaseName, deviceDetails, userRole, CustomerNumber, withDepartmentFlag);
					Orders.selectNewOrder(TestCaseName, deviceDetails);					
					Search.verifySearchPageIsDisplayed(TestCaseName, deviceDetails);
					Search.searchProduct(TestCaseName, deviceDetails, ProductNumber);
					Search.verifySearchPageIsDisplayed(TestCaseName, deviceDetails);
					Search.enterQuantity(TestCaseName, deviceDetails);
					Orders.clickReviewOrderButton(TestCaseName, deviceDetails);
					reviewOrder.verifyReviewOrderPageIsDisplayed(TestCaseName, deviceDetails);
					Orders.setPONumber(TestCaseName, deviceDetails, PONumber);
					Orders.submitOrder(TestCaseName, deviceDetails);
					Orders.orderConfirmationWithOrWithoutException(TestCaseName, deviceDetails);
					reviewOrder.enterOrderDetailScreen(TestCaseName, deviceDetails);					
					Orders.orderRecoveryPopUpSave(TestCaseName, deviceDetails, PONumber, PONumber1);					
					Orders.orderConfirmationWithOrWithoutException(TestCaseName, deviceDetails);
					login.secureSignOut(TestCaseName, deviceDetails);
					endTestScript(driver, TestCaseName, deviceDetails);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			


}




