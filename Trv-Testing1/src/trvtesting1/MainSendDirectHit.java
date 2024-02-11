package trvtesting1;

import amdocs.amsp.Configuration;
import amdocs.amsp.FrameworkConstantsI;
import amdocs.amsp.ServiceConstantsI;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.AccountConstraintsFacade;
import amdocs.amsp.services.ContractsFacade;
import amdocs.amsp.services.CorpparamFacade;
import amdocs.amsp.services.EquipmentFacade;
import amdocs.amsp.services.FinancialFacade;
import amdocs.amsp.services.LockServiceFacade;
import amdocs.amsp.services.OpInstallFacade;
import amdocs.amsp.services.OpQueryFacade;
import amdocs.amsp.services.SiteFacade;
import amdocs.amsp.services.PromosFacade;
import amdocs.amsp.services.ServicePointFacade;
import amdocs.amsp.valueobject.accountconstraints.CustomerConstraintsVO;
import amdocs.amsp.valueobject.accountconstraints.VideoEquipmentConstraintsVO;
import amdocs.amsp.valueobject.accountviewfinancials.AgedMoneyVO;
import amdocs.amsp.valueobject.accountviewwip.OrderGroupVO;
import amdocs.amsp.valueobject.accountviewwip.WipTaskInfoVO;
import amdocs.amsp.valueobject.corpparam.Code95VO;
import amdocs.amsp.valueobject.customer.CustomerDetailsVO;
import amdocs.amsp.valueobject.equipment.ResponseItemVO;
import amdocs.amsp.valueobject.financial.MoneyTransactionVO;
import amdocs.amsp.valueobject.lockservice.LockOutputVO;
import amdocs.amsp.valueobject.opquery.PollRecalculateServicesVO;
import amdocs.amsp.valueobject.order.OrderInfoVO;
import amdocs.amsp.valueobject.order.OrderResultVO;
import amdocs.amsp.valueobject.order.OrderVO;
import amdocs.amsp.valueobject.schedule.ScheduleVO;
import amdocs.amsp.valueobject.servicepoint.ContractVO;
import amdocs.amsp.valueobject.servicepoint.EquipmentVO;
import amdocs.amsp.valueobject.servicepoint.PromoVO;
import amdocs.amsp.valueobject.servicepoint.RateCodeVO;
import amdocs.amsp.valueobject.servicepoint.ServicePointVO;
import amdocs.amsp.valueobject.servicepoint.TaskVO;
import amdocs.amsp.valueobject.site.SiteDetailsVO;

public class MainSendDirectHit {
    
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
        OpInstallFacade opInstallFacade = new OpInstallFacade();
        EquipmentFacade equipmentFacade = new EquipmentFacade();
        OrderVO orderVO = new OrderVO();
        ContractsFacade contractsFacade = new ContractsFacade();
        OrderResultVO orderResultVO = new OrderResultVO();
        PollRecalculateServicesVO pollRecalculateServicesVO = new PollRecalculateServicesVO();
        SiteFacade siteFacade = new SiteFacade();
        SiteDetailsVO siteDetailsVO = null;
        //OpInstallFacade opInstallFacade = new OpInstallFacade();
        CustomerDetailsVO customerDetailsVO = new CustomerDetailsVO();
        AccountConstraintsFacade accountConstraintsFacade = new AccountConstraintsFacade();
        CustomerConstraintsVO customerConstraintsVO = new CustomerConstraintsVO();
        FinancialFacade financialFacade = new FinancialFacade();
        MoneyTransactionVO moneyTransactionVO = new MoneyTransactionVO();
        CorpparamFacade corpparamFacade = new CorpparamFacade();
        RateCodeVO rateCodeVO = new RateCodeVO();
        RateCodeVO[] rateCodeVOList = new RateCodeVO[1];
        Code95VO[] code95VO = null;        
        WipTaskInfoVO wipTaskInfoVO = new WipTaskInfoVO();
        TaskVO[] taskVOList = new TaskVO[1];
        TaskVO taskVO = new TaskVO();
        OrderGroupVO[] orderGroupVOList = new OrderGroupVO[1];
        ServicePointVO[] servicePointVOList = new ServicePointVO[1];
        OrderInfoVO orderInfoVO = new OrderInfoVO();
        ScheduleVO scheduleVO = new ScheduleVO();
        AgedMoneyVO[] agedMoneyVOList = new AgedMoneyVO[9];
        ContractVO[] contractVOList = new ContractVO[1];
        //PollRecalculateServicesVO pollRecalculateServicesVO;
        pollRecalculateServicesVO = new PollRecalculateServicesVO();
        OpQueryFacade opQueryFacade = new OpQueryFacade();
        PromoVO promoVO = new PromoVO();
        PromosFacade promosFacade = new PromosFacade();
        EquipmentVO equipmentVO = new EquipmentVO();
        EquipmentVO[] equipmentVOlist = new EquipmentVO[1];
        ServicePointFacade servicePointFacade = new ServicePointFacade();
        VideoEquipmentConstraintsVO videoEquipmentConstraintsVO = new VideoEquipmentConstraintsVO();
        ResponseItemVO[] responseItemVOList = new ResponseItemVO[1];
        
        
                
        System.out.println("Login Class created....");
        Login aLogin = new Login();
        try {
            System.out.println("Activating subcriber....");
            
            PrintOutput printOutput = new PrintOutput();           
            
            Configuration.appName = Configuration.AMSP_API_APP_NAME;
            
            System.out.println("Parameter Class created....");
            Parameters apiParams = new Parameters();
            apiParams.setUser("ANDRI");
            apiParams.setPassword("ANDRI");
            
            System.out.println("Init Parameter start...");
            apiParams.initParameters(Parameters.NEW_INSTALL_WITH_EQUIP , apiParams, printOutput);                 
                      
            //aLGORITMA cREATE CUSTOMER - iNSTALL
            // 1. Login
            // 2. JIka sedang APC, return ERROR
            // 3. Jika Option, General Maintenance, Add Site tidak enable, return ERROR
            
            System.out.println("Prepare Login....");
            session = aLogin.logInOut(aLogin.LOGIN(), apiParams, printOutput);  
            
            if (session) {
                
                // 4.A Lock site yg sudah sy create di play: 00236076    
                lockOutputVO = lockServiceFacade.getSiteLock(apiParams.getsiteId(), 
                                                             FrameworkConstantsI.LockMode.RETURN_ONLY.getLockModeValue(),
                                                             apiParams.getCorp(), 
                                                             aLogin.getTicket());
                printOutput.printToShell(apiParams, "Site Lock Message: " + lockOutputVO.getMessage(), null);
                if (lockOutputVO.getStatus()){siteLock = true;}
                else {siteLock = false;}
                
                // 4.B Lock Variable APC
                lockOutputVO = lockServiceFacade.getApcVarLock(apiParams.getsiteId(), 
                                                                       apiParams.getCust_acct(), 
                                                                       apiParams.getCorp(), 
                                                                       aLogin.getTicket());
                printOutput.printToShell(apiParams, "Variable Lock Message: " + lockOutputVO.getMessage(), null);
                if (lockOutputVO.getStatus()){varLock = true;}
                else {varLock = false;}
                
                
                // Jika site terlocked true
                if (siteLock && varLock) {
                    
                    
                    
                    try {
                        
                        responseItemVOList = equipmentFacade.sendDirectHit("   42615656339", 
                                                                        16,  apiParams.getCorp(), 
                                                                           aLogin.getTicket());
                        
                        if (responseItemVOList != null) {
                            
                            for (int i = 0; i != responseItemVOList.length; i++) {                               
                                printOutput.printToShell(apiParams, 
                                "responseItemVOList " + ":<responseItemVOList id=" + i + ">" + responseItemVOList[i].toString() + "</responseItemVOList>",
                                responseItemVOList[i].toXml()); 
                            }
                            
                        } else {
                            throw new Exception("responseItemVOList is null");
                        }
                    
                    } catch (AmspServiceException e) {
                        printOutput.printExceptionToShell(apiParams, "<<ANDRI:equipmentFacade " , e);
                    }
                    
                    
                    
                } 
                
                else {
                    printOutput.printToShell(apiParams, "Site Lock Message: " + lockOutputVO.getMessage(), null);
                }
                
                
                
                // 11. Unlock site
                lockOutputVO = lockServiceFacade.unLockSite(apiParams.getsiteId(), apiParams.getCorp(), aLogin.getTicket());
                
                printOutput.printToShell(apiParams, "Site unlock message: " + lockOutputVO.getMessage(), null);
                
                // 11.B Unlock VAR
                lockOutputVO = lockServiceFacade.unLockApcVarLock(apiParams.getsiteId(), apiParams.getCust_acct(), apiParams.getCorp(), 
                                                                  aLogin.getTicket());
                
                printOutput.printToShell(apiParams, "Var unlock message: " + lockOutputVO.getMessage(), null);
                
                
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
