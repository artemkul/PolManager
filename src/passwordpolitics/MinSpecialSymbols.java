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

public class MinSpecialSymbols extends Activity {
	protected Button mButOK;
	protected TextView mInfo;
	protected EditText mNewInfo;
	protected DevicePolicyManager mDPM;
	protected TextView mPoliticGlobal;
	protected TextView mPoliticLocal;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_min_spetial_symbols);
		mDPM = (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);
		mButOK = (Button) findViewById(R.id.butOkSpecial);
		mInfo = (TextView) findViewById(R.id.textMinSpetialPolitics);
		mNewInfo = (EditText) findViewById(R.id.editMinSpecial);
		mInfo.setText("Current Value of this politic: "+mDPM.getPasswordMinimumSymbols(null));
		mPoliticGlobal = (TextView) findViewById(R.id.textMinSpecialSymGlobal);
		mPoliticLocal = (TextView) findViewById(R.id.textMinSpecialSymLocal);
		mPoliticGlobal.setText("Current Value of GLOBAL politic" + mDPM.getPasswordMinimumSymbols(null));
		if (mDPM.isAdminActive(MainActivity.mDeviceAdminSample))
			{
				mPoliticLocal.setText("Current Value of LOCAL politic" + mDPM.getPasswordMinimumSymbols(MainActivity.mDeviceAdminSample));
			}
		else
			{
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
						mDPM.setPasswordMinimumSymbols(MainActivity.mDeviceAdminSample, newMinLen);
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
	