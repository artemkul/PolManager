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
import android.widget.CheckBox;
import android.widget.TextView;

public class Encryption extends Activity {
	protected CheckBox mCheck;
	protected Button mOk;
	protected TextView mInfo;
	protected DevicePolicyManager mDPM;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_encryption);
		mCheck = (CheckBox) findViewById(R.id.checkEncryption);
		mOk = (Button) findViewById(R.id.butOkEncryption);
		//mInfo = (TextView) findViewById(R.id.textEncryption);
		//mInfo.setText("Current Value of NULL politic: "+mDPM.getStorageEncryption(null));
		mOk.setOnClickListener(new OnClickListener() {
	  		 @Override
			    public void onClick(View view) {
	  			 	 boolean temp = mCheck.isChecked();
	  				 Intent intent = new Intent();
	  				 intent.putExtra("enc" , temp);
	  				 setResult(RESULT_OK, intent);
	  				 finish();
	  			  
	  		 }
	  		 });
	}
}
