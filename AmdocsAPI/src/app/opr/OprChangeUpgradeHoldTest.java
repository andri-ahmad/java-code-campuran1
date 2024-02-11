package app.opr;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.OpChangeMoneyStatusFacade;
import amdocs.amsp.valueobject.accountviewcollections.CollectionsInfoVO;
import amdocs.amsp.valueobject.opchangemoneystatus.CollectionStatusVO;
import app.get.GetCollectionsInfoVO_Test;
import app.set.SetCollectionStatusVO_Test;

public class OprChangeUpgradeHoldTest {
	
	private GetCollectionsInfoVO_Test getCollectionsInfoVO_Test = new GetCollectionsInfoVO_Test();
	private CollectionsInfoVO collectionsInfoVO = new CollectionsInfoVO();
	private OpChangeMoneyStatusFacade opChangeMoneyStatusFacade = new OpChangeMoneyStatusFacade();
	private SetCollectionStatusVO_Test setCollectionStatusVO_Test = new SetCollectionStatusVO_Test();
	private CollectionStatusVO collectionStatusVO = new CollectionStatusVO();
	private boolean result = false;

	public void getData (Parameters apiParams, Login login, PrintOutput printOutput) {
		
		collectionsInfoVO = getCollectionsInfoVO_Test.getCollectionsInfo(apiParams, login, printOutput);
	}
	
	public void setData (Parameters apiParams, Login login, PrintOutput printOutput) {
		
		result = setCollectionStatusVO_Test.setCollectionStatusVOForChangeUpgradeHold(apiParams, 
																			 printOutput,
																			 collectionsInfoVO, 
																			 collectionStatusVO);
	}

	public void saveData (Parameters apiParams, Login login, PrintOutput printOutput) {
		
		if (result) {
			try {
				
				opChangeMoneyStatusFacade.updateCollectionStatus(collectionStatusVO,
																 apiParams.getCorp(), 
																 login.getTicket());

			} catch (AmspServiceException e) {
				printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
			}
		} else {
			printOutput.printToShell(apiParams, 
            		getClass().getName() + " No update perfomed", null);
		}
	}
}
