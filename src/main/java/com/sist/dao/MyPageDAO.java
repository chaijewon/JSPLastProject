package com.sist.dao;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.commons.*;
import com.sist.vo.*;

public class MyPageDAO {
  private static SqlSessionFactory ssf;
  static 
  {
	  ssf=CreateSqlSessionFactory.getSsf();
  }
  /*
   *      <!-- mypage -->
		  <select id="reserveMyPageListData" parameterType="string">
		    SELECT no,ri.fno,id,rday,time,inwon,ok,
		           name,phone,poster
		    FROM reserve_info ri,menupan_food mf
		    WHERE ri.fno=mf.fno
		    AND id=#{id}
		    ORDER BY no DESC
		  </select>
   */
  public static List<ReserveVO> reserveMyPageListData(String id)
  {
	  List<ReserveVO> list=null;
	  try
	  {
		  SqlSession session=ssf.openSession();
		  list=session.selectList("reserveMyPageListData",id);
		  session.close();
	  }catch(Exception ex) 
	  {
		  ex.printStackTrace();
	  }
	  return list;
  }
}
