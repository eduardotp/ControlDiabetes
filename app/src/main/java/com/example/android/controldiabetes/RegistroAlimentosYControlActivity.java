package com.example.android.controldiabetes;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import com.example.android.controldiabetes.services.ExcelServices;
import com.example.android.controldiabetes.services.FoodHeaderServices;
import com.example.android.controldiabetes.services.FoodServices;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class RegistroAlimentosYControlActivity extends Activity implements View.OnClickListener{

    ExcelServices excelServices=new ExcelServices();
    FoodHeaderServices foodHeaderServices=new FoodHeaderServices();
    FoodServices foodServices=new FoodServices();

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

        // leer exel de alimentos

        //excelServices.readExcelSetHeadersListFoodServices();

    }

    @Override
    protected void onResume() {
        super.onResume();



    }


    @Override
    public void onClick(View v) {

            int viewID = v.getId();


        switch (viewID){

            //combo enventos
            case R.id.cbo01 :

                break;
            case R.id.cbo02 :

                break;
            case R.id.cbo03 :

                break;
            case R.id.btnAgregarPimeracomida :

                break;
            case R.id.btnAgregarSegundacomida :

                break;
            case R.id.btnAgregarTerceracomida :

                break;
            //combo enventos--
            //boton de grabados eventos
            case R.id.cbo04 :

                break;
            case R.id.cbo05 :

                break;
            case R.id.cbo06 :

                break;
            //boton de grabados eventos --
            //boton de envio de datos
            case R.id.btnRegistrardatos :

                break;
            //boton de envio de datos --
        }

    }
}
