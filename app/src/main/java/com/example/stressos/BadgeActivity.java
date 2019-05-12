package com.example.stressos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;

public class BadgeActivity extends AppCompatActivity {

    // As of right now, there are default values (top variables).
    // Will have to create a function that calculates these values or obtains them from the database.
    // Needs to be a STRING.
    private String userLongestStreak = "14";
    private String userCurrentStreak = "5";
    private String numberOfSurveysAnswered = "30";
    private String nextDayBadge = "50";

    private String streakBadgeDescription = "Your longest streak for answering our surveys is \n\n days in a row!";
    private String streakChallengeDescription = "Your Challenge: Beat it!\n\nCurrent Streak: ";
    private String surveyBadgeDescription = "You've answered our survey a total of \n\n" + numberOfSurveysAnswered + " times. \nKeep up the good work!";
    private String surveyChallengeDescription = "Your Challenge: Beat it \n\n and get the " + nextDayBadge + " day badge!";
    private String timeBadgeDescription = "";
    private String timeChallengeDescription = "";
    private String watchBadgeDescription = "";
    private String watchChallengeDescription = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_badge);

        /*
        // Set the streakBadgeDescription.
        TextView streakBadgeTextView = findViewById(R.id.mainBadgeDescription);
        streakBadgeTextView.setText(streakBadgeDescription);

        // Set the longest Streak number.
        TextView longestStreakTextView = findViewById(R.id.longestStreakNumber);
        longestStreakTextView.setText(userLongestStreak);

        // Set the current Streak number.
        TextView currentStreakTextView = findViewById(R.id.currentStreakNumber);
        currentStreakTextView.setText(userCurrentStreak);

        */

        // Default Badge Shown
        longestStreakAction(null);

    }

    // Called as default or when the button is clicked.
    public void longestStreakAction(View view) {
        // Set the streakBadgeDescription.
        TextView streakBadgeTextView = findViewById(R.id.mainBadgeDescription);
        streakBadgeTextView.setText(streakBadgeDescription);

        // Set the streakChallengeDescription.
        TextView streakChallengeTextView = findViewById(R.id.challengeDescription);
        streakChallengeTextView.setText(streakChallengeDescription);

        // Set the longest Streak number.
        TextView longestStreakTextView = findViewById(R.id.longestStreakNumber);
        longestStreakTextView.setText(userLongestStreak);

        // Set the current Streak number.
        TextView currentStreakTextView = findViewById(R.id.currentStreakNumber);
        currentStreakTextView.setText(userCurrentStreak);
    }

    // Called the button is clicked.
    public void surveyDayAction(View view) {
        // Set the surveyBadgeDescription.
        TextView surveyBadgeTextView = findViewById(R.id.mainBadgeDescription);
        surveyBadgeTextView.setText(surveyBadgeDescription);

        // Set the surveyChallengeDescription.
        TextView surveyChallengeTextView = findViewById(R.id.challengeDescription);
        surveyChallengeTextView.setText(surveyChallengeDescription);

        // Set the longest Streak number.
        TextView longestStreakTextView = findViewById(R.id.longestStreakNumber);
        longestStreakTextView.setText("");

        // Set the current Streak number.
        TextView currentStreakTextView = findViewById(R.id.currentStreakNumber);
        currentStreakTextView.setText("");
    }

    // Called the button is clicked.
    public void timeSurveyAction(View view) {
        // Set the timeBadgeDescription.
        TextView timeBadgeTextView = findViewById(R.id.mainBadgeDescription);
        timeBadgeTextView.setText(timeBadgeDescription);

        // Set the timeChallengeDescription.
        TextView timeChallengeTextView = findViewById(R.id.challengeDescription);
        timeChallengeTextView.setText(timeChallengeDescription);

        // Set the longest Streak number.
        TextView longestStreakTextView = findViewById(R.id.longestStreakNumber);
        longestStreakTextView.setText("");

        // Set the current Streak number.
        TextView currentStreakTextView = findViewById(R.id.currentStreakNumber);
        currentStreakTextView.setText("");
    }

    // Called the button is clicked.
    public void wearingWatchAction(View view) {
        // Set the watchBadgeDescription.
        TextView watchBadgeTextView = findViewById(R.id.mainBadgeDescription);
        watchBadgeTextView.setText(watchBadgeDescription);

        // Set the watchChallengeDescription.
        TextView watchChallengeTextView = findViewById(R.id.challengeDescription);
        watchChallengeTextView.setText(watchChallengeDescription);

        // Set the longest Streak number.
        TextView longestStreakTextView = findViewById(R.id.longestStreakNumber);
        longestStreakTextView.setText("");

        // Set the current Streak number.
        TextView currentStreakTextView = findViewById(R.id.currentStreakNumber);
        currentStreakTextView.setText("");
    }
}
