package cn.ssh.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.ssh.dao.FellowShipDao;
import cn.ssh.entity.FellowShip;
@Transactional
public class FellowShipService {
	private FellowShipDao fellowShipDao;
	public void setFellowShipDao(FellowShipDao fellowShipDao) {
		this.fellowShipDao = fellowShipDao;
	}
	//发起联谊
	public void addShip(FellowShip fellowShip) {
		fellowShipDao.addShip(fellowShip);
	}
	//受邀联谊
	public List<FellowShip> beShiped(String toMasNumber) {
		return fellowShipDao.beShiped(toMasNumber);
	}
	//根据fesId查找 
	public FellowShip findFellowById(int fesId) {
		return fellowShipDao.findFellowById(fesId);
	}
	//回复受邀联谊
	public void answerFellowShip(FellowShip fellowShip) {
		fellowShipDao.answerFellowShip(fellowShip);
	}
	//联谊结果与自身有关
	public List<FellowShip> shipResultList(String Number) {
		return fellowShipDao.shipResultList(Number);
	}
	//军训联谊全部结果
	public List<FellowShip> shipAllResultList() {
		return fellowShipDao.shipAllResultList();
	}
	//删除联谊信息
	public void delete() {
		fellowShipDao.delete();
	}

}
