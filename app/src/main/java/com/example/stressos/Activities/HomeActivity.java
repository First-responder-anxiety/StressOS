package com.example.stressos.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stressos.Api.RetroFitClient;
import com.example.stressos.BadgeActivity;
import com.example.stressos.Earned30DayBadge;
import com.example.stressos.Fragments.BadgesFragment;
import com.example.stressos.Fragments.HomeFragment;
import com.example.stressos.Fragments.ParentFragment;
import com.example.stressos.Fragments.QuestionnaireFragment;
import com.example.stressos.R;
import com.example.stressos.data.LoggedInUser;
import com.example.stressos.responses.ParentResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {
    private TextView mTextMessage;
    private String username;
    private final Fragment questionFrag = new QuestionnaireFragment();
    private final Fragment badgesFrag = new BadgesFragment();
    private final Fragment homeFrag = new HomeFragment();
    private final Fragment parentFrag = new ParentFragment();
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
                    fragmentManager.beginTransaction().hide(active).show(parentFrag).commit();
                    active = parentFrag;
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
        username = LoggedInUser.getUserName();
        mTextMessage.setText("Hello, " + username);
        fragmentManager.beginTransaction().add(R.id.home_container, badgesFrag, "3").hide(badgesFrag).commit();
        fragmentManager.beginTransaction().add(R.id.home_container, questionFrag, "2").hide(questionFrag).commit();
        fragmentManager.beginTransaction().add(R.id.home_container, homeFrag, "1").commit();
        fragmentManager.beginTransaction().add(R.id.home_container, parentFrag, "4").hide(parentFrag).commit();
    }

    public void openQuestionnaire(View view){
        Intent intent = new Intent(this, QuestionnaireActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
    }

    public void submitParents(View view) {
        EditText editTextFirstName, editTextLastName, editTextOccupation, editTextDayShiftStart;
        EditText editTextNightShiftTime, editTextDayShiftLength, editTextNightShiftLength;
        editTextFirstName = findViewById(R.id.parent_first_name);
        editTextLastName = findViewById(R.id.parent_last_name);
        editTextOccupation = findViewById(R.id.parent_occupation);
        editTextDayShiftStart = findViewById(R.id.day_shift_start_time);
        editTextDayShiftLength = findViewById(R.id.day_shift_length);
        editTextNightShiftTime = findViewById(R.id.night_shift_start_time);
        editTextNightShiftLength = findViewById(R.id.night_shift_length);
        String userName = LoggedInUser.getUserName();
        String firstName = editTextFirstName.getText().toString();
        String lastName = editTextLastName.getText().toString();
        String occupation = editTextOccupation.getText().toString();
        String dayShiftStart = editTextDayShiftStart.getText().toString();
        String dayShiftLength = editTextDayShiftLength.getText().toString();
        String nightShiftStart = editTextNightShiftTime.getText().toString();
        String nightShiftLength = editTextNightShiftLength.getText().toString();

        if (fieldError(firstName, editTextFirstName, "First name") ||
                fieldError(lastName, editTextLastName, "Last name") ||
                fieldError(occupation, editTextOccupation, "Occupation") ||
                fieldError(dayShiftStart, editTextDayShiftStart, "Day Shift Start Time") ||
                fieldError(dayShiftLength, editTextDayShiftLength, "Day Shift Length") ||
                fieldError(nightShiftStart, editTextNightShiftTime, "Night shift Start") ||
                fieldError(nightShiftLength, editTextNightShiftLength, "Night shift Length")) {
            return;
        }

        LoggedInUser.setParent_day_start(dayShiftStart);
        LoggedInUser.setParent_day_length(dayShiftLength);
        LoggedInUser.setParent_night_start(nightShiftStart);
        LoggedInUser.setParent_day_length(nightShiftLength);

        Call<ParentResponse> call = RetroFitClient
                .getInstance()
                .getApi()
                .insertparent(userName, firstName, lastName, occupation);

        call.enqueue(new Callback<ParentResponse>() {
            @Override
            public void onResponse(Call<ParentResponse> call, Response<ParentResponse> response) {
                ParentResponse parentResponse = response.body();
                if (parentResponse != null && !parentResponse.isError()) {
                    Toast.makeText(HomeActivity.this, "Added new Parent " + parentResponse.getFirst_name(), Toast.LENGTH_LONG).show();
                } else {
                    if (response.code() == 400) {
                        Toast.makeText(HomeActivity.this, "Could not find user", Toast.LENGTH_LONG).show();
                    } else if (response.code() == 401 || response.code() == 422) {
                        Toast.makeText(HomeActivity.this, "Programming error", Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ParentResponse> call, Throwable t) {
                Toast.makeText(HomeActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void createShiftActivity(View view) {
        Intent intent = new Intent(this, ShiftActivity.class);
        startActivity(intent);
    }

    private boolean fieldError(String fieldContent, EditText editText, String fieldName) {
        if (fieldContent.isEmpty()) {
            editText.setError(fieldName + " must be non-empty");
            editText.requestFocus();
            return true;
        }
        return false;
    }

    public void dummyBadgeEarned(View view) {
        Intent intent = new Intent(this, Earned30DayBadge.class);
        startActivity(intent);
    }

    public void startBadges(View view) {
        Intent intent = new Intent(this, BadgeActivity.class);
        startActivity(intent);
    }

}
