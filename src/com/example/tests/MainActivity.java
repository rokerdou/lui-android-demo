package com.example.tests;

import cn.iolove.lui.Activity.BootActivity;
import cn.iolove.lui.Activity.PageContainerActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends BootActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
