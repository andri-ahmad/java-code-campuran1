package app.get;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.exception.AmspServiceException;

import amdocs.amsp.services.CorpparamFacade;
import amdocs.amsp.valueobject.corpparam.ParamAccountingPerCloseVO;

public class GetParamAcctngPerCloseVO_Test {
	
	CorpparamFacade corpparamFacade = new CorpparamFacade();
	ParamAccountingPerCloseVO[] paramAccountingPerCloseVO = null;
	
	public ParamAccountingPerCloseVO[] getParamAcctngPerCloseVO (Parameters apiParams, Login login, PrintOutput printOutput) {
		
		try {
			paramAccountingPerCloseVO = corpparamFacade.getParamAcctngPerCloseList(apiParams.getCorp(), login.getTicket());
			
			if (paramAccountingPerCloseVO != null) {
				for (int i = 0; i != paramAccountingPerCloseVO.length; i++) {
					printOutput.printToShell(apiParams, 
							getClass().getName() + ":<paramAccountingPerCloseVO id=" + i + ">" + paramAccountingPerCloseVO[i].toString() + "</paramAccountingPerCloseVO>",
							paramAccountingPerCloseVO[i].toXml());
	 			}
			}
			else {
				printOutput.printToShell(apiParams, getClass().getName() + ":<paramAccountingPerCloseVO> is null", null);
			}
		}
		catch (AmspServiceException e) 	{
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
		
		return (paramAccountingPerCloseVO);
	}
}
