package edu.washington.ganaab.quizd2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class TopicsActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topics);
        Button math = (Button) findViewById(R.id.button);
        Button physics = (Button) findViewById(R.id.button2);
        Button marvel = (Button) findViewById(R.id.button3);

        math.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextActivity = new Intent(TopicsActivity.this, OverviewActivity.class);
                QuizApp.getInstance().setCurrentTopic(0);
                if(nextActivity.resolveActivity(getPackageManager()) != null) {
                    startActivity(nextActivity);
                }
                finish();
            }
        });
        physics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextActivity = new Intent(TopicsActivity.this, OverviewActivity.class);
                QuizApp.getInstance().setCurrentTopic(1);
                if(nextActivity.resolveActivity(getPackageManager()) != null) {
                    startActivity(nextActivity);
                }
                finish();
            }
        });
        marvel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextActivity = new Intent(TopicsActivity.this, OverviewActivity.class);
                QuizApp.getInstance().setCurrentTopic(2);
                if(nextActivity.resolveActivity(getPackageManager()) != null) {
                    startActivity(nextActivity);
                }
                finish();
            }
        });


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
            Intent nextActivity = new Intent(TopicsActivity.this, Preferences.class);
            if(nextActivity.resolveActivity(getPackageManager()) != null) {
                startActivity(nextActivity);
            }
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
