package cn.ssh.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {
	private FilterConfig config;
	
    public void init(FilterConfig config) throws ServletException {
		this.config = config;

	}
    public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
    	String path = ((HttpServletRequest) request).getServletPath();
    	HttpSession session = ((HttpServletRequest)request).getSession();
		response.setCharacterEncoding("gb2312");
		if(path.equals("first.jsp")||path.equals("/login/LoginAction.action")||path.equals("exit/DestroyAction.action")){
			chain.doFilter(request, response);
		}else{
			if(session.getAttribute("id")==null){
				PrintWriter out = response.getWriter();
				out.println("<script language=javascript> alert('请先登陆');window.location.href='/TrainChat/first.jsp';</script>");
			}else
				chain.doFilter(request, response);
		}
	}
	public void destroy() {
	
	}

	

	

}
