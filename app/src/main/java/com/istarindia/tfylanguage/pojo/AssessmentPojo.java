package com.istarindia.tfylanguage.pojo;

import java.io.Serializable;

/**
 * Created by istarferoz on 27/10/17.
 */

public class AssessmentPojo implements Serializable{

    private AnswerPojo answerPojo;
    private OptionPojo optionPojo;
    private QuestionPojo questionPojo;
    private  String type;
    public AssessmentPojo() {
    }

    public AssessmentPojo(AnswerPojo answerPojo, OptionPojo optionPojo, QuestionPojo questionPojo, String type) {
        this.answerPojo = answerPojo;
        this.optionPojo = optionPojo;
        this.questionPojo = questionPojo;
        this.type = type;
    }

    public AnswerPojo getAnswerPojo() {
        return answerPojo;
    }

    public void setAnswerPojo(AnswerPojo answerPojo) {
        this.answerPojo = answerPojo;
    }

    public OptionPojo getOptionPojo() {
        return optionPojo;
    }

    public void setOptionPojo(OptionPojo optionPojo) {
        this.optionPojo = optionPojo;
    }

    public QuestionPojo getQuestionPojo() {
        return questionPojo;
    }

    public void setQuestionPojo(QuestionPojo questionPojo) {
        this.questionPojo = questionPojo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
