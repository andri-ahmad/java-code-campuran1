package app.get;

import util.Lock;
import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.AddressServiceFacade;

public class GetAddressTest {
	private AddressServiceFacade addressServiceFacade = new AddressServiceFacade();
	private String address = null;
	
	public String getAddress(Parameters apiParams, Login login, Lock lock, PrintOutput printOutput) {
		{ 
			try {
				address = addressServiceFacade.getAddress(String.valueOf(apiParams.getAddressUse()),
														  apiParams.getCust_acct(), 
														  apiParams.getsiteId(), 
														  apiParams.getCorp(), 
														  login.getTicket());
				
				if (address != null) {
					printOutput.printToShell(apiParams, 
							getClass().getName() + ":<address>" + address + "</address>", null);
				}
				else {
					printOutput.printToShell(apiParams, getClass().getName() + ":<address> is null", null);
				}	
				
			}
			catch (AmspServiceException e) 	{
				printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
			}
			
			return (address);
		}
	} // end of getAddressFields method

}
