package com.testpolicymanager;



import adminrules.DeviceAdminSample;
import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageButton;
import android.widget.ToggleButton;

import com.testpolicymanager.*;

public class MainActivity extends Activity implements
OnCheckedChangeListener{
	protected ImageButton butToPassWindow;
	protected ImageButton butToDataWipe;
	protected ImageButton butToDeviceLock;
	protected ImageButton butToEncryption;
	protected ImageButton butToCamera;
	DevicePolicyManager mDPM;
    public static ComponentName mDeviceAdminSample;
    ToggleButton toggleButton;
    Button testButton;
    protected EditText testEdit;
    static final String TAG = "MainActivity";
    private static final int REQUEST_CODE_ENABLE_ADMIN = 47;
    private static final int REQUEST_CODE_DATA_WIPE = 1;
    private static final int REQUEST_CODE_DEVICE_LOCK = 2;
    private static final int REQUEST_CODE_CAMERA = 3;
   private static final int REQUEST_CODE_ENCRYPTION = 4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mDPM = (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);
	    mDeviceAdminSample = new ComponentName(this, DeviceAdminSample.class);
		setContentView(R.layout.main);
		toggleButton = (ToggleButton) findViewById(R.id.toggleButton1);
		toggleButton.setOnCheckedChangeListener(this);
		butToPassWindow = (ImageButton) findViewById(R.id.btnToPassWindow);
		butToDataWipe = (ImageButton) findViewById(R.id.btnToDataWipe);
		butToDeviceLock = (ImageButton) findViewById(R.id.btnToDeviceLock);
		butToEncryption = (ImageButton) findViewById(R.id.btnToEncryption);
		butToCamera = (ImageButton) findViewById(R.id.btnToCamera);
		butToPassWindow.setOnClickListener(new OnClickListener() {
			 @Override
			    public void onClick(View view) {
				 Intent intent = new Intent(MainActivity.this, PasswordActivity.class);
				    startActivity(intent);
			    }
			});
		butToDeviceLock.setOnClickListener(new OnClickListener() {
			 @Override
			    public void onClick(View view) {
				 Intent intent = new Intent(MainActivity.this, DeviceLock.class);
				    startActivityForResult(intent,REQUEST_CODE_DEVICE_LOCK);
			    }
			});
		butToCamera.setOnClickListener(new OnClickListener() {
			 @Override
			    public void onClick(View view) {
				 Intent intent = new Intent(MainActivity.this, Camera.class);
				    startActivityForResult(intent,REQUEST_CODE_CAMERA);
			    }
			});
		butToEncryption.setOnClickListener(new OnClickListener() {
			 @Override
			    public void onClick(View view) {
				 Intent intent = new Intent(MainActivity.this, Encryption.class);
				    startActivityForResult(intent,REQUEST_CODE_ENCRYPTION);
			    }
			});
		butToDataWipe.setOnClickListener(new OnClickListener() {
			 @Override
			    public void onClick(View view) {
				 Intent intent = new Intent(MainActivity.this, DataWipe.class);
				    startActivityForResult(intent,REQUEST_CODE_DATA_WIPE);
			    }
			});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	public void onCheckedChanged(CompoundButton button, boolean isChecked) {
		if (isChecked) {
			// Activate device administration
			Intent intent = new Intent(
					DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
			intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN,
					mDeviceAdminSample);
			intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION,
					R.string.add_admin_extra_app_text);
			startActivityForResult(intent, REQUEST_CODE_ENABLE_ADMIN);
		}
		Log.d(TAG, "onCheckedChanged to: " + isChecked);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
		case REQUEST_CODE_ENABLE_ADMIN:
			if (resultCode == Activity.RESULT_OK) {
				Log.i(TAG, "Administration enabled!");
				toggleButton.setChecked(true);
			} else {
				Log.i(TAG, "Administration enable FAILED!");
				toggleButton.setChecked(false);
			}
			break;
		case REQUEST_CODE_DATA_WIPE:
			if ((mDPM.isAdminActive(mDeviceAdminSample)) && (resultCode == Activity.RESULT_OK)){
				int wipe = data.getIntExtra("temp", 0);
				mDPM.setMaximumFailedPasswordsForWipe(mDeviceAdminSample, wipe);
			}
			break;
			
		case REQUEST_CODE_DEVICE_LOCK:
			if ((mDPM.isAdminActive(mDeviceAdminSample)) && (resultCode == Activity.RESULT_OK)){
			int lock = data.getIntExtra("temp", 0);
			mDPM.setMaximumTimeToLock(mDeviceAdminSample, lock);
			}
			break;
		case REQUEST_CODE_CAMERA:
			if ((mDPM.isAdminActive(mDeviceAdminSample)) && (resultCode == Activity.RESULT_OK)){
			boolean disable = data.getBooleanExtra("dis", false);
			mDPM.setCameraDisabled(mDeviceAdminSample, disable);
			}
			break;
		case REQUEST_CODE_ENCRYPTION:
			if ((mDPM.isAdminActive(mDeviceAdminSample)) && (resultCode == Activity.RESULT_OK)){
			boolean encryption = data.getBooleanExtra("enc", false);
			mDPM.setStorageEncryption(mDeviceAdminSample, encryption);
			}
			break;
		
			
		}
		super.onActivityResult(requestCode, resultCode, data);
	}
public static ComponentName getAdmin()
{
	return mDeviceAdminSample;
}
}
