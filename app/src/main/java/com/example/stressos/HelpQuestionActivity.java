package com.example.stressos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HelpQuestionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_question);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, QuestionnaireActivity.class);
        startActivity(intent);
        finish();
    }

    public void exit(View view){
        finish();
    }

}
