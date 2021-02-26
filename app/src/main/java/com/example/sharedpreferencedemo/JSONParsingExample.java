package com.example.sharedpreferencedemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class JSONParsingExample extends AppCompatActivity {
    String JSON_STRING = "{\"employee\":{\"name\":\"Omkar Gaware\",\"salary\":65000}}";
    String name, salary;
    TextView employeeName, employeeSalary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
        employeeName =  findViewById(R.id.txt_name);
        employeeSalary =  findViewById(R.id.txt_salary);

        try {
            JSONObject obj = new JSONObject(JSON_STRING);
            JSONObject employee = obj.getJSONObject("employee");
            name = employee.getString("name");
            salary = employee.getString("salary");
            // set employee name and salary in TextView's
            employeeName.setText("Name: " + name);
            employeeSalary.setText("Salary: " + salary);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
