package com.example.rafaj.fragmentapp;

import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import static android.util.Log.d;

public class Main2Activity extends AppCompatActivity{
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        text = findViewById(R.id.textId);
        Intent callingIntent = getIntent();

        String intentText = callingIntent.getStringExtra(Intent.EXTRA_TEXT);
        TextView textTitulo = findViewById(R.id.textTitulo);
        TextView textLugar = findViewById(R.id.textLugar);
        TextView textColor = findViewById(R.id.textColor);
        ImageView imgPlaneta = findViewById(R.id.imgPlaneta);


        if (true){
            Log.d("Mostrar", callingIntent.getStringExtra("KEY") + ", " + getIntent().getExtras().getInt("IMG"));
            text.setText(callingIntent.getStringExtra("KEY"));
            textTitulo.setText(callingIntent.getStringExtra("TIT"));
            textColor.setText(callingIntent.getExtras().getString("COL"));
            textLugar.setText(callingIntent.getExtras().getString("LUG"));
            imgPlaneta.setImageResource(callingIntent.getExtras().getInt("IMG"));
        }
    }
}
