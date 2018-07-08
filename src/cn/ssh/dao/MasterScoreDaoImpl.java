package cn.ssh.dao;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.ssh.entity.MasterScore;

public class MasterScoreDaoImpl extends HibernateDaoSupport implements MasterScoreDao {
	//评教
	public void score(MasterScore masterScore) {
		this.getHibernateTemplate().save(masterScore);
	}
	//查看自己的评教
	@SuppressWarnings("all")
	public List<MasterScore> listSelf(String masNumber) {
		return (List<MasterScore>) this.getHibernateTemplate().find("from MasterScore where masNumber=?", masNumber);
	}
	//查询所有教官评教
	@SuppressWarnings("all")
	public List<MasterScore> list() {
		return (List<MasterScore>) this.getHibernateTemplate().find("from MasterScore");
	}

}
