package app.update;


import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.valueobject.accountconstraints.VideoEquipmentConstraintsVO;
import amdocs.amsp.valueobject.servicepoint.EquipmentVO;

public class UpdateEquipmentVO_Test {
	
	public class UpdateRateCodeVO_Test {
		
	}

		public void updateEquipmentVOforAssignEquipmentToAccount (Parameters apiParams, PrintOutput printOutput, EquipmentVO equipmentVO, VideoEquipmentConstraintsVO videoEquipmentConstraintsVO) {
			
			// Check video equipment constraints when needed
			equipmentVO.setAction(Parameters.EQUIPMENT_VO_ACTION_ADD);
			/*setActiveProvisionedServices(java.lang.String activeProvisionedServices)
			setAddAddrEquipFlag(short addAddrEquipFlag)
			setAdditionalEquipment(java.lang.String additionalEquipment)
			setAddNonAddrEquipFlag(short addNonAddrEquipFlag)
			setAddressableFlag(java.lang.Boolean addressableFlag)
			setAddSubOwnEquipFlag(short addSubOwnEquipFlag)
			setAddSubOwnHostEquipFlag(short addSubOwnHostEquipFlag)
			setBoxHost(java.lang.String boxHost)
			setBoxStatus(java.lang.String boxStatus)
			setCallBackDay(int callBackDay)
			setCardId(java.lang.String cardId)
			setComboDeviceFlag(java.lang.Boolean comboDeviceFlag)
			setCost(amdocs.core.Money cost)
			setCustAcct(java.lang.String custAcct)
			setDataId(java.lang.String dataId)
			setDeliverySysId(java.lang.String deliverySysId)
			setDeviceType(java.lang.String deviceType)
			setDeviceTypeCode(java.lang.String deviceTypeCode)
			setDigitalCapable(java.lang.String digitalCapable)
			setEmergencyAlertFlag(java.lang.Boolean emergencyAlertFlag)*/
			//equipmentVO.setEquipmentClass(String.valueOf(2));
			/*setEquipmentCode(java.lang.String equipmentCode)
			setEquipmentDeposit(amdocs.core.Money equipmentDeposit)
			setEquipmentVersion(java.lang.String equipmentVersion)
			setEquipMovementFlag(short equipMovementFlag)
			setEventCapableFlag(java.lang.Boolean eventCapableFlag)
			setHibit(int hibit)
			setHistoryFlag(short historyFlag)
			setHostAdditionalEquipment(java.lang.String hostAdditionalEquipment)
			setHostEquipmentType(java.lang.String hostEquipmentType)
			setHostEquipmentVersion(java.lang.String hostEquipmentVersion)
			setHostId(java.lang.String hostId)
			setHostInventory(int hostInventory)
			setHostMacAddr(java.lang.String hostMacAddr)
			setHostMfg(java.lang.String hostMfg)
			setHostModelNum(java.lang.String hostModelNum)
			setHostOption1Code(java.lang.String hostOption1Code)
			setHostOption2Code(java.lang.String hostOption2Code)
			setHostOption3Code(java.lang.String hostOption3Code)
			setHostSerialNumber(java.lang.String hostSerialNumber)
			setHostStbMacAddr(java.lang.String hostStbMacAddr)
			setHostWarrantyEndDate(java.util.Date hostWarrantyEndDate)
			setHostWarrantyStartDate(java.util.Date hostWarrantyStartDate)
			setHub(java.lang.String hub)
			setImpulsePpvPin(java.lang.String impulsePpvPin)
			setInventory(int inventory)
			setIpAddr(java.lang.String ipAddr)
			setIsDepositRequired(boolean isDepositRequired)
			setIsDigitalCapable(java.lang.Boolean isDigitalCapable)
			setIsMDUAssigned(java.lang.Boolean isMDUAssigned)
			setIsSiteAssigned(boolean isSiteAssigned)
			setLastPollDate(java.util.Date lastPollDate)
			setLinkHostFlag(short linkHostFlag)*/
			if (videoEquipmentConstraintsVO.getLocationCode().getRequired()) {
				equipmentVO.setLocation(apiParams.getEquipmentLocation());
			}
			/*setLocLongDesc(java.lang.String locLongDesc)
			setLocShortDesc(java.lang.String locShortDesc)
			setLot(java.lang.String lot)
			setMacAddr(java.lang.String macAddr)
			setMfg(java.lang.String mfg)
			setModelNum(java.lang.String modelNum)
			setModemId(java.lang.String modemId)
			setNumRepairs(int numRepairs)
			setOption1Code(java.lang.String option1Code)
			setOption2Code(java.lang.String option2Code)
			setOption3Code(java.lang.String option3Code)*/
			equipmentVO.setOutlet(apiParams.getOutlet());
			/*setPhoneFlag(java.lang.Boolean phoneFlag)
			setPin(java.lang.String pin)
			setPlace(java.lang.String place)
			setPpvAuthorizedFlag(java.lang.Boolean ppvAuthorizedFlag)
			setPrevCustAcct(java.lang.String prevCustAcct)
			setPrevHostSerialNumber(java.lang.String prevHostSerialNumber)*/
			equipmentVO.setPrevSerialNumber(apiParams.getPrevSerialNumber());
			/*setPrevSiteEquipDesc(java.lang.String prevSiteEquipDesc)
			setPrevSiteId(java.lang.String prevSiteId)
			setProm(long prom)
			setPurchDate(java.util.Date purchDate)*/
			if (videoEquipmentConstraintsVO.getRating().getRequired()) {
				equipmentVO.setRating("2"); //Valid Values: 0 = G, 1 = PG, 2 = R, 3 = X
			}
			/*setRemoveEquipFlag(short removeEquipFlag)
			setRemoveSiteEquipFlag(java.lang.Boolean removeSiteEquipFlag)
			setRepair(int repair)
			setReturnReasonCode(java.lang.String returnReasonCode)
			setSerialNumber(java.lang.String serialNumber)
			setSiteEquipCode(java.lang.String siteEquipCode)
			setSiteEquipDesc(java.lang.String siteEquipDesc)
			setSiteId(java.lang.String siteId)
			setStbMacAddr(java.lang.String stbMacAddr)
			setSubscriberOwned(boolean subscriberOwned)
			setSubType(int subType)
			setTech(java.lang.String tech)
			setTotalPorts(int totalPorts)
			setTwoWayFlag(java.lang.Boolean twoWayFlag)
			setUnitAddr(java.lang.String unitAddr)
			setWarrantyEndDate(java.util.Date warrantyEndDate)
			setWarrantyStartDate(java.util.Date warrantyStartDate)*/
			
			printOutput.printToShell(apiParams, 
									 getClass().getName() + ":<equipmentVO>" + equipmentVO.toString() + "</equipmentVO>",
									 equipmentVO.toXml());

		}
		
		public void updateEquipmentVOforRemoveEquipmentFromAccount (Parameters apiParams, PrintOutput printOutput, EquipmentVO equipmentVO, VideoEquipmentConstraintsVO videoEquipmentConstraintsVO) {
			
			// Check video equipment constraints when needed
			equipmentVO.setAction(Parameters.EQUIPMENT_VO_ACTION_REMOVE);
			/*setActiveProvisionedServices(java.lang.String activeProvisionedServices)
			setAddAddrEquipFlag(short addAddrEquipFlag)
			setAdditionalEquipment(java.lang.String additionalEquipment)
			setAddNonAddrEquipFlag(short addNonAddrEquipFlag)
			setAddressableFlag(java.lang.Boolean addressableFlag)
			setAddSubOwnEquipFlag(short addSubOwnEquipFlag)
			setAddSubOwnHostEquipFlag(short addSubOwnHostEquipFlag)
			setBoxHost(java.lang.String boxHost)
			setBoxStatus(java.lang.String boxStatus)
			setCallBackDay(int callBackDay)
			setCardId(java.lang.String cardId)
			setComboDeviceFlag(java.lang.Boolean comboDeviceFlag)
			setCost(amdocs.core.Money cost)
			setCustAcct(java.lang.String custAcct)
			setDataId(java.lang.String dataId)
			setDeliverySysId(java.lang.String deliverySysId)
			setDeviceType(java.lang.String deviceType)
			setDeviceTypeCode(java.lang.String deviceTypeCode)
			setDigitalCapable(java.lang.String digitalCapable)
			setEmergencyAlertFlag(java.lang.Boolean emergencyAlertFlag)*/
			//equipmentVO.setEquipmentClass(String.valueOf(2));
			/*setEquipmentCode(java.lang.String equipmentCode)
			setEquipmentDeposit(amdocs.core.Money equipmentDeposit)
			setEquipmentVersion(java.lang.String equipmentVersion)
			setEquipMovementFlag(short equipMovementFlag)
			setEventCapableFlag(java.lang.Boolean eventCapableFlag)
			setHibit(int hibit)
			setHistoryFlag(short historyFlag)
			setHostAdditionalEquipment(java.lang.String hostAdditionalEquipment)
			setHostEquipmentType(java.lang.String hostEquipmentType)
			setHostEquipmentVersion(java.lang.String hostEquipmentVersion)
			setHostId(java.lang.String hostId)
			setHostInventory(int hostInventory)
			setHostMacAddr(java.lang.String hostMacAddr)
			setHostMfg(java.lang.String hostMfg)
			setHostModelNum(java.lang.String hostModelNum)
			setHostOption1Code(java.lang.String hostOption1Code)
			setHostOption2Code(java.lang.String hostOption2Code)
			setHostOption3Code(java.lang.String hostOption3Code)
			setHostSerialNumber(java.lang.String hostSerialNumber)
			setHostStbMacAddr(java.lang.String hostStbMacAddr)
			setHostWarrantyEndDate(java.util.Date hostWarrantyEndDate)
			setHostWarrantyStartDate(java.util.Date hostWarrantyStartDate)
			setHub(java.lang.String hub)
			setImpulsePpvPin(java.lang.String impulsePpvPin)
			setInventory(int inventory)
			setIpAddr(java.lang.String ipAddr)
			setIsDepositRequired(boolean isDepositRequired)
			setIsDigitalCapable(java.lang.Boolean isDigitalCapable)
			setIsMDUAssigned(java.lang.Boolean isMDUAssigned)
			setIsSiteAssigned(boolean isSiteAssigned)
			setLastPollDate(java.util.Date lastPollDate)
			setLinkHostFlag(short linkHostFlag)*/
			//if (videoEquipmentConstraintsVO.getEquipmentCode().getRequired()) {
				equipmentVO.setLocation(apiParams.getEquipmentLocation());
			//}
			/*setLocLongDesc(java.lang.String locLongDesc)
			setLocShortDesc(java.lang.String locShortDesc)
			setLot(java.lang.String lot)
			setMacAddr(java.lang.String macAddr)
			setMfg(java.lang.String mfg)
			setModelNum(java.lang.String modelNum)
			setModemId(java.lang.String modemId)
			setNumRepairs(int numRepairs)
			setOption1Code(java.lang.String option1Code)
			setOption2Code(java.lang.String option2Code)
			setOption3Code(java.lang.String option3Code)*/
			//equipmentVO.setOutlet(apiParams.getOutlet());
			/*setPhoneFlag(java.lang.Boolean phoneFlag)
			setPin(java.lang.String pin)
			setPlace(java.lang.String place)
			setPpvAuthorizedFlag(java.lang.Boolean ppvAuthorizedFlag)
			setPrevCustAcct(java.lang.String prevCustAcct)
			setPrevHostSerialNumber(java.lang.String prevHostSerialNumber)
			setPrevSerialNumber(java.lang.String prevSerialNumber)
			setPrevSiteEquipDesc(java.lang.String prevSiteEquipDesc)
			setPrevSiteId(java.lang.String prevSiteId)
			setProm(long prom)
			setPurchDate(java.util.Date purchDate)*/
			//if (videoEquipmentConstraintsVO.getRating().getRequired()) {
			//	equipmentVO.setRating("2"); //Valid Values: 0 = G, 1 = PG, 2 = R, 3 = X
			//}
			/*setRemoveEquipFlag(short removeEquipFlag)
			setRemoveSiteEquipFlag(java.lang.Boolean removeSiteEquipFlag)
			setRepair(int repair)
			setReturnReasonCode(java.lang.String returnReasonCode)
			setSerialNumber(java.lang.String serialNumber)
			setSiteEquipCode(java.lang.String siteEquipCode)
			setSiteEquipDesc(java.lang.String siteEquipDesc)
			setSiteId(java.lang.String siteId)
			setStbMacAddr(java.lang.String stbMacAddr)
			setSubscriberOwned(boolean subscriberOwned)
			setSubType(int subType)
			setTech(java.lang.String tech)
			setTotalPorts(int totalPorts)
			setTwoWayFlag(java.lang.Boolean twoWayFlag)
			setUnitAddr(java.lang.String unitAddr)
			setWarrantyEndDate(java.util.Date warrantyEndDate)
			setWarrantyStartDate(java.util.Date warrantyStartDate)*/
			
			printOutput.printToShell(apiParams, 
									 getClass().getName() + ":<equipmentVO>" + equipmentVO.toString() + "</equipmentVO>",
									 equipmentVO.toXml());

		}
}
