package app.main;

import amdocs.amsp.Configuration;

import util.Lock;
import util.Login;
import util.Parameters;
import util.PrintOutput;

public class MainLock {
	
	public static void main(String[] args) {
		Configuration.appName = Configuration.AMSP_API_APP_NAME;
			
		// variables
		boolean session;			// login session flag
		
		// create utility objects
		Login login             = new Login();
		PrintOutput printOutput = new PrintOutput();
		Parameters apiParams    = new Parameters();
		
		// initialize utility objects
		printOutput.initOutput(apiParams, printOutput);
		apiParams.initParameters(Parameters.LOCK, apiParams, printOutput);
		
		session = login.logInOut(Login.LOGIN, apiParams, printOutput);
		
		if (session) {
			
			Lock lock = new Lock();
			//APC_lock  = lock.checkAPC_lock(apiParams, login, printOutput);
			lock.lockIt(Lock.LOCK, Lock.ACCOUNT,  apiParams, login.getTicket(), printOutput);
			lock.lockIt(Lock.LOCK, Lock.ACCOUNT,  apiParams, login.getTicket(), printOutput);
			//varLock   = lock.lockIt(Lock.LOCK, Lock.VARIABLE, apiParams, login.getTicket(), printOutput);
			//siteLock  = lock.lockIt(Lock.LOCK, Lock.SITE,     apiParams, login.getTicket(), printOutput);
			
			// always unlock all
			lock.unlockAccount(apiParams, login, printOutput);
	 		
			// always logout
	 		login.logInOut(Login.LOGOUT, apiParams, printOutput);
	 		
		}
		
		//cleanup display and print file
		apiParams.finishOutput(apiParams, printOutput);
		printOutput.finishOutput(apiParams, printOutput);
		
		while (!printOutput.shell.isDisposed()) {
			if (!printOutput.display.readAndDispatch()) printOutput.display.sleep(); 
		}
	}
}
