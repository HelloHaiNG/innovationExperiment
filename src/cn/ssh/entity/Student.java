package cn.ssh.entity;

import java.util.HashSet;
import java.util.Set;

public class Student {
	private Integer stuId;
	private String stuNumber;
	private String stuName;
	private String stuPassword;
	private String stuSex;
	private String stuClassNumber;
	private String stuAcademy;
	private String stuScore;
	public String getStuScore() {
		return stuScore;
	}
	public void setStuScore(String stuScore) {
		this.stuScore = stuScore;
	}
	private Master master;
	public Master getMaster() {
		return master;
	}
	public void setMaster(Master master) {
		this.master = master;
	}
	public Integer getStuId() {
		return stuId;
	}
	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}
	public String getStuNumber() {
		return stuNumber;
	}
	public void setStuNumber(String stuNumber) {
		this.stuNumber = stuNumber;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuPassword() {
		return stuPassword;
	}
	public void setStuPassword(String stuPassword) {
		this.stuPassword = stuPassword;
	}
	public String getStuSex() {
		return stuSex;
	}
	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}
	public String getStuClassNumber() {
		return stuClassNumber;
	}
	public void setStuClassNumber(String stuClassNumber) {
		this.stuClassNumber = stuClassNumber;
	}
	public String getStuAcademy() {
		return stuAcademy;
	}
	public void setStuAcademy(String stuAcademy) {
		this.stuAcademy = stuAcademy;
	}
    
}
