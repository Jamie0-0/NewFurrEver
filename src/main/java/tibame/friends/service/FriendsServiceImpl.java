package tibame.friends.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tibame.friends.dao.FriendsDao;
import tibame.friends.vo.Friend;
import tibame.friends.vo.FriendId;

@Service
public class FriendsServiceImpl implements FriendsService {

	@Autowired
	private FriendsDao dao;

	@Override
	public List<Friend> getFriends(Integer uid, String fStatus) {
		List<Friend> friendList = dao.getCurrentFriends(uid, fStatus);
		return friendList;
	}

	// 同意邀請
	@Override
	@Transactional
	public int confirmFriend(Integer uid, Integer fId, String fStatus) {
		int status = 0;
		Optional<Friend> friendOp = dao.findById(new FriendId(uid, fId));
		if (friendOp.isPresent()) {
			Friend friend = friendOp.get();
			friend.setFStatus(fStatus);
			dao.save(friend);
			status = 1;
		}
		return status;
	}

	// 發邀請
	@Override
	@Transactional
	public int inviteFriend(Integer uid, Integer fId) {
		int status = 0;
		// uid跟fId代入相反是因為確認好友時會相反
		Friend friend = Friend.builder().fUid(fId).fId(uid).fStatus("0").build();

		dao.save(friend);

		status = 1;

		return status;
	}

	// 刪除好友
	@Override
	@Transactional
	public int deleteFriend(Integer uid, Integer fId) {
		int status = 0;

		if (dao.isFriend(uid, fId) != null) {
			dao.deleteById(new FriendId(uid, fId));
		} else if (dao.isFriend(fId, uid) != null) {
			dao.deleteById(new FriendId(fId, uid));
		}

		status = 1;
		return status;
	}

}