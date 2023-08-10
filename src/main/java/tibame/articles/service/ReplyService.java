package tibame.articles.service;

import java.util.List;

import tibame.articles.vo.Reply;

public interface ReplyService {

	List<Reply> selectReply(Integer replyComId);

	int insertReply(Reply reply);

}
