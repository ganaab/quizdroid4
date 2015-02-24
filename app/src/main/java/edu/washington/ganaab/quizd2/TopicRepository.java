package edu.washington.ganaab.quizd2;

import java.util.ArrayList;

/**
 * Created by Ganaa on 2/16/2015.
 */
public interface TopicRepository {
    public String getTitle();
    public String getsDesc();
    public String getlDesc();
    public question getQuestion(int index);
    public ArrayList<question> getQuestionCollection();
    public int getCorrect();
    public String getQuestionText();
    public ArrayList<String> getAnswers();
    public void setCurrentTopic(int topic);
}
