package trvtesting1;

import amdocs.amsp.Configuration;
import amdocs.amsp.FrameworkConstantsI;
import amdocs.amsp.ServiceConstantsI;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.AccountConstraintsFacade;
import amdocs.amsp.services.AccountViewWipFacade;
import amdocs.amsp.services.ContractsFacade;
import amdocs.amsp.services.CorpparamFacade;
import amdocs.amsp.services.CustomerFacade;
import amdocs.amsp.services.FinancialFacade;
import amdocs.amsp.services.LockServiceFacade;
import amdocs.amsp.services.OpInstallFacade;
import amdocs.amsp.services.OpQueryFacade;
import amdocs.amsp.services.SiteFacade;
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
import amdocs.amsp.valueobject.servicepoint.RateCodeVO;
import amdocs.amsp.valueobject.servicepoint.ServicePointVO;
import amdocs.amsp.valueobject.servicepoint.TaskVO;
import amdocs.amsp.valueobject.site.SiteDetailsVO;
import amdocs.amsp.services.OpChangeOfServiceFacade;
import amdocs.amsp.services.OpMainOrderOptionFacade;
import amdocs.amsp.services.OpRescheduleFacade;
import amdocs.amsp.services.PromosFacade;
import amdocs.amsp.services.ServicePointFacade;
import amdocs.amsp.valueobject.accountconstraints.VideoEquipmentConstraintsVO;
import amdocs.amsp.valueobject.opmainorderoption.EquipmentValidationVO;
import amdocs.amsp.valueobject.servicepoint.EquipmentVO;
import amdocs.amsp.valueobject.servicepoint.PromoVO;

public class MainEquipmentCheck {
    
    public static void main(String[] args) throws Exception{
        // variables
        boolean session;
        boolean siteLock         = false;
        boolean acctLock         = false;
        boolean varLock          = false;
        boolean validExecute     = false;
        boolean validasiarea     = false;
        boolean validasioverride = false;
        
        // objects
        LockServiceFacade lockServiceFacade = new LockServiceFacade();
        LockOutputVO lockOutputVO = new LockOutputVO();OrderResultVO orderResultVO = new OrderResultVO();
        PollRecalculateServicesVO pollRecalculateServicesVO = new PollRecalculateServicesVO();
        CustomerDetailsVO customerDetailsVO = new CustomerDetailsVO();
        AccountConstraintsFacade accountConstraintsFacade = new AccountConstraintsFacade();
        pollRecalculateServicesVO = new PollRecalculateServicesVO();
        EquipmentVO equipmentVO = new EquipmentVO();
        EquipmentVO[] equipmentVOlist = new EquipmentVO[1];
        ServicePointFacade servicePointFacade = new ServicePointFacade();
        VideoEquipmentConstraintsVO videoEquipmentConstraintsVO = new VideoEquipmentConstraintsVO();
               
        System.out.println("Login Class created....");
        Login aLogin = new Login();
        try {
            System.out.println("Assign Equipment to  subcriber....");
            
            PrintOutput printOutput = new PrintOutput();           
            
            Configuration.appName = Configuration.AMSP_API_APP_NAME;
            
            System.out.println("Parameter Class created....");
            Parameters apiParams = new Parameters();
            apiParams.setUser("ANDRI");
            apiParams.setPassword("ANDRI");
            
            System.out.println("Init Parameter start...");
            printOutput.initOutput(apiParams, printOutput);
            apiParams.initParameters(Parameters.EQUIPMENT_CHECK , apiParams, printOutput);                 
            
            System.out.println("Prepare Login....");
            session = aLogin.logInOut(aLogin.LOGIN(), apiParams, printOutput);  
            
            if (session) {  
                
                // 6.B part 4.1   Equipment
                //   Equipment detail yang mau di add
                try {
                    equipmentVO = servicePointFacade.getEquipmentDetails(apiParams.getEquipmentId(), 
                                                                         apiParams.getCorp(), 
                                                                         aLogin.getTicket());
                
                    if (equipmentVO != null) {
                            printOutput.printToShell(apiParams, 
                            "<<ANDRI :<equipmentVO>" +       equipmentVO.toString() + "</equipmentVO>",
                            equipmentVO.toXml());
                    }
                    else {
                            throw new Exception("equipmentVO is null");
                    }
                    
                } catch (AmspServiceException e) {
                        printOutput.printExceptionToShell(apiParams, "servicePointFacade", e);
                }
                
                // 12. Logout
                aLogin.logInOut(aLogin.LOGOUT(), apiParams, printOutput); 
                
                //cleanup display and print file
                apiParams.finishOutput(apiParams, printOutput);
                printOutput.finishOutput(apiParams, printOutput);
                
                
                
            } 
            else {
                System.out.println("Login session is expired, please Relogin");
            }
            
            
        } catch (Exception ex) {
            System.out.println ("Error Expcetion from main ==> " + ex.toString());
        }  
    }
}
