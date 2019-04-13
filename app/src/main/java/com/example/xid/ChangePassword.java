package com.example.xid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ChangePassword extends AppCompatActivity {

    EditText oldPassword, newPassword, confirmPassword;
    String pword;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        oldPassword = (EditText)findViewById(R.id.editTextUserPassword);
        newPassword = (EditText)findViewById(R.id.editTextNewPassword);
        confirmPassword = (EditText)findViewById(R.id.editTextConfirmNew);
        pword = "oldPassword";

        buttonOnClick();
    }

    public void buttonOnClick(){
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newPassword.setText(oldPassword.getText().toString());
            }
        });

    }
}
