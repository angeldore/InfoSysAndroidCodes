package com.braniax.cashcobra;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

public class MainActivity extends AppCompatActivity {


    //global variable for views

    EditText edtTxtUsername, edtTxtPassword, edtTxtServerIP;
    TextView txtVuIP;
    String incomingEdtTxtUsername, incomingEdtTxtPassword, uRL1, uRL2, incomingEdtTxtServerIP;
    Button btnSignIn;
    ImageView imgVuMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //registering the views declare above

        edtTxtUsername = findViewById(R.id.edt_txt_username);
        edtTxtPassword = findViewById(R.id.edt_txt_password);
        //edtTxtServerIP = findViewById(R.id.edt_txt_serverIP);
        btnSignIn = findViewById(R.id.btn_signin);
        imgVuMain = findViewById(R.id.img_vu_main);
        txtVuIP = findViewById(R.id.txt_vu_IP);




        // on click listener to signin button

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //calling validate function that will validate the entered data

                validateData();

            }
        });

        // on clik listener to imgVu Main

        imgVuMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SetServerIP myServerAddressDialog = new SetServerIP(MainActivity.this);
                myServerAddressDialog.show();
            }
        });
    }


    // function for validating data
    public void validateData(){

        incomingEdtTxtUsername = edtTxtUsername.getText().toString();
        incomingEdtTxtPassword = edtTxtPassword.getText().toString();

        if(incomingEdtTxtUsername.isEmpty() && incomingEdtTxtPassword.isEmpty()){
            edtTxtUsername.setError("Enter username!");
            edtTxtPassword.setError("Enter password!");
        }
        else if(incomingEdtTxtUsername.isEmpty()){
            edtTxtUsername.setError("Enter username!");
        }
        else if(incomingEdtTxtPassword.isEmpty()){
            edtTxtPassword.setError("Enter password!");
        }
        else if(!isEmailValid(incomingEdtTxtUsername)){
            edtTxtUsername.setError("Invalid type!");
        }
        else{
            //calling volley request in the function with param first is of GET second is of POST type
            //getServerData(incomingEdtTxtServerIP, incomingEdtTxtUsername, incomingEdtTxtPassword);

            //first check if Server address is entered or not

            if (incomingEdtTxtServerIP.isEmpty()){
                Toast.makeText(this, "No server found!", Toast.LENGTH_SHORT).show();
            }else
            postServerData(incomingEdtTxtServerIP, incomingEdtTxtUsername, incomingEdtTxtPassword);
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

    //function for checking data on server by receiving values passed as string using GET method

    public void getServerData(String IP, String ID, String Pass){


        //where URL contain the values in GET form
        uRL1 = "http://"+IP+"/cobra/index.php?pUsername="+ID+"&pPassword="+Pass;
               //where 0 = GET for POST use  value 1
        //where only 4 things are important first is value of GET/POST, second is URL, third is response fourth is error response
        StringRequest mStringRequest =  new StringRequest(0,
                uRL1,
                new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                //get data from the above url in a toast

                Toast.makeText(MainActivity.this, response, Toast.LENGTH_LONG).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                //getting data from the above url in a toast if error
                Toast.makeText(MainActivity.this, ""+error, Toast.LENGTH_LONG).show();

            }
        });

        // requesting queue

        RequestQueue mRequestQueue = Volley.newRequestQueue(MainActivity.this);
        mRequestQueue.add(mStringRequest);


    }

    //function for checking data on server by receiving values passed as string using POST method

    public void postServerData(final String IP, final String ID, final String Pass){


        //where in above code IP, ID and Pass are final because it will be used in inner class of map

                //where URL contain the values in POST form no need to pass values in URL it will pass in haspmap function below
        uRL2 = "http://"+IP+"/cobra/indexPost.php";
        //where 0 = GET for POST use  value 1
        //where only 4 things are important first is value of GET/POST, second is URL, third is response fourth is error response
        // in POST method Hash map is required which is the submethod of the map... it will just after the function with {}


        StringRequest mStringRequest = new StringRequest(1, uRL2, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //get data from the above url in a toast

                //Toast.makeText(MainActivity.this, response, Toast.LENGTH_LONG).show();
                //----------------------OR---------------------//
                //calling the toast method
                showToast(response, 1);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                //first converting the volleyError variable into string and storing it into string type variable
                String mError = error.toString();

                //getting data from the above url in a toast if error
                //Toast.makeText(MainActivity.this, ""+error, Toast.LENGTH_LONG).show();
                //--------------------OR we can toast the message with our own created toast method as--------//
                showToast(mError, 1);

            }

        }){

            //where just before the semicolon haspmap will start
            //search getparam and type it of type string string


            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> myParamsMap = new HashMap<>();
                //where in above code hashmap will converted into the Map type and then return to main function

                myParamsMap.put("pUsername", ID);
                myParamsMap.put("pPassword", Pass);
                return myParamsMap;

            }
        };

        // requesting queue

        RequestQueue mRequestQueue = Volley.newRequestQueue(MainActivity.this);
        mRequestQueue.add(mStringRequest);

    }


    //custom class for setIP dialogue box which is extends from dialogue class

    private class SetServerIP extends Dialog {

        //vairable globally declare for this class

        Button btnClose, btnIP;


        private Context mContext;
        //constructor for the class defined above

        public SetServerIP(@NonNull Context mContext) {
            super(mContext);
            this.mContext = mContext;

            //code for no title bar in dialog box

            requestWindowFeature(Window.FEATURE_NO_TITLE);
        }

        // now the onCreate function which will first to be run

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            //now set content view
            setContentView(R.layout.custom_dialogue_box);

            //Registering the button declare above

            btnClose = findViewById(R.id.btn_close);
            btnIP = findViewById(R.id.btn_IP);
            //in following code edtTxtSeriver IP globally declare in MainActivity this can be access any where
            edtTxtServerIP = findViewById(R.id.edt_txt_Ip_Dialog);


            //following code will adjust the dialog box as required
            // width is Match parrent and hieght is wrap content
            getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);


            //set on click listener for the close and serverIP buttons

            btnClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // close the dialog box

                    //-------------------------code for closing the dialog box-----------------//
                    //myDialogBox.cancel();
                    dismiss();

                }
            });

            // second click listener for the btn IP

            btnIP.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // set the value of the variable for server IP or address

                    //----------------code for setting the IP or address will be here--------//

                    incomingEdtTxtServerIP = edtTxtServerIP.getText().toString();
                    Toast.makeText(mContext, "You set the IP to"+incomingEdtTxtServerIP, Toast.LENGTH_SHORT).show();
                    // show this IP in main activity xml by assigning to its variable that is registered in main above

                    txtVuIP.setText(incomingEdtTxtServerIP);
                    dismiss();

                }
            });

        }
    }

    //global custom method for toast which will get string type variable and int value

    public void showToast(String msg, int length){

        if (length==0){

            //show the Toast for short length
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
        else if(length==1){
            //show the Toast for long length
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        }
    }

}
