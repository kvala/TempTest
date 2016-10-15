package unittest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import test.StringHelper;

public class StringHelperTest {

	@Test
	public void GetPermsTest() {
		ArrayList<String> output = StringHelper.GetPerms("abc");
		
		Assert.assertEquals(6, output.size());
		
		Assert.assertTrue(output.contains("acb"));
	
	}

}
