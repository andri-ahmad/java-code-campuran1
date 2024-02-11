package app.main;

import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.ServicePointFacade;
import amdocs.amsp.services.system.AmspAccessFacade;
import amdocs.amsp.valueobject.servicepoint.EquipmentVO;
import amdocs.amsp.Configuration;
import amdocs.amsp.services.LockServiceFacade;
import amdocs.amsp.valueobject.lockservice.LockOutputVO;
import amdocs.amsp.FrameworkConstantsI;

public class MainGetEquipmentBareBones {
	public static void main(String[] args) {
		
		String ticket = null;
		Configuration.appName = Configuration.AMSP_API_APP_NAME; // Amdocs
		
		AmspAccessFacade amspAccessFacade = new AmspAccessFacade();
		
		// login
		try {
			ticket = amspAccessFacade.login("jvanhoof",
			        						"7913Jv48", 
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
		
		LockServiceFacade lockServiceFacade = new LockServiceFacade();
		LockOutputVO lockOutputVO = new LockOutputVO();
		
		if (ticket != null) {
			
			try
			{
				lockOutputVO = lockServiceFacade.checkApcLock("99504", ticket);
			} catch (AmspServiceException e) 	{
				System.out.println(e);
			}
			
			System.out.println("APC Lock Message: " + lockOutputVO.getMessage());
			
			ServicePointFacade servicePointFacade = new ServicePointFacade();
			EquipmentVO equipmentVO = new EquipmentVO();
			
			try {
				equipmentVO = servicePointFacade.getEquipmentDetails("     FMTC/0007", "99504", ticket);
	            
				if (equipmentVO != null) {
					System.out.println("MainGetEquipmentDetails.main: <equipmentVO>:<equipmentVO>" +	equipmentVO.toString() + "</equipmentVO>");
				}
				else {
					System.out.println("MainGetEquipmentDetails.main:<equipmentVO> is null");
				}
			
			} catch (AmspServiceException e) {
				System.out.println(e);
			}
			
			if (lockOutputVO.getStatus()) {
				try {
					equipmentVO = servicePointFacade.getEquipmentDetails("     FMTC/0007", "99504", ticket);
		            
					if (equipmentVO != null) {
						System.out.println("MainGetEquipmentDetails.main:<equipmentVO>" +	equipmentVO.toString() + "</equipmentVO>");
					}
					else {
						System.out.println("MainGetEquipmentDetails.main:<equipmentVO> is null");
					}
				
				} catch (AmspServiceException e) {
					System.out.println("MainGetEquipmentDetails.main" + e);
				}
		}
			try {
					if (amspAccessFacade.logout(ticket)){
						System.out.println("MainGetEquipmentbareBones: Logout success");
						
					}
					else {
						System.out.println("MainGetEquipmentbareBones: Logout failure");
					}
			}
			catch (AmspServiceException e) {
				System.out.println("MainGetEquipmentDetails.main" + e);
			} 
		}
	}

}
