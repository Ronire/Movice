package com.lv.BDListener;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.lv.test.Mylatlng;

import android.util.Log;

public class MyBDListener implements BDLocationListener {
	

	@Override
     public void onReceiveLocation(BDLocation location) {
         //Receive Location
         /*StringBuffer sb = new StringBuffer(256);
         sb.append("time : ");
         sb.append(location.getTime());
         sb.append("\nerror code : ");
         sb.append(location.getLocType());
         sb.append("\nlatitude : ");
         sb.append(location.getLatitude());
         sb.append("\nlontitude : ");
         sb.append(location.getLongitude());
         sb.append("\nradius : ");
         sb.append(location.getRadius());
         if (location.getLocType() == BDLocation.TypeGpsLocation){// GPS定位结果
             sb.append("\nspeed : ");
             sb.append(location.getSpeed());// 单位：公里每小时
             sb.append("\nsatellite : ");
             sb.append(location.getSatelliteNumber());
             sb.append("\nheight : ");
             sb.append(location.getAltitude());// 单位：米
             sb.append("\ndirection : ");
             sb.append(location.getDirection());// 单位度
             sb.append("\naddr : ");
             sb.append(location.getAddrStr());
             sb.append("\ndescribe : ");
             sb.append("gps定位成功");

         } else
         
          
		if (location.getLocType() == BDLocation.TypeNetWorkLocation){
        	  // 网络定位结果
            /* sb.append("\naddr : ");
             sb.append(location.getAddrStr());
             //运营商信息
             sb.append("\noperationers : ");
             sb.append(location.getOperators());
             sb.append("\ndescribe : ");
             sb.append("网络定位成功");
        	  
         } 
         */
	
      Mylatlng.setMylantlng(location.getLongitude(), location.getLatitude());
         System.out.println("定位成功！"+"经度："+location.getLongitude()+"维度："+ location.getLatitude());
	}

}
