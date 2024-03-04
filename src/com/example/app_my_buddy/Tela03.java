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

public class Tela03 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_tela03);
		
		final TextView titulo = (TextView) findViewById(R.id.textView2);
		final TextView texto_parte1 = (TextView) findViewById(R.id.textView1);
		final TextView texto_parte2 = (TextView) findViewById(R.id.textView4);
		final TextView texto_parte3 = (TextView) findViewById(R.id.textView3);
		final TextView titulo2 = (TextView) findViewById(R.id.textView5);
		final TextView sub_titulo1 = (TextView) findViewById(R.id.textView6);
		final TextView texto1 = (TextView) findViewById(R.id.textView7);
		final TextView sub_titulo2 = (TextView) findViewById(R.id.textView8);
		final TextView texto2 = (TextView) findViewById(R.id.textView9);
		final Button animais = (Button) findViewById(R.id.button1);
		final Button produtos = (Button) findViewById(R.id.button2);
		final Button oq_e = (Button) findViewById(R.id.button3);
		final Button doacao = (Button) findViewById(R.id.button4);
		final Button home = (Button) findViewById(R.id.button5);
		// Font
		Typeface font = Typeface.createFromAsset(getAssets(), "lemonmelon.ttf");
		titulo.setTypeface(font);
		texto_parte1.setTypeface(font);
		texto_parte2.setTypeface(font);
		texto_parte3.setTypeface(font);
		titulo2.setTypeface(font);
		sub_titulo1.setTypeface(font);
		sub_titulo2.setTypeface(font);
		texto1.setTypeface(font);
		texto2.setTypeface(font);
		animais.setTypeface(font);
		produtos.setTypeface(font);
		oq_e.setTypeface(font);
		doacao.setTypeface(font);
		home.setTypeface(font);
		
		home.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent i1 = new Intent(Tela03.this, Tela02.class);
				startActivity(i1);

			}
		});
		
		animais.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i1=new Intent(Tela03.this,Tela04.class);
				startActivity(i1);
				
			}
		});
		
		produtos.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent i1 = new Intent(Tela03.this, Tela06.class);
				startActivity(i1);

			}
		});

		oq_e.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent i1 = new Intent(Tela03.this, Tela03.class);
				startActivity(i1);

			}
		});

		doacao.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent i1 = new Intent(Tela03.this, Tela05.class);
				startActivity(i1);

			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela03, menu);
		return true;
	}

}
