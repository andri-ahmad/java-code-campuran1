package app.get;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import util.SupportException;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.CorpparamFacade;
import amdocs.amsp.valueobject.corpparam.Code95VO;
import amdocs.amsp.valueobject.accountviewwip.WipTaskInfoVO;

/**
 * @author JVANHOOF
 *		This class has one method that loads up all the Task Codes for a corp and looks for a specific code
 *      If the code is found then it sets values in WipTaskInfoVO 
 */
public class GetWorkTaskCodesTest {
	
	Code95VO[] code95VO = null;
	
	WipTaskInfoVO wipTaskInfoVO = new WipTaskInfoVO();
	
	CorpparamFacade corpparamFacade = new CorpparamFacade();
	
	public WipTaskInfoVO loadTaskInfoVO (Parameters apiParams, Login login, PrintOutput printOutput, String taskCode) throws SupportException {
		
		try {
			code95VO = corpparamFacade.getWorkTaskCodes(apiParams.getCorp(), login.getTicket());
			
			if (code95VO != null) {
				for (int i = 0; i != code95VO.length; i++) {
					printOutput.printToShell(apiParams, 
											 getClass().getName() + ":<code95VO id=" + i + ">" + code95VO[i].toString() + "</code95VO>",
											 code95VO[i].toXml());
	 			}
			}
			else {
				throw new SupportException("code95VO is null");
			}
			
			for (int i = 0; i != code95VO.length; i++) {
				if (taskCode.trim().equals(code95VO[i].getCode().trim())) {
					wipTaskInfoVO.setTaskCode(code95VO[i].getCode());
					wipTaskInfoVO.setTaskDescription(code95VO[i].getShortDes());
					wipTaskInfoVO.setWorkPoints(Integer.valueOf(code95VO[i].getWorkPoints().trim()));
				}
 			}
			
			if (wipTaskInfoVO.getTaskCode() != null) {
				printOutput.printToShell(apiParams, getClass().getName() + " Task Code found ", null);
				printOutput.printToShell(apiParams, 
						 getClass().getName() + ":<wipTaskInfoVO>" + wipTaskInfoVO.toString() + "</wipTaskInfoVO>",
						 wipTaskInfoVO.toXml());
			}
			else {
				printOutput.printToShell(apiParams, getClass().getName() + "Task Code not found!", null);
			}
		
	} catch (AmspServiceException e) {
		printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
	}
		return (wipTaskInfoVO);
	}
}
