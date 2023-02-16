package com.wnybusco.depew.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public abstract class Parser {
	
	public static String[][] parse(String name) {
		
		
		String[][] dashCameras = new String[500][5];
		
		int[] columnNumbers = new int[]{1,2,4,7,8};  
		
		int count = 0;
		
		int i = 0;
		
		File file = new File(name);
		
		
		InputStream in = null;
		
		HSSFWorkbook wb = null;
		
		try {
			in = new FileInputStream(file);
			wb = new HSSFWorkbook(in);
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		
        Sheet sheet = wb.getSheetAt(0);
        Iterator<Row> it = sheet.iterator();
        while ((it.hasNext()) &(count<440)) {
        	
          Row row = it.next();
          
          if(count!=0) {
        	
          i=0;
       	  for (int val:columnNumbers) {
       		
        		  if (row.getCell(val)!=null) {
        			  System.out.println("znachenie "+val+" "); 
            		  CellType cellType = row.getCell(val).getCellType();
            		  switch(cellType) {
            		  case STRING:
            			  dashCameras[count][i] = row.getCell(val).getStringCellValue();
            		  case NUMERIC:
            			  dashCameras[count][i] = row.getCell(val).toString();
            		  default:
            		  }
        		  }
        		  i++;
        	  }
          }
          
          
          count++;
          }
          
          /*
          Iterator<Cell> cells = row.iterator();
           while (cells.hasNext()) {
              Cell cell = cells.next();
                CellType cellType = cell.getCellType();
                switch (cellType) {
                    case STRING:
                        result += cell.getStringCellValue() + "=";
                        break;
                    case NUMERIC:
                        result += "[" + cell.getNumericCellValue() + "]";
                        break;

                    case BOOLEAN:
                        result += "[" + cell.getNumericCellValue() + "]";
                        break;
                    default:
                        result += "|";
                        break;
                } 
               // result += cell.getStringCellValue();
                
                System.out.print(result);
                  }
        */
        
		
		
        
        
		return dashCameras;
	}
}
