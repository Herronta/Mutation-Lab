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
		//check if it can find the correct number of valid zips
		FileIO.ZipCodeInfo_InputPath="zipCode_info.xlsx";
		FileIO.PersonalAddress_InputPath="input_sample3.txt";
		
		DistinguishZipCodeFactory DZ=new DistinguishZipCodeFactory();
		Phaser valid=DZ.GetPhaser("valid");
		assertEquals(valid.GetSize(), 20);
		
	}
	@Test
	void testPhaserInvalid() throws IOException, CloneNotSupportedException {
		//check if it can find the correct number of invalid zips
		FileIO.ZipCodeInfo_InputPath="zipCode_info.xlsx";
		FileIO.PersonalAddress_InputPath="input_sample3.txt";
		DistinguishZipCodeFactory DZ=new DistinguishZipCodeFactory();
		Phaser invalid=DZ.GetPhaser("invalid");	
		assertEquals(invalid.GetSize(), 10);
	}
	@Test
	void testBlueGroup() throws IOException, CloneNotSupportedException {
		//check if it can find the correct number of blue zips and other related items
		FileIO.ZipCodeInfo_InputPath="zipCode_info.xlsx";
		FileIO.PersonalAddress_InputPath="input_sample3.txt";
		Selection selection =new Selection();
		boolean i = false;
		if(selection.GetSelectionBlueGroupSize() == 0) {
			selection.SelectionBluePhaser();
		}
		try {
		selection.InfoPrinter(selection.SelectionBlueStateList);
		i = true;
		}
		catch(Exception e) {
			i = false;
		}
		assertEquals(selection.SelectionBlueGroup.isEmpty(), false);
		assertEquals(selection.GetSelectionBlueGroupSize(), 5);
		assertEquals(i, true);


	}
	@Test
	void testRedGroup() throws IOException, CloneNotSupportedException {
		//check if it can find the correct number of red zips and other related items
		FileIO.ZipCodeInfo_InputPath="zipCode_info.xlsx";
		FileIO.PersonalAddress_InputPath="input_sample3.txt";
		Selection selection =new Selection();
		boolean i = false;
		if(selection.GetSelectionRedGroupSize() == 0) {
			selection.SelectionPhaser("Red");
		}
		try {
		selection.InfoPrinter(selection.SelectionRedStateList);
		i = true;
		}
		catch(Exception e) {
			i = false;
		}
		assertEquals(selection.SelectionRedGroup.isEmpty(), false);
		assertEquals(selection.GetSelectionRedGroupSize(), 15);
		assertEquals(i, true);

		
	}

	@Test
	void testNE() throws IOException, CloneNotSupportedException {
		//check if it can find the correct number of Northeast zips and other related items
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
		//check if it can find the correct number of MidWest zips and other related items
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
		//check if it can find the correct number of South zips and other related items
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
		//check if it can find the correct number of West zips and other related items
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
		//check if ReadIO functions without an error
		//In all honestly, I don't think this tests anything, but in PIT, it increases the Line coverage, which
		//I found to be interesting
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
		//check if ReadIO functions without an error with the map functions. Does also do a test of ReadExcelSheet
		FileIO f = FileIO.getInstance();
		Map<Integer, String> mapListAddress=f.GetPeopleInfo();
		Map<String, String> mapZip=f.GetOfficialZipcodeRangeInfo();
		Set set = mapListAddress.entrySet();
		Set setB = mapZip.entrySet();
		assertEquals(set.size(), 30);
		assertEquals(setB.size(), 51);
	}
	@Test
	void testStateName() throws IOException, CloneNotSupportedException{
		//check if getFullStatename works
		FileIO.ZipCodeInfo_InputPath="zipCode_info.xlsx";
		FileIO.PersonalAddress_InputPath="input_sample3.txt";
		District district=new District();
		assertEquals(district.GetFullStateName("OH"), "Ohio");
	}
	@Test
	void testDistrictPhaser() throws IOException, CloneNotSupportedException{
		//check is District Phaser will return 0 if given the wrong value
		District district=new District();
		district.DistrictPhaser("Red");
		assertEquals(district.GetDistrictGroupSize(), 0);
	}





}
