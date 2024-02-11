package app.misc;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.OpMainOrderOptionFacade;
import amdocs.amsp.valueobject.opmainorderoption.EquipmentValidationVO;
import amdocs.amsp.valueobject.servicepoint.ServicePointVO;

public class ValidateSerialNumberTest {
	
	private OpMainOrderOptionFacade opMainOrderOptionFacade = new OpMainOrderOptionFacade();
	private EquipmentValidationVO equipmentValidationVO = new EquipmentValidationVO();
	
	public EquipmentValidationVO validateSerialNumber (Parameters apiParams, Login login, PrintOutput printOutput, ServicePointVO[] servicePointVOlist) {
		
		try { 
			equipmentValidationVO = opMainOrderOptionFacade.validateSerialNumber(apiParams.getSerialNumber(), 
																				 apiParams.getServicePoint(), 
																				 apiParams.getsiteId(), 
																				 apiParams.getCust_acct(), 
																				 servicePointVOlist, 
																				 apiParams.getCorp(), 
																				 login.getTicket());
			
			if(equipmentValidationVO != null) {	
					printOutput.printToShell(apiParams, 
											 getClass().getName() + ":<equipmentValidationVO>" + equipmentValidationVO.toString() + "</equipmentValidationVO>",
											 equipmentValidationVO.toXml());
			}
			else {
				printOutput.printToShell(apiParams, getClass().getName() + ":<equipmentValidationVO> is null", null);
			}
			
		} catch (AmspServiceException e) {
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
		
		return equipmentValidationVO;
	}

}
