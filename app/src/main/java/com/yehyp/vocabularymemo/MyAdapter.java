package com.yehyp.vocabularymemo;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.content.Context;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by YEH MC on 2016/7/19.
 */
public class MyAdapter extends BaseAdapter{
    private LayoutInflater myInflater;
    private List<Vocabulary> vocabularies;


    public MyAdapter(Context context, List<Vocabulary> vocabulary){
        myInflater = LayoutInflater.from(context);
        this.vocabularies = vocabulary;
    }

    @Override
    public int getCount() {
        return vocabularies.size();
    }

    @Override
    public Object getItem(int position) {
        return vocabularies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return vocabularies.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView==null){
            convertView = myInflater.inflate(R.layout.adapter, null);
            holder = new ViewHolder(
                    (TextView) convertView.findViewById(R.id.textWord),
                    (TextView) convertView.findViewById(R.id.textAttr),
                    (TextView) convertView.findViewById(R.id.textMeaning)
            );
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        Vocabulary vocabulary = (Vocabulary)getItem(position);
        // 設定各欄位所顯示的字 字體顏色 背景顏色
        holder.txtWord.setText(vocabulary.getWord());
        holder.txtWord.setTextColor(Color.BLACK);
        holder.txtWord.setBackgroundColor(Color.TRANSPARENT);
        holder.txtAttr.setText(vocabulary.getAttribute());
        holder.txtAttr.setTextColor(Color.BLACK);
        holder.txtAttr.setBackgroundColor(Color.TRANSPARENT);
        holder.txtMeaning.setText(vocabulary.getMeaning());
        holder.txtMeaning.setTextColor(Color.BLACK);
        holder.txtMeaning.setBackgroundColor(Color.TRANSPARENT);
        return convertView;
    }

    private class ViewHolder {
        TextView txtWord;
        TextView txtAttr;
        TextView txtMeaning;
        public ViewHolder(TextView txtWord, TextView txtAttr, TextView txtMeaning){
            this.txtWord = txtWord;
            this.txtAttr = txtAttr;
            this.txtMeaning = txtMeaning;
        }
    }
}
