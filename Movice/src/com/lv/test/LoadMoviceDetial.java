package com.lv.test;

import org.json.JSONException;
import org.json.JSONObject;

import com.lidroid.xutils.BitmapUtils;
import com.lv.movice.MoviceDetial;

import android.graphics.Bitmap;

public class LoadMoviceDetial {
	
	public static MoviceDetial loadmovicedetial(String name){
		MoviceDetial detial=new MoviceDetial();
		String result=HtttpUntil.getRequest1(name);
		try {
			JSONObject rootjson=new JSONObject(result);
			JSONObject movice=rootjson.getJSONObject("result");
			detial.setName(movice.getString("title"));
			detial.setTag(movice.getString("tag"));
			detial.setAct(movice.getString("act"));
			detial.setYear(movice.getString("year"));
			detial.setRating(movice.getString("rating"));
			detial.setArea(movice.getString("area"));
			detial.setDir(movice.getString("dir"));
			detial.setDital(movice.getString("desc"));
			detial.setImage(movice.getString("cover"));	
			
			
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		 
		return detial;
		}
	         
	

}
