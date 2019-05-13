package com.example.stressos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;

public class BadgeActivity extends AppCompatActivity {

    // As of right now, there are default values (top variables).
    // Will have to create a function that calculates these values or obtains them from the database.
    // Needs to be a STRING.
    private String userLongestStreak = "\n14";
    private String userCurrentStreak = "5";
    private String numberOfSurveysAnswered = "\n30";
    private String nextDayBadge = "50";
    private String timeRespondingToNotification = "\n180";

    private String streakBadgeDescription = "\nYour longest streak for answering our surveys is \n\n days in a row!";
    private String streakChallengeDescription = "Your Challenge: Beat it!\n\nCurrent Streak: ";
    private String surveyBadgeDescription = "\nYou've answered our \n survey a total of \n\n     times. Good job!";
    private String surveyChallengeDescription = "Your Challenge: Beat it \n\n and get the " + nextDayBadge + " day badge!";
    private String timeBadgeDescription = "\nYour record in responding to our survey notification is \n\n   seconds!";
    private String timeChallengeDescription = "Keep up the good work \n\n and thanks for your help!";
    private String watchBadgeDescription = "\n";
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
        // Set the heading.
        TextView streakBadgeHeading = findViewById(R.id.mainBadgeHeading);
        streakBadgeHeading.setText("Longest Streak\n");

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
        // Set the heading.
        TextView streakBadgeHeading = findViewById(R.id.mainBadgeHeading);
        streakBadgeHeading.setText("One Survey at a Time\n");

        // Set the surveyBadgeDescription.
        TextView surveyBadgeTextView = findViewById(R.id.mainBadgeDescription);
        surveyBadgeTextView.setText(surveyBadgeDescription);

        // Set the surveyChallengeDescription.
        TextView surveyChallengeTextView = findViewById(R.id.challengeDescription);
        surveyChallengeTextView.setText(surveyChallengeDescription);

        // Set the longest Streak number.
        TextView longestStreakTextView = findViewById(R.id.longestStreakNumber);
        longestStreakTextView.setText(numberOfSurveysAnswered);

        // Set the current Streak number.
        TextView currentStreakTextView = findViewById(R.id.currentStreakNumber);
        currentStreakTextView.setText("");
    }

    // Called the button is clicked.
    public void timeSurveyAction(View view) {
        // Set the heading.
        TextView streakBadgeHeading = findViewById(R.id.mainBadgeHeading);
        streakBadgeHeading.setText("Lightning Fast Response\n");

        // Set the timeBadgeDescription.
        TextView timeBadgeTextView = findViewById(R.id.mainBadgeDescription);
        timeBadgeTextView.setText(timeBadgeDescription);

        // Set the timeChallengeDescription.
        TextView timeChallengeTextView = findViewById(R.id.challengeDescription);
        timeChallengeTextView.setText(timeChallengeDescription);

        // Set the longest Streak number.
        TextView longestStreakTextView = findViewById(R.id.longestStreakNumber);
        longestStreakTextView.setText(timeRespondingToNotification);

        // Set the current Streak number.
        TextView currentStreakTextView = findViewById(R.id.currentStreakNumber);
        currentStreakTextView.setText("");
    }

    // Called the button is clicked.
    public void wearingWatchAction(View view) {
        // Set the heading.
        TextView streakBadgeHeading = findViewById(R.id.mainBadgeHeading);
        streakBadgeHeading.setText("Watching Your Health\n");

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
