package app.opr;

import util.Login;
import util.Parameters;
import util.PrintOutput;
//import amdocs.amsp.exception.AmspServiceException;
//import amdocs.amsp.services.DispatchJobsFacade;
import amdocs.amsp.valueobject.accountviewwip.OrderGroupVO;
//import amdocs.amsp.valueobject.common.MessageVO;
//import amdocs.amsp.valueobject.dispatchjobs.DispatchVO;
//import amdocs.amsp.valueobject.servicepoint.ServicePointVO;
//import app.get.GetAllServicePointsTest;
import app.get.GetOpenOrderGroupListTest;
//import app.set.SetDispatchVO_Test;

public class OprCompleteChangeOfServiceJobTest {
	
	//private ServicePointVO[] servicePointVOList = null;
	//private GetAllServicePointsTest getAllServicePointsTest = new GetAllServicePointsTest();
	//private DispatchVO dispatchVO = new DispatchVO();
	//private DispatchJobsFacade dispatchJobsFacade = new DispatchJobsFacade();
	//private MessageVO messageVO = new MessageVO();
	private OrderGroupVO[] orderGroupVOlist = null;
	private GetOpenOrderGroupListTest getOpenOrderGroupListTest = new GetOpenOrderGroupListTest();
	//private SetDispatchVO_Test setDispatchVO_Test = new SetDispatchVO_Test();
	
	public void getData (Parameters apiParams, Login login, PrintOutput printOutput) {
		
		orderGroupVOlist = getOpenOrderGroupListTest.getOpenOrderGroupList(apiParams, login, printOutput);
		
		apiParams.setOrderGroupSeq(apiParams, printOutput, orderGroupVOlist[0].getOrderGroupSeq());
		
		//servicePointVOList = getAllServicePointsTest.getAllServicePoints(apiParams, login, printOutput);
	}
	
	public void setData (Parameters apiParams, Login login, PrintOutput printOutput) {
		
		//dispatchVO = setDispatchVO_Test.setDispatchVOforCompleteChangeOfServiceJob(apiParams, printOutput);
	}
	
	public void saveData (Parameters apiParams, Login login, PrintOutput printOutput) {
		
		/*try {
			messageVO = dispatchJobsFacade.completeJob(dispatchVO, servicePointVOList, apiParams.getOverriddenRuleIds(), apiParams.getCorp(), login.getTicket());
		} catch (AmspServiceException e) {
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
		if (messageVO != null) {
			printOutput.printToShell(apiParams, 
					 getClass().getName() + ":<messageVO>" + messageVO.toString() + "</messageVO>",
					 messageVO.toXml());
		}
		else {
			printOutput.printToShell(apiParams, getClass().getName() + ":<messageVO> is null", null);
		}*/
	}
}
