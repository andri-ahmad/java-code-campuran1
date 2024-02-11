package app.main;

import amdocs.amsp.Configuration;
import app.opr.OprOPInstallTest;
import util.Lock;
import util.Login;
import util.Parameters;
import util.PrintOutput;
import util.SupportException;

public class MainInstall {

	public static void main(String[] args) {
		Configuration.appName = Configuration.AMSP_API_APP_NAME;
		
		// create utility objects
		Lock lock               = new Lock();
		Login login             = new Login();
		PrintOutput printOutput = new PrintOutput();
		Parameters apiParams    = new Parameters();
		
		// initialize utility objects
		printOutput.initOutput(apiParams, printOutput);
		apiParams.initParameters(Parameters.NEW_INSTALL, apiParams, printOutput);
		
		// API test objects - create current test object
		OprOPInstallTest oprOPInstallTest = new OprOPInstallTest();
		
		// run setup - data gathering and setting (before locking)
		if (login.logInOut(Login.LOGIN, apiParams, printOutput)){
			
			// get, set and update data
			if (lock.checkAPC_lock(apiParams, login, printOutput) == false  
				&& lock.lockIt(Lock.LOCK, Lock.SITE, apiParams, login.getTicket(), printOutput) 
				&& lock.lockIt(Lock.LOCK, Lock.VARIABLE, apiParams, login.getTicket(), printOutput)
				){
				try {
					oprOPInstallTest.checkOption(apiParams, login, printOutput);
					oprOPInstallTest.getData(apiParams, login, printOutput);
					oprOPInstallTest.setData(apiParams, login, printOutput);
					//oprOPInstallTest.saveData(apiParams, login, printOutput);
				} catch (SupportException e) {
					printOutput.printToShell(apiParams, "MainInstall: " + e, null);
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
		//while (!printOutput.shell.isDisposed()) {
		//	if (!printOutput.display.readAndDispatch()) printOutput.display.sleep(); 
		//}
	}
}
