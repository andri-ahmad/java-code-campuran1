package util;

import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.system.AmspAccessFacade;

/**
 * @author JVANHOOF
 * Performs login and logout operations based on parameters
 */
public class Login {
	
	// variables
	
	public static int LOGIN = 0;
	public static int LOGOUT = 1;
	private String ticketP = null;
	private AmspAccessFacade amspAccessF = new AmspAccessFacade();
	
	public boolean logInOut (int action, Parameters apiParams, PrintOutput printOutput){
		switch (action){
			case 0: 
				try {
						// login				
						ticketP = amspAccessF.login(apiParams.getUserid(),
								                    apiParams.getPasswd(), 
								                    apiParams.getLocale());
						
						if (ticketP == null) {
							printOutput.printToShell(apiParams, getClass().getName() + " Login failed!", null);
							return (false);
						}
						else {
							printOutput.printToShell(apiParams, getClass().getName() + " Login succeeded", null);
							printOutput.printToShell(apiParams, getClass().getName() + ":<ticketP>" + ticketP + "</ticketP>", null);
							return (true);
						}
					} catch (AmspServiceException e) {
						printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
					} catch (NullPointerException e) {
						printOutput.printNullPointerExceptionToShell(apiParams, getClass().getName(), e);
			        }
				
				break;
			
			case 1: 
				try {
					// logout
						if (amspAccessF.logout(ticketP)){
							printOutput.printToShell(apiParams, getClass().getName() + ": Logout succeeded", null);
							ticketP = null;
							return (true);
						}
						else {
							printOutput.printToShell(apiParams, getClass().getName() + ": Logout failed!", null);
							ticketP = null;
							return (false);
						}
					} catch (AmspServiceException e) {
						printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
					} catch (NullPointerException e) {
						printOutput.printNullPointerExceptionToShell(apiParams, getClass().getName(), e);
			        }
				
				break;
			
			default: {
				printOutput.printToShell(apiParams, getClass().getName() + ": Unknown value passed", null);
				break;
			}
		} // end of switch
		return (false);
	} // end of LoginOut
	
	public String getTicket () {return (ticketP);}
	
} // end of class Login
