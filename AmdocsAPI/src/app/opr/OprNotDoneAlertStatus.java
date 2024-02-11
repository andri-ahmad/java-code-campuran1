package app.opr;

//import amdocs.amsp.exception.AmspServiceException;
//import amdocs.amsp.services.DispatchJobsFacade;
import amdocs.amsp.valueobject.common.MessageVO;
import amdocs.amsp.valueobject.dispatchjobs.NotDoneStatusVO;
import util.Login;
import util.Parameters;
import util.PrintOutput;

public class OprNotDoneAlertStatus {
	
	//private DispatchJobsFacade dispatchJobsFacade = new DispatchJobsFacade();
	private MessageVO messageVO = new MessageVO();
	private NotDoneStatusVO[] jobSeqList = new NotDoneStatusVO[1];
	
	public void getData (Parameters apiParams, Login login, PrintOutput printOutput) {
		// nothing to get in this operation
	}
	
	public void setData (Parameters apiParams, Login login, PrintOutput printOutput) {
		
		jobSeqList[0] = new NotDoneStatusVO();
		//jobSeqList[0].setDseq(apiParams.getDSeq());
		}
	
	public void saveData (Parameters apiParams, Login login, PrintOutput printOutput) {
		/*try {
			messageVO = dispatchJobsFacade.notDoneAlertStatus(apiParams.getCdwDate()
															, apiParams.getTechId()
															, apiParams.getStatusCode() 
															, apiParams.getChangeTime()
															, apiParams.getReasonCode()
															, apiParams.getComment()
															, jobSeqList
															, apiParams.getCheckinAlert()
															, apiParams.getCorp()
															, login.getTicket());
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
