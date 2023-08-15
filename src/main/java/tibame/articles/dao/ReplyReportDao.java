package tibame.articles.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tibame.articles.vo.ReplyReport;

@Repository
public interface ReplyReportDao extends CrudRepository<ReplyReport, Integer> {

}
