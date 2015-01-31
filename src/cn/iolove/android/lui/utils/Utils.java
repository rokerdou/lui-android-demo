package cn.iolove.android.lui.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;



import org.apache.http.util.EncodingUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.keplerproject.luajava.LuaState;

import cn.iolove.android.lui.Context.RuntimeContext;
import cn.iolove.android.lui.model.Luadata;

import android.content.Context;
import android.util.Log;

public class Utils {
	public static Luadata readLuaData(){
		return null;
		
	}
	public static Luadata getMap4Json(Luadata root,String jsonString)  {        

        JSONObject jsonObject = null;
       
		try {
			jsonObject = new JSONObject(jsonString);

        Iterator keyIter = jsonObject.keys();         
        String key;         
        Object value;         
              
        
        while (keyIter.hasNext()) {         
        	
            key = (String) keyIter.next();   
            if(key.equals("subitems"))
            {
            	JSONArray arr = new JSONArray(jsonObject.get(key).toString());  
            	for (int i = 0; i < arr.length(); i++) {  
            	    JSONObject temp = (JSONObject) arr.get(i);  
            	   // getMap4Json(new Luadata(),temp.toString());
            	    root.addChild( getMap4Json(new Luadata(),temp.toString()));
            	}  
            
            }
            else
            {
          //  Log.i("xxx", "key "+key);
            Log.i("xxx", key+" "+jsonObject.get(key).toString());
            value = jsonObject.get(key);         
           //valueMap.put(key, value);   
            if(key.equals("Marginleft")||key.equals("Width"))
            {
            	String v = jsonObject.get(key).toString();
            	v=v.substring(0, v.length()-1);
            	int relativev= Integer.parseInt(v);
            	int w=RuntimeContext.getInstance().getDevice().getScreenWidth();
            	int realv=(w*relativev)/100;
            	
            	root.addAttrs(key,new Integer(realv).toString());
            }
            else
            	if(key.equals("Margintop")||key.equals("Height"))
            	{
                	String v = jsonObject.get(key).toString();
                	v=v.substring(0, v.length()-1);
                	int relativev= Integer.parseInt(v);
                	int h=RuntimeContext.getInstance().getDevice().getScreenHeight();
                	int realv=(h*relativev)/100;
                	
                	root.addAttrs(key,new Integer(realv).toString());
            		
            	}
            	else

            	root.addAttrs(key, jsonObject.get(key).toString());
            }
        }         
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return root;         
    }         
	public static void exceuteLuaFuction(LuaState lua,String name)
	{
		int i = lua.getTop();
		lua.getField(LuaState.LUA_GLOBALSINDEX, name);
		//lua.call(0, 0);
		int status = lua.pcall(0, 0, 0);
		if(status!=0)
		{
			RuntimeContext.getInstance().showError(lua.toString(-1).toString());
		}
		lua.setTop(i);

		
	}
	public static void setGlobalObject(LuaState mLuaState,String name,Object obj)
	
	{
		//mLuaState.pushObjectValue(obj);
		Log.i("jjj", "加入全局对象:"+name+" 类"+obj.getClass().getName());
		mLuaState.pushJavaObject(obj);
		mLuaState.setGlobal(name);
	}
	public static void readLuaTableData(LuaState mLuaState)
	{
		
		while(mLuaState.next(-2)!=0)
		{
			if(mLuaState.toString(-2).equals("subitems"))
			{
				//mLuaState.getTable(-1);
				mLuaState.pushNil();
				readLuaTableData(mLuaState);
			}else
			{
		
			Log.i("xxx", mLuaState.toString(-2)+" "+ " "+mLuaState.toString(-1));
			
			//container.setBackgroundColor(Color.parseColor((mLuaState.toString(-1))));
			
			}
			mLuaState.pop(1);
		}
	}
	public static String loadAssetsString(String resPath,Context co) {
		InputStream isread = null;
		byte[] luaByte = new byte[1];
		try { 
			isread = co.getAssets().open(resPath);
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
}
