package com.example.dropdownspinner;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RelativeLayout.LayoutParams;

public class DropdownSpinnerActivity extends Activity {

	String TAG = DropdownSpinnerActivity.class.getSimpleName();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dropdown_spinner);


		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_dropdown_item_1line, COUNTRIES);
		final InstantAutoComplete textView = (InstantAutoComplete) findViewById(R.id.countries_list);
		textView.setAdapter(adapter);

		final EditText editText = (EditText) findViewById(R.id.editText);

		editText.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				final LayoutInflater inflater = (LayoutInflater) DropdownSpinnerActivity.this
						.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

				PopupListActivity popupListActivity = new PopupListActivity();
				popupListActivity.onCreate(null);
				final View view= popupListActivity.getListView();
				/*final View view = inflater
						.inflate(
								R.layout.popup_layout,
								(ViewGroup) findViewById(R.layout.activity_dropdown_spinner));*/
				final PopupWindow pw = new PopupWindow(view, 100, 100, true);
				// pw.showAtLocation(findViewById(R.id.editText),
				// Gravity.CENTER, 0, 0);

				findViewById(R.id.editText).post(new Runnable() {
					public void run() {

						pw.showAsDropDown(findViewById(R.id.editText), 0, 0);
						/*ListView lv = (ListView) view.findViewById(R.id.lv);

						ArrayAdapter<String> adapter = new ArrayAdapter<String>(
								getApplicationContext(),
								android.R.layout.simple_list_item_1,
								android.R.id.text1, new String[] { "a", "b",
										"c" });

						lv.setAdapter(adapter);*/

						// pw.showAtLocation(findViewById(R.id.editText),
						// Gravity.CENTER, 0, 0);
					}
				});
				/*
				 * PopupWindow popupWindow = new PopupWindow(
				 * getApplicationContext());
				 * popupWindow.setContentView(getLayoutInflater().inflate(
				 * R.layout.popup_layout, null));
				 * 
				 * popupWindow.setHeight(300); popupWindow.setWidth(300);
				 * popupWindow.showAsDropDown(DropdownSpinnerActivity.this
				 * .getWindow().getDecorView());
				 */

				/*
				 * Intent intent = new Intent(getApplicationContext(),
				 * PopupListActivity.class);
				 * intent.setAction(Intent.ACTION_VIEW); startActivity(intent);
				 */
			}
		});
		Log.i(TAG, "EditText Params = " + editText.getLayoutParams().width
				+ ", " + editText.getLayoutParams().width);

		Log.i(TAG, "EditText Params : Baseline =  " + editText.getBaseline()
				+ ", Bottom " + editText.getBottom());

		Log.i(TAG, "textView Params = " + textView.getLayoutParams().width
				+ ", " + textView.getLayoutParams().width);

		Log.i(TAG, "textView Params : Baseline =  " + textView.getBaseline()
				+ ", Bottom " + textView.getBottom());

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

	private static final String[] COUNTRIES = new String[] { "Belgium",
			"France", "Italy", "Germany", "Spain" };

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_dropdown_spinner, menu);
		return true;
	}

	public static Rect locateView(View v) {
		int[] location = new int[2];
		if (v == null)
			return null;
		try {
			v.getLocationOnScreen(location);
		} catch (NullPointerException npe) {
			// Happens when the view doesn't exist on screen anymore.
			return null;
		}
		Rect rect = new Rect();
		rect.left = location[0];
		rect.top = location[1];
		rect.right = rect.left + v.getWidth();
		rect.bottom = rect.top + v.getHeight();
		return rect;
	}
}
