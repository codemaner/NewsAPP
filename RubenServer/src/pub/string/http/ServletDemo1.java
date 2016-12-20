package pub.string.http;


import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.Enumeration;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import pub.string.http.db.DBHelp;
import pub.string.http.pojo.Category;
import pub.string.http.util.LogUtil;

public class ServletDemo1 extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException{
//		PrintWriter out = response.getWriter();
		StringBuilder sb=new StringBuilder();
//		sb.append(request.getParameter("value1"));
//		LogUtil.show(sb.toString());
//		out.println("hello");
		// 设置响应内容类型
	      response.setContentType("text/html");
	      response.setCharacterEncoding("utf8");
	      Enumeration paras=request.getParameterNames();
	      String[] keys=new String[11];
	      while(paras.hasMoreElements()){
	    	  String key=(String) paras.nextElement();
	    	  sb.append(key+":");
	    	  sb.append(request.getParameter(key)+"\n");
	      }
	      LogUtil.show(sb.toString());
	      DBHelp db=new DBHelp();
	      PrintWriter out = response.getWriter();
			Gson gson=new Gson();
	      out.println(gson.toJson(db.getItems("娱乐")));
	      

//	      String title = "title";
//	      String docType =
//	      "<!doctype html public \"-//w3c//dtd html 4.0 " +
//	      "transitional//en\">\n";
//	      out.println(docType +
//	                "<html>\n" +
//	                "<head><title>" + "login sample" + "</title></head>\n" +
//	                "<body bgcolor=\"#f0f0f0\">\n" +
//	                "<h1 align=\"center\">" + "Login" + "</h1>\n" +
//	                "<ul>\n" +
//	                "  <li><b>username</b>:"
//	                + request.getParameter("user") + "\n" +
//	                "  <li><b>passwd</b>:"
//	                + request.getParameter("pass") + "\n" +
//	                "</ul>\n" +
//	                "</body></html>");

	}
}