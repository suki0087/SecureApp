package com.sukriti.secureapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

public class Splash extends Activity {
	MediaPlayer song;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		final MediaPlayer song = MediaPlayer.create(Splash.this, R.raw.ssound);
		song.start();
		Thread timer = new Thread() {
			public void run() {
				try {
					sleep(10100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					song.stop();
					Intent openList = new Intent("android.intent.action.LIST");
					startActivity(openList);
				}
			}

		};
		timer.start();
	}

	@Override
	protected void onPause() {
		
		super.onPause();
		song.release();
		finish();
	}

	
}