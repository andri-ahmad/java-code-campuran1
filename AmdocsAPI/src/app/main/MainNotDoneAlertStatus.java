package app.main;

import util.Lock;
import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.Configuration;
import app.opr.OprNotDoneAlertStatus;

public class MainNotDoneAlertStatus {
	public static void main(String[] args) {
		Configuration.appName = Configuration.AMSP_API_APP_NAME;
		
		// create utility objects
		Lock lock               = new Lock();
		Login login             = new Login();
		Parameters apiParams    = new Parameters();
		PrintOutput printOutput = new PrintOutput();
		
		// initialize utility objects
		printOutput.initOutput(apiParams, printOutput);
		apiParams.initParameters(Parameters.NOT_DONE_ALERT_STATUS, apiParams, printOutput);
		
		// API test object
		OprNotDoneAlertStatus oprNotDoneAlertStatus = new OprNotDoneAlertStatus();
		
		if (login.logInOut(Login.LOGIN, apiParams, printOutput) 
				        && !lock.checkAPC_lock(apiParams, login, printOutput) 
				        //&& lock.lockIt(Lock.LOCK, Lock.ACCOUNT, apiParams, login.getTicket(), printOutput) 
				        //&& lock.lockIt(Lock.LOCK, Lock.SITE, apiParams, login.getTicket(), printOutput) 
				        && lock.lockIt(Lock.LOCK, Lock.TECH, apiParams, login.getTicket(), printOutput)
				        ) {
			
			oprNotDoneAlertStatus.getData(apiParams, login, printOutput);
			oprNotDoneAlertStatus.setData(apiParams, login, printOutput);
			oprNotDoneAlertStatus.saveData(apiParams, login, printOutput);
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
