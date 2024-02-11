package app.opr;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.valueobject.accountconstraints.WIPConstraintsVO;
import amdocs.amsp.services.OpSroFacade;
import amdocs.amsp.valueobject.order.OrderVO;
import amdocs.amsp.valueobject.order.OrderResultVO;
import app.get.GetWIPConstraintsVO_Test;
import app.get.GetWipOrderSummaryListVO_Test;
import app.update.UpdateOrderVO_Test;

public class OprCancelSRO_Test {
	
	private boolean foundFlag = false;
	private int i = 0;
	private WIPConstraintsVO wIPConstraintsVO = new WIPConstraintsVO();
	private OrderVO orderVO = new OrderVO();
	private OrderVO[] orderVOList = null;
	private OpSroFacade opSroFacade = new OpSroFacade();
	private OrderResultVO orderResultVO = new OrderResultVO();
	
	private GetWIPConstraintsVO_Test getWIPConstraintsVO_Test = new GetWIPConstraintsVO_Test();
	private GetWipOrderSummaryListVO_Test getWipOrderSummaryListVO_Test = new GetWipOrderSummaryListVO_Test();
	private UpdateOrderVO_Test updateOrderVO_Test = new UpdateOrderVO_Test();
	
	public void getData (Parameters apiParams, Login login, PrintOutput printOutput) {
		
		wIPConstraintsVO = getWIPConstraintsVO_Test.getWIPConstraints(apiParams, login, printOutput);
		
		orderVOList = getWipOrderSummaryListVO_Test.getWipOrderSummaryList(apiParams, login, printOutput);
		
	}
	
	public void setData (Parameters apiParams, Login login, PrintOutput printOutput) {
		foundFlag = false;
		// look for first SRO in list
		for (i = 0; i != orderVOList.length && foundFlag != true; i++) {
			
			if (orderVOList[i].getJobType() == apiParams.getJobType()) {
				orderVO = orderVOList[i];
				foundFlag = true;
			}
		}
		
		if (foundFlag) {
			printOutput.printToShell(apiParams, "SRO Order found", null);
			
			updateOrderVO_Test.updateOrderVOforSRO(apiParams, printOutput, wIPConstraintsVO, orderVO);
			
			for (i = 0; i != orderVOList.length != true; i++) {
			printOutput.printToShell(apiParams, 
									 getClass().getName() + ":<orderVO> Elem: " + i + " " + orderVOList[i].toString() + "</prospectResultVO>",
									 orderVOList[i].toXml());
			}
		} else {
			printOutput.printToShell(apiParams, "SRO Order not found", null);
		}
	}
	
	public void saveData (Parameters apiParams, Login login, PrintOutput printOutput) {
		
		if (foundFlag) {
			try {
				
				orderResultVO = opSroFacade.cancelSro(orderVO,
                        						 apiParams.getQueueHsdsHitFlag(),
                        						 apiParams.getCorp(),
                        						 login.getTicket());
				if (orderResultVO != null)
				{
				printOutput.printToShell(apiParams, 
										 getClass().getName() + ":<orderResultVO>" + orderResultVO.toString() + "</orderResultVO>",
										 orderResultVO.toXml());
				}
				else {
					
				}

			} catch (AmspServiceException e) {
				printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
			}
		}
		else {
			printOutput.printToShell(apiParams, getClass().getName() + ": WARNING: CheckCustomerPhoneTest.checkData found duplicate rphone number - Save Prospect cancelled", null);
		}
	}
}
