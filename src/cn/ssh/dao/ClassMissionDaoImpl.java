package cn.ssh.dao;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.ssh.entity.ClassMission;
import cn.ssh.entity.Student;

public class ClassMissionDaoImpl extends HibernateDaoSupport implements ClassMissionDao {
	//发布任务
	public void add(ClassMission classMission) {
		this.getHibernateTemplate().save(classMission);
	}
	//查看班级公告
	@SuppressWarnings("all")
	public List<ClassMission> findByClassNumber(Student student) {
		return (List<ClassMission>) this.getHibernateTemplate().find("from ClassMission where stuClassNumber=?", student.getStuClassNumber());
	}

}
