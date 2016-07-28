package com.yehyp.vocabularymemo;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
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

        Button addButtom = (Button)findViewById(R.id.button_add);
        addButtom.setOnClickListener(addVocabuary);
    }

    private OnClickListener addVocabuary = new OnClickListener() {
        @Override
        public void onClick(View v) {
            openAddVocabularyDialog();
        }
    };


    private void openAddVocabularyDialog() {
        LayoutInflater inflater = getLayoutInflater();
        final View inputView = inflater.inflate(R.layout.add_vocabulary, null);
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("新增單字");
        dialog.setView(inputView);
        dialog.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //TODO
            }
        });
        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ;
            }
        });
        dialog.show();
    }


}
