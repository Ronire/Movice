package com.lv.activity;

import com.lv.movice.R;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends Activity {
	
	private ImageView back;
	private AnimatorSet animator;
	 

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		back=(ImageView) findViewById(R.id.background);
		animator=(AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.scale);
		animator.setTarget(back);
		
		animator.addListener(new AnimatorListener() {
			
			@Override
			public void onAnimationStart(Animator animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animator animation) {
				
			}
			
			@Override
			public void onAnimationEnd(Animator animation) {
				startActivity(new Intent(MainActivity.this, ClientActivity.class));	
				finish();
			}
			
			@Override
			public void onAnimationCancel(Animator animation) {
				
			}
		});
		animator.start();
	
		
	}

	
}
