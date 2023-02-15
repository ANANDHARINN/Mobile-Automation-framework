package com.salesTool.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.salesTool.common.BaseTest;
import com.salesTool.util.Constants;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class SearchTest extends BaseTest {
	String TestCaseName = this.getClass().getSimpleName();
	String dataSheetName = "Search_Test";
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
	String ProductNumber = "";
	String ShoppingList = "";
	String ShoppingList2 = "";
	String executionRows = "";
	String Description = "";
	String bundleId = "";
	String udid = "";
	int totalInputDataRows = 0;
	String username = null;
	String userName = null;
	String password = null;
	boolean referInputData = false;
	String TCName = "";
	boolean newUser = false;
	String userRole = "";
	String Customer = "";
	String product = "";
	String DiscontinueProduct = "";
	String shoppingList = "";
	String tempRole = "";
	String CustomerNumber = "";
	String CustomerName = "";
	String RelatedObject = "";
	String ProductNumber1 = "";
	String Quantity = "";
	String PONumber = "";
	String PONumber1 = "";
	int testStartCount = 0;
	int testStartCountCM = 0;
	boolean launchAndLogin = false;
	String TCDescription = "";
	String replaceProductNumber= "";
	String productType="";
	String withDepartmentFlag = "";

	@Test
	public void Search() throws Exception {

		// Get the total number of rows from the execution file
		// for the specified test script name. The sting will be returned with the rows
		// Ex: 2,4
		getExecutionRows = getExecutionRows(TestCaseName);
		String dataSheetName = "Search_Test";
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
				userName = getDataFromInputFile(Constants.InputFileLocation, dataSheetName, "Username", dataRow);
				password = getDataFromInputFile(Constants.InputFileLocation, dataSheetName, "Password", dataRow);

				// Get the details of the device, this is to be used to reporting purpose
				deviceDetails = deviceModel + "-" + platformName + "-" + platformVersion;

				udid = getDataFromExecutionExcel(currentRow, "Udid");
				bundleId = getDataFromExecutionExcel(currentRow, "Bundleid");

				if (userName.contains("Data") || password.equals("Data")) {
					referInputData = true;
				}
				referInputData = true;
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
					Description = getDataFromInputFile(Constants.InputFileLocation, dataSheetName,
							"TestCaseDescription", dataRow);
					Customer = getDataFromInputFile(Constants.InputFileLocation, dataSheetName, "Customer", dataRow);
					product = getDataFromInputFile(Constants.InputFileLocation, dataSheetName, "Product", dataRow);
					DiscontinueProduct = getDataFromInputFile(Constants.InputFileLocation, dataSheetName,
							"DiscontinueProduct", dataRow);
					shoppingList = getDataFromInputFile(Constants.InputFileLocation, dataSheetName, "ShoppingList",
							dataRow);
					CustomerNumber = getDataFromInputFile(Constants.InputFileLocation, dataSheetName, "CustomerNumber",
							dataRow);
					CustomerName = getDataFromInputFile(Constants.InputFileLocation, dataSheetName, "CustomerName",
							dataRow);
					ShoppingList = getDataFromInputFile(Constants.InputFileLocation, dataSheetName, "ShoppingList",
							dataRow);
					ShoppingList2 = getDataFromInputFile(Constants.InputFileLocation, dataSheetName, "ShoppingList2",
							dataRow);
					ProductNumber = getDataFromInputFile(Constants.InputFileLocation, dataSheetName, "ProductNumber",
							dataRow);
					ProductNumber1 = getDataFromInputFile(Constants.InputFileLocation, dataSheetName, "ProductNumber1",
							dataRow);
					Quantity = getDataFromInputFile(Constants.InputFileLocation, dataSheetName, "ProductNumber1",
							dataRow);
					PONumber = getDataFromInputFile(Constants.InputFileLocation, dataSheetName, "PONumber", dataRow);
					
					replaceProductNumber=getDataFromInputFile(Constants.InputFileLocation, dataSheetName, "ReplaceProductNumber", dataRow);
					productType=getDataFromInputFile(Constants.InputFileLocation, dataSheetName, "ProductType", dataRow);
					withDepartmentFlag=getDataFromInputFile(Constants.InputFileLocation, dataSheetName, "WithDepartmentFlag", dataRow);
					
					// Get the data(s) from input data files
					if (referInputData) {
						userName = getDataFromInputFileLoginSheet(Constants.InputFileLocation, dataSheetName,
								Constants.RoleColumn, dataRow, "Username");
						password = getDataFromInputFileLoginSheet(Constants.InputFileLocation, dataSheetName,
								Constants.RoleColumn, dataRow, "Password");

						if (userName == null || password == null) {
							userName = getDataFromInputFile(Constants.InputFileLocation, dataSheetName, "Username",
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
						TestCaseName = this.getClass().getSimpleName() + "_" + dataSheetName + "_" + TCName + "_"
								+ Description + "_" + userRole;
						TC001();
						break;
					case "TC002":
						TestCaseName = this.getClass().getSimpleName() + "_" + dataSheetName + "_" + TCName + "_"
								+ Description + "_" + userRole;
						TC002();
						break;
					case "TC003":
						TestCaseName = this.getClass().getSimpleName() + "_" + dataSheetName + "_" + TCName + "_"
								+ Description + "_" + userRole;
						TC003();
						break;
					case "TC004":
						TestCaseName = this.getClass().getSimpleName() + "_" + dataSheetName + "_" + TCName + "_"
								+ Description + "_" + userRole;
						TC004();
						break;
					case "TC005":
						TestCaseName = this.getClass().getSimpleName() + "_" + dataSheetName + "_" + TCName + "_"
								+ Description + "_" + userRole;
						TC005();
						break;
					case "TC006":
						TestCaseName = this.getClass().getSimpleName() + "_" + dataSheetName + "_" + TCName + "_"
								+ Description + "_" + userRole;
						TC006();
						break;
					case "TC007":
						TestCaseName = this.getClass().getSimpleName() + "_" + dataSheetName + "_" + TCName + "_"
								+ Description + "_" + userRole;
						TC007();
						break;
					case "TC008":
						TestCaseName = this.getClass().getSimpleName() + "_" + dataSheetName + "_" + TCName + "_"
								+ Description + "_" + userRole;
						TC008();
						break;	
					
					case "TC009":
						TestCaseName = this.getClass().getSimpleName() + "_" + dataSheetName + "_" + TCName + "_"
								+ Description + "_" + userRole;
						TC009();
						break;
					case "TC010":
						TestCaseName = this.getClass().getSimpleName() + "_" + dataSheetName + "_" + TCName + "_"
								+ Description + "_" + userRole;
						TC010();
						break;
					case "TC011":
						TestCaseName = this.getClass().getSimpleName() + "_" + dataSheetName + "_" + TCName + "_"
								+ Description + "_" + userRole;
						TC011();
						break;
					case "TC012":
						TestCaseName = this.getClass().getSimpleName() + "_" + dataSheetName + "_" + TCName + "_"
								+ Description + "_" + userRole;
						TC012();
						break;
					case "TC013":
						TestCaseName = this.getClass().getSimpleName() + "_" + dataSheetName + "_" + TCName + "_"
								+ Description + "_" + userRole;
						TC013();
						break;
					case "TC014":
						TestCaseName = this.getClass().getSimpleName() + "_" + dataSheetName + "_" + TCName + "_"
								+ Description + "_" + userRole;
						TC014();
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
		// Create and assign the mobile driver
		if (driver != null) {
			driver.quit();
		}
		createMobileDriver(deviceName, platformVersion, platformName, bundleId, udid);
		this.driver = getWebDriver();
	}

	public void TC001() throws Exception {
		startTestScript(TestCaseName, deviceDetails);
		reportTestCase(driver, TestCaseName, deviceDetails, "TC001_Search Product", "Verify Search Fucntionality");
		try {
			login.validLogin(TestCaseName, deviceDetails, userName, password, userRole);
			FlyinMenu.userLevelHomeScreen(TestCaseName, deviceDetails, userRole, CustomerNumber, withDepartmentFlag);
			FlyinMenu.clickFlyinMenuOrBackButton(TestCaseName, deviceDetails);
			FlyinMenu.selectSearch(TestCaseName, deviceDetails);
			Search.verifySearchPageIsDisplayed(TestCaseName, deviceDetails);
			Search.searchScreenValidation(TestCaseName, deviceDetails);
			login.secureSignOut(TestCaseName, deviceDetails);
			endTestScript(driver, TestCaseName, deviceDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	public void TC002() throws Exception {
		startTestScript(TestCaseName, deviceDetails);
		reportTestCase(driver, TestCaseName, deviceDetails, "TC002_Search Discontinued and Non USF Product",
				"Verify Search Functionality");
		try {
			login.login(TestCaseName, deviceDetails, launchAndLogin, userName, password, userRole);
			FlyinMenu.userLevelHomeScreen(TestCaseName, deviceDetails, userRole, CustomerNumber, withDepartmentFlag);
			FlyinMenu.clickFlyinMenuOrBackButton(TestCaseName, deviceDetails);
			FlyinMenu.selectSearch(TestCaseName, deviceDetails);
			Search.viewAllShoppingList(TestCaseName, deviceDetails);
			Orders.selectShoppingListWithSwipe(TestCaseName, deviceDetails, ShoppingList);
			Search.searchDiscontinueandnonUSFProd(TestCaseName, deviceDetails, DiscontinueProduct);
			login.secureSignOut(TestCaseName, deviceDetails);
			endTestScript(driver, TestCaseName, deviceDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void TC003() throws Exception {
		startTestScript(TestCaseName, deviceDetails);
		reportTestCase(driver, TestCaseName, deviceDetails, "TC002_Search Discontinued and Non USF Product",
				"Verify Search Functionality");
		try {
			FlyinMenu.clickFlyinMenuOrBackButton(TestCaseName, deviceDetails);
			FlyinMenu.userLevelHomeScreen(TestCaseName, deviceDetails, userRole, CustomerNumber, withDepartmentFlag);
			FlyinMenu.clickFlyinMenuOrBackButton(TestCaseName, deviceDetails);
			FlyinMenu.selectSearch(TestCaseName, deviceDetails);
			endTestScript(driver, TestCaseName, deviceDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// STM7-5 This test case is to verify if the "No Results" text is displayed when
	// invalid keyword is entered in List Details Screen
	public void TC004() throws Exception {
		startTestScript(TestCaseName, deviceDetails);
		reportTestCase(driver, TestCaseName, deviceDetails, "TC004_NoResults_Invalid_Keyword_ListDetailsScreen",
				"No Results text on List Details Screen");

		try {
			login.login(TestCaseName, deviceDetails, launchAndLogin, userName, password, userRole);
			FlyinMenu.userLevelHomeScreen(TestCaseName, deviceDetails, userRole, CustomerNumber, withDepartmentFlag);
			Orders.selectNewOrder(TestCaseName, deviceDetails);
			Search.viewAllShoppingList(TestCaseName, deviceDetails);
			Orders.selectShoppingList1(TestCaseName, deviceDetails, ShoppingList);
			Search.searchProductInListScreens(TestCaseName, deviceDetails, ProductNumber);
			Search.verifyNoResults(TestCaseName, deviceDetails);
			FlyinMenu.clickFlyinMenuOrBackButton(TestCaseName, deviceDetails);
			FlyinMenu.clickFlyinMenuOrBackButton(TestCaseName, deviceDetails);
			login.secureSignOut(TestCaseName, deviceDetails);
			endTestScript(driver, TestCaseName, deviceDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// TC008_SalesTool_Validate Customer has submit the Order thru search page
	public void TC005() throws Exception {
		startTestScript(TestCaseName, deviceDetails);
		reportTestCase(driver, TestCaseName, deviceDetails, "TC001_Search Product", "Verify Search Fucntionality");
		try {
			login.login(TestCaseName, deviceDetails, launchAndLogin, userName, password, userRole);
			FlyinMenu.userLevelHomeScreen(TestCaseName, deviceDetails, userRole, CustomerNumber, withDepartmentFlag);
			FlyinMenu.clickFlyinMenuOrBackButton(TestCaseName, deviceDetails);
			FlyinMenu.selectSearch(TestCaseName, deviceDetails);
			Search.verifySearchPageIsDisplayed(TestCaseName, deviceDetails);
			Search.searchProduct(TestCaseName, deviceDetails, ProductNumber);
			Search.verifyNoResults(TestCaseName, deviceDetails);
			FlyinMenu.clickFlyinMenuOrBackButton(TestCaseName, deviceDetails);
			FlyinMenu.clickFlyinMenuOrBackButton(TestCaseName, deviceDetails);
			login.secureSignOut(TestCaseName, deviceDetails);
			endTestScript(driver, TestCaseName, deviceDetails);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void TC006() throws Exception {
		startTestScript(TestCaseName, deviceDetails);
		reportTestCase(driver, TestCaseName, deviceDetails, "TC006_Search Product_Excepetion",
				"Verify Search Fucntionality");
		try {
			login.login(TestCaseName, deviceDetails, launchAndLogin, userName, password, userRole);
			FlyinMenu.userLevelHomeScreen(TestCaseName, deviceDetails, userRole, CustomerNumber, withDepartmentFlag);
			Orders.selectNewOrder(TestCaseName, deviceDetails);
			Search.verifySearchPageIsDisplayed(TestCaseName, deviceDetails);
			Search.searchProduct(TestCaseName, deviceDetails, ProductNumber);
			Search.verifySearchPageIsDisplayed(TestCaseName, deviceDetails);
			Search.enterQuantity(TestCaseName, deviceDetails);
			Orders.addToOrderOrAddProducts(TestCaseName, deviceDetails);
			Orders.selectNewOrder(TestCaseName, deviceDetails);
			Orders.setPONumber(TestCaseName, deviceDetails, PONumber);
			Orders.submitOrder(TestCaseName, deviceDetails);
			Orders.verifyOrderExceptionsPageIsDisplayed(TestCaseName, deviceDetails);
			Orders.clickFinished(TestCaseName, deviceDetails);
			Orders.orderConfirmationWithOrWithoutException(TestCaseName, deviceDetails);
			Orders.selectNewOrder(TestCaseName, deviceDetails);
			Search.searchProduct(TestCaseName, deviceDetails, ProductNumber1);
			Search.verifyNoResults(TestCaseName, deviceDetails);
			FlyinMenu.clickFlyinMenuOrBackButton(TestCaseName, deviceDetails);
			FlyinMenu.clickFlyinMenuOrBackButton(TestCaseName, deviceDetails);
			login.secureSignOut(TestCaseName, deviceDetails);
			endTestScript(driver, TestCaseName, deviceDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// TC001_Download Single Departments and place the Offline Order.
	public void TC007() throws Exception {
		startTestScript(TestCaseName, deviceDetails);
		reportTestCase(driver, TestCaseName, deviceDetails, TCName + "_" + TCDescription,
				TCName + "_" + TCDescription + "_" + userRole);
		try {
			login.login(TestCaseName, deviceDetails, launchAndLogin, userName, password, userRole);
			if (userRole.equalsIgnoreCase("CMUser")) {

				Orders.verifyOrdersPageIsDisplayed(TestCaseName, deviceDetails);
				customers.customerChange(TestCaseName, deviceDetails);
				customers.verifyLocationPageIsDisplayed(TestCaseName, deviceDetails);
			} else {
				customers.verifyCustomerPageIsDisplayed(TestCaseName, deviceDetails);
			}
			customers.searchCustomer(TestCaseName, deviceDetails, CustomerNumber);
			customers.selectCustomer(TestCaseName, deviceDetails, CustomerNumber);
			Orders.downloadCustomer(TestCaseName, deviceDetails, ShoppingList);
			Thread.sleep(100000);
			Orders.offlinemode(TestCaseName, deviceDetails);
			customers.selectOfflineCustomer(TestCaseName, deviceDetails, CustomerName);
			Orders.verifyOrdersPageIsDisplayed(TestCaseName, deviceDetails);
			Orders.selectNewOrder(TestCaseName, deviceDetails);
			Search.verifySearchPageIsDisplayed(TestCaseName, deviceDetails);
			Orders.OfflineSelectShoppingList(TestCaseName, deviceDetails, ShoppingList);
			Search.verifyListDetailsPageIsDisplayed(TestCaseName, deviceDetails);
			Orders.Shoppinlist_SearchProduct(TestCaseName, deviceDetails, ProductNumber);
			Search.verifyNoResults(TestCaseName, deviceDetails);
			Orders.Shoppinlist_SearchProduct(TestCaseName, deviceDetails, ProductNumber1);
			Orders.SelectQuantity(TestCaseName, deviceDetails, Quantity);
			Orders.clickReviewOrderButton(TestCaseName, deviceDetails);
			Orders.setPONumber(TestCaseName, deviceDetails, PONumber);
			Orders.UpdateOrder(TestCaseName, deviceDetails);
			Orders.verifyOrdersPageIsDisplayed(TestCaseName, deviceDetails);
			Orders.offlinemode(TestCaseName, deviceDetails);
			FlyinMenu.clickFlyinMenuOrBackButton(TestCaseName, deviceDetails);
			Thread.sleep(10000);
			login.secureSignOut(TestCaseName, deviceDetails);
			endTestScript(driver, TestCaseName, deviceDetails);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
public void TC008() throws Exception {
	startTestScript(TestCaseName, deviceDetails);
	reportTestCase(driver, TestCaseName, deviceDetails, TCName + "_" + TCDescription,
			TCName + "_" + TCDescription + "_" + userRole);
	try
	{
		login.login(TestCaseName, deviceDetails, launchAndLogin, userName, password, userRole);
		customers.selectDivision(TestCaseName, deviceDetails, CustomerNumber,CustomerName);
		Search.verifySearchPageIsDisplayed(TestCaseName, deviceDetails);
		Search.searchScreenValidationfornonsale(TestCaseName, deviceDetails);
		Search.searchProduct(TestCaseName, deviceDetails, ProductNumber);
		FlyinMenu.clickFlyinMenuOrBackButton(TestCaseName, deviceDetails);
		login.secureSignOut(TestCaseName, deviceDetails);
		endTestScript(driver, TestCaseName, deviceDetails);
		
	}catch (Exception e) {
		e.printStackTrace();
		
	}
}
		
	public void TC010() throws Exception {
		startTestScript(TestCaseName, deviceDetails);
		reportTestCase(driver, TestCaseName, deviceDetails, TCName + "_" + TCDescription,
				TCName + "_" + TCDescription + "_" + userRole);

		try {
			login.login(TestCaseName, deviceDetails, launchAndLogin, username, password, userRole);
			FlyinMenu.userLevelHomeScreen(TestCaseName, deviceDetails, userRole, CustomerNumber, withDepartmentFlag);
			Orders.selectNewOrder(TestCaseName, deviceDetails);
			Search.verifySearchPageIsDisplayed(TestCaseName, deviceDetails);
			Search.searchProduct(TestCaseName, deviceDetails, ProductNumber);
			Search.verifySearchPageIsDisplayed(TestCaseName, deviceDetails);
			Search.enterQuantity(TestCaseName, deviceDetails);
			Orders.clickReviewOrderButton(TestCaseName, deviceDetails);
			Orders.setPONumber(TestCaseName, deviceDetails, PONumber);
			FlyinMenu.clickFlyinMenuOrBackButton(TestCaseName, deviceDetails);
			Orders.selectSubmittedOrderWithPONumber(TestCaseName, deviceDetails, PONumber);
			Orders.addToOrderOrAddProducts(TestCaseName, deviceDetails);
			Search.searchProduct(TestCaseName, deviceDetails, ProductNumber1);
			Search.verifyNoResults(TestCaseName, deviceDetails);
			FlyinMenu.clickFlyinMenuOrBackButton(TestCaseName, deviceDetails);
			FlyinMenu.clickFlyinMenuOrBackButton(TestCaseName, deviceDetails);
			FlyinMenu.clickFlyinMenuOrBackButton(TestCaseName, deviceDetails);
			login.secureSignOut(TestCaseName, deviceDetails);
			endTestScript(driver, TestCaseName, deviceDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void TC009() throws Exception {
		startTestScript(TestCaseName, deviceDetails);
		reportTestCase(driver, TestCaseName, deviceDetails, TCName + "_" + TCDescription,
				TCName + "_" + TCDescription + "_" + userRole);

		try {
			login.login(TestCaseName, deviceDetails, launchAndLogin, userName, password, userRole);
			FlyinMenu.userLevelHomeScreen(TestCaseName, deviceDetails, userRole, CustomerNumber, withDepartmentFlag);
			FlyinMenu.clickFlyinMenuOrBackButton(TestCaseName, deviceDetails);
			FlyinMenu.selectSpanish(TestCaseName, deviceDetails);
			FlyinMenu.clickFlyinMenuOrBackButton(TestCaseName, deviceDetails);
			FlyinMenu.clickFlyinMenuOrBackButton(TestCaseName, deviceDetails);
			Orders.spanishSelectNewOrder(TestCaseName, deviceDetails);
			Orders.verifyBuscarPageIsDisplayed(TestCaseName, deviceDetails);
			Search.searchProduct(TestCaseName, deviceDetails, ProductNumber);
			Orders.verifyBuscarPageIsDisplayed(TestCaseName, deviceDetails);
			Search.verifyNoResults(TestCaseName, deviceDetails);
			FlyinMenu.clickFlyinMenuOrBackButton(TestCaseName, deviceDetails);
			FlyinMenu.clickFlyinMenuOrBackButton(TestCaseName, deviceDetails);
			login.spanishSecureSignout(TestCaseName, deviceDetails);
			endTestScript(driver, TestCaseName, deviceDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// TC002_SalesTool_Validate Customer has submit the Order thru Fly Menu
	// -->search --> Shopping List
	public void TC011() throws Exception {
		startTestScript(TestCaseName, deviceDetails);
		reportTestCase(driver, TestCaseName, deviceDetails, TCName + "_" + TCDescription,
				TCName + "_" + TCDescription + "_" + userRole);

		try {
			login.login(TestCaseName, deviceDetails, launchAndLogin, username, password, userRole);
			FlyinMenu.userLevelHomeScreen(TestCaseName, deviceDetails, userRole, CustomerNumber, withDepartmentFlag);
			FlyinMenu.clickFlyinMenuOrBackButton(TestCaseName, deviceDetails);
			FlyinMenu.selectSearch(TestCaseName, deviceDetails);

			Search.verifySearchPageIsDisplayed(TestCaseName, deviceDetails);
			Search.viewAllShoppingList(TestCaseName, deviceDetails);
			Orders.SelectOrderGuid(TestCaseName, deviceDetails);
			Search.verifyListDetailsPageIsDisplayed(TestCaseName, deviceDetails);
			Orders.OG_SearchProduct(TestCaseName, deviceDetails, ProductNumber);
			Search.enterQuantity(TestCaseName, deviceDetails);
			Orders.addToOrderOrAddProducts(TestCaseName, deviceDetails);
			Orders.selectNewOrder(TestCaseName, deviceDetails);
			Orders.setPONumber(TestCaseName, deviceDetails, PONumber);
			Orders.submitOrder(TestCaseName, deviceDetails);
			Orders.orderConfirmationWithOrWithoutException(TestCaseName, deviceDetails);
			login.secureSignOut(TestCaseName, deviceDetails);
			endTestScript(driver, TestCaseName, deviceDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void TC012() throws Exception {
		startTestScript(TestCaseName, deviceDetails);
		reportTestCase(driver, TestCaseName, deviceDetails, TCName + "_" + TCDescription,
				TCName + "_" + TCDescription + "_" + userRole);
		try {
			login.login(TestCaseName, deviceDetails, launchAndLogin, username, password, userRole);
			FlyinMenu.userLevelHomeScreen(TestCaseName, deviceDetails, userRole, CustomerNumber, withDepartmentFlag);
			Orders.selectNewOrder(TestCaseName, deviceDetails);

			Search.verifySearchPageIsDisplayed(TestCaseName, deviceDetails);
			Search.searchProduct(TestCaseName, deviceDetails, ProductNumber);
			Search.verifySearchPageIsDisplayed(TestCaseName, deviceDetails);
			Search.enterQuantity(TestCaseName, deviceDetails);
			Orders.addToOrderOrAddProducts(TestCaseName, deviceDetails);

			DidYouForget.selectDYFBanner(TestCaseName, deviceDetails);
			DidYouForget.verifyForgottenProductsPageIsDisplayed(TestCaseName, deviceDetails);

			Orders.addToOrReviewOrder(TestCaseName, deviceDetails);
			DidYouForget.selectDYFBanner(TestCaseName, deviceDetails);
			Orders.searchProductInListScreens(TestCaseName, deviceDetails, ProductNumber1);
			Search.verifyNoResults(TestCaseName, deviceDetails);
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
	
	
	//OUT OF SCOPE

//Replacement product validation in Online mode TM/CM
	
	public void TC013() throws Exception {
		startTestScript(TestCaseName, deviceDetails);
		reportTestCase(driver, TestCaseName, deviceDetails, TCName + "_" + TCDescription,
				TCName + "_" + TCDescription + "_" + userRole);

		try {
			login.login(TestCaseName, deviceDetails, launchAndLogin, userName, password, userRole);
			FlyinMenu.userLevelHomeScreen(TestCaseName, deviceDetails, userRole, CustomerNumber, withDepartmentFlag);
			FlyinMenu.clickFlyinMenuOrBackButton(TestCaseName, deviceDetails);
			FlyinMenu.selectSearch(TestCaseName, deviceDetails);
			Search.verifySearchPageIsDisplayed(TestCaseName, deviceDetails);
			Search.viewAllShoppingList(TestCaseName, deviceDetails);
			Orders.selectShoppingList(TestCaseName, deviceDetails, ShoppingList);
			Search.verifyListDetailsPageIsDisplayed(TestCaseName, deviceDetails);
			Orders.Shoppinlist_SearchProduct(TestCaseName, deviceDetails, ProductNumber);
			//Verify replace text in shopping list screen
			Search.verifyReplaceTextandIcon(TestCaseName, deviceDetails,replaceProductNumber,productType);
			FlyinMenu.clickFlyinMenuOrBackButton(TestCaseName, deviceDetails);
			//Verify Replace text in Search screen
			Search.searchCatalog(TestCaseName, deviceDetails, ProductNumber);
			Search.verifyReplaceTextandIconNotDisplayed(TestCaseName, deviceDetails,replaceProductNumber);
			Search.clickBackButton(TestCaseName, deviceDetails);
			login.secureSignOut(TestCaseName, deviceDetails);
			endTestScript(driver, TestCaseName, deviceDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//OUT OF SCOPE
	//OFF Line mode Replacement product validation  TM/CM
	
	public void TC014() throws Exception {
		startTestScript(TestCaseName, deviceDetails);
		reportTestCase(driver, TestCaseName, deviceDetails, TCName + "_" + TCDescription,
				TCName + "_" + TCDescription + "_" + userRole);

		try {
			login.login(TestCaseName, deviceDetails, launchAndLogin, userName, password, userRole);
			if (userRole.equalsIgnoreCase("CMUser")) {
				Orders.verifyOrdersPageIsDisplayed(TestCaseName, deviceDetails);

				customers.customerChange(TestCaseName, deviceDetails);
				customers.verifyLocationPageIsDisplayed(TestCaseName, deviceDetails);

			} else {
				customers.verifyCustomerPageIsDisplayed(TestCaseName, deviceDetails);
			}
			customers.selectCustomerforoffline(TestCaseName, deviceDetails, CustomerNumber, CustomerName);
			Orders.downloadCustomer(TestCaseName, deviceDetails, ShoppingList);
			Thread.sleep(20000);
			Orders.offlinemode(TestCaseName, deviceDetails);
			customers.selectOfflineCustomer(TestCaseName, deviceDetails, CustomerName);
			Orders.verifyOrdersPageIsDisplayed(TestCaseName, deviceDetails);
			FlyinMenu.clickFlyinMenuOrBackButton(TestCaseName, deviceDetails);
			FlyinMenu.selectSearch(TestCaseName, deviceDetails);
			Search.verifySearchPageIsDisplayed(TestCaseName, deviceDetails);
			Orders.OfflineSelectShoppingList(TestCaseName, deviceDetails, ShoppingList);
			Search.verifyListDetailsPageIsDisplayed(TestCaseName, deviceDetails);
			Orders.Shoppinlist_SearchProduct(TestCaseName, deviceDetails, ProductNumber);
			Search.verifyReplaceTextandIconNotDisplayed(TestCaseName, deviceDetails,replaceProductNumber);
			Search.clickBackButton(TestCaseName, deviceDetails);
			login.secureSignOut(TestCaseName, deviceDetails);
			endTestScript(driver, TestCaseName, deviceDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}