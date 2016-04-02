package com.example.android.controldiabetes.bean;

public class AlimentosObjetos {
	
	private String identidad;
	private String alimentos;
	 
	public AlimentosObjetos(String identidad, String alimentos) {
 		this.identidad = identidad;
		this.alimentos = alimentos;
	}
	public String getIdentidad() {
		return identidad;
	}
	public void setIdentidad(String identidad) {
		this.identidad = identidad;
	}
	public String getAlimentos() {
		return alimentos;
	}
	public void setAlimentos(String alimentos) {
		this.alimentos = alimentos;
	}
	
	
	
}
