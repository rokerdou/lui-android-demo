package cn.iolove.android.lui.domain;

public class Device {
	private  static Device obj = new Device();
	public static Device getInstance() {return obj;}
	private int ScreenWidth;
	private int ScreenHeight;
	private Device(){}
	public Device setScreenWidthAndHeight(int w,int h)
	{
		ScreenWidth=w;
		ScreenHeight=h;
		
       return this;	
	}

}
