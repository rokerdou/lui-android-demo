package cn.iolove.android.lui.view;

import java.util.List;

import android.graphics.Color;
import android.widget.EditText;

import cn.iolove.android.lui.Context.RuntimeContext;
import cn.iolove.android.lui.model.Luadata;
import cn.iolove.android.lui.model.ViewModel;
import cn.iolove.android.lui.utils.WidgetController;

public class EditTextView extends View {
	private EditText edit;
	public EditTextView(RuntimeContext context) {
		super(context);
		// TODO Auto-generated constructor stub
		edit=new EditText(context.GetActivityContext());
	}


	@Override
	public String getqName() {
		
		return new String("EditText");
	}
	public void setContentView(BaseView v) {
		//WidgetController.setViewAttrs(edit, this.getViewModel());
		edit.setFocusable(true);
		
		edit.setText(this.getViewModel().getValueByKey("Text"));
		edit.setBackgroundColor(Color.parseColor(this.getViewModel().getBackgroundColor()));
		this.addView(edit);


	  super.setContentView(v);
	  
	  
	}




}
