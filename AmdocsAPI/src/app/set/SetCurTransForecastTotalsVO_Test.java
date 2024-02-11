package app.set;

import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.valueobject.order.CurTransForecastTotalsVO;
import amdocs.core.Money;


public class SetCurTransForecastTotalsVO_Test {
	
	private CurTransForecastTotalsVO curTransForecastTotalsVO = new CurTransForecastTotalsVO();
	
	public CurTransForecastTotalsVO setCurTransForecastTotalsVOforInstall(Parameters apiParams, PrintOutput printOutput) {
		
		curTransForecastTotalsVO.setCurRecalTotal(new Money(0.00));
		curTransForecastTotalsVO.setCurSavedTotal(new Money(0.00));
		curTransForecastTotalsVO.setCurTaxesTotal(new Money(0.00));
		curTransForecastTotalsVO.setDepositTaxes(new Money(0.00));
		curTransForecastTotalsVO.setLastBillDate(apiParams.getBillDate());		
		curTransForecastTotalsVO.setLastOnetimeCharge(new Money(0.00));
		curTransForecastTotalsVO.setLastSavedDeposit(new Money(0.00));
		curTransForecastTotalsVO.setLastSavedMonthlyRate(new Money(0.00));
		curTransForecastTotalsVO.setLastSavedTotal(new Money(0.00));
		curTransForecastTotalsVO.setLastSavings(new Money(0.00));
		curTransForecastTotalsVO.setLastServiceProrate(new Money(0.00));
		curTransForecastTotalsVO.setMonthlyRateTaxes(new Money(0.00));
		curTransForecastTotalsVO.setOneTimeChargeTaxes(new Money(0.00));
		curTransForecastTotalsVO.setRecalcDeposit(new Money(0.00));
		curTransForecastTotalsVO.setRecalcMonthlyRate(new Money(0.00));
		curTransForecastTotalsVO.setRecalcOneTimeCharge(new Money(0.00));
		curTransForecastTotalsVO.setRecalcSavings(new Money(0.00));
		curTransForecastTotalsVO.setRecalcServiceProrate(new Money(0.00));
		curTransForecastTotalsVO.setRecalcTotal(new Money(0.00));
		curTransForecastTotalsVO.setServiceProrateTax(new Money(0.00));
		curTransForecastTotalsVO.setTaxesTotal(new Money(0.00));

		if (curTransForecastTotalsVO != null) {
			printOutput.printToShell(apiParams, 
					getClass().getName() + ":<CurTransForecastTotalsVO>" + curTransForecastTotalsVO.toString() + "</CurTransForecastTotalsVO>",
					curTransForecastTotalsVO.toXml());
		}
		else {
			printOutput.printToShell(apiParams, getClass().getName() + ":<curTransForecastTotalsVO> is null", null);
		}
		
		return (curTransForecastTotalsVO);
	}
	
public CurTransForecastTotalsVO setCurTransForecastTotalsVOforChangeOfService(Parameters apiParams, PrintOutput printOutput) {
		
		//curTransForecastTotalsVO.setCurRecalTotal(new Money(6.70));
		// setCurSavedTotal(amdocs.core.Money curSavedTotal)
		//curTransForecastTotalsVO.setCurTaxesTotal(new Money(0.00));
		// setDepositTaxes(amdocs.core.Money depositTaxes)
		curTransForecastTotalsVO.setLastBillDate(apiParams.getBillDate());
		//calendar.set(2012, 2, 27);
		//curTransForecastTotalsVO.setLastBillDate(calendar.getTime());		
		// setLastOnetimeCharge(amdocs.core.Money lastOnetimeCharge)
		// setLastSavedDeposit(amdocs.core.Money lastSavedDeposit)
		// setLastSavedMonthlyRate(amdocs.core.Money lastSavedMonthlyRate)
		// setLastSavedTotal(amdocs.core.Money lastSavedTotal)
		// setLastSavings(amdocs.core.Money lastSavings)
		// setLastServiceProrate(amdocs.core.Money lastServiceProrate)
		//curTransForecastTotalsVO.setMonthlyRateTaxes(new Money(0.00));
		// setOneTimeChargeTaxes(amdocs.core.Money oneTimeChargeTaxes)
		// setRecalcDeposit(amdocs.core.Money recalcDeposit)
		//curTransForecastTotalsVO.setRecalcMonthlyRate(new Money(9.25));
		// setRecalcOneTimeCharge(amdocs.core.Money recalcOneTimeCharge)
		//curTransForecastTotalsVO.setRecalcSavings(new Money(0.00));
		//curTransForecastTotalsVO.setRecalcServiceProrate(new Money(6.70));
		//curTransForecastTotalsVO.setRecalcTotal(new Money(15.95));
		//curTransForecastTotalsVO.setServiceProrateTax(new Money(0.00));
		//curTransForecastTotalsVO.setTaxesTotal(new Money(0.00));

		if (curTransForecastTotalsVO != null) {
			printOutput.printToShell(apiParams, 
					getClass().getName() + ":<CurTransForecastTotalsVO>" + curTransForecastTotalsVO.toString() + "</CurTransForecastTotalsVO>",
					curTransForecastTotalsVO.toXml());
		}
		else {
			printOutput.printToShell(apiParams, getClass().getName() + ":<curTransForecastTotalsVO> is null", null);
		}
		
		return (curTransForecastTotalsVO);
	}

	public CurTransForecastTotalsVO setCurTransForecastTotalsVOforProspectOffer(Parameters apiParams, PrintOutput printOutput) {
	
		//curTransForecastTotalsVO.setCurRecalTotal(new Money(6.70));
		// setCurSavedTotal(amdocs.core.Money curSavedTotal)
		//curTransForecastTotalsVO.setCurTaxesTotal(new Money(0.00));
		// setDepositTaxes(amdocs.core.Money depositTaxes)
		curTransForecastTotalsVO.setLastBillDate(apiParams.getBillDate());		
		// setLastOnetimeCharge(amdocs.core.Money lastOnetimeCharge)
		// setLastSavedDeposit(amdocs.core.Money lastSavedDeposit)
		// setLastSavedMonthlyRate(amdocs.core.Money lastSavedMonthlyRate)
		// setLastSavedTotal(amdocs.core.Money lastSavedTotal)
		// setLastSavings(amdocs.core.Money lastSavings)
		// setLastServiceProrate(amdocs.core.Money lastServiceProrate)
		// curTransForecastTotalsVO.setMonthlyRateTaxes(new Money(0.00));
		// setOneTimeChargeTaxes(amdocs.core.Money oneTimeChargeTaxes)
		// setRecalcDeposit(amdocs.core.Money recalcDeposit)
		// curTransForecastTotalsVO.setRecalcMonthlyRate(new Money(9.25));
		// setRecalcOneTimeCharge(amdocs.core.Money recalcOneTimeCharge)
		// curTransForecastTotalsVO.setRecalcSavings(new Money(0.00));
		// curTransForecastTotalsVO.setRecalcServiceProrate(new Money(6.70));
		// curTransForecastTotalsVO.setRecalcTotal(new Money(15.95));
		// curTransForecastTotalsVO.setServiceProrateTax(new Money(0.00));
		// curTransForecastTotalsVO.setTaxesTotal(new Money(0.00));
	
		if (curTransForecastTotalsVO != null) {
			printOutput.printToShell(apiParams, 
					getClass().getName() + ":<CurTransForecastTotalsVO>" + curTransForecastTotalsVO.toString() + "</CurTransForecastTotalsVO>",
					curTransForecastTotalsVO.toXml());
		}
		else {
			printOutput.printToShell(apiParams, getClass().getName() + ":<curTransForecastTotalsVO> is null", null);
		}
		
		return (curTransForecastTotalsVO);
	}
}
