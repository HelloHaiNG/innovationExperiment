package cn.ssh.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.ssh.dao.StudentDao;
import cn.ssh.entity.Master;
import cn.ssh.entity.PageBean;
import cn.ssh.entity.Student;

@Transactional
public class StudentService {
	private StudentDao studentDao;
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	//修改登陆密码
	public void updatePwd(Student student) {
		studentDao.updatePwd(student);
	}
	//分页显示新生信息
	public PageBean list(Integer currentPage) {
		PageBean pageBean = new PageBean();
		//当前页数
		pageBean.setCurrentPage(currentPage);
		//总记录数
		int totalCount = studentDao.findCount();
		pageBean.setTotalCount(totalCount);
		//页记录数
		int pageSize = 10;
		pageBean.setPageSize(pageSize);
		//总页数
		int totalPage = 0;
		if(totalCount%pageSize==0){
			totalPage = totalCount/pageSize;
		}else{
			totalPage = totalCount/pageSize+1;
		}
		pageBean.setTotalPage(totalPage);
		//页开始记录数
		int begin = (currentPage-1)*pageSize;
		pageBean.setBegin(begin);
		List<Student> list = studentDao.findListPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}
	//根据学号查找新生
	public Student findStudentByNumber(String stuNumber) {
		return studentDao.findStudentByNumber(stuNumber);
	}
	//查找对应未打分新生集合
	public List<Student> findStudentNoScore(Master mas) {
		return studentDao.findStudentNoScore(mas);
	}
	//军训打分
	public void score(Student student) {
		studentDao.score(student);
	}
	//全部新生成绩列表
	public List<Student> scoreList() {
		return studentDao.scoreList();
	}
	//添加新生
	public void add(Student student) {
		studentDao.add(student);
	}
	//删除新生
	public void delete() {
		studentDao.delete();
	}
	//根据教官编号查询学生
	public Student selectBymasId(Master mas) {
		Student stu = studentDao.selectBymasId(mas);
		return stu;
	}


}
