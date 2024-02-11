package app.main;

import amdocs.amsp.Configuration;
import app.opr.OprCancelSRO_Test;
import util.Lock;
import util.Login;
import util.Parameters;
import util.PrintOutput;

public class MainCancelSRO {

	public static void main(String[] args) {
		Configuration.appName = Configuration.AMSP_API_APP_NAME;
			
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
		apiParams.initParameters(Parameters.CANCEL_SRO, apiParams, printOutput);
		
		OprCancelSRO_Test oprCancelSRO_Test = new OprCancelSRO_Test();
		
		session = login.logInOut(Login.LOGIN, apiParams, printOutput);
		
		if (session) {
			
			Lock lock = new Lock();
			APC_lock   = lock.checkAPC_lock(apiParams, login, printOutput);
			acctLock = lock.lockIt(Lock.LOCK, Lock.ACCOUNT, apiParams, login.getTicket(), printOutput);
			varLock = lock.lockIt(Lock.LOCK, Lock.VARIABLE, apiParams, login.getTicket(), printOutput);
			siteLock = lock.lockIt(Lock.LOCK, Lock.SITE, apiParams, login.getTicket(), printOutput);
			
			if (!APC_lock && acctLock && varLock && siteLock) {
				oprCancelSRO_Test.getData(apiParams, login, printOutput);
				
				oprCancelSRO_Test.setData(apiParams, login, printOutput);
				
				oprCancelSRO_Test.saveData(apiParams, login, printOutput);
			}
			
			// always unlock all
	 		if (acctLock || siteLock || varLock){lock.lockIt(Lock.UNLOCK, Lock.ALL, apiParams, login.getTicket(), printOutput);}
	 		
			// always logout
	 		login.logInOut(Login.LOGOUT, apiParams, printOutput);
		}
		
		// finish logging and cleanup display and print file
		apiParams.finishOutput(apiParams, printOutput);
		printOutput.finishOutput(apiParams, printOutput);
		
		while (!printOutput.shell.isDisposed()) {
			if (!printOutput.display.readAndDispatch()) printOutput.display.sleep(); 
		}	
	}
}
