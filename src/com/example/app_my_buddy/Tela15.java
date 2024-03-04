package com.example.app_my_buddy;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Tela15 extends Activity {
	
	ArrayAdapter<String> adapter;
	ArrayList<String> arrayList;
	ListView lista;
	UsuarioDAO db = new UsuarioDAO(this);
//	public static String[] nome ,email,descricao;
//	int i = 0, size = 0;
//	String tipo;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_tela15);
		
		
		lista = (ListView) findViewById(R.id.listview1);
		
//		listarUsuarios();
	}
	
	public void listarUsuarios() {
		List<Usuarios> usuario = db.listaUsuario();
		arrayList= new ArrayList<String>();
		adapter= new
		ArrayAdapter<String>(Tela15.this,android.R.layout.simple_list_item_1, arrayList);
		lista.setAdapter(adapter);
		for(Usuarios a : usuario) {
			arrayList.add(a.getId() + " -"+ a.getNome() + " -"+ a.getDescricao());
			adapter.notifyDataSetChanged();
			}
		}
		
		
		
//		List<Usuarios> usuarios = db.listaUsuario();
//		arrayList = new ArrayList<String>();
//		
//		// Tamanho da array
//		for (Usuarios a: usuarios) {
//				
//				tipo = a.getStatus_adocao().toString();
//				if(tipo.equals("solicitado")){
//					size++;
//				} else {
//				}
//				
//			
//		}
//		
//		// Define o tamanho das arrays
//		nome = new String[size];
//		email = new String[size];
//		descricao = new String[size];
//		
//		// Define cada valor de atributo do bd para cada array
//		for (Usuarios a: usuarios) {
//			tipo = a.getStatus_adocao().toString();
//			if(tipo.equals("solicitado")){
//				nome[i] = a.getNome().toString();
//				email[i] = a.getEmail().toString();
//				descricao[i] = a.getDescricao().toString();
//				i++;
//			} else {
//				
//			}
//		}
//		
//		// Coloque o adapter na lista
//		AdapImgc obj = new AdapImgc(Tela15.this, nome, email, descricao);
//		lista.setAdapter(obj);
//	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela15, menu);
		return true;
	}
	
//	class AdapImgc extends ArrayAdapter<String> {
//
//		@Override
//		public long getItemId(int position) {
//			return position;
//		}
//
//		AdapImgc(Context c, String[] nome, String[] email, String[] descricao) {
//			super(c, R.layout.adocoes, R.id.textView1, nome);
//		}
//
//		
//		@Override
//		public View getView(int position, View convertView, ViewGroup parent) {
//			
//			View view = getLayoutInflater().inflate(R.layout.adocoes, null);
//			TextView txtnome = (TextView) view.findViewById(R.id.textView1);
//			TextView txtemail = (TextView) view.findViewById(R.id.textView2);
//			TextView txtdescricao = (TextView) view.findViewById(R.id.textView3);
//			
//			txtnome.setText(nome[position]);
//			txtemail.setText(email[position]);
//			txtdescricao.setText(descricao[position]);
//
//			return view;
//		}
//
//	}
}
