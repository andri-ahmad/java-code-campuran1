package app.set;

import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.valueobject.schedule.ScheduleVO;

public class SetScheduleVO_Test {
	
	private ScheduleVO scheduleVO = new ScheduleVO();
	
	public ScheduleVO setScheduleVOforInstall (Parameters apiParams, PrintOutput printOutput){
		
		scheduleVO.setAction(apiParams.getScheduleVOaction());
		// setIsMustDo(boolean isMustDo)
		// setIsNoAppt(boolean isNoAppt)
		// scheduleVO.setNoApptReasonCode("Z    ");
		// scheduleVO.setNoApptReasonDesc("OTHER               ");
		// setNoSchdReasonCode(java.lang.String noSchdReasonCode)
		// setNoSchdReasonDesc(java.lang.String noSchdReasonDesc)
		// setPriorityCode(java.lang.String priorityCode)
		// setPriorityDesc(java.lang.String priorityDesc)
		// scheduleVO.setQuotaGroupCode((short)2);
		// setQuotaGroupDesc(java.lang.String quotaGroupDesc)
		// setQuotaTimeSlotCode(short quotaTimeSlotCode)
		// setQuotaTimeSlotDesc(java.lang.String quotaTimeSlotDesc)
		scheduleVO.setScheduleDate(apiParams.getBillDate());
		scheduleVO.setScheduleType((short) apiParams.getScheduleType());
		scheduleVO.setTechId(apiParams.getTechId());
		// scheduleVO.setTechName("NO-TRUCK      ");
		// setTimeCodeCode(java.lang.String timeCodeCode)
		// setTimeCodeDesc(java.lang.String timeCodeDesc)
		
		if (scheduleVO != null) {
			printOutput.printToShell(apiParams, 
					getClass().getName() + ":<scheduleVO>" + scheduleVO.toString() + "</scheduleVO>",
					scheduleVO.toXml());
		}
		else {
			printOutput.printToShell(apiParams, getClass().getName() + ":<scheduleVO> is null", null);
		}
		
		return (scheduleVO);
	}
	
public ScheduleVO setScheduleVOforChangeOfService (Parameters apiParams, PrintOutput printOutput){
		
		scheduleVO.setAction(apiParams.getScheduleVOaction());
		// setIsMustDo(boolean isMustDo)
		// setIsNoAppt(boolean isNoAppt)
		// scheduleVO.setNoApptReasonCode("Z    ");
		// scheduleVO.setNoApptReasonDesc("OTHER               ");
		// setNoSchdReasonCode(java.lang.String noSchdReasonCode)
		// setNoSchdReasonDesc(java.lang.String noSchdReasonDesc)
		// setPriorityCode(java.lang.String priorityCode)
		// setPriorityDesc(java.lang.String priorityDesc)
		// scheduleVO.setQuotaGroupCode((short)2);
		// setQuotaGroupDesc(java.lang.String quotaGroupDesc)
		// setQuotaTimeSlotCode(short quotaTimeSlotCode)
		// setQuotaTimeSlotDesc(java.lang.String quotaTimeSlotDesc)
		scheduleVO.setScheduleDate(apiParams.getScheduleDate());
		scheduleVO.setScheduleType((short)apiParams.getScheduleType());
		scheduleVO.setTechId(apiParams.getTechId());
		//scheduleVO.setTechName("NO-TRUCK      ");
		// setTimeCodeCode(java.lang.String timeCodeCode)
		// setTimeCodeDesc(java.lang.String timeCodeDesc)
		
		if (scheduleVO != null) {
			printOutput.printToShell(apiParams, 
					getClass().getName() + ":<scheduleVO>" + scheduleVO.toString() + "</scheduleVO>",
					scheduleVO.toXml());
		}
		else {
			printOutput.printToShell(apiParams, getClass().getName() + ":<scheduleVO> is null", null);
		}
		
		return (scheduleVO);
	}

	public ScheduleVO setScheduleVOforProspectOffer (Parameters apiParams, PrintOutput printOutput){
	
		scheduleVO.setAction(apiParams.getScheduleVOaction());
		// setIsMustDo(boolean isMustDo)
		// setIsNoAppt(boolean isNoAppt)
		// scheduleVO.setNoApptReasonCode("Z    ");
		// scheduleVO.setNoApptReasonDesc("OTHER               ");
		// setNoSchdReasonCode(java.lang.String noSchdReasonCode)
		// setNoSchdReasonDesc(java.lang.String noSchdReasonDesc)
		// setPriorityCode(java.lang.String priorityCode)
		// setPriorityDesc(java.lang.String priorityDesc)
		// scheduleVO.setQuotaGroupCode((short)2);
		// setQuotaGroupDesc(java.lang.String quotaGroupDesc)
		// setQuotaTimeSlotCode(short quotaTimeSlotCode)
		// setQuotaTimeSlotDesc(java.lang.String quotaTimeSlotDesc)
		//scheduleVO.setScheduleDate(apiParams.getScheduleDate());
		scheduleVO.setScheduleType((short) apiParams.getScheduleType());
		scheduleVO.setTechId(apiParams.getTechId());
		// scheduleVO.setTechName("NO-TRUCK      ");
		// setTimeCodeCode(java.lang.String timeCodeCode)
		// setTimeCodeDesc(java.lang.String timeCodeDesc)
		
		if (scheduleVO != null) {
			printOutput.printToShell(apiParams, 
					getClass().getName() + ":<scheduleVO>" + scheduleVO.toString() + "</scheduleVO>",
					scheduleVO.toXml());
		}
		else {
			printOutput.printToShell(apiParams, getClass().getName() + ":<scheduleVO> is null", null);
		}
		
		return (scheduleVO);
	}
}
