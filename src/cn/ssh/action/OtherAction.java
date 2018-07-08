package cn.ssh.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.ssh.entity.Admin;
import cn.ssh.entity.Master;
import cn.ssh.entity.Student;
import cn.ssh.service.OtherService;

import com.opensymphony.xwork2.ActionSupport;

public class OtherAction extends ActionSupport {
	private OtherService otherService;
	public void setOtherService(OtherService otherService) {
		this.otherService = otherService;
	}
	//登陆action方法
	public String login() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String kind = request.getParameter("kind");
		kind = new String(kind.getBytes("ISO-8859-1"),"utf-8");
		if(kind.equals("新生")) {
			Student student = otherService.loginStudent(id,pwd);
			if(student!=null) {
				ServletActionContext.getRequest().getSession().setAttribute("student", student);
				ServletActionContext.getRequest().getSession().setAttribute("id", id);
				return "studentLogin";
			}
		}else if(kind.equals("教官")) {
			Master master = otherService.loginMaster(id,pwd);
			if(master!=null) {
				ServletActionContext.getRequest().getSession().setAttribute("master", master);
				ServletActionContext.getRequest().getSession().setAttribute("id", id);
				return "masterLogin";
			}
		}else {
			Admin admin = otherService.loginAdmin(id,pwd);
			if(admin!=null) {
				ServletActionContext.getRequest().getSession().setAttribute("admin", admin);
				return "adminLogin";
		    }
		}
		return "fail";
	}
}
