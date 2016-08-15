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
		//通过context加载到 自己写的styleable
		TypedArray typedArray=context.obtainStyledAttributes(attrs, R.styleable.TopImageview_attrs);
		//通过styleable 的id 去取属性
		String text=typedArray.getString(R.styleable.TopImageview_attrs_text);
		Drawable drawable=typedArray.getDrawable(R.styleable.TopImageview_attrs_src);
		imageview.setImageDrawable(drawable);
		textview.setText(text);
	}
	public void init(Context context){
		//先初始化控件
		//再在values下面建attrs.xml
		View.inflate(context, R.layout.topimage_layout, this);
		imageview=(ImageView) this.findViewById(R.id.topimage);
		textview=(TextView) this.findViewById(R.id.belowtext);
		
	}

}
