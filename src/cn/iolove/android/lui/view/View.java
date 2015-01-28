package cn.iolove.android.lui.view;

import java.util.ArrayList;
import java.util.List;

import cn.iolove.android.lui.Context.RuntimeContext;
import cn.iolove.android.lui.model.Luadata;
import cn.iolove.android.lui.model.ViewModel;
import cn.iolove.android.lui.utils.WidgetController;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;


import android.widget.LinearLayout;


public class View extends  BaseView{


	private List subitems = new ArrayList();
	private RuntimeContext context;

	private ViewModel viewmodel = new ViewModel();
	//LinearLayout l;
	public View(RuntimeContext context) {
		super(context.GetActivityContext());
		this.context =  context;
	}
	public ViewModel getViewModel()
	{
		return viewmodel;
	}
	public void addChild(BaseView v)
	{
		subitems.add(v);
		 
	}
	public String toString()
	{
	   return viewmodel.toString();
		
	}
   public void setViewData(Luadata temp)
   {
	  
	   viewmodel.setAttrs(temp.getAttrs());


		
	   if(temp.hasChild())
	   {
		   for(int i=0;i<temp.getChild().size();i++)
		   {
			   BaseView  child= new View(context);
			   Luadata cd= (Luadata) temp.getChild().get(i);
			   child.setViewData(cd);
			   
			   addChild(child);
			 
		   }
	   }
	   
   }
	@Override
	public void setContentView(BaseView v) {
		  // viewmodel.setAttrs(temp.getAttrs());
		   String strr = new String();
			for (Object key : v.getViewModel().hm.keySet()) {
				
				   String  value = (String) v.getViewModel().hm.get(key);
				   strr= strr+ " "+key+":"+value;
				}

        WidgetController.setViewAttrs(v);
        if(!v.getChildList(v).isEmpty())
		{
			for(int i=0;i<v.getChildList(v).size();i++)
			{
				setContentView((BaseView) v.getChildList(v).get(i));
				
				BaseView s =  (BaseView) v.getChildList(v).get(i);
				Log.i("jjj", "v.getChildViewModel().."+i+": "+s);
				 this.addView( s);
			}
		}
		
	
	}
	
	public String getqName() {
		// TODO Auto-generated method stub
		return new String ("View");
	}
	

	
	public List getChildList(BaseView v) {
		// TODO Auto-generated method stub
		return subitems;
	}
	@Override
	public BaseView getParentView() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void SetParentView(BaseView v) {
		
	}



}
