package com.lv.movice;

public class Location {
	private Double lat;
	private Double lng;

	@Override
	public String toString() {
		return "经度："+lng+"维度："+lat;
	}
	public Location(Double lat, Double lag) {
		super();
		this.lat = lat;
		this.lng = lag;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public Double getLag() {
		return lng;
	}
	public void setLag(Double lng) {
		this.lng = lng;
	}
	

}
