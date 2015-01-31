package cn.iolove.android.lui.view;

import android.graphics.Color;

import android.widget.Button;
import android.widget.EditText;
import cn.iolove.android.lui.Context.RuntimeContext;
import cn.iolove.android.lui.utils.Utils;

public class ButtonView extends View {
 
	private Button btn;
	public ButtonView(RuntimeContext context) {
		super(context);
		btn = new Button(context.GetActivityContext());
		//edit = new EditText()
		// TODO Auto-generated constructor stub
	}

	public String getqName() {
		
		return new String("Button");
	}
	   public void removeAllView(BaseView v)
	   {
		   super.removeAllView(v);
			this.removeAllViews();
	   }
	public void setContentView(BaseView v) {
		//WidgetController.setViewAttrs(edit, this.getViewModel());
		

		btn.setText(this.getViewModel().getValueByKey("Text"));
		btn.setBackgroundColor(Color.parseColor(this.getViewModel().getBackgroundColor()));
		this.addView(btn);

		if(this.getViewModel().getValueByKey("Onclick")!=null)
		{
			final String   fuc = this.getViewModel().getValueByKey("Onclick");
			btn.setOnClickListener(new OnClickListener() {
				

				@Override
				public void onClick(android.view.View arg0) {
					
					Utils.exceuteLuaFuction(context.getLuaState(), fuc);
					RuntimeContext.getInstance().GetActivityContext().Refresh();
				}
			});
		}
	  super.setContentView(v);
	  
	  
	}
}
