package tibame.trip.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tibame.trip.dao.ActLikeDao;
import tibame.trip.dao.TripDao;
import tibame.trip.dao.TripJdbcDao;
import tibame.trip.service.TripService;
import tibame.trip.vo.Trip;

@Component
public class TripServiceImpl implements TripService {

	@Autowired
	private TripDao tripDao;

	@Autowired
	private ActLikeDao actLikeDao;

	@Autowired
	private TripJdbcDao tripJdbcDao;

	@Override
	public List<Trip> selectMyEndTrip(Integer uid) {
		return tripJdbcDao.findMyEndTripByUid(uid);
	}

	@Transactional
	@Override
	public Integer edit(Integer tId, Integer uid) {

		return tripDao.updateByUid(tId, uid);
	}

	@Transactional
	@Override
	public Integer cancle(Integer uid, Integer tActId) {

		return tripDao.updateByUidAndPActId(uid, tActId);
	}

	@Override
	public List<Trip> findTraceTrips(Integer uid) {
		return tripJdbcDao.findTraceTripByUid(uid);
	}

	@Override
	@Transactional
	public Integer deleteMyTripLike(Integer uid, Integer tActId) {
		System.out.println("tActId:" + tActId);
		return actLikeDao.deledeleteByTActIdAndUid(tActId, uid);

	}

	@Override
	public List<Trip> selectMyHoldTrip(Integer uid) {
		return tripJdbcDao.findMyHoldTripByUid(uid);
	}

	@Override
	public List<Trip> selectJoinTrip(Integer uid) {
		return tripJdbcDao.findJoinTripByUid(uid);
	}

	@Override
	public List<Trip> selectHistoryJoinTrip(Integer uid) {
		return tripJdbcDao.findJoinHistoryTripByUid(uid);
	}

}
