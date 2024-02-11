package app.get;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.AccountViewStatementFacade;
import amdocs.amsp.valueobject.accountviewstatement.StatementDateVO;

public class GetStatementDateVO_Test {
	
	private AccountViewStatementFacade accountViewStatementFacade = new AccountViewStatementFacade();
	private StatementDateVO[] statementDateVOarr = null;
	
	public StatementDateVO[] getAvailableStatements (Parameters apiParams, Login login, PrintOutput printOutput) {
		
		try {
			statementDateVOarr = accountViewStatementFacade.getAvailableStatements(apiParams.getCust_acct(), apiParams.getCorp(), login.getTicket());
			
			if (statementDateVOarr != null) {
				for (int i = 0; i != statementDateVOarr.length; i++) {
					printOutput.printToShell(apiParams, 
											 getClass().getName() + ":<statementDateVOarr id=" + i + ">" + statementDateVOarr[i].toString() + "</statementDateVOarr>",
											 statementDateVOarr[i].toXml());
	 			}
			}
			else {
				printOutput.printToShell(apiParams, getClass().getName() + ":<statementDateVOarr> is null", null);
			}
		}
		catch (AmspServiceException e) 	{
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
		
		return (statementDateVOarr);
	}

}
