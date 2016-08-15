package com.lv.movice;

import android.graphics.Bitmap;

public class MoviceDetial {
	private String name;
	private String image;
	private String rating;
	private String dir;
	private String act;
	private String dital;
	private String area;
	private String year;
	private String tag;
	private Bitmap bitmap;
	public Bitmap getBitmap() {
		return bitmap;
	}

	public void setBitmap(Bitmap bitmap) {
		this.bitmap = bitmap;
	}

	@Override
	public String toString() {
		return "name:"+name+"\n"+"image:"+image+"\n"+"rating:"+rating+"\n"+
	"dir:"+dir+"\n"+"act:"+act+"\n"+"dital:"+dital+"\n"+"area:"+area+"\n"+
				"year:"+year+"\n"+"tag:"+tag+"\n";
	}
	
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public String getAct() {
		return act;
	}
	public void setAct(String act) {
		this.act = act;
	}
	public String getDital() {
		return dital;
	}
	public void setDital(String dital) {
		this.dital = dital;
	}
	

}
