package com.example.abc.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // to view is the onCreate function called properly or not
        Toast.makeText(this, "OnCreate function called", Toast.LENGTH_LONG).show();


        Name = (EditText)findViewById(R.id.etName);
        Password = (EditText)findViewById(R.id.etPassword);
        Info = (TextView)findViewById(R.id.tvInfo);
        Login = (Button)findViewById(R.id.btnLogin);

        Info.setText("Incorrect attempts are: 5");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(), Password.getText().toString());


            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        // to check whether this function called or not
        Toast.makeText(this, "onStart function called", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // to check whether this function called or not
        Toast.makeText(this, "onResume function called", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        // to check whether this function called or not
        Toast.makeText(this, "onPause function called", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        // to check whether this function called or not
        Toast.makeText(this, "onStop function called", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // to check whether this function called or not
        Toast.makeText(this, "onDestroy function called", Toast.LENGTH_LONG).show();
    }

    public void onBackPressed() {
        super.onBackPressed();
        // to check whether this function called or not
        Toast.makeText(this, "onBackPressed function called", Toast.LENGTH_LONG).show();
    }

    public void closeApp(View v)
    {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);}

    private void validate (String userName, String userPassword)

    {
        if((userName.equals("123")) && (userPassword.equals("123"))){

            // this is the taost which will conmonly use by developer to show the message

            Toast.makeText(this, "successfully login!", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);

        }

        else
        {
            counter--;
            Info.setText("incorrect attempts remaining " + String.valueOf(counter));
            if (counter==0){
                Login.setEnabled(false);
            }

        }
    }
}
