package app.get;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.AddressServiceFacade;
import amdocs.amsp.valueobject.addressservice.AddressFieldsDetailVO;
import amdocs.amsp.valueobject.site.SiteDetailsVO;

public class GetAddressFieldsVO_Test {

	private AddressServiceFacade addressServiceFacade = new AddressServiceFacade();
	private AddressFieldsDetailVO[] addressFieldsDetailVO;
	
	public AddressFieldsDetailVO[] getAddressFields(Parameters apiParams, Login login, PrintOutput printOutput, SiteDetailsVO siteDetailsVO) {
		{ 
			try {
				addressFieldsDetailVO = addressServiceFacade.getAddressFields(apiParams.getAddressUse(),
																		siteDetailsVO.getAddressId(),
																		apiParams.getCorp(),
																		login.getTicket());
				
				if (addressFieldsDetailVO != null) {
					for (int i = 0; i != addressFieldsDetailVO.length; i++) {
						printOutput.printToShell(apiParams, 
								getClass().getName() + ":<addressVO id=" + i + ">" + addressFieldsDetailVO[i].toString() + "</addressVO>",
								addressFieldsDetailVO[i].toXml());
		 			}
				}
				else {
					printOutput.printToShell(apiParams, getClass().getName() + ":<addressFieldsDetailVO> is null", null);
				}
			}
			catch (AmspServiceException e) 	{
				printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
			}
			
			return (addressFieldsDetailVO);
		}
	} // end of getAddressFields method
} // end of GetAddressFieldsTest class
