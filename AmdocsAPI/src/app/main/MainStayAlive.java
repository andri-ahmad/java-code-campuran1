package app.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.Configuration;

public class MainStayAlive {
	private static int cnt = 0;
	
	public static void main(String[] args) {
		
		Configuration.appName = Configuration.AMSP_API_APP_NAME;
	
		// variables
		boolean session = false;			// login session flag
		
		// create utility objects
		final Login login             = new Login();
		final PrintOutput printOutput = new PrintOutput();
		final Parameters apiParams    = new Parameters();
		
		// initialize utility objects
		printOutput.initOutput(apiParams, printOutput);
		apiParams.initParameters(Parameters.STAY_ALIVE, apiParams, printOutput);
		
		// login
		session = login.logInOut(Login.LOGIN, apiParams, printOutput);
		
		if (session) {
			try {
				ActionListener actListner = new ActionListener() {

					 @Override

					 public void actionPerformed(ActionEvent event) {

					    if ((cnt += 1) >= 10) {
					    	 //lock.checkAPC_lock(apiParams, login, printOutput);
					    	 cnt = 0;
					     }
					    
					     System.out.println("Counter = " + cnt);
					     //printOutput.printToShell(apiParams, "Counter = " + cnt, null);
					 }
					   };

					   Timer timer = new Timer(5000, actListner);

					   timer.start();
			} catch (Exception e) {
				e.printStackTrace();
				login.logInOut(Login.LOGOUT, apiParams, printOutput);
			}
		}
		 

		/*if (session){
			login.logInOut(Login.LOGOUT, apiParams, printOutput);
		}*/
		
		//cleanup display and print file
		apiParams.finishOutput(apiParams, printOutput);
		printOutput.finishOutput(apiParams, printOutput);
		
		while (!printOutput.shell.isDisposed()) {
			if (!printOutput.display.readAndDispatch()) printOutput.display.sleep(); 
		}
	}
}
