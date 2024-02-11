package app.update;

import amdocs.amsp.valueobject.financial.AdjustmentVO;
import amdocs.amsp.valueobject.financial.MoneyTransactionVO;
import amdocs.amsp.valueobject.financial.PaymentVO;
import util.Parameters;
import util.PrintOutput;

public class UpdateMoneyTransactionVO_Test {
	
	public MoneyTransactionVO updateMoneyTransactionVOforAdjustment(MoneyTransactionVO moneyTransactionVO,
																 	AdjustmentVO adjustmentVO,
																 	Parameters apiParams, 
																 	PrintOutput printOutput) {

		moneyTransactionVO.setAdjustment(adjustmentVO); 
		//setCallerName(java.lang.String callerName) 
		//setCustAcct(java.lang.String custAcct) 
		moneyTransactionVO.setIsAdjustment(true); // TODO put in params 
		//setIsFrontCounterMode(boolean isFrontCounterMode)*/
		moneyTransactionVO.setIsPayment(false);   // TODO put in params
		//moneyTransactionVO.setPayment(paymentVO);
		/*setSiteId(java.lang.String siteId)*/
		
		
		printOutput.printToShell(apiParams, 
		getClass().getName() + ":<moneyTransactionVO>" + moneyTransactionVO.toString() + "</moneyTransactionVO>",
		moneyTransactionVO.toXml());
		
		return (moneyTransactionVO);
	}
	
	public MoneyTransactionVO updateMoneyTransactionVOforPayment(MoneyTransactionVO moneyTransactionVO,
															  	 PaymentVO paymentVO,
															  	 Parameters apiParams, 
															  	 PrintOutput printOutput) {
		
		/*setAdjustment(AdjustmentVO adjustment) 
		setCallerName(java.lang.String callerName) 
		setCustAcct(java.lang.String custAcct) 
		setIsAdjustment(boolean isAdjustment) 
		setIsFrontCounterMode(boolean isFrontCounterMode)*/
		moneyTransactionVO.setIsPayment(apiParams.getIsPayment());
		moneyTransactionVO.setPayment(paymentVO);
		/*setSiteId(java.lang.String siteId)*/
		
		printOutput.printToShell(apiParams, 
				 				 getClass().getName() + ":<moneyTransactionVO>" + moneyTransactionVO.toString() + "</moneyTransactionVO>",
				 				 moneyTransactionVO.toXml());
		
		return (moneyTransactionVO);
	}
}
