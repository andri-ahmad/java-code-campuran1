package app.opr;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.DispatchJobsFacade;
import amdocs.amsp.valueobject.common.MessageVO;
import amdocs.amsp.valueobject.dispatchjobs.ReassignJobVO;

/**
* @author JVANHOOF
*  Operation module for reAssignTechJobs API - created for LinkNet
*/

public class OprReAssignTechJobTest {
	
	private String toTechJobSeq = null;
	private String newJobSeq = null;
	private DispatchJobsFacade dispatchJobsFacade = new DispatchJobsFacade();
	private MessageVO[] messageVO = null;
	private ReassignJobVO[] reAssignJobSeqList = new ReassignJobVO[4];
	
	public void getData (Parameters apiParams, Login login, PrintOutput printOutput) {
		// Customer gets data from a spreadsheet so nothing to do here
	}

	public void setData (Parameters apiParams, Login login, PrintOutput printOutput) {
		toTechJobSeq = null;
		newJobSeq    = "1A";
		for (int i = 0; i != reAssignJobSeqList.length; i++) {
			reAssignJobSeqList[i] = new ReassignJobVO();
			reAssignJobSeqList[i].setDseq(String.valueOf(i + 1));
		}
	}

	public void saveData (Parameters apiParams, Login login, PrintOutput printOutput) {
		
		try {
			
			messageVO = dispatchJobsFacade.reAssignTechJob(apiParams.getCdwDate(), 
														   apiParams.getFromTech(), 
														   apiParams.getToTech(), 
														   toTechJobSeq, 
														   newJobSeq, 
														   reAssignJobSeqList, 
														   apiParams.getCorp(), 
														   login.getTicket());

		} catch (AmspServiceException e) {
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
		
		if (messageVO != null) {
			for (int i = 0; i != messageVO.length; i++) {
				printOutput.printToShell(apiParams, 
										 getClass().getName() + ":<messageVO id=" + i + ">" + messageVO[i].toString() + "</messageVO>",
										 messageVO[i].toXml());
 			}
		}
		else {
			printOutput.printToShell(apiParams, getClass().getName() + ":<returnValue> is null", null);
		}
	}
}
