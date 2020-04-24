package test_Mutation_Lab_JUnitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import DAO.FileIO;
import business_logic.DistinguishZipCodeFactory;
import business_logic.District;
import business_logic.Selection;
import business_logic.Phaser;

class Mutation_Lab_JUnitTest {
	
	@Test

	//testing the first few cases
	//There is a check for the size earlier in the code so that it
	void testPhaserValid() throws IOException, CloneNotSupportedException {
		FileIO.ZipCodeInfo_InputPath="zipCode_info.xlsx";
		FileIO.PersonalAddress_InputPath="input_sample3.txt";
		
		DistinguishZipCodeFactory DZ=new DistinguishZipCodeFactory();
		Phaser valid=DZ.GetPhaser("valid");
		assertEquals(valid.GetSize(), 20);
		
	}
	@Test
	void testPhaserInvalid() throws IOException, CloneNotSupportedException {
		FileIO.ZipCodeInfo_InputPath="zipCode_info.xlsx";
		FileIO.PersonalAddress_InputPath="input_sample3.txt";
		DistinguishZipCodeFactory DZ=new DistinguishZipCodeFactory();
		Phaser invalid=DZ.GetPhaser("invalid");	
		assertEquals(invalid.GetSize(), 10);
	}
	@Test
	void testBlueGroup() throws IOException, CloneNotSupportedException {
		FileIO.ZipCodeInfo_InputPath="zipCode_info.xlsx";
		FileIO.PersonalAddress_InputPath="input_sample3.txt";
		Selection selection =new Selection();
		if(selection.GetSelectionBlueGroupSize() == 0) {
			selection.SelectionBluePhaser();
		}
		assertEquals(selection.GetSelectionBlueGroupSize(), 5);
	}
	@Test
	void testRedGroup() throws IOException, CloneNotSupportedException {
		FileIO.ZipCodeInfo_InputPath="zipCode_info.xlsx";
		FileIO.PersonalAddress_InputPath="input_sample3.txt";
		Selection selection =new Selection();
		if(selection.GetSelectionRedGroupSize() == 0) {
			selection.SelectionPhaser("Red");
		}
		assertEquals(selection.GetSelectionRedGroupSize(), 15);
	}
	@Test
	void testNE() throws IOException, CloneNotSupportedException {
		FileIO.ZipCodeInfo_InputPath="zipCode_info.xlsx";
		FileIO.PersonalAddress_InputPath="input_sample3.txt";
		District district=new District();
		if(district.GetNortheastGroupSize() == 0) {
			district.Region_NortheastPhaser();
		}
		assertEquals(district.GetNortheastGroupSize(), 4);	
	}
	@Test
	void testMidW() throws IOException, CloneNotSupportedException {
		FileIO.ZipCodeInfo_InputPath="zipCode_info.xlsx";
		FileIO.PersonalAddress_InputPath="input_sample3.txt";
		District district=new District();
		if(district.GetMidwestGroupSize() == 0) {
			district.Region_MidwestPhaser();
		}
		assertEquals(district.GetMidwestGroupSize(), 5);	
	}
	@Test
	void testS() throws IOException, CloneNotSupportedException {
		FileIO.ZipCodeInfo_InputPath="zipCode_info.xlsx";
		FileIO.PersonalAddress_InputPath="input_sample3.txt";
		District district=new District();
		if(district.GetSouthGroupSize() == 0){
			district.Region_SouthPhaser();
		}
		assertEquals(district.GetSouthGroupSize(), 7);	
	}
	@Test
	void testW() throws IOException, CloneNotSupportedException {
		FileIO.ZipCodeInfo_InputPath="zipCode_info.xlsx";
		FileIO.PersonalAddress_InputPath="input_sample3.txt";
		District district=new District();
		if(district.GetWestGroupSize() == 0) {
			district.Region_WestPhaser();
		}
		assertEquals(district.GetWestGroupSize(), 4);	
	}
	

	@Test
	 void testZReadFileIO() throws IOException, CloneNotSupportedException{
		FileIO f = FileIO.getInstance();
		boolean i = false;
		try {
			f.ReadExcelSheet();
			i = true;
		}
		catch(Exception e) {
			i = false;
			
		}
		assertEquals(i,true);
		
	}
	@Test
	 void testMap() throws IOException, CloneNotSupportedException{
		FileIO f = FileIO.getInstance();
		Map<Integer, String> mapListAddress=f.GetPeopleInfo();
		Set set = mapListAddress.entrySet();
		assertEquals(set.size(), 30);
	}
	@Test
	void testStateName() throws IOException, CloneNotSupportedException{
		FileIO.ZipCodeInfo_InputPath="zipCode_info.xlsx";
		FileIO.PersonalAddress_InputPath="input_sample3.txt";
		District district=new District();
		assertEquals(district.GetFullStateName("OH"), "Ohio");
	}
	@Test
	void testDistrictPhaser() throws IOException, CloneNotSupportedException{

		District district=new District();
		assertEquals(district.GetDistrictGroupSize(), 0);
	}
	@Test
	void testSelection() throws IOException, CloneNotSupportedException{

		District district=new District();
		assertEquals(district.GetDistrictGroupSize(), 0);
	}
	



}
