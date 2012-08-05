package com.example.dropdownspinner.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;

import com.example.dropdownspinner.R;
import com.example.dropdownspinner.ui.fragment.OtherFragment.onEditTextClickListener;

public class FragmentDropdownActivity extends FragmentActivity implements
		onEditTextClickListener {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragment_dropdown);
		
		
		FragmentManager fragmentManager = FragmentDropdownActivity.this.getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager
				.beginTransaction();
		
		View fragment = FragmentDropdownActivity.this
				.findViewById(R.id.testListFragment);
		fragment.setVisibility(View.GONE);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_fragment_dropdown, menu);
		return true;
	}

	@Override
	public void onEditTextClick(boolean bool) {
		// TODO Auto-generated method stub

		View fragment = FragmentDropdownActivity.this
				.findViewById(R.id.testListFragment);

		if (fragment.getVisibility() == View.VISIBLE) {
			fragment.setVisibility(View.GONE);
		} else {
			fragment.setVisibility(View.VISIBLE);
		}

	}

}
