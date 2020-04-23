package test_Mutation_Lab_JUnitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import business_logic.ValidZipCode;
import business_logic.InValidZipCode;
import business_logic.DistinguishZipCodeFactory;
import DAO.FileIO;

class Mutations_Lab_JUnitTest {

	@Test
	 void validZipCodeTest1() {
		public Map<Integer, String> ValidZipCodeMap= new HashMap<Integer, String>();
		FileIO f = new File("zipCode_info.xlsx");
		Map<Integer, String> mapListAddress=f.GetPeopleInfo();
		Map<String, String> mapListMatchList=f.GetOfficialZipcodeRangeInfo();
		Set set = mapListAddress.entrySet();
		Iterator itr = set.iterator();
		
		try { 
			while (itr.hasNext()) {
				Map.Entry entry = (Map.Entry) itr.next();
				String[] address = entry.getValue().toString().split(",");
				String zipCode = entry.getValue().toString().split(",")[address.length - 2].trim();
				String stCode = entry.getValue().toString().split(",")[address.length - 3].trim();
				int tempMin=Integer.parseInt(mapListMatchList.get(stCode).toString().split("_")[0]);
				int tempMax=Integer.parseInt(mapListMatchList.get(stCode).toString().split("_")[1]);
				int currentCode=Integer.parseInt(zipCode);

				if(mapListMatchList.get(stCode)!=null) {
					//Changed <= to <
					if(currentCode >= tempMin && currentCode < tempMax) {
						ValidZipCodeMap.put((Integer) entry.getKey(),entry.getValue().toString());
						assertEquals(50, ValidZipCodeMap.size());
					}
				}
			}
		}
		
		catch(Exception e) {
			System.out.println("ERROR INPUT, input file does not match correct form");
		}
	}
	
	@Test
	 void validZipCodeTest2() {
		public Map<Integer, String> ValidZipCodeMap= new HashMap<Integer, String>();
		FileIO f = new File("zipCode_info.xlsx");
		Map<Integer, String> mapListAddress=f.GetPeopleInfo();
		Map<String, String> mapListMatchList=f.GetOfficialZipcodeRangeInfo();
		Set set = mapListAddress.entrySet();
		Iterator itr = set.iterator();
		
		try {
			while (itr.hasNext()) {
				Map.Entry entry = (Map.Entry) itr.next();
				String[] address = entry.getValue().toString().split(",");
				String zipCode = entry.getValue().toString().split(",")[address.length - 2].trim();
				String stCode = entry.getValue().toString().split(",")[address.length - 3].trim();
				int tempMin=Integer.parseInt(mapListMatchList.get(stCode).toString().split("_")[0]);
				int tempMax=Integer.parseInt(mapListMatchList.get(stCode).toString().split("_")[1]);
				int currentCode=Integer.parseInt(zipCode);

				if(mapListMatchList.get(stCode)!=null) {
					//Changed >= to >
					if(currentCode > tempMin && currentCode <= tempMax) {
						ValidZipCodeMap.put((Integer) entry.getKey(),entry.getValue().toString());
						assertEquals(50, ValidZipCodeMap.size());
					}
				}
			}
		}
		
		catch(Exception e) {
			System.out.println("ERROR INPUT, input file does not match correct form");
		}
	}
	
	@Test
	void inValidZipCodeTest1() {
		public Map<Integer, String> InValidZipCodeMap= new HashMap<Integer, String>();
		FileIO f = new File("zipCode_info.xlsx");
		Map<Integer, String> mapListAddress=f.GetPeopleInfo();
		Map<String, String> mapListMatchList=f.GetOfficialZipcodeRangeInfo();
		Set set = mapListAddress.entrySet();// Converting to Set so that we can traverse
		Iterator itr = set.iterator();
		
		try {
			while (itr.hasNext()) {
				Map.Entry entry = (Map.Entry) itr.next();
				String[] address = entry.getValue().toString().split(",");
				String zipCode = entry.getValue().toString().split(",")[address.length - 2].trim();
				String stCode = entry.getValue().toString().split(",")[address.length - 3].trim();
				int tempMin=Integer.parseInt(mapListMatchList.get(stCode).toString().split("_")[0]);
				int tempMax=Integer.parseInt(mapListMatchList.get(stCode).toString().split("_")[1]);
				int currentCode=Integer.parseInt(zipCode);
				if(mapListMatchList.get(stCode)!=null) {
					//Changed <= to <
					if(!(currentCode >= tempMin && currentCode < tempMax)) {
						InValidZipCodeMap.put((Integer) entry.getKey(),entry.getValue().toString());
						assertEquals(50, InValidZipCodeMap.size());
					}
				}
			}
		}
		
		catch(Exception e) {
			System.out.println("ERROR INPUT, input file does not match correct form");
		}
	}
	
	@Test
	void inValidZipCodeTest2() {
		public Map<Integer, String> InValidZipCodeMap= new HashMap<Integer, String>();
		FileIO f = new File("zipCode_info.xlsx");
		Map<Integer, String> mapListAddress=f.GetPeopleInfo();
		Map<String, String> mapListMatchList=f.GetOfficialZipcodeRangeInfo();
		Set set = mapListAddress.entrySet();// Converting to Set so that we can traverse
		Iterator itr = set.iterator();
		
		try {
			while (itr.hasNext()) {
				Map.Entry entry = (Map.Entry) itr.next();
				String[] address = entry.getValue().toString().split(",");
				String zipCode = entry.getValue().toString().split(",")[address.length - 2].trim();
				String stCode = entry.getValue().toString().split(",")[address.length - 3].trim();
				int tempMin=Integer.parseInt(mapListMatchList.get(stCode).toString().split("_")[0]);
				int tempMax=Integer.parseInt(mapListMatchList.get(stCode).toString().split("_")[1]);
				int currentCode=Integer.parseInt(zipCode);
				if(mapListMatchList.get(stCode)!=null) {
					//Changed >= to >
					if(!(currentCode > tempMin && currentCode <= tempMax)) {
						InValidZipCodeMap.put((Integer) entry.getKey(),entry.getValue().toString());
						assertEquals(50, InValidZipCodeMap.size());
					}
				}
			}
		}
		
		catch(Exception e) {
			System.out.println("ERROR INPUT, input file does not match correct form");
		}
	}
	
}