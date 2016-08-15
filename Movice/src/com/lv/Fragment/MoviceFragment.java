package com.lv.Fragment;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.lv.activity.WebActivity;
import com.lv.movice.Movice;
import com.lv.movice.R;
import com.lv.myadapter.Myadapter;
import com.lv.test.HtttpUntil;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MoviceFragment extends Fragment{
	private List<JSONObject> jslist = new ArrayList<JSONObject>();
	private List<JSONObject> jslist2 = new ArrayList<JSONObject>();
	private List<Movice> onshowlist=new ArrayList<>();
	private List<Movice> willshowlist=new ArrayList<>();
	private List<Movice> data=new ArrayList<>();
	
private ListView list;
	
	Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			if (msg.what == 0x001) {
				
				
		
			
			list.setAdapter(new Myadapter(getContext(), data, R.layout.movice_item));
			list.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					                  System.out.println("点击的是："+data.get(position).getTitle());
					            Intent intent=new Intent(getActivity(),WebActivity.class);
					            intent.putExtra("url", data.get(position).getPlayurl()+"trailer.html");
					                  startActivity(intent );
				}
			});
			
			
				

			}
		};
	};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		       View view=inflater.inflate(R.layout.movice_layout, container,false);
		       list=(ListView) view.findViewById(R.id.movice_list);
		       
		       loadmovice("南昌");
		       
		return view;
	}
	
	public void loadmovice(final String cityname){      
		new Thread() {
			public void run() {
				String result = HtttpUntil.getRequest2(cityname);
				try {
					JSONObject jsonobject = new JSONObject(result);
					JSONObject Jsonresult = jsonobject.getJSONObject("result");
					//最外层数据
					JSONArray array = Jsonresult.getJSONArray("data");
					// 判断是正在上映还是即将上映
					for (int i = 0; i < array.length(); i++) {
						String type = ((JSONObject) array.get(i)).getString("name");
						switch (type) {
						case "正在上映":
							JSONArray onshowmovice = ((JSONObject) array.get(i)).getJSONArray("data");
							for (int j = 0; j < onshowmovice.length(); j++) {
								JSONObject object = onshowmovice.getJSONObject(j);
								jslist.add(object);
							}
							for (int k = 0; k < jslist.size(); k++) {

								Movice m = new Movice();
								JSONObject movicedata = jslist.get(k);
								m.setTitle(movicedata.getString("tvTitle"));
								m.setGrade(movicedata.getString("grade"));
								m.setDate(movicedata.getJSONObject("playDate").getString("data2"));
								m.setDetial(movicedata.getJSONObject("story").getJSONObject("data")
										.getString("storyBrief"));
								m.setImage(movicedata.getString("iconaddress"));
								m.setPlayurl(movicedata.getString("iconlinkUrl"));
								onshowlist.add(m);
								data.add(m);
								
								
								
								
							}

							break;
						case "即将上映":
							JSONArray willshowmovice = ((JSONObject) array.get(i)).getJSONArray("data");
							for (int j = 0; j < willshowmovice.length(); j++) {
								JSONObject object = willshowmovice.getJSONObject(j);
								jslist2.add(object);
							}

							for (int k = 0; k < jslist2.size(); k++) {
								Movice m = new Movice();
								JSONObject movicedata = jslist2.get(k);
								m.setTitle(movicedata.getString("tvTitle"));
								//m.setGrade(movicedata.getString("grade"));
								m.setDate(movicedata.getJSONObject("playDate").getString("data2"));
								m.setDetial(movicedata.getJSONObject("story").getJSONObject("data")
										.getString("storyBrief"));
								m.setImage(movicedata.getString("iconaddress"));
								m.setPlayurl(movicedata.getString("iconlinkUrl"));
								willshowlist.add(m);
								data.add(m);
								

							}

							break;

						default:
							break;
						}

					}

					
					for(Movice m:onshowlist){
						System.out.println(m.toString());
					}
					for(Movice m:willshowlist){
						System.out.println(m.toString());
					}

				} catch (Exception e) {

					e.printStackTrace();
				}

				Message msg = Message.obtain();
				
				msg.what = 0x001;
				handler.sendMessage(msg);
				

			};
		}.start();
	
	}

}
