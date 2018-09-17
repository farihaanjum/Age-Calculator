package com.example.iiucuser2.agecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button clear,calculate;
    EditText dtoday,mtoday,ytoday,ddob,mdob,ydob;
    TextView age;
    private Integer ageofperson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clear=(Button)findViewById(R.id.btnclear);
        calculate=(Button)findViewById(R.id.btncal);
        dtoday=(EditText)findViewById(R.id.dtoday);
        mtoday=(EditText)findViewById(R.id.mtoday);
        ytoday=(EditText)findViewById(R.id.ytoday);
        ddob=(EditText)findViewById(R.id.ddob);
        mdob=(EditText)findViewById(R.id.mdob);
        ydob=(EditText)findViewById(R.id.ydob);
        age=(TextView)findViewById(R.id.age);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer dd= Integer.parseInt(ddob.getText().toString());
                Integer mm= Integer.parseInt(mdob.getText().toString());
                Integer yy= Integer.parseInt(ydob.getText().toString());

                Integer d2= Integer.parseInt(dtoday.getText().toString());
                Integer m2= Integer.parseInt(mtoday.getText().toString());
                Integer y2= Integer.parseInt(ytoday.getText().toString());

                if(y2>yy){
                    if(m2.equals(mm)){
                        if(d2>dd  || d2.equals(dd)){
                            ageofperson=(y2-yy);
                        }
                        else if(d2<dd){
                            ageofperson=(y2-yy)-1;
                        }
                    }
                    else if(m2>mm){
                        ageofperson=(y2-yy);
                    }
                    else if(m2<mm){
                        ageofperson=(y2-yy)-1;
                    }
                    age.setText(ageofperson+" years");
                }
                else if(y2.equals(yy)){
                    if(m2>mm){
                        if(d2>dd){
                            age.setText((m2-mm)+" months "+(d2-dd)+" days");
                        }
                        else if(d2.equals(dd) || d2<dd){
                            age.setText((m2-mm)+" months");
                        }

                    }
                    else if(m2.equals(mm)){
                        if(d2>dd){
                            age.setText((d2-dd)+" days");
                        }
                        else if(d2.equals(dd)){
                            age.setText("Just came to this earth :P");
                        }
                        else{
                            age.setText("Invalid information");
                        }
                    }
                    else{
                       age.setText("Invalid information");
                    }

                }
                else{
                    age.setText("Invalid information");
                }

            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ddob.setText(null);
                ydob.setText(null);
                mdob.setText(null);
                age.setText(null);

            }
        });

    }
}
