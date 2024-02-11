package app.set;

import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.valueobject.dispatchjobs.DispatchVO;

public class SetDispatchVO_Test {
	
private DispatchVO dispatchVO = new DispatchVO();
	
public DispatchVO setDispatchVOforCompleteChangeOfServiceJob (Parameters apiParams, PrintOutput printOutput) {
		
		dispatchVO.setBeginDateTime(apiParams.getBeginDateTime());
		dispatchVO.setCdwDate(apiParams.getCdwDate());
		dispatchVO.setCheckinAlert(apiParams.getCheckinAlert());
		dispatchVO.setCompleteDate(apiParams.getCompleteDate());
		dispatchVO.setCompleteTime(apiParams.getCompleteTime());
		dispatchVO.setCustAcct(apiParams.getCust_acct());
		dispatchVO.setDMoney(apiParams.getDMoney());
		dispatchVO.setDSeq(apiParams.getDSeq());
		dispatchVO.setNotDoneReason(apiParams.getReasonCode());
		dispatchVO.setOrderComment(apiParams.getOrderComment());
		dispatchVO.setSiteId(apiParams.getsiteId());
		dispatchVO.setTag(apiParams.getTag());
		dispatchVO.setTech(apiParams.getTechId());
		
		printOutput.printToShell(apiParams, 
								 getClass().getName() + ":<dispatchVO>" + dispatchVO.toString() + "</dispatchVO>",
								 dispatchVO.toXml());
		return dispatchVO;
	}

	public DispatchVO setDispatchVOforSROJob (Parameters apiParams, PrintOutput printOutput) {
		
		dispatchVO.setBeginDateTime(apiParams.getBeginDateTime());
		dispatchVO.setCdwDate(apiParams.getCdwDate());
		dispatchVO.setCheckinAlert(apiParams.getCheckinAlert());
		dispatchVO.setCompleteDate(apiParams.getCompleteDate());
		dispatchVO.setCompleteTime(apiParams.getCompleteTime());
		dispatchVO.setCustAcct(apiParams.getCust_acct());
		dispatchVO.setDMoney(apiParams.getDMoney());
		dispatchVO.setDSeq(apiParams.getDSeq());
		dispatchVO.setNotDoneReason(apiParams.getReasonCode());
		dispatchVO.setOrderComment(apiParams.getOrderComment());
		dispatchVO.setSiteId(apiParams.getsiteId());
		dispatchVO.setTag(apiParams.getTag());
		dispatchVO.setTech(apiParams.getTechId());
		
		printOutput.printToShell(apiParams, 
								 getClass().getName() + ":<dispatchVO>" + dispatchVO.toString() + "</dispatchVO>",
								 dispatchVO.toXml());
		return dispatchVO;
}
}
