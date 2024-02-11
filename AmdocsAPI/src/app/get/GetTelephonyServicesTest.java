package app.get;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.AccountViewServicesFacade;
import amdocs.amsp.valueobject.accountviewservices.PhoneNumberVO;

public class GetTelephonyServicesTest {
	
	private AccountViewServicesFacade accountViewServicesFacade = new AccountViewServicesFacade();
	private PhoneNumberVO[] phoneNumberVOList = null;
	
	public PhoneNumberVO[] getTelephonyServices (Parameters apiParams, Login login, PrintOutput printOutput) {
		
		try {
			phoneNumberVOList = accountViewServicesFacade.getTelephonyServices(apiParams.getsiteId(), 
																			   apiParams.getCust_acct(), 
																			   apiParams.getCorp(), 
																			   login.getTicket());
			
			if (phoneNumberVOList != null) {
				for (int i = 0; i != phoneNumberVOList.length; i++) {
					printOutput.printToShell(apiParams, 
							getClass().getName() + ":<phoneNumberVOList id=" + i + ">" + phoneNumberVOList[i].toString() + "</phoneNumberVOList>",
							phoneNumberVOList[i].toXml());
	 			}
			}
			else {
				printOutput.printToShell(apiParams, getClass().getName() + ":<phoneNumberVOList> is null", null);
			}
		}
		catch (AmspServiceException e) 	{
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
		
		return phoneNumberVOList;
	}
}
