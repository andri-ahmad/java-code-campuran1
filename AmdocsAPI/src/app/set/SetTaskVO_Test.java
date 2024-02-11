package app.set;

import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.valueobject.accountviewwip.WipTaskInfoVO;
import amdocs.amsp.valueobject.servicepoint.TaskVO;

public class SetTaskVO_Test {
	
	private TaskVO taskVO = new TaskVO();
	
	public TaskVO setTaskVOforChangeOfService (Parameters apiParams, PrintOutput printOutput, WipTaskInfoVO wipTaskInfoVO) {
		
		taskVO.setPoints((short)wipTaskInfoVO.getWorkPoints());
		taskVO.setTaskCode(wipTaskInfoVO.getTaskCode());
		taskVO.setTaskDesc(wipTaskInfoVO.getTaskDescription());
		
		if (taskVO != null) {
			printOutput.printToShell(apiParams, 
					getClass().getName() + ":<taskVO>" + taskVO.toString() + "</taskVO>",
					taskVO.toXml());
		}
		else {
			printOutput.printToShell(apiParams, getClass().getName() + ":<taskVO> is null", null);
		}
		
		return (taskVO);
	}
	
public TaskVO setTaskVOforInstall (Parameters apiParams, PrintOutput printOutput, WipTaskInfoVO wipTaskInfoVO) {
		
		//setCustomPointsAllowed(boolean customPointsAllowed)
		//setIsDefaultTask(boolean isDefaultTask)
		taskVO.setPoints((short)wipTaskInfoVO.getWorkPoints());
		taskVO.setTaskCode(wipTaskInfoVO.getTaskCode());
		//taskVO.setTaskDesc("API INSTALL         ");
		
		if (taskVO != null) {
			printOutput.printToShell(apiParams, 
					getClass().getName() + ":<taskVO>" + taskVO.toString() + "</taskVO>",
					taskVO.toXml());
		}
		else {
			printOutput.printToShell(apiParams, getClass().getName() + ":<taskVO> is null", null);
		}
		
		return (taskVO);
	}

public TaskVO setTaskVOforProspectOffer (Parameters apiParams, PrintOutput printOutput, WipTaskInfoVO wipTaskInfoVO) {
		
		//setCustomPointsAllowed(boolean customPointsAllowed)
		//setIsDefaultTask(boolean isDefaultTask)
		taskVO.setPoints((short)wipTaskInfoVO.getWorkPoints());
		taskVO.setTaskCode(wipTaskInfoVO.getTaskCode());
		//taskVO.setTaskDesc("API INSTALL         ");
		
		if (taskVO != null) {
			printOutput.printToShell(apiParams, 
					getClass().getName() + ":<taskVO>" + taskVO.toString() + "</taskVO>",
					taskVO.toXml());
		}
		else {
			printOutput.printToShell(apiParams, getClass().getName() + ":<taskVO> is null", null);
		}
		
		return (taskVO);
	}
}
