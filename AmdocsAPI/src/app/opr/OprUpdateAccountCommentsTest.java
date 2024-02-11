package app.opr;

import util.Lock;
import util.Login;
import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.exception.AmspServiceException;
import amdocs.amsp.services.AccountCommentsFacade;
import amdocs.amsp.valueobject.accountcomments.CommentsVO;
import app.get.GetAccountCommentsVO_Test;
import app.set.SetCommentVO_Test;

public class OprUpdateAccountCommentsTest {
	private AccountCommentsFacade accountCommentsFacade = new AccountCommentsFacade();
	private CommentsVO[] commentsVO = null;
	
	private GetAccountCommentsVO_Test getAccountCommentsTest = new GetAccountCommentsVO_Test();
	private SetCommentVO_Test setCommentVO_Test = new SetCommentVO_Test();
	
	public void getData (Parameters apiParams, Login login, Lock lock, PrintOutput printOutput) {
		commentsVO = getAccountCommentsTest.getAccountComments(apiParams, login, printOutput);
	}
	
	public void setData (Parameters apiParams, PrintOutput printOutput) {
		commentsVO = setCommentVO_Test.setComment(apiParams, printOutput);
	}
	
	public void updateData (Parameters apiParams, Login login, PrintOutput printOutput) {
		try {
			String result = accountCommentsFacade.updateAccountComments(
				commentsVO,
                apiParams.getsiteId(),
                apiParams.getCust_acct(),
                apiParams.getCorp(),
                login.getTicket());
			
			printOutput.printToShell(apiParams, 
					getClass().getName() + ":<result>" + result + "</result>", null);
			// get the comments again to verify change
			commentsVO = getAccountCommentsTest.getAccountComments(apiParams, login, printOutput);

		} catch (AmspServiceException e) {
			printOutput.printExceptionToShell(apiParams, getClass().getName(), e);
		}
	}
} // end of UpdateAccountComments class
