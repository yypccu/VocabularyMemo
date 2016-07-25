package com.yehyp.vocabularymemo;

/**
 * Created by YEH MC on 2016/7/19.
 */
public class Vocabulary {
    private long id;
    private String word;
    private String attribute;
    private String meaning;

    public Vocabulary(long id, String word, String attribute, String meaning) {
        this.id = id;
        this.word = word;
        this.attribute = attribute;
        this.meaning = meaning;
    }

    public Vocabulary() {
        word = "empty_word";
        attribute = "empty_attr";
        meaning = "empty_meaning";
    }

    public long getId() { return id; }

    public String getWord() {
        return word;
    }

    public String getAttribute() {
        return attribute;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setId(long id) { this.id = id; }

    public void setWord(String word) {
        this.word = word;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
}
