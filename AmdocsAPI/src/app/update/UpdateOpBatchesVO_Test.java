package app.update;

import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.valueobject.opbatches.BatchesVO;

public class UpdateOpBatchesVO_Test {
	
	public void updateOpBatchesVOforNewBatch (BatchesVO oPbatchesVO,
											  Parameters apiParams, 
											  PrintOutput printOutput) {

		oPbatchesVO.setBatchAmount(apiParams.getBatchAmount());
		oPbatchesVO.setBatchCash(apiParams.getBatchCash()); 
		oPbatchesVO.setBatchCheque(apiParams.getBatchCheque());
		oPbatchesVO.setBatchClose(apiParams.getBatchClose());
		oPbatchesVO.setBatchContinue(apiParams.getBatchContinue());
		oPbatchesVO.setBatchCreditCard(apiParams.getBatchCreditCard());
		oPbatchesVO.setBatchCtrlgroup(apiParams.getBatchCtrlgroup());
		oPbatchesVO.setBatchDone(apiParams.getBatchDone());
		oPbatchesVO.setBatchElectronicCheq(apiParams.getBatchElectronicCheq());
		oPbatchesVO.setBatchNew(apiParams.getBatchNew());
		oPbatchesVO.setBatchNumber(apiParams.getBatchNumber());
		oPbatchesVO.setBatchOther(apiParams.getBatchOther());
		oPbatchesVO.setBatchPostal(apiParams.getBatchPostal());
		oPbatchesVO.setBatchStatus(apiParams.getBatchStatus());
		oPbatchesVO.setBatchType(apiParams.getBatchType());
		oPbatchesVO.setServiceGroup(apiParams.getServiceGroup());

		printOutput.printToShell(apiParams, 
		getClass().getName() + ":<oPbatchesVO>" + oPbatchesVO.toString() + "</oPbatchesVO>",
		oPbatchesVO.toXml());
	}
	
	public void updateOpBatchesVOforExistingBatch (BatchesVO oPbatchesVO,
											 	   Parameters apiParams, 
											 	   PrintOutput printOutput) {
		
		oPbatchesVO.setBatchAmount(apiParams.getBatchAmount());
		oPbatchesVO.setBatchCash(apiParams.getBatchCash()); 
		oPbatchesVO.setBatchCheque(apiParams.getBatchCheque());
		oPbatchesVO.setBatchClose(apiParams.getBatchClose());
		oPbatchesVO.setBatchContinue(apiParams.getBatchContinue());
		oPbatchesVO.setBatchCreditCard(apiParams.getBatchCreditCard());
		oPbatchesVO.setBatchCtrlgroup(apiParams.getBatchCtrlgroup());
		oPbatchesVO.setBatchDone(apiParams.getBatchDone());
		oPbatchesVO.setBatchElectronicCheq(apiParams.getBatchElectronicCheq());
		oPbatchesVO.setBatchNew(apiParams.getBatchNew());
		oPbatchesVO.setBatchNumber(apiParams.getBatchNumberTarget()); // Note get method name difference
		oPbatchesVO.setBatchOther(apiParams.getBatchOther());
		oPbatchesVO.setBatchPostal(apiParams.getBatchPostal());
		oPbatchesVO.setBatchStatus(apiParams.getBatchStatus());
		oPbatchesVO.setBatchType(apiParams.getBatchType());
		oPbatchesVO.setServiceGroup(apiParams.getServiceGroup());

		printOutput.printToShell(apiParams, 
		getClass().getName() + ":<oPbatchesVO>" + oPbatchesVO.toString() + "</oPbatchesVO>",
		oPbatchesVO.toXml());
		
	}
	public void updateOpBatchesVOforClosing (BatchesVO oPbatchesVO,
											 Parameters apiParams, 
											 PrintOutput printOutput) {

		/*oPbatchesVO.setBatchAmount(apiParams.getBatchAmount());
		oPbatchesVO.setBatchCash(apiParams.getBatchCash()); 
		oPbatchesVO.setBatchCheque(apiParams.getBatchCheque()); */
		oPbatchesVO.setBatchClose(apiParams.getBatchClose());
		/*oPbatchesVO.setBatchContinue(apiParams.getBatchContinue());
		oPbatchesVO.setBatchCreditCard(apiParams.getBatchCreditCard());
		oPbatchesVO.setBatchCtrlgroup(apiParams.getBatchCtrlgroup());
		oPbatchesVO.setBatchDone(apiParams.getBatchDone());
		oPbatchesVO.setBatchElectronicCheq(apiParams.getBatchElectronicCheq());
		oPbatchesVO.setBatchNew(apiParams.getBatchNew());
		oPbatchesVO.setBatchNumber(apiParams.getBatchNumber());
		oPbatchesVO.setBatchOther(apiParams.getBatchOther());
		oPbatchesVO.setBatchPostal(apiParams.getBatchPostal());
		oPbatchesVO.setBatchStatus(apiParams.getBatchStatus());
		oPbatchesVO.setBatchType(apiParams.getBatchType());
		oPbatchesVO.setServiceGroup(apiParams.getServiceGroup());*/
		
		printOutput.printToShell(apiParams, 
								 getClass().getName() + ":<oPbatchesVO>" + oPbatchesVO.toString() + "</oPbatchesVO>",
								 oPbatchesVO.toXml());
	}
}