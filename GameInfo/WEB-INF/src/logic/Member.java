package logic;

import java.util.List;
import java.util.Map;

public interface Member {

	UserBean getLoginCheck(UserBean user);

	UserBean getFindId(UserBean user);

	void insertMember(UserBean user);

	void updateMember(UserBean user);

	void deleteMember(String id);

	UserBean idCheck(UserBean user);
	
	List<ZipcodeBean> zipCheck(String dong);

	UserBean userInfo(String id);

	UserBean nickCheck(UserBean user);

	UserBean idFind(UserBean user);

	UserBean pwdFind(UserBean user);

	UserBean admincheck(UserBean user);

	void gradeup(UserBean user);

	void gradedown(UserBean user);

	int membercount();

	List<UserBean> mem_List();

}
