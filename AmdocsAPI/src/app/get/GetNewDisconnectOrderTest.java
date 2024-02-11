package app.get;

import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.OpDisconnectFacade;
import amdocs.amsp.valueobject.order.OrderVO;
import util.Login;
import util.Parameters;
import util.PrintOutput;

public class GetNewDisconnectOrderTest {

	private OpDisconnectFacade opDisconnectFacade = new OpDisconnectFacade();
	private OrderVO orderVO = new OrderVO();
	
	public OrderVO getNewDisconnectOrder(Parameters apiParams, Login login, PrintOutput printOutput) {
		try {
			orderVO = opDisconnectFacade.getNewDisconnectOrder(apiParams.getsiteId(), 
														 apiParams.getCust_acct(),
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
		return (orderVO);
	}

}
