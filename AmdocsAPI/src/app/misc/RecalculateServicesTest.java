package app.misc;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import util.SupportException;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.valueobject.customer.CustomerDetailsVO;
import amdocs.amsp.valueobject.opquery.PollRecalculateServicesVO;
import amdocs.amsp.valueobject.order.OrderVO;
import amdocs.amsp.valueobject.site.SiteDetailsVO;
import amdocs.amsp.services.OpQueryFacade;

public class RecalculateServicesTest {
	
	private PollRecalculateServicesVO pollRecalculateServicesVO = new PollRecalculateServicesVO();
	private OpQueryFacade opQueryFacade = new OpQueryFacade();
	
	public PollRecalculateServicesVO recalculateServices (Parameters apiParams, 
														  PrintOutput printOutput, 
														  Login login, 
														  OrderVO orderVO,
														  CustomerDetailsVO customerDetailsVO,
														  SiteDetailsVO siteDetailsVO) throws SupportException {
		
try {
		pollRecalculateServicesVO = opQueryFacade.recalculateServices(orderVO, 
																	  customerDetailsVO, 
																	  siteDetailsVO, 
																	  apiParams.getCorp(), 
																	  login.getTicket());	
			
			if (pollRecalculateServicesVO != null) {
				printOutput.printToShell(apiParams, 
										 getClass().getName() + ":<PollRecalculateServicesVO>" + pollRecalculateServicesVO.toString() + "</PollRecalculateServicesVO>", 
										 pollRecalculateServicesVO.toXml());
			}
			else {
				throw new SupportException( getClass().getName() + " <pollRecalculateServicesVO> is null");
			}
			
		} catch (AmspServiceException e) {
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
			return (null);
		}
		
		return(pollRecalculateServicesVO);
	}

}
