package com.example.app_my_buddy;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class Tela05 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_tela05);
		
		final TextView titulo = (TextView) findViewById(R.id.textView4);
		final TextView texto1 = (TextView) findViewById(R.id.textView1);
		final TextView texto2 = (TextView) findViewById(R.id.textView2);
		final TextView texto3 = (TextView) findViewById(R.id.textView3);
		final TextView texto4 = (TextView) findViewById(R.id.textView5);
		Typeface font = Typeface.createFromAsset(getAssets(), "lemonmelon.ttf");
		titulo.setTypeface(font);
		texto1.setTypeface(font);
		texto2.setTypeface(font);
		texto3.setTypeface(font);
		texto4.setTypeface(font);
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela05, menu);
		return true;
	}

}
