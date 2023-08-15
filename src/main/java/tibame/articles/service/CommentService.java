package tibame.articles.service;

import java.util.List;

import tibame.articles.vo.Comment;

public interface CommentService {

	List<Comment> selectComment(Integer com_art_id);

	Comment updateComment(Comment comment);

	int selectComCount(Integer comArtId);

	Comment insertComment(Comment comment);

}