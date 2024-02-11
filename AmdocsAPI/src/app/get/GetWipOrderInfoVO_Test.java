package app.get;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.ServiceConstantsI;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.AccountViewWipFacade;
import amdocs.amsp.valueobject.order.OrderVO;

public class GetWipOrderInfoVO_Test {

	private AccountViewWipFacade accountViewWipFacade = new AccountViewWipFacade();
		private OrderVO orderVO = new OrderVO();
		
	// wrapper method
	public OrderVO getWipOrderInfo (Parameters apiParams, Login login, PrintOutput printOutput) {
		try {
				orderVO = accountViewWipFacade.getWipOrderInfo(
						apiParams.getCust_acct(),
						apiParams.getOffernum(),
						ServiceConstantsI.JobType.JOBTYPE_INSTALL.getJobTypeValue(),
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
