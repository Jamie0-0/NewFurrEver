package tibame.articles.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tibame.articles.dao.CommentDao;
import tibame.articles.dao.CommentReportDao;
import tibame.articles.vo.ComReport;
import tibame.articles.vo.Comment;

@Service
public class CommentReportServiceImpl implements CommentReportService {

	private final CommentReportDao dao;
	private final CommentDao dao1;

	@Autowired
	public CommentReportServiceImpl(CommentReportDao dao, CommentDao dao1) {
		this.dao = dao;
		this.dao1 = dao1;
	}

	@Override
	@Transactional
	public int comReport(ComReport comReport) {
		int status = 0;
		dao.save(comReport);
		Optional<Comment> commentOptional = dao1.findById(comReport.getCrepComId());
		commentOptional.get().setComRepCount(commentOptional.get().getComRepCount() + 1);
		// Optional 要用get()取
		status = 1;
		return status;
	}
}
