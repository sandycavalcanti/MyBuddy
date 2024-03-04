package com.example.app_my_buddy;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Tela07 extends Activity {

	Bundle codigo = new Bundle();
	UsuarioDAO db = new UsuarioDAO(this);
	String cnome, ccpf, ctelefone, cemail, csenha;
	int id;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_tela07);

		final EditText nome = (EditText) findViewById(R.id.editText1);
		final EditText cpf = (EditText) findViewById(R.id.editText2);
		final EditText telefone = (EditText) findViewById(R.id.editText3);
		final EditText email = (EditText) findViewById(R.id.editText4);
		final EditText senha = (EditText) findViewById(R.id.editText5);
		final Button btn = (Button) findViewById(R.id.button1);
		final TextView lbl = (TextView) findViewById(R.id.textView1);

		// Font
		Typeface regencie = Typeface.createFromAsset(getAssets(), "regencie1.ttf");
		Typeface font = Typeface.createFromAsset(getAssets(), "lemonmelon.ttf");
		lbl.setTypeface(font);
		btn.setTypeface(font);
		nome.setTypeface(regencie);
		cpf.setTypeface(regencie);
		telefone.setTypeface(regencie);
		email.setTypeface(regencie);
		senha.setTypeface(regencie);

		btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {

				cnome = nome.getText().toString();
				ccpf = cpf.getText().toString();
				ctelefone = telefone.getText().toString();
				cemail = email.getText().toString();
				csenha = senha.getText().toString();

				if (cnome.equals("") || ccpf.equals("") || ctelefone.equals("") || cemail.equals("") || csenha.equals("")) {
					Toast.makeText(Tela07.this, "Complete todos os campos", Toast.LENGTH_SHORT).show();
				} else {
					Usuarios a = new Usuarios();

					a.setNome(nome.getText().toString());
					a.setCpf(Integer.parseInt(cpf.getText().toString()));
					a.setTelefone(Integer.parseInt(telefone.getText().toString()));
					a.setEmail(email.getText().toString());
					a.setSenha(senha.getText().toString());
					
					db.salvar_usuario(a);
					
					AlertDialog.Builder alerta = new AlertDialog.Builder(Tela07.this);
					alerta.setTitle("Seu cadastro foi realizado com sucesso!!");
					alerta.setNeutralButton("Ir para o menu", new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface arg0, int arg1) {

									codigo.putInt("valor", 1);
									Intent it1 = new Intent(Tela07.this, Tela02.class);
									it1.putExtras(codigo);
									startActivity(it1);

								}
							});
					alerta.show();

				}
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela07, menu);
		return true;
	}

}
