package app.set;

import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.valueobject.opquery.RateCodeSelectionIpVO;

public class SetRateCodeSelectionIpVO_Test {
	
	private RateCodeSelectionIpVO rateCodeSelectionIp = new RateCodeSelectionIpVO();
	
	public RateCodeSelectionIpVO setRateCodeSelectionIpVOforInstall (Parameters apiParams, 
																	 PrintOutput printOutput) {
		
		rateCodeSelectionIp.setAcctPriceStructId(apiParams.getAcctPriceStructId()); 
		rateCodeSelectionIp.setCampaignCode(apiParams.getCampaignCode());
		rateCodeSelectionIp.setContractTemplateId(apiParams.getContractTemplateId());
		rateCodeSelectionIp.setCustAcct(apiParams.getCust_acct());
		rateCodeSelectionIp.setEffectiveDate(apiParams.getEffectiveDate());
		rateCodeSelectionIp.setPackageCode(apiParams.getPackageCode());
		rateCodeSelectionIp.setPendingContractIds(apiParams.getpendingContractIds());
		rateCodeSelectionIp.setPriceStructureId(apiParams.getPriceStructId());
		rateCodeSelectionIp.setSiteId(apiParams.getsiteId());

		return rateCodeSelectionIp;																 
	}
}
