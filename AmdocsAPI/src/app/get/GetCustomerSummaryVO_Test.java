package app.get;

import util.Login;
import util.Parameters;
import util.PrintOutput;

import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.AccountViewFacade;
import amdocs.amsp.valueobject.accountview.CustomerSummaryVO;

public class GetCustomerSummaryVO_Test {
	private AccountViewFacade accountViewFacade = new AccountViewFacade();
	private CustomerSummaryVO customerSummaryVO = new CustomerSummaryVO();
	
	public CustomerSummaryVO getCustomerSummary(Parameters apiParams, Login login, PrintOutput printOutput) {
		{ 
			try {
				customerSummaryVO = accountViewFacade.getCustomerSummary(
						apiParams.getsiteId(), 
						apiParams.getCust_acct(), 
						apiParams.getCorp(), 
						login.getTicket());
				
				if (customerSummaryVO != null) {
					printOutput.printToShell(apiParams, 
							getClass().getName() + ":<customerSummaryVO>" + customerSummaryVO.toString() + "</customerSummaryVO>",
							customerSummaryVO.toXml());
				}
				else {
					printOutput.printToShell(apiParams, getClass().getName() + ":<customerSummaryVO> is null", null);
				}
				
			}
			catch (AmspServiceException e) 	{
				printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
			}
			return (customerSummaryVO);
		}
	}
}
