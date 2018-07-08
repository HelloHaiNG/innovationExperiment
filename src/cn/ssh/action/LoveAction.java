package cn.ssh.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.ssh.entity.Love;
import cn.ssh.service.LoveService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoveAction extends ActionSupport implements ModelDriven<Love>{
	private Love love = new Love();
	private LoveService loveService;
	public void setLoveService(LoveService loveService) {
		this.loveService = loveService;
	}
	public Love getModel() {
		return love;
	}
	//前往表白页面
	public String toLovePage() {
		return "toLovePage";
	}
	//我要表白
	public String addLove() {
		loveService.addLove(love);
		return "addLove";
	}
	//查看我的表白
	public String myLoveList() {
		String stuNumber = (String) ServletActionContext.getRequest().getSession().getAttribute("id");
		List<Love> list = loveService.myLoveList(stuNumber);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "myLoveList";
	}
	//表白墙
	public String loveList() {
		List<Love> list = loveService.loveList();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "loveList";
	}
	//审核表白页面列表
	public String examLove() {
		List<Love> list = loveService.examLove();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "examLove";
	}
	//审核表白页面
	public String examLovePage() {
		int loveId = love.getLoveId();
		Love lo = loveService.findLove(loveId);
		if(lo!=null) {
			ServletActionContext.getRequest().setAttribute("love", lo);
		}
		return "examLovePage";
	}
	//审核表白
	public String answerLove() {
		loveService.answerLove(love);
		return "answerLove";
	}
	//删除表白信息
	public String delete() {
		loveService.delete();
		return "delete";
	}

}
