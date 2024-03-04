package com.example.app_my_buddy;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.R.layout;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Tela04 extends Activity {

	ArrayAdapter<String> adapter;
	ArrayList<String> arrayList;
	ListView lista1, lista2;
	Bundle valor = new Bundle();
	AnimalDAO db = new AnimalDAO(this);
	int usuario;
	public static String[] imgc, imgg;
	public static String[] nomec, necessidadec, sexoc, descricaoc, nomeg, necessidadeg, sexog, descricaog;
	public static int[] idc, idg;
	int ic = 0, ig = 0, sizec = 0, sizeg = 0;
	Bundle dados = new Bundle();
	String tipo;
	Uri[] convertidoc, convertidog;
	TextView msgcachorro, msggato;
	View view;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_tela04);
		
		final TextView titulo_principal = (TextView) findViewById(R.id.textView1);
		final TextView titulo_cachorros = (TextView) findViewById(R.id.textView2);
		final TextView titulo_gatos = (TextView) findViewById(R.id.textView3);
		lista1 = (ListView) findViewById(R.id.listview1);
		lista2 = (ListView) findViewById(R.id.listview2);
		final Spinner spinner = (Spinner) findViewById(R.id.spinner1);
		final TextView pesquisar = (TextView)findViewById(R.id.textView84);
		final TextView limpar = (TextView)findViewById(R.id.textView85);
		Button cad = (Button) findViewById(R.id.button1);
		msgcachorro = (TextView) findViewById(R.id.textView4);
		msggato = (TextView) findViewById(R.id.textView5);
		final Button btn_animais = (Button) findViewById(R.id.button1);
		final Button produtos = (Button) findViewById(R.id.button2);
		final Button oq_e = (Button) findViewById(R.id.button3);
		final Button doacao = (Button) findViewById(R.id.button4);
		final Button home = (Button) findViewById(R.id.button5);
		final LinearLayout l_oq_e = (LinearLayout) findViewById(R.id.linear_btn_oq_e);
		
		// Início do código da pesquisa
				 String[] categoria = new String[]{
		                 "Escolha uma categoria",
		                 "Cachorros",
		                 "Gatos"
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
							TextView msgcachorro = (TextView) findViewById(R.id.textView4);
							TextView msggato = (TextView) findViewById(R.id.textView5);
							if (pesquisar.equals("Cachorros")) {
								exibirMensagem();
								lista1.setVisibility(View.VISIBLE);
								titulo_cachorros.setVisibility(View.VISIBLE);
								lista2.setVisibility(View.GONE);
								titulo_gatos.setVisibility(View.GONE);
								msggato.setVisibility(View.GONE);
							} else if (pesquisar.equals("Gatos")) {
								exibirMensagem();
								lista1.setVisibility(View.GONE);
								titulo_cachorros.setVisibility(View.GONE);
								lista2.setVisibility(View.VISIBLE);
								titulo_gatos.setVisibility(View.VISIBLE);
								msgcachorro.setVisibility(View.GONE);
							} else {
								Toast.makeText(Tela04.this, "Selecione uma opção para filtrar", Toast.LENGTH_SHORT).show();
							}
							Toast.makeText(getApplicationContext(), "Filtrado", Toast.LENGTH_SHORT).show();
							
						}
					});
					limpar.setOnClickListener(new View.OnClickListener() {
						@Override
						public void onClick(View arg0) {
							lista1.setVisibility(View.VISIBLE);
							titulo_cachorros.setVisibility(View.VISIBLE);
							lista2.setVisibility(View.VISIBLE);
							titulo_gatos.setVisibility(View.VISIBLE);
							Toast.makeText(getApplicationContext(), "Limpo", Toast.LENGTH_SHORT).show();
						}
					});
		// Fim do código da pesquisa
					
		// Font
		Typeface font = Typeface.createFromAsset(getAssets(), "lemonmelon.ttf");
		Typeface regencie = Typeface.createFromAsset(getAssets(), "regencie1.ttf");
		titulo_principal.setTypeface(font);
		titulo_cachorros.setTypeface(font);
		titulo_gatos.setTypeface(font);
		btn_animais.setTypeface(font);
		produtos.setTypeface(font);
		oq_e.setTypeface(font);
		doacao.setTypeface(font);
		home.setTypeface(font);
		msgcachorro.setTypeface(regencie);
		msggato.setTypeface(regencie);
		
		List<Animais> animais = db.listaAnimais();
		arrayList = new ArrayList<String>();
		
		// Tamanho da array
		for (Animais a: animais) {
			
			tipo = a.getClasse().toString();
			if(tipo.equals("cachorro")){
				sizec++;
			} else {
				sizeg++;
			}
			
		}
		
		// Define o tamanho das arrays
		nomec = new String[sizec];
		imgc = new String[sizec];
		sexoc = new String[sizec];
		necessidadec = new String[sizec];
		descricaoc = new String[sizec];
		idc = new int[sizec];
		nomeg = new String[sizeg];
		imgg = new String[sizeg];
		sexog = new String[sizeg];
		necessidadeg = new String[sizeg];
		descricaog = new String[sizeg];
		idg = new int[sizeg];
		
		// Define cada valor de atributo do bd para cada array
		for (Animais a: animais) {
			
			tipo = a.getClasse().toString();
			
			if(tipo.equals("cachorro")){
				idc[ic] = a.getId();
				nomec[ic] = a.getNome().toString();
				imgc[ic] = a.getImagem().toString();
				sexoc[ic] = a.getSexo().toString();
				necessidadec[ic] = a.getNecessidade().toString();
				descricaoc[ic] = a.getDescricao().toString();
				ic++;
			} else {
				idg[ig] = a.getId();
				nomeg[ig] = a.getNome().toString();
				//imgg[ig] = a.getImagem().toString();
				sexog[ig] = a.getSexo().toString();
				necessidadeg[ig] = a.getNecessidade().toString();
				descricaog[ig] = a.getDescricao().toString();
				ig++;
			}
				
			
		}
		
		exibirMensagem(); 
		
		
		// Coloque o adapter na lista
		AdapImgc objc = new AdapImgc(Tela04.this, imgc, nomec, necessidadec, sexoc, descricaoc);
		lista1.setAdapter(objc);
		AdapImgg objg = new AdapImgg(Tela04.this, imgg, nomeg, necessidadeg, sexog, descricaog);
		//lista2.setAdapter(objg);
		
		/*
		ImageView imagema = (ImageView) findViewById(R.id.imageView1);
		Uri convertido = Uri.parse(imgc[0]);
    	imagema.setImageURI(convertido);
		*/
		
		Bundle bundle = getIntent().getExtras();
		usuario = bundle.getInt("usuario");
		
		switch (usuario) {
		case 1: // ADM
			cad.setVisibility(View.VISIBLE);
			l_oq_e.setVisibility(View.GONE);
			break;
		default: // Cliente
			cad.setVisibility(View.GONE);
			l_oq_e.setVisibility(View.VISIBLE);
			break;
		}
		
		
		home.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				
				switch (usuario) {
				case 1: // ADM
					Intent i1 = new Intent(Tela04.this, Tela12.class);
					startActivity(i1);
					break;
				default: // Cliente
					Intent i2 = new Intent(Tela04.this, Tela02.class);
					startActivity(i2);
					break;
				}
				

			}
		});
		
		produtos.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				switch (usuario) {
				case 1: // ADM
					valor.putInt("usuario", 1);
					Intent it = new Intent(Tela04.this, Tela06.class);
					it.putExtras(valor);
					startActivity(it);
					break;
				default: // Cliente
					Intent i2 = new Intent(Tela04.this, Tela06.class);
					startActivity(i2);
					break;
				}
			}
		});

		oq_e.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent i1 = new Intent(Tela04.this, Tela03.class);
				startActivity(i1);

			}
		});

		doacao.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				switch (usuario) {
				case 1: // ADM
					Intent i1 = new Intent(Tela04.this, Tela15.class);
					startActivity(i1);
					break;
				default: // Cliente
					Intent i2 = new Intent(Tela04.this, Tela14.class);
					startActivity(i2);
					break;
				}

			}
		});
		
		cad.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent cad = new Intent(Tela04.this, Tela10.class);
				startActivity(cad);	
			}
		});
		
	}
	
	// Mensagem caso não houver nenhum animal cadastrado
	public void exibirMensagem() {
				try {
					if(nomec[0] != null || nomec[0].equals(" ")){
						msgcachorro.setVisibility(View.GONE);
					}
				} catch (Exception e) {
					msgcachorro.setVisibility(View.VISIBLE);
				}
				try {
					if(nomeg[0] != null || nomeg[0].equals(" ")){
						msggato.setVisibility(View.GONE);
					}
				} catch (Exception e) {
					msggato.setVisibility(View.VISIBLE);
				}	
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.tela04, menu);
		return true;
	}
	
	// Adapter da lista
	class AdapImgc extends ArrayAdapter<String> {

		@Override
		public long getItemId(int position) {
			return position;
		}
		
		AdapImgc(Context c, String[] imgc, String[] nomec, String[] necessidadec, String[] sexoc, String[] descricaoc){ //  , String[] adotar) {
			super(c, R.layout.animais, R.id.button7, nomec);
		}

		@Override
		public View getView(final int position, View convertView, ViewGroup parent) {

			Bundle bundle = getIntent().getExtras();
			int usuario = bundle.getInt("usuario");
			
			switch (usuario) {
			case 1: // ADM
				view = getLayoutInflater().inflate(R.layout.animais_adm, null);
				break;
			default: // Cliente
				view = getLayoutInflater().inflate(R.layout.animais, null);
				break;
			}
			
			ImageView imgimagem = (ImageView) view.findViewById(R.id.imageView3);
			TextView txtnome = (TextView) view.findViewById(R.id.textView9);
			TextView txtatencao = (TextView) view.findViewById(R.id.textView1);
			TextView txtsexo = (TextView) view.findViewById(R.id.textView10);
			TextView txtparag1 = (TextView) view.findViewById(R.id.textView11);
			final LinearLayout linear = (LinearLayout) view.findViewById(R.id.linear1);
			/*
			File imgFile = new  File(imgc[position]);

			if(imgFile.exists()){

			    Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());

			    imgimagem.setImageBitmap(myBitmap);

			}
			*/
			/*
        	convertidoc[position] = Uri.parse(imgc[position]);
        	
        	teste[position] = convertidoc[position].toString();
        	
        	if (null != convertidoc) {
			//imgimagem.setImageURI(convertidoc[position]);
        	}
        	*/
			txtnome.setText(nomec[position]);
			txtatencao.setText(necessidadec[position]);
			txtsexo.setText(sexoc[position]);
			txtparag1.setText(descricaoc[position]);
			
			// Se não houver atenção, remover
			if (necessidadec[position].equals(" ")) {
				txtatencao.setVisibility(View.GONE);
			}
			
			switch (usuario) {
			case 1: // ADM
				Button excluir = (Button) view.findViewById(R.id.button2);
				Button alterar = (Button) view.findViewById(R.id.button1);
				excluir.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						AlertDialog.Builder alerta = new AlertDialog.Builder(Tela04.this);
						alerta.setTitle("Excluir esse cadastro?");
						alerta.setMessage("Tem certeza que deseja excluir esse cadastro?");
						alerta.setCancelable(false);
						alerta.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface arg0, int arg1) {
								// TODO Auto-generated method stub
								Animais a = new Animais();
								a.setId(idc[position]);
								db = new AnimalDAO(Tela04.this);
								db.delete_animais(a);
								Toast.makeText(Tela04.this, "Excluído", Toast.LENGTH_SHORT).show();
								linear.setVisibility(View.GONE);
							}
						});
						alerta.setNegativeButton("Não", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface arg0, int arg1) {
								// Fechar o alerta
							}
						});
						alerta.show();
					}
				});
				alterar.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View arg0) {
						dados.putString("nome", nomec[position]);
						dados.putString("necessidade", necessidadec[position]);
						dados.putString("sexo", sexoc[position]);
						dados.putString("descricao", descricaoc[position]);
						dados.putString("classe", "cachorro");
						dados.putInt("id", idc[position]);
						Intent it = new Intent(Tela04.this, Tela10.class);
						it.putExtras(dados);
						startActivity(it);
					}
				});
				break;
			default: // Cliente
				Button botao = (Button) view.findViewById(R.id.button7);
				botao.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						dados.putString("nome", nomec[position]);
						Intent it = new Intent(Tela04.this, Tela14.class);
						it.putExtras(dados);
						startActivity(it);
					}
				});
				break;
			}
			return view;
		}
	}
	class AdapImgg extends ArrayAdapter<String> {

		@Override
		public long getItemId(int position) {
			return position;
		}

		AdapImgg(Context c, String[] imgg, String[] nomeg, String[] necessidadeg, String[] sexog, String[] descricaog) {
			super(c, R.layout.animais, R.id.textView9, nomeg);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			
			Bundle bundle = getIntent().getExtras();
			int usuario = bundle.getInt("usuario");
			
			switch (usuario) {
			case 1: // ADM
				view = getLayoutInflater().inflate(R.layout.animais_adm, null);
				break;
			default: // Cliente
				view = getLayoutInflater().inflate(R.layout.animais, null);
				break;
			}
			
			//ImageView imgimagem = (ImageView) view.findViewById(R.id.imageView3);
			TextView txtnome = (TextView) view.findViewById(R.id.textView9);
			TextView txtatencao = (TextView) view.findViewById(R.id.textView1);
			TextView txtsexo = (TextView) view.findViewById(R.id.textView10);
			TextView txtparag1 = (TextView) view.findViewById(R.id.textView11);

			//imgimagem.setImageResource(imgg[position]);
			txtnome.setText(nomeg[position]);
			txtatencao.setText(necessidadeg[position]);
			txtsexo.setText(sexog[position]);
			txtparag1.setText(descricaog[position]);
	
			// Se não houver atenção, remover
			if (necessidadeg[position].equals(" ")) {
				txtatencao.setVisibility(View.GONE);
			}
			
			return view;
		}

	}

	
	
	

}
