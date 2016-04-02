package com.example.android.controldiabetes.services;

import com.example.android.controldiabetes.bean.AlimentosObjetos;

import java.io.File;
import java.io.IOException;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelServices {
  
	FoodServices foodServices=new FoodServices();
	FoodHeaderServices foodHeaderServices=new FoodHeaderServices();


	
	public void readExcelSetHeadersListFoodServices( String path){
		
		try {
			
			Workbook workbook = Workbook.getWorkbook(new File(path));
			Sheet sheet = workbook.getSheet(0);

			// 1. obtener toda la data
			// 2. al seleccionar la data del cbo1 actualizar el cb02
	
			Cell b2 ;

			for(int i=0;i<sheet.getColumns();i++){
				b2= sheet.getCell(i,0); 
				String stringb2 = b2.getContents(); 
					if(!stringb2.equals("")){
						//System.out.println( stringb2);
						foodHeaderServices.addFoodItems(new AlimentosObjetos(stringb2, stringb2));
  					}
			}
			workbook.close();

		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
public void readExcelSetListFoodServices(String path){
		
		try {
			
			Workbook workbook = Workbook.getWorkbook(new File(path));
			Sheet sheet = workbook.getSheet(0);

			// 1. obtener toda la data
			// 2. al seleccionar la data del cbo1 actualizar el cb02
		/*	Cell a1 = sheet.getCell(0,0); 
			String stringa1 = a1.getContents(); 

			System.out.println(""+stringa1); */
			Cell b2 ;
			Cell b3 ;

			for(int i=0;i<sheet.getColumns();i++){
				 
				for(int j=0;j<sheet.getRows();j++){
					 
					b2= sheet.getCell(i,j); 
					b3= sheet.getCell(i,0);  
					
					String stringb2 = b2.getContents(); 
					String stringb3 = b3.getContents(); 

						if(!stringb2.equals("")){
							//    System.out.println("id :"+stringb3+"\t"+" valor:"+stringb2);
 							 	foodServices.addFoodItems(new AlimentosObjetos(stringb3,stringb2));
						}
				}	 
			}
			
			workbook.close();

		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	


	
	
}
