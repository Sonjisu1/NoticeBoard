package com.example.userapp;

public class QuestionData {
    String title;
    String writer;
    String contents;
    String answercontents;

    String answer;

    public QuestionData(){

    }

    public QuestionData(String title,String writer,String answer,String contents){

        this.title= title;
        this.writer = writer;
        this.answer =answer;
        this.contents=contents;
    }




    public  String getAnswercontents() {
        return answercontents;
    }
    public void setAnswercontents(String answercontents){
        this.answercontents = answercontents;
    }
    public String getContents(){return contents;}
    public void setContents(String contents){ this.contents = contents;}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
