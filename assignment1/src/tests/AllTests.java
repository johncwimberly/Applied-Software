package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestDuplicateName.class, TestInitQuantity.class,
		TestMaxLength.class, TestRequiredFields.class })
public class AllTests {

}
