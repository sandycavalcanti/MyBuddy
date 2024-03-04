package com.example.app_my_buddy;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class Tela02 extends Activity {
	
	Bundle id = new Bundle();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_tela02);
		
		final TextView t1= (TextView) findViewById(R.id.textView1);
		final TextView t2= (TextView) findViewById(R.id.textView2);
		final TextView t3= (TextView) findViewById(R.id.textView3);
		final TextView t4= (TextView) findViewById(R.id.textView4);
		final Button adm = (Button) findViewById(R.id.button3);
		
		adm.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i1=new Intent(Tela02.this,Tela12.class);
				startActivity(i1);
				
			}
		});	
		
		t1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i1=new Intent(Tela02.this,Tela03.class);
				startActivity(i1);
				
			}
		});	
		t2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				id.putInt("usuario", 0);
				Intent it = new Intent(Tela02.this, Tela04.class);
				it.putExtras(id);
				startActivity(it);
				
			}
		});
		t3.setOnClickListener(new View.OnClickListener(){
		 
		@Override
		public void onClick(View arg0) {
			Intent i1=new Intent(Tela02.this,Tela08.class);
			startActivity(i1);
			
		 }
	   });
		t4.setOnClickListener(new View.OnClickListener(){

		@Override
		public void onClick(View arg0) {
			id.putInt("valor", 1);
			Intent it = new Intent(Tela02.this, Tela06.class);
			it.putExtras(id);
			startActivity(it);
				
			}
		 });
		 	// Font
		    Typeface font = Typeface.createFromAsset(getAssets(), "lemonmelon.ttf");
			t1.setTypeface(font);
			t2.setTypeface(font);
			t3.setTypeface(font);
			t4.setTypeface(font);
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela02, menu);
		return true;
	}
}
