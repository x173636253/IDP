package com.example.xid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button to open profile details page
        button = (Button)findViewById(R.id.buttonProfDetails);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProfDetails();
            }
        });

        //Button to open the banking details page
        button = (Button)findViewById(R.id.buttonBankDetails);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBankDetails();
            }
        });

        //Button to open price plan details page
        button = (Button)findViewById(R.id.buttonPricePlan);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            openPricePlan();
            }
        });

        //Button to open change password page
        button = (Button)findViewById(R.id.buttonChangePword);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChangePassword();
            }
        });

        //Button to open the fingerprint changing/adding page page
        button = (Button)findViewById(R.id.buttonFPEdits);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFPEdits();
            }
        });

        //Button to open the FAQ page
        button = (Button)findViewById(R.id.buttonQuestion);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuestion();
            }
        });

        //Button to open support contact details page
        button = (Button)findViewById(R.id.buttonContactSupport);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openContactSupport();
            }
        });

    }

    //profile details intent
    public void openProfDetails(){
        Intent intent = new Intent(this, ProfileDetailsPage.class);
        startActivity(intent);
    }

    //bank details intent
    public void openBankDetails(){
        Intent intent = new Intent(this, BankDetails.class);
        startActivity(intent);
    }

    //price plan intent
    public void openPricePlan(){
        Intent intent = new Intent(this, PricePlan.class);
        startActivity(intent);
    }

    //change password intent
    public void openChangePassword(){
        Intent intent = new Intent (this,ChangePassword.class);
        startActivity(intent);
    }

    //fingerprint changing/adding intent
    public void openFPEdits(){
        Intent intent = new Intent(this, FPEdits.class);
        startActivity(intent);
    }

    //FAQ intent
    public void openQuestion(){
        Intent intent = new Intent(this, Question.class);
        startActivity(intent);
    }

    //support contact intent
    public void openContactSupport(){
        Intent intent = new Intent(this, ContactSupport.class);
        startActivity(intent);
    }
}
