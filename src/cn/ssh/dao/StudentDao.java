package cn.ssh.dao;

import java.util.List;

import cn.ssh.entity.Master;
import cn.ssh.entity.Student;

public interface StudentDao {
    //修改登陆密码
	void updatePwd(Student student);
    //新生总数
	int findCount();
	//分页查询新生信息
	List<Student> findListPage(int begin, int pageSize);
	//根据学号查找新生
	Student findStudentByNumber(String stuNumber);
	//查找对应未打分新生集合
	List<Student> findStudentNoScore(Master mas);
	//军训打分
	void score(Student student);
	//全部新生成绩列表
	List<Student> scoreList();
	//添加新生
	void add(Student student);
	//删除新生
	void delete();
	//根据教官编号查询学生
	Student selectBymasId(Master mas);
    
}
