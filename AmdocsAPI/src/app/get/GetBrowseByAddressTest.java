package app.get;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.AccountBrowseFacade;
import amdocs.amsp.valueobject.accountbrowse.BrowseResultVO;
import amdocs.amsp.valueobject.addressservice.AddressFieldsDetailVO;


public class GetBrowseByAddressTest {
	
	private AccountBrowseFacade accountBrowseFacade = new AccountBrowseFacade();
	private BrowseResultVO[] browseResultVO = null;
	
	public BrowseResultVO[] getBrowseByAddress(Parameters apiParams, Login login, PrintOutput printOutput, AddressFieldsDetailVO[] addressFieldsDetailVO) {
		try {
			// CollectionsInfoVO 
			browseResultVO = accountBrowseFacade.browseByAddress(apiParams.getAddressType(), 
					                                             apiParams.getPlant(), 
					                                             addressFieldsDetailVO, 
					                                             apiParams.getCorpSet(), 
					                                             login.getTicket());
            
			if (browseResultVO != null) {
				for (int i = 0; i != browseResultVO.length; i++) {
					printOutput.printToShell(apiParams, 
											 getClass().getName() + ":<browseResultVO id=" + i + ">" + browseResultVO[i].toString() + "</browseResultVO>",
											 browseResultVO[i].toXml());
	 			}
			}
			else {
				printOutput.printToShell(apiParams, getClass().getName() + ":<browseResultVO> is null", null);
			}
			
			
		} catch (AmspServiceException e) {
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
		return (browseResultVO);
	}
}
