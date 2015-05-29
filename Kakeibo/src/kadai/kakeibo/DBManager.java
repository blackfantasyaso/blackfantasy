package kadai.kakeibo;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DBManager extends SQLiteOpenHelper {
	
	SQLiteDatabase sdb = null;
	
	public DBManager(Context context){
		super(context,"kakeibodb.db",null,1);
		sdb = getReadableDatabase();
		

	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u

		db.execSQL("create table kakeibo(" + "koumoku TEXT," + "kingaku INTEGER," + "kakeiboDay TEXT);");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u

	}
	
	public void insertKakeibo(String inKoumoku, Integer inKingaku, String inDay){
		
		try{
			//�g�����U�N�V�����J�n
			sdb.beginTransaction();
			
			//�}��������e��ݒ�
			ContentValues cv = new ContentValues();
			cv.put("koumoku", inKoumoku);
			cv.put("kingaku", inKingaku);
			cv.put("kakeiboDay", inDay);
			
			//�e�[�u���ɑ}��
			sdb.insert("kakeibo", "", cv);
			
			//�g�����U�N�V��������
			sdb.setTransactionSuccessful();
			
		}finally{
			//�g�����U�N�V�����I��
			sdb.endTransaction();
		}
		
		
		
		
	}
	//�S���擾
	public Cursor getAllKakeibo(){
			
		Cursor cursor = null;
			
		//SQL��ݒ�
		StringBuilder sql = new StringBuilder();  
		sql.append(" SELECT * FROM kakeibo;");  
			        
		//SQL�����s����       
		try{  
			cursor = sdb.rawQuery(sql.toString(), null);   
		}
		catch(Exception ex){
			Log.v("DBTEST", "InsertError:" + ex.getMessage());
		}
		
		return cursor;
	}

	
	
	}


