package com.example.app_my_buddy;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Tela11 extends Activity {

	ArrayList<String> arrayList;
	UsuarioDAO db = new UsuarioDAO(this);
	String senha_cad, email_cad, login_us, senha_us;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_tela11);

		final TextView sem_conta = (TextView) findViewById(R.id.textView4);
		final Button entrar_conta = (Button) findViewById(R.id.button1);
		final Button entrar_adm = (Button) findViewById(R.id.button2);
		final EditText login_usuario = (EditText) findViewById(R.id.editText1);
		final EditText senha_usuario = (EditText) findViewById(R.id.editText2);
		// final EditText login_adm = (EditText) findViewById(R.id.editText3);
		// final EditText senha_adm = (EditText) findViewById(R.id.editText4);

		sem_conta.setOnClickListener(new TextView.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Tela11.this, Tela07.class);
				startActivity(intent);
				finish();
			}
		});

		entrar_conta.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {

				List<Usuarios> usuarios = db.listaUsuario();
				arrayList = new ArrayList<String>();
				
				login_us = login_usuario.getText().toString();
				senha_us = senha_usuario.getText().toString();

				for (Usuarios a : usuarios) {

					email_cad = a.getEmail().toString();
					senha_cad = a.getSenha().toString();
					
					
					if (login_us.equals(email_cad) && senha_us.equals(senha_cad)) {

						Intent intent = new Intent(Tela11.this, Tela02.class);
						startActivity(intent);
						finish();
						
					} else {

						AlertDialog.Builder alerta = new AlertDialog.Builder(Tela11.this);
						alerta.setTitle("Login ou senha invalidos");
						alerta.setMessage("Por favor tente novamente.");
						alerta.setNeutralButton("Ok", null);
						alerta.show();

					}
					
					Toast.makeText(getApplicationContext(), email_cad, Toast.LENGTH_SHORT).show();
				}

			}

		});

		entrar_adm.setOnClickListener(new TextView.OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Intent intent = new Intent(Tela11.this, Tela12.class);
				startActivity(intent);
				finish();

				// if (login_adm.equals("adm123") && senha_adm.equals("54321"))
				// {
				//
				// Intent intent = new Intent(Tela11.this, Tela02.class);
				// startActivity(intent);
				// finish();
				//
				// } else {
				//
				// AlertDialog.Builder alerta = new
				// AlertDialog.Builder(Tela11.this);
				// alerta.setTitle("Login ou senha invalidos");
				// alerta.setMessage("Por favor tente novamente.");
				// alerta.setNeutralButton("Ok", null);
				// alerta.show();
				// }
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela11, menu);
		return true;
	}

}
