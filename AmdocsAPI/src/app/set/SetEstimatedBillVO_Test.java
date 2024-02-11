package app.set;

import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.valueobject.order.EstimatedBillVO;
import amdocs.core.Money;

public class SetEstimatedBillVO_Test {
	
	private EstimatedBillVO[] estimatedBillVOArr = new EstimatedBillVO[6];
    private EstimatedBillVO   estimatedBillVO    = new EstimatedBillVO();
    
    public EstimatedBillVO[] setEstimatedBillVO_Test(Parameters apiParams, PrintOutput printOutput) {

    	// Elem 0
    	estimatedBillVO = new EstimatedBillVO();
    	estimatedBillVO.setAmount(new Money(0.00));
    	estimatedBillVO.setAmountType(0); // INCREMENTAL(0), DEPOSIT(1), PRORATE(2), MONTHLYSERVICE(3), TAX(4), ETF(5)
        estimatedBillVO.setLabel("install");
        estimatedBillVOArr[0] = estimatedBillVO;
        
        // Elem 1
        estimatedBillVO = new EstimatedBillVO();
        estimatedBillVO.setAmount(new Money(0.00));
        estimatedBillVO.setAmountType(1); // INCREMENTAL(0), DEPOSIT(1), PRORATE(2), MONTHLYSERVICE(3), TAX(4), ETF(5)
        estimatedBillVO.setLabel("Deposit");
        estimatedBillVOArr[1] = estimatedBillVO;
        
        // Elem 2
        estimatedBillVO = new EstimatedBillVO();
        estimatedBillVO.setAmount(new Money(0.00));
        estimatedBillVO.setAmountType(2); // INCREMENTAL(0), DEPOSIT(1), PRORATE(2), MONTHLYSERVICE(3), TAX(4), ETF(5)
        estimatedBillVO.setLabel("Prorate");
        estimatedBillVOArr[2] = estimatedBillVO;
        
        // Elem 3
        estimatedBillVO = new EstimatedBillVO();
        estimatedBillVO.setAmount(new Money(0.00));
        estimatedBillVO.setAmountType(3); // INCREMENTAL(0), DEPOSIT(1), PRORATE(2), MONTHLYSERVICE(3), TAX(4), ETF(5)
        estimatedBillVO.setLabel("Service");
        estimatedBillVOArr[3] = estimatedBillVO;
        
        // Elem 4
        estimatedBillVO = new EstimatedBillVO();
        estimatedBillVO.setAmount(new Money(0.00));
        estimatedBillVO.setAmountType(4); // INCREMENTAL(0), DEPOSIT(1), PRORATE(2), MONTHLYSERVICE(3), TAX(4), ETF(5)
        estimatedBillVO.setLabel("Tax amount");
        estimatedBillVOArr[4] = estimatedBillVO;
        
        // Elem 5
        estimatedBillVO = new EstimatedBillVO();
        estimatedBillVO.setAmount(new Money(0.00));
        estimatedBillVO.setAmountType(5); // INCREMENTAL(0), DEPOSIT(1), PRORATE(2), MONTHLYSERVICE(3), TAX(4), ETF(5)
        estimatedBillVO.setLabel("Termination fee");
        estimatedBillVOArr[5] = estimatedBillVO;
        
        if (estimatedBillVOArr != null) {
        	for (int i = 0; i != estimatedBillVOArr.length; i++) 
    		{		
    			printOutput.printToShell(apiParams, 
    					getClass().getName() + ":<estimatedBillVOArr>" + estimatedBillVOArr[i].toString() + "</estimatedBillVOArr>",
    					estimatedBillVOArr[i].toXml());
    		}
		}
		else {
			printOutput.printToShell(apiParams, getClass().getName() + ":<estimatedBillVOArr> is null", null);
		}
		
    	return (estimatedBillVOArr);
    }

}
