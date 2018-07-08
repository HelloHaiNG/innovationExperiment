package cn.ssh.dao;

import java.util.List;

import cn.ssh.entity.Article;

public interface ArticleDao {
	//添加稿件
	void add(Article article);
	//稿件列表
	List<Article> list();
	//根据id查询稿件
	Article findById(int artId);
	//删除稿件信息
	void delete();

}
