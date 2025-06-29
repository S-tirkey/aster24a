package com.skillio.utils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	/* --------TYPE 5 To read only one column using excelutil ---*/
	
	public Object[][] readExcelColumn(String filePath, int coulumnNum) {
		Object[][] data =null;
		Workbook book = null;
		
		try {
			FileInputStream fis = new FileInputStream(filePath); //path is parameterized 
			book = new XSSFWorkbook(fis);
			Sheet sheet = book.getSheet("Pincode_sheet");			
			int lastRow = sheet.getLastRowNum();
			Row row = sheet.getRow(0);
			data = new Object[lastRow][1]; //object array to keep data	
			
			for(int r=1; r<= lastRow;r++) {
				 row = sheet.getRow(r);							 
					Cell cell = row.getCell(coulumnNum);
					
					switch(cell.getCellType()) {
					case STRING:
						String value1 = cell.getStringCellValue();
						data[r-1][0] = value1;
						break;
						
					case NUMERIC: 
                       int value2 = (int) cell.getNumericCellValue();
                       data[r-1][0] = value2;
                        break;           						
										
				}
			}		
		}catch(FileNotFoundException e ){
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				book.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		return data;
	}
	
	
	/* -----------TYPE 6 to read data of whole excel using excelutil -----------*/
	
	public Object[][] readExcel_4(String filePath) {	
		Object[][] data =null;
		Workbook book = null;
		//FileInputStream fis = null;
		try {
			FileInputStream fis = new FileInputStream(filePath); //path is parameterized 
			book = new XSSFWorkbook(fis);
			Sheet sheet = book.getSheet("Pincode_sheet");			
			int lastRow = sheet.getLastRowNum();
			Row row = sheet.getRow(0);
			data = new Object[lastRow][row.getLastCellNum()]; //object array to keep data	
			
			for(int r=1; r<= lastRow;r++) {
				 row = sheet.getRow(r);							 
				for(int c=0; c< row.getLastCellNum(); c++) {
					Cell cell = row.getCell(c);
					
					switch(cell.getCellType()) {
					case STRING:
						String value1 = cell.getStringCellValue();
						data[r-1][c] = value1;
						break;
						
					case NUMERIC: 
                       int value2 = (int) cell.getNumericCellValue();
                       data[r-1][c] = value2;
                        break;           						
					}					
				}
			}		
		}catch(FileNotFoundException e ){
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				book.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		return data;
	}	

}
