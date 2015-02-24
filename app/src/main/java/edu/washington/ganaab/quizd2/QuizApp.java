package edu.washington.ganaab.quizd2;

import android.app.Application;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Ganaa on 2/16/2015.
 */
public class QuizApp extends Application implements TopicRepository{
    public int currentTopic;
    public int currentQuestion;
    public ArrayList<topic> topics;

    private static QuizApp instance;
    public QuizApp (){
        if (instance == null){
            instance = this;
        }
    }

    public static QuizApp getInstance() {
        return instance;
    }

    public static void setInstance(QuizApp instance) {
        QuizApp.instance = instance;
    }

    @Override public void onCreate()
    {
        Log.d("QuizApp Starter","App has started");
        initialize();
    }
    public void initialize(){
        setCurrentQuestion(0);
        topics = new ArrayList<>();

        topic topicMath = new topic();
        topic topicPhysics= new topic();
        topic topicMarvel = new topic();

        question math1 = new question();
        question math2 = new question();
        question physics1 = new question();
        question physics2 = new question();
        question marvel1 = new question();
        question marvel2 = new question();

        // setting question text
        math1.setQuestionText("What is 1 + 2 - 3 * 4 / 5?");
        math2.setQuestionText("What is 0 / 1 * 2 + 3 - 4?");
        physics1.setQuestionText("A thermometer for measuring very low temperature is called?");
        physics2.setQuestionText("Name the device which converts electric energy into mechanical energy");
        marvel1.setQuestionText("Which one of these heroes turns into a giant green rage monster?");
        marvel2.setQuestionText("What color is Ironman's suit?");

        ArrayList<String> mathAnswers1 = new ArrayList<String>();
        ArrayList<String> mathAnswers2 = new ArrayList<String>();
        ArrayList<String> physicsA1 = new ArrayList<String>();
        ArrayList<String> physicsA2 = new ArrayList<String>();
        ArrayList<String> marvelA1 = new ArrayList<String>();
        ArrayList<String> marvelA2 = new ArrayList<String>();

        mathAnswers1.add("0");
        mathAnswers1.add("1");
        mathAnswers1.add("2");
        mathAnswers1.add("none of the above");

        mathAnswers2.add("-1");
        mathAnswers2.add("0");
        mathAnswers2.add("1");
        mathAnswers2.add("2");

        physicsA1.add("pyrometer");
        physicsA1.add("bolometer");
        physicsA1.add("cyrometer");
        physicsA1.add("platinum resistant thermometer");

        physicsA2.add("alternator");
        physicsA2.add("transformer");
        physicsA2.add("dynamo");
        physicsA2.add("motor");

        marvelA1.add("Captain America");
        marvelA1.add("Hulk");
        marvelA1.add("Ironman");
        marvelA1.add("Thor");

        marvelA2.add("Red");
        marvelA2.add("Yellow");
        marvelA2.add("Pink");
        marvelA2.add("Green");

        math1.setAnswers(mathAnswers1);
        math2.setAnswers(mathAnswers2);
        physics1.setAnswers(physicsA1);
        physics2.setAnswers(physicsA2);
        marvel1.setAnswers(marvelA1);
        marvel2.setAnswers(marvelA2);

        math1.setCorrect(3);
        math2.setCorrect(0);
        physics1.setCorrect(2);
        physics2.setCorrect(3);
        marvel1.setCorrect(1);
        marvel2.setCorrect(0);

        topicMath.setTitle("Math");
        topicPhysics.setTitle("Physics");
        topicMarvel.setTitle("Marvel Super Heroes");

        topicMath.setlDesc("This is the math section");
        topicPhysics.setlDesc("This is the Physics section");
        topicMarvel.setlDesc("This is the Marvel section");

        topicMath.setsDesc("There are 2 questions in this section");
        topicPhysics.setsDesc("There are 2 questions in this section");
        topicMarvel.setsDesc("There are 2 questions in this section");

        ArrayList<question> mathQuestions = new ArrayList<>();
        ArrayList<question> physicsQuestions = new ArrayList<>();
        ArrayList<question> marvelQuestions = new ArrayList<>();

        mathQuestions.add(math1);
        mathQuestions.add(math2);
        physicsQuestions.add(physics1);
        physicsQuestions.add(physics2);
        marvelQuestions.add(marvel1);
        marvelQuestions.add(marvel2);

        topicMath.setQuestionCollection(mathQuestions);
        topicPhysics.setQuestionCollection(physicsQuestions);
        topicMarvel.setQuestionCollection(marvelQuestions);

        topics.add(topicMath);
        topics.add(topicPhysics);
        topics.add(topicMarvel);
    }

    @Override
    public String getTitle() {
        return topics.get(currentTopic).getTitle();
    }

    @Override
    public String getsDesc() {
        return topics.get(currentTopic).getsDesc();
    }

    @Override
    public String getlDesc() {
        return topics.get(currentTopic).getlDesc();
    }

    @Override
    public question getQuestion(int index) {
        return topics.get(currentTopic).getQuestion(currentQuestion);
    }

    @Override
    public ArrayList<question> getQuestionCollection() {
        return topics.get(currentTopic).getQuestionCollection();
    }

    @Override
    public int getCorrect() {
        return topics.get(currentTopic).getQuestion(currentQuestion).getCorrect();
    }

    @Override
    public String getQuestionText() {
        return topics.get(currentTopic).getQuestion(currentQuestion).getQuestionText();
    }

    @Override
    public ArrayList<String> getAnswers() {
        return topics.get(currentTopic).getQuestion(currentQuestion).getAnswers();
    }

    @Override
    public void setCurrentTopic(int topic) {
        currentTopic = topic;
    }

    public void setCurrentQuestion(int question){
        currentQuestion = question;
    }
}
