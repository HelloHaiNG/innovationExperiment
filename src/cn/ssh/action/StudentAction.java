package cn.ssh.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.ssh.entity.Master;
import cn.ssh.entity.PageBean;
import cn.ssh.entity.Student;
import cn.ssh.service.MasterService;
import cn.ssh.service.StudentService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class StudentAction extends ActionSupport implements ModelDriven<Student>{
	private Student student = new Student();
	private Master master = new Master();
	private StudentService studentService;
	private MasterAction masterAction;
	private MasterService masterService;
	public void setMasterService(MasterService masterService) {
		this.masterService = masterService;
	}
	public void setMasterAction(MasterAction masterAction) {
		this.masterAction = masterAction;
	}
	private Integer currentPage;
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	public Student getModel() {
		return student;
	}
	//查看个人信息
	public String selfInfo() {
		Object session = ServletActionContext.getRequest().getSession().getAttribute("student");
		ServletActionContext.getRequest().setAttribute("student", session);
		return "selfInfo";
	}
	//前往修改登陆密码页面
	public String toUpdatePwdPage() {
		Object session = ServletActionContext.getRequest().getSession().getAttribute("student");
		ServletActionContext.getRequest().setAttribute("student", session);
		return "toUpdatePwdPage";
	}
	//修改登陆密码
	public String updatePwd() {
		studentService.updatePwd(student);
		return "updatePwd";
	}
	//退出登陆
	public String exit() {
		return "exit";
	}
	//军训介绍
	public String toTrainIntroducePage() {
		return "toTrainIntroducePage";
	}
	//前往多条件查询教官页面
	public String toFindMasterMoreConditionPage() {
		return "toFindMasterMoreConditionPage";
	}
	//分页显示新生信息
	public String studentList() {
		PageBean pageBean = studentService.list(currentPage);
		ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
		return "studentList";
	}
	//前往军训打分页面
	public String toScorePage() {
		String masNumber = (String) ServletActionContext.getRequest().getSession().getAttribute("id");
		//根据教官学号查看教官
		Master mas = masterService.findMasterByNumber(masNumber);
		//查找对应未打分新生集合
		List<Student> list = studentService.findStudentNoScore(mas);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "toScorePage";
	}
	//具体打分页面
	public String toScore() {
		String stuNumber = student.getStuNumber();
		Student stu = studentService.findStudentByNumber(stuNumber);
		if(stu!=null) {
			ServletActionContext.getRequest().setAttribute("student", stu);
		}
		return "toScore";
	}
	//军训打分
	public String score() {
		studentService.score(student);
		return "score";
	}
	//全部新生成绩列表
	public String scoreList() {
		List<Student> list = studentService.scoreList();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "scoreList";
	}
	//添加新生页面
	public String toAddPage() {
		//查找所有教官
		masterAction.masterList();
		return "toAddPage";
	}
	//添加新生
	public String add() {
		studentService.add(student);
		return "add";
	}
	//删除新生
	public String delete() {
		studentService.delete();
		return "delete";
	}
	
}
