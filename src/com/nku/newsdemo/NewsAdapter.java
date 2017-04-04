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
	
	//�ȶ��������Ķ���
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
		//ʵ��list��ÿһ�������Ҫ����һ��news_item
		if(convertView == null){
		convertView = LayoutInflater.from(context).inflate(R.layout.news_item, null);
		}
		TextView txTitle = (TextView) convertView.findViewById(R.id.txTitle);
		TextView txDec = (TextView) convertView.findViewById(R.id.txDec);
		TextView txTime = (TextView) convertView.findViewById(R.id.txTime);
		ImageView imPic = (ImageView) convertView.findViewById(R.id.imPic);
		
		//���ݶ�Ӧλ�õ�position���news
		News news = newsList.get(position);
		txTitle.setText(news.getTitle());
		txDec.setText(news.getDesc());
		txTime.setText(news.getTime());
		
		//ͼƬ�ķ�����Ҫͨ�����磬�������Ƕ���һ����������Ĺ�����,ֱ���ڹ�����
		//�еķ����н�ͼƬ���õ�ImageView
		String pic_url = news.getPic_url();
		HttpUtils.setPicBitmap(imPic, pic_url);
		
		return convertView;
	}

}
