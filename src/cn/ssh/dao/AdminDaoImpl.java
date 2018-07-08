package cn.ssh.dao;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.ssh.entity.Admin;

public class AdminDaoImpl extends HibernateDaoSupport implements AdminDao {
    //修改登陆密码
	public void updatePwd(Admin admin) {
		this.getHibernateTemplate().update(admin);
	}

}
