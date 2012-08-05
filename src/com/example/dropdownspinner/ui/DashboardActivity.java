package com.example.dropdownspinner.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.example.dropdownspinner.R;

public class DashboardActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dashboard);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_dashboard, menu);
		return true;
	}

	public void startPopupWindowDropdownActivity(View view) {

		Intent intent = new Intent(getApplicationContext(),
				PopupWindowDropdownActivity.class);
		intent.setAction(Intent.ACTION_VIEW);
		startActivity(intent);

	}
	
	public void startAutoCompleteDropdownActivity(View view) {

		Intent intent = new Intent(getApplicationContext(),
				AutoCompleteDropdownActivity.class);
		intent.setAction(Intent.ACTION_VIEW);
		startActivity(intent);

	}
	
	
}