package com.tmt.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.json.JSONArray;
import org.json.JSONObject;

public class FileListMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		try {
		FileInputStream fis = new FileInputStream("C:/TMT/Config/TMTSFCWeb_Config.properties");
        ResourceBundle config = new PropertyResourceBundle(fis);
		String strPath = config.getString("FilePath");
		JSONArray jArray = new JSONArray();
		JSONObject jObjNew = new JSONObject();
		 File directory = new File(strPath);
	        //get all the files from a directory
	        File[] fList = directory.listFiles();
	        for (File file : fList){
//	            System.out.println(file.getName());
//	            System.out.println(file.getPath());
	            System.out.println("<html><body>");
	        
//				jObjNew.put("filename", file.getName());
//				jObjNew.put("filepath", file.getPath());
//				jArray.put(jObjNew);
	        }
//			 response.setContentType("text/html");
//			JSONObject jObjDevice = new JSONObject();
//			jObjDevice.put("stations", jArray);
//			response.setContentType("application/json");
//			response.getWriter().write(jObjDevice.toString());
	        
	        
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
