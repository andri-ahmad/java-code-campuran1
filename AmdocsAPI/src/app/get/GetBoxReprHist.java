package app.get;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.ServicePointFacade;
import amdocs.amsp.valueobject.servicepoint.BoxRepairHistListVO;

public class GetBoxReprHist {
	
	private BoxRepairHistListVO[] boxRepairHistListVO = null;
	private ServicePointFacade servicePointFacade = new ServicePointFacade();
	
	public BoxRepairHistListVO[] getBoxReprHist (Parameters apiParams, Login login, PrintOutput printOutput) {
		try {
			
			boxRepairHistListVO = servicePointFacade.getBoxReprHist(apiParams.getEquipmentId(), apiParams.getCorp(), login.getTicket());
            
			if (boxRepairHistListVO != null) {
				for (int i = 0; i != boxRepairHistListVO.length; i++) {
					printOutput.printToShell(apiParams, 
							getClass().getName() + ":<boxRepairHistListVO id=" + i + ">" + boxRepairHistListVO[i].toString() + "</boxRepairHistListVO>",
							boxRepairHistListVO[i].toXml());
	 			}
			} else {
				printOutput.printToShell(apiParams, getClass().getName() + ":<boxRepairHistListVO> is null", null);
			}
			
		} catch (AmspServiceException e) {
				printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
		
		return (boxRepairHistListVO);
	}
}
