package trvtesting1;

import amdocs.amsp.Configuration;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.OpQueryFacade;
import amdocs.amsp.valueobject.customer.CustomerDetailsVO;
import amdocs.amsp.valueobject.lockservice.LockOutputVO;
import amdocs.amsp.valueobject.opquery.PackageDataVO;
import amdocs.amsp.valueobject.opquery.PackageDetailsVO;
import amdocs.amsp.valueobject.opquery.RateCodeSelectionIpVO;
import amdocs.amsp.valueobject.order.OrderVO;
import amdocs.amsp.valueobject.servicepoint.PromoVO;
import amdocs.amsp.valueobject.site.SiteDetailsVO;

import java.math.BigDecimal;


public class MainListPackageLines {
    
    public static void main(String[] args) throws Exception{
        // variables
        boolean session;       
        boolean siteLock         = false;      
        boolean varLock          = false;   
        
        // objects
        OpQueryFacade opQueryFacade = new OpQueryFacade();
        LockOutputVO lockOutputVO = new LockOutputVO();        
        PackageDetailsVO packageDetailsVO = new PackageDetailsVO();
        RateCodeSelectionIpVO rateCodeSelectionIp = new RateCodeSelectionIpVO();
        CustomerDetailsVO customerDetails = new CustomerDetailsVO();
        SiteDetailsVO siteDetails = new SiteDetailsVO();
        OrderVO orderVO = new OrderVO();
        
        BigDecimal offerNum = new BigDecimal(0);
        BigDecimal orderGroupSeq = new BigDecimal(0); 
        
               
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
                        
                        rateCodeSelectionIp.setPackageCode("PE");
                        rateCodeSelectionIp.setCampaignCode("113");
                        rateCodeSelectionIp.setPriceStructureId(0);
                        packageDetailsVO = opQueryFacade.getPackageLines(rateCodeSelectionIp, orderGroupSeq, offerNum, 0, 0, 
                                                                         customerDetails, siteDetails, orderVO,
                                                                         apiParams.getCorp(), 
                                                                         aLogin.getTicket());
                                                          
                                                                       
                        
                        if (packageDetailsVO != null) {
                            
                                                         
                                printOutput.printToShell(apiParams, 
                                "packageDetailsVO " + ":<packageDetailsVO id=" + ">" + packageDetailsVO.toString() + "</packageDetailsVO>",
                                packageDetailsVO.toXml()); 
                            
                            
                        } 
                        else {
                            throw new Exception("packageDetailsVO is null");
                        }                     
                        
                        
                    } catch (AmspServiceException e) {
                        printOutput.printExceptionToShell(apiParams, "packageDetailsVO Facade ", e);
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
