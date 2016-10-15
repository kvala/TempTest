package unittest;

import org.junit.Assert;
import org.junit.Test;

import test.BinaryTree;
import test.BstHelper;

public class BstHelperTest {

	@Test
	public void bintree2listtest() {

		BinaryTree n10 = new BinaryTree(10);

		BinaryTree n12 = new BinaryTree(12);
		BinaryTree n15 = new BinaryTree(15);
		BinaryTree n25 = new BinaryTree(25);
		BinaryTree n30 = new BinaryTree(30);
		BinaryTree n36 = new BinaryTree(36);

		n10.left = n12;
		n10.right = n15;

		n12.left = n25;
		n12.right = n30;

		n15.left = n36;

		BinaryTree node = BstHelper.bintree2list(n10);

		Assert.assertEquals(25, node.data);

	}

}
