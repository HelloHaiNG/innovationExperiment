package cn.ssh.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.ssh.dao.MasterScoreDao;
import cn.ssh.entity.MasterScore;
@Transactional
public class MasterScoreService {
	private MasterScoreDao masterScoreDao;
	public void setMasterScoreDao(MasterScoreDao masterScoreDao) {
		this.masterScoreDao = masterScoreDao;
	}
	//评教
	public void score(MasterScore masterScore) {
		masterScoreDao.score(masterScore);
	}
	//查看自己的评教
	public List<MasterScore> listSelf(String masNumber) {
		return masterScoreDao.listSelf(masNumber);
	}
	//查询所有教官评教
	public List<MasterScore> list() {
		return masterScoreDao.list();
	}
	

}
