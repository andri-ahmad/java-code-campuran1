package app.get;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import util.SupportException;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.FinancialFacade;
import amdocs.amsp.valueobject.financial.MoneyTransactionVO;

public class GetNewMoneyTransactionVO_Test {
	
	private FinancialFacade financialFacade = new FinancialFacade();
	private MoneyTransactionVO moneyTransactionVO = new MoneyTransactionVO();
	
	public MoneyTransactionVO getNewMoneyTranasction(Parameters apiParams, Login login, PrintOutput printOutput) throws SupportException {
		try {
			moneyTransactionVO = financialFacade.getNewMoneyTransaction(apiParams.getCust_acct(),
																		apiParams.getsiteId(), 
																		apiParams.getCallerName(),
																		apiParams.getCorp(),
																		login.getTicket());
			
			if (moneyTransactionVO != null) {
				printOutput.printToShell(apiParams, 
										 getClass().getName() + ":<moneyTransactionVO>" + moneyTransactionVO.toString() + "</moneyTransactionVO>",
										 moneyTransactionVO.toXml());
			}
			else {
				throw new SupportException("moneyTransactionVO is null");
			}
		
		} catch (AmspServiceException e) {
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
		return (moneyTransactionVO);
	}
}
