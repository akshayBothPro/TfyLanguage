package com.istarindia.tfylanguage.pojo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by istarferoz on 27/10/17.
 */

public class AnswerPojo implements Serializable {
    ArrayList<String> answers;

    public AnswerPojo() {
    }

    public AnswerPojo(ArrayList<String> answers) {
        this.answers = answers;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }
}
