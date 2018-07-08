package cn.ssh.dao;

import java.util.List;

import cn.ssh.entity.Master;
import cn.ssh.entity.Student;

public interface MasterDao {
    //修改登陆密码
	void updatePwd(Master master);
	//多条件查询教官信息
	List<Master> findMasterMoreCondition(Master master);
	//教官列表
	List<Master> findAllMaster();
	//根据教官号查找教官
	Master findMasterByNumber(String masNumber);
	//通过教官查找该教官班级的新生信息
	List<Student> findStudentByMaster(Master mas);
	//添加教官
	void add(Master master);
	//删除所有教官信息
	void delete();

}
