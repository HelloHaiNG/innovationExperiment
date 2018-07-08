package cn.ssh.entity;

public class ClassMission {
//	missionId: 任务号（主键 自动增长） stuClassNumber: 学生班级号（主键）
//	mission: 班级公告  releaseWhen: 发布时间
//	masId: 教官号（外键）（任务和教官是多对一关系）
    private Integer missionId;
    private String stuClassNumber;
    private String mission;
    private String releaseWhen;
    private Master master;
	public Integer getMissionId() {
		return missionId;
	}
	public void setMissionId(Integer missionId) {
		this.missionId = missionId;
	}
	public String getStuClassNumber() {
		return stuClassNumber;
	}
	public void setStuClassNumber(String stuClassNumber) {
		this.stuClassNumber = stuClassNumber;
	}
	public String getMission() {
		return mission;
	}
	public void setMission(String mission) {
		this.mission = mission;
	}
	public String getReleaseWhen() {
		return releaseWhen;
	}
	public void setReleaseWhen(String releaseWhen) {
		this.releaseWhen = releaseWhen;
	}
	public Master getMaster() {
		return master;
	}
	public void setMaster(Master master) {
		this.master = master;
	}

}
