package app.set;

import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.valueobject.accountviewcollections.CollectionsInfoVO;
import amdocs.amsp.valueobject.opchangemoneystatus.CollectionStatusVO;

public class SetCollectionStatusVO_Test {
	
	public boolean setCollectionStatusVOForChangeUpgradeHold (Parameters apiParams, 
														   PrintOutput printOutput,
			                                               CollectionsInfoVO collectionsInfoVO, 
			                                               CollectionStatusVO collectionStatusVO) {

		boolean result = false;
		collectionStatusVO.setCallerName("API");  // Optional - value can be null
		collectionStatusVO.setCancelNpd((short)0); // Default
		collectionStatusVO.setCollStatAgencyCode(collectionsInfoVO.getAgency());
		collectionStatusVO.setCollStatCancelReason(collectionsInfoVO.getCancelReason());
		collectionStatusVO.setCollStatClass((short)collectionsInfoVO.getNextClass());
		collectionStatusVO.setCollStatClose((short)0); // Default
		collectionStatusVO.setCollStatComments(null);  // Default
		collectionStatusVO.setCollStatDate(apiParams.getCollStatDate());
		collectionStatusVO.setCollStatPath(collectionsInfoVO.getNextPath());  
		collectionStatusVO.setCollStatStep(collectionsInfoVO.getNextStep()); 
		collectionStatusVO.setColStatPpvHold(collectionsInfoVO.getPpvHold());
		
		if (collectionsInfoVO.getUpgradeHold() == apiParams.getUpgradeHold()) {
			printOutput.printToShell(apiParams, getClass().getName() + ":Warning - collectionsInfoVO.upgradeHold is same as API parameter: " + apiParams.getUpgradeHold(), null);
		}
		else {
			result = true;
			collectionStatusVO.setColStatUpgHold(apiParams.getUpgradeHold());
		}
		
		collectionStatusVO.setCustAcct(apiParams.getCust_acct());
		collectionStatusVO.setSiteId(apiParams.getsiteId());
		collectionStatusVO.setValidateOnlyFlg((short)0); // Default
		
		printOutput.printToShell(apiParams, 
            		getClass().getName() + ":<collectionStatusVO>" + collectionStatusVO.toString() + "</collectionStatusVO>",
            		collectionStatusVO.toXml());
		
		return result;
	}
}
