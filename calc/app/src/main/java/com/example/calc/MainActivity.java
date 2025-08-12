package com.example.calc;

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

    Button btnadd,btnsub,btnmul,btndiv;
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
        num1=findViewById(R.id.number1);
        num2=findViewById(R.id.number2);
        btnadd=findViewById(R.id.add);
        btnsub=findViewById(R.id.sub);
        btnmul=findViewById(R.id.mul);
        btndiv=findViewById(R.id.div);
        result=findViewById(R.id.res);


        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a= Integer.parseInt(num1.getText().toString());
                double b= Integer.parseInt(num2.getText().toString());
                double res=a+b;
                result.setText("Result"+res);

            }

        });
        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a= Integer.parseInt(num1.getText().toString());
                double b= Integer.parseInt(num2.getText().toString());
                double res=a-b;
                result.setText("Result" + res);

            }

        });
        btnmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a= Integer.parseInt(num1.getText().toString());
                double b= Integer.parseInt(num2.getText().toString());
                double res=a*b;
                result.setText("Result"+res);

            }

        });
        btndiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a= Integer.parseInt(num1.getText().toString());
                double b= Integer.parseInt(num2.getText().toString());
                double res=a/b;
                result.setText("Result"+res);

            }

        });




    }
}