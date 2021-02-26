package com.example.sharedpreferencedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    CheckBox rememberMe;
    Button login, btn_sqlite,btn_Json;
    private SharedPreferences preferences;
    String name;
    String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.et_username);
        password = findViewById(R.id.et_password);
        rememberMe = findViewById(R.id.checkbox_remember);
        login = findViewById(R.id.btn_login);
        btn_sqlite = findViewById(R.id.btn_sqlite);
        btn_Json=findViewById(R.id.btn_Json);
        preferences = this.getSharedPreferences("login", this.MODE_PRIVATE);

        name = preferences.getString("name", "");

        pass = preferences.getString("pass", "");
        username.setText(name);
        password.setText(pass);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=username.getText().toString();
                pass=password.getText().toString();
                if (rememberMe.isChecked()) {
                    savedData(name,pass);
                    Toast.makeText(getApplicationContext(), "Checked", Toast.LENGTH_SHORT).show();
                    username.setText(name);
                    password.setText(pass);
                } else {
                   savedData("","");
                    Toast.makeText(getApplicationContext(), "UnChecked", Toast.LENGTH_SHORT).show();
                    username.setText("");
                    password.setText("");
                }
            }
        });


//        rememberMe.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked) {
//                    Toast.makeText(getApplicationContext(), "Checked", Toast.LENGTH_SHORT).show();
//                    aBoolean = true;
//                } else
//                    Toast.makeText(getApplicationContext(), "UnChecked", Toast.LENGTH_SHORT).show();
//                    aBoolean = false;
//
//
//            }
//        });

        btn_sqlite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Demo_Sqlite_Activity.class);
                startActivity(intent);
            }
        });
        btn_Json.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,JSONParsingExample.class);
                startActivity(intent);
            }
        });
    }

    public void savedData(String str_username,String str_password){
        SharedPreferences.Editor ed = preferences.edit();
        ed.putString("name", str_username);
        ed.putString("pass", str_password);
        ed.commit();
    }

}