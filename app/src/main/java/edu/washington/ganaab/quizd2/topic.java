package edu.washington.ganaab.quizd2;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Ganaa on 2/16/2015.
 */
public class topic implements Serializable {
    String title;
    String sDesc;
    String lDesc;
    ArrayList<question> questionCollection;
    public topic (){}
    public void setTitle(String title){
        this.title = title;
    }
    public void setsDesc(String sDesc){
        this.sDesc = sDesc;
    }
    public void setlDesc(String lDesc){
        this.lDesc = lDesc;
    }
    public void setQuestionCollection(ArrayList<question> questionCollection){
        this.questionCollection = questionCollection;
    }
    public String getTitle(){
        return this.title;
    }
    public String getsDesc(){
        return this.sDesc;
    }
    public String getlDesc(){
        return this.lDesc;
    }
    public question getQuestion(int index){
        return questionCollection.get(index);
    }
    public ArrayList<question> getQuestionCollection(){
        return this.questionCollection;
    }
}
