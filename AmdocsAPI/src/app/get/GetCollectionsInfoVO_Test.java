package app.get;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.AccountViewCollectionsFacade;
import amdocs.amsp.valueobject.accountviewcollections.CollectionsInfoVO;

public class GetCollectionsInfoVO_Test {
	private AccountViewCollectionsFacade accountViewCollectionsFacade = new AccountViewCollectionsFacade();
	private CollectionsInfoVO collectionsInfoVO = new CollectionsInfoVO();
	
	public CollectionsInfoVO getCollectionsInfo(Parameters apiParams, Login login, PrintOutput printOutput) {
		try {
			// CollectionsInfoVO 
			collectionsInfoVO = accountViewCollectionsFacade.getCollectionsInfo(
					apiParams.getsiteId(),
					apiParams.getCust_acct(),
					apiParams.getCorp(),
					login.getTicket());
            
			if (collectionsInfoVO != null) {
				printOutput.printToShell(apiParams, 
	            		getClass().getName() + ":<collectionsInfoVO>" + collectionsInfoVO.toString() + "</collectionsInfoVO>",
	            		collectionsInfoVO.toXml());
			}
			else {
				printOutput.printToShell(apiParams, getClass().getName() + ":<collectionsInfoVO> is null", null);
			}
			
			
		} catch (AmspServiceException e) {
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
		return (collectionsInfoVO);
	}
}
