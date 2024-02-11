package app.opr;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.PersonnelMaintenanceFacade;
import amdocs.amsp.valueobject.personnelmaintenance.SalesmanDetailsVO; 
import amdocs.amsp.valueobject.personnelmaintenance.CorpsetListVO;
import app.get.GetCorpsetListVO_Test;
import app.get.GetEnterpriseSalesmanTest;

public class OprUpdateEnterpriseSalesmanTest {
	
	private PersonnelMaintenanceFacade personnelMaintenanceFacade = new PersonnelMaintenanceFacade ();
	private SalesmanDetailsVO salesmanDetailsVO = new SalesmanDetailsVO ();
	private GetEnterpriseSalesmanTest getEnterpriseSalesmanTest = new GetEnterpriseSalesmanTest ();
	private GetCorpsetListVO_Test getCorpsetListVO_Test = new GetCorpsetListVO_Test();
	private CorpsetListVO[] corpsetListVO = null;
	private String returnValue = null;
	
	public void getData (Parameters apiParams, Login login, PrintOutput printOutput) {
		
		salesmanDetailsVO = getEnterpriseSalesmanTest.getEnterpriseSalesman(apiParams, login, printOutput);
		
		// check for inactive status and conversion corpset value "default_corpset" - needs special handling
		if (salesmanDetailsVO.getStatus() == 0 || salesmanDetailsVO.getCorpset()[0].equals("default_corpset")) {
			
			corpsetListVO = getCorpsetListVO_Test.getCorpsetListVO(apiParams, login, printOutput);
			
			// look for the target corpset - if target not found will use "default_corpset" and fail
			for (int i = 0; i != corpsetListVO.length; i++) {
				if(corpsetListVO[i].getCorpset().equals(apiParams.getCorpSetTarget())) {
					apiParams.setCorpSetList(apiParams, printOutput, 0, corpsetListVO[i].getCorpset());
				}
			}
		}
		else {
			apiParams.setCorpSetList(apiParams, printOutput, 0, salesmanDetailsVO.getCorpset()[0]);
		}
	}

	public void setData (Parameters apiParams, Login login, PrintOutput printOutput) {
		
		salesmanDetailsVO.setStatus(apiParams.getStatus());
		salesmanDetailsVO.setComment(apiParams.getComment());
		salesmanDetailsVO.setCorpset(apiParams.getCorpSet());
		
		printOutput.printToShell(apiParams, 
								 getClass().getName() + ":<salesmanDetailsVO>" + salesmanDetailsVO.toString() + "</salesmanDetailsVO>", 
								 salesmanDetailsVO.toXml());
	}

	public void saveData (Parameters apiParams, Login login, PrintOutput printOutput) {
		
		try {
			
			returnValue = personnelMaintenanceFacade.updateEnterpriseSalesman(salesmanDetailsVO, login.getTicket());

		} catch (AmspServiceException e) {
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
		
		if (returnValue != null) {
			printOutput.printToShell(apiParams, 
									 getClass().getName() + ":<returnValue>" + returnValue + "</returnValue>",
									 null);
		}
		else {
			printOutput.printToShell(apiParams, getClass().getName() + ":<returnValue> is null", null);
		}
	}
}
