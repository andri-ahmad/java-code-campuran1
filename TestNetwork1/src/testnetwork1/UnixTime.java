package testnetwork1;

public class UnixTime {
    public UnixTime() {
        super();
        
        System.out.println("");
        //2. data body, 2 adalah date
        System.out.println("System.currentTimeMillis = "+ System.currentTimeMillis());
        int unixTime = (int)(System.currentTimeMillis() / 1000);
        int unixTime2 = 86400 + unixTime;
        // 86.400 = detik dalam satu hari = 24 x 60 x 60
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
    }

    public static void main(String[] args) {
        UnixTime unixTime = new UnixTime();
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
