package com.example.activitylifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;


interface PassData {
    void passDataInSvreen();
}

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

//    @Override
//    public void passDataInSvreen() {
//        Log.i(TAG, "I am called using interface");
//    }

    private static final String TAG = "MainActivityTag";
    private ItemViewModel viewModel;
    PassData passData;

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i(TAG, "Main Activity onNewIntent");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate() callback started");
        TextView t = findViewById(R.id.title);

        viewModel = new ViewModelProvider(this).get(ItemViewModel.class);


//        viewModel.getSelectedItem().observe(this, item -> {
//            // Perform an action with the latest item data.
//            Log.i(TAG, "I am called");
//            t.setText(item);
//        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onStart() callback started");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart() callback started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume() callback started");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause() callback started");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop() callback started");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy() callback started");
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_container_view, FirstFragment.class, null)
//                    .addToBackStack(null)
                    .commit();

            getSupportFragmentManager()
                    .beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_container_view1, SecondFragment.class, null)
//                    .addToBackStack(null)
                    .commit();
        }else if(view.getId() == R.id.button1){
            passData = (PassData) getSupportFragmentManager().findFragmentById(R.id.fragment_container_view1);
            passData.passDataInSvreen();
        }
    }
}