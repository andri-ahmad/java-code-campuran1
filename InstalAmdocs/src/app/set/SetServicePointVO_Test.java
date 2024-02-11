package app.set;

import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.valueobject.accountviewwip.OrderGroupVO;
import amdocs.amsp.valueobject.servicepoint.ServicePointVO;
import amdocs.amsp.valueobject.servicepoint.RateCodeVO;
import amdocs.amsp.valueobject.servicepoint.TaskVO;

public class SetServicePointVO_Test {
	
	private ServicePointVO servicePointVO = new ServicePointVO();
	
	public ServicePointVO setServicePointVOforChangeOfService (Parameters apiParams, PrintOutput printOutput, RateCodeVO[] rateCodeList, TaskVO[] taskVOArr) {
		
		servicePointVO.setAction(apiParams.getServicePointVOaction());
		//setAssignPort(boolean assignPort)
		//setCampaignCode(java.lang.String campaignCode)
		//setCampaignCodeDesc(java.lang.String campaignCodeDesc)
		//setContractTemplateId(java.lang.Long contractTemplateId)
		//setEquipment(EquipmentVO[] equipment)
		//setEquipmentDeposit(amdocs.core.Money equipmentDeposit)
		//setEquipmentOutlet(int equipmentOutlet)
		//setEquipmentPort(short equipmentPort)
		//setFixList(FixVO[] fixList)
		//setIsPortChanged(java.lang.Boolean isPortChanged)
		//setLinkedServices(LinkedServicesVO linkedServices)
		//setOrderGroup(java.math.BigDecimal orderGroup)
		//setPhoneAsOnSysDate(java.lang.String phoneAsOnSysDate)
		//setPhoneList(PhoneVO phoneList)
		//setPhoneNumber(java.lang.String phoneNumber)
		//setPortSerialNumber(java.lang.String portSerialNumber)
		servicePointVO.setRateCodeList(rateCodeList);
		//setReturnReasonCode(java.lang.String returnReasonCode)
		//setServiceList(java.lang.String serviceList)
		//servicePointVO.setServicePackage(apiParams.getServicePackage());
		//setServicePackageName(java.lang.String servicePackageName)
		servicePointVO.setServicePoint(apiParams.getServicePoint());
		//setServicePointEquipRemoval(boolean servicePointEquipRemoval)
		//servicePointVO.setServicePointLocationCode(apiParams.getServicePointLocationCode());
		//servicePointVO.setServicePointLongDesc("API TESTING         ");
		//servicePointVO.setServicePointShortDesc("API TEST");
		//setStatus(short status)
		//setStatusDesc(java.lang.String statusDesc)
		//setSubOwnedEquipRemoval(boolean subOwnedEquipRemoval)
		servicePointVO.setTaskList(taskVOArr);
		//setVbdAction(int vbdAction)
		//setVolumeBasedDiscount(VolumeBasedDiscountVO volumeBasedDiscount)
        
        if (servicePointVO != null) {
			printOutput.printToShell(apiParams, 
					getClass().getName() + ":<servicePointVO>" + servicePointVO.toString() + "</servicePointVO>",
					servicePointVO.toXml());
		}
		else {
			printOutput.printToShell(apiParams, getClass().getName() + ":<servicePointVO> is null", null);
		}

		return (servicePointVO);
	}
	
public ServicePointVO setServicePointVOforInstall (Parameters apiParams, 
												   PrintOutput printOutput, 
												   RateCodeVO[] rateCodeList, 
												   OrderGroupVO[] orderGroupVOList,
												   TaskVO[] taskVOArr) {
		
		servicePointVO.setAction(apiParams.getServicePointVOaction());
		//setAssignPort(boolean assignPort)
		//setCampaignCode(java.lang.String campaignCode)
		//setCampaignCodeDesc(java.lang.String campaignCodeDesc)
		//setContractTemplateId(java.lang.Long contractTemplateId)
		//setEquipment(EquipmentVO[] equipment)
		//setEquipmentDeposit(amdocs.core.Money equipmentDeposit)
		//setEquipmentOutlet(int equipmentOutlet)
		//setEquipmentPort(short equipmentPort)
		//setFixList(FixVO[] fixList)
		//setIsPortChanged(java.lang.Boolean isPortChanged)
		//setLinkedServices(LinkedServicesVO linkedServices)
		servicePointVO.setOrderGroup(orderGroupVOList[0].getOrderGroupSeq());
		//setPhoneAsOnSysDate(java.lang.String phoneAsOnSysDate)
		//setPhoneList(PhoneVO phoneList)
		//setPhoneNumber(java.lang.String phoneNumber)
		//setPortSerialNumber(java.lang.String portSerialNumber)
		servicePointVO.setRateCodeList(rateCodeList);
		//setReturnReasonCode(java.lang.String returnReasonCode)
		//setServiceList(java.lang.String serviceList)
		servicePointVO.setServicePackage(apiParams.getServicePackage());  // 99504 Residential T.V.
		//setServicePackageName(java.lang.String servicePackageName)
		servicePointVO.setServicePoint(apiParams.getServicePoint());
		//setServicePointEquipRemoval(boolean servicePointEquipRemoval)
		servicePointVO.setServicePointLocationCode(apiParams.getServicePointLocationCode());
		//servicePointVO.setServicePointLongDesc("API TESTING         ");
		//servicePointVO.setServicePointShortDesc("API TEST");
		//setStatus(short status)
		//setStatusDesc(java.lang.String statusDesc)
		//setSubOwnedEquipRemoval(boolean subOwnedEquipRemoval)
		servicePointVO.setTaskList(taskVOArr);
		//setVbdAction(int vbdAction)
		//setVolumeBasedDiscount(VolumeBasedDiscountVO volumeBasedDiscount)
        
        if (servicePointVO != null) {
			printOutput.printToShell(apiParams, 
					getClass().getName() + ":<servicePointVO>" + servicePointVO.toString() + "</servicePointVO>",
					servicePointVO.toXml());
		}
		else {
			printOutput.printToShell(apiParams, getClass().getName() + ":<servicePointVO> is null", null);
		}

		return (servicePointVO);
	}

	public ServicePointVO setServicePointVOforProspectOffer (Parameters apiParams, PrintOutput printOutput, RateCodeVO[] rateCodeList, TaskVO[] taskVOArr) {
		
		servicePointVO.setAction(apiParams.getServicePointVOaction()); // no change = 0, change = 1, add = 2, remove = 3
		//setAssignPort(boolean assignPort)
		//setCampaignCode(java.lang.String campaignCode)
		//setCampaignCodeDesc(java.lang.String campaignCodeDesc)
		//setContractTemplateId(java.lang.Long contractTemplateId)
		//setEquipment(EquipmentVO[] equipment)
		//setEquipmentDeposit(amdocs.core.Money equipmentDeposit)
		//setEquipmentOutlet(int equipmentOutlet)
		//setEquipmentPort(short equipmentPort)
		//setFixList(FixVO[] fixList)
		//setIsPortChanged(java.lang.Boolean isPortChanged)
		//setLinkedServices(LinkedServicesVO linkedServices)
		//setOrderGroup(java.math.BigDecimal orderGroup)
		//setPhoneAsOnSysDate(java.lang.String phoneAsOnSysDate)
		//setPhoneList(PhoneVO phoneList)
		//setPhoneNumber(java.lang.String phoneNumber)
		//setPortSerialNumber(java.lang.String portSerialNumber)
		servicePointVO.setRateCodeList(rateCodeList);
		//setReturnReasonCode(java.lang.String returnReasonCode)
		//setServiceList(java.lang.String serviceList)
		servicePointVO.setServicePackage(apiParams.getServicePackage());  // 99504 Residential T.V.
		//setServicePackageName(java.lang.String servicePackageName)
		servicePointVO.setServicePoint(1);
		//setServicePointEquipRemoval(boolean servicePointEquipRemoval)
		servicePointVO.setServicePointLocationCode(apiParams.getServicePointLocationCode());
		//servicePointVO.setServicePointLongDesc("API TESTING         ");
		//servicePointVO.setServicePointShortDesc("API TEST");
		//setStatus(short status)
		//setStatusDesc(java.lang.String statusDesc)
		//setSubOwnedEquipRemoval(boolean subOwnedEquipRemoval)
		servicePointVO.setTaskList(taskVOArr);
		//setVbdAction(int vbdAction)
		//setVolumeBasedDiscount(VolumeBasedDiscountVO volumeBasedDiscount)
        
        if (servicePointVO != null) {
			printOutput.printToShell(apiParams, 
					getClass().getName() + ":<servicePointVO>" + servicePointVO.toString() + "</servicePointVO>",
					servicePointVO.toXml());
		}
		else {
			printOutput.printToShell(apiParams, getClass().getName() + ":<servicePointVO> is null", null);
		}

		return (servicePointVO);
	}
	
	public ServicePointVO setServicePointVOforInstallWithContract (Parameters apiParams, 
																   PrintOutput printOutput, 
																   RateCodeVO[] rateCodeVOList, 
																   OrderGroupVO[] orderGroupVOList, 
																   TaskVO[] taskList) {

		servicePointVO.setAction(apiParams.getServicePointVOaction());
		/*setAssignPort(boolean assignPort)
		setCampaignCode(java.lang.String campaignCode)
		setCampaignCodeDesc(java.lang.String campaignCodeDesc)*/
		servicePointVO.setContractTemplateId(apiParams.getContractTemplateId());
		//servicePointVO.setEquipment(equipmentVOlist);
		/*setEquipmentDeposit(amdocs.core.Money equipmentDeposit)
		setEquipmentOutlet(int equipmentOutlet)
		setEquipmentPort(short equipmentPort)
		setFixList(FixVO[] fixList)
		setIsPortChanged(java.lang.Boolean isPortChanged)
		setLinkedServices(LinkedServicesVO linkedServices)*/
		servicePointVO.setOrderGroup(orderGroupVOList[0].getOrderGroupSeq());
		/*setPhoneAsOnSysDate(java.lang.String phoneAsOnSysDate)
		setPhoneList(PhoneVO phoneList)
		setPhoneNumber(java.lang.String phoneNumber)
		setPortSerialNumber(java.lang.String portSerialNumber)*/
		servicePointVO.setRateCodeList(rateCodeVOList);
		servicePointVO.setServicePoint(apiParams.getServicePoint());
		servicePointVO.setServicePointLocationCode(apiParams.getServicePointLocationCode());
		/*setReturnReasonCode(java.lang.String returnReasonCode)
		setServiceList(java.lang.String serviceList)
		setServicePackage(java.lang.String servicePackage)
		setServicePackageName(java.lang.String servicePackageName)
		setServicePoint(int servicePoint)
		setServicePointEquipRemoval(boolean servicePointEquipRemoval)
		setServicePointLocationCode(java.lang.String servicePointLocationCode)
		setServicePointLongDesc(java.lang.String servicePointLongDesc)
		setServicePointShortDesc(java.lang.String servicePointShortDesc)
		setStatus(short status)
		setStatusDesc(java.lang.String statusDesc)
		setSubOwnedEquipRemoval(boolean subOwnedEquipRemoval)*/
		servicePointVO.setTaskList(taskList);
		/*setVbdAction(int vbdAction)
		setVolumeBasedDiscount(VolumeBasedDiscountVO volumeBasedDiscount)*/
		
		printOutput.printToShell(apiParams, 
							     getClass().getName() + ":<servicePointVO>" + servicePointVO.toString() + "</servicePointVO>",
							     servicePointVO.toXml());
		
		return (servicePointVO);
	}
}
