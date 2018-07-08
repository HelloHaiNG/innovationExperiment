package cn.ssh.dao;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.ssh.entity.Admin;
import cn.ssh.entity.Master;
import cn.ssh.entity.Student;

public class OtherDaoImpl extends HibernateDaoSupport implements OtherDao {
    //登陆
	@SuppressWarnings("all")
	public Student loginStudent(String id, String pwd) {
		List<Student> list = (List<Student>) this.getHibernateTemplate().find("from Student where stuNumber=? and stuPassword=?", id,pwd);
		if(list.size()!=0 && list!=null){
			Student stu = list.get(0);
			return stu;
		}
		return null;
	}

	@SuppressWarnings("all")
	public Master loginMaster(String id, String pwd) {
		List<Master> list = (List<Master>) this.getHibernateTemplate().find("from Master where masNumber=? and masPassword=?", id,pwd);
		if(list.size()!=0 && list!=null){
			Master mas = list.get(0);
			return mas;
		}
		return null;
	}

	@SuppressWarnings("all")
	public Admin loginAdmin(String id, String pwd) {
		List<Admin> list = (List<Admin>) this.getHibernateTemplate().find("from Admin where admNumber=? and admPassword=?", id,pwd);
		if(list.size()!=0 && list!=null){
			Admin adm = list.get(0);
			return adm;
		}
		return null;
	}

}
