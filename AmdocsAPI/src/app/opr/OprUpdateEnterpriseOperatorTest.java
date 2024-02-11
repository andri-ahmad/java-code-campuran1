package app.opr;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.PersonnelMaintenanceFacade;
import amdocs.amsp.valueobject.personnelmaintenance.CorpsetListVO;
import amdocs.amsp.valueobject.personnelmaintenance.CorpTemplateInfoVO;
import amdocs.amsp.valueobject.personnelmaintenance.CorpTemplateVO;
import amdocs.amsp.valueobject.personnelmaintenance.OprEnterpriseDetailsVO;
import app.get.GetEnterpriseOperatorTest;

public class OprUpdateEnterpriseOperatorTest {
	
	private PersonnelMaintenanceFacade personnelMaintenanceFacade = new PersonnelMaintenanceFacade ();
	private OprEnterpriseDetailsVO oprEnterpriseDetailsVO = new OprEnterpriseDetailsVO ();
	private GetEnterpriseOperatorTest getEnterpriseOperatorTest = new GetEnterpriseOperatorTest ();
	private CorpTemplateInfoVO[] corpTemplateInfoVO = null;
	CorpTemplateVO corpTemplateVO = new CorpTemplateVO();
	
	private CorpsetListVO[] corpsetListVO = null;
	private String returnValue = null;
	
	public void getData (Parameters apiParams, Login login, PrintOutput printOutput) {
		
		oprEnterpriseDetailsVO = getEnterpriseOperatorTest.getEnterpriseOperator(apiParams, login, printOutput);
		corpsetListVO = oprEnterpriseDetailsVO.getCorpsetList();
	}

	public void setData (Parameters apiParams, Login login, PrintOutput printOutput) {
		
		// set the status to active for all corps
		corpTemplateInfoVO = corpsetListVO[0].getCorpTemplateInfo();
		for (int i = 0; i != corpsetListVO.length; i++) 
		{		
			corpTemplateInfoVO[i].setStatus(apiParams.getOperatorStatus());
		}
		
		oprEnterpriseDetailsVO.setCorpsetList(corpsetListVO);
		
		printOutput.printToShell(apiParams, 
				getClass().getName() + ":<oprEnterpriseDetailsVO>" + oprEnterpriseDetailsVO.toString() + "</oprEnterpriseDetailsVO>", 
				oprEnterpriseDetailsVO.toXml());
	}

	public void saveData (Parameters apiParams, Login login, PrintOutput printOutput) {
		
		try {
			
			returnValue = personnelMaintenanceFacade.updateEnterpriseOperator(oprEnterpriseDetailsVO, login.getTicket());

		} catch (AmspServiceException e) {
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
		
		if (returnValue != null) {
			printOutput.printToShell(apiParams, 
									 getClass().getName() + ":<returnValue>" + returnValue + "</returnValue>",
									 null);
			printOutput.printToShell(apiParams, 
					getClass().getName() + ":<oprEnterpriseDetailsVO>" + oprEnterpriseDetailsVO.toString() + "</oprEnterpriseDetailsVO>", 
					oprEnterpriseDetailsVO.toXml());
		}
		else {
			printOutput.printToShell(apiParams, getClass().getName() + ":<returnValue> is null", null);
		}
	}
}
