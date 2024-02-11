package app.get;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.AccountViewWipFacade;
import amdocs.amsp.valueobject.order.OrderVO;

public class GetWipOrderSummaryListVO_Test {
	private AccountViewWipFacade accountViewWipFacade = new AccountViewWipFacade();
	private OrderVO[] orderVO = null;
	
	public OrderVO[] getWipOrderSummaryList(Parameters apiParams, Login login, PrintOutput printOutput) {
		try {
			// OrderVO 
			orderVO = accountViewWipFacade.getWipOrderSummaryList(
					apiParams.getCust_acct(),
					apiParams.getCorp(),
					login.getTicket());
			
			if(orderVO != null) {
				for (int i = 0; i != orderVO.length; i++) 
				{		
					printOutput.printToShell(apiParams, 
							getClass().getName() + ":<OrderVO>" +	orderVO[i].toString() + "</OrderVO>",
							orderVO[i].toXml());
					
					// print the Order Type value and description
					printOutput.printToShell(apiParams, getClass().getName() + ":<orderType>" + orderVO[i].getOrderType() 
							+ "</orderType>" + " <orderTypeDesc>" + orderVO[i].getOrderTypeDesc() + "<orderTypeDesc>", null);
				}
			}
			else {
				printOutput.printToShell(apiParams, getClass().getName() + ":<orderVO> is null", null);
			}
			
		} catch (AmspServiceException e) {
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
		return (orderVO);
	}
}
