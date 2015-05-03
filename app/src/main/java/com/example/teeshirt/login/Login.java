package com.example.teeshirt.login;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Login extends ActionBarActivity {
    private static EditText etUser, etPass;
    private static TextView tvAttempts;
    private static Button loginBtn;
    int attempts_counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginBtnOnClick();
    }


    public void loginBtnOnClick(){
        etUser = (EditText)findViewById(R.id.etUser);
        etPass = (EditText)findViewById(R.id.etPass);
        tvAttempts = (TextView)findViewById(R.id.tvAttempts);
        loginBtn = (Button)findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etUser.getText().toString().equals("user") && etPass.getText().toString().equals("pass")){
                    Toast.makeText(Login.this, "Correct username & password", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent("com.example.teeshirt.login.User");
                    startActivity(intent);
                }
                else{
                    Toast.makeText(Login.this, "Incorrect username or password", Toast.LENGTH_SHORT).show();
                    attempts_counter-=1;
                    if (attempts_counter==0){
                        loginBtn.setEnabled(false);
                    }

                    tvAttempts.setText(Integer.toString(attempts_counter));
                }
            }
        });
    }
}
