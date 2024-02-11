package app.opr;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.PersonnelMaintenanceFacade;
import amdocs.amsp.valueobject.personnelmaintenance.SalesmanDetailsVO; 
import app.set.SetSalesmanDetailsVO_Test;


public class OprCreateEnterpriseSalesmanTest {
	private PersonnelMaintenanceFacade personnelMaintenanceFacade = new PersonnelMaintenanceFacade ();
	private SalesmanDetailsVO salesmanDetailsVO = new SalesmanDetailsVO ();
	private SetSalesmanDetailsVO_Test setSalesmanDetailsVO_Test = new SetSalesmanDetailsVO_Test (); 
	private String returnValue = null; 
	
	public void getData (Parameters apiParams, Login login, PrintOutput printOutput) {
		
	}

	public void setData (Parameters apiParams, Login login, PrintOutput printOutput) {
		
		salesmanDetailsVO = setSalesmanDetailsVO_Test.setSalesmanDetailsVOforCreateNewSalsman(apiParams, printOutput);
	}

	public void saveData (Parameters apiParams, Login login, PrintOutput printOutput) {
		
		try {
			
			returnValue = personnelMaintenanceFacade.createEnterpriseSalesman(salesmanDetailsVO, login.getTicket());

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
 