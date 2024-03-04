	package com.example.app_my_buddy;

	import java.util.ArrayList;
	import java.util.List;
	import android.content.ContentValues;
	import android.content.Context;
	import android.database.Cursor;
	import android.database.sqlite.SQLiteDatabase;
	import android.database.sqlite.SQLiteOpenHelper;

	public class UsuarioDAO extends SQLiteOpenHelper{
		
		private static String database= "my_buddy";
		private static int versao = 2;
		
		public UsuarioDAO(Context c) {
			super(c, database, null, versao);
			}
		
		public void onCreate(SQLiteDatabase db) {
			String sql = "create table usuario("
					+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "nome TEXT,"
					+ "email TEXT,"
					+ "senha TEXT,"
					+ "descricao TEXT,"
					+ "endereco TEXT,"
					+ "residencia TEXT,"
					+ "quant_pes_casa INTEGER,"
					+ "telefone INTEGER,"
					+ "cpf INTEGER)";
			db.execSQL(sql);	
		}

		public void onUpdate(SQLiteDatabase db, int arg1, int arg2) {
			String sql = "drop table if exists usuario";
			db.execSQL(sql);
			this.onCreate(db);
		}
	

	// CRUD USUARIO
	
	// salvar
	public void salvar_usuario(Usuarios a){
		ContentValues v = new ContentValues();
		v.put("nome", a.getNome());
		v.put("email", a.getEmail());
		v.put("senha", a.getSenha());
		v.put("descricao", a.getDescricao());
		v.put("endereco", a.getEndereco());
		v.put("residencia", a.getResidencia());
		v.put("quant_pes_casa", a.getQuant_pes_casa());
		v.put("telefone", a.getTelefone());
		v.put("cpf", a.getCpf());
		getWritableDatabase().insert("Usuario", null, v);
	}
	
	// Alterar
		public void alterar_usuario(Usuarios a) {
			ContentValues v = new ContentValues();
			v.put("nome", a.getNome());
			v.put("email", a.getEmail());
			v.put("senha", a.getSenha());
			v.put("descricao", a.getDescricao());
			v.put("endereco", a.getEndereco());
			v.put("residencia", a.getResidencia());
			v.put("status_adocao", a.getStatus_adocao());
			v.put("quant_pes_casa", a.getQuant_pes_casa());
			v.put("telefone", a.getTelefone());
			v.put("cpf", a.getCpf());
			getWritableDatabase().update("Usuario", v, "id=" + a.getId(), null);
		}

		// Listar
		public List<Usuarios> listaUsuario() {
			List<Usuarios> usuarios = new ArrayList<Usuarios>();
			String query = "SELECT * FROM USUARIO";
			SQLiteDatabase db = this.getWritableDatabase();
			Cursor c = db.rawQuery(query, null);
			if (c.moveToFirst()) {
				do {
					Usuarios a = new Usuarios();
					a.setId(Integer.parseInt(c.getString(0)));
					a.setNome(c.getString(1));
					a.setEmail(c.getString(2));
					a.setSenha(c.getString(3));
					a.setDescricao(c.getString(4));
					a.setEndereco(c.getString(5));
					a.setResidencia(c.getString(6));
					a.setStatus_adocao(c.getString(7));
					a.setQuant_pes_casa(Integer.parseInt(c.getString(8)));
					a.setTelefone(Integer.parseInt(c.getString(9)));
					a.setCpf(Integer.parseInt(c.getString(10)));
					usuarios.add(a);
				} while (c.moveToNext());
			}
			return usuarios;
		}

		// Deletar
		public void delete_usuario(Produtos a) {
			this.getWritableDatabase().delete("Usuario", "id=" + a.getId(), null);
		}
		
		@Override
		public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
			// TODO Auto-generated method stub
			
		}

}
