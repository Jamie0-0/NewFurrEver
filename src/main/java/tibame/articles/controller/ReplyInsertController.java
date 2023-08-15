package tibame.articles.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import tibame.articles.service.ReplyService;
import tibame.articles.vo.Reply;

@Controller
public class ReplyInsertController {

	private final ReplyService service;

	@Autowired
	public ReplyInsertController(ReplyService service) {
		this.service = service;
	}

	@PostMapping("/replyInsert") // 後OK 前端form表單就不能用RequestBody接
	public String insertReply(@RequestParam String replyContent, @RequestParam Integer replyComId,
			@SessionAttribute Integer uid) {

		Reply reply = Reply.builder().replyContent(replyContent).replyComId(replyComId).replyUserId(uid).build();

		service.insertReply(reply);

		return "redirect:/article.html";
	}

}
