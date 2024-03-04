package com.example.app_my_buddy;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.Window;
import android.widget.VideoView;

public class Tela01 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_tela01);
        
        Handler handler = new Handler();
	    handler.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				home();	
			}
		},4140);

	    try {
	        VideoView videoHolder = new VideoView(this);
	        setContentView(videoHolder);
	        Uri video = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.splash_video);
	        videoHolder.setVideoURI(video);

	        videoHolder.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
	            public void onCompletion(MediaPlayer mp) {
	                home();
	            }
	        });
	        videoHolder.start();
	    } catch (Exception ex) {
	        home();
	    }
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		home();
		return true;
	}
	
	private void home() {
        Intent intent = new Intent(Tela01.this, Tela02.class);
        startActivity(intent);
        finish();
    }
}