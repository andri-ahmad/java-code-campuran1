package app.get;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.AccountViewFinancialsFacade;
import amdocs.amsp.valueobject.accountviewfinancials.FinancialVO;


public class GetFinancialTest {
	
	private AccountViewFinancialsFacade accountViewFinancialsFacade = new AccountViewFinancialsFacade();
	private FinancialVO financialVO = new FinancialVO();
	
	public FinancialVO getFinancial(Parameters apiParams, Login login, PrintOutput printOutput) 
	{ 
		try {
			financialVO = accountViewFinancialsFacade.getFinancial(apiParams.getCust_acct(), apiParams.getCorp(), login.getTicket());
			
			if (financialVO != null) {
				printOutput.printToShell(apiParams, 
										 getClass().getName() + ":<FinancialVO>" +	financialVO.toString() + "</FinancialVO>",
										 financialVO.toXml());
			}
			else {
				printOutput.printToShell(apiParams, getClass().getName() + ":<FinancialVO > is null", null);
			}
			
		}
		catch (AmspServiceException e) 	{
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
		return (financialVO);
	}
}
