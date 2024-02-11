package app.get;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import util.SupportException;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.SiteFacade;
import amdocs.amsp.valueobject.site.SiteDetailsVO;

public class GetSiteDetailVO_Test {
	private SiteFacade siteFacade = new SiteFacade();
	private SiteDetailsVO siteDetailsVO = null;
	
	public SiteDetailsVO getSiteDetail(Parameters apiParams, Login login, PrintOutput printOutput) throws SupportException {
		try {
			// SiteDetailsVO 
            siteDetailsVO = siteFacade.getSiteDetail(apiParams.getsiteId(),
													 apiParams.getCorp(), 
													 login.getTicket());
            
            if (siteDetailsVO != null) {
            	printOutput.printToShell(apiParams, 
                		getClass().getName() + ":<SiteDetailsVO>" +	siteDetailsVO.toString() + "</SiteDetailsVO>",
                		siteDetailsVO.toXml());
			}
			else {
				throw new SupportException("siteDetailsVO is null");
			}
            
		} catch (AmspServiceException e) {
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
		return (siteDetailsVO);
	}
}
