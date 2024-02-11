package trvtesting1;

import amdocs.amsp.Configuration;
import amdocs.amsp.FrameworkConstantsI;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.AccountConstraintsFacade;
import amdocs.amsp.services.AddressServiceFacade;
import amdocs.amsp.services.EquipmentFacade;
import amdocs.amsp.services.SiteFacade;
import amdocs.amsp.valueobject.addressservice.AddressFieldsDetailVO;
import amdocs.amsp.valueobject.lockservice.LockOutputVO;
import amdocs.amsp.valueobject.order.OrderResultVO;
import amdocs.amsp.valueobject.servicepoint.EquipmentVO;
import amdocs.amsp.valueobject.siteparam.SiteServiceGroupVO;
import amdocs.amsp.services.LockServiceFacade;
import amdocs.amsp.valueobject.accountconstraints.SiteConstraintsVO;
import amdocs.amsp.valueobject.site.SiteDetailsVO;


public class MainEquipment {
    public MainEquipment() {
        super();
    }
    
    public static void main(String[] args) throws Exception{
        // variables
        boolean session;
        
        // objects
        LockServiceFacade lockServiceFacade = new LockServiceFacade();
        LockOutputVO lockOutputVO = new LockOutputVO();
        AccountConstraintsFacade accountConstraintsFacade = new AccountConstraintsFacade();
        SiteConstraintsVO siteConstraintsVO = new SiteConstraintsVO();
        SiteFacade siteFacade = new SiteFacade();
        SiteDetailsVO siteDetailsVO = null;
        AddressServiceFacade addressServiceFacade = new AddressServiceFacade();
        AddressFieldsDetailVO[] addressFieldsDetailVO;
        OrderResultVO orvo = new OrderResultVO();
        EquipmentVO[] evo = new EquipmentVO[0];
        SiteServiceGroupVO[] ssgvo = new SiteServiceGroupVO[0];
        EquipmentFacade equipmentFacade = new EquipmentFacade();
        
        System.out.println("Login Class created....");
        Login aLogin = new Login();
        
        try {
            
            //equipmentFacade.
                            
                            
            //System.out.println("Create site Testing....");
            
            PrintOutput printOutput = new PrintOutput();           
            
            Configuration.appName = Configuration.AMSP_API_APP_NAME;
            
            System.out.println("Parameter Class created....");
            Parameters apiParams = new Parameters();
            apiParams.setUser("ANDRI");
            apiParams.setPassword("ANDRI");
            
            System.out.println("Init Parameter start...");
            apiParams.initParameters(Parameters.CREATE_SITE , apiParams, printOutput);                 
            
            System.out.println("Prepare Login....");
            session = aLogin.logInOut(aLogin.LOGIN(), apiParams, printOutput);         
          
            
            //aLGORITMA cREATE Site
            //1. Login --DONE
            //2. JIka sedang APC, return ERROR
            //3. Jika Option, General Maintenance, Add Site tidak enable, return ERROR
            //4. Lock template site, site yg sudah sy create di play: 00236076
            if (session) {
                
                lockOutputVO = lockServiceFacade.getSiteLock(apiParams.getsiteId(), 
                                                             FrameworkConstantsI.LockMode.RETURN_ONLY.getLockModeValue(),
                                                             apiParams.getCorp(), 
                                                             aLogin.getTicket());
                printOutput.printToShell(apiParams, "Site Lock Message: " + lockOutputVO.getMessage(), null);
                
                if (lockOutputVO.getStatus()) {
                    
                    //5. Get Site Constraint:
                    siteConstraintsVO = accountConstraintsFacade.getSiteConstraints(apiParams.getOrderType(),
                                                                                    apiParams.getScheduleAction(), 
                                                                                    apiParams.getsiteId(), 
                                                                                    apiParams.getCorp(), 
                                                                                    aLogin.getTicket());
                    if (siteConstraintsVO != null) {
                            printOutput.printToShell(apiParams, ":<siteConstraintsVO>" + siteConstraintsVO.toString() + "</siteConstraintsVO>",
                                            siteConstraintsVO.toXml());
                    }
                    else {
                            printOutput.printToShell(apiParams, ":<siteConstraintsVO> is null", null);
                    }
                    
                    //6. Get Site Detail:
                    siteDetailsVO = siteFacade.getSiteDetail(apiParams.getsiteId(),
                                                             apiParams.getCorp(),
                                                             aLogin.getTicket());
                    
                    if (siteDetailsVO != null) {
                        printOutput.printToShell(apiParams, ":<SiteDetailsVO>" + siteDetailsVO.toString() + "</SiteDetailsVO>", siteDetailsVO.toXml());
                    }
                    else {
                            throw new Exception("siteDetailsVO is null");
                    }
                    
                    
                    //7. Get Address Fields Detail (AddressServiceFacade)
                    addressFieldsDetailVO = addressServiceFacade.getAddressFields(apiParams.getAddressUse(),
                                                                                  siteDetailsVO.getAddressId(),
                                                                                  apiParams.getCorp(),
                                                                                  aLogin.getTicket());
                    
                    //8. Iterate through elements of the Address Fields Details array (AddressFieldsDetailVO[])
                    if (addressFieldsDetailVO != null) {
                        for (int i = 0; i != addressFieldsDetailVO.length; i++) {
                            
                            if (addressFieldsDetailVO[i].getNlsNum() == 3) {
                                addressFieldsDetailVO[i].setValue("JL. ANDRI 1");
                            }
                            if (addressFieldsDetailVO[i].getNlsNum() == 28) {
                                addressFieldsDetailVO[i].setValue("KEL. KALICEBONG");
                            }
                            if (addressFieldsDetailVO[i].getNlsNum() == 15) {
                                addressFieldsDetailVO[i].setValue("KEC. PASARMALAM");
                            }
                            if (addressFieldsDetailVO[i].getNlsNum() == 4) {
                                addressFieldsDetailVO[i].setValue("KOTA JAKARTA");
                            }
                            
                            printOutput.printToShell(apiParams, ":<addressVO id=" + i + ">" + addressFieldsDetailVO[i].toString() 
                                                                + "</addressVO>", addressFieldsDetailVO[i].toXml());
                            
                            
                        }
                    }
                    else {
                            printOutput.printToShell(apiParams, ":<addressFieldsDetailVO> is null", null);
                    }
                    
                    //9. If the current element requires updating, then update it (if (addressFieldsDetailVO[i].getNlsNum() == x)
                    // Updatenya di atas pada saat iterasi..
                    evo = siteDetailsVO.getEquipmentList();
                    printOutput.printToShell(apiParams, "Existing Equipment List ==> " + evo.toString(), null); 
                    ssgvo = siteDetailsVO.getSiteServiceGroupVO();
                    printOutput.printToShell(apiParams, "Existing SiteService Group ==> " + ssgvo.toString(), null); 
                               
                    //10. Create Site (SiteFacade)
                    printOutput.printToShell(apiParams, "Creating site...", null);                    
                    
                    try {                    
                          orvo = siteFacade.createSite(apiParams.getCust_acct(),
                                apiParams.getsiteId(), 
                                apiParams.getCallerName(), 
                                addressFieldsDetailVO, 
                                apiParams.getAllowInvalidZip(), 
                                apiParams.getDuplicateAddressFlag(), 
                                evo, 
                                ssgvo, 
                                apiParams.getCorp(),
                                aLogin.getTicket());
                    } catch (AmspServiceException exp) {
                        printOutput.printToShell(apiParams,"Exception while execution create site ==> " + exp.toString() + "==" + exp.getLocalizedMessage(), null);
                    }
                    
                    printOutput.printToShell(apiParams, orvo.toString(), orvo.toXml()); 
                    
                } else {
                    printOutput.printToShell(apiParams, "Site Lock Message: " + lockOutputVO.getMessage(), null);
                }               
                
                //11. Unlock site
                lockOutputVO = lockServiceFacade.unLockSite(apiParams.getsiteId(), apiParams.getCorp(), aLogin.getTicket());
                
                printOutput.printToShell(apiParams, "Site unlock message: " + lockOutputVO.getMessage(), null);
                
                // 12. Logout
                aLogin.logInOut(aLogin.LOGOUT(), apiParams, printOutput);     
            }           
                
        } catch (AmspServiceException ex) {
                System.out.println ("Error Expcetion from main ==> " + ex.toString());
        }               
    }
}
