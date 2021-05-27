package com.example.mysimplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bdot,beql,bmul,badd,bclr,bsub,bdiv;
    double in1=0,in2=0;
    EditText et1;
    boolean Add,Sub,Multiply,Divide,deci;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        b0=(Button)findViewById(R.id.b14);
        b1=(Button)findViewById(R.id.b9);
        b2=(Button)findViewById(R.id.b10);
        b3=(Button)findViewById(R.id.b11);
        b4=(Button)findViewById(R.id.b5);
        b5=(Button)findViewById(R.id.b6);
        b6=(Button)findViewById(R.id.b7);
        b7=(Button)findViewById(R.id.b1);
        b8=(Button)findViewById(R.id.b2);
        b9=(Button)findViewById(R.id.b3);

        bsub=(Button)findViewById(R.id.b12);
        badd=(Button)findViewById(R.id.b16);
        bmul=(Button)findViewById(R.id.b8);
        bdiv=(Button)findViewById(R.id.b4);
        bclr=(Button)findViewById(R.id.b17);
        bdot=(Button)findViewById(R.id.b13);
        beql=(Button)findViewById(R.id.b15);

        et1=(EditText)findViewById(R.id.display);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et1.setText(et1.getText()+"1");
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et1.setText(et1.getText()+"2");
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et1.setText(et1.getText()+"3");
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et1.setText(et1.getText()+"4");
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et1.setText(et1.getText()+"5");
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et1.setText(et1.getText()+"6");
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et1.setText(et1.getText()+"7");
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et1.setText(et1.getText()+"8");
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et1.setText(et1.getText()+"9");
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et1.setText(et1.getText()+"0");
            }
        });

        badd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et1.getText().length()!=0){
                    in1=Float.parseFloat(et1.getText()+"");
                    Add=true;
                    deci=false;
                    et1.setText(null);
                }

            }
        });

        bsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et1.getText().length()!=0){
                    in1=Float.parseFloat(et1.getText()+"");
                    Sub=true;
                    deci=false;
                    et1.setText(null);
                }

            }
        });

        bmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et1.getText().length()!=0){
                    in1=Float.parseFloat(et1.getText()+"");
                    Multiply=true;
                    deci=false;
                    et1.setText(null);
                }

            }
        });

        bdiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et1.getText().length()!=0){
                    in1=Float.parseFloat(et1.getText()+"");
                    Divide=true;
                    deci=false;
                    et1.setText(null);
                }

            }
        });

        beql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Add || Sub || Multiply || Divide){
                    in2 = Float.parseFloat(et1.getText()+"");

                }
                if(Add){
                    et1.setText(in1+in2+"");
                    Add=false;
                }
                if(Sub){
                    et1.setText(in1-in2+"");
                    Sub=false;
                }
                if(Multiply){
                    et1.setText(in1*in2+"");
                    Multiply=false;
                }
                if(Divide){
                    et1.setText(in1/in2+"");
                    Divide=false;
                }

            }
        });


        bclr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et1.setText("");
                in1=0.0;
                in2=0.0;
            }
        });
        bdot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!deci){
                    et1.setText(et1.getText()+".");
                    deci=true;
                }

            }
        });

    }
}