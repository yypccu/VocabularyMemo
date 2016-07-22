package com.yehyp.vocabularymemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    List<Vocabulary> vocabulary_list = new ArrayList<Vocabulary>();
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView= (ListView)findViewById(R.id.list);
        vocabulary_list.add(new Vocabulary("prospective", "adj.", "預期的, 未來的"));
        vocabulary_list.add(new Vocabulary("secure a deal", "phr.", "獲得一筆交易"));
        vocabulary_list.add(new Vocabulary("whereas", "conj.", "然而, 雖然"));
        adapter = new MyAdapter(MainActivity.this, vocabulary_list);
        mListView.setAdapter(adapter);
    }
}
