package app.set;

import amdocs.amsp.valueobject.financial.PaymentVO;
import util.Parameters;
import util.PrintOutput;

public class SetPaymentVO_Test {
	
	private PaymentVO paymentVO = new PaymentVO();
	
	public PaymentVO setPaymentVOforPayment(Parameters apiParams, 
											PrintOutput printOutput) {
			 
		paymentVO.setAmount(apiParams.getAmount()); //amount - Money amount or flat rate adjustment amount
		paymentVO.setAmountTendered(apiParams.getAmountTendered());
		/*setECheck(ECheckVO eCheck) 
		setEpiRecord(EpiRecordVO[] epiRecord)*/ 
		paymentVO.setIsEcheck(apiParams.getIsEcheck());
		/*setPayCard(PayCardDetailsVO payCard)*/
		paymentVO.setPaymentKind(apiParams.getPaymentKind()); // paymentKind - PMTKIND column from EPI_TRANSACTIONS. Valid Values:0-9,A-Z.
		paymentVO.setRefrenceNumber(apiParams.getRefrenceNumber());
		
		printOutput.printToShell(apiParams, 
								 getClass().getName() + ":<paymentVO>" + paymentVO.toString() + "</paymentVO>",
								 paymentVO.toXml());

		return (paymentVO);
	}
}
