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
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view);
		db = new DBManager(this);
		refreshList();
		Button kakobtn = (Button)findViewById(R.id.kakikomibtn);
		kakobtn.setOnClickListener(this);

	
	}
	
	//ListView�ɓ��L�̓��e��\������
		private void refreshList(){
			
			//DB����������
			Cursor c = db.getAllKakeibo();
			
			ArrayAdapter<String> adapter = 
				new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
			// �A�C�e����ǉ����܂�
			while (c.moveToNext()){  
				String kekka = c.getString(0) + c.getString(1) + "�~" + c.getString(2) ;
				adapter.add(kekka);
			} 
			       
			ListView listView = (ListView)findViewById(R.id.listView1);
			// �A�_�v�^�[��ݒ肵�܂�
			listView.setAdapter(adapter);

		}

	@Override
	public void onClick(View v) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		
		switch(v.getId()){
			case R.id.kakikomibtn:
				Intent intent2 = new Intent();
				intent2.setClassName("kadai.kakeibo", "kadai.kakeibo.MainActivity");
				startActivity(intent2);
		
		
		
		}
		
	}


}
