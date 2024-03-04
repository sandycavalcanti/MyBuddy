package com.example.app_my_buddy;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Tela14 extends Activity {

	UsuarioDAO db = new UsuarioDAO(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_tela14);

		final EditText nome = (EditText) findViewById(R.id.editText1);
		final EditText cpf = (EditText) findViewById(R.id.editText2);
		final EditText telefone = (EditText) findViewById(R.id.editText3);
		final EditText email = (EditText) findViewById(R.id.editText4);
		final EditText senha = (EditText) findViewById(R.id.editText5);
		final EditText animal_nome = (EditText) findViewById(R.id.editText6);
		final EditText descricao = (EditText) findViewById(R.id.editText7);
		final RadioGroup moradia = (RadioGroup) findViewById(R.id.radioGroup1);
		final RadioGroup quant_pes = (RadioGroup) findViewById(R.id.radioGroup2);
		final Button adotar = (Button) findViewById(R.id.button1);

		try {
			Bundle dados = getIntent().getExtras();
			String nomein = dados.getString("nome");
			animal_nome.setText(nomein);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		adotar.setOnClickListener(new Button.OnClickListener() {

			// Verificar se todos os campos estão preenchidos

			// String u_desc = descricao.getText().toString();
			// String u_email = email.getText().toString();
			// String u_senha = senha.getText().toString();
			// String u_cpf = cpf.getText().toString();
			// String u_tel = telefone.getText().toString();
			// String u_nome = nome.getText().toString();

			// if( u_nome.equals("") || u_desc.equals("") || u_email.equals("")
			// || u_senha.equals("") || u_tel.equals("") || u_cpf.equals("")
			// ||casa == null || pessoas == 0 || descricao.equals("")){
			// Toast.makeText(Tela14.this, "Complete todos os campos",
			// Toast.LENGTH_SHORT).show();
			// } else{
			// Cadastrar
			// Usuarios a = new Usuarios();
			// a.setNome(nome.getText().toString());
			// a.setCpf(cpf.getText().toString());
			// a.setTelefone(telefone.getText().toString());
			// a.setEmail(email.getText().toString());
			// a.setResidencia(casa);
			// a.setQuant_pes_casa(pessoas);
			// a.setSenha(senha.getText().toString());
			// a.setDescricao(descricao.getText().toString());
			// db = new MyBuddyDAO(Tela14.this);
			// db.salvar_usuario(a);

			// Toast.makeText(Tela14.this, "Cadastrado",
			// Toast.LENGTH_SHORT).show();
			// }

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Usuarios a = new Usuarios();
				a.setNome(nome.getText().toString());
				a.setEmail(email.getText().toString());
				a.setSenha(senha.getText().toString());
				a.setDescricao(descricao.getText().toString());
				db = new UsuarioDAO(Tela14.this);
				db.salvar_usuario(a);
				Toast.makeText(Tela14.this, "Cadastrado", Toast.LENGTH_SHORT)
						.show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela14, menu);
		return true;
	}

}
