package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic.BbsBean;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.BbsDao;

public class MainController {

	private BbsDao bbsService;

	public void setBbsService(BbsDao bbsService) {
		this.bbsService = bbsService;
	}
	
	
	// MainContoller 등록 get방식
	@RequestMapping(value = "main.info", method = RequestMethod.GET)
	public ModelAndView main(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws SQLException {
		int page = 1;
		int limit = 5;
		ModelAndView model = new ModelAndView();
		
		List<BbsBean> noticelist = new ArrayList<BbsBean>();
		List<BbsBean> eventlist = new ArrayList<BbsBean>();
		List<BbsBean> qnalist = new ArrayList<BbsBean>();
  		noticelist = this.bbsService.getMiniNotice(page,limit);		// 미니 게시판 게시물 5개
  		int listcount = this.bbsService.getnoticeListCount();
 		eventlist = this.bbsService.getMiniEvent(page,limit);
 		int listcount2 = this.bbsService.geteventListCount();
 		qnalist = this.bbsService.getMiniQna(page,limit);
 		int listcount3 = this.bbsService.getqnaListCount();

 		
		model.setViewName("index");

		request.setAttribute("page", page);
		request.setAttribute("limit", limit);
		request.setAttribute("noticeList", noticelist);
		request.setAttribute("noticelistcount", listcount);
		request.setAttribute("eventList", eventlist);
		request.setAttribute("eventlistcount", listcount2);
		request.setAttribute("qnaList", qnalist);
		request.setAttribute("qnalistcount", listcount3);
		
		return model;
	}
}
