package com.example.dropdownspinner;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class PopupListActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				getApplicationContext(), android.R.layout.simple_list_item_1,
				android.R.id.text1, new String[] { "a", "b", "c" });

		setListAdapter(adapter);

	}

	@Override
	public void onAttachedToWindow() {
		// TODO Auto-generated method stub
		super.onAttachedToWindow();

	}
}
