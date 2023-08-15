package tibame.articles.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tibame.articles.vo.ComReport;

@Repository
public interface CommentReportDao extends CrudRepository<ComReport, Integer> {

}
