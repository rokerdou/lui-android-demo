package cn.iolove.android.lui.utils;

import cn.iolove.android.lui.model.ViewModel;
import cn.iolove.android.lui.view.BaseView;
import cn.iolove.android.lui.view.BaseViewLayoutParams;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;  

  
/* 
 * 获取、设置控件信息 
 */  
public class WidgetController {  
  
    /* 
     * 获取控件宽 
     */  
    public static int getWidth(BaseView view)  
    {  
        int w = BaseView.MeasureSpec.makeMeasureSpec(0,BaseView.MeasureSpec.UNSPECIFIED);  
        int h = BaseView.MeasureSpec.makeMeasureSpec(0,BaseView.MeasureSpec.UNSPECIFIED);  
        view.measure(w, h);  
        return (view.getMeasuredWidth());         
    }  
    public static void setWidth(BaseView view,BaseViewLayoutParams lop)
    {
    	view.setLayoutParams(lop);
    }
    public static void setViewAttrs(View v,ViewModel vm)
    {
		WidgetController.setLayout(v,vm.getMarginleft(),vm.getMargintop(),vm.getWidth(),vm.getHeight());
		WidgetController.setBackgroundColor(v,vm.getBackgroundColor());
    }
    public static void setViewAttrs(BaseView v)
    {
		WidgetController.setLayout(v, v.getViewModel().getMarginleft(), v.getViewModel().getMargintop(),v.getViewModel().getWidth(),v.getViewModel().getHeight());
		WidgetController.setBackgroundColor(v,v.getViewModel().getBackgroundColor());
    }
/*
     * 获取控件高 
     */  
    public static int getHeight(BaseView view)  
    {  
        int w = BaseView.MeasureSpec.makeMeasureSpec(0,BaseView.MeasureSpec.UNSPECIFIED);  
        int h = BaseView.MeasureSpec.makeMeasureSpec(0,BaseView.MeasureSpec.UNSPECIFIED);  
        view.measure(w, h);  
        return (view.getMeasuredHeight());         
    }  
      
    /* 
     * 设置控件所在的位置X，并且不改变宽高， 
     * X为绝对位置，此时Y可能归0 
     */  

    /* 
     * 设置控件所在的位置Y，并且不改变宽高， 
     * Y为绝对位置，此时X可能归0 
     */  
    public static void setBackgroundColor(BaseView view ,String p)
    {
    	view.setBackgroundColor(Color.parseColor(p));
    }
    public static void setBackgroundColor(View view ,String p)
    {
    	view.setBackgroundColor(Color.parseColor(p));
    }
    /* 
     * 设置控件所在的位置YY，并且不改变宽高， 
     * XY为绝对位置 
     */  
    public static void setLayout(View view,int x,int y,int w ,int h)  
    {  
       view.layout(x, y, x+w, y+h);
       MarginLayoutParams margin=new MarginLayoutParams(w,h); 
       margin.setMargins(x,y, x+w, y+h); 
       BaseViewLayoutParams layoutParams = new BaseViewLayoutParams(margin); 
       view.setLayoutParams(layoutParams); 
    }  
    public static void setLayout(BaseView view,int x,int y,int w ,int h)  
    {  
       view.layout(x, y, x+w, y+h);
       MarginLayoutParams margin=new MarginLayoutParams(w,h); 
       margin.setMargins(x,y, x+w, y+h); 
       BaseViewLayoutParams layoutParams = new BaseViewLayoutParams(margin); 
       view.setLayoutParams(layoutParams); 
    }  
}  