package app.update;


import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.valueobject.accountviewwip.WipTaskInfoVO;
import amdocs.amsp.valueobject.servicepoint.ServicePointVO;

public class UpdateWipTaskInfoVO {
	public void updateWipTaskInfoVOforChangeOfService(Parameters apiParams, 
													  PrintOutput printOutput, 
													  ServicePointVO servicePointVO,
													  WipTaskInfoVO wipTaskInfoVO) {
		wipTaskInfoVO.setJobType(apiParams.getJobType());
		wipTaskInfoVO.setOutlet(servicePointVO.getServicePoint());
		wipTaskInfoVO.setOutletLocationCode(servicePointVO.getServicePointLocationCode());
		wipTaskInfoVO.setOutletLocationDescription(servicePointVO.getServicePointShortDesc());
		//wipTaskInfoVO.setTaskCode(servicePointVO.getTaskList()[0].getTaskCode());
		//wipTaskInfoVO.setTaskDescription(servicePointVO.getTaskList()[0].getTaskDesc());
		//setTaskOrFixCodeFlag(java.lang.String taskOrFixCodeFlag)
		wipTaskInfoVO.setWorkPoints(servicePointVO.getTaskList()[0].getPoints());

		printOutput.printToShell(apiParams, 
				 				 getClass().getName() + ":<wipTaskInfoVO>" + wipTaskInfoVO.toString() + "</wipTaskInfoVO>",
				 				wipTaskInfoVO.toXml());
	}

}
