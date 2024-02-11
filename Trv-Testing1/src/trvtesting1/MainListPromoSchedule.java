package trvtesting1;

import amdocs.amsp.Configuration;
import amdocs.amsp.FrameworkConstantsI;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.AccountConstraintsFacade;
import amdocs.amsp.services.ContractsFacade;
import amdocs.amsp.services.CorpparamFacade;
import amdocs.amsp.services.FinancialFacade;
import amdocs.amsp.services.LockServiceFacade;
import amdocs.amsp.services.OpInstallFacade;
import amdocs.amsp.services.OpQueryFacade;
import amdocs.amsp.services.SiteFacade;
import amdocs.amsp.services.PromosFacade;
import amdocs.amsp.valueobject.accountconstraints.CustomerConstraintsVO;
import amdocs.amsp.valueobject.accountviewfinancials.AgedMoneyVO;
import amdocs.amsp.valueobject.accountviewwip.OrderGroupVO;
import amdocs.amsp.valueobject.accountviewwip.WipTaskInfoVO;
import amdocs.amsp.valueobject.corpparam.Code95VO;
import amdocs.amsp.valueobject.customer.CustomerDetailsVO;
import amdocs.amsp.valueobject.financial.MoneyTransactionVO;
import amdocs.amsp.valueobject.lockservice.LockOutputVO;
import amdocs.amsp.valueobject.opquery.PollRecalculateServicesVO;
import amdocs.amsp.valueobject.order.OrderInfoVO;
import amdocs.amsp.valueobject.order.OrderResultVO;
import amdocs.amsp.valueobject.order.OrderVO;
import amdocs.amsp.valueobject.schedule.ScheduleVO;
import amdocs.amsp.valueobject.servicepoint.ContractVO;
import amdocs.amsp.valueobject.servicepoint.PromoVO;
import amdocs.amsp.valueobject.servicepoint.RateCodeVO;
import amdocs.amsp.valueobject.servicepoint.ServicePointVO;
import amdocs.amsp.valueobject.servicepoint.TaskVO;
import amdocs.amsp.valueobject.site.SiteDetailsVO;

public class MainListPromoSchedule {
    
    public static void main(String[] args) throws Exception{
        // variables
        boolean session;
        boolean apcLock          = false;
        boolean siteLock         = false;
        boolean acctLock         = false;
        boolean varLock          = false;
        boolean techLock         = false;
        boolean phoneNumberLock  = false;
        
        // objects
        LockServiceFacade lockServiceFacade = new LockServiceFacade();
        LockOutputVO lockOutputVO = new LockOutputVO();        
        PromoVO[] promoVOList;
        PromosFacade promosFacade = new PromosFacade();
                
        System.out.println("Login Class created....");
        Login aLogin = new Login();
        try {
            System.out.println("List promo ID from product ID subcriber....");
            
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
                        promoVOList = promosFacade.getSvcPromoDetails("PL", 0, apiParams.getCorp(), aLogin.getTicket());
                        
                        if (promoVOList != null) {
                            
                            for (int i = 0; i != promoVOList.length; i++) {                               
                                printOutput.printToShell(apiParams, 
                                "promoVOList " + ":<promoVOList id=" + i + ">" + promoVOList[i].toString() + "</promoVOList>",
                                promoVOList[i].toXml()); 
                            }
                            
                        } 
                        else {
                            throw new Exception("promoVOList is null");
                        }                     
                        
                        
                    } catch (AmspServiceException e) {
                        printOutput.printExceptionToShell(apiParams, "Promos Facade ", e);
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
