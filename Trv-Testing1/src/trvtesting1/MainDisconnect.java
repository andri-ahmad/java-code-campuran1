package trvtesting1;

import amdocs.amsp.Configuration;
import amdocs.amsp.FrameworkConstantsI;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.AccountConstraintsFacade;
import amdocs.amsp.services.ContractsFacade;
import amdocs.amsp.services.CorpparamFacade;
import amdocs.amsp.services.CustomerFacade;
import amdocs.amsp.services.FinancialFacade;
import amdocs.amsp.services.LockServiceFacade;
import amdocs.amsp.services.OpDisconnectFacade;
import amdocs.amsp.services.OpInstallFacade;
import amdocs.amsp.services.OpQueryFacade;
import amdocs.amsp.services.PromosFacade;
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
import amdocs.amsp.valueobject.servicepoint.PromoVO;
import amdocs.amsp.valueobject.servicepoint.RateCodeVO;
import amdocs.amsp.valueobject.servicepoint.ServicePointVO;
import amdocs.amsp.valueobject.servicepoint.TaskVO;
import amdocs.amsp.valueobject.site.SiteDetailsVO;

public class MainDisconnect {
   
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
        OpDisconnectFacade opDisconnectFacade = new OpDisconnectFacade();
        CustomerFacade customerFacade = new CustomerFacade();
            
                
        System.out.println("Login Class created....");
        Login aLogin = new Login();
        try {
            System.out.println("Disconnecting subcriber....");
            
            PrintOutput printOutput = new PrintOutput();           
            
            Configuration.appName = Configuration.AMSP_API_APP_NAME;
            
            System.out.println("Parameter Class created....");
            Parameters apiParams = new Parameters();
            apiParams.setUser("ANDRI");
            apiParams.setPassword("ANDRI");
            
            System.out.println("Init Parameter start...");
            apiParams.initParameters(Parameters.DISCONNECT_NO_TRUCK , apiParams, printOutput);                 
                      
            //aLGORITMA cREATE CUSTOMER - iNSTALL
            // 1. Login
            // 2. JIka sedang APC, return ERROR
            // 3. Jika Option, General Maintenance, Add Site tidak enable, return ERROR
            
            System.out.println("Prepare Login....");
            session = aLogin.logInOut(aLogin.LOGIN(), apiParams, printOutput);  
            
            if (session) {
                
                // 4. Account Lock
                lockOutputVO = lockServiceFacade.getAccountLock(apiParams.getCust_acct(), 
                                                                FrameworkConstantsI.LockMode.RETURN_ONLY.getLockModeValue(), 
                                                                apiParams.getCorp(), 
                                                                aLogin.getTicket());
                printOutput.printToShell(apiParams, "Account Lock Message: " + lockOutputVO.getMessage(), null);
                
                if (lockOutputVO.getStatus()){acctLock = true;}
                else {acctLock = false;}  
                
                // Jika account terlocked true
                if (acctLock) {
                    
                    // 6.a part 1 is get Customer details
                    try {
                        customerDetailsVO = customerFacade.getCustomerDetail(apiParams.getCust_acct(), 
                                                                             false, apiParams.getCorp(), aLogin.getTicket());                          
                        
                        if (customerDetailsVO != null) {
                            printOutput.printToShell(apiParams, 
                            "<<ANDRI GETDATA customerFacade.getCustomerDetail:<customerDetailsVO>" + customerDetailsVO.toString() + "</CustomerDetailsVO>",
                            customerDetailsVO.toXml());
                        }
                        else {
                            throw new Exception("customerDetailsVO is null");
                        }
                        
                        }
                    catch (AmspServiceException e)  {
                        printOutput.printExceptionToShell(apiParams, "customerFacade.getCustomerDetail", e);
                    }
                    
                    // 4.B Lock site dari site di customer detail.    
                    lockOutputVO = lockServiceFacade.getSiteLock(customerDetailsVO.getSiteId(), 
                                                                 FrameworkConstantsI.LockMode.RETURN_ONLY.getLockModeValue(),
                                                                 apiParams.getCorp(), 
                                                                 aLogin.getTicket());
                    printOutput.printToShell(apiParams, "Site Lock Message: " + lockOutputVO.getMessage(), null);                    
                    if (lockOutputVO.getStatus()){siteLock = true;}
                    else {siteLock = false;}
                    
                    // 4.C Lock Variable APC
                    lockOutputVO = lockServiceFacade.getApcVarLock(customerDetailsVO.getSiteId(), 
                                                                           apiParams.getCust_acct(), 
                                                                           apiParams.getCorp(), 
                                                                           aLogin.getTicket());
                    printOutput.printToShell(apiParams, "Variable Lock Message: " + lockOutputVO.getMessage(), null);
                    if (lockOutputVO.getStatus()){varLock = true;}
                    else {varLock = false;}
                    
                    
                    // pastikan site dan varlock OK
                    if (siteLock && varLock) {
                        
                        
                        // siapin order VO
                        try {
                            orderVO = opDisconnectFacade.getNewDisconnectOrder(customerDetailsVO.getSiteId(), 
                                                        apiParams.getCust_acct(), 
                                                        apiParams.getOrderGroupSeq(),
                                                        apiParams.getCorp(), 
                                                        aLogin.getTicket());
                            
                            if (orderVO != null) {
                                printOutput.printToShell(apiParams, 
                                ":<orderVO>" + orderVO.toString() + "</orderVO>",
                                orderVO.toXml());
                            }
                            else {
                                throw new Exception("orderVO is null");
                            }
                            
                            }
                        catch (AmspServiceException e)  {
                            printOutput.printExceptionToShell(apiParams, "opInstallFacade.getNewInstallOrder ", e);
                            
                            System.exit(-1);
                        }
                        
                        //site detail
                        // 6.a part 2 is get siteDetails
                        try {
                            // SiteDetailsVO 
                            siteDetailsVO = siteFacade.getSiteDetail(customerDetailsVO.getSiteId(),
                                         apiParams.getCorp(), 
                                         aLogin.getTicket());
                            
                            if (siteDetailsVO != null) {
                                printOutput.printToShell(apiParams, 
                                ":<SiteDetailsVO>" +     siteDetailsVO.toString() + "</SiteDetailsVO>",
                                siteDetailsVO.toXml());
                            }
                            else {
                                throw new Exception("siteDetailsVO is null");
                            }
                        
                        } catch (AmspServiceException e) {
                            printOutput.printExceptionToShell(apiParams, "Site Class ", e);
                        }
                        
                        
                        // money transaction
                        // 6.a part 5, get money Transaction
                        try {
                            moneyTransactionVO = financialFacade.getNewMoneyTransaction(apiParams.getCust_acct(),
                                                                                    customerDetailsVO.getSiteId(), 
                                                                                    apiParams.getCallerName(),
                                                                                    apiParams.getCorp(),
                                                                                    aLogin.getTicket());
                            
                            if (moneyTransactionVO != null) {
                                printOutput.printToShell(apiParams, 
                                "<<ANDRI: Monet Trx Index Get DATA>> " + ":<moneyTransactionVO>" + moneyTransactionVO.toString() + "</moneyTransactionVO>",
                                moneyTransactionVO.toXml());
                            }
                            else {
                                throw new Exception("moneyTransactionVO is null");
                            }
                        
                        } catch (AmspServiceException e) {
                            printOutput.printExceptionToShell(apiParams, "Monet Trx ", e);
                        }       
                        
                        
                        
                        servicePointVOList = orderVO.getServicePointList();
                        
                        servicePointVOList[0].setAction(apiParams.getServicePointVOaction());                        
                        servicePointVOList[0].setOrderGroup(apiParams.getOrderGroupSeq());
                        
                        orderInfoVO = orderVO.getOrderInfoList();
                        
                        apiParams.setOrderGroupSeq(apiParams, printOutput, orderInfoVO.getOrderGroupSeq());
                        
                        scheduleVO = orderInfoVO.getSchedule();                        
                        scheduleVO.setAction(apiParams.getScheduleVOaction());
                        scheduleVO.setIsMustDo(apiParams.getIsMustDo());
                        scheduleVO.setScheduleDate(apiParams.getScheduleDate());
                        scheduleVO.setScheduleType((short)apiParams.getScheduleType());
                        scheduleVO.setTechId(apiParams.getTechId());                        
                        
                        orderInfoVO.setAction(apiParams.getOrderInfoVOaction());
                        orderInfoVO.setBillDate(apiParams.getBillDate());
                        orderInfoVO.setBillToDate(apiParams.getBillDate());
                        orderInfoVO.setDisconnectReasonCode(apiParams.getDisconnectReasonCode());
                        orderInfoVO.setInstallDate(customerDetailsVO.getInitialInstallDate());
                        orderInfoVO.setLastInstallDate(customerDetailsVO.getLastInstallDate());
                        orderInfoVO.setNewCycle(String.valueOf(customerDetailsVO.getCycle()));
                        orderInfoVO.setOrderGroupSeq(apiParams.getOrderGroupSeq());
                        orderInfoVO.setProrateFromDate(apiParams.getBillDate());
                        orderInfoVO.setProrateToDate(apiParams.getBillDate());
                        orderInfoVO.setSchedule(scheduleVO);
                        orderInfoVO.setSpecialInstruct1Code(apiParams.getSpecialInstruct1Code());
                        orderInfoVO.setWorkDoneDate(apiParams.getBillDate());
                        orderInfoVO.setWorkDoneTime(apiParams.getBillDate());
                                        
                        
                        orderVO.setCustAcct(apiParams.getCust_acct());
                        orderVO.setServicePointList(servicePointVOList);
                        orderVO.setCallerName(apiParams.getCallerName());
                        orderVO.setOrderInfoList(orderInfoVO);
                        
                        
                        // 6.B part 11, Recalculate Services
                        try {
                            pollRecalculateServicesVO = opQueryFacade.recalculateServices(orderVO, 
                                                    customerDetailsVO, 
                                                    siteDetailsVO, 
                                                    apiParams.getCorp(), 
                                                    aLogin.getTicket());   
                            
                            if (pollRecalculateServicesVO != null) {
                                printOutput.printToShell(apiParams, 
                                "<<ANDRI pollRecalculateService " + ":<PollRecalculateServicesVO>" + pollRecalculateServicesVO.toString() + "</PollRecalculateServicesVO>", 
                                pollRecalculateServicesVO.toXml());
                            }
                            else {
                                throw new Exception( "op Query facade " + " <pollRecalculateServicesVO> is null");
                            }
                        
                        } catch (AmspServiceException e) {
                            printOutput.printExceptionToShell(apiParams, "op Query Facade ", e);                    
                        } 
                        
                        
                        // disonnect part
                        try {
                            
                            orderResultVO = opDisconnectFacade.disconnect(customerDetailsVO, 
                                                                    pollRecalculateServicesVO.getOrderVO(), 
                                                                    siteDetailsVO, 
                                                                    customerDetailsVO.getBillingAddressFieldsArr(), 
                                                                    apiParams.getQueueHsdsHitFlag(),
                                                                    moneyTransactionVO,
                                                                    apiParams.getCorp(), 
                                                                    aLogin.getTicket()); 
                            
                            if (orderResultVO != null) {
                                    printOutput.printToShell(apiParams, "<<ANDRI orderResult VO " + 
                                                            ":<orderResultVO>" + orderResultVO.toString() + "</orderResultVO>",
                                                            orderResultVO.toXml());
                            } else {
                                    printOutput.printToShell(apiParams, "<<ANDRI orderResult VO " + ":<orderResultVO> is null", null);
                            }

                            
                        } catch (AmspServiceException e) {
                            printOutput.printExceptionToShell(apiParams, "opDisconnect Facade ", e);
                        } 
                        
                        
                        
                        
                        
                    }
                    else {
                        printOutput.printToShell(apiParams, "Site Lock Message: " + lockOutputVO.getMessage(), null);
                    } 
                    
                    // 11. Unlock site
                    lockOutputVO = lockServiceFacade.unLockSite( customerDetailsVO.getSiteId(), apiParams.getCorp(), aLogin.getTicket());
                    
                    printOutput.printToShell(apiParams, "Site unlock message: " + lockOutputVO.getMessage(), null);                  
                    
                    
                    // 11.B Unlock VAR
                    lockOutputVO = lockServiceFacade.unLockApcVarLock(customerDetailsVO.getSiteId(), apiParams.getCust_acct(), apiParams.getCorp(), 
                                                                      aLogin.getTicket());
                    
                    printOutput.printToShell(apiParams, "Var unlock message: " + lockOutputVO.getMessage(), null);
                    
                    
                    
                    
                }
                else {
                    printOutput.printToShell(apiParams, "Account & Var Lock Message: " + lockOutputVO.getMessage(), null);
                } 
                
                // 11.C Unlock Account
                lockOutputVO = lockServiceFacade.unLockAccount(apiParams.getCust_acct(), apiParams.getCorp(), aLogin.getTicket());
                printOutput.printToShell(apiParams, "Account unlock message: " + lockOutputVO.getMessage(), null);                       
                
                                
                // 12. Logout
                aLogin.logInOut(aLogin.LOGOUT(), apiParams, printOutput); 
                
                //cleanup display and print file
                apiParams.finishOutput(apiParams, printOutput);
                printOutput.finishOutput(apiParams, printOutput);
                
                
                
            } else {
                System.out.println("Login session is expired, please Relogin");
            }
            
            
        } catch (Exception ex) {
            System.out.println ("Error Expcetion from main ==> " + ex.toString());
        }
    
        
    
    }
}
