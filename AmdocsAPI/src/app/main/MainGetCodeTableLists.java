package app.main;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.Configuration;
import amdocs.amsp.valueobject.corpparam.Code95VO;
import app.get.GetCodeTableCodeTest;

public class MainGetCodeTableLists {
	public static void main(String[] args) {
		Configuration.appName = Configuration.AMSP_API_APP_NAME;
		
		// create utility objects
		Login login             = new Login();
		Parameters apiParams    = new Parameters();
		PrintOutput printOutput = new PrintOutput();
		
		// initialize utility objects
		printOutput.initOutput(apiParams, printOutput);
		apiParams.initParameters(Parameters.GET_CODE_TABLE, apiParams, printOutput);
		
		// API test objects
		Code95VO[] code95VOList = null;
		GetCodeTableCodeTest getCodeTableCodeTest = new GetCodeTableCodeTest();
		
		if (login.logInOut(Login.LOGIN, apiParams, printOutput)) {
			
			code95VOList = getCodeTableCodeTest.getNotDoneAlert(apiParams, login, printOutput);
			
			if (code95VOList != null) {
				System.out.println("code95VOList is not null");
			} else {
				System.out.println("code95VOList is null");
			}
			
			login.logInOut(Login.LOGOUT, apiParams, printOutput);
		}
		
		while (!printOutput.shell.isDisposed()) {
			if (!printOutput.display.readAndDispatch()) printOutput.display.sleep(); 
		}
		
		//cleanup display and print file
		printOutput.finishOutput(apiParams, printOutput);
	}
}
