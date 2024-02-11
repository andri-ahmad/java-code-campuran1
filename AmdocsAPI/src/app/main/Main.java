package app.main;

// local classes
import util.Lock;
import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.Configuration;
import amdocs.amsp.valueobject.accountviewledger.LedgerSummaryVO;
import amdocs.amsp.valueobject.accountviewstatement.StatementDateVO;
import app.get.GetLedgerSummaryVO_Test;
import app.get.GetStatementDateVO_Test;

/**
 * @author JVANHOOF
 *  Driver class for API Testing. Minor additions and changes should be made here
 *  to access the target test class(es)
 */
public class Main {	

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		Configuration.appName = Configuration.AMSP_API_APP_NAME;

		// variables
		boolean session;			// login session flag
		
		// locking flags
		boolean APC_lock   = false;
		boolean siteLock   = false;
		boolean acctLock   = false;
		boolean varLock    = false;
		
		// create utility objects
		Login login             = new Login();
		PrintOutput printOutput = new PrintOutput();
		Parameters apiParams    = new Parameters();
		
		// initialize utility objects
		printOutput.initOutput(apiParams, printOutput);
		apiParams.initParameters(Parameters.TEMP_OPERATION, apiParams, printOutput);
		
		// API test objects - add/expose current test objects
		GetStatementDateVO_Test getStatementDateVO_Test = new GetStatementDateVO_Test();
		StatementDateVO[] statementDateVOarr = null;
		GetLedgerSummaryVO_Test getLedgerSummaryVO_Test = new GetLedgerSummaryVO_Test();
		LedgerSummaryVO[] ledgerSummaryVOarr = null;
			
		// attempt login
		session = login.logInOut(Login.LOGIN, apiParams, printOutput);
		
		// operation
		if (session){
			// lock - expose whichever lock types are needed for operation
			Lock lock = new Lock();
			APC_lock  = lock.checkAPC_lock(apiParams, login, printOutput);
			//acctLock  = lock.lockIt(Lock.LOCK, Lock.ACCOUNT,  apiParams, login.getTicket(), printOutput);
			//siteLock  = lock.lockIt(Lock.LOCK, Lock.SITE,     apiParams, login.getTicket(), printOutput);
			//varLock   = lock.lockIt(Lock.LOCK, Lock.VARIABLE, apiParams, login.getTicket(), printOutput);
			
			// Get, set and update data
			if (!APC_lock){
				statementDateVOarr = getStatementDateVO_Test.getAvailableStatements(apiParams, login, printOutput);
				apiParams.setStatementDate(apiParams, printOutput, statementDateVOarr[0].getStmtDate());
				printOutput.printToShell (apiParams, "Parameter:statementDate updated to: " + statementDateVOarr[0].getStmtDate(), null);
				if (statementDateVOarr[0].getIsPredicted()) {
					ledgerSummaryVOarr = getLedgerSummaryVO_Test.getSummaryLedger(apiParams, login, printOutput);
				}
			}
					
			// always unlock all
	 		if (acctLock || siteLock || varLock){lock.lockIt(Lock.UNLOCK, Lock.ALL, apiParams, login.getTicket(), printOutput);}
	 		
			// logout
	 		login.logInOut(Login.LOGOUT, apiParams, printOutput);
	 			
	 		printOutput.printToShell(apiParams, "\nClose this window to end session", null);
		}
		
		// finish logging and cleanup display and print file
		apiParams.finishOutput(apiParams, printOutput);
		printOutput.finishOutput(apiParams, printOutput);
		
		// hold here until user closes output window
		while (!printOutput.shell.isDisposed()) {
			if (!printOutput.display.readAndDispatch()) printOutput.display.sleep(); 
		}
	} // end of main
} // end of class Main
