package trvtesting1;

import amdocs.amsp.Configuration;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.OpQueryFacade;
import amdocs.amsp.valueobject.lockservice.LockOutputVO;
import amdocs.amsp.valueobject.opquery.PackageDataVO;
import amdocs.amsp.valueobject.opquery.QualifiersVO;
import amdocs.amsp.valueobject.servicepoint.PromoVO;


public class MainListPackage {
    
    public static void main(String[] args) throws Exception{
        // variables
        boolean session;       
        boolean siteLock         = false;      
        boolean varLock          = false;   
        
        // objects
        OpQueryFacade opQueryFacade = new OpQueryFacade();
        LockOutputVO lockOutputVO = new LockOutputVO();        
      PackageDataVO[] PackageDataVOList;
        QualifiersVO[] qualifiersVOList;
        QualifiersVO qualifiersVO = new QualifiersVO();
               
        System.out.println("Login Class created....");
        Login aLogin = new Login();
        try {
            System.out.println("List package from subcriber....");
            
            PrintOutput printOutput = new PrintOutput();           
            
            Configuration.appName = Configuration.AMSP_API_APP_NAME;
            
            System.out.println("Parameter Class created....");
            Parameters apiParams = new Parameters();
            apiParams.setUser("ANDRI");
            apiParams.setPassword("ANDRI");           
            
            System.out.println("Prepare Login....");
            session = aLogin.logInOut(aLogin.LOGIN(), apiParams, printOutput);  
            
            if (session) {
                
                siteLock = true;
                varLock = true;
                
                
                
                // Jika site terlocked true
                if (siteLock && varLock) {
                    
                    
                    try {
                        
                        System.out.println("Setting qualifier..");
                        qualifiersVOList = new QualifiersVO[1];
                        qualifiersVO.setQualifierType(5);
                        
                        qualifiersVOList[0] = qualifiersVO;
                        
                        System.out.print("Trying to call opQueryFacade.getPackageCodeDetails... ");
                        PackageDataVOList = opQueryFacade.getPackageCodeDetails("10213085", "00217231", qualifiersVOList,0, apiParams.getCorp(), aLogin.getTicket());
                                                                            
                        
                        if (PackageDataVOList != null) {
                            
                            for (int i = 0; i != PackageDataVOList.length; i++) {                               
                                printOutput.printToShell(apiParams, 
                                "PackageDataVOList " + ":<PackageDataVOList id=" + i + ">" + PackageDataVOList[i].toString() + "</PackageDataVOList>",
                                PackageDataVOList[i].toXml()); 
                            }
                            
                        } 
                        else {
                            throw new Exception("PackageDataVOList is null");
                        }                     
                        
                        
                    } catch (AmspServiceException e) {
                        printOutput.printExceptionToShell(apiParams, "PackageDataVOList Facade ", e);
                    }                    
                    
                    
                } else {
                    printOutput.printToShell(apiParams, "Site Lock Message: " + lockOutputVO.getMessage(), null);
                }                
                
                
                // 12. Logout
                aLogin.logInOut(aLogin.LOGOUT(), apiParams, printOutput); 
                
                
                
            } else {
                System.out.println("Login session is expired, please Relogin");
            }
            
            
        } catch (Exception ex) {
            System.out.println ("Error Expcetion from main ==> " + ex.toString());
        }  
    }
}
