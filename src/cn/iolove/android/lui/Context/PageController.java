package cn.iolove.android.lui.Context;

import java.util.Stack;

import cn.iolove.android.lui.page.Page;
import cn.iolove.android.lui.view.BaseView;
import cn.iolove.android.lui.view.View;

public class PageController implements PageControl{
	private static Stack<Page>  StackPage = new Stack<Page>() ;
	private RuntimeContext rc;
	private View top;
	private static  PageController obj = new PageController();
	public static PageController getInstance()
	{
		return obj;
	}
	public PageController setRuntimeContext(RuntimeContext context)
	{
		rc=context;
		return this;
	}
	public View getTopPage()
	{
		return top;
	}
	private void PageControlloer(){}
	@Override
	public void switchpage(String pagename) {
	
		if(StackPage.isEmpty())
		{
			return ;
		}
	    Page temp = StackPage.pop();
	    pushpage(pagename);
	    temp=null;
	    rc.GetActivityContext().Refresh();
	    
	}

	@Override
	public void pushpage(String pagename) {
    Page objs = new Page(rc);
     objs.NewPage(pagename);
    StackPage.push(objs);
    top =objs.getRootView();
   
		
	}

	@Override
	public void poppage() {
		if(StackPage.isEmpty())
		{
			return ;
		}
	    Page temp = StackPage.pop();
	    top= StackPage.peek().getRootView();
	    rc.GetActivityContext().Refresh();
		
	}

}
