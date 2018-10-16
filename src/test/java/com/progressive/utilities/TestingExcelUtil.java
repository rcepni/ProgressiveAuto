package com.progressive.utilities;

import java.util.List;
import java.util.Map;

public class TestingExcelUtil {
	public static void main(String[] args) {
		// open the file and create utility object which holds out excel data
		ExcelUtil excelObject = new ExcelUtil("src/test/resources/com/prestashop/test-data/Products.xlsx", "Sheet1");
		
		System.out.println("columns "+excelObject.columnCount());
		System.out.println("row "+excelObject.rowCount());
		// method to get  all column names
		List<String> columnsNames = excelObject.getColumnsNames();
		System.out.println(columnsNames);
		// get all data in nested array
		String[][] dataArray = excelObject.getDataArray();
		
		for (String[] row : dataArray) {
			for (String value : row) {
				System.out.print(value+"\t");
			}
			System.out.println();
		}
		
		List<Map<String,String>> dataList = excelObject.getDataList();
		
		System.out.println(dataList);
		
		for (Map<String, String> row : dataList) {
			System.out.println(row);
		}
		
		// name of the product in the 3rd row
		System.out.println("Name of the PRODUCT in the 3rd row");
		
		System.out.println(dataList.get(3).get("Product"));
		
		// get data by index
		System.out.println(excelObject.getCellData(0, 0));
	}
	
	
	
	
	
	
	
	
	
	
}


















