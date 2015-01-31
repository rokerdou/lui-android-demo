package cn.iolove.android.lui.model;

public class EditTextModel extends ViewModel {
	public void setText(String name)
	{
		putValueAndKey("Text", name);
	}
}
