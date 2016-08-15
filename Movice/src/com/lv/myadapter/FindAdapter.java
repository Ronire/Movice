package com.lv.myadapter;

import java.util.List;

import com.lv.movice.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class FindAdapter extends BaseAdapter{
	private List<String> data;
	private LayoutInflater inflater;
	public FindAdapter(List<String> data,Context context) {
		this.data=data;
		inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
	}

	@Override
	public int getCount() {
		
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v;
		if(convertView!=null){
			v=convertView;
			
		}
		else {
			v=inflater.inflate(R.layout.find_item, parent,false);
		
			TextView tv=(TextView) v.findViewById(R.id.tt);
			tv.setText(data.get(position));
		}
		return v;
	}

}
