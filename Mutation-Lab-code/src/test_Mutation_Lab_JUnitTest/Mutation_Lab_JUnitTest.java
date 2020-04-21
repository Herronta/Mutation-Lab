package test_Mutation_Lab_JUnitTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.junit.jupiter.api.Test;

class Mutation_Lab_JUnitTest {

	//@Test
	//void test() {
	//	fail("Not yet implemented");
	//}
	
	@Test
	 void ReadTxtTest1() {
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
	
	@Test
	void ReadTxtTest2() {
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
			for (int i = 0; i <= tempList.size(); i++) { //Changed (i < tempList.size() to i <= tempList.size())
				assertEquals(tempList.size(), (tempList.size() + 1 )); // The (+ 1) is because it will have one more due to the <= 
				if (tempList.get(i).toString().contains("name:")) {
					String tempAddress=tempList.get(i).trim()+","+tempList.get(i+1).trim();	
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
	


}
