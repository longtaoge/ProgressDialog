package org.xiangbalao.progressdialog;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends Activity {
	protected ProgressDialog dialog;

	private Button button;
	
	private Handler mHandler= new Handler(){

		@Override
		public void handleMessage(Message msg) {
			
			
			dialog.dismiss();
			
			
			
			super.handleMessage(msg);
		}
		
		
	};
	
	
	
	
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

	
		
		
		dialog = ProgressDialog.createDialog(this);
		dialog.setMessage("数据加载中...");
		dialog.show();
		mHandler.sendEmptyMessageDelayed(0, 5000);
		
		
		button=(Button) findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
				if (!dialog.isShowing()) {
					dialog.show();
					mHandler.sendEmptyMessageDelayed(0, 5000);
				}
				
				
			}
		});
		
		
		
	}

}
