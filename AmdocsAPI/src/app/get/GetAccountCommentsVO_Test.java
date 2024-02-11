package app.get;

import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.AccountCommentsFacade;
import amdocs.amsp.valueobject.accountcomments.CommentsVO;

public class GetAccountCommentsVO_Test {
	private AccountCommentsFacade accountCommentsFacade = new AccountCommentsFacade();
	private CommentsVO[] commentsVO = null;
	
	public CommentsVO[] getAccountComments(Parameters apiParams, Login login, PrintOutput printOutput) {
		
		try {
			// CommentsVO 
			commentsVO = accountCommentsFacade.getAccountComments(
					apiParams.getsiteId(),
                    apiParams.getCust_acct(),
                    1,  // 1 = HouseCustComments
                    apiParams.getCorp(),
                    login.getTicket());
            
			if (commentsVO != null) {
				for (int i = 0; i != commentsVO.length; i++) {
					printOutput.printToShell(apiParams, 
							getClass().getName() + ":<commentsVO id=" + i + ">" + commentsVO[i].toString() + "</commentsVO>",
							commentsVO[i].toXml());
	 			}
			}
			else {
				printOutput.printToShell(apiParams, getClass().getName() + ":<commentsVO> is null", null);
			}
						
		} catch (AmspServiceException e) {
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
		return (commentsVO);
	}
}
