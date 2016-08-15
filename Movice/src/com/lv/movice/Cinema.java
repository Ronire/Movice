package com.lv.movice;

public class Cinema {
	private String name;
	private Location location;
	private String address;
	private String price;
	private String comment_num;
	private String detial_url;
	private Double distance;
	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "影院名："+name+"\n"+"地址："+address+"\n"+location.toString()
		+"\n"  +"价格："+price+"\n"+"点赞数："+comment_num+"\n"+"详细信息url:"+detial_url+"\n"
		+"距离:"+distance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getComment_num() {
		return comment_num;
	}

	public void setComment_num(String comment_num) {
		this.comment_num = comment_num;
	}

	public String getDetial_url() {
		return detial_url;
	}

	public void setDetial_url(String detial_url) {
		this.detial_url = detial_url;
	}

}
