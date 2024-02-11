package app.set;

import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.ServiceConstantsI;
import amdocs.amsp.valueobject.accountconstraints.CustomerConstraintsVO;
import amdocs.amsp.valueobject.customer.CustomerDetailsVO;
import amdocs.amsp.valueobject.site.SiteDetailsVO;

public class SetCustomerDetailsVO_Test {
	
	private CustomerDetailsVO customerDetailsVO = new CustomerDetailsVO();
	
	public CustomerDetailsVO setCustomerDetailsForProspect (CustomerConstraintsVO customerConstraintsVO_in, 
						                                    SiteDetailsVO siteDetailsVO, 
						                                    Parameters apiParams, 
						                                    PrintOutput printOutput) {
		
		if (customerConstraintsVO_in.getCustAcctCategory().getRequired()) {
			customerDetailsVO.setAccountCategory((short) apiParams.getAccountCategory());
		}
		//setAlias(java.lang.String alias)
		//setBillDate(java.util.Date billDate)
		//setBillForm(java.lang.String billForm)
		//customerDetailsVO.setBillingAddress(address); 
		//customerDetailsVO.setBillingAddressFieldsArr(addressFieldsDetailVO);
		customerDetailsVO.setBillingAddressId(siteDetailsVO.getAddressId());
		//customerDetailsVO.setBillingAddressUpdated(true);
		//customerDetailsVO.setBlankOutRphoneFlag((short) 0); // 0 = true
		//setBroadcastStatusFlag(boolean broadcastStatusFlag)
		//setBusinessDetails(BusinessDetailsVO businessDetails)
		//setCampaignCode(java.lang.String campaignCode)
		//setCampaignDesc(java.lang.String campaignDesc)
		//setCancelReason(java.lang.String cancelReason)
		//setCancelRsnCode(java.lang.String cancelRsnCode)
		//setCancelRsnDesc(java.lang.String cancelRsnDesc)
		//setCostCenter(int costCenter)
		customerDetailsVO.setCustAcct(apiParams.getCust_acct());  // "0" required for Prospect
		//setCustClassCode(java.lang.String custClassCode)
		//setCustClassDesc(java.lang.String custClassDesc)
		//setCustDataCode(java.lang.String custDataCode)
		//setCustDataDesc(java.lang.String custDataDesc)
		//customerDetailsVO.setCustHomePhoneAcct(apiParams.getHomePhone());
		//setCustPin(java.lang.String custPin)
		//setCustPredicted(java.util.Date custPredicted)
		//setCvtr(java.lang.String cvtr)
		//setCycle(int cycle)
		//setDateOfBirth(java.util.Date dateOfBirth)
		//setDealer(java.lang.String dealer)
		//setDesigMaintId(int desigMaintId)
		//setDisconnectDate(java.util.Date disconnectDate)
		//setDisconnectReason(java.lang.String disconnectReason)
		//setDisconnectRsnCode(java.lang.String disconnectRsnCode)
		//setDisconnectRsnDesc(java.lang.String disconnectRsnDesc)
		//setDiscountCode(java.lang.String discountCode)
		//setDiscountOffcycleDate(java.util.Date discountOffcycleDate)
		//setDriverLicense(java.lang.String driverLicense)
		//setDriverLicense2(java.lang.String driverLicense2)
		//setEcheckFlag(int echeckFlag)
		//setEcheckStopCycleDate(java.util.Date echeckStopCycleDate)
		//setEftsFlg(java.lang.String eftsFlg)
		//setEMailAddress(java.lang.String eMailAddress)
		//setEnterpriseId(java.lang.String enterpriseId)
		//setEppFlg(int eppFlg)
		//setEppStopCycleDate(java.util.Date eppStopCycleDate)
		//setExpandedName(AccountExpandedNamesVO[] expandedName)
		if (customerConstraintsVO_in.getFirstName().getRequired()) {
			customerDetailsVO.setFirstName(apiParams.getFirstName());
		}
		//setGovernmentUnifiedInvoice(java.lang.String governmentUnifiedInvoice)
		//setHasPin(boolean hasPin)
		//setHasText(boolean hasText)
		//setHoldStatus(int holdStatus)
		//constraintVO = customerConstraintsVO.getTelephone();
		customerDetailsVO.setHomePhone(apiParams.getHomePhone()); // Required for prospect
		//setHsds(int hsds)
		//vsetInfoCode(java.lang.String infoCode)
		//setInfoDesc(java.lang.String infoDesc)
		//setInitialInstallDate(java.util.Date initialInstallDate)
		//setInvoiceFee(java.lang.String invoiceFee)
		//setLastInstallDate(java.util.Date lastInstallDate)
		customerDetailsVO.setLastName(apiParams.getLastName()); // Required for prospect
		//setLateAPCModeChgDate(java.util.Date lateAPCModeChgDate)
		//setMaiden(java.lang.String maiden)
		//setMduExempt(int mduExempt)
		//setMiddleInitial(java.lang.String middleInitial)
		//setMobilePhone(java.lang.String mobilePhone)
		//setMonthlySavings(amdocs.core.Money monthlySavings)
		//setMonthlyTax(amdocs.core.Money monthlyTax)
		//setNameField5(java.lang.String nameField5)
		//setNewCycle(int newCycle)
		//setOfferNum(java.math.BigDecimal offerNum)
		//setOtherMailAdr(int otherMailAdr)
		//setOtherPhone(java.lang.String otherPhone)
		//setOtherPhoneDesc(java.lang.String otherPhoneDesc)
		//setOutletCount(int outletCount)
		//setPayCardDetails(PayCardDetailsVO[] payCardDetails)
		//setPendExcosOdFlg(int pendExcosOdFlg)
		//setPendExcosOrdCount(int pendExcosOrdCount)
		//setPersonalId(java.lang.String personalId)
		//setPersonalId2(java.lang.String personalId2)
		//customerDetailsVO.setPreferredContact("0");
		if (customerConstraintsVO_in.getProductLanguage().getRequired()) {
			customerDetailsVO.setProductLanguageCode(apiParams.getProductLanguage());
		}
		//setProductLanguageDesc(java.lang.String productLanguageDesc)
		//setRate(amdocs.core.Money rate)
		//setRcvPromoCallsFlag(boolean rcvPromoCallsFlag)
		//setRcvPromoMailFlag(boolean rcvPromoMailFlag)
		//setRemainderScheme(java.lang.String remainderScheme)
		//setSalesChannel(java.lang.String salesChannel)
		//setSalesReasonCode(java.lang.String salesReasonCode)
		//setSalesReasonDesc(java.lang.String salesReasonDesc)
		//setSalesRepId(java.lang.String salesRepId)
		//setSalesRepInitials(java.lang.String salesRepInitials)
		//setSalesRepLastName(java.lang.String salesRepLastName)
		//setSalesRepresentative(java.lang.String salesRepresentative)
		//setSellNameFlg(boolean sellNameFlg)
		//setSendOtherMailTo(boolean sendOtherMailTo)
		//setServiceGroupDetails(CustServiceGroupDetailsVO[] serviceGroupDetails)
		//customerDetailsVO.setShippingAddress(address);  // Required for prospect
		//customerDetailsVO.setShippingAddressFieldsArr(addressFieldsDetailVO);  // Required for prospect
		//customerDetailsVO.setShippingAddressFieldsArr(null); 
		customerDetailsVO.setShippingAddressId(siteDetailsVO.getAddressId());
		//customerDetailsVO.setShippingAddressUpdated(true);
		//customerDetailsVO.setSiteId(apiParams.getsiteId());
		//setSplitCustNum(short splitCustNum)
		//setSplitCustomer(boolean splitCustomer)
		//setStatisticsCode(java.lang.String statisticsCode)
		//setStatisticsDesc(java.lang.String statisticsDesc)
		//setStatus(java.lang.String status)
		//setStatusCode(java.lang.String statusCode)
		//setStatusDesc(java.lang.String statusDesc)
		//setStmtScheme(java.lang.String stmtScheme)
		//setTitle(java.lang.String title)
		//setTvTypeCode(java.lang.String tvTypeCode)
		//setTvTypeDesc(java.lang.String tvTypeDesc)
		//setTypeCode(java.lang.String typeCode)
		//setTypeDescription(java.lang.String typeDescription)
		//setVip(boolean vip)
		//setVipNum(int vipNum)
		
		if (customerDetailsVO != null) {
			printOutput.printToShell(apiParams, 
					getClass().getName() + ":<customerDetailsVO>" + customerDetailsVO.toString() + "</customerDetailsVO>", 
					customerDetailsVO.toXml());
		}
		else {
			printOutput.printToShell(apiParams, getClass().getName() + ":<customerDetailsVO> is null", null);
		}

		return (customerDetailsVO);
	}
	
	public CustomerDetailsVO setCustomerDetailsForProspectNoConstraints (SiteDetailsVO siteDetailsVO, 
            															 Parameters apiParams, 
            PrintOutput printOutput) {

		customerDetailsVO.setAccountCategory((short) apiParams.getAccountCategory());
		//setAlias(java.lang.String alias)
		//setBillDate(java.util.Date billDate)
		//setBillForm(java.lang.String billForm)
		//customerDetailsVO.setBillingAddress(address); 
		//customerDetailsVO.setBillingAddressFieldsArr(addressFieldsDetailVO);
		customerDetailsVO.setBillingAddressId(siteDetailsVO.getAddressId());
		//customerDetailsVO.setBillingAddressUpdated(true);
		//customerDetailsVO.setBlankOutRphoneFlag((short) 0); // 0 = true
		//setBroadcastStatusFlag(boolean broadcastStatusFlag)
		//setBusinessDetails(BusinessDetailsVO businessDetails)
		//setCampaignCode(java.lang.String campaignCode)
		//setCampaignDesc(java.lang.String campaignDesc)
		//setCancelReason(java.lang.String cancelReason)
		//setCancelRsnCode(java.lang.String cancelRsnCode)
		//setCancelRsnDesc(java.lang.String cancelRsnDesc)
		//setCostCenter(int costCenter)
		customerDetailsVO.setCustAcct(apiParams.getCust_acct());  // "0" required for Prospect
		//setCustClassCode(java.lang.String custClassCode)
		//setCustClassDesc(java.lang.String custClassDesc)
		//setCustDataCode(java.lang.String custDataCode)
		//setCustDataDesc(java.lang.String custDataDesc)
		//customerDetailsVO.setCustHomePhoneAcct(apiParams.getHomePhone());
		//setCustPin(java.lang.String custPin)
		//setCustPredicted(java.util.Date custPredicted)
		//setCvtr(java.lang.String cvtr)
		//setCycle(int cycle)
		//setDateOfBirth(java.util.Date dateOfBirth)
		//setDealer(java.lang.String dealer)
		//setDesigMaintId(int desigMaintId)
		//setDisconnectDate(java.util.Date disconnectDate)
		//setDisconnectReason(java.lang.String disconnectReason)
		//setDisconnectRsnCode(java.lang.String disconnectRsnCode)
		//setDisconnectRsnDesc(java.lang.String disconnectRsnDesc)
		//setDiscountCode(java.lang.String discountCode)
		//setDiscountOffcycleDate(java.util.Date discountOffcycleDate)
		//setDriverLicense(java.lang.String driverLicense)
		//setDriverLicense2(java.lang.String driverLicense2)
		//setEcheckFlag(int echeckFlag)
		//setEcheckStopCycleDate(java.util.Date echeckStopCycleDate)
		//setEftsFlg(java.lang.String eftsFlg)
		//setEMailAddress(java.lang.String eMailAddress)
		//setEnterpriseId(java.lang.String enterpriseId)
		//setEppFlg(int eppFlg)
		//setEppStopCycleDate(java.util.Date eppStopCycleDate)
		//setExpandedName(AccountExpandedNamesVO[] expandedName)
		//customerDetailsVO.setFirstName(apiParams.getFirstName());
		//setGovernmentUnifiedInvoice(java.lang.String governmentUnifiedInvoice)
		//setHasPin(boolean hasPin)
		//setHasText(boolean hasText)
		//setHoldStatus(int holdStatus)
		//constraintVO = customerConstraintsVO.getTelephone();
		customerDetailsVO.setHomePhone(apiParams.getHomePhone()); // Required for prospect
		//setHsds(int hsds)
		//vsetInfoCode(java.lang.String infoCode)
		//setInfoDesc(java.lang.String infoDesc)
		//setInitialInstallDate(java.util.Date initialInstallDate)
		//setInvoiceFee(java.lang.String invoiceFee)
		//setLastInstallDate(java.util.Date lastInstallDate)
		customerDetailsVO.setLastName(apiParams.getLastName()); // Required for prospect
		//setLateAPCModeChgDate(java.util.Date lateAPCModeChgDate)
		//setMaiden(java.lang.String maiden)
		//setMduExempt(int mduExempt)
		//setMiddleInitial(java.lang.String middleInitial)
		//setMobilePhone(java.lang.String mobilePhone)
		//setMonthlySavings(amdocs.core.Money monthlySavings)
		//setMonthlyTax(amdocs.core.Money monthlyTax)
		//setNameField5(java.lang.String nameField5)
		//setNewCycle(int newCycle)
		//setOfferNum(java.math.BigDecimal offerNum)
		//setOtherMailAdr(int otherMailAdr)
		//setOtherPhone(java.lang.String otherPhone)
		//setOtherPhoneDesc(java.lang.String otherPhoneDesc)
		//setOutletCount(int outletCount)
		//setPayCardDetails(PayCardDetailsVO[] payCardDetails)
		//setPendExcosOdFlg(int pendExcosOdFlg)
		//setPendExcosOrdCount(int pendExcosOrdCount)
		//setPersonalId(java.lang.String personalId)
		//setPersonalId2(java.lang.String personalId2)
		//customerDetailsVO.setPreferredContact("0");
		//customerDetailsVO.setProductLanguageCode(apiParams.getProductLanguage());
		//setProductLanguageDesc(java.lang.String productLanguageDesc)
		//setRate(amdocs.core.Money rate)
		//setRcvPromoCallsFlag(boolean rcvPromoCallsFlag)
		//setRcvPromoMailFlag(boolean rcvPromoMailFlag)
		//setRemainderScheme(java.lang.String remainderScheme)
		//setSalesChannel(java.lang.String salesChannel)
		//setSalesReasonCode(java.lang.String salesReasonCode)
		//setSalesReasonDesc(java.lang.String salesReasonDesc)
		//setSalesRepId(java.lang.String salesRepId)
		//setSalesRepInitials(java.lang.String salesRepInitials)
		//setSalesRepLastName(java.lang.String salesRepLastName)
		//setSalesRepresentative(java.lang.String salesRepresentative)
		//setSellNameFlg(boolean sellNameFlg)
		//setSendOtherMailTo(boolean sendOtherMailTo)
		//setServiceGroupDetails(CustServiceGroupDetailsVO[] serviceGroupDetails)
		//customerDetailsVO.setShippingAddress(address);  // Required for prospect
		//customerDetailsVO.setShippingAddressFieldsArr(addressFieldsDetailVO);  // Required for prospect
		//customerDetailsVO.setShippingAddressFieldsArr(null); 
		customerDetailsVO.setShippingAddressId(siteDetailsVO.getAddressId());
		//customerDetailsVO.setShippingAddressUpdated(true);
		//customerDetailsVO.setSiteId(apiParams.getsiteId());
		//setSplitCustNum(short splitCustNum)
		//setSplitCustomer(boolean splitCustomer)
		//setStatisticsCode(java.lang.String statisticsCode)
		//setStatisticsDesc(java.lang.String statisticsDesc)
		//setStatus(java.lang.String status)
		//setStatusCode(java.lang.String statusCode)
		//setStatusDesc(java.lang.String statusDesc)
		//setStmtScheme(java.lang.String stmtScheme)
		//setTitle(java.lang.String title)
		//setTvTypeCode(java.lang.String tvTypeCode)
		//setTvTypeDesc(java.lang.String tvTypeDesc)
		//setTypeCode(java.lang.String typeCode)
		//setTypeDescription(java.lang.String typeDescription)
		//setVip(boolean vip)
		//setVipNum(int vipNum)
		
		if (customerDetailsVO != null) {
		printOutput.printToShell(apiParams, 
		getClass().getName() + ":<customerDetailsVO>" + customerDetailsVO.toString() + "</customerDetailsVO>", 
		customerDetailsVO.toXml());
		}
		else {
		printOutput.printToShell(apiParams, getClass().getName() + ":<customerDetailsVO> is null", null);
		}
		
		return (customerDetailsVO);
	}
	
	public CustomerDetailsVO setCustomerDetailsForInstall (CustomerConstraintsVO customerConstraintsVO_in, 
		            									   SiteDetailsVO siteDetailsVO, 
		            									   Parameters apiParams,		            									 
		            									   PrintOutput printOutput) {
		
		customerDetailsVO.setAccountCategory((short) apiParams.getAccountCategory());
		//setAlias(java.lang.String alias)
		//setBillDate(java.util.Date billDate)
		//setBillForm(java.lang.String billForm)
		//customerDetailsVO.setBillingAddress(address);
		//customerDetailsVO.setBillingAddressFieldsArr(addressFieldsDetailVO);
		customerDetailsVO.setBillingAddressId(siteDetailsVO.getAddressId());
		//customerDetailsVO.setBillingAddressUpdated(true);
		//customerDetailsVO.setBlankOutRphoneFlag((short) 0);
		//setBroadcastStatusFlag(boolean broadcastStatusFlag)
		//setBusinessDetails(BusinessDetailsVO businessDetails)
		//setCampaignCode(java.lang.String campaignCode)
		//setCampaignDesc(java.lang.String campaignDesc)
		//setCancelReason(java.lang.String cancelReason)
		//setCancelRsnCode(java.lang.String cancelRsnCode)
		//setCancelRsnDesc(java.lang.String cancelRsnDesc)
		//setCostCenter(int costCenter)
		customerDetailsVO.setCustAcct(apiParams.getCust_acct());
		//setCustClassCode(java.lang.String custClassCode)
		//setCustClassDesc(java.lang.String custClassDesc)
		//setCustDataCode(java.lang.String custDataCode)
		//setCustDataDesc(java.lang.String custDataDesc)
		//setCustHomePhoneAcct(java.lang.String custHomePhoneAcct)
		//setCustPin(java.lang.String custPin)
		//setCustPredicted(java.util.Date custPredicted)
		//setCvtr(java.lang.String cvtr)
		//setCycle(int cycle)
		//setDateOfBirth(java.util.Date dateOfBirth)
		//setDealer(java.lang.String dealer)
		//setDesigMaintId(int desigMaintId)
		//setDisconnectDate(java.util.Date disconnectDate)
		//setDisconnectReason(java.lang.String disconnectReason)
		//setDisconnectRsnCode(java.lang.String disconnectRsnCode)
		//setDisconnectRsnDesc(java.lang.String disconnectRsnDesc)
		//setDiscountCode(java.lang.String discountCode)
		//setDiscountOffcycleDate(java.util.Date discountOffcycleDate)
		//setDriverLicense(java.lang.String driverLicense)
		//setDriverLicense2(java.lang.String driverLicense2)
		//setEcheckFlag(int echeckFlag)
		//setEcheckStopCycleDate(java.util.Date echeckStopCycleDate)
		//setEftsFlg(java.lang.String eftsFlg)
		//setEMailAddress(java.lang.String eMailAddress)
		//setEnterpriseId(java.lang.String enterpriseId)
		//setEppFlg(int eppFlg)
		//setEppStopCycleDate(java.util.Date eppStopCycleDate)
		//setExpandedName(AccountExpandedNamesVO[] expandedName)
		if (customerConstraintsVO_in.getFirstName().getRequired()) {
			customerDetailsVO.setFirstName(apiParams.getFirstName());
		}
		//setGovernmentUnifiedInvoice(java.lang.String governmentUnifiedInvoice)
		//setHasPin(boolean hasPin)
		//setHasText(boolean hasText)
		//setHoldStatus(int holdStatus)

		if (customerConstraintsVO_in.getHomePhone().getRequired()) {
			customerDetailsVO.setHomePhone(apiParams.getHomePhone());
		}
		//setHsds(int hsds)
		//vsetInfoCode(java.lang.String infoCode)
		//setInfoDesc(java.lang.String infoDesc)
		//setInitialInstallDate(java.util.Date initialInstallDate)
		//setInvoiceFee(java.lang.String invoiceFee)
		//setLastInstallDate(java.util.Date lastInstallDate)
		if (customerConstraintsVO_in.getLastName().getRequired()) {
			customerDetailsVO.setLastName(apiParams.getLastName());
		}
		//setLateAPCModeChgDate(java.util.Date lateAPCModeChgDate)
		//setMaiden(java.lang.String maiden)
		//setMduExempt(int mduExempt)
		//setMiddleInitial(java.lang.String middleInitial)
		//setMobilePhone(java.lang.String mobilePhone)
		//setMonthlySavings(amdocs.core.Money monthlySavings)
		//setMonthlyTax(amdocs.core.Money monthlyTax)
		//setNameField5(java.lang.String nameField5)
		//setNewCycle(int newCycle)
		//setOfferNum(java.math.BigDecimal offerNum)
		//setOtherMailAdr(int otherMailAdr)
		//setOtherPhone(java.lang.String otherPhone)
		//setOtherPhoneDesc(java.lang.String otherPhoneDesc)
		//setOutletCount(int outletCount)
		//setPayCardDetails(PayCardDetailsVO[] payCardDetails)
		//setPendExcosOdFlg(int pendExcosOdFlg)
		//setPendExcosOrdCount(int pendExcosOrdCount)
		//setPersonalId(java.lang.String personalId)
		//setPersonalId2(java.lang.String personalId2)
		//customerDetailsVO.setPreferredContact("0");
		if (customerConstraintsVO_in.getProductLanguage().getRequired()) {
			customerDetailsVO.setProductLanguageCode(apiParams.getProductLanguage());
		}
		//setProductLanguageDesc(java.lang.String productLanguageDesc)
		//setRate(amdocs.core.Money rate)
		//setRcvPromoCallsFlag(boolean rcvPromoCallsFlag)
		//setRcvPromoMailFlag(boolean rcvPromoMailFlag)
		//setRemainderScheme(java.lang.String remainderScheme)
		//setSalesChannel(java.lang.String salesChannel)
		//setSalesReasonCode(java.lang.String salesReasonCode)
		//setSalesReasonDesc(java.lang.String salesReasonDesc)
		//setSalesRepId(java.lang.String salesRepId)
		//setSalesRepInitials(java.lang.String salesRepInitials)
		//setSalesRepLastName(java.lang.String salesRepLastName)
		//setSalesRepresentative(java.lang.String salesRepresentative)
		//setSellNameFlg(boolean sellNameFlg)
		//setSendOtherMailTo(boolean sendOtherMailTo)
		//setServiceGroupDetails(CustServiceGroupDetailsVO[] serviceGroupDetails)
		//customerDetailsVO.setShippingAddress(address);
		//customerDetailsVO.setShippingAddressFieldsArr(siteDetailsVO.getAddressId());
		//setShippingAddressId(long shippingAddressId)
		//customerDetailsVO.setShippingAddressUpdated(true);
		customerDetailsVO.setSiteId(apiParams.getsiteId());
		//setSplitCustNum(short splitCustNum)
		//setSplitCustomer(boolean splitCustomer)
		//setStatisticsCode(java.lang.String statisticsCode)
		//setStatisticsDesc(java.lang.String statisticsDesc)
		//setStatus(java.lang.String status)
		//setStatusCode(java.lang.String statusCode)
		//setStatusDesc(java.lang.String statusDesc)
		//setStmtScheme(java.lang.String stmtScheme)
		//setTitle(java.lang.String title)
		//setTvTypeCode(java.lang.String tvTypeCode)
		//setTvTypeDesc(java.lang.String tvTypeDesc)
		//setTypeCode(java.lang.String typeCode)
		//setTypeDescription(java.lang.String typeDescription)
		//setVip(boolean vip)
		//setVipNum(int vipNum)
		
		return (customerDetailsVO);
	}
	
	public CustomerDetailsVO setCustomerDetailsForProspectOffer (CustomerConstraintsVO customerConstraintsVO_in, 
			   													 SiteDetailsVO siteDetailsVO, 
			   													 Parameters apiParams,		            									 
			   													 PrintOutput printOutput) {

		customerDetailsVO.setAccountCategory((short)ServiceConstantsI.AccountCategory.RESIDENTIAL.getAcctCatTypeValue());
		//setAlias(java.lang.String alias)
		//setBillDate(java.util.Date billDate)
		//setBillForm(java.lang.String billForm)
		//customerDetailsVO.setBillingAddress(address);
		//customerDetailsVO.setBillingAddressFieldsArr(addressFieldsDetailVO);
		customerDetailsVO.setBillingAddressId(siteDetailsVO.getAddressId());
		//customerDetailsVO.setBillingAddressUpdated(true);
		// customerDetailsVO.setBlankOutRphoneFlag((short) 0);
		//setBroadcastStatusFlag(boolean broadcastStatusFlag)
		//setBusinessDetails(BusinessDetailsVO businessDetails)
		//setCampaignCode(java.lang.String campaignCode)
		//setCampaignDesc(java.lang.String campaignDesc)
		//setCancelReason(java.lang.String cancelReason)
		//setCancelRsnCode(java.lang.String cancelRsnCode)
		//setCancelRsnDesc(java.lang.String cancelRsnDesc)
		//setCostCenter(int costCenter)
		customerDetailsVO.setCustAcct(apiParams.getCust_acct());
		//setCustClassCode(java.lang.String custClassCode)
		//setCustClassDesc(java.lang.String custClassDesc)
		//setCustDataCode(java.lang.String custDataCode)
		//setCustDataDesc(java.lang.String custDataDesc)
		//setCustHomePhoneAcct(java.lang.String custHomePhoneAcct)
		//setCustPin(java.lang.String custPin)
		//setCustPredicted(java.util.Date custPredicted)
		//setCvtr(java.lang.String cvtr)
		//setCycle(int cycle)
		//setDateOfBirth(java.util.Date dateOfBirth)
		//setDealer(java.lang.String dealer)
		//setDesigMaintId(int desigMaintId)
		//setDisconnectDate(java.util.Date disconnectDate)
		//setDisconnectReason(java.lang.String disconnectReason)
		//setDisconnectRsnCode(java.lang.String disconnectRsnCode)
		//setDisconnectRsnDesc(java.lang.String disconnectRsnDesc)
		//setDiscountCode(java.lang.String discountCode)
		//setDiscountOffcycleDate(java.util.Date discountOffcycleDate)
		//setDriverLicense(java.lang.String driverLicense)
		//setDriverLicense2(java.lang.String driverLicense2)
		//setEcheckFlag(int echeckFlag)
		//setEcheckStopCycleDate(java.util.Date echeckStopCycleDate)
		//setEftsFlg(java.lang.String eftsFlg)
		//setEMailAddress(java.lang.String eMailAddress)
		//setEnterpriseId(java.lang.String enterpriseId)
		//setEppFlg(int eppFlg)
		//setEppStopCycleDate(java.util.Date eppStopCycleDate)
		//setExpandedName(AccountExpandedNamesVO[] expandedName)
		if (customerConstraintsVO_in.getFirstName().getRequired()) {
		customerDetailsVO.setFirstName(apiParams.getFirstName());
		}
		//setGovernmentUnifiedInvoice(java.lang.String governmentUnifiedInvoice)
		//setHasPin(boolean hasPin)
		//setHasText(boolean hasText)
		//setHoldStatus(int holdStatus)
		
		if (customerConstraintsVO_in.getHomePhone().getRequired()) {
		customerDetailsVO.setHomePhone(apiParams.getHomePhone());
		}
		//setHsds(int hsds)
		//vsetInfoCode(java.lang.String infoCode)
		//setInfoDesc(java.lang.String infoDesc)
		//setInitialInstallDate(java.util.Date initialInstallDate)
		//setInvoiceFee(java.lang.String invoiceFee)
		//setLastInstallDate(java.util.Date lastInstallDate)
		if (customerConstraintsVO_in.getLastName().getRequired()) {
		customerDetailsVO.setLastName(apiParams.getLastName());
		}
		//setLateAPCModeChgDate(java.util.Date lateAPCModeChgDate)
		//setMaiden(java.lang.String maiden)
		//setMduExempt(int mduExempt)
		//setMiddleInitial(java.lang.String middleInitial)
		//setMobilePhone(java.lang.String mobilePhone)
		//setMonthlySavings(amdocs.core.Money monthlySavings)
		//setMonthlyTax(amdocs.core.Money monthlyTax)
		//setNameField5(java.lang.String nameField5)
		//setNewCycle(int newCycle)
		//setOfferNum(java.math.BigDecimal offerNum)
		//setOtherMailAdr(int otherMailAdr)
		//setOtherPhone(java.lang.String otherPhone)
		//setOtherPhoneDesc(java.lang.String otherPhoneDesc)
		//setOutletCount(int outletCount)
		//setPayCardDetails(PayCardDetailsVO[] payCardDetails)
		//setPendExcosOdFlg(int pendExcosOdFlg)
		//setPendExcosOrdCount(int pendExcosOrdCount)
		//setPersonalId(java.lang.String personalId)
		//setPersonalId2(java.lang.String personalId2)
		//customerDetailsVO.setPreferredContact("0");
		if (customerConstraintsVO_in.getProductLanguage().getRequired()) {
		customerDetailsVO.setProductLanguageCode("1");
		}
		//setProductLanguageDesc(java.lang.String productLanguageDesc)
		//setRate(amdocs.core.Money rate)
		//setRcvPromoCallsFlag(boolean rcvPromoCallsFlag)
		//setRcvPromoMailFlag(boolean rcvPromoMailFlag)
		//setRemainderScheme(java.lang.String remainderScheme)
		//setSalesChannel(java.lang.String salesChannel)
		//setSalesReasonCode(java.lang.String salesReasonCode)
		//setSalesReasonDesc(java.lang.String salesReasonDesc)
		//setSalesRepId(java.lang.String salesRepId)
		//setSalesRepInitials(java.lang.String salesRepInitials)
		//setSalesRepLastName(java.lang.String salesRepLastName)
		//setSalesRepresentative(java.lang.String salesRepresentative)
		//setSellNameFlg(boolean sellNameFlg)
		//setSendOtherMailTo(boolean sendOtherMailTo)
		//setServiceGroupDetails(CustServiceGroupDetailsVO[] serviceGroupDetails)
		//customerDetailsVO.setShippingAddress(address);
		//customerDetailsVO.setShippingAddressFieldsArr(addressFieldsDetailVO);
		customerDetailsVO.setShippingAddressId(siteDetailsVO.getAddressId());
		//customerDetailsVO.setShippingAddressUpdated(true);
		customerDetailsVO.setSiteId(apiParams.getsiteId());
		//setSplitCustNum(short splitCustNum)
		//setSplitCustomer(boolean splitCustomer)
		//setStatisticsCode(java.lang.String statisticsCode)
		//setStatisticsDesc(java.lang.String statisticsDesc)
		//setStatus(java.lang.String status)
		//setStatusCode(java.lang.String statusCode)
		//setStatusDesc(java.lang.String statusDesc)
		//setStmtScheme(java.lang.String stmtScheme)
		//setTitle(java.lang.String title)
		//setTvTypeCode(java.lang.String tvTypeCode)
		//setTvTypeDesc(java.lang.String tvTypeDesc)
		//setTypeCode(java.lang.String typeCode)
		//setTypeDescription(java.lang.String typeDescription)
		//setVip(boolean vip)
		//setVipNum(int vipNum)
		
		return (customerDetailsVO);
		}
}
