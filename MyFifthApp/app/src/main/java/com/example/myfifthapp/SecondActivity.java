package com.example.myfifthapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    SharedPreferences prefs;
    TextView tvNom;
    TextView tvCognom;
    TextView tvWeb;
    TextView tvTelf;
    TextView tvContador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tvNom = findViewById(R.id.tvNom);
        tvCognom = findViewById(R.id.tvCognom);
        tvWeb = findViewById(R.id.tvWeb);
        tvTelf = findViewById(R.id.tvTelf);
        tvContador = findViewById(R.id.tvContador);

        String textN = getIntent().getStringExtra("txtNom");
        String textC = getIntent().getStringExtra("txtCognom");
        String textW = getIntent().getStringExtra("txtWeb");
        String textT = getIntent().getStringExtra("txtTelf");

        tvNom.setText(textN);
        tvCognom.setText(textC);
        tvWeb.setText(textW);
        tvTelf.setText(textT);

        prefs = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        int comptador= prefs.getInt("numeret",0);
        comptador= comptador +1;

        editor.putInt("numeret", comptador);
        editor.commit();
        tvContador.setText(String.valueOf(prefs.getInt("numeret", 0)));
    }

    public void anarWeb(View view) {
        String web = tvWeb.getText().toString();
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://"+web));
        startActivity(intent);
    }

    public void obrirTelf(View view) {
        int telf = Integer.parseInt(tvTelf.getText().toString());
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+telf));
        startActivity(intent);

    }

    public void borrar(View view) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.clear();
        editor.commit();
        tvContador.setText(String.valueOf(prefs.getInt("numeret", 0)));
    }
}
