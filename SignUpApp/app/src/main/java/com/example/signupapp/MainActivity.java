package com.example.signupapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText un_et,pwd_et;
    Button signup_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        un_et = (EditText)findViewById(R.id.unEditText);
        pwd_et = (EditText)findViewById(R.id.pwdEditText);
        signup_btn=(Button)findViewById(R.id.signupbtn);

        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = un_et.getText().toString();
                String passWord = pwd_et.getText().toString();
                if(!isValidPassword(passWord))
                {
                    Toast.makeText(MainActivity.this,"Invalid Password",Toast.LENGTH_LONG).show();
                    return;
                }
                Intent intent= new Intent(MainActivity.this,LoginActivity.class);
                intent.putExtra("userName",userName);
                intent.putExtra("passWord",passWord);
                startActivity(intent);

            }
        });
    }
    Pattern lowercase = Pattern.compile("^.*[a-z].*$");
    Pattern uppercase = Pattern.compile("^.*[A-Z].*$");
    Pattern number = Pattern.compile("^.*[0-9].*$");
    Pattern spclchars = Pattern.compile("^.*[^a-zA-z0-9].*$");

    private boolean isValidPassword(String passWord){
        if(passWord.length()<8){
            return false;
        }
        if(!lowercase.matcher(passWord).matches()){
            return false;
        }
        if(!uppercase.matcher(passWord).matches()){
            return false;
        }
        if(!number.matcher(passWord).matches()){
            return false;
        }
        if(!spclchars.matcher(passWord).matches()){
            return false;
        }
        return true;
    }
}