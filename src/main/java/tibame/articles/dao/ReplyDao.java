package tibame.articles.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tibame.articles.vo.Reply;

@Repository
public interface ReplyDao extends CrudRepository<Reply, Integer> {

	List<Reply> findByReplyComId(Integer replyComId);

}
