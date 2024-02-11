package app.get;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.ServicePointFacade;
import amdocs.amsp.valueobject.servicepoint.EquipmentVO;

public class GetEquipmentDetailsVO_Test {
	
	private ServicePointFacade servicePointFacade = new ServicePointFacade();
	private EquipmentVO equipmentVO = new EquipmentVO();
	
	public EquipmentVO getEquipmentDetails (Parameters apiParams, Login login, PrintOutput printOutput) {
		try {
				equipmentVO = servicePointFacade.getEquipmentDetails(apiParams.getEquipmentId(), 
						                                             apiParams.getCorp(), 
						                                             login.getTicket());
	            
				if (equipmentVO != null) {
					printOutput.printToShell(apiParams, 
		            		getClass().getName() + ":<equipmentVO>" +	equipmentVO.toString() + "</equipmentVO>",
		            		equipmentVO.toXml());
				}
				else {
					printOutput.printToShell(apiParams, getClass().getName() + ":<equipmentVO> is null", null);
				}
			
		} catch (AmspServiceException e) {
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
		
		return (equipmentVO);
	}
}
