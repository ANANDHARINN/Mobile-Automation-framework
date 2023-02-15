package com.salesTool.pages;


import java.io.IOException;
import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.salesTool.applitools.ApplitoolsVerification;
import com.salesTool.common.BaseTest;
import com.salesTool.util.Constants;
import com.salesTool.util.LocatorConstants;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class SearchPage extends BaseTest {

	private static final By productSearch = By.xpath("//*[@id='tbxSearch']");
	private static final By productSearchSpanish=By.xpath("//*[@placeholder='Busca en el Catalogo']");
	private static final By productQuantity = MobileBy.AccessibilityId("segSearch_1_1_flexProducts_flexBaseContainer_flexItemContainerParent_flexItem_flexPricingContainer_flexDetails_flexQuantity_flexQuantityOne_lblQtyOne");
	private static final By barCodeScannerLabel = MobileBy.AccessibilityId("imgBarCode");
	private static final By productQuantity1 =By.xpath("//*[@id='segSearch_1_1_flexInventoryDetails_flexItemContainer_flexItem_flexDetails_flexQuantityCSEA_flexQuantities_flexCSQuantity_lblCSQty']");
	private static final By shoppingListsLabel = MobileBy.AccessibilityId("lblShoppingLists");
	private static final By firstShoppingListLabel = MobileBy.AccessibilityId("segShoppingList_1_1_flexSearchSeg_flexGuidesAndList_lblOption");
	private static final By secondShoppingListLabel = MobileBy.AccessibilityId("segShoppingList_1_2_flexSearchSeg_flexGuidesAndList_lblOption");
	private static final By viewAllShoppingListLabel = MobileBy.AccessibilityId("lblAll");
	private static final By browseProductsByLabel = By.xpath("//XCUIElementTypeStaticText[(@value='Browse Products By')]");
	private static final By recentlyPurchasedLabel = MobileBy.AccessibilityId("lblRecentlyPur");
	private static final By contractedLabel = MobileBy.AccessibilityId("lblContracted");
	private static final By newScoopLabel = MobileBy.AccessibilityId("lblNewScoop");
	private static final By cesLabel = MobileBy.AccessibilityId("lblCES");
	private static final By locallySourcedLabel = MobileBy.AccessibilityId("lblLocallySourced");
	private static final By recentSearchesLabel = MobileBy.AccessibilityId("lblRecentSearches");
	private static final By Search1 =By.xpath("//*[@text='Search']");
	private static final By Search2 =By.xpath("//*[@accessibilityLabel='lblSearch']");
	//private static final By doneButton = By.xpath("//*[@text='Done' and ./parent::*[./parent::*[./parent::*[@text='Toolbar']]]]");
	
	private static final By doneButton = By.xpath("(//XCUIElementTypeButton[@name='Done'])[2]");
	private static final By advanceFilterLabel = MobileBy.AccessibilityId("btnAdvanced");
	private static final By addToOrderLabel = MobileBy.AccessibilityId("btnAdd");
	private static final By searchBackButton = MobileBy.AccessibilityId("imgBack");
	private static final By changeButton = MobileBy.AccessibilityId("btnChange");
	private static final By stockButton = By.xpath("//XCUIElementTypeStaticText[(@value='Stock')]");
	private static final By selectFirstProduct = By.xpath("//XCUIElementTypeOther[contains(@name ,'richName')]");
	// Advanced Search
	private static final By advancedSearchHeader = MobileBy.AccessibilityId("lblHeader");
	private static final By categoryLabel = MobileBy.AccessibilityId("hbxCategory");
	private static final By newlyPurchasedLabel = MobileBy.AccessibilityId("hbxRecentPurchase");
	private static final By contractedProduct = MobileBy.AccessibilityId("hbxContractProduct");
	private static final By brandsLabel = MobileBy.AccessibilityId("hbxBrand");
	private static final By manufacturersLabel = MobileBy.AccessibilityId("hbxManufacturer");
	private static final By nutritionalLabel = MobileBy.AccessibilityId("hbxNutritional");
	private static final By clearFiltersButton = By.xpath("//XCUIElementTypeButton[(@label='Clear Filters')]");
	private static final By applyFiltersButton = By.xpath("//XCUIElementTypeButton[(@label='Apply Filters')]");
	// List Details
	private static final By filterListSearchBox = MobileBy.AccessibilityId("flexSearchBox");
	private static final By groupsLabel = By.xpath("//XCUIElementTypeButton[(@name='btnAdvanced')]");
	private static final By discontinuedGroup = By.xpath("//XCUIElementTypeStaticText[(@value='Discontinued')]");
	private static final By nonUSFProdGroup = By.xpath("//XCUIElementTypeStaticText[(@value='Non USF Products')]");
	private static final By listdetailsBackButton = MobileBy.AccessibilityId("imgBack");
	private static final By tbx_SearchOrder = MobileBy.AccessibilityId("tbxSearchOrder");
	// Product OverView
	private static final By productOverviewLabel = By.xpath("//XCUIElementTypeStaticText[@value='Product Detail']");
	private static final By productOverviewBackButton = MobileBy.AccessibilityId("imgBack");
	private static final By packSizeLabel = MobileBy.AccessibilityId("lblPackSize");
	private static final By GetByLabel = MobileBy.AccessibilityId("lblGetBy");
	private static final By productDetailsLabel = MobileBy.AccessibilityId("lblProductDetails");
	private static final By nutritionalFactsLabel = MobileBy.AccessibilityId("lblNutritionalFacts");
	private static final By marketingClaimsLabel = MobileBy.AccessibilityId("lblMarketingClaims");
	private static final By shippingInformationLabel = MobileBy.AccessibilityId("lblPhysicalAttributes");
	private static final By backButton = MobileBy.AccessibilityId("vboxback");
	// Product Details
	private static final By productDetailLabel = By.xpath("//XCUIElementTypeStaticText[@value='Product Detail']");
	private static final By lbl_Manufacturer = MobileBy.AccessibilityId("lblManufacturer");
	private static final By lbl_ProdCategory = MobileBy.AccessibilityId("lblProdCategory");
	private static final By lbl_ProductDescription = MobileBy.AccessibilityId("lblProductDescription");
	private static final By SpaishproductDetailLabel = By.xpath("//XCUIElementTypeStaticText[@value='Detalles del Producto']");
	private static final By SpaishproductDetailsLabel1 = By.xpath("//XCUIElementTypeStaticText[@value='Detalles del Producto']");
	private static final By SpaishnutritionalFactsLabel = By.xpath("//XCUIElementTypeStaticText[@value='Contenido Nutritivo']");
	private static final By SpaishmarketingClaimsLabel = By.xpath("//XCUIElementTypeStaticText[@value='Mercadeo & Declaraciones Nutricionales']");
	private static final By SpaishshippingInformationLabel = By.xpath("//XCUIElementTypeStaticText[@value='Información de envío']");
	// Search Page
	private static final By MarketPlaceShoppingList = By.xpath("//XCUIElementTypeStaticText[@label='Kony Test List']");
	private static final By ProductSearchShoppingList = MobileBy.AccessibilityId("tbxSearchOrder");
	private static final By noResults = MobileBy.AccessibilityId("flexNoResHeader");
	private static final By advertisedPromotionBannerSaveText = MobileBy.AccessibilityId("segSearch_1_1_flexProducts_flexBaseContainer_flexPromotion_flexOffer_lblOffer");
	private static final By advertisedPromotionBannerDetailsText = MobileBy.AccessibilityId("segSearch_1_1_flexProducts_flexBaseContainer_flexPromotion_flexOfferDetails_lblOfferDetails");
	private static final By OfferDetailsTitle = By.xpath("//XCUIElementTypeStaticText[@value='Offer Details']");
	private static final By SpanishOfferDetailsTitle = By.xpath("//XCUIElementTypeStaticText[@value='Detalles de la oferta']");
	private static final By lbl_Offer = MobileBy.AccessibilityId("lblOffer");
	private static final By lbl_PromoDate = MobileBy.AccessibilityId("lblPromoDate");
	private static final By lbl_ApplyEach = MobileBy.AccessibilityId("lblApplyEach");
	private static final By lbl_Qualification = MobileBy.AccessibilityId("lblQualification");
	private static final By lbl_Disclaimer = MobileBy.AccessibilityId("lblDisclaimer");
	private static final By lbl_PriceOne = By.xpath("//XCUIElementTypeStaticText[contains(@name,'lblPriceOne')]");
	private static final By lbl_CSCost = By.xpath("//XCUIElementTypeStaticText[contains(@name,'lblCSCost')]");
	private static final By replaceProductsText = By.xpath("//XCUIElementTypeStaticText[contains(text(),'replaces')]");
	private static final By directGetItByText = By.xpath("//XCUIElementTypeStaticText[contains(text(),'Get it by')]");
	private static final By replaceProductsImage = By.xpath("//XCUIElementTypeStaticText[contains(text(),'replaces')]");
	private static final String REPLACES_TXT = "Replaces";
	private static final By alternateProductsText = MobileBy.AccessibilityId("segSearch_1_1_flexProducts_flexBaseContainer_flexItemContainer_flexItem_flexDetails_flexAlternateProducts_lblAlternateProducts");
	private static final By alternateProductsHeader = By.xpath("//XCUIElementTypeStaticText[@value='Alternate Products']");
	
	
	IOSDriver<MobileElement> driver;
	ApplitoolsVerification appli;
	WebDriverWait wait;


	public SearchPage(IOSDriver<MobileElement> iosDriver) {
		this.driver = iosDriver;
		appli = new ApplitoolsVerification(iosDriver);
	}
	
	public void verifySearchPageIsDisplayed(String strTestCaseName, String strDevice) throws IOException
	{
		try {
			
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Search Screen", LocatorConstants.pageTitle);
			String searchPageTitle = driver.findElement(LocatorConstants.pageTitle).getText();		
			compareValues(driver, strTestCaseName, strDevice, "Search", "Search", searchPageTitle);
			appli.verifyPageWithApplitools(driver, strTestCaseName, strDevice, " Applitools - Search",
					"layout");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void searchProduct(String strTestCaseName, String strDevice, String ProductNumber)
			throws InterruptedException, IOException {
		try {
			Thread.sleep(1000);
			
			setValue(driver, strTestCaseName, strDevice, "Select the Product from search", productSearch,
					ProductNumber);
			clickLink(driver, strTestCaseName, strDevice, "Top Done Button", LocatorConstants.topdone);
			clickLink(driver, strTestCaseName, strDevice, "Click the search text", productSearch);
			clickButton(driver, strTestCaseName, strDevice, "Done Button", doneButton);
			
	
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END-Select the Search product",
					"Failed to Select the Search product");
			e.printStackTrace();
		}
	}
	public void searchProductfromFlyin(String strTestCaseName, String strDevice, String ProductNumber)
			throws InterruptedException, IOException {
		try {
			Thread.sleep(1000);
			clickButton(driver, strTestCaseName, strDevice, "Flyin Menu Or Back", LocatorConstants.flyinMenuOrBackBtn);
			clickLink(driver, strTestCaseName, strDevice, "Search Icon", Search1);
			setValue(driver, strTestCaseName, strDevice, "Select the Product from search", productSearch,
					ProductNumber);
			clickLink(driver, strTestCaseName, strDevice, "Top Done Button", LocatorConstants.topdone);
			clickLink(driver, strTestCaseName, strDevice, "Click the search text", productSearch);
			clickButton(driver, strTestCaseName, strDevice, "Done Button", doneButton);
			
//			
//			clickButton(driver, strTestCaseName, strDevice, "Done Button", doneButton);
//			clickLink(driver, strTestCaseName, strDevice, "Top Done Button", LocatorConstants.topdone);
//			clickLink(driver, strTestCaseName, strDevice, "Click the search text",productSearch);
//			clickButton(driver, strTestCaseName, strDevice, "Done Button", doneButton);
			//driver.getKeyboard().sendKeys(Keys.RETURN);
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END-Select the Search product",
					"Failed to Select the Search product");
			e.printStackTrace();
		}
	}
	public void searchProductfromFlyinSpanish(String strTestCaseName, String strDevice, String ProductNumber)
			throws InterruptedException, IOException {
		try {
			Thread.sleep(1000);
			clickButton(driver, strTestCaseName, strDevice, "Flyin Menu Or Back", LocatorConstants.flyinMenuOrBackBtn);
			clickLink(driver, strTestCaseName, strDevice, "Search", Search2);
			setValue(driver, strTestCaseName, strDevice, "Select the Product from search", productSearchSpanish,
					ProductNumber);
			clickLink(driver, strTestCaseName, strDevice, "Top Done Button", LocatorConstants.topdone);
			clickLink(driver, strTestCaseName, strDevice, "Click the search text", productSearchSpanish);
			clickButton(driver, strTestCaseName, strDevice, "Done Button", doneButton);
			
//			
//			clickButton(driver, strTestCaseName, strDevice, "Done Button", doneButton);
//			clickLink(driver, strTestCaseName, strDevice, "Top Done Button", LocatorConstants.topdone);
//			clickLink(driver, strTestCaseName, strDevice, "Click the search text",productSearch);
//			clickButton(driver, strTestCaseName, strDevice, "Done Button", doneButton);
			//driver.getKeyboard().sendKeys(Keys.RETURN);
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END-Select the Search product",
					"Failed to Select the Search product");
			e.printStackTrace();
		}
	}
	public void searchProductInListScreens(String strTestCaseName, String strDevice, String ProductNumber)
			throws InterruptedException, IOException {
		try {
			
			setValue(driver, strTestCaseName, strDevice, "Select the Product from list screens", LocatorConstants.filterTextBox,ProductNumber);
			clickLink(driver, strTestCaseName, strDevice, "Top Done Button", LocatorConstants.topdone);
			clickLink(driver, strTestCaseName, strDevice, "Search Text_FR",tbx_SearchOrder);
			clickButton(driver, strTestCaseName, strDevice, "Done Button", doneButton);
			
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END-Select the Product from list screens",
					"Failed to Select the Product from list screens");
			e.printStackTrace();
		}
	}
	
	public void enterQuantity(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {
		try {
			clickLink(driver, strTestCaseName, strDevice, "Select Product Quantity", productQuantity);
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END-Enter quantity",
					"Failed to add quantity to the searched product");
			e.printStackTrace();
		}
	}
	
	public void enterQuantity1(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {
		try {
			clickLink(driver, strTestCaseName, strDevice, "Select Product Quantity", productQuantity1);
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END-Enter quantity",
					"Failed to add quantity to the searched product");
			e.printStackTrace();
		}
	}
	
	public void verifyListDetailsPageIsDisplayed(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {
		try {
			Thread.sleep(3000);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "List Details Screen", LocatorConstants.pageTitle);
			String listDetailsTitle = driver.findElement(LocatorConstants.pageTitle).getText();

           // wait.until(ExpectedConditions.v(listDetailsTitle, text));
			Thread.sleep(3000);
			compareValues(driver, strTestCaseName, strDevice, "List Details", "List Details", listDetailsTitle);
			appli.verifyPageWithApplitools(driver, strTestCaseName, strDevice, "List Details", "layout");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
			
	public void searchScreenValidation(String strTestCaseName, String strDevice) throws IOException
	{
		try {
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Barcode Scanner", barCodeScannerLabel);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Shopping Lists Header", shoppingListsLabel);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "First Shopping List",firstShoppingListLabel );
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Second Shopping List", secondShoppingListLabel);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "View All Shopping Lists", viewAllShoppingListLabel);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Browse Products By", browseProductsByLabel);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Newly Purchased", recentlyPurchasedLabel);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Contracted", contractedLabel);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Scoop", newScoopLabel);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Equipment & Supplies", cesLabel);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Locally Sourced", locallySourcedLabel);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Recent Searches", recentSearchesLabel);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void searchScreenValidationfornonsale(String strTestCaseName, String strDevice) throws IOException
	{
		try {
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Barcode Scanner", barCodeScannerLabel);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Browse Products By", browseProductsByLabel);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Scoop", newScoopLabel);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Equipment & Supplies", cesLabel);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Locally Sourced", locallySourcedLabel);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Recent Searches", recentSearchesLabel);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickNewlyPurchased(String strTestCaseName, String strDevice) throws IOException
	{
		try {
			clickLink(driver, strTestCaseName, strDevice, "Newly Purchased", recentlyPurchasedLabel);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Newly Purchased Screen", LocatorConstants.pageTitle);
			String newlyPurchasedTitle = driver.findElement(LocatorConstants.pageTitle).getText();
			compareValues(driver, strTestCaseName, strDevice, "Newly Purchased", "Newly Purchased", newlyPurchasedTitle);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickContracted(String strTestCaseName, String strDevice) throws IOException
	{
		try {
			clickLink(driver, strTestCaseName, strDevice, "Contracted", contractedLabel);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Contracted Screen", LocatorConstants.pageTitle);
			String contractedTitle = driver.findElement(LocatorConstants.pageTitle).getText();
			compareValues(driver, strTestCaseName, strDevice, "Contracted", "Contracted", contractedTitle);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickScoop(String strTestCaseName, String strDevice) throws IOException
	{
		try {
			clickLink(driver, strTestCaseName, strDevice, "Scoop", newScoopLabel);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Scoop Screen", LocatorConstants.pageTitle);
			String scoopTitle = driver.findElement(LocatorConstants.pageTitle).getText();
			compareValues(driver, strTestCaseName, strDevice, "Scoop", "Scoop", scoopTitle);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickEquipmentAndSupplies(String strTestCaseName, String strDevice) throws IOException
	{
		try {
			
			clickLink(driver, strTestCaseName, strDevice, "Equipment & Supplies", cesLabel);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Equipment & Supplies Screen", LocatorConstants.pageTitle);
			String cesTitle = driver.findElement(LocatorConstants.pageTitle).getText();
			compareValues(driver, strTestCaseName, strDevice, "Equipment & Supplies", "Equipment & Supplies", cesTitle);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickLocallySourced(String strTestCaseName, String strDevice) throws IOException
	{
		try {
			clickLink(driver, strTestCaseName, strDevice, "Locally Sourced", locallySourcedLabel);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Locally Sourced Screen", LocatorConstants.pageTitle);
			String locallySourcedTitle = driver.findElement(LocatorConstants.pageTitle).getText();
			compareValues(driver, strTestCaseName, strDevice, "Locally Sourced", "Locally Sourced", locallySourcedTitle);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void viewAllShoppingList(String strTestCaseName, String strDevice) throws InterruptedException, IOException
	{
		clickLink(driver, strTestCaseName, strDevice, "View All ", viewAllShoppingListLabel);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public void searchCatalog(String strTestCaseName, String strDevice, String Product)
			throws InterruptedException, IOException {
		try {
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Browse by Products",browseProductsByLabel);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Bar Code Scanner",barCodeScannerLabel);
			setValue(driver, strTestCaseName, strDevice, "Search the Product", productSearch, Product);
			driver.getKeyboard().sendKeys(Keys.RETURN);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Advanced Filter",advanceFilterLabel);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Add to Order Button",addToOrderLabel);
			String logReport = strTestCaseName + Constants.DELIMITER + strDevice + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER + "Search functionality is verified"
					+ Constants.DELIMITER + "NO DATA" + Constants.DELIMITER + Constants.stepPass;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);

		} catch (Exception e) {
			e.printStackTrace();
			String logReport = strTestCaseName + Constants.DELIMITER + strDevice + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER + "Search screen is not as expected"
					+ Constants.DELIMITER + "NO DATA" + Constants.DELIMITER + Constants.stepFail;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);
		}
	}
	
	public void advancedFilter(String strTestCaseName, String strDevice) throws InterruptedException, IOException {

		clickButton(driver, strTestCaseName, strDevice, "Advanced filter", advanceFilterLabel);
		String logReport = strTestCaseName + Constants.DELIMITER + strDevice + Constants.DELIMITER
				+ getCurrentDateAndTime() + Constants.DELIMITER + "Advanced Search Page is Displayed"
				+ Constants.DELIMITER + "NO DATA" + Constants.DELIMITER + Constants.stepPass;
		appendReportFile(driver, logReport);
		extentReport(driver, logReport);
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Advanced Search Page", advancedSearchHeader);
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Categories Label", categoryLabel);
		/*
		 * try { clickButton(driver, strTestCaseName, strDevice, "Categories",
		 * categoryLabel); // clickTop(driver, strTestCaseName, strDevice); } catch
		 * (Exception e) { e.printStackTrace(); }
		 */
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Newly Purchased label",
				newlyPurchasedLabel);

		/*
		 * try { clickButton(driver, strTestCaseName, strDevice, "Newly Purchased",
		 * newlyPurchasedLabel); } catch (Exception e) { e.printStackTrace(); }
		 */
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Contracted Product label",
				contractedProduct);

		/*
		 * try { clickButton(driver, strTestCaseName, strDevice, "Contracted Product",
		 * contractedProduct); } catch (Exception e) { e.printStackTrace(); }
		 */
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Brands Label", brandsLabel);

		/*
		 * try { clickButton(driver, strTestCaseName, strDevice, "Brands", brandsLabel);
		 * swipeAndVerifyElementIsDisplayed(driver, strTestCaseName, strDevice,
		 * "Manufacturers", manufacturersLabel, "up"); } catch (Exception e) {
		 * e.printStackTrace(); }
		 */

		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Manufacturers Label",
				manufacturersLabel);

		/*
		 * try { clickButton(driver, strTestCaseName, strDevice, "Manufacturers",
		 * manufacturersLabel); swipeAndVerifyElementIsDisplayed(driver,
		 * strTestCaseName, strDevice, "Nutritionals", nutritionalLabel, "up"); } catch
		 * (Exception e) { e.printStackTrace(); }
		 */
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Nutritionals Label",
				nutritionalLabel);

		/*
		 * try { clickButton(driver, strTestCaseName, strDevice, "Nutritionals",
		 * nutritionalLabel); } catch (Exception e) { e.printStackTrace(); }
		 */

		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Apply filters",
				applyFiltersButton);
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Clear Filters",
				clearFiltersButton);
		clickButton(driver, strTestCaseName, strDevice, "Clear Filters", clearFiltersButton);

	}

	public void clickBackButton(String strTestCaseName, String strDevice) throws InterruptedException, IOException {

		clickButton(driver, strTestCaseName, strDevice, "Search Page Back Button", searchBackButton);

	}

	public void searchDiscontinueandnonUSFProd(String strTestCaseName, String strDevice, String DiscontinueProduct)
			throws IOException, InterruptedException {

		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "List Details Page",LocatorConstants.pageTitle);
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "FilterSearchBox",
				filterListSearchBox);
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Groups Label", groupsLabel);

		clickButton(driver, strTestCaseName, strDevice, "Groups Label", groupsLabel);
		swipeAndVerifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Discontinued Products",
				discontinuedGroup, "up");
		clickButton(driver, strTestCaseName, strDevice, "Discontinued Group", discontinuedGroup);

		// setValue_donothidekeyboard(driver, strTestCaseName, strDevice, "Search
		// Product", filterListSearchBox, DiscontinueProduct);

		clickButton(driver, strTestCaseName, strDevice, "Groups", groupsLabel);
		swipeAndVerifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Non USF Products",
				nonUSFProdGroup, "up");
		clickButton(driver, strTestCaseName, strDevice, "Non USF Group", nonUSFProdGroup);
		clickButton(driver, strTestCaseName, strDevice, "List Details Back Button", listdetailsBackButton);

	}

	public void verifyStock(String strTestCaseName, String strDevice, String move) throws InterruptedException, IOException {

		//swipeLeft(driver);
		//scrollIos(strTestCaseName, strDevice, move);
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Stock Button",
				stockButton);
		try {
			clickButton(driver, strTestCaseName, strDevice, "Stock Button", stockButton);
			String logReport = strTestCaseName + Constants.DELIMITER + strDevice + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER + "STOCK BUTTON IS CLICKED" + Constants.DELIMITER
					+ "NO DATA" + Constants.DELIMITER + Constants.stepPass;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);
		} catch (Exception e) {
			e.printStackTrace();
			String logReport = strTestCaseName + Constants.DELIMITER + strDevice + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER + "STOCK BUTTON IS NOT CLICKED"
					+ Constants.DELIMITER + "NO DATA" + Constants.DELIMITER + Constants.stepFail;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);
		}
	}
	
	public void selectProductDetailScreen(String strTestCaseName, String strDevice) throws IOException {
		clickButton(driver, strTestCaseName, strDevice, "Selected the product", selectFirstProduct);
		
	}

	public void verifyProductDetailScreen(String strTestCaseName, String strDevice) throws IOException {
		clickButton(driver, strTestCaseName, strDevice, "Product", selectFirstProduct);

		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Product Detail Page",
				productDetailLabel);
		/*verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Direct Icon Validation",
				Directicon);*/
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Product Manufacturer Details",
				lbl_Manufacturer);
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Product Category",
				lbl_ProdCategory);
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Product Description",
				lbl_ProductDescription);
		// verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Product
		// Statement is Displayed", lbl_ProductStatement);
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Pack Size", packSizeLabel);
		// verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Case Price is
		// Displayed", casePriceLabel);

		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Product Details Label",
				productDetailsLabel);
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "NutritionalFacts Label",
				nutritionalFactsLabel);
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Marketing Claims Label",
				marketingClaimsLabel);
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Shipping Information Label",
				shippingInformationLabel);
		try {
			appli.verifyPageWithApplitools(driver, strTestCaseName, strDevice, "Applitools Product Detail Page",
					"layout");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void verifyAdvertisementProductDetailScreen(String strTestCaseName, String strDevice) throws IOException {
		clickButton(driver, strTestCaseName, strDevice, "Selected the product", selectFirstProduct);

		// verifyElementIsDisplayed(driver, strTestCaseName, strDevice,
		// "AdvertisedPromotion Banner Savings text", AdvertisedPromotionBanner_Save);
		// verifyElementIsDisplayed(driver, strTestCaseName, strDevice,
		// "AdvertisedPromotion Banner Offer Details",
		// AdvertisedPromotionBanner_OfferDetails);

		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Product Detail Page",
				productDetailLabel);
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Product Manufacturer Details",
				lbl_Manufacturer);
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Product Category",
				lbl_ProdCategory);
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Product Description",
				lbl_ProductDescription);
		// verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Product
		// Statement is Displayed", lbl_ProductStatement);
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Pack Size", packSizeLabel);
		// verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Case Price is
		// Displayed", casePriceLabel);

		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Product Details",
				productDetailsLabel);
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "NutritionalFacts",
				nutritionalFactsLabel);
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Marketing Claims",
				marketingClaimsLabel);
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Shipping Information",
				shippingInformationLabel);
		try {
			appli.verifyPageWithApplitools(driver, strTestCaseName, strDevice, "Applitools Product Detail",
					"layout");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void verifySpanishProductDetailScreen(String strTestCaseName, String strDevice) throws IOException {
		clickButton(driver, strTestCaseName, strDevice, "Selected the product", selectFirstProduct);
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Detalles del Producto",
				SpaishproductDetailLabel);
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Product Manufacturer Details",
				lbl_Manufacturer);
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Product Category",
				lbl_ProdCategory);
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Product Description",
				lbl_ProductDescription);
		// verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Product
		// Statement is Displayed", lbl_ProductStatement);
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Pack Size", packSizeLabel);
		// verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Case Price is
		// Displayed", casePriceLabel);

		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Detalles del Producto",
				SpaishproductDetailsLabel1);
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Contenido Nutritivo",
				SpaishnutritionalFactsLabel);
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice,
				"Mercadeo & Declaraciones Nutricionales is Displayed", SpaishmarketingClaimsLabel);
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Información de envío",
				SpaishshippingInformationLabel);
		try {
			appli.verifyPageWithApplitools(driver, strTestCaseName, strDevice, "Product Detail Page", "layout");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void verifyMarketPlaceProductOverView(String strTestCaseName, String strDevice)
			throws IOException, InterruptedException {

		clickButton(driver, strTestCaseName, strDevice, "Selected the product" ,selectFirstProduct);
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Product OverView Page",
				productOverviewLabel);
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Pack Size", packSizeLabel);
		// verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Case Price is
		// Displayed", casePriceLabel);
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Get by Label Validation", GetByLabel);
		String MarketPlaceText = getObjectText(driver, strTestCaseName, strDevice,
				"MarketPlace Get By Label validaiton in product overview screen ", GetByLabel);

		// verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Stock Status id
		// Displayed", stockStatusLabel);
		// verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Stock
		// Quantitites is Displayed", stockQuantititesLabel);
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Product Details",
				productDetailsLabel);
		// verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "You May Also
		// Need Label is Displayed", YouMayAlsoNeedLabel);
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Shipping Information",
				shippingInformationLabel);

		// verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Nutritional
		// Facts Label is Displayed", nutritionalFactsLabel);
		// verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Nutritional
		// Claims Label is Displayed", marketingClaimsLabel);

	}

	public void ValidateMarketPlaceProduct(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {

		// verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Get it by Text
		// in Search Screen ", GetitbyhText);
		// verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "No returns
		// Text", NoReturnText);
		// verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "mm/dd Date
		// formate", mmdd_dateformate);

		String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
				+ getCurrentDateAndTime() + Constants.DELIMITER + "Verification: Element/Object Displayed--->"
				+ "Get it by  Text in Search Screen " + Constants.DELIMITER + "NO DATA" + Constants.DELIMITER
				+ Constants.stepPass;
		appendReportFile(driver, logReport);
		extentReport(driver, logReport);

		logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
				+ getCurrentDateAndTime() + Constants.DELIMITER + "Verification: Element/Object Displayed--->"
				+ "No returns Text in Search Screen" + Constants.DELIMITER + "NO DATA" + Constants.DELIMITER
				+ Constants.stepPass;
		appendReportFile(driver, logReport);
		extentReport(driver, logReport);

		logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
				+ getCurrentDateAndTime() + Constants.DELIMITER + "Verification: Element/Object Displayed--->"
				+ "mm/dd Date formate in Search Screen " + Constants.DELIMITER + "NO DATA" + Constants.DELIMITER
				+ Constants.stepPass;
		appendReportFile(driver, logReport);
		extentReport(driver, logReport);

		// String MarketPlaceText = getObjectText(driver, strTestCaseName, strDevice,
		// "MarketPlace Text ",GetitbyhText);
		// compareValues(driver, strTestCaseName, strDevice, "Deparment Page Title Text
		// Validation", "Departments",
		// MarketPlaceText);

	}

	public void SelectMarketPlaceShoppingList(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {
		try {
			// reportInfo(driver, strTestCaseName, strDevice, "START-Select the Shopping
			// List ", "Select the Shopping List");
			clickLink(driver, strTestCaseName, strDevice, "Market Place Shopping List",
					MarketPlaceShoppingList);
			// reportInfo(driver, strTestCaseName, strDevice, "END-Select the View All
			// Shopping List", "Select the Shopping List");
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END-Select the Shopping List",
					"Failed to Select the Shopping List");
			e.printStackTrace();
		}
	}

	public void verifyProductDetails(String strTestCaseName, String strDevice) throws IOException {
		try {
			clickButton(driver, strTestCaseName, strDevice, "Product Details", productDetailsLabel);
			String logReport = strTestCaseName + Constants.DELIMITER + strDevice + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER + "PRODUCT DETAILS" + Constants.DELIMITER
					+ "NO DATA" + Constants.DELIMITER + Constants.stepPass;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);
			clickButton(driver, strTestCaseName, strDevice, "Product Details Back Button", backButton);
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public void verifyNutritionalFacts(String strTestCaseName, String strDevice) throws IOException {
		try {
			clickButton(driver, strTestCaseName, strDevice, "Nutritional Labels", nutritionalFactsLabel);
			String logReport = strTestCaseName + Constants.DELIMITER + strDevice + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER + "NUTRITIONAL FACTS"
					+ Constants.DELIMITER + "NO DATA" + Constants.DELIMITER + Constants.stepPass;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);
			clickButton(driver, strTestCaseName, strDevice, "Nutritional Facts Back Button", backButton);
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public void verifyNutritionalClaims(String strTestCaseName, String strDevice) throws IOException {
		try {
			clickButton(driver, strTestCaseName, strDevice, "Marketing and Nutritional Claims",
					marketingClaimsLabel);
			String logReport = strTestCaseName + Constants.DELIMITER + strDevice + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER + "MARKETING AND NUTRITIONAL CLAIMS"
					+ Constants.DELIMITER + "NO DATA" + Constants.DELIMITER + Constants.stepPass;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);
			clickButton(driver, strTestCaseName, strDevice, "Marketing and Nutritional Claims Back Button",
					backButton);
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public void verifyNoResults(String strTestCaseName, String strDevice) throws Exception {
		try {
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "No Results Available", noResults);

			// WebElement parentCell =
			// driver.findElement(By.xpath("//XCUIElementTypeStaticText[contains(@name,
			// \"flexNoResHeader\")]/parent::*");
			// parentCell.findElement(By.className("XCUIElementTypeStaticText")).getText().equals("Infiniti"))
			// String noResultsText = getObjectText(driver, strTestCaseName, strDevice, "No
			// Reults AvailableText", noResults);
			// compareValues(driver, strTestCaseName, strDevice, "Contact Us Page Title Text
			// Validation","No Results Available", noResultsText);
			appli.verifyPageWithApplitools(driver, strTestCaseName, strDevice,
					"Search Page--> No Reults Available Text", "layout");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyRealTimePricing(String strTestCaseName, String strDevice, String RealTimeFacingPrice)
			throws Exception {
		try {
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Pricing Label", lbl_PriceOne);
			String RTP = getObjectText(driver, strTestCaseName, strDevice, "Real Time Pricing Value", lbl_PriceOne);
			compareValues(driver, strTestCaseName, strDevice, "Real Time Pricing", RealTimeFacingPrice, RTP);

			// appli.verifyPageWithApplitools(driver, strTestCaseName, strDevice, "Search
			// Page--> No Reults Available Text", "strict");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyInventoryRealTimePricing(String strTestCaseName, String strDevice, String RealTimeFacingPrice)
			throws Exception {
		try {
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Pricing Label", lbl_CSCost);
			String RTP = getObjectText(driver, strTestCaseName, strDevice, "Real Time Pricing Value", lbl_CSCost);
			compareValues(driver, strTestCaseName, strDevice, "Validate Realt Time Pricing", RealTimeFacingPrice, RTP);

			// appli.verifyPageWithApplitools(driver, strTestCaseName, strDevice, "Search
			// Page--> No Reults Available Text", "strict");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyShippingInformation(String strTestCaseName, String strDevice) throws IOException {
		try {
			clickButton(driver, strTestCaseName, strDevice, "Shipping Information", shippingInformationLabel);
			String logReport = strTestCaseName + Constants.DELIMITER + strDevice + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER + "SHIPPING INFORMATION"
					+ Constants.DELIMITER + "NO DATA" + Constants.DELIMITER + Constants.stepPass;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);
			clickButton(driver, strTestCaseName, strDevice, "Shipping Information Back Button", backButton);
			clickButton(driver, strTestCaseName, strDevice, "Product OverView Back Button",
					productOverviewBackButton);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public void verifySpanishOfferDetailsPageIsDisplayed(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {
		try {
			verifyPageHeader(driver, strTestCaseName, strDevice, "Detalles de la oferta  Page ",
					SpanishOfferDetailsTitle);
			// Compare the add event page description value
			String SpanishOfferDetailspagetitle = getObjectText(driver, strTestCaseName, strDevice,
					"Detalles de la oferta Page title", SpanishOfferDetailsTitle);
			compareValues(driver, strTestCaseName, strDevice, "Offer Details Page",
					"Detalles de la oferta" + "", SpanishOfferDetailspagetitle);
			// Verify Search page using Applitools eyes
			appli.verifyPageWithApplitools(driver, strTestCaseName, strDevice, "Detalles de la oferta Page", "strict");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyReplaceTextandIcon(String strTestCaseName, String strDevice, String replaceProductNumber, String productType) throws IOException, InterruptedException
	{
		try {
		
			if (productType.equalsIgnoreCase("Normal"))
			{
			// Verify ListDetails page using Applitools eyes
			//appli.verifyPageWithApplitools(driver, strTestCaseName, strDevice, "Shopping List Replace text validation", Constants.LAYOUT);

			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Replace text",replaceProductsText);	
			String ReplaceTextEnglishBeforeSplit = getObjectText(driver, strTestCaseName, strDevice, "Replace product text",replaceProductsText);
			String[] ReplaceTextEnglishAfterSplit = ReplaceTextEnglishBeforeSplit.split(" ");			
			compareValues(driver, strTestCaseName, strDevice, "Replace text", REPLACES_TXT,
					ReplaceTextEnglishAfterSplit[0]);
			compareValues(driver, strTestCaseName, strDevice, "Replace product number", replaceProductNumber,
					ReplaceTextEnglishAfterSplit[1]);
			//verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Verify Replace image is displayed",replaceProductsImage);			
			}
			else if (productType.equalsIgnoreCase("Direct"))
			{
				// Verify ListDetails page using Applitools eyes
				//appli.verifyPageWithApplitools(driver, strTestCaseName, strDevice, "Shopping List Replace text validation", Constants.LAYOUT);
				verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Direct Get it by text",directGetItByText);	
				String ReplaceTextEnglishBeforeSplit = getObjectText(driver, strTestCaseName, strDevice, "Replace product text",replaceProductsText);
				String[] ReplaceTextEnglishAfterSplit = ReplaceTextEnglishBeforeSplit.split(" ");			
				compareValues(driver, strTestCaseName, strDevice, "Replace text", REPLACES_TXT,
						ReplaceTextEnglishAfterSplit[0]);
				compareValues(driver, strTestCaseName, strDevice, "Replace product number", replaceProductNumber,
						ReplaceTextEnglishAfterSplit[1]);
				verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Replace image",replaceProductsImage);	
			}
			else if (productType.equalsIgnoreCase("Advertised Product"))
			{
				
				// Verify ListDetails page using Applitools eyes
				//appli.verifyPageWithApplitools(driver, strTestCaseName, strDevice, "Shopping List Replace text validation", Constants.LAYOUT);
				//Data not available Add validation for advertise banner
				
				verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Replace text",replaceProductsText);	
				String ReplaceTextEnglishBeforeSplit = getObjectText(driver, strTestCaseName, strDevice, "Replace product",replaceProductsText);
				String[] ReplaceTextEnglishAfterSplit = ReplaceTextEnglishBeforeSplit.split(" ");			
				compareValues(driver, strTestCaseName, strDevice, "Replace text", "replaces",
						ReplaceTextEnglishAfterSplit[0]);
				compareValues(driver, strTestCaseName, strDevice, "Replace product number", replaceProductNumber,
						ReplaceTextEnglishAfterSplit[1]);
				//verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Verify Replace image is displayed",replaceProductsImage);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void verifyReplaceTextandIconNotDisplayed(String strTestCaseName, String strDevice, String ProductNumber)
			throws InterruptedException, IOException {
		try {
			
			verifyElementIsNotDisplayed(driver, strTestCaseName, strDevice, "Replace text",replaceProductsText);
			//clickcoordinatesdone(driver, strTestCaseName, strDevice);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void verifyLockIcon(String strTestCaseName, String strDevice)
	{
		try {
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Lock Icon", replaceProductsText);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void verifyAndClickAlternateProducts(String strTestCaseName, String strDevice) throws IOException
	{
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Alternate Products Available", alternateProductsText);
		clickButton(driver, strTestCaseName, strDevice, "Alternate Products", alternateProductsText);
	}
	
	public void verifyAlternateProductsScreen(String strTestCaseName, String strDevice) throws IOException
	{
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Alternate Products Screen Header", alternateProductsHeader);
		
	}
}
