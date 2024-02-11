package app.main;

import util.Lock;
import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.Configuration;
import app.get.GetTechJobsTest;

public class MainTechJobs {

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
		apiParams.initParameters(Parameters.GET_TECH_JOBS, apiParams, printOutput);
		
		// API test objects - create current test object
		GetTechJobsTest currentTest = new GetTechJobsTest();
		
		// attempt login
		session = login.logInOut(Login.LOGIN, apiParams, printOutput);
		
		// run setup - data gathering and setting (before locking)
		if (session){
			// locking - expose whichever lock types are needed for operation
			Lock lock  = new Lock();
			APC_lock   = lock.checkAPC_lock(apiParams, login, printOutput);
			//acctLock = lock.lockIt(lockAction.LOCK, lockType.ACCOUNT,  apiParams, login.getTicket(), printOutput);
			//siteLock = lock.lockIt(lockAction.LOCK, lockType.SITE,     apiParams, login.getTicket(), printOutput);
			//varLock  = lock.lockIt(lockAction.LOCK, lockType.VARIABLE, apiParams, login.getTicket(), printOutput);
			
			// get, set and update data
			if (APC_lock == false){
				currentTest.getTechJobs(apiParams, login, printOutput);
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
	}
}
