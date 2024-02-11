package app.get;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import util.SupportException;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.OpInstallFacade;
import amdocs.amsp.valueobject.order.OrderVO;

public class GetNewInstallOrderTest {
	
	private OpInstallFacade opInstallFacade = new OpInstallFacade();
	private OrderVO orderVO = new OrderVO();
	
	public OrderVO getNewInstallOrder(Parameters apiParams, Login login, PrintOutput printOutput) throws SupportException { 
		try {
			orderVO = opInstallFacade.getNewInstallOrder(apiParams.getsiteId(), 
														 apiParams.getCust_acct(), 
														 apiParams.getCorp(), 
														 login.getTicket());
			
			if (orderVO != null) {
				printOutput.printToShell(apiParams, 
						getClass().getName() + ":<orderVO>" + orderVO.toString() + "</orderVO>",
						orderVO.toXml());
			}
			else {
				throw new SupportException("orderVO is null");
			}
			
		}
		catch (AmspServiceException e) 	{
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
		return (orderVO);
	}

}
