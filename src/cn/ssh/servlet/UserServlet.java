package cn.ssh.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.ssh.dao.IllegalWordImpl;




public class UserServlet extends BaseServlet {	
	
	/**
	 * 发送聊天内容
	 * @throws IOException 
	 */
	public String sendMessage(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		// 1.接收数据 。
		System.out.println("sendMessage invoke....");
		HttpSession session = req.getSession();
	    String from = (String)session.getAttribute("id");
		String face = req.getParameter("face"); // 表情
		String color = req.getParameter("color"); // 字体颜色
		String content = req.getParameter("content"); // 发言内容
		IllegalWordImpl illegalWordImpl = new IllegalWordImpl();
		String words = illegalWordImpl.words();				
		char chs[] = content.toCharArray();
		for(int i=0;i<chs.length;i++){
				if(words.indexOf(chs[i])!=-1){
					chs[i] = '*';
				}
		}
		content = "";
		for(int i=0;i<chs.length;i++){
			content = content+chs[i];
		}
		// 发言时间 正常情况下使用SimpleDateFormat
		String sendTime = new Date().toLocaleString(); // 发言时间
		// 获得ServletContext对象.
		ServletContext application = getServletContext();
		//  从ServletContext中获取消息
		String sourceMessage = (String) application.getAttribute("message");
		// 拼接发言的内容:xx 对 yy 说 xxx
		sourceMessage += "<font color='blue'><strong>" + from
				+ "</strong></font><font color='#CC0000'>" + face
				+ "</font>说："
				+ "<font color='" + color + "'>" + content + "</font>（"
				+ sendTime + "）<br>";
		// 将消息存入到application的范围
		application.setAttribute("message", sourceMessage);
		return getMessage(req, resp);
	}
	
	/**
	 * 获取消息的方法
	 * @throws IOException 
	 */
	public String getMessage(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		String message = (String) getServletContext().getAttribute("message");
		if(message != null){
			resp.getWriter().println(message);
		}
		return "";
	}
	
}

