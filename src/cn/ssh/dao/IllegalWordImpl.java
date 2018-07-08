package cn.ssh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import cn.ssh.entity.IllegalWord;
import cn.ssh.utils.JdbcUtils;

public class IllegalWordImpl {
	PreparedStatement stmt;
	Statement st;
	ResultSet rs;
	JdbcUtils utils = new JdbcUtils();
	public String words(){
		Connection conn = utils.getConnection();
		IllegalWord iw = null;
		String words = "";
		String sql = "select word from t_illegalword";
		try{
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				iw = new IllegalWord();
				iw.setWord(rs.getString(1));
				words = words+iw.getWord();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return words;
	}
}
