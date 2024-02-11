package app.main;

import util.Lock;
import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.Configuration;
import amdocs.amsp.valueobject.corpparam.Code36VO;
import app.get.GetCodeTableCodeTest;

public class MainGetReturnReasons {
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		Configuration.appName = Configuration.AMSP_API_APP_NAME; // Amdocs
		
		// variables
		boolean session;			// login session flag
		
		// lock type flags
		boolean APC_lock   = false;
		
		// create utility objects
		Login login             = new Login();
		PrintOutput printOutput = new PrintOutput();
		Parameters apiParams    = new Parameters();
		
		Code36VO[] code36VOList = null;
		GetCodeTableCodeTest getCodeTableCodeTest = new GetCodeTableCodeTest();
		
		// initialize utility objects
		printOutput.initOutput(apiParams, printOutput);
		apiParams.initParameters(apiParams.TEMP_OPERATION, apiParams, printOutput);
		
		session = login.logInOut(Login.LOGIN, apiParams, printOutput);
		
		if (session) {
			
			Lock lock = new Lock();
			APC_lock   = lock.checkAPC_lock(apiParams, login, printOutput);
			
			if (!APC_lock) {
				
				code36VOList = getCodeTableCodeTest.getReturnReasons(apiParams, login, printOutput);
				
				if (code36VOList != null) {
					System.out.println("code36VOList is not null");
				} else {
					System.out.println("code36VOList is null");
				}
			}
			// always logout
	 		login.logInOut(Login.LOGOUT, apiParams, printOutput);
		}

		//cleanup display and print file
		printOutput.finishOutput(apiParams, printOutput);	
	}

}
