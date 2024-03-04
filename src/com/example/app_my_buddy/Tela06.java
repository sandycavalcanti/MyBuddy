package com.example.app_my_buddy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Tela06 extends Activity {
	
	ArrayList<String> arrayList;
	ListView lista1, lista2, lista3, lista4;
	ProdutoDAO db = new ProdutoDAO(this);
	
	public static int[] img;
	public static String[] nome, preco;
	
	
	public static int[] a1 = { R.drawable.produto_cama_simples, R.drawable.produto_cama_acolchoada};
	public static String[] a2 = { "Cama Simples", "Cama acolchoada"};
	public static String[] a3 = { "R$89.11","R$88.03"};

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_tela06);
		
		lista1 = (ListView) findViewById(R.id.listview1);
		lista2 = (ListView) findViewById(R.id.listview2);
		lista3 = (ListView) findViewById(R.id.listview3);
		lista4 = (ListView) findViewById(R.id.listview4);
		final Spinner spinner = (Spinner) findViewById(R.id.spinner1);
		final TextView pesquisar = (TextView)findViewById(R.id.textView84);
		final TextView limpar = (TextView)findViewById(R.id.textView85);
		final TextView txtcaminhas = (TextView)findViewById(R.id.textView1);
		final TextView txtcomedouros = (TextView)findViewById(R.id.textView32);
		final TextView txtroupinhas = (TextView)findViewById(R.id.textView33);
		final TextView txtbrinquedos = (TextView)findViewById(R.id.textView34);
		final Button animais = (Button) findViewById(R.id.button1);
		final Button produtos = (Button) findViewById(R.id.button2);
		final Button oq_e = (Button) findViewById(R.id.button3);
		final Button doacao = (Button) findViewById(R.id.button4);
		final Button home = (Button) findViewById(R.id.button5);

		// Font
		Typeface font = Typeface.createFromAsset(getAssets(), "lemonmelon.ttf");
		Typeface regencie = Typeface.createFromAsset(getAssets(), "regencie1.ttf");
		animais.setTypeface(font);
		produtos.setTypeface(font);
		oq_e.setTypeface(font);
		doacao.setTypeface(font);
		home.setTypeface(font);
		
		home.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent i1 = new Intent(Tela06.this, Tela02.class);
				startActivity(i1);

			}
		});
		
		animais.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i1=new Intent(Tela06.this,Tela04.class);
				startActivity(i1);
				
			}
		});
		
		produtos.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent i1 = new Intent(Tela06.this, Tela06.class);
				startActivity(i1);

			}
		});

		oq_e.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent i1 = new Intent(Tela06.this, Tela03.class);
				startActivity(i1);

			}
		});

		doacao.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent i1 = new Intent(Tela06.this, Tela05.class);
				startActivity(i1);

			}
		});
		
		// Início do código da pesquisa
		 String[] categoria = new String[]{
                "Escolha uma categoria",
                "Caminhas",
                "Comedouros",
                "Roupinhas",
                "Brinquedos"
        };
		 List<String> categoriaList = new ArrayList<String>(Arrays.asList(categoria));
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
       		 this, android.R.layout.simple_dropdown_item_1line,categoriaList){
       	 @Override
            public boolean isEnabled(int position){
                    return position != 0;
            } @Override
            public View getDropDownView(
                    int position, View convertView, ViewGroup parent) {
           	 
                    View view = super.getDropDownView(position, convertView, parent);
                    TextView textView = (TextView) view;
                    if(position == 0){
                            textView.setTextColor(Color.GRAY);
                    }
                    else {textView.setTextColor(Color.BLACK); }
                    return view;
            }
        };
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(spinnerArrayAdapter);
        // Caixa de pesquisa
     		pesquisar.setOnClickListener(new View.OnClickListener() {

     			@Override
     			public void onClick(View arg0) {
     				String pesquisar = spinner.getSelectedItem().toString();
     				
     				if (pesquisar.equals("Caminhas")) {
     					lista1.setVisibility(View.VISIBLE);
     					txtcaminhas.setVisibility(View.VISIBLE);
     					lista2.setVisibility(View.GONE);
     					txtcomedouros.setVisibility(View.GONE);
     					lista3.setVisibility(View.GONE);
     					txtroupinhas.setVisibility(View.GONE);
     					lista4.setVisibility(View.GONE);
     					txtbrinquedos.setVisibility(View.GONE);
     					
     				} else if (pesquisar.equals("Comedouros")) {
     					lista1.setVisibility(View.GONE);
     					txtcaminhas.setVisibility(View.GONE);
     					lista2.setVisibility(View.VISIBLE);
     					txtcomedouros.setVisibility(View.VISIBLE);
     					lista3.setVisibility(View.GONE);
     					txtroupinhas.setVisibility(View.GONE);
     					lista4.setVisibility(View.GONE);
     					txtbrinquedos.setVisibility(View.GONE);

     				} else if (pesquisar.equals("Roupinhas")) {
     					lista1.setVisibility(View.GONE);
     					txtcaminhas.setVisibility(View.GONE);
     					lista2.setVisibility(View.GONE);
     					txtcomedouros.setVisibility(View.GONE);
     					lista3.setVisibility(View.VISIBLE);
     					txtroupinhas.setVisibility(View.VISIBLE);
     					lista4.setVisibility(View.GONE);
     					txtbrinquedos.setVisibility(View.GONE);

     				} else if (pesquisar.equals("Brinquedos")) {
     					lista1.setVisibility(View.GONE);
     					txtcaminhas.setVisibility(View.GONE);
     					lista2.setVisibility(View.GONE);
     					txtcomedouros.setVisibility(View.GONE);
     					lista3.setVisibility(View.GONE);
     					txtroupinhas.setVisibility(View.GONE);
     					lista4.setVisibility(View.VISIBLE);
     					txtbrinquedos.setVisibility(View.VISIBLE);
     				} else {
     					Toast.makeText(Tela06.this, "Selecione uma opção para filtrar", Toast.LENGTH_SHORT).show();
     				}
     				Toast.makeText(getApplicationContext(), "Filtrado", Toast.LENGTH_SHORT).show();
     			}
     		});
     		limpar.setOnClickListener(new View.OnClickListener() {
     			
     			@Override
     			public void onClick(View arg0) {
     				// TODO Auto-generated method stub
     				lista1.setVisibility(View.VISIBLE);
     				txtcaminhas.setVisibility(View.VISIBLE);
     				lista2.setVisibility(View.VISIBLE);
     				txtcomedouros.setVisibility(View.VISIBLE);
     				lista3.setVisibility(View.VISIBLE);
     				txtroupinhas.setVisibility(View.VISIBLE);
     				lista4.setVisibility(View.VISIBLE);
     				txtbrinquedos.setVisibility(View.VISIBLE);
     				Toast.makeText(getApplicationContext(), "Limpo", Toast.LENGTH_SHORT).show();
     			}
     		});
     	// Fim do código da pesquisa
		
		img = a1;
		nome = a2;
		preco = a3;
		
		AdapImg obj = new AdapImg(Tela06.this, img, nome, preco);
		lista1.setAdapter(obj);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela06, menu);
		return true;
	}
	class AdapImg extends ArrayAdapter<String> {

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		Context context;
		int[] imgc;
		String[] nomec, precoc;

		AdapImg(Context c, int[] img, String[] nome, String[] preco) {
			super(c, R.layout.produtos, R.id.textView2, nome);
			this.context = c;
			this.imgc = img;
			this.nomec = nome;
			this.precoc = preco;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
	
				img = a1;
				nome = a2;
				preco = a3;

	

			View view = getLayoutInflater().inflate(R.layout.produtos, null);
			ImageView imgimagem = (ImageView) view.findViewById(R.id.imageView13);
			TextView txtnome = (TextView) view.findViewById(R.id.textView2);
			TextView txtpreco = (TextView) view.findViewById(R.id.textView3);

			imgimagem.setImageResource(img[position]);
			txtnome.setText(nome[position]);
			txtpreco.setText(preco[position]);

	
			return view;
		}

	}
}
