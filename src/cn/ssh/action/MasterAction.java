package cn.ssh.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.ssh.entity.Master;
import cn.ssh.entity.PageBean;
import cn.ssh.entity.Student;
import cn.ssh.service.MasterService;
import cn.ssh.service.StudentService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class MasterAction extends ActionSupport implements ModelDriven<Master> {
	private Master master = new Master();
	private Student student = new Student();
	private StudentService studentService = new StudentService();
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	private MasterService masterService;
	public void setMasterService(MasterService masterService) {
		this.masterService = masterService;
	}
	public Master getModel() {
		return master;
	}

	// 查看个人信息
	public String selfInfo() {
		Object session = ServletActionContext.getRequest().getSession()
				.getAttribute("master");
		ServletActionContext.getRequest().setAttribute("master", session);
		return "selfInfo";
	}

	// 前往修改登陆密码页面
	public String toUpdatePwdPage() {
		Object session = ServletActionContext.getRequest().getSession()
				.getAttribute("master");
		ServletActionContext.getRequest().setAttribute("master", session);
		return "toUpdatePwdPage";
	}

	// 修改登陆密码
	public String updatePwd() {
		masterService.updatePwd(master);
		return "updatePwd";
	}

	// 退出登陆
	public String exit() {
		return "exit";
	}
	//军训介绍
	public String toTrainIntroducePage() {
		return "toTrainIntroducePage";
	}
	//教官列表
	public String masterList() {
		List<Master> list = masterService.findAllMaster();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "masterList";
	}
	//根据教官号查找教官
	public String findMasterByNumber() {
		String masNumber = (String) ServletActionContext.getRequest().getSession().getAttribute("id");
		Master mas = masterService.findMasterByNumber(masNumber);
		return "findMasterByNumber";
	}
	//多条件查询教官信息
	public String findMasterMoreCondition() {
		List<Master> list = masterService.findMasterMoreCondition(master);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "findMasterMoreCondition";
	}
	//新生信息
	public String studentList() {
		String masNumber = (String) ServletActionContext.getRequest().getSession().getAttribute("id");
		Master mas = masterService.findMasterByNumber(masNumber);
		if(mas!=null) {
			List<Student> list = masterService.findStudentByMaster(mas);
			ServletActionContext.getRequest().setAttribute("list", list);
		}
		return "studentList";
	}
	//添加教官页面
	public String toAddPage() {
		return "toAddPage";
	}
	//添加教官
	public String add() {
		masterService.add(master);
		return "add";
	}
	//删除所有教官信息
	public String delete() {
		masterService.delete();
		return "delete";
	}
	//发布班级公告
	public String toClassMissionPage() {
		String masNumber = (String) ServletActionContext.getRequest().getSession().getAttribute("id");
		Master mas = masterService.findMasterByNumber(masNumber);
		Student stu = studentService.selectBymasId(mas);
		ServletActionContext.getRequest().setAttribute("student", stu);
		return "toClassMissionPage";
	}
	

}
