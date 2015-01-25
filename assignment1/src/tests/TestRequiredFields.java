package tests;

import static org.junit.Assert.*;

import java.io.IOException;

import model.Model;

import org.junit.Test;

public class TestRequiredFields {
	
	@Test(expected = IOException.class)
	public void testEmptyNumberField() throws IOException {
		Model model = new Model();
		model.addPart("", "testpart1", "", 50);
	}
	
	@Test(expected = IOException.class)
	public void testEmptyNameField() throws IOException {
		Model model = new Model();
		model.addPart("12", "", "", 50);
	}

}
