package cn.iolove.android.lui.view;

import java.util.List;

import android.content.Context;

import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import cn.iolove.android.lui.model.Luadata;
import cn.iolove.android.lui.model.ViewModel;

public abstract class BaseView extends FrameLayout{

	public BaseView(Context context) {
		super(context);
	

        
	}

	public void setLayoutParams(BaseViewLayoutParams params) {
		// TODO Auto-generated method stub
		setLayoutParamss(params);
		

		
	}
 

public void setLayoutParamss(android.view.ViewGroup.LayoutParams params) {
	// TODO Auto-generated method stub
	super.setLayoutParams(params);
}
	public abstract void setContentView(BaseView v);
	public abstract String getqName();
	public abstract void setViewData(Luadata t);
	public abstract BaseView getParentView();
	public abstract void SetParentView(BaseView v);
	
	
   public abstract ViewModel getViewModel();
   public abstract List getChildList(BaseView v);


}
