package app.main;

import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.system.AmspAccessFacade;
import amdocs.amsp.Configuration;
import amdocs.amsp.FrameworkConstantsI;

public class MainLoginBareBones {
	
	public static void main(String[] args) {
		String ticket = null;
		
		Configuration.appName = Configuration.AMSP_API_APP_NAME;
		
		AmspAccessFacade amspAccessFacade = new AmspAccessFacade();
		
		// login
		try {
			ticket = amspAccessFacade.login("c46099",
			        						"m@$t3r99", 
			        						FrameworkConstantsI.DEFAULT_LOCALE);
		} catch (AmspServiceException e) {
			System.out.println("AMSP Exception: " + e);
		}
		
		if (ticket != null){
			System.out.println("Login success, ticket value: " + ticket);
		}
		else {
			System.out.println("Login failed, ticket is null");
		}
		
		// logout
		try {
			if (amspAccessFacade.logout(ticket)) {
				System.out.println("Logout success");
			}
			else {
				System.out.println("Logout failure");
			}
		} catch (AmspServiceException e) {
			System.out.println("AMSP Exception: " + e);
		}	
	}
}
