package com.example.android.controldiabetes.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.android.controldiabetes.R;
import com.example.android.controldiabetes.bean.Medicamentos;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Luis on 03/04/2016.
 */
public class AlimentosMedicacionAdapter extends BaseAdapter {

    Context context;
    List<Medicamentos> medicamentos;

    public AlimentosMedicacionAdapter(Context context, List<Medicamentos> medicamentos) {
        this.context = context;
        this.medicamentos = medicamentos;
    }

    @Override
    public int getCount() {
        return medicamentos.size();
    }

    @Override
    public Object getItem(int position) {
        return medicamentos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        HolderListaAlimentos holderListaAlimentos;

        if(convertView==null){

            convertView= LayoutInflater.from(context).inflate(R.layout.lista_custom_alimentos_y_medicacion,null);

            holderListaAlimentos=new HolderListaAlimentos();

            holderListaAlimentos.textView=(TextView) convertView.findViewById(R.id.txtMD01);
            holderListaAlimentos.radioButton=(CheckBox) convertView.findViewById(R.id.rbtMD01);

            convertView.setTag(holderListaAlimentos);

        }
        else{
            holderListaAlimentos=(HolderListaAlimentos)  convertView.getTag();
        }
        if(medicamentos!=null){
            holderListaAlimentos.textView.setText(medicamentos.get(position).getNombre());
       //     holderListaAlimentos.radioButton.setChecked(false);
        }

        return convertView;
    }

    static class HolderListaAlimentos{
         TextView textView;
        CheckBox radioButton;
     }

}
