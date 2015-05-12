package com.testpolicymanager;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DataWipe extends Activity {
	protected Button mOk;
	protected EditText mNewInfo;
	protected TextView mInfo;
	protected TextView mInfoLocal;
	protected DevicePolicyManager mDPM;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_data_wipe);
		mOk = (Button) findViewById(R.id.butOkDataWipe);
		mNewInfo = (EditText) findViewById(R.id.editDataWipeTime);
		mInfo = (TextView) findViewById(R.id.textDataWipe);
		mInfoLocal = (TextView) findViewById(R.id.textDataWipeLocal);
		mDPM = (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);
		mInfo.setText("Carrent Value of NULL politic: "+mDPM.getMaximumFailedPasswordsForWipe(null));
		if (mDPM.isAdminActive(MainActivity.mDeviceAdminSample))
		{
		mInfoLocal.setText("Carrent Value of LOCAL politic: "+mDPM.getMaximumFailedPasswordsForWipe(MainActivity.mDeviceAdminSample));
		}
		else
		{
			mInfoLocal.setText("Please, activate admin rules in main menu!");
		}
		mOk.setOnClickListener(new OnClickListener() {
	  		 @Override
			    public void onClick(View view) {
	  			 if ((mNewInfo.getTextSize()>0) && (mDPM.isAdminActive(MainActivity.mDeviceAdminSample)))
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
