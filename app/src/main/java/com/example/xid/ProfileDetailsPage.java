package com.example.xid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProfileDetailsPage extends AppCompatActivity {

    EditText e1;
    Button b1;
    TextView t1;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_details_page);

        e1=(EditText)findViewById(R.id.editTextNewEmail);
        b1=(Button)findViewById(R.id.buttonChangeEmail);
        t1=(TextView)findViewById(R.id.textViewCurrentEmail);

        ButtonClick();
    }

    //public static boolean emailValidate(String email){ }

//email validator
    private void ButtonClick(){
        //boolean validEmail = false;
        String expression = "^[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]$";
        CharSequence input = email;
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()){
            //validEmail = true;
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    t1.setText(e1.getText().toString());
                }
            });


        }
    }
}
