package com.lv.MyView;

import com.lv.movice.R;
import com.lv.movice.R.styleable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TextArrow extends RelativeLayout {
	private TextView Tv_title;
	private TextView Tv_message;
	private ImageView Iv_arrow;
	
	
	public TextArrow(Context context) {
		super(context);
		init(context);
	}

	public TextArrow(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
		TypedArray array=context.obtainStyledAttributes(attrs, R.styleable.TextArrows_attrs);
		String title=array.getString(R.styleable.TextArrows_attrs_title);
		String message=array.getString(R.styleable.TextArrows_attrs_message);
	     Drawable drawable=array.getDrawable(R.styleable.TextArrows_attrs_arrow);
	     Tv_title.setText(title);
	     Tv_message.setText(message);
	     Iv_arrow.setImageDrawable(drawable);
	}
	public void init(Context context){
		View.inflate(context, R.layout.text_arrows_layout, this);
		Tv_title=(TextView) this.findViewById(R.id.Tv_left);
	    Tv_message=(TextView)this.findViewById(R.id.Tv_message);
	    Iv_arrow=(ImageView)this.findViewById(R.id.Im_right);
	    
		
		
	}

}
