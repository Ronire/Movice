package com.lv.myadapter;

import java.util.List;

import com.lv.movice.Movice;
import com.lv.movice.R;
import com.lv.smartview.SmartImageView;
import com.lv.untils.ViewHolder;

import android.content.Context;
import android.widget.TextView;

public class Myadapter extends CommonAdapter<Movice>{

	public Myadapter(Context context, List<Movice> data, int resId) {
		super(context, data, resId);
	}

	@Override
	public void setviewcontent(ViewHolder holder, Object object) {
		Movice m=(Movice)object;
		((SmartImageView)holder.getView(R.id.Im_movice)).setImageUrl(m.getImage());
		((TextView)holder.getView(R.id.Tv_movice)).setText(m.getTitle());
		((TextView)holder.getView(R.id.grade)).setText(m.getGrade()+" "+"分数");
		((TextView)holder.getView(R.id.Tv_detial)).setText(m.getDetial());
		((TextView)holder.getView(R.id.date)).setText(m.getDate());
		
	}

}
