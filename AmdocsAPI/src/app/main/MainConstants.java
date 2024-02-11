package app.main;

import amdocs.amsp.AddressConstantsI;
import amdocs.amsp.ServiceConstantsI;

public class MainConstants {

	public static void main(String[] args) {
		System.out.println("ServiceConstantsI.AccountCategory.RESIDENTIAL = " + ServiceConstantsI.AccountCategory.RESIDENTIAL.getAcctCatTypeValue());
		System.out.println("ServiceConstantsI.OrderType.ORDER_INSTALL = " + ServiceConstantsI.OrderType.ORDER_INSTALL.getOrderTypeValue());
		System.out.println("ServiceConstantsI.OrderType.DISCONNECT = " + ServiceConstantsI.OrderType.ORDER_DISCONNECT.getOrderTypeValue());
		System.out.println("ServiceConstantsI.NO_TRUCK = " + ServiceConstantsI.NO_TRUCK);
		System.out.println("ServiceConstantsI.JobType.JOBTYPE_COS = " + ServiceConstantsI.JobType.JOBTYPE_COS.getJobTypeValue());
		System.out.println("ServiceConstantsI.OrderType.ORDER_RESCHEDULE = " + ServiceConstantsI.OrderType.ORDER_RESCHEDULE.getOrderTypeValue());
		System.out.println("AddressConstantsI.AddrUseContext.SERVICE_ADDRESS = " +AddressConstantsI.AddrUseContext.SERVICE_ADDRESS.getAddrUseContextValue());
	}

}
