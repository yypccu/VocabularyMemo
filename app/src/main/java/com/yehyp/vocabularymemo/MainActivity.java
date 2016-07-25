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
        VocabularyDAO vocabularyDAO = new VocabularyDAO(getApplicationContext());
        if (vocabularyDAO.getCount() == 0) {
            vocabularyDAO.sample();
        }
        vocabulary_list = vocabularyDAO.getAll();
        adapter = new MyAdapter(MainActivity.this, vocabulary_list);
        mListView.setAdapter(adapter);
    }

}
