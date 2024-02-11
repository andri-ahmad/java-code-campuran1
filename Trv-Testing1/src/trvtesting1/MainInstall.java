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

public class MainInstall {
    
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
            apiParams.initParameters(Parameters.NEW_INSTALL , apiParams, printOutput);                 
                      
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
                    
                    // 5. Aman untuk melakukan install di site bersangkutan...
                    
                    // 6. INTI DARI INSTALL
                    // 6.A  GET DATA
                    // 6.B  SET DATA
                    // 6.C  SAVE DATA
                    
                    // 6.a part 1 - it is get Order
                    try {
                        orderVO = opInstallFacade.getNewInstallOrder(apiParams.getsiteId(), 
                                                    apiParams.getCust_acct(), 
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
                        printOutput.printExceptionToShell(apiParams, "Order Class ", e);
                    }
                    
                    // 6.a part 2 is get siteDetails
                    try {
                        // SiteDetailsVO 
                        siteDetailsVO = siteFacade.getSiteDetail(apiParams.getsiteId(),
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
                    
                    
                    // 6.a part 3 is get Customer details
                    try {
                        customerDetailsVO = opInstallFacade.getNewInstallCustomerDetails(apiParams.getsiteId(), 
                                                                                         apiParams.getCorp(), 
                                                                                         aLogin.getTicket());                       
                        
                        if (customerDetailsVO != null) {
                            printOutput.printToShell(apiParams, 
                            ":<customerDetailsVO>" + customerDetailsVO.toString() + "</CustomerDetailsVO>",
                            customerDetailsVO.toXml());
                        }
                        else {
                            throw new Exception("customerDetailsVO is null");
                        }
                        
                        }
                    catch (AmspServiceException e)  {
                        printOutput.printExceptionToShell(apiParams, "Customer Class", e);
                    }
                    
                    // 6.a part 4, get others: customer constraint
                    try {
                        customerConstraintsVO = accountConstraintsFacade.getCustomerConstraints(apiParams.getOrderType(),
                                                                            apiParams.getScheduleType(),
                                                                            apiParams.getCust_acct(),
                                                                            apiParams.getsiteId(),
                                                                            (short) apiParams.getAccountCategory(),
                                                                            apiParams.getCorp(), 
                                                                            aLogin.getTicket());
                        
                        if (customerConstraintsVO != null) {
                            printOutput.printToShell(apiParams, 
                            "<<ANDRI: Customer Constraint Get DATA>> " + ":<customerConstraintsVO>" + customerConstraintsVO.toString() + "</customerConstraintsVO>",
                            customerConstraintsVO.toXml());
                        }
                        else {
                            throw new Exception("customerConstraintsVO is null");
                        }
                    }
                    catch (AmspServiceException e)  {
                        printOutput.printExceptionToShell(apiParams, "Customer constraint ", e);
                    }
                    
                    // 6.a part 5, get money Transaction
                    try {
                        moneyTransactionVO = financialFacade.getNewMoneyTransaction(apiParams.getCust_acct(),
                                                                                apiParams.getsiteId(), 
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
                    
                    // 6.a part 6, get rate code                    
                    try {
                        rateCodeVO = corpparamFacade.getRateCodeDetail(apiParams.getRateCode1(), apiParams.getCorp(), aLogin.getTicket());
                                               
                        if (rateCodeVO != null) {
                            printOutput.printToShell(apiParams,
                            "<<ANDRI: RateCode Index Get DATA>> " + ":<rateCodeVO>" +rateCodeVO.toString() + "</rateCodeVO>",
                            rateCodeVO.toXml());
                            
                            rateCodeVOList[0] = rateCodeVO;
                        }
                        else {
                            throw new Exception("rateCodeVO is null");
                        }
                    
                    } catch (AmspServiceException e) {
                        printOutput.printExceptionToShell(apiParams, "<<ANDRI:RateCode Index " , e);
                    }
                    
                    
                    
                    // 6.B SET DATA
                    
                    // 6.b part 1, set set data yg perlu di Customer Details
                    customerDetailsVO.setAccountCategory((short) apiParams.getAccountCategory());
                    customerDetailsVO.setCampaignCode("113");
                    customerDetailsVO.setBillingAddressId(siteDetailsVO.getAddressId());
                    customerDetailsVO.setCustAcct(apiParams.getCust_acct());
                    customerDetailsVO.setCustClassCode(apiParams.getCustClassCode());
                    customerDetailsVO.setDateOfBirth(apiParams.getDateOfBirth());
                    if (customerConstraintsVO.getFirstName().getRequired()) {
                        customerDetailsVO.setFirstName(apiParams.getFirstName());
                    }
                    customerDetailsVO.setHomePhone(apiParams.getHomePhone());
                    if (customerConstraintsVO.getLastName().getRequired()) {
                        customerDetailsVO.setLastName(apiParams.getLastName());
                    }
                    if (customerConstraintsVO.getProductLanguage().getRequired()) {
                        customerDetailsVO.setProductLanguageCode(apiParams.getProductLanguage());
                    }
                    customerDetailsVO.setShippingAddressId(siteDetailsVO.getAddressId());
                    customerDetailsVO.setSiteId(apiParams.getsiteId());
                    customerDetailsVO.setTypeCode(apiParams.getTypeCode());
                    
                    printOutput.printToShell(apiParams, 
                                "<<ANDRI: CUSTDETAIL SET DATA>> Customer details VO" + ":<customerDetailsVO>" +        
                                customerDetailsVO.toString() + "</CustomerDetailsVO>",
                                customerDetailsVO.toXml());
                    
                    
                    // 6.b part 2, WIP task info
                    try {
                        code95VO = corpparamFacade.getWorkTaskCodes(apiParams.getCorp(), aLogin.getTicket());
                        
                        if (code95VO != null) {
                            
                            for (int i = 0; i != code95VO.length; i++) {                               
                                printOutput.printToShell(apiParams, 
                                "Code95VO " + ":<code95VO id=" + i + ">" + code95VO[i].toString() + "</code95VO>",
                                code95VO[i].toXml()); 
                            }
                            
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
                            "WIP task Info " + ":<wipTaskInfoVO>" + wipTaskInfoVO.toString() + "</wipTaskInfoVO>",
                            wipTaskInfoVO.toXml());
                        }
                        else {
                            printOutput.printToShell(apiParams, "WIP task Info " + "Task Code not found!", null);
                        }
                    
                    } catch (AmspServiceException e) {
                        printOutput.printExceptionToShell(apiParams, "WIP task Info ", e);
                    }
                    
                    // 6.B part 3, task info VO
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
                    
                    
                    // 6.B part 4, Update Retcode for Install
                    rateCodeVO.setAction(apiParams.getRateCodeVOaction());                    
                    rateCodeVO.setBillDate(apiParams.getBillDate());  
                    
                    rateCodeVOList[0] = rateCodeVO;
                    
                    printOutput.printToShell(apiParams, 
                             "<<ANDRI: SET RETCOde :"+  ":<rateCodeVO>" + rateCodeVO.toString() + "</rateCodeVO>",
                             rateCodeVO.toXml());
                    
                    // 6.B part 5, order group
                    orderGroupVOList[0] = new OrderGroupVO();
                    orderGroupVOList[0].setOrderGroupSeq(apiParams.getOrderGroupSeq());
                    
                    // 6.B part 6, Service Point VO
                    servicePointVOList[0] = new ServicePointVO();     
                    servicePointVOList[0].setCampaignCode("113");
                    servicePointVOList[0].setAction(apiParams.getServicePointVOaction());                    
                    servicePointVOList[0].setContractTemplateId(apiParams.getContractTemplateId());                    
                    servicePointVOList[0].setOrderGroup(orderGroupVOList[0].getOrderGroupSeq());                    
                    servicePointVOList[0].setRateCodeList(rateCodeVOList);
                    servicePointVOList[0].setServicePoint(apiParams.getServicePoint());
                    servicePointVOList[0].setServicePointLocationCode(apiParams.getServicePointLocationCode());                    
                    servicePointVOList[0].setTaskList(taskVOList);
                                        
                    printOutput.printToShell(apiParams, 
                                 "<<ANDRI SERvice Point : " + ":<servicePointVO>" + servicePointVOList[0].toString() + "</servicePointVO>",
                                 servicePointVOList[0].toXml());

                    orderInfoVO = orderVO.getOrderInfoList();
                    
                    scheduleVO = orderInfoVO.getSchedule();
                    
                    // 6.B part 7, Schedule VO
                    scheduleVO.setAction(apiParams.getScheduleVOaction());
                    scheduleVO.setIsMustDo(apiParams.getIsMustDo());
                    scheduleVO.setScheduleDate(apiParams.getScheduleDate());
                    scheduleVO.setScheduleType((short)apiParams.getScheduleType());
                    scheduleVO.setTechId(apiParams.getTechId());
                                        
                    printOutput.printToShell(apiParams, 
                                         "<<ANDRI Schedule VO " + ":<scheduleVO>" + scheduleVO.toString() + "</scheduleVO>",
                                         scheduleVO.toXml());
                    
                    // 6.B part 8, order info di set
                    orderInfoVO.setAction(apiParams.getOrderInfoVOaction());   
                    orderInfoVO.setCampaign("113");
                    orderInfoVO.setAgedMoney(agedMoneyVOList);
                    orderInfoVO.setBillDate(apiParams.getBillDate());
                    orderInfoVO.setBillToDate(apiParams.getBillDate());
                    orderInfoVO.setCycle(apiParams.getCycle());
                    orderInfoVO.setInstallDate(apiParams.getBillDate());
                    orderInfoVO.setLastInstallDate(customerDetailsVO.getLastInstallDate());
                    orderInfoVO.setNewCycle(Integer.toString(apiParams.getCycle()));
                    orderInfoVO.setOrderGroupSeq(orderGroupVOList[0].getOrderGroupSeq());
                    orderInfoVO.setProrateFromDate(apiParams.getBillDate());
                    orderInfoVO.setProrateToDate(apiParams.getBillDate());
                    orderInfoVO.setReminderScheme(apiParams.getReminderScheme());
                    orderInfoVO.setSalesRepId(apiParams.getSalesRepId());           
                    orderInfoVO.setSchedule(scheduleVO);
                    orderInfoVO.setSpecialInstruct1Code(apiParams.getSpecialInstruct1Code());                    
                    orderInfoVO.setWorkDoneDate(apiParams.getBillDate());
                    orderInfoVO.setWorkDoneTime(apiParams.getBillDate());
                    orderInfoVO.setDwellingTypeCode(siteDetailsVO.getDwellingTypeCode());
                    
                    printOutput.printToShell(apiParams, 
                                            "<<ANDRI Order Info VO : " + ":<OrderInfoVO>" + orderInfoVO.toString() + "</OrderInfoVO>", 
                                            orderInfoVO.toXml());
                    
                    // 6.B part 9, Contract VO di set
                    contractVOList[0] = new ContractVO();                   
                    contractVOList[0].setContractTemplateId(apiParams.getContractTemplateId());
                                       
                    printOutput.printToShell(apiParams, 
                                             "<<ANDRI Contract VO " + ":<contractVO>" + contractVOList[0].toString() + "</contractVO>",
                                             contractVOList[0].toXml());
                    
                    // 6.B part 10, order info VO di set
                    orderVO.setContract(contractVOList);
                    orderVO.setCustAcct(apiParams.getCust_acct());
                    orderVO.setInstallType((short) apiParams.getInstallType());
                    orderVO.setIsOffer(apiParams.getIsOffer());
                    orderVO.setIsProspect(apiParams.getIsProspect());
                    orderVO.setJobType(apiParams.getJobType());
                    orderVO.setOperatorId(apiParams.getOperatorId());
                    orderVO.setOrderInfoList(orderInfoVO);
                    orderVO.setOrderType(apiParams.getOrderType()); 
                    orderVO.setServicePointList(servicePointVOList);
                    orderVO.setCallerName("TEST-API");
                    
                    if (orderVO != null) {
                        printOutput.printToShell(apiParams, 
                        "<<ANDRI Order VO " + ":<OrderVO>" + orderVO.toString() + "</OrderVO>",
                        orderVO.toXml());
                    }
                    
                    // 6.B part 11, Apply Contract Services
                    
                    try {
                        orderVO = contractsFacade.applyContractServices(orderVO, apiParams.getCorp(), aLogin.getTicket());
                        
                        if (orderVO != null) {
                            printOutput.printToShell(apiParams, 
                            "<<ANDRI Order Vo after Apply Contract : " + ":<orderVO>" + orderVO.toString() + "</orderVO>", 
                            orderVO.toXml());
                        }
                        else {
                            throw new Exception("Contract Facade" + " <orderVO> is null");
                        }
                    
                    } catch (AmspServiceException e) {
                        printOutput.printExceptionToShell(apiParams, "Contract Facade Error : ", e);                        
                    }
                   
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
                    
                    
                    
                    // 6.c part of save data
                    
                    try {
                        orderResultVO = opInstallFacade.install(customerDetailsVO, 
                                                                siteDetailsVO, 
                                                                pollRecalculateServicesVO.getOrderVO(), 
                                                                null, 
                                                                moneyTransactionVO, 
                                                                apiParams.getQueueHsdsHitFlag(),
                                                                apiParams.getOverriddenRuleIds(),
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
			printOutput.printExceptionToShell(apiParams, "opInstall Facade ", e);
                    }   
                    
                    
                    
                    
                } else {
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
