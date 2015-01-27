package cn.iolove.android.lui.view;

import java.util.List;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import cn.iolove.android.lui.model.Luadata;
import cn.iolove.android.lui.model.ViewModel;

public abstract class BaseView extends LinearLayout{

	public BaseView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	public abstract void setContentView(BaseView v);
	public abstract String getqName();
	public abstract void setViewData(Luadata t);

   public abstract ViewModel getViewModel();
   public abstract List getChildList(BaseView v);
}
