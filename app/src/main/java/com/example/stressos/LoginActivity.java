package com.example.stressos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.stressos.Api.RetroFitClient;
import com.example.stressos.data.LoggedInUser;
import com.example.stressos.responses.UserNameResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    EditText editTextUserName, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editTextUserName = findViewById(R.id.username);
        editTextPassword = findViewById(R.id.password);
    }

    /**
     * Called when the user presses the login button
     * @param view The login view
     */
    public void login(View view) {
        final String userName = editTextUserName.getText().toString();
        String password = editTextPassword.getText().toString();
        if (fieldError(password, editTextPassword, "Password")) {
            return;
        }

        Call<UserNameResponse> call = RetroFitClient
                .getInstance()
                .getApi()
                .userlogin(userName, password);

        call.enqueue(new Callback<UserNameResponse>() {
            @Override
            public void onResponse(Call<UserNameResponse> call, Response<UserNameResponse> response) {
                UserNameResponse userNameResponse = response.body();
                if (!userNameResponse.isError()) {
                    Toast.makeText(LoginActivity.this, userNameResponse.getMessage(), Toast.LENGTH_LONG).show();
                    LoggedInUser.setUserName(userNameResponse.getUserName());
                } else {
                    if (response.code() == 400) {
                        // Username does not exits
                        editTextUserName.setError("Email is invalid");
                        editTextUserName.requestFocus();
                        LoggedInUser.setUserName(userNameResponse.getUserName());
                    } else if (response.code() == 401) {
                        // Password is wrong
                        editTextPassword.setError("Password is invalid");
                        editTextPassword.requestFocus();
                    } else if (response.code() == 422) {
                        // Programming error;
                        Toast.makeText(LoginActivity.this, "Programming Error", Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<UserNameResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private boolean fieldError(String fieldContent, EditText editText, String message) {
        if (fieldContent.isEmpty()) {
            editText.setError(message + " must not be empty");
            editText.requestFocus();
            return true;
        } else if (fieldContent.length() < 6) {
            editText.setError(message + " must be at least 6 characters long");
            editText.requestFocus();
            return true;
        }
        return false;
    }
}

