package com.example.app_my_buddy;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class Tela08 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_tela08);
		
		final Button doar = (Button) findViewById(R.id.button1);
		
		doar.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {

				AlertDialog.Builder alerta = new AlertDialog.Builder(Tela08.this);
				alerta.setTitle("Sua doação foi realizada com sucesso!!");
				alerta.setMessage("Obrigado por nos ajudar a continuar mudando vidas  <3");
				alerta.setNeutralButton("Voltar ao menu", 
						new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						
						Intent it = new Intent(Tela08.this, Tela02.class);
						startActivity(it);
						
					}
				});
				alerta.show();
				
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela08, menu);
		return true;
	}

}
