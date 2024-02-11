package app.set;

import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.valueobject.personnelmaintenance.SalesmanDetailsVO; 

public class SetSalesmanDetailsVO_Test {

	private SalesmanDetailsVO salesmanDetailsVO = new SalesmanDetailsVO ();
	
	public SalesmanDetailsVO setSalesmanDetailsVOforCreateNewSalsman (Parameters apiParams, PrintOutput printOutput) {
		
		// void setComment(java.lang.String comment)
		salesmanDetailsVO.setComment(apiParams.getComment());
		// void setCorpset(java.lang.String[] corpset)
		salesmanDetailsVO.setCorpset(apiParams.getCorpSet());
		// void setInitial(java.lang.String initial)
		salesmanDetailsVO.setInitial(apiParams.getInitial());
		// void setLastName(java.lang.String lastName)
		salesmanDetailsVO.setLastName(apiParams.getLastName());
		// void setSalesRepId(java.lang.String salesRepId)
		salesmanDetailsVO.setSalesRepId(apiParams.getSalesRepId());
		// void setStatus(java.lang.Integer status)
		salesmanDetailsVO.setStatus(apiParams.getStatus());
		// void setType(java.lang.String type)
		salesmanDetailsVO.setType(apiParams.getType());
	
		
		if (salesmanDetailsVO != null) {
			printOutput.printToShell(apiParams, 
									 getClass().getName() + ":<salesmanDetailsVO>" + salesmanDetailsVO.toString() + "</salesmanDetailsVO>",
									 salesmanDetailsVO.toXml());
		}
		else {
			printOutput.printToShell(apiParams, getClass().getName() + ":<salesmanDetailsVO> is null", null);
		}
 
		return (salesmanDetailsVO);
	}
}
