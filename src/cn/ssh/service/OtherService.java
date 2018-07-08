package cn.ssh.service;

import org.springframework.transaction.annotation.Transactional;

import cn.ssh.dao.OtherDao;
import cn.ssh.entity.Admin;
import cn.ssh.entity.Master;
import cn.ssh.entity.Student;

@Transactional
public class OtherService {
	private OtherDao otherDao;

	public void setOtherDao(OtherDao otherDao) {
		this.otherDao = otherDao;
	}
    //登陆
	public Student loginStudent(String id, String pwd) {
		return otherDao.loginStudent(id,pwd);
	}
	public Master loginMaster(String id, String pwd) {
		return otherDao.loginMaster(id,pwd);
	}
	public Admin loginAdmin(String id, String pwd) {
		return otherDao.loginAdmin(id,pwd);
	}
	

}
