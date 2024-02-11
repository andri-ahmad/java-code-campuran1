package trvtesting1;

import amdocs.amsp.Configuration;

import amdocs.amsp.services.CustomerFacade;
import amdocs.amsp.valueobject.customer.CustomerDetailsVO;

import amdocs.amsp.services.OpInstallFacade;
import amdocs.amsp.services.SiteFacade;
import amdocs.amsp.valueobject.addressservice.AddressFieldsDetailVO;
import amdocs.amsp.valueobject.order.OrderResultVO;
import amdocs.amsp.valueobject.servicepoint.EquipmentVO;
import amdocs.amsp.valueobject.siteparam.SiteServiceGroupVO;

public class Main {
       
    public static void main(String[] args) throws Exception{
        
        try {
                System.out.println("Hello World");
                
                PrintOutput printOutput = new PrintOutput();
                
                System.out.println("Login Class created....");
                Login aLogin = new Login();
                
                Configuration.appName = Configuration.AMSP_API_APP_NAME;
                
                System.out.println("Parameter Class created....");
                Parameters apiParams = new Parameters();
                apiParams.setUser("ANDRI");
                apiParams.setPassword("ANDRI");
                
                System.out.println("Init Parameter start...");
                apiParams.initParameters(Parameters.LOGIN, apiParams, printOutput);
                     
                
                System.out.println("Prepare Login....");
                aLogin.logInOut(aLogin.LOGIN(), apiParams, printOutput);         
                
            
                // Customer
            
                CustomerFacade cf = new CustomerFacade();
                System.out.println("Create Customer Detail......");
                CustomerDetailsVO cdvo = cf.getCustomerDetail("10213085", false, "46030", aLogin.getTicket());
                
                System.out.println("Create Customer get Billing Address......");
                System.out.println(cdvo.getBillingAddress());

            
            
                //System.out.println(aLogin.getTicket());    
            } catch (Exception ex) {
                System.out.println ("Error Expcetion from main ==> " + ex.toString());
            }
        
        
    }
}
