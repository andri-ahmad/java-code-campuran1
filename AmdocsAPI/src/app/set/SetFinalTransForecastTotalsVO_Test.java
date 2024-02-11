package app.set;


import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.valueobject.order.FinalTransForecastTotalsVO;
//import amdocs.core.Money;
import amdocs.core.Money;

public class SetFinalTransForecastTotalsVO_Test {
	
	private FinalTransForecastTotalsVO finalTransForecastTotalsVO = new FinalTransForecastTotalsVO();
	
	public FinalTransForecastTotalsVO setFinalTransForecastTotalsVOforInstall(Parameters apiParams, PrintOutput printOutput) {
		
		finalTransForecastTotalsVO.setActiveMonthlyRate(new Money(0.00));
		finalTransForecastTotalsVO.setActiveSavings(new Money(0.00));
		finalTransForecastTotalsVO.setFinalBillDate(apiParams.getBillDate());
		finalTransForecastTotalsVO.setOrdStartPendDeposit(new Money(0.00));
		finalTransForecastTotalsVO.setOrdStartPendOnetime(new Money(0.00));
		finalTransForecastTotalsVO.setOrdStartPendServices(new Money(0.00));
		finalTransForecastTotalsVO.setOrdStartTotal(new Money(0.00));
		finalTransForecastTotalsVO.setPendingDepositTaxes(new Money(0.00));
		finalTransForecastTotalsVO.setPendingOnetimeTaxes(new Money(0.00));
		finalTransForecastTotalsVO.setPendingSvcsTaxes(new Money(0.00));
		finalTransForecastTotalsVO.setRecalcMonthlyRate(new Money(0.00));
		finalTransForecastTotalsVO.setRecalcPendDeposit(new Money(0.00));
		finalTransForecastTotalsVO.setRecalcPendOnetime(new Money(0.00));
		finalTransForecastTotalsVO.setRecalcPendServices(new Money(0.00));
		finalTransForecastTotalsVO.setReclacSavings(new Money(0.00));
		finalTransForecastTotalsVO.setTaxesMonthlyRate(new Money(0.00));
		finalTransForecastTotalsVO.setTaxesTotal(new Money(0.00));
		
		if (finalTransForecastTotalsVO != null) {
			printOutput.printToShell(apiParams, 
					getClass().getName() + ":<FinalTransForecastTotalsVO>" + finalTransForecastTotalsVO.toString() + "</FinalTransForecastTotalsVO>",
					finalTransForecastTotalsVO.toXml());
		}
		else {
			printOutput.printToShell(apiParams, getClass().getName() + ":<finalTransForecastTotalsVO> is null", null);
		}
	
		return (finalTransForecastTotalsVO);
	}
	
	public FinalTransForecastTotalsVO setFinalTransForecastTotalsVOforChangeOfService(Parameters apiParams, PrintOutput printOutput) {
			
		// setActiveMonthlyRate(amdocs.core.Money activeMonthlyRate)
		// setActiveSavings(amdocs.core.Money activeSavings)
		finalTransForecastTotalsVO.setFinalBillDate(apiParams.getBillDate());
		// setOrdStartPendDeposit(amdocs.core.Money ordStartPendDeposit)
		// setOrdStartPendOnetime(amdocs.core.Money ordStartPendOnetime)
		// setOrdStartPendServices(amdocs.core.Money ordStartPendServices)
		// setOrdStartTotal(amdocs.core.Money ordStartTotal)
		// setPendingDepositTaxes(amdocs.core.Money pendingDepositTaxes)
		// setPendingOnetimeTaxes(amdocs.core.Money PendingOnetimeTaxes)
		// setPendingSvcsTaxes(amdocs.core.Money pendingSvcsTaxes)
		// finalTransForecastTotalsVO.setRecalcMonthlyRate(new Money(21.75));
		// setRecalcPendDeposit(amdocs.core.Money recalcPendDeposit)
		// setRecalcPendOnetime(amdocs.core.Money recalcPendOnetime)
		// setRecalcPendServices(amdocs.core.Money recalcPendServices)
		// finalTransForecastTotalsVO.setReclacSavings(new Money(0.00));
		// finalTransForecastTotalsVO.setTaxesMonthlyRate(new Money(1.88));
		// setTaxesTotal(amdocs.core.Money taxesTotal)
		
		if (finalTransForecastTotalsVO != null) {
			printOutput.printToShell(apiParams, 
					getClass().getName() + ":<FinalTransForecastTotalsVO>" + finalTransForecastTotalsVO.toString() + "</FinalTransForecastTotalsVO>",
					finalTransForecastTotalsVO.toXml());
		}
		else {
			printOutput.printToShell(apiParams, getClass().getName() + ":<finalTransForecastTotalsVO> is null", null);
		}
	
		return (finalTransForecastTotalsVO);
	}
	
	public FinalTransForecastTotalsVO setFinalTransForecastTotalsVOforProspectOffer(Parameters apiParams, PrintOutput printOutput) {
		
		// setActiveMonthlyRate(amdocs.core.Money activeMonthlyRate)
		// setActiveSavings(amdocs.core.Money activeSavings)
		finalTransForecastTotalsVO.setFinalBillDate(apiParams.getBillDate());
		// setOrdStartPendDeposit(amdocs.core.Money ordStartPendDeposit)
		// setOrdStartPendOnetime(amdocs.core.Money ordStartPendOnetime)
		// setOrdStartPendServices(amdocs.core.Money ordStartPendServices)
		// setOrdStartTotal(amdocs.core.Money ordStartTotal)
		// setPendingDepositTaxes(amdocs.core.Money pendingDepositTaxes)
		// setPendingOnetimeTaxes(amdocs.core.Money PendingOnetimeTaxes)
		// setPendingSvcsTaxes(amdocs.core.Money pendingSvcsTaxes)
		// finalTransForecastTotalsVO.setRecalcMonthlyRate(new Money(21.75));
		// setRecalcPendDeposit(amdocs.core.Money recalcPendDeposit)
		// setRecalcPendOnetime(amdocs.core.Money recalcPendOnetime)
		// setRecalcPendServices(amdocs.core.Money recalcPendServices)
		// finalTransForecastTotalsVO.setReclacSavings(new Money(0.00));
		// finalTransForecastTotalsVO.setTaxesMonthlyRate(new Money(1.88));
		// setTaxesTotal(amdocs.core.Money taxesTotal)
		
		if (finalTransForecastTotalsVO != null) {
			printOutput.printToShell(apiParams, 
					getClass().getName() + ":<FinalTransForecastTotalsVO>" + finalTransForecastTotalsVO.toString() + "</FinalTransForecastTotalsVO>",
					finalTransForecastTotalsVO.toXml());
		}
		else {
			printOutput.printToShell(apiParams, getClass().getName() + ":<finalTransForecastTotalsVO> is null", null);
		}
	
		return (finalTransForecastTotalsVO);
	}
}
