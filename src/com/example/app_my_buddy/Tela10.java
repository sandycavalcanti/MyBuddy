package com.example.app_my_buddy;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Tela10 extends Activity {

	ListView lista;
	String classe, id, sexo;
	ArrayAdapter<String> adapter;
	ArrayList<String> arrayList;
	RadioGroup radioclasse, radioatencao, radiosexo;
	RadioButton r0, r1, r2, r3, r4, r5;
	AnimalDAO db = new AnimalDAO(this);
	ImageView imgview;
	String caminho;
	int SELECT_PICTURE = 200;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_tela10);

		final EditText nome = (EditText) findViewById(R.id.editText1);
		radioatencao = (RadioGroup) findViewById(R.id.radioGroup1);
		radioclasse = (RadioGroup) findViewById(R.id.radioGroup2);
		radiosexo = (RadioGroup) findViewById(R.id.radioGroup3);
		r0 = (RadioButton) findViewById(R.id.radio0);
		r1 = (RadioButton) findViewById(R.id.radio1);
		r2 = (RadioButton) findViewById(R.id.radio2);
		r3 = (RadioButton) findViewById(R.id.radio3);
		r4 = (RadioButton) findViewById(R.id.radio4);
		r5 = (RadioButton) findViewById(R.id.radio5);
		final EditText necessidade = (EditText) findViewById(R.id.editText3);
		final EditText idtxt = (EditText) findViewById(R.id.editText5);
		final EditText desc = (EditText) findViewById(R.id.editText4);
		final Button cadastrar = (Button) findViewById(R.id.button1);
		final Button listar = (Button) findViewById(R.id.button2);
		final Button deletar = (Button) findViewById(R.id.button3);
		final Button alterar = (Button) findViewById(R.id.button4);
		final Button imagem = (Button) findViewById(R.id.button5);
		lista = (ListView) findViewById(R.id.listview1);

		radioatencao
				.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
					@Override
					public void onCheckedChanged(RadioGroup arg0, int arg1) {
						switch (radioatencao.getCheckedRadioButtonId()) {
						case R.id.radio0:
							necessidade.setVisibility(View.VISIBLE);
							break;
						case R.id.radio1:
							necessidade.setVisibility(View.GONE);
							break;

						default:
							necessidade.setVisibility(View.GONE);
							break;
						}
					}
				});

		if (r1.isChecked()) {
			necessidade.setVisibility(View.GONE);
		}

		radioclasse
				.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
					@Override
					public void onCheckedChanged(RadioGroup arg0, int arg1) {
						switch (radioclasse.getCheckedRadioButtonId()) {
						case R.id.radio2:
							classe = "cachorro";
							break;

						case R.id.radio3:
							classe = "gato";
							break;

						default:
							classe = "gato";
							break;
						}
					}
				});

		radiosexo
				.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
					@Override
					public void onCheckedChanged(RadioGroup arg0, int arg1) {
						switch (radiosexo.getCheckedRadioButtonId()) {
						case R.id.radio4:
							sexo = "Macho";
							break;

						case R.id.radio5:
							sexo = "Fêmea";
							break;

						default:
							sexo = "Macho";
							break;
						}
					}
				});

		cadastrar.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// Verificar se todos os campos estão preenchidos
				String cdesc = desc.getText().toString();
				String cnome = nome.getText().toString();
				if (cnome.equals("") || classe == null || sexo == null || cdesc.equals("")) {
					Toast.makeText(Tela10.this, "Complete todos os campos",
							Toast.LENGTH_SHORT).show();
				} else if (r0.isChecked() && necessidade.getText().toString().equals("")) {
					Toast.makeText(Tela10.this, "Complete todos os campos",
							Toast.LENGTH_SHORT).show();
				} else {
					// Cadastrar
					Animais a = new Animais();
					a.setNome(nome.getText().toString());
					a.setSexo(sexo);
					if (r0.isChecked()) {
						a.setNecessidade(necessidade.getText().toString());
					} else {
						a.setNecessidade(" ");
					}
					a.setDescricao(desc.getText().toString());
					a.setClasse(classe);
					a.setImagem(caminho);
					db = new AnimalDAO(Tela10.this);
					db.salvar_animais(a);

					Toast.makeText(Tela10.this, "Cadastrado",
							Toast.LENGTH_SHORT).show();
				}
			}
		});

		alterar.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// Verificar se todos os campos estão preenchidos
				String cdesc = desc.getText().toString();
				String cnome = nome.getText().toString();
				if (cnome.equals("") || classe == null || sexo == null || cdesc.equals("")) {
					Toast.makeText(Tela10.this, "Complete todos os campos",
							Toast.LENGTH_SHORT).show();
				} else if (r0.isChecked() && necessidade.getText().toString().equals("")) {
					Toast.makeText(Tela10.this, "Complete todos os campos",
							Toast.LENGTH_SHORT).show();
				} else {
					Animais a = new Animais();
					a.setId(Integer.parseInt(idtxt.getText().toString()));
					a.setNome(nome.getText().toString());
					a.setClasse(classe);
					a.setImagem(caminho);
					a.setSexo(sexo);
					a.setNecessidade(necessidade.getText().toString());
					a.setDescricao(desc.getText().toString());

					db = new AnimalDAO(Tela10.this);
					db.alterar_animais(a);
					listarAnimais();
					Toast.makeText(Tela10.this, "Alterado", Toast.LENGTH_SHORT).show();
					listarAnimais();
				}
			}
		});

		listar.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				listarAnimais();
			}
		});

		deletar.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Animais a = new Animais();
				a.setId(Integer.parseInt(id));
				db = new AnimalDAO(Tela10.this);
				db.delete_animais(a);
				listarAnimais();
				Toast.makeText(Tela10.this, "Excluido", Toast.LENGTH_SHORT)
						.show();
				listarAnimais();
			}
		});

		lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
				String conteudo = (String) lista.getItemAtPosition(position);
				String palavra[] = conteudo.split(" - ");
				id = palavra[0];
				nome.setText(palavra[2]);
				if (palavra[1].equals("gato")) {
					r3.setChecked(true);
				} else {
					r2.setChecked(true);
				}
				idtxt.setText(String.valueOf(id));
			}
		});

		try {
			Bundle bundle = getIntent().getExtras();
			String nomein = bundle.getString("nome");
			String necessidadein = bundle.getString("necessidade");
			String sexoin = bundle.getString("sexo");
			String descricaocin = bundle.getString("descricao");
			String classein = bundle.getString("classe");
			int idin = bundle.getInt("id");
			nome.setText(nomein);
			if (sexoin.equals("Macho")) {
				r4.setChecked(true);
			} else {
				r5.setChecked(true);
			}
			if (necessidadein.equals(" ")) {
				r1.setChecked(true);
			} else {
				r0.setChecked(true);
				necessidade.setText(necessidadein);
			}
			desc.setText(descricaocin);
			if (classein.equals("cachorro")) {
				r2.setChecked(true);
			} else {
				r3.setChecked(true);
			}
			idtxt.setText(String.valueOf(idin));
		} catch (Exception e) {
			// TODO: handle exception
		}

		imgview = (ImageView) findViewById(R.id.imageView1);
		imgview.setImageResource(0);
		imgview.setVisibility(View.GONE);

		imagem.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				imageChooser();
			}
		});
	}

	void imageChooser() {

		Intent i = new Intent();
		i.setType("image/*");
		i.setAction(Intent.ACTION_GET_CONTENT);
		startActivityForResult(Intent.createChooser(i, "Select Picture"),
				SELECT_PICTURE);
	}

	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (resultCode == RESULT_OK) {

			if (requestCode == SELECT_PICTURE) {

				Uri selectedImageUri = data.getData();
				if (null != selectedImageUri) {

					caminho = selectedImageUri.toString();
					imgview.setImageURI(selectedImageUri);
					imgview.setVisibility(View.VISIBLE);
				}
			}
		}

	}

	public void listarAnimais() {

		List<Animais> animais = db.listaAnimais();
		arrayList = new ArrayList<String>();
		adapter = new ArrayAdapter<String>(Tela10.this,
				android.R.layout.simple_list_item_1, arrayList);
		lista.setAdapter(adapter);
		for (Animais a : animais) {
			arrayList.add(a.getId() + " - " + a.getClasse() + " - "
					+ a.getNome() + " - " + a.getSexo());
			adapter.notifyDataSetChanged();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela10, menu);
		return true;
	}
}
