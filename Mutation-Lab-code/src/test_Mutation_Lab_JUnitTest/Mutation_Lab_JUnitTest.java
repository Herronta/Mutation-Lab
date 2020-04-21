package test_Mutation_Lab_JUnitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
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
	//Matt's Code
	void ReadTxtTest1() throws IOException{
		Map<Integer, String> InputPeopleInfo = new HashMap<Integer, String>();
		int PersonUniqueID=0;
		String path= "zipCode_info.xlsx";
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String st;
			List<String> tempList = new ArrayList<String>();
			while ((st = br.readLine()) != null) {
				tempList.add(st.trim().toString());
			}
			for (int i = 0; i < tempList.size(); i++) {
				if (tempList.get(i).toString().contains("name:")) {
					String tempAddress=tempList.get(i).trim()+","+tempList.get(i-1).trim();	//Changing tempList.get(i+1) to tempList.get(i-1)
					assertEquals(tempList.get(i+1).trim(), tempList.get(i-1).trim());
					InputPeopleInfo.put(PersonUniqueID, tempAddress);
					PersonUniqueID++;				
				}
			}
			br.close();
	}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Input file fail or cant read, check FileIO class");
		}
	}
	//End Matt's Code
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
