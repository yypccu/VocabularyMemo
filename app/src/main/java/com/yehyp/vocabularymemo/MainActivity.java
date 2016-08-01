package com.yehyp.vocabularymemo;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    List<Vocabulary> vocabulary_list = new ArrayList<Vocabulary>();
    private MyAdapter mAdapter;

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
        mAdapter = new MyAdapter(MainActivity.this, vocabulary_list);
        mListView.setAdapter(mAdapter);

        ImageButton addButtom = (ImageButton)findViewById(R.id.button_add);
        addButtom.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddVocabularyDialog();
            }
        });
    }

    private void openAddVocabularyDialog() {
        LayoutInflater inflater = getLayoutInflater();
        final View inputView = inflater.inflate(R.layout.add_vocabulary, null);

        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setView(inputView);
        dialog.setPositiveButton(R.string.btn_confirm, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText fieldWord = (EditText)inputView.findViewById(R.id.inputViewWord);
                EditText fieldAttr = (EditText)inputView.findViewById(R.id.inputViewAttribute);
                EditText fieldMeaning = (EditText)inputView.findViewById(R.id.inputViewMeaning);
                String mWord = fieldWord.getText().toString();
                String mAttr = fieldAttr.getText().toString();
                String mMeaning = fieldMeaning.getText().toString();
                Vocabulary newVocabulary = new Vocabulary(0, mWord, mAttr, mMeaning);

                //Add the new vocabulary into DB
                VocabularyDAO mVocabularyDAO = new VocabularyDAO(getApplicationContext());
                mVocabularyDAO.insert(newVocabulary);
                mVocabularyDAO.close();
                //Add the new vocabulary into the listView
                vocabulary_list.add(newVocabulary);
                mAdapter.notifyDataSetChanged();
            }
        });
        dialog.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

    }


}
