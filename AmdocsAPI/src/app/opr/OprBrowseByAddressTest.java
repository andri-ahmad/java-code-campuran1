package app.opr;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.AccountBrowseFacade;
import amdocs.amsp.valueobject.accountbrowse.BrowseResultVO;
import amdocs.amsp.valueobject.addressservice.AddressFieldsDetailVO;
//import amdocs.amsp.valueobject.site.SiteDetailsVO;

public class OprBrowseByAddressTest {
	private AccountBrowseFacade accountBrowseFacade = new AccountBrowseFacade();
	private BrowseResultVO[] browseResultVO = null;
	private AddressFieldsDetailVO[] addressFieldsDetailVO = null;
	
	public void setData (Parameters apiParams, Login login, PrintOutput printOutput) {
		
	}
	
	public void getData(Parameters apiParams, Login login, PrintOutput printOutput) {
		try {
			browseResultVO = accountBrowseFacade.browseByAddress(apiParams.getAddressType(), apiParams.getPlant(), addressFieldsDetailVO, apiParams.getCorpSet(), login.getTicket());
			
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
	}
}
