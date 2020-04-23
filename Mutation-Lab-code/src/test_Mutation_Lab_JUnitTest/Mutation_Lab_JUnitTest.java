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
			selection.SelectionRedPhaser();
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
	
//Mutations? I added 1 to each value since that may be a mutation or a different version of an original test
	@Test
	void testPhaserValidM() throws IOException, CloneNotSupportedException {
		FileIO.ZipCodeInfo_InputPath="zipCode_info.xlsx";
		FileIO.PersonalAddress_InputPath="input_sample3.txt";
		
		DistinguishZipCodeFactory DZ=new DistinguishZipCodeFactory();
		Phaser valid=DZ.GetPhaser("valid");
		assertEquals(valid.GetSize() + 1, 20);
		
	}
	@Test
	void testPhaserInvalidM() throws IOException, CloneNotSupportedException {
		FileIO.ZipCodeInfo_InputPath="zipCode_info.xlsx";
		FileIO.PersonalAddress_InputPath="input_sample3.txt";
		DistinguishZipCodeFactory DZ=new DistinguishZipCodeFactory();
		Phaser invalid=DZ.GetPhaser("invalid");	
		assertEquals(invalid.GetSize() + 1, 10);
	}
	@Test
	void testBlueGroupM() throws IOException, CloneNotSupportedException {
		FileIO.ZipCodeInfo_InputPath="zipCode_info.xlsx";
		FileIO.PersonalAddress_InputPath="input_sample3.txt";
		Selection selection =new Selection();
		if(selection.GetSelectionBlueGroupSize() == 0) {
			selection.SelectionBluePhaser();
		}
		assertEquals(selection.GetSelectionBlueGroupSize() + 1, 5);
	}
	@Test
	void testRedGroupM() throws IOException, CloneNotSupportedException {
		FileIO.ZipCodeInfo_InputPath="zipCode_info.xlsx";
		FileIO.PersonalAddress_InputPath="input_sample3.txt";
		Selection selection =new Selection();
		if(selection.GetSelectionRedGroupSize() == 0) {
			selection.SelectionRedPhaser();
		}
		assertEquals(selection.GetSelectionRedGroupSize() + 1, 15);
	}
	@Test
	void testNEM() throws IOException, CloneNotSupportedException {
		FileIO.ZipCodeInfo_InputPath="zipCode_info.xlsx";
		FileIO.PersonalAddress_InputPath="input_sample3.txt";
		District district=new District();
		if(district.GetNortheastGroupSize() == 0) {
			district.Region_NortheastPhaser();
		}
		assertEquals(district.GetNortheastGroupSize() + 1, 4);	
	}
	@Test
	void testMidWM() throws IOException, CloneNotSupportedException {
		FileIO.ZipCodeInfo_InputPath="zipCode_info.xlsx";
		FileIO.PersonalAddress_InputPath="input_sample3.txt";
		District district=new District();
		if(district.GetMidwestGroupSize() == 0) {
			district.Region_MidwestPhaser();
		}
		assertEquals(district.GetMidwestGroupSize() + 1, 5);	
	}
	@Test
	void testSM() throws IOException, CloneNotSupportedException {
		FileIO.ZipCodeInfo_InputPath="zipCode_info.xlsx";
		FileIO.PersonalAddress_InputPath="input_sample3.txt";
		District district=new District();
		if(district.GetSouthGroupSize() == 0){
			district.Region_SouthPhaser();
		}
		assertEquals(district.GetSouthGroupSize() + 1, 7);	
	}
	@Test
	void testWM() throws IOException, CloneNotSupportedException {
		FileIO.ZipCodeInfo_InputPath="zipCode_info.xlsx";
		FileIO.PersonalAddress_InputPath="input_sample3.txt";
		District district=new District();
		if(district.GetWestGroupSize() == 0) {
			district.Region_WestPhaser();
		}
		assertEquals(district.GetWestGroupSize() + 1, 4);	
	}
}
