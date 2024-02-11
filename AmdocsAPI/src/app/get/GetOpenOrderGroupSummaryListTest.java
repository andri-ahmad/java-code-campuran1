package app.get;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.valueobject.accountviewwip.OrderGroupSummaryVO;
import amdocs.amsp.services.AccountViewWipFacade;

public class GetOpenOrderGroupSummaryListTest {
	private AccountViewWipFacade accountViewWipFacade = new AccountViewWipFacade();
	private OrderGroupSummaryVO[] orderGroupSummaryVO = null;
	
	public OrderGroupSummaryVO[] getOpenOrderGroupSummaryList(Parameters apiParams, Login login, PrintOutput printOutput) 
	{ 
		try {
			orderGroupSummaryVO = accountViewWipFacade.getOpenOrderGroupSummaryList(apiParams.getCust_acct(), apiParams.getCorp(), login.getTicket());
			
			if (orderGroupSummaryVO != null) {
				for (int i = 0; i != orderGroupSummaryVO.length; i++) {
					printOutput.printToShell(apiParams, 
							getClass().getName() + ":<OrderGroupSummaryVO>" +	orderGroupSummaryVO[i].toString() + "</OrderGroupSummaryVO>",
							orderGroupSummaryVO[i].toXml());
					}
			}
			else {
				printOutput.printToShell(apiParams, getClass().getName() + ":<OrderGroupSummaryVO> is null", null);
			}
			
		}
		catch (AmspServiceException e) 	{
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
		return (orderGroupSummaryVO);
	}

}
