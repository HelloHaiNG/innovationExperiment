package cn.ssh.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.ssh.entity.ClassMission;
import cn.ssh.entity.Student;
import cn.ssh.service.ClassMissionService;
import cn.ssh.service.StudentService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ClassMissionAction extends ActionSupport implements ModelDriven<ClassMission>{
	private ClassMission classMission = new ClassMission();
	private StudentService studentService;
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	private ClassMissionService classMissionService;
	public void setClassMissionService(ClassMissionService classMissionService) {
		this.classMissionService = classMissionService;
	}
	public ClassMission getModel() {
		return classMission;
	}
	//发布任务
	public String add() {
		classMissionService.add(classMission);
		return "add";
	}
	//查看班级公告
	public String viewClassMission() {
		String stuNumber = (String) ServletActionContext.getRequest().getSession().getAttribute("id");
		Student student = studentService.findStudentByNumber(stuNumber);
		if(student!=null) {
			List<ClassMission> list = classMissionService.findByClassNumber(student);
			ServletActionContext.getRequest().setAttribute("list", list);
		}
		return "viewClassMission";
	}

}
