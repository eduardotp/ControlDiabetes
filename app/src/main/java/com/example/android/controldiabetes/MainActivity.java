package com.example.android.controldiabetes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void comidas(View view){
        Intent i = new Intent(this, Comidas.class);
        startActivity(i);
    }

    public void datosper(View view){
        Intent i = new Intent(this, DatosPersonales.class);
        startActivity(i);
    }

    public void ayunas(View view){
        Intent i = new Intent(this, RegistroAyunas.class);
        startActivity(i);
    }

    public void diario(View view){
        Intent i = new Intent(this, RegistroDiario.class);
        startActivity(i);
    }

}
