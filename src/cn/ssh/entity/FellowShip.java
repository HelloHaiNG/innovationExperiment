package cn.ssh.entity;

public class FellowShip {
//	fesId: 主键（自动增长）
//	fromMasNumber: 发起教官学号   toMasNumber: 受邀教官学号
//	fesWhen: 联谊时间   fesContent: 联谊内容
//	fesResult: 联谊结果   fesReason: 拒绝原因
    private Integer fesId;
    private String fromMasNumber;
    private String toMasNumber;
    private String fesWhen;
    private String fesContent;
    private String fesResult;
    private String fesReason;
	public Integer getFesId() {
		return fesId;
	}
	public void setFesId(Integer fesId) {
		this.fesId = fesId;
	}
	public String getFromMasNumber() {
		return fromMasNumber;
	}
	public void setFromMasNumber(String fromMasNumber) {
		this.fromMasNumber = fromMasNumber;
	}
	public String getToMasNumber() {
		return toMasNumber;
	}
	public void setToMasNumber(String toMasNumber) {
		this.toMasNumber = toMasNumber;
	}
	public String getFesWhen() {
		return fesWhen;
	}
	public void setFesWhen(String fesWhen) {
		this.fesWhen = fesWhen;
	}
	public String getFesContent() {
		return fesContent;
	}
	public void setFesContent(String fesContent) {
		this.fesContent = fesContent;
	}
	public String getFesResult() {
		return fesResult;
	}
	public void setFesResult(String fesResult) {
		this.fesResult = fesResult;
	}
	public String getFesReason() {
		return fesReason;
	}
	public void setFesReason(String fesReason) {
		this.fesReason = fesReason;
	}

}
