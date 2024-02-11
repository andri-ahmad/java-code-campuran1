package app.get;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.valueobject.addressservice.AllAddressVO;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.AddressServiceFacade;

public class GetAllAddressTest {
	
	private AllAddressVO allAddressVO = new AllAddressVO();
	private AddressServiceFacade addressServiceFacade = new AddressServiceFacade();
	
	public AllAddressVO getAllAddress (Parameters apiParams, Login login, PrintOutput printOutput) {
		
		try {
			
			allAddressVO = addressServiceFacade.getAllAddress(apiParams.getCust_acct(), 
															  apiParams.getsiteId(), 
															  apiParams.getCorp(), 
															  login.getTicket());
			
			if (allAddressVO != null) {
				printOutput.printToShell(apiParams, 
						getClass().getName() + ":<allAddressVO>" + allAddressVO + "</allAddressVO>", null);
			}
			else {
				printOutput.printToShell(apiParams, getClass().getName() + ":<allAddressVO> is null", null);
			}	
			
		}
		catch (AmspServiceException e) 	{
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
		
		return (allAddressVO);
	}

}
