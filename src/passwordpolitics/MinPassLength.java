package passwordpolitics;



import android.app.Activity;
import android.app.admin.DeviceAdminInfo;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
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

import com.testpolicymanager.MainActivity;
import com.testpolicymanager.R;
import com.testpolicymanager.R.id;
import com.testpolicymanager.R.layout;

public class MinPassLength extends Activity {
	protected EditText mEdtPassLen;
	protected MainActivity mActivity;
	private Button mOkPassLen;
	protected TextView minPassValue;
	protected TextView mPoliticGlobal;
	protected TextView mPoliticLocal;
	protected DevicePolicyManager mDPM;
    //protected ComponentName mDeviceAdminSample;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.activity_min_pass_length);
		mDPM = (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);
		minPassValue = (TextView) findViewById(R.id.minPassValue);
		mOkPassLen = (Button) findViewById(R.id.butOkPassLen);
		mEdtPassLen = (EditText) findViewById(R.id.editPassLen);
		mPoliticLocal = (TextView) findViewById(R.id.textMinPassLenLocal);
		mPoliticGlobal = (TextView) findViewById(R.id.textMinPasLenGlobal);
		mPoliticGlobal.setText("Current Value of GLOBAL politic" + mDPM.getPasswordMinimumLength(null));
		if (mDPM.isAdminActive(MainActivity.mDeviceAdminSample))
		{
			mPoliticLocal.setText("Current Value of LOCAL politic" + mDPM.getPasswordMinimumLength(MainActivity.mDeviceAdminSample));
		}
	else
		{
			mPoliticLocal.setText("Please, activate admin rules");
		}
		mDPM = (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);
		minPassValue.setText("Current Value of this politic: "+mDPM.getPasswordMinimumLength(null));
			mOkPassLen.setOnClickListener(new OnClickListener() {
		  		 @Override
				    public void onClick(View view) {
					 if ((mEdtPassLen.getTextSize()>0) && (mDPM.isAdminActive(MainActivity.mDeviceAdminSample)))
						{	
							int newMinLen = Integer.parseInt(mEdtPassLen.getText().toString()) ;
							mDPM.setPasswordQuality(
									MainActivity.mDeviceAdminSample,DevicePolicyManager.PASSWORD_QUALITY_UNSPECIFIED);
							mDPM.setPasswordMinimumLength(MainActivity.mDeviceAdminSample, newMinLen);
							finish();
						}
					  
				    }
				});
			
		
	}
}
