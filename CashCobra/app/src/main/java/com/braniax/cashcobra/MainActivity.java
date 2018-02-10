package com.braniax.cashcobra;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

public class MainActivity extends AppCompatActivity {


    //global variable for views

    EditText edtTxtUsername, edtTxtPassword;
    String incomingEdtTxtUsername, incomingEdtTxtPassword;
    Button btnSignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //registering the views declare above

        edtTxtUsername = findViewById(R.id.edt_txt_username);
        edtTxtPassword = findViewById(R.id.edt_txt_password);
        btnSignIn = findViewById(R.id.btn_signin);


        // on click listener to signin button

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //calling validate function that will validate the entered data

                validateData();

            }
        });
    }


    // function for validating data
    public void validateData(){

        incomingEdtTxtUsername = edtTxtUsername.getText().toString();
        incomingEdtTxtPassword = edtTxtPassword.getText().toString();

        if(incomingEdtTxtUsername.isEmpty() && incomingEdtTxtPassword.isEmpty()){
        }
        else if(incomingEdtTxtUsername.isEmpty()){
        }
        else if(incomingEdtTxtPassword.isEmpty()){
        }
        else if(!isEmailValid(incomingEdtTxtUsername)){
        }
        else{
            //calling volley request in the function
        }
    }

    //function for validating email

    public boolean isEmailValid(String email) {
        String regExpn =
                "^([a-zA-Z0-9_\\-.]+)@([a-zA-Z0-9_\\-.]+)\\.([a-zA-Z]{2,5})$";

        CharSequence inputStr = email;

        Pattern pattern = compile(regExpn, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);

        if (matcher.matches())
            return true;
        else
            return false;
    }


}
