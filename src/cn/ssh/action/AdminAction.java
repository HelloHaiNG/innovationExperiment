package cn.ssh.action;

import org.apache.struts2.ServletActionContext;

import cn.ssh.entity.Admin;
import cn.ssh.service.AdminService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminAction extends ActionSupport implements ModelDriven<Admin> {
	private Admin admin = new Admin();
	private AdminService adminService;

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public Admin getModel() {
		return admin;
	}

	// 查看个人信息
	public String selfInfo() {
		Object session = ServletActionContext.getRequest().getSession()
				.getAttribute("admin");
		ServletActionContext.getRequest().setAttribute("admin", session);
		return "selfInfo";
	}

	// 前往修改登陆密码页面
	public String toUpdatePwdPage() {
		Object session = ServletActionContext.getRequest().getSession()
				.getAttribute("admin");
		ServletActionContext.getRequest().setAttribute("admin", session);
		return "toUpdatePwdPage";
	}

	// 修改登陆密码
	public String updatePwd() {
		adminService.updatePwd(admin);
		return "updatePwd";
	}

	// 退出登陆
	public String exit() {
		return "exit";
	}
	//军训介绍
	public String toTrainIntroducePage() {
		return "toTrainIntroducePage";
	}
	
}
