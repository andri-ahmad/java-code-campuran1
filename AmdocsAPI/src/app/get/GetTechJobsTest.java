package app.get;

import util.Login;
import util.Parameters;
import util.PrintOutput;

import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.TechviewjobsFacade;
import amdocs.amsp.valueobject.techviewjobs.TechViewJobsResultVO;

public class GetTechJobsTest {
	
	private TechviewjobsFacade techviewjobsFacade = new TechviewjobsFacade();
	private TechViewJobsResultVO[] techViewJobsResultVO = null;
	
	public TechViewJobsResultVO[] getTechJobs (Parameters apiParams, Login login, PrintOutput printOutput) {
			
		try {
			
			for (int jobtype = 1; jobtype <= 8; jobtype++) {
				techViewJobsResultVO = techviewjobsFacade.getTechJobs(apiParams.getTechId(),
													                    jobtype,
													                    apiParams.getsiteId(),
													                    apiParams.getCust_acct(),
													                    apiParams.getScheduleDate(),
													                    apiParams.getOffernum(),
													                    apiParams.getCorp(),
													                    login.getTicket());
			}
			
			if (techViewJobsResultVO != null) {
				for (int i = 0; i != techViewJobsResultVO.length; i++) {
				printOutput.printToShell(apiParams, 
						getClass().getName() + ":<techViewJobsResultVO> elem: " + i + " " + techViewJobsResultVO[i].toString() + "</techViewJobsResultVO>", techViewJobsResultVO[i].toXml());
				}
			}
			else {
				printOutput.printToShell(apiParams, getClass().getName() + ":<techViewJobsResultVO> is null", null);
			}	
			
		}
		catch (AmspServiceException e) 	{
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
		
		return (techViewJobsResultVO);
	}
}
