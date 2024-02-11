package app.get;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.CorpparamFacade;
import amdocs.amsp.valueobject.corpparam.EquipmentClassTypeVO;

public class GetEquipmentClassTypeTest {
	
	private EquipmentClassTypeVO[] equipmentClassTypeVOlist = null;
	private CorpparamFacade corpparamFacade = new CorpparamFacade();
	
	public EquipmentClassTypeVO[] getEquipmentClassType (Parameters apiParams, Login login, PrintOutput printOutput) {
		try {
			
			equipmentClassTypeVOlist = corpparamFacade.getEquipmentClassType(apiParams.getCorp(), login.getTicket());
            
			if (equipmentClassTypeVOlist != null) {
				for (int i = 0; i != equipmentClassTypeVOlist.length; i++) {
					printOutput.printToShell(apiParams, 
							getClass().getName() + ":<equipmentClassTypeVOlist id=" + i + ">" + equipmentClassTypeVOlist[i].toString() + "</equipmentClassTypeVOlist>",
							equipmentClassTypeVOlist[i].toXml());
	 			}
			} else {
				printOutput.printToShell(apiParams, getClass().getName() + ":<equipmentClassTypeVOlist> is null", null);
			}
			
		} catch (AmspServiceException e) {
				printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
		
		return (equipmentClassTypeVOlist);
	}
}
