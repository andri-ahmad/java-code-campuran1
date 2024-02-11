package testnetwork1;

import java.net.*;
import java.io.*;

import java.math.BigInteger;



public class Class1 {
    public Class1() {
        super();
    }

    public static void main(String[] args) {
        
        // 1.Message Header // 1.1 Session ID, 2 Byte, maksium 65536, int 
        int sessionId = 12123;
        String sessionHex = Integer.toHexString(sessionId);
        System.out.println("Session ID = " + sessionId);
        System.out.println("Session ID Hex Format = " + sessionHex);
        
        byte[] sessionid_bytes = hex2Byte(sessionHex);                
        System.out.println("Session ID parameter, dng panjang : " + sessionid_bytes.length + " " + 
                           sessionHex.toString());
        
        for (int i=0; i < sessionid_bytes.length; i++) {
            System.out.println(i+"." +sessionid_bytes[i]);    
        }     
        
        System.out.println("");
        

        // 1.Message Header   // 1.2 CAS_VER, 1 Byte, maksium 256, short 
        short CAS_VER = 2;
        String CAS_VERHex = Integer.toHexString(CAS_VER);
        System.out.println("CAS_VER = " + CAS_VER);
        System.out.println("CAS_VER Hex Format = " + CAS_VERHex);
        
        byte[] CAS_VER_bytes = CAS_VERHex.getBytes();                
        System.out.println("CAS_VERSION parameter, dng panjang : " + CAS_VER_bytes.length + " " + 
                           CAS_VER_bytes.toString());
        
        for (int i=0; i < CAS_VER_bytes.length; i++) {
            System.out.println(i+"." +CAS_VER_bytes[i]);    
        } 
        
        System.out.println("");
        

        // 1.Message Header   // 1.3 command type, 1 Byte, maksium 256, short 
        short commandType = 33;
        String commandTypeHex = Integer.toHexString(commandType);
        System.out.println("commandType = " + commandType);
        System.out.println("commandType Hex Format = " + commandTypeHex);
        
        byte[] commandTypeBytes = hex2Byte(commandTypeHex);                
        System.out.println("commandTypeBytes parameter, dng panjang : " + commandTypeBytes.length + " " + 
                           commandTypeBytes.toString());
        
        for (int i=0; i < commandTypeBytes.length; i++) {
            System.out.println(i+"." +commandTypeBytes[i]);    
        }

        
        System.out.println("");
        
        
        // 1.Message Header  // 1.4 Data length, 1 Byte, maksium 256, short 
        int data_length = 12123;
        String data_length_hex = Integer.toHexString(data_length);
        System.out.println("data_length = " + data_length);
        System.out.println("data_length Hex Format = " + data_length_hex);
        
        byte[] data_length_bytes = hex2Byte(data_length_hex);                
        data_length_bytes[0] = 0;
        data_length_bytes[1] = 9;               
        System.out.println("data_length_bytes parameter, dng panjang : " + data_length_bytes.length + " " + 
                           data_length_bytes.toString());
        
        for (int i=0; i < data_length_bytes.length; i++) {
            System.out.println(i+"." +data_length_bytes[i]);    
        }
        
        
        System.out.println("");
        
        // 1.Message Header  // 1.5 Data Body, Dinamis depend on 4, maksium 256, short 
              
        
        
        //2. data body, 1 adalah card number
        BigInteger cardNumberbi = new BigInteger ("2147483664");
        long cardNumberlong = cardNumberbi.longValue();
        String cardNumberHex = Long.toHexString(cardNumberlong);
        System.out.println("Card Number = " + cardNumberbi);
        System.out.println("Card Number Hex Format = " + cardNumberHex);
        
        byte[] cardNumberBytes_Conf = hex2Byte(cardNumberHex);                
        System.out.println("Success sending message.., dng panjang : " + cardNumberBytes_Conf.length + " " + 
                           cardNumberBytes_Conf.toString());
        
            for (int i=0; i < cardNumberBytes_Conf.length; i++) {
                System.out.println(i+"." +cardNumberBytes_Conf[i]);    
            }
            
            
        String hexaku = byte2hex(cardNumberBytes_Conf);
        System.out.println("Balkin lagi jadi Hexa " + hexaku );
            
        BigInteger decimal =  new BigInteger(hexaku,16);
        System.out.println("Decimal nya adalah : " + decimal);
        
        
        System.out.println("");
        //2. data body, 2 adalah date
        System.out.println("System.currentTimeMillis = "+ System.currentTimeMillis());
        int unixTime = (int)(System.currentTimeMillis() / 1000);
        int unixTime2 = 86400 + unixTime;
        System.out.println("System.currentTimeMillis /1000 "+ unixTime);
        System.out.println("System.currentTimeMillis /1000 "+ unixTime2);
        byte[] productionDate = new byte[]{
                (byte) (unixTime2 >> 24),
                (byte) (unixTime2 >> 16),
                (byte) (unixTime2 >> 8),
                (byte) unixTime2

        };
        System.out.println("System.currentTimeMillis Hex : "+ byte2hex(productionDate).toUpperCase());
        
        System.out.println("Date time.., dng panjang : " + productionDate.length + " " + 
                           productionDate.toString());
        
        for (int i=0; i < productionDate.length; i++) {
                System.out.println(i+"." +productionDate[i]);    
        }
        
        //2. data body, 3 is send variable.
        short is_send = 1;
        String is_sendHex = Integer.toHexString(is_send);
        System.out.println("is_send = " + is_send);
        System.out.println("is_send Hex Format = " + is_sendHex);
        
        byte[] is_sendBytes = is_sendHex.getBytes();                
        System.out.println("is_sendBytes parameter, dng panjang : " + is_sendBytes.length + " " + 
                           is_sendBytes.toString());
        
        for (int i=0; i < is_sendBytes.length; i++) {
            System.out.println(i+"." +is_sendBytes[i]);    
        } 
        
        System.out.println("");
        
        
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            baos.write(sessionid_bytes);
            baos.write(CAS_VER_bytes);
            baos.write(commandTypeBytes);
            baos.write(data_length_bytes);
            baos.write(cardNumberBytes_Conf);
            baos.write(productionDate);
            baos.write(is_sendBytes);
            
            byte[] finalMessage = baos.toByteArray();
          System.out.println("finalMessage parameter, dng panjang : " + finalMessage.length + " " + 
                             finalMessage.toString());
          
          for (int i=0; i < finalMessage.length; i++) {
              System.out.println(i+"." +finalMessage[i]);    
          } 
          
          System.out.println("");
            
            
        } catch (IOException e4) {
            e4.printStackTrace();
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
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
}
