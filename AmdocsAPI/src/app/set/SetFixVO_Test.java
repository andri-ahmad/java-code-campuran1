package app.set;

import amdocs.amsp.valueobject.servicepoint.FixVO;
import util.Parameters;
import util.PrintOutput;

public class SetFixVO_Test {
	private FixVO  fixVO = new FixVO();
	
	public FixVO setFixVOforCompleteSROJob (Parameters apiParams, PrintOutput printOutput) {
		
		fixVO.setCustomPointsAllowed(apiParams.getCustomPointsAllowed());
		fixVO.setFixCode(apiParams.getSroFixCode());
		fixVO.setFixDesc(apiParams.getSroFixDesc());
		// setFixDesc(java.lang.String fixDesc) 
		// setPoints(short points) 
		
		if (fixVO != null) {
			
			printOutput.printToShell(apiParams, 
					getClass().getName() + ":<fixVO>" + fixVO.toString() + "</fixVO>",
					fixVO.toXml());
		} else {
			printOutput.printToShell(apiParams, 
					getClass().getName() + ":<fixVO> is null", null);
		}
		
		return fixVO;
	}
}
