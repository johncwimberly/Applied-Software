package tests;

import static org.junit.Assert.*;

import java.io.IOException;

import model.Model;
import model.Part;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestDuplicateName {

	@Test(expected = IOException.class)
	public void testDuplicateName() throws IOException {
		Model model = new Model();
		model.addPart("12", "testpart1", "", 121);
		model.addPart("3", "testpart1", "vendor2", 12);
	}

}
