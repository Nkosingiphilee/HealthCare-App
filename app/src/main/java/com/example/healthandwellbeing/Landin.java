package com.example.healthandwellbeing;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Landin extends AppCompatActivity {
    private Button btnBA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_landin);

        Bundle goodies = getIntent().getExtras();
        if (goodies !=null){
            String name = goodies.getString("username","not logged");
            TextView lgUser=findViewById(R.id.idLog);
            lgUser.setText("Logged as "+name);
        }
        btnBA=findViewById(R.id.idBookAp);
        btnBA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Landin.this,Appointment.class);
                startActivity(intent);
            }
        });
    }
}