package com.example.healthandwellbeing;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Register extends AppCompatActivity {

    private TextView username;
    private TextView surname ;
    private EditText emailAddress;
    private EditText phoneNo;
    private EditText password;
    private Button btnSubmit;
    private SQLiteOpenHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        username=findViewById(R.id.idUsername);
        surname=findViewById(R.id.idSurname);
        emailAddress=findViewById(R.id.idEmail);
        phoneNo=findViewById(R.id.IdCellno);
        password=findViewById(R.id.idPassword);

        btnSubmit=findViewById(R.id.idSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Username=username.getText().toString();
                String Surname=surname.getText().toString();
                String EmailAddress=emailAddress.getText().toString();
                String PhoneNo=phoneNo.getText().toString();
                String Password=password.getText().toString();

                insertUser(Username,Surname,EmailAddress,PhoneNo,Password);
            }
        });


    }
    private void insertUser(String Username, String Surname, String Email, String PhoneNo, String Password){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_Username, Username);
        values.put(DatabaseHelper.COLUMN_Surname,Surname );
        values.put(DatabaseHelper.COLUMN_Email,Email);
        values.put(DatabaseHelper.COLUMN_PhoneNo, PhoneNo);
        values.put(DatabaseHelper.COLUMN_Password,Password);
        long id = db.insert(DatabaseHelper.TABLE_USERS, null, values);
        if (id != -1) {
            Toast.makeText(Register.this, "New user saved :) with identity (PK): " + id, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(Register.this, "Failed to save new user. Try again!", Toast.LENGTH_SHORT).show();
        }
    }
}