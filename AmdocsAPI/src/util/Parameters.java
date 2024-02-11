package util;

import java.math.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import amdocs.amsp.AddressConstantsI;
import amdocs.amsp.Configuration;
import amdocs.amsp.FrameworkConstantsI;
import amdocs.amsp.ServiceConstantsI;
import amdocs.amsp.util.AmspUtil;
import amdocs.amsp.valueobject.opquery.QualifiersVO;
import amdocs.amsp.valueobject.servicepoint.ContractVO;
import amdocs.amsp.valueobject.servicepoint.ServicePointVO;
import amdocs.core.Money;

/**
 * @author JVANHOOF
 * This class holds all the common and operational specific values used in API parameters
 */
@SuppressWarnings("deprecation")
public class Parameters {
	
	private long startTime = 0;
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
	private String startTimestamp = null;
	private String env_variable = null;
	
	// add new operations that require specific parameter values to the bottom of this list and add
	// a matching case to the switch statement in the constructor
	public static int TEMP_OPERATION              = 99;
	public static int NEW_PROSPECT                =  0;
	public static int NEW_PROSPECT_OFFER          =  1;
	public static int GET_AVAILABLE_PHONE_NUMBERS =  2;
	public static int DEMO                        =  3;
	public static int NEW_INSTALL                 =  4;
	public static int SEND_DIRECT_HIT             =  5;
	public static int CANCEL_SRO                  =  6;
	public static int OPERATOR                    =  7;
	public static int GET_TECH_JOBS               =  8;
	public static int ASSIGN_EQUIP                =  9;
	public static int CHANGE_UPGRADE_HOLD         = 10;
	public static int CREATE_NEW_ENT_SALESMAN     = 11;
	public static int UPDATE_ENT_SALESMAN         = 12;
	public static int CREATE_SITE                 = 13;
	public static int PROSPECT_OFFER_SITE         = 14;
	public static int UPDATE_CUST_DATA            = 15;
	public static int PROSPECT_OFFER_SITE_TOOL    = 16;
	public static int UPDATE_ENTERPRISE_OPERATOR  = 17;
	public static int PROSPECT_OFFER_SITE_DEMO    = 18;
	public static int RE_ASSIGN_TECH_JOBS         = 19;
	public static int CHANGE_OF_SERVICE           = 20;
	public static int CONSTRAINTS_DUMP            = 21;
	public static int PAYCARD_INFO                = 22;
	public static int CHANGE_OF_SERVICE_2         = 23;
	public static int RESCHEDULE_COS_CHANGE       = 24;
	public static int GET_TELEPHONY_SERVICES      = 25;
	public static int GET_ACCOUNT_SERVICE_POINTS  = 26;
	public static int LOCK                        = 27;
	public static int UPDATE_ENT_TECHNICIAN       = 28;
	public static int BROWSE_EQUIPMENT            = 29;
	public static int REMOVE_EQUIP                = 30;
	public static int GET_EQUIPMENT_DETAILS       = 31;
	public static int COMPLETE_COS_JOB            = 32;
	public static int NOT_DONE_ALERT_STATUS       = 33;
	public static int GET_CODE_TABLE              = 34;
	public static int RESCHEDULE_COS_DATES_ONLY   = 35;
	public static int RESCHEDULE_SRO              = 36;
	public static int COMPLETE_SRO_JOB            = 37;
	public static int PAYMENTS                    = 38;
	public static int LOGIN                       = 39;
	public static int STAY_ALIVE                  = 40;
	public static int BROWSE_BY_ADDRESS           = 41;
	public static int MOVE_EQUIP_OTHER_SP         = 42;
	public static int GET_PREDICTED_ENDING_BALANCE= 43;
	public static int DISCONNECT_NO_TRUCK         = 44;
	public static int CREATE_TC                   = 45;
	public static int CREATE_SRO                  = 46;
	public static int DISCONNECT_SCHEDULE         = 47;
	public static int UPDATE_ACCOUNT_COMMENTS     = 48;
	public static int GET_ALL_FINANCIALS          = 49;
	public static int COMPLETE_TC_JOB             = 50;
	public static int DIRECT_PAYMENT_ADJUSTMENT   = 51;
	public static int DIRECT_PAYMENT_ADJUSTMENT_TOOL = 53;
	public static int ADD_MDU_SITE_UNITS_TOOL     = 54;
	public static int GET_CONTRACTS               = 55;
	public static int GET_PACKAGES                = 56;
	
	public static short EQUIPMENT_VO_ACTION_NO_CHANGE = 0; //Valid Values:no change = 0, change = 1, add = 2, remove = 3
	public static short EQUIPMENT_VO_ACTION_CHANGE    = 1;
	public static short EQUIPMENT_VO_ACTION_ADD       = 2;
	public static short EQUIPMENT_VO_ACTION_REMOVE    = 3;
	
	public static short SERVICE_POINT_VO_ACTION_NO_CHANGE = 0; // valid values are :no change = 0, change = 1, add = 2, remove = 3
	public static short SERVICE_POINT_VO_ACTION_CHANGE    = 1;
	public static short SERVICE_POINT_VO_ACTION_ADD       = 2;
	public static short SERVICE_POINT_VO_ACTION_REMOVE    = 3;
	// App
	private String     appName          = "API Testing Client";
	private String     appVersion       = "1.2";
	private String     amspVersion      = "9.0";
	
	// API test app settings
	private String     file_name       = "API_output";
	private String     file_path       = "c:\\temp\\";  // Double backslashes are "escaped" single backslashes
	private int        outputMode      = 2;  // 0 = console only, 1 = screen only, 2 = screen and print files, 3 = tool messages only
	
	// These values are set in the initParameters() Method based on environment variable API_TARGET (DMZ or ORT) set in launch script         
	private String     corp            = null;
	private String     user            = null;
	private String     password        = null;
	
	private String     locale          = FrameworkConstantsI.DEFAULT_LOCALE;

	// Add new operational parameters here and to the printParameters in case statement
	//    1. Create and initialize them here
	//    2. Create a get method for them below
	//    3. Set and print the value in the appropriate section of the case statement
	private int        accountingArea           = -1;
	private int        accountCategory          = -1;
	private int        acctPriceStructId        = 0;
	private int        addressUse               = -1;
	private int        addressType              = -1;   // Valid Values: 1=business ,2= residential
	private Money      adjustmentAmount         = null;
	private String     adjustmentCode           = null;
	private String     aging                    = null; // Aging to which adjustment should be applied.Valid Values: 0 = Current, 1 = 30 day, 2 = 60 day, 3 = 90 day, 4 = 120 day
	private Money      amount                   = null;
	private Money      amountTendered           = null;
	private short      allowInvalidZip          = -1;   // valid values: 0 = false:validates the user input, 1= true: Allows whatever the user entered input
	private Money      batchAmount				= null; // The total amount for this batch. Valid Values: unknown .
	private Money      batchCash				= null; // Drawer Tally cash amount. Valid Values: unknown
	private Money      batchCheque				= null; // Drawer Tally Cheque amount. Valid Values: unknown
	private short	   batchClose               = -1;   // Close an exiting batch. Valid Values : 0,1.
	private short      batchContinue            = -1;   // Continue an existing batch. Valid Values: 0,1
	private Money      batchCreditCard          = null; // Drawer Tally Credit Card amount. Valid Values: unknown 
	private String     batchCtrlgroup           = null; // Batch control group. Valid Values: unknown .
	private short      batchDone                = -1;   // Valid Values 0,1.
	private Money      batchElectronicCheq      = null; // Drawer Tally eCheck amount. Valid Values: unknown.
	private short      batchNew                 = -1;   // New batch to open. Valid Values : 0,1(open a new batch) .
	private int        batchNumber              = -1;   // Batch Number. Valid Values: 1-9999 .
	private int        batchNumberTarget        = -1;   // Batch Number. Valid Values: 1-9999 .
	private Money      batchOther               = null; // Drawer Tally other amount. Valid Values: unknown .
	private Money      batchPostal              = null; // Drawer Tally Postal amount. Valid Values: unknown .
	private String     batchStatus              = null; // Current status of the batch. Valid Values: Blank=Closed,3= Open/Busy
	private String     batchType                = null; // Batch Type. Valid Values: P = Payment and A = Adjustment.
	private Date       billDate                 = null;
	private String     billForm                 = null; // char(5) Billing form (36 code table number 124)
	private Date       beginDateTime            = null;
	private String     callerName               = null; // char(9)
	private String     campaignCode             = null; // char(20)
	private short      cancelNpd                = 0;
	private String     cancelReason             = null; // char(5) WIP Cancel reason (36 code table number 133
	private String     changeReason             = null; // char(5) WIP Change reason (36 code table number xxx
	private Date       changeTime               = null;
	private Date       cdwDate                  = null;
	private String     checkinAlert             = null;
	private String     codCode                  = null;
	private String     collStatAgencyCode       = null;
	public short       collStatClass            = 0;
	public short       collStatClose            = 0;
	public String      collStatComments         = null;
	private Date       collStatDate             = null;
	private String     collStatCancelReason     = null;
	private String     collStatPath             = null;
	private String     collStatStep             = null;
	private boolean    colStatPpvHold           = false;
	private String     comment                  = null; // varies by us
	private int        commentTypeSelect        = 0;
	private Date       completeDate             = null;
	private Date       completeTime             = null;
	private int        contractStatusOption     = 0;
	private long       contractTemplateId       = 0;
	private String[]   corpSet                  = {""};
	private String     corpSetTarget            = null;
	private String     cust_acct                = null; // char(8)
	private String     cust_acct2               = null; // char(8)
	private String     custClassCode            = null;
	private boolean    customPointsAllowed      = false;
	private int        cycle                    = -1;
	private Date       dateOfBirth              = null;
	private String     disconnectReasonCode     = null;
	private Money      dMoney                   = null; // Money collected on this job.Valid Values: 0-999999999999
	private String     dSeq                     = null; // Sequence of this job in the total work assigned to the technician. DSEQ column from WIPMASTER table.
	private boolean    duplicateAddressFlag     = false;
	private String     equipmentId              = null; // char(14) bmumb in boxinvtry
	private Date       effectiveDate            = null;
	private int        effectiveDateFlag        = 0;
	private String     equipmentLocation        = null;
	private short      equipmentVOaction        = -1;   //Valid Values:no change = 0, change = 1, add = 2, remove = 3
	private String     enterpriseId             = null;
	private String     firstName                = null; // char(20)
	private String     fromTech                 = null; // char(6)
	private Date       highDate                 = new Date("30-dec-3500");
	private String     homePhone                = null; // char(14)
	private String     houseInfo                = null; // char(5)
	private String     initial                  = null; // char(2)
	private boolean    isAdjustment             = false;
	private boolean    isProspect               = false;
	private short      blankOutFlag             = 0;
	private boolean	   isEcheck					= false;
	private boolean    isFrontCounterMode       = false;
	private boolean    isMustDo                 = false;
	private boolean    isPayCard                = false;
	private boolean	   isPayment    			= false;
	private int        installType              = -1;   // New move in type order. Valid Values: 1 = New move in order 
	private boolean    isOffer                  = false;
	private int        jobType                  = -1;
	private String     lastName                 = null; // char(20)
	private int        newCycle                 = 0;
	private BigDecimal offerNum                 = null; // = new BigDecimal("5909");
	private String     operatorId               = null; // char(3)
	private String     operatorStatus           = null; // char(1)
	private String     optionCode               = null; // char(5)
	private int        optionId                 = 0;
	private String     orderComment             = null;
	private short      orderInfoVOaction        = -1;
	private BigDecimal orderGroupSeq            = null;
	private int        orderType                = -1;
	private String[]   overriddenRuleIds        = {"",""};
	private String     otherPhone               = null;
	private int        outlet                   = 0;
	private int        outletTarget             = 0;
	private String     packageCode              = null; // char(2)
	private String	   paymentKind				= null;
	private String	   paymentReference  		= null;
	private ContractVO[] pendingContractIds     = null;
	private String     phoneClass               = null; // char(2) PHONE_NUM_CLAS column from PHONE_NUMBER_INVENTORY
	private String     phoneNumber              = null; // char(14)
	private boolean    phoneNumberReplaceFlag   = false;
	private int        phoneNumSearch           = -1;
	private short      phoneVOaction            = -1;
	private boolean    plant                    = false;
	private short      points                   = -1;
	private int        priceStructId            = 0;
	private String     printFileCode            = null; // char(1)
	private String     prevSerialNumber         = null;
	private String     productLanguage          = null; // char(5) Product Language identifier code 36 table 167
	private QualifiersVO[] qualifiersVOList = null;
	private short      quotaGroupCode           = 0;
	private short      quotaTimeSlotCode        = 0;
	private String     rateCode1                = null; // char(2)
	private String     rateCode2                = null; // char(2)
	private String     rateCode3                = null; // char(2)
	private String     rateCode4                = null; // char(2)
	private short      rateCodeVOaction         = -2;   // -1=Inactive, no change = 0, change = 1, add = 2, remove = 3
	private String     reason                   = null; // adjustment reason
	private String     reasonCode               = null;
	private String     refrenceNumber			= null; // 20 char alpha-numeric maps to batchdetil.pmt_ref
	private boolean    queueHsdsHitFlag         = false;
	private String     reminderScheme           = null; // char(5) Reminder scheme for collection process (36 code table number 122)
	private String     salesRepId               = null; // char(6) 
	private Date       scheduleDate             = null;
	private int        scheduleType             = -1;
	private int        scheduleAction           = -1;
	private short      scheduleVOaction         = -1;
	public String      serialNumber             = null;
	private int        serviceGroup             = -1;
	private String     servicePackage           = null; // char(2)
	private int        servicePoint             = -1;
	private boolean    servicePointEquipRemoval = false;
	private int        servicePointTarget       = -1;
	private String     servicePointLocationCode = null; // char(5) 36 code table number 163
	private ServicePointVO[] servicePointVOlist = null;
	private short      servicePointVOaction     = -1;   // valid values are :no change = 0, change = 1, add = 2, remove = 3
	private String     siteId                   = null; // char(8)
	private String     skillLevel               = null; // char(1)
	private Boolean    skipPayCard              = false;
	private Boolean    skipServicePointData     = false;
	private String     specialInstruct1Code     = null;
	private String     sroFixCode               = null;
	private String     sroFixDesc               = null;
	private Date       startStmtDate            = null;
	private Date       stopStmtDate             = null;
	private Date       statementDate            = null;
	private String     statementScheme          = null; // char(5) Valid Values: A - D Must be in the parameter statement scheme table
	private int        status                   = -1;   // used in SalesmanDetailsVO
	private short      statusCode               = 0;    // Job status code. Valid Values: 2 = Not done, 3 = Alert. Used in DispatchJobsFacade.notDoneAlertStatus() 
	private String[]   suiteList                = null;
	private String     tag                      = null; // char(7) Tag number for this drop. Valid Values: Alphanumeric String
	private String     taskCode                 = null; // char(10) code95 table number 201
	private String     tcFixCode                = null;
	private String     tcFixDesc                = null;
	private String     techId                   = null; // char(6)
	private String     toTech                   = null; // char(6)
	private String     type                     = null; // used in SalesmanDetailsVO
	private String     typeCode                 = null; // Customer Type
	private boolean    upgradeHold              = false;
	private String     userName                 = null; // used in getEnterpriseOperator
	private short      validateOnlyFlg          = 0;

	// Method called by all Main[...] classes at the beginning of the main method
	public void initParameters (int operation, Parameters apiParams, PrintOutput printOutput) {
		
		startTime = System.nanoTime();
		
		env_variable = System.getenv("API_TARGET");
		
		printOutput.printToShell (apiParams, "   Runtime Login Values", null);
		switch (env_variable.toString()) {
		case "TRAIN":
			this.setCorp(apiParams, printOutput, "99956");
			this.setPassword(apiParams, printOutput, "7913Jv51");
			this.setUser(apiParams, printOutput, "jvanhoof");
			break;
			
		case "ORT":
			this.setCorp(apiParams, printOutput, "99517");
			this.setPassword(apiParams, printOutput, "api4amsp");
			this.setUser(apiParams, printOutput, "amspapi");
			break;
			
		case "ORTLNX":
			this.setCorp(apiParams, printOutput, "00755");
			this.setPassword(apiParams, printOutput, "api4amsp");
			this.setUser(apiParams, printOutput, "amspapi");
			break;
		case "DEV":
			this.setCorp(apiParams, printOutput, "46099");
			this.setPassword(apiParams, printOutput, "m@$t3r99");
			this.setUser(apiParams, printOutput, "c46099");
			break;
		
		}
		
		printOutput.printToShell (apiParams, "", null);
		
		if (operation != Parameters.PROSPECT_OFFER_SITE_TOOL) {
			this.printCommonParameters(apiParams, printOutput);
		}
		
		switch (operation) {
		case 99: // TEMP_OPERATION
			printOutput.printToShell (apiParams, "   TEMP_Operation Initial Parameter Values",  null);
			this.setCust_acct(apiParams, printOutput, "45466461");
			this.setSiteId(apiParams, printOutput, "00107333");
			break;
			
		case 0: // NEW_PROSPECT
			printOutput.printToShell (apiParams, "   NEW_PROSPECT Operation Initial Parameter Values",  null);
			this.setAccountCategory(apiParams, printOutput, ServiceConstantsI.AccountCategory.RESIDENTIAL.getAcctCatTypeValue());
			this.setCust_acct(apiParams, printOutput, "0"); // must be 0 for new Prospect
			this.setCycle(apiParams, printOutput, 28);
			this.setHomePhone(apiParams, printOutput, this.generateRandomNumberString(10));
			this.setLastName(apiParams, printOutput, "APIsetcyclenewcycle");
			this.setNewCycle(apiParams, printOutput, 15);
			//this.setOrderType(apiParams, printOutput, ServiceConstantsI.OrderType.ORDER_INSTALL.getOrderTypeValue());
			//this.setScheduleType(apiParams, printOutput, ServiceConstantsI.NO_TRUCK);
			this.blankOutFlag = 0; // If we set to 1. This flag will Blank Out existing Customer RPhone number
			this.setSiteId(apiParams, printOutput, "01000205");
			break;
			
		case 1: // NEW_PROSPECT_OFFER
			printOutput.printToShell (apiParams, "   NEW_PROSPECT_OFFER Operation Initial Parameter Values",  null);
			this.setAccountCategory(apiParams, printOutput, ServiceConstantsI.AccountCategory.RESIDENTIAL.getAcctCatTypeValue());
			this.setBillDate(apiParams, printOutput, new Date("6-mar-2014"));
			this.setBillForm(apiParams, printOutput, "S    ");
			this.setCust_acct(apiParams, printOutput, "0"); // must be 0 for new Prospect
			this.setInstallType(apiParams, printOutput, ServiceConstantsI.OrderType.ORDER_INSTALL.getOrderTypeValue());
			this.setIsOffer(apiParams, printOutput, true);
			this.setJobType(apiParams, printOutput, ServiceConstantsI.JobType.JOBTYPE_INSTALL.getJobTypeValue());
			this.setLastName(apiParams, printOutput, "PROSPECTOFFERLN08");
			this.setOrderInfoVOaction(apiParams, printOutput, (short)1); // empty = -1, no change = 0, change = 1, add = 2, remove = 3
			this.setOrderType(apiParams, printOutput, ServiceConstantsI.OrderType.ORDER_INSTALL.getOrderTypeValue());
			this.setPoints(apiParams, printOutput, (short)0);
			this.setProductLanguage(apiParams, printOutput, "1");
			this.setRateCode1(apiParams, printOutput, "PQ");
			this.setRateCodeVOaction(apiParams, printOutput, (short)2); // -1 = Inactive, no change = 0, change = 1, add = 2, remove = 3
			this.setReminderScheme(apiParams, printOutput, "A    "); 
			this.setSalesRepId(apiParams, printOutput, "100");
			this.setScheduleType(apiParams, printOutput, ServiceConstantsI.NO_TRUCK);
			this.setScheduleVOaction(apiParams, printOutput, (short)2); // 2 should mean add - javadoc needs updating
			this.setServiceGroup(apiParams, printOutput, 1);
			this.setServicePoint(apiParams, printOutput, 1);
			this.setServicePointLocationCode(apiParams, printOutput, "A1 "); // 99504 API Test location
			this.setServicePointVOaction(apiParams, printOutput, (short)2); // no change = 0, change = 1, add = 2, remove = 3
			this.setSiteId(apiParams, printOutput, "01000405"); 
			this.setStatementScheme(apiParams, printOutput, "A    ");
			this.setTaskCode(apiParams, printOutput, "APIINSTALL");
			break;
			
		case 2: // GET_AVAILABLE_PHONE_NUMBERS
		case 3: // Demo
			printOutput.printToShell (apiParams, "   GET_AVAILABLE_PHONE_NUMBERS Operation Initial Parameter Values",  null);
			this.setCust_acct(apiParams, printOutput, "40457701");
			this.setEquipmentId(apiParams, printOutput, null);
			this.setOrderGroupSeq(apiParams, printOutput, new BigDecimal(0));
			this.setPhoneClass(apiParams, printOutput, "4"); // PHONE_NUM_CLAS column from PHONE_NUMBER_INVENTORY
			this.setPhoneNumSearch(apiParams, printOutput, 1); // phoneNumSearch - PHONE_NUMBER_SEARCH column from PARAM_TELCO	
			this.setPhoneNumber(apiParams, printOutput, null);
			this.setSiteId(apiParams, printOutput, "00404577");
			break;

		case 4: // NEW_INSTALL
			printOutput.printToShell (apiParams, "   NEW_INSTALL Operation Initial Parameter Values",  null);
			this.setAccountCategory(apiParams, printOutput, ServiceConstantsI.AccountCategory.RESIDENTIAL.getAcctCatTypeValue());
			this.setAccountingArea(apiParams, printOutput, 1);
			this.setAcctPriceStructId(apiParams, printOutput, 0); // Zero is default Price Structure
			this.setBillDate(apiParams, printOutput, new Date(this.getSystemDate()));
			this.setBillForm(apiParams, printOutput, "S    ");
			this.setCampaignCode(apiParams, printOutput, null);
			this.setContractStatusOption(apiParams, printOutput, 1); // Contract status value. Valid values 1 - Active Contracts, 2 - Terminated Contracts, 4 - Expired contracts, 8 - Future effective contracts, 16 - Pending Termination contracts, 32 - Pending Addition contracts. For multiple contracts status' add the corresponding values.
			this.setContractTemplateId(apiParams, printOutput, 0); // Updated at runtime 
			this.setCust_acct(apiParams, printOutput, "0"); // must be 0 for new Account
			this.setCustClassCode(apiParams, printOutput, "REGSV");
			this.setDateOfBirth(apiParams, printOutput, new Date("6-mar-2000"));
			this.setCycle(apiParams, printOutput, 15);
			this.setEffectiveDate(apiParams, printOutput, new Date(this.getSystemDate()));
			this.setEffectiveDateFlag(apiParams, printOutput, 0); //This field is used only during COS order.Valid values are 1 - Add effective date before,2 - Add effective date after, 3 - Add with same effective date
			this.setHomePhone(apiParams, printOutput, this.generateRandomNumberString(10));
			this.setInstallType(apiParams, printOutput, ServiceConstantsI.OrderType.ORDER_INSTALL.getOrderTypeValue());
			this.setIsMustDo(apiParams, printOutput, false);
			this.setIsOffer(apiParams, printOutput, false);
			this.setIsProspect(apiParams, printOutput, false);
			this.setBlankOutFlag(apiParams, printOutput, (short)0);
			this.setJobType(apiParams, printOutput, ServiceConstantsI.JobType.JOBTYPE_INSTALL.getJobTypeValue());
			this.setLastName(apiParams, printOutput, this.generateRandomNumberString(5));
			this.setOrderGroupSeq(apiParams, printOutput, new BigDecimal(0));
			this.setOrderInfoVOaction(apiParams, printOutput, (short)1); // empty = -1, no change = 0, change = 1, add = 2, remove = 3
			this.setOrderType(apiParams, printOutput, ServiceConstantsI.OrderType.ORDER_INSTALL.getOrderTypeValue());
			this.setOverriddenRuleIds(apiParams, printOutput, "");
			this.setPackageCode(apiParams, printOutput, null); // Set at runtime
			this.setPendingContractIds(apiParams, printOutput, null); // Optional parameter not needed for new Install Order
			this.setPoints(apiParams, printOutput, (short)0);
			this.setProductLanguage(apiParams, printOutput, "1");
			this.setRateCode1(apiParams, printOutput, "ZZ");
                        
			this.setRateCodeVOaction(apiParams, printOutput, (short)2); // -1 = Inactive, no change = 0, change = 1, add = 2, remove = 3
			this.setReminderScheme(apiParams, printOutput, "A    "); 
			this.setSalesRepId(apiParams, printOutput, "0000001");
			this.setScheduleType(apiParams, printOutput, ServiceConstantsI.sc);
			this.setScheduleVOaction(apiParams, printOutput, (short)2); // 2 = Add
			this.setServiceGroup(apiParams, printOutput, 1);
			this.setServicePackage(apiParams, printOutput,""); // To be set at runtime eventually
			this.setServicePoint(apiParams, printOutput, 1); 
			this.setServicePointLocationCode(apiParams, printOutput, "API"); // API Test location
			this.setServicePointVOaction(apiParams, printOutput, (short)2); // no change = 0, change = 1, add = 2, remove = 3
			this.setSiteId(apiParams, printOutput, "00273801");
			this.setSpecialInstruct1Code(apiParams, printOutput, "5");
			this.setStatementScheme(apiParams, printOutput, "A    ");
			this.setTaskCode(apiParams, printOutput, "API");
			this.setTechId(apiParams, printOutput, "999");
			this.setTypeCode(apiParams, printOutput, "TEST");
			break;
			
		case 5: // SEND_DIRECT_HIT
			printOutput.printToShell (apiParams, "   SEND_DIRECT_HIT Operation Initial Parameter Values",  null);
			this.setEquipmentId(apiParams, printOutput, "  SETTOP023301"); // Equipment that is on an Account
			this.setOrderType(apiParams, printOutput, ServiceConstantsI.OrderType.ORDER_TROUBLE_CALL_NEW.getOrderTypeValue()); 
			break;
			
		case 6: // CANCEL_SRO
			printOutput.printToShell (apiParams, "   CANCEL_SRO Operation Initial Parameter Values",  null);
			//this.setCallerName(apiParams, printOutput, "API");
			//this.setCancelNpd(apiParams, printOutput, (short)0); // Default
			this.setCancelReason(apiParams, printOutput, "API");
			this.setCust_acct(apiParams, printOutput, "45465434");
			this.setJobType(apiParams, printOutput, ServiceConstantsI.JobType.JOBTYPE_SRO.getJobTypeValue());
			this.setOperatorId(apiParams, printOutput, "API");
			this.setOrderType(apiParams, printOutput, ServiceConstantsI.OrderType.ORDER_SRO_CANCEL.getOrderTypeValue());
			this.setQueueHsdsHitFlag(apiParams, printOutput, false);
			this.setSiteId(apiParams, printOutput, "01000345");
			break;
		
		case 7: // OPERATOR
			printOutput.printToShell (apiParams, "   OPERATOR Operation Initial Parameter Values",  null);
			this.setOperatorId(apiParams, printOutput, "JVH");
			this.setUser(apiParams, printOutput, "jvanhoof");
			break;
			
		case 8: // GET_TECH_JOBS
			printOutput.printToShell (apiParams, "   GET_TECH_JOBS Operation Initial Parameter Values",  null);
			this.setCust_acct(apiParams, printOutput, "45465434");
			this.setJobType(apiParams, printOutput, ServiceConstantsI.JobType.JOBTYPE_SRO.getJobTypeValue());
			this.setOfferNum(apiParams, printOutput, new BigDecimal(6026));
			this.setScheduleDate(apiParams, printOutput, new Date("30-dec-2013"));
			this.setSiteId(apiParams, printOutput, "00406180");
			this.setTechId(apiParams, printOutput, "107"); //ADDISON);
			break;
			
		case 9: // ASSIGN_EQUIP
			printOutput.printToShell (apiParams, "   ASSIGN_EQUIP Operation Initial Parameter Values",  null);
			this.setCallerName(apiParams, printOutput, "API");
			this.setCust_acct(apiParams, printOutput, "45466724");
			//                                          "12345678901234" 
			this.setEquipmentId(apiParams, printOutput, "  GABETST00003");
			this.setEquipmentLocation(apiParams, printOutput, "1    ");
			this.setEquipmentVOaction(apiParams, printOutput, (short)2); //Valid Values:no change = 0, change = 1, add = 2, remove = 3
			this.setIsFrontCounterMode(apiParams, printOutput, false);
			this.setOptionCode(apiParams, printOutput, ""); // To be set at runtime
			this.setOrderGroupSeq(apiParams, printOutput, new BigDecimal(0)); // Zero to get all Service Points
			this.setOrderType(apiParams, printOutput, ServiceConstantsI.OrderType.ORDER_CHANGE_BOX.getOrderTypeValue());
			this.setOutlet(apiParams, printOutput, 1);
			this.setServicePoint(apiParams, printOutput, 1);
			this.setOverriddenRuleIds(apiParams, printOutput, "");
			this.setPrevSerialNumber(apiParams, printOutput, ""); // Must blank out to make box_history record correct
			this.setServiceGroup(apiParams, printOutput, 1);
			this.setServicePointVOaction(apiParams, printOutput, (short)1); // valid values are :no change = 0, change = 1, add = 2, remove = 3
			this.setSiteId(apiParams, printOutput, "00405577");
			break;
			
		case 10: // CHANGE_UPGRADE_HOLD
			printOutput.printToShell (apiParams, "   CHANGE_UPGRADE_HOLD Operation Initial Parameter Values",  null);
			this.setCallerName(apiParams, printOutput, "API"); // Optional - value can be null
			this.setCancelNpd(apiParams, printOutput, (short)0);
			this.setCollStatAgencyCode(apiParams, printOutput, null); // set later in operation
			this.setCollStatCancelReason(apiParams, printOutput, null); // set later in operation
			this.setCollStatClass(apiParams, printOutput, (short)0); // set later in operation
			this.setCollStatClose(apiParams, printOutput, (short)0); // default
			this.setCollStatComments(apiParams, printOutput, "API CLIENT");
			this.setCollStatDate(apiParams, printOutput, AmspUtil.stringToDate("2014-04-17", "yyyy-MM-dd"));
			this.setCollStatPath(apiParams, printOutput, null); // set later in operation
			this.setCollStatPpvHold(apiParams, printOutput, false); // set later in operation
			this.setCollStatStep(apiParams, printOutput, null); // set later in operation
			this.setCust_acct(apiParams, printOutput, "45465726");
			this.setSiteId(apiParams, printOutput, "01000412");
			this.setUpgradeHold(apiParams, printOutput, false);
			this.setValidateOnlyFlg(apiParams, printOutput, (short)0);
			break;
			
		case 11: // CREATE_NEW_ENT_SALESMAN
			printOutput.printToShell (apiParams, "   CREATE_NEW_ENT_SALESMAN Operation Initial Parameter Values",  null);
			//         12345678901234567
			this.setComment(apiParams, printOutput, "API SalesM");
			this.setCorpSet("default_corpset"); // PARAM_CORPSET_DETAIL.CORPSET VARCHAR2 (40 BYTE)
			this.setInitial(apiParams, printOutput, "AL"); // CHAR(2)
			this.setLastName(apiParams, printOutput, "APILAST3");
			this.setSalesRepId(apiParams, printOutput, "APIID3"); // CHAR(6) Valid Values: 0-9, A-Z or a combination of both and up to 6 characters, but alone zero is not valid.
			this.setStatus(apiParams, printOutput, 1); // CHAR(1) Valid Values: 0 = Inactive 1 = Active 2 = Deleted.
			break;
			
		case 12: //UPDATE_ENT_SALESMAN
			printOutput.printToShell (apiParams, "   UPDATE_ENT_SALESMAN Operation Initial Parameter Values",  null);
			comment = "API 101";
			corpSetTarget = "ort2";
			salesRepId = "101"; // CHAR(6) Valid Values: 0-9, A-Z or a combination of both and up to 6 characters, but alone zero is not valid.
			status = 1; // CHAR(1) Valid Values: 0 = Inactive 1 = Active 2 = Deleted.
			printOutput.printToShell (apiParams, "Parameter:comment      : " + comment,       null);
			printOutput.printToShell (apiParams, "Parameter:corpsetTarget: " + corpSetTarget, null);
			printOutput.printToShell (apiParams, "Parameter:salesRepId   : " + salesRepId,    null);
			printOutput.printToShell (apiParams, "Parameter:status       : " + status,        null);
			break;
			
		case 13: //CREATE_SITE
			printOutput.printToShell (apiParams, "   CREATE_SITE Operation Initial Parameter Values",  null);
			
			addressType = ServiceConstantsI.AccountCategory.RESIDENTIAL.getAcctCatTypeValue();
			addressUse = AddressConstantsI.AddrUseContext.SERVICE_ADDRESS.getAddrUseContextValue();
			allowInvalidZip = 0; // valid values: 0 = false:validates the user input, 1= true: Allows whatever the user entered input
			callerName = "API"; // char(9) causes FML buffer error if too big
			corpSet[0] = this.getCorp();
			cust_acct = "0"; // must be zero to work
			duplicateAddressFlag = false;
			orderType = ServiceConstantsI.NO_TRUCK;
			plant = false;
			scheduleAction = ServiceConstantsI.NO_TRUCK;
			siteId   = "01000415"; // 99504 base site to be used in browse
			printOutput.printToShell (apiParams, "Parameter:addressType         : " + addressType,          null);
			printOutput.printToShell (apiParams, "Parameter:addressUse          : " + addressUse,           null);
			printOutput.printToShell (apiParams, "Parameter:allowInvalidZip     : " + allowInvalidZip,      null);
			printOutput.printToShell (apiParams, "Parameter:callerName          : " + callerName,           null);
			printOutput.printToShell (apiParams, "Parameter:corpSet[0]         : " + corpSet[0],          null);
			printOutput.printToShell (apiParams, "Parameter:Cust_acct           : " + cust_acct,            null);
			printOutput.printToShell (apiParams, "Parameter:duplicateAddressFlag: " + duplicateAddressFlag, null);
			printOutput.printToShell (apiParams, "Parameter:plant               : " + plant,                null);
			printOutput.printToShell (apiParams, "Parameter:siteId             : " + siteId,              null);
			break;
			
		case 14: // PROSPECT_OFFER_SITE
			printOutput.printToShell (apiParams, "   PROSPECT_OFFER_SITE Operation Initial Parameter Values",  null);
			addressType = ServiceConstantsI.AccountCategory.RESIDENTIAL.getAcctCatTypeValue();
			addressUse = AddressConstantsI.AddrUseContext.SERVICE_ADDRESS.getAddrUseContextValue();
			allowInvalidZip = 0; // valid values: 0 = false:validates the user input, 1= true: Allows whatever the user entered input
			callerName = "API"; // char(9) causes FML buffer error if too big
			corpSet[0] = this.getCorp();
			cust_acct = "0"; // must be zero to work
			duplicateAddressFlag = false;
			plant = false;
			siteId   = "01000415"; // base site to be used in browse
			printOutput.printToShell (apiParams, "Parameter:addressType         : " + addressType,          null);
			printOutput.printToShell (apiParams, "Parameter:addressUse          : " + addressUse,           null);
			printOutput.printToShell (apiParams, "Parameter:allowInvalidZip     : " + allowInvalidZip,      null);
			printOutput.printToShell (apiParams, "Parameter:callerName          : " + callerName,           null);
			printOutput.printToShell (apiParams, "Parameter:corpSet[0]         : " + corpSet[0],          null);
			printOutput.printToShell (apiParams, "Parameter:Cust_acct           : " + cust_acct,            null);
			printOutput.printToShell (apiParams, "Parameter:duplicateAddressFlag: " + duplicateAddressFlag, null);
			printOutput.printToShell (apiParams, "Parameter:plant               : " + plant,                null);
			
			billDate = new Date(this.getSystemDate());
			billForm = "S    "; // Valid Values: S = Statement, N = None (EFTS customer)
			// cust_acct = "0"; set above
			cycle = 28; // gets reset during operation
			installType = ServiceConstantsI.OrderType.ORDER_INSTALL.getOrderTypeValue();
			isOffer = true;
			jobType = ServiceConstantsI.JobType.JOBTYPE_INSTALL.getJobTypeValue();
			//          12345678901234567890
			lastName = "TESTING"; // char(20)
			orderInfoVOaction = 1; // empty = -1, no change = 0, change = 1, add = 2, remove = 3
			orderType = ServiceConstantsI.OrderType.ORDER_INSTALL.getOrderTypeValue();
			points = 0;
			productLanguage = "1";
			rateCode1  = "PQ";
			rateCodeVOaction = 2; // -1 = Inactive, no change = 0, change = 1, add = 2, remove = 3
			reminderScheme  = "A    "; // updated during operation
			salesRepId = "100";
			scheduleType = ServiceConstantsI.NO_TRUCK;
			scheduleVOaction = 2; // 2 should mean add - javadoc needs updating
			serviceGroup = 1;
			servicePoint = 1;
			servicePointLocationCode = "A1 "; // 99504 API Test location
			servicePointVOaction = 2; // no change = 0, change = 1, add = 2, remove = 3 
			// siteId = "01000405"; Gets set at runtime after new site created
			statementScheme = "A    ";
			taskCode = "APIINSTALL";
			printOutput.printToShell (apiParams, "Parameter:accountCategory         : " + accountCategory,          null);
			printOutput.printToShell (apiParams, "Parameter:billDate                : " + billDate,                 null);
			printOutput.printToShell (apiParams, "Parameter:billForm                : " + billForm,                 null);
			printOutput.printToShell (apiParams, "Parameter:cycle                   : " + cycle,                    null);
			printOutput.printToShell (apiParams, "Parameter:installType             : " + installType,              null);
			printOutput.printToShell (apiParams, "Parameter:isOffer                 : " + isOffer,                  null);
			printOutput.printToShell (apiParams, "Parameter:jobType                 : " + jobType,                  null);
			printOutput.printToShell (apiParams, "Parameter:lastName                : " + lastName,                 null);
			printOutput.printToShell (apiParams, "Parameter:orderInfoVOaction       : " + orderInfoVOaction,        null);
			printOutput.printToShell (apiParams, "Parameter:points                  : " + points,                   null);
			printOutput.printToShell (apiParams, "Parameter:productLanguage         : " + productLanguage,          null);
			printOutput.printToShell (apiParams, "Parameter:rateCode1               : " + rateCode1,                null);
			printOutput.printToShell (apiParams, "Parameter:rateCodeVOaction        : " + rateCodeVOaction,         null);
			printOutput.printToShell (apiParams, "Parameter:reminderScheme          : " + reminderScheme,           null);
			printOutput.printToShell (apiParams, "Parameter:salesRepId              : " + salesRepId,               null);
			printOutput.printToShell (apiParams, "Parameter:scheduleType            : " + scheduleType,             null);
			printOutput.printToShell (apiParams, "Parameter:scheduleVOaction        : " + scheduleVOaction,         null);
			printOutput.printToShell (apiParams, "Parameter:serviceGroup            : " + serviceGroup,             null);
			printOutput.printToShell (apiParams, "Parameter:servicePoint            : " + servicePoint,             null);
			printOutput.printToShell (apiParams, "Parameter:servicePointLocationCode: " + servicePointLocationCode, null);
			printOutput.printToShell (apiParams, "Parameter:servicePointVOaction    : " + servicePointVOaction,     null);
			printOutput.printToShell (apiParams, "Parameter:statementScheme         : " + statementScheme,          null);
			printOutput.printToShell (apiParams, "Parameter:taskCode                : " + taskCode,                 null);
			break;
			
		case 15: // UPDATE_CUST_DATA
			printOutput.printToShell (apiParams, "   UPDATE_CUST_DATA Operation Initial Parameter Values",  null);
			cust_acct                = "40460701";
			offerNum                 = new BigDecimal(0);
			otherPhone               = "API DATA2"; //char(20)
			orderGroupSeq            = new BigDecimal(0);
			orderType                = ServiceConstantsI.OrderType.ORDER_CUST_DATA.getOrderTypeValue();
			phoneNumberReplaceFlag   = false;
			siteId                   = "00404607";
			skipPayCard              = true;
			
			printOutput.printToShell (apiParams, "Parameter:cust_acct              : " + cust_acct,              null);
			printOutput.printToShell (apiParams, "Parameter:offerNum               : " + offerNum,               null);
			printOutput.printToShell (apiParams, "Parameter:orderGroupSeq          : " + orderGroupSeq,          null);
			printOutput.printToShell (apiParams, "Parameter:otherPhone             : " + otherPhone,             null);
			printOutput.printToShell (apiParams, "Parameter:phoneNumberReplaceFlag : " + phoneNumberReplaceFlag, null);
			printOutput.printToShell (apiParams, "Parameter:siteId                 : " + siteId,                 null);
			printOutput.printToShell (apiParams, "Parameter:skipPayCard            : " + skipPayCard,            null);
			
			break;
			
		case 16: // PROSPECT_OFFER_SITE_TOOL
			printOutput.printToToolShell (apiParams, "   PROSPECT_OFFER_SITE_TOOL Operation Initial Parameter Values");
			addressType = ServiceConstantsI.AccountCategory.RESIDENTIAL.getAcctCatTypeValue();
			addressUse = AddressConstantsI.AddrUseContext.SERVICE_ADDRESS.getAddrUseContextValue();
			allowInvalidZip = 0; // valid values: 0 = false:validates the user input, 1= true: Allows whatever the user entered input
			appVersion = "1.3";
			billDate = new Date(this.getSystemDate());
			billForm = "S    "; // Valid Values: S = Statement, N = None (EFTS customer)
			callerName = "API"; // char(9) causes FML buffer error if too big
			corpSet[0] = this.getCorp(); // can be changed by user at runtime
			cust_acct = "0"; // must be zero to work
			cycle = -1; // gets reset during operation
			duplicateAddressFlag = false;
			installType = ServiceConstantsI.OrderType.ORDER_INSTALL.getOrderTypeValue();
			isOffer = true;
			jobType = ServiceConstantsI.JobType.JOBTYPE_INSTALL.getJobTypeValue();
			//          12345678901234567890
			lastName = "TESTING"; // char(20)
			orderInfoVOaction = 1; // empty = -1, no change = 0, change = 1, add = 2, remove = 3
			orderType = ServiceConstantsI.OrderType.ORDER_INSTALL.getOrderTypeValue();
			outputMode = 3;
			plant = false;
			points = 0;
			productLanguage = "1";
			rateCode1  = "PQ";
			rateCodeVOaction = 2; // -1 = Inactive, no change = 0, change = 1, add = 2, remove = 3
			reminderScheme  = "A    "; // updated during operation
			salesRepId = "100";
			scheduleType = ServiceConstantsI.NO_SCHEDULE;
			scheduleVOaction = 2; // 2 should mean add - javadoc needs updating
			serviceGroup = 1;
			servicePoint = 1;
			servicePointLocationCode = "A1 "; // 99504 API Test location
			servicePointVOaction = 2; // no change = 0, change = 1, add = 2, remove = 3 
			siteId   = "01000415"; // base site to be used in browse for ORT 99504 - can be changed by user at runtime
			statementScheme = "A    ";
			
			printOutput.printToToolShell (apiParams, "   PROSPECT_OFFER_SITE_TOOL Operation Initial Parameter Values");
			printOutput.printToToolShell (apiParams, "Parameter:corpSet index 0        : " + corpSet[0]);
			printOutput.printToToolShell (apiParams, "Parameter:Password                : " + password);
			printOutput.printToToolShell (apiParams, "Parameter:outputMode              : " + outputMode);
			printOutput.printToToolShell (apiParams, "Parameter:User                    : " + user);
			printOutput.printToToolShell (apiParams, "");
			printOutput.printToToolShell (apiParams, "Parameter:addressType             : " + addressType);
			printOutput.printToToolShell (apiParams, "Parameter:addressUse              : " + addressUse);
			printOutput.printToToolShell (apiParams, "Parameter:allowInvalidZip         : " + allowInvalidZip);
			printOutput.printToToolShell (apiParams, "Parameter:callerName              : " + callerName);
			printOutput.printToToolShell (apiParams, "Parameter:billDate                : " + billDate);
			printOutput.printToToolShell (apiParams, "Parameter:billForm                : " + billForm);
			printOutput.printToToolShell (apiParams, "Parameter:corpSet[0]             : " + corpSet[0]);
			printOutput.printToToolShell (apiParams, "Parameter:Cust_acct               : " + cust_acct);
			printOutput.printToToolShell (apiParams, "Parameter:cycle                   : " + cycle);
			printOutput.printToToolShell (apiParams, "Parameter:duplicateAddressFlag    : " + duplicateAddressFlag);
			printOutput.printToToolShell (apiParams, "Parameter:installType             : " + installType);
			printOutput.printToToolShell (apiParams, "Parameter:isOffer                 : " + isOffer);
			printOutput.printToToolShell (apiParams, "Parameter:jobType                 : " + jobType);
			printOutput.printToToolShell (apiParams, "Parameter:lastName                : " + lastName);
			printOutput.printToToolShell (apiParams, "Parameter:orderInfoVOaction       : " + orderInfoVOaction);
			printOutput.printToToolShell (apiParams, "Parameter:plant                   : " + plant);
			printOutput.printToToolShell (apiParams, "Parameter:points                  : " + points);
			printOutput.printToToolShell (apiParams, "Parameter:productLanguage         : " + productLanguage);
			printOutput.printToToolShell (apiParams, "Parameter:rateCode1               : " + rateCode1);
			printOutput.printToToolShell (apiParams, "Parameter:rateCodeVOaction        : " + rateCodeVOaction);
			printOutput.printToToolShell (apiParams, "Parameter:reminderScheme          : " + reminderScheme);
			printOutput.printToToolShell (apiParams, "Parameter:salesRepId              : " + salesRepId);
			printOutput.printToToolShell (apiParams, "Parameter:scheduleType            : " + scheduleType);
			printOutput.printToToolShell (apiParams, "Parameter:scheduleVOaction        : " + scheduleVOaction);
			printOutput.printToToolShell (apiParams, "Parameter:serviceGroup            : " + serviceGroup);
			printOutput.printToToolShell (apiParams, "Parameter:servicePoint            : " + servicePoint);
			printOutput.printToToolShell (apiParams, "Parameter:servicePointLocationCode: " + servicePointLocationCode);
			printOutput.printToToolShell (apiParams, "Parameter:servicePointVOaction    : " + servicePointVOaction);
			printOutput.printToToolShell (apiParams, "Parameter:siteId (root)           : " + siteId);
			printOutput.printToToolShell (apiParams, "Parameter:statementScheme         : " + statementScheme);
			printOutput.printToToolShell (apiParams, "Parameter:taskCode                : " + taskCode);
			break;
			
		case 17: // UPDATE_ENTERPRISE_OPERATOR
			printOutput.printToShell (apiParams, "   UPDATE_ENTERPRISE_OPERATOR Operation Initial Parameter Values",  null);
			operatorId = "JVH";
			operatorStatus = "1";
			userName = "jvanhoof";
			//operatorId = "BOGUS";
			//userName = "bogus";
			printOutput.printToShell (apiParams, "Parameter:operatorId    : " + operatorId,     null);
			printOutput.printToShell (apiParams, "Parameter:operatorStatus: " + operatorStatus, null);
			printOutput.printToShell (apiParams, "Parameter:userName      : " + userName,       null);
			break;
		
		case 18: // PROSPECT_OFFER_SITE_DEMO
			printOutput.printToToolShell (apiParams, "   UPDATE_ENTERPRISE_OPERATOR Operation Initial Parameter Values");
			addressType = ServiceConstantsI.AccountCategory.RESIDENTIAL.getAcctCatTypeValue();
			addressUse = AddressConstantsI.AddrUseContext.SERVICE_ADDRESS.getAddrUseContextValue();
			allowInvalidZip = 0; // valid values: 0 = false:validates the user input, 1= true: Allows whatever the user entered input
			appVersion = "1.3";
			billDate = new Date(this.getSystemDate());
			billForm = "S    "; // Valid Values: S = Statement, N = None (EFTS customer)
			callerName = "API"; // char(9) causes FML buffer error if too big
			corpSet[0] = this.getCorp(); // can be changed by user at runtime
			cust_acct = "0"; // must be zero to work
			cycle = -1; // gets reset during operation
			duplicateAddressFlag = false;
			installType = ServiceConstantsI.OrderType.ORDER_INSTALL.getOrderTypeValue();
			isOffer = true;
			jobType = ServiceConstantsI.JobType.JOBTYPE_INSTALL.getJobTypeValue();
			//          12345678901234567890
			lastName = "TESTING"; // char(20)
			orderInfoVOaction = 1; // empty = -1, no change = 0, change = 1, add = 2, remove = 3
			orderType = ServiceConstantsI.OrderType.ORDER_INSTALL.getOrderTypeValue();
			outputMode = 3;
			plant = false;
			points = 0;
			productLanguage = "1";
			rateCode1  = "PQ";
			rateCodeVOaction = 2; // -1 = Inactive, no change = 0, change = 1, add = 2, remove = 3
			reminderScheme  = "A    "; // updated during operation
			salesRepId = "100";
			scheduleType = ServiceConstantsI.NO_SCHEDULE;
			scheduleVOaction = 2; // 2 should mean add - javadoc needs updating
			serviceGroup = 1;
			servicePoint = 1;
			servicePointLocationCode = "A1 "; // 99504 API Test location
			servicePointTarget = 1;
			servicePointVOaction = 2; // no change = 0, change = 1, add = 2, remove = 3 
			siteId   = "01000415"; // base site to be used in browse for ORT 99504 - can be changed by user at runtime
			statementScheme = "A    ";
			taskCode = "APIINSTALL";
	
			printOutput.printToToolShell (apiParams, "   PROSPECT_OFFER_SITE_DEMO Operation Initial Parameter Values");
			printOutput.printToToolShell (apiParams, "Parameter:corpSet index 0        : " + corpSet[0]);
			printOutput.printToToolShell (apiParams, "Parameter:Password                : " + password);
			printOutput.printToToolShell (apiParams, "Parameter:outputMode              : " + outputMode);
			printOutput.printToToolShell (apiParams, "Parameter:User                    : " + user);
			printOutput.printToToolShell (apiParams, "");
			printOutput.printToToolShell (apiParams, "Parameter:addressType             : " + addressType);
			printOutput.printToToolShell (apiParams, "Parameter:addressUse              : " + addressUse);
			printOutput.printToToolShell (apiParams, "Parameter:allowInvalidZip         : " + allowInvalidZip);
			printOutput.printToToolShell (apiParams, "Parameter:callerName              : " + callerName);
			printOutput.printToToolShell (apiParams, "Parameter:billDate                : " + billDate);
			printOutput.printToToolShell (apiParams, "Parameter:billForm                : " + billForm);
			printOutput.printToToolShell (apiParams, "Parameter:corpSet[0]             : " + corpSet[0]);
			printOutput.printToToolShell (apiParams, "Parameter:Cust_acct               : " + cust_acct);
			printOutput.printToToolShell (apiParams, "Parameter:cycle                   : " + cycle);
			printOutput.printToToolShell (apiParams, "Parameter:duplicateAddressFlag    : " + duplicateAddressFlag);
			printOutput.printToToolShell (apiParams, "Parameter:installType             : " + installType);
			printOutput.printToToolShell (apiParams, "Parameter:isOffer                 : " + isOffer);
			printOutput.printToToolShell (apiParams, "Parameter:jobType                 : " + jobType);
			printOutput.printToToolShell (apiParams, "Parameter:lastName                : " + lastName);
			printOutput.printToToolShell (apiParams, "Parameter:orderInfoVOaction       : " + orderInfoVOaction);
			printOutput.printToToolShell (apiParams, "Parameter:plant                   : " + plant);
			printOutput.printToToolShell (apiParams, "Parameter:points                  : " + points);
			printOutput.printToToolShell (apiParams, "Parameter:productLanguage         : " + productLanguage);
			printOutput.printToToolShell (apiParams, "Parameter:rateCode1               : " + rateCode1);
			printOutput.printToToolShell (apiParams, "Parameter:rateCodeVOaction        : " + rateCodeVOaction);
			printOutput.printToToolShell (apiParams, "Parameter:reminderScheme          : " + reminderScheme);
			printOutput.printToToolShell (apiParams, "Parameter:salesRepId              : " + salesRepId);
			printOutput.printToToolShell (apiParams, "Parameter:scheduleType            : " + scheduleType);
			printOutput.printToToolShell (apiParams, "Parameter:scheduleVOaction        : " + scheduleVOaction);
			printOutput.printToToolShell (apiParams, "Parameter:serviceGroup            : " + serviceGroup);
			printOutput.printToToolShell (apiParams, "Parameter:servicePoint            : " + servicePoint);
			printOutput.printToToolShell (apiParams, "Parameter:servicePointLocationCode: " + servicePointLocationCode);
			printOutput.printToToolShell (apiParams, "Parameter:servicePointTarget      : " + servicePointTarget);
			printOutput.printToToolShell (apiParams, "Parameter:servicePointVOaction    : " + servicePointVOaction);
			printOutput.printToToolShell (apiParams, "Parameter:siteId (root)           : " + siteId);
			printOutput.printToToolShell (apiParams, "Parameter:statementScheme         : " + statementScheme);
			printOutput.printToToolShell (apiParams, "Parameter:taskCode                : " + taskCode);
			break;
			
		case 19: // RE_ASSIGN_TECH_JOBS
			printOutput.printToShell (apiParams, "   RE_ASSIGN_TECH_JOBS Operation Initial Parameter Values",  null);
			cdwDate = new Date("24-sep-2014");
			fromTech = "100";
			toTech   = "102";
			printOutput.printToShell (apiParams, "Parameter:cdwDate : " + cdwDate,  null);
			printOutput.printToShell (apiParams, "Parameter:fromTech: " + fromTech, null);
			printOutput.printToShell (apiParams, "Parameter:toTech  : " + toTech,   null);
			break;
			
		case 20: // CHANGE_OF_SERVICE
			printOutput.printToShell (apiParams, "   CHANGE_OF_SERVICE Operation Initial Parameter Values",  null);
			billDate = new Date(this.getSystemDate());
			billForm = "S    "; // Valid Values: S = Statement, N = None (EFTS customer)
			callerName = "APIclient"; // char(9)
			codCode = "2";
			changeReason = "API";
			cust_acct = "40457701";
			//installType = ServiceConstantsI.OrderType.ORDER_CHANGE.getOrderTypeValue();
			installType = 1; // installType - New move in flag
			isMustDo = false;
			isProspect = false;
			jobType = ServiceConstantsI.JobType.JOBTYPE_COS.getJobTypeValue();
			orderGroupSeq = new BigDecimal(0); // Zero to get all Service Points
			orderInfoVOaction = 1; // empty = -1, no change = 0, change = 1, add = 2, remove = 3
			orderType = ServiceConstantsI.OrderType.ORDER_CHANGE.getOrderTypeValue();
			overriddenRuleIds[0] = "";
			overriddenRuleIds[1] = "";
			queueHsdsHitFlag = false;
			rateCode1  = "MN"; // Disney
			rateCode2  = "SK"; // Sky
			rateCodeVOaction = 2; // -1 = Inactive, no change = 0, change = 1, add = 2, remove = 3
			salesRepId = "100";
			scheduleDate = new Date(this.getSystemDate());
			scheduleType = ServiceConstantsI.NO_TRUCK;
			scheduleVOaction = 2; // 2 should mean add - javadoc needs updating
			servicePoint = 1;
			servicePointTarget = 2; // Service Point number to add to
			servicePointVOaction = 1; // no change = 0, change = 1, add = 2, remove = 3
			siteId   = "00404577";
			taskCode = "APIINSTALL";
			techId = "999";  // No Truck Tech
			
			printOutput.printToShell (apiParams, "   CHANGE_OF_SERVICE Operation Initial Parameter Values",          null);
			printOutput.printToShell (apiParams, "Parameter:billDate             : " + billDate,             null);
			printOutput.printToShell (apiParams, "Parameter:billForm             : " + billForm,             null);
			printOutput.printToShell (apiParams, "Parameter:callerName           : " + callerName,           null);
			printOutput.printToShell (apiParams, "Parameter:changeReason         : " + changeReason,         null);
			printOutput.printToShell (apiParams, "Parameter:codCode              : " + codCode,              null);
			printOutput.printToShell (apiParams, "Parameter:corp                 : " + corp,                 null);
			printOutput.printToShell (apiParams, "Parameter:cust_acct            : " + cust_acct,            null);
			printOutput.printToShell (apiParams, "Parameter:isMustDo             : " + isMustDo,             null);
			printOutput.printToShell (apiParams, "Parameter:isProspect        : " + isProspect,              null);
			printOutput.printToShell (apiParams, "Parameter:jobType              : " + jobType,              null);
			printOutput.printToShell (apiParams, "Parameter:orderGroupSeq        : " + orderGroupSeq,        null);
			printOutput.printToShell (apiParams, "Parameter:orderInfoVOaction    : " + orderInfoVOaction,    null);
			printOutput.printToShell (apiParams, "Parameter:orderType            : " + orderType,            null);
			printOutput.printToShell (apiParams, "Parameter:overriddenRuleIds    : " + "[0] " + overriddenRuleIds[0] + "[1] " + overriddenRuleIds[1], null);
			printOutput.printToShell (apiParams, "Parameter:queueHsdsHitFlag     : " + queueHsdsHitFlag,     null);
			printOutput.printToShell (apiParams, "Parameter:rateCode1            : " + rateCode1,            null);
			printOutput.printToShell (apiParams, "Parameter:rateCode2            : " + rateCode2,            null);
			printOutput.printToShell (apiParams, "Parameter:rateCodeVOaction     : " + rateCodeVOaction,     null);
			printOutput.printToShell (apiParams, "Parameter:salesRepId           : " + salesRepId,           null);
			printOutput.printToShell (apiParams, "Parameter:scheduleDate         : " + scheduleDate,         null);
			printOutput.printToShell (apiParams, "Parameter:scheduleType         : " + scheduleType,         null);
			printOutput.printToShell (apiParams, "Parameter:scheduleVOaction     : " + scheduleVOaction,     null);
			printOutput.printToShell (apiParams, "Parameter:servicePoint         : " + servicePoint,         null);
			printOutput.printToShell (apiParams, "Parameter:servicePointTarget   : " + servicePointTarget,   null);
			printOutput.printToShell (apiParams, "Parameter:servicePointVOaction : " + servicePointVOaction, null);
			printOutput.printToShell (apiParams, "Parameter:siteId               : " + siteId,               null);
			printOutput.printToShell (apiParams, "Parameter:taskCode             : " + taskCode,             null);
			printOutput.printToShell (apiParams, "Parameter:techId               : " + techId,               null);

			break;
			
		case 21: // CONSTRAINTS_DUMP
			printOutput.printToShell (apiParams, "   CONSTRAINTS_DUMP Operation Initial Parameter Values",  null);
			accountCategory = ServiceConstantsI.AccountCategory.RESIDENTIAL.getAcctCatTypeValue();
			cust_acct = "45465887"; // 99504
			orderType = ServiceConstantsI.OrderType.ORDER_INSTALL.getOrderTypeValue();
			scheduleType = ServiceConstantsI.NO_TRUCK;
			siteId   = "01000470";
			printOutput.printToShell (apiParams, "Parameter:accountCategory: " + accountCategory, null);
			printOutput.printToShell (apiParams, "Parameter:cust_acct      : " + cust_acct,       null);
			printOutput.printToShell (apiParams, "Parameter:orderType      : " + orderType,       null);
			printOutput.printToShell (apiParams, "Parameter:scheduleType   : " + scheduleType,    null);
			printOutput.printToShell (apiParams, "Parameter:siteId         : " + siteId,          null);
			
			break;
			
		case 22: // PAYCARD_INFO
			printOutput.printToShell (apiParams, "   PAYCARD_INFO Operation Initial Parameter Values",  null);
			cust_acct = "45465902"; // 99504
			orderType = ServiceConstantsI.OrderType.ORDER_INSTALL.getOrderTypeValue();
			skipPayCard = false;

			printOutput.printToShell (apiParams, "Parameter:cust_acc   : " + cust_acct,   null);
			printOutput.printToShell (apiParams, "Parameter:orderType  : " + orderType,   null);
			printOutput.printToShell (apiParams, "Parameter:skipPayCard: " + skipPayCard, null);
		
			break;
			
		case 23: // CHANGE_OF_SERVICE_2
			billDate = new Date(this.getSystemDate());
			billForm = "S    "; // Valid Values: S = Statement, N = None (EFTS customer)
			callerName = "APIclient"; // char(9)
			codCode = "2";
			corp = "99517";
			changeReason = "API"; 
			cust_acct = "45465986"; // 99517
			installType = 1; // installType - New move in flag
			isProspect = false;
			isMustDo = false;
			jobType = ServiceConstantsI.JobType.JOBTYPE_COS.getJobTypeValue();
			offerNum = new BigDecimal(0);
			orderGroupSeq = new BigDecimal(0); // Zero to get all Service Points
			orderInfoVOaction = 1; // empty = -1, no change = 0, change = 1, add = 2, remove = 3
			orderType = ServiceConstantsI.OrderType.ORDER_CHANGE.getOrderTypeValue();
			overriddenRuleIds[0] = "";
			overriddenRuleIds[1] = "";
			phoneVOaction = 1; // valid values:no change = 0, change = 1, add = 2, remove = 3
			queueHsdsHitFlag = false;
			rateCode1  = "LR"; // Rate Code being added
			//rateCode2  = "SK"; // Rate Code being added
			rateCodeVOaction = 2; // -1 = Inactive, no change = 0, change = 1, add = 2, remove = 3
			salesRepId = "100";
			scheduleDate = new Date(this.getSystemDate());
			scheduleType = ServiceConstantsI.NO_TRUCK;
			scheduleVOaction = 2; // 2 should mean add - javadoc needs updating
			servicePoint = 1;
			servicePointTarget = 1; // Service Point number to add new rate Code
			servicePointVOaction = 1; // no change = 0, change = 1, add = 2, remove = 3
			siteId   = "01000629"; // 99517
			taskCode = "APIINSTALL";
			techId = "999";  // No Truck Tech
			
			printOutput.printToShell (apiParams, "   CHANGE_OF_SERVICE_2 Operation Initial Parameter Values",        null);
			printOutput.printToShell (apiParams, "Parameter:billDate             : " + billDate,             null);
			printOutput.printToShell (apiParams, "Parameter:billForm             : " + billForm,             null);
			printOutput.printToShell (apiParams, "Parameter:callerName           : " + callerName,           null);
			printOutput.printToShell (apiParams, "Parameter:changeReason         : " + changeReason,         null);
			printOutput.printToShell (apiParams, "Parameter:codCode              : " + codCode,              null);
			printOutput.printToShell (apiParams, "Parameter:corp                 : " + corp,                 null);
			printOutput.printToShell (apiParams, "Parameter:cust_acct            : " + cust_acct,            null);
			printOutput.printToShell (apiParams, "Parameter:isMustDo             : " + isMustDo,             null);
			printOutput.printToShell (apiParams, "Parameter:isProspect           : " + isProspect,           null);
			printOutput.printToShell (apiParams, "Parameter:jobType              : " + jobType,              null);
			printOutput.printToShell (apiParams, "Parameter:Offernum             : " + offerNum,             null);
			printOutput.printToShell (apiParams, "Parameter:orderGroupSeq        : " + orderGroupSeq,        null);
			printOutput.printToShell (apiParams, "Parameter:orderInfoVOaction    : " + orderInfoVOaction,    null);
			printOutput.printToShell (apiParams, "Parameter:orderType            : " + orderType,            null);
			printOutput.printToShell (apiParams, "Parameter:overriddenRuleIds    : " + "[0] " + overriddenRuleIds[0] + "[1] " + overriddenRuleIds[1], null);
			printOutput.printToShell (apiParams, "Parameter:phoneVOaction        : " + phoneVOaction,        null);
			printOutput.printToShell (apiParams, "Parameter:queueHsdsHitFlag     : " + queueHsdsHitFlag,     null);
			printOutput.printToShell (apiParams, "Parameter:rateCode1            : " + rateCode1,            null);
			printOutput.printToShell (apiParams, "Parameter:rateCode2            : " + rateCode2,            null);
			printOutput.printToShell (apiParams, "Parameter:rateCodeVOaction     : " + rateCodeVOaction,     null);
			printOutput.printToShell (apiParams, "Parameter:salesRepId           : " + salesRepId,           null);
			printOutput.printToShell (apiParams, "Parameter:scheduleDate         : " + scheduleDate,         null);
			printOutput.printToShell (apiParams, "Parameter:scheduleType         : " + scheduleType,         null);
			printOutput.printToShell (apiParams, "Parameter:scheduleVOaction     : " + scheduleVOaction,     null);
			printOutput.printToShell (apiParams, "Parameter:servicePoint         : " + servicePoint,         null);
			printOutput.printToShell (apiParams, "Parameter:servicePointTarget   : " + servicePointTarget,   null);
			printOutput.printToShell (apiParams, "Parameter:servicePointVOaction : " + servicePointVOaction, null);
			printOutput.printToShell (apiParams, "Parameter:siteId               : " + siteId,               null);
			printOutput.printToShell (apiParams, "Parameter:taskCode             : " + taskCode,             null);
			printOutput.printToShell (apiParams, "Parameter:techId               : " + techId,               null);

			break;
			
		case 24: // RESCHEDULE_ORDER	
			billDate = new Date(this.getSystemDate());
			cancelReason = "API"; 
			corp = "99517";
			//cust_acct = "45465926"; // 99504
			//cust_acct = "45465983"; // 99517 Test 1
			//cust_acct = "45465985"; // 99517 Test 2
			cust_acct = "45466010"; // 99517 Test 2B
			isMustDo = false;
			jobType = ServiceConstantsI.JobType.JOBTYPE_COS.getJobTypeValue();
			//offernum = new BigDecimal(6609); // 99517 Test 1
			//offernum = new BigDecimal(6614); // 99517 Test 2
			offerNum = new BigDecimal(6673); // 99517 Test 2B
			orderGroupSeq = new BigDecimal(0); // Zero to get all Service Points
			orderInfoVOaction = 1; // empty = -1, no change = 0, change = 1, add = 2, remove = 3
			orderType = ServiceConstantsI.OrderType.ORDER_RESCHEDULE.getOrderTypeValue();
			overriddenRuleIds[0] = "";
			overriddenRuleIds[1] = "";
			queueHsdsHitFlag = false;
			//rateCode1  = "MM"; // 99517 Test 2
			rateCode1  = "TA"; // 99517 Test 2B
			//rateCode2  = "08"; 
			//rateCode3  = "QP"; 
			//rateCode4  = "SK"; 
			rateCodeVOaction = 0; // To be set in operation -1 = Inactive, no change = 0, change = 1, add = 2, remove = 3
			salesRepId = "100";
			scheduleDate = new Date(this.getSystemDate());
			scheduleType = ServiceConstantsI.NO_TRUCK;
			scheduleVOaction = 2; // 2 should mean add - CR submitted for javadoc update
			servicePoint = 1;
			servicePointTarget = 2; // Service Point number to make changes to
			servicePointVOaction = 1; // no change = 0, change = 1, add = 2, remove = 3
			//siteId   = "01000415"; // 99504
			//siteId   = "01000625"; // 99517 Test 1
			//siteId   = "01000627"; // 99517 Test 2
			siteId   = "01000645"; // 99517 Test 2B 
			skipServicePointData = false;
			taskCode = "APIINSTALL";
			techId = "999";  // No Truck Tech
			
			printOutput.printToShell (apiParams, "   RESCHEDULE_ORDER Operation Initial Parameter Values",        null);
			printOutput.printToShell (apiParams, "Parameter:billDate             : " + billDate,             null);
			printOutput.printToShell (apiParams, "Parameter:cancelReason         : " + cancelReason,         null);
			printOutput.printToShell (apiParams, "Parameter:corp                 : " + corp,                 null);
			printOutput.printToShell (apiParams, "Parameter:cust_acct            : " + cust_acct,            null);
			printOutput.printToShell (apiParams, "Parameter:isMustDo             : " + isMustDo,             null);
			printOutput.printToShell (apiParams, "Parameter:jobType              : " + jobType,              null);
			printOutput.printToShell (apiParams, "Parameter:Offernum             : " + offerNum,             null);
			printOutput.printToShell (apiParams, "Parameter:orderGroupSeq        : " + orderGroupSeq,        null);
			printOutput.printToShell (apiParams, "Parameter:orderInfoVOaction    : " + orderInfoVOaction,    null);
			printOutput.printToShell (apiParams, "Parameter:orderType            : " + orderType,            null);
			printOutput.printToShell (apiParams, "Parameter:overriddenRuleIds    : " + "[0] " + overriddenRuleIds[0] + "[1] " + overriddenRuleIds[1], null);
			printOutput.printToShell (apiParams, "Parameter:queueHsdsHitFlag     : " + queueHsdsHitFlag,     null);
			printOutput.printToShell (apiParams, "Parameter:rateCode1            : " + rateCode1,            null);
			printOutput.printToShell (apiParams, "Parameter:rateCode2            : " + rateCode2,            null);
			printOutput.printToShell (apiParams, "Parameter:rateCode3            : " + rateCode3,            null);
			printOutput.printToShell (apiParams, "Parameter:rateCode4            : " + rateCode4,            null);
			printOutput.printToShell (apiParams, "Parameter:rateCodeVOaction     : " + rateCodeVOaction,     null);
			printOutput.printToShell (apiParams, "Parameter:salesRepId           : " + salesRepId,           null);
			printOutput.printToShell (apiParams, "Parameter:scheduleDate         : " + scheduleDate,         null);
			printOutput.printToShell (apiParams, "Parameter:scheduleType         : " + scheduleType,         null);
			printOutput.printToShell (apiParams, "Parameter:scheduleVOaction     : " + scheduleVOaction,     null);
			printOutput.printToShell (apiParams, "Parameter:servicePoint         : " + servicePoint,         null);
			printOutput.printToShell (apiParams, "Parameter:servicePointTarget   : " + servicePointTarget,   null);
			printOutput.printToShell (apiParams, "Parameter:servicePointVOaction : " + servicePointVOaction, null);
			printOutput.printToShell (apiParams, "Parameter:siteId               : " + siteId,               null);
			printOutput.printToShell (apiParams, "Parameter:taskCode             : " + taskCode,             null);
			printOutput.printToShell (apiParams, "Parameter:techId               : " + techId,               null);

			break;
			
		case 25: // GET_TELEPHONY_SERVICES
			cust_acct = "45466493";
			siteId = "01000909";
			printOutput.printToShell (apiParams, "   GET_TELEPHONY_SERVICES Operation Initial Parameter Values",        null);
			printOutput.printToShell (apiParams, "Parameter:cust_acct            : " + cust_acct,            null);
			printOutput.printToShell (apiParams, "Parameter:siteId               : " + siteId,               null);
			
			break;
			
		case 26: // GET_ACCOUNT_SERVICE_POINTS	
			billDate = new Date(this.getSystemDate()); printOutput.printToShell (apiParams, "   GET_ACCOUNT_SERVICE_POINTS Operation Initial Parameter Values", null);
			corp = "99517";                            printOutput.printToShell (apiParams, "Parameter:corp                 : " + corp,                 null);
			cust_acct = "45466493";                    printOutput.printToShell (apiParams, "Parameter:cust_acct            : " + cust_acct,            null);
			offerNum = new BigDecimal(6617);           printOutput.printToShell (apiParams, "Parameter:Offernum             : " + offerNum,             null);
			orderGroupSeq = new BigDecimal(0);         printOutput.printToShell (apiParams, "Parameter:orderGroupSeq        : " + orderGroupSeq,        null);
			siteId   = "01000909";                     printOutput.printToShell (apiParams, "Parameter:siteId               : " + siteId,               null);
			
			break;
			
		case 27: // LOCKS	
			corp = "99517";                            printOutput.printToShell (apiParams, "Parameter:corp                 : " + corp,                 null);
			cust_acct = "45465986";                    printOutput.printToShell (apiParams, "Parameter:cust_acct            : " + cust_acct,            null);
			break;
			
		case 28: //UPDATE_ENT_TECHNICIAN
			printOutput.printToShell (apiParams, "   UPDATE_ENT_TECHNICIAN Operation Initial Parameter Values",  null);
			cdwDate = new Date(this.getSystemDate()); printOutput.printToShell (apiParams, "Parameter:cdwDate                 : " + cdwDate,                 null);
			comment = "API 101"; printOutput.printToShell (apiParams, "Parameter:comment                 : " + comment,                 null);
			corp = "99517"; printOutput.printToShell (apiParams, "Parameter:corp                 : " + corp,                 null);
			corpSetTarget = "ort2"; printOutput.printToShell (apiParams, "Parameter:corpsetTarget: " + corpSetTarget, null);
			printFileCode = "1"; printOutput.printToShell (apiParams, "printFileCode: " + printFileCode, null);
			skillLevel = "I"; printOutput.printToShell (apiParams, "skillLevel: " + skillLevel, null);
			techId = "102"; printOutput.printToShell (apiParams, "Parameter:techId   : " + techId,    null);
			break;
			
		case 29: // BROWSE_EQUIPMENT	
			printOutput.printToShell (apiParams, "   BROWSE_EQUIPMENT Operation Initial Parameter Values",  null);
			corp = "99517";                            printOutput.printToShell (apiParams, "Parameter:corp                 : " + corp,                 null);
			cust_acct = "45465962";                    printOutput.printToShell (apiParams, "Parameter:cust_acct            : " + cust_acct,            null);
			equipmentId = "  APITESTING01";            printOutput.printToShell (apiParams, "Parameter:equipmentId          : " + equipmentId,          null);
			break;
			
		case 30: // REMOVE_EQUIP
			user = "jvanhoof";
			password = "7913Jv48";
			printOutput.printToShell (apiParams, "Changed valid user and valid password to " + user + " " + password, null);
			printOutput.printToShell (apiParams, "Removed Order Processing Change Converter permissions", null);
			printOutput.printToShell (apiParams, " ", null);
			printOutput.printToShell (apiParams, "   REMOVE_EQUIP Operation Parameter Values",  null);
			callerName = "API"; // char(9) causes FML buffer error if too big
			cust_acct = "45465960";
			//            |12345678901234|;
			equipmentId = "  APITESTING01";
			equipmentLocation = "JVH "; // 99504 API Test location
			equipmentVOaction = 3; //Valid Values:no change = 0, change = 1, add = 2, remove = 3
			isFrontCounterMode = false;
			orderGroupSeq = new BigDecimal(0); // Zero to get all Service Points
			orderType = ServiceConstantsI.OrderType.ORDER_CHANGE.getOrderTypeValue();
			outlet = 1;
			overriddenRuleIds[0] = "";
			overriddenRuleIds[1] = "";
			serialNumber = null; // set during operation
			serviceGroup = 1;
			servicePoint = 1; // not sure why validateSerialNumber needs this...
			servicePointEquipRemoval = true;
			servicePointVOaction = 1; // valid values are :no change = 0, change = 1, add = 2, remove = 3
			siteId   = "01000415";
			//siteId   = "01000412";
			printOutput.printToShell (apiParams, "Parameter:callerName              : " + callerName,               null);
			printOutput.printToShell (apiParams, "Parameter:Cust_acct               : " + cust_acct,                null);
			printOutput.printToShell (apiParams, "Parameter:equipmentId             : " + equipmentId,              null);
			printOutput.printToShell (apiParams, "Parameter:equipmentLocation       : " + equipmentLocation,        null);
			printOutput.printToShell (apiParams, "Parameter:equipmentVOaction       : " + equipmentVOaction,        null);
			printOutput.printToShell (apiParams, "Parameter:isFrontCounterMode      : " + isFrontCounterMode,       null);
			printOutput.printToShell (apiParams, "Parameter:orderGroupSeq           : " + orderGroupSeq,            null);
			printOutput.printToShell (apiParams, "Parameter:orderType               : " + orderType,                null);
			printOutput.printToShell (apiParams, "Parameter:outlet                  : " + outlet,                   null);
			printOutput.printToShell (apiParams, "Parameter:overriddenRuleIds       : " + "[0] " + overriddenRuleIds[0] + "[1] " + overriddenRuleIds[1], null);
			printOutput.printToShell (apiParams, "Parameter:serialNumber            : " + serialNumber,             null);
			printOutput.printToShell (apiParams, "Parameter:serviceGroup            : " + serviceGroup,             null);
			printOutput.printToShell (apiParams, "Parameter:servicePoint            : " + servicePoint,             null);
			printOutput.printToShell (apiParams, "Parameter:servicePointEquipRemoval: " + servicePointEquipRemoval, null);
			printOutput.printToShell (apiParams, "Parameter:servicePointVOaction    : " + servicePointVOaction,     null);
			printOutput.printToShell (apiParams, "Parameter:siteId                  : " + siteId,                   null);
			break;
		
		case 31: // GET_EQUIPMENT_DETAILS
			//            "12345678901234"
			equipmentId = "     FMTC/0007";
			printOutput.printToShell (apiParams, "   GET_EQUIPMENT_DETAILS Operation Initial Parameter Values", null);
			printOutput.printToShell (apiParams, "Parameter:equipmentId : " + equipmentId, null);
		break;
		
		case 32: // COMPLETE_COS_JOB
			printOutput.printToShell (apiParams, "   COMPLETE_COS_JOB Operation Parameter Values",  null);
			cust_acct = "45465989"; //10000085
			siteId   = "01000415"; //01000022
			techId = "110";
			orderGroupSeq = new BigDecimal(0); // Zero to get all Service Points
			cdwDate = new Date("26-mar-2015");
			beginDateTime = new Date(this.getSystemDate());
			checkinAlert = ""; // Valid Values: 1 or blank.
			completeDate = new Date(this.getSystemDate());
			completeTime = new Date(this.getSystemDate());
			dMoney = new Money(0.0);
			dSeq = "3A"; // char(3) Sequence of this job in the total work assigned to the technician. DSEQ column from WIPMASTER table.
			reasonCode = "API"; // Not done or alert reason code from code 95 table with tabl as 212. Valid Values: 0 - ZZZZZZZZZZ
			orderComment = "API Comment";
			orderType = ServiceConstantsI.OrderType.ORDER_CHANGE.getOrderTypeValue(); // This value does not seem to mater in this context
			tag = "";
			overriddenRuleIds[0] = "";
			overriddenRuleIds[1] = "";
			
			printOutput.printToShell (apiParams, "cust_acct        : " + cust_acct,              null);
			printOutput.printToShell (apiParams, "siteId           : " + siteId,              null);
			printOutput.printToShell (apiParams, "techId           : " + techId,              null);
			printOutput.printToShell (apiParams, "orderGroupSeq    : " + orderGroupSeq,              null);
			printOutput.printToShell (apiParams, "cdwDate          : " + cdwDate,                 null);
			printOutput.printToShell (apiParams, "beginDateTime    : " + beginDateTime,                 null);
			printOutput.printToShell (apiParams, "checkinAlert     : " + checkinAlert,                 null);
			printOutput.printToShell (apiParams, "completeDate     : " + completeDate,                 null);
			printOutput.printToShell (apiParams, "completeTime     : " + completeTime,                 null);
			printOutput.printToShell (apiParams, "dMoney           : " + dMoney,                 null);
			printOutput.printToShell (apiParams, "dSeq             : " + dSeq,                 null);
			printOutput.printToShell (apiParams, "reasonCode       : " + reasonCode,                 null);
			printOutput.printToShell (apiParams, "orderComment     : " + orderComment,                 null);
			printOutput.printToShell (apiParams, "orderType        : " + orderType,                 null);
			printOutput.printToShell (apiParams, "tag              : " + tag,                 null);
			printOutput.printToShell (apiParams, "overriddenRuleIds: " + "[0] " + overriddenRuleIds[0] + "[1] " + overriddenRuleIds[1], null);
			break;
			
		case 33: // NOT_DONE_ALERT_STATUS
			printOutput.printToShell (apiParams, "   NOT_DONE_ALERT_STATUS Operation Parameter Values",  null);
			techId = "110";
			cdwDate = new Date("26-mar-2015");
			statusCode = 3;    // Job status code. Valid Values: 2 = Not done, 3 = Alert. Used in DispatchJobsFacade.notDoneAlertStatus()
			changeTime = new Date(this.getSystemDate());
			reasonCode = "API"; // Not done or alert reason code from code 95 table with tabl as 212. Valid Values: 0 - ZZZZZZZZZZ
			comment = "API Comment";
			checkinAlert = ""; // Valid Values: 1 or blank.
			dSeq = "1A"; // char(3) Sequence of this job in the total work assigned to the technician. DSEQ column from WIPMASTER table.

			printOutput.printToShell (apiParams, "techId           : " + techId,              null);
			printOutput.printToShell (apiParams, "cdwDate          : " + cdwDate,                 null);
			printOutput.printToShell (apiParams, "statusCode              : " + statusCode,                 null);
			printOutput.printToShell (apiParams, "changeTime              : " + changeTime,                 null);
			printOutput.printToShell (apiParams, "reasonCode    : " + reasonCode,                 null);
			printOutput.printToShell (apiParams, "comment    : " + comment,                 null);
			printOutput.printToShell (apiParams, "checkinAlert     : " + checkinAlert,                 null);
			printOutput.printToShell (apiParams, "dSeq             : " + dSeq,                 null);
			break;
			
		case 34: // GET_CODE_TABLE
			printOutput.printToShell (apiParams, "   GET_CODE_TABLE Operation Parameter Values",  null);
			equipmentId =   "     FMTC/0007";
			
			printOutput.printToShell (apiParams, "Parameter:equipmentId             : " + equipmentId,              null);
			break;
			
		case 35: // RESCHEDULE_COS_DATES_ONLY:
			billDate = null; // gets set at runtime
			cancelReason = "API"; 
			corp = "99504";
			cust_acct = "45465926"; // COS & SRO
			isMustDo = false; // true should force the reschedule when quota is full
			jobType = ServiceConstantsI.JobType.JOBTYPE_COS.getJobTypeValue(); // This needs to match the kind of job type of the target job
			offerNum = new BigDecimal(0); // gets set at runtime
			orderGroupSeq = new BigDecimal(0); // gets set at runtime
			orderInfoVOaction = 1; // empty = -1, no change = 0, change = 1, add = 2, remove = 3
			orderType = ServiceConstantsI.OrderType.ORDER_RESCHEDULE_DATES_ONLY.getOrderTypeValue(); // value = 5011
			overriddenRuleIds[0] = "";
			overriddenRuleIds[1] = "";
			queueHsdsHitFlag = false;
			//scheduleDate = formatDate(20, 11, 2015);
			scheduleType = ServiceConstantsI.SCHEDULE;
			scheduleVOaction = 1; 
			servicePointVOaction = 0; // no change = 0, change = 1, add = 2, remove = 3
			siteId = "01000415"; // COS &SRO
			skipServicePointData = false;
			
			printOutput.printToShell (apiParams, "   RESCHEDULE_COS_DATES_ONLY Operation Parameter Values",  null);
			printOutput.printToShell (apiParams, "Parameter:cancelReason         : " + cancelReason,         null);
			printOutput.printToShell (apiParams, "Parameter:corp                 : " + corp,                 null);
			printOutput.printToShell (apiParams, "Parameter:cust_acct            : " + cust_acct,            null);
			printOutput.printToShell (apiParams, "Parameter:isMustDo             : " + isMustDo,             null);
			printOutput.printToShell (apiParams, "Parameter:offerNum             : " + offerNum,             null);
			printOutput.printToShell (apiParams, "Parameter:jobType              : " + jobType,              null);
			printOutput.printToShell (apiParams, "Parameter:orderGroupSeq        : " + orderGroupSeq,        null);
			printOutput.printToShell (apiParams, "Parameter:orderInfoVOaction    : " + orderInfoVOaction,    null);
			printOutput.printToShell (apiParams, "Parameter:orderType            : " + orderType,            null);
			printOutput.printToShell (apiParams, "Parameter:overriddenRuleIds    : " + "[0] " + overriddenRuleIds[0] + "[1] " + overriddenRuleIds[1], null);
			printOutput.printToShell (apiParams, "Parameter:queueHsdsHitFlag     : " + queueHsdsHitFlag,     null);
			printOutput.printToShell (apiParams, "Parameter:scheduleDate         : " + scheduleDate,         null);
			printOutput.printToShell (apiParams, "Parameter:scheduleType         : " + scheduleType,         null);
			printOutput.printToShell (apiParams, "Parameter:scheduleVOaction     : " + scheduleVOaction,     null);
			printOutput.printToShell (apiParams, "Parameter:servicePointVOaction : " + servicePointVOaction, null);
			printOutput.printToShell (apiParams, "Parameter:siteId               : " + siteId,               null);
			printOutput.printToShell (apiParams, "Parameter:skipServicePointData : " + skipServicePointData, null);

			break;
			
		case 36: // RESCHEDULE_SRO:
			billDate = null; // gets set at runtime
			callerName = "JVH"; // Attention LinkNet
			cancelReason = "API"; 
			corp = "99504";
			//cust_acct = "45465926"; // COS & SRO
			cust_acct = "10000085"; // 2nd account
			isMustDo = false; // true should force the reschedule when quota is full
			//jobType = ServiceConstantsI.JobType.JOBTYPE_COS.getJobTypeValue(); // This needs to match the kind of job type of the target job
			jobType = ServiceConstantsI.JobType.JOBTYPE_SRO.getJobTypeValue();
			offerNum = new BigDecimal(0); // gets set at runtime
			orderGroupSeq = new BigDecimal(0); // gets set at runtime
			orderInfoVOaction = 1; // empty = -1, no change = 0, change = 1, add = 2, remove = 3
			orderType = ServiceConstantsI.OrderType.ORDER_SRO_RESCHEDULE.getOrderTypeValue();  // value = 7
			overriddenRuleIds[0] = "";
			//scheduleDate = formatDate(24, 11, 2015);
			scheduleType = ServiceConstantsI.SCHEDULE;
			scheduleVOaction = 1; 
			servicePointVOaction = 1; // no change = 0, change = 1, add = 2, remove = 3
			// siteId = "01000415"; // COS & SRO
			siteId = "01000022"; // 2nd account
			skipServicePointData = false;
			
			printOutput.printToShell (apiParams, "   RESCHEDULE_SRO Operation Parameter Values",  null);
			printOutput.printToShell (apiParams, "Parameter:callerName           : " + callerName,           null); // added 11/24 for money transaction call
			printOutput.printToShell (apiParams, "Parameter:cancelReason         : " + cancelReason,         null);
			printOutput.printToShell (apiParams, "Parameter:corp                 : " + corp,                 null);
			printOutput.printToShell (apiParams, "Parameter:cust_acct            : " + cust_acct,            null);
			printOutput.printToShell (apiParams, "Parameter:isMustDo             : " + isMustDo,             null);
			printOutput.printToShell (apiParams, "Parameter:offerNum             : " + offerNum,             null);
			printOutput.printToShell (apiParams, "Parameter:jobType              : " + jobType,              null);
			printOutput.printToShell (apiParams, "Parameter:orderGroupSeq        : " + orderGroupSeq,        null);
			printOutput.printToShell (apiParams, "Parameter:orderInfoVOaction    : " + orderInfoVOaction,    null);
			printOutput.printToShell (apiParams, "Parameter:orderType            : " + orderType,            null);
			printOutput.printToShell (apiParams, "Parameter:scheduleDate         : " + scheduleDate,         null);
			printOutput.printToShell (apiParams, "Parameter:scheduleType         : " + scheduleType,         null);
			printOutput.printToShell (apiParams, "Parameter:scheduleVOaction     : " + scheduleVOaction,     null);
			printOutput.printToShell (apiParams, "Parameter:servicePointVOaction : " + servicePointVOaction, null);
			printOutput.printToShell (apiParams, "Parameter:siteId               : " + siteId,               null);
			printOutput.printToShell (apiParams, "Parameter:skipServicePointData : " + skipServicePointData, null);

			break;
			
		case 37: // COMPLETE_SRO_JOB
			beginDateTime = new Date(this.getSystemDate());
			cdwDate = new Date("3-dec-2015");			
			checkinAlert = ""; // Valid Values: 1 or blank.			
			completeDate = new Date(this.getSystemDate());			
			completeTime = new Date(this.getSystemDate());			
			cust_acct = "45465553";			
			customPointsAllowed = false;			
			dSeq = "2"; // char(3) Sequence of this job in the total work assigned to the technician. DSEQ column from WIPMASTER table.
			jobType = ServiceConstantsI.JobType.JOBTYPE_SRO.getJobTypeValue(); // Value = 8
			offerNum = new BigDecimal(7027);
			optionId = ServiceConstantsI.WipOrderType.WIP_ORDER_TYPE_SRO.getWipOrderTypeValue();
			orderComment = "API Comment";
			orderGroupSeq = new BigDecimal(0); // Zero to get all Service Points	
			overriddenRuleIds[0] = "";
			overriddenRuleIds[1] = "";			
			servicePoint = 1;			
			servicePointVOaction = 1; // no change = 0, change = 1, add = 2, remove = 3
			siteId = "00107333";			
			sroFixCode = null; // set at runtime			
			sroFixDesc = null; // set at runtime			
			tag = "";			
			techId = "110";						
			
			printOutput.printToShell (apiParams, "   COMPLETE_SRO_JOB Operation Parameter Values",  null);
			printOutput.printToShell (apiParams, "beginDateTime       : " + beginDateTime,          null);
			printOutput.printToShell (apiParams, "cdwDate             : " + cdwDate,                null);
			printOutput.printToShell (apiParams, "checkinAlert        : " + checkinAlert,           null);
			printOutput.printToShell (apiParams, "completeDate        : " + completeDate,           null);
			printOutput.printToShell (apiParams, "completeTime        : " + completeTime,           null);
			printOutput.printToShell (apiParams, "cust_acct           : " + cust_acct,              null);
			printOutput.printToShell (apiParams, "customPointsAllowed : " + customPointsAllowed,    null);
			printOutput.printToShell (apiParams, "dSeq                : " + dSeq,                   null);
			printOutput.printToShell (apiParams, "Parameter:jobType   : " + jobType,                null);
			printOutput.printToShell (apiParams, "offerNum            : " + offerNum,               null);			
			printOutput.printToShell (apiParams, "optionId            : " + optionId,               null);
			printOutput.printToShell (apiParams, "orderComment        : " + orderComment,           null);
			printOutput.printToShell (apiParams, "orderGroupSeq       : " + orderGroupSeq,          null);
			printOutput.printToShell (apiParams, "overriddenRuleIds   : " + "[0] " + overriddenRuleIds[0] + "[1] " + overriddenRuleIds[1], null);
			printOutput.printToShell (apiParams, "servicePoint        : " + servicePoint,           null);
			printOutput.printToShell (apiParams, "servicePointVOaction: " + servicePointVOaction  , null);
			printOutput.printToShell (apiParams, "siteId              : " + siteId,                 null);
			printOutput.printToShell (apiParams, "sroFixCode          : " + sroFixCode,             null);
			printOutput.printToShell (apiParams, "sroFixDesc          : " + sroFixDesc,             null);
			printOutput.printToShell (apiParams, "tag                 : " + tag,                    null);
			printOutput.printToShell (apiParams, "techId              : " + techId,                 null);
			
			break;
			
			case 38: // PAYMENTS	
			printOutput.printToShell (apiParams, "   PAYMENTS Operation Initial Parameter Values", null);
			aging = "0"; // Aging to which adjustment should be applied.Valid Values: 0 = Current, 1 = 30 day, 2 = 60 day, 3 = 90 day, 4 = 120 day
			printOutput.printToShell (apiParams, "Parameter:aging             : " + aging, null);
			amount = new Money(0.00);
			printOutput.printToShell (apiParams, "Parameter:amount            : " + amount, null);
			amountTendered = new Money(0.00);
			printOutput.printToShell (apiParams, "Parameter:amountTendered    : " + amountTendered, null);
			batchClose = 0; // Close an exiting batch. Valid Values : 0,1.
			printOutput.printToShell (apiParams, "Parameter:batchClose        : " + batchClose, null);
			batchContinue = 0; // Continue an existing batch. Valid Values: 0,1
			printOutput.printToShell (apiParams, "Parameter:batchContinue     : " + batchContinue, null);
			batchCtrlgroup = "APIPY";
			printOutput.printToShell (apiParams, "Parameter:batchCtrlgroup    : " + batchCtrlgroup, null);
			batchDone= 0; //Valid Values 0,1.
			printOutput.printToShell (apiParams, "Parameter:batchDone         : " + batchDone, null);
			batchNew = 1; //New batch to open. Valid Values : 0,1(open a new batch) .
			printOutput.printToShell (apiParams, "Parameter:batchNew          : " + batchNew, null);
			batchNumber = 0; // Batch Number. Valid Values: 1-9999 .
			printOutput.printToShell (apiParams, "Parameter:batchNumber       : " + batchNumber, null);
			batchNumberTarget = 9290; // Batch Number. Valid Values: 1-9999 .
			printOutput.printToShell (apiParams, "Parameter:batchNumberTarget : " + batchNumberTarget, null);
			batchStatus = "3"; // Current status of the batch. Valid Values: Blank=Closed,3= Open/Busy
			printOutput.printToShell (apiParams, "Parameter:batchStatus       : " + batchStatus, null);
			batchType = "P"; // Batch Type. Valid Values: P = Payment and A = Adjustment.
			printOutput.printToShell (apiParams, "Parameter:batchType         : " + batchType, null);
			callerName = "API";
			printOutput.printToShell (apiParams, "Parameter:callerName        : " + callerName, null);
			cust_acct = "45466342"; // 99517                
			printOutput.printToShell (apiParams, "Parameter:cust_acct         : " + cust_acct, null);
			cust_acct2 = "45466037"; // 99517           
			printOutput.printToShell (apiParams, "Parameter:cust_acct2        : " + cust_acct2, null);
			isEcheck = false;
			printOutput.printToShell (apiParams, "Parameter:isEcheck          : " + isEcheck, null);
			isFrontCounterMode = false;
			printOutput.printToShell (apiParams, "Parameter:isFrontCounterMode: " + isFrontCounterMode, null);
			isPayCard = false;
			printOutput.printToShell (apiParams, "Parameter:isPayCard         : " + isPayCard, null);
			isPayment = true;
			printOutput.printToShell (apiParams, "Parameter:isPayment         : " + isPayment, null);
			paymentKind = "32";
			printOutput.printToShell (apiParams, "Parameter:paymentKind       : " + paymentKind, null);
			reason = "01";
			printOutput.printToShell (apiParams, "Parameter:reason            : " + reason, null);
			refrenceNumber = "12345678901234567890";
			printOutput.printToShell (apiParams, "Parameter:refrenceNumber    : " + refrenceNumber, null);
			serviceGroup = 1;
			printOutput.printToShell (apiParams, "Parameter:serviceGroup      : " + serviceGroup, null);
			siteId   = null;                     
			printOutput.printToShell (apiParams, "Parameter:siteId            : " + siteId,               null);
		break;
			
		case 39: // LOGIN - Handled in init method
			
		break;
		
		case 40: // STAY_ALIVE
			printOutput.printToShell (apiParams, "   STAY_ALIVE Operation Initial Parameter Values", null);
		break;
		
		
		case 41: // BROWSE_BY_ADDRESS
			printOutput.printToShell (apiParams, "   BROWSE_BY_ADDRESS Operation Initial Parameter Values", null);
			
			this.setAddressType(apiParams, printOutput, ServiceConstantsI.AccountCategory.RESIDENTIAL.getAcctCatTypeValue());
			this.setCorpSetList(apiParams, printOutput, 0, "99956");
			this.setPlant(apiParams, printOutput, false);
			
		break;
		
		case 42: // MOVE_EQUIP_OTHER_SP
			printOutput.printToShell (apiParams, "   MOVE_EQUIP_OTHER_SP Operation Initial Parameter Values",  null);
			callerName = "API"; // char(9) causes FML buffer error if too big
			cust_acct = "45465726";
			//            |12345678901234|
			equipmentId = "    FMT7BOB111"; // Equipment that is on target Account
			equipmentLocation = "JVH "; // 99504 API Test location
			equipmentVOaction = Parameters.EQUIPMENT_VO_ACTION_REMOVE; //Valid Values:no change = 0, change = 1, add = 2, remove = 3
			isFrontCounterMode = false;
			orderGroupSeq = new BigDecimal(0); // Zero to get all Service Points
			orderType = ServiceConstantsI.OrderType.ORDER_CHANGE.getOrderTypeValue();
			outlet = 2;		// SP the equipment to remove is currently on
			outletTarget = 1; // SP to move the same equipment to
			overriddenRuleIds[0] = "";
			overriddenRuleIds[1] = "";
			prevSerialNumber = ""; // Must blank out to make box_history record correct
			serialNumber = null; // set during operation
			serviceGroup = 1;
			servicePointEquipRemoval = true;
			servicePointVOaction = Parameters.SERVICE_POINT_VO_ACTION_CHANGE; // valid values are :no change = 0, change = 1, add = 2, remove = 3
			siteId   = "01000412";
			printOutput.printToShell (apiParams, "Parameter:callerName              : " + callerName,           null);
			printOutput.printToShell (apiParams, "Parameter:Cust_acct               : " + cust_acct,            null);
			printOutput.printToShell (apiParams, "Parameter:equipmentId             : " + equipmentId,          null);
			printOutput.printToShell (apiParams, "Parameter:equipmentLocation       : " + equipmentLocation,    null);
			printOutput.printToShell (apiParams, "Parameter:equipmentVOaction       : " + equipmentVOaction,    null);
			printOutput.printToShell (apiParams, "Parameter:isFrontCounterMode      : " + isFrontCounterMode,   null);
			printOutput.printToShell (apiParams, "Parameter:orderGroupSeq           : " + orderGroupSeq,        null);
			printOutput.printToShell (apiParams, "Parameter:orderType               : " + orderType,            null);
			printOutput.printToShell (apiParams, "Parameter:outlet                  : " + outlet,               null);
			printOutput.printToShell (apiParams, "Parameter:outletTarget            : " + outletTarget,         null);
			printOutput.printToShell (apiParams, "Parameter:overriddenRuleIds       : " + "[0] " + overriddenRuleIds[0] + "[1] " + overriddenRuleIds[1], null);
			printOutput.printToShell (apiParams, "Parameter:serialNumber            : " + serialNumber,         null);
			printOutput.printToShell (apiParams, "Parameter:prevSerialNumber        : " + prevSerialNumber,     null);
			printOutput.printToShell (apiParams, "Parameter:serviceGroup            : " + serviceGroup,         null);
			printOutput.printToShell (apiParams, "Parameter:servicePointEquipRemoval: " + servicePointEquipRemoval, null);
			printOutput.printToShell (apiParams, "Parameter:servicePointVOaction    : " + servicePointVOaction, null);
			printOutput.printToShell (apiParams, "Parameter:siteId                  : " + siteId,               null);
			
		break;
		
		case 43: // GET_PREDICTED_ENDING_BALANCE
			
			cust_acct = "45466461";
			siteId = "00107333";

			printOutput.printToShell (apiParams, "   GET_PREDICTED_ENDING_BALANCE Parameter Values",  null);
			printOutput.printToShell (apiParams, "Parameter:Cust_acct     : " + cust_acct,       null);
			printOutput.printToShell (apiParams, "Parameter:siteId        : " + siteId,       null);
			printOutput.printToShell (apiParams, "Parameter:highDate      : " + highDate,       null);
			
		break;
		
		case 44: // DISCONNECT_NO_TRUCK
			printOutput.printToShell (apiParams, "   DISCONNECT_NO_TRUCK Parameter Values",  null);
			this.setAddressUse(apiParams, printOutput, AddressConstantsI.AddrUseContext.SERVICE_ADDRESS.getAddrUseContextValue());
			this.setBillDate(apiParams, printOutput, new Date(this.getSystemDate()));
			this.setCust_acct(apiParams, printOutput, "10000226");
			this.setIsMustDo(apiParams, printOutput, false);
			this.setOrderGroupSeq(apiParams, printOutput, new BigDecimal(0));
			this.setOrderInfoVOaction(apiParams, printOutput, (short)1); // empty = -1, no change = 0, change = 1, add = 2, remove = 3
			this.setQueueHsdsHitFlag(apiParams, printOutput, false);
			this.setServicePointVOaction(apiParams, printOutput, (short)3); // no change = 0, change = 1, add = 2, remove = 3
			this.setScheduleDate(apiParams, printOutput, new Date(this.getSystemDate()));
			this.setScheduleType(apiParams, printOutput, ServiceConstantsI.NO_TRUCK);
			this.setScheduleVOaction(apiParams, printOutput, (short)2); // 2 should mean add - javadoc needs updating
			this.setTechId(apiParams, printOutput, "999"); // No-Truck Tech
		break;
		
		case 45: //CREATE_TC
			
			corp="99992";
			cust_acct = "10001329";
			siteId = "00100168";
			skipPayCard = false;
			orderType = -1; // ServiceConstantsI.OrderType.ORDER_TROUBLE_CALL_NEW.getOrderTypeValue();
			callerName = "API";
			orderGroupSeq = new BigDecimal(0);
			
			printOutput.printToShell (apiParams, "   New TROUBLE CALL Parameter Values",  null);
			printOutput.printToShell (apiParams, "Parameter:Cust_acct     : " + cust_acct,       null);
			printOutput.printToShell (apiParams, "Parameter:siteId        : " + siteId,       null);
			printOutput.printToShell (apiParams, "Parameter:skipPayCard      : " + skipPayCard,       null);
			printOutput.printToShell (apiParams, "Parameter:orderType      : " + orderType,       null);
			printOutput.printToShell (apiParams, "Parameter:callerName      : " + callerName,       null);
			
		break;
		
		case 46: //CREATE_SRO

			corp="00930";
			cust_acct = "10001331";
			siteId = "00404821";
			skipPayCard = false;
			orderType = ServiceConstantsI.OrderType.ORDER_SRO_NEW.getOrderTypeValue();
			callerName = "API";
			
			
			printOutput.printToShell (apiParams, "   New SRO Parameter Values",  null);
			printOutput.printToShell (apiParams, "Parameter:Cust_acct     : " + cust_acct,       null);
			printOutput.printToShell (apiParams, "Parameter:siteId        : " + siteId,       null);
			printOutput.printToShell (apiParams, "Parameter:skipPayCard      : " + skipPayCard,       null);
			printOutput.printToShell (apiParams, "Parameter:orderType      : " + orderType,       null);
			printOutput.printToShell (apiParams, "Parameter:callerName      : " + callerName,       null);

		break;
		
		case 47: // DISCONNECT_SCHEDULE
			printOutput.printToShell (apiParams, "   DISCONNECT_SCHEDULE Parameter Values",  null);
			this.setAddressUse(apiParams, printOutput, AddressConstantsI.AddrUseContext.SERVICE_ADDRESS.getAddrUseContextValue());
			this.setBillDate(apiParams, printOutput, new Date(this.getSystemDate()));
			this.setCust_acct(apiParams, printOutput, "45466365");
			this.setIsMustDo(apiParams, printOutput, false);
			this.setOrderGroupSeq(apiParams, printOutput, new BigDecimal(0));
			this.setOrderInfoVOaction(apiParams, printOutput, (short)1); // empty = -1, no change = 0, change = 1, add = 2, remove = 3
			this.setQueueHsdsHitFlag(apiParams, printOutput, false);
			this.setQuotaGroupCode(apiParams, printOutput, (short)5); // API Quota group on 99517
			this.setQuotaTimeSlotCode(apiParams, printOutput, (short)2);
			this.setServicePointVOaction(apiParams, printOutput, (short)3); // no change = 0, change = 1, add = 2, remove = 3
			this.setScheduleDate(apiParams, printOutput, new Date(this.getSystemDate()));
			this.setScheduleType(apiParams, printOutput, ServiceConstantsI.SCHEDULE);
			this.setScheduleVOaction(apiParams, printOutput, (short)2); // 2 should mean add - javadoc needs updating
			this.setSiteId(apiParams, printOutput, "01000853");
			//this.setTechId(apiParams, printOutput, "999"); // No-Truck Tech
		break;
		
		case 48: // UPDATE_ACCOUNT_COMMENTS
			printOutput.printToShell (apiParams, "   UPDATE_ACCOUNT_COMMENTS Parameter Values",  null);
			this.setCommentTypeSelect(apiParams, printOutput, 1); // 1 = HouseCustComments
			this.setCust_acct(apiParams, printOutput, "40482121");
			this.setSiteId(apiParams, printOutput, "01000195");
		break;
		
		case 49: // GET_ALL_FINANCIALS
			printOutput.printToShell (apiParams, "   GET_ALL_FINANCIALS Parameter Values",  null);
			this.setCust_acct(apiParams, printOutput, "40482121");
			this.setSiteId(apiParams, printOutput, "01000195");
			this.setStartStmtDate(apiParams, printOutput, new Date("1-jan-2016"));
			this.setStopStmtDate(apiParams, printOutput, new Date(this.getSystemDate()));
		break;
		
		case 50: // COMPLETE_TC_JOB
			printOutput.printToShell (apiParams, "   COMPLETE_TC_JOB Operation Parameter Values",  null);
			beginDateTime = new Date(this.getSystemDate());
			cdwDate = new Date("14-jan-2016");			
			checkinAlert = ""; // Valid Values: 1 or blank.			
			completeDate = new Date(this.getSystemDate());			
			completeTime = new Date(this.getSystemDate());			
			cust_acct = "45465553";			
			customPointsAllowed = false;			
			dSeq = "2"; // char(3) Sequence of this job in the total work assigned to the technician. DSEQ column from WIPMASTER table.
			jobType = ServiceConstantsI.JobType.JOBTYPE_TRBL_CALL.getJobTypeValue(); // Value = 7
			offerNum = new BigDecimal(7056);
			optionId = ServiceConstantsI.WipOrderType.WIP_ORDER_TYPE_TROUBLE_CALL.getWipOrderTypeValue(); // Value = 7
			orderComment = "API Comment";
			orderGroupSeq = new BigDecimal(0); // set at runtime
			orderType = ServiceConstantsI.OrderType.ORDER_TROUBLE_CALL_NEW.getOrderTypeValue(); // value: 11
			overriddenRuleIds[0] = "";
			overriddenRuleIds[1] = "";			
			servicePoint = 1;			
			servicePointVOaction = 1; // no change = 0, change = 1, add = 2, remove = 3
			siteId = "00107333";			
			tcFixCode = null; // set at runtime			
			tcFixDesc = null; // set at runtime			
			tag = "";			
			techId = "110";						
			
			printOutput.printToShell (apiParams, "beginDateTime       : " + beginDateTime,          null);
			printOutput.printToShell (apiParams, "cdwDate             : " + cdwDate,                null);
			printOutput.printToShell (apiParams, "checkinAlert        : " + checkinAlert,           null);
			printOutput.printToShell (apiParams, "completeDate        : " + completeDate,           null);
			printOutput.printToShell (apiParams, "completeTime        : " + completeTime,           null);
			printOutput.printToShell (apiParams, "cust_acct           : " + cust_acct,              null);
			printOutput.printToShell (apiParams, "customPointsAllowed : " + customPointsAllowed,    null);
			printOutput.printToShell (apiParams, "dSeq                : " + dSeq,                   null);
			printOutput.printToShell (apiParams, "Parameter:jobType   : " + jobType,                null);
			printOutput.printToShell (apiParams, "offerNum            : " + offerNum,               null);			
			printOutput.printToShell (apiParams, "optionId            : " + optionId,               null);
			printOutput.printToShell (apiParams, "orderComment        : " + orderComment,           null);
			printOutput.printToShell (apiParams, "orderGroupSeq       : " + orderGroupSeq,          null);
			printOutput.printToShell (apiParams, "orderType           : " + orderType,              null);
			printOutput.printToShell (apiParams, "overriddenRuleIds   : " + "[0] " + overriddenRuleIds[0] + "[1] " + overriddenRuleIds[1], null);
			printOutput.printToShell (apiParams, "servicePoint        : " + servicePoint,           null);
			printOutput.printToShell (apiParams, "servicePointVOaction: " + servicePointVOaction  , null);
			printOutput.printToShell (apiParams, "siteId              : " + siteId,                 null);
			printOutput.printToShell (apiParams, "sroFixCode          : " + sroFixCode,             null);
			printOutput.printToShell (apiParams, "sroFixDesc          : " + sroFixDesc,             null);
			printOutput.printToShell (apiParams, "tag                 : " + tag,                    null);
			printOutput.printToShell (apiParams, "techId              : " + techId,                 null);
			
			break;
			
		case 51: // DIRECT_PAYMENT_ADJUSTMENT
			this.setAging(apiParams, printOutput, "0"); // Aging to which adjustment should be applied. Valid Values: 0 = Current, 1 = 30 day, 2 = 60 day, 3 = 90 day, 4 = 120 day.
			this.setAdjustmentAmount(apiParams, printOutput, new Money(0.00)); // to be set at runtime
			this.setComment(apiParams, printOutput, "To be set at runtime");           
			this.setAdjustmentCode(apiParams, printOutput, ""); // to be set at runtime
			this.setCust_acct(apiParams, printOutput, "40482121");
			this.setIsAdjustment(apiParams, printOutput, false); // to be set at runtime
			this.setIsPayment(apiParams, printOutput, false); // to be set at runtime
			this.setAmount(apiParams, printOutput, new Money(0.00)); // to be set at runtime
			this.setPaymentKind(apiParams, printOutput, ""); // to be set at runtime
			this.setPaymentReference(apiParams, printOutput, "API Direct Pay/Adj");
			this.setSiteId("01000195");
			break;
			
		case 53: // DIRECT_PAYMENT_ADJUSTMENT_TOOL
			printOutput.printToShell (apiParams, "   DIRECT_PAYMENT_ADJUSTMENT_TOOL Operation Initial Parameter Values - To be set at runtime",  null);
			this.setCorp(apiParams, printOutput, "99956");
			this.setUser(apiParams, printOutput, "train00");
			this.setPassword(apiParams, printOutput, "Amdocs2016");
			outputMode = 2;
			this.setAging(apiParams, printOutput, "0"); // Aging to which adjustment should be applied. Valid Values: 0 = Current, 1 = 30 day, 2 = 60 day, 3 = 90 day, 4 = 120 day.
			this.setComment(apiParams, printOutput, ""); 
			this.setAdjustmentAmount(apiParams, printOutput, new Money(0.00));     
			this.setAdjustmentCode(apiParams, printOutput, "");
			this.setCust_acct(apiParams, printOutput, ""); 
			this.setIsAdjustment(apiParams, printOutput, false);
			this.setIsPayment(apiParams, printOutput, false); 
			this.setAmount(apiParams, printOutput, new Money(0.00));
			this.setPaymentKind(apiParams, printOutput, ""); 
			this.setPaymentReference(apiParams, printOutput, ""); 
			this.setSiteId(""); 
			break;
		
		case 54: // ADD_MDU_SITE_UNITS_TOOL
			printOutput.printToShell (apiParams, "   ADD_MDU_SITE_UNITS_TOOL Operation Initial Parameter Values",  null);
			outputMode = 2; // audit screen and files
			this.setAddressType(apiParams, printOutput, ServiceConstantsI.AccountCategory.RESIDENTIAL.getAcctCatTypeValue());
			this.setAddressUse(apiParams, printOutput, AddressConstantsI.AddrUseContext.SERVICE_ADDRESS.getAddrUseContextValue());
			this.setAllowInvalidZip(apiParams, printOutput, (short)0);
			this.setCallerName(apiParams, printOutput, "API");
			this.setCorp(apiParams, printOutput, "00930");
			this.setCorpSet("00930");
			this.setCust_acct(apiParams, printOutput, "0");
			this.setDuplicateAddressFlag(apiParams, printOutput, false);
			this.setHouseInfo(apiParams, printOutput, "SN"); // Survey required
			this.setPassword(apiParams, printOutput, "7913Jv54");
			this.setPlant(apiParams, printOutput, false);
			this.setSiteId(apiParams, printOutput, "01000910"); // Master Site
			// Load Suite IDs
			String[] tempSuiteList = {"TH103","TH104","TH105","401","405","501","505","LPH1","LPH2","LPH3","LPH4","LPH5","PH1","PH2","PH3"};
			
			suiteList = tempSuiteList;
			/*for (int i = 0; i != suiteList.length; i++) {
				printOutput.printToToolShell(apiParams, "suiteList: " + suiteList[i]);
				printOutput.printToShell(apiParams, 
										 getClass().getName() + ":<suiteList id=" + i + ">" + suiteList[i] + "</suites>",
										 null);
 			}*/ 
			this.setUser(apiParams, printOutput, "jvanhoof");
			
			break;
			
		case 55 : // GET_CONTRACTS
			printOutput.printToShell (apiParams, "   GET_CONTRACTS Operation Initial Parameter Values",  null);
			this.setSiteId(apiParams, printOutput, "01001015");
			break;
			
		case 56 : // GET_PACKAGES
			printOutput.printToShell (apiParams, "   GET_PACKAGES Operation Initial Parameter Values",  null);
			this.setCust_acct(apiParams, printOutput, "0");
			this.setPriceStructId(apiParams, printOutput, 0);
			this.setQualifiersVOList(apiParams, printOutput, null);
			this.setSiteId(apiParams, printOutput, "01001015");
			break;
			
		} // end of Switch 
		
		printOutput.printToShell (apiParams, "", null);
	}
	
	// Internal method to get system date
	public String getSystemDate () {
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
	    Calendar calendar = Calendar.getInstance();
	    
	    return (dateFormat.format(calendar.getTime()));
	}
	
	// Internal method to format date
	public Date formatDate (int day, int month, int year) {
		
	    Calendar calendar = Calendar.getInstance();
	    calendar.set(year, month - 1, day);
	    
	    return (calendar.getTime());
	}
	
	// good for phone numbers
	public String generateRandomNumberString (int length) {
		
		String numberString = "";
		Random rn = new Random();
		
		for(int i =0; i < length; i++)
		{
		    int answer = rn.nextInt(9) + 1;
		    numberString = numberString + Integer.toString(answer);
		}
		
		return numberString;
	}
	
	// Internal method to print common parameter values
	private void printCommonParameters(Parameters apiParams, PrintOutput printOutput) {
		Calendar calendar = Calendar.getInstance();
		startTimestamp = simpleDateFormat.format(calendar.getTime());

		printOutput.printToShell (apiParams, "Start: " + startTimestamp,  null);
		printOutput.printToShell (apiParams, "", null);
		
		String amspHome = System.getenv("AMSP_HOME");
		String[] fileNames = {"", ""};
		fileNames = printOutput.getFileNames();

		printOutput.printToShell (apiParams, "   Runtime Configuration Values",                             null);
		printOutput.printToShell (apiParams, "getOPPort()           : " + Configuration.getOPPort(),        null);
		printOutput.printToShell (apiParams, "getOPIp()             : " + Configuration.getOPIp(),          null);
		printOutput.printToShell (apiParams, "getSysUser()          : " + Configuration.getSysUser(),       null);
		printOutput.printToShell (apiParams, "getDefaultLocale()    : " + Configuration.getDefaultLocale(), null);
		printOutput.printToShell (apiParams, "",                                                            null);
		printOutput.printToShell (apiParams, "   Runtime Common Parameter Values",                          null);
		printOutput.printToShell (apiParams, "AMSP_HOME             : " + amspHome,                         null);
		printOutput.printToShell (apiParams, "Parameter:Text file   : " + fileNames[0],                     null);
		printOutput.printToShell (apiParams, "Parameter:XML file    : " + fileNames[1],                     null);
		printOutput.printToShell (apiParams, "Parameter:Locale      : " + locale,                           null);
		printOutput.printToShell (apiParams, "Parameter:outputMode  : " + outputMode,                       null);
		printOutput.printToShell (apiParams, "",                                                            null);
	}
	
	// get methods
	public int        getAccountingArea()           {return accountingArea;}
	public int        getAccountCategory()          {return accountCategory;}
	public int        getAcctPriceStructId()        {return acctPriceStructId;}
	public int        getAddressUse()               {return addressUse;}
	public int        getAddressType()              {return addressType;}
	public String     getAdjustmentCode()           {return adjustmentCode;}
	public String     getAging()                    {return aging;}
	public short      getAllowInvalidZip()          {return allowInvalidZip;}
	public Money	  getAdjustmentAmount()			{return adjustmentAmount;}
	public Money	  getAmount()					{return amount;}
	public Money	  getAmountTendered()           {return amountTendered;}
	public String     getAmspVersion()              {return amspVersion;}
	public String     getAppName()                  {return appName;}
	public String     getAppVersion()               {return appVersion;}
	public Money      getBatchAmount() 				{return batchAmount;}
	public Money      getBatchCash()         		{return batchCash;}
	public Money      getBatchCheque()				{return batchCheque;}
	public short	  getBatchClose()				{return batchClose;}
	public short      getBatchContinue()			{return batchContinue;}
	public Money      getBatchCreditCard()			{return batchCreditCard;}
	public String     getBatchCtrlgroup()			{return batchCtrlgroup;}
	public short      getBatchDone()				{return batchDone;}
	public Money      getBatchElectronicCheq()		{return batchElectronicCheq;}
	public short      getBatchNew()					{return batchNew;}
	public int        getBatchNumber()				{return batchNumber;}
	public int        getBatchNumberTarget()    	{return batchNumberTarget;}
	public Money      getBatchOther()				{return batchOther;}
	public Money      getBatchPostal()				{return batchPostal;}
	public String  	  getBatchStatus()				{return batchStatus;}
	public String  	  getBatchType()				{return batchType;}
	public Date       getBeginDateTime()            {return beginDateTime;}
	public Date       getBillDate()                 {return billDate;}
	public String     getBillForm()                 {return billForm;}
	public String     getCampaignCode()             {return campaignCode;}
	public short      getCancelNpd()                {return cancelNpd;}
	public String     getCancelReason()             {return cancelReason;}
	public String     getCallerName()               {return callerName;}
	public Date       getCdwDate()                  {return cdwDate;}
	public String     getCodCode()                  {return codCode;}
	public String     getCollStatAgencyCode()       {return collStatAgencyCode;}
	public String     getCollStatCancelReason()     {return collStatCancelReason;}
	public short      getCollStatClass()            {return collStatClass;}
	public short      getCollStatClose()            {return collStatClose;}
	public String     getCollStatComments()         {return collStatComments;}
	public Date       getCollStatDate()             {return collStatDate;}
	public String     getCollStatPath()             {return collStatPath;}
	public boolean    getCollStatPpvHold()          {return colStatPpvHold;}
	public String     getCollStatStep()             {return collStatStep;}
	public String     getComment()                  {return comment;}
	public int        getCommentTypeSelect()        {return commentTypeSelect;}
	public int        getContractStatusOption()     {return contractStatusOption;}
	public long       getContractTemplateId()       {return contractTemplateId;}
	public String     getCheckinAlert()             {return checkinAlert;}
	public String     getChangeReason()             {return changeReason;}
	public String     getCustClassCode()            {return custClassCode;}
	public Date       getCompleteDate()             {return completeDate;}
	public Date       getCompleteTime()             {return completeTime;}
	public String     getCorp()                     {return corp;}
	public String[]   getCorpSet()                  {return corpSet;}
	public String     getCorpSetTarget()            {return corpSetTarget;}
	public String     getCust_acct()                {return cust_acct;}
	public String     getCust_acct2()               {return cust_acct2;}
	public boolean    getCustomPointsAllowed()      {return customPointsAllowed;}
	public int        getCycle()                    {return cycle;}
	public Date       getDateOfBirth()              {return dateOfBirth;}
	public Money      getDMoney()                   {return dMoney;}
	public String     getDSeq()                     {return dSeq;}
	public String     getDisconnectReasonCode()     {return disconnectReasonCode;}
	public boolean    getDuplicateAddressFlag()     {return duplicateAddressFlag;}
	public Date       getEffectiveDate()            {return effectiveDate;}
	public int        getEffectiveDateFlag()        {return effectiveDateFlag;}
	public String     getEquipmentId()              {return equipmentId;}
	public String     getEquipmentLocation()        {return equipmentLocation;}
	public short      getEquipmentVOaction()        {return equipmentVOaction;}
	public String     getEnterpriseId()             {return enterpriseId;}
	public String     getFileName()                 {return file_name;}
	public String     getFilePath()                 {return file_path;}
	public String     getFirstName()                {return firstName;}
	public String     getFromTech()                 {return fromTech;}
	public Date       getHighDate()                 {return highDate;}
	public String     getHomePhone()                {return homePhone;}
	public String     gethouseInfo()                {return houseInfo;}
	public String     getInitial()                  {return initial;}
	public int        getInstallType()              {return installType;}
	public boolean    getIsAdjustment()             {return isAdjustment;}
	public boolean    getIsEcheck()					{return isEcheck;}
	public boolean    getIsFrontCounterMode()       {return isFrontCounterMode;}
	public boolean    getIsMustDo()                 {return isMustDo;}
	public boolean    getIsOffer()                  {return isOffer;}
	public int        getOptionId()                 {return optionId;}
	public boolean    getIsPayCard()				{return isPayCard;}
	public boolean	  getIsPayment()				{return isPayment;}
	public boolean    getIsProspect()               {return isProspect;}
	public short    getBlankOutFlag()               {return blankOutFlag;}
	public int        getJobType()                  {return jobType;}
	public String     getLastName()                 {return lastName;}
	public String     getLocale()                   {return locale;}
	public int        getNewCycle()                 {return newCycle;}
	public BigDecimal getOffernum()                 {return offerNum;}
	public String     getOperatorId()               {return operatorId;}
	public String     getOperatorStatus()           {return operatorStatus;}
	public String	  getOptionCode()               {return optionCode;}
	public String     getOrderComment()             {return orderComment;}
	public short      getOrderInfoVOaction()        {return orderInfoVOaction;}
	public BigDecimal getOrderGroupSeq()            {return orderGroupSeq;}
	public int        getOrderType()                {return orderType;}
	public String     getOtherPhone()               {return otherPhone;}
	public int        getOutlet()                   {return outlet;}
	public int        getOutletTarget()             {return outletTarget;}
	public int        getOutputMode()               {return outputMode;}
	public String[]   getOverriddenRuleIds()        {return overriddenRuleIds;}
	public String     getPackageCode()              {return packageCode;}
	public String     getPasswd()                   {return password;}
	public String	  getPaymentKind()				{return paymentKind;}
	public String	  getPaymentReferenced()	    {return paymentReference;}
	public ContractVO[] getpendingContractIds()     {return pendingContractIds;}
	public String     getPhoneClass()               {return phoneClass;}
	public String     getPhoneNumber()              {return phoneNumber;}
	public boolean    getPhoneNumberReplaceFlag()   {return phoneNumberReplaceFlag;}
	public int        getPhoneNumSearch()           {return phoneNumSearch;}
	public short      getPhoneVOaction()            {return phoneVOaction;} 
	public boolean    getPlant()                    {return plant;}
	public short      getPoints()                   {return points;}
	public String     getPrevSerialNumber()         {return prevSerialNumber;}
	public int        getPriceStructId()            {return priceStructId;}
	public String     getPrintFileCode()            {return printFileCode;}
	public String     getProductLanguage()          {return productLanguage;}
	public QualifiersVO[] getQualifiersVOList()     {return qualifiersVOList;}
	public boolean    getQueueHsdsHitFlag()         {return queueHsdsHitFlag;}
	public short      getQuotaGroupCode()           {return quotaGroupCode;}
	public short      getQuotaTimeSlotCode()        {return quotaTimeSlotCode;}
	public String     getRateCode1()                {return rateCode1;}
	public String     getRateCode2()                {return rateCode2;}
	public String     getRateCode3()                {return rateCode3;}
	public String     getRateCode4()                {return rateCode4;}
	public short      getRateCodeVOaction()         {return rateCodeVOaction;}
	public String     getReasonCode()				{return reasonCode;}
	public String     getRefrenceNumber()           {return refrenceNumber;}
	public String     getReminderScheme()           {return reminderScheme;}
	public String     getSalesRepId()               {return salesRepId;}
	public int        getScheduleAction()           {return scheduleAction;}
	public Date       getScheduleDate()             {return scheduleDate;}
	public int        getScheduleType()             {return scheduleType;}
	public short      getScheduleVOaction()         {return scheduleVOaction;}
	public String     getSerialNumber()             {return serialNumber;}
	public int        getServiceGroup()             {return serviceGroup;}
	public String     getServicePackage()           {return servicePackage;}
	public int        getServicePoint()             {return servicePoint;}
	public boolean    getServicePointEquipRemoval() {return servicePointEquipRemoval;}
	public String     getServicePointLocationCode() {return servicePointLocationCode;}
	public int        getServicePointTarget()       {return servicePointTarget;}
	public ServicePointVO[] getServicePointVOlist() {return servicePointVOlist;}
	public short      getServicePointVOaction()     {return servicePointVOaction;}
	public String     getsiteId()                   {return siteId;}
	public String     getSkillLevel()               {return skillLevel;}
	public Boolean    getSkipPayCard()              {return skipPayCard;}
	public Boolean    getSkipServicePointData()     {return skipServicePointData;}
	public String     getSpecialInstruct1Code()     {return specialInstruct1Code;}
	public String     getSroFixCode()               {return sroFixCode;}
	public String     getSroFixDesc()               {return sroFixDesc;}
	public Date       getStartStmtDate()            {return startStmtDate;}
	public Date       getStopStmtDate()             {return stopStmtDate;}
	public Date       getStatementDate()            {return statementDate;}
	public String     getStatementScheme()          {return statementScheme;}
	public int        getStatus()                   {return status;}
	public String     getSuiteListElement(int idx)  {return suiteList[idx];}
	public int        getSuiteListLength()          {return suiteList.length;}
	public String     getTag()                      {return tag;}
	public String     getTaskCode()                 {return taskCode;}
	public String     getTcFixCode()                {return tcFixCode;}
	public String     getTcFixDesc()                {return tcFixDesc;}
	public String     getTechId()                   {return techId;}
	public String     getToTech()                   {return toTech;}
	public String     getType()                     {return type;}
	public String     getTypeCode()                 {return typeCode;}
	public String     getUserid()                   {return user;}
	public boolean    getUpgradeHold()              {return upgradeHold;}
	public String     getUserName()                 {return userName;}
	public short      getValidateOnlyFlg()          {return validateOnlyFlg;}
	
	// add a set method whenever a parameter value needs to change during an operation
	public void setAccountCategory (Parameters apiParams, PrintOutput printOutput, int new_val) {
		printOutput.printToShell (apiParams, "Updating accountCategory from: " + accountCategory + " to: " + new_val, null);
		accountCategory = new_val;
	}
	public void setAccountingArea (Parameters apiParams, PrintOutput printOutput, int new_val) {
		printOutput.printToShell (apiParams, "Updating accountingArea from: " + accountingArea + " to: " + new_val, null);
		accountingArea = new_val;
	}
	public void setAcctPriceStructId (Parameters apiParams, PrintOutput printOutput, int new_val) {
		printOutput.printToShell (apiParams, "Updating acctPriceStructId from: " + acctPriceStructId + " to: " + new_val, null);
		acctPriceStructId = new_val;
	}
	public void setAddressType (Parameters apiParams, PrintOutput printOutput, int new_val) {
		printOutput.printToShell (apiParams, "Updating addressType from: " + addressType + " to: " + new_val, null);
		addressType = new_val;
	}
	public void setAddressUse (Parameters apiParams, PrintOutput printOutput, int new_val) {
		printOutput.printToShell (apiParams, "Updating addressUse from: " + addressUse + " to: " + new_val, null);
		addressUse = new_val;
	}
	public void setAdjustmentCode (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating adjustmentCode from: " + adjustmentCode + " to: " + new_val, null);
		adjustmentCode = new_val;
	}
	public void setAging (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating aging from: " + aging + " to: " + new_val, null);
		aging = new_val;
	}
	public void setAdjustmentAmount (Parameters apiParams, PrintOutput printOutput, Money new_val) {
		printOutput.printToShell (apiParams, "Updating adjustmentAmount from: " + adjustmentAmount + " to: " + new_val, null);
		adjustmentAmount = new_val;
	}
	public void setAllowInvalidZip (Parameters apiParams, PrintOutput printOutput, short new_val) {
		printOutput.printToShell (apiParams, "Updating allowInvalidZip from: " + allowInvalidZip + " to: " + new_val, null);
		allowInvalidZip = new_val;
	}
	public void setAmount (Parameters apiParams, PrintOutput printOutput, Money new_val) {
		printOutput.printToShell (apiParams, "Updating amount from: " + amount + " to: " + new_val, null);
		amount = new_val;
	}
	public void setAmountTendered (Parameters apiParams, PrintOutput printOutput, Money new_val) {
		printOutput.printToShell (apiParams, "Updating amountTendered from: " + amountTendered + " to: " + new_val, null);
		amountTendered = new_val;
	}
	public void setBatchClose (Parameters apiParams, PrintOutput printOutput, short new_val) {
		printOutput.printToShell (apiParams, "Updating batchClose from: " + batchClose + " to: " + new_val, null);
		batchClose = new_val;
	}
	public void setBatchContinue (Parameters apiParams, PrintOutput printOutput, short new_val) {
		printOutput.printToShell (apiParams, "Updating batchContinue from: " + batchContinue + " to: " + new_val, null);
		batchContinue = new_val;
	}
	public void setBatchNew (Parameters apiParams, PrintOutput printOutput, short new_val) {
		printOutput.printToShell (apiParams, "Updating batchNew from: " + batchNew + " to: " + new_val, null);
		batchNew = new_val;
	}
	public void setBatchNumber (Parameters apiParams, PrintOutput printOutput, int new_val) {
		printOutput.printToShell (apiParams, "Updating batchNumber from: " + batchNumber + " to: " + new_val, null);
		batchNumber = new_val;
	}
	public void setBatchCtrlgroup (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating batchCtrlgroup from: " + batchCtrlgroup + " to: " + new_val, null);
		batchCtrlgroup = new_val;
	}
	public void setBatchType (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating batchType from: " + batchType + " to: " + new_val, null);
		batchType = new_val;
	}
	public void setBillDate (Parameters apiParams, PrintOutput printOutput, Date new_val) {
		printOutput.printToShell (apiParams, "Updating billDate from: " + billDate + " to: " + new_val, null);
		billDate = new_val;
	} 
	public void setBillForm (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating billForm from: " + billForm + " to: " + new_val, null);
		billForm = new_val;
	} 
	public void setCallerName (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating callerName from: " + callerName + " to: " + new_val, null);
		callerName = new_val;
	}
	public void setCampaignCode (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating campaignCode from: " + campaignCode + " to: " + new_val, null);
		campaignCode = new_val;
	}
	public void setCancelNpd (Parameters apiParams, PrintOutput printOutput, short new_val) {
		printOutput.printToShell (apiParams, "Updating cancelNpd from: " + cancelNpd + " to: " + new_val, null);
		cancelNpd = new_val;
	}
	public void setCancelReason (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating cancelReason from: " + cancelReason + " to: " + new_val, null);
		cancelReason = new_val;
	}
	public void setCdwDate (Parameters apiParams, PrintOutput printOutput, Date new_val) {
		printOutput.printToShell (apiParams, "Updating cdwDate from: " + cdwDate + " to: " + new_val, null);
		cdwDate = new_val;
	}
	public void setCustClassCode (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating custClassCode from: " + custClassCode + " to: " + new_val, null);
		custClassCode = new_val;
	}
	public void setCollStatAgencyCode (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating collStatAgencyCode from: " + collStatAgencyCode + " to: " + new_val, null);
		collStatAgencyCode = new_val;
	}
	public void setCollStatCancelReason (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating collStatCancelReason from: " + collStatCancelReason + " to: " + new_val, null);
		collStatCancelReason = new_val;
	}
	public void setCollStatClass (Parameters apiParams, PrintOutput printOutput, short new_val) {
		printOutput.printToShell (apiParams, "Updating collStatClass from: " + collStatClass + " to: " + new_val, null);
		collStatClass = new_val;
	}
	public void setCollStatClose (Parameters apiParams, PrintOutput printOutput, short new_val) {
		printOutput.printToShell (apiParams, "Updating collStatClose from: " + collStatClose + " to: " + new_val, null);
		collStatClose = new_val;
	}
	public void setCollStatDate (Parameters apiParams, PrintOutput printOutput, Date new_val) {
		printOutput.printToShell (apiParams, "Updating collStatDate from: " + collStatDate + " to: " + new_val, null);
		collStatDate = new_val;
	}
	public void setCollStatComments (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating collStatComments from: " + collStatComments + " to: " + new_val, null);
		collStatComments = new_val;
	}
	public void setCollStatPath (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating collStatPath from: " + collStatPath + " to: " + new_val, null);
		collStatPath = new_val;
	}
	public void setCollStatStep (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating collStatStep from: " + collStatStep + " to: " + new_val, null);
		collStatStep = new_val;
	}	
	public void setCollStatPpvHold (Parameters apiParams, PrintOutput printOutput, boolean new_val) {
		printOutput.printToShell (apiParams, "Updating colStatPpvHold from: " + colStatPpvHold + " to: " + new_val, null);
		colStatPpvHold = new_val;
	}
	public void setComment (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating comment from: " + comment + " to: " + new_val, null);
		comment = new_val;
	}
	public void setCommentTypeSelect (Parameters apiParams, PrintOutput printOutput, int new_val) {
		printOutput.printToShell (apiParams, "Updating commentTypeSelect from: " + commentTypeSelect + " to: " + new_val, null);
		commentTypeSelect = new_val;
	}
	public void setContractStatusOption (Parameters apiParams, PrintOutput printOutput, int new_val) {
		printOutput.printToShell (apiParams, "Updating contractStatusOption from: " + contractStatusOption + " to: " + new_val, null);
		contractStatusOption = new_val;
	}
	public void setContractTemplateId (Parameters apiParams, PrintOutput printOutput, long new_val) {
		printOutput.printToShell (apiParams, "Updating contractTemplateId from: " + contractTemplateId + " to: " + new_val, null);
		contractTemplateId = new_val;
	}
	public void setCorp (String new_val) {corp = new_val;} // For tool use
	
	public void setCorp (Parameters apiParams, PrintOutput printOutput, String new_val)  {
		printOutput.printToShell (apiParams, "Updating corp from: " + corp + " to: " + new_val, null);
		corp = new_val;
	}
	public void setCorpSet (String new_val) {corpSet[0] = new_val;} // For tool use
	
	public void setCorpSetList (Parameters apiParams, PrintOutput printOutput, int elem, String new_val)  {
		printOutput.printToShell (apiParams, "Updating corpSet[" + elem + "] from: " + corpSet[elem] + " to: " + new_val, null);
		corpSet[elem] = new_val;
	}
	public void setCust_acct (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating cust_acct from: " + cust_acct + " to: " + new_val, null);
		cust_acct = new_val;
	}
	public void setCycle (Parameters apiParams, PrintOutput printOutput, int new_val) {
		printOutput.printToShell (apiParams, "Updating cycle from: " + cycle + " to: " + new_val, null);
		cycle = new_val;
	}
	public void setDateOfBirth (Parameters apiParams, PrintOutput printOutput, Date new_val) {
		printOutput.printToShell (apiParams, "Updating dateOfBirth from: " + dateOfBirth + " to: " + new_val, null);
		dateOfBirth = new_val;
	}
	public void setDisconnectReasonCode (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating disconnectReason from: " + disconnectReasonCode + " to: " + new_val, null);
		disconnectReasonCode = new_val;
	}
	public void setDuplicateAddressFlag (Parameters apiParams, PrintOutput printOutput, boolean new_val) {
		printOutput.printToShell (apiParams, "Updating duplicateAddressFlag from: " + duplicateAddressFlag + " to: " + new_val, null);
		duplicateAddressFlag = new_val;
	}
	public void setEffectiveDate (Parameters apiParams, PrintOutput printOutput, Date new_val) {
		printOutput.printToShell (apiParams, "Updating effectiveDate from: " + effectiveDate + " to: " + new_val, null);
		effectiveDate = new_val;
	}
	public void setEffectiveDateFlag (Parameters apiParams, PrintOutput printOutput, int new_val) {
		printOutput.printToShell (apiParams, "Updating effectiveDateFlag from: " + effectiveDateFlag + " to: " + new_val, null);
		effectiveDateFlag = new_val;
	}
	public void setEquipmentId (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating equipmentId from: " + equipmentId + " to: " + new_val, null);
		equipmentId = new_val;
	} 
	public void setEquipmentLocation (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating equipmentLocation from: " + equipmentLocation + " to: " + new_val, null);
		equipmentLocation = new_val;
	} 
	public void setEquipmentVOaction (Parameters apiParams, PrintOutput printOutput, short new_val) {
		printOutput.printToShell (apiParams, "Updating equipmentVOaction from: " + equipmentVOaction + " to: " + new_val, null);
		equipmentVOaction = new_val;
	}
	public void setFirstName (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating firstName from: " + firstName + " to: " + new_val, null);
		firstName = new_val;
	}
	public void setInstallType (Parameters apiParams, PrintOutput printOutput, int new_val) {
		printOutput.printToShell (apiParams, "Updating installType from: " + installType + " to: " + new_val, null);
		installType = new_val;
	}
	public void setJobType (Parameters apiParams, PrintOutput printOutput, int new_val) {
		printOutput.printToShell (apiParams, "Updating jobType from: " + jobType + " to: " + new_val, null);
		jobType = new_val;
	}
	public void setHomePhone (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating homePhone from: " + homePhone + " to: " + new_val, null);
		homePhone = new_val;
	}
	public void setHouseInfo (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating houseInfo from: " + houseInfo + " to: " + new_val, null);
		houseInfo = new_val;
	}
	public void setInitial (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating initial from: " + initial + " to: " + new_val, null);
		initial = new_val;
	}
	public void setIsAdjustment (Parameters apiParams, PrintOutput printOutput, boolean new_val) {
		printOutput.printToShell (apiParams, "Updating isAdjustment from: " + isAdjustment + " to: " + new_val, null);
		isAdjustment = new_val;
	}
	public void setIsFrontCounterMode (Parameters apiParams, PrintOutput printOutput, boolean new_val) {
		printOutput.printToShell (apiParams, "Updating isFrontCounterMode from: " + isFrontCounterMode + " to: " + new_val, null);
		isFrontCounterMode = new_val;
	}
	public void setIsMustDo (Parameters apiParams, PrintOutput printOutput, boolean new_val) {
		printOutput.printToShell (apiParams, "Updating isMustDo from: " + isMustDo + " to: " + new_val, null);
		isMustDo = new_val;
	}
	public void setIsOffer (Parameters apiParams, PrintOutput printOutput, boolean new_val) {
		printOutput.printToShell (apiParams, "Updating isOffer from: " + isOffer + " to: " + new_val, null);
		isOffer = new_val;
	}
	public void setIsProspect (Parameters apiParams, PrintOutput printOutput, boolean new_val) {
		printOutput.printToShell (apiParams, "Updating isProspect from: " + isProspect + " to: " + new_val, null);
		isProspect = new_val;
	}
	public void setBlankOutFlag(Parameters apiParams, PrintOutput printOutput, short new_val) {
		printOutput.printToShell (apiParams, "Updating isProspect from: " + isProspect + " to: " + new_val, null);
		blankOutFlag = new_val;
	}
	public void setNewCycle (Parameters apiParams, PrintOutput printOutput, int new_val) {
		printOutput.printToShell (apiParams, "Updating newCycle from: " + newCycle + " to: " + new_val, null);
		newCycle = new_val;
	}
	public void setOverriddenRuleIds (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating overriddenRuleIds[0] from: " + overriddenRuleIds[0] + " to: " + new_val, null);
		printOutput.printToShell (apiParams, "Updating overriddenRuleIds[1] from: " + overriddenRuleIds[1] + " to: " + new_val, null);
		overriddenRuleIds[0] = new_val;
		overriddenRuleIds[1] = new_val;
	}
	public void setIsPayment (Parameters apiParams, PrintOutput printOutput, boolean new_val) {
		printOutput.printToShell (apiParams, "Updating isPayment from: " + isPayment + " to: " + new_val, null);
		isPayment = new_val;
	} 
	public void setPrevSerialNumber (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating prevSerialNumber from: " + prevSerialNumber + " to: " + new_val, null);
		prevSerialNumber = new_val;
	}
	public void setLastName (String new_val) {lastName = new_val;} // For tool use
	public void setLastName (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating lastName from: " + lastName + " to: " + new_val, null);
		lastName = new_val;
	}
	public void setOfferNum (Parameters apiParams, PrintOutput printOutput, BigDecimal new_val) {
		printOutput.printToShell (apiParams, "Updating offerNum from: " + offerNum + " to: " + new_val, null);
		offerNum = new_val;
	}
	public void setOperatorId (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating operatorId from: " + operatorId + " to: " + new_val, null);
		operatorId = new_val;
	}
	public void setOptionCode (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating optionCode from: " + optionCode + " to: " + new_val, null);
		optionCode = new_val;
	}
	public void setOrderGroupSeq (Parameters apiParams, PrintOutput printOutput, BigDecimal new_val) {
		printOutput.printToShell (apiParams, "Updating orderGroupSeq from: " + orderGroupSeq + " to: " + new_val, null);
		orderGroupSeq = new_val;
	}
	public void setOrderInfoVOaction (Parameters apiParams, PrintOutput printOutput, short new_val) {
		printOutput.printToShell (apiParams, "Updating orderInfoVOaction from: " + orderInfoVOaction + " to: " + new_val, null);
		orderInfoVOaction = new_val;
	}
	public void setOrderType (Parameters apiParams, PrintOutput printOutput, int new_val) {
		printOutput.printToShell (apiParams, "Updating orderType from: " + orderType + " to: " + new_val, null);
		orderType = new_val;
	} 
	public void setOutlet (Parameters apiParams, PrintOutput printOutput, int new_val) {
		printOutput.printToShell (apiParams, "Updating outlet from: " + outlet + " to: " + new_val, null);
		outlet = new_val;
	}
	public void setOutputMode (Parameters apiParams, PrintOutput printOutput, int new_val) {
		printOutput.printToShell (apiParams, "Updating outputMode from: " + outputMode + " to: " + new_val, null);
		outputMode = new_val;
	}
	public void setPackageCode (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating packageCode from: " + packageCode + " to: " + new_val, null);
		packageCode = new_val;
	}
	public void setPassword (String new_val) {password = new_val;} // For tool use
	
	public void setPassword (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating password from: " + password + " to: " + new_val, null);
		password = new_val;
	}
	public void setPaymentKind (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating paymentKind from: " + paymentKind + " to: " + new_val, null);
		paymentKind = new_val;
	}
	public void setPaymentReference (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating paymentReference from: " + paymentReference + " to: " + new_val, null);
		paymentReference = new_val;
	}
	public void setPendingContractIds (Parameters apiParams, PrintOutput printOutput, ContractVO[] new_val) {
		printOutput.printToShell (apiParams, "Updating pendingContractIds from: " + pendingContractIds + " to: " + new_val, null);
		pendingContractIds = new_val; // This only works for null right now
	}
	public void setPhoneClass (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating phoneClass from: " + phoneClass + " to: " + new_val, null);
		phoneClass = new_val;
	}
	public void setPhoneNumber (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating phoneNumber from: " + phoneNumber + " to: " + new_val, null);
		phoneNumber = new_val;
	}
	public void setPhoneNumSearch (Parameters apiParams, PrintOutput printOutput, int new_val) {
		printOutput.printToShell (apiParams, "Updating phoneNumSearch from: " + phoneNumSearch + " to: " + new_val, null);
		phoneNumSearch = new_val;
	}
	public void setPlant (Parameters apiParams, PrintOutput printOutput, boolean new_val) {
		printOutput.printToShell (apiParams, "Updating plant from: " + plant + " to: " + new_val, null);
		plant = new_val;
	}
	public void setPoints (Parameters apiParams, PrintOutput printOutput, short new_val) {
		printOutput.printToShell (apiParams, "Updating points from: " + points + " to: " + new_val, null);
		points = new_val;
	}
	public void setPriceStructId (Parameters apiParams, PrintOutput printOutput, int new_val) {
		printOutput.printToShell (apiParams, "Updating priceStructId from: " + priceStructId + " to: " + new_val, null);
		priceStructId = new_val;
	}
	public void setProductLanguage (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating productLanguage from: " + productLanguage + " to: " + new_val, null);
		productLanguage = new_val;
	}
	public void setQualifiersVOList (Parameters apiParams, PrintOutput printOutput, QualifiersVO[] new_val) {
		printOutput.printToShell (apiParams, "Updating qualifiersVOList from: " + qualifiersVOList + " to: " + new_val, null);
		qualifiersVOList = new_val;
	}
	public void setQueueHsdsHitFlag (Parameters apiParams, PrintOutput printOutput, boolean new_val) {
		printOutput.printToShell (apiParams, "Updating queueHsdsHitFlag from: " + queueHsdsHitFlag + " to: " + new_val, null);
		queueHsdsHitFlag = new_val;
	}
	public void setQuotaGroupCode (Parameters apiParams, PrintOutput printOutput, short new_val) {
		printOutput.printToShell (apiParams, "Updating quotaGroup from: " + quotaGroupCode + " to: " + new_val, null);
		quotaGroupCode = new_val;
	}
	public void setQuotaTimeSlotCode (Parameters apiParams, PrintOutput printOutput, short new_val) {
		printOutput.printToShell (apiParams, "Updating quotaTimeSlot from: " + quotaTimeSlotCode + " to: " + new_val, null);
		quotaTimeSlotCode = new_val;
	}
	public void setRateCode1 (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating rateCode1 from: " + rateCode1 + " to: " + new_val, null);
		rateCode1 = new_val;
	}
	public void setRateCode2 (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating rateCode2 from: " + rateCode2 + " to: " + new_val, null);
		rateCode2 = new_val;
	}
	public void setRateCodeVOaction (Parameters apiParams, PrintOutput printOutput, short new_val) {
		printOutput.printToShell (apiParams, "Updating rateCodeVOaction from: " + rateCodeVOaction + " to: " + new_val, null);
		rateCodeVOaction = new_val;
	}
	public void setReminderScheme (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating reminderScheme from: " + reminderScheme + " to: " + new_val, null);
		reminderScheme = new_val;
	}
	public void setSalesRepId (String new_val) {salesRepId = new_val;} // For tool use
	
	public void setSalesRepId (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating salesRepId from: " + salesRepId + " to: " + new_val, null);
		salesRepId = new_val;
	}
	public void setSerialNumber (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating serialNumber from: " + serialNumber + " to: " + new_val, null);
		serialNumber = new_val;
	}
	public void setScheduleDate (Parameters apiParams, PrintOutput printOutput, Date new_val) {
		printOutput.printToShell (apiParams, "Updating scheduleDate from: " + scheduleDate + " to: " + new_val, null);
		scheduleDate = new_val;
	}
	public void setScheduleType (Parameters apiParams, PrintOutput printOutput, int new_val) {
		printOutput.printToShell (apiParams, "Updating scheduleType from: " + scheduleType + " to: " + new_val, null);
		scheduleType = new_val;
	}
	public void setScheduleVOaction (Parameters apiParams, PrintOutput printOutput, short new_val) {
		printOutput.printToShell (apiParams, "Updating scheduleVOaction from: " + scheduleVOaction + " to: " + new_val, null);
		scheduleVOaction = new_val;
	}
	public void setSiteId (String new_val) {siteId = new_val;}
	
	public void setSiteId (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating siteId from: " + siteId + " to: " + new_val, null);
		siteId = new_val;
	} 
	public void setServicePoint (Parameters apiParams, PrintOutput printOutput, int new_val) {
		printOutput.printToShell (apiParams, "Updating servicePoint from: " + servicePoint + " to: " + new_val, null);
		servicePoint = new_val;
	}
	public void setServiceGroup (Parameters apiParams, PrintOutput printOutput, int new_val) {
		printOutput.printToShell (apiParams, "Updating serviceGroup from: " + serviceGroup + " to: " + new_val, null);
		serviceGroup = new_val;
	}
	public void setServicePackage (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating servicePackage from: " + servicePackage + " to: " + new_val, null);
		servicePackage = new_val;
	}
	public void setServicePointEquipRemoval (Parameters apiParams, PrintOutput printOutput, boolean new_val) {
		printOutput.printToShell (apiParams, "Updating servicePointEquipRemoval from: " + servicePointEquipRemoval + " to: " + new_val, null);
		servicePointEquipRemoval = new_val;
	}
	public void setServicePointLocationCode (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating servicePointLocationCode from: " + servicePointLocationCode + " to: " + new_val, null);
		servicePointLocationCode = new_val;
	}
	public void setServicePointVOaction (Parameters apiParams, PrintOutput printOutput, short new_val) {
		printOutput.printToShell (apiParams, "Updating servicePointVOaction from: " + servicePointVOaction + " to: " + new_val, null);
		servicePointVOaction = new_val;
	}
	public void setSpecialInstruct1Code (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating specialInstruct1Code from: " + specialInstruct1Code + " to: " + new_val, null);
		specialInstruct1Code = new_val;
	}
	public void setSroFixCode (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating sroFixCode from: " + sroFixCode + " to: " + new_val, null);
		sroFixCode = new_val;
	}
	public void setSroFixDesc (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating sroFixDesc from: " + sroFixDesc + " to: " + new_val, null);
		sroFixDesc = new_val;
	}
	public void setStartStmtDate (Parameters apiParams, PrintOutput printOutput, Date new_val) {
		printOutput.printToShell (apiParams, "Updating startStmtDate from: " + startStmtDate + " to: " + new_val, null);
		startStmtDate = new_val;
	}
	public void setStopStmtDate (Parameters apiParams, PrintOutput printOutput, Date new_val) {
		printOutput.printToShell (apiParams, "Updating stopStmtDate from: " + stopStmtDate + " to: " + new_val, null);
		stopStmtDate = new_val;
	}
	public void setStatementDate (Parameters apiParams, PrintOutput printOutput, Date new_val) {
		printOutput.printToShell (apiParams, "Updating statementDate from: " + statementDate + " to: " + new_val, null);
		statementDate = new_val;
	}
	public void setStatementScheme (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating statementScheme from: " + statementScheme + " to: " + new_val, null);
		statementScheme = new_val;
	}
	public void setStatus (Parameters apiParams, PrintOutput printOutput, int new_val) {
		printOutput.printToShell (apiParams, "Updating status from: " + status + " to: " + new_val, null);
		status = new_val;
	}
	public void setTaskCode (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating taskCode from: " + taskCode + " to: " + new_val, null);
		taskCode = new_val;
		}
	public void setTcFixCode (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating tcFixCode from: " + tcFixCode + " to: " + new_val, null);
		tcFixCode = new_val;
	}
	public void setTcFixDesc (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating tcFixDesc from: " + tcFixDesc + " to: " + new_val, null);
		tcFixDesc = new_val;
	}
	public void setTechId (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating techId from: " + techId + " to: " + new_val, null);
		techId = new_val;
	}
	public void setType (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating type from: " + type + " to: " + new_val, null);
		type = new_val;
	}
	public void setTypeCode (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating typeCode from: " + typeCode + " to: " + new_val, null);
		typeCode = new_val;
	}
	public void setUpgradeHold (Parameters apiParams, PrintOutput printOutput, boolean new_val) {
		printOutput.printToShell (apiParams, "Updating upgradeHold from: " + upgradeHold + " to: " + new_val, null);
		upgradeHold = new_val;
	}
	public void setUser (String new_val) {user = new_val;} // For tool use
	
	public void setUser (Parameters apiParams, PrintOutput printOutput, String new_val) {
		printOutput.printToShell (apiParams, "Updating user from: " + user + " to: " + new_val, null);
		user = new_val;
	}
	public void setValidateOnlyFlg (Parameters apiParams, PrintOutput printOutput, short new_val) {
		printOutput.printToShell (apiParams, "Updating validateOnlyFlg from: " + validateOnlyFlg + " to: " + new_val, null);
		validateOnlyFlg = new_val;
	}
	
	// Cleanup
	public void finishOutput(Parameters apiParams, PrintOutput printOutput) {
		long elapsedTime = System.nanoTime() - startTime;
		double seconds = (double)elapsedTime / 1000000000.0;
		Calendar calendar = Calendar.getInstance();
		printOutput.printToShell (apiParams, "", null);
		printOutput.printToShell (apiParams, "Start  : " + startTimestamp, null);
		printOutput.printToShell (apiParams, "Stop   : " + simpleDateFormat.format(calendar.getTime()), null);
		printOutput.printToShell (apiParams, "Elapsed: " + seconds + " seconds" , null);
	}
	
	public static Calendar DateToCalendar(Date date){ 
		  Calendar calendar = Calendar.getInstance();
		  calendar.setTime(date);
		  return calendar;
	}
} // end of Parameters class
