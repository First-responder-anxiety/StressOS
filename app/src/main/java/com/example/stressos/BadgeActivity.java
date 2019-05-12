package com.example.stressos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BadgeActivity extends AppCompatActivity {

    // As of right now, there is a default longest streak and current streak.
    // Will have to create a function that calculates these two values or obtains them from the database.
    // Needs to be a STRING.
    private String userLongestStreak = "14";
    private String userCurrentStreak = "5";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_badge);

        // Set the longest Streak number.
        TextView longestStreakTextView = findViewById(R.id.longestStreakNumber);
        longestStreakTextView.setText(userLongestStreak);

        // Set the current Streak number.
        TextView currentStreakTextView = findViewById(R.id.currentStreakNumber);
        currentStreakTextView.setText(userCurrentStreak);

    }
}
