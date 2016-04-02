package com.example.android.controldiabetes.services;

import com.example.android.controldiabetes.bean.AlimentosObjetos;

import java.util.ArrayList;
import java.util.List;


public class FoodServices {

private static List<AlimentosObjetos> FoodList;
	
	public FoodServices(){
		if(FoodList==null){
			FoodList=new ArrayList<AlimentosObjetos>();
		}
	}
 	
	public List<AlimentosObjetos> getFoodList(){
 		return FoodList;
 	}
	
	public void addFoodItems(AlimentosObjetos objcts){
		try {
			FoodList.add(objcts);
		} catch (Exception e) {
			e.printStackTrace();
			}
	}
	public int getFoodLenght(){
 		return FoodList.size();
 	}
	public AlimentosObjetos getFoodItem(int index){
 		return FoodList.get(index);
 	}
}
