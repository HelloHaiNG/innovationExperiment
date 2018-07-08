package cn.ssh.dao;

import java.util.List;

import cn.ssh.entity.IllegalWord;

public interface IllegalWordDao {
	//敏感字列表
	List<IllegalWord> list();
	//添加敏感字
	void add(IllegalWord illegalWord);

}
