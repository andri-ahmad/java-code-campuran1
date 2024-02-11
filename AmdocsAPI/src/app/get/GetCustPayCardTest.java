package app.get;

import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.EpiFacade;
import amdocs.amsp.valueobject.customer.PayCardDetailsVO;
import util.Login;
import util.Parameters;
import util.PrintOutput;

public class GetCustPayCardTest {
	
	private EpiFacade epiFacade = new EpiFacade();
	private PayCardDetailsVO[] payCardDetailsVOList = null;
	
	public PayCardDetailsVO[] getCustPayCard(Parameters apiParams, Login login, PrintOutput printOutput) 
	{ 
		try {
			payCardDetailsVOList = epiFacade.getCustPayCard(apiParams.getCust_acct(), apiParams.getCorp(), login.getTicket());
			
			if (payCardDetailsVOList != null) {
				for (int i = 0; i < payCardDetailsVOList.length; i++) {
					printOutput.printToShell(apiParams, 
							getClass().getName() + ":<payCardDetailsVOList[" + i + "] " + payCardDetailsVOList[i].toString() + "</payCardDetailsVOList[" + i + "]>",
							payCardDetailsVOList[i].toXml());
				}
			}
			else {
				printOutput.printToShell(apiParams, getClass().getName() + ":<payCardDetailsVOList> is null", null);
			}
			
		}
		catch (AmspServiceException e) 	{
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
		return (payCardDetailsVOList);
	}

}
