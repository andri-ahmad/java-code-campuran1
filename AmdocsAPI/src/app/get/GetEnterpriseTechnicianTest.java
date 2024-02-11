package app.get;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.PersonnelMaintenanceFacade;
import amdocs.amsp.valueobject.personnelmaintenance.TechnicianDetailsVO;

public class GetEnterpriseTechnicianTest {
	private PersonnelMaintenanceFacade personnelMaintenanceFacade = new PersonnelMaintenanceFacade ();
	private TechnicianDetailsVO technicianDetailsVO = new TechnicianDetailsVO ();
	
	public TechnicianDetailsVO getEnterpriseTechnician(Parameters apiParams, Login login, PrintOutput printOutput) {
		{ 
			try {
				technicianDetailsVO = personnelMaintenanceFacade.getEnterpriseTechnician(apiParams.getTechId(), login.getTicket());
				
				if (technicianDetailsVO != null) {
					printOutput.printToShell(apiParams, 
							getClass().getName() + ":<technicianDetailsVO>" + technicianDetailsVO.toString() + "</technicianDetailsVO>", 
							technicianDetailsVO.toXml());
				}
				else {
					printOutput.printToShell(apiParams, getClass().getName() + ":<salesmanDetailsVO> is null", null);
				}	
				
			}
			catch (AmspServiceException e) 	{
				printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
			}
			
			return (technicianDetailsVO);
		}
	}

}
