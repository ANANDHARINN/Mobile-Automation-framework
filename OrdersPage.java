package com.salesTool.pages;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.mobile.NetworkConnection;
import org.openqa.selenium.mobile.NetworkConnection.ConnectionType;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.salesTool.applitools.ApplitoolsVerification;
import com.salesTool.common.BaseTest;
import com.salesTool.util.Constants;
import com.salesTool.util.LocatorConstants;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.android.Connection;

public class OrdersPage extends BaseTest {
	private static final By productSearch = MobileBy.AccessibilityId("tbxSearch");
	private static final By productSearch1 =By.xpath("//*[@id='tbxSearchOrder']");
	private static final By orderConfirmation = MobileBy.AccessibilityId("lblHeaderPopup");
	private static final By orderConfirmationImg = MobileBy.AccessibilityId("imgConf");
	private static final By thankYouOrder = MobileBy.AccessibilityId("lblGreetingsHeader");
	private static final By submittedSuccessfully = MobileBy.AccessibilityId("lblOrdStatus");
	private static final By orderNumberLabel = MobileBy.AccessibilityId("lblOrdno");
	private static final By orderNumber = MobileBy.AccessibilityId("lblOrdNumber");
	private static final By estimatedDeliveryLabel = MobileBy.AccessibilityId("lblEstimatedDate");
	private static final By estimatedDeliveryDate = MobileBy.AccessibilityId("lblDelDate");
	private static final By promotionImg = MobileBy.AccessibilityId("imgInvoicePromotion");
	private static final By promotionMessage = MobileBy.AccessibilityId("lblInvoicePromotion");
	private static final By okBtn = MobileBy.AccessibilityId("popbtn");
	private static final By newOrderBtn = MobileBy.AccessibilityId("btnNewOrder");
	private static final By spanishnewOrderBtn=By.xpath("//*[@text='Orden Nueva']");
	private static final By addToOrderBtn = MobileBy.AccessibilityId("btnAdd");
	private static final By reviewOrderBtn = MobileBy.AccessibilityId("flexAddToOrder");
	private static final By submitBtn = MobileBy.AccessibilityId("btnUpdate");
	private static final By doneButton = By.xpath("(//XCUIElementTypeButton[@name='Done'])[2]");
	private static final By searchInListScreens = MobileBy.AccessibilityId("tbxSearch");
	private static final By poNumberBox = MobileBy.AccessibilityId("tbxPONumber");
	private static final By splitOrderOkBtn = MobileBy.AccessibilityId("btnOk");
	private static final By orderSplitMsg = MobileBy.AccessibilityId("lblOrderSplit");
	private static String orderSplitMsgText = "One or more items you have ordered are not available for delivery on your scheduled delivery date. Separate order(s) have been created for these items. Please review the list of your Orders and check that the CES order(s) exceed your minimum dollar amount, or you may be assessed additional fees.";
	private static final By splitOrderHeader = MobileBy.AccessibilityId("hbxTitle");
	private static final By firstOrderNumber = MobileBy.AccessibilityId("segOrders_1_1_flexOrderList_flexOrders_flexOrdersInner_flexOrderInfo_flexOrderNumber_lblOrderNumberVal");
	private static final By cancelOrderBtn = By.xpath("//XCUIElementTypeStaticText[@value='Cancel Order']");
	private static final By firstOrder = MobileBy.AccessibilityId("segOrders_1_1_flexOrderList_flexOrders_flexOrdersInner_flexOrderInfo_flexDisplayStatus_lblDisplayStatus");
	private static final By deliveryDate = MobileBy.AccessibilityId("lblDateDel");
	private static final By submittedOrder=By.xpath("//*[@id='segOrders_1_1_flexOrderList_flexOrders_flexOrdersInner_flexOrderInfo_flexDisplayStatus_lblDisplayStatus']");
	private static final By done = MobileBy.AccessibilityId("btnDone");
	private static final By confirmNavigationPopup = MobileBy.AccessibilityId("hboxtitle");
	private static final By confirmNavigation = By.xpath("//XCUIElementTypeStaticText[@label='Confirm Navigation']");
	private static final String expectedMessage = "You have unsaved changes. Are you sure you wish to discard them?";
	private static final By continueOrYesOrViewBtn = By.xpath("//*[@text='Yes']");
	private static final By cancelOrNoBtn =  By.xpath("//*[@id='btnLeft']");
	private static final By warningPopUp = MobileBy.AccessibilityId("dynamicpopup");
	private static final By warningTitle = By.xpath("//*[@text='Warning']");
	private static final String expectedWarningMessage = "Your changes to the order will not be saved. Do you want to proceed?";
	private static final By warningMessage = MobileBy.AccessibilityId("lblMsg");
	private static final By myAccountBanner = MobileBy.AccessibilityId("flexMyAccount");
	private static final By btn_FromDate = MobileBy.AccessibilityId("calendarFromDate");
	private static final By btn_ToDate = MobileBy.AccessibilityId("calendarToDate");
	private static final By Chk_All = MobileBy.AccessibilityId("imgAll");
	private static final By Chk_CreditMemo = MobileBy.AccessibilityId("lblTypeCreditMemo");
	private static final By Chk_DebitMemo = MobileBy.AccessibilityId("lblTypeDebitMemo");
	private static final By Chk_Invoice = MobileBy.AccessibilityId("lblTypeInvoice");
	private static final By Chk_InvoiceFWCl = MobileBy.AccessibilityId("lblTypeInvoiceFWC");
	private static final By Chk_OriginalInvoicel = MobileBy.AccessibilityId("lblTypeOriginalInvoice");
	private static final By tbx_tbxDocNum = MobileBy.AccessibilityId("tbxDocNum");
	private static final By lbl_DocumentNumber = MobileBy.AccessibilityId("lblDocumentNumber");
	private static final By btn_SearchInvoices = MobileBy.AccessibilityId("btnSearch");
	private static final By viewEditLbl = By.xpath("//XCUIElementTypeStaticText[@value='View/Edit Will Call']");
	private static final By convertOrder = By.xpath("//XCUIElementTypeStaticText[@value='Convert Order']");
	private static final By convertOrderMessage = By.xpath("//XCUIElementTypeStaticText[@value='Are you sure you want to update Will Call details?']");
	private static final By originalDeliveryDatelbl = MobileBy.AccessibilityId("lblOrderDeliveryDate");
	private static final By pickupDatelbl = MobileBy.AccessibilityId("lblPickupDate");
	private static final By pickupTimelbl = MobileBy.AccessibilityId("lblPickupTime");
	private static final By willCallTypelbl = MobileBy.AccessibilityId("lblWillCallType");
	private static final By personPickingUplbl = MobileBy.AccessibilityId("lblPersonPickingUp");
	private static final By customerPOlbl = MobileBy.AccessibilityId("lblCustomerPO");
	private static final By specialInstructionslbl = MobileBy.AccessibilityId("lblSpecialInstructions");
	private static final By originalDeliveryDate = MobileBy.AccessibilityId("lblDeliveryDate");
	private static final By pickupDate = MobileBy.AccessibilityId("calWillCall");
	private static final By pickupHrs = MobileBy.AccessibilityId("btnPickupHrs");
	private static final By pickupMins = MobileBy.AccessibilityId("btnPickupMins");
	private static final By pickupAmPm = MobileBy.AccessibilityId("btnPickupAmpm");
	private static final By willCallType = MobileBy.AccessibilityId("lblWillCallCustomer");
	private static final By personPickingUp = MobileBy.AccessibilityId("txtPersonPickingUp");
	private static final By customerPO = MobileBy.AccessibilityId("txtPO");
	private static final By specialInstructions = MobileBy.AccessibilityId("textAreaSI");
	private static final By cancelLabel = By.xpath("//*[@value='Cancel Order']");
	private static final By convertOrderLbl = By.xpath("//*[@text='Convert to Will Call']");
	private static final By convertOrderbtn = By.xpath("//*[@text='Convert Order']");
	private static final By viewWillCallLbl = By.xpath("//XCUIElementTypeStaticText[@value='View Will Call']");
	private static final By dateCreatedLbl = MobileBy.AccessibilityId("lblOrderDeliveryDateWC");
	private static final By pickupDateCMLbl = MobileBy.AccessibilityId("lblPickUpDateWC");
	private static final By pickupTimeCMLbl = MobileBy.AccessibilityId("lblPickupTimeLabel");
	private static final By willCallTypeCMLbl = MobileBy.AccessibilityId("lblWillcallTypeLabel");
	private static final By personPickingUpCMLbl = MobileBy.AccessibilityId("lblPersonPickingUpLabel");
	private static final By customerPOLbl = MobileBy.AccessibilityId("lblCustPOLabel");
	private static final By specialInstructionsCMLbl = MobileBy.AccessibilityId("lblSpecialInstructionsWC");
	private static final By dateCreatedValue = MobileBy.AccessibilityId("lblOrderDeliveryDateWC");
	private static final By pickupDateCMValue = MobileBy.AccessibilityId("lblPickUpDateWC");
	private static final By pickupTimeCMValue = MobileBy.AccessibilityId("lblPickupTimeLabel");
	private static final By willCallTypeCMValue = MobileBy.AccessibilityId("lblWillcallTypeLabel");
	private static final By personPickingUpCMValue = MobileBy.AccessibilityId("lblPersonPickingUpLabel");
	private static final By customerPOValue = MobileBy.AccessibilityId("lblCustPOLabel");
	private static final By specialInstructionsCMValue = MobileBy.AccessibilityId("lblSpecialInstructionsWC");
	private static final By hours = By.xpath("//XCUIElementTypeStaticText[@value='06']");
	private static final By minutes = By.xpath("//XCUIElementTypeStaticText[@value='45']");
	private static final By orderException = By.xpath("//*[@text='Order Exceptions']");
	private static final By btnFinished = MobileBy.AccessibilityId("btnFinished");
	private static final String expectedMessageCode744 = "The quantity requested exceeds the currently available inventory. Please choose an action or select a substitute product.";
	private static final String expectedMessageCode610 = "The system price could not be determined for this product.";
	private static final String expectedMessageCode626 = "is not available. Please select a substitute item";
	private static final String expectedMessageCode601 = "This product has been discontinued and is no longer available. Please select a substitute item.";
	private static final By exceptionProductName = MobileBy.AccessibilityId("segSubException_1_1_flexSubException_flexSubInner_flexProductDetails_flexProdDetails_richName");
	private static final By exceptionShowSubstitutes = MobileBy.AccessibilityId("segSubException_1_1_flexSubException_flexSubInner_flexSubButtons_btnSubOrSearch");
	private static final By exceptionQuantityOrdered = MobileBy.AccessibilityId("segSubException_1_1_flexSubException_flexSubInner_flexProductDetails_flexProdDetails_lblQtyOrdered");
	private static final By exceptionQuantityReserved = MobileBy.AccessibilityId("segSubException_1_1_flexSubException_flexSubInner_flexProductDetails_flexProdDetails_lblQtyReserved");
	private static final By exceptionInStock = MobileBy.AccessibilityId("segSubException_1_1_flexSubException_flexSubInner_flexProductDetails_flexProdDetails_lblExpectedInStock");
	private static final By exceptionProductBrand = MobileBy.AccessibilityId("segSubException_1_1_flexSubException_flexSubInner_flexProductDetails_flexProdDetails_flexBrand_lblBrand");
	private static final By exceptionProductQuantity = MobileBy.AccessibilityId("segSubException_1_1_flexSubException_flexSubInner_flexProductDetails_flexProdDetails_flexQty_lblPackSize");
	private static final By exceptionProductPrice = MobileBy.AccessibilityId("segSubException_1_1_flexSubException_flexSubInner_flexProductDetails_flexProdDetails_flexPrice_lblCSPrice");
	private static final By exceptionQuantityOrderedBox = MobileBy.AccessibilityId("segSubException_1_1_flexSubException_flexSubInner_flexProductDetails_flexProdDetails_flexQtyOrdered_flexCSQty_lblCSQty");
	private static final By exceptionQuantityReservedBox = MobileBy.AccessibilityId("segSubException_1_1_flexSubException_flexSubInner_flexProductDetails_flexProdDetails_flexQtyReserved_flexCSQtyReserved_lblCSQtyReserved");
	private static final By exceptionSelectAction = MobileBy.AccessibilityId("segSubException_1_1_flexSubException_flexSubInner_flexSubButtons_btnSelectAction");
	private static final By exceptionSearchForMore = MobileBy.AccessibilityId("segSubException_1_2_flexSubException_flexSubInner_flexSubButtons_btnSubOrSearch");
	private static final By exceptionSubstituteWith = MobileBy.AccessibilityId("segSubException_1_1_flexSubException_flexSubInner_flexSubWith_lblSubWith");
	private static final By exceptionSubstituteProductName = MobileBy.AccessibilityId("segSubException_1_2_flexSubException_flexSubInner_flexProductDetails_flexProdDetails_richName");
	private static final By exceptionSubstituteProductBrand = MobileBy.AccessibilityId("segSubException_1_2_flexSubException_flexSubInner_flexProductDetails_flexProdDetails_flexBrand_lblBrand");
	private static final By exceptionSubstituteProductSize = MobileBy.AccessibilityId("segSubException_1_2_flexSubException_flexSubInner_flexProductDetails_flexProdDetails_flexQty_lblPackSize");
	private static final By exceptionSubstituteProductPrice = MobileBy.AccessibilityId("segSubException_1_2_flexSubException_flexSubInner_flexProductDetails_flexProdDetails_flexPrice_lblCSPrice");
	private static final By exceptionSubstituteProductQuantity = MobileBy.AccessibilityId("segSubException_1_2_flexSubException_flexSubInner_flexProductDetails_flexProdDetails_flexQtyOrdered_flexCSQty_lblCSQty");
	private static final By exceptionSubstituteSelectAction = MobileBy.AccessibilityId("segSubException_1_2_flexSubException_flexSubInner_flexSubButtons_btnSelectAction");
	private static final By ackExceptionError = MobileBy.AccessibilityId("segACKException_1_1_flexAckException_flexAckExceptionInner_lblExceptionMessage");
	private static final By ackExceptionProductName = MobileBy.AccessibilityId("segACKException_1_1_flexAckException_flexAckExceptionInner_flexProductDetails_flexProdDetails_richName");
	private static final By ackExceptionQuantityBox = MobileBy.AccessibilityId("segACKException_1_1_flexAckException_flexAckExceptionInner_flexQtyBox_lblQtyOne");
	private static final By ackExceptionPackSize = MobileBy.AccessibilityId("segACKException_1_1_flexAckException_flexAckExceptionInner_flexProductDetails_flexProdDetails_flexQty_lblPackSize");
	private static final By ackExceptionAcknowledgeBtn = MobileBy.AccessibilityId("segACKException_1_1_flexAckException_flexAckExceptionInner_btnAcknowledge");
	private static final By ackExceptionAcknowledgeSuccessMsg = MobileBy.AccessibilityId("segACKException_1_1_flexAckException_flexAckExceptionInner_lblSuccessMessage");
	private static final By selectSubstitute = By.xpath("//*[contains(@text,'Select Substitute')]");
	private static final By startnewinventory = By.xpath("//XCUIElementTypeOther[@name='flexButton']");
	private static final By lnk_Contactustitle = By.xpath("//XCUIElementTypeStaticText[@name='lblContactusTitle']");
	private static final By ProDetailsTittle = By.xpath("//XCUIElementTypeStaticText[@value='Product Details']");
	private static final By InventoryDetailsTittle = By.xpath("//XCUIElementTypeStaticText[@value='Inventory Details']");
	private static final By ParStockTittle = By.xpath("//XCUIElementTypeStaticText[@value='Par Stock']");
	private static final By NutritionalFactsTittle = By.xpath("//XCUIElementTypeStaticText[@value='Nutrition Facts']");
	private static final By shippinginfotitle = By.xpath("//XCUIElementTypeStaticText[@value='Shipping Information']");
	private static final By MarketingClaimsTittle = By.xpath("//XCUIElementTypeStaticText[@value='Marketing & Nutritional']");
	private static final By UnsavedOrderTitle = By.xpath("//XCUIElementTypeStaticText[@value='Unsaved Order']");
	private static final By ViewOrder = MobileBy.AccessibilityId("btnYes");
	private static final By DiscardChanges = MobileBy.AccessibilityId("btnNo");
	private static final By UnSavedorder = MobileBy.AccessibilityId("lblMsg");
	private static final By ProductDetailTitle = By.xpath("//*[@text='Product Detail']");
	private static final By BuscarTitle = By.xpath("//XCUIElementTypeStaticText[@value='Buscar']");
	private static final By HelpImage = By.xpath("//XCUIElementTypeImage[@name='segHelpImages_1_imgHelp']");
	private static final By newinventoryheader = By.xpath("//XCUIElementTypeStaticText[@name='lblInventory']");
	private static final By selectshoppinglist = By.xpath("//XCUIElementTypeStaticText[@name='lblShoppingList']");
	private static final By selectinventorydate = By.xpath("//XCUIElementTypeStaticText[@name='lblInvDate']");
	private static final By begininventory = By.xpath("//XCUIElementTypeButton[@name='btnBeginInv']");
	private static final By shoppingList1 = By.xpath("//XCUIElementTypeImage[@name='imgArrowThree']");
	private static final By shoppinglistpopup = By.xpath("//XCUIElementTypeScrollView[@name='popupActionSheet']");
	private static final By oneofshoppinglist = By.xpath("//XCUIElementTypeCell[@name='segActionSheet_1_5']");
	private static final By ChangePriceTitle = By.xpath("//XCUIElementTypeStaticText[@value='Change Price']");
	private static final By RichUserDetails = MobileBy.AccessibilityId("richUserDetails");
	private static final By lbl_CSCurrentVal = MobileBy.AccessibilityId("lblCSCurrentVal");
	private static final By lbl_CSComVal = MobileBy.AccessibilityId("lblCSComVal");
	private static final By lbl_CSPrice = MobileBy.AccessibilityId("lblCSNew");
	private static final By lbl_Target = MobileBy.AccessibilityId("lblTarget");
	private static final By lbl_Max = MobileBy.AccessibilityId("lblMax");
	private static final By flexKeypad = MobileBy.AccessibilityId("flexKeypad");
	private static final By btn_One = MobileBy.AccessibilityId("btnOne");
	private static final By btn_Two = MobileBy.AccessibilityId("btnTwo");
	private static final By btn_Three = MobileBy.AccessibilityId("btnThree");
	private static final By btn_Four = MobileBy.AccessibilityId("btnFour");
	private static final By btn_Five = MobileBy.AccessibilityId("btnFive");
	private static final By btn_Six = MobileBy.AccessibilityId("btnSix");
	private static final By btn_Seven = MobileBy.AccessibilityId("btnSeven");
	private static final By btn_Eight = MobileBy.AccessibilityId("btnEight");
	private static final By btn_Nine = MobileBy.AccessibilityId("btnNine");
	private static final By btn_Zero = MobileBy.AccessibilityId("btnZero");
	private static final By btn_Decimal = MobileBy.AccessibilityId("btnDecimal");
	private static final By btn_Cross = MobileBy.AccessibilityId("btnCross");
	private static final By btn_Cancel = MobileBy.AccessibilityId("btnCancel");
	private static final By btn_ChangePrice = MobileBy.AccessibilityId("btnChangePrice");
	private static final By lbl_DeliveryDate = MobileBy.AccessibilityId("lblDeliveryDate");
	private static final By lbl_OrderNumber = MobileBy.AccessibilityId("lblOrderNumber");
	private static final By lbl_Ordered = MobileBy.AccessibilityId("lblOrdered");
	private static final By lbl_Reserved = MobileBy.AccessibilityId("lblReserved");
	private static final By lbl_SpecialInstructions = MobileBy.AccessibilityId("lblSpecialInstructions");
	private static final By lbl_PONumber = MobileBy.AccessibilityId("lblPONumber");
	private static final By lbl_TotAmnt = MobileBy.AccessibilityId("lblTotAmnt");
	private static final By lbl_TotLines = MobileBy.AccessibilityId("lblTotLines");
	private static final By lbl_OrderStatus = MobileBy.AccessibilityId("lblOrderStatus");
	private static final By Ord_DeliveryDate = By.xpath("//XCUIElementTypeStaticText[@value='Delivery Date:']");
	private static final By Order_TotalLine = By.xpath("//XCUIElementTypeStaticText[@value='Totals:']");
	private static final By Order_CreationDate = By.xpath("//XCUIElementTypeStaticText[@value='Creation Date:']");
	private static final By Order_CreationDateText = By.xpath("//XCUIElementTypeStaticText[contains(@name,'1_lblCreateDateVal')]");
	private static final By selectShoppingList = By.xpath("//XCUIElementTypeStaticText[@value='Order Guide (# 375997)']");
	private static final By OrderGuid = By.xpath("//*[@id='segShoppingList_1_1_flexSearchSeg_flexGuidesAndList_lblOption']");
	private static final By ProductSearch = By.xpath("//XCUIElementTypeTextField[@name='tbxSearch']");
	private static final By favProductSearch = MobileBy.AccessibilityId("tbxSearchOrder");
	private static final By ShoppingListProductSearch = MobileBy.AccessibilityId("tbxSearchOrder");
	private static final By ProductQuantity = MobileBy.AccessibilityId("segSearch_1_1_flexProducts_flexBaseContainer_flexItemContainerParent_flexItem_flexPricingContainer_flexDetails_flexQuantity_flexQuantityOne_lblQtyOne");
	private static final By addproducts = By.xpath("//XCUIElementTypeButton[@value='Add Products']");
	private static final By ProductOverView = MobileBy.AccessibilityId("segSearch_1_1_flexProducts_flexBaseContainer_flexItemContainer_flexItem_flexDetails_richName");
	private static final By ProductDetailsscreen_Inventory = By.xpath("//XCUIElementTypeOther[contains(@name,'flexDetails_lblName')]");
	private static final By lblProductNumber = MobileBy.AccessibilityId("lblProductNumber");
	private static final By lblProductDescription = MobileBy.AccessibilityId("lblProductDescription");
	private static final By lblAdditionalDescription = MobileBy.AccessibilityId("lblAdditionalDescription");
	private static final By lblBrandName = MobileBy.AccessibilityId("lblBrandName");
	private static final By lblPackSize = MobileBy.AccessibilityId("lblPackSize");
	private static final By lblUnitOfMeasure = MobileBy.AccessibilityId("lblUnitOfMeasure");
	private static final By lblPartialUnitsAvailable = MobileBy.AccessibilityId("lblPartialUnitsAvailable");
	private static final By lblStatus = MobileBy.AccessibilityId("lblStatus");
	private static final By lblBrandType = MobileBy.AccessibilityId("lbBrandType");
	private static final By lblManufacturer = MobileBy.AccessibilityId("lblManufacturer");
	private static final By lblClass = MobileBy.AccessibilityId("lblClass");
	private static final By lblCategory = MobileBy.AccessibilityId("lblCategory");
	private static final By lblGroup = MobileBy.AccessibilityId("lblGroup");
	private static final By lblGTIN = MobileBy.AccessibilityId("lblGTIN");
	private static final By lblUPCCode = MobileBy.AccessibilityId("lblUPCCode");
	private static final By lblIngredients = MobileBy.AccessibilityId("lblIngredients");
	private static final By lblServingSuggestions = MobileBy.AccessibilityId("lblServingSuggestions");
	private static final By lblPreparationInstructions = MobileBy.AccessibilityId("lblPreparationInstructions");
	private static final By lblHandlingInstructions = MobileBy.AccessibilityId("lblHandlingInstructions");
	private static final By lblLocallySourced = MobileBy.AccessibilityId("lblLocallySourced");
	private static final By NutritionalFacts = By.xpath("//*[@text='Marketing & Nutritional Claims']");
	private static final By AmntPerServ = MobileBy.AccessibilityId("lblAmntPerServ");
	private static final By Calory = MobileBy.AccessibilityId("lblCalory");
	private static final By TotalFat = MobileBy.AccessibilityId("lblTotalFat");
	private static final By Cholesterol = MobileBy.AccessibilityId("lblCholesterol");
	private static final By SodiumVal = MobileBy.AccessibilityId("lblSodiumVal");
	private static final By TotalCarbo = MobileBy.AccessibilityId("lblTotalCarbo");
	private static final By SupplementalFacts = MobileBy.AccessibilityId("lblSupplementalFacts");
	private static final By PercentDailyValue = MobileBy.AccessibilityId("lblPercentDailyValue");
	private static final By ProteinVal1 = MobileBy.AccessibilityId("lblProteinVal");
	private static final By ShippingInfo = MobileBy.AccessibilityId("lblPhysicalAttributes");
	private static final By MarkingInfo = MobileBy.AccessibilityId("lblMarketingClaims");
	private static final By searchbox = By.xpath("//XCUIElementTypeTextField[@name='tbxSearchOrder']");
	private static final By createparorder = By.xpath("//XCUIElementTypeStaticText[@name='segActionSheet_1_1_lblActionItem']");
	private static final By pardatelable = By.xpath("//XCUIElementTypeStaticText[@name='lblInvDate']");
	private static final By monday = By.xpath("//XCUIElementTypeStaticText[@name='lblMon']");
	private static final By cancelbutton = By.xpath("//XCUIElementTypeButton[@name='btnLeft']");
	private static final By donebutton = By.xpath("//XCUIElementTypeButton[@name='btnRight']");
	private static final By selectmonday = By.xpath("//XCUIElementTypeImage[@name='imgMon']");
	private static final By ok = By.xpath("//XCUIElementTypeButton[@name='okButton]");
	private static final By noparmsg = By.xpath("//XCUIElementTypeStaticText[@name='lblMsg']");
	private static final By custname = By.xpath("//XCUIElementTypeStaticText[@name='lblUserDetails']");
	private static final By custno = By.xpath("//XCUIElementTypeStaticText[@name='lblCustNum']");
	private static final By csquantity = By.xpath("//XCUIElementTypeStaticText[@name='segSearch_1_1_lblCSQty']");
	private static final By eaquantity = By.xpath("//XCUIElementTypeStaticText[@name='segSearch_1_1_lblEAQty']");
	private static final By priceobj = By.xpath("//XCUIElementTypeStaticText[@name='segSearch_1_1_lblCSCost']");
	private static final By OrderingStatusTitle = By.xpath("//XCUIElementTypeStaticText[@value='Ordering Status']");
	private static final By btn_ConfirmQuantity = By.xpath("//XCUIElementTypeButton[@label='Confirm Quantity']");
	private static final By btn_ShowSubstitute = By.xpath("//*[@text='Show Substitutes']");
	private static final By btn_Quantity = By.xpath("//*[@id='segSubException_1_2_flexSubException_flexSubInner_flexProductDetails_flexProdDetails_flexQtyOrdered_flexCSQty_lblCSQty']");
	private static final By lbl_QuantityConfirmed = By.xpath("//XCUIElementTypeStaticText[@label='Quantity Confirmed']");
	private static final By ProDetails = By.xpath("//XCUIElementTypeStaticText[@value='Product Details']");
	private static final By InventoryDetails = MobileBy.AccessibilityId("lblInventoryDetails");
	private static final By ParStock = MobileBy.AccessibilityId("lblParStock");
	private static final By Keyboarddone = By.xpath(" //XCUIElementTypeButton[@value='Done' and @knownSuperClass='UIAccessibilityElement']");
	private static final By titleHeader = MobileBy.AccessibilityId("lblHeader");
	private static final By btn_Update = MobileBy.AccessibilityId("btnUpdate");
	private static final By tbx_SearchOrder = MobileBy.AccessibilityId("tbxSearchOrder");
	private static final By ele_NoOrderSubmitted = By.xpath("//XCUIElementTypeStaticText[@value='No Order Submitted']");
	private static final By ele_OrderSubmitted = By.xpath("//XCUIElementTypeStaticText[@value='Order Submitted']");
	private static final By lblOrdered = By.xpath("//XCUIElementTypeStaticText[@value='Ordered:']");
	private static final By lbl_TotalAmount = By.xpath("//XCUIElementTypeStaticText[@value='Total Amount:']");
	private static final By lbl_TotalLines = By.xpath("//XCUIElementTypeStaticText[@value='Total Lines:']");
	private static final By SelectOrder = By.xpath("//XCUIElementTypeOther[@name='segCustomerOrderingStatus']/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeOther");
	private static final By WillcallCancelOrder = By.xpath("//XCUIElementTypeStaticText[@value='Cancel Order']");
	private static final By btn_Save = MobileBy.AccessibilityId("btnSave");
	private static final By refreshBtn = By.xpath("//XCUIElementTypeStaticText[contains(@label,'Refresh')]");
	private static final By swt_wfi = MobileBy.AccessibilityId("Wi-Fi");
	private static final By lnk_Department = By.xpath("//XCUIElementTypeStaticText[contains(@name,'lblDept')]");
	private static final By SoftKeyPadCross = By.xpath("//*[@id='btnCross']");
	private static final By SoftKeyPad1 = By.xpath("//*[@id='flexOne']");
	private static final By SoftKeyPad2 = By.xpath("//*[@id='flexTwo']");
	private static final By SoftKeyPad3 = By.xpath("//*[@id='flexThree']");
	private static final By SoftKeyPad4 = By.xpath("//*[@id='flexFour']");
	private static final By SoftKeyPad5 = By.xpath("//*[@id='flexFive']");
	private static final By SoftKeyPad6 = By.xpath("//*[@id='flexSix']");
	private static final By SoftKeyPad7 = By.xpath("//*[@id='flexSeven']");
	private static final By SoftKeyPad8 = By.xpath("//*[@id='flexEight']");
	private static final By SoftKeyPad9 = By.xpath("//*[@id='flexNine']");
	private static final By SoftKeyPad0 = By.xpath("//*[@id='flexZero']");
	private static final By btn_SubforSearch = By.xpath("//XCUIElementTypeButton[@value='Search for Sub']");
	private static final String searchforSub = "Search for Sub";
	private static final String showSubstitue = "Show Substitutes";
	private static final By OfflineOrder = By.xpath("//XCUIElementTypeStaticText[@value='NEW']");
	private static final By OfflineOrder_Update = By.xpath("//XCUIElementTypeStaticText[@value='UPDATED']");
	private static final By Online_NotSubmitted = By.xpath("//XCUIElementTypeStaticText[@value='Not Submitted']");
	private static final By ChangePrice_lbl = By.xpath("//XCUIElementTypeStaticText[@value='Change Price']");
	private static final By OrderDetails = MobileBy.AccessibilityId("lblQtyOrdCaseVal");
	private static final By OrdeAckExptionsDetail = MobileBy.AccessibilityId("segACKException_1_1_lblExceptionMessage");
	private static final By Acknowledge = MobileBy.AccessibilityId("segACKException_1_1_btnAcknowledge");
	private static final By AcknowledgedSuccess = MobileBy.AccessibilityId("segACKException_1_1_lblSuccessMessage");
	private static final By btn_Substitute = By.xpath("//XCUIElementTypeStaticText[@value='Select Substitute']");
	private static final By btn_ShowSubstituteinexp = By.xpath("//XCUIElementTypeButton[contains(text(),'Show Substitute')]");
	private static final By btn_ShowSearchMore = By.xpath("//XCUIElementTypeButton[@label='Search for More']");
	private static final By btn_Selectsub = By.xpath("//*[@id='segSearch_1_1_flexProducts_flexBaseContainer_flexItemContainerParent_flexItem_flexPricingContainer_flexDetails_flexSelectSub_lblSelectSub']");
	private static final By show_subsbtn=By.xpath("//*[@id='Show Substitutes']");
	private static final By btn_Searchforsub = By.xpath("//*[@id='segSubException_1_1_flexSubException_flexSubInner_flexSubButtons_btnSubOrSearch']");
	private static final By lnk_OrderSubstitue = By.xpath("//XCUIElementTypeStaticText[@value='Order Substitute Product(s)']");
	private static final By selectaction =By.xpath("//*[@id='Select Action']");
	private static final By original_product_ordered=By.xpath("//*[@text='Original Product Ordered']");
	private static final By order_originalproduct =By.xpath("//*[@text='Order Original Product']");
	private static final By SubstitueOrderStatus = By.xpath("//XCUIElementTypeStaticText[@value='Substitute Product(s) Added']");
	private static final By previouspage = By.xpath("//XCUIElementTypeStaticText[@value='Previous Page']");
	private static final By nextpage = By.xpath("//XCUIElementTypeStaticText[@value='Next Page']");
	private static final By product = By.xpath("//XCUIElementTypeOther[@name='segSearch_1_1_lblName']");
	private static final By Directicon = By.xpath("//XCUIElementTypeImage[@id='imgMarketPlace']");
	private static final By killwarningPopUp = MobileBy.AccessibilityId("vboxRecoverProducts");
	private static final By substituteProductQuantity = By.xpath("//*[@id='segSearch_1_1_flexProducts_flexBaseContainer_flexItemContainer_flexItem_flexDetails_flexQuantity_flexQuantityOne_lblQtyOne']");
	private static final By killwarningTitle = By.xpath("//XCUIElementTypeStaticText[@value='Warning']");
	private static final String killexpectedWarningMessage = "You have product(s) not yet added to an order.";
	private static final By killCustomerDetails = MobileBy.AccessibilityId("hboxCustomer");
	private static final By killbtnDiscard = MobileBy.AccessibilityId("btnDiscard");
	private static final By killbtnAddToOrder = MobileBy.AccessibilityId("btnAddToOrder");
	private static final By btn_UpdatePrice = MobileBy.AccessibilityId("segPriceException_1_1_flexPriceExcep_flexPriceExcepInner_flexPriceButtons_btnUpdatePrice");
	private static final By orderDetail = By.xpath("//*[@text='flexOrderBGCream']");
	private static final By downloadshoppingList = MobileBy.AccessibilityId("btnYes");
	private static final By OpenMyAccount = MobileBy.AccessibilityId("flexMyAccount");
	private static final By PayInvoicesTitle = By.xpath("//XCUIElementTypeStaticText[@value='Pay Invoices']");
	private static final By AdvertisedPromotionBanner = MobileBy.AccessibilityId("flexOffer");
	private static final String productName = "richName";
	//private static final By PayInvoicesTitle = By.xpath("//XCUIElementTypeStaticText[@value='Pay Invoices']");
	//*[@knownSuperClass='_UITableViewCellSeparatorView']
	private static final String nextPage = "//*[contains(@text,'Next Page')]";
	private static final By OrderException = By.xpath("//*[contains(@text,'Order Exception')]");
	private static final By WOULD_YOU_LIKE_TO_TRY_GROUP_HEADER = By.xpath("//*[(@text='You May Like')]");
	private static final By getItById = MobileBy.AccessibilityId("lblGetBy");
	private static final String getItBy = "Get it by";
	private static final String noReturns = ". No returns";
	private static final By departmentDownloadBtn =By.xpath("((//*[@text='Vertical scroll bar, 1 page']");
	private static final By btn_Finished = MobileBy.AccessibilityId("btnFinished");
	private static final By productAvailabilityMsg = MobileBy.AccessibilityId("lblSuccessMessage");
	private static final By OrderExptionsDetail = MobileBy.AccessibilityId("//*[@accessibilityLabel='segSubException_1_1_flexSubException_flexSubInner_lblExceptionMessage']");
	private static final By btnpop_greetings = MobileBy.AccessibilityId("popbtn");
	private static final By lbl_OrdStatus = MobileBy.AccessibilityId("lblHeaderPopup");
	private static final By lnk_ListPageTitle = By.xpath("//*[(@text='List Details')]");
	private static final By Title =MobileBy.AccessibilityId ("lblTitle");
	private static final By MLM_AlternateProductText =By.xpath("//*[@text='Alternate Products Available']");
	private static final By AlternateProductPageHeaderText =By.xpath("//*[@text='Alternate Products']");
	private static final By AlternateProductPageBackbtn =MobileBy.AccessibilityId("imgBack");
	private static final By btn_AddToOrder = MobileBy.AccessibilityId("btnAdd");
	private static final By AlternateProductNumber =By.xpath("//*[@id='segSearch_1_1_flexProducts_flexBaseContainer_flexItemContainerParent_flexItem_flexItemContainer_flexDescriptionContainer_richName']");
	private static final By DirectProductText=By.xpath("//*[@text='DIRECT']");
	private static final By txt_PONumber = MobileBy.AccessibilityId("tbxPONumber");
	private static final By quantityBox = MobileBy.AccessibilityId("lblQtyOne");
	private static final By backButton = MobileBy.AccessibilityId("imgBack");
	private static final By ReviewOrderTitle = MobileBy.AccessibilityId("lblTitle");
	private static final By yesOrViewOrderBtn = By.xpath("//*[@id='Yes']");
	private static final By noBtn = By.xpath("//*[@id='No']");
	private static final By updateOrder=By.xpath("//*[@id='Update Order']");
	private static final By finishBtn=By.xpath("//*[@text='Finished']");
	private static final By downloadOrOpenMyAccountBanner = By.xpath("//*[@text='Download My Account']");

    private static final By downloadOrOpenMyAccountImage = By.xpath("//*[@text='imgMyAccount']");

    private static final By managingYourAccountTxt = By.xpath("//*[@text='Managing your account is easy']");

    private static final By openMyAccountTxt = By.xpath("//*[@text='Open My Account']");

    private static final By downloadMyAccountDismissBtn = By.xpath("//*[@text='imgCloseBtn']");

    private static final String MANAGING_YOUR_ACCOUNT = "Managing your account is easy";

    private static final String DOWNLOAD_MY_ACCOUNT = "Download My Account";
    private static final By  myAccountLoginpage=By.xpath("//*[@text='What would you like to do today?']");
    private static final String OPEN_MY_ACCOUNT = "Open My Account";
    private static final By searchbtn= By.xpath("//*[@text='Search']");
    private static final By myAccount=By.xpath("//*[@text='flexMyAccount']");
    private static final By FromDate=By.xpath("//*[@id='calendarFromDate']");
    private static final By listSearch=By.xpath("//*[@id='tbxSearchOrder']");
	// Change Price
	IOSDriver<MobileElement> driver;
	ApplitoolsVerification appli;
	WebDriverWait wait;

	public OrdersPage(IOSDriver<MobileElement> iosDriver) {
		this.driver = iosDriver;
		appli = new ApplitoolsVerification(iosDriver);
	}

	public void verifyOrdersPageIsDisplayed(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {
		try {
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Orders Screen", LocatorConstants.pageTitle);
			String orderPageTitle = driver.findElement(LocatorConstants.pageTitle).getText();
			//compareValues(driver, strTestCaseName, strDevice, "Orders", "Orders", orderPageTitle);
			appli.verifyPageWithApplitools(driver, strTestCaseName, strDevice, " Applitools - Orders Details",
					"layout");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void verifyDivisionPageIsDisplayed(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void orderRecoveryPopUpDiscard(String strTestCaseName, String strDevice, String PONumber, String PONumber1)
			throws Exception {
		try {
			Thread.sleep(20000);
			String poNumberBeforeChange = driver.findElement(txt_PONumber).getText();
			clearValue(driver, strTestCaseName, strDevice, "Clear the PO number", txt_PONumber);
			// Change the PONumber

			
			setValue(driver, strTestCaseName, strDevice, "FilterList", txt_PONumber, PONumber1);
			
			clickLink(driver, strTestCaseName, strDevice, "Top Done Button", LocatorConstants.topdone);
			clickLink(driver, strTestCaseName, strDevice, "Search Text_FR",poNumberBox);
			clickButton(driver, strTestCaseName, strDevice, "Done Button", doneButton);
			// Date change done
			// change the order quantity
			clickButton(driver, strTestCaseName, strDevice, "Click on the Order", orderDetail);
			Search.enterQuantity(strTestCaseName, deviceDetails);
			clickButton(driver, strTestCaseName, strDevice, "Back Arrow", backButton);
			verifyReviewOrderPageIsDisplayed(strTestCaseName, strDevice);
			// change the order quantity done
			clickButton(driver, strTestCaseName, strDevice, "Back Arrow", backButton);
			
			verifyOrderRecoveryPopUp(strTestCaseName, strDevice);
			// click Yes-changes unsaved
			clickButton(driver, strTestCaseName, strDevice, "Click Yes to discard changes", yesOrViewOrderBtn);
			// Verify Review Order Page is displayed
			// verifyReviewOrderPageIsDisplayed(strTestCaseName, strDevice);
			verifyOrderDetailsPageIsDisplayed(strTestCaseName, deviceDetails);
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "Submitted order recovery popup discard changes unsuccessful",
					"Failed to Click ===> Add to Order");
			e.printStackTrace();
			
		}
	}
	public void addToOrder(String strTestCaseName, String strDevice) throws InterruptedException, IOException {
		try {
			clickButton(driver, strTestCaseName, strDevice, "Add to Order", btn_AddToOrder);
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END-Click ===> Add to Order",
					"Failed to Click ===> Add to Order");
			e.printStackTrace();
		}
	}
	public void verifyReviewOrderPageIsDisplayed(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {
		try {
			// verifyPageHeader(driver, strTestCaseName, strDevice, "Review Order Page ",
			// ReviewOrderTitle);
			// Compare the add event page description value
			String revieworderTitle = getObjectText(driver, strTestCaseName, strDevice, "Review Order title",
					ReviewOrderTitle);
			compareValues(driver, strTestCaseName, strDevice, "Review Order Page Title Text Validation", "Review Order",
					revieworderTitle);
			// Verify ReviewOrder page using Applitools eyes
			appli.verifyPageWithApplitools(driver, strTestCaseName, strDevice, "Search Details", Constants.LAYOUT);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public void clickAlternateProductsAvailabletext(String strTestCaseName, String strDevice) throws Exception {
		try {
			
			clickLink(driver, strTestCaseName, strDevice, "Click Alternate Products Available", MLM_AlternateProductText);
			} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//Validate Alternate products page 

	public void alternateProductsPagevalidation(String strTestCaseName, String strDevice) throws Exception {
		try {
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Alternate Products page header text validation", AlternateProductPageHeaderText);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Back button validation on Alternate product page",AlternateProductPageBackbtn );
			
			} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//Validate Alternate product number

	public void alternateProductNumbervalidation(String strTestCaseName, String strDevice,String ProductNumber1) throws Exception {
			try {
				String AlternateProductNumbertext = driver.findElement(AlternateProductNumber).getText();
				compareValuesContains(driver, strTestCaseName, strDevice, "Alternate Product Number text validation",ProductNumber1, AlternateProductNumbertext);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	public void searchProductInListScreens(String strTestCaseName, String strDevice, String ProductNumber)
			throws InterruptedException, IOException {
		try {

			//setValue_donothidekeyboard(driver, strTestCaseName, strDevice, "FilterList", searchInListScreens, ProductNumber);
			clickLink(driver, strTestCaseName, strDevice, "Top Done Button", LocatorConstants.topdone);
			System.out.println("re");
			clickLink(driver, strTestCaseName, strDevice, "Click the search text", productSearch);
			clickButton(driver, strTestCaseName, strDevice, "Done Button", doneButton);
			String logReport = strTestCaseName + Constants.DELIMITER + strDevice + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER + "List Details search is displayed"
					+ Constants.DELIMITER + "NO DATA" + Constants.DELIMITER + Constants.stepPass;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END-Select the Product from the List Screens",
					"Failed to Select the Product from the List Screens");
			e.printStackTrace();
		}
	}
	public void searchProductInFavouritesScreens(String strTestCaseName, String strDevice, String ProductNumber)
			throws InterruptedException, IOException {
		try {

			//setValue_donothidekeyboard(driver, strTestCaseName, strDevice, "FilterList", searchInListScreens, ProductNumber);
			setValue(driver, strTestCaseName, strDevice, "Select the Product from favourites FilterList", listSearch,
					ProductNumber);
			clickLink(driver, strTestCaseName, strDevice, "Top Done Button", LocatorConstants.topdone);
			clickLink(driver, strTestCaseName, strDevice, "Click the favourites search text", productSearch);
			clickButton(driver, strTestCaseName, strDevice, "Done Button", doneButton);
			
			String logReport = strTestCaseName + Constants.DELIMITER + strDevice + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER + "List Details search is displayed"
					+ Constants.DELIMITER + "NO DATA" + Constants.DELIMITER + Constants.stepPass;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END-Select the Product from the List Screens",
					"Failed to Select the Product from the List Screens");
			e.printStackTrace();
		}
	}
	
	public void searchProductInForgottenScreens(String strTestCaseName, String strDevice, String ProductNumber)
			throws InterruptedException, IOException {
		try {

			//setValue_donothidekeyboard(driver, strTestCaseName, strDevice, "FilterList", searchInListScreens, ProductNumber);
			//clickLink(driver, strTestCaseName, strDevice, "Top Done Button", LocatorConstants.topdone);
			clickLink(driver, strTestCaseName, strDevice, "Click the search text", productSearch1);
			clickButton(driver, strTestCaseName, strDevice, "Done Button", doneButton);
			String logReport = strTestCaseName + Constants.DELIMITER + strDevice + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER + "List Details search is displayed"
					+ Constants.DELIMITER + "NO DATA" + Constants.DELIMITER + Constants.stepPass;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END-Select the Product from the List Screens",
					"Failed to Select the Product from the List Screens");
			e.printStackTrace();
		}
	}
	
	
	
	
	public void addToOrderOrAddProducts(String strTestCaseName, String strDevice) throws InterruptedException, IOException {
		try {
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Add to Order Btn", addToOrderBtn);
			clickButton(driver, strTestCaseName, strDevice, "Select the Add to Order", addToOrderBtn);
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END-Click ===> Add to Order",
					"Failed to Click ===> Add to Order");
			e.printStackTrace();
		}
	}
	
	public void selectNewOrder(String strTestCaseName, String strDevice) throws InterruptedException, IOException {
		try {
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "New Order Btn", newOrderBtn);
			String newOrder = driver.findElement(newOrderBtn).getText();
			compareValues(driver, strTestCaseName, strDevice, "New Order", "New Order", newOrder);
			clickButton(driver, strTestCaseName, strDevice, "New Order", newOrderBtn);
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END-Click ===> New Order",
					"Failed to Click ===> New Order");
			e.printStackTrace();
		}
	}
	
	
	public void finishedException(String strTestCaseName, String strDevice) throws InterruptedException, IOException {
		try {
			clickButton(driver, strTestCaseName, strDevice, "Finish Button", btn_Finished);
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END- Order Submit Button in Review Order Page",
					"Failed to Order Submit Button in Review Order Page");
			e.printStackTrace();
		}
	}
	public void selectNewOrderspanish(String strTestCaseName, String strDevice) throws InterruptedException, IOException {
		try {
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "New Order Btn", spanishnewOrderBtn);
			
			clickButton(driver, strTestCaseName, strDevice, "New Order", spanishnewOrderBtn);
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END-Click ===> New Order",
					"Failed to Click ===> New Order");
			e.printStackTrace();
		}
	}
	
	
	public void submitOrder(String strTestCaseName, String strDevice) throws InterruptedException, IOException {
		try {
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Submit Btn", submitBtn);
			String submit = driver.findElement(submitBtn).getText();
			compareValues(driver, strTestCaseName, strDevice, "Submit", "Submit", submit);
			clickButton(driver, strTestCaseName, strDevice, "Submit Button", submitBtn);
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END- Order Submit Button in Review Order Page",
					"Failed to Order Submit Button in Review Order Page");
			e.printStackTrace();
		}
	}
	public void alternateProductTextdisplayed(String strTestCaseName, String strDevice) throws Exception {
		try {
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Alternate Products text is displayed", MLM_AlternateProductText);
			} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void orderConfirmationWithOrWithoutException(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {
		try {
			
			
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Order Confirmation Header", orderConfirmation);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Order Confirmation Image", orderConfirmationImg);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Thank You for your Order", thankYouOrder);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Submitted Successfully or With Exceptions", submittedSuccessfully);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Order Number Label", orderNumberLabel);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Order Number", orderNumber);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Estimated Delivery Label", estimatedDeliveryLabel);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Estimated Delivery Date", estimatedDeliveryDate);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "OK", okBtn);
			String expectedOrderNumberValue = driver.findElement(orderNumber).getText();
			clickButton(driver, strTestCaseName, strDevice, "OK Button", okBtn);
			verifyOrdersPageIsDisplayed(strTestCaseName, strDevice);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Order Number", firstOrderNumber);
			String actualOrderNumberValue = driver.findElement(firstOrderNumber).getText();
			compareValues(driver, strTestCaseName, strDevice, "Order Number", expectedOrderNumberValue, actualOrderNumberValue);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void verifyOrderSubmittedWithExceptions(String strTestCaseName, String strDevice) throws IOException
	{
		try {
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Order Confirmation Header", orderConfirmation);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Order Confirmation Image", orderConfirmationImg);
			String actualOrderStatus = driver.findElement(submittedSuccessfully).getText();
			compareValues(driver, strTestCaseName, strDevice, "Submit", "Submitted with Exceptions", actualOrderStatus);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectSecondaryNavigation(String strTestCaseName, String strDevice) throws IOException {
		
		clickButton(driver, strTestCaseName, strDevice, "Clicked Three Dots on Top Right side of Screen ",LocatorConstants.secondaryNavigationButton);
		String logReport = strTestCaseName + Constants.DELIMITER + strDevice + Constants.DELIMITER+ getCurrentDateAndTime() + Constants.DELIMITER + "SELECTED SECONDARY NAVIGATION" + Constants.DELIMITER+ "NO DATA" + Constants.DELIMITER + Constants.stepPass;
		appendReportFile(driver, logReport);
		extentReport(driver, logReport);
	}
	
	public void cancelOrder(String strTestCaseName, String strDevice) throws IOException
	{
		clickButton(driver, strTestCaseName, strDevice, "Order", firstOrderNumber);
		
		selectSecondaryNavigation(strTestCaseName, strDevice);
		clickButton(driver, strTestCaseName, strDevice, "Cancel Order", cancelOrderBtn);
		//Incomplete
		clickButton(driver, strTestCaseName, strDevice, "Yes Button", continueOrYesOrViewBtn);
	}
	
	public void promotionTextInOrderConfirmation(String strTestCaseName, String strDevice) throws IOException
	{
		try {
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Promotion Image", promotionImg);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Promotion Text", promotionMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickReviewOrderButton(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {
		try {
			clickButton(driver, strTestCaseName, strDevice, "Review Order", reviewOrderBtn);
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END-Click Review Order Button",
					"Failed to Select Review Order Page");
			e.printStackTrace();
		}
	}

	public void setPONumber(String strTestCaseName, String strDevice, String PONumber)
			throws InterruptedException, IOException {
		try {
			setValue(driver, strTestCaseName, strDevice, "PO Number", poNumberBox, PONumber);
			clickLink(driver, strTestCaseName, strDevice, "Top Done Button", LocatorConstants.topdone);
			clickLink(driver, strTestCaseName, strDevice, "Search Text_FR",poNumberBox);
			clickButton(driver, strTestCaseName, strDevice, "Done Button", doneButton);
		
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END-Entering PO Number in Review Order Page",
					"Failed to enter PO Number in Review Order Page");
			e.printStackTrace();
		}
	}
	public void orderRecoveryPopUpSave(String strTestCaseName, String strDevice, String PONumber, String PONumber1)
			throws Exception {
		try {
			Thread.sleep(20000);
			clearValue(driver, strTestCaseName, strDevice, "Clear the PO number", txt_PONumber);
			// Change the PONumber

			
			setValue(driver, strTestCaseName, strDevice, "FilterList", txt_PONumber, PONumber1);
			
			clickLink(driver, strTestCaseName, strDevice, "Top Done Button", LocatorConstants.topdone);
			clickLink(driver, strTestCaseName, strDevice, "Search Text_FR",poNumberBox);
			clickButton(driver, strTestCaseName, strDevice, "Done Button", doneButton);
			// Date change done
			// change the order quantity
			clickButton(driver, strTestCaseName, strDevice, "Click on the Order", orderDetail);
			Search.enterQuantity(strTestCaseName, deviceDetails);
			clickButton(driver, strTestCaseName, strDevice, "Back Arrow", backButton);
			verifyReviewOrderPageIsDisplayed(strTestCaseName, strDevice);
			// change the order quantity done
			clickButton(driver, strTestCaseName, strDevice, "Back Arrow", backButton);
						verifyOrderRecoveryPopUp(strTestCaseName, strDevice);
			// click Yes-changes unsaved
			clickButton(driver, strTestCaseName, strDevice, "Click No to save changes", noBtn );
			clickButton(driver, strTestCaseName, strDevice, "Back Arrow", backButton);
			clickButton(driver, strTestCaseName, strDevice, "Click Update Order", updateOrder );
			// Verify Review Order Page is displayed
			// verifyReviewOrderPageIsDisplayed(strTestCaseName, strDevice);
			
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "Submitted order recovery popup discard changes unsuccessful",
					"Failed to Click ===> Add to Order");
			e.printStackTrace();
			
		}	
			
		
	}
	
	public void splitOrderPopUpMsg(String strTestCaseName, String strDevice) throws InterruptedException, IOException {
		try {
			
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Split Order", splitOrderHeader);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Order Split Message", orderSplitMsg);
			compareValues(driver, strTestCaseName, strDevice, "Order Split Message", orderSplitMsgText, driver.findElement(orderSplitMsg).getText());
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "OK Button", splitOrderOkBtn);
			clickButton(driver, strTestCaseName, strDevice, "OK Button", splitOrderOkBtn);
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END-Split Order", "Split Order");
			e.printStackTrace();
		}
	}
	
	public void selectShoppingListWithSwipe(String strTestCaseName, String strDevice, String ShoppingListName)
			throws InterruptedException, IOException {
		try {
			By ShoppingList1 = By.xpath("//*[@text='" + ShoppingListName + "']");
			//swipeAndVerifyElementIsDisplayed1(driver, strTestCaseName, strDevice, "Shopping list", ShoppingList1, "up",
			//		80, 70);
			clickLink(driver, strTestCaseName, strDevice, "Select the Shopping List from search", ShoppingList1);
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END-Select the Shopping List",
					"Failed to Select the Shopping List");
			e.printStackTrace();
		}
	}
	
	public void verifyOrderDetailsPageIsDisplayed(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {
		try {
		
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Order Detail Screen", LocatorConstants.pageTitle);
			String orderDetailTitle = driver.findElement(LocatorConstants.pageTitle).getText();
			
			compareValues(driver, strTestCaseName, strDevice, "Orders", "Orders", orderDetailTitle);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void verifyDepartmentsPageIsDisplayed(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {
		try {
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Departments Screen", LocatorConstants.pageHeader);
			String departmentsTitle = driver.findElement(LocatorConstants.pageHeader).getText();
			compareValues(driver, strTestCaseName, strDevice, "Departments", "Departments", departmentsTitle);
			appli.verifyPageWithApplitools(driver, strTestCaseName, strDevice, "Applitools -Department Page", "layout");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void verifySpanishOrderPageIsDisplayed(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {
		try {
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Ordenes Screen", LocatorConstants.pageTitle);
			String Órdenespagetitle = driver.findElement(LocatorConstants.pageTitle).getText();
			compareValues(driver, strTestCaseName, strDevice, "Ordenes", "Ordenes", Órdenespagetitle);
			appli.verifyPageWithApplitools(driver, strTestCaseName, strDevice, "Órdenes page title", "layout");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void alternateProductTextnotdisplayed(String strTestCaseName, String strDevice) throws Exception {
		try {
			verifyElementIsNotDisplayed(driver, strTestCaseName, strDevice, "Alternate Products text not displayed", MLM_AlternateProductText);
			} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void verifyOrderExceptionsPageIsDisplayed(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {
		try {
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Order Exceptions Screen", LocatorConstants.pageTitle);
			String orderExceptionsTitle = driver.findElement(LocatorConstants.pageTitle).getText();
			compareValues(driver, strTestCaseName, strDevice, "Order Exceptions", "Order Exceptions", orderExceptionsTitle);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void verifyExceptionsScreen(String strTestCaseName, String strDevice, String errorCode) throws IOException
	{
		try {
			if(errorCode.contains("701") || errorCode.contains("626") || errorCode.contains("601")) {
				  verifyElementIsDisplayed(driver, strTestCaseName, strDevice,"Excpetion Product Name", exceptionProductName);
				  verifyElementIsDisplayed(driver,strTestCaseName, strDevice, "Exception Product Brand",exceptionProductBrand); 
				  verifyElementIsDisplayed(driver, strTestCaseName,strDevice, "Exception Product Quantity", exceptionProductQuantity);
				  verifyElementIsDisplayed(driver, strTestCaseName, strDevice,"Exception Product Price", exceptionProductPrice);
				  verifyElementIsDisplayed(driver, strTestCaseName, strDevice,"Exception Quantity Ordered Box", exceptionQuantityOrderedBox);
				  verifyElementIsDisplayed(driver, strTestCaseName, strDevice,"Exception Select Action", exceptionSelectAction);
				  verifyElementIsDisplayed(driver, strTestCaseName, strDevice,"Exception Show Substitutes", exceptionShowSubstitutes); 
				}
				if(errorCode.contains("701")) { 
				  verifyElementIsDisplayed(driver, strTestCaseName, strDevice,"Exception Quantity Ordered", exceptionQuantityOrdered);
				  verifyElementIsDisplayed(driver, strTestCaseName, strDevice,"Exception Quantity Reserved", exceptionQuantityReserved);
				  verifyElementIsDisplayed(driver, strTestCaseName, strDevice,"Exception In Stock", exceptionInStock); 
				  verifyElementIsDisplayed(driver, strTestCaseName, strDevice,"Exception Quantity Reserved Box", exceptionQuantityReservedBox);
				}
				if(errorCode.contains("610") || errorCode.contains("123"))
				{
					 verifyElementIsDisplayed(driver, strTestCaseName, strDevice,"Exception Product Name", ackExceptionProductName);
					 verifyElementIsDisplayed(driver, strTestCaseName, strDevice,"Exception Product Quantity Box", ackExceptionQuantityBox);
					 verifyElementIsDisplayed(driver, strTestCaseName, strDevice,"Exception Product Pack Size", ackExceptionPackSize);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void verifyExceptionMessage(String strTestCaseName, String strDevice, String errorCode, String exception) throws IOException 
	{
		try {
			if(errorCode.contains("744"))
			{
				verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Order Exception", orderException);
				String actualExceptionMessage744 = driver.findElement(orderException).getText();
				compareValues(driver, strTestCaseName, strDevice, "Order Exceptions", exception, actualExceptionMessage744);
			}
			if(errorCode.contains("610"))
			{
				verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Order Exception", ackExceptionError);
				String actualExceptionMessage610= driver.findElement(ackExceptionError).getText();
				compareValues(driver, strTestCaseName, strDevice, "Order Exceptions", exception, actualExceptionMessage610);
			}
			if(errorCode.contains("626"))
			{
				verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Order Exception", orderException);
				String actualExceptionMessage626= driver.findElement(orderException).getText();
				compareValuesContains(driver, strTestCaseName, strDevice, "Order Exceptions", exception, actualExceptionMessage626);
			}
			if(errorCode.contains("601"))
			{
				verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Order Exception", orderException);
				String actualExceptionMessage626= driver.findElement(orderException).getText();
				compareValuesContains(driver, strTestCaseName, strDevice, "Order Exceptions", exception, actualExceptionMessage626);
			}
			if(errorCode.contains("123"))
			{
				verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Order Exception", ackExceptionError);
				String actualExceptionMessage123= driver.findElement(orderException).getText();
				compareValuesContains(driver, strTestCaseName, strDevice, "Order Exceptions", exception, actualExceptionMessage123);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectAcknowledge(String strTestCaseName, String strDevice) throws InterruptedException, IOException {
		try {
			clickButton(driver, strTestCaseName, strDevice, "Acknowledge Order Exception", ackExceptionAcknowledgeBtn);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Exception Acknowledged", ackExceptionAcknowledgeSuccessMsg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectFirstOrder(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {
		try {
			clickLink(driver, strTestCaseName, strDevice, "Select the Not Submitted ORder", firstOrder);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectSubmittedOrder(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {
		try {
			clickLink(driver, strTestCaseName, strDevice, "Select the  Submitted ORder", submittedOrder);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void noRecoveryPopup(String strTestCaseName, String strDevice)
			throws Exception {
		try {
			reviewOrder.verifyReviewOrderPageIsDisplayed(strTestCaseName, strDevice);
			String deliveryDateDetails = driver.findElement(deliveryDate).getText();
			String[] dateDetails = deliveryDateDetails.split("/");
			int date = Integer.parseInt(dateDetails[1]);
			clickButton(driver, strTestCaseName, strDevice, "Click on date", deliveryDate);
			clickButton(driver, strTestCaseName, strDevice, "Select date",
					By.xpath("//XCUIElementTypeStaticText[@value='" + date + "']"));
			clickButton(driver, strTestCaseName, strDevice, "Click done", done);
			FlyinMenu.clickFlyinMenuOrBackButton(strTestCaseName, strDevice);
			selectFirstOrder(strTestCaseName, strDevice);
			clickButton(driver, strTestCaseName, strDevice, "Click on the Order", orderDetail);
			Search.enterQuantity(strTestCaseName, strDevice);
			FlyinMenu.clickFlyinMenuOrBackButton(strTestCaseName, strDevice);
			FlyinMenu.clickFlyinMenuOrBackButton(strTestCaseName, strDevice);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void verifyConfirmNavigationPopUp(String strTestCaseName, String strDevice) throws Exception {
		try {
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Confirm Navigation Pop-up",
					confirmNavigationPopup);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Confirm Navigation", confirmNavigation);
			String actualMessage = driver.findElement(warningMessage).getText();
			compareValues(driver, strTestCaseName, strDevice, "Confirmation PopUp Message", expectedMessage,
					actualMessage);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Continue", continueOrYesOrViewBtn);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Cancel", cancelOrNoBtn);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	public void clickContinueOrYesBtn(String strTestCaseName, String strDevice) throws Exception {
		try {
			clickButton(driver, strTestCaseName, strDevice, "Continue", continueOrYesOrViewBtn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// This method is to verify the Order Recovery Pop Up
	public void verifyOrderRecoveryPopUp(String strTestCaseName, String strDevice) throws Exception {
		try {
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Warning Pop Up", warningPopUp);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Warning title", warningTitle);
			String actualWarningMessage = driver.findElement(warningMessage).getText();
			compareValues(driver, strTestCaseName, strDevice, "Warning Message", expectedWarningMessage,
					actualWarningMessage);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Yes button", continueOrYesOrViewBtn);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "No button", cancelOrNoBtn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void verifySearchInvoicesIsDisplayed(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {
		try {
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Invoices Screen", LocatorConstants.pageTitle);
			String invoicesPageTitle = driver.findElement(LocatorConstants.pageTitle).getText();
			compareValues(driver, strTestCaseName, strDevice, "Invoices", "Search Invoices", invoicesPageTitle);
			appli.verifyPageWithApplitools(driver, strTestCaseName, strDevice, "Invoices", "layout");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void verifySearchInvoicesPage(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {
		try {
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "My Account", myAccountBanner);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "From Date", btn_FromDate);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "To Date", btn_ToDate);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "All Radio Button", Chk_All);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Credit Memo Button", Chk_CreditMemo);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Debit Memo Button", Chk_DebitMemo);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Invoice", Chk_Invoice);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Invoice(FWC)", Chk_InvoiceFWCl);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Original Invoice", Chk_OriginalInvoicel);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Document Number", tbx_tbxDocNum);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Document Number Label", lbl_DocumentNumber);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Search", btn_SearchInvoices);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectViewOrder(String strTestCaseName, String strDevice) throws InterruptedException, IOException {
		try {
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Unsaved Order", confirmNavigationPopup );
			clickButton(driver, strTestCaseName, strDevice, "Select View Order", continueOrYesOrViewBtn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void verifyWillCallDetailsPageForTM(String strTestCaseName, String strDevice) throws IOException {
		try {
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Will Call Details Screen", LocatorConstants.pageTitle);
		String willCallDetailsTitle = driver.findElement(LocatorConstants.pageTitle).getText();
		compareValues(driver, strTestCaseName, strDevice, "Will Call Details", "Will Call Details", willCallDetailsTitle);
		appli.verifyPageWithApplitools(driver, strTestCaseName, strDevice, "Will Call Details", "layout");
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Original Delivery Date Label", originalDeliveryDatelbl);
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Pickup Date Label", pickupDatelbl);
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Pickup Time Label", pickupTimelbl);
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Will Call Type Label", willCallTypelbl);
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Person picking up label", personPickingUplbl);
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Customer PO Label", customerPOlbl);
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Special Instruction Label", specialInstructionslbl);
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Original Delivery Date Value", originalDeliveryDate);
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Pickup Date Value", pickupDate);
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Pickup Hrs", pickupHrs);
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Pickup Min", pickupMins);
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Pick Up AM/PM", pickupAmPm);
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Will Call Type", willCallType);
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Person Picking Up", personPickingUp);
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Customer PO", customerPO);
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Special Instructions", specialInstructions);
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Convert Order Label", convertOrderbtn);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void clickConvertbtn(String strTestCaseName, String strDevice)throws IOException {
		try {
		clickLink(driver, strTestCaseName, strDevice, "Convert Order Label", convertOrderbtn);
		}catch (Exception e) {
			e.printStackTrace();
		}}
	
	public void enterPickingPerson(String strTestCaseName, String strDevice, String PickingUp) throws IOException {
		try {
			setValue(driver, strTestCaseName, strDevice, "Enter Pick Up Person name(Mandatory)", personPickingUp,PickingUp);
			clickLink(driver, strTestCaseName, strDevice, "Top Done Button", LocatorConstants.topdone);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectTime(String strTestCaseName, String strDevice) throws IOException {
		try {
			clickLink(driver, strTestCaseName, strDevice, "Pickup Hours", pickupHrs);
			clickLink(driver, strTestCaseName, strDevice, "Hours", hours);
			clickLink(driver, strTestCaseName, strDevice, "Pickup Mins", pickupMins);
			clickLink(driver, strTestCaseName, strDevice, "Minutes", minutes);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickConvert(String strTestCaseName, String strDevice) throws IOException {
		try {
			clickButton(driver, strTestCaseName, strDevice, "Clicked Convert in Will Call Details Page", convertOrderLbl);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void convertOrderConfirmation(String strTestCaseName, String strDevice) throws IOException {
		try {
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Convert Order Confirmation Pop Up Screen",continueOrYesOrViewBtn);
			clickButton(driver, strTestCaseName, strDevice, "Yes on Confirmation Pop Up", continueOrYesOrViewBtn);
			
			String logReport = strTestCaseName + Constants.DELIMITER + strDevice + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER + "CONVERTED TO WILL CALL ORDER" + Constants.DELIMITER
					+ "NO DATA" + Constants.DELIMITER + Constants.stepPass;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void viewOrEditWillCall(String strTestCaseName, String strDevice) throws IOException {
		try {
			clickButton(driver, strTestCaseName, strDevice, "Clicked View/Edit Will Call from Secondary Navigation ",
					viewEditLbl);

			String logReport = strTestCaseName + Constants.DELIMITER + strDevice + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER + "VIEW/EDIT WILL CALL CLICKED" + Constants.DELIMITER
					+ "NO DATA" + Constants.DELIMITER + Constants.stepPass;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateWillCallOrder(String strTestCaseName, String strDevice, String PickingUp) throws IOException {
		try {
			setValue(driver, strTestCaseName, strDevice, "Update Pick Up Person name(Mandatory)", personPickingUp,
					PickingUp);
			driver.getKeyboard().sendKeys(Keys.RETURN);
			clickButton(driver, strTestCaseName, strDevice, "Clicked Update Order", convertOrderLbl);
			String logReport = strTestCaseName + Constants.DELIMITER + strDevice + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER + "UPDATE ORDER" + Constants.DELIMITER + "NO DATA"
					+ Constants.DELIMITER + Constants.stepPass;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateWillCallOrderConfirmation(String strTestCaseName, String strDevice) throws IOException {
		try {
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Convert Order", convertOrder);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Convert Order Message", convertOrderMessage);
			clickLink(driver, strTestCaseName, strDevice, "Yes", continueOrYesOrViewBtn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void viewWillCall(String strTestCaseName, String strDevice) throws IOException {
		clickButton(driver, strTestCaseName, strDevice, "Clicked View Will Call from Secondary Navigation ",
				viewWillCallLbl);
		String logReport = strTestCaseName + Constants.DELIMITER + strDevice + Constants.DELIMITER
				+ getCurrentDateAndTime() + Constants.DELIMITER + "VIEW WILL CALL CLICKED" + Constants.DELIMITER
				+ "NO DATA" + Constants.DELIMITER + Constants.stepPass;
		appendReportFile(driver, logReport);
		extentReport(driver, logReport);
	}

	public void verifyWillCallDetailsPageForCM(String strTestCaseName, String strDevice) throws IOException {
		try {
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Will Call Details Screen",LocatorConstants.pageTitle);
			String willCallDetailsTitle = driver.findElement(LocatorConstants.pageTitle).getText();
			compareValues(driver, strTestCaseName, strDevice, "Will Call Details", "Will Call Details",willCallDetailsTitle);
			appli.verifyPageWithApplitools(driver, strTestCaseName, strDevice, "Will Call Details-CM", "layout");
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Date Created Label", dateCreatedLbl);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Pickup Date Label", pickupDateCMLbl);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Pickup Time Label", pickupTimeCMLbl);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Will Call Type Label", willCallTypeCMLbl);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Person Picking Up Label", personPickingUpCMLbl);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Customer PO Label", customerPOLbl);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Special Instructions Label", specialInstructionsCMLbl);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Date Created Value", dateCreatedValue);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Pickup Date Value", pickupDateCMValue);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Pickup Time Value", pickupTimeCMValue);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Will Call Type Value", willCallTypeCMValue);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Person Picking Up Value", personPickingUpCMValue);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Customer PO Value", customerPOValue);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Special Instructions Value", specialInstructionsCMValue);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickFinished(String strTestCaseName, String strDevice) throws InterruptedException, IOException {
		try {
			clickButton(driver, strTestCaseName, strDevice, "Finished Button", btnFinished);
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END- Failed to click finished button",
					"Failed to click finished button");
			e.printStackTrace();
		}
	}
	
	public void showSubstitute(String strTestCaseName, String strDevice, String SubstituteProduct)
			throws InterruptedException, IOException {
		try {

			clickButton(driver, strTestCaseName, strDevice, "Show Substitute product", btn_ShowSubstitute);
			driver.swipe(375, 165, 275, 165, 100);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void enterQuantityforSub(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {
		try {
			clickButton(driver, strTestCaseName, strDevice, "Enter Quantity for subs", btn_Quantity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void selectSubstitute(String strTestCaseName, String strDevice, String errorCode) throws InterruptedException, IOException {
		try {
			clickButton(driver, strTestCaseName, strDevice, "Show Substitute product", exceptionShowSubstitutes);
			swipeAndVerifyElementIsDisplayed1(driver, strTestCaseName, strDevice, "Search For More", exceptionSearchForMore, "up", 30, 30);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Exception Substitute With", exceptionSubstituteWith);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Exception Substitute Product Name", exceptionSubstituteProductName);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Exception Substitute Product Brand", exceptionSubstituteProductBrand);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Exception Substitute Product Size", exceptionSubstituteProductSize);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Exception Substitute Product Price", exceptionSubstituteProductPrice);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Exception Substitute Product Quantity", exceptionSubstituteProductQuantity);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Exception Substitute Select Action", exceptionSubstituteSelectAction);
			clickButton(driver, strTestCaseName, strDevice, "Substitute product quantity", exceptionSubstituteProductQuantity);
			clickButton(driver, strTestCaseName, strDevice, "Select Action", exceptionSubstituteSelectAction);
			verifySelectActions(strTestCaseName, strDevice, errorCode);
			if(errorCode.contains("744"))
			{
				clickButton(driver, strTestCaseName, strDevice, "Order Substitute Product(s)", LocatorConstants.secondElementInActionSheet);
			}
			if(errorCode.contains("626"))
			{
				clickButton(driver, strTestCaseName, strDevice, "Order Substitute Product(s)", LocatorConstants.firstElementInActionSheet);
			}
			} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void verifySelectActions(String strTestCaseName, String strDevice, String errorCode)
	{
		if(errorCode.contains("744"))
		{
			String orderOriginalProduct = driver.findElement(LocatorConstants.firstElementInActionSheet).getText();
			compareValues(driver, strTestCaseName, strDevice, "Order Original Product", "Order Original Product", orderOriginalProduct);
			String orderSubstitueProducts = driver.findElement(LocatorConstants.secondElementInActionSheet).getText();
			compareValues(driver, strTestCaseName, strDevice, "Order Original Product", "Order Substitute Product(s)", orderSubstitueProducts);
			String orderSubIfOriginalNotAvailable = driver.findElement(LocatorConstants.thirdElementInActionSheet).getText();
			compareValues(driver, strTestCaseName, strDevice, "Order Original Product", "Order Sub If Original Not Available", orderSubIfOriginalNotAvailable);
			String cancelProduct = driver.findElement(LocatorConstants.fourthElementInActionSheet).getText();
			compareValues(driver, strTestCaseName, strDevice, "Order Original Product", "Cancel Product", cancelProduct);
		}

		if(errorCode.contains("626"))
		{
			String orderSubstitueProducts = driver.findElement(LocatorConstants.firstElementInActionSheet).getText();
			compareValues(driver, strTestCaseName, strDevice, "Order Original Product", "Order Substitute Product(s)", orderSubstitueProducts);
			String cancelProduct = driver.findElement(LocatorConstants.secondElementInActionSheet).getText();
			compareValues(driver, strTestCaseName, strDevice, "Order Original Product", "Cancel Product", cancelProduct);
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	

	
	

	

	public void validateNewOrder(String strTestCaseName, String strDevice) throws InterruptedException, IOException {
		try {
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "New Order Not Submitted", OfflineOrder);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void validateUpdateOrder(String strTestCaseName, String strDevice) throws InterruptedException, IOException {
		try {
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Updated Order Not Submitted",
					OfflineOrder_Update);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void validateNotSubmittedOrder(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {
		try {
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Not Submitted Order", Online_NotSubmitted);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showSubstituteorSearchforSub(String strTestCaseName, String strDevice, String ProductNumber)
			throws InterruptedException, IOException {
		try {

			String getSubstituteText = driver.findElement(btn_SubforSearch).getText();

			if (getSubstituteText.equalsIgnoreCase(searchforSub)) {
				clickButton(driver, strTestCaseName, strDevice, "Show Substitute product", exceptionShowSubstitutes);
				FlyinMenu.clickFlyinMenuOrBackButton(strTestCaseName, strDevice);
			} else if (getSubstituteText.equalsIgnoreCase(showSubstitue)) {
				clickButton(driver, strTestCaseName, strDevice, "Show Substitute product", exceptionShowSubstitutes);
				driver.swipe(375, 165, 275, 165, 100);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * public void selectSubstitute(String strTestCaseName, String strDevice, String
	 * SubstituteProduct) throws InterruptedException, IOException { try {
	 * 
	 * setValue(driver, strTestCaseName, strDevice,
	 * "Select the Substitute product from search", tbx_SearchOrder,
	 * SubstituteProduct); driver.getKeyboard().sendKeys(Keys.RETURN);
	 * clickButton(driver, strTestCaseName, strDevice, "Select Substitute",
	 * btn_Substitute); driver.swipe(375, 165, 275, 165, 100); } catch (Exception e)
	 * { e.printStackTrace(); } }
	 */
	public void validateDirectIconText(String strTestCaseName, String strDevice) throws Exception {
		try {
			
			  String getItByText = driver.findElement(getItById).getText(); Boolean
			  getItByValue = getItByText.contains(getItBy); Boolean noReturnsValue =
			  getItByText.contains(noReturns); if (getItByValue && noReturnsValue) {
			  verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "getItBy text",
			  getItById); }
			 
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "getItBy text", getItById);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void validateDirectIconimage(String strTestCaseName, String strDevice) throws Exception {
		try {
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Direct Icon Validation", Directicon);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showSubstituteinExpScreen(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {
		try {

			clickButton(driver, strTestCaseName, strDevice, "Show Substitute product", btn_ShowSubstituteinexp);
			driver.swipe(375, 165, 275, 165, 100);

			// verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Product Rich
			// Name", RichName);
			// String RichName1 = getObjectText(driver, strTestCaseName, strDevice,"Product
			// Rich Name", RichName);
			// reportInfo(driver, strTestCaseName, strDevice, "Product Rich Name",
			// RichName1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterQuantityForSubstituteProduct(String strTestCaseName, String strDevice, String Quantity, int qtyBox)
			throws InterruptedException, IOException {

		try {
			List<MobileElement> objElements = driver.findElements(substituteProductQuantity);
			MobileElement element;
			Iterator<MobileElement> it = objElements.iterator();

			while (it.hasNext()) {
				element = it.next();
				if (qtyBox == 1) {
					element.click();
					element.sendKeys(Quantity);
					break;
				}
				if (qtyBox == 2) {
					element = it.next();
					element.sendKeys(Quantity);
					String logReport = strTestCaseName + Constants.DELIMITER + deviceDetails + Constants.DELIMITER
							+ getCurrentDateAndTime() + Constants.DELIMITER + "Click Link--->"
							+ "Select substitute product" + Constants.DELIMITER + Constants.NO_DATA
							+ Constants.DELIMITER + Constants.STEP_PASS;
					appendReportFile(driver, logReport);
					extentReport(driver, logReport);

					reportPass(driver, strTestCaseName, strDevice, "Entered Qty in second box", Quantity);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectAction(String strTestCaseName, String strDevice, String SubstituteProduct)throws InterruptedException, IOException {
		try {

			driver.swipe(375, 165, 275, 165, 100);
			//clickButton(driver, strTestCaseName, strDevice, "Select Action", btn_SelectAction);
			clickLink(driver, strTestCaseName, strDevice, "Order Substitute Product(s)", lnk_OrderSubstitue);
			driver.swipe(375, 165, 275, 165, 100);

			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Substitute Product(s) Added",
					SubstitueOrderStatus);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void selectchangeAction(String strTestCaseName, String strDevice, String SubstituteProduct)throws InterruptedException, IOException {
		try {

			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Select Action",selectaction );
			clickButton(driver, strTestCaseName, strDevice, "select Action", selectaction );
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Original Product Ordered",order_originalproduct );
			clickButton(driver, strTestCaseName, strDevice, "Original Product Ordered", order_originalproduct);
			
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Org product ordered",original_product_ordered);
			
			clickButton(driver, strTestCaseName, strDevice, "Finish Button", btn_Finished);
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}public void selectchangeaction(String strTestCaseName, String strDevice, String SubstituteProduct)
			throws InterruptedException, IOException {
		try {

			driver.swipe(375, 165, 275, 165, 100);
			
			clickLink(driver, strTestCaseName, strDevice, "Select Action", lnk_OrderSubstitue);
			driver.swipe(375, 165, 275, 165, 100);

			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Substitute Product(s) Added",
					SubstitueOrderStatus);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void showsubstitute(String strTestCaseName, String strDevice) throws InterruptedException, IOException {
		try {
			clickButton(driver, strTestCaseName, strDevice, "click show substitute", show_subsbtn);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void searchforSubstitute(String strTestCaseName, String strDevice) throws InterruptedException, IOException {
		try {
			clickButton(driver, strTestCaseName, strDevice, "Search more product", btn_Searchforsub);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void searchMoreProduct(String strTestCaseName, String strDevice) throws InterruptedException, IOException {
		try {

			clickButton(driver, strTestCaseName, strDevice, "Search more product", btn_ShowSearchMore);
			driver.swipe(375, 165, 275, 165, 100);

			// verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Product Rich
			// Name", RichName);
			// String RichName1 = getObjectText(driver, strTestCaseName, strDevice,"Product
			// Rich Name", RichName);
			// reportInfo(driver, strTestCaseName, strDevice, "Product Rich Name",
			// RichName1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void selectSubstitute(String strTestCaseName, String strDevice) throws InterruptedException, IOException {
		try {

			clickButton(driver, strTestCaseName, strDevice, "Select Substitute from Search Page", btn_Selectsub);
			driver.swipe(375, 165, 275, 165, 100);

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void offlineContactUSCMValidation(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {
		try {

			verifyPageHeader(driver, strTestCaseName, strDevice, "Contact Us Title Validation", lnk_Contactustitle);
			/// Compare the Contact US description value
			String contactustitle = getObjectText(driver, strTestCaseName, strDevice, "Contact US Title",
					lnk_Contactustitle);
			compareValues(driver, strTestCaseName, strDevice, "Contact Us Page Title Text Validation", "Contact Us",
					contactustitle);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void selectDeliveryDate(String strTestCaseName, String strDevice) throws Exception {
		try {
			Thread.sleep(2000);
			String deliveryDateDetails = driver.findElement(deliveryDate).getText();
			String[] dateDetails = deliveryDateDetails.split("/");
			int date = Integer.parseInt(dateDetails[1]);
			clickButton(driver, strTestCaseName, strDevice, "Click on date", deliveryDate);
			clickButton(driver, strTestCaseName, strDevice, "Select date",
					By.xpath("//XCUIElementTypeStaticText[@value='" + date + "']"));
			clickButton(driver, strTestCaseName, strDevice, "Click done", doneButton);
			// clickButton(driver, strTestCaseName, strDevice, "Back Arrow", backButton);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void expOrderConfirmation(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {
		try {
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Submitted with Exceptions", lbl_OrdStatus);
			clickButton(driver, strTestCaseName, strDevice, "Order Confirmaton OK Button", btnpop_greetings);

			String logReport = strTestCaseName + Constants.DELIMITER + strDevice + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER + "Search Page title is displayed"
					+ Constants.DELIMITER + Constants.NO_DATA + Constants.DELIMITER + Constants.STEP_PASS;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice,
					"ERROR-END- Order Confirmaton OK Button in Review Order Page",
					"Failed to  Order Confirmaton OK Button in Review Order Page");
			e.printStackTrace();
		}
	}
	public void selectSubForSearch(String strTestCaseName, String strDevice) throws InterruptedException, IOException {
		try {
			clickLink(driver, strTestCaseName, strDevice, "Select Sub For Search", btn_SubforSearch);

		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END-Select the Sub For Search ",
					"Failed to Select the Sub For Search");
			e.printStackTrace();
		}
	}
	public void selectConfirmQuantity(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {
		try {
			clickButton(driver, strTestCaseName, strDevice, "ConfirmQuantity Button", btn_ConfirmQuantity);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Exceptions- Quantity Confirmation ",
					lbl_QuantityConfirmed);
		} catch (Exception e) {
			e.printStackTrace();
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END- Order Submit Button in Review Order Page",
					"Failed to Order Submit Button in Review Order Page");
		}
	}
	public void showSubstitute(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {
		try {

			clickButton(driver, strTestCaseName, strDevice, "Show Substitute product", btn_ShowSubstitute);
			driver.swipe(375, 165, 275, 165, 100);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void pagenavigationoptions(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {
		try {

			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "NextPage", nextpage);
			clickButton(driver, strTestCaseName, strDevice, "clicked on next page", nextpage);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "previous page", previouspage);
			clickButton(driver, strTestCaseName, strDevice, "clicked on previouspage page", previouspage);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void selectOpenMyAccount(String strTestCaseName, String strDevice) throws InterruptedException, IOException {
		try {

			clickLink(driver, strTestCaseName, strDevice, "Open My Account App", OpenMyAccount);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectSubmittedOrder(String strTestCaseName, String strDevice, String POnumber)
			throws InterruptedException, IOException {
		try {
			// reportInfo(driver, strTestCaseName, strDevice, "START- Not Submitted Order",
			// "Select Not Submitted Order");
			// driver.findElement(NotSubmittedOrder);
			// clickLink(driver,strTestCaseName, strDevice, "Select the Not Submitted
			// ORder",NotSubmittedOrdr);

			By SubmittedOrdr = By.xpath("//XCUIElementTypeStaticText[@value='" + POnumber + "']");

			clickLink(driver, strTestCaseName, strDevice, "Select the Submitted ORder", SubmittedOrdr);

			// reportInfo(driver, strTestCaseName, strDevice, "END-Back Button Click",
			// "Clicked Back Button");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyOrderPlacedWithPONumber(String strTestCaseName, String strDevice, String POnumber) {
		try {

			// By OrderPOnumber = By.xpath("//XCUIElementTypeStaticText[@value='" + POnumber
			// + "']");

			String poNumberValue = driver.findElement(By.xpath("//XCUIElementTypeStaticText[@value='" + POnumber + "']")).getText();
			compareValues(driver, strTestCaseName, strDevice, "Order Placed with PO Number", POnumber, poNumberValue);

			/*
			 * compareValues(driver, strTestCaseName, strDevice,
			 * "Order Placed with PO Number", PONumber, OrderPOnumber);
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void startNewInventory(String strTestCaseName, String strDevice) throws InterruptedException, IOException {
		try {

			clickButton(driver, strTestCaseName, strDevice, "Start New Inventory", startnewinventory);
			verifyPageHeader(driver, strTestCaseName, strDevice, "New Inventory ", newinventoryheader);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Select Shopping List", selectshoppinglist);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Select Inventory Date", selectinventorydate);

			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Begin Inventory", begininventory);
			clickLink(driver, strTestCaseName, strDevice, "Select Shopping List ", shoppingList1);
			clickLink(driver, strTestCaseName, strDevice, "select from list of shopping lists ", shoppingList1);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "shopping list popup", shoppinglistpopup);
			clickLink(driver, strTestCaseName, strDevice, "one of shopping list ", oneofshoppinglist);
			clickButton(driver, strTestCaseName, strDevice, "Begin Inventory", begininventory);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void fillinventorydetails(String strTestCaseName, String strDevice, String ProductNumber)
			throws InterruptedException, IOException {
		try {

			verifyPageHeader(driver, strTestCaseName, strDevice, "02/14/2018", LocatorConstants.pageTitle);

			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Filter List", searchbox);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "secondary navButton",
					LocatorConstants.secondaryNavigationButton);
			setValue(driver, strTestCaseName, strDevice, "Select the Product from search", ProductSearch,
					ProductNumber);
			driver.getKeyboard().sendKeys(Keys.RETURN);

			clickLink(driver, strTestCaseName, strDevice, "secondarynavigationbutton ", LocatorConstants.secondaryNavigationButton);
			clickLink(driver, strTestCaseName, strDevice, "Create PAR Order", createparorder);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ChooseParDate(String strTestCaseName, String strDevice) throws InterruptedException, IOException {
		try {

			verifyPageHeader(driver, strTestCaseName, strDevice, "Choose a PAR Date", pardatelable);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Monday", monday);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Cancel Button", cancelbutton);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Done Button", donebutton);
			clickButton(driver, strTestCaseName, strDevice, "SelectingMonday", selectmonday);
			clickButton(driver, strTestCaseName, strDevice, "ClickingDoneButton", donebutton);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ChooseDate(String strTestCaseName, String strDevice, String PONumber)
			throws InterruptedException, IOException {
		try {
			String deliveryDateDetails = driver.findElement(deliveryDate).getText();
			String[] dateDetails = deliveryDateDetails.split("/");
			int date = Integer.parseInt(dateDetails[1]);
			clickButton(driver, strTestCaseName, deviceDetails, "Click on date", deliveryDate);
			clickButton(driver, strTestCaseName, deviceDetails, "Select date",
					By.xpath("//XCUIElementTypeStaticText[@value='" + date + "']"));
			clickButton(driver, strTestCaseName, deviceDetails, "Click done", doneButton);
			FlyinMenu.clickFlyinMenuOrBackButton(strTestCaseName, strDevice);
			clickButton(driver, strTestCaseName, deviceDetails, "Select the Order with PO number",
					By.xpath("//XCUIElementTypeStaticText[@label='" + PONumber + "']"));

			clickButton(driver, strTestCaseName, deviceDetails, "Click on the Order", orderDetail);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ParOrderMessage(String strTestCaseName, String strDevice) throws InterruptedException, IOException {
		try {

			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "createparorder", LocatorConstants.pageTitle);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "No PAR Order Created", noparmsg);

			clickButton(driver, strTestCaseName, strDevice, "Clicking OK", ok);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void VerifyHelpPageIsDisplayed(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {
		try {
			verifyPageHeader(driver, strTestCaseName, strDevice, "Help Page ", HelpImage);

			// Verify Search page using Applitools eyes
			// appli.verifyPageWithApplitools(driver, strTestCaseName, strDevice, "Search
			// Details", "strict");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyProductDetailPageIsDisplayed(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {
		try {
			verifyPageHeader(driver, strTestCaseName, strDevice, "Product Detail  Page ", ProductDetailTitle);
			// Compare the add event page description value
			String ProductDetailpagetitle = getObjectText(driver, strTestCaseName, strDevice,
					"Product Detail Page title", ProductDetailTitle);
			Thread.sleep(5000);
			compareValues(driver, strTestCaseName, strDevice, "Product Detail Page Title Text Validation",
					"Product Detail", ProductDetailpagetitle);
			// Verify Search page using Applitools eyes
			// appli.verifyPageWithApplitools(driver, strTestCaseName, strDevice, "Search
			// Details", "strict");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyBuscarPageIsDisplayed(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {
		try {
			verifyPageHeader(driver, strTestCaseName, strDevice, "Buscar  Page ", BuscarTitle);
			// Compare the add event page description value
			String Buscarpagetitle = getObjectText(driver, strTestCaseName, strDevice, "Buscar Page title",
					BuscarTitle);
			compareValues(driver, strTestCaseName, strDevice, "Buscar Page Title Text Validation", "Buscar",
					Buscarpagetitle);
			// Verify Search page using Applitools eyes
			// appli.verifyPageWithApplitools(driver, strTestCaseName, strDevice, "Search
			// Details", "strict");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyOrderDetailsScreenBanner(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {
		try {

			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "AdvertisedPromotion Banner Savings text",
					AdvertisedPromotionBanner);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "AdvertisedPromotion Banner Offer Details",
					AdvertisedPromotionBanner);

			// Compare the add event page description value

			// Verify Search page using Applitools eyes
			// appli.verifyPageWithApplitools(driver, strTestCaseName, strDevice, "Search
			// Details", "strict");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void VerifyKillOrderConfirmation(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {
		try {
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "ViewOrder", ViewOrder);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Discard Changes", DiscardChanges);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyKillOrderConfirmationNotDisplayed(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {
		try {
			verifyElementIsNotDisplayed(driver, strTestCaseName, strDevice, "Unsaved Order Title", UnsavedOrderTitle);
			verifyElementIsNotDisplayed(driver, strTestCaseName, strDevice, "ViewOrder", ViewOrder);
			verifyElementIsNotDisplayed(driver, strTestCaseName, strDevice, "Discard Changes", DiscardChanges);
			verifyElementIsNotDisplayed(driver, strTestCaseName, strDevice, "UnSaved Order", UnSavedorder);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyWarningPopUpKillRelaunch(String strTestCaseName, String strDevice) throws Exception {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(killwarningPopUp));
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Warning Pop Up", killwarningPopUp);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Warning title", killwarningTitle);
			String actualWarningMessage = driver.findElement(warningMessage).getText();
			compareValues(driver, strTestCaseName, strDevice, "Warning Message", killexpectedWarningMessage,
					actualWarningMessage);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Customer Details", killCustomerDetails);

			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Discard  button", killbtnDiscard);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Add to Order button", killbtnAddToOrder);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void clickAddToOrderOnConfirmationPopUp(String strTestCaseName, String strDevice) throws Exception {
		try {
			clickButton(driver, strTestCaseName, strDevice, "Add To Order", killbtnAddToOrder);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyConfirmatNavigationPopUpNotDisplayed(String strTestCaseName, String strDevice)
			throws IOException {
		verifyElementIsNotDisplayed(driver, strTestCaseName, strDevice, "Confirm Navigation Pop-up",
				confirmNavigationPopup);
		verifyElementIsNotDisplayed(driver, strTestCaseName, strDevice, "Confirm Navigation", confirmNavigation);

		verifyElementIsNotDisplayed(driver, strTestCaseName, strDevice, "Continue", continueOrYesOrViewBtn);
		verifyElementIsNotDisplayed(driver, strTestCaseName, strDevice, "Cancel", cancelOrNoBtn);
	}

	// This method is to continue without saving the changes
	public void clickCancelOnConfirmationPopUp(String strTestCaseName, String strDevice) throws Exception {
		try {
			clickButton(driver, strTestCaseName, strDevice, "Cancel", cancelOrNoBtn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void DeSelectViewOrder(String strTestCaseName, String strDevice) throws InterruptedException, IOException {
		try {
			clickButton(driver, strTestCaseName, strDevice, "Discard", continueOrYesOrViewBtn);
			// Verify Search page using Applitools eyes
			// appli.verifyPageWithApplitools(driver, strTestCaseName, strDevice, "Search
			// Details", "strict");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void VerifyChangePricePageIsDisplayed(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {
		try {
			verifyPageHeader(driver, strTestCaseName, strDevice, "Change Price Page", ChangePriceTitle);
			// Compare the add event page description value
			String changepriceTitle = getObjectText(driver, strTestCaseName, strDevice, "Change Price title",
					ChangePriceTitle);
			compareValues(driver, strTestCaseName, strDevice, "Change Price Page Title Text Validation", "Change Price",
					changepriceTitle);
			// Verify ReviewOrder page using Applitools eyes
			// appli.verifyPageWithApplitools(driver, strTestCaseName, strDevice, "Search
			// Details", "strict");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyPayInvoicesPage(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {
		try {
			verifyPageHeader(driver, strTestCaseName, strDevice, "Pay Invoices Page ", PayInvoicesTitle);

			String PayInvoicesTitletext = getObjectText(driver, strTestCaseName, strDevice, "Pay Invoices title",
					PayInvoicesTitle);
			compareValues(driver, strTestCaseName, strDevice, "Pay Invoices Page Title Text Validation", "Pay Invoices",
					PayInvoicesTitletext);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void VerifyChangePrice(String strTestCaseName, String strDevice) throws InterruptedException, IOException {
		try {

			driver.swipe(375, 165, 275, 165, 100);
			// verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Change Price
			// Lable", ChangePrice_lbl);

			String ChangePrice = getObjectText(driver, strTestCaseName, strDevice, "Change Price Lable Message",
					ChangePrice_lbl);
			compareValues(driver, strTestCaseName, strDevice, "Change Price Validation", "Change Price", ChangePrice);

			// Verify ReviewOrder page using Applitools eyes
			// appli.verifyPageWithApplitools(driver, strTestCaseName, strDevice, "Search
			// Details", "strict");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ClickChangePriceLabel(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {
		try {

			clickButton(driver, strTestCaseName, strDevice, "Change Price", ChangePrice_lbl);

			// Verify ReviewOrder page using Applitools eyes
			// appli.verifyPageWithApplitools(driver, strTestCaseName, strDevice, "Search
			// Details", "strict");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ValidateChangePricePage(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {
		try {

			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Rich User Details", RichUserDetails);
			String OrderModify = getObjectText(driver, strTestCaseName, strDevice,
					" User Details in Change Price Screen", RichUserDetails);
			// reportInfo(driver, strTestCaseName, strDevice, "Stock Available data",
			// OrderModify);

			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "CS Current Value", lbl_CSCurrentVal);
			String CSCurrentVal = getObjectText(driver, strTestCaseName, strDevice, " Customer Current Value",
					lbl_CSCurrentVal);
			// reportInfo(driver, strTestCaseName, strDevice, "Customer Current Value",
			// CSCurrentVal);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, " CS Com Value ", lbl_CSComVal);
			String CSComVal = getObjectText(driver, strTestCaseName, strDevice, " CS COM Value", lbl_CSComVal);
			// reportInfo(driver, strTestCaseName, strDevice, "CS COM Value", CSComVal);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, " CS Price Value ", lbl_CSPrice);
			String CSPrice = getObjectText(driver, strTestCaseName, strDevice, " CS COM Value", lbl_CSPrice);
			// reportInfo(driver, strTestCaseName, strDevice, "CS COM Value", CSPrice);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Target Value ", lbl_Target);
			String TargetPrice = getObjectText(driver, strTestCaseName, strDevice, " Target Value", lbl_Target);
			// reportInfo(driver, strTestCaseName, strDevice, "Target Value", TargetPrice);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Maximum Value ", lbl_Max);
			String MaxPrice = getObjectText(driver, strTestCaseName, strDevice, " Maximum Value", lbl_Max);
			// reportInfo(driver, strTestCaseName, strDevice, "Maximum Value", MaxPrice);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Cancel Button ", btn_Cancel);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Change Price Button ", btn_ChangePrice);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Flex KeyBoard Button ", flexKeypad);

			// Verify ReviewOrder page using Applitools eyes
			// appli.verifyPageWithApplitools(driver, strTestCaseName, strDevice, "Search
			// Details", "strict");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ValidateChangePriceFucntionality(String strTestCaseName, String strDevice, String price)
			throws InterruptedException, IOException {

		for (int i = 0; i < price.length(); i++) {
			System.out.println("Price    :" + price.charAt(i));
		}

		try {

			// clickButton(driver,strTestCaseName, strDevice,"Select Price ",lbl_CSPrice);
			clickButton(driver, strTestCaseName, strDevice, "Clear Data ", btn_Cross);

			for (int i = 0; i < price.length(); i++) {
				switch (price.charAt(i)) {
				case '0':
					clickButton(driver, strTestCaseName, strDevice, "Clear Data ", btn_Zero);
					break;
				case '1':
					clickButton(driver, strTestCaseName, strDevice, "One ", btn_One);
					break;
				case '2':
					clickButton(driver, strTestCaseName, strDevice, "Two ", btn_Two);
					break;
				case '3':
					clickButton(driver, strTestCaseName, strDevice, "Three ", btn_Three);
					break;
				case '4':
					clickButton(driver, strTestCaseName, strDevice, "Four ", btn_Four);
					break;
				case '5':
					clickButton(driver, strTestCaseName, strDevice, "Five ", btn_Five);
					break;
				case '6':
					clickButton(driver, strTestCaseName, strDevice, "Six ", btn_Six);
					break;
				case '7':
					clickButton(driver, strTestCaseName, strDevice, "Seven", btn_Seven);
					break;
				case '8':
					clickButton(driver, strTestCaseName, strDevice, "Eight", btn_Eight);
					break;
				case '9':
					clickButton(driver, strTestCaseName, strDevice, "Nine", btn_Nine);
					break;
				case '.':
					clickButton(driver, strTestCaseName, strDevice, "Decimal", btn_Decimal);
					break;
				default:
					System.out.println("Invalid grade");
					break;
				}
			}

			clickButton(driver, strTestCaseName, strDevice, "Change Price ", btn_ChangePrice);
			By OrderDetail_Price = By.xpath("//XCUIElementTypeStaticText[@value='$" + price + " CS']");
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Order Details screen Product Price Changed",
					OrderDetail_Price);
			clickButton(driver, strTestCaseName, strDevice, "Order Details --> Review Order ", LocatorConstants.flyinMenuOrBackBtn);
		} catch (Exception e) {
			e.printStackTrace();
			{
			}
		}
	}

	public void SelectQuantity(String strTestCaseName, String strDevice, String quantity)
			throws InterruptedException, IOException {
		driver.tap(1, 161, 300, 10000);
		for (int i = 0; i < quantity.length(); i++) {
			System.out.println("Quantity    :" + quantity.charAt(i));
		}

		try {
			// clickButton(driver,strTestCaseName, strDevice,"Select Price ",lbl_CSPrice);
			clickButton(driver, strTestCaseName, strDevice, "Clear Data ", btn_Cross);

			for (int i = 0; i < quantity.length(); i++) {
				switch (quantity.charAt(i)) {
				case '0':
					clickButton(driver, strTestCaseName, strDevice, "Zero", btn_Zero);
					break;
				case '1':
					clickButton(driver, strTestCaseName, strDevice, "One ", btn_One);
					break;
				case '2':
					clickButton(driver, strTestCaseName, strDevice, "Two ", btn_Two);
					break;
				case '3':
					clickButton(driver, strTestCaseName, strDevice, "Three ", btn_Three);
					break;
				case '4':
					clickButton(driver, strTestCaseName, strDevice, "Four ", btn_Four);
					break;
				case '5':
					clickButton(driver, strTestCaseName, strDevice, "Five ", btn_Five);
					break;
				case '6':
					clickButton(driver, strTestCaseName, strDevice, "Six ", btn_Six);
					break;
				case '7':
					clickButton(driver, strTestCaseName, strDevice, "Seven", btn_Seven);
					break;
				case '8':
					clickButton(driver, strTestCaseName, strDevice, "Eight", btn_Eight);
					break;
				case '9':
					clickButton(driver, strTestCaseName, strDevice, "Nine", btn_Nine);
					break;
				default:
					System.out.println("Invalid grade");
					break;
				}
			}
			// driver.tap(1, 100, 100, 100);
			driver.tap(1, 120, 380, 100);

			// clickButton(driver,strTestCaseName, strDevice,"Change Price
			// ",btn_ChangePrice);
			// By OrderDetail_Price =
			// By.xpath("//XCUIElementTypeStaticText[@value='$"+quantity+" CS']");
			// clickButton(driver,strTestCaseName, strDevice,"Order Details --> Review Order
			// ",reviewOrderBackButton);
		} catch (Exception e) {
			e.printStackTrace();
			{
			}
		}
	}
	public void orderExceptionsPageValidation(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {
		try {
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Order Exception Details",OrderExptionsDetail);
			String OrderExptionDetail1 = getObjectText(driver, strTestCaseName, strDevice, "Order Exception Details",OrderExptionsDetail);
			reportInfo(driver, strTestCaseName, strDevice, "Order Exception Details", OrderExptionDetail1);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void validateReviewOrderPage(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {
		try {
			String OrderStatus = getObjectText(driver, strTestCaseName, strDevice, "Order Status", lbl_OrderStatus);
			String logReport = strTestCaseName + Constants.DELIMITER + strDevice + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER + "Order Status" + "--->" + OrderStatus
					+ Constants.DELIMITER + "NO DATA" + Constants.DELIMITER + Constants.stepInfo;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);

			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Delivery Date", lbl_DeliveryDate);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Order Number", lbl_OrderNumber);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Ordered", lbl_Ordered);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Reserved", lbl_Reserved);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Special Instructions",
					lbl_SpecialInstructions);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "PO Number", lbl_PONumber);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Total", lbl_TotAmnt);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Total Lines", lbl_TotLines);

			// Verify ReviewOrder page using Applitools eyes
			// appli.verifyPageWithApplitools(driver, strTestCaseName, strDevice, "Search
			// Details", "strict");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void spanishSelectNewOrder(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {
		try {
			// reportInfo(driver, strTestCaseName, strDevice, "START-Select the Order",
			// "Select the Order");
			clickButton(driver, strTestCaseName, strDevice, "Select the Order", newOrderBtn);
			// reportInfo(driver, strTestCaseName, strDevice, "END-Select the Customer",
			// "Select the Order");
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END-Select the Customer",
					"Failed to Select the Customer");
			e.printStackTrace();
		}
	}

	public void selectDepartments(String strTestCaseName, String strDevice) throws InterruptedException, IOException {
		try {
			// reportInfo(driver, strTestCaseName, strDevice, "START-Select the Order",
			// "Select the Order");
			clickLink(driver, strTestCaseName, strDevice, "Select Department ", lnk_Department);

			// reportInfo(driver, strTestCaseName, strDevice, "END-Select the Customer",
			// "Select the Order");
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END-Select the Customer",
					"Failed to Select the Customer");
			e.printStackTrace();
		}
	}

	public void wifiOff(String strTestCaseName, String strDevice) throws InterruptedException {
		NetworkConnection mobileDriver = (NetworkConnection) driver;
		if (mobileDriver.getNetworkConnection() != ConnectionType.AIRPLANE_MODE) {
			mobileDriver.setNetworkConnection(ConnectionType.AIRPLANE_MODE);
		}
	}

	public void departmentDownload(String strTestCaseName, String strDevice) throws IOException {
	
		clickButton(driver, strTestCaseName, strDevice, "Department Download",
		departmentDownloadBtn);
	//	driver.tap(1, 384, 142, 100);
	}

	public void downloadDepartmentsOrShoppingList(String strTestCaseName, String strDevice, String ShoppingList)
			throws InterruptedException, IOException {
		try {
			By lnk_shoppinglist = By.xpath("//XCUIElementTypeStaticText[@value='" + ShoppingList + "']");
			clickLink(driver, strTestCaseName, strDevice, "Select Shoppingh list ", lnk_shoppinglist);
			List<MobileElement> element1 = null;
			int objcount1 = 0;
			element1 = driver.findElements(refreshBtn);
			objcount1 = element1.size();
			if (objcount1 > 0) {
				//clickButton(driver, strTestCaseName, strDevice, "cancel", cancel_lbl);
			} else {
				clickButton(driver, strTestCaseName, strDevice, "Select save", btn_Save);
			}
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END-Select the Customer",
					"Failed to Select the Customer");
			e.printStackTrace();
		}
	}

	public void downloadCustomerSingleDepartment(String strTestCaseName, String strDevice, String ShoppingList)
			throws InterruptedException, IOException {
		try {
			// reportInfo(driver, strTestCaseName, strDevice, "START-Download the Shopping
			// List - For Offline Scenario", "Down the Order");
			// Orders.flyMenu(strTestCaseName, strDevice);
			driver.tap(1, 360, 135, 100);
			By lnk_shoppinglist = By.xpath("//XCUIElementTypeStaticText[@value='" + ShoppingList + "']");
			clickLink(driver, strTestCaseName, strDevice, "Select Shoppingh list ", lnk_shoppinglist);
			clickButton(driver, strTestCaseName, strDevice, "Select Save", btn_Save);
			// reportInfo(driver, strTestCaseName, strDevice, "END-Select the Customer",
			// "Select the Order");
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END-Select the Customer",
					"Failed to Select the Customer");
			e.printStackTrace();
		}
	}

	public void downloadCustomerSingleDepartmentfromflymenu(String strTestCaseName, String strDevice,
			String ShoppingList) throws InterruptedException, IOException {
		try {

			FlyinMenu.clickFlyinMenuOrBackButton(strTestCaseName, strDevice);
			clickLink(driver, strTestCaseName, strDevice, "Down load Shopping List ", downloadshoppingList);
			By lnk_shoppinglist = By.xpath("//XCUIElementTypeStaticText[@value='" + ShoppingList + "']");
			clickLink(driver, strTestCaseName, strDevice, "Select Shoppingh list ", lnk_shoppinglist);
			clickButton(driver, strTestCaseName, strDevice, "Select Save", btn_Save);
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END-Select the Customer",
					"Failed to Select the Customer");
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public void downloadCustomer(String strTestCaseName, String strDevice, String ShoppingList)
			throws InterruptedException, IOException {
		try {
			// reportInfo(driver, strTestCaseName, strDevice, "START-Download the Shopping
			// List - For Offline Scenario", "Down the Order");

			driver.tap(1, 360, 135, 100);
			clickcoordinatesdone(driver, strTestCaseName, strDevice);
			By lnk_shoppinglist = By.xpath("//XCUIElementTypeStaticText[@value='" + ShoppingList + "']");
			clickLink(driver, strTestCaseName, strDevice, "Select Shoppingh list ", lnk_shoppinglist);
			clickButton(driver, strTestCaseName, strDevice, "Select Save", btn_Save);
			// reportInfo(driver, strTestCaseName, strDevice, "END-Select the Customer",
			// "Select the Order");
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END-Select the Customer",
					"Failed to Select the Customer");
			e.printStackTrace();
		}
	}

	public void offlinemode(String strTestCaseName, String strDevice) throws InterruptedException, IOException {
		try {
			// reportInfo(driver, strTestCaseName, strDevice, "START-Select the Order",
			// "Select the Order");
			driver.swipe(188, 667, 188, 100, 100);
			clickLink(driver, strTestCaseName, strDevice, "OFF/On Wi Fi ", swt_wfi);
			driver.tap(1, 188, 150, 50);
			// reportInfo(driver, strTestCaseName, strDevice, "END-Select the Customer",
			// "Select the Order");
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END-Select the Customer",
					"Failed to Select the Customer");
			e.printStackTrace();
		}
	}

//	public void selectShoppingList(String strTestCaseName, String strDevice) throws InterruptedException, IOException {
//		try {
//			// reportInfo(driver, strTestCaseName, strDevice, "START-Select the Shopping
//			// List ", "Select the Shopping List");
//
//			swipeAndVerifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Swipe Test Shopping List List ",
//					selectShoppingList, "up");
//			By btn_shoppingListItem = By.xpath("//XCUIElementTypeStaticText[@value='" + ShoopingList + "']");
//			clickButton(driver, strTestCaseName, strDevice, "Shopping List Item", btn_shoppingListItem);
//			clickButton(driver, strTestCaseName, strDevice, "Selected Shopping List", selectShoppingList);
//			// reportInfo(driver, strTestCaseName, strDevice, "END-Select the View All
//			// Shopping List", "Select the Shopping List");
//		} catch (Exception e) {
//			reportFail(driver, strTestCaseName, strDevice, "ERROR-END-Select the Shopping List",
//					"Failed to Select the Shopping List");
//			e.printStackTrace();
//		}
//	}
	
	

	public void selectShoppingList1(String strTestCaseName, String strDevice, String ShoppingListName)
			throws InterruptedException, IOException {
		try {
			// reportInfo(driver, strTestCaseName, strDevice, "START-Select the Shopping
			// List ", "Select the Shopping List");

			By ShoppingList1 = By.xpath("//XCUIElementTypeStaticText[@value='"+ ShoppingListName+"']");

			// swipeAndVerifyElementIsDisplayedForPaginationWithType(driver,
			// strTestCaseName, deviceDetails, "List Details Screen",ShoppingList1, "xpath",
			// "up");
			clickLink(driver, strTestCaseName, strDevice, "Select the Shopping List from search", ShoppingList1);
			// reportInfo(driver, strTestCaseName, strDevice, "END-Select the View All
			// Shopping List", "Select the Shopping List");
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END-Select the Shopping List",
					"Failed to Select the Shopping List");
			e.printStackTrace();
		}
	}

	public void OfflineSelectShoppingList(String strTestCaseName, String strDevice, String ShoppingList)
			throws InterruptedException, IOException {
		try {
			// reportInfo(driver, strTestCaseName, strDevice, "START-Select the Shopping
			// List ", "Select the Shopping List");
			By lnk_shoppinglist1 = By.xpath("//XCUIElementTypeStaticText[@value='" + ShoppingList + "']");
			clickLink(driver, strTestCaseName, strDevice, "Select the Shopping List from search", lnk_shoppinglist1);
			// reportInfo(driver, strTestCaseName, strDevice, "END-Select the View All
			// Shopping List", "Select the Shopping List");
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END-Select the Shopping List",
					"Failed to Select the Shopping List");
			e.printStackTrace();
		}
	}

	public void selectShoppingList(String strTestCaseName, String strDevice, String ShoppingList)
			throws InterruptedException, IOException {
		try {
			// reportInfo(driver, strTestCaseName, strDevice, "START-Select the Shopping
			// List ", "Select the Shopping List");
			By lnk_shoppinglist1 = By.xpath("//XCUIElementTypeStaticText[@value='" + ShoppingList + "']");
			Thread.sleep(1000);
			clickLink(driver, strTestCaseName, strDevice, "Select the Shopping List from search", lnk_shoppinglist1);
			// reportInfo(driver, strTestCaseName, strDevice, "END-Select the View All
			// Shopping List", "Select the Shopping List");
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END-Select the Shopping List",
					"Failed to Select the Shopping List");
			e.printStackTrace();
		}
	}
	
	
	public void verifyListDetailsPageIsDisplayed(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {
		try {
			verifyPageHeader(driver, strTestCaseName, strDevice, "List Details Page ", lnk_ListPageTitle);
			// Compare the ListDetails page description value
			String ListDetailspagetitle = getObjectText(driver, strTestCaseName, strDevice, "List Details Title",
					Title);
			compareValues(driver, strTestCaseName, strDevice, "List Details Page Title Text Validation", "List Details",
					ListDetailspagetitle);

			String logReport = strTestCaseName + Constants.DELIMITER + strDevice + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER + "List Details page is displayed"
					+ Constants.DELIMITER + Constants.NO_DATA + Constants.DELIMITER + Constants.STEP_PASS;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);

			// Verify ListDetails page using Applitools eyes
			appli.verifyPageWithApplitools(driver, strTestCaseName, strDevice, "List Details", Constants.LAYOUT);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void orderGuideSearchProduct(String strTestCaseName, String strDevice, String ProductNumber)
			throws InterruptedException, IOException {
		try {
			setValue_donothidekeyboard(driver, strTestCaseName, strDevice, "FilterList", productSearch,
					ProductNumber);
			clickcoordinatesdone(driver, strTestCaseName, strDevice);
			Thread.sleep(1000);
			String logReport = strTestCaseName + Constants.DELIMITER + strDevice + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER + "List Details search is displayed"
					+ Constants.DELIMITER + Constants.NO_DATA + Constants.DELIMITER + Constants.STEP_PASS;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END-Select the Product from the OG List Details",
					"Failed to Select the Product from the OG List Details");
			e.printStackTrace();
		}
	}
	public void serachpage_selectSubstituteButton(String strTestCaseName, String strDevice) throws InterruptedException, IOException {
		try {
			clickButton(driver, strTestCaseName, strDevice, "Click Select Substitute Button", selectSubstitute);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void SelectOrderGuid(String strTestCaseName, String strDevice) throws InterruptedException, IOException {
		try {
			// reportInfo(driver, strTestCaseName, strDevice, "START-Select the OrderGuid ",
			// "Select the OrderGuid");
			clickLink(driver, strTestCaseName, strDevice, "Select the OrderGuid from search", OrderGuid);
			// reportInfo(driver, strTestCaseName, strDevice, "END-Select the View All
			// OrderGuid", "Select the OrderGuid");
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END-Select the OrderGuid",
					"Failed to Select the OrderGuid");
			e.printStackTrace();
		}
	}

	public void favSearchProduct(String strTestCaseName, String strDevice, String ProductNumber)
			throws InterruptedException, IOException {
		try {

			setValue(driver, strTestCaseName, strDevice, "Select the Product from Favorites search", favProductSearch,
					ProductNumber);
			clickButton(driver, strTestCaseName, strDevice, "Done Button", doneButton);
			// driver.tap(1, 320, 643, 100);
			// reportInfo(driver, strTestCaseName, strDevice, "END-Select the Search
			// product", "Select the product");
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END-Select the Search product",
					"Failed to Select the Search product");
			e.printStackTrace();
		}
	}

	public void SearchShoppingListProduct(String strTestCaseName, String strDevice, String ProductNumber)
			throws InterruptedException, IOException {
		try {
			setValue(driver, strTestCaseName, strDevice, "Select the Product from search", productSearch,
					ProductNumber);
			//setValue(driver, strTestCaseName, strDevice, "Select the Product from search", ShoppingListProductSearch,
				//	ProductNumber);
			driver.getKeyboard().sendKeys(Keys.RETURN);
			// driver.tap(1, 320, 643, 100);
			// reportInfo(driver, strTestCaseName, strDevice, "END-Select the Search
			// product", "Select the product");
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END-Select the Search product",
					"Failed to Select the Search product");
			e.printStackTrace();
		}
	}

	public void OG_SearchProduct(String strTestCaseName, String strDevice, String ProductNumber)
			throws InterruptedException, IOException {
		try {

			// reportInfo(driver, strTestCaseName, strDevice, "START-Select the Product from
			// the OG List Details", "Select the OG Product");
			setValue(driver, strTestCaseName, strDevice, "Select the Product from search", searchInListScreens,
					ProductNumber);
			clickLink(driver, strTestCaseName, strDevice, "Top Done Button", LocatorConstants.topdone);
			clickLink(driver, strTestCaseName, strDevice, "Click the search text", searchInListScreens);
			clickButton(driver, strTestCaseName, strDevice, "Done Button", doneButton);
			
			
			// driver.getKeyboard().sendKeys(Keys.RETURN);
			// driver.tap(1, 320, 643, 100);
			// reportInfo(driver, strTestCaseName, strDevice, "END-Select the Product from
			// the OG List Details", "Select the OG product");
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END-Select the Product from the OG List Details",
					"Failed to Select the Product from the OG List Details");
			e.printStackTrace();
		}
	}

	public void searchproductinpages(String strTestCaseName, String strDevice, String Product)
			throws InterruptedException, IOException {
		try {

			String product = driver.findElement(By.xpath("//XCUIElementTypeOther[@value='" + Product + "']")).getText();
			compareValues(driver, strTestCaseName, strDevice, "Search product in list/screens", Product, product);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	public void Shoppinlist_SearchProduct(String strTestCaseName, String strDevice, String ProductNumber)
			throws InterruptedException, IOException {
		try {

			// reportInfo(driver, strTestCaseName, strDevice, "START-Select the Product from
			// the OG List Details", "Select the OG Product");
			setValue(driver, strTestCaseName, strDevice, "Select the Product from search", searchInListScreens,
					ProductNumber);
			//clickLink(driver, strTestCaseName, strDevice, "click keyboarddone", doneButton);
			// driver.getKeyboard().sendKeys(Keys.RETURN);

			// driver.tap(1, 320, 643, 100);
			// reportInfo(driver, strTestCaseName, strDevice, "END-Select the Product from
			// the OG List Details", "Select the OG product");
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END-Select the Product from the OG List Details",
					"Failed to Select the Product from the OG List Details");
			e.printStackTrace();
		}
	}

	public void addProducts(String strTestCaseName, String strDevice) throws InterruptedException, IOException {
		try {

			clickLink(driver, strTestCaseName, strDevice, "Select Add Products Button in Review order", addproducts);

		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END-select the Quantity thru tap",
					"Failed to Select the Search product");
			e.printStackTrace();
		}
	}

	public void addToOrReviewOrder(String strTestCaseName, String strDevice) throws InterruptedException, IOException {
		try {
			clickButton(driver, strTestCaseName, strDevice, "Add to Order/Review Order", addToOrderBtn);
			appli.verifyPageWithApplitools(driver, strTestCaseName, strDevice, "Review Order", "layout");
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END-Click ===> Review Order",
					"Failed to Click ===> Review Order");
			e.printStackTrace();
		}
	}

	public void VerifyRemoveProduct(String strTestCaseName, String strDevice, String price)
			throws InterruptedException, IOException {
		try {

			driver.tap(1, 160, 270, 1000);
			clickButton(driver, strTestCaseName, strDevice, "Clear Data ", btn_Cross);
			// reportInfo(driver, strTestCaseName, strDevice, "Product has been removed",
			// "Product has been removed");
			driver.tap(1, 120, 299, 100);
			By OrderDetail_Price = By.xpath("//XCUIElementTypeStaticText[@value='$" + price + " CS']");
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Order Details screen Product Price Changed",
					OrderDetail_Price);
			clickButton(driver, strTestCaseName, strDevice, "Order Details --> Review Order ", LocatorConstants.flyinMenuOrBackBtn);
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END-Remove the Quantity thru tap",
					"Failed to Remove the Search product");
			e.printStackTrace();
		}
	}

	public void selectProductDetails_Inventory(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {
		try {

			clickButton(driver, strTestCaseName, strDevice, " Product Details Screen ", ProductDetailsscreen_Inventory);

		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END-Click ===>Sort By Invoices",
					"Failed to Click ===> Sort By Invoices");
			e.printStackTrace();
		}
	}

	public void selectProductDetails(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {

		clickLink(driver, strTestCaseName, strDevice, "Select  Product Details", ProDetails);
		verifyPageHeader(driver, strTestCaseName, strDevice, "Product Details", ProDetailsTittle);
	}

	public void selectInventoryDetails(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {

		clickLink(driver, strTestCaseName, strDevice, "Select  Inventory Details", InventoryDetails);
		verifyPageHeader(driver, strTestCaseName, strDevice, "Inventory Details", InventoryDetailsTittle);
	}

	public void selectParStock(String strTestCaseName, String strDevice) throws InterruptedException, IOException {

		clickLink(driver, strTestCaseName, strDevice, "Select  PAr Stock", ParStock);
		verifyPageHeader(driver, strTestCaseName, strDevice, "Inventory Details", ParStockTittle);
	}

	public void SpanishProductDetailsScreenValidation(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {
		try {
			// reportInfo(driver, strTestCaseName, strDevice, "START- Product Details Page
			// Validation ", "Product Details Page Validation");

			clickLink(driver, strTestCaseName, strDevice, "Select  Product Details", ProDetails);
			verifyPageHeader(driver, strTestCaseName, strDevice, "Product Details", titleHeader);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Product Number Description",
					lblProductNumber);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Product Description Details",
					lblProductDescription);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Additional Description Details",
					lblAdditionalDescription);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Brand Name Details", lblBrandName);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Pack Size Details", lblPackSize);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Unit Of Measure Details", lblUnitOfMeasure);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Partial Units AvailableDetails",
					lblPartialUnitsAvailable);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Status Details", lblStatus);
			driver.swipe(175, 650, 175, 80, 100);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Brand Type", lblBrandType);

			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Manufacturer Details", lblManufacturer);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Class Details", lblClass);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Category Details", lblCategory);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Group Details", lblGroup);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "GTIN Details", lblGTIN);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "UPCCode Details", lblUPCCode);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Ingredients Details", lblIngredients);
			driver.swipe(175, 650, 175, 80, 100);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Serving Suggestions Details",
					lblServingSuggestions);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "PreparationInstructions Details",
					lblPreparationInstructions);
			// verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "ReadyToEat
			// Details", lblReadyToEat);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Handling Instructions Details",
					lblHandlingInstructions);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Locally Sourced Details", lblLocallySourced);

			// reportInfo(driver, strTestCaseName, strDevice, "END-Click Review Order
			// Button", "Product Details Page Validation");
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END-Click Review Order Button",
					"Failed to Validate Product Details Page");
			e.printStackTrace();
		}
	}

	public void selectNutritioanlFacts(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {
		clickLink(driver, strTestCaseName, strDevice, "Select   Nutrition Facts", NutritionalFacts);

		verifyPageHeader(driver, strTestCaseName, strDevice, "Nutrition Facts", NutritionalFactsTittle);
	}

	public void selectShipppingInformation(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {
		clickLink(driver, strTestCaseName, strDevice, "Select  Shipping Information ", ShippingInfo);
		verifyPageHeader(driver, strTestCaseName, strDevice, "	Shipping Information", shippinginfotitle);
	}

	public void selectMarketingClaims(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {
		clickLink(driver, strTestCaseName, strDevice, "Select Marketing Claims ", MarkingInfo);
		verifyPageHeader(driver, strTestCaseName, strDevice, "	Marketing Claims", MarketingClaimsTittle);
	}

	public void SpanishNutritioanlFactsScreenValidation(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {
		try {
			// reportInfo(driver, strTestCaseName, strDevice, "START-Click Review Order
			// Button", "Select Nutritioanl Facts");

			String NutritionalFactsTitle = getObjectText(driver, strTestCaseName, strDevice, "Contenido Nutritivo",
					NutritionalFacts);
			compareValues(driver, strTestCaseName, strDevice, "Nutrition Facts Validation", " Contenido Nutritivo ",
					NutritionalFactsTitle);
			clickLink(driver, strTestCaseName, strDevice, "Select   Nutrition Facts", NutritionalFacts);

			verifyPageHeader(driver, strTestCaseName, strDevice, "Nutrition Facts", titleHeader);

			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Amount per Serving Details", AmntPerServ);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Calories Details", Calory);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Total Fat Details", TotalFat);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Cholesterol Details", Cholesterol);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Sodium Details", SodiumVal);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Total Carbohydrate Details", TotalCarbo);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "	Supplemental Facts Details",
					SupplementalFacts);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "% Daily Value*", PercentDailyValue);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Protein Value", ProteinVal1);
			// reportInfo(driver, strTestCaseName, strDevice, "END-Click Review Order
			// Button", "Validation Nutritioanl Facts Page");
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END-Click Review Order Button",
					"Failed to VAlidate Nutritioanl Facts Page");
			e.printStackTrace();
		}
	}

	public void inventoryPagination(String strTestCaseName, String strDevice) throws InterruptedException, IOException {
		try {

			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "	CustomerName", custname);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "	CustomerNumber", custno);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "	CS Quantity", csquantity);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "	EA Quantity", eaquantity);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "	price in dollars", priceobj);

			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "	NextPage", nextpage);
			clickButton(driver, strTestCaseName, strDevice, "clicked on NextPage", nextpage);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "	PreviousPage", previouspage);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "	NextPage", nextpage);
			clickButton(driver, strTestCaseName, strDevice, "clicked on NextPage", previouspage);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "	ClickingOnProduct", product);
			clickcoordinatesdone(driver, strTestCaseName, strDevice);

		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END-Click secondary navigation Button",
					"Failed to Validate Inventory Pagination");
			e.printStackTrace();
		}
	}

	public String GetOrderNumber(String strTestCaseName, String strDevice) throws InterruptedException, IOException {
		try {
			reportInfo(driver, strTestCaseName, strDevice, "START-Click Review Order Button",
					"Select Review Order Page");
			String OrderNumber = getObjectText(driver, strTestCaseName, strDevice, "Order Split Message",
					orderSplitMsg);

			reportInfo(driver, strTestCaseName, strDevice, "END-Click Review Order Button", "Select Review Order Page");
			return OrderNumber;
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END-Click Review Order Button",
					"Failed to Select Review Order Page");
			e.printStackTrace();
			return "Fail";
		}
	}

	public void SelectOrderDetails(String strTestCaseName, String strDevice) throws InterruptedException, IOException {
		try {
			// reportInfo(driver, strTestCaseName, strDevice, "START-Entering PO Number",
			// "Entering PO Number in Review Order Page");
			clickLink(driver, strTestCaseName, strDevice, "Select the customer", OrderDetails);
			// reportInfo(driver, strTestCaseName, strDevice, "END-Entering PO Number",
			// "Entering PO Number in Review Order Page");
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END-Entering PO Number in Review Order Page",
					"Failed to Entering PO Number in Review Order Page");
			e.printStackTrace();
		}
	}

	public void SelectSecondaryNavi(String strTestCaseName, String strDevice) throws InterruptedException, IOException {
		try {
			// reportInfo(driver, strTestCaseName, strDevice, "START-Entering PO Number",
			// "Entering PO Number in Review Order Page");
			// verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Convert Order
			// Details", lblLength);
			clickLink(driver, strTestCaseName, strDevice, "Select the customer", LocatorConstants.secondaryNavigationButton);
			// reportInfo(driver, strTestCaseName, strDevice, "END-Entering PO Number",
			// "Entering PO Number in Review Order Page");
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END-Entering PO Number in Review Order Page",
					"Failed to Entering PO Number in Review Order Page");
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public void HideButtons(String strTestCaseName, String strDevice) throws InterruptedException, IOException {
		try {
			driver.tap(1, 152, 360, 50);
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END-Entering PO Number in Review Order Page",
					"Failed to Entering PO Number in Review Order Page");
			e.printStackTrace();
		}
	}

	public void VerifyWillCallCancelOrder(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {
		try {
			// reportInfo(driver, strTestCaseName, strDevice, "START-Entering PO Number",
			// "Entering PO Number in Review Order Page");
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Verify  Will call Cancel Order Lable",
					WillcallCancelOrder);
			// clickButton(driver, strTestCaseName, strDevice, "Hide Cancel Button",
			// ReviewOrderTitle);
			// reportInfo(driver, strTestCaseName, strDevice, "END-Entering PO Number",
			// "Entering PO Number in Review Order Page");
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END-Entering PO Number in Review Order Page",
					"Failed to Entering PO Number in Review Order Page");
			e.printStackTrace();
		}
	}

	public void UpdateOrder(String strTestCaseName, String strDevice) throws InterruptedException, IOException {
		try {
			reportInfo(driver, strTestCaseName, strDevice, "START- Order update Button",
					" Update Order Button in Review Order Page");
			clickButton(driver, strTestCaseName, strDevice, "Update Button", btn_Update);
			reportInfo(driver, strTestCaseName, strDevice, "END- UpdateOrder Button",
					"Update Order Button in Review Order Page");
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END- Update Order Button in Review Order Page",
					"Failed to  Update Order Button in Review Order Page");
			e.printStackTrace();
		}
	}
	
	public void ExceptionOrder(String strTestCaseName, String strDevice) throws InterruptedException, IOException {
		try {
			// reportInfo(driver, strTestCaseName, strDevice, "START- Order Submit Button",
			// "Order Submit Button in Review Order Page");
			String exp = getObjectText(driver, strTestCaseName, strDevice, "Order Exceptions", orderException);
			System.out.println("Exp : " + exp);

			String logReport = strTestCaseName + Constants.DELIMITER + strDevice + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER + "Exception Information" + "--->" + exp
					+ Constants.DELIMITER + "NO DATA" + Constants.DELIMITER + Constants.stepInfo;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);
			reportInfo(driver, strTestCaseName, strDevice, "END-Order Submit Button",
					"Order Submit Button in Review Order Page");
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END- Order Submit Button in Review Order Page",
					"Failed to Order Submit Button in Review Order Page");
			e.printStackTrace();
		}
	}

	public void UpdatePrice(String strTestCaseName, String strDevice) throws InterruptedException, IOException {
		try {
			// reportInfo(driver, strTestCaseName, strDevice, "START- Order Submit Button",
			// "Order Submit Button in Review Order Page");

			clickButton(driver, strTestCaseName, strDevice, "Update Price", btn_UpdatePrice);

			// reportInfo(driver, strTestCaseName, strDevice, "END-Order Submit Button",
			// "Order Submit Button in Review Order Page");
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END- Finished Button in Order Exception Page",
					"Failed to Finished Button in Order Exception Page");
			e.printStackTrace();
		}
	}

	public void SelectConfirmQuantity(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {
		try {
			// reportInfo(driver, strTestCaseName, strDevice, "START- Order Submit Button",
			// "Order Submit Button in Review Order Page");

			clickButton(driver, strTestCaseName, strDevice, "ConfirmQuantity Button", btn_ConfirmQuantity);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Exceptions- Quantity Confirmation ",
					lbl_QuantityConfirmed);

			// reportInfo(driver, strTestCaseName, strDevice, "END-Order Submit Button",
			// "Order Submit Button in Review Order Page");
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END- Order Submit Button in Review Order Page",
					"Failed to Order Submit Button in Review Order Page");
			e.printStackTrace();
		}
	}

	public void SelectCustomerOrderStatus(String strTestCaseName, String strDevice, String CustomerNumber)
			throws InterruptedException, IOException {
		try {
			reportInfo(driver, strTestCaseName, strDevice, "START-Select the Order from search",
					"Select the Order from search Order Status Page");
			setValue(driver, strTestCaseName, strDevice, "Select the customer from search", tbx_SearchOrder,CustomerNumber);
			clickLink(driver, strTestCaseName, strDevice, "Top Done Button", LocatorConstants.topdone);
			clickLink(driver, strTestCaseName, strDevice, "Search Text_FR",tbx_SearchOrder);
			clickButton(driver, strTestCaseName, strDevice, "Done Button", doneButton);
			//driver.getKeyboard().sendKeys(Keys.RETURN);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "No Order Submitted", ele_NoOrderSubmitted);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Order Submitted", ele_OrderSubmitted);

			// By CustomerSelect =
			// By.xpath("(//XCUIElementTypeStaticText[@value='("+CustomerNumber+")'])[1]");

			// clickLink(driver,strTestCaseName, strDevice, "Select the
			// customer",CustomerSelect);
			reportInfo(driver, strTestCaseName, strDevice, "END- Order from search Order Status Pag",
					"Order from search Order Status Page");
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END- Order Submit Button in Review Order Page",
					"Failed to Order from search Order Status Page");
			e.printStackTrace();
		}
	}

	public void SearchProducts(String strTestCaseName, String strDevice, String ProductNumber)
			throws InterruptedException, IOException {
		try {

			setValue(driver, strTestCaseName, strDevice, "Search the Product from OrderDetails", tbx_SearchOrder,
					ProductNumber);
			clickLink(driver, strTestCaseName, strDevice, "Top Done Button", LocatorConstants.topdone);
			clickLink(driver, strTestCaseName, strDevice, "Click the search text",tbx_SearchOrder );
			clickButton(driver, strTestCaseName, strDevice, "Done Button", doneButton);
			driver.getKeyboard().sendKeys(Keys.RETURN);

		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END- Search the Product from OrderDetails Page",
					"Failed toSearch the Product from OrderDetails Page");
			e.printStackTrace();
		}
	}

	public void SelectNonSubmitedOrder(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {
		try {
			// reportInfo(driver, strTestCaseName, strDevice, "START- Order Submit Button",
			// "Order Submit Button in Review Order Page");
			clickButton(driver, strTestCaseName, strDevice, "Select the No Order Submitted", SelectOrder);
			// reportInfo(driver, strTestCaseName, strDevice, "END-Order Submit Button",
			// "Order Submit Button in Review Order Page");
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END- Order Submit Button in Review Order Page",
					"Failed to Order Submit Button in Review Order Page");
			e.printStackTrace();
		}
	}

	public void VaidationNotSubmitedOrderStatusScreen(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {
		try {
			reportInfo(driver, strTestCaseName, strDevice, "START-Validate the Order - Order Status",
					"Validate the Order - Order Status");

			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Ordered:", lblOrdered);

			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Total Amount:", lbl_TotalAmount);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Total Lines:", lbl_TotalLines);

			clickLink(driver, strTestCaseName, strDevice, "Move to Review Order Screen", lblOrdered);

			reportInfo(driver, strTestCaseName, strDevice, "END- Order from search Order Status Pag",
					"Order from search Order Status Page");
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END- Order Submit Button in Review Order Page",
					"Failed to Order from search Order Status Page");
			e.printStackTrace();
		}
	}

	public void OrderPageValidation(String strTestCaseName, String strDevice) throws IOException, Exception {
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Delivery Date:", Ord_DeliveryDate);
		// verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Order Status",
		// Order_Status);
		// verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Department",
		// Order_Department);
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Total lines", Order_TotalLine);
		verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Creation Date", Order_CreationDate);
		String CreationDateText = getObjectText(driver, strTestCaseName, strDevice, "Creation Date Text",
				Order_CreationDateText);

		if (isValidDate(CreationDateText)) {
			String logReport = strTestCaseName + Constants.DELIMITER + strDevice + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER + "DATE FORMAT" + Constants.DELIMITER
					+ CreationDateText + Constants.DELIMITER + Constants.stepPass;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);
		} else {
			String logReport = strTestCaseName + Constants.DELIMITER + strDevice + Constants.DELIMITER
					+ getCurrentDateAndTime() + Constants.DELIMITER + "DATE FORMAT" + Constants.DELIMITER
					+ CreationDateText + Constants.DELIMITER + Constants.stepPass;
			appendReportFile(driver, logReport);
			extentReport(driver, logReport);
		}

	}

	public static boolean isValidDate(String inDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/DD/YY hh:mm aa");
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(inDate.trim());
		} catch (ParseException pe) {
			return false;
		}
		return true;
	}

	public void VaidationNonSubmitedOrderStatusScreen(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {
		try {
			reportInfo(driver, strTestCaseName, strDevice, "START-Validate the Order - Order Status",
					"Validate the Order - Order Status");

			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Ordered:", lblOrdered);

			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Total Amount:", lbl_TotalAmount);
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Total Lines:", lbl_TotalLines);

			clickLink(driver, strTestCaseName, strDevice, "Move to Review Order Screen", lblOrdered);

			// verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "No Order
			// Submitted", ele_NoOrderSubmitted);
			// final By btn_OrderNumber= By.xpath(Prd_OrderNumber+OrderNumber+"]'");
			// clickButton(driver, strTestCaseName, strDevice, "Order selected",
			// btn_OrderNumber);
			reportInfo(driver, strTestCaseName, strDevice, "END- Order from search Order Status Page",
					"Order from search Order Status Page");
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END- Order Submit Button in Review Order Page",
					"Failed to Order from search Order Status Page");
			e.printStackTrace();
		}
	}

	public void updateOrder(String strTestCaseName, String strDevice) throws InterruptedException, IOException {
		try {
			reportInfo(driver, strTestCaseName, strDevice, "START- Order update Button",
					" Update Order Button in Review Order Page");
			clickButton(driver, strTestCaseName, strDevice, "Update Button", btn_Update);
			reportInfo(driver, strTestCaseName, strDevice, "END- UpdateOrder Button",
					"Update Order Button in Review Order Page");
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END- Update Order Button in Review Order Page",
					"Failed to  Update Order Button in Review Order Page");
			e.printStackTrace();
		}
	}

	// This method is to select the submitted order with the PO Number
	public void selectSubmittedOrderWithPONumber(String strTestCaseName, String strDevice, String PONumber)
			throws InterruptedException, IOException {
		try {
			/*
			 * swipeAndVerifyElementIsDisplayedForPaginationWithType(driver,
			 * strTestCaseName, strDevice, "Order with the PONumber",
			 * "//android.widget.TextView[@text='" + PONumber + "']", "xpath", "up");
			 */
			clickButton(driver, strTestCaseName, strDevice, "Order with PONumber",By.xpath("//XCUIElementTypeStaticText[@value='" + PONumber + "']"));
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END- Order with PO Number not found",
					"Failed to find the order with the PO Number");
			e.printStackTrace();
		}
	}

	public void enterMoreQuantity(String strTestCaseName, String strDevice) throws IOException {
		try {
			TouchAction longPress = new TouchAction(driver);

			longPress.longPress(driver.findElement(ProductQuantity)).perform();

			clickButton(driver, strTestCaseName, strDevice, "9", btn_Nine);
			clickButton(driver, strTestCaseName, strDevice, "9", btn_Nine);
			clickButton(driver, strTestCaseName, strDevice, "9", btn_Nine);

			clickButton(driver, strTestCaseName, strDevice, "Product", ProductOverView);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyProducts(String strTestCaseName, String strDevice) throws IOException, InterruptedException {
		try {

            List<String> textData = new ArrayList<>();
            List<String> textData1 = new ArrayList<>();
            Set<String> elementSet1 = new HashSet<>();
            for (int i = 0; i <= 50; i++) {
            	List<MobileElement> objElement1 = driver.findElementsById(productName);
            	for (MobileElement element : objElement1) {
            		String text = element.getText();
            		elementSet1.add(text);
            		textData.add(text);
            	}
                  while(i<=30)
                  {
                  		swipeUp(driver, 80, 30);
                  		List<MobileElement> objElement2 = driver.findElementsById(productName);
                  		for (MobileElement element : objElement2) {
                  			String text = element.getText();
                  			textData1.add(text);

                  }

                 

                  ////

                  List<MobileElement> element2 = driver.findElements(WOULD_YOU_LIKE_TO_TRY_GROUP_HEADER);
                  int objcount2 = element2.size();
                  if(textData.containsAll(textData1))
                  {
                	  if((elementSet1.size() < 48))
                	  {
                	if(objcount2 > 0)

                  {
            			  verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "EDLP Header", WOULD_YOU_LIKE_TO_TRY_GROUP_HEADER);

                  }
                		  break;

                        }

                        if(elementSet1.size() > 48)

                        {

                              List<MobileElement> element1 = null;

                              int objcount1 = 0;

                              element1 = driver.findElements(By.xpath(nextPage));

                              objcount1 = element1.size();

                              if (objcount1 > 0) {

                                    appli.verifyPageWithApplitools(driver, strTestCaseName, strDevice, "Next Page", Constants.LAYOUT);

                                    clickButton(driver, strTestCaseName, strDevice, "Next Page", By.xpath(nextPage));

                                    if(objcount2 > 0)

                                    {

                                          verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "EDLP Header", WOULD_YOU_LIKE_TO_TRY_GROUP_HEADER);

                                    }

                                    break;

                              }

                        }

                        if((elementSet1.size() == 48))

                        {

                              break;

                        }

                  }}}}
            catch (Exception e) 
		{
            e.printStackTrace();
      }
}
	public void validateProductAvailabilityMsgforSubstituteProduct(String strTestCaseName, String strDevice, String productAvailabilityText) throws InterruptedException, IOException {
		try {
			
		//	swipeAndVerifyElementIsDisplayedForPaginationWithType(driver, strTestCaseName, strDevice, "Shopping list",
			//		productAvailabilityObj, "xpath", "up");
			verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Product availability message under substitute product", productAvailabilityMsg);		
			String getProductAvailibilityText = driver.findElement(productAvailabilityMsg).getText();
			
			compareValues(driver, strTestCaseName, strDevice, "Product availability text under substitute product in Order exception screen", getProductAvailibilityText,
					productAvailabilityText);	
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void swipeandverifyFinshedButton(String strTestCaseName, String strDevice)
			throws InterruptedException, IOException {
		try {
			
			swipeAndVerifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Swipe and verify Finished button",
					btn_Finished, "up");
			
		} catch (Exception e) {
			reportFail(driver, strTestCaseName, strDevice, "ERROR-END- Order Submit Button in Review Order Page",
					"Failed to Order Submit Button in Review Order Page");
			e.printStackTrace();
		}
	}
	
	public void validateDownloadMyAccountBanner(String strTestCaseName, String strDevice) throws IOException, InterruptedException

    {

                    try {

                                    verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Download My Account Banner", downloadOrOpenMyAccountBanner);

                                    verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Download My Account Image", downloadOrOpenMyAccountImage);

                                    verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "Managing Your Account", managingYourAccountTxt);

                                    String managingTxt = getObjectText(driver, strTestCaseName, strDevice, "Managing your account is easy", managingYourAccountTxt);

                                    compareValues(driver, strTestCaseName, strDevice, "Managing your account is easy Text Validation", MANAGING_YOUR_ACCOUNT, managingTxt);

                                    String downloadTxt = getObjectText(driver, strTestCaseName, strDevice, "Open My Account", openMyAccountTxt);
                                    
                                    clickLink(driver, strTestCaseName, strDevice, "click the myAccount Banner", myAccount);
                                    
                                    verifyElementIsDisplayed(driver, strTestCaseName, strDevice, "MyAccount Application Login", myAccountLoginpage);
                                    
                                  // clickLink(driver, strTestCaseName, strDevice, "click the search Button", searchbtn);
                                   

                    } catch (Exception e) {

                                    e.printStackTrace();

                    }             

    }

public void setValueusingSoftKeypad_forQuantityBox(String strTestCaseName, String strDevice, String quantity)
			throws IOException {
		try {

			// TouchActions action = new TouchActions(driver);
			// action.longPress(OrderGuid).moveTo(OrderGuid).release().perform();
			// action.perform();

			MobileElement element = (MobileElement) driver.findElementById("segSearch_1_1_flexProducts_flexBaseContainer_flexItemContainerParent_flexItem_flexPricingContainer_flexDetails_flexQuantity_flexQuantityOne_lblQtyOne");
			new TouchAction(driver).longPress(element).release().perform();

			clickButton(driver, strTestCaseName, strDevice, "Delete values in Quantity box", SoftKeyPadCross);

			for (int i = 0; i < quantity.length(); i++) {
				char value = quantity.charAt(i);
				if (value == '1') {
					clickButton(driver, strTestCaseName, strDevice, "Click 1 fron soft keypad", SoftKeyPad1);
				} else if (value == '2') {
					clickButton(driver, strTestCaseName, strDevice, "Click 2 fron soft keypad", SoftKeyPad2);
				} else if (value == '3') {
					clickButton(driver, strTestCaseName, strDevice, "Click 2 fron soft keypad", SoftKeyPad3);
				} else if (value == '4') {
					clickButton(driver, strTestCaseName, strDevice, "Click 2 fron soft keypad", SoftKeyPad4);
				} else if (value == '5') {
					clickButton(driver, strTestCaseName, strDevice, "Click 2 fron soft keypad", SoftKeyPad5);
				} else if (value == '6') {
					clickButton(driver, strTestCaseName, strDevice, "Click 2 fron soft keypad", SoftKeyPad6);
				} else if (value == '7') {
					clickButton(driver, strTestCaseName, strDevice, "Click 2 fron soft keypad", SoftKeyPad7);
				} else if (value == '8') {
					clickButton(driver, strTestCaseName, strDevice, "Click 2 fron soft keypad", SoftKeyPad8);
				} else if (value == '9') {
					clickButton(driver, strTestCaseName, strDevice, "Click 2 fron soft keypad", SoftKeyPad9);
				} else if (value == '0') {
					clickButton(driver, strTestCaseName, strDevice, "Click 2 fron soft keypad", SoftKeyPad0);
				}

			}
			clickButton(driver, strTestCaseName, strDevice, "Click on  quantity box", ProductQuantity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
