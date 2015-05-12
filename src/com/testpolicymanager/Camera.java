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
import android.widget.CheckBox;
import android.widget.TextView;

public class Camera extends Activity {
	protected CheckBox mCheck;
	protected Button mOk;
	protected TextView mInfo;
	protected TextView mInfoLocal;
	protected DevicePolicyManager mDPM;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_camera);
		mCheck = (CheckBox) findViewById(R.id.checkDisable);
		mOk = (Button) findViewById(R.id.butOkCamera);
		mInfo = (TextView) findViewById(R.id.textCamera);
		mInfoLocal = (TextView) findViewById(R.id.textCameraLocal);
		mDPM = (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);
		mInfo.setText("Carrent Value of NULL politic: "+mDPM.getCameraDisabled(null));
		if (mDPM.isAdminActive(MainActivity.mDeviceAdminSample))
		{
			mInfoLocal.setText("Carrent Value of LOCAL politic: "+mDPM.getCameraDisabled(MainActivity.mDeviceAdminSample));
		}
		else
		{
			mInfoLocal.setText("Please, activate admin rules in main menu!");
		}
		mOk.setOnClickListener(new OnClickListener() {
	  		 @Override
			    public void onClick(View view) {
	  			if (mDPM.isAdminActive(MainActivity.mDeviceAdminSample))
	  			{
	  			 	 boolean temp = mCheck.isChecked();
	  				 Intent intent = new Intent();
	  				 intent.putExtra("dis" , temp);
	  				 setResult(RESULT_OK, intent);
	  				 finish();
	  			}
	  		 }
	  		 });
	}
}
