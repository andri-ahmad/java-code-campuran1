package app.set;

import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.valueobject.accountconstraints.WIPConstraintsVO;
import amdocs.amsp.valueobject.order.CurTransForecastTotalsVO;
import amdocs.amsp.valueobject.order.EstimatedBillVO;
import amdocs.amsp.valueobject.order.FinalTransForecastTotalsVO;
import amdocs.amsp.valueobject.order.OrderInfoVO;
import amdocs.amsp.valueobject.schedule.ScheduleVO;
import amdocs.amsp.valueobject.site.SiteDetailsVO;

public class SetOrderInfoVO_Test {
	private OrderInfoVO orderInfoVO = new OrderInfoVO();
	
	
	
	public OrderInfoVO setOrderInfoVOforInstall(Parameters apiParams, PrintOutput printOutput,
										   CurTransForecastTotalsVO curTransForecastTotalsVO,
			                               EstimatedBillVO[] estimatedBillVOArr,
			                               FinalTransForecastTotalsVO finalTransForecastTotalsVO,
			                               ScheduleVO scheduleVO,
			                               SiteDetailsVO siteDetailsVO,
			                               WIPConstraintsVO wIPConstraintsVO) {
		
		orderInfoVO.setAction((short)apiParams.getOrderInfoVOaction());
		/*setAdvsvcType(java.lang.Short advsvcType)
		setAgedMoney(AgedMoneyVO[] agedMoney)
		setAllTaxesExempted(boolean allTaxesExempted)
		setBasicRateConfirm(boolean basicRateConfirm)*/
		orderInfoVO.setBillDate(apiParams.getBillDate());
		/*setBillForm(java.lang.String billForm)*/
		orderInfoVO.setBillFromDate(apiParams.getBillDate());
		/*setBillingGroup(int billingGroup)*/
		orderInfoVO.setBillToDate(apiParams.getBillDate());
		/*setCampaign(java.lang.String campaign)
		setCampaignVO(CampaignVO campaignVO)
		setCdwDate(java.util.Date cdwDate)
		setChangeReasonCode(java.lang.String changeReasonCode)
		setChangeReasonDesc(java.lang.String changeReasonDesc)
		setCodCode(java.lang.String codCode)
		setCodDesc(java.lang.String codDesc)
		setCurCallDay(short curCallDay)
		setCurrentBalance(amdocs.core.Money currentBalance)*/
		orderInfoVO.setCurrentTransactionTotals(curTransForecastTotalsVO);
		//orderInfoVO.setCycle(apiParams.getCycle());
		/*setDisconnectDate(java.util.Date disconnectDate)
		setDisconnectReasonCode(java.lang.String disconnectReasonCode)
		setDisconnectReasonDesc(java.lang.String disconnectReasonDesc)
		setDiscountCode(java.lang.String discountCode)
		setDiscountDesc(java.lang.String discountDesc)*/
		orderInfoVO.setDropTypeCode(siteDetailsVO.getDropTypeCode());
		/*setDwellingTypeCode(java.lang.String dwellingTypeCode)
		setEffectiveDateFlag(int effectiveDateFlag)*/
		orderInfoVO.setEstimatedBillVO(estimatedBillVOArr);
		/*setEstimatedNewMonthlyRate(amdocs.core.Money estimatedNewMonthlyRate)
		setEstimatedNextBill(amdocs.core.Money estimatedNextBill)*/
		orderInfoVO.setFinalTransactionTotals(finalTransForecastTotalsVO);
		/*setFlashComment(java.lang.String flashComment)
		setHasPromoRemvFrmStart(boolean hasPromoRemvFrmStart)
		setIncrementalDepositRemain(amdocs.core.Money incrementalDepositRemain)
		setIncrementalInstallRemain(amdocs.core.Money incrementalInstallRemain)
		setInstallDate(java.util.Date installDate)
		setIntlDestAnalysis(boolean intlDestAnalysis)
		setInvoiceExempt(java.lang.Boolean invoiceExempt)
		setIsAdvanceServiceOrder(boolean isAdvanceServiceOrder)
		setIsComplianceToOrderTime(boolean isComplianceToOrderTime)
		setIsCycleOverride(boolean isCycleOverride)
		setIsDispatchComplete(boolean isDispatchComplete)
		setIsFinalBillSent(boolean isFinalBillSent)
		setIsMduExempt(java.lang.Boolean isMduExempt)
		setIsPhNumPortedOut(java.lang.Boolean isPhNumPortedOut)
		setIsRouted(boolean isRouted)
		setIsTaxExempt(java.lang.Boolean isTaxExempt)
		setLastInstallDate(java.util.Date lastInstallDate)
		setLastStatementDate(java.util.Date lastStatementDate)
		setLocator(java.lang.String locator)
		setNatlDestAnalysis(boolean natlDestAnalysis)
		setNewCallDay(short newCallDay)*/
		orderInfoVO.setNewCycle(String.valueOf(apiParams.getCycle()));
		/*setNotDoneRsg(java.lang.String notDoneRsg)
		setOfferNumber(java.math.BigDecimal offerNumber)
		setOrderComment(java.lang.String orderComment)
		setOrderDate(java.util.Date orderDate)
		setOrderGroupSeq(java.math.BigDecimal orderGroupSeq)
		setOrderNumber(java.math.BigDecimal orderNumber)
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
		if (wIPConstraintsVO.getSalesrep().getRequired()) {
			orderInfoVO.setSalesRepId(apiParams.getSalesRepId());
		}		
		/*setSalesRepLastName(java.lang.String salesRepLastName)
		setSchedule(ScheduleVO schedule)
		setSpecialInstruct1Code(java.lang.String specialInstruct1Code)
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
		//if (wIPConstraintsVO.getTechId().getRequired()) {  // !!!!!!!!!!!  Why is this required?????    !!!!!!!!!!
		//orderInfoVO.setTechAssigned(apiParams.getTechId());   
		//}
		/*setTechLastName(java.lang.String techLastName)
		setTelcoChangeType(java.lang.Short telcoChangeType)
		setTermOverrideComment(java.lang.String termOverrideComment)
		setTotalCodAmount(amdocs.core.Money totalCodAmount)
		setWdwo(java.lang.String wdwo)
		setWipChangeProg(short wipChangeProg)
		setWipComment(java.lang.String wipComment)
		setWipDependency(int wipDependency)
		setWorkDoneDate(java.util.Date workDoneDate)
		setWorkDoneTime(java.util.Date workDoneTime)*/
		
		if (orderInfoVO != null) {
			printOutput.printToShell(apiParams, 
					getClass().getName() + ":<OrderInfoVO>" + orderInfoVO.toString() + "</OrderInfoVO>", 
					orderInfoVO.toXml());
		}
		else {
			printOutput.printToShell(apiParams, getClass().getName() + ":<orderInfoVO> is null", null);
		}
		
		return (orderInfoVO);
	}
	
	public OrderInfoVO setOrderInfoVOforProspectOffer(Parameters apiParams, PrintOutput printOutput,
			   										  CurTransForecastTotalsVO curTransForecastTotalsVO,
			   										  EstimatedBillVO[] estimatedBillVOArr,
			   										  FinalTransForecastTotalsVO finalTransForecastTotalsVO,
			   										  ScheduleVO scheduleVO,
			   										  SiteDetailsVO siteDetailsVO,
			   										  WIPConstraintsVO wIPConstraintsVO) {
		orderInfoVO.setAction((short)apiParams.getOrderInfoVOaction());
		/*setAdvsvcType(java.lang.Short advsvcType)
		setAgedMoney(AgedMoneyVO[] agedMoney)
		setAllTaxesExempted(boolean allTaxesExempted)
		setBasicRateConfirm(boolean basicRateConfirm)*/
		orderInfoVO.setBillDate(apiParams.getBillDate());
		/*setBillForm(java.lang.String billForm)*/
		orderInfoVO.setBillFromDate(apiParams.getBillDate());
		/*setBillingGroup(int billingGroup)*/
		orderInfoVO.setBillToDate(apiParams.getBillDate());
		/*setCampaign(java.lang.String campaign)
		setCampaignVO(CampaignVO campaignVO)
		setCdwDate(java.util.Date cdwDate)
		setChangeReasonCode(java.lang.String changeReasonCode)
		setChangeReasonDesc(java.lang.String changeReasonDesc)
		setCodCode(java.lang.String codCode)
		setCodDesc(java.lang.String codDesc)
		setCurCallDay(short curCallDay)
		setCurrentBalance(amdocs.core.Money currentBalance)*/
		orderInfoVO.setCurrentTransactionTotals(curTransForecastTotalsVO);
		//orderInfoVO.setCycle(apiParams.getCycle());
		/*setDisconnectDate(java.util.Date disconnectDate)
		setDisconnectReasonCode(java.lang.String disconnectReasonCode)
		setDisconnectReasonDesc(java.lang.String disconnectReasonDesc)
		setDiscountCode(java.lang.String discountCode)
		setDiscountDesc(java.lang.String discountDesc)*/
		orderInfoVO.setDropTypeCode(siteDetailsVO.getDropTypeCode());
		/*setDwellingTypeCode(java.lang.String dwellingTypeCode)
		setEffectiveDateFlag(int effectiveDateFlag)*/
		orderInfoVO.setEstimatedBillVO(estimatedBillVOArr);
		/*setEstimatedNewMonthlyRate(amdocs.core.Money estimatedNewMonthlyRate)
		setEstimatedNextBill(amdocs.core.Money estimatedNextBill)*/
		orderInfoVO.setFinalTransactionTotals(finalTransForecastTotalsVO);
		/*setFlashComment(java.lang.String flashComment)
		setHasPromoRemvFrmStart(boolean hasPromoRemvFrmStart)
		setIncrementalDepositRemain(amdocs.core.Money incrementalDepositRemain)
		setIncrementalInstallRemain(amdocs.core.Money incrementalInstallRemain)
		setInstallDate(java.util.Date installDate)
		setIntlDestAnalysis(boolean intlDestAnalysis)
		setInvoiceExempt(java.lang.Boolean invoiceExempt)
		setIsAdvanceServiceOrder(boolean isAdvanceServiceOrder)
		setIsComplianceToOrderTime(boolean isComplianceToOrderTime)
		setIsCycleOverride(boolean isCycleOverride)
		setIsDispatchComplete(boolean isDispatchComplete)
		setIsFinalBillSent(boolean isFinalBillSent)
		setIsMduExempt(java.lang.Boolean isMduExempt)
		setIsPhNumPortedOut(java.lang.Boolean isPhNumPortedOut)
		setIsRouted(boolean isRouted)
		setIsTaxExempt(java.lang.Boolean isTaxExempt)
		setLastInstallDate(java.util.Date lastInstallDate)
		setLastStatementDate(java.util.Date lastStatementDate)
		setLocator(java.lang.String locator)
		setNatlDestAnalysis(boolean natlDestAnalysis)
		setNewCallDay(short newCallDay)*/
		orderInfoVO.setNewCycle(String.valueOf(apiParams.getCycle()));
		/*setNotDoneRsg(java.lang.String notDoneRsg)
		setOfferNumber(java.math.BigDecimal offerNumber)
		setOrderComment(java.lang.String orderComment)
		setOrderDate(java.util.Date orderDate)
		setOrderGroupSeq(java.math.BigDecimal orderGroupSeq)
		setOrderNumber(java.math.BigDecimal orderNumber)
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
		if (wIPConstraintsVO.getSalesrep().getRequired()) {
		orderInfoVO.setSalesRepId(apiParams.getSalesRepId());
		}		
		/*setSalesRepLastName(java.lang.String salesRepLastName)
		setSchedule(ScheduleVO schedule)
		setSpecialInstruct1Code(java.lang.String specialInstruct1Code)
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
		//if (wIPConstraintsVO.getTechId().getRequired()) {
			//orderInfoVO.setTechAssigned(apiParams.getTechId());   
		//}
		/*setTechLastName(java.lang.String techLastName)
		setTelcoChangeType(java.lang.Short telcoChangeType)
		setTermOverrideComment(java.lang.String termOverrideComment)
		setTotalCodAmount(amdocs.core.Money totalCodAmount)
		setWdwo(java.lang.String wdwo)
		setWipChangeProg(short wipChangeProg)
		setWipComment(java.lang.String wipComment)
		setWipDependency(int wipDependency)
		setWorkDoneDate(java.util.Date workDoneDate)
		setWorkDoneTime(java.util.Date workDoneTime)*/
		
		if (orderInfoVO != null) {
		printOutput.printToShell(apiParams, 
		getClass().getName() + ":<OrderInfoVO>" + orderInfoVO.toString() + "</OrderInfoVO>", 
		orderInfoVO.toXml());
		}
		else {
		printOutput.printToShell(apiParams, getClass().getName() + ":<orderInfoVO> is null", null);
		}
		
		return (orderInfoVO);
	}
}
