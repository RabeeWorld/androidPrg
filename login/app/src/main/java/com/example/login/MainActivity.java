package com.example.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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
        EditText passwordText = findViewById(R.id.pass);
        Button loginbtn = findViewById(R.id.button2);
        EditText usernameText = findViewById(R.id.user);

        loginbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String user = usernameText.getText().toString();
                String pass = passwordText.getText().toString();

                if (user.equals("admin") && pass.equals("admin")) {
                    Toast.makeText(MainActivity.this, "login susess", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.ma(MainActivity.this, "failed", Toast.LENGTH_SHORT).show();;
                }
            }
        });
    }
}