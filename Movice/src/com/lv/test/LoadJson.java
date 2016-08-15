package com.lv.test;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.utils.DistanceUtil;
import com.lv.movice.Cinema;
import com.lv.movice.Location;

public class LoadJson {
	public static List<Cinema> loadcinema(String city,String q,List<Cinema> list){
		List<JSONObject> jslist=null;
		Double lng;//经度
		Double lat;//维度
		 try {
			String result=HtttpUntil.nettobaidu(city, q);
			System.out.println(result);
			//获取最外层jsonobject
			JSONObject rootdata=new JSONObject(result);
			JSONArray array=rootdata.getJSONArray("results");
			//获取jsonaray
			jslist=new ArrayList<>();
			for(int i=0;i<array.length();i++){
				jslist.add(array.getJSONObject(i));
			}
			//获取影院jslist
			for(int j=0;j<jslist.size();j++){
				if(j!=2){
					Cinema c=new Cinema();
					c.setName(jslist.get(j).getString("name"));
					c.setAddress(jslist.get(j).getString("address"));
					c.setPrice(jslist.get(j).getJSONObject("detail_info").getString("price"));
					c.setComment_num(jslist.get(j).getJSONObject("detail_info").getString("comment_num"));
				    c.setDetial_url(jslist.get(j).getJSONObject("detail_info").getString("detail_url"));
				     lng=Double.parseDouble(jslist.get(j).getJSONObject("location").getString("lng"));
				    lat=Double.parseDouble(jslist.get(j).getJSONObject("location").getString("lat"));
				    c.setLocation( new Location(lng,lat));
				    //LatLng(double latitude, double longitude)
				    LatLng l=new LatLng(lat, lng);
				    //计算距离
				    Double distance= DistanceUtil.getDistance(Mylatlng.getMylantlng(),l);
				    c.setDistance(distance);
				
				list.add(c);
				}
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		 
		
	}

}
