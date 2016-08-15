package com.lv.Fragment;

import java.util.ArrayList;
import java.util.List;

import com.lv.movice.MoviceDetialActivity;
import com.lv.movice.R;
import com.lv.myadapter.FindAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

public class FindFragment extends Fragment implements OnClickListener {
	private GridView type;
	private GridView country;
	private String[] typedata = { "剧情", "喜剧", "爱情", "动画", "动作", "恐怖", "惊悚", "悬疑", "冒险", "科幻", "犯罪", "战争", "纪录片", "其他" };
	private String[] countrydata = { "大陆", "美国", "法国", "英国", "日本", "韩国", "印度", "泰国", "港台", "德国", "其他" };
	private List<String> typelist = new ArrayList<>();
	private List<String> countrylist = new ArrayList<>();
	private TextView m1, m2, m3;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.find_layout, container, false);
		init();
		type = (GridView) view.findViewById(R.id.movicetype);
		country = (GridView) view.findViewById(R.id.country);
		type.setAdapter(new FindAdapter(typelist, getActivity()));
		country.setAdapter(new FindAdapter(countrylist, getActivity()));
		initview(view);

		return view;
	}

	public void initview(View view) {
		m1 = (TextView) view.findViewById(R.id.m1);
		m2 = (TextView) view.findViewById(R.id.m2);
		m3 = (TextView) view.findViewById(R.id.m3);
		m1.setOnClickListener(this);
		m2.setOnClickListener(this);
		m3.setOnClickListener(this);
	}

	public void init() {
		for (int i = 0; i < typedata.length; i++) {
			typelist.add(typedata[i]);
		}
		for (int i = 0; i < countrydata.length; i++) {
			countrylist.add(countrydata[i]);
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.m1:
			movicedetial(m1.getText().toString());

			break;
		case R.id.m2:
			movicedetial(m2.getText().toString());

			break;
		case R.id.m3:
			movicedetial(m3.getText().toString());

			break;

		default:
			break;
		}

	}

	public void movicedetial(String name) {
		Intent intent=new Intent(getActivity(),MoviceDetialActivity.class);		
		intent.putExtra("name", name);
		startActivity(intent);
	}

}
