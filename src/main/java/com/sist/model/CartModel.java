package com.sist.model;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class CartModel {
	  @RequestMapping("cart/cart_insert.do")
	  public String admin_main(HttpServletRequest request,HttpServletResponse response)
	  {
		  
		  request.setAttribute("mypage_jsp", "../mypage/cart_list.jsp");
		  request.setAttribute("main_jsp", "../mypage/mypage_main.jsp");
		  return "../main/main.jsp";
	  }
}
