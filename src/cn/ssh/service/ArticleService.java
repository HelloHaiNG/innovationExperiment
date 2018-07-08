package cn.ssh.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.ssh.dao.ArticleDao;
import cn.ssh.entity.Article;

@Transactional
public class ArticleService {
	private ArticleDao articleDao;
	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}
	//添加稿件
	public void add(Article article) {
		articleDao.add(article);
	}
	//稿件列表
	public List<Article> list() {
		return articleDao.list();
	}
	//根据id查询稿件
	public Article findById(int artId) {
		return articleDao.findById(artId);
	}
	//删除稿件信息
	public void delete() {
		articleDao.delete();
	}

}
