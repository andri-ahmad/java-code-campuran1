package app.get;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import util.SupportException;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.OpQueryFacade;
import amdocs.amsp.valueobject.opquery.PackageDataVO;

public class GetPackageCodeDetailsTest {
	
	private OpQueryFacade opQueryFacade = new OpQueryFacade();
	private PackageDataVO[] packageDataVOList = null;
	
	public PackageDataVO[] getPackageCodeDetails(Parameters apiParams, Login login, PrintOutput printOutput) throws SupportException {
		
		try {
			 
			packageDataVOList = opQueryFacade.getPackageCodeDetails(apiParams.getCust_acct(), 
																    apiParams.getsiteId(), 
																    apiParams.getQualifiersVOList(), 
																    apiParams.getPriceStructId(), 
																    apiParams.getCorp(), 
																    login.getTicket());
            
			if (packageDataVOList != null) {
				for (int i = 0; i != packageDataVOList.length; i++) {
					printOutput.printToShell(apiParams, 
											getClass().getName() + ":<packageDataVOList id=" + i + ">" + packageDataVOList[i].toString() + "</packageDataVOList>",
											packageDataVOList[i].toXml());
	 			}
			}
			else {
				throw new SupportException("packageDataVOList is null");
			}
						
		} catch (AmspServiceException e) {
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
		return (packageDataVOList);
	}

}
