package cn.ssh.dao;

import java.util.List;

import cn.ssh.entity.FellowShip;

public interface FellowShipDao {
	//发起联谊
	void addShip(FellowShip fellowShip);
	//受邀联谊
	List<FellowShip> beShiped(String toMasNumber);
	//根据fesId查找
	FellowShip findFellowById(int fesId);
	//回复受邀联谊
	void answerFellowShip(FellowShip fellowShip);
	//联谊结果与自身有关
	List<FellowShip> shipResultList(String Number);
	//军训联谊全部结果
	List<FellowShip> shipAllResultList();
	//删除联谊信息
	void delete();

}
