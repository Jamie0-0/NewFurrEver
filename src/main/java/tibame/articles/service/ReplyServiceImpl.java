package tibame.articles.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tibame.articles.dao.ReplyDao;
import tibame.articles.vo.Reply;

@Service
public class ReplyServiceImpl implements ReplyService {

	private final ReplyDao dao;

	@Autowired
	public ReplyServiceImpl(ReplyDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Reply> selectReply(Integer replyComId) {

		return dao.findByReplyComId(replyComId);
	}

	@Override
	public int insertReply(Reply reply) {

		dao.save(reply);

		return 1;
	}

}
