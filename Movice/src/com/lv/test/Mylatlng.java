package com.lv.test;

import com.baidu.mapapi.model.LatLng;

public class Mylatlng {
	private static LatLng Me=null;
	public static void setMylantlng(Double lng ,Double  lan){
		//LatLng(double latitude, double longitude)
		Me=new LatLng(lan,  lng);
		
	}
	public static LatLng getMylantlng(){
		return Me;
		
	}

}
