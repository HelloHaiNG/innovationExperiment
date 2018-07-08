package cn.ssh.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.ssh.dao.MasterDao;
import cn.ssh.entity.Master;
import cn.ssh.entity.PageBean;
import cn.ssh.entity.Student;

@Transactional
public class MasterService {
	private MasterDao masterDao;
	public void setMasterDao(MasterDao masterDao) {
		this.masterDao = masterDao;
	}
	//修改登陆密码
	public void updatePwd(Master master) {
		masterDao.updatePwd(master);
	}
	//教官列表
	public List<Master> findAllMaster() {
		return masterDao.findAllMaster();
	}
	//多条件查询教官信息
	public List<Master> findMasterMoreCondition(Master master) {
		return masterDao.findMasterMoreCondition(master);
	}
	//根据教官号查找教官
	public Master findMasterByNumber(String masNumber) {
		return masterDao.findMasterByNumber(masNumber);
	}
	//通过教官查找该教官班级的新生信息
	public List<Student> findStudentByMaster(Master mas) {
		return masterDao.findStudentByMaster(mas);
	}
	//添加教官
	public void add(Master master) {
		masterDao.add(master);
	}
	//删除所有教官信息
	public void delete() {
		masterDao.delete();
	}

}
