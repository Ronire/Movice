package com.lv.movice;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import com.lv.smartview.SmartImageView;
import com.lv.test.LoadMoviceDetial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class MoviceDetialActivity extends Activity {
	private String name;
	private MoviceDetial movice;
	private SmartImageView image;
	private TextView title;
	private TextView tag;
	private TextView area;
	private TextView year;
	// private TextView desc;

	Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			if (msg.what == 0x001) {
				System.out.println(movice.toString());
				image.setImageUrl(movice.getImage());
				title.setText(movice.getName());
				tag.setText(movice.getTag());
				area.setText(movice.getArea());
				year.setText(movice.getYear());

			}
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_movice_detial);
		initview();
		Intent intent = getIntent();
		name = intent.getStringExtra("name");
		new Thread() {
			public void run() {
				movice = LoadMoviceDetial.loadmovicedetial(name);
				handler.sendEmptyMessage(0x001);

			};
		}.start();

	}

	public void initview() {
		image = (SmartImageView) findViewById(R.id.haibao);
		title = (TextView) findViewById(R.id.title);

		tag = (TextView) findViewById(R.id.tag);
		area = (TextView) findViewById(R.id.area);
		year = (TextView) findViewById(R.id.year);

	}

}
