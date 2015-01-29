package cn.iolove.android.lui.view;

import android.graphics.Color;
import android.widget.Button;
import android.widget.EditText;
import cn.iolove.android.lui.Context.RuntimeContext;

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
	public void setContentView(BaseView v) {
		//WidgetController.setViewAttrs(edit, this.getViewModel());
		
		
		btn.setText(this.getViewModel().getValueByKey("text"));
		btn.setBackgroundColor(Color.parseColor(this.getViewModel().getBackgroundColor()));
		this.addView(btn);


	  super.setContentView(v);
	  
	  
	}
}
