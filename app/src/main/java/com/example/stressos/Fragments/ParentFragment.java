package com.example.stressos.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.stressos.Activities.LoginActivity;
import com.example.stressos.Api.RetroFitClient;
import com.example.stressos.R;
import com.example.stressos.data.LoggedInUser;
import com.example.stressos.responses.ParentResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ParentFragment extends Fragment {
    EditText editTextFirstName, editTextLastName, editTextOccupation;

    public ParentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_parent, container, false);
        editTextFirstName = view.findViewById(R.id.parent_first_name);
        editTextLastName = view.findViewById(R.id.parent_last_name);
        editTextOccupation = view.findViewById(R.id.parent_occupation);

        return view;
    }

}
