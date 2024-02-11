package util;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;


import amdocs.amsp.exception.AmspServiceException;

/**
 * @author JVANHOOF
 * Handles printing to the screen, print file or console based on output mode
 */

public class PrintOutput {
	public Display display = new Display();
	public Shell shell = new Shell(display);
	
	private Text textToDisplay = new Text(shell, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL |  SWT.H_SCROLL | SWT.WRAP);
	private PrintWriter txtWriter = null;
	private PrintWriter xmlWriter = null;
	private String txtFileName = null;
	private String xmlFileName = null;
	
	// must be called before use
	public void initOutput(Parameters apiParams, PrintOutput printOutput){
		
		// screen init
		switch (apiParams.getOutputMode()) { // 0 = console only, 1 = screen only, 2 = screen and print files, 3 = tool messages only
		case 0:
			// do nothing
			break;
		case 1:
		case 2:
		case 3:
			shell.setBounds(10,10,800,600);
			Display.setAppName(apiParams.getAppName() + " V " + apiParams.getAppVersion() + " AMSP V " + apiParams.getAmspVersion());
			shell.setText(Display.getAppName()); // Window title
			
			textToDisplay.setBounds(10,10,750,550);
			textToDisplay.setEditable(true);
			textToDisplay.setFont(new Font(shell.getDisplay(), "Courier New", 10, SWT.NORMAL));
		    
			shell.pack(); // Set to preferred size
			shell.open();
			
			if (apiParams.getOutputMode() == 2) { // 0 = console only, 1 = screen only, 2 = screen and print files, 3 = tool messages only
				// print file init
				try {
					java.util.Date date = new java.util.Date();
					Timestamp timeStamp = new Timestamp(date.getTime());
					String prefix = new SimpleDateFormat("MMddyyyymmss_").format(timeStamp);
					txtFileName = apiParams.getFilePath() + prefix + apiParams.getFileName() + ".txt";
					xmlFileName = apiParams.getFilePath() + prefix + apiParams.getFileName() + ".xml";
					
					txtWriter = new PrintWriter(txtFileName);
					xmlWriter = new PrintWriter(xmlFileName);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			break;
		}
	}
	
	public void finishOutput (Parameters apiParams, PrintOutput printOutput){
		// check for sending output to print files
		if (apiParams.getOutputMode() == 2) { // 0 = console only, 1 = screen only, 2 = screen and print files, 3 = tool messages only
			
			printToShell(apiParams, "", null);
			
			// close the text files
			this.txtWriter.close();
			this.xmlWriter.close();
			
			// establish an invisible JFrame for options dialog
			final JFrame frame = new JFrame("FrameDemo");
			final int result;
			frame.setLocationRelativeTo(null);
			frame.pack();
			frame.setVisible(false);
	
			//Custom button text
			Object[] options = {"Open Text File",
			                    "Open XML File",
			                    "Open Both Files",
			                    "Open No Files"};
			
			result = JOptionPane.showOptionDialog(frame,
			    "Output Files",
			    "Choose Action",
			    JOptionPane.YES_NO_CANCEL_OPTION,
			    JOptionPane.QUESTION_MESSAGE,
			    null,
			    options,
			    options[3]);
			
			switch (result) {
				case 0: {
					openFileFromExplorer(txtFileName);
					break;
				}
				case 1: {
					openFileFromExplorer(xmlFileName);
					break;
				}
				
				case 2: {
					openFileFromExplorer(txtFileName);
					openFileFromExplorer(xmlFileName);
					break;
				}
			}
			frame.dispose();
		}
		if (apiParams.getOutputMode() > 1) {
			printOutput.display.dispose();
		}
	}
	
	public String[] getFileNames() {
		final String[] fileNames = {txtFileName, xmlFileName};
		
		return (fileNames);
	}
	
	public void printToShell (Parameters apiParams, String txtIn, String xmlIn) {
		
		switch (apiParams.getOutputMode()) { // 0 = console only, 1 = screen only, 2 = screen and print files, 3 = tool messages only
		case 0:
			System.out.println(txtIn);
			break;
		case 1:
			textToDisplay.append(txtIn + "\n");
			break;
		case 2:
			textToDisplay.append(txtIn + "\n");
			txtWriter.println(txtIn);
			
			if (xmlIn != null) {
				xmlWriter.println(xmlIn);
			}
			break;
		}
	}
	
	public void printExceptionToShell (Parameters apiParams, String offendingClass, AmspServiceException e) {
		StackTraceElement elements[] = e.getStackTrace();
		
		switch (apiParams.getOutputMode()) { // 0 = console only, 1 = screen only, 2 = screen and print files, 3 = tool messages only
		case 0:

			System.out.println(offendingClass + "<AmspServiceException>\n" +
					 "   <msgID>"        + e.getMsgId()            + "</msgId>\n" +
					 "   <localizedMsg>" + e.getLocalizedMessage() + "</localizedMsg>\n" + 
					 "   <msgValue>"     + e.getMessage()          + "</msgValue>\n" +
					 "   <cause>"        + e.getCause()            + "</cause>\n" +
					 "</AmspServiceException>" + "\n"              +
					 "<StackTrace>\n");
			for (int i = 0, n = elements.length; i < n; i++) {       
				System.out.println("   " + elements[i].getFileName()
		            + ":" + elements[i].getLineNumber() 
		            + ">> "
		            + elements[i].getMethodName() + "()\n");
		    }
			System.out.println("</StaceTrace>\n");
			break;
		case 1:
			textToDisplay.append(offendingClass + "<AmspServiceException>\n" +
					 "   <msgID>"        + e.getMsgId()            + "</msgId>\n" +
					 "   <localizedMsg>" + e.getLocalizedMessage() + "</localizedMsg>\n" + 
					 "   <msgValue>"     + e.getMessage()          + "</msgValue>\n" +
					 "   <cause>"        + e.getCause()            + "</cause>\n" +
					 "</AmspServiceException>" + "\n"              +
					 "<StackTrace>\n");
			for (int i = 0, n = elements.length; i < n; i++) {       
				textToDisplay.append("   " + elements[i].getFileName()
		            + ":" + elements[i].getLineNumber() 
		            + ">> "
		            + elements[i].getMethodName() + "()\n");
		    }
			textToDisplay.append("</StaceTrace>\n");
			break;
		case 2:
			textToDisplay.append(offendingClass + "<AmspServiceException>\n" +
					 "   <msgID>"        + e.getMsgId()            + "</msgId>\n" +
					 "   <localizedMsg>" + e.getLocalizedMessage() + "</localizedMsg>\n" + 
					 "   <msgValue>"     + e.getMessage()          + "</msgValue>\n" +
					 "   <cause>"        + e.getCause()            + "</cause>\n" +
					 "</AmspServiceException>" + "\n"              +
					 "<StackTrace>\n");
			for (int i = 0, n = elements.length; i < n; i++) {       
				textToDisplay.append("   " + elements[i].getFileName()
		            + ":" + elements[i].getLineNumber() 
		            + ">> "
		            + elements[i].getMethodName() + "()\n");
		    }
			textToDisplay.append("</StaceTrace>\n");
			
			txtWriter.println(offendingClass + "<AmspServiceException>\n" +
					 "   <msgID>"        + e.getMsgId()            + "</msgId>\n" +
					 "   <localizedMsg>" + e.getLocalizedMessage() + "</localizedMsg>\n" + 
					 "   <msgValue>"     + e.getMessage()          + "</msgValue>\n" +
					 "   <cause>"        + e.getCause()            + "</cause>\n" +
					 "</AmspServiceException>" + "\n"              +
					 "<StackTrace>\n");
			for (int i = 0, n = elements.length; i < n; i++) {       
				txtWriter.println("   " + elements[i].getFileName()
		            + ":" + elements[i].getLineNumber() 
		            + ">> "
		            + elements[i].getMethodName() + "()\n");
		    }
			txtWriter.println("</StaceTrace>\n");
			break;
		}
	}
	
	public void printNullPointerExceptionToShell (Parameters apiParams, String offendingClass, NullPointerException  e) {
		StackTraceElement elements[] = e.getStackTrace();
		
		switch (apiParams.getOutputMode()) { // 0 = console only, 1 = screen only, 2 = screen and print files, 3 = tool messages only
		case 0:

			System.out.println(offendingClass + "EJB layer: <JavaNullpointerException>\n" +
			         " <Message>" + e.getMessage() + " </Message>" +
			         " <Cause>" + e.getCause() + " </Cause>" +
			         " <Class>" + e.getClass() + " </Class>" +
					 " </JavaNullpointerException>" + "\n"              +
					 " <StackTrace>" + e.getStackTrace() + " </StackTrace>" +
					 " <StackTrace>\n");
			break;
		case 1:
			textToDisplay.append(offendingClass + "<JavaNullpointerException>\n" +
					" <Message>" + e.getMessage() + " </Message>" +
			         " <Cause>" + e.getCause() + " </Cause>" +
			         " <Class>" + e.getClass() + " </Class>" +
					 " </JavaNullpointerException>" + "\n"              +
					 " <StackTrace>" + e.getStackTrace() + " </StackTrace>" +
					 " <StackTrace>\n");
			for (int i = 0, n = elements.length; i < n; i++) {       
				textToDisplay.append("   " + elements[i].getFileName()
		            + ":" + elements[i].getLineNumber() 
		            + ">> "
		            + elements[i].getMethodName() + "()\n");
		    }
			textToDisplay.append("</StaceTrace>\n");
			break;
		case 2:
			textToDisplay.append(offendingClass + "<JavaNullpointerException>\n" +
					" <Message>" + e.getMessage() + " </Message>" +
			         " <Cause>" + e.getCause() + " </Cause>" +
			         " <Class>" + e.getClass() + " </Class>" +
					 " </JavaNullpointerException>" + "\n"              +
					 " <StackTrace>" + e.getStackTrace() + " </StackTrace>" +
					 " <StackTrace>\n");
			for (int i = 0, n = elements.length; i < n; i++) {       
				textToDisplay.append("   " + elements[i].getFileName()
		            + ":" + elements[i].getLineNumber() 
		            + ">> "
		            + elements[i].getMethodName() + "()\n");
		    }
			textToDisplay.append("</StaceTrace>\n");
			
			txtWriter.println(offendingClass + "<JavaNullpointerException>\n" +
					" <Message>" + e.getMessage() + " </Message>" +
			         " <Cause>" + e.getCause() + " </Cause>" +
			         " <Class>" + e.getClass() + " </Class>" +
					 " </JavaNullpointerException>" + "\n"              +
					 " <StackTrace>" + e.getStackTrace() + " </StackTrace>" +
					 " <StackTrace>\n");
			for (int i = 0, n = elements.length; i < n; i++) {       
				txtWriter.println("   " + elements[i].getFileName()
		            + ":" + elements[i].getLineNumber() 
		            + ">> "
		            + elements[i].getMethodName() + "()\n");
		    }
			txtWriter.println("</StaceTrace>\n");
			break;
		}
	}
		
	public void printToToolShell (Parameters apiParams, String txtIn) {
		if (apiParams.getOutputMode() == 3) {
			textToDisplay.append(txtIn + "\n");
		}
	}
	
	private void openFileFromExplorer(String fileName) {    
		try {
			Runtime.getRuntime().exec("notepad " +  fileName);
		} catch (IOException e) {
			System.out.println("Java IO Exception: " + e.getMessage());
		}
	}
}
