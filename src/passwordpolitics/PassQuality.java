package passwordpolitics;

import com.testpolicymanager.MainActivity;
import com.testpolicymanager.PasswordActivity;
import com.testpolicymanager.R;
import com.testpolicymanager.R.layout;

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

public class PassQuality extends Activity {
	protected Button mButUNSPECIFIED;
	protected Button mButSOMETHING;
	protected Button mButNUMERIC;
	protected Button mButALPHABETIC;
	protected Button mButALPHANUMERIC;
	protected Button mButCOMPLEX;
	protected TextView mInfoGlobal;
	protected TextView mInfoLocal;
	protected EditText mNewInfo;
	protected DevicePolicyManager mDPM;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pass_quality);
		mDPM = (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);
		mButUNSPECIFIED = (Button) findViewById(R.id.butPassQualityUNSPECIFIED);
		mButSOMETHING = (Button) findViewById(R.id.butPassQualitySOMETHING);
		mButNUMERIC = (Button) findViewById(R.id.butPassQualityNUMERIC);
		mButALPHABETIC = (Button) findViewById(R.id.butPassQualityALPHABETIC);
		mButALPHANUMERIC = (Button) findViewById(R.id.butPassQualityALPHANUMERIC);
		mButCOMPLEX = (Button) findViewById(R.id.butPassQualityCOMPLEX);
		mInfoGlobal = (TextView) findViewById(R.id.textQualityGlobal);
		mInfoLocal = (TextView) findViewById(R.id.textQualityLocal);
		mInfoGlobal.setText("Current GLOBAL Value of this politic: "+mDPM.getPasswordQuality(null));
		 if(mDPM.isAdminActive(MainActivity.mDeviceAdminSample))
			 {
			 	mInfoLocal.setText("Current LOCAL Value of this politic: "+mDPM.getPasswordQuality(
			 			MainActivity.mDeviceAdminSample));
			 }
		 else
			 {
			 mInfoGlobal.setText("Admin not activate. Please, activate admin`s rules"); 
			 }
		mButUNSPECIFIED.setOnClickListener(new OnClickListener() {
	  		 @Override
			    public void onClick(View view) {
	  			 if(mDPM.isAdminActive(MainActivity.mDeviceAdminSample))
	  			 {
						mDPM.setPasswordQuality(MainActivity.mDeviceAdminSample,
								DevicePolicyManager.PASSWORD_QUALITY_UNSPECIFIED);
	  					 finish();
	  			 }
	  			 else
	  			 {
	  				mInfoGlobal.setText("Admin not activate. Please, activate admin`s rules"); 
	  			 }
				  
			    }
			});
		mButSOMETHING.setOnClickListener(new OnClickListener() {
	  		 @Override
			    public void onClick(View view) {
	  			 if(mDPM.isAdminActive(MainActivity.mDeviceAdminSample))
	  			 {
						mDPM.setPasswordQuality(MainActivity.mDeviceAdminSample,
								DevicePolicyManager.PASSWORD_QUALITY_SOMETHING);
	  					 finish();
	  			 }
	  			 else
	  			 {
	  				mInfoGlobal.setText("Admin not activate. Please, activate admin`s rules"); 
	  			 }
				  
			    }
			});
		mButNUMERIC.setOnClickListener(new OnClickListener() {
	  		 @Override
			    public void onClick(View view) {
	  			 if(mDPM.isAdminActive(MainActivity.mDeviceAdminSample))
	  			 {
						mDPM.setPasswordQuality(MainActivity.mDeviceAdminSample,
								DevicePolicyManager.PASSWORD_QUALITY_NUMERIC);
	  					 finish();
	  			 }
	  			 else
	  			 {
	  				mInfoGlobal.setText("Admin not activate. Please, activate admin`s rules"); 
	  			 }
				  
			    }
			});
		mButALPHABETIC.setOnClickListener(new OnClickListener() {
	  		 @Override
			    public void onClick(View view) {
	  			 if(mDPM.isAdminActive(MainActivity.mDeviceAdminSample))
	  			 {
						mDPM.setPasswordQuality(MainActivity.mDeviceAdminSample,
								DevicePolicyManager.PASSWORD_QUALITY_ALPHABETIC);
	  					 finish();
	  			 }
	  			 else
	  			 {
	  				mInfoGlobal.setText("Admin not activate. Please, activate admin`s rules"); 
	  			 }
				  
			    }
			});
		mButALPHANUMERIC.setOnClickListener(new OnClickListener() {
	  		 @Override
			    public void onClick(View view) {
	  			 if(mDPM.isAdminActive(MainActivity.mDeviceAdminSample))
	  			 {
						mDPM.setPasswordQuality(MainActivity.mDeviceAdminSample,
								DevicePolicyManager.PASSWORD_QUALITY_ALPHANUMERIC);
	  					 finish();
	  			 }
	  			 else
	  			 {
	  				mInfoGlobal.setText("Admin not activate. Please, activate admin`s rules"); 
	  			 }
				  
			    }
			});
		mButCOMPLEX.setOnClickListener(new OnClickListener() {
	  		 @Override
			    public void onClick(View view) {
	  			 if(mDPM.isAdminActive(MainActivity.mDeviceAdminSample))
	  			 {
						mDPM.setPasswordQuality(MainActivity.mDeviceAdminSample,
								DevicePolicyManager.PASSWORD_QUALITY_COMPLEX);
	  					 finish();
	  			 }
	  			 else
	  			 {
	  				mInfoGlobal.setText("Admin not activate. Please, activate admin`s rules"); 
	  			 }
				  
			    }
			});
	}
	@Override
	 public void onBackPressed() 
	{
		Intent intent = new Intent(this, MainActivity.class);
	    startActivity(intent);
	    finish();
	}
}
