package tibame.articles.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tibame.articles.service.ReplyReportService;
import tibame.articles.vo.ReplyReport;

@RestController
public class ReplyReportController {

	private final ReplyReportService service;

	@Autowired
	public ReplyReportController(ReplyReportService service) {
		this.service = service;
	}

	@GetMapping("/replyReport") // 後OK
	public int replyReport(@RequestBody ReplyReport replyReport) {

		return service.replyReport(replyReport);
	}

}
