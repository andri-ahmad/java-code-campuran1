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
import amdocs.amsp.services.OpChangeOfServiceFacade;
import amdocs.amsp.services.OpInstallFacade;
import amdocs.amsp.services.OpQueryFacade;
import amdocs.amsp.services.OpRescheduleFacade;
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

public class MainRescheduleOrder {
    
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
        OrderVO orderVO = new OrderVO();
        ContractsFacade contractsFacade = new ContractsFacade();
        OrderResultVO orderResultVO = new OrderResultVO();
        PollRecalculateServicesVO pollRecalculateServicesVO = new PollRecalculateServicesVO();
        SiteFacade siteFacade = new SiteFacade();
        SiteDetailsVO siteDetailsVO = null;
        CustomerDetailsVO customerDetailsVO = new CustomerDetailsVO();
        AccountConstraintsFacade accountConstraintsFacade = new AccountConstraintsFacade();
        CustomerConstraintsVO customerConstraintsVO = new CustomerConstraintsVO();
        FinancialFacade financialFacade = new FinancialFacade();
        MoneyTransactionVO moneyTransactionVO = new MoneyTransactionVO();
        CorpparamFacade corpparamFacade = new CorpparamFacade();
        RateCodeVO rateCodeVO1 = new RateCodeVO();        
        RateCodeVO[] rateCodeVOList = new RateCodeVO[6];
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
        pollRecalculateServicesVO = new PollRecalculateServicesVO();
        OpQueryFacade opQueryFacade = new OpQueryFacade();
        OpChangeOfServiceFacade opCOS = new OpChangeOfServiceFacade();
        CustomerFacade customerFacade = new CustomerFacade();
        PromosFacade promosFacade = new PromosFacade();
        OrderGroupVO[] orderGroupVO = null;
        AccountViewWipFacade accountViewWipFacade = new AccountViewWipFacade();
        PromoVO promoVO = new PromoVO();
        OpRescheduleFacade opRescheduleFacade = new OpRescheduleFacade();
        ServicePointVO[] servicePointVOlist = null;
        ServicePointVO servicePointVO;
                
        System.out.println("Login Class created....");
        Login aLogin = new Login();
        try {
            System.out.println("Reschedule Order subcriber....");
            
            PrintOutput printOutput = new PrintOutput();           
            
            Configuration.appName = Configuration.AMSP_API_APP_NAME;
            
            System.out.println("Parameter Class created....");
            Parameters apiParams = new Parameters();
            apiParams.setUser("ANDRI");
            apiParams.setPassword("ANDRI");
            
            System.out.println("Init Parameter start...");
            apiParams.initParameters(Parameters.RESCHEDULE_ORDER , apiParams, printOutput);                 
                      
            //aLGORITMA ReSchedule Order
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
                    
                    // 5. Aman untuk melakukan ReSChedule Order di Account bersangkutan...
                    
                    // 6. INTI DARI ReSchedule
                    // 6.A  GET DATA, get customer detail, get site detail dari customer detail
                    // 6.B  SET DATA
                    // 6.C  SAVE DATA   
                    
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
                    
                    if (siteLock && varLock) {
                        
                        
                        // 6.A.1 Get order Install
                        try {
                            orderVO = accountViewWipFacade.getWipOrderInfo(
                                            apiParams.getCust_acct(),
                                            apiParams.getOffernum(),
                                            ServiceConstantsI.JobType.JOBTYPE_INSTALL.getJobTypeValue(),
                                            apiParams.getCorp(),
                                            aLogin.getTicket());
                        
                            if (orderVO != null) {
                                    printOutput.printToShell(apiParams, 
                                                      ":<OrderVO>" + orderVO.toString() + "</OrderVO>",
                                                    orderVO.toXml());
                            }
                            else {
                                    throw new Exception("orderVO is null");
                            }                       
                        
                        } catch (AmspServiceException e) {
                                printOutput.printExceptionToShell(apiParams, "accountViewWipFacade", e);
                        }
                        
                        // 6.a.2 site detail
                        try {
                            // SiteDetailsVO 
                            siteDetailsVO = siteFacade.getSiteDetail(customerDetailsVO.getSiteId(),
                                         apiParams.getCorp(), 
                                         aLogin.getTicket());
                            
                            if (siteDetailsVO != null) {
                                printOutput.printToShell(apiParams, 
                                "<<ANDRI GETDATA siteFacade.getSiteDetail:<SiteDetailsVO>" +     siteDetailsVO.toString() + "</SiteDetailsVO>",
                                siteDetailsVO.toXml());
                            }
                            else {
                                throw new Exception("siteDetailsVO is null");
                            }
                        
                        } catch (AmspServiceException e) {
                            printOutput.printExceptionToShell(apiParams, "Site Class ", e);
                        }
                        
                        
                        
                        // 6.a.3 money transaction
                        try {
                            moneyTransactionVO = financialFacade.getNewMoneyTransaction(apiParams.getCust_acct(),
                                                                                    customerDetailsVO.getSiteId(), 
                                                                                    apiParams.getCallerName(),
                                                                                    apiParams.getCorp(),
                                                                                    aLogin.getTicket());
                            
                            if (moneyTransactionVO != null) {
                                printOutput.printToShell(apiParams, 
                                "<<ANDRI:GET financialFacade.getNewMoneyTransaction " + ":<moneyTransactionVO>" + moneyTransactionVO.toString() + "</moneyTransactionVO>",
                                moneyTransactionVO.toXml());
                            }
                            else {
                                throw new Exception("moneyTransactionVO is null");
                            }
                        
                        } catch (AmspServiceException e) {
                            printOutput.printExceptionToShell(apiParams, "Monet Trx ", e);
                        }
                        
                        // 6.b part 1, WIP task info
                        try {
                            code95VO = corpparamFacade.getWorkTaskCodes(apiParams.getCorp(), aLogin.getTicket());
                            
                            if (code95VO != null) {
                                /*
                                for (int i = 0; i != code95VO.length; i++) {                               
                                    printOutput.printToShell(apiParams, 
                                    "Code95VO " + ":<code95VO id=" + i + ">" + code95VO[i].toString() + "</code95VO>",
                                    code95VO[i].toXml()); 
                                }
                                */
                            } 
                            else {
                                throw new Exception("code95VO is null");
                            }
                            
                            for (int i = 0; i != code95VO.length; i++) {
                                if (apiParams.getTaskCode().trim().equals(code95VO[i].getCode().trim())) {
                                    wipTaskInfoVO.setTaskCode(code95VO[i].getCode());
                                    wipTaskInfoVO.setTaskDescription(code95VO[i].getShortDes());
                                    wipTaskInfoVO.setWorkPoints(Integer.valueOf(code95VO[i].getWorkPoints().trim()));
                                }
                            }
                            
                            if (wipTaskInfoVO.getTaskCode() != null) {
                                printOutput.printToShell(apiParams, "WIP Task Info " + " Task Code found ", null);
                                printOutput.printToShell(apiParams, 
                                "<<ANDRI: WIP task Info " + ":<wipTaskInfoVO>" + wipTaskInfoVO.toString() + "</wipTaskInfoVO>",
                                wipTaskInfoVO.toXml());
                            }
                            else {
                                printOutput.printToShell(apiParams, "WIP task Info " + "Task Code not found!", null);
                            }
                        
                        } catch (AmspServiceException e) {
                            printOutput.printExceptionToShell(apiParams, "WIP task Info ", e);
                        }
                        
                        // 6.B part 2, task info VO
                        taskVO.setPoints((short)wipTaskInfoVO.getWorkPoints());
                        taskVO.setTaskCode(wipTaskInfoVO.getTaskCode());
                        taskVOList[0] = taskVO;                    
                        
                        if (taskVOList[0] != null) {
                                printOutput.printToShell(apiParams, 
                                                "<<ANDRI TASK VO "+ ":<taskVO>" + taskVOList[0].toString() + "</taskVO>",
                                                taskVOList[0].toXml());
                        }
                        else {
                                printOutput.printToShell(apiParams, "taskVOList[0] " + ":<taskVO> is null", null);
                        }
                        
                        // 6.B part 4. get order group VO dari customer
                        try {
                            orderGroupVO = accountViewWipFacade.getOpenOrderGroupList(apiParams.getCust_acct(), apiParams.getOrderType(), apiParams.getCorp(), aLogin.getTicket());
                            
                            if (orderGroupVO != null) {
                                for (int i = 0; i != orderGroupVO.length; i++) {
                                        printOutput.printToShell(apiParams, 
                                            "<<ANDRI get accountViewWipFacade.getOpenOrderGroupList" + ":<OrderGroupVO>" +      orderGroupVO[i].toString() + "</OrderGroupVO>",
                                            orderGroupVO[i].toXml());
                                        }
                                    
                            }
                            else {
                                    throw new Exception("orderGroupVO is null");
                            }
                            
                        }
                        catch (AmspServiceException e)  {
                                printOutput.printExceptionToShell(apiParams, "accountViewWipFacade.getOpenOrderGroupList", e);
                        }
                        
                        
                        // 6.B part 5, order group
                        orderGroupVOList[0] = orderGroupVO[0];
                        orderGroupVOList[0].setOrderGroupSeq(orderGroupVO[0].getOrderGroupSeq());
                        
                        // 6.b Get the order info VO
                        orderInfoVO = orderVO.getOrderInfoList();
                        
                        scheduleVO = orderInfoVO.getSchedule();
                        
                        // set the schedule
                        scheduleVO.setAction(apiParams.getScheduleVOaction());
                        scheduleVO.setIsMustDo(apiParams.getIsMustDo());
                        scheduleVO.setScheduleDate(apiParams.getScheduleDate());
                        scheduleVO.setScheduleType((short)ServiceConstantsI.NO_TRUCK);
                        scheduleVO.setTechId(apiParams.getTechId());
                        
                        // set the order Info the schedule
                        // 6.B part 9, order info di set
                        orderInfoVO.setAction(apiParams.getOrderInfoVOaction());                         
                        orderInfoVO.setBillDate(apiParams.getBillDate());
                        orderInfoVO.setBillToDate(apiParams.getBillDate());                        
                        orderInfoVO.setOrderGroupSeq(orderGroupVOList[0].getOrderGroupSeq());
                        orderInfoVO.setProrateFromDate(apiParams.getBillDate());
                        orderInfoVO.setProrateToDate(apiParams.getBillDate());                                  
                        orderInfoVO.setSchedule(scheduleVO);    
                        orderInfoVO.setWorkDoneDate(apiParams.getBillDate());
                        orderInfoVO.setWorkDoneTime(apiParams.getBillDate());
                        orderInfoVO.setSalesRepId(apiParams.getSalesRepId());
                        orderInfoVO.setDwellingTypeCode(siteDetailsVO.getDwellingTypeCode());
                        orderInfoVO.setSpecialInstruct1Code(apiParams.getSpecialInstruct1Code());
                        
                        // get service point
                        servicePointVOlist = orderVO.getServicePointList();
                        servicePointVO = servicePointVOlist[0];
                        
                        // set service point
                        servicePointVO.setAction((short)0); // No Change
                        
                        // baalikin ke array
                        servicePointVOlist[0] = servicePointVO;
                        
                        
                        // set the order                             
                        
                        orderVO.setCustAcct(apiParams.getCust_acct());
                        orderVO.setInstallType((short) apiParams.getInstallType());
                        orderVO.setIsOffer(apiParams.getIsOffer());
                        orderVO.setIsProspect(apiParams.getIsProspect());
                        orderVO.setJobType(apiParams.getJobType());
                        orderVO.setOperatorId(apiParams.getOperatorId());                       
                        orderVO.setOrderType(apiParams.getOrderType()); 
                        orderVO.setContract(contractVOList);
                        orderVO.setServicePointList(servicePointVOList);
                        orderVO.setOrderInfoList(orderInfoVO);
                        orderVO.setCallerName("TEST-API");
                        
                        if (orderVO != null) {
                            printOutput.printToShell(apiParams, 
                            "<<ANDRI:set Order VO " + ":<OrderVO>" + orderVO.toString() + "</OrderVO>",
                            orderVO.toXml());
                        }
                        
                       
                        
                        // 6.B part 13, Recalculate Services
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
                        
                        
                        /// Final, call the reschedule API                        
                        try {
                            orderResultVO = opRescheduleFacade.reschedule(customerDetailsVO, 
                                                                    siteDetailsVO,
                                                                    orderVO,
                                                                    moneyTransactionVO,
                                                                    apiParams.getQueueHsdsHitFlag(),
                                                                    apiParams.getOverriddenRuleIds(),
                                                                    apiParams.getCorp(), 
                                                                    aLogin.getTicket());                                  
                                 
                            
                            if (orderResultVO != null) {
                                    printOutput.printToShell(apiParams, "<<ANDRI orderResultVO = opRescheduleFacade.reschedule" + 
                                                            ":<orderResultVO>" + orderResultVO.toString() + "</orderResultVO>",
                                                            orderResultVO.toXml());
                            } else {
                                    printOutput.printToShell(apiParams, "<<ANDRI orderResult VO " + ":<orderResultVO> is null", null);
                            }
                            
                        } catch (AmspServiceException e) {
                            printOutput.printExceptionToShell(apiParams, "opRescheduleFacade  ", e);
                        }
                        
                        
                        
                        
                        
                        
                        
                    } else {
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
                    printOutput.printToShell(apiParams, "Account: " + lockOutputVO.getMessage(), null);
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
