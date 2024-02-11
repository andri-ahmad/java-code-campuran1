package app.misc;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import util.SupportException;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.CustomerFacade;
import amdocs.amsp.valueobject.customer.ProspectResultVO;

public class CheckCustomerPhoneTest {
	
	CustomerFacade customerFacade = new CustomerFacade();
	ProspectResultVO prospectResultVO = new ProspectResultVO();
	
	public ProspectResultVO checkData (Parameters apiParams, Login login, PrintOutput printOutput) throws SupportException {
		try {
			
			prospectResultVO = customerFacade.checkCustomerPhone(apiParams.getHomePhone(), apiParams.getCust_acct(), apiParams.getsiteId(), apiParams.getCorp(), login.getTicket());

		} catch (AmspServiceException e) {
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
		return (prospectResultVO);
	}
}
