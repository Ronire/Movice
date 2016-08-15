package com.lv.activity;

import java.util.ArrayList;
import java.util.List;

import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.LocationClientOption.LocationMode;
import com.lv.BDListener.MyBDListener;
import com.lv.Fragment.CinemaFragment;
import com.lv.Fragment.FindFragment;
import com.lv.Fragment.MeFragment;
import com.lv.Fragment.MoviceFragment;
import com.lv.movice.R;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ClientActivity extends FragmentActivity implements OnClickListener {
	// 用于百度地图定位
	private LocationClient client;
	private BDLocationListener listener;

	private TextView Tv_movice, Tv_cinema, Tv_find, Tv_me;
	private List<TextView> Tv_list = new ArrayList<TextView>();
	private List<Fragment> Fragmentlist = new ArrayList<Fragment>();
	private FragmentManager fragmentmanager;
	private ActionBar actionbar;
	private TextView centertv;
	private View view;
	private View v;
	private RelativeLayout citylayout;
	private TextView Tv_city;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	   //初始化百度地图
		//SDKInitializer.initialize(getApplicationContext());
		setContentView(R.layout.activity_client);
		
		//initDB();
		
		// 设置actionbar
		actionbar = getActionBar();
		actionbar.setDisplayShowHomeEnabled(false);
		actionbar.setDisplayShowCustomEnabled(true);
		actionbar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		v = inflater.inflate(R.layout.actionbar_layout, null, false);
		// view = inflater.inflate(R.layout.actionbar_me_layout, null, false);
		centertv = (TextView) v.findViewById(R.id.centertv);
		citylayout=(RelativeLayout) v.findViewById(R.id.citylayout);
		Tv_city=(TextView) v.findViewById(R.id.city);
		citylayout.setOnClickListener(this);
		actionbar.setCustomView(v);

		initview();

	}

	public void initDB() {
		client = new LocationClient(this);
		LocationClientOption option = new LocationClientOption();
		option.setLocationMode(LocationMode.Battery_Saving);
		client.setLocOption(option);
		listener = new MyBDListener();
		client.registerLocationListener(listener);
		client.start();
	}

	public void initview() {
		// ��ʼ��FragmentManager
		fragmentmanager = getSupportFragmentManager();

		// ��ʼ��Fragment
		MoviceFragment moviceFragment = new MoviceFragment();
		CinemaFragment cinemaFragment = new CinemaFragment();
		FindFragment findFragment = new FindFragment();
		MeFragment meFragment = new MeFragment();
		// ��Fragment��ӵ�������
		Fragmentlist.add(moviceFragment);
		Fragmentlist.add(cinemaFragment);
		Fragmentlist.add(findFragment);
		Fragmentlist.add(meFragment);
		// ��ʼ��TextView
		Tv_movice = (TextView) findViewById(R.id.Tv_movice);
		Tv_movice.setSelected(true);
		Tv_movice.setTextColor(Color.rgb(231, 51, 26));
		Tv_cinema = (TextView) findViewById(R.id.Tv_cinema);
		Tv_find = (TextView) findViewById(R.id.Tv_find);
		Tv_me = (TextView) findViewById(R.id.Tv_me);
		// ��TextView��ӵ�������
		Tv_list.add(Tv_movice);
		Tv_list.add(Tv_cinema);
		Tv_list.add(Tv_find);
		Tv_list.add(Tv_me);
		// Ϊtextview���õ���¼�
		Tv_movice.setOnClickListener(this);
		Tv_cinema.setOnClickListener(this);
		Tv_find.setOnClickListener(this);
		Tv_me.setOnClickListener(this);
		FragmentTransaction f = fragmentmanager.beginTransaction();
		f.add(R.id.toplayout, Fragmentlist.get(0));
		f.add(R.id.toplayout, Fragmentlist.get(1));
		f.add(R.id.toplayout, Fragmentlist.get(2));
		f.add(R.id.toplayout, Fragmentlist.get(3));

		f.show(Fragmentlist.get(0));
		f.hide(Fragmentlist.get(1));
		f.hide(Fragmentlist.get(2));
		f.hide(Fragmentlist.get(3));
		f.commit();
	}

	public void clear() {
		for (int i = 0; i < Tv_list.size(); i++) {
			Tv_list.get(i).setSelected(false);
			Tv_list.get(i).setTextColor(Color.rgb(135, 133, 133));
		}
	}

	public void ChangeTextView(View v) {
		clear();
		TextView tv = (TextView) v;
		tv.setSelected(true);
		tv.setTextColor(Color.rgb(231, 51, 26));

	}

	public void switchFragment(Fragment fragment, FragmentTransaction tf) {
		if (fragment.isHidden()) {
			for (Fragment f : Fragmentlist) {
				if (!f.isHidden()) {
					tf.hide(f);
				}
			}
			tf.show(fragment);
		}
	}

	@Override
	public void onClick(View v) {
		FragmentTransaction ft = fragmentmanager.beginTransaction();
		switch (v.getId()) {
		case R.id.Tv_movice:
			ChangeTextView(v);
			switchFragment(Fragmentlist.get(0), ft);
			centertv.setText("电影");
			actionbar.show();
			break;
		case R.id.Tv_cinema:
			ChangeTextView(v);
			switchFragment(Fragmentlist.get(1), ft);
			centertv.setText("影院");
			actionbar.show();

			break;
		case R.id.Tv_find:
			ChangeTextView(v);
			switchFragment(Fragmentlist.get(2), ft);
			centertv.setText("发现");
			actionbar.show();

			break;
		case R.id.Tv_me:
			ChangeTextView(v);

			actionbar.hide();

			// ft.replace(R.id.toplayout, Fragmentlist.get(3));
			switchFragment(Fragmentlist.get(3), ft);

			break;
		case R.id.citylayout:
			
			Intent intent=new Intent(this, ChoiceActivity.class);
		 
			startActivityForResult(intent, 0x001);
			break;

		default:
			break;
		}
		ft.commit();

	}
	@Override
	protected void onActivityResult(int requestcode, int resultcode, Intent intent) {
		
		if(requestcode==0x001&&resultcode==0x002){
			String city=intent.getStringExtra("city");
			Tv_city.setText(city);
			((CinemaFragment)Fragmentlist.get(1)).changecity(city);
		}
	}

}
