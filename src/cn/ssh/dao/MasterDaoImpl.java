package cn.ssh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.ssh.entity.Master;
import cn.ssh.entity.Student;
import cn.ssh.utils.JdbcUtils;

public class MasterDaoImpl extends HibernateDaoSupport implements MasterDao {
	// 修改登陆密码
	public void updatePwd(Master master) {
		this.getHibernateTemplate().update(master);
	}

	// 教官列表
	@SuppressWarnings("all")
	public List<Master> findAllMaster() {
		return (List<Master>) this.getHibernateTemplate().find("from Master");
	}

	// 多条件查询教官信息
	@SuppressWarnings("all")
	public List<Master> findMasterMoreCondition(Master master) {
		List<Object> p = new ArrayList<Object>();
		String hql = "from Master where 1=1 ";
		if (master.getMasName() != null && !"".equals(master.getMasName())) {
			hql += " and masName = ?";
			p.add(master.getMasName());
		}
		if ("男".equals(master.getMasSex()) || "女".equals(master.getMasSex())) {
			hql += " and masSex = ?";
			p.add(master.getMasSex());
		}
		if ("信息工程学院".equals(master.getMasAcademy()) || "土木工程学院".equals(master.getMasAcademy()) || "外国语学院".equals(master.getMasAcademy())) {
			hql += " and masAcademy = ?";
			p.add(master.getMasAcademy());
		}
		return (List<Master>) this.getHibernateTemplate()
				.find(hql, p.toArray());
	}
    //根据教官号查教官
	@SuppressWarnings("all")
	public Master findMasterByNumber(String masNumber) {
		List<Master> list = (List<Master>) this.getHibernateTemplate().find("from Master where masNumber=?", masNumber);
		if(list.size()!=0 && list!=null){
			Master mas = list.get(0);
			return mas;
		}
		return null;
	}
	//通过教官查找该教官班级的新生信息
	@SuppressWarnings("all")
	public List<Student> findStudentByMaster(Master mas) {
		return (List<Student>) this.getHibernateTemplate().find("from Student where masId=?", mas.getMasId());
	}
	//添加教官
	public void add(Master master) {
		this.getHibernateTemplate().save(master);
	}
	//删除所有教官信息
	public void delete() {
		PreparedStatement stmt;
		Statement st;
		ResultSet rs;
		JdbcUtils utils = new JdbcUtils();
		Connection conn = utils.getConnection();
		String sql = "delete from t_master";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
