package app.main;

//local classes
import util.Lock;
import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.Configuration;
import app.opr.OprBrowseByAddressTest;


/**
* @author JVANHOOF
*  Driver class for API Operation class
*/

public class MainDemo {
	public static void main(String[] args) {

		Configuration.appName = Configuration.AMSP_API_APP_NAME;
		
		// create utility objects
		Lock lock               = new Lock();
		Login login             = new Login();
		PrintOutput printOutput = new PrintOutput();
		Parameters apiParams    = new Parameters();
		
		// initialize utility objects
		printOutput.initOutput(apiParams, printOutput);
		apiParams.initParameters(Parameters.BROWSE_BY_ADDRESS, apiParams, printOutput);
		
		// API test objects
		OprBrowseByAddressTest oprBrowseByAddressTest = new OprBrowseByAddressTest();
		
		// login and perform operation
		if (login.logInOut(Login.LOGIN, apiParams, printOutput)){

			lock.checkAPC_lock(apiParams, login, printOutput);
			
			if (lock.getApcLock() == false){
				
				oprBrowseByAddressTest.getData(apiParams, login, printOutput);
			}
			
	 		login.logInOut(Login.LOGOUT, apiParams, printOutput);
		}
		
		// finish logging and cleanup display and print file
		apiParams.finishOutput(apiParams, printOutput);
		printOutput.finishOutput(apiParams, printOutput);
		
		// hold here until user closes output window
		while (!printOutput.shell.isDisposed()) {
			if (!printOutput.display.readAndDispatch()) printOutput.display.sleep(); 
		}
	}
}

