package com.lv.movice;

public class Movice {
	private String title;
	private String image;
	private String detial;
	private String date;
	private String grade;
	private String playurl;
	public String getPlayurl() {
		return playurl;
	}
	public void setPlayurl(String playurl) {
		this.playurl = playurl;
	}
	@Override
	public String toString() {
		
		return "电影名："+title +"\n"+"介绍："+detial+"\n"+"上映日期："+date+"\n"+"评分："+grade+"\n"+"图片地址："+image+"\n";
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDetial() {
		return detial;
	}
	public void setDetial(String detial) {
		this.detial = detial;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	

}
