package com.skillio.dataproviders;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.skillio.utils.ExcelUtil;

public class DataProviders {
/*
	@DataProvider(name = "Data")	
	public Object[][] pinCodeData() {
		Object[][] pincodes = readExcel_4();		
		return pincodes;	
	}

	
	@DataProvider(name = "Data")	// to read whole excel sheet	
	public Object[][] pinCodeData() {
		ExcelUtil excel = new ExcelUtil();
		String baseDir= System.getProperty("user.dir"); //current working directory
		
		Object[][] pincodes = excel.readExcel_4(baseDir + "/src/test/resources/excel_files/Pincode_sheet.xlsx") ;		
		return pincodes;	
	}
*/	
	
	
	@DataProvider(name = "Data")  // to read single column	
	public Object[][] pinCodeDataColumn() {
		ExcelUtil excel = new ExcelUtil();
		String baseDir= System.getProperty("user.dir"); //current working directory
		
		Object[][] pincodes = excel.readExcelColumn(baseDir + "/src/test/resources/excel_files/Pincode_sheet.xlsx",0) ;		
		return pincodes;	
	}
	
	/* -----------TYPE 1 to read data of specific cell -----------*/
	
	public void readExcel_1() {
		try {
			FileInputStream fis = new FileInputStream("F:/Automation framework/Pincode_sheet.xlsx");
			Workbook book = new XSSFWorkbook(fis);
			Sheet sheet = book.getSheet("Pincode_sheet");
			Row row1 = sheet.getRow(2);
			Cell cell1 = row1.getCell(0);
			int pincode1 = (int)cell1.getNumericCellValue();
			System.out.println(pincode1);
			
			Row row2 = sheet.getRow(1);
			Cell cell2 = row2.getCell(0);
			int pincode2 = (int)cell2.getNumericCellValue();
			System.out.println(pincode2);
		}
		catch(FileNotFoundException e ){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/* -----------TYPE 2 To read data of one column----------*/
	
	public void readExcel_2() {
		try {
			FileInputStream fis = new FileInputStream("F:/Automation framework/Pincode_sheet.xlsx");
			Workbook book = new XSSFWorkbook(fis);
			Sheet sheet = book.getSheet("Pincode_sheet");
			
			int lastRow = sheet.getLastRowNum();
			for(int row=1; row<= lastRow;row++) {
				Row row1 = sheet.getRow(row);
				Cell cell1 = row1.getCell(0);
				int pincodes = (int)cell1.getNumericCellValue();
				System.out.println(pincodes);
			}
			
		}
		catch(FileNotFoundException e ){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/* -----------TYPE 3 to read data of whole excel -----------*/
	@Test
	public void readExcel_3() {		
		try {			
			FileInputStream fis = new FileInputStream("F:/Automation framework/Pincode_sheet.xlsx");
			Workbook book = new XSSFWorkbook(fis);
			Sheet sheet = book.getSheet("Pincode_sheet");			
			int lastRow = sheet.getLastRowNum();
			
			for(int r=0; r<= lastRow;r++) {
				Row row = sheet.getRow(r);			
				 
				for(int c=0; c< row.getLastCellNum(); c++) {
					Cell cell = row.getCell(c);
					
					switch(cell.getCellType()) {
					case STRING:
						String value1 = cell.getStringCellValue();
						System.out.print(value1 + "\t");
						break;
						
					case NUMERIC: 
                       int value2 = (int) cell.getNumericCellValue();
                       System.out.print(value2 + "\t");
                        break;           						
					}					
				}
				System.out.println();
			}		
		}
		catch(FileNotFoundException e ){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}	
	
	/* -----------TYPE 4 to read data of whole excel and keep this data in 2d array -----------*/
	
	public Object[][] readExcel_4() {	
		Object[][] data =null;
		Workbook book = null;
		try {			
			FileInputStream fis = new FileInputStream("F:/Automation framework/Pincode_sheet.xlsx");
			 book = new XSSFWorkbook(fis);
			Sheet sheet = book.getSheet("Pincode_sheet");			
			int lastRow = sheet.getLastRowNum();
			data = new Object[lastRow][2]; //object array to keep data			
			for(int r=1; r<= lastRow;r++) {
				Row row = sheet.getRow(r);							 
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
		}
		catch(FileNotFoundException e ){
			e.printStackTrace();
		} catch (IOException e) {
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

	

