package app.main;

import util.Lock;
import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.Configuration;
import amdocs.amsp.valueobject.accountviewservices.PhoneNumberVO;
import app.get.GetTelephonyServicesTest;

public class MainGetTelephonyServices {
	public static void main(String[] args) {
		Configuration.appName = Configuration.AMSP_API_APP_NAME;

		// variables
		boolean session; // login session flag
			
		// create utility objects
		Lock lock               = new Lock();
		Login login             = new Login();
		Parameters apiParams    = new Parameters();
		PrintOutput printOutput = new PrintOutput();
		
		// initialize utility objects
		printOutput.initOutput(apiParams, printOutput);
		apiParams.initParameters(Parameters.GET_TELEPHONY_SERVICES, apiParams, printOutput);
		
		// API test objects - create current test objects
		@SuppressWarnings("unused")
		PhoneNumberVO[] phoneNumberVOList = null;
		GetTelephonyServicesTest getTelephonyServicesTest = new GetTelephonyServicesTest();
		
		session = login.logInOut(Login.LOGIN, apiParams, printOutput);
		
		if (session){
			// locking
			lock.checkAPC_lock(apiParams, login, printOutput);
			
			// get, set and save data
			if (lock.getApcLock() == false){
				phoneNumberVOList = getTelephonyServicesTest.getTelephonyServices(apiParams, login, printOutput);
			}
					
			// always unlock all
	 		lock.lockIt(Lock.UNLOCK, Lock.ALL, apiParams, login.getTicket(), printOutput);
	 		
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
