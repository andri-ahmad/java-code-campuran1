package trvtesting1;

import amdocs.amsp.Configuration;
import amdocs.amsp.FrameworkConstantsI;
import amdocs.amsp.ServiceConstantsI;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.AccountConstraintsFacade;
import amdocs.amsp.services.AccountViewWipFacade;
import amdocs.amsp.services.CustomerFacade;
import amdocs.amsp.services.LockServiceFacade;
import amdocs.amsp.services.OpCheckinFacade;
import amdocs.amsp.services.OpQueryFacade;
import amdocs.amsp.services.ServicePointFacade;
import amdocs.amsp.services.SiteFacade;
import amdocs.amsp.valueobject.accountconstraints.VideoEquipmentConstraintsVO;
import amdocs.amsp.valueobject.customer.CustomerDetailsVO;
import amdocs.amsp.valueobject.lockservice.LockOutputVO;
import amdocs.amsp.valueobject.opquery.PollRecalculateServicesVO;
import amdocs.amsp.valueobject.order.OrderInfoVO;
import amdocs.amsp.valueobject.order.OrderResultVO;
import amdocs.amsp.valueobject.order.OrderVO;
import amdocs.amsp.valueobject.schedule.ScheduleVO;
import amdocs.amsp.valueobject.servicepoint.EquipmentVO;
import amdocs.amsp.valueobject.servicepoint.ServicePointVO;
import amdocs.amsp.valueobject.site.SiteDetailsVO;


public class MainUpdateCustData {
    public MainUpdateCustData() {
        super();
    }
    
    
    
    public static void main(String[] args) {
        
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
        CustomerDetailsVO customerDetailsVO = new CustomerDetailsVO();
        SiteDetailsVO siteDetailsVO = new SiteDetailsVO();
        OpCheckinFacade opCheckinFacade = new OpCheckinFacade();
        OrderResultVO orderResultVO = new OrderResultVO();
        OrderVO orderVO = new OrderVO();
        EquipmentVO[] equipmentVOlist = new EquipmentVO[1];
        VideoEquipmentConstraintsVO videoEquipmentConstraintsVO = new VideoEquipmentConstraintsVO();
        ServicePointVO[] servicePointVOlist = null;
        PollRecalculateServicesVO pollRecalculateServicesVO = new PollRecalculateServicesVO();
        OrderVO recalcOrderVO = new OrderVO();
        SiteFacade siteFacade = new SiteFacade();
        CustomerFacade customerFacade = new CustomerFacade();
        AccountViewWipFacade accountViewWipFacade = new AccountViewWipFacade();
        ServicePointFacade servicePointFacade = new ServicePointFacade();
        EquipmentVO equipmentVO = new EquipmentVO();
        AccountConstraintsFacade accountConstraintsFacade = new AccountConstraintsFacade();
        ServicePointVO servicePointVO;        
        OpQueryFacade opQueryFacade = new OpQueryFacade();
        ScheduleVO scheduleVO = new ScheduleVO();
        OrderInfoVO orderInfoVO = new OrderInfoVO();

               
        
        System.out.println("Login Class created....");
        Login aLogin = new Login();
        try {
            System.out.println("Updating equpiment subcriber....");
            
            PrintOutput printOutput = new PrintOutput();           
            
            Configuration.appName = Configuration.AMSP_API_APP_NAME;
            
            System.out.println("Parameter Class created....");
            Parameters apiParams = new Parameters();
            apiParams.setUser("ANDRI");
            apiParams.setPassword("ANDRI");
            
            System.out.println("Init Parameter start...");
            apiParams.initParameters(Parameters.UPDATE_DAILY_CHECKIN_ACCOUNT_ADD_EQUIPMENT , apiParams, printOutput); 
            
            //aLGORITMA Update Check-in add Equipment
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
                    
                    // 5. Aman untuk melakukan update equipment di customer bersangkutan...
                    
                    // 6. Inti dari update Equipment
                    // 6.A  GET DATA
                    // 6.B  SET DATA
                    // 6.C  SAVE DATA
                    
                    // 6.a.1  Cari site detail
                    try {
                        // SiteDetailsVO 
                        siteDetailsVO = siteFacade.getSiteDetail(apiParams.getsiteId(),
                                     apiParams.getCorp(), 
                                     aLogin.getTicket());
                        
                        if (siteDetailsVO != null) {
                            printOutput.printToShell(apiParams, 
                            "<<ANDRI:<SiteDetailsVO>" +     siteDetailsVO.toString() + "</SiteDetailsVO>",
                            siteDetailsVO.toXml());
                        }
                        else {
                            throw new Exception("siteDetailsVO is null");
                        }
                    
                    } catch (AmspServiceException e) {
                        printOutput.printExceptionToShell(apiParams, "Site Class ", e);
                    }
                    
                    // 6.a.2 Cari customer detail
                    try {
                        customerDetailsVO = customerFacade.getCustomerDetail(apiParams.getCust_acct(), false, 
                                                                                         apiParams.getCorp(), 
                                                                                         aLogin.getTicket());
                        
                        if (customerDetailsVO != null) {
                            printOutput.printToShell(apiParams, 
                            "<<ANDRI:<customerDetailsVO>" + customerDetailsVO.toString() + "</CustomerDetailsVO>",
                            customerDetailsVO.toXml());
                        }
                        else {
                            throw new Exception("customerDetailsVO is null");
                        }
                        
                        }
                    catch (AmspServiceException e)  {
                        printOutput.printExceptionToShell(apiParams, "Customer Class", e);
                    }
                    
                    
                    // 6.a.3  get order info nya
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
                    
                    //6.a.4 Cari service point nya..
                    servicePointVOlist = orderVO.getServicePointList();
                                    
                    if (servicePointVOlist != null) {
                            for (int i = 0; i != servicePointVOlist.length; i++) {
                                    printOutput.printToShell(apiParams, 
                                                    ":<servicePointVOlist id=" + i + ">" + servicePointVOlist[i].toString() + "</servicePointVOlist>",
                                                    servicePointVOlist[i].toXml());
                            }
                    }
                    else {
                            throw new Exception("servicePointVOlist is null");
                    }
                    
                    
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
                                                                            apiParams.getsiteId(),
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
                    
                    // 6.b setting the data
                    // 6.b.1
                    orderVO.getOrderInfoList().setAction(apiParams.getOrderInfoVOaction());
                    
                    orderInfoVO = orderVO.getOrderInfoList();
                    
                    scheduleVO = orderInfoVO.getSchedule();
                    
                    // 6.B part 7, Schedule VO
                    scheduleVO.setAction(apiParams.getScheduleVOaction());
                    scheduleVO.setIsMustDo(apiParams.getIsMustDo());
                    scheduleVO.setScheduleDate(apiParams.getScheduleDate());
                    scheduleVO.setScheduleType((short)ServiceConstantsI.NO_TRUCK);
                    scheduleVO.setTechId(apiParams.getTechId());
                    
                    orderInfoVO.setSchedule(scheduleVO);
                    
                    // 6.b.2  set equipment
                    equipmentVO.setAction(apiParams.getEquipmentVOaction());
                    equipmentVO.setEquipMovementFlag(apiParams.getEquipMovementFlag());
                    if (videoEquipmentConstraintsVO.getLocationCode().getRequired()) {
                            equipmentVO.setLocation(apiParams.getEquipmentLocation());
                    }
                    if (videoEquipmentConstraintsVO.getOption1Code().getRequired()) {
                            equipmentVO.setOption1Code(apiParams.getOptionCode());
                    }
                    equipmentVO.setOutlet(apiParams.getOutlet());
                    equipmentVO.setPrevSerialNumber(apiParams.getPrevSerialNumber());
                    if (videoEquipmentConstraintsVO.getRating().getRequired()) {
                            equipmentVO.setRating("2"); //Valid Values: 0 = G, 1 = PG, 2 = R, 3 = X
                    }
                    printOutput.printToShell(apiParams, 
                                             "<<ANDRI After SET:<equipmentVO>" + equipmentVO.toString() + "</equipmentVO>",
                                             equipmentVO.toXml());
                    
                    equipmentVOlist[0] = equipmentVO;
                    
                    
                    
                    // 6.b.3 set service point
                    servicePointVO = servicePointVOlist[0];
                    servicePointVO.setAction(apiParams.getServicePointVOaction());
                    servicePointVO.setEquipment(equipmentVOlist);
                    servicePointVO.setOrderGroup(apiParams.getOrderGroupSeq());
                    servicePointVO.setServicePoint(apiParams.getServicePoint());
                    
                    printOutput.printToShell(apiParams, 
                                             "<<ANDRI :<servicePointVO>" + servicePointVO.toString() + "</servicePointVO>",
                                             servicePointVO.toXml());
                    
                    servicePointVOlist[0] = servicePointVO;
                    
                    
                    // 6.b.4 set order VO
                    orderVO.setServicePointList(servicePointVOlist);
                    orderVO.setOrderInfoList(orderInfoVO);
                    
                    if (orderVO != null) {
                        printOutput.printToShell(apiParams, 
                        "<<ANDRI After set:<OrderVO>" + orderVO.toString() + "</OrderVO>",
                        orderVO.toXml());
                    }
                    
                    // 6.B 5, Recalculate Services
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
                    
                    
                    if (pollRecalculateServicesVO.getIsCompleted()) {
                                    
                            recalcOrderVO = pollRecalculateServicesVO.getOrderVO();
                            
                            printOutput.printToShell(apiParams, 
                                ":<recalcOrderVO>" + recalcOrderVO.toString() + "</recalcOrderVO>",
                                recalcOrderVO.toXml());
                    }
                    else {
                            printOutput.printToShell(apiParams, 
                                 "pollRecalculateServicesVO.getIsCompleted() = " + pollRecalculateServicesVO.getIsCompleted(),
                                null);
                    }
    
                    // 6.c save data 
                    try {
                        orderResultVO = opCheckinFacade.updateDailyCheckin(siteDetailsVO, 
                                                                           recalcOrderVO, 
                                                                           customerDetailsVO, 
                                                                           apiParams.getCheckinOption(),
                                                                           apiParams.getDSeq(), 
                                                                           apiParams.getNotDoneCode(), 
                                                                           apiParams.getSarSentFlag(), 
                                                                           apiParams.getMvtStatusCode(), 
                                                                           apiParams.getOverriddenRuleIds(), 
                                                                           apiParams.getCorp(), 
                                                                           aLogin.getTicket());
                        
                        if (orderResultVO != null) {
                                printOutput.printToShell(apiParams, 
                                                "<<ANDRI :<orderResultVO>" + orderResultVO.toString() + "</orderResultVO>",
                                                 orderResultVO.toXml());
                        }
                        else {
                                printOutput.printToShell(apiParams, ":<orderResultVO> is null", null);
                        }
                        
                        
                    } catch (AmspServiceException e) {
                            printOutput.printExceptionToShell(apiParams, "opCheckinFacade", e);
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
                
            }
            else {
                System.out.println("Login session is expired, please Relogin");
            }
            
            
            
            
            
        } 
        catch (Exception ex) {
            System.out.println ("Error Expcetion from main ==> " + ex.toString());
        }
        
        
        
        
    }    
}