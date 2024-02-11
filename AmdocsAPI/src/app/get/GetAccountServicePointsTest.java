package app.get;

import util.Login;
import util.Parameters;
import util.PrintOutput;

import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.ServicePointFacade;
import amdocs.amsp.valueobject.servicepoint.AccountServicesVO;


public class GetAccountServicePointsTest {
	private AccountServicesVO accountServicesVO   = new AccountServicesVO();
	private ServicePointFacade servicePointFacade = new ServicePointFacade();
	
	public AccountServicesVO getAccountServicePoints (Parameters apiParams, Login login, PrintOutput printOutput) {
		try {
			accountServicesVO = servicePointFacade.getAccountServicePoints(apiParams.getsiteId(), 
																		   apiParams.getCust_acct(), 
																		   apiParams.getBillDate(), 
																		   apiParams.getOrderGroupSeq(), 
																		   apiParams.getOffernum(), 
																		   apiParams.getCorp(), 
																		   login.getTicket());
			
			if (accountServicesVO != null) {
				printOutput.printToShell(apiParams, 
									     getClass().getName() + ":<accountServicesVO>" + accountServicesVO.toString() + "</accountServicesVO>",
									     accountServicesVO.toXml());
			}
			else {
				printOutput.printToShell(apiParams, getClass().getName() + ":<servicePointVO> is null", null);
			}
		}
		catch (AmspServiceException e) 	{
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
		
		return (accountServicesVO);
	}

}
