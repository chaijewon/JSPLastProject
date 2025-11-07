package com.sist.model;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;

import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
/*                  request (어떤 데이터를 전송) 
 *   JSP ====== 전송 =======> DispatcherServlet
 *                                |
 *                             -------------------
 *                              @RequestMapping()
 *                                | url이 동일 
 *                              메소드 호출 
 *                             ------------------Model
 *                                | request에 출력할 결과값을 담는다
 *                             DispatcherServlet 
 *                                | request
 *                               JSP => 출력 
 *       <a> : ?id=admin
 *       <form> : id=admin
 *       $.ajax => data:{id:"admin"} => id=admin
 *       axios => params:{id:"admin"} => id=admin
 */
@Controller
public class BoardReplyModel {
  @RequestMapping("reply/reply_insert.do")
  public String reply_insert(HttpServletRequest request,
		  HttpServletResponse response)
  {
	  try
	  {
		  request.setCharacterEncoding("UTF-8");
	  }catch(Exception ex) {}
	  
	  String bno=request.getParameter("bno");
	  String page=request.getParameter("page");
	  String msg=request.getParameter("msg");
	  
	  HttpSession session=request.getSession();
	  String id=(String)session.getAttribute("id");
	  String name=(String)session.getAttribute("name");
	  
	  BoardReplyVO vo=new BoardReplyVO();
	  vo.setId(id);
	  vo.setName(name);
	  vo.setMsg(msg);
	  vo.setBno(Integer.parseInt(bno));
	  
	  BoardReplyDAO.replyInsert(vo);
	  /*
	   *  INSERT INTO mvcBoardReply(no,bno,id,name,msg,
	   *  group_id)
          VALUES(mr_no_seq.nextval,1,'hong','홍길동',
          '게시판 댓글 : 답변형게시판 응용',1);
	   */
	  // DB연동 
	  return "redirect:../board/detail.do?no="+bno+"&page="+page;
	  
  }
}
