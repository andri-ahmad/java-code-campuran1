package app.update;

import amdocs.amsp.valueobject.dispatchjobs.DispatchVO;
import util.Parameters;
import util.PrintOutput;

public class UpdateDispatchVO_Test {
	
	public void updateDispatchVOforCompleteJob (Parameters apiParams, PrintOutput printOutput, DispatchVO dispatchVO) {
		
		if (dispatchVO != null) {
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
		} else {
			printOutput.printToShell(apiParams, 
					getClass().getName() + ":<dispatchVO> is null", null);
		}
	}
}
