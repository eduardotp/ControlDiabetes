package com.example.android.controldiabetes.bean;

/**
 * Created by Luis on 03/04/2016.
 */
public class Medicamentos {

    private String id;
    private String nombre;

    public Medicamentos(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
