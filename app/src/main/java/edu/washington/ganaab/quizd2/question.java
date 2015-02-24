package edu.washington.ganaab.quizd2;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Ganaa on 2/16/2015.
 */
public class question implements Serializable {
    int correct;
    String questionText;
    ArrayList<String> answers;
    public question (){}
    public void setCorrect(int correct){
        this.correct = correct;
    }
    public void setQuestionText(String questionText){
        this.questionText = questionText;
    }
    public void setAnswers(ArrayList<String> answers){
        this.answers = answers;
    }
    public int getCorrect(){
        return this.correct;
    }
    public String getQuestionText(){
        return this.questionText;
    }
    public ArrayList<String> getAnswers() {
        return this.answers;
    }
}
