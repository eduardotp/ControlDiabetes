package com.example.android.controldiabetes.services;

import java.io.File;

/**
 * Created by Luis on 02/04/2016.
 */
public class FileServices {

    public String searchFile(String path,String filename){

        String filepath="there is no file path";

        File file=new File(path);
        File[] listfiles=file.listFiles();
        for(int i=0;i<listfiles.length;i++){
            if(listfiles[i].getName().startsWith(filename)){
                filepath=listfiles[i].getAbsolutePath();
                break;
            }
        }
         return filepath;
    }

}
