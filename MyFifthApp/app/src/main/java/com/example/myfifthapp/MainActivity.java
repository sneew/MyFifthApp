package com.example.myfifthapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etnom;
    EditText etcognom;
    EditText ettelf;
    EditText etweb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etnom= findViewById(R.id.etNom);
        etcognom = findViewById(R.id.etCognom);
        ettelf = findViewById(R.id.etTelf);
        etweb= findViewById(R.id.etWeb);
    }

    public void mostrar(View view) {
        if(comprovar()) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            String txtNom = etnom.getText().toString();
            String txtCognom = etcognom.getText().toString();
            String txtWeb = etweb.getText().toString();
            String txtTelf = ettelf.getText().toString();
            intent.putExtra("txtNom", txtNom);
            intent.putExtra("txtCognom", txtCognom);
            intent.putExtra("txtTelf", txtTelf);
            intent.putExtra("txtWeb", txtWeb);
            startActivity(intent);
        }
    }

    public void borrar(View view) {
        openDialog();
    }

    public void openDialog() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);
        alertDialogBuilder.setTitle(getString(R.string.besborrar)); //modificar el titol
        alertDialogBuilder.setMessage(getString(R.string.pregunta))
                .setCancelable(false)
                .setPositiveButton(getString(R.string.btn_yes), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        deletefileds();
                    }
                })
                .setNegativeButton(getString(R.string.btn_no), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel(); // No fem res, tanquem el Alert.
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create(); //crear el alert dialog
        alertDialog.show(); //mostrar per pantalla
    }

    private void deletefileds() {
        etnom.setText("");
        etcognom.setText("");
        ettelf.setText("");
        etweb.setText("");
    }

    public boolean comprovar(){
        boolean istrue = true;
        if("".equals(etnom.getText().toString())){
            istrue = false;
            etnom.setError(getString(R.string.error)); //el text de l'string ve en int, l'hem de parsejar a String
        }
        if("".equals(etcognom.getText().toString())){
            istrue = false;
            etcognom.setError(getString(R.string.error)); //el text de l'string ve en int, l'hem de parsejar a String
        }
        if("".equals(ettelf.getText().toString())){
            istrue = false;
            ettelf.setError(getString(R.string.error)); //el text de l'string ve en int, l'hem de parsejar a String
        }
        if("".equals(etweb.getText().toString())){
            istrue = false;
            etweb.setError(getString(R.string.error)); //el text de l'string ve en int, l'hem de parsejar a String
        }
        return istrue;
    }
}
