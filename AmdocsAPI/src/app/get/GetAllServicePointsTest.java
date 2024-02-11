package app.get;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.valueobject.servicepoint.ServicePointVO;
import amdocs.amsp.services.ServicePointFacade;

public class GetAllServicePointsTest {
	
	private ServicePointVO[] servicePointVO = null;
	private ServicePointFacade servicePointFacade = new ServicePointFacade();
	
	public ServicePointVO[] getAllServicePoints (Parameters apiParams, Login login, PrintOutput printOutput) {
		
		try {
			servicePointVO = servicePointFacade.getAllServicePoints(apiParams.getCust_acct(),
																	apiParams.getsiteId(),
																	apiParams.getOrderGroupSeq(),
												                    apiParams.getCorp(),
																	login.getTicket());

			
			if (servicePointVO != null) {
				for (int i = 0; i != servicePointVO.length; i++) {
					printOutput.printToShell(apiParams, 
							getClass().getName() + ":<servicePointVO id=" + i + ">" + servicePointVO[i].toString() + "</servicePointVO>",
							servicePointVO[i].toXml());
	 			}
			}
			else {
				printOutput.printToShell(apiParams, getClass().getName() + ":<servicePointVO> is null", null);
			}
		}
		catch (AmspServiceException e) 	{
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
		
		return (servicePointVO);
	}

}
