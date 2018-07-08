package cn.ssh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.ssh.entity.FellowShip;
import cn.ssh.entity.Master;
import cn.ssh.utils.JdbcUtils;

public class FellowShipDaoImpl extends HibernateDaoSupport implements FellowShipDao {
	//发起联谊
	public void addShip(FellowShip fellowShip) {
		this.getHibernateTemplate().save(fellowShip);
	}
	//受邀联谊
	@SuppressWarnings("all")
	public List<FellowShip> beShiped(String toMasNumber) {
		return (List<FellowShip>) this.getHibernateTemplate().find("from FellowShip where toMasNumber=? and fesResult is null", toMasNumber);
	}
	//根据fesId查找
	@SuppressWarnings("all")
	public FellowShip findFellowById(int fesId) {
		List<FellowShip> list = (List<FellowShip>) this.getHibernateTemplate().find("from FellowShip where fesId=?", fesId);
		if(list.size()!=0 && list!=null){
			FellowShip fes = list.get(0);
			return fes;
		}
		return null;
	}
	//回复受邀联谊
	public void answerFellowShip(FellowShip fellowShip) {
		this.getHibernateTemplate().update(fellowShip);
	}
	//联谊结果与自身有关
	@SuppressWarnings("all")
	public List<FellowShip> shipResultList(String Number) {
		return (List<FellowShip>) this.getHibernateTemplate().find("from FellowShip where fromMasNumber=? or toMasNumber=?", Number,Number);
	}
	//军训联谊全部结果
	@SuppressWarnings("all")
	public List<FellowShip> shipAllResultList() {
		return (List<FellowShip>) this.getHibernateTemplate().find("from FellowShip");
	}
	//删除联谊信息
	public void delete() {
		PreparedStatement stmt;
		Statement st;
		ResultSet rs;
		JdbcUtils utils = new JdbcUtils();
		Connection conn = utils.getConnection();
		String sql = "delete from t_fellowship";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
