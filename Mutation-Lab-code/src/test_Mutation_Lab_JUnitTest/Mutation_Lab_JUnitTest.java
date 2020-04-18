package test_Mutation_Lab_JUnitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import DAO.FileIO;
import business_logic.DistinguishZipCodeFactory;
import business_logic.District;
import business_logic.Selection;
import business_logic.Phaser;

class Mutation_Lab_JUnitTest {

	
	@Test
	//testing the first few cases
	void testPhaserValid() throws IOException, CloneNotSupportedException {
		FileIO.ZipCodeInfo_InputPath="zipCode_info.xlsx";
		FileIO.PersonalAddress_InputPath="input_sample3.txt";
		
		DistinguishZipCodeFactory DZ=new DistinguishZipCodeFactory();
		Phaser valid=DZ.GetPhaser("valid");
		assertEquals(valid.GetSize(), 20);
		
	}
	void testPhaserInvalid() throws IOException, CloneNotSupportedException {
		FileIO.ZipCodeInfo_InputPath="zipCode_info.xlsx";
		FileIO.PersonalAddress_InputPath="input_sample3.txt";
		DistinguishZipCodeFactory DZ=new DistinguishZipCodeFactory();
		Phaser invalid=DZ.GetPhaser("invalid");	
		assertEquals(invalid.GetSize(), 10);
	}
	void testBlueGroup() throws IOException, CloneNotSupportedException {
		FileIO.ZipCodeInfo_InputPath="zipCode_info.xlsx";
		FileIO.PersonalAddress_InputPath="input_sample3.txt";
		Selection selection =new Selection();
		selection.SelectionBluePhaser();
		assertEquals(selection.GetSelectionBlueGroupSize(), 5);
	}
	void testRedGroup() throws IOException, CloneNotSupportedException {
		FileIO.ZipCodeInfo_InputPath="zipCode_info.xlsx";
		FileIO.PersonalAddress_InputPath="input_sample3.txt";
		Selection selection =new Selection();
		selection.SelectionRedPhaser();
		assertEquals(selection.GetSelectionRedGroupSize(), 15);
	}
	void testNE() throws IOException, CloneNotSupportedException {
		FileIO.ZipCodeInfo_InputPath="zipCode_info.xlsx";
		FileIO.PersonalAddress_InputPath="input_sample3.txt";
		District district=new District();
		district.Region_NortheastPhaser();
		assertEquals(district.GetNortheastGroupSize(), 4);	
	}
	void testMidW() throws IOException, CloneNotSupportedException {
		FileIO.ZipCodeInfo_InputPath="zipCode_info.xlsx";
		FileIO.PersonalAddress_InputPath="input_sample3.txt";
		District district=new District();
		district.Region_MidwestPhaser();
		assertEquals(district.GetMidwestGroupSize(), 5);	
	}
	void testS() throws IOException, CloneNotSupportedException {
		FileIO.ZipCodeInfo_InputPath="zipCode_info.xlsx";
		FileIO.PersonalAddress_InputPath="input_sample3.txt";
		District district=new District();
		district.Region_SouthPhaser();
		assertEquals(district.GetSouthGroupSize(), 7);	
	}
	void testW() throws IOException, CloneNotSupportedException {
		FileIO.ZipCodeInfo_InputPath="zipCode_info.xlsx";
		FileIO.PersonalAddress_InputPath="input_sample3.txt";
		District district=new District();
		district.Region_WestPhaser();
		assertEquals(district.GetWestGroupSize(), 4);	
	}

}
