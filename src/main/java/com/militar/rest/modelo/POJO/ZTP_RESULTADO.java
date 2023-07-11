package com.militar.rest.modelo.POJO;

public class ZTP_RESULTADO {
    private int idexam;
    private String date_exam;
    private int questions;
    private int correct;
    private int incorrect;
    private boolean finalized;

    
    public ZTP_RESULTADO() {
    }

    public ZTP_RESULTADO(int idexam, String date_exam, int questions, int correct, int incorrect, boolean finalized) {
        this.idexam = idexam;
        this.date_exam = date_exam;
        this.questions = questions;
        this.correct = correct;
        this.incorrect = incorrect;
        this.finalized = finalized;
    }
    
    public String getDate_exam() {
        return date_exam;
    }
    public void setDate_exam(String date_exam) {
        this.date_exam = date_exam;
    }
    public int getQuestions() {
        return questions;
    }
    public void setQuestions(int questions) {
        this.questions = questions;
    }
    public int getCorrect() {
        return correct;
    }
    public void setCorrect(int correct) {
        this.correct = correct;
    }
    public int getIncorrect() {
        return incorrect;
    }
    public void setIncorrect(int incorrect) {
        this.incorrect = incorrect;
    }
    public boolean isFinalized() {
        return finalized;
    }
    public void setFinalized(boolean finalized) {
        this.finalized = finalized;
    }

    public int getIdexam() {
        return idexam;
    }

    public void setIdexam(int idexam) {
        this.idexam = idexam;
    }
}
