package clienttester;

import java.util.Date;

public class TestOnly {
    public TestOnly() {
        super();
    }
    
    public static void main(String[] args) {
    
    
        long startTime = (long)(System.currentTimeMillis());
        
        System.out.println("StartTIme = " + new Date(System.currentTimeMillis()));        
        System.out.println("StartTIme = " + startTime);
        
        long endTime = (long)(System.currentTimeMillis())+ (180 * 86400000);
                
        System.out.println("End Time = " + endTime);
        System.out.println("End Time = " + new Date(endTime));
        
    }
    
    
}
