package cn.ssh.dao;

import cn.ssh.entity.Admin;
import cn.ssh.entity.Master;
import cn.ssh.entity.Student;

public interface OtherDao {
    //登陆
	Student loginStudent(String id, String pwd);

	Master loginMaster(String id, String pwd);

	Admin loginAdmin(String id, String pwd);

}
