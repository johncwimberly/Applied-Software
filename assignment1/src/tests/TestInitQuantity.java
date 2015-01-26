package tests;

import java.io.IOException;

import model.Model;

import org.junit.Test;

public class TestInitQuantity {

	@Test(expected = IOException.class)
	public void testInitQuantity() throws IOException {
		Model model = new Model();
		model.addPart("7", "testpart1", "", 0);
	}

}
