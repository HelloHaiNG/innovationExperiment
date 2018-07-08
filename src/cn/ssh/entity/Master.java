package cn.ssh.entity;

import java.util.HashSet;
import java.util.Set;

public class Master {
	private Integer masId;
	private String masNumber;
	private String masPassword;
	private String masName;
	private String masSex;
	private String masAcademy;
	Set<Student> setStudent = new HashSet<Student>();
	Set<ClassMission> setClassMission = new HashSet<ClassMission>();
	public Set<ClassMission> getSetClassMission() {
		return setClassMission;
	}
	public void setSetClassMission(Set<ClassMission> setClassMission) {
		this.setClassMission = setClassMission;
	}
	public Set<Student> getSetStudent() {
		return setStudent;
	}
	public void setSetStudent(Set<Student> setStudent) {
		this.setStudent = setStudent;
	}
	public Integer getMasId() {
		return masId;
	}
	public void setMasId(Integer masId) {
		this.masId = masId;
	}
	public String getMasNumber() {
		return masNumber;
	}
	public void setMasNumber(String masNumber) {
		this.masNumber = masNumber;
	}
	public String getMasPassword() {
		return masPassword;
	}
	public void setMasPassword(String masPassword) {
		this.masPassword = masPassword;
	}
	public String getMasName() {
		return masName;
	}
	public void setMasName(String masName) {
		this.masName = masName;
	}
	public String getMasSex() {
		return masSex;
	}
	public void setMasSex(String masSex) {
		this.masSex = masSex;
	}
	public String getMasAcademy() {
		return masAcademy;
	}
	public void setMasAcademy(String masAcademy) {
		this.masAcademy = masAcademy;
	}

}
