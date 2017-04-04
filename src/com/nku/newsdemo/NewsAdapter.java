package com.nku.newsdemo;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NewsAdapter extends BaseAdapter {
	
	//先定义上下文对象
	private Context context;
	private List<News> newsList;
	
	public NewsAdapter(Context context,List<News> newsList){
		this.context = context;
		this.newsList = newsList;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return newsList.size();
	}

	@Override
	public News getItem(int position) {
		return newsList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		//实现list的每一项，所以需要定义一个news_item
		if(convertView == null){
		convertView = LayoutInflater.from(context).inflate(R.layout.news_item, null);
		}
		TextView txTitle = (TextView) convertView.findViewById(R.id.txTitle);
		TextView txDec = (TextView) convertView.findViewById(R.id.txDec);
		TextView txTime = (TextView) convertView.findViewById(R.id.txTime);
		ImageView imPic = (ImageView) convertView.findViewById(R.id.imPic);
		
		//根据对应位置的position获得news
		News news = newsList.get(position);
		txTitle.setText(news.getTitle());
		txDec.setText(news.getDesc());
		txTime.setText(news.getTime());
		
		//图片的访问需要通过网络，所以我们定义一个访问网络的工具类,直接在工具类
		//中的方法中将图片设置到ImageView
		String pic_url = news.getPic_url();
		HttpUtils.setPicBitmap(imPic, pic_url);
		
		return convertView;
	}

}
