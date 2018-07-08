package cn.ssh.dao;

import java.util.List;

import cn.ssh.entity.Love;

public interface LoveDao {
	//我要表白
	void addLove(Love love);
	//查看我的表白
	List<Love> myLoveList(String stuNumber);
	//表白墙
	List<Love> loveList();
	//审核表白
	List<Love> examLove();
	//审核表白
	void answerLove(Love love);
	//根据表白编号查找
	Love findLove(int loveId);
	//删除表白信息
	void delete();

}
