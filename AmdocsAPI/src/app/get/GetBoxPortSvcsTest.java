package app.get;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.ServicePointFacade;
import amdocs.amsp.valueobject.servicepoint.BoxPortListVO;

public class GetBoxPortSvcsTest {
	
	private BoxPortListVO[] boxPortListVOlist = null;
	private ServicePointFacade servicePointFacade = new ServicePointFacade();
	
	public BoxPortListVO[] getBoxPortSvcs (Parameters apiParams, Login login, PrintOutput printOutput) {
		try {
			boxPortListVOlist = servicePointFacade.getBoxPortSvcs(apiParams.getEquipmentId(), apiParams.getCorp(), login.getTicket());
            
			if (boxPortListVOlist != null) {
				for (int i = 0; i != boxPortListVOlist.length; i++) {
					printOutput.printToShell(apiParams, 
							getClass().getName() + ":<boxPortListVOlist id=" + i + ">" + boxPortListVOlist[i].toString() + "</boxPortListVOlist>",
							boxPortListVOlist[i].toXml());
	 			}
			} else {
				printOutput.printToShell(apiParams, getClass().getName() + ":<boxPortListVOlist> is null", null);
			}
			
		} catch (AmspServiceException e) {
				printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
		
		return (boxPortListVOlist);
	}
}
