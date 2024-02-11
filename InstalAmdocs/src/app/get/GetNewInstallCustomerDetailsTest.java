package app.get;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import util.SupportException;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.OpInstallFacade;
import amdocs.amsp.valueobject.customer.CustomerDetailsVO;

public class GetNewInstallCustomerDetailsTest {

	private OpInstallFacade opInstallFacade = new OpInstallFacade();
	private CustomerDetailsVO customerDetailsVO = new CustomerDetailsVO();
	
	public CustomerDetailsVO getNewInstallCustomerDetails(Parameters apiParams, Login login, PrintOutput printOutput) throws SupportException { 
		try {
			customerDetailsVO = opInstallFacade.getNewInstallCustomerDetails(apiParams.getsiteId(), apiParams.getCorp(), login.getTicket());
			
			if (customerDetailsVO != null) {
				printOutput.printToShell(apiParams, 
						getClass().getName() + ":<customerDetailsVO>" +	customerDetailsVO.toString() + "</CustomerDetailsVO>",
						customerDetailsVO.toXml());
			}
			else {
				throw new SupportException("customerDetailsVO is null");
			}
			
		}
		catch (AmspServiceException e) 	{
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
		return (customerDetailsVO);
	}
}
