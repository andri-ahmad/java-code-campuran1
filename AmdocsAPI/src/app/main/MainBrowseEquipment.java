package app.main;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.Configuration;
import app.opr.OprBrowseEquipmentTest;

public class MainBrowseEquipment {
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
		apiParams.initParameters(Parameters.BROWSE_EQUIPMENT, apiParams, printOutput);
		
		OprBrowseEquipmentTest oprBrowseEquipmentTest = new OprBrowseEquipmentTest();
		
		session = login.logInOut(Login.LOGIN, apiParams, printOutput);
		
		if (session) {

			oprBrowseEquipmentTest.getData(apiParams, login, printOutput);
				
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
