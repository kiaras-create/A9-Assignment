import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for Binary Search Tree (BST) class.
 *
 * @author YOUR_NAME_HERE
 * @version Fall 2025
 */
public class BSTTests {
    /** Helper method: verifies that a BinaryTree has the expected structure and contents. */
    private static <T> void verifyBT(BinaryTree<? extends T> t, T[][] contents) {
        for (int i = 0; i <= contents.length; i++) {
            int nj = (int) Math.pow(2, i);
            for (int j = 0; j < nj; j++) {
                int h = (int) Math.pow(2, i - 1);
                int k = j;
                BinaryTree<?> node = t;

                while (h > 0 && node != null) {
                    if (k >= h) node = node.getRight();
                    else node = node.getLeft();
                    k = k % h;
                    h /= 2;
                }

                // Compare expected and actual structure
                if ((i == contents.length || contents[i][j] == null) && node != null) {
                    fail("Row " + i + " position " + j +
                         " should be null but found data: " + node.getData());
                } else if (i < contents.length && contents[i][j] != null) {
                    if (node == null) {
                        fail("Row " + i + " position " + j +
                             " should be " + contents[i][j] + " but found null");
                    } else {
                        assertEquals("Row " + i + " position " + j + 
                                     " expected " + contents[i][j] + 
                                     " but got " + node.getData(),
                                     contents[i][j], node.getData());
                    }
                }
            }
        }
    }

    // Sample tests...
    @Test
    public void testBSTInsertions() {
        Integer[][] gt1 = {{5}};
        Integer[][] gt2 = {{5},{null,7}};

        BST<Integer> tree = new BST<>(5);
        verifyBT(tree, gt1);

        tree.insert(7);
        verifyBT(tree, gt2);
    }
   // Delete a leaf using copy left
    @Test
    public void TestBSTDeleteCopyLeft(){
        BST<Integer> tree = new BST<>(5);
        tree.insert(6);
        tree.insert(10);
        tree.insert(4);
        tree = tree.deleteWithCopyLeft(4);
        Integer[][] expected = {
            {5},
            {null, 6},
            {null, null, null,10}
        };
        verifyBT(tree, expected);
    }

    // Delete node with two children
    @Test
        public void TestBSTDeleteCopyLeftTwo(){
        BST<Integer> tree = new BST<>(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(4);
        tree.insert(1);
        tree.insert(17);
        tree.insert(14);
        tree.insert(7);

        tree = tree.deleteWithCopyLeft(5);
        Integer[][] expected = {
            {10},
            {4,15},
            {1,7,14,17},
        };
        verifyBT(tree, expected);
    }
    // Delete node with one child
    @Test
    public void TestBSTDeleteCopyLeftOne(){
        BST<Integer> tree = new BST<>(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(4);
        tree.insert(1);

        tree = tree.deleteWithCopyLeft(4);
        Integer[][] expected = {
            {10},
            {5,15},
            {1, null, null,null}
            
        };
        verifyBT(tree,expected);

    }
    //Test rotate left
    @Test 
    public void TestBSTRotateLeft(){
        BST<Integer> tree = new BST<>(10);
        //tree.insert(5);
        tree.insert(15);

        tree = tree.rotateLeft();
        Integer[][] expected = {
            {15},
            {10, null}
        };
           verifyBT(tree, expected);
        
    }
    //Test rotate right
    @Test
    public void TestBSTRotateRight(){
        BST<Integer> tree = new BST<Integer>(10);
        tree.insert(5);

        tree = tree.rotateRight();
        Integer[][] expected = {
            {5},
            {null, 10}
        };
        verifyBT(tree, expected);
    }
    // Test lookup
    @Test
    public void testLookup(){
        BST<Integer> tree = new BST<Integer>(10);
        tree.insert(5);
        tree.insert(15);

        assertNotNull(tree.lookup(10));
        assertNotNull(tree.lookup(15));
        assertNotNull(tree.lookup(5));

        assertNull(tree.lookup(7));

    }




}