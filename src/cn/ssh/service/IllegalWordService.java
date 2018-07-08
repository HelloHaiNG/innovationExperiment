package cn.ssh.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.ssh.dao.IllegalWordDao;
import cn.ssh.entity.IllegalWord;
@Transactional
public class IllegalWordService {
	private IllegalWordDao illegalWordDao;
	public void setIllegalWordDao(IllegalWordDao illegalWordDao) {
		this.illegalWordDao = illegalWordDao;
	}
	//敏感字列表
	public List<IllegalWord> list() {
		return illegalWordDao.list();
	}
	//添加敏感字
	public void add(IllegalWord illegalWord) {
		illegalWordDao.add(illegalWord);
	}

}
