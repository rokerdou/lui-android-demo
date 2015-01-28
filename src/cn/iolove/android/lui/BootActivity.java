package cn.iolove.android.lui;

import org.keplerproject.luajava.LuaState;

import cn.iolove.android.lui.Context.RuntimeContext;
import cn.iolove.android.lui.view.BaseView;
import cn.iolove.android.lui.view.View;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

public abstract class BootActivity extends Activity  {
	protected RuntimeContext runcontext;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
	
		runcontext=RuntimeContext.getInstance();

	}
	public  abstract void  Refresh();
}
