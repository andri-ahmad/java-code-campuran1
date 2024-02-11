package app.get;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.CorpparamFacade;
import amdocs.amsp.valueobject.corpparam.Code36VO;
import amdocs.amsp.valueobject.corpparam.Code95VO;

public class GetCodeTableCodeTest {
	
	CorpparamFacade corpparamFacade = new CorpparamFacade();
	Code36VO[] code36VO = null;
	
	public String getActiveReminderScheme (Parameters apiParams, Login login, PrintOutput printOutput) {
		
		String code = null;
		
		try {
			
			code36VO = corpparamFacade.getReminderSchemes(apiParams.getCorp(), login.getTicket());
			
			if (code36VO != null) {
				for (int i = 0; i != code36VO.length;) {
					
					// grab first active code
					if ("1".equals(code36VO[i].getActiveFlg())) {
						code = code36VO[i].getCode();
						
						printOutput.printToShell(apiParams, 
								getClass().getName() + ":<code36VO id=" + i + ">" + code36VO[i].toString() + "</code36VO>",
								code36VO[i].toXml());
						
						i = code36VO.length; // end the search
					} else {
						i++;
					}
	 			}
				if (code == null) {
					printOutput.printToShell(apiParams, getClass().getName() + ":No active code found", null);
				}
			}
			else {
				printOutput.printToShell(apiParams, getClass().getName() + ":<code36VO> is null", null);
			}
		}
		catch (AmspServiceException e) 	{
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
		
		return (code);
	}
	
	public String getDisconnectReason (Parameters apiParams, Login login, PrintOutput printOutput) {
		
		String code = null;
		
		try {
			
			code36VO = corpparamFacade.getDisconnectReason(apiParams.getCorp(), login.getTicket());
			
			if (code36VO != null) {
				for (int i = 0; i != code36VO.length;) {
					
					// grab first active code
					if ("1".equals(code36VO[i].getActiveFlg())) {
						code = code36VO[i].getCode();
						
						printOutput.printToShell(apiParams, 
								getClass().getName() + ":<code36VO id=" + i + ">" + code36VO[i].toString() + "</code36VO>",
								code36VO[i].toXml());
						
						i = code36VO.length; // end the search
					} else {
						i++;
					}
	 			}
				if (code == null) {
					printOutput.printToShell(apiParams, getClass().getName() + ":No active code found", null);
				}
			}
			else {
				printOutput.printToShell(apiParams, getClass().getName() + ":<code36VO> is null", null);
			}
		}
		catch (AmspServiceException e) 	{
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
		
		return (code);
	}
	
	public String getActiveStatementScheme (Parameters apiParams, Login login, PrintOutput printOutput) {
		
		String code = null;
		
		try {
			
			code36VO = corpparamFacade.getStatementSchemes(apiParams.getCorp(), login.getTicket());
			
			if (code36VO != null) {
				for (int i = 0; i != code36VO.length;) {
					
					// grab first active code
					if ("1".equals(code36VO[i].getActiveFlg())) {
						code = code36VO[i].getCode();
						
						printOutput.printToShell(apiParams, 
								getClass().getName() + ":<code36VO id=" + i + ">" + code36VO[i].toString() + "</code36VO>",
								code36VO[i].toXml());
						
						i = code36VO.length; // end the search
					} else {
						i++;
					}
	 			}
				if (code == null) {
					printOutput.printToShell(apiParams, getClass().getName() + ":No active code found", null);
				}
			}
			else {
				printOutput.printToShell(apiParams, getClass().getName() + ":<code36VO> is null", null);
			}
		}
		catch (AmspServiceException e) 	{
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
		
		return (code);
	}
	
	public Code95VO[] getNotDoneAlert (Parameters apiParams, Login login, PrintOutput printOutput) {
		Code95VO[] code95VOList = null;
	
		try {
			
			code95VOList = corpparamFacade.getNotDoneAlert(apiParams.getCorp(), login.getTicket());
			
			if (code95VOList != null) {
				for (int i = 0; i != code95VOList.length; i++) {
					printOutput.printToShell(apiParams, 
											 ":<code95VOList id=" + i + ">" + code95VOList[i].toString() + "</code95VOList>",
											 code95VOList[i].toXml());
	 			}
			}
			else {
				printOutput.printToShell(apiParams, getClass().getName() + ":<code95VOList> is null", null);
			}
		}
		catch (AmspServiceException e) 	{
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
		return (code95VOList);
	}
	
	public String getOutletLocation (Parameters apiParams, Login login, PrintOutput printOutput) {
		
		String code = null;
		
		try {
			
			code36VO = corpparamFacade.getOutletLocation(apiParams.getCorp(), login.getTicket());
			
			if (code36VO != null) {
				for (int i = 0; i != code36VO.length;) {
					
					// grab first active code
					if ("1".equals(code36VO[i].getActiveFlg())) {
						code = code36VO[i].getCode();
						
						printOutput.printToShell(apiParams, 
								getClass().getName() + ":<code36VO id=" + i + ">" + code36VO[i].toString() + "</code36VO>",
								code36VO[i].toXml());
						
						i = code36VO.length; // end the search
					} else {
						i++;
					}
	 			}
				if (code == null) {
					printOutput.printToShell(apiParams, getClass().getName() + ":No active code found", null);
				}
			}
			else {
				printOutput.printToShell(apiParams, getClass().getName() + ":<code36VO> is null", null);
			}
		}
		catch (AmspServiceException e) 	{
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
		
		return (code);
	}
	
	public Code36VO[] getReturnReasons (Parameters apiParams, Login login, PrintOutput printOutput) {
		Code36VO[] code36VOList = null;
		try {
			
			code36VOList = corpparamFacade.getReturnReason(apiParams.getCorp(), login.getTicket());
			
			if (code36VOList != null) {
				for (int i = 0; i != code36VOList.length; i++) {
					printOutput.printToShell(apiParams, 
											 ":<code36VOList id=" + i + ">" + code36VOList[i].toString() + "</code36VOList>",
											 code36VOList[i].toXml());
	 			}
			}
			else {
				printOutput.printToShell(apiParams, getClass().getName() + ":<code36VO> is null", null);
			}
		}
		catch (AmspServiceException e) 	{
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
		
		return (code36VOList);
	}
}
