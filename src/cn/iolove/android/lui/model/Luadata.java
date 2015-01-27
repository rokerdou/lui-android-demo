package cn.iolove.android.lui.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Luadata {
	private HashMap attrs= new HashMap();
	private List  ChildArray = new ArrayList();
	public Luadata addChild(Luadata c)
	{
		ChildArray.add(c);
		return c;
	}
	public void addAttrs(String key,String v)
	{
		attrs.put(key, v);
	}

	public String toString()
	{
		String str = new String();
		for (Object key : attrs.keySet()) {

		   String  value = (String) attrs.get(key);
		   str= str+ " "+key+":"+value;
		}
		for(int i=0;i<ChildArray.size();i++)
		{
			str= str+" Child_"+i+" {"+ChildArray.get(i).toString()+"}";
		}
		return str;
		
	}

}
