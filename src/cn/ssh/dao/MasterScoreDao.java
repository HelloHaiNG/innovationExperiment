package cn.ssh.dao;

import java.util.List;

import cn.ssh.entity.MasterScore;

public interface MasterScoreDao {
	//评教
	void score(MasterScore masterScore);
	//查看自己的评教
	List<MasterScore> listSelf(String masNumber);
	//查询所有教官评教
	List<MasterScore> list();

}
