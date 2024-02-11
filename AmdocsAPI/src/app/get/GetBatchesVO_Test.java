package app.get;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.BatchesFacade;
import amdocs.amsp.valueobject.batches.BatchesVO;

public class GetBatchesVO_Test {
	
	private BatchesFacade batchesFacade = new BatchesFacade();
	private BatchesVO[] batchesVOlist = null;
	
	public BatchesVO[] getBatches (Parameters apiParams, Login login, PrintOutput printOutput) {
		
		try {
			batchesVOlist = batchesFacade.getBatches(apiParams.getCorp(), login.getTicket());
			
			if (batchesVOlist != null) {
				for (int i = 0; i < batchesVOlist.length; i++) {
					printOutput.printToShell(apiParams, 
											 getClass().getName() + ":<batchesVOlist[" + i + "] " + batchesVOlist[i].toString() + "</batchesVOlist[" + i + "]>",
											 batchesVOlist[i].toXml());
				}
			}
			else {
				printOutput.printToShell(apiParams, getClass().getName() + ":<batchesVOlist> is null", null);
			}
			
		}
		catch (AmspServiceException e) 	{
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
		return (batchesVOlist);
	}
}
