package cn.ssh.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.ssh.entity.FellowShip;
import cn.ssh.service.FellowShipService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class FellowShipAction extends ActionSupport implements ModelDriven<FellowShip>{
	private FellowShip fellowShip = new FellowShip();
	private FellowShipService fellowShipService;
	public void setFellowShipService(FellowShipService fellowShipService) {
		this.fellowShipService = fellowShipService;
	}
	public FellowShip getModel() {
		return fellowShip;
	}
	//前往发起联谊页面
	public String toShipPage() {
		return "toShipPage";
	}
	//发起联谊
	public String addShip() {
		fellowShipService.addShip(fellowShip);
		return "addShip";
	}
	//受邀联谊
	public String beShiped() {
		String toMasNumber = (String) ServletActionContext.getRequest().getSession().getAttribute("id");
		List<FellowShip> list = fellowShipService.beShiped(toMasNumber);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "beShiped";
	}
	//前往回复联谊页面
	public String toAnswerPage() {
		int fesId = fellowShip.getFesId();
		FellowShip fes = fellowShipService.findFellowById(fesId);
		ServletActionContext.getRequest().setAttribute("fellowship", fes);
		return "toAnswerPage";
	}
	//回复受邀联谊
	public String answerFellowShip() {
		fellowShipService.answerFellowShip(fellowShip);
		return "answerFellowShip";
	}
	//联谊结果与自身有关
	public String shipResultList() {
		String Number = (String) ServletActionContext.getRequest().getSession().getAttribute("id");
		List<FellowShip> list = fellowShipService.shipResultList(Number);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "shipResultList";
	}
	//军训联谊全部结果
	public String shipAllResultList() {
		List<FellowShip> list = fellowShipService.shipAllResultList();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "shipAllResultList";
	}
	//删除联谊信息
	public String delete() {
		fellowShipService.delete();
		return "delete";
	}

}
