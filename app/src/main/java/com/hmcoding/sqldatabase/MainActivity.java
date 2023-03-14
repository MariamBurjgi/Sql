package com.hmcoding.sqldatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    DBHelper dbHelper;
    EditText ename, esurname, eyear;
    Button del, add, get;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DBHelper(this);

        ename = findViewById(R.id.txt1);
        esurname = findViewById(R.id.txt2);
        eyear = findViewById(R.id.txt3);

        del = findViewById(R.id.btn1);
        add = findViewById(R.id.btn2);
        get = findViewById(R.id.btn3);

        del.setOnClickListener(this);
        add.setOnClickListener(this);
        get.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
            dbHelper.DeleteAll();
            break;

            case R.id.btn2:
                String name = ename.getText().toString();
                String surname = esurname.getText().toString();
                Integer year = Integer.parseInt(eyear.getText().toString());

                Data data = new Data(name, surname, year);
                dbHelper.AddOne(data);
                break;

            case R.id.btn3:
                LinkedList<Data> list = dbHelper.GetAll();

                String text = "";
                for (Data d:list) text = text + d.name + "" +d.surname + "" +d.year
                        +"/n";


        }

    }
}