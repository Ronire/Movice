package com.lv.Fragment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.baidu.mapapi.SDKInitializer;
import com.lv.movice.Cinema;
import com.lv.movice.R;
import com.lv.myadapter.CinemaAdapter;
import com.lv.test.HtttpUntil;
import com.lv.test.LoadJson;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

public class CinemaFragment extends Fragment implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private List<Cinema> list = new ArrayList<>();
	private ListView cinemalist;
	Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			if (msg.what == 0x001) {

				for (Cinema c : list) {
					System.out.println(c.toString());
					CinemaAdapter adapter = new CinemaAdapter(getActivity(), list, R.layout.cinema_item);
					cinemalist.setAdapter(adapter);

				}
			}
		};
	};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.cinema_layout, container, false);
		cinemalist = (ListView) view.findViewById(R.id.cinemalist);
		new Thread() {
			public void run() {
				LoadJson.loadcinema("南昌", "影院", list);
				Message msg = Message.obtain();
				msg.what = 0x001;
				handler.sendMessage(msg);

			};
		}.start();

		return view;
	}

	public void changecity(final String city) {
		list.clear();
		new Thread() {
			public void run() {
				LoadJson.loadcinema(city, "影院", list);
				Message msg = Message.obtain();
				msg.what = 0x001;
				handler.sendMessage(msg);
			};
		}.start();

		Toast.makeText(getActivity(), "改变城市", 1000).show();
	}

}
