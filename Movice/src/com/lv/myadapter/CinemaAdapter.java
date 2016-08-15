package com.lv.myadapter;

import java.util.List;

import com.lv.movice.Cinema;
import com.lv.movice.R;
import com.lv.untils.ViewHolder;

import android.content.Context;
import android.widget.TextView;

public class CinemaAdapter extends CommonAdapter<Cinema>{

	public CinemaAdapter(Context context, List<Cinema> data, int resId) {
		super(context, data, resId);
	}

	@Override
	public void setviewcontent(ViewHolder holder, Object object) {
		Cinema cinema=(Cinema)object;
		((TextView)holder.getView(R.id.Tv_cinemaname)).setText(cinema.getName());
		((TextView)holder.getView(R.id.cinemaprice)).setText(cinema.getPrice()+" "+"元");
		((TextView)holder.getView(R.id.Tv_cinemaaddress)).setText(cinema.getAddress());
		//((TextView)holder.getView(R.id.distance)).setText(cinema.getDistance().toString());
		
	}

}
