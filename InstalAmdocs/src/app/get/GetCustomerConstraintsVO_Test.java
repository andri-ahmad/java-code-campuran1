package app.get;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import util.SupportException;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.AccountConstraintsFacade;
import amdocs.amsp.valueobject.accountconstraints.CustomerConstraintsVO;

public class GetCustomerConstraintsVO_Test {
	private AccountConstraintsFacade accountConstraintsFacade = new AccountConstraintsFacade();
	private CustomerConstraintsVO customerConstraintsVO = new CustomerConstraintsVO();
	
	public CustomerConstraintsVO getCustomerConstraints(Parameters apiParams, Login login, PrintOutput printOutput) throws SupportException { 
		try {
			customerConstraintsVO = accountConstraintsFacade.getCustomerConstraints(apiParams.getOrderType(),
																					apiParams.getScheduleType(),
																					apiParams.getCust_acct(),
																					apiParams.getsiteId(),
																					(short) apiParams.getAccountCategory(),
																					apiParams.getCorp(), 
																					login.getTicket());
			
			if (customerConstraintsVO != null) {
				printOutput.printToShell(apiParams, 
						getClass().getName() + ":<customerConstraintsVO>" + customerConstraintsVO.toString() + "</customerConstraintsVO>",
						customerConstraintsVO.toXml());
			}
			else {
				throw new SupportException("customerConstraintsVO is null");
			}
		}
		catch (AmspServiceException e) 	{
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
		return (customerConstraintsVO);
	}
}
