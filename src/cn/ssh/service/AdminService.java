package cn.ssh.service;

import org.springframework.transaction.annotation.Transactional;

import cn.ssh.dao.AdminDao;
import cn.ssh.entity.Admin;
@Transactional
public class AdminService {
	private AdminDao adminDao;
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	//修改密码
	public void updatePwd(Admin admin) {
		adminDao.updatePwd(admin);
	}

}
