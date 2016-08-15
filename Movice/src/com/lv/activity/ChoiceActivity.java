package com.lv.activity;

import java.util.ArrayList;
import java.util.List;

import com.lv.movice.R;
import com.lv.myadapter.FindAdapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.TextView;

public class ChoiceActivity extends Activity {
	private GridView city;
	private String[] c={"上海","北京","广州","南京","南昌","杭州","赣州",
			               "成都","长沙","苏州"};
	
	private List<String> list=new ArrayList<>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choice);
		city=(GridView) findViewById(R.id.city);
		for(int i=0;i<c.length;i++){
			list.add(c[i]);
		}
		city.setAdapter(new FindAdapter(list, this));
		city.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				             TextView tv=(TextView) view.findViewById(R.id.tt);				             
				             Intent intent =getIntent();
				             intent.putExtra("city", tv.getText().toString());
				             ChoiceActivity.this.setResult(0x002, intent);
				             ChoiceActivity.this.finish();
				             
				             
			}
		});
		
	}


}
