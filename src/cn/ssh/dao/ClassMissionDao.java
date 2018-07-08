package cn.ssh.dao;

import java.util.List;

import cn.ssh.entity.ClassMission;
import cn.ssh.entity.Student;

public interface ClassMissionDao {
	//发布任务
	void add(ClassMission classMission);
	//查看班级公告
	List<ClassMission> findByClassNumber(Student student);

}
