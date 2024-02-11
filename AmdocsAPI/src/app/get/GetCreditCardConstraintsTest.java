package app.get;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.AccountConstraintsFacade;
import amdocs.amsp.valueobject.accountconstraints.CreditCardConstraintsVO;

public class GetCreditCardConstraintsTest {
	
	private AccountConstraintsFacade accountConstraintsFacade = new AccountConstraintsFacade();
	private CreditCardConstraintsVO creditCardConstraintsVO = new CreditCardConstraintsVO();
	
	public CreditCardConstraintsVO getCreditCardConstraints(Parameters apiParams, Login login, PrintOutput printOutput) 
	{ 
		try {
			creditCardConstraintsVO = accountConstraintsFacade.getCreditCardConstraints(apiParams.getOrderType(), apiParams.getCorp(), login.getTicket());
			
			if (creditCardConstraintsVO != null) {
				printOutput.printToShell(apiParams, 
						getClass().getName() + ":<creditCardConstraintsVO>" + creditCardConstraintsVO.toString() + "</creditCardConstraintsVO>",
						creditCardConstraintsVO.toXml());
			}
			else {
				printOutput.printToShell(apiParams, getClass().getName() + ":<creditCardConstraintsVO> is null", null);
			}
		}
		catch (AmspServiceException e) 	{
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
		return (creditCardConstraintsVO);
	}

}
