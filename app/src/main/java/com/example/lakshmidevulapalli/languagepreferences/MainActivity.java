package com.example.lakshmidevulapalli.languagepreferences;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    SharedPreferences sharedPreferences;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        if(item.getItemId() == R.id.english){
            setLanguage("English");
        } else if (item.getItemId() == R.id.spanish){
            setLanguage("Spanish");
        }
        return true;
    }

    public void setLanguage(String language){
        sharedPreferences.edit().putString("language", language).apply();
        textView.setText(language);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        sharedPreferences = this.getSharedPreferences("com.example.lakshmidevulapalli.languagepreferences",MODE_PRIVATE);

        String language = sharedPreferences.getString("language", "");
        if(language == "") {

            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_btn_speak_now)
                    .setTitle("Select your Language!")
                    .setMessage("User preference for language")
                    .setPositiveButton("English", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //Toast.makeText(MainActivity.this, "English",Toast.LENGTH_SHORT).show();
                            setLanguage("English");
                        }
                    })
                    .setNegativeButton("Spanish", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //Toast.makeText(MainActivity.this, "Spanish", Toast.LENGTH_SHORT).show();
                            setLanguage("Spanish");
                        }
                    }).show();
        } else{
            textView.setText(language);
        }
    }
}
