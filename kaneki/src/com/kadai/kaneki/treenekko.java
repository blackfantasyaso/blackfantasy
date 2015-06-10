package com.kadai.kaneki;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.graphics.*;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;

public class treenekko extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	class SampleView extends View {
		
		Paint paint = new Paint();
		
	    //âÊëúì«Ç›çûÇ›
	    Resources res = this.getContext().getResources();
	    Bitmap nekko = BitmapFactory.decodeResource(res, R.drawable.nekko);
	    
	    public SampleView(Context context) {
	        super(context);
	    }
	    
	    @Override
	    public void onDraw(Canvas c) {
	    	 c.drawBitmap(nekko, 0, 0, paint);
	    }
	}	
}

