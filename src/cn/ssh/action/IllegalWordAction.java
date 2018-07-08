package cn.ssh.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.ssh.entity.IllegalWord;
import cn.ssh.service.IllegalWordService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class IllegalWordAction extends ActionSupport implements ModelDriven<IllegalWord>{
	private IllegalWord illegalWord = new IllegalWord();
	private IllegalWordService illegalWordService;
	public void setIllegalWordService(IllegalWordService illegalWordService) {
		this.illegalWordService = illegalWordService;
	}
	public IllegalWord getModel() {
		return illegalWord;
	}
	//敏感字列表
	public String list() {
		List<IllegalWord> list = illegalWordService.list();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "list";
	}
	//添加敏感字页面
	public String toAddPage() {		
		return "toAddPage";
	}
	//添加敏感字
	public String add() {
		illegalWordService.add(illegalWord);
		return "add";
	}

}
