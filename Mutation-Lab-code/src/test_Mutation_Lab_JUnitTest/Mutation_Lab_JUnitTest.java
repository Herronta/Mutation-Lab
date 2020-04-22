package test_Mutation_Lab_JUnitTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

class Mutation_Lab_JUnitTest {

	@Test
	void testReadExcelSheet1() {
		//Mutation: changed != to ==
		Map<String, String> InputZipCodeRangeInfo = new HashMap<String, String>();
		String ZipCodeInfo_InputPath="zipCode_info.xlsx";
		try  
		{  
			String path2=ZipCodeInfo_InputPath;
			File f1 = new File(path2);   //creating a new file instance  
			FileInputStream fis = new FileInputStream(f1);   //obtaining bytes from the file  
			XSSFWorkbook wb = new XSSFWorkbook(fis);   
			XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object  
			for(int rowIndex=1;rowIndex<= sheet.getLastRowNum();rowIndex++) {
				XSSFRow row =sheet.getRow(rowIndex);
				assertEquals(true,row!=null); //Should always be grabbing a non-null row
				if(row==null) { //Mutation: changed != to ==
					Cell cellStFullName=row.getCell(1);
					Cell cellSt=row.getCell(2);
					Cell cellMin = row.getCell(3);
					Cell cellMax = row.getCell(4);
					String temp=null;		
					try {
						temp=(int)cellMin.getNumericCellValue()+"_"+(int)cellMax.getNumericCellValue()+"_"+cellStFullName.getStringCellValue().toString();
					}catch(Exception e){
						temp=cellMin+"_"+cellMax+"_"+cellStFullName.getStringCellValue().toString();
					}
					InputZipCodeRangeInfo.put(cellSt.toString(),temp);
				}
			}
			wb.close();
			assertEquals(51, InputZipCodeRangeInfo.size()); //Should always be 51 rows in excel sheet
		}  
		catch(Exception e)  
		{  
			e.printStackTrace(); 
			System.out.println("Input file fail or can;t read, check FileIO class");
			fail("Input file fail or can;t read, check FileIO class");
		}
	}
	
	@Test
	void testReadExcelSheet2() {
		//Mutation, changed rowIndex++ to rowIndex--
		Map<String, String> InputZipCodeRangeInfo = new HashMap<String, String>();
		String ZipCodeInfo_InputPath="zipCode_info.xlsx";
		try  
		{  
			String path2=ZipCodeInfo_InputPath;
			File f1 = new File(path2);   //creating a new file instance  
			FileInputStream fis = new FileInputStream(f1);   //obtaining bytes from the file  
			XSSFWorkbook wb = new XSSFWorkbook(fis);   
			XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object  
			for(int rowIndex=1;rowIndex<= sheet.getLastRowNum();rowIndex--) { //Mutation, changed rowIndex++ to rowIndex--
				XSSFRow row =sheet.getRow(rowIndex);
				assertEquals(true,row!=null); //Should always be grabbing a non-null row
				if(row!=null) {
					Cell cellStFullName=row.getCell(1);
					Cell cellSt=row.getCell(2);
					Cell cellMin = row.getCell(3);
					Cell cellMax = row.getCell(4);
					String temp=null;		
					try {
						temp=(int)cellMin.getNumericCellValue()+"_"+(int)cellMax.getNumericCellValue()+"_"+cellStFullName.getStringCellValue().toString();
					}catch(Exception e){
						temp=cellMin+"_"+cellMax+"_"+cellStFullName.getStringCellValue().toString();
					}
					InputZipCodeRangeInfo.put(cellSt.toString(),temp);
				}
			}
			wb.close();
			assertEquals(51, InputZipCodeRangeInfo.size()); //Should always be 51 rows in excel sheet
		}  
		catch(Exception e)  
		{  
			e.printStackTrace(); 
			System.out.println("Input file fail or can;t read, check FileIO class");
			fail("Input file fail or can;t read, check FileIO class");
		}
	}
	
	@Test
	void testReadExcelSheet3() {
		//Mutation, changed <= to ==
		Map<String, String> InputZipCodeRangeInfo = new HashMap<String, String>();
		String ZipCodeInfo_InputPath="zipCode_info.xlsx";
		try  
		{  
			String path2=ZipCodeInfo_InputPath;
			File f1 = new File(path2);   //creating a new file instance  
			FileInputStream fis = new FileInputStream(f1);   //obtaining bytes from the file  
			XSSFWorkbook wb = new XSSFWorkbook(fis);   
			XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object  
			for(int rowIndex=2; rowIndex== sheet.getLastRowNum();rowIndex++) { //Mutation, changed <= to ==
				XSSFRow row =sheet.getRow(rowIndex);
				assertEquals(true,row!=null); //Should always be grabbing a non-null row
				if(row!=null) {
					Cell cellStFullName=row.getCell(1);
					Cell cellSt=row.getCell(2);
					Cell cellMin = row.getCell(3);
					Cell cellMax = row.getCell(4);
					String temp=null;		
					try {
						temp=(int)cellMin.getNumericCellValue()+"_"+(int)cellMax.getNumericCellValue()+"_"+cellStFullName.getStringCellValue().toString();
					}catch(Exception e){
						temp=cellMin+"_"+cellMax+"_"+cellStFullName.getStringCellValue().toString();
					}
					InputZipCodeRangeInfo.put(cellSt.toString(),temp);
				}
			}
			wb.close();
			assertEquals(51, InputZipCodeRangeInfo.size()); //Should always be 51 rows in excel sheet
		}  
		catch(Exception e)  
		{  
			e.printStackTrace(); 
			System.out.println("Input file fail or can;t read, check FileIO class");
			fail("Input file fail or can;t read, check FileIO class");
		}
	}
	
	@Test
	void testReadExcelSheet4() {
		//Mutation, changed <= to >=
		Map<String, String> InputZipCodeRangeInfo = new HashMap<String, String>();
		String ZipCodeInfo_InputPath="zipCode_info.xlsx";
		try  
		{  
			String path2=ZipCodeInfo_InputPath;
			File f1 = new File(path2);   //creating a new file instance  
			FileInputStream fis = new FileInputStream(f1);   //obtaining bytes from the file  
			XSSFWorkbook wb = new XSSFWorkbook(fis);   
			XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object  
			for(int rowIndex=1;rowIndex>= sheet.getLastRowNum();rowIndex++) { //Mutation, changed <= to >=
				XSSFRow row =sheet.getRow(rowIndex);
				assertEquals(true,row!=null); //Should always be grabbing a non-null row
				if(row!=null) {
					Cell cellStFullName=row.getCell(1);
					Cell cellSt=row.getCell(2);
					Cell cellMin = row.getCell(3);
					Cell cellMax = row.getCell(4);
					String temp=null;		
					try {
						temp=(int)cellMin.getNumericCellValue()+"_"+(int)cellMax.getNumericCellValue()+"_"+cellStFullName.getStringCellValue().toString();
					}catch(Exception e){
						temp=cellMin+"_"+cellMax+"_"+cellStFullName.getStringCellValue().toString();
					}
					InputZipCodeRangeInfo.put(cellSt.toString(),temp);
				}
			}
			wb.close();
			assertEquals(51, InputZipCodeRangeInfo.size()); //Should always be 51 rows in excel sheet
		}  
		catch(Exception e)  
		{  
			e.printStackTrace(); 
			System.out.println("Input file fail or can;t read, check FileIO class");
			fail("Input file fail or can;t read, check FileIO class");
		}
	}
	
	@Test
	void testReadExcelSheet5() {
		//Mutation, changed rowIndex=1 to rowIndex=0, sheet.getLastRowNum() to sheet.getLastRowNum()-1, rowIndex to rowIndex+1
		Map<String, String> InputZipCodeRangeInfo = new HashMap<String, String>();
		String ZipCodeInfo_InputPath="zipCode_info.xlsx";
		try  
		{  
			String path2=ZipCodeInfo_InputPath;
			File f1 = new File(path2);   //creating a new file instance  
			FileInputStream fis = new FileInputStream(f1);   //obtaining bytes from the file  
			XSSFWorkbook wb = new XSSFWorkbook(fis);   
			XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object  
			for(int rowIndex=0;rowIndex<= sheet.getLastRowNum()-1;rowIndex++) { //Mutation, changed rowIndex=1 to rowIndex=0, sheet.getLastRowNum() to sheet.getLastRowNum()-1
				XSSFRow row =sheet.getRow(rowIndex+1); // Mutation, changed rowIndex to rowIndex+1
				assertEquals(true,row!=null); //Should always be grabbing a non-null row
				if(row!=null) {
					Cell cellStFullName=row.getCell(1);
					Cell cellSt=row.getCell(2);
					Cell cellMin = row.getCell(3);
					Cell cellMax = row.getCell(4);
					String temp=null;		
					try {
						temp=(int)cellMin.getNumericCellValue()+"_"+(int)cellMax.getNumericCellValue()+"_"+cellStFullName.getStringCellValue().toString();
					}catch(Exception e){
						temp=cellMin+"_"+cellMax+"_"+cellStFullName.getStringCellValue().toString();
					}
					InputZipCodeRangeInfo.put(cellSt.toString(),temp);
				}
			}
			wb.close();
			assertEquals(51, InputZipCodeRangeInfo.size()); //Should always be 51 rows in excel sheet
		}  
		catch(Exception e)  
		{  
			e.printStackTrace(); 
			System.out.println("Input file fail or can;t read, check FileIO class");
			fail("Input file fail or can;t read, check FileIO class");
		}
	}
}
