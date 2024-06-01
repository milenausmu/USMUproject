package com.example.graduate.Data;

import java.util.List;

public class Question {
    private String questionText;
    private List<String> options;
    private int correctAnswer;

    public Question(String questionText, List<String> options) {
        this.questionText = questionText;
        this.options = options;
    }

    // Getters and setters
    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
