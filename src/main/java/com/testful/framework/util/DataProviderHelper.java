package com.testful.framework.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;

public class DataProviderHelper {

	
	@DataProvider(name = "csvDataProvider")
	public static Object[][] csvProvider()  throws Exception{
			return getStringArrayOfArray("csvTestData.csv");
	}
	
	public static Object[][] getStringArrayOfArray(String filePath) throws Exception{
		boolean local = true;
		String seperator = ",";
		
		//ArrayList<String[]> data = new ArrayList<String[]>();
		String[][] data = null;
		
		//ArrayList<Object> data = new ArrayList();
		try {
			List<String> lines = getRawLinesFromFile(filePath, local);
			System.out.println("row is: " + lines.get(0));
			//int iColumns = lines.get(0).split(",").length;
			int iColumns = lines.get(0).split(seperator).length;
			System.out.println("number of rows: " + lines.size());
			System.out.println("number of columns: " + iColumns);
			data = new String[lines.size()][iColumns];
				
			for (int i = 0; i < lines.size(); i++) {
					//String[] lineElements = lines.get(i).split(",");
					String[] lineElements = lines.get(i).split(seperator);
					for (int j=0; j<iColumns; j++) {
						data[i][j]=lineElements[j];
						System.out.print("data: " + data[i][j]);
					}
					System.out.println();
			}
		} catch (FileNotFoundException e) {
				System.out.println("fild not found!");
				e.printStackTrace();
		} catch (IOException e) {
				System.out.println("io exception!");
				e.printStackTrace();
		}

		System.out.println("Successfully read data file");
		return data;
	}
	
	public static List<String> getRawLinesFromFile(String filePath, boolean local) throws Exception     
	{     
		 String path = ""; 
		System.out.println("filePath = " + filePath);
		 if (!local){
			 URL url = DataProviderHelper.class.getClassLoader().getResource(filePath);
			 System.out.println("url = " + url);

			
			 // path = URLDecoder.decode (path, "utf-8");
			 try {
				 path = new File(url.toURI()).getAbsolutePath();
				 System.out.println("Resource path = " + path);
			 } catch (Exception error) {
				 throw error;
			 }
		 }else{
			 path = filePath;
			 System.out.println("Resource path = " + path);
		 }
	          
	        
		InputStream is = new FileInputStream(new File(path));  
        BufferedReader bReader = new BufferedReader(new InputStreamReader(is));
//        StringBuffer sbfFileContents = new StringBuffer();
        String line = null;
        List<String> lines = new ArrayList<String>();
        
        //read file line by line
        while( (line = bReader.readLine()) != null){
//                sbfFileContents.append(line);
                lines.add(line);
        }
       
        //finally convert StringBuffer object to String!
//        strContent = sbfFileContents.toString();
		
//		List<String> lines = IOUtils.readLines(is, "UTF-8");         
		is.close();         
		return lines;     
	}
	
	public String[][] getMapOfJson(String file){
		String[][] data = null;
		return data;
	}
	
}
