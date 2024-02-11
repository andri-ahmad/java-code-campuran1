package app.get;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import util.SupportException;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.OrderFlowFacade;
import amdocs.amsp.valueobject.orderflow.OrderOptionVO;

// use to validate that an Operation option is enabled
public class GetOrderOptionTest {
	
	private OrderOptionVO[] orderOptionVOList = null;
	private OrderFlowFacade orderFlowFacade = new OrderFlowFacade();
	
	public OrderOptionVO[] getOrderOption (Parameters apiParams, Login login, PrintOutput printOutput) throws SupportException {
		
		try {
			orderOptionVOList = orderFlowFacade.getOrderOption(apiParams.getCust_acct(), 
														   apiParams.getsiteId(), 
														   apiParams.getOffernum(), 
														   apiParams.getOrderType(), 
														   apiParams.getOrderGroupSeq().toString(), 
														   apiParams.getCorp(), 
														   login.getTicket());
			
			if (orderOptionVOList != null) {
				for (int i = 0; i != orderOptionVOList.length; i++) {
					printOutput.printToShell(apiParams, 
							getClass().getName() + ":<orderOptionVOList id=" + i + ">" + orderOptionVOList[i].toString() + "</orderOptionVOList>",
							orderOptionVOList[i].toXml());
	 			}
			}
			else {
				throw new SupportException("orderOptionVOList is null");
			}
		}
		catch (AmspServiceException e) 	{
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
		return orderOptionVOList;
	}

}
