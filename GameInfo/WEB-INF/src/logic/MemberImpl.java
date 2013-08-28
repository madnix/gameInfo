package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class MemberImpl extends JdbcDaoSupport implements Member {

	private static final String ADMINCHECK = "select * from member where user_state='admin' and user_id=?";
	
	private static final String MEMBERLIST = "select * from member";
	
	private static final String MEMBERCOUNT = "select count(*) from member";
	
	private static final String SELECT_ID_PWD = "select * "
			+ " from member where user_id=? and user_pass=?";
	// 아이디와 비번을 기준으로 디비로 부터 회원정보 검색

	private static final String SELECT_ID = "select * from member where user_id=?";
	// 아이디 기준으로 회원정보 검색
	
	private static final String SELECT_NAME="select * from member where user_name=?";
	
	private static final String SELECT_NAME_ID="select * from member where user_name=? and user_id=?";

	private static final String IDCHECK = "select user_id from member where user_id=?";

	private static final String NICKCHECK = "select user_nickname from member where user_nickname=?";
	
	private static final String GRADEUP = "update member set user_state='admin' where user_id=?";
	
	private static final String GRADEDOWN = "update member set user_state='0' where user_id=?";
	
	private static final String INSERT = "insert into member "
			+ "(no,user_id,user_pass,user_name,user_nickname,user_birth,user_mail,user_maildomain,"
			+ "user_phone1,user_phone2,user_phone3,user_zip1,user_zip2,user_addr1,user_addr2,"
			+ "user_state,user_regdate)"
			+ "values(mem_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,0,sysdate)";
	// 회원가입 저장 메서드

	private static final String UPDATE = "update member set "
			+ " user_pass=?, user_nickname=?, user_mail=?, user_maildomain=?, "
			+ " user_phone1=?, user_phone2=?, "
			+ " user_phone3=?, user_zip1=?, user_zip2=?, user_addr1=?, user_addr2=?, user_birth=? "
			+ " where user_id=?";

	private static final String DELETE = "delete member where user_id=?";

	private static final String ZIPSEARCH = "select * from zipcode where dong like '%' || ? || '%'";

	// private static final String ZIPSEARCH =
	// "select * from zipcode where dong like '%봉천%'";

	private class MemDel implements PreparedStatementSetter {

		private String id;

		public MemDel(String id) {
			this.id = id;
		}

		@Override
		public void setValues(PreparedStatement pstmt) throws SQLException {
			// TODO Auto-generated method stub
			pstmt.setString(1, this.id);
		}

	}
	
	private class EditGrade implements PreparedStatementSetter {
		
		private UserBean user;

		public EditGrade(UserBean user){
			this.user = user;
		}
		
		@Override
		public void setValues(PreparedStatement pstmt) throws SQLException {
			// TODO Auto-generated method stub
			pstmt.setString(1, this.user.getUser_id());
		}
		
	}

	private class MemEdit implements PreparedStatementSetter {

		private UserBean user;

		public MemEdit(UserBean user) {
			this.user = user;
		}

		@Override
		public void setValues(PreparedStatement pstmt) throws SQLException {
			// TODO Auto-generated method stub
			
			pstmt.setString(1, this.user.getUser_pass());
			pstmt.setString(2, this.user.getUser_nickname());
			pstmt.setString(3, this.user.getUser_mail());
			pstmt.setString(4, this.user.getUser_maildomain());
			pstmt.setString(5, this.user.getUser_phone1());
			pstmt.setString(6, this.user.getUser_phone2());
			pstmt.setString(7, this.user.getUser_phone3());
			pstmt.setString(8, this.user.getUser_zip1());
			pstmt.setString(9, this.user.getUser_zip2());
			pstmt.setString(10, this.user.getUser_addr1());
			pstmt.setString(11, this.user.getUser_addr2());
			pstmt.setString(12, this.user.getUser_birth());
			pstmt.setString(13, this.user.getUser_id());
		}

	}

	private class MemInsert implements PreparedStatementSetter {
		// 회원가입 저장 클래스

		private UserBean user;

		public MemInsert(UserBean user) {
			this.user = user;
		}

		@Override
		public void setValues(PreparedStatement pstmt) throws SQLException {
			// TODO Auto-generated method stub
			pstmt.setString(1, this.user.getUser_id());
			pstmt.setString(2, this.user.getUser_pass());
			pstmt.setString(3, this.user.getUser_name());
			pstmt.setString(4, this.user.getUser_nickname());
			pstmt.setString(5, this.user.getUser_birth());
			pstmt.setString(6, this.user.getUser_mail());
			pstmt.setString(7, this.user.getUser_maildomain());
			pstmt.setString(8, this.user.getUser_phone1());
			pstmt.setString(9, this.user.getUser_phone2());
			pstmt.setString(10, this.user.getUser_phone3());
			pstmt.setString(11, this.user.getUser_zip1());
			pstmt.setString(12, this.user.getUser_zip2());
			pstmt.setString(13, this.user.getUser_addr1());
			pstmt.setString(14, this.user.getUser_addr2());
		}

	}

	private class NickCheck implements PreparedStatementSetter {
		// 전달인자로 넘어온 아이디 저장 클래스

		private String user_nickname;

		public NickCheck(String user_nickname) {
			this.user_nickname = user_nickname;
		}

		@Override
		public void setValues(PreparedStatement pstmt) throws SQLException {
			// TODO Auto-generated method stub
			pstmt.setString(1, this.user_nickname);
		}
	}
	
	private class MemIdCheck2 implements PreparedStatementSetter {
		// 전달인자로 넘어온 아이디 저장 클래스

		private String user_id;

		public MemIdCheck2(String user_id) {
			this.user_id = user_id;
		}

		@Override
		public void setValues(PreparedStatement pstmt) throws SQLException {
			// TODO Auto-generated method stub
			pstmt.setString(1, this.user_id);
		}
	}

	private class MemIdCheck implements PreparedStatementSetter {
		// 아이디 비밀번호 세팅

		private String user_id;
		private String user_pass;

		public MemIdCheck(String user_id, String user_pass) {
			this.user_id = user_id;
			this.user_pass = user_pass;
		}

		@Override
		public void setValues(PreparedStatement pstmt) throws SQLException {
			// TODO Auto-generated method stub
			pstmt.setString(1, this.user_id);
			pstmt.setString(2, this.user_pass);
		}

	}
	private class AdminCheck implements PreparedStatementSetter{

		private String user_id;
		
		public AdminCheck(String user_id){
			this.user_id=user_id;
		}
		
		@Override
		public void setValues(PreparedStatement pstmt) throws SQLException {
			// TODO Auto-generated method stub
			pstmt.setString(1, this.user_id);
		}
		
	}
	private class MemNameCheck implements PreparedStatementSetter {
		// 전달인자로 넘어온 아이디 저장 클래스

		private String user_name;

		public MemNameCheck(String user_name) {
			this.user_name = user_name;
		}

		@Override
		public void setValues(PreparedStatement pstmt) throws SQLException {
			// TODO Auto-generated method stub
			pstmt.setString(1, this.user_name);
		}
	}
	private class MemNameIdCheck implements PreparedStatementSetter {
		// 전달인자로 넘어온 아이디 저장 클래스

		private String user_name;
		private String user_id;

		public MemNameIdCheck(String user_name, String user_id) {
			this.user_name = user_name;
			this.user_id=user_id;
		}

		@Override
		public void setValues(PreparedStatement pstmt) throws SQLException {
			// TODO Auto-generated method stub
			pstmt.setString(1, this.user_name);
			pstmt.setString(2, this.user_id);
		}
	}
	@SuppressWarnings("rawtypes")
	private class MemIdResult implements ResultSetExtractor {
		// 로그인 인증후 db 회원정보를 가져오는 클래스

		@Override
		public Object extractData(ResultSet rs) throws SQLException,
				DataAccessException {
			// TODO Auto-generated method stub
			if (rs.next()) {// 검색결과 레코드가 있을때 실행
				UserBean user = new UserBean();
				user.setUser_id(rs.getString("user_id"));
				user.setUser_pass(rs.getString("user_pass"));
				user.setUser_name(rs.getString("user_name"));
				user.setUser_nickname(rs.getString("user_nickname"));
				user.setUser_zip1(rs.getString("user_zip1"));
				user.setUser_zip2(rs.getString("user_zip2"));
				user.setUser_addr1(rs.getString("user_addr1"));
				user.setUser_addr2(rs.getString("user_addr2"));
				user.setUser_state(rs.getString("user_state"));
				user.setUser_mail(rs.getString("user_mail"));
				user.setUser_maildomain(rs.getString("user_maildomain"));
				user.setUser_birth(rs.getString("user_birth"));

				return user;
			}
			return null;
		}
	}
	
//	@SuppressWarnings("rawtypes")
//	private class MemList implements ResultSetExtractor{
//
//		Map memlist = new HashMap();
//		@SuppressWarnings("unchecked")
//		@Override
//		public Object extractData(ResultSet rs) throws SQLException,
//				DataAccessException {
//			// TODO Auto-generated method stub
//			if(rs.next()){
//				memlist.put("id", rs.getString("user_id"));
//				memlist.put("pass", rs.getString("user_pass"));
//				memlist.put("name", rs.getString("user_name"));
//				memlist.put("nickname", rs.getString("user_nickname"));
//				memlist.put("zip1", rs.getString("user_zip1"));
//				memlist.put("zip2", rs.getString("user_zip2"));
//				memlist.put("addr1", rs.getString("user_addr1"));
//				memlist.put("addr2", rs.getString("user_addr2"));
//				memlist.put("mail", rs.getString("user_mail"));
//				memlist.put("maildomain", rs.getString("user_maildomain"));
//				memlist.put("birth", rs.getString("user_birth"));
//				
//				return memlist;
//			}
//			return null;
//		}
//		
//	}

	


	
	
	private class NickChecking implements ResultSetExtractor {

		@Override
		public Object extractData(ResultSet rs) throws SQLException,
				DataAccessException {
			// TODO Auto-generated method stub
			if (rs.next()) {
				UserBean user = new UserBean();
				user.setUser_nickname(rs.getString("user_nickname"));

				return user;
			}
			return null;
		}

	}	
	
	private class MemIdChecking implements ResultSetExtractor {

		@Override
		public Object extractData(ResultSet rs) throws SQLException,
				DataAccessException {
			// TODO Auto-generated method stub
			if (rs.next()) {
				UserBean user = new UserBean();
				user.setUser_id(rs.getString("user_id"));

				return user;
			}
			return null;
		}

	}

	@SuppressWarnings("unused")
	private class MemZipSearching implements ResultSetExtractor {

		@Override
		public Object extractData(ResultSet rs) throws SQLException,
				DataAccessException {
			// TODO Auto-generated method stub
			if (rs.next()) {

			}
			return null;
		}

	}

	private class MemZipCheck implements RowMapper {

		@Override
		public Object mapRow(ResultSet rs, int arg1) throws SQLException {
			ZipSetExtractor extractor = new ZipSetExtractor();
			return extractor.extractData(rs);

		}

	}

	private class ZipSetExtractor implements ResultSetExtractor {

		@Override
		public Object extractData(ResultSet rs) throws SQLException {
			ZipcodeBean bean = new ZipcodeBean();
			bean.setPostcode(rs.getString(1));
			bean.setJuso(rs.getString(2));
			return bean;
		}

	}
	

	@SuppressWarnings("unchecked")
	@Override
	public UserBean getLoginCheck(UserBean user) {
		// TODO Auto-generated method stub
		return (UserBean) getJdbcTemplate().query(SELECT_ID_PWD,
				new MemIdCheck(user.getUser_id(), user.getUser_pass()),
				new MemIdResult());
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserBean getFindId(UserBean user) {
		// TODO Auto-generated method stub
		return (UserBean) getJdbcTemplate().query(SELECT_ID,
				new MemIdCheck2(user.getUser_id()), new MemIdResult());
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserBean admincheck(UserBean user) {
		// TODO Auto-generated method stub
		return (UserBean) getJdbcTemplate().query(ADMINCHECK,
				new AdminCheck(user.getUser_id()), new MemIdResult());
	}


	@Override
	public int membercount() {
		// TODO Auto-generated method stub
		return getJdbcTemplate().queryForInt(MEMBERCOUNT);
	}
	
	@Override
	public void gradeup(UserBean user) {
		// TODO Auto-generated method stub
		getJdbcTemplate().update(MemberImpl.GRADEUP, new EditGrade(user));
	}

	@Override
	public void gradedown(UserBean user) {
		// TODO Auto-generated method stub
		getJdbcTemplate().update(MemberImpl.GRADEDOWN, new EditGrade(user));
	}
	
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<UserBean> memlist() {
//		// TODO Auto-generated method stub
//		List<UserBean> list=getJdbcTemplate().query(MEMBERLIST,new MemList());
//		return list;
//	}
	
	@SuppressWarnings("unchecked")
	@Override
	public UserBean idFind(UserBean user) {
		// TODO Auto-generated method stub
		return (UserBean) getJdbcTemplate().query(SELECT_NAME,
				new MemNameCheck(user.getUser_name()),new MemIdResult());
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserBean pwdFind(UserBean user) {
		// TODO Auto-generated method stub
		return (UserBean) getJdbcTemplate().query(SELECT_NAME_ID, 
				new MemNameIdCheck(user.getUser_name(), user.getUser_id()),new MemIdResult());
	}
	
	@Override
	public void insertMember(UserBean user) {
		// TODO Auto-generated method stub
		getJdbcTemplate().update(MemberImpl.INSERT, new MemInsert(user));
	}

	@Override
	public void updateMember(UserBean user) {
		// TODO Auto-generated method stub
		getJdbcTemplate().update(MemberImpl.UPDATE, new MemEdit(user));
	}

	@Override
	public void deleteMember(String id) {
		// TODO Auto-generated method stub
		getJdbcTemplate().update(MemberImpl.DELETE, new MemDel(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserBean idCheck(UserBean user) {
		// TODO Auto-generated method stub
		return (UserBean) getJdbcTemplate().query(IDCHECK,
				new MemIdCheck2(user.getUser_id()), new MemIdChecking());
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserBean nickCheck(UserBean user) {
		// TODO Auto-generated method stub
		return (UserBean) getJdbcTemplate().query(NICKCHECK, new NickCheck(user.getUser_nickname()), new NickChecking());
	}
	private Connection getConnection2() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:xe", "admin", "admin");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	@Override
	public List<UserBean> mem_List() {
		// TODO Auto-generated method stub
		Connection con = null;
		// DataSource ds = this.getDataSource();
		PreparedStatement pstmt = null; // 쿼리문 실행
		ResultSet rs = null; // 쿼리문 실행 결과 레코드를 저장할 rs
		List<UserBean> list = new ArrayList();
		
		UserBean bean = new UserBean();
		
		try {
			con = this.getConnection2();
			// sql=ZIPSEARCH;
			// like는 ~와 비슷한 문자열을 검색
			pstmt = con.prepareStatement(MEMBERLIST);
			// %는 하나이상의 임의의 문자열과 매핑
			rs = pstmt.executeQuery();// 쿼리문을 실행

			while (rs.next()) {
				
				String user_id=rs.getString("user_id");
				String user_pass=rs.getString("user_pass");
				String user_name=rs.getString("user_name");
				String user_nickname=rs.getString("user_nickname");
				String user_birth=rs.getString("user_birth");
				String user_mail=rs.getString("user_mail");
				String user_maildomain=rs.getString("user_maildomain");
				String user_phone1=rs.getString("user_phone1");
				String user_phone2=rs.getString("user_phone2");
				String user_phone3=rs.getString("user_phone3");
				String user_zip1=rs.getString("user_zip1");
				String user_zip2=rs.getString("user_zip2");
				String user_addr1=rs.getString("user_addr1");
				String user_addr2=rs.getString("user_addr2");
				String user_state=rs.getString("user_state");

				//UserBean bean = new UserBean();
				
				bean.setUser_id(user_id);
				bean.setUser_pass(user_pass);
				bean.setUser_name(user_name);
				bean.setUser_nickname(user_nickname);
				bean.setUser_birth(user_birth);
				bean.setUser_mail(user_mail);
				bean.setUser_maildomain(user_maildomain);
				bean.setUser_phone1(user_phone1);
				bean.setUser_phone2(user_phone2);
				bean.setUser_phone3(user_phone3);
				bean.setUser_zip1(user_zip1);
				bean.setUser_zip2(user_zip2);
				bean.setUser_addr1(user_addr1);
				bean.setUser_addr2(user_addr2);
				bean.setUser_state(user_state);

				list.add(bean);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<ZipcodeBean> zipCheck(String dong) {
		// TODO Auto-generated method stub
		// MemZipCheck mzc = new MemZipCheck();

		// List<ZipcodeBean> list = (List<ZipcodeBean>)
		// getJdbcTemplate().query(ZIPSEARCH,
		// new MemZipCheck());
		// System.out.println("list2");
		Connection con = null;
		// DataSource ds = this.getDataSource();
		PreparedStatement pstmt = null; // 쿼리문 실행
		ResultSet rs = null; // 쿼리문 실행 결과 레코드를 저장할 rs
		List zipcodeList = new ArrayList();
		try {
			con = this.getConnection2();
			// sql=ZIPSEARCH;
			// like는 ~와 비슷한 문자열을 검색
			pstmt = con.prepareStatement(ZIPSEARCH);
			pstmt.setString(1, dong);
			// %는 하나이상의 임의의 문자열과 매핑
			rs = pstmt.executeQuery();// 쿼리문을 실행

			while (rs.next()) {
				// ZipcodeBean bean = new ZipcodeBean();
				String zipcode = rs.getString("zipcode");// 우편번호 저장
				String sido = rs.getString("sido"); // 시도 저장
				String gugun = rs.getString("gugun"); // 구군 저장
				String dong2 = rs.getString("dong");// 읍면동을 저장
				String bunji = rs.getString("bunji");// 번지 저장
				String addr = sido + " " + gugun + " " + dong2;// 번지뺀 주소값 저장
				String addr2 = sido + " " + gugun + " " + dong2 + " " + bunji;

				// bean.setPostcode(zipcode);
				// bean.setJuso(addr);

				// zipcodeList.add(bean);
				zipcodeList.add(zipcode + "," + addr + "," + addr2);
				// 컬렉션에 추가
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return zipcodeList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserBean userInfo(String id) {

		Connection con = null;
		// DataSource ds = this.getDataSource();
		PreparedStatement pstmt = null; // 쿼리문 실행
		ResultSet rs = null; // 쿼리문 실행 결과 레코드를 저장할 rs
		// List userInfo=new ArrayList();
		UserBean user = null;
		try {
			con = this.getConnection2();
			pstmt = con.prepareStatement(SELECT_ID);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();// 쿼리문을 실행
			user = new UserBean();
			if (rs.next()) {

				id = rs.getString("user_id");
				String pwd = rs.getString("user_pass");
				String name = rs.getString("user_name");
				String nickname = rs.getString("user_nickname");
				String zip1 = rs.getString("user_zip1");
				String zip2 = rs.getString("user_zip2");
				String addr1 = rs.getString("user_addr1");
				String addr2 = rs.getString("user_addr2");
				String mail = rs.getString("user_mail");
				String maildomain = rs.getString("user_maildomain");
				String phone1 = rs.getString("user_phone1");
				String phone2 = rs.getString("user_phone2");
				String phone3 = rs.getString("user_phone3");
				String birth = rs.getString("user_birth");

				user.setUser_id(id);
				user.setUser_pass(pwd);
				user.setUser_name(name);
				user.setUser_nickname(nickname);
				user.setUser_zip1(zip1);
				user.setUser_zip2(zip2);
				user.setUser_addr1(addr1);
				user.setUser_addr2(addr2);
				user.setUser_mail(mail);
				user.setUser_maildomain(maildomain);
				user.setUser_phone1(phone1);
				user.setUser_phone2(phone2);
				user.setUser_phone3(phone3);
				user.setUser_birth(birth);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;

	}

}
