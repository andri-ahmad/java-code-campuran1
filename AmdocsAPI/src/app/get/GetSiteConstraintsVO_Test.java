package app.get;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.AccountConstraintsFacade;
import amdocs.amsp.valueobject.accountconstraints.SiteConstraintsVO;

public class GetSiteConstraintsVO_Test {
	private AccountConstraintsFacade accountConstraintsFacade = new AccountConstraintsFacade();
	private SiteConstraintsVO siteConstraintsVO = new SiteConstraintsVO();
	
	public SiteConstraintsVO getSiteConstraints(Parameters apiParams, Login login, PrintOutput printOutput) 
	{ 
		try {
			siteConstraintsVO = accountConstraintsFacade.getSiteConstraints(apiParams.getOrderType(), 
																			apiParams.getScheduleAction(), 
																			apiParams.getsiteId(), 
																			apiParams.getCorp(), 
																			login.getTicket());
			
			if (siteConstraintsVO != null) {
				printOutput.printToShell(apiParams, 
						getClass().getName() + ":<siteConstraintsVO>" + siteConstraintsVO.toString() + "</siteConstraintsVO>",
						siteConstraintsVO.toXml());
			}
			else {
				printOutput.printToShell(apiParams, getClass().getName() + ":<siteConstraintsVO> is null", null);
			}
		}
		catch (AmspServiceException e) 	{
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
		return (siteConstraintsVO);
	}
}
