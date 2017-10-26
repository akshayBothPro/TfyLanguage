package com.istarindia.tfylanguage.pojo;

import java.io.Serializable;

/**
 * Created by istarferoz on 27/10/17.
 */

public class QuestionPojo implements Serializable {
    String text;

    public QuestionPojo() {
    }

    public QuestionPojo(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
