package app.get;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.CustomerFacade;
import amdocs.amsp.valueobject.customer.CustomerDetailsVO;

public class GetCustomerDetailsVO_Test 
{
	private CustomerFacade customerFacade = new CustomerFacade();
	private CustomerDetailsVO customerDetailsVO = new CustomerDetailsVO();
	
	public CustomerDetailsVO getCustomerDetail(Parameters apiParams, Login login, PrintOutput printOutput) 
	{ 
		try {
			customerDetailsVO = customerFacade.getCustomerDetail (apiParams.getCust_acct(),
																  apiParams.getSkipPayCard(),
																  apiParams.getCorp(), 
																  login.getTicket());
			
			if (customerDetailsVO != null) {
				printOutput.printToShell(apiParams, 
										 getClass().getName() + ":<customerDetailsVO>" +	customerDetailsVO.toString() + "</CustomerDetailsVO>",
										 customerDetailsVO.toXml());
			}
			else {
				printOutput.printToShell(apiParams, getClass().getName() + ":<customerDetailsVO> is null", null);
			}
		}
		catch (AmspServiceException e) 	{
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
		return (customerDetailsVO);
	}
}
