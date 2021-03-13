package com.example.quiz1eco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button Registrar;
    private TextView Registros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Registrar = findViewById(R.id.Registrar);
        Registros = findViewById(R.id.listaRegistro);

        listaUsuarios();

        Registrar.setOnClickListener(
                (v)->{
                    Intent i = new Intent(this, Registro.class);
                    startActivity(i);
                }
        );

    }

    public void listaUsuarios(){
        SharedPreferences preferences = getSharedPreferences("encuesta", MODE_PRIVATE);
        String usuarios = preferences.getString("nombre+calificacion", "no hay encuestados");
        Registros.setText(usuarios);
    }

    @Override
    protected void onResume() {
        super.onResume();
        listaUsuarios();
    }
}