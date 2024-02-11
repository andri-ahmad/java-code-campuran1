package util;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
/*
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
*/
import amdocs.amsp.exception.AmspServiceException;

/**
 * @author JVANHOOF
 * Handles printing to the screen, print file or console based on output mode
 */

public class PrintOutput {
//	public Display display = new Display();
//	public Shell shell = new Shell(display);
//	
//	private Text textToDisplay = new Text(shell, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL |  SWT.H_SCROLL | SWT.WRAP);
//	private PrintWriter txtWriter = null;
	private PrintWriter xmlWriter = null;
	private String txtFileName = null;
	private String xmlFileName = null;
	
	// must be called before use
	public void initOutput(Parameters apiParams, PrintOutput printOutput){
		
	}
	
	public void finishOutput (Parameters apiParams, PrintOutput printOutput){
		// check for sending output to print files
	}
	
	public String[] getFileNames() {
		final String[] fileNames = {txtFileName, xmlFileName};
		
		return (fileNames);
	}
	
	public void printToShell (Parameters apiParams, String txtIn, String xmlIn) {
	    System.out.println(txtIn);
	}
	
	public void printExceptionToShell (Parameters apiParams, String offendingClass, AmspServiceException e) {
            StackTraceElement elements[] = e.getStackTrace();
            
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
            
            /*switch (apiParams.getOutputMode()) { // 0 = console only, 1 = screen only, 2 = screen and print files, 3 = tool messages only
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
            }*/
        
        }
	
	public void printNullPointerExceptionToShell (Parameters apiParams, String offendingClass, NullPointerException  e) {
	}
		
	public void printToToolShell (Parameters apiParams, String txtIn) {
	}
	
	private void openFileFromExplorer(String fileName) {    
		try {
			Runtime.getRuntime().exec("notepad " +  fileName);
		} catch (IOException e) {
			System.out.println("Java IO Exception: " + e.getMessage());
		}
	}
}
