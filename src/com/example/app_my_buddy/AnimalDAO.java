
	package com.example.app_my_buddy;

	import java.util.ArrayList;
	import java.util.List;
	import android.content.ContentValues;
	import android.content.Context;
	import android.database.Cursor;
	import android.database.sqlite.SQLiteDatabase;
	import android.database.sqlite.SQLiteOpenHelper;

public class AnimalDAO extends SQLiteOpenHelper{
	
		private static String database= "my_buddy";
		private static int versao = 2;
		
		public AnimalDAO(Context c) {
			super(c, database, null, versao);
			}
		
		
		// CRUD ANIMAIS
		
		public void onCreate(SQLiteDatabase db) {
			String sql = 
					"create table animal("
					+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "classe TEXT,"
					+ "nome TEXT," 
					+ "sexo TEXT," 
					+ "necessidade TEXT,"
					+ "descricao TEXT,"
					+ "imagem TEXT)";
			db.execSQL(sql);	
		}

		public void onUpdate(SQLiteDatabase db, int arg1, int arg2) {
			String sql = "drop table if exists animal";
			db.execSQL(sql);
			this.onCreate(db);
		}

		// salvar
		public void salvar_animais(Animais a) {
			ContentValues v = new ContentValues();
			v.put("classe", a.getClasse());
			v.put("nome", a.getNome());
			v.put("sexo", a.getSexo());
			v.put("necessidade", a.getNecessidade());
			v.put("descricao", a.getDescricao());
			v.put("imagem", a.getImagem());
			getWritableDatabase().insert("animal", null, v);
		}

		// listar
		public List<Animais> listaAnimais() {
			List<Animais> animais = new ArrayList<Animais>();
			String query = "SELECT * FROM animal";
			SQLiteDatabase db = this.getWritableDatabase();
			Cursor c = db.rawQuery(query, null);
			if (c.moveToFirst()) {
				do {
					Animais a = new Animais();
					a.setId(Integer.parseInt(c.getString(0)));
					a.setClasse(c.getString(1));
					a.setNome(c.getString(2));
					a.setSexo(c.getString(3));
					a.setNecessidade(c.getString(4));
					a.setDescricao(c.getString(5));
					a.setImagem(c.getString(6));
					animais.add(a);
				} while (c.moveToNext());
			}
			return animais;
		}

		// Alterar
		public void alterar_animais(Animais a) {
			ContentValues v = new ContentValues();
			v.put("classe", a.getClasse());
			v.put("nome", a.getNome());
			v.put("sexo", a.getSexo());
			v.put("necessidade", a.getNecessidade());
			v.put("descricao", a.getDescricao());
			v.put("id", a.getId());
			getWritableDatabase().update("animal", v, "id=" + a.getId(), null);
		}

		// Deletar
		public void delete_animais(Animais a) {
			this.getWritableDatabase().delete("animal", "id=" + a.getId(), null);
		}
		
		

		@Override
		public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
			// TODO Auto-generated method stub
			
		}

		}
