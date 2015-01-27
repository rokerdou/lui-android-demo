package cn.iolove.android.lui;

import org.keplerproject.luajava.LuaState;

import cn.iolove.android.lui.Context.RuntimeContext;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class BootActivity extends Activity {
	private RuntimeContext runcontext;
	LinearLayout container;
	protected void onCreate(Bundle savedInstanceState) {
		 container = new LinearLayout(this);
		setContentView(container);
	}
}
