package com.kadai.kaneki;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Saving_frame_input extends Activity implements OnClickListener {

	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.saving_frame_input);
	        
	        Button btn1 = (Button)findViewById(R.id.btn_touroku); //ボタンを探してくる
	        btn1.setOnClickListener(this); //ボタンにリスナーを登録する
	        
	    }

	@Override
	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ
		
		switch(v.getId()){ //どのボタンが押されたか判定
		case R.id.btn_touroku: //btn_tyokinが押された
			
			//エディットテキストを探してくる
			EditText edit = (EditText)findViewById(R.id.Etext_tyokin);
			//入力された数値を取得
	        String str = edit.getText().toString();
	        //取得した数値(String)をint型に変換
	        int i = Integer.parseInt(str);
	        
	        //テキストビューを探してくる
	        TextView test = (TextView) findViewById(R.id.test);
	        test.setText(i);
		}
	}
}
