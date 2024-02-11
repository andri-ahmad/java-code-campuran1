package app.opr;

import amdocs.amsp.valueobject.corpparam.EquipmentClassTypeVO;
import amdocs.amsp.valueobject.customer.CustomerDetailsVO;
import amdocs.amsp.valueobject.servicepoint.BoxPortListVO;
import amdocs.amsp.valueobject.servicepoint.BoxRepairHistListVO;
import amdocs.amsp.valueobject.servicepoint.EquipmentVO;
import app.get.GetBoxPortSvcsTest;
import app.get.GetBoxReprHist;
import app.get.GetCustomerDetailsVO_Test;
import app.get.GetEquipmentClassTypeTest;
import app.get.GetEquipmentDetailsVO_Test;
import util.Login;
import util.Parameters;
import util.PrintOutput;

public class OprBrowseEquipmentTest {
	
	EquipmentVO equipmentVO = new EquipmentVO();
	GetEquipmentDetailsVO_Test getEquipmentDetailsVO_Test = new GetEquipmentDetailsVO_Test();
	
	BoxPortListVO[] boxPortListVOlist = null;
	GetBoxPortSvcsTest getBoxPortSvcsTest = new GetBoxPortSvcsTest();
	
	CustomerDetailsVO customerDetailsVO = new CustomerDetailsVO();
	GetCustomerDetailsVO_Test getCustomerDetailsVO_Test = new GetCustomerDetailsVO_Test();
	
	BoxRepairHistListVO[] boxRepairHistListVO = null;
	GetBoxReprHist getBoxReprHist = new GetBoxReprHist();
	
	EquipmentClassTypeVO[] equipmentClassTypeVOlist = null;
	GetEquipmentClassTypeTest getEquipmentClassTypeTest = new GetEquipmentClassTypeTest();
	
	public void getData (Parameters apiParams, Login login, PrintOutput printOutput) {
		
		equipmentVO = getEquipmentDetailsVO_Test.getEquipmentDetails(apiParams, login, printOutput);
		
		boxPortListVOlist = getBoxPortSvcsTest.getBoxPortSvcs(apiParams, login, printOutput);
		
		customerDetailsVO = getCustomerDetailsVO_Test.getCustomerDetail(apiParams, login, printOutput);
		printOutput.printToShell(apiParams, "Just printing only required fields from CustomerDetailsVO according to the screen.", null);
		printOutput.printToShell(apiParams, "Info       :  " + customerDetailsVO.getInfoCode(), null);
		printOutput.printToShell(apiParams, "InfoDesc   :  " + customerDetailsVO.getInfoDesc(), null);
		printOutput.printToShell(apiParams, "HomePhone  :  " + customerDetailsVO.getHomePhone(), null);
		printOutput.printToShell(apiParams, "Cust Acct  :  " + customerDetailsVO.getCustAcct(), null);
		printOutput.printToShell(apiParams, "Site Id    :  " + customerDetailsVO.getSiteId(), null);
		
		boxRepairHistListVO = getBoxReprHist.getBoxReprHist(apiParams, login, printOutput);
		
	}

}
