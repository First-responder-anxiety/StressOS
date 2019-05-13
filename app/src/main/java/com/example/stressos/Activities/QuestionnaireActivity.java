package com.example.stressos.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.stressos.HelpQuestionActivity;
import com.example.stressos.R;

public class QuestionnaireActivity extends AppCompatActivity {

    private ImageButton badMood;
    private ImageButton goodMood;
    private ImageButton indifference;
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);
        addListenerToButtons();

    }

    public void addListenerToButtons(){
        badMood = (ImageButton) findViewById(R.id.badMood);
        goodMood = (ImageButton) findViewById(R.id.goodMood);
        indifference = (ImageButton) findViewById(R.id.neutralMood);
        next = (Button) findViewById(R.id.next);

        badMood.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                v.setSelected(!v.isSelected());
                goodMood.setSelected(false);
                indifference.setSelected(false);
                if(v.isSelected()) {
                    next.setEnabled(true);
                }
                else {
                    next.setEnabled(false);
                }
            }
        });

        goodMood.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                v.setSelected(!v.isSelected());
                badMood.setSelected(false);
                indifference.setSelected(false);
                if(v.isSelected()) {
                    next.setEnabled(true);
                }
                else {
                    next.setEnabled(false);
                }
            }
        });

        indifference.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                v.setSelected(!v.isSelected());
                goodMood.setSelected(false);
                badMood.setSelected(false);
                if(v.isSelected()) {
                    next.setEnabled(true);
                }
                else {
                    next.setEnabled(false);
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HelpQuestionActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private QuestionnaireActivity getActivity(){
        return this;
    }

}
