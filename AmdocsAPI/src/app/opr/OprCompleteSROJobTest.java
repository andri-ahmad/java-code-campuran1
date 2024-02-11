package app.opr;

import util.Login;
import util.Parameters;
import util.PrintOutput;
//import amdocs.amsp.exception.AmspServiceException;
//import amdocs.amsp.services.DispatchJobsFacade;
//import amdocs.amsp.services.OpQueryFacade;
import amdocs.amsp.valueobject.accountviewwip.OrderGroupVO;
import amdocs.amsp.valueobject.common.MessageVO;
//import amdocs.amsp.valueobject.dispatchjobs.DispatchVO;
import amdocs.amsp.valueobject.servicepoint.FixVO;
//import amdocs.amsp.valueobject.servicepoint.ServicePointVO;
//import app.get.GetAllServicePointsTest;
//import app.get.GetCodeTableCodeTest;
import app.get.GetOpenOrderGroupListTest;
//import app.set.SetDispatchVO_Test;
import app.set.SetFixVO_Test;
//import app.update.UpdateServicePointVO_Test;

public class OprCompleteSROJobTest {
	
	//private DispatchJobsFacade dispatchJobsFacade = new DispatchJobsFacade();
	//private DispatchVO dispatchVO = new DispatchVO();
	private FixVO[]  fixVOList = new FixVO[1];
	//private GetAllServicePointsTest getAllServicePointsTest = new GetAllServicePointsTest();
	//private GetCodeTableCodeTest getCodeTableCodeTest = new GetCodeTableCodeTest();
	private GetOpenOrderGroupListTest getOpenOrderGroupListTest = new GetOpenOrderGroupListTest();
	private MessageVO messageVO = new MessageVO();
	//private OpQueryFacade opQueryFacade = new OpQueryFacade();
	private OrderGroupVO[] orderGroupVOlist = null;
	//private ServicePointVO[] servicePointVOList = null;
	//private SetDispatchVO_Test setDispatchVO_Test = new SetDispatchVO_Test();
	private SetFixVO_Test setFixVO_Test = new SetFixVO_Test();
	//private UpdateServicePointVO_Test updateServicePointVO_Test = new UpdateServicePointVO_Test();

	public void getData (Parameters apiParams, Login login, PrintOutput printOutput) {
		
		// get/set SRO Fix code

		//fixVOList[0] = getCodeTableCodeTest.getSROFix(apiParams, login, printOutput);
		//apiParams.setSroFixCode(apiParams, printOutput, fixVOList[0].getFixCode());
		//apiParams.setSroFixDesc(apiParams, printOutput, fixVOList[0].getFixDesc());
		
		// ServicePoint : GetAllServicePoints
		//servicePointVOList = getAllServicePointsTest.getAllServicePoints(apiParams, login, printOutput);
		
		orderGroupVOlist = getOpenOrderGroupListTest.getOpenOrderGroupList(apiParams, login, printOutput);
		
		apiParams.setOrderGroupSeq(apiParams, printOutput, orderGroupVOlist[0].getOrderGroupSeq());
	}
	
	public void setData (Parameters apiParams, Login login, PrintOutput printOutput) {
		
		fixVOList[0] = setFixVO_Test.setFixVOforCompleteSROJob(apiParams, printOutput);
		
		//updateServicePointVO_Test.updateServicePointVOforCompleteSROJob(apiParams, 
		//																printOutput, 
		//																servicePointVOList[0], 
		//																fixVOList);
		
		//dispatchVO = setDispatchVO_Test.setDispatchVOforSROJob(apiParams, printOutput);
	}

	public void saveData (Parameters apiParams, Login login, PrintOutput printOutput) {
		
		/*try {
			
			opQueryFacade.getTaskCodeValidation(servicePointVOList, 
												apiParams.getOptionId(), 
												apiParams.getJobType(), 
												apiParams.getCorp(), 
												login.getTicket());
			
			messageVO = dispatchJobsFacade.completeJob(dispatchVO, 
													   servicePointVOList, 
													   apiParams.getOverriddenRuleIds(), 
													   apiParams.getCorp(), 
													   login.getTicket());
			
		} catch (AmspServiceException e) {
			
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}*/
		if (messageVO != null) {
			
			printOutput.printToShell(apiParams, 
					 				 getClass().getName() + ":<messageVO>" + messageVO.toString() + "</messageVO>",
					 				 messageVO.toXml());
		}
		else {
			
			printOutput.printToShell(apiParams, getClass().getName() + ":<messageVO> is null", null);
		}
	}
}
