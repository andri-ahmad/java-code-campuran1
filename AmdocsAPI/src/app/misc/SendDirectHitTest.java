package app.misc;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.EquipmentFacade;
import amdocs.amsp.valueobject.equipment.ResponseItemVO;

public class SendDirectHitTest {
	
	private EquipmentFacade equipmentFacade = new EquipmentFacade();
	private ResponseItemVO[] responseItemVO = null;
	
	public ResponseItemVO[] sendDirectHit (Parameters apiParams, Login login, PrintOutput printOutput) {
		
		try { 
			responseItemVO = equipmentFacade.sendDirectHit(apiParams.getEquipmentId(), 
														   apiParams.getOrderType(),
														   apiParams.getCorp(), 
														   login.getTicket());
			
			if(responseItemVO != null) {
				for (int i = 0; i != responseItemVO.length; i++) 
				{		
					printOutput.printToShell(apiParams, 
							getClass().getName() + ":<responseItemVO>" + responseItemVO[i].toString() + "</responseItemVO>",
							responseItemVO[i].toXml());
				}
			}
			else {
				printOutput.printToShell(apiParams, getClass().getName() + ":<responseItemVO> is null", null);
			}
			
		} catch (AmspServiceException e) {
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}

		return (responseItemVO);
	}
}
