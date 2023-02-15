package com.salesTool.pages;

import com.salesTool.util.LocatorConstants;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.salesTool.util.Constants;
import com.salesTool.applitools.ApplitoolsVerification;
import com.salesTool.common.*;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class LoginPage extends BaseTest {
	
	private static final By noUserID = MobileBy.AccessibilityId("lblNoUser");
	String noUserIDText = "No User ID? Contact your US Foods representative.";
	private static final By becomeACustomerID = MobileBy.AccessibilityId("lblBecome");
	String becomeACustomerText = "to become a US Foods customer.";
	private static final By clickHereID = MobileBy.AccessibilityId("lblClick");
	private static final By lblBrandType = MobileBy.xpath("//*[@accessibilityLabel='lblBrandType']");
	
	private static final By SpanishlogoutLabel = By.xpath("//XCUIElementTypeStaticText[@value='Cerrar Sesión']");
	// My Account Login Details
	private static final By myaccountuserIdLabel = MobileBy.AccessibilityId("inputLoginUsername");
	private static final By myaccountpasswordLabel = MobileBy.AccessibilityId("inputLoginPassword");
	private static final By myaccountInvocesettings = MobileBy.AccessibilityId("flexBottomMenuLinksPartialSettings");
	private static final By myaccountLogout = MobileBy.AccessibilityId("flexSettingsWhiteLogout");
	private static final By SettingsTitle = By.xpath("//XCUIElementTypeStaticText[@value='Settings']");
	private static final By DoneButton = MobileBy.AccessibilityId("Done");
	private static final By ShoppingListName = MobileBy.xpath("//*[@text='UHS Kitchen']");
	
	IOSDriver<MobileElement> driver;
	ApplitoolsVerification appli;
	LocatorConstants locator;
	WebDriverWait wait;
	public LoginPage(IOSDriver<MobileElement> iosDriver) {
		this.driver = iosDriver;
		appli = new ApplitoolsVerification(iosDriver);
	}

	public void login(String strTestCaseName, String strDevice, boolean testStart, String username, String password, String Role) throws IOException, InterruptedException {
		if (testStart) {
			login.loginApp(strTestCaseName, strDevice, username, password);
			loginSystemAndUnsavedOrderPopUp(strTestCaseName, strDevice);
		} else {
			reportLogin(driver, strTestCaseName, strDevice, username, password);
		}
	}
	
	public void Login(String strTestCaseName, String strDevice, boolean testStart, String username, String password, String Role) throws IOException, InterruptedException {
		if (testStart) {
			login.loginAppWithoutUncheck(strTestCaseName, strDevice, username, password);
			loginSystemAndUnsavedOrderPopUp(strTestCaseName, strDevice);
		} else {
			reportLogin(driver, strTestCaseName, strDevice, username, password);
		}
	}

	public void loginMyAccount(String strTestCaseName, String strDevice, boolean testStart, String username, String password) throws InterruptedException, IOException {
		if (testStart) {
			login.loginMyAccountApp(strTestCaseName, strDevice, username, password);
		} else {
			reportLogin(driver, strTestCaseName, strDevice, username, password);
		}
	}

	public void loginApp(String strTestCaseName, String strDevice, String userName, String password)
			throws IOException {
		try {
			
			
			appli.verifyPageWithApplitools(driver, strTestCaseName, strDevice, "Login Page", "layout");
			setValue(driver, strTestCaseName, strDevice, "User Name", LocatorConstants.userIdLabel, userName);
			setValue(driver, strTestCaseName, strDevice, "Password", LocatorConstants.passwordLabel, password);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Keep me SignIn check box is displayed",
					LocatorConstants.keepMeSignedInCheckBox);
			clickLink(driver, strTestCaseName, strDevice, "Unchecked keep me Signed In", LocatorConstants.keepMeSignedInCheckBox);
			clickLink(driver, strTestCaseName, strDevice, "Top Done Button", LocatorConstants.topdone);
			clickButton(driver, strTestCaseName, strDevice, "Done Button", LocatorConstants.signInButton);

			String logReport = strTestCaseName + Constants.DELIMITER + strDevice + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER + "LOGIN SUCCESS" + Constants.DELIMITER + "NO DATA"
					+ Constants.DELIMITER + Constants.stepPass;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void loginAppWithoutUncheck(String strTestCaseName, String strDevice, String userName, String password)
			throws IOException {
		try {
			
			
			appli.verifyPageWithApplitools(driver, strTestCaseName, strDevice, "Login Page", "layout");
			setValue(driver, strTestCaseName, strDevice, "User Name", LocatorConstants.userIdLabel, userName);
			setValue(driver, strTestCaseName, strDevice, "Password", LocatorConstants.passwordLabel, password);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Keep me SignIn check box is displayed",
					LocatorConstants.keepMeSignedInCheckBox);
			//clickLink(driver, strTestCaseName, strDevice, "Unchecked keep me Signed In", LocatorConstants.keepMeSignedInCheckBox);
			clickLink(driver, strTestCaseName, strDevice, "Top Done Button", LocatorConstants.topdone);
			clickButton(driver, strTestCaseName, strDevice, "Done Button", LocatorConstants.signInButton);

			String logReport = strTestCaseName + Constants.DELIMITER + strDevice + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER + "LOGIN SUCCESS" + Constants.DELIMITER + "NO DATA"
					+ Constants.DELIMITER + Constants.stepPass;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public void loginMyAccountApp(String strTestCaseName, String strDevice, String userName, String password)
			throws IOException {
		try {
			appli.verifyPageWithApplitools(driver, strTestCaseName, strDevice, "Login Page", "layout");
			setValue(driver, strTestCaseName, strDevice, "User Name", myaccountuserIdLabel, userName);
			clickButton(driver, strTestCaseName, strDevice, "Done Button", DoneButton);
			setValue(driver, strTestCaseName, strDevice, "Password", myaccountpasswordLabel, password);
			clickButton(driver, strTestCaseName, strDevice, "Done Button", DoneButton);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void validLogin(String strTestCaseName, String strDevice, String userName, String Password, String userRole)
			throws IOException {
		try {
			setValue(driver, strTestCaseName, strDevice, "User Name", LocatorConstants.userIdLabel, userName);
			setValue(driver, strTestCaseName, strDevice, "Password", LocatorConstants.passwordLabel, Password);
			clickLink(driver, strTestCaseName, strDevice, "Top Done Button", LocatorConstants.topdone);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Remember me", LocatorConstants.rememberMeId);
			clickLink(driver, strTestCaseName, strDevice, "Remember me", LocatorConstants.keepMeSignedInCheckBox);
			clickButton(driver, strTestCaseName, strDevice, "Login Button", LocatorConstants.signInButton);
			loginSystemAndUnsavedOrderPopUp(strTestCaseName, strDevice);
			String logReport = strTestCaseName + Constants.DELIMITER + strDevice + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER + "Log In Successful" + Constants.DELIMITER + "NO DATA"
					+ Constants.DELIMITER + Constants.stepPass;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void emptySignInClick(String strTestCaseName, String strDevice) throws InterruptedException, IOException 
	{
		try {
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "User ID label displayed",LocatorConstants.userIdLabel);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Password label is displayed",LocatorConstants.passwordLabel);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "SignIn button is displayed",LocatorConstants.signInButton);
			clickButton(driver, strTestCaseName, strDevice, "SignIn", LocatorConstants.signInButton);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Please enter your userid Label ",LocatorConstants.enterValidUserIdText);
			String validUserText = driver.findElement(LocatorConstants.enterValidUserIdText).getText();
			compareValues(driver, strTestCaseName, strDevice, "Valid User Message", LocatorConstants.enterValidUserId,validUserText);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Please enter your password Label ",LocatorConstants.enterValidPasswordText);
			String validPasswordText = driver.findElement(LocatorConstants.enterValidPasswordText).getText();
			compareValues(driver, strTestCaseName, strDevice, "Valid User Message", LocatorConstants.enterValidPassword,validPasswordText);
			String logReport = strTestCaseName + Constants.DELIMITER + strDevice + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER + "Verified Error Messages" + Constants.DELIMITER
					+ "NO DATA" + Constants.DELIMITER + Constants.stepPass;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);
		} catch (Exception e) {
			e.printStackTrace();
			String logReport = strTestCaseName + Constants.DELIMITER + strDevice + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER + "Not Verified Error Messages"
					+ Constants.DELIMITER + "NO DATA" + Constants.DELIMITER + Constants.stepFail;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);
		}
	}

	public void invalidLoginInvalidUserIdInvalidPassword(String strTestCaseName, String strDevice, String userName, String Password) throws IOException 
	{
		try {
			setValue(driver, strTestCaseName, strDevice, "User Name", LocatorConstants.userIdLabel, userName);
			setValue(driver, strTestCaseName, strDevice, "Password", LocatorConstants.passwordLabel, Password);
			clickLink(driver, strTestCaseName, strDevice, "Unchecked keep me Signed In", LocatorConstants.keepMeSignedInCheckBox);
			clickButton(driver, strTestCaseName, strDevice, "Login Button", LocatorConstants.signInButton);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Authentication Failed ", LocatorConstants.authenticationFailedMsg);
			String authenticationMessageText = driver.findElement(LocatorConstants.authenticationFailedMsg).getText();
			compareValues(driver, strTestCaseName, strDevice, "Authentication Message", LocatorConstants.authenticationMessage, authenticationMessageText);
			String logReport = strTestCaseName + Constants.DELIMITER + strDevice + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER + "Log In UnSuccessful" + Constants.DELIMITER
					+ "NO DATA" + Constants.DELIMITER + Constants.stepPass;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void invalidLoginValidUserIdInvalidPassword(String strTestCaseName, String strDevice, String userName, String Password) throws IOException {
		try {
			setValue(driver, strTestCaseName, strDevice, "User Name", LocatorConstants.userIdLabel, userName);
			setValue(driver, strTestCaseName, strDevice, "Password", LocatorConstants.passwordLabel, Password);
			clickLink(driver, strTestCaseName, strDevice, "Unchecked keep me Signed In", LocatorConstants.keepMeSignedInCheckBox);
			clickButton(driver, strTestCaseName, strDevice, "Login Button", LocatorConstants.signInButton);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Authentication Failed ", LocatorConstants.authenticationFailedMsg);
			String authenticationMessageText = driver.findElement(LocatorConstants.authenticationFailedMsg).getText();
			compareValues(driver, strTestCaseName, strDevice, "Authentication Message", LocatorConstants.authenticationMessage, authenticationMessageText);
			String logReport = strTestCaseName + Constants.DELIMITER + strDevice + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER + "Log In UnSuccessful" + Constants.DELIMITER
					+ "NO DATA" + Constants.DELIMITER + Constants.stepPass;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void verifyBecomeACustomerLink(String strTestCaseName, String strDevice) throws IOException
	{
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "No User ID ", noUserID);
		String noUserIDValue = driver.findElement(noUserID).getText();
		compareValues(driver, strTestCaseName, strDevice, "No User ID?",noUserIDText, noUserIDValue);
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Become a US Foods Customer ", becomeACustomerID);
		String becomeACustomer = driver.findElement(becomeACustomerID).getText();
		compareValues(driver, strTestCaseName, strDevice, "No User ID?",becomeACustomerText, becomeACustomer);
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Click Here ", clickHereID);
	}

	public void signOut(String strTestCaseName, String strDevice) throws IOException {
		try {
			clickLink(driver, strTestCaseName, strDevice, "First customer", LocatorConstants.selectFirstCustomer);
			secureSignOut(strTestCaseName, strDevice);
			String logReport = strTestCaseName + Constants.DELIMITER + strDevice + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER + "Loged Out Successfully" + Constants.DELIMITER
					+ "NO DATA" + Constants.DELIMITER + Constants.stepPass;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void secureSignOut(String strTestCaseName, String strDevice) throws IOException {
		try {
			//wait.until(ExpectedConditions.elementToBeSelected(LocatorConstants.flyinMenuOrBackBtn));
			clickButton(driver, strTestCaseName, strDevice, "Flyin Menu", LocatorConstants.flyinMenuOrBackBtn);
			swipeAndVerifyElementIsDisplayed1(driver, strTestCaseName, strDevice, "Log out", LocatorConstants.logoutLabel, "up", 80, 70);
			clickButton(driver, strTestCaseName, strDevice, "click on logout button", LocatorConstants.logoutLabel);
			String logReport = strTestCaseName + Constants.DELIMITER + strDevice + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER + "Logout Successfully" + Constants.DELIMITER
					+ "NO DATA" + Constants.DELIMITER + Constants.stepPass;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void SignOut(String strTestCaseName, String strDevice) throws IOException {
		try {
			//wait.until(ExpectedConditions.elementToBeSelected(LocatorConstants.flyinMenuOrBackBtn));
			
			swipeAndVerifyElementIsDisplayed1(driver, strTestCaseName, strDevice, "Log out", LocatorConstants.logoutLabel, "up", 80, 70);
			clickButton(driver, strTestCaseName, strDevice, "click on logout button", LocatorConstants.logoutLabel);
			String logReport = strTestCaseName + Constants.DELIMITER + strDevice + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER + "Logout Successfully" + Constants.DELIMITER
					+ "NO DATA" + Constants.DELIMITER + Constants.stepPass;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void myAccountSecureSignOut(String strTestCaseName, String strDevice) throws IOException, Exception {
		try {
			clickButton(driver, strTestCaseName, strDevice, "clicked Settings", myaccountInvocesettings);
			verifyPageHeader(driver, strTestCaseName, strDevice, "Settings Page ", SettingsTitle);
			// Compare the add event page description value
			String SettingsTitletext = getObjectText(driver, strTestCaseName, strDevice, "Settings Page title",
					SettingsTitle);
			compareValues(driver, strTestCaseName, strDevice, "Settings Page Title Text Validation", "Settings",
					SettingsTitletext);
			clickButton(driver, strTestCaseName, strDevice, "logout", myaccountLogout);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void spanishSecureSignout(String strTestCaseName, String strDevice) throws IOException 
	{
		try {
			clickButton(driver, strTestCaseName, strDevice, "clicked Flying Menu", LocatorConstants.flyinMenuOrBackBtn);
			clickButton(driver, strTestCaseName, strDevice, "clicked Settings in Flying Menu", LocatorConstants.SpanishsettingsLabel);
			clickButton(driver, strTestCaseName, strDevice, "clicked Security", LocatorConstants.SpanishsecurityLabel);
			clickButton(driver, strTestCaseName, strDevice, "clicked Logout", SpanishlogoutLabel);
			String logReport = strTestCaseName + Constants.DELIMITER + strDevice + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER + "Logout Successfully" + Constants.DELIMITER
					+ "NO DATA" + Constants.DELIMITER + Constants.stepPass;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loginSystemAndUnsavedOrderPopUp(String strTestCaseName, String strDevice) throws InterruptedException 
	{
		try {
			Thread.sleep(20000);
			List<MobileElement> element1 = null;
			int objcount1 = 0;
			element1 = driver.findElements(LocatorConstants.SystemNoticeLabel);
			objcount1 = element1.size();
			if (objcount1 > 0) {
				System.out.println("Printing the element1 " + element1);
				clickButton(driver, strTestCaseName, strDevice, "System Notice", LocatorConstants.systemNoticeOkBtn);
			}
			
			/*
			 * List<MobileElement> element2 = null; int objcount2 = 0; element2 =
			 * driver.findElements(LocatorConstants.unsavedOrderPopup); objcount2 =
			 * element2.size(); if (objcount2 > 0) {
			 * System.out.println("Printing the element1 " + element2);
			 * verifyElementIsDisplayed(driver, strTestCaseName, strDevice,
			 * "Unsaved Order Popup message", LocatorConstants.unsavedOrderMessage);
			 * verifyElementIsDisplayed(driver, strTestCaseName, strDevice,
			 * "View Order Button", LocatorConstants.viewOrderBtn); clickButton(driver,
			 * strTestCaseName, strDevice, "Discard Changes",
			 * LocatorConstants.discardChangesBtn); }
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
