package util;

import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.FrameworkConstantsI;
import amdocs.amsp.services.LockServiceFacade;
import amdocs.amsp.valueobject.lockservice.LockOutputVO;
import util.Login;

/**
 * @author JVANHOOF
 * performs all lock and unlock operations for all lock types
 */
public class Lock {
	// constants
	public static int LOCK         = 0;
	public static int UNLOCK       = 1;
	public static int SITE         = 2;
	public static int ACCOUNT      = 3;
	public static int VARIABLE     = 4;
	public static int TECH         = 5;
	public static int PHONE_NUMBER = 6;
	public static int ALL          = 20;
	
	// flags
	private boolean apcLock          = false;
	private boolean siteLock         = false;
	private boolean acctLock         = false;
	private boolean varLock          = false;
	private boolean techLock         = false;
	private boolean phoneNumberLock  = false;
	
	// objects
	private LockServiceFacade lockServiceFacade = new LockServiceFacade();
	private LockOutputVO lockOutputVO = new LockOutputVO();
	
	public boolean lockIt (int action, int type, Parameters apiParams, String ticket, PrintOutput printOutput)
	{
		try
		{
			switch (action) {
				// lock
				case 0: {
					switch (type) {
						// Site lock
						case 2: {
							lockOutputVO = lockServiceFacade.getSiteLock(apiParams.getsiteId(), 
																	     FrameworkConstantsI.LockMode.RETURN_ONLY.getLockModeValue(),
																	     apiParams.getCorp(), 
																	     ticket);
							printOutput.printToShell(apiParams, "Site Lock Message: " + lockOutputVO.getMessage(), null);
							
							if (lockOutputVO.getStatus()){siteLock = true;}
							else {siteLock = false;}
							
							return (siteLock);
						}
						// Account lock
						case 3: {
							lockOutputVO = lockServiceFacade.getAccountLock(apiParams.getCust_acct(), 
																	        FrameworkConstantsI.LockMode.RETURN_ONLY.getLockModeValue(), 
																	        apiParams.getCorp(), 
																	        ticket);
							printOutput.printToShell(apiParams, "Account Lock Message: " + lockOutputVO.getMessage(), null);
							
							if (lockOutputVO.getStatus()){acctLock = true;}
							else {acctLock = false;}
							
							return (acctLock);

						}
						// Variable lock
						case 4: {
							lockOutputVO = lockServiceFacade.getApcVarLock(apiParams.getsiteId(), 
									                                       apiParams.getCust_acct(), 
									                                       apiParams.getCorp(), 
									                                       ticket);
							printOutput.printToShell(apiParams, "Variable Lock Message: " + lockOutputVO.getMessage(), null);
							
							if (lockOutputVO.getStatus()){varLock = true;}
							else {varLock = false;}
							
							return (varLock);
						}
						// Tech lock
						case 5: {
							lockOutputVO = lockServiceFacade.getCdwTechLock(FrameworkConstantsI.LockMode.RETURN_ONLY.getLockModeValue(),
									                                        apiParams.getCdwDate(), 
									                                        apiParams.getTechId(), 
									                                        apiParams.getCorp(), 
									                                        ticket);
							
							printOutput.printToShell(apiParams, "Tech Lock Message: " + lockOutputVO.getMessage(), null);
							
							if (lockOutputVO.getStatus()){techLock = true;}
							else {techLock = false;}
							
							return (techLock);
						}
						// Phone Number lock
						case 6: {
							lockOutputVO = lockServiceFacade.getPhoneNumberLock(apiParams.getPhoneNumber(), 
																				FrameworkConstantsI.LockMode.RETURN_ONLY.getLockModeValue(),
																				apiParams.getCorp(), 
																				ticket);
							
							printOutput.printToShell(apiParams, "Phone Number Lock Message: " + lockOutputVO.getMessage(), null);
							
							if (lockOutputVO.getStatus()){phoneNumberLock = true;}
							else {phoneNumberLock = false;}
							
							return (phoneNumberLock);
						}
						// protection
						default: {
							printOutput.printToShell(apiParams, "Lock:lockIt:Unknown value passed", null);
							return (false);
						}
					} // end of switch on type
				} // end of case LOCK
				
				// unlock
				case 1: {
					
					if (siteLock){
						lockOutputVO = lockServiceFacade.unLockSite(apiParams.getsiteId(), apiParams.getCorp(), ticket);
						
						printOutput.printToShell(apiParams, "Site unlock message: " + lockOutputVO.getMessage(), null);
						
						if (lockOutputVO.getStatus()){
							siteLock = false;
						}
					}
					
					if (acctLock){
						lockOutputVO = lockServiceFacade.unLockAccount(apiParams.getCust_acct(), apiParams.getCorp(), ticket);
						//lockOutputVO = lockServiceFacade.unLockAccountNewTrans(apiParams.getCust_acct(), apiParams.getCorp(), "Supported", ticket);
						
						printOutput.printToShell(apiParams, "Account unlock message: " + lockOutputVO.getMessage(), null);
						
						if (lockOutputVO.getStatus()){
							acctLock = false;
						}
					}
					
					if (varLock){
						lockOutputVO = lockServiceFacade.unLockApcVarLock(apiParams.getsiteId(), apiParams.getCust_acct(), apiParams.getCorp(), ticket);
						
						printOutput.printToShell(apiParams, "Variable unlock message: " + lockOutputVO.getMessage(), null);
						
						if (lockOutputVO.getStatus()){
							varLock = false;
						}
					}
					
					if (techLock){
						lockOutputVO = lockServiceFacade.unLockCdwTech(apiParams.getCdwDate(), 
								                                       apiParams.getTechId(), 
								                                       "0", // If value is set as "0", then all the TECH,CDW locked by combo of JSESSION and OPRID would be unlocked.
								                                       apiParams.getCorp(), 
								                                       ticket);
						
						printOutput.printToShell(apiParams, "Tech unlock message: " + lockOutputVO.getMessage(), null);
						
						if (lockOutputVO.getStatus()){
							techLock = false;
						}
					}
					
					if (phoneNumberLock){
						lockOutputVO = lockServiceFacade.unlockPhoneNumber(apiParams.getPhoneNumber(), 
								                                           apiParams.getCorp(), 
								                                           ticket);
						
						printOutput.printToShell(apiParams, "Phone Number unlock message: " + lockOutputVO.getMessage(), null);
						
						if (lockOutputVO.getStatus()){
							phoneNumberLock = false;
						}
					}
					
					if (siteLock || acctLock || varLock || techLock || phoneNumberLock) {return false;}
					else {return true;}
					
				} // end of UNLOCK
				
				default: {
					printOutput.printToShell(apiParams, "Lock: Unknown value passed", null);
					return (false);
				}
				
			} // end of switch on action
		}
		catch (AmspServiceException e) {
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		} 
 		catch (RuntimeException e) {
				e.printStackTrace();
		}
		return (false);
	} // end of lockIt method
	
	public boolean checkAPC_lock (Parameters apiParams, Login login, PrintOutput printOutput) {
		
		try
		{
			lockOutputVO = lockServiceFacade.checkApcLock(apiParams.getCorp(), login.getTicket());
		} catch (AmspServiceException e) 	{
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
			
			this.lockIt(UNLOCK, ALL, apiParams, login.getTicket(), printOutput);
			login.logInOut(Login.LOGOUT, apiParams, printOutput);
			printOutput.finishOutput(apiParams, printOutput);
		}
		
		printOutput.printToShell(apiParams, "APC Lock Message: " + lockOutputVO.getMessage(), null);
		
		apcLock = lockOutputVO.getStatus();
		
		return (apcLock);
	}
	
	public boolean unlockAccount (Parameters apiParams, Login login, PrintOutput printOutput) {
		try
		{
			lockOutputVO = lockServiceFacade.unLockAccount(apiParams.getCust_acct(), apiParams.getCorp(), login.getTicket());
		} catch (AmspServiceException e) 	{
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
			this.lockIt(UNLOCK, ALL, apiParams, login.getTicket(), printOutput);
			login.logInOut(Login.LOGOUT, apiParams, printOutput);
			printOutput.finishOutput(apiParams, printOutput);
		}
		
		printOutput.printToShell(apiParams, "<lockOutputVO>" + lockOutputVO.toString() + "</lockOutputVO>", null);
		return true;
	}
	
	public boolean getApcLock()         {return (apcLock);}
	public boolean getSiteLock()        {return (siteLock);}
	public boolean getAcctLock()        {return (acctLock);}
	public boolean getVarLock()         {return (varLock);}
	public boolean getTechLock()        {return (techLock);}
	public boolean getPhoneNumberLock() {return (phoneNumberLock);}
	
} // end of Lock class
