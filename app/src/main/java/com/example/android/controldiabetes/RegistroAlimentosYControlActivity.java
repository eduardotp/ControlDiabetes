package com.example.android.controldiabetes;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.android.controldiabetes.bean.AlimentosObjetos;
import com.example.android.controldiabetes.services.ExcelServices;
import com.example.android.controldiabetes.services.FileServices;
import com.example.android.controldiabetes.services.FoodHeaderServices;
import com.example.android.controldiabetes.services.FoodServices;

import java.util.ArrayList;


public class RegistroAlimentosYControlActivity extends Activity  {

    ExcelServices excelServices=new ExcelServices();
    FoodHeaderServices foodHeaderServices=new FoodHeaderServices();
    FoodServices foodServices=new FoodServices();
    FileServices fileServices=new FileServices();
    Button btn1,btn2,btn3;

    Spinner sp01,sp02;
    Spinner sp03,sp04;
    Spinner sp05,sp06;

    Button btnsend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_alimentos_ycontrol);

        sp01=(Spinner) findViewById(R.id.cbo01);
        sp02=(Spinner) findViewById(R.id.cbo02);

        sp03=(Spinner) findViewById(R.id.cbo03);
        sp04=(Spinner) findViewById(R.id.cbo04);

        sp05=(Spinner) findViewById(R.id.cbo05);
        sp06=(Spinner) findViewById(R.id.cbo06);

        btn1=(Button) findViewById(R.id.btnAgregarPimeracomida);
        btn2=(Button) findViewById(R.id.btnAgregarSegundacomida);
        btn3=(Button) findViewById(R.id.btnAgregarTerceracomida);

        btnsend=(Button) findViewById(R.id.btnRegistrardatos);

        String ambiente= Environment.getExternalStorageDirectory().getAbsolutePath();
        String patron="AlimentosABC";
        //buscar ruta
        String path=fileServices.searchFile(ambiente,patron);
        // si hay ruta del exel
       if(path!=null){
            // leer exel de alimentos
            excelServices.readExcelSetHeadersListFoodServices(path);
            excelServices.readExcelSetListFoodServices(path);
        }
        else{
            Toast.makeText(getApplicationContext(),"Parece que no se encontro el archivo de datos de alimentos.",Toast.LENGTH_LONG).show();
       }
     }

    @Override
    protected void onResume() {
        super.onResume();

        //settear valores a los combos
        setAlimentosDataintoSpinner(sp01);
        setAlimentosDataintoSpinner(sp03);
        setAlimentosDataintoSpinner(sp05);

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
        sp03.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value = sp03.getSelectedItem().toString();

                setAlimentosDataintoSpinnerById(value, sp04);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sp05.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value = sp05.getSelectedItem().toString();

                setAlimentosDataintoSpinnerById(value, sp06);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
     }


    public void setAlimentosDataintoSpinner(Spinner spinner){

        ArrayList<AlimentosObjetos> arrayList= (ArrayList) foodHeaderServices.getFoodList();
        ArrayList<String> arrayListas=new ArrayList<String>();

        for(int  i=0;i<arrayList.size();i++){
            arrayListas.add(String.valueOf(arrayList.get(i).getIdentidad()));
        }

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getApplication(),R.layout.spinner_font,arrayListas);
        spinner.setAdapter(arrayAdapter);

    }

    public void setAlimentosDataintoSpinnerById(String parentspinner,Spinner childresult){

        ArrayList<String> arrayListas=new ArrayList<String>();

        ArrayList<AlimentosObjetos> arrayList=(ArrayList) foodServices.getFoodList();

        for(int  i=0;i<arrayList.size();i++){

             if(arrayList.get(i).getIdentidad().trim().equals(parentspinner.trim()) ){
                arrayListas.add(arrayList.get(i).getAlimentos());
              }
        }
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getApplication(),R.layout.spinner_font,arrayListas);
        childresult.setAdapter(arrayAdapter);
    }



}
