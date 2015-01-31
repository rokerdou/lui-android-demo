package cn.iolove.android.lui;



import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.util.EncodingUtils;
import org.keplerproject.luajava.LuaObject;
import org.keplerproject.luajava.LuaState;
import org.keplerproject.luajava.LuaStateFactory;

import cn.iolove.android.lui.Context.RuntimeContext;
import cn.iolove.android.lui.model.Luadata;
import cn.iolove.android.lui.utils.Utils;
import cn.iolove.android.lui.view.BaseView;
import cn.iolove.android.lui.view.View;


import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends BootActivity {
	View container;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
  
		
		RuntimeContext.getInstance().setContext(this) ;
		RuntimeContext.getInstance().getPageController().setRuntimeContext(RuntimeContext.getInstance());
		RuntimeContext.getInstance().getPageController().pushpage("main");
		//container = new View(RuntimeContext.getInstance());
		
		container=(RuntimeContext.getInstance().getPageController().getTopPage());
		setContentView(container);
             

		
		
	
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


	@Override
	public void Refresh() {
		container.removeAllView(container);
		container.removeAllViews();
		RuntimeContext.getInstance().getPageController().getTopPage().setContentView(RuntimeContext.getInstance().getPageController().getTopPage());
		container=(RuntimeContext.getInstance().getPageController().getTopPage());
		//setContentView(container);
		
	}
	

}
