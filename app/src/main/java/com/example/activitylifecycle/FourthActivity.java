package com.example.activitylifecycle;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FourthActivity extends AppCompatActivity implements View.OnClickListener {

    //setup variables
    private static final String TAG = "FourthActivityTag";

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i(TAG, "Fourth Activity onNewIntent");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.button:
                //add logic for when the button is pressed
                Toast toast = Toast.makeText(FourthActivity.this, "Fourth Button Pressed", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.RIGHT, 0, 780);
                toast.show();

                Log.i(TAG, "button pressed");

                Intent MainActivityIntent = new Intent(FourthActivity.this, ThirdActivity.class);
                startActivity(MainActivityIntent);
        }
    }

    //========================================activity lifecycle callbacks code===============================
    // called when activity is first created
    // this callback is mandatory
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        TextView t = (TextView) findViewById(R.id.secondActivity);
        t.setText("Fourth Activity");

        Log.i(TAG, "onCreate() callback started");

        Toast toast = Toast.makeText(FourthActivity.this, "Fourth:onCreate()", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.RIGHT, 0, -480);
        toast.show();

        //Set up UI components in this callback in order to have them at the start of the activity
        //set listener for button
        final Button button = findViewById(R.id.button);
        button.setText("Fourth Btn");
        button.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart() callback started");

        Toast toast = Toast.makeText(FourthActivity.this, "Fourth:onStart()", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.RIGHT, 0, -280);
        toast.show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart() callback started");


        Toast toast = Toast.makeText(FourthActivity.this, "Fourth:onRestart()", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.RIGHT, 0, -80);
        toast.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume() callback started");

        Toast toast = Toast.makeText(FourthActivity.this, "Fourth:onResume()", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.RIGHT, 0, 120);
        toast.show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause() callback started");

        Toast toast = Toast.makeText(FourthActivity.this, "Fourth:onPause()", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.RIGHT, 0, 315);
        toast.show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop() callback started");

        Toast toast = Toast.makeText(FourthActivity.this, "Fourth:onStop()", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.RIGHT, 0, 510);
        toast.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy() callback started");

        //no toast is possible here because context will be null

    }
}