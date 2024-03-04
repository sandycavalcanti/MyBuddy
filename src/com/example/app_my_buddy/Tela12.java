package com.example.app_my_buddy;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class Tela12 extends Activity {
	
	Bundle valor = new Bundle();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_tela12);
		
		final Button g_animais = (Button) findViewById(R.id.button1);
		final Button g_produtos = (Button) findViewById(R.id.button2);
		final Button g_adocao = (Button) findViewById(R.id.button3);
		final Button sair = (Button) findViewById(R.id.button4);

		g_animais.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {

				valor.putInt("usuario", 1);
				Intent it = new Intent(Tela12.this, Tela04.class);
				it.putExtras(valor);
				startActivity(it);
				
			}
		});
		
		g_produtos.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View arg0) {

				valor.putInt("valor", 2);
				Intent it = new Intent(Tela12.this, Tela06.class);
				it.putExtras(valor);
				startActivity(it);

			}
		});

		g_adocao.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Intent it = new Intent(Tela12.this, Tela15.class);
				startActivity(it);

			}
		});
		
		sair.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Intent it = new Intent(Tela12.this, Tela11.class);
				startActivity(it);

			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela12, menu);
		return true;
	}

}
