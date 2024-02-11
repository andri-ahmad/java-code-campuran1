package app.get;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.exception.AmspServiceException;

import amdocs.amsp.services.AccountViewWipFacade;
import amdocs.amsp.valueobject.accountviewwip.OrderGroupVO;

public class GetOpenOrderGroupListTest {

	private AccountViewWipFacade accountViewWipFacade = new AccountViewWipFacade();
	private OrderGroupVO[] orderGroupVO = null;
	
	public OrderGroupVO[] getOpenOrderGroupList(Parameters apiParams, Login login, PrintOutput printOutput) 
	{ 
		try {
			orderGroupVO = accountViewWipFacade.getOpenOrderGroupList(apiParams.getCust_acct(), apiParams.getOrderType(), apiParams.getCorp(), login.getTicket());
			
			if (orderGroupVO != null) {
				for (int i = 0; i != orderGroupVO.length; i++) {
					printOutput.printToShell(apiParams, 
							getClass().getName() + ":<OrderGroupVO>" +	orderGroupVO[i].toString() + "</OrderGroupVO>",
							orderGroupVO[i].toXml());
					}
				
			}
			else {
				printOutput.printToShell(apiParams, getClass().getName() + ":<OrderGroupVO> is null", null);
			}
			
		}
		catch (AmspServiceException e) 	{
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
		return (orderGroupVO);
	}
}
