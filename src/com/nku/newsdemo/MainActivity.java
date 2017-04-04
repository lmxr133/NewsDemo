package com.nku.newsdemo;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;


public class MainActivity extends Activity implements OnItemClickListener{
	private ListView listView;
	//对于ListView的填充 必须使用一个Adapter
	private NewsAdapter adapter;
	//将实体News数据填充到已经写好的布局adapter
	private List<News> newsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化数据集合
        newsList = new ArrayList<News>();
        listView = (ListView) findViewById(R.id.listViews);
        
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject1 = new JSONObject();
        JSONObject jsonObject2 = new JSONObject();
        try {
        	jsonObject1.put("id","1");
        	jsonObject1.put("title", "极客学院客户端");
        	jsonObject1.put("desc", "客户端APP重磅上线，欢迎下载");
        	jsonObject1.put("time", "2016.10.1");
        	jsonObject1.put("content_url", "http://www.jikexueyuan.com/app/?hmsr=wb");
        	jsonObject1.put("pic_url", "https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1491235693&di=a55b3f8fe77ab7e579767d574be04082&src=http://imgrt.pconline.com.cn/images/upload/upc/tx/pcdlc/1609/29/c2/spcgroup/27713545_1475147113903_115x115.png");
        	
        	jsonObject2.put("id","1");
        	jsonObject2.put("title", "极客学院新课发布");
        	jsonObject2.put("desc", "Meteor 入门指南");
        	jsonObject2.put("time", "2017.5.1");
        	jsonObject2.put("content_url", "http://www.jikexueyuan.com/course/577.html");
        	jsonObject2.put("pic_url", "https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1491235693&di=a55b3f8fe77ab7e579767d574be04082&src=http://imgrt.pconline.com.cn/images/upload/upc/tx/pcdlc/1609/29/c2/spcgroup/27713545_1475147113903_115x115.png");
        	
        	jsonArray.put(jsonObject1);
        	jsonArray.put(jsonObject2);
        	System.out.println(jsonArray.toString());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        //解析json数据,并加入到list集合中，在界面显示
        for(int i=0; i<jsonArray.length(); i++){
        	try {
				JSONObject object = (JSONObject) jsonArray.get(i);
				String title = object.getString("title");
				String desc = object.getString("desc");
				String time = object.getString("time");
				String conten_url = object.getString("content_url");
				String pic_url = object.getString("pic_url");
				newsList.add(new News(title,desc,time,conten_url,pic_url));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        adapter = new NewsAdapter(this,newsList);//这里必须传入list，用于填充数据
        listView.setAdapter(adapter);
        
        //listView绑定点击事件
        listView.setOnItemClickListener(this);
        //将数据list和adapter绑定到一起，然后adapter改变
        adapter.notifyDataSetChanged();
    }
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		News news = newsList.get(position);
		Intent intent = new Intent(this, DetailNewsActivity.class);
		intent.putExtra("content_url", news.getContent_url());
		//切记不要忘记启动Activity
		startActivity(intent);
	}


}
