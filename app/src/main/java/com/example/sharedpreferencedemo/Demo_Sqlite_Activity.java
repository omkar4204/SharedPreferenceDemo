package com.example.sharedpreferencedemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Demo_Sqlite_Activity extends Activity {
    DatabaseHelper myDB;
    EditText edt_username, edt_password;
    Button Add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        myDB = new DatabaseHelper(this);

        edt_username = (EditText) findViewById(R.id.editTextUserName);
        edt_password = (EditText) findViewById(R.id.editTextPassword);
        Add = (Button) findViewById(R.id.buttonCreateAccount);


        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addData();
            }
        });
    }

    public void addData() {
        boolean status = myDB.insertData(edt_username.getText().toString(), edt_password.getText().toString());
        if (status)
            Toast.makeText(Demo_Sqlite_Activity.this, edt_username.getText().toString()+ "," + edt_password.getText().toString(), Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(Demo_Sqlite_Activity.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();
    }
}
