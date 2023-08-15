package tibame.articles.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tibame.articles.vo.ArtUser;

@Repository
public interface ArtUserDao extends CrudRepository<ArtUser, Integer> {

	@Query("SELECT uPic FROM ArtUser WHERE uid = :userId")
	byte[] findAvatarDataByUserId(Integer userId);

}
