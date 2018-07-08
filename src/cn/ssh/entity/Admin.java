package cn.ssh.entity;

public class Admin {
	private Integer admId;
	private String admNumber;
	private String admPassword;
	private String admName;
	public String getAdmNumber() {
		return admNumber;
	}
	public void setAdmNumber(String admNumber) {
		this.admNumber = admNumber;
	}
	public Integer getAdmId() {
		return admId;
	}
	public void setAdmId(Integer admId) {
		this.admId = admId;
	}
	public String getAdmPassword() {
		return admPassword;
	}
	public void setAdmPassword(String admPassword) {
		this.admPassword = admPassword;
	}
	public String getAdmName() {
		return admName;
	}
	public void setAdmName(String admName) {
		this.admName = admName;
	}

}
