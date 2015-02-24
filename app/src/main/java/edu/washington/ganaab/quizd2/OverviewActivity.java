package edu.washington.ganaab.quizd2;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;


public class OverviewActivity extends ActionBarActivity {

    static int numberCorrect = 0;
    static String num;
    static int choice;
    static AlertDialog dialog1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);
        QuizApp app = QuizApp.getInstance();
        num = app.getsDesc();
        // 1. Instantiate an AlertDialog.Builder with its constructor
        AlertDialog.Builder builder = new AlertDialog.Builder(OverviewActivity.this);

        // 2. Chain together various setter methods to set the dialog characteristics
        builder.setMessage("You have finished")
                .setTitle("Finish message");

        // 3. Get the AlertDialog from create()
        dialog1 = builder.create();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_overview, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_overview, container, false);
            final TextView over = (TextView) rootView.findViewById(R.id.textView3);
            over.setText(QuizApp.getInstance().getlDesc());

            TextView number = (TextView) rootView.findViewById(R.id.textView4);
            number.setText(num);
            Button begin = (Button) rootView.findViewById(R.id.button4);
            begin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction transaction = fm.beginTransaction();
                    transaction.replace(R.id.container, new PlaceholderFragment2());
                    transaction.commit();
                }
            });
            return rootView;
        }
    }
    public static class PlaceholderFragment2 extends Fragment {

        public PlaceholderFragment2() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_question, container, false);
            RadioButton one = (RadioButton) rootView.findViewById(R.id.radioButton1);
            RadioButton two = (RadioButton) rootView.findViewById(R.id.radioButton2);
            RadioButton three = (RadioButton) rootView.findViewById(R.id.radioButton3);
            RadioButton four = (RadioButton) rootView.findViewById(R.id.radioButton4);
            Button showSummary = (Button) rootView.findViewById(R.id.button5);
            TextView question = (TextView) rootView.findViewById(R.id.textView2);
            showSummary.setVisibility(View.VISIBLE);

            final boolean checked1 = one.isChecked();
            final boolean checked2 = two.isChecked();
            final boolean checked3 = three.isChecked();
            final boolean checked4 = four.isChecked();

            one.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    choice = 0;
                }
            });
            two.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    choice = 1;
                }
            });
            three.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    choice = 2;
                }
            });
            four.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    choice = 3;
                }
            });

            question.setText(QuizApp.getInstance().getQuestionText());
            final ArrayList<String> answers = QuizApp.getInstance().getAnswers();
            one.setText(answers.get(0));
            two.setText(answers.get(1));
            three.setText(answers.get(2));
            four.setText(answers.get(3));

            showSummary.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ArrayList<String> answersList = QuizApp.getInstance().getAnswers();
                    if(answersList.get(choice).equalsIgnoreCase(answersList.get(QuizApp.getInstance().getCorrect()))){
                        numberCorrect++;
                    }
                    if (checked1 || checked2 || checked3 || checked4) {

                    } else {
                        FragmentManager fm = getFragmentManager();
                        FragmentTransaction transaction = fm.beginTransaction();
                        transaction.replace(R.id.container, new PlaceholderFragment3());
                        transaction.commit();
                    }
                }
            });

            return rootView;
        }
    }
    public static class PlaceholderFragment3 extends Fragment {

        public PlaceholderFragment3() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_summary, container, false);
            TextView choice1 = (TextView) rootView.findViewById(R.id.textView5);
            TextView correct = (TextView) rootView.findViewById(R.id.textView6);
            TextView prog = (TextView) rootView.findViewById(R.id.textView7);
            Button nextQuestion = (Button) rootView.findViewById(R.id.button6);
            Button finisher = (Button) rootView.findViewById(R.id.button7);

            nextQuestion.setVisibility(View.VISIBLE);
            finisher.setVisibility(View.GONE);
            ArrayList<String> answerslist = QuizApp.getInstance().getAnswers();
            choice1.setText("You have chosen: " + answerslist.get(choice));
            correct.setText("Correct answer: " + answerslist.get(QuizApp.getInstance().getCorrect()));

            if(QuizApp.getInstance().currentQuestion==1){
                nextQuestion.setVisibility(View.GONE);
                finisher.setVisibility(View.VISIBLE);
            }
            prog.setText("You have answered " + numberCorrect + " out of " + (QuizApp.getInstance().currentQuestion + 1) + " correctly.");
            nextQuestion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    QuizApp.getInstance().setCurrentQuestion(1);
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction transaction = fm.beginTransaction();
                    transaction.replace(R.id.container, new PlaceholderFragment2());
                    transaction.commit();
                }
            });


            finisher.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog1.show();
                }
            });
            return rootView;
        }
    }
}
