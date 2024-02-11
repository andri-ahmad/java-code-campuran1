package app.main;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.Configuration;
import amdocs.amsp.valueobject.accountviewwip.OrderGroupVO;
import amdocs.amsp.valueobject.servicepoint.ServicePointVO;
import app.get.GetAllServicePointsTest;
import app.get.GetOpenOrderGroupListTest;

public class MainGetAllServicePoints {
	
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
		apiParams.initParameters(Parameters.GET_ACCOUNT_SERVICE_POINTS, apiParams, printOutput);
		
		OrderGroupVO[] orderGroupVOlist = null;
		GetAllServicePointsTest getAllServicePointsTest = new GetAllServicePointsTest();
		GetOpenOrderGroupListTest getOpenOrderGroupListTest = new GetOpenOrderGroupListTest();
		ServicePointVO[] currentServicePointVOList = null;
		
		session = login.logInOut(Login.LOGIN, apiParams, printOutput);
		
		if (session) {

			orderGroupVOlist = getOpenOrderGroupListTest.getOpenOrderGroupList(apiParams, login, printOutput);
			
			apiParams.setOrderGroupSeq(apiParams, printOutput, orderGroupVOlist[0].getOrderGroupSeq());
			
			currentServicePointVOList = getAllServicePointsTest.getAllServicePoints(apiParams, login, printOutput);
			
			
			if (currentServicePointVOList != null && currentServicePointVOList.length > 0) {
				for (int i = 0; i != currentServicePointVOList.length; i++) {
					printOutput.printToShell(apiParams, 
											 ":<currentServicePointVOList id=" + i + ">" + currentServicePointVOList[i].toString() + "</currentServicePointVOList>",
											 currentServicePointVOList[i].toXml());
	 			}
			}
			else { 
				printOutput.printToShell(apiParams, 
										 "currentServicePointVOList is null or has no data", null);
			}
	 		
			// always logout
	 		login.logInOut(Login.LOGOUT, apiParams, printOutput);
		}
		while (!printOutput.shell.isDisposed()) {
			if (!printOutput.display.readAndDispatch()) printOutput.display.sleep(); 
		}
		
		//cleanup display and print file
		printOutput.finishOutput(apiParams, printOutput);	
	}
}
