package cn.ssh.dao;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.ssh.entity.IllegalWord;

public class IllegalWordDaoImpl extends HibernateDaoSupport implements IllegalWordDao {
	//敏感字列表
	@SuppressWarnings("all")
	public List<IllegalWord> list() {
		return (List<IllegalWord>) this.getHibernateTemplate().find("from IllegalWord");
	}
	//添加敏感字
	public void add(IllegalWord illegalWord) {
		this.getHibernateTemplate().save(illegalWord);
	}

}
