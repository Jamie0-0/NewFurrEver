package tibame.articles.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tibame.articles.vo.ArtUser;
import tibame.articles.vo.ArticlePic;

@Repository
public interface ArticleUserDao extends CrudRepository<ArtUser, Integer> {

	ArticlePic findUPicByUid(Integer uid);

}
