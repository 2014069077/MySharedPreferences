package com.uy.mysharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextName, editTextPass;
    Button buttonSave, buttonDisplay;
    TextView textViewDisplay;
    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = (EditText) findViewById(R.id.input_name);
        editTextPass = (EditText) findViewById(R.id.input_pass);
        buttonSave = (Button) findViewById(R.id.btn_save);
        buttonDisplay = (Button) findViewById(R.id.btn_open);
        textViewDisplay = (TextView) findViewById(R.id.tv_display);
        preferences =getPreferences(Context.MODE_PRIVATE);
    }


    public void saveInfo(View view) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username", editTextName.getText().toString());
        editor.putString("password", editTextPass.getText().toString());
        editor.commit();
        Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show();
    }

    public void loadInfo (View view) {
        String user = preferences.getString("username", "");
        String pwd = preferences.getString("password", "");
        textViewDisplay.setText("The password of " + user + " is " + pwd);
    }
}

