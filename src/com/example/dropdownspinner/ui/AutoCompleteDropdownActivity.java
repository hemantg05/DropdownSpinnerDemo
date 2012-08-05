package com.example.dropdownspinner.ui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RelativeLayout.LayoutParams;

import com.example.dropdownspinner.R;
import com.example.dropdownspinner.ui.widget.InstantAutoComplete;

public class AutoCompleteDropdownActivity extends Activity {

	private static final String[] COUNTRIES = new String[] { "Belgium",
			"France", "Italy", "Germany", "Spain" };

	private static final String TAG = AutoCompleteDropdownActivity.class
			.getSimpleName();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_auto_complete_dropdown);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_dropdown_item_1line, COUNTRIES);
		final InstantAutoComplete textView = (InstantAutoComplete) findViewById(R.id.countries_list);
		final EditText editText = (EditText) findViewById(R.id.editText);

		textView.setAdapter(adapter);

		textView.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				if (textView.isPopupShowing())
					textView.dismissDropDown();
				else
					textView.showDropDown();

				LayoutParams params = new LayoutParams(0, textView
						.getBaseline());

				Log.i(TAG,
						"EditText Params = " + editText.getLayoutParams().width
								+ ", " + editText.getLayoutParams().width);

				Log.i(TAG,
						"EditText Params : Baseline =  "
								+ editText.getBaseline() + ", Bottom "
								+ editText.getBottom());

				Log.i(TAG,
						"textView Params = " + textView.getLayoutParams().width
								+ ", " + textView.getLayoutParams().width);

				Log.i(TAG,
						"textView Params : Baseline =  "
								+ textView.getBaseline() + ", Bottom "
								+ textView.getBottom());

				editText.setLayoutParams(params);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_auto_complete_dropdown, menu);
		return true;
	}

}
