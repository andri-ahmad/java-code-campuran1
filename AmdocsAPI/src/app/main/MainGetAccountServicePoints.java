package app.main;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.Configuration;
import amdocs.amsp.valueobject.accountviewwip.OrderGroupVO;
import amdocs.amsp.valueobject.servicepoint.AccountServicesVO;
import amdocs.amsp.valueobject.servicepoint.ServicePointVO;
import app.get.GetAccountServicePointsTest;
import app.get.GetOpenOrderGroupListTest;

public class MainGetAccountServicePoints {
	
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
		
		AccountServicesVO accountServicesVO   = new AccountServicesVO();
		OrderGroupVO[] orderGroupVOlist = null;
		GetAccountServicePointsTest getAccountServicePointsTest = new GetAccountServicePointsTest();
		GetOpenOrderGroupListTest getOpenOrderGroupListTest = new GetOpenOrderGroupListTest();
		ServicePointVO[] currentServicePointVOList = null;
		ServicePointVO[] futureServicePointVOList = null;
		
		session = login.logInOut(Login.LOGIN, apiParams, printOutput);
		
		if (session) {

			orderGroupVOlist = getOpenOrderGroupListTest.getOpenOrderGroupList(apiParams, login, printOutput);
			
			apiParams.setOrderGroupSeq(apiParams, printOutput, orderGroupVOlist[0].getOrderGroupSeq());
			
			accountServicesVO = getAccountServicePointsTest.getAccountServicePoints(apiParams, login, printOutput);
			
			currentServicePointVOList = accountServicesVO.getCurrentServicePointList();
			
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
			
			futureServicePointVOList = accountServicesVO.getFutureServicePointList();
			
			if (futureServicePointVOList != null && futureServicePointVOList.length > 0) {
				for (int i = 0; i != futureServicePointVOList.length; i++) {
					printOutput.printToShell(apiParams, 
											 ":<futureServicePointVOList id=" + i + ">" + futureServicePointVOList[i].toString() + "</futureServicePointVOList>",
											 futureServicePointVOList[i].toXml());
	 			}
			}
			else {
				printOutput.printToShell(apiParams, 
										 "futureServicePointVOList is null or has no data", null);
			}
	 		
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
