package tests;

import java.io.IOException;

import model.Model;
import org.junit.Test;

public class TestDuplicateName {

	@Test(expected = IOException.class)
	public void testDuplicateName() throws IOException {
		Model model = new Model();
		model.addPart("12", "testpart1", "", 121);
		model.addPart("3", "testpart1", "vendor2", 12);
	}

}
