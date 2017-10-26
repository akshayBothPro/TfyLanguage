package com.istarindia.tfylanguage.pojo;

import java.io.Serializable;

/**
 * Created by istarferoz on 27/10/17.
 */

public class AssessmentPojo implements Serializable{

    private AnswerPojo answerPojo;
    private OptionPojo optionPojo;
    private QuestionPojo questionPojo;
    public AssessmentPojo() {
    }

    public AssessmentPojo( AnswerPojo answerPojo, OptionPojo optionPojo, QuestionPojo questionPojo) {
        this.answerPojo = answerPojo;
        this.optionPojo = optionPojo;
        this.questionPojo = questionPojo;
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
}
