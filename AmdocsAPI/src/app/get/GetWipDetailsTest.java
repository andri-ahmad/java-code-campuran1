package app.get;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.AccountViewWipFacade;
import amdocs.amsp.valueobject.order.OrderVO;

public class GetWipDetailsTest {
	
	private AccountViewWipFacade accountViewWipFacade = new AccountViewWipFacade();
	private OrderVO orderVO = new OrderVO();
	
	public OrderVO getWipDetails(Parameters apiParams, Login login, PrintOutput printOutput) {
		try {
			// OrderVO 
			orderVO = accountViewWipFacade.getWipDetails(apiParams.getCust_acct(), 
														 apiParams.getOffernum(), 
														 apiParams.getSkipServicePointData(), 
														 apiParams.getCorp(), 
														 login.getTicket());
			
			if (orderVO != null) {
				printOutput.printToShell(apiParams, 
						getClass().getName() + ":<OrderVO>" + orderVO.toString() + "</OrderVO>",
						orderVO.toXml());
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
