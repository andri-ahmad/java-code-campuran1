package server1;

import java.net.*;
import java.lang.*;
import java.io.*;

import javax.sound.sampled.Port;

public class Server{

//port number should be more than 1024

public static final int PORT = 1025;
         
public static void main( String args[])
{
 ServerSocket sersock = null;
 Socket sock = null;
 System.out.println(" Wait !! ");

     try
     {
      //  Initialising the ServerSocket
      sersock =  new ServerSocket(PORT);
                    
      // Gives the Server Details Machine name, Port number
    
      System.out.println("Server Started  :"+sersock);
    
            try
          {
                                
           // makes a socket connection to particular client after 
           // which two way communication take place
        
           sock = sersock.accept();
        
           System.out.println("Client Connected  :"+ sock);
        
           // Receive message from client i.e Request from client
        
           DataInputStream ins = new                 
           DataInputStream(sock.getInputStream());
           // Send message to the client i.e Response
        
           PrintStream ios = new PrintStream(sock.getOutputStream());
           ios.println("Hello from server");
           ios.close();
        
           // Close the Socket connection 
                
            sock.close();
        
            }
            catch(SocketException se)
            {
        System.out.println("Server Socketproblem  "+se.getMessage());
        }
     }
	catch(Exception e)
	{
        System.out.println("Couldn't start "               + e.getMessage()) ;     
    }               
                        
 // Usage of some methods in Socket class

  System.out.println(" Connection from :  " +   sock.getInetAddress());
                
 } // main 
        
}  // Server class
