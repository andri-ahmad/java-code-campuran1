package app.set;

import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.valueobject.servicepoint.RateCodeVO;

public class SetRateCodeVO_Test {
	
	RateCodeVO rateCodeVO = new RateCodeVO();
	
	public RateCodeVO setRateCodeVOforChangeOfService (Parameters apiParams, PrintOutput printOutput) {
		
		rateCodeVO.setAction(apiParams.getRateCodeVOaction());
		/*setAddressableFlag(int addressableFlag) */
		rateCodeVO.setBillDate(apiParams.getBillDate());
		/* setBillFrequency(short billFrequency)
		setBillFrequencyOverride(int billFrequencyOverride)
		setBillingGroup(int billingGroup)
		setBoxPortRequired(java.lang.String boxPortRequired)
		setCannotBeRemoved(boolean cannotBeRemoved)
		setChangePriceStructureFlag(short changePriceStructureFlag)
		setChargeLimit(amdocs.core.Money chargeLimit)
		setComboCode(java.lang.String comboCode)
		setComboCodeLongDesc(java.lang.String comboCodeLongDesc)
		setComboSeq(int comboSeq)
		setComboSupplier(java.lang.String comboSupplier)
		setContract(ContractVO contract)
		setContractExternalNum(java.lang.String contractExternalNum)
		setContractRateAction(int contractRateAction)
		setContractRateFlag(boolean contractRateFlag)
		setContractSequenceNumber(java.math.BigDecimal contractSequenceNumber)
		setCycle(int cycle)
		setDeliverySysId(java.lang.String deliverySysId)
		setEquipmentEtfRate(amdocs.core.Money equipmentEtfRate)
		setFeatureList(FeatureVO[] featureList)
		setFreeFormRateCodeLongDesc(java.lang.String freeFormRateCodeLongDesc)
		setFreeFormRateCodeShortDesc(java.lang.String freeFormRateCodeShortDesc)
		setGrpBehavior(int grpBehavior)
		setHasBillFreqChange(boolean hasBillFreqChange)
		setHasNonStdRateChange(boolean hasNonStdRateChange)
		setIncrementalChargeRateFlag(int incrementalChargeRateFlag)
		setIsfreeFormService(boolean isfreeFormService)
		setIsRegulated(boolean isRegulated)
		setLineUseType(int lineUseType)
		setMonthlyRate(amdocs.core.Money monthlyRate)
		setNonStdIncrementalCharge(NonStdIncrementalChargeVO nonStdIncrementalCharge)
		setNonStdRateFlag(int nonStdRateFlag)
		setOfferNum(java.math.BigDecimal offerNum)
		setPendingOrderFlag(int pendingOrderFlag)
		setPriceStructureId(int priceStructureId)
		setPricingInfo(PricingVO pricingInfo)
		setPromo(PromoVO promo)
		setRateCode(java.lang.String rateCode)
		setRateCodeCategory(java.lang.String rateCodeCategory)
		setRateCodeChkFlag(short rateCodeChkFlag)
		setRateCodeCount(short rateCodeCount)
		setRateCodeEffectiveDate(java.util.Date rateCodeEffectiveDate)
		setRateCodeFloorAmount(amdocs.core.Money rateCodeFloorAmount)
		setRateCodeFullDesc(java.lang.String rateCodeFullDesc)
		setRateCodeLongDesc(java.lang.String rateCodeLongDesc)
		setRateCodePackage(java.lang.String rateCodePackage)
		setRateCodePackageId(java.lang.String rateCodePackageId)
		setRateCodeQualifyFlag(short rateCodeQualifyFlag)
		setRateCodeReportingCenter(java.lang.String rateCodeReportingCenter)
		setRateCodeShortDesc(java.lang.String rateCodeShortDesc)
		setRateCodeSvcClass1(java.lang.String rateCodeSvcClass1)
		setRateCodeSvcClass2(java.lang.String rateCodeSvcClass2)
		setRateCodeSvcClass3(java.lang.String rateCodeSvcClass3)
		setRateCodeType(short rateCodeType)
		setRateComment(java.lang.String rateComment)
		setRauth01(java.lang.String rauth01)
		setRauth02(java.lang.String rauth02)
		setRauth03(java.lang.String rauth03)
		setRauth04(java.lang.String rauth04)
		setRauth05(java.lang.String rauth05)
		setRauth06(java.lang.String rauth06)
		setRtype(java.lang.String rtype)
		setServiceGroup(int serviceGroup)
		setSourceOutlet(int sourceOutlet)
		setStandAloneRate(amdocs.core.Money standAloneRate)
		setStatus(java.lang.Short status)
		setSvcHasPromoChg(boolean svcHasPromoChg)
		setTask1AptOvInstall(java.lang.String task1AptOvInstall)
		setTask1AptOvRestart(java.lang.String task1AptOvRestart)
		setTask1AptUgInstall(java.lang.String task1AptUgInstall)
		setTask1AptUgRestart(java.lang.String task1AptUgRestart)
		setTask1HsOvInstall(java.lang.String task1HsOvInstall)
		setTask1HsOvRestart(java.lang.String task1HsOvRestart)
		setTask1HsUgInstall(java.lang.String task1HsUgInstall)
		setTask1HsUgRestart(java.lang.String task1HsUgRestart)
		setTask1Remove(java.lang.String task1Remove)
		setTask2AptOvInstall(java.lang.String task2AptOvInstall)
		setTask2AptOvRestart(java.lang.String task2AptOvRestart)
		setTask2AptUgInstall(java.lang.String task2AptUgInstall)
		setTask2AptUgRestart(java.lang.String task2AptUgRestart)
		setTask2HsOvInstall(java.lang.String task2HsOvInstall)
		setTask2HsOvRestart(java.lang.String task2HsOvRestart)
		setTask2HsUgInstall(java.lang.String task2HsUgInstall)
		setTask2HsUgRestart(java.lang.String task2HsUgRestart)
		setTask2Remove(java.lang.String task2Remove)
		setTask3AptOvInstall(java.lang.String task3AptOvInstall)
		setTask3AptOvRestart(java.lang.String task3AptOvRestart)
		setTask3AptUgInstall(java.lang.String task3AptUgInstall)
		setTask3AptUgRestart(java.lang.String task3AptUgRestart)
		setTask3HsOvInstall(java.lang.String task3HsOvInstall)
		setTask3HsOvRestart(java.lang.String task3HsOvRestart)
		setTask3HsUgInstall(java.lang.String task3HsUgInstall)
		setTask3HsUgRestart(java.lang.String task3HsUgRestart)
		setTask3Remove(java.lang.String task3Remove)
		setTaskGroup(short taskGroup)
		setTelcoLineType(java.lang.String telcoLineType)*/
		
		if (rateCodeVO != null) {
			printOutput.printToShell(apiParams, 
					getClass().getName() + ":<rateCodeVO>" + rateCodeVO.toString() + "</rateCodeVO>",
					rateCodeVO.toXml());
		}
		else {
			printOutput.printToShell(apiParams, getClass().getName() + ":<rateCodeVO> is null", null);
		}
		
		return (rateCodeVO);
	}
	
public RateCodeVO setRateCodeVOforInstall (Parameters apiParams, PrintOutput printOutput) {
		
		rateCodeVO.setAction(apiParams.getRateCodeVOaction());
		/*setAddressableFlag(int addressableFlag) */
		rateCodeVO.setBillDate(apiParams.getBillDate());
		/* setBillFrequency(short billFrequency)
		setBillFrequencyOverride(int billFrequencyOverride)
		setBillingGroup(int billingGroup)
		setBoxPortRequired(java.lang.String boxPortRequired)
		setCannotBeRemoved(boolean cannotBeRemoved)
		setChangePriceStructureFlag(short changePriceStructureFlag)
		setChargeLimit(amdocs.core.Money chargeLimit)
		setComboCode(java.lang.String comboCode)
		setComboCodeLongDesc(java.lang.String comboCodeLongDesc)
		setComboSeq(int comboSeq)
		setComboSupplier(java.lang.String comboSupplier)
		setContract(ContractVO contract)
		setContractExternalNum(java.lang.String contractExternalNum)
		setContractRateAction(int contractRateAction)
		setContractRateFlag(boolean contractRateFlag)
		setContractSequenceNumber(java.math.BigDecimal contractSequenceNumber)
		setCycle(int cycle)
		setDeliverySysId(java.lang.String deliverySysId)
		setEquipmentEtfRate(amdocs.core.Money equipmentEtfRate)
		setFeatureList(FeatureVO[] featureList)
		setFreeFormRateCodeLongDesc(java.lang.String freeFormRateCodeLongDesc)
		setFreeFormRateCodeShortDesc(java.lang.String freeFormRateCodeShortDesc)
		setGrpBehavior(int grpBehavior)
		setHasBillFreqChange(boolean hasBillFreqChange)
		setHasNonStdRateChange(boolean hasNonStdRateChange)
		setIncrementalChargeRateFlag(int incrementalChargeRateFlag)
		setIsfreeFormService(boolean isfreeFormService)
		setIsRegulated(boolean isRegulated)
		setLineUseType(int lineUseType)
		setMonthlyRate(amdocs.core.Money monthlyRate)
		setNonStdIncrementalCharge(NonStdIncrementalChargeVO nonStdIncrementalCharge)
		setNonStdRateFlag(int nonStdRateFlag)
		setOfferNum(java.math.BigDecimal offerNum)
		setPendingOrderFlag(int pendingOrderFlag)
		setPriceStructureId(int priceStructureId)
		setPricingInfo(PricingVO pricingInfo)
		setPromo(PromoVO promo)
		setRateCode(java.lang.String rateCode)
		setRateCodeCategory(java.lang.String rateCodeCategory)
		setRateCodeChkFlag(short rateCodeChkFlag)
		setRateCodeCount(short rateCodeCount)
		setRateCodeEffectiveDate(java.util.Date rateCodeEffectiveDate)
		setRateCodeFloorAmount(amdocs.core.Money rateCodeFloorAmount)
		setRateCodeFullDesc(java.lang.String rateCodeFullDesc)
		setRateCodeLongDesc(java.lang.String rateCodeLongDesc)
		setRateCodePackage(java.lang.String rateCodePackage)
		setRateCodePackageId(java.lang.String rateCodePackageId)
		setRateCodeQualifyFlag(short rateCodeQualifyFlag)
		setRateCodeReportingCenter(java.lang.String rateCodeReportingCenter)
		setRateCodeShortDesc(java.lang.String rateCodeShortDesc)
		setRateCodeSvcClass1(java.lang.String rateCodeSvcClass1)
		setRateCodeSvcClass2(java.lang.String rateCodeSvcClass2)
		setRateCodeSvcClass3(java.lang.String rateCodeSvcClass3)
		setRateCodeType(short rateCodeType)
		setRateComment(java.lang.String rateComment)
		setRauth01(java.lang.String rauth01)
		setRauth02(java.lang.String rauth02)
		setRauth03(java.lang.String rauth03)
		setRauth04(java.lang.String rauth04)
		setRauth05(java.lang.String rauth05)
		setRauth06(java.lang.String rauth06)
		setRtype(java.lang.String rtype)
		setServiceGroup(int serviceGroup)
		setSourceOutlet(int sourceOutlet)
		setStandAloneRate(amdocs.core.Money standAloneRate)
		setStatus(java.lang.Short status)
		setSvcHasPromoChg(boolean svcHasPromoChg)
		setTask1AptOvInstall(java.lang.String task1AptOvInstall)
		setTask1AptOvRestart(java.lang.String task1AptOvRestart)
		setTask1AptUgInstall(java.lang.String task1AptUgInstall)
		setTask1AptUgRestart(java.lang.String task1AptUgRestart)
		setTask1HsOvInstall(java.lang.String task1HsOvInstall)
		setTask1HsOvRestart(java.lang.String task1HsOvRestart)
		setTask1HsUgInstall(java.lang.String task1HsUgInstall)
		setTask1HsUgRestart(java.lang.String task1HsUgRestart)
		setTask1Remove(java.lang.String task1Remove)
		setTask2AptOvInstall(java.lang.String task2AptOvInstall)
		setTask2AptOvRestart(java.lang.String task2AptOvRestart)
		setTask2AptUgInstall(java.lang.String task2AptUgInstall)
		setTask2AptUgRestart(java.lang.String task2AptUgRestart)
		setTask2HsOvInstall(java.lang.String task2HsOvInstall)
		setTask2HsOvRestart(java.lang.String task2HsOvRestart)
		setTask2HsUgInstall(java.lang.String task2HsUgInstall)
		setTask2HsUgRestart(java.lang.String task2HsUgRestart)
		setTask2Remove(java.lang.String task2Remove)
		setTask3AptOvInstall(java.lang.String task3AptOvInstall)
		setTask3AptOvRestart(java.lang.String task3AptOvRestart)
		setTask3AptUgInstall(java.lang.String task3AptUgInstall)
		setTask3AptUgRestart(java.lang.String task3AptUgRestart)
		setTask3HsOvInstall(java.lang.String task3HsOvInstall)
		setTask3HsOvRestart(java.lang.String task3HsOvRestart)
		setTask3HsUgInstall(java.lang.String task3HsUgInstall)
		setTask3HsUgRestart(java.lang.String task3HsUgRestart)
		setTask3Remove(java.lang.String task3Remove)
		setTaskGroup(short taskGroup)
		setTelcoLineType(java.lang.String telcoLineType)*/
		
		if (rateCodeVO != null) {
			printOutput.printToShell(apiParams, 
					getClass().getName() + ":<rateCodeVO>" + rateCodeVO.toString() + "</rateCodeVO>",
					rateCodeVO.toXml());
		}
		else {
			printOutput.printToShell(apiParams, getClass().getName() + ":<rateCodeVO> is null", null);
		}
		
		return (rateCodeVO);
	}

}
