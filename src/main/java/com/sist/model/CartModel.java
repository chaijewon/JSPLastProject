package com.sist.model;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.CartDAO;
import com.sist.vo.CartVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class CartModel {
	  @RequestMapping("cart/cart_insert.do")
	  public String admin_main(HttpServletRequest request,HttpServletResponse response)
	  {
		  String gno=request.getParameter("gno");
		  String account=request.getParameter("account");
		  HttpSession session=request.getSession();
		  String id=(String)session.getAttribute("id");
		  CartVO vo=new CartVO();
		  vo.setGno(Integer.parseInt(gno));
		  vo.setId(id);
		  vo.setAccount(Integer.parseInt(account));
		  CartDAO.cartInsert(vo);
		  request.setAttribute("mypage_jsp", "../mypage/cart_list.jsp");
		  request.setAttribute("main_jsp", "../mypage/mypage_main.jsp");
		  return "../main/main.jsp";
	  }
}
