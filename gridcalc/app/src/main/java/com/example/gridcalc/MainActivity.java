package com.example.gridcalc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText num1,num2;

    TextView result;
    Button btnadd,btnmul,btndiv,btnsub,btnc;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        num1=findViewById(R.id.n1);
        num2=findViewById(R.id.n2);
        btnadd=findViewById(R.id.add);
        btnmul=findViewById(R.id.mul);
        btndiv=findViewById(R.id.div);
        btnsub=findViewById(R.id.sub);
        btnc=findViewById(R.id.c);
        result=findViewById(R.id.tvInput);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a=Integer.parseInt(num1.getText().toString());
                double b=Integer.parseInt(num2.getText().toString());
                double res=a+b;
                result.setText(String.valueOf(res));


            }


        });
        btnmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a=Integer.parseInt(num1.getText().toString());
                double b=Integer.parseInt(num2.getText().toString());
                double res=a*b;
                result.setText(String.valueOf(res));


            }


        });
        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a=Integer.parseInt(num1.getText().toString());
                double b=Integer.parseInt(num2.getText().toString());
                double res=a-b;
                result.setText(String.valueOf(res));


            }


        });
        btndiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a=Integer.parseInt(num1.getText().toString());
                double b=Integer.parseInt(num2.getText().toString());
                double res=a/b;
                result.setText(String.valueOf(res));


            }


        });
        btnc.setOnClickListener(v -> {
            num1.setText("");
            num2.setText("");
            result.setText("0.0");
        });










    }
}