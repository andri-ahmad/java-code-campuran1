package app.set;

import util.Parameters;
import util.PrintOutput;

import amdocs.amsp.valueobject.servicepoint.ContractVO;

public class SetContractVO_Test {
	
	private ContractVO contractVO = new ContractVO();
	
	public ContractVO setContractVOforInstallWithContract (Parameters apiParams, 
														PrintOutput printOutput) {
		/* setContractExternalNum(java.lang.String contractExternalNum) 
		setContractImageLink(java.lang.String contractImageLink) 
		setContractSeq(java.math.BigDecimal contractSeq) 
		setContractService(ContractServicesVO[] contractService) */
		contractVO.setContractTemplateId(apiParams.getContractTemplateId());
		/*setRenewContract(java.lang.Boolean renewContract) */
		
		printOutput.printToShell(apiParams, 
								 getClass().getName() + ":<contractVO>" + contractVO.toString() + "</contractVO>",
								 contractVO.toXml());
		
		return contractVO;
	}

}
