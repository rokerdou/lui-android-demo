package cn.iolove.android.lui.Service;

import cn.iolove.android.lui.Context.PageControl;
import cn.iolove.android.lui.Context.RuntimeContext;

public class System implements PageControl {
	private static System sy=new System();
	private RuntimeContext rc = RuntimeContext.getInstance();
	private System(){};
	public static System getInstance(){return sy;}
	@Override
	public void switchpage(String pagename) {
		rc.getPageController().switchpage(pagename);		
	}
	@Override
	public void pushpage(String pagename) {
		rc.getPageController().pushpage(pagename);
		
	}
	@Override
	public void poppage() {
		rc.getPageController().poppage();
		
	}
	

}
