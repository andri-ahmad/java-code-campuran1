package app.misc;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import util.SupportException;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.ContractsFacade;
import amdocs.amsp.valueobject.order.OrderVO;

public class ApplyContractServicesTest {
	
	private ContractsFacade contractsFacade = new ContractsFacade();
	private OrderVO orderVO = new OrderVO();
	
	public OrderVO applyContractServices(Parameters apiParams, 
			  						     PrintOutput printOutput, 
			  						     Login login,
			  						     OrderVO orderVOIn) throws SupportException {
		try {
			orderVO = contractsFacade.applyContractServices(orderVOIn, apiParams.getCorp(), login.getTicket());
		
			if (orderVO != null) {
				printOutput.printToShell(apiParams, 
										 getClass().getName() + ":<orderVO>" + orderVO.toString() + "</orderVO>", 
										 orderVO.toXml());
			}
			else {
				throw new SupportException(getClass().getName() + " <orderVO> is null");
			}
			
		} catch (AmspServiceException e) {
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
			return (null);
		}
		return orderVO;
	}
}
