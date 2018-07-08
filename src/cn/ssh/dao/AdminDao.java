package cn.ssh.dao;

import cn.ssh.entity.Admin;

public interface AdminDao {
    //修改登陆密码
	void updatePwd(Admin admin);

}
