package app.main;

import amdocs.amsp.Configuration;
import app.opr.OprCreateSiteTest;
import util.Lock;
import util.Login;
import util.Parameters;
import util.PrintOutput;

public class MainCreateSite {
	
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
		apiParams.initParameters(Parameters.CREATE_SITE, apiParams, printOutput);
		
		OprCreateSiteTest oprCreateSiteTest = new OprCreateSiteTest();
		
		session = login.logInOut(login.LOGIN(), apiParams, printOutput);
		
		if (session) {
			
			Lock lock = new Lock();
			APC_lock   = lock.checkAPC_lock(apiParams, login, printOutput);
			//varLock = lock.lockIt(lock.LOCK(), lock.VARIABLE(), apiParams, login.getTicket(), printOutput);
			//siteLock = lock.lockIt(lock.LOCK(), lock.SITE(), apiParams, login.getTicket(), printOutput);
			
			if (!APC_lock) {
				oprCreateSiteTest.getData(apiParams, login, printOutput);
				
				oprCreateSiteTest.setData(apiParams, login, printOutput);
				
				oprCreateSiteTest.saveData(apiParams, login, printOutput);
			}
			
			// always unlock all
	 		if (acctLock || siteLock || varLock){lock.lockIt(lock.UNLOCK(), lock.ALL(), apiParams, login.getTicket(), printOutput);}
	 		
			// always logout
	 		login.logInOut(login.LOGOUT(), apiParams, printOutput);
		}
		
		while (!printOutput.shell.isDisposed()) {
			if (!printOutput.display.readAndDispatch()) printOutput.display.sleep(); 
		}
		
		//cleanup display and print file
		printOutput.finishOutput(apiParams, printOutput);
	}
}
