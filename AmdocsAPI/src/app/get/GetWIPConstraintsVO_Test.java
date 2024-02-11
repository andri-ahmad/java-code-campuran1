package app.get;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.AccountConstraintsFacade;
import amdocs.amsp.valueobject.accountconstraints.WIPConstraintsVO;

public class GetWIPConstraintsVO_Test {
	
	private AccountConstraintsFacade accountConstraintsFacade = new AccountConstraintsFacade();
	private WIPConstraintsVO wIPConstraintsVO = new WIPConstraintsVO();
	
	public WIPConstraintsVO getWIPConstraints(Parameters apiParams, Login login, PrintOutput printOutput) {
		try {
			 
			wIPConstraintsVO = accountConstraintsFacade.getWIPConstraints(
					apiParams.getOrderType(),
                    apiParams.getCust_acct(), 
                    apiParams.getsiteId(),
                    apiParams.getCorp(),
                    login.getTicket());
			
			if (wIPConstraintsVO != null) {
				printOutput.printToShell(apiParams, 
	            		getClass().getName() + ":<WIPConstraintsVO>" + wIPConstraintsVO.toString() + "</WIPConstraintsVO>",
	            		wIPConstraintsVO.toXml());
			}
			else {
				printOutput.printToShell(apiParams, getClass().getName() + ":<wIPConstraintsVO> is null", null);
			}
			
		} catch (AmspServiceException e) {
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
		return (wIPConstraintsVO);
	}
}
