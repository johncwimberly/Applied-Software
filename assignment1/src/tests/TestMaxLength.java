package tests;

import static org.junit.Assert.*;

import java.io.IOException;

import model.Model;

import org.junit.Test;

public class TestMaxLength {

	@Test(expected = IOException.class)
	public void testPartNumberLength() throws IOException {
		
		Model model = new Model();
		String partNumber = "";
		for(int i = 0; i < 21; i ++){
			partNumber += "a";
		}
		model.addPart(partNumber, "testpart1", "", 1);
	}
	
	@Test(expected = IOException.class)
	public void testPartNameLength() throws IOException {
		
		Model model = new Model();
		String partName = "";
		for(int i = 0; i < 256; i ++){
			partName += "a";
		}
		model.addPart("234", partName, "", 1);
	}

	@Test(expected = IOException.class)
	public void testVendorLength() throws IOException {
		
		Model model = new Model();
		String vendor = "";
		for(int i = 0; i < 256; i ++){
			vendor += "a";
		}
		model.addPart("234", "testpart1", vendor, 1);
	}


}
