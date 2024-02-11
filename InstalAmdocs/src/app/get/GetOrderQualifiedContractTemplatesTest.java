package app.get;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import util.SupportException;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.ContractsFacade;
import amdocs.amsp.valueobject.contracts.TemplateDetailVO;

public class GetOrderQualifiedContractTemplatesTest {
	
	private ContractsFacade contractsFacade = new ContractsFacade();
	private TemplateDetailVO[] templateDetailVOlist = null;
	
public TemplateDetailVO[] getOrderQualifiedContractTemplates(Parameters apiParams, Login login, PrintOutput printOutput) throws SupportException {
		
		try {
			 
			templateDetailVOlist = contractsFacade.getOrderQualifiedContractTemplates(apiParams.getsiteId(), apiParams.getCorp(), login.getTicket());
            
			if (templateDetailVOlist != null) {
				for (int i = 0; i != templateDetailVOlist.length; i++) {
					printOutput.printToShell(apiParams, 
											getClass().getName() + ":<templateDetailVOlist id=" + i + ">" + templateDetailVOlist[i].toString() + "</templateDetailVOlist>",
											templateDetailVOlist[i].toXml());
	 			}
			}
			else {
				throw new SupportException("templateDetailVOlist is null");
			}
						
		} catch (AmspServiceException e) {
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
		return (templateDetailVOlist);
	}
}
