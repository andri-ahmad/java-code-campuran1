package clienttester;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.*;
import java.io.*;

import java.math.BigInteger;

public class ClientGreetings {
    @SuppressWarnings("oracle.jdeveloper.java.nested-assignment")
    public ClientGreetings(String[] args) {
        super();
    
          //String serverName = "Localhost";
          String serverName = "10.10.2.150";
                    
          int port = 8000;
          try {
             System.out.println("Connecting to " + serverName + " on port " + port);
             Socket client = new Socket(serverName, port);
             
             System.out.println("Just connected to " + client.getRemoteSocketAddress());
             
             OutputStream outToServer = client.getOutputStream();
             System.out.println("Output stream get From Server..");
                    
             DataOutputStream out = new DataOutputStream(outToServer);
              System.out.println("Output stream created from local to server..");
             
             System.out.println("Try to communicate to with localsocket : " + client.getLocalSocketAddress());
             
             
              System.out.println("Try writing to the stream..");
              try {
                  
                  // 1.Message Header // 1.1 Session ID, 2 Byte, maksium 65536, int 
                  int sessionId = 12123;
                  String sessionHex = Integer.toHexString(sessionId);
                  System.out.println("Session ID = " + sessionId);
                  System.out.println("Session ID Hex Format = " + sessionHex.toUpperCase());
                  
                  byte[] sessionid_bytes = hex2Byte(sessionHex);                
                  System.out.println("Session ID parameter, Length : " + sessionid_bytes.length + " " + 
                                     sessionHex.toString());
                  
                  for (int i=0; i < sessionid_bytes.length; i++) {
                      System.out.println(i+"." +sessionid_bytes[i]);    
                  }     
                  
                  System.out.println("");
                  

                  // 1.Message Header   // 1.2 CAS_VER, 1 Byte, maksium 256, short 
                  short CAS_VER = 2;
                  String CAS_VERHex = Integer.toHexString(CAS_VER);
                  System.out.println("CAS_VER = " + CAS_VER);
                  System.out.println("CAS_VER Hex Format = " + CAS_VERHex.toUpperCase());
                  
                  byte[] CAS_VER_bytes = new byte[1];
                  CAS_VER_bytes[0] = 2;
                  System.out.println("CAS_VERSION parameter, length : " + CAS_VER_bytes.length + " " + 
                                     CAS_VER_bytes.toString());
                  
                  for (int i=0; i < CAS_VER_bytes.length; i++) {
                      System.out.println(i+"." +CAS_VER_bytes[i]);    
                  } 
                  
                  System.out.println("");
                  

                  // 1.Message Header   // 1.3 command type, 1 Byte, maksium 256, short 
                  short commandType = 33;
                  String commandTypeHex = Integer.toHexString(commandType);
                  System.out.println("commandType = " + commandType);
                  System.out.println("commandType Hex Format = " + commandTypeHex.toUpperCase());
                  
                  byte[] commandTypeBytes = hex2Byte(commandTypeHex);                
                  System.out.println("commandTypeBytes parameter, Length : " + commandTypeBytes.length + " " + 
                                     commandTypeBytes.toString());
                  
                  for (int i=0; i < commandTypeBytes.length; i++) {
                      System.out.println(i+"." +commandTypeBytes[i]);    
                  }

                  
                  System.out.println("");
                  
                  
                  // 1.Message Header  // 1.4 Data length, 2 Byte, maksium 256, short 
                  int data_length = 12123;
                  String data_length_hex = Integer.toHexString(data_length);
                  System.out.println("data_length = " + data_length);
                  System.out.println("data_length Hex Format = " + data_length_hex);
                  
                  byte[] data_length_bytes = new byte[2];               
                  data_length_bytes[0] = 0;
                  data_length_bytes[1] = 9;               
                  System.out.println("data_length_bytes parameter, Length : " + data_length_bytes.length + " " + 
                                     data_length_bytes.toString());
                  
                  for (int i=0; i < data_length_bytes.length; i++) {
                      System.out.println(i+"." +data_length_bytes[i]);    
                  }
                  
                  
                  System.out.println("");
                  
                  // 1.Message Header  // 1.5 Data Body, Dinamis depend on 4, maksium 256, short 
                        
                  
                  
                  //2. data body, 1 adalah card number
                  BigInteger cardNumberbi = new BigInteger ("69590896");
                  long cardNumberlong = cardNumberbi.longValue();
                  String cardNumberHex = Long.toHexString(cardNumberlong);
                  System.out.println("Card Number = " + cardNumberbi);
                  System.out.println("Card Number Hex Format = " + cardNumberHex);
                  
                  if (cardNumberHex.length() == 7) {cardNumberHex = "0"+cardNumberHex;}
                  if (cardNumberHex.length() == 6) {cardNumberHex = "00"+cardNumberHex;}
                  if (cardNumberHex.length() == 5) {cardNumberHex = "000"+cardNumberHex;}
                  if (cardNumberHex.length() == 4) {cardNumberHex = "0000"+cardNumberHex;}
                  if (cardNumberHex.length() == 3) {cardNumberHex = "00000"+cardNumberHex;}
                  if (cardNumberHex.length() == 2) {cardNumberHex = "000000"+cardNumberHex;}
                  if (cardNumberHex.length() == 1) {cardNumberHex = "0000000"+cardNumberHex;}
                  
                  byte[] cardNumberBytes_Conf = hex2Byte(cardNumberHex);
                                    
                  System.out.println("Card Number parameter, Length : " + cardNumberBytes_Conf.length + " " + 
                                     cardNumberBytes_Conf.toString());
                  
                      for (int i=0; i < cardNumberBytes_Conf.length; i++) {
                          System.out.println(i+"." +cardNumberBytes_Conf[i]);    
                      }
                      
                                        
                  //2. data body, 2 adalah date
                  int unixTime = (int)(System.currentTimeMillis() / 1000);
                  int unixTime2 = 86400 + unixTime;
                  byte[] productionDate = new byte[]{
                          (byte) (unixTime2 >> 24),
                          (byte) (unixTime2 >> 16),
                          (byte) (unixTime2 >> 8),
                          (byte) unixTime2

                  };
                  System.out.println("Date time.., length : " + productionDate.length + " " + 
                                     productionDate.toString());
                  
                  for (int i=0; i < productionDate.length; i++) {
                          System.out.println(i+"." +productionDate[i]);    
                  }
                  
                  //2. data body, 3 is send variable.
                  short is_send = 1;
                  String is_sendHex = Integer.toHexString(is_send);
                  System.out.println("is_send = " + is_send);
                  System.out.println("is_send Hex Format = " + is_sendHex.toUpperCase());
                  
                  byte[] is_sendBytes = new byte[1];
                  is_sendBytes[0]= 1;
                  System.out.println("is_sendBytes parameter, Length : " + is_sendBytes.length + " " + 
                                     is_sendBytes.toString());
                  
                  for (int i=0; i < is_sendBytes.length; i++) {
                      System.out.println(i+"." +is_sendBytes[i]);    
                  } 
                  
                  System.out.println("");
                  
                  
                  
                  ByteArrayOutputStream baos = new ByteArrayOutputStream();
                  
                      baos.write(sessionid_bytes);
                      baos.write(CAS_VER_bytes);
                      baos.write(commandTypeBytes);
                      baos.write(data_length_bytes);
                      baos.write(cardNumberBytes_Conf);
                      baos.write(productionDate);
                      baos.write(is_sendBytes);
                      
                      byte[] finalMessage = baos.toByteArray();
                  
                    System.out.println("finalMessage parameter, with Length : " + finalMessage.length + " " + 
                                       finalMessage.toString());
                  
                  String finalMessageHexa = byte2hex(finalMessage);
                    System.out.println("Messange sent to CAS : " + "0x"+finalMessageHexa.toUpperCase());
                  
                    /*
                    for (int i=0; i < finalMessage.length; i++) {
                        System.out.println(i+"." +finalMessage[i]  );    
                    } 
                    */
                    
                    System.out.println("");
 

                   out.write(finalMessage);
                  
                  
                  System.out.println("Message sent to CAS");
                  
              } catch (IOException e) {

                  System.out.println("Writing failure,  Exception from server : ");
                  e.printStackTrace();
              }
              

                          
             
             
             InputStream inFromServer = client.getInputStream();
              System.out.println("Input stream get From Server..");
              
             DataInputStream in = new DataInputStream(inFromServer);
              System.out.println("Input stream created..");
              
              System.out.println("Reading input streaam....");
              
              try {
                  
                  /*
                  // 4 Byte pertama adalah RESULT
                  byte[] msgResult = new byte[4];
                  //in.read();
                  msgResult[0] = in.readByte();
                  //in.read();
                  msgResult[1] = in.readByte();
                  //in.read();
                  msgResult[2] = in.readByte();
                  //in.read();
                  msgResult[3] = in.readByte();
                  
                  byte[] msgResult2 = new byte[1];
                  //in.read();
                  msgResult2[0] = in.readByte();
                  
                  
                  String resultHexa = byte2hex(msgResult);
                  System.out.println("Result : " + "0x"+resultHexa.toUpperCase());
                                        
                  String resultHexa2 = byte2hex(msgResult2);
                  System.out.println("Emm_Count : " + "0x"+resultHexa2.toUpperCase());
                  */  
                  
                 
                  /*
                  while (in.read(result) != -1) {
                      //in.read(result);
                      System.out.println("  Server said : " + in.readByte());  
                  }
*/
                  
                  byte[] BufferMsg = new byte[11];   // 1Kb

                  in.read(BufferMsg);
                  System.out.println("Server response , LENGTH " + BufferMsg.length  + 
                                     ", Mesage = " +  "0x"+byte2hex(BufferMsg).toUpperCase() );
                  
                  /*
                  for (int i=0; i < BufferMsg.length; i++) {
                      System.out.println(i+"." +BufferMsg[i]  );    
                  }
*/
                  
                  
                  
                  
                  
                  
                  
                  in.close();
                  
                       
              } catch (IOException e2) {
                  System.out.println("Reading Failure, Exception from server : ");
                  e2.printStackTrace();
              }
             
            System.out.println("Closing stream..");
             
             client.close();
              
              System.out.println("Closed");
              
          } catch (IOException e) {
              System.out.println("Exception from server : ");
             e.printStackTrace();
          }
        
    }

    public static void main(String[] args) {
        ClientGreetings clientGreetings = new ClientGreetings(args);
    }
    
    public static byte[] hex2Byte(String str)
        {
           byte[] bytes = new byte[str.length() / 2];
           for (int i = 0; i < bytes.length; i++)
           {
              bytes[i] = (byte) Integer
                    .parseInt(str.substring(2 * i, 2 * i + 2), 16);
           }
           return bytes;
        }
    
    public static String byte2hex(byte[] b)
        {

         // String Buffer can be used instead

           String hs = "";
           String stmp = "";

           for (int n = 0; n < b.length; n++)
           {
              stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));

              if (stmp.length() == 1)
              {
                 hs = hs + "0" + stmp;
              }
              else
              {
                 hs = hs + stmp;
              }

              if (n < b.length - 1)
              {
                 hs = hs + "";
              }
           }

           return hs;
        }
    
    public static void reverse(byte[] array) {
          if (array == null) {
              return;
          }
          int i = 0;
          int j = array.length - 1;
          byte tmp;
          while (j > i) {
              tmp = array[j];
              array[j] = array[i];
              array[i] = tmp;
              j--;
              i++;
          }
      }
}
