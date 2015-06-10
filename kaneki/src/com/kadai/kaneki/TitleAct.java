package com.kadai.kaneki;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class TitleAct extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自動生成されたメソッド・スタブ
		super.onCreate(savedInstanceState);
		setContentView(R.layout.title);
		
		 // スプラッシュ画面から、2秒（2000ミリ秒)後に遷移する。
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(TitleAct.this, MainActivity.class);
                startActivity(intent);
  
                // アクティビティを終了させることで、スプラッシュ画面に戻ることを防ぐ。
                TitleAct.this.finish();
            }
        }, 2000);
		
		
	}

}
