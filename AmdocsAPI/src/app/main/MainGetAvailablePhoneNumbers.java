package app.main;

//local classes
import util.Lock;
import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.Configuration;
//import app.opr.OprGetAvailablePhoneNumbersTest;


/**
* @author JVANHOOF
*  Driver class for API Operation class.
*/

public class MainGetAvailablePhoneNumbers {
	public static void main(String[] args) {
		Configuration.appName = Configuration.AMSP_API_APP_NAME;

		// variables
		boolean session;			// login session flag
		
		// lock type flag
		boolean APC_lock   = false;

		// create utility objects
		Login login             = new Login();
		PrintOutput printOutput = new PrintOutput();
		Parameters apiParams    = new Parameters();
		
		// initialize utility objects
		printOutput.initOutput(apiParams, printOutput);
		apiParams.initParameters(Parameters.DEMO, apiParams, printOutput);
		
		// API test objects - create current test objects
		//OprGetAvailablePhoneNumbersTest oprGetAvailablePhoneNumbers = new OprGetAvailablePhoneNumbersTest();
		
		// login
		session = login.logInOut(Login.LOGIN, apiParams, printOutput);
		
		// operation
		if (session){
			// lock
			Lock lock  = new Lock();
			APC_lock   = lock.checkAPC_lock(apiParams, login, printOutput);

			// get data
			if (APC_lock == false){
				//oprGetAvailablePhoneNumbers.getData(apiParams, login, lock, printOutput);
				//oprGetAvailablePhoneNumbers.setData(apiParams, printOutput);
				//oprGetAvailablePhoneNumbers.saveData(apiParams, login, printOutput);
			}
			
			// always logout
	 		login.logInOut(Login.LOGOUT, apiParams, printOutput);
		}
		
		// finish logging and cleanup display and print file
		apiParams.finishOutput(apiParams, printOutput);
		printOutput.finishOutput(apiParams, printOutput);
		
		// hold here until user closes output window
		while (!printOutput.shell.isDisposed()) {
			if (!printOutput.display.readAndDispatch()) printOutput.display.sleep(); 
		}
	} // end of main method
}
