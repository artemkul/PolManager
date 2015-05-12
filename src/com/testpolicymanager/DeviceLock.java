package com.testpolicymanager;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DeviceLock extends Activity {
	protected Button mOk;
	protected EditText mNewInfo;
	protected TextView mInfo;
	protected DevicePolicyManager mDPM;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_device_lock);
		mOk = (Button) findViewById(R.id.butOkDeviceLock);
		mNewInfo = (EditText) findViewById(R.id.editDeviceLock);
		mInfo = (TextView) findViewById(R.id.textDeviceLock);
		//mInfo.setText("Current Value of NULL politic: "+mDPM.getMaximumTimeToLock(null));
		mOk.setOnClickListener(new OnClickListener() {
	  		 @Override
			    public void onClick(View view) {
	  			 if (mNewInfo.getTextSize()>0)
	  			 {
	  				 Intent intent = new Intent();
	  				 intent.putExtra("temp" , Integer.parseInt(mNewInfo.getText().toString()));
	  				 setResult(RESULT_OK, intent);
	  				 finish();
	  			 }	 
	  		 }
	  		 });
	  		 
	}
}
