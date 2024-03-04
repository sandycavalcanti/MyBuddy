	package com.example.app_my_buddy;

	import java.util.ArrayList;
	import java.util.List;
	import android.content.ContentValues;
	import android.content.Context;
	import android.database.Cursor;
	import android.database.sqlite.SQLiteDatabase;
	import android.database.sqlite.SQLiteOpenHelper;

public class ProdutoDAO extends SQLiteOpenHelper{
		
		private static String database= "my_buddy";
		private static int versao = 2;
		
		public ProdutoDAO(Context c) {
			super(c, database, null, versao);
			}
		
		
		// CRUD ANIMAIS
		
		public void onCreate(SQLiteDatabase db) {
			String sql ="create table produto("
					+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "classe TEXT,"
					+ "nome TEXT,"
					+ "preco TEXT)";
			db.execSQL(sql);	
		}

		public void onUpdate(SQLiteDatabase db, int arg1, int arg2) {
			String sql = "drop table if exists produto";
			db.execSQL(sql);
			this.onCreate(db);
		}

	 // CRUD PRODUTOS
		
		// salvar
		public void salvar_produtos(Produtos a){
			ContentValues v = new ContentValues();
			v.put("classe", a.getClasse());
			v.put("nome", a.getNome());
			v.put("preco", a.getPreco());
			getWritableDatabase().insert("produtos", null, v);
		}
		
		//listar
		public List<Produtos> listaProdutos(){
			List<Produtos> produtos = new ArrayList<Produtos>();
			String query = "SELECT * FROM produto";
			SQLiteDatabase db = this.getWritableDatabase();
			Cursor c = db.rawQuery(query, null);
			if (c.moveToFirst()) {
				do {
					Produtos a = new Produtos();
					a.setId(Integer.parseInt(c.getString(0)));
					a.setClasse(c.getString(1));
					a.setNome(c.getString(2));
					a.setPreco(c.getDouble(3));
					produtos.add(a);
				} while (c.moveToNext());
			}
			return produtos;
		}
		
		//Alterar
		public void alterar_produtos(Produtos a){
			ContentValues v = new ContentValues();
			v.put("classe", a.getClasse());
			v.put("nome", a.getNome());
			v.put("preco", a.getPreco());
			v.put("id", a.getId());
			getWritableDatabase().update("Produto", v, "id=" + a.getId(), null);
		}
		
		//Deletar
		public void delete_produtos(Produtos a){
			this.getWritableDatabase().delete("Produto", "id="+ a.getId(), null);
		}
		
		@Override
		public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
			// TODO Auto-generated method stub
			
		}

		}

