package app.get;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.PersonnelMaintenanceFacade;
import amdocs.amsp.valueobject.personnelmaintenance.SalesmanDetailsVO;

public class GetEnterpriseSalesmanTest {
	
	private PersonnelMaintenanceFacade personnelMaintenanceFacade = new PersonnelMaintenanceFacade ();
	private SalesmanDetailsVO salesmanDetailsVO = new SalesmanDetailsVO ();
	
	public SalesmanDetailsVO getEnterpriseSalesman(Parameters apiParams, Login login, PrintOutput printOutput) {
		{ 
			try {
					salesmanDetailsVO = personnelMaintenanceFacade.getEnterpriseSalesman(apiParams.getSalesRepId(), login.getTicket());
				
				if (salesmanDetailsVO != null) {
					printOutput.printToShell(apiParams, 
							getClass().getName() + ":<salesmanDetailsVO>" + salesmanDetailsVO.toString() + "</salesmanDetailsVO>", 
							salesmanDetailsVO.toXml());
				}
				else {
					printOutput.printToShell(apiParams, getClass().getName() + ":<salesmanDetailsVO> is null", null);
				}	
				
			}
			catch (AmspServiceException e) 	{
				printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
			}
			
			return (salesmanDetailsVO);
		}
	} 
}
