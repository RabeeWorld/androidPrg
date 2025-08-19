package com.example.adapter;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] fruits = {"Apple", "Banana", "Mango", "Orange", "Grapes"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            setContentView(R.layout.activity_main);

            // Initialize ListView safely
            listView = findViewById(R.id.listView);
            if (listView == null) {
                throw new NullPointerException("ListView is null. Check XML ID.");
            }

            // Create and set adapter safely
            ArrayAdapter<String> adapter = new ArrayAdapter<>(
                    this,
                    android.R.layout.simple_list_item_1,
                    fruits
            );

            listView.setAdapter(adapter);



        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Unexpected error occurred", Toast.LENGTH_LONG).show();
        }
    }
}
