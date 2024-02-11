package app.get;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.OpOrderFacade;
import amdocs.amsp.valueobject.order.OrderVO;

public class GetNewOrderTest {
	
	private OrderVO orderVO = new OrderVO();
	private OpOrderFacade opOrderFacade = new OpOrderFacade();
	
	public OrderVO getNewOrder(Parameters apiParams, Login login, PrintOutput printOutput) {
		try {
			orderVO = opOrderFacade.getNewOrder(apiParams.getCust_acct(), 
												apiParams.getOrderType(), 
												apiParams.getOrderGroupSeq(), 
												apiParams.getCorp(), 
												login.getTicket());
			
			if (orderVO != null) {
				printOutput.printToShell(apiParams, 
						getClass().getName() + ":<orderVO>" + orderVO.toString() + "</orderVO>",
						orderVO.toXml());
			}
			else {
				printOutput.printToShell(apiParams, getClass().getName() + ":<orderVO> is null", null);
			}
			
		}
		catch (AmspServiceException e) 	{
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
		
		return orderVO;
	}
}
