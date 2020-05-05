package com.example.guardianapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Manual_Input1 extends AppCompatActivity {
    String state, city;
    Button submitButton;

    EditText stateInput;
    EditText cityInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual__input1);

        stateInput = (EditText) findViewById(R.id.state_input);
        //cityInput = findViewById(R.id.city_input);

        submitButton = (Button) findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                state = stateInput.getText().toString();
                //city = cityInput.getText().toString();
                openDataofState();
            }
        });
    }
    public void openDataofState() {
        Intent intent = new Intent(this, DataofState.class);
        intent.putExtra("State", state);
        startActivity(intent);
    }
}
