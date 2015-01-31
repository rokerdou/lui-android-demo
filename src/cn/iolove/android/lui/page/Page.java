package cn.iolove.android.lui.page;

import java.util.List;

import org.keplerproject.luajava.LuaState;
import org.keplerproject.luajava.LuaStateFactory;

import android.app.AlertDialog;
import android.content.Context;
import android.util.Log;

import cn.iolove.android.lui.Context.RuntimeContext;
import cn.iolove.android.lui.model.Luadata;
import cn.iolove.android.lui.model.PageModel;
import cn.iolove.android.lui.model.ViewModel;
import cn.iolove.android.lui.utils.Utils;
import cn.iolove.android.lui.view.BaseView;
import cn.iolove.android.lui.view.View;

public class Page extends View{

	private  LuaState mLuaState;
	private PageModel pm;
	private View root;
	private RuntimeContext context;
	public Page(RuntimeContext context) {
		super(context);
		root = new View(context);
		this.context=context;
		
	}
	   public void removeAllView(BaseView v)
	   {
		   super.removeAllView(v);
		   root.removeAllView(root);
			
	   }
	public View getRootView()
	{
		return root;
	}
	public LuaState getLuaState()
	{
		return mLuaState;
	}
    public BaseView NewPage(String name)
    {
    	
    	mLuaState = LuaStateFactory.newLuaState();
    	mLuaState.openLibs();
		try {

			
			int error = mLuaState.LdoString(Utils.loadAssetsString("framework/ui.lua",context.GetActivityContext())+Utils.loadAssetsString("lua/"+name+".lua",context.GetActivityContext()));
			if(error!=0)
			{
				new AlertDialog.Builder(context.GetActivityContext()).setTitle("LUA错误").setMessage(mLuaState.toString(-1)).setPositiveButton("确定", null).show();
				return this;
	
			}
		   mLuaState.getField(LuaState.LUA_GLOBALSINDEX, "onCreated");
		  // mLuaState.pushNumber(1);
			mLuaState.call(0, 1);
			
			//mLuaState.pushObjectValue(-1);
			mLuaState.setField(LuaState.LUA_GLOBALSINDEX, "resulttable");
			 mLuaState.getField(LuaState.LUA_GLOBALSINDEX, "table2json");
			 mLuaState.getGlobal("resulttable");
			 mLuaState.call(1, 1);
				mLuaState.setField(LuaState.LUA_GLOBALSINDEX, "json");
				 mLuaState.getGlobal("json");
				//new AlertDialog.Builder(this).setTitle("LUA").setMessage(mLuaState.toString(-1)).setPositiveButton("确定", null).show();
                Log.i("xxx", "LuaJson"+mLuaState.toString(-1));
                Luadata rootdata=  Utils.getMap4Json(new Luadata(),mLuaState.toString(-1));
                root.setViewData(rootdata);
                root.setContentView(root);
                this.addView(root);
                //mLuaState.close();
                
                return this;
              //  Log.i("xxx","lua Object:"+ root.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.print("打开失败");
			e.printStackTrace();
		}            
    	return this;
    }
	@Override
	public void setContentView(BaseView v) {
	
		root.setContentView(v);
		this.addView(root);
	}
	@Override
	public String getqName() {
		
		return root.getqName();
	}
	@Override
	public void setViewData(Luadata t) {
		root.setViewData(t);
		
	}
	@Override
	public BaseView getParentView() {
		
		return null;
	}
	@Override
	public void SetParentView(BaseView v) {
	
		
	}
	@Override
	public ViewModel getViewModel() {
		
		return root.getViewModel();
	}
	@Override
	public List getChildList(BaseView v) {
		
		return root.getChildList(v);
	}

}
