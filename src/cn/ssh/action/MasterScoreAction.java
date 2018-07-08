package cn.ssh.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.ssh.entity.MasterScore;
import cn.ssh.service.MasterScoreService;
import cn.ssh.service.StudentService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class MasterScoreAction extends ActionSupport implements ModelDriven<MasterScore>{
	private MasterScore masterScore = new MasterScore();
	private StudentService studentService;
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	private MasterScoreService masterScoreService;
	public void setMasterScoreService(MasterScoreService masterScoreService) {
		this.masterScoreService = masterScoreService;
	}
	public MasterScore getModel() {
		return masterScore;
	}
	//前往评教页面
	public String toScorePage() {
		Object session = ServletActionContext.getRequest().getSession().getAttribute("student");
		ServletActionContext.getRequest().setAttribute("student", session);
		return "toScorePage";
	}
	//评教
	public String score() {
		masterScoreService.score(masterScore);
		return "score";
	}
	//查看自己的评教
	public String listSelf() {
		String masNumber = (String) ServletActionContext.getRequest().getSession().getAttribute("id");
		List<MasterScore> list = masterScoreService.listSelf(masNumber);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "listSelf";
	}
	//查询所有教官评教
	public String list() {
		List<MasterScore> list = masterScoreService.list();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "list";
	}

}
