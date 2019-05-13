package com.example.stressos;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    private TextView mTextMessage;
    private String username;
    private final Fragment questionFrag = new QuestionnaireFragment();
    private final Fragment badgesFrag = new BadgesFragment();
    private final Fragment homeFrag = new HomeFragment();
    final FragmentManager fragmentManager = getSupportFragmentManager();
    Fragment active = homeFrag;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText("Hello, " + username);
                    fragmentManager.beginTransaction().hide(active).show(homeFrag).commit();
                    active = homeFrag;
                    return true;
                case R.id.navigation_badges:
                    mTextMessage.setText(R.string.title_badges);
                    fragmentManager.beginTransaction().hide(active).show(badgesFrag).commit();
                    active = badgesFrag;
                    return true;
                case R.id.navigation_questionnaire:
                    mTextMessage.setText(R.string.title_questionnaire);
                    fragmentManager.beginTransaction().hide(active).show(questionFrag).commit();
                    active = questionFrag;
                    return true;
                case R.id.navigation_parents:
                    mTextMessage.setText(R.string.title_parents);
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
        fragmentManager.beginTransaction().add(R.id.home_container, badgesFrag, "3").hide(badgesFrag).commit();
        fragmentManager.beginTransaction().add(R.id.home_container, questionFrag, "2").hide(questionFrag).commit();
        fragmentManager.beginTransaction().add(R.id.home_container, homeFrag, "1").commit();

    }

    public void openQuestionnaire(View view){
        Intent intent = new Intent(this, QuestionnaireActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
    }

}
