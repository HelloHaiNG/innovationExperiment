package cn.ssh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.ssh.entity.Article;
import cn.ssh.entity.Student;
import cn.ssh.utils.JdbcUtils;

public class ArticleDaoImpl extends HibernateDaoSupport implements ArticleDao {
	//添加稿件
	public void add(Article article) {
		this.getHibernateTemplate().save(article);
	}
	//稿件列表
	@SuppressWarnings("all")
	public List<Article> list() {
		return (List<Article>) this.getHibernateTemplate().find("from Article");
	}
	//根据id查询稿件
	@SuppressWarnings("all")
	public Article findById(int artId) {
		List<Article> list = (List<Article>) this.getHibernateTemplate().find("from Article where artId=?", artId);
		if(list.size()!=0 && list!=null){
			Article art = list.get(0);
			return art;
		}
		return null;
	}
	//删除稿件信息
	public void delete() {
		PreparedStatement stmt;
		Statement st;
		ResultSet rs;
		JdbcUtils utils = new JdbcUtils();
		Connection conn = utils.getConnection();
		String sql = "delete from t_article";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
