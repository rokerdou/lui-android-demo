package cn.iolove.android.lui.model;

import java.util.HashMap;

import android.util.Log;
import android.widget.LinearLayout.LayoutParams;


public class ViewModel implements UIModel {


public HashMap hm= new HashMap();
public void setAttrs(HashMap hmm)
{
	hm=(HashMap) hmm.clone();
}
@Override
public void setMarginleft(String p) {
	hm.put("Marginleft", Integer.parseInt(p));
	
}

@Override
public void setMargintop(String p) {
	
	hm.put("Marginleft", Integer.parseInt(p));
}

@Override
public void setWidth(String p) {
	hm.put("Marginleft", Integer.parseInt(p));
	
}

@Override
public void setHeight(String p) {
	hm.put("Height", Integer.parseInt(p));
	
}

@Override
public int getMarginleft() {
	// TODO Auto-generated method stub
	return Integer.parseInt((String)hm.get("Marginleft"));
}

@Override
public int getMargintop() {
	// TODO Auto-generated method stub
	return Integer.parseInt((String) hm.get("Margintop"));
}

@Override
public int getWidth() {
	// TODO Auto-generated method stub
	return Integer.parseInt((String)hm.get("Width")) ;
}

@Override
public int getHeight() {
	// TODO Auto-generated method stub
	return  Integer.parseInt((String)hm.get("Height"));
}
@Override
public void SetBackgroundColor(String p) {
	// TODO Auto-generated method stub
	hm.put("BackgroundColor", p);
}
public String toString()
{
	String strr = new String();
	// TODO Auto-generated method stub
	
	for (Object key : hm.keySet()) {
		
		   String  value = (String) hm.get(key);
		   strr= strr+ " "+key+":"+value;
		}
	//Log.i("jjj", "viewmodel.."+strr);
	return strr;
	
}
@Override
public String getBackgroundColor() {
	String strr = new String();
	// TODO Auto-generated method stub
	String temp = (String) hm.get("BackgroundColor");
	for (Object key : hm.keySet()) {
		
		   String  value = (String) hm.get(key);
		   strr= strr+ " "+key+":"+value;
		}
	//Log.i("jjj", "viewmodel.."+strr);
	return (String) hm.get("BackgroundColor");
}
}
