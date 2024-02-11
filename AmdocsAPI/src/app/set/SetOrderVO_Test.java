package app.set;

import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.valueobject.order.OrderInfoVO;
import amdocs.amsp.valueobject.order.OrderVO;
import amdocs.amsp.valueobject.servicepoint.ServicePointVO;

public class SetOrderVO_Test {
	OrderVO orderVO = new OrderVO();

	public OrderVO setOrderVOforInstall(Parameters apiParams, 
			                       		PrintOutput printOutput,
			                       		OrderInfoVO orderInfoVO,
			                       		ServicePointVO[] servicePointList) {
		
		orderVO.setAcctArea(apiParams.getAccountingArea());
		orderVO.setBillDateWarnFlag(false);
		// setBlankOutRphoneCustAcct(java.lang.String blankOutRphoneCustAcct)
		// setBlankOutRphoneFlag(short blankOutRphoneFlag)
		// setCallerName(java.lang.String callerName)
		// setCancelReasonCode(java.lang.String cancelReasonCode)
		// setClrInfoFlag(short clrInfoFlag)
		// setContract(ContractVO[] contract)
		// setCreateNewAddr(java.lang.Boolean createNewAddr)
		orderVO.setCustAcct(apiParams.getCust_acct());
		// setEftList(ContractTerminationOpVO[] eftList)
		// setEftTotalAmount(amdocs.core.Money eftTotalAmount)
		// setFutureServicePointList(ServicePointVO[] futureServicePointList)
		orderVO.setInstallType((short) apiParams.getInstallType());
		// setIsFrontCounterMode(boolean isFrontCounterMode)
		// orderVO.setIsOffer();
		// setIsPlanStartToBillDate(java.lang.Boolean IsPlanStartToBillDate)
		// setIsPortabilityOn(boolean isPortabilityOn)
		// setIsProrateBasedOnBillDate(java.lang.Boolean IsProrateBasedOnBillDate)
		// setIsProspect(java.lang.Boolean isProspect)
		// setIsSarDateChanged(boolean isSarDateChanged)
		// setIsStrtDateChanged(boolean isStrtDateChanged)
		// orderVO.setJobPoints((short)0);
		orderVO.setJobType(apiParams.getJobType());
		//orderVO.setJobTypeDesc(" Order");  // Why a leading space?????
		// setNmiAcct(java.lang.String nmiAcct)
		// setNmiDiscDate(java.util.Date nmiDiscDate)
		orderVO.setOperatorId(apiParams.getOperatorId());
		orderVO.setOrderInfoList(orderInfoVO);
		orderVO.setOrderType(apiParams.getOrderType());
		//orderVO.setOrderTypeDesc("Install");
		// setPhoneNumberReplaceFlag(java.lang.Boolean phoneNumberReplaceFlag)
		// setPriceStructureId(int priceStructureId)
		// setPriceStructureOverride(boolean priceStructureOverride)
		// setRemovePlanAsNeverExisted(java.lang.Boolean removePlanAsNeverExisted)
		// setRenewContract(RenewContractVO renewContract)
		// setRestartOnNewSite(short restartOnNewSite)
		// setRestartSiteId(java.lang.String restartSiteId)
		// setRuleCustFinancials(RuleCustFinancialsVO[] ruleCustFinancials)
		// setRuleWipOrder(short ruleWipOrder)
		orderVO.setServicePointList(servicePointList);
		orderVO.setSiteId(apiParams.getsiteId());
		// setTerminatedContract(java.math.BigDecimal[] terminatedContract.
		// setTotalCodAmount(amdocs.core.Money totalCodAmount)
		// orderVO.setTotalHours(new Float(1.25));
		// orderVO.setTotalPoints((short)5);
		// setTravelPoints(short travelPoints)

		if (orderVO != null) {
			printOutput.printToShell(apiParams, 
									 getClass().getName() + ":<OrderVO>" + orderVO.toString() + "</OrderVO>",
									 orderVO.toXml());
		}
		else {
			printOutput.printToShell(apiParams, getClass().getName() + ":<orderVO> is null", null);
		}
		
		return (orderVO);
	}
	
	public OrderVO setOrderVOforProspectOffer(Parameters apiParams, 
											  PrintOutput printOutput,
											  OrderInfoVO orderInfoVO,
											  ServicePointVO[] servicePointList) {
	
		//orderVO.setAcctArea(apiParams.getAccountingArea());
		//orderVO.setBillDateWarnFlag(false);
		// setBlankOutRphoneCustAcct(java.lang.String blankOutRphoneCustAcct)
		// setBlankOutRphoneFlag(short blankOutRphoneFlag)
		// setCallerName(java.lang.String callerName)
		// setCancelReasonCode(java.lang.String cancelReasonCode)
		// setClrInfoFlag(short clrInfoFlag)
		// setContract(ContractVO[] contract)
		// setCreateNewAddr(java.lang.Boolean createNewAddr)
		orderVO.setCustAcct(apiParams.getCust_acct());
		// setEftList(ContractTerminationOpVO[] eftList)
		// setEftTotalAmount(amdocs.core.Money eftTotalAmount)
		// setFutureServicePointList(ServicePointVO[] futureServicePointList)
		orderVO.setInstallType((short) apiParams.getInstallType());
		// setIsFrontCounterMode(boolean isFrontCounterMode)
		orderVO.setIsOffer(apiParams.getIsOffer());
		// setIsPlanStartToBillDate(java.lang.Boolean IsPlanStartToBillDate)
		// setIsPortabilityOn(boolean isPortabilityOn)
		// setIsProrateBasedOnBillDate(java.lang.Boolean IsProrateBasedOnBillDate)
		// setIsProspect(java.lang.Boolean isProspect)
		// setIsSarDateChanged(boolean isSarDateChanged)
		// setIsStrtDateChanged(boolean isStrtDateChanged)
		// orderVO.setJobPoints((short)0);
		orderVO.setJobType(apiParams.getJobType());
		//orderVO.setJobTypeDesc(" Order");  // Why a leading space?????
		// setNmiAcct(java.lang.String nmiAcct)
		// setNmiDiscDate(java.util.Date nmiDiscDate)
		orderVO.setOperatorId(apiParams.getOperatorId());
		orderVO.setOrderInfoList(orderInfoVO);
		orderVO.setOrderType(apiParams.getOrderType()); 
		//orderVO.setOrderTypeDesc("Install");
		// setPhoneNumberReplaceFlag(java.lang.Boolean phoneNumberReplaceFlag)
		// setPriceStructureId(int priceStructureId)
		// setPriceStructureOverride(boolean priceStructureOverride)
		// setRemovePlanAsNeverExisted(java.lang.Boolean removePlanAsNeverExisted)
		// setRenewContract(RenewContractVO renewContract)
		// setRestartOnNewSite(short restartOnNewSite)
		// setRestartSiteId(java.lang.String restartSiteId)
		// setRuleCustFinancials(RuleCustFinancialsVO[] ruleCustFinancials)
		// setRuleWipOrder(short ruleWipOrder)
		orderVO.setServicePointList(servicePointList);
		orderVO.setSiteId(apiParams.getsiteId());
		// setTerminatedContract(java.math.BigDecimal[] terminatedContract.
		// setTotalCodAmount(amdocs.core.Money totalCodAmount)
		// orderVO.setTotalHours(new Float(1.25));
		// orderVO.setTotalPoints((short)5);
		// setTravelPoints(short travelPoints)
		
		if (orderVO != null) {
		printOutput.printToShell(apiParams, 
		getClass().getName() + ":<OrderVO>" + orderVO.toString() + "</OrderVO>",
		orderVO.toXml());
		}
		else {
		printOutput.printToShell(apiParams, getClass().getName() + ":<orderVO> is null", null);
		}
		
		return (orderVO);
	}
}
