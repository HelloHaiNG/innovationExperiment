package cn.ssh.entity;

public class Article {
//	artId: 主键（自动增长）
//	masId: 上传稿件教官的学号（外键）
//	artAuthor: 稿件作者   artTitle: 稿件标题
//	artContent: 稿件内容   artResult: 是否通过
	private Integer artId;
	private String artAuthor;
	private String artTitle;
	private String artContent;
	private String artResult;
	private String masNumber;
	public Integer getArtId() {
		return artId;
	}
	public void setArtId(Integer artId) {
		this.artId = artId;
	}
	public String getArtAuthor() {
		return artAuthor;
	}
	public void setArtAuthor(String artAuthor) {
		this.artAuthor = artAuthor;
	}
	public String getArtTitle() {
		return artTitle;
	}
	public void setArtTitle(String artTitle) {
		this.artTitle = artTitle;
	}
	public String getArtContent() {
		return artContent;
	}
	public void setArtContent(String artContent) {
		this.artContent = artContent;
	}
	public String getArtResult() {
		return artResult;
	}
	public void setArtResult(String artResult) {
		this.artResult = artResult;
	}
	public String getMasNumber() {
		return masNumber;
	}
	public void setMasNumber(String masNumber) {
		this.masNumber = masNumber;
	}


}
