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

public class MainAssignEquipment {
    
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
        CustomerFacade customerFacade = new CustomerFacade();
        EquipmentVO equipmentVO = new EquipmentVO();
        EquipmentVO[] equipmentVOlist = new EquipmentVO[1];
        ServicePointFacade servicePointFacade = new ServicePointFacade();
        VideoEquipmentConstraintsVO videoEquipmentConstraintsVO = new VideoEquipmentConstraintsVO();
        OpMainOrderOptionFacade opMainOrderOptionFacade = new OpMainOrderOptionFacade();
        EquipmentValidationVO equipmentValidationVO = new EquipmentValidationVO();
        ServicePointVO[] servicePointVOList = null;
               
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
            apiParams.initParameters(Parameters.ASSIGN_EQUIP , apiParams, printOutput);                 
                      
            //aLGORITMA Assigned
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
                    
                    // 5. Aman untuk melakukan Assigned Equipment di Account bersangkutan...
                    
                    // 6. INTI
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
                    
                    
                    // pastikan site dan varlock OK
                    if (siteLock && varLock) {
                        
                        
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
                        
                        // ini adalah equipment yg akan di masukin ke subscriber
                        equipmentVOlist[0] = equipmentVO;
                        
                        // ini constraint
                        try {
                            videoEquipmentConstraintsVO = accountConstraintsFacade.getVideoEquipmentConstraints(apiParams.getOrderType(),
                                                                                apiParams.getEquipmentVOaction(),
                                                                                equipmentVO,
                                                                                customerDetailsVO.getSiteId(),
                                                                                apiParams.getCorp(), 
                                                                                aLogin.getTicket());

                            if (videoEquipmentConstraintsVO != null) {
                                    printOutput.printToShell(apiParams, 
                                                     "<<ANDRI :<videoEquipmentConstraintsVO>" + videoEquipmentConstraintsVO.toString() + "</videoEquipmentConstraintsVO>",
                                                    videoEquipmentConstraintsVO.toXml());
                            }
                            else {
                                    throw new Exception("videoEquipmentConstraintsVO is null");
                            }
                            
                        }
                        catch (AmspServiceException e)  {
                                printOutput.printExceptionToShell(apiParams, "accountConstraintsFacade", e);
                        }
                        
                        
                        // service point
                        try {
                            servicePointVOList = servicePointFacade.getAllServicePoints(apiParams.getCust_acct(),
                                                                                    apiParams.getsiteId(),
                                                                                    apiParams.getOrderGroupSeq(),
                                                                                    apiParams.getCorp(),
                                                                                    aLogin.getTicket());
                                                                                    
                                                                                    
                            if (servicePointVOList != null) {
                                printOutput.printToShell(apiParams, "<service point>Tidak Null, panjang : " + servicePointVOList.length, null);
                                    for (int i = 0; i != servicePointVOList.length; i++) {
                                            printOutput.printToShell(apiParams, 
                                                            "servicePointVOList" + ":<servicePointVO id=" + i + ">" + servicePointVOList[i].toString() + "</servicePointVO>",
                                                            servicePointVOList[i].toXml());
                                    }
                            }
                            else {
                                    printOutput.printToShell(apiParams, "servicePointVOList" + ":<servicePointVO> is null", null);
                            }
                        }
                        catch (AmspServiceException e)  {
                                printOutput.printExceptionToShell(apiParams, "servicePointVOList", e);
                        }
                        
                        
                        // Set the equipment.
                        equipmentVO.setAction(apiParams.getEquipmentVOaction());
                        equipmentVO.setOutlet(apiParams.getOutlet());
                        if (videoEquipmentConstraintsVO.getRating().getRequired()) {
                            equipmentVO.setRating("2"); //Valid Values: 0 = G, 1 = PG, 2 = R, 3 = X
                        }
                        equipmentVO.setPrevSerialNumber("NO Boxes");
                        equipmentVO.setSubscriberOwned(true);
                        equipmentVO.setLocation("1");
                        
                        
                        printOutput.printToShell(apiParams, 
                                  ":<equipmentVO>" + equipmentVO.toString() + "</equipmentVO>",
                                 equipmentVO.toXml());
                        
                        
                        equipmentVOlist[0] = equipmentVO;
                        
                        
                        // Set the service point
                        servicePointVOList[0].setAction(apiParams.getServicePointVOaction());
                        servicePointVOList[0].setEquipment(equipmentVOlist);  
                        servicePointVOList[0].setServicePointLocationCode("1");  
                       
                        
                        printOutput.printToShell(apiParams, 
                                 ":<servicePointVO>" + servicePointVOList[0].toString() + "</servicePointVO>",
                                 servicePointVOList[0].toXml());
                        
                        // Validasi Equipment
                        // Cek Validation of Equipment
                        try {
                            equipmentValidationVO = opMainOrderOptionFacade.validateSerialNumber(
                                                                apiParams.getEquipmentId(), 
                                                                 apiParams.getServicePoint(), 
                                                                 apiParams.getsiteId(),
                                                                 apiParams.getCust_acct(), 
                                                                servicePointVOList, 
                                                                apiParams.getCorp(), 
                                                                aLogin.getTicket());
                            
                            if (equipmentValidationVO != null) {
                                for (int i = 0; i != equipmentValidationVO.getValidationMessageList().length; i++) {                               
                                    printOutput.printToShell(apiParams, 
                                    "equipmentValidationVO " + ":<equipmentValidationVO id=" + i + ">" + equipmentValidationVO.getValidationMessageList()[i].toString() + "</getValidationMessageList>",
                                    ""); 
                                }
                            }
                        } catch (AmspServiceException e)  {
                                printOutput.printExceptionToShell(apiParams, "opMainOrderOptionFacade.validateSerialNumber", e);
                        }                       
                        
                        
                        // Jika ada validasi Exception
                        printOutput.printToShell(apiParams, "ANDRI:CHECKING VALIDATION",""); 
                        if (equipmentValidationVO.getValidationMessageList().length != 0) {
                            
                            for (int i = 0; i != equipmentValidationVO.getValidationMessageList().length; i++) {                               
                                printOutput.printToShell(apiParams, 
                                "equipmentValidationVO " + ":<equipmentValidationVO id=" + i + ">" + equipmentValidationVO.getValidationMessageList()[i].toString() + "</getValidationMessageList>",
                                ""); 
                                
                                // Exception 1.
                                // Jika 12076 = Artinya area management Kartu dan Area management Site berbeda.
                                if (equipmentValidationVO.getValidationMessageList()[i].getMsgId().trim().equals("12076")) {
                                    validasiarea=true;                                    
                                }
                                
                                // Exception 2.
                                // Jika 12077 =  artinya user yang dipakai mempunyai capability untuk override, bisa menggunakan kode area mangement manapun.
                                if (equipmentValidationVO.getValidationMessageList()[i].getMsgId().trim().equals("12077")) {
                                    validasioverride=true;                                    
                                }
                            }
                            
                            if (validasiarea && validasioverride) {
                                validExecute = true;
                            }
                            
                            printOutput.printToShell(apiParams, "ANDRI:validasiarea=" + validasiarea + ";validasioverride= "+validasioverride ,"");
                            
                        } 
                        // tidak ada validasi, bisa eksekusi 
                        else {
                            validExecute = true;
                        }
                        
                        
                        if (validExecute) {
                            
                            printOutput.printToShell(apiParams, "ANDRI:VALID EKSEKUSi","");
                            
                            try {
                                                    
                                orderResultVO = opMainOrderOptionFacade.updateBoxData(servicePointVOList, 
                                                                                      apiParams.getCust_acct(), 
                                                                                      apiParams.getsiteId(), 
                                                                                      apiParams.getServiceGroup(), 
                                                                                      apiParams.getCallerName(), 
                                                                                      apiParams.getOverriddenRuleIds(), 
                                                                                      false, 
                                                                                      apiParams.getCorp(), 
                                                                                      aLogin.getTicket());
                                printOutput.printToShell(apiParams, 
                                ":<orderResultVO>" + orderResultVO.toString() + "</orderResultVO>",
                                 orderResultVO.toXml());

                            } catch (AmspServiceException e) {
                                    printOutput.printExceptionToShell(apiParams, "opMainOrderOptionFacade.updateBoxData", e);
                            } 
                        }   else {
                            printOutput.printToShell(apiParams, "ANDRI: VALIDATION akhir tidak VALID, tidak ada EKSEKUSi","");
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
                    
                } else {
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
