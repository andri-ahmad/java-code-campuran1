package trvtesting1;

import amdocs.amsp.AddressConstantsI;
import amdocs.amsp.Configuration;
import amdocs.amsp.FrameworkConstantsI;
import amdocs.amsp.ServiceConstantsI;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.AccountConstraintsFacade;
import amdocs.amsp.services.AddressServiceFacade;
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
import amdocs.amsp.valueobject.addressservice.AddressFieldsDetailVO;
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

public class MainInstallwithPSwithBillAddress {
    
    public static void main(String[] args) throws Exception{
        // variables
        boolean session;
        boolean apcLock          = false;
        boolean siteLock         = false;
        boolean acctLock         = false;
        boolean varLock          = false;
        boolean techLock         = false;
        boolean phoneNumberLock  = false;
        String billingAdress     = "";
        
        int decoder = 2;
        
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
        RateCodeVO rateCodeVO1 = new RateCodeVO();
        RateCodeVO rateCodeVO2 = new RateCodeVO();        
        RateCodeVO[] rateCodeVOList1 = new RateCodeVO[2];        
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
        PromoVO promoVO2 = new PromoVO();
        PromosFacade promosFacade = new PromosFacade();
        AddressServiceFacade addressServiceFacade = new AddressServiceFacade();
        AddressFieldsDetailVO[] addressFieldsDetailVO;
                
        System.out.println("Login Class created....");
        Login aLogin = new Login();
        try {
            System.out.println("Activating subcriber....");
            
            PrintOutput printOutput = new PrintOutput();           
            
            Configuration.appName = Configuration.AMSP_API_APP_NAME;
            
            System.out.println("Parameter Class created....");
            Parameters apiParams = new Parameters();
            //apiParams.setUser("PASSION");
            //apiParams.setPassword("PASSION");
            
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
                        printOutput.printExceptionToShell(apiParams, "opInstallFacade.getNewInstallOrder ", e);
                        
                        System.exit(-1);
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
                    
                    // PROMO VO
                    // 6.B part 12.. Get Promo Detail
                    try {
                        promoVO = promosFacade.getPromoDetails(null, apiParams.getCorp(), aLogin.getTicket());
                        
                        if (promoVO != null) {
                            printOutput.printToShell(apiParams, 
                            "<<ANDRI promoVO " + ":<promoVO>" + promoVO.toString() + "</promoVO>", 
                            promoVO.toXml());
                            
                            promoVO.setAction((short)2);                           
                            
                                                        
                        }
                        else {
                            throw new Exception( "opromoVO " + " <promoVO> is null");
                        }                      
                        
                        
                    } catch (AmspServiceException e) {
                        printOutput.printExceptionToShell(apiParams, "Promos Facade ", e);
                    }
                    
                    // PROMO VO
                    // 6.B part 12.. Get Promo Detail
                    try {
                        promoVO2 = promosFacade.getPromoDetails(null, apiParams.getCorp(), aLogin.getTicket());
                        
                        if (promoVO2 != null) {
                            printOutput.printToShell(apiParams, 
                            "<<ANDRI promoVO " + ":<promoVO2>" + promoVO2.toString() + "</promoVO2>", 
                            promoVO2.toXml());
                            
                            promoVO2.setAction((short)2);                           
                            
                                                        
                        }
                        else {
                            throw new Exception( "opromoVO " + " <promoVO> is null");
                        }                      
                        
                        
                    } catch (AmspServiceException e) {
                        printOutput.printExceptionToShell(apiParams, "Promos Facade ", e);
                    }
                    
                    // 6.a part 6, get rate code     
                    // Buat rateCode sebayanyak jumlah decoder
                    
                    try {
                        rateCodeVO1 = corpparamFacade.getRateCodeDetail("GP", apiParams.getCorp(), aLogin.getTicket());
                                               
                        if (rateCodeVO1 != null) {
                            printOutput.printToShell(apiParams,
                            "<<ANDRI: RateCode Index Get DATA>> " + ":<rateCodeVO>" +rateCodeVO1.toString() + "</rateCodeVO>",
                            rateCodeVO1.toXml());      
                            // 6.B part 4, Update Retcode for Install
                            rateCodeVO1.setAction(apiParams.getRateCodeVOaction());                    
                            rateCodeVO1.setBillDate(apiParams.getBillDate());  
                            rateCodeVO1.setPromo(promoVO);
                            
                        }
                        else {
                            throw new Exception("rateCodeVO is null");
                        }
                    
                    } catch (AmspServiceException e) {
                        printOutput.printExceptionToShell(apiParams, "<<ANDRI:RateCode Index " , e);
                    }
                    
                    try {
                        rateCodeVO2 = corpparamFacade.getRateCodeDetail("BL", apiParams.getCorp(), aLogin.getTicket());
                                          
                        
                        if (rateCodeVO2 != null) {
                            printOutput.printToShell(apiParams,
                            "<<ANDRI: RateCode Index Get DATA>> " + ":<rateCodeVO>" +rateCodeVO2.toString() + "</rateCodeVO>",
                            rateCodeVO2.toXml());
                            
                            rateCodeVO2.setAction(apiParams.getRateCodeVOaction());                    
                            rateCodeVO2.setBillDate(apiParams.getBillDate());    
                            rateCodeVO2.setPromo(promoVO2);
                           
                            
                        }
                        else {
                            throw new Exception("rateCodeVO is null");
                        }
                    
                    } catch (AmspServiceException e) {
                        printOutput.printExceptionToShell(apiParams, "<<ANDRI:RateCode Index " , e);
                    }
                    
                    rateCodeVOList1[0] = rateCodeVO1;
                    rateCodeVOList1[1] = rateCodeVO2;
                    
                    
                   
                    // 6.B Customer Detail
                    
                    // Setting Billing Address,
                    //7. Get Address Fields Detail (AddressServiceFacade)
                    addressFieldsDetailVO = addressServiceFacade.getAddressFields(AddressConstantsI.AddrUseContext.BILLING_ADDRESS.getAddrUseContextValue(),
                                                                                  siteDetailsVO.getAddressId(),
                                                                                  apiParams.getCorp(),
                                                                                  aLogin.getTicket());
                    //8. Iterate through elements of the Address Fields Details array (AddressFieldsDetailVO[])
                    if (addressFieldsDetailVO != null) {
                        for (int i = 0; i != addressFieldsDetailVO.length; i++) {
                            
                            /*
                            if (addressFieldsDetailVO[i].getNlsNum() == 3) {
                                addressFieldsDetailVO[i].setValue("JL. ANDRI 4");
                            }
                            if (addressFieldsDetailVO[i].getNlsNum() == 21) {
                                addressFieldsDetailVO[i].setValue("-7.66519,111.31629");
                            }
                            if (addressFieldsDetailVO[i].getNlsNum() == 28) {
                                addressFieldsDetailVO[i].setValue("KEL. KALICEBONG");
                            }
                            if (addressFieldsDetailVO[i].getNlsNum() == 15) {
                                addressFieldsDetailVO[i].setValue("KEC. PASARMALAM");
                            }
                            if (addressFieldsDetailVO[i].getNlsNum() == 4) {
                                addressFieldsDetailVO[i].setValue("KOTA JAKARTA");
                            }*/
                            
                            if (addressFieldsDetailVO[i].getNlsNum() == 3) {
                                addressFieldsDetailVO[i].setValue("Jl. DODOL GARUT EUY...");
                                billingAdress = billingAdress + addressFieldsDetailVO[i].getValue();                                    
                            }
                            if (addressFieldsDetailVO[i].getNlsNum() == 28) {
                                addressFieldsDetailVO[i].setValue("JELUPANG");
                                billingAdress = billingAdress + addressFieldsDetailVO[i].getValue();
                            }
                            if (addressFieldsDetailVO[i].getNlsNum() == 27) {
                                addressFieldsDetailVO[i].setValue("BANTEN");
                                billingAdress = billingAdress + addressFieldsDetailVO[i].getValue();
                            }
                            if (addressFieldsDetailVO[i].getNlsNum() == 15) {
                                addressFieldsDetailVO[i].setValue("SERPONG UTARA");
                                billingAdress = billingAdress + addressFieldsDetailVO[i].getValue();
                            }
                            if (addressFieldsDetailVO[i].getNlsNum() == 4) {
                                addressFieldsDetailVO[i].setValue("KOTA TANGGERANG SELATAN");
                                billingAdress = billingAdress + addressFieldsDetailVO[i].getValue();
                            }
                            if (addressFieldsDetailVO[i].getNlsNum() == 5) {
                                addressFieldsDetailVO[i].setValue("15323");
                                billingAdress = billingAdress + addressFieldsDetailVO[i].getValue();
                            }
                            
                            printOutput.printToShell(apiParams, ":<addressVO id=" + i + ">" + addressFieldsDetailVO[i].toString() 
                                                                + "</addressVO>", addressFieldsDetailVO[i].toXml());
                            
                            
                        }
                    }
                    else {
                            printOutput.printToShell(apiParams, ":<addressFieldsDetailVO> is null", null);
                    }
                    
                    // 6.b part 1, set set data yg perlu di Customer Details
                    customerDetailsVO.setAccountCategory((short) apiParams.getAccountCategory());
                    customerDetailsVO.setCampaignCode("4");
                     
                    
                    customerDetailsVO.setBillingAddressId(siteDetailsVO.getAddressId());
                    customerDetailsVO.setBillingAddress("TESTING");                    
                    customerDetailsVO.setBillingAddressFieldsArr(addressFieldsDetailVO);
                    customerDetailsVO.setBillingAddressUpdated(true);
                    
                    
                    customerDetailsVO.setCustAcct(apiParams.getCust_acct());
                    customerDetailsVO.setCustClassCode(apiParams.getCustClassCode());                    
                    customerDetailsVO.setDateOfBirth(apiParams.getDateOfBirth());
                    //if (customerConstraintsVO.getFirstName().getRequired()) {
                        customerDetailsVO.setFirstName(apiParams.getFirstName());
                    //}
                    //customerDetailsVO.setHomePhone(apiParams.getHomePhone());
                    customerDetailsVO.setHomePhone("1234567898");
                    customerDetailsVO.setMobilePhone("62818126374");
                    //if (customerConstraintsVO.getLastName().getRequired()) {
                        customerDetailsVO.setLastName(apiParams.getLastName());
                    //}
                    if (customerConstraintsVO.getProductLanguage().getRequired()) {
                        customerDetailsVO.setProductLanguageCode(apiParams.getProductLanguage());
                    }
                    //customerDetailsVO.setShippingAddressId(siteDetailsVO.getAddressId());
                    customerDetailsVO.setSiteId(apiParams.getsiteId());
                    customerDetailsVO.setTypeCode(apiParams.getTypeCode());
                    //customerDetailsVO.setDealer("TNK");
                    customerDetailsVO.setDealer("MTD");
                    customerDetailsVO.setSalesChannel("MTR");
                    
                    printOutput.printToShell(apiParams, 
                                "<<ANDRI: CUSTDETAIL SET DATA>> Customer details VO" + ":<customerDetailsVO>" +        
                                customerDetailsVO.toString() + "</CustomerDetailsVO>",
                                customerDetailsVO.toXml());
                    
                    
                    // 6.b part 2, WIP task info
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
                    
                   
                    
                    // 6.B part 5, order group
                    orderGroupVOList[0] = new OrderGroupVO();
                    orderGroupVOList[0].setOrderGroupSeq(apiParams.getOrderGroupSeq());
                    
                    // 6.B part 6, Service Point VO
                    servicePointVOList[0] = new ServicePointVO();     
                    servicePointVOList[0].setCampaignCode("113");
                    servicePointVOList[0].setAction(apiParams.getServicePointVOaction());                    
                    servicePointVOList[0].setContractTemplateId(apiParams.getContractTemplateId());                    
                    servicePointVOList[0].setOrderGroup(orderGroupVOList[0].getOrderGroupSeq());                    
                    servicePointVOList[0].setRateCodeList(rateCodeVOList1);
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
                   
                     
                    
                    
                    // 6.B part 11-a, Confirming The services
                    try {
                          
                        
                        orderVO = opQueryFacade.confirmServices(orderVO,                                                
                                                      apiParams.getCorp(), 
                                                        aLogin.getTicket());
                        
                        if (orderVO != null) {
                            printOutput.printToShell(apiParams, 
                            "<<ANDRI orderVO After Confirm " + ":<orderVO After Confirm>" + orderVO.toString() + "</orderVO After Confirm>", 
                            orderVO.toXml());
                        }
                        else {
                            throw new Exception( "op Query facade " + " <orderVO after confirm> is null");
                        }
                    
                    } catch (AmspServiceException e) {
                        printOutput.printExceptionToShell(apiParams, "op Query Facade -> confirm Service ", e);                    
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
			printOutput.printExceptionToShell(apiParams, "opDisonnect Facade ", e);
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
