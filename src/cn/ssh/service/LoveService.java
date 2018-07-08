package cn.ssh.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.ssh.dao.LoveDao;
import cn.ssh.entity.Love;

@Transactional
public class LoveService {
	private LoveDao loveDao;
	public void setLoveDao(LoveDao loveDao) {
		this.loveDao = loveDao;
	}
	//我要表白
	public void addLove(Love love) {
		loveDao.addLove(love);
	}
	//查看我的表白
	public List<Love> myLoveList(String stuNumber) {
		return loveDao.myLoveList(stuNumber);
	}
	//表白墙
	public List<Love> loveList() {
		return loveDao.loveList();
	}
	//审核表白
	public List<Love> examLove() {
		return loveDao.examLove();
	}
	//审核表白
	public void answerLove(Love love) {
		loveDao.answerLove(love);
	}
	//审核表白页面
	public Love findLove(int loveId) {
		return loveDao.findLove(loveId);
	}
	//删除表白信息
	public void delete() {
		loveDao.delete();
	}

}
