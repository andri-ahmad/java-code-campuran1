package app.get;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.PersonnelMaintenanceFacade;
import amdocs.amsp.valueobject.personnelmaintenance.CorpsetListVO;

public class GetCorpsetListVO_Test {
	
	private PersonnelMaintenanceFacade personnelMaintenanceFacade = new PersonnelMaintenanceFacade ();
	private CorpsetListVO[] corpsetListVO = null;
	
	public CorpsetListVO[] getCorpsetListVO(Parameters apiParams, Login login, PrintOutput printOutput) {
		try {
			corpsetListVO = personnelMaintenanceFacade.getCorpsetList(login.getTicket());
			
			if (corpsetListVO != null) {
				for (int i = 0; i != corpsetListVO.length; i++) {
					printOutput.printToShell(apiParams, 
							getClass().getName() + ":<corpsetListVO id=" + i + ">" + corpsetListVO[i].toString() + "</corpsetListVO>",
							corpsetListVO[i].toXml());
	 			}
			}
			else {
				printOutput.printToShell(apiParams, getClass().getName() + ":<corpsetListVO> is null", null);
			}
		}
		catch (AmspServiceException e) 	{
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
		
		return (corpsetListVO);
	}
}
