package passwordpolitics;

import com.testpolicymanager.MainActivity;
import com.testpolicymanager.R;
import com.testpolicymanager.R.layout;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HistoryLength extends Activity {
	protected Button mButOK;
	protected Button mButOKTimeout;
	protected TextView mInfo;
	protected EditText mNewInfo;
	protected EditText mNewInfoTimeout;
	protected DevicePolicyManager mDPM;
	protected TextView mPoliticGlobal;
	protected TextView mPoliticLocal;
	protected TextView mPoliticGlobalTimeout;
	protected TextView mPoliticLocalTimeout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_history_length);
		mDPM = (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);
		mNewInfo = (EditText) findViewById(R.id.editHistory);
		mNewInfoTimeout = (EditText) findViewById(R.id.editTimeout);
		mButOK = (Button) findViewById(R.id.butHistoryLen);
		mButOKTimeout = (Button) findViewById(R.id.butOkTimeout);
		mPoliticGlobalTimeout = (TextView) findViewById(R.id.textTimeoutGlobal);
		mPoliticLocalTimeout = (TextView) findViewById(R.id.textTimeoutLocal );
		mPoliticGlobal = (TextView) findViewById(R.id.textHistoryLenGlobal);
		mPoliticLocal = (TextView) findViewById(R.id.textHistoryLenLocal);
		mPoliticGlobalTimeout.setText("Current Value of this politic: "+mDPM.getPasswordExpirationTimeout(null));
		mPoliticGlobal.setText("Current Value of this politic: "+mDPM.getPasswordHistoryLength(null));
		if (mDPM.isAdminActive(MainActivity.mDeviceAdminSample))
		{
			mPoliticLocalTimeout.setText("Current Value of this politic: "+mDPM.getPasswordExpirationTimeout(MainActivity.mDeviceAdminSample));
			mPoliticLocal.setText("Current Value of this politic: "+mDPM.getPasswordHistoryLength(MainActivity.mDeviceAdminSample));

		}
		else
		{
			mPoliticLocalTimeout.setText("Please, activate admin rules");
			mPoliticLocal.setText("Please, activate admin rules");
		}
		mButOK.setOnClickListener(new OnClickListener() {
	  		 @Override
			    public void onClick(View view) {
	  			 if(mDPM.isAdminActive(MainActivity.mDeviceAdminSample))
	  			 {
	  				 if (mNewInfo.getTextSize()>0)
	  				 {	
	  					 int newMinLen = Integer.parseInt(mNewInfo.getText().toString()) ;
						mDPM.setPasswordHistoryLength(MainActivity.mDeviceAdminSample, newMinLen);
	  					 finish();
	  				 }
	  			 }
	  			 else
	  			 {
	  				mPoliticGlobal.setText("Admin not activate. Please, activate admin`s rules"); 
	  			 }
				  
			    }
			});
		mButOKTimeout.setOnClickListener(new OnClickListener() {
	  		 @Override
			    public void onClick(View view) {
	  			 if(mDPM.isAdminActive(MainActivity.mDeviceAdminSample))
	  			 {
	  				 if (mNewInfoTimeout.getTextSize()>0)
	  				 {	
	  					 int newMinLen = Integer.parseInt(mNewInfoTimeout.getText().toString()) ;
						mDPM.setPasswordExpirationTimeout(MainActivity.mDeviceAdminSample, newMinLen);
	  					 finish();
	  				 }
	  			 }
	  			 else
	  			 {
	  				mPoliticGlobal.setText("Admin not activate. Please, activate admin`s rules"); 
	  			 }
				  
			    }
			});
	
	}
}
