package cn.ssh.entity;

public class Love {
//	loveId: 主键（自动增长）
//	fromStuName: 表白人姓名  toName: 被表白人姓名
//	loveContent: 表白内容  loveResult: 表白结果（成功上墙还是被过滤）
//	loveReason: 表白失败原因
//	stuId: 表白人学号（外键）
	private Integer loveId;
	private String fromStuName;
	private String toName;
	private String loveContent;
	private String loveResult;
	private String loveReason;
	private String stuNumber;
	public String getStuNumber() {
		return stuNumber;
	}
	public void setStuNumber(String stuNumber) {
		this.stuNumber = stuNumber;
	}
	public Integer getLoveId() {
		return loveId;
	}
	public void setLoveId(Integer loveId) {
		this.loveId = loveId;
	}
	public String getFromStuName() {
		return fromStuName;
	}
	public void setFromStuName(String fromStuName) {
		this.fromStuName = fromStuName;
	}
	public String getToName() {
		return toName;
	}
	public void setToName(String toName) {
		this.toName = toName;
	}
	public String getLoveContent() {
		return loveContent;
	}
	public void setLoveContent(String loveContent) {
		this.loveContent = loveContent;
	}
	public String getLoveResult() {
		return loveResult;
	}
	public void setLoveResult(String loveResult) {
		this.loveResult = loveResult;
	}
	public String getLoveReason() {
		return loveReason;
	}
	public void setLoveReason(String loveReason) {
		this.loveReason = loveReason;
	}
	

}
