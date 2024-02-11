package app.main;

import util.Lock;
import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.Configuration;
import app.opr.OprCompleteSROJobTest;

public class MainCompleteSROJob {
	
	public static void main(String[] args) {
		Configuration.appName = Configuration.AMSP_API_APP_NAME;
		
		// create utility objects
		Lock lock               = new Lock();
		Login login             = new Login();
		Parameters apiParams    = new Parameters();
		PrintOutput printOutput = new PrintOutput();
		
		// initialize utility objects
		printOutput.initOutput(apiParams, printOutput);
		apiParams.initParameters(Parameters.COMPLETE_SRO_JOB, apiParams, printOutput);
		
		// API test object
		OprCompleteSROJobTest oprCompleteSROJobTest = new OprCompleteSROJobTest();
		
		// Account, Site and Tech locks are all required for this operation
		if (login.logInOut(Login.LOGIN, apiParams, printOutput) 
	        && !lock.checkAPC_lock(apiParams, login, printOutput) 
	        && lock.lockIt(Lock.LOCK, Lock.ACCOUNT, apiParams, login.getTicket(), printOutput) 
	        && lock.lockIt(Lock.LOCK, Lock.SITE, apiParams, login.getTicket(), printOutput) 
	        && lock.lockIt(Lock.LOCK, Lock.TECH, apiParams, login.getTicket(), printOutput)
	        ) {
			
			oprCompleteSROJobTest.getData(apiParams, login, printOutput);
			oprCompleteSROJobTest.setData(apiParams, login, printOutput);
			oprCompleteSROJobTest.saveData(apiParams, login, printOutput);
		}
		
		lock.lockIt(Lock.UNLOCK, Lock.ALL, apiParams, login.getTicket(), printOutput);
		login.logInOut(Login.LOGOUT, apiParams, printOutput);
		
		while (!printOutput.shell.isDisposed()) {
			if (!printOutput.display.readAndDispatch()) printOutput.display.sleep(); 
		}
		
		//cleanup display and print file
		printOutput.finishOutput(apiParams, printOutput);
	}

}
