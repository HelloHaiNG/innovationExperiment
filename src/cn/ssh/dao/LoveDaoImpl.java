package cn.ssh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.ssh.entity.FellowShip;
import cn.ssh.entity.Love;
import cn.ssh.utils.JdbcUtils;

public class LoveDaoImpl extends HibernateDaoSupport implements LoveDao {
	//我要表白
	public void addLove(Love love) {
		this.getHibernateTemplate().save(love);
	}
	//查看我的表白
	@SuppressWarnings("all")
	public List<Love> myLoveList(String stuNumber) {
		return (List<Love>) this.getHibernateTemplate().find("from Love where stuNumber=?", stuNumber);
	}
	//表白墙
	@SuppressWarnings("all")
	public List<Love> loveList() {
		return (List<Love>) this.getHibernateTemplate().find("from Love where loveResult=?", "同意");
	}
	//审核表白
	@SuppressWarnings("all")
	public List<Love> examLove() {
		return (List<Love>) this.getHibernateTemplate().find("from Love where loveResult is null");
	}
	//审核表白
	public void answerLove(Love love) {
		this.getHibernateTemplate().update(love);
	}
	//根据表白编号查找
	@SuppressWarnings("all")
	public Love findLove(int loveId) {
		List<Love> list = (List<Love>) this.getHibernateTemplate().find("from Love where loveId=?", loveId);
		if(list.size()!=0 && list!=null){
			Love lo = list.get(0);
			return lo;
		}
		return null;
	}
	//删除表白信息
	public void delete() {
		PreparedStatement stmt;
		Statement st;
		ResultSet rs;
		JdbcUtils utils = new JdbcUtils();
		Connection conn = utils.getConnection();
		String sql = "delete from t_love";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
