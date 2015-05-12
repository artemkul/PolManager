package passwordpolitics;

import com.testpolicymanager.MainActivity;
import com.testpolicymanager.R;
import com.testpolicymanager.R.layout;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MinLowerLetters extends Activity {
protected Button mButOK;
protected TextView mInfo;
protected TextView mPoliticGlobal;
protected TextView mPoliticLocal;
protected EditText mNewInfo;
protected DevicePolicyManager mDPM;
//protected ComponentName mTempAdmin;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pass_lower_letters);
		mDPM = (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);
		mButOK = (Button) findViewById(R.id.butOkLowercase);
		mInfo = (TextView) findViewById(R.id.textLowerPolitics);
		mNewInfo = (EditText) findViewById(R.id.editLowercase);
		mPoliticGlobal = (TextView) findViewById(R.id.textLowerGlobal);
		mPoliticLocal = (TextView) findViewById(R.id.textLowerLocal);
		mPoliticGlobal.setText("Current Value of GLOBAL politic" + mDPM.getPasswordMinimumLowerCase(null));
		if (mDPM.isAdminActive(MainActivity.mDeviceAdminSample))
			{
				mPoliticLocal.setText("Current Value of LOCAL politic" + mDPM.getPasswordMinimumLowerCase(MainActivity.mDeviceAdminSample));
			}
		else
			{
				mPoliticLocal.setText("Please, activate admin rules");
			}
		//mTempAdmin = MainActivity.getAdmin();
		mInfo.setText("Carrent Value of this politic: "+mDPM.getPasswordMinimumLowerCase(null));
		mButOK.setOnClickListener(new OnClickListener() {
	  		 @Override
			    public void onClick(View view) {
	  			 if(  mDPM.isAdminActive(MainActivity.mDeviceAdminSample))
	  			 {
	  				 if (mNewInfo.getTextSize()>0)
	  				 {	
	  					 int newMinLen = Integer.parseInt(mNewInfo.getText().toString()) ;
						mDPM.setPasswordMinimumLowerCase(MainActivity.mDeviceAdminSample, newMinLen);
	  					 finish();
	  				 }
	  			 }
	  			 else
	  			 {
	  				mInfo.setText("Admin not activate. Please, activate admin`s rules"); 
	  			 }
				  
			    }
			});
	}
}
