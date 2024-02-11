package app.opr;

import java.util.ArrayList;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import util.SupportException;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.OpInstallFacade;
import amdocs.amsp.valueobject.accountconstraints.CustomerConstraintsVO;
import amdocs.amsp.valueobject.accountviewfinancials.AgedMoneyVO;
import amdocs.amsp.valueobject.accountviewwip.OrderGroupVO;
import amdocs.amsp.valueobject.accountviewwip.WipTaskInfoVO;
import amdocs.amsp.valueobject.contracts.TemplateDetailVO;
import amdocs.amsp.valueobject.customer.CustomerDetailsVO;
import amdocs.amsp.valueobject.financial.MoneyTransactionVO;
import amdocs.amsp.valueobject.opquery.PackageDataVO;
import amdocs.amsp.valueobject.opquery.PackageDetailsVO;
import amdocs.amsp.valueobject.opquery.PollRecalculateServicesVO;
import amdocs.amsp.valueobject.opquery.RateCodeSelectionIpVO;
import amdocs.amsp.valueobject.order.OrderInfoVO;
import amdocs.amsp.valueobject.order.OrderResultVO;
import amdocs.amsp.valueobject.order.OrderVO;
import amdocs.amsp.valueobject.orderflow.OrderOptionVO;
import amdocs.amsp.valueobject.schedule.ScheduleVO;
import amdocs.amsp.valueobject.servicepoint.ContractVO;
import amdocs.amsp.valueobject.servicepoint.RateCodeVO;
import amdocs.amsp.valueobject.servicepoint.ServicePointVO;
import amdocs.amsp.valueobject.servicepoint.TaskVO;
import amdocs.amsp.valueobject.site.SiteDetailsVO;
import app.get.GetCustomerConstraintsVO_Test;
import app.get.GetNewInstallCustomerDetailsTest;
import app.get.GetNewInstallOrderTest;
import app.get.GetNewMoneyTransactionVO_Test;
import app.get.GetOrderOptionTest;
import app.get.GetOrderQualifiedContractTemplatesTest;
import app.get.GetPackageCodeDetailsTest;
import app.get.GetPackageLinesTest;
import app.get.GetRateCodeDetailTest;
import app.get.GetSiteDetailVO_Test;
import app.get.GetWorkTaskCodesTest;
import app.misc.ApplyContractServicesTest;
import app.misc.CheckCustomerPhoneTest;
import app.misc.RecalculateServicesTest;
import app.set.SetContractVO_Test;
import app.set.SetRateCodeSelectionIpVO_Test;
import app.set.SetServicePointVO_Test;
import app.set.SetTaskVO_Test;
import app.update.UpdateCustomerVO_Test;
import app.update.UpdateOrderInfoVO_Test;
import app.update.UpdateOrderVO_Test;
import app.update.UpdateRateCodeVO_Test;
import app.update.UpdateScheduleVO_Test;

public class OprOPInstallTest {
	
	private OpInstallFacade opInstallFacade = new OpInstallFacade();
	
	private AgedMoneyVO[] agedMoneyVOList = new AgedMoneyVO[9];
	private ContractVO[] contractVOList = new ContractVO[1];
	private CustomerDetailsVO customerDetailsVO = new CustomerDetailsVO();
	private CustomerConstraintsVO customerConstraintsVO = new CustomerConstraintsVO();
	private OrderGroupVO[] orderGroupVOList = new OrderGroupVO[1];
	private OrderVO orderVO = new OrderVO();
	@SuppressWarnings("unused")
	private OrderVO recalcOrderVO = new OrderVO();
	private OrderInfoVO orderInfoVO = new OrderInfoVO();
	private OrderOptionVO[] orderOptionVOList = null;
	private OrderResultVO orderResultVO = new OrderResultVO();
	private PackageDataVO[] packageDataVOList = null;
	@SuppressWarnings("unused")
	private PackageDetailsVO[] packageDetailsVOList = null;
	private ArrayList<PackageDetailsVO> dynPackageDetailsVOList = new ArrayList<PackageDetailsVO>();
	private PollRecalculateServicesVO pollRecalculateServicesVO = new PollRecalculateServicesVO();
	private RecalculateServicesTest recalculateServicesTest = new RecalculateServicesTest();
	private RateCodeVO[] rateCodeVOList = new RateCodeVO[1];
	private RateCodeSelectionIpVO rateCodeSelectionIp = new RateCodeSelectionIpVO();
	private MoneyTransactionVO moneyTransactionVO = new MoneyTransactionVO();
	private ScheduleVO scheduleVO = new ScheduleVO();
	private ServicePointVO[] servicePointVOList = new ServicePointVO[1];
	private SiteDetailsVO siteDetailsVO = new SiteDetailsVO();
	private TaskVO[] taskVOList = new TaskVO[1];
	private TemplateDetailVO[] templateDetailVOList = null;
	private WipTaskInfoVO wipTaskInfoVO = new WipTaskInfoVO();
	
	private ApplyContractServicesTest applyContractServicesTest = new ApplyContractServicesTest();
	private CheckCustomerPhoneTest checkCustomerPhoneTest = new CheckCustomerPhoneTest();
	
	private GetCustomerConstraintsVO_Test getCustomerConstraintsVO_Test = new GetCustomerConstraintsVO_Test();
	private GetNewInstallCustomerDetailsTest getNewInstallCustomerDetailsTest = new GetNewInstallCustomerDetailsTest();
	private GetNewInstallOrderTest getNewInstallOrderTest = new GetNewInstallOrderTest();
	private GetNewMoneyTransactionVO_Test getNewMoneyTransactionVO_Test = new GetNewMoneyTransactionVO_Test();
	private GetOrderOptionTest getOrderOptionTest = new GetOrderOptionTest();
	private GetOrderQualifiedContractTemplatesTest getOrderQualifiedContractTemplatesTest = new GetOrderQualifiedContractTemplatesTest();
	private GetPackageCodeDetailsTest getPackageCodeDetailsTest = new GetPackageCodeDetailsTest();
	private GetPackageLinesTest getPackageLinesTest = new GetPackageLinesTest();
	private GetRateCodeDetailTest getRateCodeDetailTest = new GetRateCodeDetailTest();
	private GetSiteDetailVO_Test getSiteDetailVO_Test = new GetSiteDetailVO_Test();
	private GetWorkTaskCodesTest getWorkTaskCodesTest = new GetWorkTaskCodesTest();
	
	private SetContractVO_Test setContractVO_Test = new SetContractVO_Test();
	private SetRateCodeSelectionIpVO_Test setRateCodeSelectionIpVO_Test = new SetRateCodeSelectionIpVO_Test();
	SetServicePointVO_Test setServicePointVO_Test = new SetServicePointVO_Test();
	private SetTaskVO_Test setTaskVO_Test = new SetTaskVO_Test();
	
	private UpdateCustomerVO_Test updateCustomerVO_Test = new UpdateCustomerVO_Test();
	private UpdateOrderInfoVO_Test updateOrderInfoVO_Test = new UpdateOrderInfoVO_Test();
	private UpdateOrderVO_Test updateOrderVO_Test = new UpdateOrderVO_Test();
	private UpdateRateCodeVO_Test updateRateCodeVO_Test = new UpdateRateCodeVO_Test();
	private UpdateScheduleVO_Test updateScheduleVO_Test = new UpdateScheduleVO_Test();
	
	// check if Install option is available for APi client Operator
	public void checkOption (Parameters apiParams, Login login, PrintOutput printOutput) throws SupportException {
		
		orderOptionVOList = getOrderOptionTest.getOrderOption(apiParams, login, printOutput);
		
		if (orderOptionVOList[0].getEnabled() == false) {
			throw new SupportException("orderOptionVOList[0].getEnabled() = " + orderOptionVOList[0].getEnabled());
		}
	}
	
	public void getData (Parameters apiParams, Login login, PrintOutput printOutput) throws SupportException {
		
		orderVO = getNewInstallOrderTest.getNewInstallOrder(apiParams, login, printOutput);
		
		// Runtime Parameter update
		apiParams.setOfferNum(apiParams, printOutput, orderVO.getOrderInfoList().getOfferNumber());
		
		siteDetailsVO = getSiteDetailVO_Test.getSiteDetail(apiParams, login, printOutput);
		
		customerDetailsVO = getNewInstallCustomerDetailsTest.getNewInstallCustomerDetails(apiParams, login, printOutput);
				
		// Gets all Packages
		packageDataVOList = getPackageCodeDetailsTest.getPackageCodeDetails(apiParams, login, printOutput);
		
		// Process all Packages to get details
		for (int i = 0; i != packageDataVOList.length; i++) {
			
			// Runtime Parameter update
			apiParams.setPackageCode(apiParams, printOutput, packageDataVOList[i].getPackageCode()); // Set Parameter value to current Package Code
			
			rateCodeSelectionIp = setRateCodeSelectionIpVO_Test.setRateCodeSelectionIpVOforInstall(apiParams, printOutput);
			
			// Add current object to dynamic list
			dynPackageDetailsVOList.add(getPackageLinesTest.getPackageLines(apiParams, 
																		    login, 
																		    printOutput, 
																		    rateCodeSelectionIp, 
																		    customerDetailsVO, 
																		    siteDetailsVO, 
																		    orderVO));
		}
		
		// Convert the dynamic list to an array
		if (dynPackageDetailsVOList.isEmpty() == false) {
			
			// Each element of this VO has all the Headers and Rate Codes associated with each Package
			packageDetailsVOList = dynPackageDetailsVOList.toArray(new PackageDetailsVO[dynPackageDetailsVOList.size()]);
		} // Not printing array contents because all Package details are printed in getPackageLinesTest.getPackageLines()
		
		// Get all Contract Templates
		templateDetailVOList = getOrderQualifiedContractTemplatesTest.getOrderQualifiedContractTemplates(apiParams, login, printOutput);
		
		// Runtime Parameter update - Setting the Template ID to the value in the first Contract Template in list
		apiParams.setContractTemplateId(apiParams, printOutput, templateDetailVOList[0].getTemplateId());
		
		// Check for duplicate phone number
		if(checkCustomerPhoneTest.checkData(apiParams, login, printOutput) != null) {
			throw new SupportException("Phone number already exists");
		}
		
		customerConstraintsVO = getCustomerConstraintsVO_Test.getCustomerConstraints(apiParams, login, printOutput);
		
		moneyTransactionVO = getNewMoneyTransactionVO_Test.getNewMoneyTranasction(apiParams, login, printOutput);
		
		rateCodeVOList[0] = getRateCodeDetailTest.getRateCodeDetail(apiParams, login, printOutput, 1);
	}
	
	public void setData (Parameters apiParams, Login login, PrintOutput printOutput) throws SupportException {
		
		updateCustomerVO_Test.updateCustomerDetailsForInstall(apiParams, 
															  printOutput,
															  siteDetailsVO,
															  customerConstraintsVO, 
															  customerDetailsVO);
		
		wipTaskInfoVO = getWorkTaskCodesTest.loadTaskInfoVO(apiParams, login, printOutput, apiParams.getTaskCode());
		
		taskVOList[0] = setTaskVO_Test.setTaskVOforInstall(apiParams, printOutput, wipTaskInfoVO);
		
		updateRateCodeVO_Test.updateRateCodeVOforInstall(apiParams, printOutput, rateCodeVOList[0]);
		
		orderGroupVOList[0] = new OrderGroupVO();
		orderGroupVOList[0].setOrderGroupSeq(apiParams.getOrderGroupSeq());
		
		servicePointVOList[0] = new ServicePointVO();
		servicePointVOList[0] = setServicePointVO_Test.setServicePointVOforInstallWithContract(apiParams, 
																 			 				   printOutput,
																 			 				   rateCodeVOList, 
																 			 				   orderGroupVOList, 
																 			 				   taskVOList);
		
		orderInfoVO = orderVO.getOrderInfoList();
		
		scheduleVO = orderInfoVO.getSchedule();
		updateScheduleVO_Test.updateScheduleVOforInstall(apiParams, 
				 										 printOutput, 
				 										 scheduleVO);
		
		updateOrderInfoVO_Test.updateOrderInfoVOforInstall(apiParams, 
				   										   printOutput,
				   										   agedMoneyVOList,
				   										   customerDetailsVO,
				   										   orderGroupVOList, 
				   										   orderInfoVO, 
				   										   scheduleVO);
		contractVOList[0] = new ContractVO();
		contractVOList[0] = setContractVO_Test.setContractVOforInstallWithContract(apiParams, printOutput);
		
		updateOrderVO_Test.updateOrderVOforInstallWithContract(apiParams, 
															   printOutput,
															   contractVOList,
															   orderInfoVO,
															   servicePointVOList,
															   orderVO);
		
		orderVO = applyContractServicesTest.applyContractServices(apiParams, printOutput, login, orderVO);
		
		pollRecalculateServicesVO = recalculateServicesTest.recalculateServices(apiParams, 
																				printOutput, 
																				login, 
																				orderVO, 
																				customerDetailsVO, 
																				siteDetailsVO);
	}
	
	public void saveData (Parameters apiParams, Login login, PrintOutput printOutput) {
		
		try {
			orderResultVO = opInstallFacade.install(customerDetailsVO, 
													siteDetailsVO, 
													pollRecalculateServicesVO.getOrderVO(), 
													null, 
													moneyTransactionVO, 
													apiParams.getQueueHsdsHitFlag(),
													apiParams.getOverriddenRuleIds(),
													apiParams.getCorp(), 
													login.getTicket());
			
			if (orderResultVO != null) {
				printOutput.printToShell(apiParams, getClass().getName() + ":<orderResultVO>" + orderResultVO.toString() + "</orderResultVO>",
										 orderResultVO.toXml());
			} else {
				printOutput.printToShell(apiParams, getClass().getName() + ":<orderResultVO> is null", null);
			}
			
		} catch (AmspServiceException e) {
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
	}
}
