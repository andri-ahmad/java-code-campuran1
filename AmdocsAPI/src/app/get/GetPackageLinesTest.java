package app.get;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import util.SupportException;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.OpQueryFacade;
import amdocs.amsp.valueobject.customer.CustomerDetailsVO;
import amdocs.amsp.valueobject.opquery.PackageDetailsVO;
import amdocs.amsp.valueobject.opquery.RateCodeSelectionIpVO;
import amdocs.amsp.valueobject.order.OrderVO;
import amdocs.amsp.valueobject.site.SiteDetailsVO;

public class GetPackageLinesTest {
	
	private OpQueryFacade opQueryFacade = new OpQueryFacade();
	private PackageDetailsVO packageDetailsVO = new PackageDetailsVO();
	
	public PackageDetailsVO getPackageLines(Parameters apiParams, 
												  Login login, 
												  PrintOutput printOutput,
												  RateCodeSelectionIpVO rateCodeSelectionIp,
												  CustomerDetailsVO customerDetails,
												  SiteDetailsVO siteDetails,
												  OrderVO order) throws SupportException {
		try {
			 
			packageDetailsVO = opQueryFacade.getPackageLines(rateCodeSelectionIp, 
															 apiParams.getOrderGroupSeq(), 
															 apiParams.getOffernum(), 
															 apiParams.getOrderType(), 
															 apiParams.getEffectiveDateFlag(), 
															 customerDetails, 
															 siteDetails, 
															 order, 
															 apiParams.getCorp(), 
															 login.getTicket());
            
			if (packageDetailsVO != null) {
				printOutput.printToShell(apiParams, 
						 				 getClass().getName() + ":<packageDetailsVO>" + packageDetailsVO.toString() + "</packageDetailsVO>",
						 				 packageDetailsVO.toXml());
			}
			else {
				throw new SupportException("packageDetailsVO is null");
			}
						
		} catch (AmspServiceException e) {
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
		return (packageDetailsVO);
	}
}
