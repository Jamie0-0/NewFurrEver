package tibame.master.service;

import tibame.master.vo.Master;

public interface MasterService {

	Master register(Master master);

	Integer login(String mEmail, String mPwd);

	Master findMasterName(String mEmail);
}
