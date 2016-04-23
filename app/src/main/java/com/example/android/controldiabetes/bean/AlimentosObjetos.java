package com.example.android.controldiabetes.bean;

public class AlimentosObjetos {
	
	private String identidad;
	private String alimentos;

	private boolean selected;
	private String tipoComida;


	public AlimentosObjetos(String identidad, String alimentos) {
 		this.identidad = identidad;
		this.alimentos = alimentos;
	}

	public AlimentosObjetos(String tipoComida, String identidad, String alimentos, boolean selected) {
		this.tipoComida = tipoComida;
		this.identidad = identidad;
		this.alimentos = alimentos;
		this.selected = selected;
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
	public String getTipoComida() {
		return tipoComida;
	}
	public void setTipoComida(String tipoComida) {
		this.tipoComida = tipoComida;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}
