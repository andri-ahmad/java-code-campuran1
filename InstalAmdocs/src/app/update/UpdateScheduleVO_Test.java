package app.update;

import amdocs.amsp.valueobject.schedule.ScheduleVO;
import util.Parameters;
import util.PrintOutput;

public class UpdateScheduleVO_Test {
	
public void updateScheduleVOforChangeOfService (Parameters apiParams, PrintOutput printOutput, ScheduleVO scheduleVO){
		
		scheduleVO.setAction(apiParams.getScheduleVOaction());
		scheduleVO.setIsMustDo(apiParams.getIsMustDo());
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
		
		printOutput.printToShell(apiParams, 
								 getClass().getName() + ":<scheduleVO>" + scheduleVO.toString() + "</scheduleVO>",
								 scheduleVO.toXml());
	}

	public void updateScheduleVOforDisconnectNoTruck (Parameters apiParams, PrintOutput printOutput, ScheduleVO scheduleVO){
		
		scheduleVO.setAction(apiParams.getScheduleVOaction());
		scheduleVO.setIsMustDo(apiParams.getIsMustDo());
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
		
		printOutput.printToShell(apiParams, 
								 getClass().getName() + ":<scheduleVO>" + scheduleVO.toString() + "</scheduleVO>",
								 scheduleVO.toXml());
	}
	
	public void updateScheduleVOforDisconnectSchedule (Parameters apiParams, PrintOutput printOutput, ScheduleVO scheduleVO){
		
		scheduleVO.setAction(apiParams.getScheduleVOaction());
		scheduleVO.setIsMustDo(apiParams.getIsMustDo());
		// setIsNoAppt(boolean isNoAppt)
		// scheduleVO.setNoApptReasonCode("Z    ");
		// scheduleVO.setNoApptReasonDesc("OTHER               ");
		// setNoSchdReasonCode(java.lang.String noSchdReasonCode)
		// setNoSchdReasonDesc(java.lang.String noSchdReasonDesc)
		// setPriorityCode(java.lang.String priorityCode)
		// setPriorityDesc(java.lang.String priorityDesc)
		scheduleVO.setQuotaGroupCode(apiParams.getQuotaGroupCode());
		// setQuotaGroupDesc(java.lang.String quotaGroupDesc)
		scheduleVO.setQuotaTimeSlotCode(apiParams.getQuotaTimeSlotCode());
		// setQuotaTimeSlotDesc(java.lang.String quotaTimeSlotDesc)
		scheduleVO.setScheduleDate(apiParams.getScheduleDate());
		scheduleVO.setScheduleType((short)apiParams.getScheduleType());
		scheduleVO.setTechId(apiParams.getTechId());
		//scheduleVO.setTechName("NO-TRUCK      ");
		// setTimeCodeCode(java.lang.String timeCodeCode)
		// setTimeCodeDesc(java.lang.String timeCodeDesc)
		
		printOutput.printToShell(apiParams, 
								 getClass().getName() + ":<scheduleVO>" + scheduleVO.toString() + "</scheduleVO>",
								 scheduleVO.toXml());
	}

	public void updateScheduleVOforInstall (Parameters apiParams, PrintOutput printOutput, ScheduleVO scheduleVO){
	
		scheduleVO.setAction(apiParams.getScheduleVOaction());
		scheduleVO.setIsMustDo(apiParams.getIsMustDo());
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
		
		printOutput.printToShell(apiParams, 
								 getClass().getName() + ":<scheduleVO>" + scheduleVO.toString() + "</scheduleVO>",
								 scheduleVO.toXml());
	}
	
public void updateScheduleVOforRescheduleOrderChange (Parameters apiParams, PrintOutput printOutput, ScheduleVO scheduleVO){
		
		scheduleVO.setAction(apiParams.getScheduleVOaction());
		scheduleVO.setIsMustDo(apiParams.getIsMustDo());
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
		
		printOutput.printToShell(apiParams, 
								 getClass().getName() + ":<scheduleVO>" + scheduleVO.toString() + "</scheduleVO>",
								 scheduleVO.toXml());
	}
	
	public void updateScheduleVOforRescheduleOrderDatesOnly (Parameters apiParams, PrintOutput printOutput, ScheduleVO scheduleVO){
		
		scheduleVO.setAction(apiParams.getScheduleVOaction());
		scheduleVO.setIsMustDo(apiParams.getIsMustDo());
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
		
		printOutput.printToShell(apiParams, 
								 getClass().getName() + ":<scheduleVO>" + scheduleVO.toString() + "</scheduleVO>",
								 scheduleVO.toXml());
	}
	
	public void updateScheduleVOforRescheduleSRO (Parameters apiParams, PrintOutput printOutput, ScheduleVO scheduleVO){
		
		scheduleVO.setAction(apiParams.getScheduleVOaction());
		scheduleVO.setIsMustDo(apiParams.getIsMustDo());
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
		
		printOutput.printToShell(apiParams, 
								 getClass().getName() + ":<scheduleVO>" + scheduleVO.toString() + "</scheduleVO>",
								 scheduleVO.toXml());
	}
}
