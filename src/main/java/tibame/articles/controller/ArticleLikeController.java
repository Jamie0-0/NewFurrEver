package tibame.articles.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import tibame.articles.service.ArticlesService;

//後端可用
@RestController
public class ArticleLikeController {

	private final ArticlesService service;

	@Autowired
	public ArticleLikeController(ArticlesService service) {
		this.service = service;
	}

	@GetMapping("/artLike")
	private int likeArticle(@RequestParam Integer artId, @SessionAttribute Integer uid) {
		int status = service.likeArticle(artId, uid);
		return status;
	}
}
