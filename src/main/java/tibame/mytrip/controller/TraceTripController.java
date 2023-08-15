package tibame.mytrip.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tibame.mytrip.service.TripService;
import tibame.mytrip.vo.Trip;

@RestController
@RequestMapping("tracetrip")
public class TraceTripController {

	@Autowired
	private TripService tripService;

	//查詢追蹤出遊活動
	
	@PostMapping
	public ResponseEntity<?> findHistorytrip(HttpSession session) {
		Integer uid = (Integer) session.getAttribute("uid");
		Map<String, Object> response = new HashMap<>();
		if (uid != null) {
			List<Trip> triplist = tripService.findTraceTrips(uid);
			if (triplist.isEmpty()) {
				response.put("noAct", 0);
				return ResponseEntity.ok(response);
			}
			response.put("activity", triplist);
			return ResponseEntity.ok(response);
		}
		response.put("noUser", 0);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
}
