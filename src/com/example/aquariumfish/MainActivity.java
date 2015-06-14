package com.example.aquariumfish;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemClickListener,OnScrollListener{
    private ListView listview;
    private SimpleAdapter sim_adapter;
    private List<Map<String,Object>>datalist;
    private String fish_key[]={"fish_pic","fish_txt"};
    private int fish_id[]={R.id.fish_pic,R.id.fish_txt};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listview =(ListView) findViewById(R.id.listview);
		datalist= new ArrayList<Map<String,Object>>();
//		SimpleAdapter(上下文，数据源，布局文件，键，值）
		sim_adapter=new SimpleAdapter(this, getData(), R.layout.fishlist, fish_key, fish_id);
		listview.setAdapter(sim_adapter);
		listview.setOnItemClickListener(this);
		listview.setOnScrollListener(this);
	}
    private List<Map<String,Object>>getData()
    {
        String[] SubName = new String[5];
        SubName[0]="锦鲤";
        SubName[1]="龙鱼";
        SubName[2]="热带鱼";
        SubName[3]="金鱼";
        SubName[4]="神仙鱼";
          for(int i=0;i<5;i++)
          {
        	  Map<String,Object>map=new HashMap<String,Object>();
        	  map.put("fish_pic", R.drawable.ic_launcher);
        	  map.put("fish_txt", SubName[i]);
        	  datalist.add(map);
          }
//    		Map<String,Object>map=new HashMap<String, Object>();
//    		map.put("fish_pic", R.drawable.ic_launcher);
//    		map.put("fish_txt", "锦鲤");
//    		datalist.add(map);
//    		map.put("fish_pic", R.drawable.ic_launcher);
//    		map.put("fish_txt", "龙鱼");
//    		datalist.add(map);
//    		map.put("fish_pic", R.drawable.ic_launcher);
//    		map.put("fish_txt", "热带鱼");
//    		datalist.add(map);
//    		map.put("fish_pic", R.drawable.ic_launcher);
//    		map.put("fish_txt", "金鱼");
//    		datalist.add(map);
//    		map.put("fish_pic", R.drawable.ic_launcher);
//    		map.put("fish_txt", "神仙鱼");
//    		datalist.add(map);
    	return datalist;
    }
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,long id) 
	{
		// TODO Auto-generated method stub
		Intent intent = new Intent();
		Toast.makeText(this, "正在跳转...", Toast.LENGTH_SHORT).show();
		switch(position){
		case 0:
			intent.setClass(this, fish1.class);
			startActivity(intent);
			break;
		case 1:
			intent.setClass(this, fish2.class);
			startActivity(intent);
			break;
		case 2:
			intent.setClass(this, fish3.class);
			startActivity(intent);
			break;
		case 3:
			intent.setClass(this, fish4.class);
			startActivity(intent);
			break;
		case 4:
			intent.setClass(this, fish5.class);
			startActivity(intent);
			break;
		}
	}
	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		// TODO Auto-generated method stub
		//scrollState 滑动状态；
		switch(scrollState){
		case SCROLL_STATE_FLING:
			Log.i("scroll","滑动后的惯性");
			Toast.makeText(this, "抱歉~没有更多了...", Toast.LENGTH_SHORT).show();
			//若更新资源，要调用notifyDataSetChanged()
//        Map<String,Object>map=new HashMap<String,Object>();
//        map.put("fish_pic", R.drawable.ic_launcher);
//        map.put("fish_txt", "新品种！");
//        datalist.add(map);
//		  sim_adapter.notifyDataSetChanged();
			break;
		case SCROLL_STATE_IDLE:
			Log.i("scroll","视图已经停止滑动");
			break;
		case SCROLL_STATE_TOUCH_SCROLL:
			Log.i("scroll", "手指还在滑动");
			break;
		}
	}
	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {
		// TODO Auto-generated method stub
		
	}

}
