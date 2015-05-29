package kadai.kakeibo;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ViewActivity extends Activity implements OnClickListener{
	
	DBManager db = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自動生成されたメソッド・スタブ
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view);
		db = new DBManager(this);
		refreshList();
		Button kakobtn = (Button)findViewById(R.id.kakikomibtn);
		kakobtn.setOnClickListener(this);

	
	}
	
	//ListViewに日記の内容を表示する
		private void refreshList(){
			
			//DBを検索する
			Cursor c = db.getAllKakeibo();
			
			ArrayAdapter<String> adapter = 
				new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
			// アイテムを追加します
			while (c.moveToNext()){  
				String kekka = c.getString(0) + c.getString(1) + "円" + c.getString(2) ;
				adapter.add(kekka);
			} 
			       
			ListView listView = (ListView)findViewById(R.id.listView1);
			// アダプターを設定します
			listView.setAdapter(adapter);

		}

	@Override
	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ
		
		switch(v.getId()){
			case R.id.kakikomibtn:
				Intent intent2 = new Intent();
				intent2.setClassName("kadai.kakeibo", "kadai.kakeibo.MainActivity");
				startActivity(intent2);
		
		
		
		}
		
	}


}
