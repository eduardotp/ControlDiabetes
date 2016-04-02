package com.example.android.controldiabetes.services;

import com.example.android.controldiabetes.bean.AlimentosObjetos;

import java.util.ArrayList;
import java.util.List;


public class FoodHeaderServices {

private static List<AlimentosObjetos> FoodHeadersList;
	
	public FoodHeaderServices(){
		if(FoodHeadersList==null){
			FoodHeadersList=new ArrayList<AlimentosObjetos>();
		}
	}
 	
	public List<AlimentosObjetos> getFoodList(){
 		return FoodHeadersList;
 	}
	
	public void addFoodItems(AlimentosObjetos objcts){
		try {
			FoodHeadersList.add(objcts);
		} catch (Exception e) {
			e.printStackTrace();
			}
	}
	public int getFoodLenght(){
 		return FoodHeadersList.size();
 	}
	public AlimentosObjetos getFoodItem(int index){
 		return FoodHeadersList.get(index);
 	}
}
