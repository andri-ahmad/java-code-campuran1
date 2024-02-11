package app.get;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.OpChangeOfServiceFacade;
import amdocs.amsp.valueobject.order.OrderVO;

public class GetNewChangeOfServiceOrderTest {
	private OpChangeOfServiceFacade opChangeOfServiceFacade = new OpChangeOfServiceFacade();
	private OrderVO orderVO = new OrderVO();
	
	public OrderVO getNewChangeOfServiceOrder(Parameters apiParams, Login login, PrintOutput printOutput) 
	{ 
		try {
			orderVO = opChangeOfServiceFacade.getNewChangeOfServiceOrder(apiParams.getCust_acct(), 
																		 apiParams.getsiteId(), 
																		 apiParams.getOrderGroupSeq(), 
																		 apiParams.getBillDate(), 
																		 3, // Effective Date flag indicates the nature of COS order being taken.Valid values are 1 - Add effective date before,2 - Add effective date after, 3 - Add with same effective date.
																		 apiParams.getCorp(), 
																		 login.getTicket());
			
			if (orderVO != null) {
				printOutput.printToShell(apiParams, 
						getClass().getName() + ":<OrderVO>" +	orderVO.toString() + "</OrderVO>",
						orderVO.toXml());
			}
			else {
				printOutput.printToShell(apiParams, getClass().getName() + ":<OrderVO> is null", null);
			}
			
		}
		catch (AmspServiceException e) 	{
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
		return (orderVO);
	}
}
