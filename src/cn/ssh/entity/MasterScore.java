package cn.ssh.entity;

public class MasterScore {
//	msId: 主键（自动增长）
//	msCharacter: 教官性格   msIsGood: 教官是否棒棒的
//	msFriend: 是否建立了友谊  masId: 外键
	private Integer msId;
	private String msCharacter;
	private String msGood;
	private String msFriend;
	private String masNumber;
	public String getMasNumber() {
		return masNumber;
	}
	public void setMasNumber(String masNumber) {
		this.masNumber = masNumber;
	}
	public Integer getMsId() {
		return msId;
	}
	public void setMsId(Integer msId) {
		this.msId = msId;
	}
	public String getMsCharacter() {
		return msCharacter;
	}
	public void setMsCharacter(String msCharacter) {
		this.msCharacter = msCharacter;
	}
	public String getMsGood() {
		return msGood;
	}
	public void setMsGood(String msGood) {
		this.msGood = msGood;
	}
	public String getMsFriend() {
		return msFriend;
	}
	public void setMsFriend(String msFriend) {
		this.msFriend = msFriend;
	}

}
