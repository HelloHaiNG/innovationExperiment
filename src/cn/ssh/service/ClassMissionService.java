package cn.ssh.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.ssh.dao.ClassMissionDao;
import cn.ssh.entity.ClassMission;
import cn.ssh.entity.Student;
@Transactional
public class ClassMissionService {
	private ClassMissionDao classMissionDao;
	public void setClassMissionDao(ClassMissionDao classMissionDao) {
		this.classMissionDao = classMissionDao;
	}
	//发布任务
	public void add(ClassMission classMission) {
		classMissionDao.add(classMission);
	}
	//查看班级公告
	public List<ClassMission> findByClassNumber(Student student) {		
		return classMissionDao.findByClassNumber(student);
	}

}
