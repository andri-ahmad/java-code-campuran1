package app.main;

import amdocs.amsp.Configuration;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.ServicePointFacade;
import amdocs.amsp.valueobject.servicepoint.EquipmentVO;

import util.Lock;
import util.Login;
import util.Parameters;
import util.PrintOutput;

public class MainGetEquipmentDetails {
	
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
			
			ServicePointFacade servicePointFacade = new ServicePointFacade();
			EquipmentVO equipmentVO = new EquipmentVO();
			
			// initialize utility objects
			printOutput.initOutput(apiParams, printOutput);
			apiParams.initParameters(Parameters.GET_EQUIPMENT_DETAILS, apiParams, printOutput);
			
			session = login.logInOut(Login.LOGIN, apiParams, printOutput);
			
			if (session) {
				
				Lock lock = new Lock();
				APC_lock   = lock.checkAPC_lock(apiParams, login, printOutput);
				
				if (!APC_lock) {
					try {
						equipmentVO = servicePointFacade.getEquipmentDetails(apiParams.getEquipmentId(), 
								                                             apiParams.getCorp(), 
								                                             login.getTicket());
			            
						if (equipmentVO != null) {
							printOutput.printToShell(apiParams, 
				            		"MainGetEquipmentDetails.main:<equipmentVO>" +	equipmentVO.toString() + "</equipmentVO>",
				            		equipmentVO.toXml());
						}
						else {
							printOutput.printToShell(apiParams, "MainGetEquipmentDetails.main:<equipmentVO> is null", null);
						}
					
					} catch (AmspServiceException e) {
						printOutput.printExceptionToShell(apiParams, "MainGetEquipmentDetails.main", e);
					}
				}
				
				// always logout
		 		login.logInOut(Login.LOGOUT, apiParams, printOutput);
		}
			
		//cleanup display and print file
		apiParams.finishOutput(apiParams, printOutput);
		printOutput.finishOutput(apiParams, printOutput);
		
		// hold here until user closes output window
		while (!printOutput.shell.isDisposed()) {
			if (!printOutput.display.readAndDispatch()) printOutput.display.sleep(); 
		}
	}
}
