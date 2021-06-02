package com.example.signupapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText un_et1,pwd_et1;
    Button signin;
    int count=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        un_et1 = (EditText)findViewById(R.id.usrName);
        pwd_et1 = (EditText)findViewById(R.id.passwd);
        signin=(Button)findViewById(R.id.signinbtn);

        final  String regUserName = getIntent().getStringExtra("userName");
        final String regPassWord = getIntent().getStringExtra("passWord");

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName1 = un_et1.getText().toString();
                String passWord1 = pwd_et1.getText().toString();

                if(regUserName.equals(userName1)&&regPassWord.equals(passWord1)){
                    Intent intent1=new Intent(LoginActivity.this,LoginSucessActivity.class);
                    startActivity(intent1);
                }
                else{
                    Toast.makeText(LoginActivity.this,"login Failed",Toast.LENGTH_LONG).show();
                }
                count--;
                if(count==0){
                    Toast.makeText(getBaseContext(),"Failed Login Atempts",Toast.LENGTH_LONG).show();
                    signin.setEnabled(false);
                }

            }
        });
    }
}