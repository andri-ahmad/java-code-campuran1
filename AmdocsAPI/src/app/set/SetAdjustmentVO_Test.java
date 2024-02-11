package app.set;

import amdocs.amsp.valueobject.financial.AdjustmentVO;
import util.Parameters;
import util.PrintOutput;

public class SetAdjustmentVO_Test {
	
	private AdjustmentVO adjustmentVO = new AdjustmentVO();
	
	public AdjustmentVO setAdjustmentVOforAdjustment(Parameters apiParams, 
													 PrintOutput printOutput) {
		
		adjustmentVO.setAging(apiParams.getAging());
		adjustmentVO.setAmount(apiParams.getAmount());
		//setComment(java.lang.String comment) 
		//setEpiRecord(EpiRecordVO[] epiRecord) 
		adjustmentVO.setIsPayCard(apiParams.getIsPayCard()) ;
		//setPayCard(PayCardDetailsVO payCard) 
		adjustmentVO.setReason(apiParams.getReasonCode());
		//setTaxAmount(amdocs.core.Money taxAmount)
		
		printOutput.printToShell(apiParams, 
		getClass().getName() + ":<adjustmentVO>" + adjustmentVO.toString() + "</adjustmentVO>",
		adjustmentVO.toXml());
		
	 return (adjustmentVO);
	}
}
