package app.get;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.AccountViewLedgerFacade;
import amdocs.amsp.valueobject.accountviewledger.LedgerSummaryVO;

public class GetLedgerSummaryVO_Test {
	
	private AccountViewLedgerFacade accountViewLedgerFacade = new AccountViewLedgerFacade();
	private LedgerSummaryVO[] ledgerSummaryVOarr = null;
	
	public LedgerSummaryVO[] getSummaryLedger (Parameters apiParams, Login login, PrintOutput printOutput) {
		
		try {
			ledgerSummaryVOarr = accountViewLedgerFacade.getSummaryLedger(apiParams.getsiteId(), 
																		  apiParams.getCust_acct(), 
																		  apiParams.getStatementDate(), 
																		  apiParams.getStatementDate(), 
																		  apiParams.getCorp(), 
																		  login.getTicket());
			
			if (ledgerSummaryVOarr != null) {
				for (int i = 0; i != ledgerSummaryVOarr.length; i++) {
					printOutput.printToShell(apiParams, 
											 getClass().getName() + ":<ledgerSummaryVOarr id=" + i + ">" + ledgerSummaryVOarr[i].toString() + "</ledgerSummaryVOarr>",
											 ledgerSummaryVOarr[i].toXml());
	 			}
			}
			else {
				printOutput.printToShell(apiParams, getClass().getName() + ":<ledgerSummaryVOarr> is null", null);
			}
		}
		catch (AmspServiceException e) 	{
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
		
		return (ledgerSummaryVOarr);
	}

}
