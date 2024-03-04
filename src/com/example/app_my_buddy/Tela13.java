package com.example.app_my_buddy;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Tela13 extends Activity {

	ListView lista;
	ArrayAdapter<String> adapter;
	ArrayList<String> arrayList;
	String classe, id;
	RadioButton r1, r2, r3, r4;
	ProdutoDAO db= new ProdutoDAO(this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_tela13);
		
		final EditText nome = (EditText) findViewById(R.id.editText1);
		final EditText preco = (EditText) findViewById(R.id.editText2);
		final RadioGroup categoria = (RadioGroup) findViewById(R.id.radioGroup1);
		r1 = (RadioButton) findViewById(R.id.radio0);
		r2 = (RadioButton) findViewById(R.id.radio1);
		r3 = (RadioButton) findViewById(R.id.radio2);
		r4 = (RadioButton) findViewById(R.id.radio3);
		final Button cadastrar = (Button) findViewById(R.id.button1);
		final Button Alterar = (Button) findViewById(R.id.button4);
		final Button Deletar = (Button) findViewById(R.id.button3);
		final Button Listar = (Button) findViewById(R.id.button2);
		
		categoria.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(
				) {
			
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				switch (categoria.getCheckedRadioButtonId()) {
		case R.id.radio0:
			classe = "caminha";
			break;

		case R.id.radio1:
			classe = "comedouro";
			break;
			
		case R.id.radio2:
			classe = "roupa";
			break;

		case R.id.radio3:
			classe = "brinquedinho";
			break;
		default:
			classe = "roupa";
			break;
		}
			}
		});
		
		cadastrar.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Produtos a = new Produtos();
				a.setNome(nome.getText().toString());
				a.setClasse(classe);
				db = new ProdutoDAO(Tela13.this);
				db.salvar_produtos(a);

				Toast.makeText(Tela13.this, classe, Toast.LENGTH_SHORT).show();
			}
		});
		
//		Alterar.setOnClickListener(new Button.OnClickListener() {
//			@Override
//		public void onClick(View arg0) {
//				
//				Produtos a = new Produtos();
//				a.setId(Integer.parseInt(id));
//				a.setNome(nome.getText().toString());
//				a.setClasse(classe);
//				db= new MyBuddyDAO(Tela13.this);
//				db.alterar_produtos(a);
//				listarProdutos();
//				Toast.makeText(Tela13.this, "Alterado", Toast.LENGTH_SHORT).show();
//				listarProdutos();
//			}
//		});
		
		Listar.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				listarProdutos();
			}
		});
		
//		lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//			@Override
//			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
//					long arg3) {
//				String conteudo = (String) 
//				lista.getItemAtPosition(position);
//				String palavra[] = conteudo.split(" - ");
//				id = palavra[0];
//				nome.setText(palavra[2]);
//				if (palavra[1].equals("Caminha")) {
//					r1.isChecked();
//				} else if (palavra[1].equals("Comedouro")) {
//					r2.isChecked();
//				} else if (palavra[1].equals("Roupa")) {
//					r3.isChecked();
//				} else {
//					r4.isChecked();
//				}
//			}
//		});
 	}
	
	public void listarProdutos() {
		List<Produtos> produtos = db.listaProdutos();
		arrayList = new ArrayList<String>();
		adapter = new ArrayAdapter<String>(Tela13.this,
				android.R.layout.simple_list_item_1, arrayList);
		lista.setAdapter(adapter);
		for (Produtos a : produtos) {
			arrayList.add(a.getId() + " - " + a.getClasse() + " - "
					+ a.getNome());
			adapter.notifyDataSetChanged();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela13, menu);
		return true;
	}

}
