package dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import logic.BbsBean;
import logic.CommentBean;
import logic.UserBean;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import util.SqlMapLocator;

public class BbsDao {

	private SimpleJdbcTemplate template;

	public void setDataSource(DataSource dataSource) {
		// 오라클 디비 연동 설정해주는 메서드
		this.template = new SimpleJdbcTemplate(dataSource);
		// 쿼리문 실행 객체 생성
	}
	
	// 회원관리
	@SuppressWarnings("unchecked")
	public List<UserBean> mem_List()
			throws SQLException {
		System.out.println("1");
		List<UserBean> list = SqlMapLocator.getMapper().queryForList(
				"mem_list");
		System.out.println("2");
		return list;

	}

	// info_xbox

	//삽입
	public void insertInfoXbox(BbsBean bbsbean) throws SQLException {
		// 삽입 메서드
		SqlMapLocator.getMapper().insert("info_xbox_insert", bbsbean);
		// insert()메서드에 의해서 저장
	}

	//게시판 글수
	public int getInfoXboxListCount() throws SQLException {
		return ((Integer) SqlMapLocator.getMapper().queryForObject(
				"info_xbox_cnt")).intValue();
		// queryForObject()메서드는 한개 검색 결과 레코드를 가져올때 실행
		// intValue()는 정수형숫자로 바꿔준다.
	}

	//댓글수
	public int getInfoXboxComCount(int no) throws SQLException{
		return ((Integer) SqlMapLocator.getMapper().queryForObject(
				"info_xbox_comcnt",no)).intValue();
	}
	//내용보기
	@SuppressWarnings("unchecked")
	public Object contInfoXbox(int no) throws SQLException {
		Map<String, Integer> getlist = new HashMap();
		getlist.put("num", no);

		Object list = SqlMapLocator.getMapper().queryForObject(
				"info_xbox_cont", getlist);
		return list;
	}

	//비밀번호 확인
	public Object infoXboxcheckpwd(int no) throws SQLException{
		Map<String, Integer> getlist = new HashMap();
		getlist.put("num", no);
		Object list = SqlMapLocator.getMapper().queryForObject("info_xbox_cont",getlist);
		
		return list;
	}
	// 수정
	public void editInfoXbox(BbsBean bbsbean) throws SQLException {
		SqlMapLocator.getMapper().update("info_xbox_edit", bbsbean);
	}

	//댓글쓰기
	public void infoXboxCom(CommentBean combean) throws SQLException{

		SqlMapLocator.getMapper().insert("info_xbox_com",combean);
		
	}

	//댓글보기
	@SuppressWarnings("unchecked")
	public List<CommentBean> infoXboxComView(int no) throws SQLException {
		
		Map<String, Integer> getlist=new HashMap();
		getlist.put("num", no);
		
		List<CommentBean> list=SqlMapLocator.getMapper().queryForList(
				"info_xbox_comview",getlist);
		return list;
	}
	
	// 조회수
	public void infoXboxhit(int no) throws SQLException {
		SqlMapLocator.getMapper().update("info_xbox_hit", no);
	}

	// 삭제
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void delInfoXbox(int no, String pwd) throws SQLException {
		 Map del = new HashMap();
		 del.put("num", no);
		 del.put("pass", pwd);
		SqlMapLocator.getMapper().delete("info_xbox_del", del);
	}
	
	//댓글삭제(글삭제시)
	public void infoXboxComDelAll(int no) throws SQLException {
		SqlMapLocator.getMapper().delete("info_xbox_comdelall", no);
	}
	
	//리스트
	@SuppressWarnings("unchecked")
	public List<BbsBean> getInfoXboxList(int page, int limit)
			throws SQLException {
		Map<String, Integer> getlist = new HashMap();
		getlist.put("startrow", (page - 1) * limit + 1);
		getlist.put("endrow", page * limit);

		List<BbsBean> list = SqlMapLocator.getMapper().queryForList(
				"info_xbox_List", getlist);
		return list;

	}

	//검색 결과 수
	public int getInfoXboxFindCount() throws SQLException {
		// TODO Auto-generated method stub
		return ((Integer) SqlMapLocator.getMapper().queryForObject(
				"info_xbox_findcnt")).intValue();
	}
	public int getInfoXboxFindCount2() throws SQLException {
		// TODO Auto-generated method stub
		return ((Integer) SqlMapLocator.getMapper().queryForObject(
				"info_xbox_findcnt2")).intValue();
	}
	// 자료실 검색
	@SuppressWarnings("unchecked")
	public List<BbsBean> infoXboxFind(String find_name, int page, int limit) throws SQLException {
		Map<String,Object> getlist = new HashMap();
		getlist.put("find_name", find_name);
		getlist.put("startrow", (page - 1) * limit + 1);
		getlist.put("endrow", page * limit);
		
		List<BbsBean> list = SqlMapLocator.getMapper().queryForList(
				"info_xbox_Find", getlist);
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<BbsBean> infoXboxFind2(String find_name, int page, int limit) throws SQLException {
		Map<String,Object> getlist = new HashMap();
		getlist.put("find_name", find_name);
		getlist.put("startrow", (page - 1) * limit + 1);
		getlist.put("endrow", page * limit);
		
		List<BbsBean> list = SqlMapLocator.getMapper().queryForList(
				"info_xbox_Find2", getlist);
		return list;
	}
	
	//댓글리스트(보이기)
	@SuppressWarnings("unchecked")
	public List<CommentBean> getInfoXboxComList(int no) throws SQLException{
		List<CommentBean> list = SqlMapLocator.getMapper().queryForList(
				"info_xbox_ComList", no);
		return list;
	}

	//댓글삭제
	public void infoXboxComDel(int bbsno, int comno) throws SQLException {
		// TODO Auto-generated method stub
		Map <String,Integer> del = new HashMap();
		del.put("bbsno", bbsno);
		del.put("comno", comno);
		
		SqlMapLocator.getMapper().delete("info_xbox_comdel", del);
	}
	//추천
	public void infoXboxRecom(int no) throws SQLException {
		// TODO Auto-generated method stub
		
		SqlMapLocator.getMapper().update("info_xbox_Recom",no);
	}
	

	
	
	

	// info_pc

	//삽입
	public void insertInfopc(BbsBean bbsbean) throws SQLException {
		// 삽입 메서드
		SqlMapLocator.getMapper().insert("info_pc_insert", bbsbean);
		// insert()메서드에 의해서 저장
	}

	//게시판 글수
	public int getInfopcListCount() throws SQLException {
		return ((Integer) SqlMapLocator.getMapper().queryForObject(
				"info_pc_cnt")).intValue();
		// queryForObject()메서드는 한개 검색 결과 레코드를 가져올때 실행
		// intValue()는 정수형숫자로 바꿔준다.
	}

	//댓글수
	public int getInfopcComCount(int no) throws SQLException{
		return ((Integer) SqlMapLocator.getMapper().queryForObject(
				"info_pc_comcnt",no)).intValue();
	}
	
	//내용보기
	@SuppressWarnings("unchecked")
	public Object contInfopc(int no) throws SQLException {
		Map<String, Integer> getlist = new HashMap();
		getlist.put("num", no);

		Object list = SqlMapLocator.getMapper().queryForObject(
				"info_pc_cont", getlist);
		return list;
	}

	//비밀번호 확인
	public Object infopccheckpwd(int no) throws SQLException{
		Map<String, Integer> getlist = new HashMap();
		getlist.put("num", no);
		Object list = SqlMapLocator.getMapper().queryForObject("info_pc_cont",getlist);
		
		return list;
	}
	// 수정
	public void editInfopc(BbsBean bbsbean) throws SQLException {
		SqlMapLocator.getMapper().update("info_pc_edit", bbsbean);
	}

	//댓글쓰기
	public void infopcCom(CommentBean combean) throws SQLException{

		SqlMapLocator.getMapper().insert("info_pc_com",combean);
		
	}

	//댓글보기
	@SuppressWarnings("unchecked")
	public List<CommentBean> infopcComView(int no) throws SQLException {
		
		Map<String, Integer> getlist=new HashMap();
		getlist.put("num", no);
		
		List<CommentBean> list=SqlMapLocator.getMapper().queryForList(
				"info_pc_comview",getlist);
		return list;
	}
	
	// 조회수
	public void infopchit(int no) throws SQLException {
		SqlMapLocator.getMapper().update("info_pc_hit", no);
	}

	// 삭제
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void delInfopc(int no, String pwd) throws SQLException {
		 Map del = new HashMap();
		 del.put("num", no);
		 del.put("pass", pwd);
		SqlMapLocator.getMapper().delete("info_pc_del", del);
	}
	
	//댓글삭제(글삭제시)
	public void infopcComDelAll(int no) throws SQLException {
		SqlMapLocator.getMapper().delete("info_pc_comdelall", no);
	}
	
	//리스트
	@SuppressWarnings("unchecked")
	public List<BbsBean> getInfopcList(int page, int limit)
			throws SQLException {
		Map<String, Integer> getlist = new HashMap();
		getlist.put("startrow", (page - 1) * limit + 1);
		getlist.put("endrow", page * limit);

		List<BbsBean> list = SqlMapLocator.getMapper().queryForList(
				"info_pc_List", getlist);
		return list;

	}

	//검색 결과 수
	public int getInfopcFindCount() throws SQLException {
		// TODO Auto-generated method stub
		return ((Integer) SqlMapLocator.getMapper().queryForObject(
				"info_pc_findcnt")).intValue();
	}
	public int getInfopcFindCount2() throws SQLException {
		// TODO Auto-generated method stub
		return ((Integer) SqlMapLocator.getMapper().queryForObject(
				"info_pc_findcnt2")).intValue();
	}
	// 자료실 검색
	@SuppressWarnings("unchecked")
	public List<BbsBean> infopcFind(String find_name, int page, int limit) throws SQLException {
		Map<String,Object> getlist = new HashMap();
		getlist.put("find_name", find_name);
		getlist.put("startrow", (page - 1) * limit + 1);
		getlist.put("endrow", page * limit);
		
		List<BbsBean> list = SqlMapLocator.getMapper().queryForList(
				"info_pc_Find", getlist);
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<BbsBean> infopcFind2(String find_name, int page, int limit) throws SQLException {
		Map<String,Object> getlist = new HashMap();
		getlist.put("find_name", find_name);
		getlist.put("startrow", (page - 1) * limit + 1);
		getlist.put("endrow", page * limit);
		
		List<BbsBean> list = SqlMapLocator.getMapper().queryForList(
				"info_pc_Find2", getlist);
		return list;
	}
	
	//댓글리스트(보이기)
	@SuppressWarnings("unchecked")
	public List<CommentBean> getInfopcComList(int no) throws SQLException{
		List<CommentBean> list = SqlMapLocator.getMapper().queryForList(
				"info_pc_ComList", no);
		return list;
	}

	//댓글삭제
	public void infopcComDel(int bbsno, int comno) throws SQLException {
		// TODO Auto-generated method stub
		Map <String,Integer> del = new HashMap();
		del.put("bbsno", bbsno);
		del.put("comno", comno);
		
		SqlMapLocator.getMapper().delete("info_pc_comdel", del);
	}
	//추천
	public void infopcRecom(int no) throws SQLException {
		// TODO Auto-generated method stub
		
		SqlMapLocator.getMapper().update("info_pc_Recom",no);
	}
	

	
	
	

	// info_ps

	//삽입
	public void insertInfops(BbsBean bbsbean) throws SQLException {
		// 삽입 메서드
		SqlMapLocator.getMapper().insert("info_ps_insert", bbsbean);
		// insert()메서드에 의해서 저장
	}

	//게시판 글수
	public int getInfopsListCount() throws SQLException {
		return ((Integer) SqlMapLocator.getMapper().queryForObject(
				"info_ps_cnt")).intValue();
		// queryForObject()메서드는 한개 검색 결과 레코드를 가져올때 실행
		// intValue()는 정수형숫자로 바꿔준다.
	}

	//댓글수
	public int getInfopsComCount(int no) throws SQLException{
		return ((Integer) SqlMapLocator.getMapper().queryForObject(
				"info_ps_comcnt",no)).intValue();
	}
	
	//내용보기
	@SuppressWarnings("unchecked")
	public Object contInfops(int no) throws SQLException {
		Map<String, Integer> getlist = new HashMap();
		getlist.put("num", no);

		Object list = SqlMapLocator.getMapper().queryForObject(
				"info_ps_cont", getlist);
		return list;
	}

	//비밀번호 확인
	public Object infopscheckpwd(int no) throws SQLException{
		Map<String, Integer> getlist = new HashMap();
		getlist.put("num", no);
		Object list = SqlMapLocator.getMapper().queryForObject("info_ps_cont",getlist);
		
		return list;
	}
	// 수정
	public void editInfops(BbsBean bbsbean) throws SQLException {
		SqlMapLocator.getMapper().update("info_ps_edit", bbsbean);
	}

	//댓글쓰기
	public void infopsCom(CommentBean combean) throws SQLException{

		SqlMapLocator.getMapper().insert("info_ps_com",combean);
		
	}

	//댓글보기
	@SuppressWarnings("unchecked")
	public List<CommentBean> infopsComView(int no) throws SQLException {
		
		Map<String, Integer> getlist=new HashMap();
		getlist.put("num", no);
		
		List<CommentBean> list=SqlMapLocator.getMapper().queryForList(
				"info_ps_comview",getlist);
		return list;
	}
	
	// 조회수
	public void infopshit(int no) throws SQLException {
		SqlMapLocator.getMapper().update("info_ps_hit", no);
	}

	// 삭제
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void delInfops(int no, String pwd) throws SQLException {
		 Map del = new HashMap();
		 del.put("num", no);
		 del.put("pass", pwd);
		SqlMapLocator.getMapper().delete("info_ps_del", del);
	}
	
	//댓글삭제(글삭제시)
	public void infopsComDelAll(int no) throws SQLException {
		SqlMapLocator.getMapper().delete("info_ps_comdelall", no);
	}
	
	//리스트
	@SuppressWarnings("unchecked")
	public List<BbsBean> getInfopsList(int page, int limit)
			throws SQLException {
		Map<String, Integer> getlist = new HashMap();
		getlist.put("startrow", (page - 1) * limit + 1);
		getlist.put("endrow", page * limit);

		List<BbsBean> list = SqlMapLocator.getMapper().queryForList(
				"info_ps_List", getlist);
		return list;

	}

	//검색 결과 수
	public int getInfopsFindCount() throws SQLException {
		// TODO Auto-generated method stub
		return ((Integer) SqlMapLocator.getMapper().queryForObject(
				"info_ps_findcnt")).intValue();
	}
	public int getInfopsFindCount2() throws SQLException {
		// TODO Auto-generated method stub
		return ((Integer) SqlMapLocator.getMapper().queryForObject(
				"info_ps_findcnt2")).intValue();
	}
	// 자료실 검색
	@SuppressWarnings("unchecked")
	public List<BbsBean> infopsFind(String find_name, int page, int limit) throws SQLException {
		Map<String,Object> getlist = new HashMap();
		getlist.put("find_name", find_name);
		getlist.put("startrow", (page - 1) * limit + 1);
		getlist.put("endrow", page * limit);
		
		List<BbsBean> list = SqlMapLocator.getMapper().queryForList(
				"info_ps_Find", getlist);
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<BbsBean> infopsFind2(String find_name, int page, int limit) throws SQLException {
		Map<String,Object> getlist = new HashMap();
		getlist.put("find_name", find_name);
		getlist.put("startrow", (page - 1) * limit + 1);
		getlist.put("endrow", page * limit);
		
		List<BbsBean> list = SqlMapLocator.getMapper().queryForList(
				"info_ps_Find2", getlist);
		return list;
	}
	
	//댓글리스트(보이기)
	@SuppressWarnings("unchecked")
	public List<CommentBean> getInfopsComList(int no) throws SQLException{
		List<CommentBean> list = SqlMapLocator.getMapper().queryForList(
				"info_ps_ComList", no);
		return list;
	}

	//댓글삭제
	public void infopsComDel(int bbsno, int comno) throws SQLException {
		// TODO Auto-generated method stub
		Map <String,Integer> del = new HashMap();
		del.put("bbsno", bbsno);
		del.put("comno", comno);
		
		SqlMapLocator.getMapper().delete("info_ps_comdel", del);
	}
	//추천
	public void infopsRecom(int no) throws SQLException {
		// TODO Auto-generated method stub
		
		SqlMapLocator.getMapper().update("info_ps_Recom",no);
	}
	
	
	
	
	
	
	
	

	// com_xbox

	//삽입
	public void insertcomXbox(BbsBean bbsbean) throws SQLException {
		// 삽입 메서드
		SqlMapLocator.getMapper().insert("com_xbox_insert", bbsbean);
		// insert()메서드에 의해서 저장
	}

	//게시판 글수
	public int getcomXboxListCount() throws SQLException {
		return ((Integer) SqlMapLocator.getMapper().queryForObject(
				"com_xbox_cnt")).intValue();
		// queryForObject()메서드는 한개 검색 결과 레코드를 가져올때 실행
		// intValue()는 정수형숫자로 바꿔준다.
	}

	//댓글수
	public int getcomXboxComCount(int no) throws SQLException{
		return ((Integer) SqlMapLocator.getMapper().queryForObject(
				"com_xbox_comcnt",no)).intValue();
	}
	
	//내용보기
	@SuppressWarnings("unchecked")
	public Object contcomXbox(int no) throws SQLException {
		Map<String, Integer> getlist = new HashMap();
		getlist.put("num", no);

		Object list = SqlMapLocator.getMapper().queryForObject(
				"com_xbox_cont", getlist);
		return list;
	}

	//비밀번호 확인
	public Object comXboxcheckpwd(int no) throws SQLException{
		Map<String, Integer> getlist = new HashMap();
		getlist.put("num", no);
		Object list = SqlMapLocator.getMapper().queryForObject("com_xbox_cont",getlist);
		
		return list;
	}
	// 수정
	public void editcomXbox(BbsBean bbsbean) throws SQLException {
		SqlMapLocator.getMapper().update("com_xbox_edit", bbsbean);
	}

	//댓글쓰기
	public void comXboxCom(CommentBean combean) throws SQLException{

		SqlMapLocator.getMapper().insert("com_xbox_com",combean);
		
	}

	//댓글보기
	@SuppressWarnings("unchecked")
	public List<CommentBean> comXboxComView(int no) throws SQLException {
		
		Map<String, Integer> getlist=new HashMap();
		getlist.put("num", no);
		
		List<CommentBean> list=SqlMapLocator.getMapper().queryForList(
				"com_xbox_comview",getlist);
		return list;
	}
	
	// 조회수
	public void comXboxhit(int no) throws SQLException {
		SqlMapLocator.getMapper().update("com_xbox_hit", no);
	}

	// 삭제
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void delcomXbox(int no, String pwd) throws SQLException {
		 Map del = new HashMap();
		 del.put("num", no);
		 del.put("pass", pwd);
		SqlMapLocator.getMapper().delete("com_xbox_del", del);
	}
	
	//댓글삭제(글삭제시)
	public void comXboxComDelAll(int no) throws SQLException {
		SqlMapLocator.getMapper().delete("com_xbox_comdelall", no);
	}
	
	//리스트
	@SuppressWarnings("unchecked")
	public List<BbsBean> getcomXboxList(int page, int limit)
			throws SQLException {
		Map<String, Integer> getlist = new HashMap();
		getlist.put("startrow", (page - 1) * limit + 1);
		getlist.put("endrow", page * limit);

		List<BbsBean> list = SqlMapLocator.getMapper().queryForList(
				"com_xbox_List", getlist);
		return list;

	}

	//검색 결과 수
	public int getcomXboxFindCount() throws SQLException {
		// TODO Auto-generated method stub
		return ((Integer) SqlMapLocator.getMapper().queryForObject(
				"com_xbox_findcnt")).intValue();
	}
	public int getcomXboxFindCount2() throws SQLException {
		// TODO Auto-generated method stub
		return ((Integer) SqlMapLocator.getMapper().queryForObject(
				"com_xbox_findcnt2")).intValue();
	}
	// 자료실 검색
	@SuppressWarnings("unchecked")
	public List<BbsBean> comXboxFind(String find_name, int page, int limit) throws SQLException {
		Map<String,Object> getlist = new HashMap();
		getlist.put("find_name", find_name);
		getlist.put("startrow", (page - 1) * limit + 1);
		getlist.put("endrow", page * limit);
		
		List<BbsBean> list = SqlMapLocator.getMapper().queryForList(
				"com_xbox_Find", getlist);
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<BbsBean> comXboxFind2(String find_name, int page, int limit) throws SQLException {
		Map<String,Object> getlist = new HashMap();
		getlist.put("find_name", find_name);
		getlist.put("startrow", (page - 1) * limit + 1);
		getlist.put("endrow", page * limit);
		
		List<BbsBean> list = SqlMapLocator.getMapper().queryForList(
				"com_xbox_Find2", getlist);
		return list;
	}
	
	//댓글리스트(보이기)
	@SuppressWarnings("unchecked")
	public List<CommentBean> getcomXboxComList(int no) throws SQLException{
		List<CommentBean> list = SqlMapLocator.getMapper().queryForList(
				"com_xbox_ComList", no);
		return list;
	}

	//댓글삭제
	public void comXboxComDel(int bbsno, int comno) throws SQLException {
		// TODO Auto-generated method stub
		Map <String,Integer> del = new HashMap();
		del.put("bbsno", bbsno);
		del.put("comno", comno);
		
		SqlMapLocator.getMapper().delete("com_xbox_comdel", del);
	}
	//추천
	public void comXboxRecom(int no) throws SQLException {
		// TODO Auto-generated method stub
		
		SqlMapLocator.getMapper().update("com_xbox_Recom",no);
	}
	
	
	
	
	
	
	
	

	// com_pc

	//삽입
	public void insertcompc(BbsBean bbsbean) throws SQLException {
		// 삽입 메서드
		SqlMapLocator.getMapper().insert("com_pc_insert", bbsbean);
		// insert()메서드에 의해서 저장
	}

	//게시판 글수
	public int getcompcListCount() throws SQLException {
		return ((Integer) SqlMapLocator.getMapper().queryForObject(
				"com_pc_cnt")).intValue();
		// queryForObject()메서드는 한개 검색 결과 레코드를 가져올때 실행
		// intValue()는 정수형숫자로 바꿔준다.
	}

	//댓글수
	public int getcompcComCount(int no) throws SQLException{
		return ((Integer) SqlMapLocator.getMapper().queryForObject(
				"com_pc_comcnt",no)).intValue();
	}
	
	//내용보기
	@SuppressWarnings("unchecked")
	public Object contcompc(int no) throws SQLException {
		Map<String, Integer> getlist = new HashMap();
		getlist.put("num", no);

		Object list = SqlMapLocator.getMapper().queryForObject(
				"com_pc_cont", getlist);
		return list;
	}

	//비밀번호 확인
	public Object compccheckpwd(int no) throws SQLException{
		Map<String, Integer> getlist = new HashMap();
		getlist.put("num", no);
		Object list = SqlMapLocator.getMapper().queryForObject("com_pc_cont",getlist);
		
		return list;
    }
	// 수정
	public void editcompc(BbsBean bbsbean) throws SQLException {
		SqlMapLocator.getMapper().update("com_pc_edit", bbsbean);
	}

	//댓글쓰기
	public void compcCom(CommentBean combean) throws SQLException{

		SqlMapLocator.getMapper().insert("com_pc_com",combean);
		
	}

	//댓글보기
	@SuppressWarnings("unchecked")
	public List<CommentBean> compcComView(int no) throws SQLException {
		
		Map<String, Integer> getlist=new HashMap();
		getlist.put("num", no);
		
		List<CommentBean> list=SqlMapLocator.getMapper().queryForList(
				"com_pc_comview",getlist);
		return list;
	}
	
	// 조회수
	public void compchit(int no) throws SQLException {
		SqlMapLocator.getMapper().update("com_pc_hit", no);
	}

	// 삭제
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void delcompc(int no, String pwd) throws SQLException {
		 Map del = new HashMap();
		 del.put("num", no);
		 del.put("pass", pwd);
		SqlMapLocator.getMapper().delete("com_pc_del", del);
	}
	
	//댓글삭제(글삭제시)
	public void compcComDelAll(int no) throws SQLException {
		SqlMapLocator.getMapper().delete("com_pc_comdelall", no);
	}
	
	//리스트
	@SuppressWarnings("unchecked")
	public List<BbsBean> getcompcList(int page, int limit)
			throws SQLException {
		Map<String, Integer> getlist = new HashMap();
		getlist.put("startrow", (page - 1) * limit + 1);
		getlist.put("endrow", page * limit);

		List<BbsBean> list = SqlMapLocator.getMapper().queryForList(
				"com_pc_List", getlist);
		return list;

	}

	//검색 결과 수
	public int getcompcFindCount() throws SQLException {
		// TODO Auto-generated method stub
		return ((Integer) SqlMapLocator.getMapper().queryForObject(
				"com_pc_findcnt")).intValue();
	}
	public int getcompcFindCount2() throws SQLException {
		// TODO Auto-generated method stub
		return ((Integer) SqlMapLocator.getMapper().queryForObject(
				"com_pc_findcnt2")).intValue();
	}
	// 자료실 검색
	@SuppressWarnings("unchecked")
	public List<BbsBean> compcFind(String find_name, int page, int limit) throws SQLException {
		Map<String,Object> getlist = new HashMap();
		getlist.put("find_name", find_name);
		getlist.put("startrow", (page - 1) * limit + 1);
		getlist.put("endrow", page * limit);
		
		List<BbsBean> list = SqlMapLocator.getMapper().queryForList(
				"com_pc_Find", getlist);
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<BbsBean> compcFind2(String find_name, int page, int limit) throws SQLException {
		Map<String,Object> getlist = new HashMap();
		getlist.put("find_name", find_name);
		getlist.put("startrow", (page - 1) * limit + 1);
		getlist.put("endrow", page * limit);
		
		List<BbsBean> list = SqlMapLocator.getMapper().queryForList(
				"com_pc_Find2", getlist);
		return list;
	}
	
	//댓글리스트(보이기)
	@SuppressWarnings("unchecked")
	public List<CommentBean> getcompcComList(int no) throws SQLException{
		List<CommentBean> list = SqlMapLocator.getMapper().queryForList(
				"com_pc_ComList", no);
		return list;
	}

	//댓글삭제
	public void compcComDel(int bbsno, int comno) throws SQLException {
		// TODO Auto-generated method stub
		Map <String,Integer> del = new HashMap();
		del.put("bbsno", bbsno);
		del.put("comno", comno);
		
		SqlMapLocator.getMapper().delete("com_pc_comdel", del);
	}
	//추천
	public void compcRecom(int no) throws SQLException {
		// TODO Auto-generated method stub
		
		SqlMapLocator.getMapper().update("com_pc_Recom",no);
	}
	
	
	
	
	
	
	
	

	// com_ps

	//삽입
	public void insertcomps(BbsBean bbsbean) throws SQLException {
		// 삽입 메서드
		SqlMapLocator.getMapper().insert("com_ps_insert", bbsbean);
		// insert()메서드에 의해서 저장
	}

	//게시판 글수
	public int getcompsListCount() throws SQLException {
		return ((Integer) SqlMapLocator.getMapper().queryForObject(
				"com_ps_cnt")).intValue();
		// queryForObject()메서드는 한개 검색 결과 레코드를 가져올때 실행
		// intValue()는 정수형숫자로 바꿔준다.
	}

	//댓글수
	public int getcompsComCount(int no) throws SQLException{
		return ((Integer) SqlMapLocator.getMapper().queryForObject(
				"com_ps_comcnt",no)).intValue();
	}
	
	//내용보기
	@SuppressWarnings("unchecked")
	public Object contcomps(int no) throws SQLException {
		Map<String, Integer> getlist = new HashMap();
		getlist.put("num", no);

		Object list = SqlMapLocator.getMapper().queryForObject(
				"com_ps_cont", getlist);
		return list;
	}

	//비밀번호 확인
	public Object compscheckpwd(int no) throws SQLException{
		Map<String, Integer> getlist = new HashMap();
		getlist.put("num", no);
		Object list = SqlMapLocator.getMapper().queryForObject("com_ps_cont",getlist);
		
		return list;
	}
	// 수정
	public void editcomps(BbsBean bbsbean) throws SQLException {
		SqlMapLocator.getMapper().update("com_ps_edit", bbsbean);
	}

	//댓글쓰기
	public void compsCom(CommentBean combean) throws SQLException{

		SqlMapLocator.getMapper().insert("com_ps_com",combean);
		
	}

	//댓글보기
	@SuppressWarnings("unchecked")
	public List<CommentBean> compsComView(int no) throws SQLException {
		
		Map<String, Integer> getlist=new HashMap();
		getlist.put("num", no);
		
		List<CommentBean> list=SqlMapLocator.getMapper().queryForList(
				"com_ps_comview",getlist);
		return list;
	}
	
	// 조회수
	public void compshit(int no) throws SQLException {
		SqlMapLocator.getMapper().update("com_ps_hit", no);
	}

	// 삭제
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void delcomps(int no, String pwd) throws SQLException {
		 Map del = new HashMap();
		 del.put("num", no);
		 del.put("pass", pwd);
		SqlMapLocator.getMapper().delete("com_ps_del", del);
	}
	
	//댓글삭제(글삭제시)
	public void compsComDelAll(int no) throws SQLException {
		SqlMapLocator.getMapper().delete("com_ps_comdelall", no);
	}
	
	//리스트
	@SuppressWarnings("unchecked")
	public List<BbsBean> getcompsList(int page, int limit)
			throws SQLException {
		Map<String, Integer> getlist = new HashMap();
		getlist.put("startrow", (page - 1) * limit + 1);
		getlist.put("endrow", page * limit);

		List<BbsBean> list = SqlMapLocator.getMapper().queryForList(
				"com_ps_List", getlist);
		return list;

	}

	//검색 결과 수
	public int getcompsFindCount() throws SQLException {
		// TODO Auto-generated method stub
		return ((Integer) SqlMapLocator.getMapper().queryForObject(
				"com_ps_findcnt")).intValue();
	}
	public int getcompsFindCount2() throws SQLException {
		// TODO Auto-generated method stub
		return ((Integer) SqlMapLocator.getMapper().queryForObject(
				"com_ps_findcnt2")).intValue();
	}
	// 자료실 검색
	@SuppressWarnings("unchecked")
	public List<BbsBean> compsFind(String find_name, int page, int limit) throws SQLException {
		Map<String,Object> getlist = new HashMap();
		getlist.put("find_name", find_name);
		getlist.put("startrow", (page - 1) * limit + 1);
		getlist.put("endrow", page * limit);
		
		List<BbsBean> list = SqlMapLocator.getMapper().queryForList(
				"com_ps_Find", getlist);
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<BbsBean> compsFind2(String find_name, int page, int limit) throws SQLException {
		Map<String,Object> getlist = new HashMap();
		getlist.put("find_name", find_name);
		getlist.put("startrow", (page - 1) * limit + 1);
		getlist.put("endrow", page * limit);
		
		List<BbsBean> list = SqlMapLocator.getMapper().queryForList(
				"com_ps_Find2", getlist);
		return list;
	}
	
	//댓글리스트(보이기)
	@SuppressWarnings("unchecked")
	public List<CommentBean> getcompsComList(int no) throws SQLException{
		List<CommentBean> list = SqlMapLocator.getMapper().queryForList(
				"com_ps_ComList", no);
		return list;
	}

	//댓글삭제
	public void compsComDel(int bbsno, int comno) throws SQLException {
		// TODO Auto-generated method stub
		Map <String,Integer> del = new HashMap();
		del.put("bbsno", bbsno);
		del.put("comno", comno);
		
		SqlMapLocator.getMapper().delete("com_ps_comdel", del);
	}
	//추천
	public void compsRecom(int no) throws SQLException {
		// TODO Auto-generated method stub
		
		SqlMapLocator.getMapper().update("com_ps_Recom",no);
	}
	
	
	
	
	
	
	
	
	


	// faq

	//삽입
	public void insertfaq(BbsBean bbsbean) throws SQLException {
		// 삽입 메서드
		SqlMapLocator.getMapper().insert("faq_insert", bbsbean);
		// insert()메서드에 의해서 저장
	}

	//게시판 글수
	public int getfaqListCount() throws SQLException {
		return ((Integer) SqlMapLocator.getMapper().queryForObject(
				"faq_cnt")).intValue();
		// queryForObject()메서드는 한개 검색 결과 레코드를 가져올때 실행
		// intValue()는 정수형숫자로 바꿔준다.
	}

	//댓글수
	public int getfaqComCount(int no) throws SQLException{
		return ((Integer) SqlMapLocator.getMapper().queryForObject(
				"faq_comcnt",no)).intValue();
	}
	
	//내용보기
	@SuppressWarnings("unchecked")
	public Object contfaq(int no) throws SQLException {
		Map<String, Integer> getlist = new HashMap();
		getlist.put("num", no);

		Object list = SqlMapLocator.getMapper().queryForObject(
				"faq_cont", getlist);
		return list;
	}

	//비밀번호 확인
	public Object faqcheckpwd(int no) throws SQLException{
		Map<String, Integer> getlist = new HashMap();
		getlist.put("num", no);
		Object list = SqlMapLocator.getMapper().queryForObject("faq_cont",getlist);
		
		return list;
	}
	// 수정
	public void editfaq(BbsBean bbsbean) throws SQLException {
		SqlMapLocator.getMapper().update("faq_edit", bbsbean);
	}

	//댓글쓰기
	public void faqCom(CommentBean combean) throws SQLException{

		SqlMapLocator.getMapper().insert("faq_com",combean);
		
	}

	//댓글보기
	@SuppressWarnings("unchecked")
	public List<CommentBean> faqComView(int no) throws SQLException {
		
		Map<String, Integer> getlist=new HashMap();
		getlist.put("num", no);
		
		List<CommentBean> list=SqlMapLocator.getMapper().queryForList(
				"faq_comview",getlist);
		return list;
	}
	
	// 조회수
	public void faqhit(int no) throws SQLException {
		SqlMapLocator.getMapper().update("faq_hit", no);
	}

	// 삭제
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void delfaq(int no, String pwd) throws SQLException {
		 Map del = new HashMap();
		 del.put("num", no);
		 del.put("pass", pwd);
		SqlMapLocator.getMapper().delete("faq_del", del);
	}
	
	//댓글삭제(글삭제시)
	public void faqComDelAll(int no) throws SQLException {
		SqlMapLocator.getMapper().delete("faq_comdelall", no);
	}
	
	//리스트
	@SuppressWarnings("unchecked")
	public List<BbsBean> getfaqList(int page, int limit)
			throws SQLException {
		Map<String, Integer> getlist = new HashMap();
		getlist.put("startrow", (page - 1) * limit + 1);
		getlist.put("endrow", page * limit);

		List<BbsBean> list = SqlMapLocator.getMapper().queryForList(
				"faq_List", getlist);
		return list;

	}

	//검색 결과 수
	public int getfaqFindCount() throws SQLException {
		// TODO Auto-generated method stub
		return ((Integer) SqlMapLocator.getMapper().queryForObject(
				"faq_findcnt")).intValue();
	}
	public int getfaqFindCount2() throws SQLException {
		// TODO Auto-generated method stub
		return ((Integer) SqlMapLocator.getMapper().queryForObject(
				"faq_findcnt2")).intValue();
	}
	// 자료실 검색
	@SuppressWarnings("unchecked")
	public List<BbsBean> faqFind(String find_name, int page, int limit) throws SQLException {
		Map<String,Object> getlist = new HashMap();
		getlist.put("find_name", find_name);
		getlist.put("startrow", (page - 1) * limit + 1);
		getlist.put("endrow", page * limit);
		
		List<BbsBean> list = SqlMapLocator.getMapper().queryForList(
				"faq_Find", getlist);
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<BbsBean> faqFind2(String find_name, int page, int limit) throws SQLException {
		Map<String,Object> getlist = new HashMap();
		getlist.put("find_name", find_name);
		getlist.put("startrow", (page - 1) * limit + 1);
		getlist.put("endrow", page * limit);
		
		List<BbsBean> list = SqlMapLocator.getMapper().queryForList(
				"faq_Find2", getlist);
		return list;
	}
	
	//댓글리스트(보이기)
	@SuppressWarnings("unchecked")
	public List<CommentBean> getfaqComList(int no) throws SQLException{
		List<CommentBean> list = SqlMapLocator.getMapper().queryForList(
				"faq_ComList", no);
		return list;
	}

	//댓글삭제
	public void faqComDel(int bbsno, int comno) throws SQLException {
		// TODO Auto-generated method stub
		Map <String,Integer> del = new HashMap();
		del.put("bbsno", bbsno);
		del.put("comno", comno);
		
		SqlMapLocator.getMapper().delete("faq_comdel", del);
	}
	//추천
	public void faqRecom(int no) throws SQLException {
		// TODO Auto-generated method stub
		
		SqlMapLocator.getMapper().update("faq_Recom",no);
	}
	
	
	
	
	
	
	
	
	


	// qna

	//삽입
	public void insertqna(BbsBean bbsbean) throws SQLException {
		// 삽입 메서드
		SqlMapLocator.getMapper().insert("qna_insert", bbsbean);
		// insert()메서드에 의해서 저장
	}

	//게시판 글수
	public int getqnaListCount() throws SQLException {
		return ((Integer) SqlMapLocator.getMapper().queryForObject(
				"qna_cnt")).intValue();
		// queryForObject()메서드는 한개 검색 결과 레코드를 가져올때 실행
		// intValue()는 정수형숫자로 바꿔준다.
	}

	//댓글수
	public int getqnaComCount(int no) throws SQLException{
		return ((Integer) SqlMapLocator.getMapper().queryForObject(
				"qna_comcnt",no)).intValue();
	}
	
	//내용보기
	@SuppressWarnings("unchecked")
	public Object contqna(int no) throws SQLException {
		Map<String, Integer> getlist = new HashMap();
		getlist.put("num", no);

		Object list = SqlMapLocator.getMapper().queryForObject(
				"qna_cont", getlist);
		return list;
	}

	//비밀번호 확인
	public Object qnacheckpwd(int no) throws SQLException{
		Map<String, Integer> getlist = new HashMap();
		getlist.put("num", no);
		Object list = SqlMapLocator.getMapper().queryForObject("qna_cont",getlist);
		
		return list;
	}
	// 수정
	public void editqna(BbsBean bbsbean) throws SQLException {
		SqlMapLocator.getMapper().update("qna_edit", bbsbean);
	}

	//댓글쓰기
	public void qnaCom(CommentBean combean) throws SQLException{

		SqlMapLocator.getMapper().insert("qna_com",combean);
		
	}

	//댓글보기
	@SuppressWarnings("unchecked")
	public List<CommentBean> qnaComView(int no) throws SQLException {
		
		Map<String, Integer> getlist=new HashMap();
		getlist.put("num", no);
		
		List<CommentBean> list=SqlMapLocator.getMapper().queryForList(
				"qna_comview",getlist);
		return list;
	}
	
	// 조회수
	public void qnahit(int no) throws SQLException {
		SqlMapLocator.getMapper().update("qna_hit", no);
	}

	// 삭제
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void delqna(int no, String pwd) throws SQLException {
		 Map del = new HashMap();
		 del.put("num", no);
		 del.put("pass", pwd);
		SqlMapLocator.getMapper().delete("qna_del", del);
	}
	
	//댓글삭제(글삭제시)
	public void qnaComDelAll(int no) throws SQLException {
		SqlMapLocator.getMapper().delete("qna_comdelall", no);
	}
	
	//리스트
	@SuppressWarnings("unchecked")
	public List<BbsBean> getqnaList(int page, int limit)
			throws SQLException {
		Map<String, Integer> getlist = new HashMap();
		getlist.put("startrow", (page - 1) * limit + 1);
		getlist.put("endrow", page * limit);

		List<BbsBean> list = SqlMapLocator.getMapper().queryForList(
				"qna_List", getlist);
		return list;

	}

	//검색 결과 수
	public int getqnaFindCount() throws SQLException {
		// TODO Auto-generated method stub
		return ((Integer) SqlMapLocator.getMapper().queryForObject(
				"qna_findcnt")).intValue();
	}
	public int getqnaFindCount2() throws SQLException {
		// TODO Auto-generated method stub
		return ((Integer) SqlMapLocator.getMapper().queryForObject(
				"qna_findcnt2")).intValue();
	}
	// 자료실 검색
	@SuppressWarnings("unchecked")
	public List<BbsBean> qnaFind(String find_name, int page, int limit) throws SQLException {
		Map<String,Object> getlist = new HashMap();
		getlist.put("find_name", find_name);
		getlist.put("startrow", (page - 1) * limit + 1);
		getlist.put("endrow", page * limit);
		
		List<BbsBean> list = SqlMapLocator.getMapper().queryForList(
				"qna_Find", getlist);
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<BbsBean> qnaFind2(String find_name, int page, int limit) throws SQLException {
		Map<String,Object> getlist = new HashMap();
		getlist.put("find_name", find_name);
		getlist.put("startrow", (page - 1) * limit + 1);
		getlist.put("endrow", page * limit);
		
		List<BbsBean> list = SqlMapLocator.getMapper().queryForList(
				"qna_Find2", getlist);
		return list;
	}
	
	//댓글리스트(보이기)
	@SuppressWarnings("unchecked")
	public List<CommentBean> getqnaComList(int no) throws SQLException{
		List<CommentBean> list = SqlMapLocator.getMapper().queryForList(
				"qna_ComList", no);
		return list;
	}

	//댓글삭제
	public void qnaComDel(int bbsno, int comno) throws SQLException {
		// TODO Auto-generated method stub
		Map <String,Integer> del = new HashMap();
		del.put("bbsno", bbsno);
		del.put("comno", comno);
		
		SqlMapLocator.getMapper().delete("qna_comdel", del);
	}
	//추천
	public void qnaRecom(int no) throws SQLException {
		// TODO Auto-generated method stub
		
		SqlMapLocator.getMapper().update("qna_Recom",no);
	}
	
	
	
	
	
	
	
	
	


	// notice

	//삽입
	public void insertnotice(BbsBean bbsbean) throws SQLException {
		// 삽입 메서드
		SqlMapLocator.getMapper().insert("notice_insert", bbsbean);
		// insert()메서드에 의해서 저장
	}

	//게시판 글수
	public int getnoticeListCount() throws SQLException {
		return ((Integer) SqlMapLocator.getMapper().queryForObject(
				"notice_cnt")).intValue();
		// queryForObject()메서드는 한개 검색 결과 레코드를 가져올때 실행
		// intValue()는 정수형숫자로 바꿔준다.
	}

	//댓글수
	public int getnoticeComCount(int no) throws SQLException{
		return ((Integer) SqlMapLocator.getMapper().queryForObject(
				"notice_comcnt",no)).intValue();
	}
	
	//내용보기
	@SuppressWarnings("unchecked")
	public Object contnotice(int no) throws SQLException {
		Map<String, Integer> getlist = new HashMap();
		getlist.put("num", no);

		Object list = SqlMapLocator.getMapper().queryForObject(
				"notice_cont", getlist);
		return list;
	}

	//비밀번호 확인
	public Object noticecheckpwd(int no) throws SQLException{
		Map<String, Integer> getlist = new HashMap();
		getlist.put("num", no);
		Object list = SqlMapLocator.getMapper().queryForObject("notice_cont",getlist);
		
		return list;
	}
	// 수정
	public void editnotice(BbsBean bbsbean) throws SQLException {
		SqlMapLocator.getMapper().update("notice_edit", bbsbean);
	}

	//댓글쓰기
	public void noticeCom(CommentBean combean) throws SQLException{

		SqlMapLocator.getMapper().insert("notice_com",combean);
		
	}

	//댓글보기
	@SuppressWarnings("unchecked")
	public List<CommentBean> noticeComView(int no) throws SQLException {
		
		Map<String, Integer> getlist=new HashMap();
		getlist.put("num", no);
		
		List<CommentBean> list=SqlMapLocator.getMapper().queryForList(
				"notice_comview",getlist);
		return list;
	}
	
	// 조회수
	public void noticehit(int no) throws SQLException {
		SqlMapLocator.getMapper().update("notice_hit", no);
	}

	// 삭제
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void delnotice(int no, String pwd) throws SQLException {
		 Map del = new HashMap();
		 del.put("num", no);
		 del.put("pass", pwd);
		SqlMapLocator.getMapper().delete("notice_del", del);
	}
	
	//댓글삭제(글삭제시)
	public void noticeComDelAll(int no) throws SQLException {
		SqlMapLocator.getMapper().delete("notice_comdelall", no);
	}
	
	//리스트
	@SuppressWarnings("unchecked")
	public List<BbsBean> getnoticeList(int page, int limit)
			throws SQLException {
		Map<String, Integer> getlist = new HashMap();
		getlist.put("startrow", (page - 1) * limit + 1);
		getlist.put("endrow", page * limit);

		List<BbsBean> list = SqlMapLocator.getMapper().queryForList(
				"notice_List", getlist);
		return list;

	}

	//검색 결과 수
	public int getnoticeFindCount() throws SQLException {
		// TODO Auto-generated method stub
		return ((Integer) SqlMapLocator.getMapper().queryForObject(
				"notice_findcnt")).intValue();
	}
	public int getnoticeFindCount2() throws SQLException {
		// TODO Auto-generated method stub
		return ((Integer) SqlMapLocator.getMapper().queryForObject(
				"notice_findcnt2")).intValue();
	}
	// 자료실 검색
	@SuppressWarnings("unchecked")
	public List<BbsBean> noticeFind(String find_name, int page, int limit) throws SQLException {
		Map<String,Object> getlist = new HashMap();
		getlist.put("find_name", find_name);
		getlist.put("startrow", (page - 1) * limit + 1);
		getlist.put("endrow", page * limit);
		
		List<BbsBean> list = SqlMapLocator.getMapper().queryForList(
				"notice_Find", getlist);
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<BbsBean> noticeFind2(String find_name, int page, int limit) throws SQLException {
		Map<String,Object> getlist = new HashMap();
		getlist.put("find_name", find_name);
		getlist.put("startrow", (page - 1) * limit + 1);
		getlist.put("endrow", page * limit);
		
		List<BbsBean> list = SqlMapLocator.getMapper().queryForList(
				"notice_Find2", getlist);
		return list;
	}
	
	//댓글리스트(보이기)
	@SuppressWarnings("unchecked")
	public List<CommentBean> getnoticeComList(int no) throws SQLException{
		List<CommentBean> list = SqlMapLocator.getMapper().queryForList(
				"notice_ComList", no);
		return list;
	}

	//댓글삭제
	public void noticeComDel(int bbsno, int comno) throws SQLException {
		// TODO Auto-generated method stub
		Map <String,Integer> del = new HashMap();
		del.put("bbsno", bbsno);
		del.put("comno", comno);
		
		SqlMapLocator.getMapper().delete("notice_comdel", del);
	}
	//추천
	public void noticeRecom(int no) throws SQLException {
		// TODO Auto-generated method stub
		
		SqlMapLocator.getMapper().update("notice_Recom",no);
	}
	
	
	
	
	
	
	
	
	


	// event

	//삽입
	public void insertevent(BbsBean bbsbean) throws SQLException {
		// 삽입 메서드
		SqlMapLocator.getMapper().insert("event_insert", bbsbean);
		// insert()메서드에 의해서 저장
	}

	//게시판 글수
	public int geteventListCount() throws SQLException {
		return ((Integer) SqlMapLocator.getMapper().queryForObject(
				"event_cnt")).intValue();
		// queryForObject()메서드는 한개 검색 결과 레코드를 가져올때 실행
		// intValue()는 정수형숫자로 바꿔준다.
	}

	//댓글수
	public int geteventComCount(int no) throws SQLException{
		return ((Integer) SqlMapLocator.getMapper().queryForObject(
				"event_comcnt",no)).intValue();
	}
	
	//내용보기
	@SuppressWarnings("unchecked")
	public Object contevent(int no) throws SQLException {
		Map<String, Integer> getlist = new HashMap();
		getlist.put("num", no);

		Object list = SqlMapLocator.getMapper().queryForObject(
				"event_cont", getlist);
		return list;
	}

	//비밀번호 확인
	public Object eventcheckpwd(int no) throws SQLException{
		Map<String, Integer> getlist = new HashMap();
		getlist.put("num", no);
		Object list = SqlMapLocator.getMapper().queryForObject("event_cont",getlist);
		
		return list;
	}
	// 수정
	public void editevent(BbsBean bbsbean) throws SQLException {
		SqlMapLocator.getMapper().update("event_edit", bbsbean);
	}

	//댓글쓰기
	public void eventCom(CommentBean combean) throws SQLException{

		SqlMapLocator.getMapper().insert("event_com",combean);
		
	}

	//댓글보기
	@SuppressWarnings("unchecked")
	public List<CommentBean> eventComView(int no) throws SQLException {
		
		Map<String, Integer> getlist=new HashMap();
		getlist.put("num", no);
		
		List<CommentBean> list=SqlMapLocator.getMapper().queryForList(
				"event_comview",getlist);
		return list;
	}
	
	// 조회수
	public void eventhit(int no) throws SQLException {
		SqlMapLocator.getMapper().update("event_hit", no);
	}

	// 삭제
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void delevent(int no, String pwd) throws SQLException {
		 Map del = new HashMap();
		 del.put("num", no);
		 del.put("pass", pwd);
		SqlMapLocator.getMapper().delete("event_del", del);
	}
	
	//댓글삭제(글삭제시)
	public void eventComDelAll(int no) throws SQLException {
		SqlMapLocator.getMapper().delete("event_comdelall", no);
	}
	
	//리스트
	@SuppressWarnings("unchecked")
	public List<BbsBean> geteventList(int page, int limit)
			throws SQLException {
		Map<String, Integer> getlist = new HashMap();
		getlist.put("startrow", (page - 1) * limit + 1);
		getlist.put("endrow", page * limit);

		List<BbsBean> list = SqlMapLocator.getMapper().queryForList(
				"event_List", getlist);
		return list;

	}

	//검색 결과 수
	public int geteventFindCount() throws SQLException {
		// TODO Auto-generated method stub
		return ((Integer) SqlMapLocator.getMapper().queryForObject(
				"event_findcnt")).intValue();
	}
	public int geteventFindCount2() throws SQLException {
		// TODO Auto-generated method stub
		return ((Integer) SqlMapLocator.getMapper().queryForObject(
				"event_findcnt2")).intValue();
	}
	// 자료실 검색
	@SuppressWarnings("unchecked")
	public List<BbsBean> eventFind(String find_name, int page, int limit) throws SQLException {
		Map<String,Object> getlist = new HashMap();
		getlist.put("find_name", find_name);
		getlist.put("startrow", (page - 1) * limit + 1);
		getlist.put("endrow", page * limit);
		
		List<BbsBean> list = SqlMapLocator.getMapper().queryForList(
				"event_Find", getlist);
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<BbsBean> eventFind2(String find_name, int page, int limit) throws SQLException {
		Map<String,Object> getlist = new HashMap();
		getlist.put("find_name", find_name);
		getlist.put("startrow", (page - 1) * limit + 1);
		getlist.put("endrow", page * limit);
		
		List<BbsBean> list = SqlMapLocator.getMapper().queryForList(
				"event_Find2", getlist);
		return list;
	}
	
	//댓글리스트(보이기)
	@SuppressWarnings("unchecked")
	public List<CommentBean> geteventComList(int no) throws SQLException{
		List<CommentBean> list = SqlMapLocator.getMapper().queryForList(
				"event_ComList", no);
		return list;
	}

	//댓글삭제
	public void eventComDel(int bbsno, int comno) throws SQLException {
		// TODO Auto-generated method stub
		Map <String,Integer> del = new HashMap();
		del.put("bbsno", bbsno);
		del.put("comno", comno);
		
		SqlMapLocator.getMapper().delete("event_comdel", del);
	}
	//추천
	public void eventRecom(int no) throws SQLException {
		// TODO Auto-generated method stub
		
		SqlMapLocator.getMapper().update("event_Recom",no);
	}
	
	
	
	
	
	
	
	
	


	// pds

	//삽입
	public void insertpds(BbsBean bbsbean) throws SQLException {
		// 삽입 메서드
		SqlMapLocator.getMapper().insert("pds_insert", bbsbean);
		// insert()메서드에 의해서 저장
	}

	//게시판 글수
	public int getpdsListCount() throws SQLException {
		return ((Integer) SqlMapLocator.getMapper().queryForObject(
				"pds_cnt")).intValue();
		// queryForObject()메서드는 한개 검색 결과 레코드를 가져올때 실행
		// intValue()는 정수형숫자로 바꿔준다.
	}

	//댓글수
	public int getpdsComCount(int no) throws SQLException{
		return ((Integer) SqlMapLocator.getMapper().queryForObject(
				"pds_comcnt",no)).intValue();
	}
	
	//내용보기
	@SuppressWarnings("unchecked")
	public Object contpds(int no) throws SQLException {
		Map<String, Integer> getlist = new HashMap();
		getlist.put("num", no);

		Object list = SqlMapLocator.getMapper().queryForObject(
				"pds_cont", getlist);
		return list;
	}

	//비밀번호 확인
	public Object pdscheckpwd(int no) throws SQLException{
		Map<String, Integer> getlist = new HashMap();
		getlist.put("num", no);
		Object list = SqlMapLocator.getMapper().queryForObject("pds_cont",getlist);
		
		return list;
	}
	// 수정
	public void editpds(BbsBean bbsbean) throws SQLException {
		SqlMapLocator.getMapper().update("pds_edit", bbsbean);
	}

	//댓글쓰기
	public void pdsCom(CommentBean combean) throws SQLException{

		SqlMapLocator.getMapper().insert("pds_com",combean);
		
	}

	//댓글보기
	@SuppressWarnings("unchecked")
	public List<CommentBean> pdsComView(int no) throws SQLException {
		
		Map<String, Integer> getlist=new HashMap();
		getlist.put("num", no);
		
		List<CommentBean> list=SqlMapLocator.getMapper().queryForList(
				"pds_comview",getlist);
		return list;
	}
	
	// 조회수
	public void pdshit(int no) throws SQLException {
		SqlMapLocator.getMapper().update("pds_hit", no);
	}

	// 삭제
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void delpds(int no, String pwd) throws SQLException {
		 Map del = new HashMap();
		 del.put("num", no);
		 del.put("pass", pwd);
		SqlMapLocator.getMapper().delete("pds_del", del);
	}
	
	//댓글삭제(글삭제시)
	public void pdsComDelAll(int no) throws SQLException {
		SqlMapLocator.getMapper().delete("pds_comdelall", no);
	}
	
	//리스트
	@SuppressWarnings("unchecked")
	public List<BbsBean> getpdsList(int page, int limit)
			throws SQLException {
		Map<String, Integer> getlist = new HashMap();
		getlist.put("startrow", (page - 1) * limit + 1);
		getlist.put("endrow", page * limit);

		List<BbsBean> list = SqlMapLocator.getMapper().queryForList(
				"pds_List", getlist);
		return list;

	}

	//검색 결과 수
	public int getpdsFindCount() throws SQLException {
		// TODO Auto-generated method stub
		return ((Integer) SqlMapLocator.getMapper().queryForObject(
				"pds_findcnt")).intValue();
	}
	public int getpdsFindCount2() throws SQLException {
		// TODO Auto-generated method stub
		return ((Integer) SqlMapLocator.getMapper().queryForObject(
				"pds_findcnt2")).intValue();
	}
	// 자료실 검색
	@SuppressWarnings("unchecked")
	public List<BbsBean> pdsFind(String find_name, int page, int limit) throws SQLException {
		Map<String,Object> getlist = new HashMap();
		getlist.put("find_name", find_name);
		getlist.put("startrow", (page - 1) * limit + 1);
		getlist.put("endrow", page * limit);
		
		List<BbsBean> list = SqlMapLocator.getMapper().queryForList(
				"pds_Find", getlist);
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<BbsBean> pdsFind2(String find_name, int page, int limit) throws SQLException {
		Map<String,Object> getlist = new HashMap();
		getlist.put("find_name", find_name);
		getlist.put("startrow", (page - 1) * limit + 1);
		getlist.put("endrow", page * limit);
		
		List<BbsBean> list = SqlMapLocator.getMapper().queryForList(
				"pds_Find2", getlist);
		return list;
	}
	
	//댓글리스트(보이기)
	@SuppressWarnings("unchecked")
	public List<CommentBean> getpdsComList(int no) throws SQLException{
		List<CommentBean> list = SqlMapLocator.getMapper().queryForList(
				"pds_ComList", no);
		return list;
	}

	//댓글삭제
	public void pdsComDel(int bbsno, int comno) throws SQLException {
		// TODO Auto-generated method stub
		Map <String,Integer> del = new HashMap();
		del.put("bbsno", bbsno);
		del.put("comno", comno);
		
		SqlMapLocator.getMapper().delete("pds_comdel", del);
	}
	//추천
	public void pdsRecom(int no) throws SQLException {
		// TODO Auto-generated method stub
		
		SqlMapLocator.getMapper().update("pds_Recom",no);
	}
	

	// 공지사항 미니 게시판 게시물 5개
	public List<BbsBean> getMiniNotice(int page, int limit) throws SQLException {
		// TODO Auto-generated method stub
		Map<String, Integer> getlist = new HashMap();
		getlist.put("startrow", (page - 1) * limit + 1);
		getlist.put("endrow", page * limit);
		List<BbsBean> list = SqlMapLocator.getMapper().queryForList("getMiniNotice",getlist);
		 return list;
	}

	// 이벤트 미니 게시판 게시물 5개
	public List<BbsBean> getMiniEvent(int page, int limit) throws SQLException {
		// TODO Auto-generated method stub
		Map<String, Integer> getlist = new HashMap();
		getlist.put("startrow", (page - 1) * limit + 1);
		getlist.put("endrow", page * limit);
		List<BbsBean> list = SqlMapLocator.getMapper().queryForList("getMiniEvent",getlist);
		 return list;
	}
	
	// QnA 미니 게시판 게시물 5개
	public List<BbsBean> getMiniQna(int page, int limit) throws SQLException {
		// TODO Auto-generated method stub
		Map<String, Integer> getlist = new HashMap();
		getlist.put("startrow", (page - 1) * limit + 1);
		getlist.put("endrow", page * limit);
		List<BbsBean> list =SqlMapLocator.getMapper().queryForList("getMiniQna",getlist);
		 return list;
	}
}