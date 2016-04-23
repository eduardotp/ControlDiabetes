package com.example.android.controldiabetes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.android.controldiabetes.adapters.AlimentosMedicacionAdapter;
import com.example.android.controldiabetes.bean.AlimentosObjetos;
import com.example.android.controldiabetes.bean.Medicamentos;
import com.example.android.controldiabetes.services.ExcelServices;
import com.example.android.controldiabetes.services.FileServices;
import com.example.android.controldiabetes.services.FoodHeaderServices;
import com.example.android.controldiabetes.services.FoodServices;

import java.util.ArrayList;


public class RegistroAlimentosYControlActivity extends Activity {

    ExcelServices excelServices = new ExcelServices();
    FoodHeaderServices foodHeaderServices = new FoodHeaderServices();
    FoodServices foodServices = new FoodServices();
    FileServices fileServices = new FileServices();

    ImageButton btn1;
    Spinner sp01, sp02,spnc;

    ListView listView;
    ImageButton btnsend;

    BaseAdapter baseAdapter;

    ArrayList<AlimentosObjetos> alimentosObjetoses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_alimentos_ycontrol);

        sp01 = (Spinner) findViewById(R.id.cbo01);
        sp02 = (Spinner) findViewById(R.id.cbo02);
        spnc = (Spinner) findViewById(R.id.cbonumcomida);
        btn1 = (ImageButton) findViewById(R.id.btnAgregarPimeracomida);

        listView = (ListView) findViewById(R.id.listaalimentos);

        btnsend = (ImageButton) findViewById(R.id.btnRegistrardatos);

        String ambiente = Environment.getExternalStorageDirectory().getAbsolutePath();
        String patron = "AlimentosABC";
        //buscar ruta
        String path = fileServices.searchFile(ambiente, patron);
        // si hay ruta del exel
        if (path != null) {
            // leer exel de alimentos
            excelServices.readExcelSetHeadersListFoodServices(path);
            excelServices.readExcelSetListFoodServices(path);
        } else {
            Toast.makeText(getApplicationContext(), "Parece que no se encontro el archivo de datos de alimentos.", Toast.LENGTH_LONG).show();
        }

        alimentosObjetoses=new ArrayList<AlimentosObjetos>();

        baseAdapter=new AlimentosMedicacionAdapter(getApplicationContext(),alimentosObjetoses);

        listView.setAdapter(baseAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        //settear valores a los combos
        setAlimentosDataintoSpinner(sp01);

        sp01.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String value = sp01.getSelectedItem().toString();

                setAlimentosDataintoSpinnerById(value, sp02);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlimentosObjetos alimentosObjetos=new AlimentosObjetos(String.valueOf(spnc.getSelectedItemPosition()),sp01.getSelectedItem().toString(),sp02.getSelectedItem().toString(),true);

                alimentosObjetoses.add(alimentosObjetos);
                System.err.println(alimentosObjetos.getTipoComida() + " " + alimentosObjetos.getIdentidad());

                 baseAdapter.notifyDataSetChanged();
                // listView.invalidateViews();
                listView.setAdapter(baseAdapter);


            }
        });

        btn1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                btn1.setImageResource(R.drawable.ic_add_circle_white_36dp);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    btn1.setImageResource(R.drawable.ic_add_circle_black_36dp);
                }
                return false;
            }
        });




        ArrayList<AlimentosObjetos> Alimentoslist = new ArrayList<AlimentosObjetos>();

        AlimentosMedicacionAdapter alimentosMedicacionAdapter
                = new AlimentosMedicacionAdapter(getApplicationContext(), Alimentoslist);

        listView.setAdapter(alimentosMedicacionAdapter);

        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //   Intent intent = new Intent(RegistroAlimentosYControlActivity.this, registropac.class);

                //   startActivity(intent);

            }
        });

        btnsend.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    btnsend.setImageResource(R.drawable.ic_save_white_36dp);
                 } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    btnsend.setImageResource(R.drawable.ic_save_black_36dp);
                 }
                return false;
            }
        });



    }


    public void setAlimentosDataintoSpinner(Spinner spinner) {

        ArrayList<AlimentosObjetos> arrayList = (ArrayList) foodHeaderServices.getFoodList();
        ArrayList<String> arrayListas = new ArrayList<String>();

        for (int i = 0; i < arrayList.size(); i++) {
            arrayListas.add(String.valueOf(arrayList.get(i).getIdentidad()));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplication(), R.layout.spinner_font, arrayListas);
        spinner.setAdapter(arrayAdapter);

    }

    public void setAlimentosDataintoSpinnerById(String parentspinner, Spinner childresult) {

        ArrayList<String> arrayListas = new ArrayList<String>();

        ArrayList<AlimentosObjetos> arrayList = (ArrayList) foodServices.getFoodList();

        for (int i = 0; i < arrayList.size(); i++) {

            if (arrayList.get(i).getIdentidad().trim().equals(parentspinner.trim())) {
                arrayListas.add(arrayList.get(i).getAlimentos());
            }
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplication(), R.layout.spinner_font, arrayListas);
        childresult.setAdapter(arrayAdapter);
    }



}
