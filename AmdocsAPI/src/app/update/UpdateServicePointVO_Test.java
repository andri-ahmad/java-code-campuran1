package app.update;

import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.valueobject.accountviewwip.OrderGroupVO;
import amdocs.amsp.valueobject.servicepoint.PhoneVO;
import amdocs.amsp.valueobject.servicepoint.RateCodeVO;
import amdocs.amsp.valueobject.servicepoint.EquipmentVO;
import amdocs.amsp.valueobject.servicepoint.ServicePointVO;
import amdocs.amsp.valueobject.servicepoint.TaskVO;

public class UpdateServicePointVO_Test {

	public void updateServicePointVOforAssignEquipmentToAccount (Parameters apiParams, 
																 PrintOutput printOutput, 
																 ServicePointVO servicePointVO, 
																 EquipmentVO[] equipmentVOlist) {
		
		servicePointVO.setAction(Parameters.SERVICE_POINT_VO_ACTION_CHANGE);
		/*setAssignPort(boolean assignPort)
		setCampaignCode(java.lang.String campaignCode)
		setCampaignCodeDesc(java.lang.String campaignCodeDesc)
		setContractTemplateId(java.lang.Long contractTemplateId)*/
		servicePointVO.setEquipment(equipmentVOlist);
		/*setEquipmentDeposit(amdocs.core.Money equipmentDeposit)
		setEquipmentOutlet(int equipmentOutlet)
		setEquipmentPort(short equipmentPort)
		setFixList(FixVO[] fixList)
		setIsPortChanged(java.lang.Boolean isPortChanged)
		setLinkedServices(LinkedServicesVO linkedServices)*/
		servicePointVO.setOrderGroup(apiParams.getOrderGroupSeq());
		/*setPhoneAsOnSysDate(java.lang.String phoneAsOnSysDate)
		setPhoneList(PhoneVO phoneList)
		setPhoneNumber(java.lang.String phoneNumber)
		setPortSerialNumber(java.lang.String portSerialNumber)*/
		//setRateCodeList(RateCodeVO[] rateCodeList)
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
		setSubOwnedEquipRemoval(boolean subOwnedEquipRemoval)
		setTaskList(TaskVO[] taskList)
		setVbdAction(int vbdAction)
		setVolumeBasedDiscount(VolumeBasedDiscountVO volumeBasedDiscount)*/

		
		printOutput.printToShell(apiParams, 
								 getClass().getName() + ":<servicePointVO>" + servicePointVO.toString() + "</servicePointVO>",
								 servicePointVO.toXml());
	}
	
	public void updateServicePointVOforRemoveEquipmentFromAccount (Parameters apiParams, 
			 PrintOutput printOutput, 
			 ServicePointVO servicePointVO, 
			 EquipmentVO[] equipmentVOlist) {

		servicePointVO.setAction(Parameters.SERVICE_POINT_VO_ACTION_CHANGE);
		/*setAssignPort(boolean assignPort)
		setCampaignCode(java.lang.String campaignCode)
		setCampaignCodeDesc(java.lang.String campaignCodeDesc)
		setContractTemplateId(java.lang.Long contractTemplateId)*/
		servicePointVO.setEquipment(equipmentVOlist);
		/*setEquipmentDeposit(amdocs.core.Money equipmentDeposit)
		setEquipmentOutlet(int equipmentOutlet)
		setEquipmentPort(short equipmentPort)
		setFixList(FixVO[] fixList)
		setIsPortChanged(java.lang.Boolean isPortChanged)
		setLinkedServices(LinkedServicesVO linkedServices)*/
		servicePointVO.setOrderGroup(apiParams.getOrderGroupSeq());
		/*setPhoneAsOnSysDate(java.lang.String phoneAsOnSysDate)
		setPhoneList(PhoneVO phoneList)
		setPhoneNumber(java.lang.String phoneNumber)
		setPortSerialNumber(java.lang.String portSerialNumber)*/
		//setRateCodeList(RateCodeVO[] rateCodeList)
		/*setReturnReasonCode(java.lang.String returnReasonCode)
		setServiceList(java.lang.String serviceList)
		setServicePackage(java.lang.String servicePackage)
		setServicePackageName(java.lang.String servicePackageName)
		setServicePoint(int servicePoint)*/
		servicePointVO.setServicePointEquipRemoval(apiParams.getServicePointEquipRemoval());
		/*setServicePointLocationCode(java.lang.String servicePointLocationCode)
		setServicePointLongDesc(java.lang.String servicePointLongDesc)
		setServicePointShortDesc(java.lang.String servicePointShortDesc)
		setStatus(short status)
		setStatusDesc(java.lang.String statusDesc)
		setSubOwnedEquipRemoval(boolean subOwnedEquipRemoval)
		setTaskList(TaskVO[] taskList)
		setVbdAction(int vbdAction)
		setVolumeBasedDiscount(VolumeBasedDiscountVO volumeBasedDiscount)*/
		
		printOutput.printToShell(apiParams, 
		getClass().getName() + ":<servicePointVO>" + servicePointVO.toString() + "</servicePointVO>",
		servicePointVO.toXml());
	}
	
	public void updateServicePointVOforChangeOfService (Parameters apiParams, 
														PrintOutput printOutput, 
														ServicePointVO servicePointVO, 
														RateCodeVO[] rateCodeVOList, 
														OrderGroupVO[] orderGroupVOList, 
														TaskVO[] taskList) {
		
		servicePointVO.setAction(apiParams.getServicePointVOaction());
		/*setAssignPort(boolean assignPort)
		setCampaignCode(java.lang.String campaignCode)
		setCampaignCodeDesc(java.lang.String campaignCodeDesc)
		setContractTemplateId(java.lang.Long contractTemplateId)*/
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
	}
	
	public void updateServicePointVOforDisconnect (Parameters apiParams, 
												   PrintOutput printOutput, 
												   ServicePointVO servicePointVO) {
		
		servicePointVO.setAction(apiParams.getServicePointVOaction());
		/*setAssignPort(boolean assignPort)
		setCampaignCode(java.lang.String campaignCode)
		setCampaignCodeDesc(java.lang.String campaignCodeDesc)
		setContractTemplateId(java.lang.Long contractTemplateId)*/
		//servicePointVO.setEquipment(equipmentVOlist);
		/*setEquipmentDeposit(amdocs.core.Money equipmentDeposit)
		setEquipmentOutlet(int equipmentOutlet)
		setEquipmentPort(short equipmentPort)
		setFixList(FixVO[] fixList)
		setIsPortChanged(java.lang.Boolean isPortChanged)
		setLinkedServices(LinkedServicesVO linkedServices)*/
		servicePointVO.setOrderGroup(apiParams.getOrderGroupSeq());
		/*setPhoneAsOnSysDate(java.lang.String phoneAsOnSysDate)
		setPhoneList(PhoneVO phoneList)
		setPhoneNumber(java.lang.String phoneNumber)
		setPortSerialNumber(java.lang.String portSerialNumber)*/
		//servicePointVO.setRateCodeList(rateCodeVOList);
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
		//servicePointVO.setTaskList(taskList);
		/*setVbdAction(int vbdAction)
		setVolumeBasedDiscount(VolumeBasedDiscountVO volumeBasedDiscount)*/
		
		printOutput.printToShell(apiParams, 
		getClass().getName() + ":<servicePointVO>" + servicePointVO.toString() + "</servicePointVO>",
		servicePointVO.toXml());
	}
	
	public void updateServicePointVOforChangeOfService2 (Parameters apiParams, 
														 PrintOutput printOutput,
														 PhoneVO phoneVO,
														 ServicePointVO servicePointVO, 
														 RateCodeVO[] rateCodeVOList, 
														 OrderGroupVO[] orderGroupVOList, 
														 TaskVO[] taskList) {

		servicePointVO.setAction(apiParams.getServicePointVOaction());
		/*setAssignPort(boolean assignPort)
		setCampaignCode(java.lang.String campaignCode)
		setCampaignCodeDesc(java.lang.String campaignCodeDesc)
		setContractTemplateId(java.lang.Long contractTemplateId)*/
		//servicePointVO.setEquipment(equipmentVOlist);
		/*setEquipmentDeposit(amdocs.core.Money equipmentDeposit)
		setEquipmentOutlet(int equipmentOutlet)
		setEquipmentPort(short equipmentPort)
		setFixList(FixVO[] fixList)
		setIsPortChanged(java.lang.Boolean isPortChanged)
		setLinkedServices(LinkedServicesVO linkedServices)*/
		servicePointVO.setOrderGroup(orderGroupVOList[0].getOrderGroupSeq());
		/*setPhoneAsOnSysDate(java.lang.String phoneAsOnSysDate)*/
		servicePointVO.setPhoneList(phoneVO);
		/*setPhoneNumber(java.lang.String phoneNumber)
		setPortSerialNumber(java.lang.String portSerialNumber)*/
		servicePointVO.setRateCodeList(rateCodeVOList);
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
}
	
	public void updateServicePointVOforInstall (Parameters apiParams, 
												PrintOutput printOutput, 
												ServicePointVO servicePointVO, 
												RateCodeVO[] rateCodeVOList, 
												OrderGroupVO[] orderGroupVOList, 
												TaskVO[] taskList) {

		servicePointVO.setAction(apiParams.getServicePointVOaction());
		/*setAssignPort(boolean assignPort)
		setCampaignCode(java.lang.String campaignCode)
		setCampaignCodeDesc(java.lang.String campaignCodeDesc)
		setContractTemplateId(java.lang.Long contractTemplateId)*/
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
	}
	
	public void updateServicePointVOforRescheduleOrder (Parameters apiParams, 
														PrintOutput printOutput, 
														ServicePointVO servicePointVO, 
														RateCodeVO[] rateCodeVOList) {

		servicePointVO.setAction(apiParams.getServicePointVOaction());
		/*setAssignPort(boolean assignPort)
		setCampaignCode(java.lang.String campaignCode)
		setCampaignCodeDesc(java.lang.String campaignCodeDesc)
		setContractTemplateId(java.lang.Long contractTemplateId)*/
		//servicePointVO.setEquipment(equipmentVOlist);
		/*setEquipmentDeposit(amdocs.core.Money equipmentDeposit)
		setEquipmentOutlet(int equipmentOutlet)
		setEquipmentPort(short equipmentPort)
		setFixList(FixVO[] fixList)
		setIsPortChanged(java.lang.Boolean isPortChanged)
		setLinkedServices(LinkedServicesVO linkedServices)*/
		servicePointVO.setOrderGroup(apiParams.getOrderGroupSeq());
		/*setPhoneAsOnSysDate(java.lang.String phoneAsOnSysDate)
		setPhoneList(PhoneVO phoneList)
		setPhoneNumber(java.lang.String phoneNumber)
		setPortSerialNumber(java.lang.String portSerialNumber)*/
		servicePointVO.setRateCodeList(rateCodeVOList);
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
		// servicePointVO.setTaskList(taskList);
		/*setVbdAction(int vbdAction)
		setVolumeBasedDiscount(VolumeBasedDiscountVO volumeBasedDiscount)*/
		
		printOutput.printToShell(apiParams, 
		getClass().getName() + ":<servicePointVO>" + servicePointVO.toString() + "</servicePointVO>",
		servicePointVO.toXml());
	}
}
