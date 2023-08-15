package tibame.articles.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tibame.articles.service.CommentReportService;
import tibame.articles.vo.ComReport;

@RestController
public class CommentReportController {

	private final CommentReportService service;

	@Autowired
	public CommentReportController(CommentReportService service) {
		this.service = service;
	}

	@GetMapping("/commentReport") // 後OK
	public int commentReport(@RequestBody ComReport comReport) {

		return service.comReport(comReport);
	}

}
