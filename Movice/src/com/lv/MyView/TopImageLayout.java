package com.lv.MyView;

import com.lv.movice.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TopImageLayout extends LinearLayout {
	private ImageView imageview;
	private TextView textview;
	public TopImageLayout(Context context) {
		super(context);
		init(context);
	}

	public TopImageLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
		//ͨ��context���ص� �Լ�д��styleable
		TypedArray typedArray=context.obtainStyledAttributes(attrs, R.styleable.TopImageview_attrs);
		//ͨ��styleable ��id ȥȡ����
		String text=typedArray.getString(R.styleable.TopImageview_attrs_text);
		Drawable drawable=typedArray.getDrawable(R.styleable.TopImageview_attrs_src);
		imageview.setImageDrawable(drawable);
		textview.setText(text);
	}
	public void init(Context context){
		//�ȳ�ʼ���ؼ�
		//����values���潨attrs.xml
		View.inflate(context, R.layout.topimage_layout, this);
		imageview=(ImageView) this.findViewById(R.id.topimage);
		textview=(TextView) this.findViewById(R.id.belowtext);
		
	}

}
