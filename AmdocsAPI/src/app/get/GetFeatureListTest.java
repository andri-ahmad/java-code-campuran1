package app.get;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.TelcoFacade;
import amdocs.amsp.valueobject.servicepoint.ServicePointVO;

public class GetFeatureListTest {
	
	private TelcoFacade telcoFacade = new TelcoFacade();
	private ServicePointVO servicePointVO = new ServicePointVO();

	public ServicePointVO getFeatureList(Parameters apiParams, Login login, PrintOutput printOutput, ServicePointVO servicePointVOin) 
	{ 
		try {
			servicePointVO = telcoFacade.getFeatureList(servicePointVOin, 
														apiParams.getCust_acct(), 
														apiParams.getsiteId(), 
														apiParams.getServiceGroup(), 
														apiParams.getCorp(), 
														login.getTicket());
			
			if (servicePointVO != null) {
				printOutput.printToShell(apiParams, 
						getClass().getName() + ":<servicePointVO>" + servicePointVO.toString() + "</servicePointVO>",
						servicePointVO.toXml());
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
