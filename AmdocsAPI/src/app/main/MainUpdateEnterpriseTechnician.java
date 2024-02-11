package app.main;

//local classes
import amdocs.amsp.Configuration;

import app.opr.OprUpdateEnterpriseTechnicianTest;
import util.Lock;
import util.Login;
import util.Parameters;
import util.PrintOutput;

public class MainUpdateEnterpriseTechnician {
	
	public static void main(String[] args) {
		Configuration.appName = Configuration.AMSP_API_APP_NAME;

		// variables
		boolean session;			// login session flag
		
		// lock type flags
		
		// create utility objects
		Login login             = new Login();
		PrintOutput printOutput = new PrintOutput();
		Parameters apiParams    = new Parameters();
		
		// initialize utility objects
		printOutput.initOutput(apiParams, printOutput);
		apiParams.initParameters(Parameters.UPDATE_ENT_TECHNICIAN, apiParams, printOutput);
		
		// API test objects - create current test objects
		OprUpdateEnterpriseTechnicianTest oprUpdateEnterpriseTechnicianTest = new OprUpdateEnterpriseTechnicianTest();
		
		session = login.logInOut(Login.LOGIN, apiParams, printOutput);
		
		// run setup - data gathering and setting (before locking)
		if (session){
			// locking - expose whichever lock types are needed for operation
			Lock lock  = new Lock();
			lock.checkAPC_lock(apiParams, login, printOutput);
			
			
			// get, set and update data
			if (lock.getApcLock() == false){
				
				lock.lockIt(Lock.LOCK, Lock.TECH, apiParams, login.getTicket(), printOutput);
				
				if (lock.getTechLock()) {
					oprUpdateEnterpriseTechnicianTest.getData(apiParams,  login, printOutput);
					oprUpdateEnterpriseTechnicianTest.setData(apiParams,  login, printOutput);
					oprUpdateEnterpriseTechnicianTest.saveData(apiParams, login, printOutput);
				}
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
