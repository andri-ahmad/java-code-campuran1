package app.misc;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.OpBatchesFacade;
import amdocs.amsp.valueobject.order.OrderResultVO;

public class CloseBatchesTest {
	private OpBatchesFacade opBatchesFacade = new OpBatchesFacade();
	private OrderResultVO orderResultVO = new OrderResultVO();
	
	public void closeBatches (Parameters apiParams, Login login, PrintOutput printOutput) {
		
		try {
			orderResultVO = opBatchesFacade.closeBatches(apiParams.getIsFrontCounterMode(), apiParams.getCorp(), login.getTicket());
			
			if (orderResultVO != null) {
				printOutput.printToShell(apiParams, 
										 getClass().getName() + ":<orderResultVO>" + orderResultVO.toString() + "</orderResultVO>",
										 orderResultVO.toXml());
			}
			else {
				printOutput.printToShell(apiParams, getClass().getName() + ":<prospectResultVO> is null", null);
			}
		} 	catch (AmspServiceException e) {
				printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
	}
}
