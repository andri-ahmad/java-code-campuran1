package app.get;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import util.SupportException;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.CorpparamFacade;
import amdocs.amsp.valueobject.servicepoint.RateCodeVO;

public class GetRateCodeDetailTest {
	
	private CorpparamFacade corpparamFacade = new CorpparamFacade();
	private RateCodeVO rateCodeVO = new RateCodeVO();
	
	public RateCodeVO getRateCodeDetail (Parameters apiParams, Login login, PrintOutput printOutput, int rateCodeIndex) throws SupportException {
		try {
			switch (rateCodeIndex) {
			case 1:
				rateCodeVO = corpparamFacade.getRateCodeDetail(apiParams.getRateCode1(), apiParams.getCorp(), login.getTicket());
				break;
				
			case 2:
				rateCodeVO = corpparamFacade.getRateCodeDetail(apiParams.getRateCode2(), apiParams.getCorp(), login.getTicket());
				break;
			
			case 3:
				rateCodeVO = corpparamFacade.getRateCodeDetail(apiParams.getRateCode3(), apiParams.getCorp(), login.getTicket());
				break;
			
			case 4:
				rateCodeVO = corpparamFacade.getRateCodeDetail(apiParams.getRateCode4(), apiParams.getCorp(), login.getTicket());
				break;
			
			default:
				printOutput.printToShell(apiParams, getClass().getName() + "Bad value passed: " + rateCodeIndex, null);
				break;
			
			}

			if (rateCodeVO != null) {
				printOutput.printToShell(apiParams,
	            		                 getClass().getName() + ":<rateCodeVO>" +rateCodeVO.toString() + "</rateCodeVO>",
	            		                 rateCodeVO.toXml());
			}
			else {
				throw new SupportException("rateCodeVO is null");
			}
		
	} catch (AmspServiceException e) {
		printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
	}
		return(rateCodeVO);
	}
}
