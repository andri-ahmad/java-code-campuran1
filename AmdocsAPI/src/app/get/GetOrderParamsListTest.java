package app.get;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.valueobject.corpparam.OrderParamsVO;
import amdocs.amsp.services.CorpparamFacade;

/**
 * @author JVANHOOF
 * This really is not a list - bad original naming
 */
public class GetOrderParamsListTest {
	private CorpparamFacade corpparamFacade = new CorpparamFacade();
	private OrderParamsVO orderParamsVO = new OrderParamsVO();
	
	public OrderParamsVO getOrderParamsListTest(Parameters apiParams, Login login, PrintOutput printOutput) 
	{ 
		try {
			orderParamsVO = corpparamFacade.getOrderParamsList(apiParams.getCorp(), login.getTicket());
			
			if (orderParamsVO != null) {
				printOutput.printToShell(apiParams, 
						getClass().getName() + ":<OrderParamsVO>" +	orderParamsVO.toString() + "</OrderParamsVO>",
						orderParamsVO.toXml());
			}
			else {
				printOutput.printToShell(apiParams, getClass().getName() + ":<OrderParamsVO> is null", null);
			}
			
		}
		catch (AmspServiceException e) 	{
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
		return (orderParamsVO);
	}
}
