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

import tibame.mytrip.service.MyTripService;
import tibame.mytrip.vo.MyTrip;

@RestController
@RequestMapping("findjointrip")
public class findJoinTripController {
	
	@Autowired
	private MyTripService tripService;

	@PostMapping
	public ResponseEntity<?> findHistorytrip(HttpSession session) {
		Integer uid = (Integer) session.getAttribute("uid");
		Map<String, Object> response = new HashMap<>();
		if (uid != null) {
			List<MyTrip> triplist = tripService.selectJoinTrip(uid);
			if (triplist.isEmpty()) {
				response.put("noAct",0);
				return ResponseEntity.ok(response);
			}
			
			return ResponseEntity.ok(triplist);
		}
		response.put("noUser", 0);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
}
