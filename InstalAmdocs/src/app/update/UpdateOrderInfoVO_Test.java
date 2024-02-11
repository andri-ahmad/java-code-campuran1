package app.update;

import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.valueobject.accountviewfinancials.AgedMoneyVO;
import amdocs.amsp.valueobject.accountviewwip.OrderGroupVO;
import amdocs.amsp.valueobject.customer.CustomerDetailsVO;
import amdocs.amsp.valueobject.order.CurTransForecastTotalsVO;
import amdocs.amsp.valueobject.order.FinalTransForecastTotalsVO;
import amdocs.amsp.valueobject.order.OrderInfoVO;
import amdocs.amsp.valueobject.schedule.ScheduleVO;

public class UpdateOrderInfoVO_Test {
	
	public void updateOrderInfoVOforChangeOfService(Parameters apiParams, 
			                                        PrintOutput printOutput,
			                                        CustomerDetailsVO customerDetailsVO,
			                                        OrderGroupVO[] orderGroupVOList,
			                                        OrderInfoVO orderInfoVO,
			                                        ScheduleVO scheduleVO) {

		orderInfoVO.setAction(apiParams.getOrderInfoVOaction());
		/*setAdvsvcType(java.lang.Short advsvcType)*/
		//orderInfoVO.setAgedMoney(AgedMoneyVOList);
		/*setAllTaxesExempted(boolean allTaxesExempted)
		setBasicRateConfirm(boolean basicRateConfirm)*/
		orderInfoVO.setBillDate(apiParams.getBillDate());
		/*setBillForm(java.lang.String billForm)*/
		//orderInfoVO.setBillFromDate(apiParams.getBillDate());
		/*setBillingGroup(int billingGroup)*/
		orderInfoVO.setBillToDate(apiParams.getBillDate());
		/*setCampaign(java.lang.String campaign)
		setCampaignVO(CampaignVO campaignVO)
		setCdwDate(java.util.Date cdwDate)*/
		orderInfoVO.setChangeReasonCode(apiParams.getChangeReason());
		//derInfoVO.setChangeReasonDesc(apiParams.getCodCode());
		orderInfoVO.setCodCode(apiParams.getCodCode());
		/*setCurCallDay(short curCallDay)
		setCurrentBalance(amdocs.core.Money currentBalance)*/
		//orderInfoVO.setCurrentTransactionTotals(curTransForecastTotalsVO);
		//orderInfoVO.setCycle(customerDetailsVO.getCycle());
		/*setDisconnectDate(java.util.Date disconnectDate)
		setDisconnectReasonCode(java.lang.String disconnectReasonCode)
		setDisconnectReasonDesc(java.lang.String disconnectReasonDesc)
		setDiscountCode(java.lang.String discountCode)
		setDiscountDesc(java.lang.String discountDesc)*/
		//orderInfoVO.setDropTypeCode(siteDetailsVO.getDropTypeCode());
		/*setDwellingTypeCode(java.lang.String dwellingTypeCode)
		setEffectiveDateFlag(int effectiveDateFlag)*/
		//orderInfoVO.setEstimatedBillVO(estimatedBillVOList);
		/*setEstimatedNewMonthlyRate(amdocs.core.Money estimatedNewMonthlyRate)
		setEstimatedNextBill(amdocs.core.Money estimatedNextBill)*/
		//orderInfoVO.setFinalTransactionTotals(finalTransForecastTotalsVO);
		/*setFlashComment(java.lang.String flashComment)*/
		//orderInfoVO.setHasPromoRemvFrmStart(false);
		/*setIncrementalDepositRemain(amdocs.core.Money incrementalDepositRemain)
		setIncrementalInstallRemain(amdocs.core.Money incrementalInstallRemain)*/
		orderInfoVO.setInstallDate(customerDetailsVO.getInitialInstallDate());
		/*setIntlDestAnalysis(boolean intlDestAnalysis)
		setInvoiceExempt(java.lang.Boolean invoiceExempt)
		setIsAdvanceServiceOrder(boolean isAdvanceServiceOrder)
		setIsComplianceToOrderTime(boolean isComplianceToOrderTime)
		setIsCycleOverride(boolean isCycleOverride)
		setIsDispatchComplete(boolean isDispatchComplete)
		setIsFinalBillSent(boolean isFinalBillSent)
		setIsMduExempt(java.lang.Boolean isMduExempt)
		setIsPhNumPortedOut(java.lang.Boolean isPhNumPortedOut)
		setIsRouted(boolean isRouted)
		setIsTaxExempt(java.lang.Boolean isTaxExempt)*/
		orderInfoVO.setLastInstallDate(customerDetailsVO.getLastInstallDate());
		/*setLastStatementDate(java.util.Date lastStatementDate)
		setLocator(java.lang.String locator)
		setNatlDestAnalysis(boolean natlDestAnalysis)
		setNewCallDay(short newCallDay)*/
		orderInfoVO.setNewCycle(String.valueOf(customerDetailsVO.getCycle()));
		/*setNotDoneRsg(java.lang.String notDoneRsg)
		setOfferNumber(java.math.BigDecimal offerNumber)
		setOrderComment(java.lang.String orderComment)
		setOrderDate(java.util.Date orderDate)*/
		orderInfoVO.setOrderGroupSeq(orderGroupVOList[0].getOrderGroupSeq());
		/*setOrderNumber(java.math.BigDecimal orderNumber)
		setOrderReasonCode(java.lang.String orderReasonCode)
		setOrderReasonDesc(java.lang.String orderReasonDesc)
		setOrderStatus(java.lang.String orderStatus)
		setOrderStatusDesc(java.lang.String orderStatusDesc)
		setOrderTime(java.util.Date orderTime)
		setPriTariffTabDetails(PrimaryTartifTabVO[] priTariffTabDetails)*/
		orderInfoVO.setProrateFromDate(apiParams.getBillDate());
		orderInfoVO.setProrateToDate(apiParams.getBillDate());
		/*setReferenceBillDate(java.util.Date referenceBillDate)
		setReferenceDateType(int referenceDateType)*/
		//orderInfoVO.setReminderScheme(customerDetailsVO.getRemainderScheme());
		/*setRoutedDesc(java.lang.String routedDesc)
		setSalesReasonCode(java.lang.String salesReasonCode)
		setSalesReasonDesc(java.lang.String salesReasonDesc) */
		orderInfoVO.setSalesRepId(apiParams.getSalesRepId());		
		/*setSalesRepLastName(java.lang.String salesRepLastName)*/
		orderInfoVO.setSchedule(scheduleVO);
		/*setSpecialInstruct1Code(java.lang.String specialInstruct1Code)
		setSpecialInstruct1Desc(java.lang.String specialInstruct1Desc)
		setSpecialInstruct2Code(java.lang.String specialInstruct2Code)
		setSpecialInstruct2Desc(java.lang.String specialInstruct2Desc)
		setSpecialInstruct3Code(java.lang.String specialInstruct3Code)
		setSpecialInstruct3Desc(java.lang.String specialInstruct3Desc)
		setSpecialRateAnalysis(boolean specialRateAnalysis)
		setSpecialRateCallLog(boolean SpecialRateCallLog)*/
		orderInfoVO.setStatementScheme(customerDetailsVO.getStmtScheme());
		/*setSubTotalCharges(amdocs.core.Money subTotalCharges)
		setSummaryByOrigin(boolean summaryByOrigin)
		setSvcDependencyWip(boolean svcDependencyWip)
		setTaxExemptionsList(CustTaxExemptLocalVO[] taxExemptionsList)*/
		//if (wIPConstraintsVO.getTechId().getRequired())
		//orderInfoVO.setTechAssigned(apiParams.getTechId());   
		//}
		/*setTechLastName(java.lang.String techLastName)
		setTelcoChangeType(java.lang.Short telcoChangeType)
		setTermOverrideComment(java.lang.String termOverrideComment)
		setTotalCodAmount(amdocs.core.Money totalCodAmount)
		setWdwo(java.lang.String wdwo)
		setWipChangeProg(short wipChangeProg)
		setWipComment(java.lang.String wipComment)
		setWipDependency(int wipDependency)*/
		orderInfoVO.setWorkDoneDate(apiParams.getBillDate());
		orderInfoVO.setWorkDoneTime(apiParams.getBillDate());
		
		printOutput.printToShell(apiParams, 
		getClass().getName() + ":<OrderInfoVO>" + orderInfoVO.toString() + "</OrderInfoVO>", 
		orderInfoVO.toXml());
	}
	
	public void updateOrderInfoVOforDisconnect(Parameters apiParams, 
            								   PrintOutput printOutput,
            								   CustomerDetailsVO customerDetailsVO,
            								   OrderInfoVO orderInfoVO,
            								   ScheduleVO scheduleVO) {

		orderInfoVO.setAction(apiParams.getOrderInfoVOaction());
		/*setAdvsvcType(java.lang.Short advsvcType)*/
		//orderInfoVO.setAgedMoney(AgedMoneyVOList);
		/*setAllTaxesExempted(boolean allTaxesExempted)
		setBasicRateConfirm(boolean basicRateConfirm)*/
		orderInfoVO.setBillDate(apiParams.getBillDate());
		/*setBillForm(java.lang.String billForm)*/
		//orderInfoVO.setBillFromDate(apiParams.getBillDate());
		/*setBillingGroup(int billingGroup)*/
		orderInfoVO.setBillToDate(apiParams.getBillDate());
		/*setCampaign(java.lang.String campaign)
		setCampaignVO(CampaignVO campaignVO)
		setCdwDate(java.util.Date cdwDate)*/
		//orderInfoVO.setChangeReasonCode(apiParams.getChangeReason());
		//derInfoVO.setChangeReasonDesc(apiParams.getCodCode());
		//orderInfoVO.setCodCode(apiParams.getCodCode());
		/*setCurCallDay(short curCallDay)
		setCurrentBalance(amdocs.core.Money currentBalance)*/
		//orderInfoVO.setCurrentTransactionTotals(curTransForecastTotalsVO);
		//orderInfoVO.setCycle(customerDetailsVO.getCycle());
		/*setDisconnectDate(java.util.Date disconnectDate)*/
		orderInfoVO.setDisconnectReasonCode(apiParams.getDisconnectReasonCode());
		/*setDisconnectReasonDesc(java.lang.String disconnectReasonDesc)
		setDiscountCode(java.lang.String discountCode)
		setDiscountDesc(java.lang.String discountDesc)*/
		//orderInfoVO.setDropTypeCode(siteDetailsVO.getDropTypeCode());
		/*setDwellingTypeCode(java.lang.String dwellingTypeCode)
		setEffectiveDateFlag(int effectiveDateFlag)*/
		//orderInfoVO.setEstimatedBillVO(estimatedBillVOList);
		/*setEstimatedNewMonthlyRate(amdocs.core.Money estimatedNewMonthlyRate)
		setEstimatedNextBill(amdocs.core.Money estimatedNextBill)*/
		//orderInfoVO.setFinalTransactionTotals(finalTransForecastTotalsVO);
		/*setFlashComment(java.lang.String flashComment)*/
		//orderInfoVO.setHasPromoRemvFrmStart(false);
		/*setIncrementalDepositRemain(amdocs.core.Money incrementalDepositRemain)
		setIncrementalInstallRemain(amdocs.core.Money incrementalInstallRemain)*/
		orderInfoVO.setInstallDate(customerDetailsVO.getInitialInstallDate());
		/*setIntlDestAnalysis(boolean intlDestAnalysis)
		setInvoiceExempt(java.lang.Boolean invoiceExempt)
		setIsAdvanceServiceOrder(boolean isAdvanceServiceOrder)
		setIsComplianceToOrderTime(boolean isComplianceToOrderTime)
		setIsCycleOverride(boolean isCycleOverride)
		setIsDispatchComplete(boolean isDispatchComplete)
		setIsFinalBillSent(boolean isFinalBillSent)
		setIsMduExempt(java.lang.Boolean isMduExempt)
		setIsPhNumPortedOut(java.lang.Boolean isPhNumPortedOut)
		setIsRouted(boolean isRouted)
		setIsTaxExempt(java.lang.Boolean isTaxExempt)*/
		orderInfoVO.setLastInstallDate(customerDetailsVO.getLastInstallDate());
		/*setLastStatementDate(java.util.Date lastStatementDate)
		setLocator(java.lang.String locator)
		setNatlDestAnalysis(boolean natlDestAnalysis)
		setNewCallDay(short newCallDay)*/
		orderInfoVO.setNewCycle(String.valueOf(customerDetailsVO.getCycle()));
		/*setNotDoneRsg(java.lang.String notDoneRsg)
		setOfferNumber(java.math.BigDecimal offerNumber)
		setOrderComment(java.lang.String orderComment)
		setOrderDate(java.util.Date orderDate)*/
		orderInfoVO.setOrderGroupSeq(apiParams.getOrderGroupSeq());
		/*setOrderNumber(java.math.BigDecimal orderNumber)
		setOrderReasonCode(java.lang.String orderReasonCode)
		setOrderReasonDesc(java.lang.String orderReasonDesc)
		setOrderStatus(java.lang.String orderStatus)
		setOrderStatusDesc(java.lang.String orderStatusDesc)
		setOrderTime(java.util.Date orderTime)
		setPriTariffTabDetails(PrimaryTartifTabVO[] priTariffTabDetails)*/
		orderInfoVO.setProrateFromDate(apiParams.getBillDate());
		orderInfoVO.setProrateToDate(apiParams.getBillDate());
		/*setReferenceBillDate(java.util.Date referenceBillDate)
		setReferenceDateType(int referenceDateType)*/
		//orderInfoVO.setReminderScheme(customerDetailsVO.getRemainderScheme());
		/*setRoutedDesc(java.lang.String routedDesc)
		setSalesReasonCode(java.lang.String salesReasonCode)
		setSalesReasonDesc(java.lang.String salesReasonDesc) */
		//orderInfoVO.setSalesRepId(apiParams.getSalesRepId());		
		/*setSalesRepLastName(java.lang.String salesRepLastName)*/
		orderInfoVO.setSchedule(scheduleVO);
		/*setSpecialInstruct1Code(java.lang.String specialInstruct1Code)
		setSpecialInstruct1Desc(java.lang.String specialInstruct1Desc)
		setSpecialInstruct2Code(java.lang.String specialInstruct2Code)
		setSpecialInstruct2Desc(java.lang.String specialInstruct2Desc)
		setSpecialInstruct3Code(java.lang.String specialInstruct3Code)
		setSpecialInstruct3Desc(java.lang.String specialInstruct3Desc)
		setSpecialRateAnalysis(boolean specialRateAnalysis)
		setSpecialRateCallLog(boolean SpecialRateCallLog)*/
		//orderInfoVO.setStatementScheme(customerDetailsVO.getStmtScheme());
		/*setSubTotalCharges(amdocs.core.Money subTotalCharges)
		setSummaryByOrigin(boolean summaryByOrigin)
		setSvcDependencyWip(boolean svcDependencyWip)
		setTaxExemptionsList(CustTaxExemptLocalVO[] taxExemptionsList)*/
		//if (wIPConstraintsVO.getTechId().getRequired())
		//orderInfoVO.setTechAssigned(apiParams.getTechId());   
		//}
		/*setTechLastName(java.lang.String techLastName)
		setTelcoChangeType(java.lang.Short telcoChangeType)
		setTermOverrideComment(java.lang.String termOverrideComment)
		setTotalCodAmount(amdocs.core.Money totalCodAmount)
		setWdwo(java.lang.String wdwo)
		setWipChangeProg(short wipChangeProg)
		setWipComment(java.lang.String wipComment)
		setWipDependency(int wipDependency)*/
		orderInfoVO.setWorkDoneDate(apiParams.getBillDate());
		orderInfoVO.setWorkDoneTime(apiParams.getBillDate());
		
		printOutput.printToShell(apiParams, 
		getClass().getName() + ":<OrderInfoVO>" + orderInfoVO.toString() + "</OrderInfoVO>", 
		orderInfoVO.toXml());
	}
	
	public void updateOrderInfoVOforInstall(Parameters apiParams, 
											PrintOutput printOutput,
											AgedMoneyVO[] agedMoneyVOList,
											CustomerDetailsVO customerDetailsVO,
											OrderGroupVO[] orderGroupVOList,
											OrderInfoVO orderInfoVO,
											ScheduleVO scheduleVO) {

		orderInfoVO.setAction(apiParams.getOrderInfoVOaction());
		/*setAdvsvcType(java.lang.Short advsvcType)*/
		orderInfoVO.setAgedMoney(agedMoneyVOList);
		/*setAllTaxesExempted(boolean allTaxesExempted)
		setBasicRateConfirm(boolean basicRateConfirm)*/
		orderInfoVO.setBillDate(apiParams.getBillDate());
		/*setBillForm(java.lang.String billForm)*/
		//orderInfoVO.setBillFromDate(apiParams.getBillDate());
		/*setBillingGroup(int billingGroup)*/
		orderInfoVO.setBillToDate(apiParams.getBillDate());
		/*setCampaign(java.lang.String campaign)
		setCampaignVO(CampaignVO campaignVO)
		setCdwDate(java.util.Date cdwDate)*/
		//orderInfoVO.setChangeReasonCode(apiParams.getChangeReason());
		/*setChangeReasonDesc(java.lang.String changeReasonDesc)
		setCodCode(java.lang.String codCode)
		setCodDesc(java.lang.String codDesc)
		setCurCallDay(short curCallDay)
		setCurrentBalance(amdocs.core.Money currentBalance)*/
		//orderInfoVO.setCurrentTransactionTotals(curTransForecastTotalsVO);
		orderInfoVO.setCycle(apiParams.getCycle());
		/*setDisconnectDate(java.util.Date disconnectDate)
		setDisconnectReasonCode(java.lang.String disconnectReasonCode)
		setDisconnectReasonDesc(java.lang.String disconnectReasonDesc)
		setDiscountCode(java.lang.String discountCode)
		setDiscountDesc(java.lang.String discountDesc)*/
		//orderInfoVO.setDropTypeCode(siteDetailsVO.getDropTypeCode());
		/*setDwellingTypeCode(java.lang.String dwellingTypeCode)
		setEffectiveDateFlag(int effectiveDateFlag)*/
		//orderInfoVO.setEstimatedBillVO(estimatedBillVOList);
		/*setEstimatedNewMonthlyRate(amdocs.core.Money estimatedNewMonthlyRate)
		setEstimatedNextBill(amdocs.core.Money estimatedNextBill)*/
		//orderInfoVO.setFinalTransactionTotals(finalTransForecastTotalsVO);
		/*setFlashComment(java.lang.String flashComment)*/
		//orderInfoVO.setHasPromoRemvFrmStart(false);
		/*setIncrementalDepositRemain(amdocs.core.Money incrementalDepositRemain)
		setIncrementalInstallRemain(amdocs.core.Money incrementalInstallRemain)*/
		orderInfoVO.setInstallDate(apiParams.getBillDate());
		/*setIntlDestAnalysis(boolean intlDestAnalysis)
		setInvoiceExempt(java.lang.Boolean invoiceExempt)
		setIsAdvanceServiceOrder(boolean isAdvanceServiceOrder)
		setIsComplianceToOrderTime(boolean isComplianceToOrderTime)
		setIsCycleOverride(boolean isCycleOverride)
		setIsDispatchComplete(boolean isDispatchComplete)
		setIsFinalBillSent(boolean isFinalBillSent)
		setIsMduExempt(java.lang.Boolean isMduExempt)
		setIsPhNumPortedOut(java.lang.Boolean isPhNumPortedOut)
		setIsRouted(boolean isRouted)
		setIsTaxExempt(java.lang.Boolean isTaxExempt)*/
		orderInfoVO.setLastInstallDate(customerDetailsVO.getLastInstallDate());
		/*setLastStatementDate(java.util.Date lastStatementDate)
		setLocator(java.lang.String locator)
		setNatlDestAnalysis(boolean natlDestAnalysis)
		setNewCallDay(short newCallDay)*/
		orderInfoVO.setNewCycle(Integer.toString(apiParams.getCycle()));
		/*setNotDoneRsg(java.lang.String notDoneRsg)
		setOfferNumber(java.math.BigDecimal offerNumber)
		setOrderComment(java.lang.String orderComment)
		setOrderDate(java.util.Date orderDate)*/
		orderInfoVO.setOrderGroupSeq(orderGroupVOList[0].getOrderGroupSeq());
		/*setOrderNumber(java.math.BigDecimal orderNumber)
		setOrderReasonCode(java.lang.String orderReasonCode)
		setOrderReasonDesc(java.lang.String orderReasonDesc)
		setOrderStatus(java.lang.String orderStatus)
		setOrderStatusDesc(java.lang.String orderStatusDesc)
		setOrderTime(java.util.Date orderTime)
		setPriTariffTabDetails(PrimaryTartifTabVO[] priTariffTabDetails)*/
		orderInfoVO.setProrateFromDate(apiParams.getBillDate());
		orderInfoVO.setProrateToDate(apiParams.getBillDate());
		/*setReferenceBillDate(java.util.Date referenceBillDate)
		setReferenceDateType(int referenceDateType)*/
		orderInfoVO.setReminderScheme(apiParams.getReminderScheme());
		/*setRoutedDesc(java.lang.String routedDesc)
		setSalesReasonCode(java.lang.String salesReasonCode)
		setSalesReasonDesc(java.lang.String salesReasonDesc) */
		orderInfoVO.setSalesRepId(apiParams.getSalesRepId());		
		/*setSalesRepLastName(java.lang.String salesRepLastName)*/
		orderInfoVO.setSchedule(scheduleVO);
		/*setSpecialInstruct1Code(java.lang.String specialInstruct1Code)
		setSpecialInstruct1Desc(java.lang.String specialInstruct1Desc)
		setSpecialInstruct2Code(java.lang.String specialInstruct2Code)
		setSpecialInstruct2Desc(java.lang.String specialInstruct2Desc)
		setSpecialInstruct3Code(java.lang.String specialInstruct3Code)
		setSpecialInstruct3Desc(java.lang.String specialInstruct3Desc)
		setSpecialRateAnalysis(boolean specialRateAnalysis)
		setSpecialRateCallLog(boolean SpecialRateCallLog)*/
		orderInfoVO.setStatementScheme(apiParams.getStatementScheme());
		/*setSubTotalCharges(amdocs.core.Money subTotalCharges)
		setSummaryByOrigin(boolean summaryByOrigin)
		setSvcDependencyWip(boolean svcDependencyWip)
		setTaxExemptionsList(CustTaxExemptLocalVO[] taxExemptionsList)*/
		//if (wIPConstraintsVO.getTechId().getRequired())
		//orderInfoVO.setTechAssigned(apiParams.getTechId());   
		//}
		/*setTechLastName(java.lang.String techLastName)
		setTelcoChangeType(java.lang.Short telcoChangeType)
		setTermOverrideComment(java.lang.String termOverrideComment)
		setTotalCodAmount(amdocs.core.Money totalCodAmount)
		setWdwo(java.lang.String wdwo)
		setWipChangeProg(short wipChangeProg)
		setWipComment(java.lang.String wipComment)
		setWipDependency(int wipDependency)*/
		orderInfoVO.setWorkDoneDate(apiParams.getBillDate());
		orderInfoVO.setWorkDoneTime(apiParams.getBillDate());
		
		printOutput.printToShell(apiParams, 
		getClass().getName() + ":<OrderInfoVO>" + orderInfoVO.toString() + "</OrderInfoVO>", 
		orderInfoVO.toXml());
	}
	
	public void updateOrderInfoVOforRescheduleOrder(Parameters apiParams, 
            										PrintOutput printOutput,
            										CurTransForecastTotalsVO curTransForecastTotalsVO,
            										CustomerDetailsVO customerDetailsVO,
            										FinalTransForecastTotalsVO finalTransForecastTotalsVO,
            										OrderGroupVO[] orderGroupVOList,
            										OrderInfoVO orderInfoVO,
            										ScheduleVO scheduleVO) {

		orderInfoVO.setAction(apiParams.getOrderInfoVOaction());
		/*setAdvsvcType(java.lang.Short advsvcType)*/
		//orderInfoVO.setAgedMoney(AgedMoneyVOList);
		/*setAllTaxesExempted(boolean allTaxesExempted)
		setBasicRateConfirm(boolean basicRateConfirm)*/
		//orderInfoVO.setBillDate(apiParams.getBillDate());
		/*setBillForm(java.lang.String billForm)*/
		orderInfoVO.setBillFromDate(apiParams.getBillDate());
		/*setBillingGroup(int billingGroup)*/
		orderInfoVO.setBillToDate(apiParams.getBillDate());
		/*setCampaign(java.lang.String campaign)
		setCampaignVO(CampaignVO campaignVO)
		setCdwDate(java.util.Date cdwDate)*/
		//orderInfoVO.setChangeReasonCode(apiParams.getChangeReason());
		//derInfoVO.setChangeReasonDesc(apiParams.getCodCode());
		//orderInfoVO.setCodCode(apiParams.getCodCode());
		/*setCurCallDay(short curCallDay)
		setCurrentBalance(amdocs.core.Money currentBalance)*/
		orderInfoVO.setCurrentTransactionTotals(curTransForecastTotalsVO);
		//orderInfoVO.setCycle(customerDetailsVO.getCycle());
		/*setDisconnectDate(java.util.Date disconnectDate)
		setDisconnectReasonCode(java.lang.String disconnectReasonCode)
		setDisconnectReasonDesc(java.lang.String disconnectReasonDesc)
		setDiscountCode(java.lang.String discountCode)
		setDiscountDesc(java.lang.String discountDesc)*/
		//orderInfoVO.setDropTypeCode(siteDetailsVO.getDropTypeCode());
		/*setDwellingTypeCode(java.lang.String dwellingTypeCode)
		setEffectiveDateFlag(int effectiveDateFlag)*/
		//orderInfoVO.setEstimatedBillVO(estimatedBillVOList);
		/*setEstimatedNewMonthlyRate(amdocs.core.Money estimatedNewMonthlyRate)
		setEstimatedNextBill(amdocs.core.Money estimatedNextBill)*/
		orderInfoVO.setFinalTransactionTotals(finalTransForecastTotalsVO);
		/*setFlashComment(java.lang.String flashComment)*/
		//orderInfoVO.setHasPromoRemvFrmStart(false);
		/*setIncrementalDepositRemain(amdocs.core.Money incrementalDepositRemain)
		setIncrementalInstallRemain(amdocs.core.Money incrementalInstallRemain)*/
		//orderInfoVO.setInstallDate(customerDetailsVO.getInitialInstallDate());
		/*setIntlDestAnalysis(boolean intlDestAnalysis)
		setInvoiceExempt(java.lang.Boolean invoiceExempt)
		setIsAdvanceServiceOrder(boolean isAdvanceServiceOrder)
		setIsComplianceToOrderTime(boolean isComplianceToOrderTime)
		setIsCycleOverride(boolean isCycleOverride)
		setIsDispatchComplete(boolean isDispatchComplete)
		setIsFinalBillSent(boolean isFinalBillSent)
		setIsMduExempt(java.lang.Boolean isMduExempt)
		setIsPhNumPortedOut(java.lang.Boolean isPhNumPortedOut)
		setIsRouted(boolean isRouted)
		setIsTaxExempt(java.lang.Boolean isTaxExempt)*/
		//orderInfoVO.setLastInstallDate(customerDetailsVO.getLastInstallDate());
		/*setLastStatementDate(java.util.Date lastStatementDate)
		setLocator(java.lang.String locator)
		setNatlDestAnalysis(boolean natlDestAnalysis)
		setNewCallDay(short newCallDay)*/
		//orderInfoVO.setNewCycle(String.valueOf(customerDetailsVO.getCycle()));
		/*setNotDoneRsg(java.lang.String notDoneRsg)
		setOfferNumber(java.math.BigDecimal offerNumber)
		setOrderComment(java.lang.String orderComment)
		setOrderDate(java.util.Date orderDate)*/
		orderInfoVO.setOrderGroupSeq(apiParams.getOrderGroupSeq());
		/*setOrderNumber(java.math.BigDecimal orderNumber)
		setOrderReasonCode(java.lang.String orderReasonCode)
		setOrderReasonDesc(java.lang.String orderReasonDesc)
		setOrderStatus(java.lang.String orderStatus)
		setOrderStatusDesc(java.lang.String orderStatusDesc)
		setOrderTime(java.util.Date orderTime)
		setPriTariffTabDetails(PrimaryTartifTabVO[] priTariffTabDetails)*/
		orderInfoVO.setProrateFromDate(apiParams.getBillDate());
		orderInfoVO.setProrateToDate(apiParams.getBillDate());
		/*setReferenceBillDate(java.util.Date referenceBillDate)
		setReferenceDateType(int referenceDateType)*/
		//orderInfoVO.setReminderScheme(customerDetailsVO.getRemainderScheme());
		/*setRoutedDesc(java.lang.String routedDesc)
		setSalesReasonCode(java.lang.String salesReasonCode)
		setSalesReasonDesc(java.lang.String salesReasonDesc) */
		//orderInfoVO.setSalesRepId(apiParams.getSalesRepId());		
		/*setSalesRepLastName(java.lang.String salesRepLastName)*/
		//orderInfoVO.setSchedule(scheduleVO);
		/*setSpecialInstruct1Code(java.lang.String specialInstruct1Code)
		setSpecialInstruct1Desc(java.lang.String specialInstruct1Desc)
		setSpecialInstruct2Code(java.lang.String specialInstruct2Code)
		setSpecialInstruct2Desc(java.lang.String specialInstruct2Desc)
		setSpecialInstruct3Code(java.lang.String specialInstruct3Code)
		setSpecialInstruct3Desc(java.lang.String specialInstruct3Desc)
		setSpecialRateAnalysis(boolean specialRateAnalysis)
		setSpecialRateCallLog(boolean SpecialRateCallLog)*/
		//orderInfoVO.setStatementScheme(customerDetailsVO.getStmtScheme());
		/*setSubTotalCharges(amdocs.core.Money subTotalCharges)
		setSummaryByOrigin(boolean summaryByOrigin)
		setSvcDependencyWip(boolean svcDependencyWip)
		setTaxExemptionsList(CustTaxExemptLocalVO[] taxExemptionsList)*/
		//if (wIPConstraintsVO.getTechId().getRequired())
		//orderInfoVO.setTechAssigned(apiParams.getTechId());   
		//}
		/*setTechLastName(java.lang.String techLastName)
		setTelcoChangeType(java.lang.Short telcoChangeType)
		setTermOverrideComment(java.lang.String termOverrideComment)
		setTotalCodAmount(amdocs.core.Money totalCodAmount)
		setWdwo(java.lang.String wdwo)
		setWipChangeProg(short wipChangeProg)
		setWipComment(java.lang.String wipComment)
		setWipDependency(int wipDependency)*/
		//orderInfoVO.setWorkDoneDate(apiParams.getBillDate());
		//orderInfoVO.setWorkDoneTime(apiParams.getBillDate());
		
		printOutput.printToShell(apiParams, 
		getClass().getName() + ":<OrderInfoVO>" + orderInfoVO.toString() + "</OrderInfoVO>", 
		orderInfoVO.toXml());
	}
	
	public void updateOrderInfoVOforRescheduleOrderChange(Parameters apiParams, 
			PrintOutput printOutput,
			CurTransForecastTotalsVO curTransForecastTotalsVO,
			CustomerDetailsVO customerDetailsVO,
			FinalTransForecastTotalsVO finalTransForecastTotalsVO,
			OrderGroupVO[] orderGroupVOList,
			OrderInfoVO orderInfoVO,
			ScheduleVO scheduleVO) {

		orderInfoVO.setAction(apiParams.getOrderInfoVOaction());
		/*setAdvsvcType(java.lang.Short advsvcType)*/
		//orderInfoVO.setAgedMoney(AgedMoneyVOList);
		/*setAllTaxesExempted(boolean allTaxesExempted)
		setBasicRateConfirm(boolean basicRateConfirm)*/
		//orderInfoVO.setBillDate(apiParams.getBillDate());
		/*setBillForm(java.lang.String billForm)*/
		orderInfoVO.setBillFromDate(apiParams.getBillDate());
		/*setBillingGroup(int billingGroup)*/
		orderInfoVO.setBillToDate(apiParams.getBillDate());
		/*setCampaign(java.lang.String campaign)
		setCampaignVO(CampaignVO campaignVO)
		setCdwDate(java.util.Date cdwDate)*/
		//orderInfoVO.setChangeReasonCode(apiParams.getChangeReason());
		//derInfoVO.setChangeReasonDesc(apiParams.getCodCode());
		//orderInfoVO.setCodCode(apiParams.getCodCode());
		/*setCurCallDay(short curCallDay)
		setCurrentBalance(amdocs.core.Money currentBalance)*/
		orderInfoVO.setCurrentTransactionTotals(curTransForecastTotalsVO);
		//orderInfoVO.setCycle(customerDetailsVO.getCycle());
		/*setDisconnectDate(java.util.Date disconnectDate)
		setDisconnectReasonCode(java.lang.String disconnectReasonCode)
		setDisconnectReasonDesc(java.lang.String disconnectReasonDesc)
		setDiscountCode(java.lang.String discountCode)
		setDiscountDesc(java.lang.String discountDesc)*/
		//orderInfoVO.setDropTypeCode(siteDetailsVO.getDropTypeCode());
		/*setDwellingTypeCode(java.lang.String dwellingTypeCode)
		setEffectiveDateFlag(int effectiveDateFlag)*/
		//orderInfoVO.setEstimatedBillVO(estimatedBillVOList);
		/*setEstimatedNewMonthlyRate(amdocs.core.Money estimatedNewMonthlyRate)
		setEstimatedNextBill(amdocs.core.Money estimatedNextBill)*/
		orderInfoVO.setFinalTransactionTotals(finalTransForecastTotalsVO);
		/*setFlashComment(java.lang.String flashComment)*/
		//orderInfoVO.setHasPromoRemvFrmStart(false);
		/*setIncrementalDepositRemain(amdocs.core.Money incrementalDepositRemain)
		setIncrementalInstallRemain(amdocs.core.Money incrementalInstallRemain)*/
		//orderInfoVO.setInstallDate(customerDetailsVO.getInitialInstallDate());
		/*setIntlDestAnalysis(boolean intlDestAnalysis)
		setInvoiceExempt(java.lang.Boolean invoiceExempt)
		setIsAdvanceServiceOrder(boolean isAdvanceServiceOrder)
		setIsComplianceToOrderTime(boolean isComplianceToOrderTime)
		setIsCycleOverride(boolean isCycleOverride)
		setIsDispatchComplete(boolean isDispatchComplete)
		setIsFinalBillSent(boolean isFinalBillSent)
		setIsMduExempt(java.lang.Boolean isMduExempt)
		setIsPhNumPortedOut(java.lang.Boolean isPhNumPortedOut)
		setIsRouted(boolean isRouted)
		setIsTaxExempt(java.lang.Boolean isTaxExempt)*/
		//orderInfoVO.setLastInstallDate(customerDetailsVO.getLastInstallDate());
		/*setLastStatementDate(java.util.Date lastStatementDate)
		setLocator(java.lang.String locator)
		setNatlDestAnalysis(boolean natlDestAnalysis)
		setNewCallDay(short newCallDay)*/
		//orderInfoVO.setNewCycle(String.valueOf(customerDetailsVO.getCycle()));
		/*setNotDoneRsg(java.lang.String notDoneRsg)
		setOfferNumber(java.math.BigDecimal offerNumber)
		setOrderComment(java.lang.String orderComment)
		setOrderDate(java.util.Date orderDate)*/
		orderInfoVO.setOrderGroupSeq(apiParams.getOrderGroupSeq());
		/*setOrderNumber(java.math.BigDecimal orderNumber)
		setOrderReasonCode(java.lang.String orderReasonCode)
		setOrderReasonDesc(java.lang.String orderReasonDesc)
		setOrderStatus(java.lang.String orderStatus)
		setOrderStatusDesc(java.lang.String orderStatusDesc)
		setOrderTime(java.util.Date orderTime)
		setPriTariffTabDetails(PrimaryTartifTabVO[] priTariffTabDetails)*/
		orderInfoVO.setProrateFromDate(apiParams.getBillDate());
		orderInfoVO.setProrateToDate(apiParams.getBillDate());
		/*setReferenceBillDate(java.util.Date referenceBillDate)
		setReferenceDateType(int referenceDateType)*/
		//orderInfoVO.setReminderScheme(customerDetailsVO.getRemainderScheme());
		/*setRoutedDesc(java.lang.String routedDesc)
		setSalesReasonCode(java.lang.String salesReasonCode)
		setSalesReasonDesc(java.lang.String salesReasonDesc) */
		//orderInfoVO.setSalesRepId(apiParams.getSalesRepId());		
		/*setSalesRepLastName(java.lang.String salesRepLastName)*/
		//orderInfoVO.setSchedule(scheduleVO);
		/*setSpecialInstruct1Code(java.lang.String specialInstruct1Code)
		setSpecialInstruct1Desc(java.lang.String specialInstruct1Desc)
		setSpecialInstruct2Code(java.lang.String specialInstruct2Code)
		setSpecialInstruct2Desc(java.lang.String specialInstruct2Desc)
		setSpecialInstruct3Code(java.lang.String specialInstruct3Code)
		setSpecialInstruct3Desc(java.lang.String specialInstruct3Desc)
		setSpecialRateAnalysis(boolean specialRateAnalysis)
		setSpecialRateCallLog(boolean SpecialRateCallLog)*/
		//orderInfoVO.setStatementScheme(customerDetailsVO.getStmtScheme());
		/*setSubTotalCharges(amdocs.core.Money subTotalCharges)
		setSummaryByOrigin(boolean summaryByOrigin)
		setSvcDependencyWip(boolean svcDependencyWip)
		setTaxExemptionsList(CustTaxExemptLocalVO[] taxExemptionsList)*/
		//if (wIPConstraintsVO.getTechId().getRequired())
		//orderInfoVO.setTechAssigned(apiParams.getTechId());   
		//}
		/*setTechLastName(java.lang.String techLastName)
		setTelcoChangeType(java.lang.Short telcoChangeType)
		setTermOverrideComment(java.lang.String termOverrideComment)
		setTotalCodAmount(amdocs.core.Money totalCodAmount)
		setWdwo(java.lang.String wdwo)
		setWipChangeProg(short wipChangeProg)
		setWipComment(java.lang.String wipComment)
		setWipDependency(int wipDependency)*/
		//orderInfoVO.setWorkDoneDate(apiParams.getBillDate());
		//orderInfoVO.setWorkDoneTime(apiParams.getBillDate());
		
		printOutput.printToShell(apiParams, 
		getClass().getName() + ":<OrderInfoVO>" + orderInfoVO.toString() + "</OrderInfoVO>", 
		orderInfoVO.toXml());
	}

	public void updateOrderInfoVOforRescheduleOrderDatesOnly(Parameters apiParams, 
					PrintOutput printOutput,
					CurTransForecastTotalsVO curTransForecastTotalsVO,
					CustomerDetailsVO customerDetailsVO,
					FinalTransForecastTotalsVO finalTransForecastTotalsVO,
					OrderGroupVO[] orderGroupVOList,
					OrderInfoVO orderInfoVO,
					ScheduleVO scheduleVO) {

		orderInfoVO.setAction(apiParams.getOrderInfoVOaction());
		/*setAdvsvcType(java.lang.Short advsvcType)*/
		//orderInfoVO.setAgedMoney(AgedMoneyVOList);
		/*setAllTaxesExempted(boolean allTaxesExempted)
		setBasicRateConfirm(boolean basicRateConfirm)*/
		orderInfoVO.setBillDate(apiParams.getBillDate());
		/*setBillForm(java.lang.String billForm)*/
		orderInfoVO.setBillFromDate(apiParams.getBillDate());
		/*setBillingGroup(int billingGroup)*/
		orderInfoVO.setBillToDate(apiParams.getBillDate());
		/*setCampaign(java.lang.String campaign)
		setCampaignVO(CampaignVO campaignVO)
		setCdwDate(java.util.Date cdwDate)*/
		//orderInfoVO.setChangeReasonCode(apiParams.getChangeReason());
		//derInfoVO.setChangeReasonDesc(apiParams.getCodCode());
		//orderInfoVO.setCodCode(apiParams.getCodCode());
		/*setCurCallDay(short curCallDay)
		setCurrentBalance(amdocs.core.Money currentBalance)*/
		orderInfoVO.setCurrentTransactionTotals(curTransForecastTotalsVO);
		//orderInfoVO.setCycle(customerDetailsVO.getCycle());
		orderInfoVO.setDisconnectDate(apiParams.getScheduleDate());
		/*setDisconnectReasonCode(java.lang.String disconnectReasonCode)
		setDisconnectReasonDesc(java.lang.String disconnectReasonDesc)
		setDiscountCode(java.lang.String discountCode)
		setDiscountDesc(java.lang.String discountDesc)*/
		//orderInfoVO.setDropTypeCode(siteDetailsVO.getDropTypeCode());
		/*setDwellingTypeCode(java.lang.String dwellingTypeCode)
		setEffectiveDateFlag(int effectiveDateFlag)*/
		//orderInfoVO.setEstimatedBillVO(estimatedBillVOList);
		/*setEstimatedNewMonthlyRate(amdocs.core.Money estimatedNewMonthlyRate)
		setEstimatedNextBill(amdocs.core.Money estimatedNextBill)*/
		orderInfoVO.setFinalTransactionTotals(finalTransForecastTotalsVO);
		/*setFlashComment(java.lang.String flashComment)*/
		//orderInfoVO.setHasPromoRemvFrmStart(false);
		/*setIncrementalDepositRemain(amdocs.core.Money incrementalDepositRemain)
		setIncrementalInstallRemain(amdocs.core.Money incrementalInstallRemain)*/
		//orderInfoVO.setInstallDate(customerDetailsVO.getInitialInstallDate());
		/*setIntlDestAnalysis(boolean intlDestAnalysis)
		setInvoiceExempt(java.lang.Boolean invoiceExempt)
		setIsAdvanceServiceOrder(boolean isAdvanceServiceOrder)
		setIsComplianceToOrderTime(boolean isComplianceToOrderTime)
		setIsCycleOverride(boolean isCycleOverride)
		setIsDispatchComplete(boolean isDispatchComplete)
		setIsFinalBillSent(boolean isFinalBillSent)
		setIsMduExempt(java.lang.Boolean isMduExempt)
		setIsPhNumPortedOut(java.lang.Boolean isPhNumPortedOut)
		setIsRouted(boolean isRouted)
		setIsTaxExempt(java.lang.Boolean isTaxExempt)*/
		//orderInfoVO.setLastInstallDate(customerDetailsVO.getLastInstallDate());
		/*setLastStatementDate(java.util.Date lastStatementDate)
		setLocator(java.lang.String locator)
		setNatlDestAnalysis(boolean natlDestAnalysis)
		setNewCallDay(short newCallDay)*/
		//orderInfoVO.setNewCycle(String.valueOf(customerDetailsVO.getCycle()));
		/*setNotDoneRsg(java.lang.String notDoneRsg)
		setOfferNumber(java.math.BigDecimal offerNumber)
		setOrderComment(java.lang.String orderComment)
		setOrderDate(java.util.Date orderDate)*/
		orderInfoVO.setOrderGroupSeq(apiParams.getOrderGroupSeq());
		/*setOrderNumber(java.math.BigDecimal orderNumber)
		setOrderReasonCode(java.lang.String orderReasonCode)
		setOrderReasonDesc(java.lang.String orderReasonDesc)
		setOrderStatus(java.lang.String orderStatus)
		setOrderStatusDesc(java.lang.String orderStatusDesc)
		setOrderTime(java.util.Date orderTime)
		setPriTariffTabDetails(PrimaryTartifTabVO[] priTariffTabDetails)*/
		orderInfoVO.setProrateFromDate(apiParams.getBillDate());
		orderInfoVO.setProrateToDate(apiParams.getBillDate());
		/*setReferenceBillDate(java.util.Date referenceBillDate)
		setReferenceDateType(int referenceDateType)*/
		//orderInfoVO.setReminderScheme(customerDetailsVO.getRemainderScheme());
		/*setRoutedDesc(java.lang.String routedDesc)
		setSalesReasonCode(java.lang.String salesReasonCode)
		setSalesReasonDesc(java.lang.String salesReasonDesc) */
		//orderInfoVO.setSalesRepId(apiParams.getSalesRepId());		
		/*setSalesRepLastName(java.lang.String salesRepLastName)*/
		//orderInfoVO.setSchedule(scheduleVO);
		/*setSpecialInstruct1Code(java.lang.String specialInstruct1Code)
		setSpecialInstruct1Desc(java.lang.String specialInstruct1Desc)
		setSpecialInstruct2Code(java.lang.String specialInstruct2Code)
		setSpecialInstruct2Desc(java.lang.String specialInstruct2Desc)
		setSpecialInstruct3Code(java.lang.String specialInstruct3Code)
		setSpecialInstruct3Desc(java.lang.String specialInstruct3Desc)
		setSpecialRateAnalysis(boolean specialRateAnalysis)
		setSpecialRateCallLog(boolean SpecialRateCallLog)*/
		//orderInfoVO.setStatementScheme(customerDetailsVO.getStmtScheme());
		/*setSubTotalCharges(amdocs.core.Money subTotalCharges)
		setSummaryByOrigin(boolean summaryByOrigin)
		setSvcDependencyWip(boolean svcDependencyWip)
		setTaxExemptionsList(CustTaxExemptLocalVO[] taxExemptionsList)*/
		//if (wIPConstraintsVO.getTechId().getRequired())
		//orderInfoVO.setTechAssigned(apiParams.getTechId());   
		//}
		/*setTechLastName(java.lang.String techLastName)
		setTelcoChangeType(java.lang.Short telcoChangeType)
		setTermOverrideComment(java.lang.String termOverrideComment)
		setTotalCodAmount(amdocs.core.Money totalCodAmount)
		setWdwo(java.lang.String wdwo)
		setWipChangeProg(short wipChangeProg)
		setWipComment(java.lang.String wipComment)
		setWipDependency(int wipDependency)*/
		//orderInfoVO.setWorkDoneDate(apiParams.getBillDate());
		//orderInfoVO.setWorkDoneTime(apiParams.getBillDate());
		
		printOutput.printToShell(apiParams, 
		getClass().getName() + ":<OrderInfoVO>" + orderInfoVO.toString() + "</OrderInfoVO>", 
		orderInfoVO.toXml());
		}
		
		public void updateOrderInfoVOforRescheduleSRO(Parameters apiParams, 
		PrintOutput printOutput,
		CurTransForecastTotalsVO curTransForecastTotalsVO,
		CustomerDetailsVO customerDetailsVO,
		FinalTransForecastTotalsVO finalTransForecastTotalsVO,
		OrderGroupVO[] orderGroupVOList,
		OrderInfoVO orderInfoVO,
		ScheduleVO scheduleVO) {
		
		orderInfoVO.setAction(apiParams.getOrderInfoVOaction());
		/*setAdvsvcType(java.lang.Short advsvcType)*/
		//orderInfoVO.setAgedMoney(AgedMoneyVOList);
		/*setAllTaxesExempted(boolean allTaxesExempted)
		setBasicRateConfirm(boolean basicRateConfirm)*/
		orderInfoVO.setBillDate(apiParams.getBillDate());
		/*setBillForm(java.lang.String billForm)*/
		orderInfoVO.setBillFromDate(apiParams.getBillDate());
		/*setBillingGroup(int billingGroup)*/
		orderInfoVO.setBillToDate(apiParams.getBillDate());
		/*setCampaign(java.lang.String campaign)
		setCampaignVO(CampaignVO campaignVO)
		setCdwDate(java.util.Date cdwDate)*/
		//orderInfoVO.setChangeReasonCode(apiParams.getChangeReason());
		//derInfoVO.setChangeReasonDesc(apiParams.getCodCode());
		//orderInfoVO.setCodCode(apiParams.getCodCode());
		/*setCurCallDay(short curCallDay)
		setCurrentBalance(amdocs.core.Money currentBalance)*/
		orderInfoVO.setCurrentTransactionTotals(curTransForecastTotalsVO);
		// orderInfoVO.setCycle(customerDetailsVO.getCycle());
		orderInfoVO.setDisconnectDate(apiParams.getScheduleDate());
		/*setDisconnectReasonCode(java.lang.String disconnectReasonCode)
		setDisconnectReasonDesc(java.lang.String disconnectReasonDesc)
		setDiscountCode(java.lang.String discountCode)
		setDiscountDesc(java.lang.String discountDesc)*/
		//orderInfoVO.setDropTypeCode(siteDetailsVO.getDropTypeCode());
		/*setDwellingTypeCode(java.lang.String dwellingTypeCode)
		setEffectiveDateFlag(int effectiveDateFlag)*/
		//orderInfoVO.setEstimatedBillVO(estimatedBillVOList);
		/*setEstimatedNewMonthlyRate(amdocs.core.Money estimatedNewMonthlyRate)
		setEstimatedNextBill(amdocs.core.Money estimatedNextBill)*/
		orderInfoVO.setFinalTransactionTotals(finalTransForecastTotalsVO);
		/*setFlashComment(java.lang.String flashComment)*/
		//orderInfoVO.setHasPromoRemvFrmStart(false);
		/*setIncrementalDepositRemain(amdocs.core.Money incrementalDepositRemain)
		setIncrementalInstallRemain(amdocs.core.Money incrementalInstallRemain)*/
		//orderInfoVO.setInstallDate(customerDetailsVO.getInitialInstallDate());
		/*setIntlDestAnalysis(boolean intlDestAnalysis)
		setInvoiceExempt(java.lang.Boolean invoiceExempt)
		setIsAdvanceServiceOrder(boolean isAdvanceServiceOrder)
		setIsComplianceToOrderTime(boolean isComplianceToOrderTime)
		setIsCycleOverride(boolean isCycleOverride)
		setIsDispatchComplete(boolean isDispatchComplete)
		setIsFinalBillSent(boolean isFinalBillSent)
		setIsMduExempt(java.lang.Boolean isMduExempt)
		setIsPhNumPortedOut(java.lang.Boolean isPhNumPortedOut)
		setIsRouted(boolean isRouted)
		setIsTaxExempt(java.lang.Boolean isTaxExempt)*/
		//orderInfoVO.setLastInstallDate(customerDetailsVO.getLastInstallDate());
		/*setLastStatementDate(java.util.Date lastStatementDate)
		setLocator(java.lang.String locator)
		setNatlDestAnalysis(boolean natlDestAnalysis)
		setNewCallDay(short newCallDay)*/
		//orderInfoVO.setNewCycle(String.valueOf(customerDetailsVO.getCycle()));
		/*setNotDoneRsg(java.lang.String notDoneRsg)
		setOfferNumber(java.math.BigDecimal offerNumber)
		setOrderComment(java.lang.String orderComment)
		setOrderDate(java.util.Date orderDate)*/
		orderInfoVO.setOrderGroupSeq(apiParams.getOrderGroupSeq());
		/*setOrderNumber(java.math.BigDecimal orderNumber)
		setOrderReasonCode(java.lang.String orderReasonCode)
		setOrderReasonDesc(java.lang.String orderReasonDesc)
		setOrderStatus(java.lang.String orderStatus)
		setOrderStatusDesc(java.lang.String orderStatusDesc)
		setOrderTime(java.util.Date orderTime)
		setPriTariffTabDetails(PrimaryTartifTabVO[] priTariffTabDetails)*/
		orderInfoVO.setProrateFromDate(apiParams.getBillDate());
		orderInfoVO.setProrateToDate(apiParams.getBillDate());
		/*setReferenceBillDate(java.util.Date referenceBillDate)
		setReferenceDateType(int referenceDateType)*/
		//orderInfoVO.setReminderScheme(customerDetailsVO.getRemainderScheme());
		/*setRoutedDesc(java.lang.String routedDesc)
		setSalesReasonCode(java.lang.String salesReasonCode)
		setSalesReasonDesc(java.lang.String salesReasonDesc) */
		//orderInfoVO.setSalesRepId(apiParams.getSalesRepId());		
		/*setSalesRepLastName(java.lang.String salesRepLastName)*/
		//orderInfoVO.setSchedule(scheduleVO);
		/*setSpecialInstruct1Code(java.lang.String specialInstruct1Code)
		setSpecialInstruct1Desc(java.lang.String specialInstruct1Desc)
		setSpecialInstruct2Code(java.lang.String specialInstruct2Code)
		setSpecialInstruct2Desc(java.lang.String specialInstruct2Desc)
		setSpecialInstruct3Code(java.lang.String specialInstruct3Code)
		setSpecialInstruct3Desc(java.lang.String specialInstruct3Desc)
		setSpecialRateAnalysis(boolean specialRateAnalysis)
		setSpecialRateCallLog(boolean SpecialRateCallLog)*/
		//orderInfoVO.setStatementScheme(customerDetailsVO.getStmtScheme());
		/*setSubTotalCharges(amdocs.core.Money subTotalCharges)
		setSummaryByOrigin(boolean summaryByOrigin)
		setSvcDependencyWip(boolean svcDependencyWip)
		setTaxExemptionsList(CustTaxExemptLocalVO[] taxExemptionsList)*/
		//if (wIPConstraintsVO.getTechId().getRequired())
		//orderInfoVO.setTechAssigned(apiParams.getTechId());   
		//}
		/*setTechLastName(java.lang.String techLastName)
		setTelcoChangeType(java.lang.Short telcoChangeType)
		setTermOverrideComment(java.lang.String termOverrideComment)
		setTotalCodAmount(amdocs.core.Money totalCodAmount)
		setWdwo(java.lang.String wdwo)
		setWipChangeProg(short wipChangeProg)
		setWipComment(java.lang.String wipComment)
		setWipDependency(int wipDependency)*/
		//orderInfoVO.setWorkDoneDate(apiParams.getBillDate());
		//orderInfoVO.setWorkDoneTime(apiParams.getBillDate());
		
		printOutput.printToShell(apiParams, 
		getClass().getName() + ":<OrderInfoVO>" + orderInfoVO.toString() + "</OrderInfoVO>", 
		orderInfoVO.toXml());
	}
}
