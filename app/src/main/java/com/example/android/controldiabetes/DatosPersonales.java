package com.example.android.controldiabetes;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DatosPersonales extends AppCompatActivity {

    private EditText nombre, apellidop, apellidom, celular;
    private Cursor fila;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_personales);

        nombre = (EditText) findViewById(R.id.editText7);
        apellidop = (EditText) findViewById(R.id.editText6);
        apellidom = (EditText) findViewById(R.id.editText5);
        celular = (EditText) findViewById(R.id.editText4);

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this);
        SQLiteDatabase bd = admin.getWritableDatabase(); //Create and/or open a database that will be used for reading and writing.

        Cursor fila = bd.rawQuery("SELECT nombre, apellidop, apellidom, celular FROM person", null);
        //devuelve 0 o 1 fila //es una consulta
        if (fila.moveToFirst()) {  //si ha devuelto 1 fila, vamos al primero (que es el unico)
            nombre.setText(fila.getString(0));
            apellidop.setText(fila.getString(1));
            apellidom.setText(fila.getString(2));
            celular.setText(fila.getString(3));
        } else
        nombre.setText("");
        apellidop.setText("");
        apellidom.setText("");
        celular.setText("");
        bd.close();
    }

    public void atras(View view){
        //Intent i = new Intent(this, MainActivity.class);
        //startActivity(i);
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String n = nombre.getText().toString();

        int cant = bd.delete("person", "nombre='" + n + "'", null); // (votantes es la nombre de la tabla, condición)

        bd.close();
        nombre.setText("");
        apellidop.setText("");
        apellidom.setText("");
        celular.setText("");
        if (cant == 1)
            Toast.makeText(this, "Se borró la persona con dicho documento",
                    Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "No existe una persona con dicho documento",
                    Toast.LENGTH_SHORT).show();
    }

    public void grabar(View view){

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String n = nombre.getText().toString();
        String ap = apellidop.getText().toString();
        String am = apellidom.getText().toString();
        String c = celular.getText().toString();
        ContentValues registro = new ContentValues();  //es una clase para guardar datos
        registro.put("nombre", n);
        registro.put("apellidop", ap);
        registro.put("apellidom", am);
        registro.put("celular", c);
        bd.insert("person", null, registro);
        bd.close();
        nombre.setText("");
        apellidop.setText("");
        apellidom.setText("");
        celular.setText("");
        Toast.makeText(this, "Se cargaron los datos del paciente",
                Toast.LENGTH_SHORT).show();
    }

    public void editar(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String n = nombre.getText().toString();
        String p = apellidop.getText().toString();
        String m = apellidom.getText().toString();
        String c = celular.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("nombre", n);
        registro.put("apellidop", p);
        registro.put("apellidom", m);
        registro.put("celular", c);
        int cant = bd.update("person", registro, "nombre='" + n +"'", null);
        bd.close();
        if (cant == 1)
            Toast.makeText(this, "Se modificaron los datos", Toast.LENGTH_SHORT)
                    .show();
        else
            Toast.makeText(this, "No existe una persona con dicho documento",
                    Toast.LENGTH_SHORT).show();
    }

}
