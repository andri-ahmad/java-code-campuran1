package app.opr;

import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.OpBatchesFacade;
import amdocs.amsp.valueobject.opbatches.BatchesVO;
import amdocs.amsp.valueobject.order.OrderResultVO;
import amdocs.core.Money;
import util.Login;
import util.Parameters;
import util.PrintOutput;

public class OprBatchesTest {

	OpBatchesFacade batchesFacade = new OpBatchesFacade();
	BatchesVO batchesVO = new BatchesVO();	
	OrderResultVO orderResultVO =null;
	
	public BatchesVO setAddbatchData(Parameters apiParams, Login login, PrintOutput printOutput) {
		
		batchesVO.setBatchNew((short)1);
		batchesVO.setBatchClose((short)0);
		batchesVO.setBatchDone((short)0);
		batchesVO.setBatchNumber((short)0);
		batchesVO.setBatchAmount(new Money(0));
		batchesVO.setBatchStatus("3");
		batchesVO.setBatchCtrlgroup(apiParams.getBatchCtrlgroup());
		
		batchesVO.setBatchCash(apiParams.getBatchCash());
		batchesVO.setBatchCheque(apiParams.getBatchCheque());
		batchesVO.setBatchPostal(apiParams.getBatchPostal());
		batchesVO.setBatchOther(apiParams.getBatchOther());
		
		// EPI scheme default beginning balance values are 0 $  
		batchesVO.setBatchElectronicCheq(new Money(0));
		batchesVO.setBatchCreditCard(new Money(0));
		

		batchesVO.setBatchType(apiParams.getBatchType());
		return batchesVO;
	}
	
	public BatchesVO setClosebatchData(Parameters apiParams, Login login, PrintOutput printOutput) {

		batchesVO.setBatchClose((short)1);
		batchesVO.setBatchNumber(apiParams.getBatchNumber());
		batchesVO.setBatchContinue((short)0);
		batchesVO.setBatchNew((short)0);
		batchesVO.setBatchDone((short)0);
		batchesVO.setBatchAmount(new Money(0));
		batchesVO.setBatchStatus("3");
		
		batchesVO.setBatchCash(apiParams.getBatchCash());
		batchesVO.setBatchCheque(apiParams.getBatchCheque());
		batchesVO.setBatchPostal(apiParams.getBatchPostal());
		batchesVO.setBatchOther(apiParams.getBatchOther());
		
		// EPI scheme default beginning balance values are 0 $  
		batchesVO.setBatchElectronicCheq(new Money(0));
		batchesVO.setBatchCreditCard(new Money(0));
		

		batchesVO.setBatchType(apiParams.getBatchType());
		return batchesVO;
	}
	
	public void saveAddBatchData(BatchesVO batchesVO, Parameters apiParams, Login login, PrintOutput printOutput) {

		boolean frontCounter = false; 
		try {
			orderResultVO = batchesFacade.addBatches(batchesVO, frontCounter, apiParams.getCorp(), login.getTicket());
		} catch (AmspServiceException e) {
			//e.printStackTrace();
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
		printOutput.printToShell(apiParams, " ***************** batch created successfully  ***************** \n <orderResultVO>" + orderResultVO.toString() + "</orderResultVO>", batchesVO.toXml());
	}
	
	public void saveCloseBatchData(BatchesVO batchesVO, Parameters apiParams, Login login, PrintOutput printOutput) {

		boolean frontCounter = false; 
		try {
			orderResultVO = batchesFacade.addBatches(batchesVO, frontCounter, apiParams.getCorp(), login.getTicket());
		} catch (AmspServiceException e) {
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
	}
}
