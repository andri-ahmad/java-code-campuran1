package app.opr;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.OpChangeHouseCustFacade;
import amdocs.amsp.valueobject.customer.CustomerDetailsVO;
import amdocs.amsp.valueobject.order.OrderResultVO;
import app.get.GetCustomerDetailsVO_Test;

public class OprUpdateCustDataTest {
	
	private OpChangeHouseCustFacade opChangeHouseCustFacade = new OpChangeHouseCustFacade();
	private CustomerDetailsVO customerDetailsVO = new CustomerDetailsVO();
	private OrderResultVO orderResultVO = new OrderResultVO();
	private GetCustomerDetailsVO_Test getCustomerDetailsVO_Test = new GetCustomerDetailsVO_Test();
	
	public void getData (Parameters apiParams, Login login, PrintOutput printOutput) {
		
		customerDetailsVO = getCustomerDetailsVO_Test.getCustomerDetail(apiParams, login, printOutput);
		
	}
	
	public void setData (Parameters apiParams, Login login, PrintOutput printOutput) {
		
		customerDetailsVO.setEnterpriseId("API06"); //char(20)
		
	}
	
	public void saveData(Parameters apiParams, Login login, PrintOutput printOutput) {
		try {
			orderResultVO = opChangeHouseCustFacade.updateCustData(apiParams.getCust_acct(), 
					                                               apiParams.getsiteId(), 
					                                               apiParams.getCallerName(), 
					                                               customerDetailsVO, 
					                                               apiParams.getPhoneNumberReplaceFlag(), 
					                                               apiParams.getCorp(), 
					                                               login.getTicket());
			
			if (orderResultVO != null) {
				
					printOutput.printToShell(apiParams, 
							                 getClass().getName() + ":<orderResultVO>" + orderResultVO.toString() + "</orderResultVO>",
							                 orderResultVO.toXml());
			}
			
		} catch (AmspServiceException e) {
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
	}
}
