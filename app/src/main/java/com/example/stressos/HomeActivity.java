package com.example.stressos;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    private TextView mTextMessage;
    private String username;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText("Hello, " + username);
                    return true;
                case R.id.navigation_badges:
                    mTextMessage.setText(R.string.title_badges);
                    return true;
                case R.id.navigation_questionnaire:
                    mTextMessage.setText(R.string.title_questionnaire);
                    return true;
                case R.id.navigation_settings:
                    mTextMessage.setText(R.string.title_settings);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Intent intent = getIntent();
        username = intent.getStringExtra("USERNAME");
        mTextMessage.setText("Hello, " + username);
    }

    @Override
    public void onBackPressed() {
    }

}
