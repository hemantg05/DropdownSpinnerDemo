package com.example.dropdownspinner.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.example.dropdownspinner.R;

/**
 * This activity illustrates the use of PopupWindow class in android to show
 * dropdown list inside a scrollview. The example uses a static local list view
 * as drop down view.
 * 
 * @author hemant
 * 
 */
public class PopupWindowDropdownActivity extends Activity {

	EditText editText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_popup_window_dropdown);
		EditText editText = (EditText) findViewById(R.id.editText);

		editText.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				final LayoutInflater inflater = (LayoutInflater) PopupWindowDropdownActivity.this
						.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

				final View view = inflater
						.inflate(
								R.layout.popup_layout,
								(ViewGroup) findViewById(R.layout.activity_dropdown_spinner));

				final PopupWindow pw = new PopupWindow(view, 480, 200, true);
				pw.setBackgroundDrawable(new BitmapDrawable());
				pw.setOutsideTouchable(true);

				if (pw.isShowing()) {
					pw.dismiss();
				} else {
					findViewById(R.id.editText).post(new Runnable() {
						public void run() {

							pw.showAsDropDown(findViewById(R.id.editText), 0, 0);

							ListView lv = (ListView) view.findViewById(R.id.lv);

							ArrayAdapter<String> adapter = new ArrayAdapter<String>(
									getApplicationContext(),
									R.layout.simple_list_item, R.id.text1,
									new String[] { "a", "b", "c" });

							lv.setAdapter(adapter);
						}
					});

					findViewById(R.id.editText).postInvalidate();

				}

			}
		});

	}

}
