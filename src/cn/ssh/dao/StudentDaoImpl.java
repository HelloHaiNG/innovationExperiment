package cn.ssh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.ssh.entity.Master;
import cn.ssh.entity.Student;
import cn.ssh.utils.JdbcUtils;

public class StudentDaoImpl extends HibernateDaoSupport implements StudentDao {
	//修改登陆密码
	public void updatePwd(Student student) {
		this.getHibernateTemplate().update(student);
	}
    //查询新生数
	@SuppressWarnings("all")
	public int findCount() {
		List<Object>list = (List<Object>) this.getHibernateTemplate().find("select count(*) from Student");
		if(list.size()!=0 && list!=null){
			Object obj = list.get(0);
			Long lobj = (Long) obj;
			int totalCount = lobj.intValue();
			return totalCount;
		}
		return 0;
	}
    //分页查询新生信息
	@SuppressWarnings("all")
	public List<Student> findListPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Student.class);
		List<Student> list = (List<Student>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}
	//根据学号查找新生
	@SuppressWarnings("all")
	public Student findStudentByNumber(String stuNumber) {
		List<Student> list = (List<Student>) this.getHibernateTemplate().find("from Student where stuNumber=?", stuNumber);
		if(list.size()!=0 && list!=null){
			Student stu = list.get(0);
			return stu;
		}
		return null;
	}
	//查找对应未打分新生集合
	@SuppressWarnings("all")
	public List<Student> findStudentNoScore(Master mas) {
		return (List<Student>) this.getHibernateTemplate().find("from Student where masId=? and stuScore is null", mas.getMasId());
	}
	//军训打分
	public void score(Student student) {
		this.getHibernateTemplate().update(student);
	}
	//全部新生成绩列表
	@SuppressWarnings("all")
	public List<Student> scoreList() {
		return (List<Student>) this.getHibernateTemplate().find("from Student where stuScore is not null");
	}
	//添加新生
	public void add(Student student) {
		this.getHibernateTemplate().save(student);
	}
	//删除新生
	public void delete() {
		PreparedStatement stmt;
		Statement st;
		ResultSet rs;
		JdbcUtils utils = new JdbcUtils();
		Connection conn = utils.getConnection();
		String sql = "delete from t_student";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//根据教官编号查询学生信息
	@SuppressWarnings("all")
	public Student selectBymasId(Master mas) {
		Student stu = new Student();
		List<Student> list = (List<Student>) this.getHibernateTemplate().find("from Student where masId=?", mas.getMasId());
		if(list.size()!=0 && list!=null){
			 stu = list.get(0);			
		}
		return stu;
	}
 	
}
