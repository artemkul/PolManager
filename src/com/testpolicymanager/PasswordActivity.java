package com.testpolicymanager;

import passwordpolitics.*;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class PasswordActivity extends Activity {
	protected Button butPMinPassLen;
	protected Button butPMinLet;
	protected Button butPPassQuality;
	protected Button butPLowercase;
	protected Button butPUppercase;
	protected Button butPNonletter;
	protected Button butPNumerics;
	protected Button butPMinSpecial;
	protected Button butPHistory;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_password);
		butPMinPassLen = (Button) findViewById(R.id.butMinPassLength);
		butPMinLet = (Button) findViewById(R.id.butMinLetters);
		butPPassQuality = (Button) findViewById(R.id.butPassQuallity);
		butPLowercase = (Button) findViewById(R.id.butMinLowercase);
		butPUppercase = (Button) findViewById(R.id.butMinUppercase);
		butPNonletter = (Button) findViewById(R.id.butMinNonletter);
		butPNumerics = (Button) findViewById(R.id.butMinNumerics);
		butPMinSpecial = (Button) findViewById(R.id.butMinSpecialSymb);
		butPHistory = (Button) findViewById(R.id.textMinSpetialPolitics);
		butPMinPassLen.setOnClickListener(new OnClickListener() {
			 @Override
			    public void onClick(View view) {
				 Intent intent = new Intent(PasswordActivity.this, MinPassLength.class);
				    startActivity(intent);
			    }
			});
		butPMinLet.setOnClickListener(new OnClickListener() {
			 @Override
			    public void onClick(View view) {
				 Intent intent = new Intent(PasswordActivity.this, MinPassLetters.class);
				    startActivity(intent);
			    }
			});
		butPPassQuality.setOnClickListener(new OnClickListener() {
			 @Override
			    public void onClick(View view) {
				 Intent intent = new Intent(PasswordActivity.this, PassQuality.class);
				    startActivity(intent);
			    }
			});
		butPLowercase.setOnClickListener(new OnClickListener() {
			 @Override
			    public void onClick(View view) {
				 Intent intent = new Intent(PasswordActivity.this, MinLowerLetters.class);
				    startActivity(intent);
			    }
			});
		butPUppercase.setOnClickListener(new OnClickListener() {
			 @Override
			    public void onClick(View view) {
				 Intent intent = new Intent(PasswordActivity.this, MinUpperLetters.class);
				    startActivity(intent);
			    }
			});
		butPNonletter.setOnClickListener(new OnClickListener() {
			 @Override
			    public void onClick(View view) {
				 Intent intent = new Intent(PasswordActivity.this, MinNonletterChars.class);
				    startActivity(intent);
			    }
			});
		butPNumerics.setOnClickListener(new OnClickListener() {
			 @Override
			    public void onClick(View view) {
				 Intent intent = new Intent(PasswordActivity.this, MinNumerics.class);
				    startActivity(intent);
			    }
			});
		butPMinSpecial.setOnClickListener(new OnClickListener() {
			 @Override
			    public void onClick(View view) {
				 Intent intent = new Intent(PasswordActivity.this, MinSpecialSymbols.class);
				    startActivity(intent);
			    }
			});
		butPHistory.setOnClickListener(new OnClickListener() {
			 @Override
			    public void onClick(View view) {
				 Intent intent = new Intent(PasswordActivity.this,HistoryLength.class);
				    startActivity(intent);
			    }
			});
		
		
		
	}
}
