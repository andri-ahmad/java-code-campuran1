package app.main;

//local classes
import amdocs.amsp.Configuration;
import app.opr.OprReAssignTechJobTest;
import util.Lock;
import util.Login;
import util.Parameters;
import util.PrintOutput;

/**
* @author JVANHOOF
*  Main module for reAssignTechJobs API - created for LinkNet
*/

public class MainReAssignTechJobsTest {
	
	public static void main(String[] args) {
		Configuration.appName = Configuration.AMSP_API_APP_NAME;

		// login session flag
		boolean session = false;
		
		// locking flags
		boolean APC_lock      = false;
		boolean fromTechLock  = false;
		boolean toTechLock    = false;
		
		// create utility objects
		Login login             = new Login();
		PrintOutput printOutput = new PrintOutput();
		Parameters apiParams    = new Parameters();
		
		// initialize utility objects
		printOutput.initOutput(apiParams, printOutput);
		apiParams.initParameters(Parameters.RE_ASSIGN_TECH_JOBS, apiParams, printOutput);
		
		// API test objects - add/expose current test objects
		OprReAssignTechJobTest oprReAssignTechJobTest = new OprReAssignTechJobTest();
				
		// attempt login
		session = login.logInOut(Login.LOGIN, apiParams, printOutput);
		
		// operation
		if (session){
			// lock - expose whichever lock types are needed for operation
			Lock lock = new Lock();
			APC_lock  = lock.checkAPC_lock(apiParams, login, printOutput);
			
			// We lock 2 Techs in this operation
			apiParams.setTechId(apiParams, printOutput, apiParams.getFromTech());
			fromTechLock = lock.lockIt(Lock.LOCK, Lock.TECH, apiParams, login.getTicket(), printOutput);
			
			if (fromTechLock) {
				apiParams.setTechId(apiParams, printOutput, apiParams.getToTech());
				toTechLock = lock.lockIt(Lock.LOCK, Lock.TECH, apiParams, login.getTicket(), printOutput);
			}

			// Get, set and update data
			if (!APC_lock && fromTechLock && toTechLock){
				// No need to call a get data method for this API
				oprReAssignTechJobTest.setData(apiParams,  login, printOutput);
				oprReAssignTechJobTest.saveData(apiParams, login, printOutput);
			}
					
			// always unlock all
	 		if (fromTechLock || toTechLock){lock.lockIt(Lock.UNLOCK, Lock.ALL, apiParams, login.getTicket(), printOutput);}
	 		
			// logout
	 		login.logInOut(Login.LOGOUT, apiParams, printOutput);
	 			
	 		printOutput.printToShell(apiParams, "\nClose this window to end session", null);
		}
		
		//cleanup display and print file
		apiParams.finishOutput(apiParams, printOutput);
		printOutput.finishOutput(apiParams, printOutput);
		
		// hold here until user closes output window
		while (!printOutput.shell.isDisposed()) {
			if (!printOutput.display.readAndDispatch()) printOutput.display.sleep(); 
		}
	} // end of main()
}
