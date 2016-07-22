package com.yehyp.vocabularymemo;

/**
 * Created by YEH MC on 2016/7/19.
 */
public class Vocabulary {
    private String word;
    private String attribute;
    private String meaning;

    public Vocabulary(String word, String attribute, String meaning) {
        this.word = word;
        this.attribute = attribute;
        this.meaning = meaning;
    }

    public String getWord() {
        return word;
    }

    public String getAttribute() {
        return attribute;
    }

    public String getMeaning() {
        return meaning;
    }

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
