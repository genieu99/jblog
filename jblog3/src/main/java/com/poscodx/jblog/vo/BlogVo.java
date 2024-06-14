package com.poscodx.jblog.vo;

public class BlogVo {
	private String no;
	private String title;
	private String logo;
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	@Override
	public String toString() {
		return "BlogVo [no=" + no + ", title=" + title + ", logo=" + logo + "]";
	}
}
