package app.set;

import util.Parameters;
import util.PrintOutput;
import amdocs.amsp.valueobject.accountcomments.CommentsVO;

public class SetCommentVO_Test {
	
	private CommentsVO[] commentsVO = null;
	
	//setComment(java.lang.String comment)
	//setCommentType(java.lang.String commentType)
	//setOfferNum(java.lang.String offerNum)
	//setOprId(java.lang.String oprId)
	//setTimeStamp(java.lang.String timeStamp)
	//setTitle(java.lang.String title)
	//setTypeNumber(int typeNumber)
	//setWipCommentCount(int wipCommentCount)
	//setWjob(short wjob)

	public CommentsVO[] setComment (Parameters apiParams, PrintOutput printOutput) {
		commentsVO[0].setComment(commentsVO[0].getComment() + " API test"); //append a string to first comment
		
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
		
		return (commentsVO);
	}
}
