package com.qa.api.gorest.Util;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ExcelUtil {
	
	
		public static Workbook book;
		public static Sheet sheet;

		public static String TestData_Sheet_Path=("userdata.xlsx");
		/**
		 * 
		 * @param sheetName
		 * @return
		 */

		public static Object[][] getTestData(String sheetName)
		{
		try{
		 // InputStream ip = ExcelUtil.class.getResourceAsStream("/userdata.xlsx");
		  //System.out.println("adadsadadadaadasdadaf:"+ ip);
		  //FileInputStream ip = new FileInputStream("/userdata.xlsx"); 
		  //System.out.println("sdsadadad:"+ ip);
			
			  FileInputStream ip = new FileInputStream("userdata.xlsx"); 
		  System.out.println("sdsadadadxcvxcvvdgfd:"+ ip);
		                              //FileInputstream is used to create a connection with any file. 
		                              //if file got deleted, file path is wrong. 
		  book =  WorkbookFactory.create(ip);  //once the connection is established with excel xlsx file , 
		                                      //and workbookFactory.create method will craete a  local copy of excel sheet inside the  java library. 
		                                      //so that we can read it properly
                                              //make the connection, load locally inside the memoery(create inside local copy in the memory) and read the data
		  sheet = book.getSheet(sheetName); //we are passing shhetname

		 }
		  catch(FileNotFoundException e){
		      e.printStackTrace();
		   }
		catch(InvalidFormatException e){
		e.printStackTrace();
		}
		catch(IOException e){
		e.printStackTrace();
		}

		Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		 for(int i=0; i<sheet.getLastRowNum();i++) {
		    for(int k=0;k<sheet.getRow(0).getLastCellNum();k++){
		       data[i][k]= sheet.getRow(i+1).getCell(k).toString();
		       }
		   }
		return data;
		}


}
