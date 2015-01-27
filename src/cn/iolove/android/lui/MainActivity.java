package cn.iolove.android.lui;



import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.util.EncodingUtils;
import org.keplerproject.luajava.LuaObject;
import org.keplerproject.luajava.LuaState;
import org.keplerproject.luajava.LuaStateFactory;

import cn.iolove.android.lui.model.Luadata;
import cn.iolove.android.lui.utils.Utils;
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

public class MainActivity extends Activity {
	private LuaState mLuaState;
	View container;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        FrameLayout f = new FrameLayout(this);
		mLuaState = LuaStateFactory.newLuaState();
		
		 container = new View(this);
		
		mLuaState.openLibs();
		try {

			
			int error = mLuaState.LdoString(loadAssetsString("framework/ui.lua")+loadAssetsString("lua/main.lua"));
			if(error!=0)
			{
				new AlertDialog.Builder(this).setTitle("LUA错误").setMessage(mLuaState.toString(-1)).setPositiveButton("确定", null).show();
				return;
	
			}
		   mLuaState.getField(LuaState.LUA_GLOBALSINDEX, "onCreated");
		  // mLuaState.pushNumber(1);
			mLuaState.call(0, 1);
			//mLuaState.pushObjectValue(-1);
			mLuaState.setField(LuaState.LUA_GLOBALSINDEX, "resulttable");
			 mLuaState.getField(LuaState.LUA_GLOBALSINDEX, "table2json");
			 mLuaState.getGlobal("resulttable");
			 mLuaState.call(1, 1);
				mLuaState.setField(LuaState.LUA_GLOBALSINDEX, "json");
				 mLuaState.getGlobal("json");
				//new AlertDialog.Builder(this).setTitle("LUA").setMessage(mLuaState.toString(-1)).setPositiveButton("确定", null).show();
                Log.i("xxx", mLuaState.toString(-1));
                Luadata root=  Utils.getMap4Json(new Luadata(),mLuaState.toString(-1));
                Log.i("xxx","lua Object:"+ root.toString());
               
                container.setViewData(root);
                container.setContentView(container);
                f.addView(container);
                setContentView(f);
               // mLuaState.setTop(0);
		 // mLuaState.getGlobal("resulttable");
		  //LuaObject obj = mLuaState.getLuaObject("resulttable");
	
			//mLuaState.pushNil();
		//	Toast.makeText(this,obj.toString() , 2000).show();
		//	Utils.readLuaTableData(mLuaState);
		/*
			while(mLuaState.next(-2)!=0)
			{
				
				Log.i("xxx", "value: "+mLuaState.toString(-1));
				Log.i("xxx", "key: "+mLuaState.toString(-2));
				container.setBackgroundColor(Color.parseColor((mLuaState.toString(-1))));
				mLuaState.pop(1);
				
			}
			*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.print("打开失败");
			e.printStackTrace();
		}
		
		
		
	
	}
	private String loadAssetsString(String resPath) {
		InputStream isread = null;
		byte[] luaByte = new byte[1];
		try { 
			isread = this.getAssets().open(resPath);
			int len = isread.available();
			luaByte = new byte[len];
			isread.read(luaByte);
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			if (isread != null) {
				try {
					isread.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return EncodingUtils.getString(luaByte, "UTF-8");
	} 
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private String readStream(InputStream is) {
	
	        try {
	
	            ByteArrayOutputStream bo = new ByteArrayOutputStream();
	
	            int i = is.read();
	
	            while (i != -1) {
	
	                bo.write(i);
	
	               i = is.read();
	
	            }
	
	            return bo.toString();
	
	        } catch (IOException e) {
	
	        	e.printStackTrace();
	
	            return "";
	
	        }
	
	    }
}
