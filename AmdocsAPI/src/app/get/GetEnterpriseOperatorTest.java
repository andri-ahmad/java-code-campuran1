package app.get;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.PersonnelMaintenanceFacade;
import amdocs.amsp.valueobject.personnelmaintenance.OprEnterpriseDetailsVO;


public class GetEnterpriseOperatorTest {
	private PersonnelMaintenanceFacade personnelMaintenanceFacade = new PersonnelMaintenanceFacade ();
	private OprEnterpriseDetailsVO oprEnterpriseDetailsVO = new OprEnterpriseDetailsVO ();
	
	public OprEnterpriseDetailsVO getEnterpriseOperator(Parameters apiParams, Login login, PrintOutput printOutput) {
		{ 
			try {
				oprEnterpriseDetailsVO = personnelMaintenanceFacade.getEnterpriseOperator(apiParams.getOperatorId(), apiParams.getUserName(), login.getTicket());
				
				if (oprEnterpriseDetailsVO != null) {
					printOutput.printToShell(apiParams, 
							getClass().getName() + ":<oprEnterpriseDetailsVO>" + oprEnterpriseDetailsVO.toString() + "</oprEnterpriseDetailsVO>", 
							oprEnterpriseDetailsVO.toXml());
				}
				else {
					printOutput.printToShell(apiParams, getClass().getName() + ":<oprEnterpriseDetailsVO> is null", null);
				}	
				
			}
			catch (AmspServiceException e) 	{
				printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
			}
			return (oprEnterpriseDetailsVO);
		}
	}
}
