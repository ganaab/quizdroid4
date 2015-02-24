package edu.washington.ganaab.quizd2;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.app.AlarmManager.RTC_WAKEUP;


public class Preferences extends Activity {
    private PendingIntent pendingIntent;
    int interval = 6000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

        final Button button = (Button) findViewById(R.id.button8);
        final EditText editText = (EditText) findViewById(R.id.editText);
        final EditText editText2 = (EditText) findViewById(R.id.editText2);

        final Intent alarmIntent = new Intent(this, AlarmReceiver.class);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button.getText().equals("SUBMIT")) {
                    if(!editText.getText().toString().matches("") && !editText2.getText().toString().matches("")){
                        button.setText("STOP");
                        interval = 1000 * Integer.parseInt(editText2.getText().toString());
                        alarmIntent.putExtra("value", editText.getText().toString());
                        pendingIntent = PendingIntent.getBroadcast(Preferences.this, 0, alarmIntent, 0);
                        start();
                    }
                } else {
                    button.setText("SUBMIT");
                    cancel();
                }
            }
        });
    }
    public void start() {
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        manager.setInexactRepeating(RTC_WAKEUP, System.currentTimeMillis(), interval, pendingIntent);
        Toast.makeText(this, "Alarm Set", Toast.LENGTH_SHORT).show();
    }

    public void cancel() {
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        manager.cancel(pendingIntent);
        pendingIntent.cancel();
        Toast.makeText(this, "Alarm Canceled", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_preferences, menu);
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
}
