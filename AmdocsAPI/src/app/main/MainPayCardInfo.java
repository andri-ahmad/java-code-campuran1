package app.main;

import util.Lock;
import util.Login;
import util.Parameters;
import util.PrintOutput;

import amdocs.amsp.valueobject.customer.CustomerDetailsVO;
import app.get.GetCreditCardConstraintsTest;
import app.get.GetCustPayCardTest;
import app.get.GetCustomerDetailsVO_Test;
import amdocs.amsp.valueobject.customer.PayCardDetailsVO;

public class MainPayCardInfo {
	
	public static void main(String[] args) {

		// variables
		boolean session;			// login session flag
		
		// lock type flags
		boolean APC_lock   = false;
		boolean siteLock   = false;
		boolean acctLock   = false;
		boolean varLock    = false;
		
		// create utility objects
		Login login             = new Login();
		PrintOutput printOutput = new PrintOutput();
		Parameters apiParams    = new Parameters();
		
		// initialize utility objects
		printOutput.initOutput(apiParams, printOutput);
		apiParams.initParameters(Parameters.PAYCARD_INFO, apiParams, printOutput);
		
		// API test objects - create current test objects
		GetCreditCardConstraintsTest getCreditCardConstraintsTest = new GetCreditCardConstraintsTest();
		CustomerDetailsVO customerDetailsVO = new CustomerDetailsVO();
		GetCustomerDetailsVO_Test getCustomerDetailsVO_Test = new GetCustomerDetailsVO_Test();
		PayCardDetailsVO[] payCardDetailsVOList = null;
		
		GetCustPayCardTest getCustPayCardTest = new GetCustPayCardTest();
		
		session = login.logInOut(Login.LOGIN, apiParams, printOutput);
		
		// run setup - data gathering and setting (before locking)
		if (session){
			// locking - expose whichever lock types are needed for operation
			Lock lock  = new Lock();
			APC_lock   = lock.checkAPC_lock(apiParams, login, printOutput);
			acctLock   = lock.lockIt(Lock.LOCK, Lock.ACCOUNT,  apiParams, login.getTicket(), printOutput);

			// get, set and update data
			if (APC_lock == false && acctLock == true){
				getCreditCardConstraintsTest.getCreditCardConstraints(apiParams, login, printOutput);
				
				customerDetailsVO = getCustomerDetailsVO_Test.getCustomerDetail(apiParams, login, printOutput);
				
				payCardDetailsVOList = customerDetailsVO.getPayCardDetails();
				
				if (payCardDetailsVOList != null) {
					for (int i = 0; i < payCardDetailsVOList.length; i++) {
						printOutput.printToShell(apiParams, 
								 "<payCardDetailsVOList[" + i + "] " + payCardDetailsVOList[i].toString() + "</payCardDetailsVOList[" + i + "]>",
								 payCardDetailsVOList[i].toXml());
					}
					
				}
				else {
					printOutput.printToShell(apiParams, "payCardDetailsVOList is null", null);
				}
				
				getCustPayCardTest.getCustPayCard(apiParams, login, printOutput);
				
				printOutput.printToShell(apiParams, "<creditCardNumber>" + payCardDetailsVOList[0].getCreditCardNumber() + "</creditCardNumber>", null);
				printOutput.printToShell(apiParams, "<creditCardExpiration>" + payCardDetailsVOList[0].getCreditCardExpiration() + "</creditCardExpiration>", null);
			}
					
			// always unlock all
	 		if (acctLock || siteLock || varLock){lock.lockIt(Lock.UNLOCK, Lock.ALL, apiParams, login.getTicket(), printOutput);}
	 		
			// always logout
	 		login.logInOut(Login.LOGOUT, apiParams, printOutput);
		}
		
		//cleanup display and print file
		apiParams.finishOutput(apiParams, printOutput);
		printOutput.finishOutput(apiParams, printOutput);
		
		// hold here until user closes output window
		while (!printOutput.shell.isDisposed()) {
			if (!printOutput.display.readAndDispatch()) printOutput.display.sleep(); 
		}
	} // end of main method
}
