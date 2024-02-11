package app.get;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.PersonnelMaintenanceFacade;
import amdocs.amsp.valueobject.personnelmaintenance.OperatorDetailsVO;

public class GetCorpOperatorDetailsVO_Test {
	
	private OperatorDetailsVO operatorDetailsVO = new OperatorDetailsVO();
	private PersonnelMaintenanceFacade personnelMaintenanceFacade = new PersonnelMaintenanceFacade();
	
	public OperatorDetailsVO getCorpOperatorDetails (Parameters apiParams, Login login, PrintOutput printOutput) {
		
		try {
			operatorDetailsVO = personnelMaintenanceFacade.getCorpOperatorDetails(apiParams.getOperatorId(), 
																				  apiParams.getUserid(), 
																				  apiParams.getCorp(), 
																				  login.getTicket());
            
			if (operatorDetailsVO != null) {
				printOutput.printToShell(apiParams, 
	            		getClass().getName() + ":<operatorDetailsVO>" +	operatorDetailsVO.toString() + "</operatorDetailsVO>",
	            		operatorDetailsVO.toXml());
			}
			else {
				printOutput.printToShell(apiParams, getClass().getName() + ":<operatorDetailsVO> is null", null);
			}
		
	} catch (AmspServiceException e) {
		printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
	}
		
		return (operatorDetailsVO);
	}
}
