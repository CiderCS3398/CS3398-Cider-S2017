package com.example.sthomp.mysql_practice;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button showButton;
    private EditText idSearch;
    private String JSON_STRING;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        idSearch = (EditText) findViewById(R.id.idSearch);
        showButton = (Button) findViewById(R.id.showButton);
        showButton.setOnClickListener(this);
    }

    private void getUserNameQuery(View view) {
        String id = idSearch.getText().toString();
        String type = "getUsername";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, id);
    }

    @Override
    public void onClick(View v) {
        if(v == showButton) {
            getUserNameQuery(v);
        }
    }
}
