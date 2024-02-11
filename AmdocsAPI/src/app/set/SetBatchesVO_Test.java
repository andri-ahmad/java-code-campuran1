package app.set;

import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.valueobject.opbatches.BatchesVO;

public class SetBatchesVO_Test {
	
	private BatchesVO batchesVO = new BatchesVO();
	
	public BatchesVO setBatchesVOforPayments (Parameters apiParams, 
			   							 	PrintOutput printOutput) {
	
		batchesVO.setBatchAmount(apiParams.getBatchAmount()); 
		batchesVO.setBatchCash(apiParams.getBatchCash()); 
		batchesVO.setBatchCheque(apiParams.getBatchCheque());
		batchesVO.setBatchClose(apiParams.getBatchClose());
		batchesVO.setBatchContinue(apiParams.getBatchContinue());
		batchesVO.setBatchCreditCard(apiParams.getBatchCreditCard());
		batchesVO.setBatchCtrlgroup(apiParams.getBatchCtrlgroup());
		batchesVO.setBatchDone(apiParams.getBatchDone());
		batchesVO.setBatchElectronicCheq(apiParams.getBatchElectronicCheq());
		batchesVO.setBatchNew(apiParams.getBatchNew());
		batchesVO.setBatchNumber(apiParams.getBatchNumber());
		batchesVO.setBatchOther(apiParams.getBatchOther());
		batchesVO.setBatchPostal(apiParams.getBatchPostal());
		batchesVO.setBatchStatus(apiParams.getBatchStatus());
		batchesVO.setBatchType(apiParams.getBatchType());
		batchesVO.setServiceGroup(apiParams.getServiceGroup());
		
		printOutput.printToShell(apiParams, 
	    		getClass().getName() + ":<batchesVO>" + batchesVO.toString() + "</batchesVO>",
	    		batchesVO.toXml());
		
		return(batchesVO);
	}
}
