package com.example.healthandwellbeing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button buttonRegister;
    private Button buttonlogin;
    private TextView username;
    private TextView password;
    private TextView result;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.idLoginUser);
        password=findViewById(R.id.idLoginPassword);
        result=findViewById(R.id.idResult);

       buttonRegister=findViewById(R.id.idRegister);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this, Register.class);
                startActivity(intent);
            }
        });
        btnLogin=findViewById(R.id.idLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Username=username.getText().toString();
                String Password=password.getText().toString();

                if (Username.equals("username") && Password.equals("password")){
                    Intent intent=new Intent(MainActivity.this,Landin.class);
                    intent.putExtra("username",Username);
                    Toast.makeText(MainActivity.this,"log In successful",Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }else {
                    username.setText("");
                    password.setText("");
                    Toast.makeText(MainActivity.this,"login unsuccessful",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

}